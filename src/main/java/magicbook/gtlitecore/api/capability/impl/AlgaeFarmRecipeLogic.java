package magicbook.gtlitecore.api.capability.impl;

import gregtech.api.capability.GregtechDataCodes;
import gregtech.api.capability.IMultipleTankHandler;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.common.blocks.BlockMachineCasing;
import gregtech.common.blocks.MetaBlocks;
import magicbook.gtlitecore.common.items.GTLiteMetaItems;
import magicbook.gtlitecore.common.metatileentities.multi.electric.MetaTileEntityAlgaeFarm;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nonnull;
import java.util.Random;

import static gregtech.api.GTValues.*;
import static magicbook.gtlitecore.api.utils.GTLiteUtils.getFluidById;
import static magicbook.gtlitecore.api.utils.GTLiteUtils.isNotStaticWater;

public class AlgaeFarmRecipeLogic {

    public static final int MAX_PROGRESS = 189000;

    private int progressTime = 0;
    private int maxProgress = 0;

    private int casingTier = 1;

    private final MetaTileEntityAlgaeFarm tileEntity;

    private boolean isActive;
    private boolean isWorkingEnabled = true;
    private boolean wasActiveAndNeedsUpdate;
    private boolean isDone = false;
    protected boolean isInventoryFull = false;
    private boolean isEnergyNotEnough;

    public AlgaeFarmRecipeLogic(MetaTileEntityAlgaeFarm tileEntity,
                                int minEnergyTier) {
        this.tileEntity = tileEntity;
        this.casingTier = minEnergyTier;
    }

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
                        if (this.tileEntity.getImportFluid() != null) {
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
        boolean isValidWater = amount >= 49;
        //if (isValidWater) {
        //    GTLiteLog.logger.info("Filled structure.");
        //} else {
        //    GTLiteLog.logger.info("Did not fill structure.");
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
        IMultipleTankHandler inputTank = tileEntity.getImportFluid();
        if (fluid.isFluidStackIdentical(inputTank.drain(fluid, false))) {
            inputTank.drain(fluid, true);
            return true;
        }
        return false;
    }

    private void outputsAmountMultiplier() {
        EnumFacing facing = this.tileEntity.getFrontFacing();
        switch (facing.getIndex()) {
            case 2 -> {
                BlockPos pos = this.tileEntity.getPos().add(0, 0, 1);
                this.getCasingTier(pos);
            }
            case 3 -> {
                BlockPos pos = this.tileEntity.getPos().add(0, 0, -1);
                this.getCasingTier(pos);
            }
            case 4 -> {
                BlockPos pos = this.tileEntity.getPos().add(1, 0, 0);
                this.getCasingTier(pos);
            }
            case 5 -> {
                BlockPos pos = this.tileEntity.getPos().add(-1, 0, 0);
                this.getCasingTier(pos);
            }
            default -> {
                this.casingTier = 0;
            }
        }
    }

    private void getCasingTier(BlockPos pos) {
        IBlockState blockState = this.tileEntity.getWorld().getBlockState(pos);
        if (this.getMachineCasingByTier(ULV).equals(blockState))
            this.casingTier = 1;
        else if (this.getMachineCasingByTier(LV).equals(blockState))
            this.casingTier = 2;
        else if (this.getMachineCasingByTier(MV).equals(blockState))
            this.casingTier = 3;
        else if (this.getMachineCasingByTier(HV).equals(blockState))
            this.casingTier = 4;
        else if (this.getMachineCasingByTier(EV).equals(blockState))
            this.casingTier = 5;
        else if (this.getMachineCasingByTier(IV).equals(blockState))
            this.casingTier = 6;
        else if (this.getMachineCasingByTier(LuV).equals(blockState))
            this.casingTier = 7;
        else if (this.getMachineCasingByTier(ZPM).equals(blockState))
            this.casingTier = 8;
        else if (this.getMachineCasingByTier(UV).equals(blockState))
            this.casingTier = 9;
        else if (this.getMachineCasingByTier(UHV).equals(blockState))
            this.casingTier = 10;
        else if (this.getMachineCasingByTier(UEV).equals(blockState))
            this.casingTier = 11;
        else if (this.getMachineCasingByTier(UIV).equals(blockState))
            this.casingTier = 12;
        else if (this.getMachineCasingByTier(UXV).equals(blockState))
            this.casingTier = 13;
        else if (this.getMachineCasingByTier(OpV).equals(blockState))
            this.casingTier = 14;
        else if (this.getMachineCasingByTier(MAX).equals(blockState))
            this.casingTier = 15;
    }

    private IBlockState getMachineCasingByTier(int voltage) {
        return MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.valueOf(VN[voltage]));
    }

    public void update() {
        if (this.tileEntity.getWorld().isRemote)
            return;
        if (!this.checkWater())
            return;
        if (!this.isWorkingEnabled)
            return;

        //  if inventory is not full, drain energy etc. from it
        if (!isInventoryFull) {
            //  it is now active
            if (!this.isActive)
                this.setActive(true);
        } else {
            //  it cannot drain, therefore it is inactive
            if (this.isActive)
                this.setActive(false);
            return;
        }

        //  multiplier of output amount.
        this.outputsAmountMultiplier();

        //  increase progress
        progressTime++;
        if (progressTime % (int) (MAX_PROGRESS / Math.pow(2, (double) this.casingTier - 1)) != 0)
            return;
        progressTime = 0;

        int rnd = new Random().nextInt(5);

        //  Common Algae
        if (this.tileEntity.fillItemInventory(GTLiteMetaItems.ORDINARY_ALGAE.getStackForm(rnd * this.casingTier), true)) {
            this.tileEntity.fillItemInventory(GTLiteMetaItems.ORDINARY_ALGAE.getStackForm(rnd * this.casingTier), false);
        } else {
            this.isInventoryFull = true;
            this.setActive(false);
            this.setWasActiveAndNeedsUpdate(true);
        }

        //  Red Algae
        if (this.tileEntity.fillItemInventory(GTLiteMetaItems.RED_ALGAE.getStackForm(rnd * Math.max(0, (this.casingTier - 5)) / 2), true)) {
            this.tileEntity.fillItemInventory(GTLiteMetaItems.RED_ALGAE.getStackForm(rnd * Math.max(0, (this.casingTier - 5)) / 2), false);
        } else {
            this.isInventoryFull = true;
            this.setActive(false);
            this.setWasActiveAndNeedsUpdate(true);
        }

        //  Green Algae
        if (this.tileEntity.fillItemInventory(GTLiteMetaItems.GREEN_ALGAE.getStackForm(rnd * this.casingTier), true)) {
            this.tileEntity.fillItemInventory(GTLiteMetaItems.GREEN_ALGAE.getStackForm(rnd * this.casingTier), false);
        } else {
            this.isInventoryFull = true;
            this.setActive(false);
            this.setWasActiveAndNeedsUpdate(true);
        }

        //  Gold Algae
        if (this.tileEntity.fillItemInventory(GTLiteMetaItems.GOLD_ALGAE.getStackForm(rnd * Math.max(0, (this.casingTier - 4))), true)) {
            this.tileEntity.fillItemInventory(GTLiteMetaItems.GOLD_ALGAE.getStackForm(rnd * Math.max(0, (this.casingTier - 4))), false);
        } else {
            this.isInventoryFull = true;
            this.setActive(false);
            this.setWasActiveAndNeedsUpdate(true);
        }

        //  Brown Algae
        if (this.tileEntity.fillItemInventory(GTLiteMetaItems.BROWN_ALGAE.getStackForm(rnd * Math.max(0, this.casingTier - 2)), true)) {
            this.tileEntity.fillItemInventory(GTLiteMetaItems.BROWN_ALGAE.getStackForm(rnd * Math.max(0, this.casingTier - 2)), false);
        } else {
            this.isInventoryFull = true;
            this.setActive(false);
            this.setWasActiveAndNeedsUpdate(true);
        }

        //  Blue Algae
        if (this.tileEntity.fillItemInventory(GTLiteMetaItems.BLUE_ALGAE.getStackForm(rnd * Math.max(0, this.casingTier - 3)), true)) {
            this.tileEntity.fillItemInventory(GTLiteMetaItems.BLUE_ALGAE.getStackForm(rnd * Math.max(0, this.casingTier - 3)), false);
        } else {
            this.isInventoryFull = true;
            this.setActive(false);
            this.setWasActiveAndNeedsUpdate(true);
        }

    }

    /**
     * Getter of {@link #maxProgress}.
     *
     * @return  Max Progress.
     */
    public int getMaxProgress() {
        return this.maxProgress;
    }

    /**
     * Setter of {@link #maxProgress}.
     *
     * @param maxProgress  Max Progress.
     */
    public void setMaxProgress(int maxProgress) {
        this.maxProgress = maxProgress;
    }

    public void invalidate() {
        this.progressTime = 0;
        this.maxProgress = 0;
        this.setActive(false);
    }

    public boolean isActive() {
        return this.isActive;
    }

    /**
     * Active Setter.
     * Common method in {@link MultiblockRecipeLogic}.
     */
    public void setActive(boolean active) {
        if (this.isActive != active) {
            this.isActive = active;
            this.tileEntity.markDirty();
            if (this.tileEntity.getWorld() != null && !this.tileEntity.getWorld().isRemote) {
                this.tileEntity.writeCustomData(GregtechDataCodes.WORKABLE_ACTIVE, buf -> buf.writeBoolean(active));
            }
        }
    }

    /**
     * Working Enabled Setter.
     * Common method in {@link MultiblockRecipeLogic}.
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
     * Working Enable Checker.
     *
     * @return  Whether working is enabled for the logic
     */
    public boolean isWorkingEnabled() {
        return this.isWorkingEnabled;
    }

    /**
     * @return  Whether it is currently working
     */
    public boolean isWorking() {
        return this.isActive && !this.isEnergyNotEnough && this.isWorkingEnabled;
    }

    /**
     *
     * @return the current progress towards producing algae of Algae Farm.
     */
    public int getProgressTime() {
        return this.progressTime;
    }

    public double getProgressPercent() {
        return getProgressTime() * 1.0 / (int) (MAX_PROGRESS / Math.pow(2, (double) this.casingTier -1));
    }


    /**
     *
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
    public NBTTagCompound writeToNBT(@Nonnull NBTTagCompound data) {
        data.setBoolean("isActive", this.isActive);
        data.setBoolean("isWorkingEnabled", this.isWorkingEnabled);
        data.setBoolean("wasActiveAndNeedsUpdate", this.wasActiveAndNeedsUpdate);
        data.setBoolean("isDone", isDone);
        data.setInteger("progressTime", progressTime);
        data.setInteger("maxProgress", maxProgress);
        data.setBoolean("isInventoryFull", isInventoryFull);
        return data;
    }

    /**
     * reads all needed values from NBT
     * This MUST be called and returned in the MetaTileEntity's
     * {@link MetaTileEntity#readFromNBT(NBTTagCompound)} method
     */
    public void readFromNBT(@Nonnull NBTTagCompound data) {
        this.isActive = data.getBoolean("isActive");
        this.isWorkingEnabled = data.getBoolean("isWorkingEnabled");
        this.wasActiveAndNeedsUpdate = data.getBoolean("wasActiveAndNeedsUpdate");
        this.isDone = data.getBoolean("isDone");
        this.progressTime = data.getInteger("progressTime");
        this.maxProgress =  data.getInteger("maxProgress");
        this.isInventoryFull = data.getBoolean("isInventoryFull");
    }

    /**
     * writes all needed values to InitialSyncData
     * This MUST be called and returned in the MetaTileEntity's
     * {@link MetaTileEntity#writeInitialSyncData(PacketBuffer)} )} method
     */
    public void writeInitialSyncData(@Nonnull PacketBuffer buf) {
        buf.writeBoolean(this.isActive);
        buf.writeBoolean(this.isWorkingEnabled);
        buf.writeBoolean(this.wasActiveAndNeedsUpdate);
        buf.writeInt(this.progressTime);
        buf.writeInt(this.maxProgress);
        buf.writeBoolean(this.isInventoryFull);
    }

    /**
     * reads all needed values from InitialSyncData
     * This MUST be called and returned in the MetaTileEntity's
     * {@link MetaTileEntity#receiveInitialSyncData(PacketBuffer)} method
     */
    public void receiveInitialSyncData(@Nonnull PacketBuffer buf) {
        this.setActive(buf.readBoolean());
        this.setWorkingEnabled(buf.readBoolean());
        this.setWasActiveAndNeedsUpdate(buf.readBoolean());
        this.progressTime = buf.readInt();
        this.maxProgress = buf.readInt();
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
            this.tileEntity.scheduleRenderUpdate();
        } else if (dataId == GregtechDataCodes.WORKING_ENABLED) {
            this.isWorkingEnabled = buf.readBoolean();
            this.tileEntity.scheduleRenderUpdate();
        }
    }

    /**
     * @return  whether Algae Farm was active and needs an update
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