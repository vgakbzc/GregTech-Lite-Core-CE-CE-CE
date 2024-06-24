package magicbook.gtlitecore.api.capability.impl;

import gregtech.api.GTValues;
import gregtech.api.capability.GregtechDataCodes;
import gregtech.api.capability.IMultipleTankHandler;
import gregtech.api.capability.IWorkable;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.multiblock.IMaintenance;
import gregtech.common.ConfigHolder;
import magicbook.gtlitecore.common.metatileentities.multi.electric.MetaTileEntityZhuHaiFishingPond;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraftforge.fluids.FluidStack;

import org.jetbrains.annotations.NotNull;
import java.util.List;

import static magicbook.gtlitecore.api.utils.GTLiteUtils.getFluidById;
import static magicbook.gtlitecore.api.utils.GTLiteUtils.isNotStaticWater;

/**
 * Fishing Pond Recipe Logic.
 *
 * @author Gate Guardian
 *
 * <p>
 *     This class is basic logic for ZhuHai Fishing Pond.
 *     Thanks for my friend Gate Guardian create it, I just redo something.
 * </p>
 */
public class FishingPondRecipeLogic implements IWorkable {

    public static final int maxProgress = 20;
    private int progressTime = 0;
    private int MaxProgress = 0;
    private final int minEnergyTier;
    private final MetaTileEntityZhuHaiFishingPond tileEntity;
    private int output;
    private String loots = "";
    private int mode = 0;
    private boolean isActive;
    private boolean isWorkingEnabled = true;
    private boolean wasActiveAndNeedsUpdate;
    private boolean isDone = false;
    protected boolean isInventoryFull;
    private boolean isEnergyNotEnough;
    private final boolean hasMaintenance;

    public FishingPondRecipeLogic(MetaTileEntityZhuHaiFishingPond tileEntity,
                                  int minEnergyTier) {
        this.tileEntity = tileEntity;
        this.minEnergyTier = minEnergyTier;
        this.hasMaintenance = ConfigHolder.machines.enableMaintenance && ((IMaintenance) tileEntity).hasMaintenanceMechanics();
    }

    /**
     * Getter of Machine mode.
     *
     * @return  Machine Mode.
     */
    public int getMode() {
        return this.mode;
    }

    /**
     * Setter of Machine mode.
     *
     * @param mode  Machine Mode.
     */
    public void setMode(int mode) {
        this.mode = mode;
    }

    /**
     * Check if required water in machine structure.
     *
     * @return  If structure has required water, then return true.
     */
    public Boolean checkWater() {
        int currentDirectionX;
        int currentDirectionZ;
        int offsetLowerX;
        int offsetUpperX;
        int offsetLowerZ;
        int offsetUpperZ;

        currentDirectionX = 4;
        currentDirectionZ = 4;
        offsetLowerX = -4;
        offsetUpperX = 4;
        offsetLowerZ = -4;
        offsetUpperZ = 4;

        final int directionX = this.tileEntity.getFrontFacing().getOpposite().getXOffset() * currentDirectionX;
        final int directionZ = this.tileEntity.getFrontFacing().getOpposite().getZOffset() * currentDirectionZ;

        int amount = 0;

        for (int i = offsetLowerX + 1; i <= offsetUpperX - 1; ++i) {
            for (int j = offsetLowerZ + 1; j <= offsetUpperZ - 1; ++j) {
                for (int k = 0; k < 2; k++) {
                    BlockPos waterCheckPos = this.tileEntity.getPos().add(directionX + i, k, directionZ + j);
                    Block block = this.tileEntity.getWorld().getBlockState(waterCheckPos).getBlock();
                    if (isNotStaticWater(block)) {
                        if (this.tileEntity.getImportFluids() != null) {
                            if (depleteInput(getFluidById("water", 1000)))
                                this.tileEntity.getWorld().setBlockState(waterCheckPos, Blocks.WATER.getDefaultState());
                        }
                    }
                    block = this.tileEntity.getWorld().getBlockState(this.tileEntity.getPos().add(directionX + i, k, directionZ + j)).getBlock();
                    if (block == Blocks.WATER || block == Blocks.FLOWING_WATER) {
                        ++ amount;
                        //GTLiteLog.logger.info("Found Water!");
                    }
                }
            }
        }
        boolean isValidWater = amount >= 60;
        //if (isValidWater) {
        //  GTLiteLog.logger.info("Filled structure.");
        //} else {
        //  GTLiteLog.logger.info("Did not fill structure.");
        //}
        return isValidWater;
    }

    /**
     * Used to check consume liquid to fill structure water requied.
     *
     * @param fluid  Fluid Stack.
     * @return       Check input fluid inventory, if inventory has water,
     *               then drain it, and return true.
     */
    private boolean depleteInput(FluidStack fluid) {
        if (fluid == null)
            return false;
        IMultipleTankHandler inputTank = tileEntity.getImportFluids();
        if (fluid.isFluidStackIdentical(inputTank.drain(fluid, false))) {
            inputTank.drain(fluid, true);
            return true;
        }
        return false;
    }

    /**
     * Update processing for machine.
     *
     * <p>
     *     Except for common situation for {@link MultiblockRecipeLogic},
     *     this machine should check extended structure support by {@link #checkWater()},
     *     and {@link #checkCanFishing()}, these two properties constraint machine working.
     *     If structure does not have enough water, then machine cannot working;
     *     and energy consumed/inventory full checks add for {@link #checkCanFishing()}.
     * </p>
     */
    public void update() {
        if (this.tileEntity.getWorld().isRemote)
            return;
        if (!this.checkWater())
            return;
        if (this.hasMaintenance && ((IMaintenance) this.tileEntity).getNumMaintenanceProblems() > 5)
            return;
        if (!this.isWorkingEnabled)
            return;
        if (!checkCanFishing())
            return;

        //  if inventory is not full, drain energy etc. from it
        if (!isInventoryFull) {
            //  actually drain the energy
            consumeEnergy(false);
            //  since energy is being consumed, it is now active
            if (!this.isActive)
                setActive(true);
        } else {
            //  it cannot drain, therefore it is inactive
            if (this.isActive)
                setActive(false);
            return;
        }

        //  increase progress
        progressTime++;
        if (progressTime % maxProgress != 0) return;
        progressTime = 0;

        World world = this.tileEntity.getWorld();
        int l = world.rand.nextInt(output);
        while (l < output) {
            LootTable loots = world.getLootTableManager().getLootTableFromLocation(new ResourceLocation(getLootTable()));
            LootContext ctxs = new LootContext.Builder((WorldServer) world).build();
            List<ItemStack> stacks = loots.generateLootForPools(world.rand, ctxs);
            for (ItemStack stack: stacks) {
                if (tileEntity.fillTanks(stack, true)) {
                    tileEntity.fillTanks(stack, false);
                } else {
                    isInventoryFull = true;
                    setActive(false);
                    setWasActiveAndNeedsUpdate(true);
                }
                l++;
            }
        }
    }

    /**
     * Getter of Loot Table (used for machine products).
     *
     * <p>
     *     For this recipe logic, the parameter {@link #mode} obtains loots.
     *     Used for product adder in {@link #update()}.
     * </p>
     *
     * @return  Get Loot Table by {@link #mode}.
     */
    public String getLootTable() {
        if (this.mode == 0) { //  Fish
            output = 8 + (tileEntity.getMaxParallelRecipes() - 2);
            this.loots = "gameplay/fishing/fish";
        } else if (this.mode == 1) { //  Junk
            output = 4;
            this.loots = "gameplay/fishing/junk";
        } else if (this.mode == 2) { // Treasure
            output = 4;
            this.loots = "gameplay/fishing/treasure";
        } else {
            this.mode = 0;
        }

        return loots;
    }

    /**
     * Extended check of machine.
     *
     * <p>
     *     This extended check is used for {@link #update()},
     *     used to check energy consumed requirement and inventory full problem.
     * </p>
     *
     * @return  Check if machine can work.
     */
    protected boolean checkCanFishing() {
        if (!consumeEnergy(true)) {
            if (progressTime >= 2) {
                if (ConfigHolder.machines.recipeProgressLowEnergy)
                    this.progressTime = 1;
                else
                    this.progressTime = Math.max(1, progressTime - 2);

                isEnergyNotEnough = true;
            }
            return false;
        }

        if (this.isEnergyNotEnough && tileEntity.getEnergyInputPerSecond() > 19L * GTValues.VA[tileEntity.getEnergyTier()]) {
            this.isEnergyNotEnough = false;
        }

        World world = this.tileEntity.getWorld();
        LootTable loots = world.getLootTableManager().getLootTableFromLocation(new ResourceLocation(getLootTable()));
        LootContext ctxs = new LootContext.Builder((WorldServer) world).build();
        List<ItemStack> stacks = loots.generateLootForPools(world.rand, ctxs);

        for (ItemStack stack : stacks)
            if (tileEntity.fillChest(stack, true)) {
                this.isInventoryFull = false;
                return true;
            }
        this.isInventoryFull = true;

        if (isActive()) {
            setActive(false);
            setWasActiveAndNeedsUpdate(true);
        }
        return false;
    }

    protected boolean consumeEnergy(boolean energy) {
        return tileEntity.drainEnergy(energy);
    }

    @Override
    public int getProgress() {
        return this.progressTime;
    }

    /**
     * Getter of {@link #MaxProgress}.
     *
     * @return  Max Progress.
     */
    @Override
    public int getMaxProgress() {
        return this.MaxProgress;
    }

    /**
     * Setter of {@link #MaxProgress}.
     *
     * @param maxProgress  Max Progress.
     */
    public void setMaxProgress(int maxProgress) {
        this.MaxProgress = maxProgress;
    }

    public void invalidate() {
        this.progressTime = 0;
        this.MaxProgress = 0;
        setActive(false);
    }

    @Override
    public boolean isActive() {
        return this.isActive;
    }

    /**
     * Active Setter.
     *
     * <p>
     *     This method is functionally useful for extended check trigger ({@link #checkCanFishing()}),
     *     and also a common method in {@link MultiblockRecipeLogic}.
     * </p>
     *
     */
    public void setActive(boolean active) {
        if (this.isActive != active) {
            this.isActive = active;
            this.tileEntity.markDirty();
            if (tileEntity.getWorld() != null && !tileEntity.getWorld().isRemote) {
                this.tileEntity.writeCustomData(GregtechDataCodes.WORKABLE_ACTIVE, buf -> buf.writeBoolean(active));
            }
        }
    }

    /**
     * Working Enabled Setter.
     *
     * <p>
     *     Common method in {@link MultiblockRecipeLogic}.
     * </p>
     */
    public void setWorkingEnabled(boolean isWorkingEnabled) {
        if (this.isWorkingEnabled != isWorkingEnabled) {
            this.isWorkingEnabled = isWorkingEnabled;
            this.tileEntity.markDirty();
            if (this.tileEntity.getWorld() != null && !this.tileEntity.getWorld().isRemote) {
                this.tileEntity.writeCustomData(GregtechDataCodes.WORKING_ENABLED, buf -> buf.writeBoolean(isWorkingEnabled));
            }
        }
    }

    /**
     * Working Enabled Checker.
     *
     * <p>
     *     Common method in {@link MultiblockRecipeLogic}.
     * </p>
     *
     * @return  Whether working is enabled for the logic
     */
    @Override
    public boolean isWorkingEnabled() {
        return this.isWorkingEnabled;
    }

    /**
     * @return  Whether it is currently working
     */
    public boolean isWorking() {
        return isActive && !isEnergyNotEnough && isWorkingEnabled;
    }

    public double getProgressPercent() {
        return getProgress() * 1.0 / maxProgress;
    }

    protected boolean isOverclocked() {
        return tileEntity.getEnergyTier() > minEnergyTier;
    }

    /**
     * @return whether the inventory is full
     */
    public boolean isInventoryFull() {
        return this.isInventoryFull;
    }

    /**
     * writes all needed values to NBT
     * This MUST be called and returned in the MetaTileEntity's
     * {@link MetaTileEntity#writeToNBT(NBTTagCompound)} method
     */
    public NBTTagCompound writeToNBT(@NotNull NBTTagCompound data) {
        data.setBoolean("isActive", this.isActive);
        data.setBoolean("isWorkingEnabled", this.isWorkingEnabled);
        data.setBoolean("wasActiveAndNeedsUpdate", this.wasActiveAndNeedsUpdate);
        data.setBoolean("isDone", isDone);
        data.setInteger("progressTime", progressTime);
        data.setInteger("MaxProgress", MaxProgress);
        data.setBoolean("isInventoryFull", isInventoryFull);
        data.setInteger("mode", mode);
        return data;
    }

    /**
     * reads all needed values from NBT
     * This MUST be called and returned in the MetaTileEntity's
     * {@link MetaTileEntity#readFromNBT(NBTTagCompound)} method
     */
    public void readFromNBT(@NotNull NBTTagCompound data) {
        this.isActive = data.getBoolean("isActive");
        this.isWorkingEnabled = data.getBoolean("isWorkingEnabled");
        this.wasActiveAndNeedsUpdate = data.getBoolean("wasActiveAndNeedsUpdate");
        this.isDone = data.getBoolean("isDone");
        this.progressTime = data.getInteger("progressTime");
        this.MaxProgress = data.getInteger("MaxProgress");
        this.isInventoryFull = data.getBoolean("isInventoryFull");
        this.mode = data.getInteger("mode");
    }

    /**
     * writes all needed values to InitialSyncData
     * This MUST be called and returned in the MetaTileEntity's
     * {@link MetaTileEntity#writeInitialSyncData(PacketBuffer)} method
     */
    public void writeInitialSyncData(@NotNull PacketBuffer buf) {
        buf.writeBoolean(this.isActive);
        buf.writeBoolean(this.isWorkingEnabled);
        buf.writeBoolean(this.wasActiveAndNeedsUpdate);
        buf.writeInt(this.progressTime);
        buf.writeInt(this.MaxProgress);
        buf.writeBoolean(this.isInventoryFull);
    }

    /**
     * reads all needed values from InitialSyncData
     * This MUST be called and returned in the MetaTileEntity's
     * {@link MetaTileEntity#receiveInitialSyncData(PacketBuffer)} method
     */
    public void receiveInitialSyncData(@NotNull PacketBuffer buf) {
        setActive(buf.readBoolean());
        setWorkingEnabled(buf.readBoolean());
        setWasActiveAndNeedsUpdate(buf.readBoolean());
        this.progressTime = buf.readInt();
        this.MaxProgress = buf.readInt();
        this.isInventoryFull = buf.readBoolean();
    }

    /**
     * reads all needed values from CustomData
     * This MUST be called and returned in the MetaTileEntity's
     * {@link MetaTileEntity#receiveCustomData(int, PacketBuffer)} method
     */
    public void receiveCustomData(int dataId, PacketBuffer buf) {
        if (dataId == GregtechDataCodes.WORKABLE_ACTIVE) {
            this.isActive = buf.readBoolean();
            tileEntity.scheduleRenderUpdate();
        } else if (dataId == GregtechDataCodes.WORKING_ENABLED) {
            this.isWorkingEnabled = buf.readBoolean();
            tileEntity.scheduleRenderUpdate();
        }
    }

    /**
     * @return  whether Fishing Pond was active and needs an update
     */
    public boolean wasActiveAndNeedsUpdate() {
        return this.wasActiveAndNeedsUpdate;
    }

    /**
     * @param wasActiveAndNeedsUpdate  the state to set
     */
    public void setWasActiveAndNeedsUpdate(boolean wasActiveAndNeedsUpdate) {
        this.wasActiveAndNeedsUpdate = wasActiveAndNeedsUpdate;
    }
}
