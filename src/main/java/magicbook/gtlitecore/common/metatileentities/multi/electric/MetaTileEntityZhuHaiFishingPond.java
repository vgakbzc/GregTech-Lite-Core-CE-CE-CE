package magicbook.gtlitecore.common.metatileentities.multi.electric;

import codechicken.lib.raytracer.CuboidRayTraceResult;
import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import com.google.common.collect.Lists;
import gregtech.api.GTValues;
import gregtech.api.capability.GregtechTileCapabilities;
import gregtech.api.capability.IEnergyContainer;
import gregtech.api.capability.IMultipleTankHandler;
import gregtech.api.capability.impl.EnergyContainerList;
import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.capability.impl.ItemHandlerList;
import gregtech.api.metatileentity.IDataInfoProvider;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.MultiblockWithDisplayBase;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.MultiblockShapeInfo;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.util.GTTransferUtils;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.metatileentities.MetaTileEntities;
import magicbook.gtlitecore.api.capability.impl.FishingPondRecipeLogic;
import magicbook.gtlitecore.client.renderer.texture.GTLiteTextures;
import magicbook.gtlitecore.common.blocks.BlockMetalCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.IItemHandler;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static gregtech.api.GTValues.EV;

/**
 * ZhuHai Fishing Pond for GregTech CEu
 *
 * @author Gate Guardian
 *
 * <p>
 *     Based on my friend Gate Guardian's work about this machine.
 * </p>
 *
 * @since 2.7.4-beta
 */
public class MetaTileEntityZhuHaiFishingPond extends MultiblockWithDisplayBase implements IDataInfoProvider {

    private final FishingPondRecipeLogic logic;
    private IEnergyContainer container;
    protected IMultipleTankHandler inputFluidInventory;
    protected IItemHandler outputItemInventory;

    public MetaTileEntityZhuHaiFishingPond(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId);
        this.logic = new FishingPondRecipeLogic(this, EV);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityZhuHaiFishingPond(metaTileEntityId);
    }

    @Override
    protected void updateFormedValid() {
        this.logic.update();
        if (!getWorld().isRemote && this.logic.wasActiveAndNeedsUpdate()) {
            this.logic.setWasActiveAndNeedsUpdate(false);
            this.logic.setActive(false);
        }
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        initializeAbilities();
    }

    @Override
    public void invalidateStructure() {
        super.invalidateStructure();
        resetTileAbilities();
        this.logic.invalidate();
    }

    protected void initializeAbilities() {
        this.inputFluidInventory = new FluidTankList(true, getAbilities(MultiblockAbility.IMPORT_FLUIDS));
        this.outputItemInventory = new ItemHandlerList(getAbilities(MultiblockAbility.EXPORT_ITEMS));
        this.container = new EnergyContainerList(getAbilities(MultiblockAbility.INPUT_ENERGY));
    }

    private void resetTileAbilities() {
        this.inputFluidInventory = new FluidTankList(true);
        this.outputItemInventory = new ItemHandlerList(Collections.emptyList());
        this.container = new EnergyContainerList(Lists.newArrayList());
    }

    @NotNull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("EEEEEEEEE", "XXXXXXXXX", "XXXXXXXXX")
                .aisle("EXXXXXXXE", "X#######X", "X#######X")
                .aisle("EXXXXXXXE", "X#######X", "X#######X")
                .aisle("EXXXXXXXE", "X#######X", "X#######X")
                .aisle("EXXXXXXXE", "X#######X", "X#######X")
                .aisle("EXXXXXXXE", "X#######X", "X#######X")
                .aisle("EXXXXXXXE", "X#######X", "X#######X")
                .aisle("EXXXXXXXE", "X#######X", "X#######X")
                .aisle("EEEEEEEEE", "XXXXSXXXX", "XXXXXXXXX")
                .where('S', selfPredicate())
                .where('X', states(getCasingState())
                        .setMinGlobalLimited(106)
                        .or(abilities(MultiblockAbility.EXPORT_ITEMS)
                                .setExactLimit(1))
                        .or(abilities(MultiblockAbility.IMPORT_FLUIDS)
                                .setMaxGlobalLimited(1))
                        .or(abilities(MultiblockAbility.MUFFLER_HATCH)
                                .setExactLimit(1))
                        .or(abilities(MultiblockAbility.MAINTENANCE_HATCH)
                                .setExactLimit(1)))
                .where('E', states(getCasingState())
                        .or(abilities(MultiblockAbility.INPUT_ENERGY)
                                .setMinGlobalLimited(1)
                                .setMaxGlobalLimited(3)))
                .where('#', any())
                .build();
    }

    private static IBlockState getCasingState() {
        return GTLiteMetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.INCONEL_792_CASING);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GTLiteTextures.INCONEL_792_CASING;
    }

    @SideOnly(Side.CLIENT)
    @NotNull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.VACUUM_FREEZER_OVERLAY;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void renderMetaTileEntity(CCRenderState renderState,
                                     Matrix4 translation,
                                     IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        this.getFrontOverlay().renderOrientedState(renderState, translation, pipeline, getFrontFacing(), this.logic.isActive(), this.logic.isWorkingEnabled());
    }

    @Override
    public boolean onScrewdriverClick(EntityPlayer playerIn,
                                      EnumHand hand,
                                      EnumFacing facing,
                                      CuboidRayTraceResult hitResult) {
        if (logic.getMode() < 2)
            this.logic.setMode(logic.getMode() + 1);
        else
            this.logic.setMode(0);
        return true;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addToolUsages(ItemStack stack,
                              @Nullable World world,
                              @NotNull List<String> tooltip,
                              boolean advanced) {
        tooltip.add(I18n.format("gregtech.tool_action.screwdriver.toggle_mode_covers"));
        tooltip.add(I18n.format("gregtech.tool_action.wrench.set_facing"));
        tooltip.add(I18n.format("gregtech.tool_action.crowbar"));
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
        MultiblockShapeInfo.Builder builder = MultiblockShapeInfo.builder()
                .aisle("EEEEeEEEE", "XXXXXXXXX", "XXXXXXXXX")
                .aisle("EXXXXXXXE", "X#######X", "X#######X")
                .aisle("EXXXXXXXE", "X#######X", "X#######X")
                .aisle("EXXXXXXXE", "X#######X", "X#######X")
                .aisle("EXXXXXXXE", "X#######X", "X#######X")
                .aisle("EXXXXXXXE", "X#######X", "X#######X")
                .aisle("EXXXXXXXE", "X#######X", "X#######X")
                .aisle("EXXXXXXXE", "X#######X", "X#######X")
                .aisle("EEEEEEEEE", "XXIJSKLXX", "XXXXXXXXX")
                .where('S', GTLiteMetaTileEntities.ZHUHAI_FISHING_POND, EnumFacing.SOUTH)
                .where('X', getCasingState())
                .where('I', MetaTileEntities.FLUID_IMPORT_HATCH[EV], EnumFacing.SOUTH)
                .where('J', MetaTileEntities.ITEM_EXPORT_BUS[EV], EnumFacing.SOUTH)
                .where('K', MetaTileEntities.MAINTENANCE_HATCH, EnumFacing.SOUTH)
                .where('L', MetaTileEntities.MUFFLER_HATCH[EV], EnumFacing.SOUTH)
                .where('E', getCasingState())
                .where('e', MetaTileEntities.ENERGY_INPUT_HATCH[EV], EnumFacing.NORTH)
                .where('#', Blocks.WATER.getDefaultState());
        shapeInfo.add(builder.build());
        return shapeInfo;
    }

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        super.addDisplayText(textList);

        if (!isStructureFormed()) return;

        //  energies
        if (container != null && container.getEnergyCapacity() > 0) {
            int energyContainer = getEnergyTier();
            long maxVoltage = GTValues.V[energyContainer];
            String voltageName = GTValues.VNF[energyContainer];
            textList.add(new TextComponentTranslation("gregtech.multiblock.max_energy_per_tick", maxVoltage, voltageName));
        }

        //  works
        if (!logic.isWorkingEnabled()) {
            textList.add(new TextComponentTranslation("gregtech.multiblock.work_paused"));
        } else if (logic.isActive()) {
            textList.add(new TextComponentTranslation("gregtech.multiblock.running"));
            int currentProgress = (int) (logic.getProgressPercent() * 100);
            textList.add(new TextComponentTranslation("gregtech.multiblock.progress", currentProgress));
        } else {
            textList.add(new TextComponentTranslation("gregtech.multiblock.idling"));
        }

        //  modes
        if (logic.getMode() == 1)
            textList.add(new TextComponentTranslation("gtlitecore.machine.zhuhai_fishing_pond.mode.1"));
        else if (logic.getMode() == 2)
            textList.add(new TextComponentTranslation("gtlitecore.machine.zhuhai_fishing_pond.mode.2"));
        else
            textList.add(new TextComponentTranslation("gtlitecore.machine.zhuhai_fishing_pond.mode.0"));

        //  not enough energy
        if (!drainEnergy(true)) {
            textList.add(new TextComponentTranslation("gregtech.multiblock.not_enough_energy").setStyle(new Style().setColor(TextFormatting.RED)));
        }

        //  inventory full
        if (logic.isInventoryFull())
            textList.add(new TextComponentTranslation("gtlitecore.machine.zhuhai_fishing_pond.error").setStyle(new Style().setColor(TextFormatting.RED)));
    }

    public boolean fillChest(ItemStack stack, boolean simulate) {
        return GTTransferUtils.addItemsToItemHandler(outputItemInventory, simulate, Collections.singletonList(stack));
    }

    public boolean fillTanks(ItemStack stack, boolean simulate) {
        return GTTransferUtils.addItemsToItemHandler(outputItemInventory, simulate, Collections.singletonList(stack));
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing side) {
        if (capability == GregtechTileCapabilities.CAPABILITY_WORKABLE)
            return GregtechTileCapabilities.CAPABILITY_WORKABLE.cast(this.logic);
        if (capability == GregtechTileCapabilities.CAPABILITY_CONTROLLABLE)
            return GregtechTileCapabilities.CAPABILITY_CONTROLLABLE.cast(this.logic);
        return super.getCapability(capability, side);
    }

    public boolean isActive() {
        return (isStructureFormed() && this.logic.isActive() && this.logic.isWorkingEnabled());
    }

    @Override
    public boolean getIsWeatherOrTerrainResistant(){
        return true;
    }

    public IMultipleTankHandler getImportFluid() {
        return this.inputFluidInventory;
    }

    @NotNull
    @Override
    public List<ITextComponent> getDataInfo() {
        List<ITextComponent> list = new ArrayList<>();
        list.add(new TextComponentTranslation("gtlitecore.machine.zhuhai_fishing_pond.mode", logic.getMode()));
        return list;
    }

    public int getEnergyTier() {
        if (container == null) return EV;
        return Math.max(GTValues.IV, GTUtility.getFloorTierByVoltage(container.getInputVoltage()));
    }

    public long getEnergyInputPerSecond() {
        return container.getInputPerSec();
    }

    public int getMaxParallelRecipes() {
        return (2 * (this.getEnergyTier() + 1));
    }

    public boolean drainEnergy(boolean energy) {
        long energyToDrain = GTValues.VA[getEnergyTier()];
        long resultEnergy = container.getEnergyStored() - energyToDrain;
        if (resultEnergy >= 0L && resultEnergy <= container.getEnergyCapacity()) {
            if (!energy)
                container.changeEnergy(-energyToDrain);
            return true;
        }
        return false;
    }

    @Override
    public NBTTagCompound writeToNBT(@NotNull NBTTagCompound data) {
        super.writeToNBT(data);
        return this.logic.writeToNBT(data);
    }

    @Override
    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        this.logic.readFromNBT(data);
    }

    @Override
    public void writeInitialSyncData(PacketBuffer buf) {
        super.writeInitialSyncData(buf);
        this.logic.writeInitialSyncData(buf);
    }

    @Override
    public void receiveInitialSyncData(PacketBuffer buf) {
        super.receiveInitialSyncData(buf);
        this.logic.receiveInitialSyncData(buf);
    }

    @Override
    public void receiveCustomData(int dataId, PacketBuffer buf) {
        super.receiveCustomData(dataId, buf);
        this.logic.receiveCustomData(dataId, buf);
    }

    @Override
    protected boolean shouldShowVoidingModeButton() {
        return false;
    }
}