package magicbook.gtlitecore.common.metatileentities.multi.electric;

import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregtech.api.capability.GregtechTileCapabilities;
import gregtech.api.capability.IMultipleTankHandler;
import gregtech.api.capability.IWorkable;
import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.capability.impl.ItemHandlerList;
import gregtech.api.metatileentity.IDataInfoProvider;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.MultiblockDisplayText;
import gregtech.api.metatileentity.multiblock.MultiblockWithDisplayBase;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.MultiblockShapeInfo;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.util.GTTransferUtils;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.common.metatileentities.MetaTileEntities;
import magicbook.gtlitecore.api.GTLiteAPI;
import magicbook.gtlitecore.api.block.impl.WrappedIntTier;
import magicbook.gtlitecore.api.capability.impl.AlgaeFarmRecipeLogic;
import magicbook.gtlitecore.api.pattern.GTLiteTraceabilityPredicate;
import magicbook.gtlitecore.client.renderer.texture.GTLiteTextures;
import magicbook.gtlitecore.common.blocks.BlockMultiblockCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;

import javax.annotation.Nonnull;
import java.util.*;

import static gregtech.api.GTValues.MV;

/**
 * @since 2.8.8-beta
 */
public class MetaTileEntityAlgaeFarm extends MultiblockWithDisplayBase implements IDataInfoProvider, IWorkable {

    private final AlgaeFarmRecipeLogic logic;
    protected IMultipleTankHandler inputFluidInventory;
    protected ItemHandlerList itemImportInventory;
    protected IItemHandler outputItemInventory;

    public MetaTileEntityAlgaeFarm(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId);
        this.logic = new AlgaeFarmRecipeLogic(this, MV);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityAlgaeFarm(metaTileEntityId);
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
        this.itemImportInventory = new ItemHandlerList(getAbilities(MultiblockAbility.IMPORT_ITEMS));
    }

    private void resetTileAbilities() {
        this.inputFluidInventory = new FluidTankList(true);
        this.outputItemInventory = new ItemHandlerList(Collections.emptyList());
        this.itemImportInventory = new ItemHandlerList(Collections.emptyList());
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("CCCCCCCCC", "CCCCCCCCC", "CCCCCCCCC")
                .aisle("CXXXXXXXC", "C       C", "C       C")
                .aisle("CXXXXXXXC", "C       C", "C       C")
                .aisle("CXXXXXXXC", "C       C", "C       C")
                .aisle("CXXXXXXXC", "C       C", "C       C")
                .aisle("CXXXXXXXC", "C       C", "C       C")
                .aisle("CXXXXXXXC", "C       C", "C       C")
                .aisle("CXXXXXXXC", "C       C", "C       C")
                .aisle("CCCCSCCCC", "CCCCCCCCC", "CCCCCCCCC")
                .where('S', this.selfPredicate())
                .where('C', states(getCasingState())
                        .setMinGlobalLimited(70)
                        .or(abilities(MultiblockAbility.IMPORT_ITEMS)
                                .setPreviewCount(1))
                        .or(abilities(MultiblockAbility.EXPORT_ITEMS)
                                .setPreviewCount(1))
                        .or(abilities(MultiblockAbility.IMPORT_FLUIDS)
                                .setPreviewCount(1)))
                .where('X', GTLiteTraceabilityPredicate.MACHINE_CASING.get())
                .where(' ', any())
                .build();
    }

    private static IBlockState getCasingState() {
        return GTLiteMetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.ASEPTIC_FARM_CASING);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GTLiteTextures.FARM_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return GTLiteTextures.ALGAE_FARM_OVERLAY;
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
        MultiblockShapeInfo.Builder builder = MultiblockShapeInfo.builder()
                .aisle("CCCCCCCCC", "CCCCCCCCC", "CCCCCCCCC")
                .aisle("CXXXXXXXC", "C       C", "C       C")
                .aisle("CXXXXXXXC", "C       C", "C       C")
                .aisle("CXXXXXXXC", "C       C", "C       C")
                .aisle("CXXXXXXXC", "C       C", "C       C")
                .aisle("CXXXXXXXC", "C       C", "C       C")
                .aisle("CXXXXXXXC", "C       C", "C       C")
                .aisle("CXXXXXXXC", "C       C", "C       C")
                .aisle("CCIISJKCC", "CCCCCCCCC", "CCCCCCCCC")
                .where('S', GTLiteMetaTileEntities.ALGAE_FARM, EnumFacing.SOUTH)
                .where('C', getCasingState())
                .where('I', MetaTileEntities.ITEM_IMPORT_BUS[MV], EnumFacing.SOUTH)
                .where('J', MetaTileEntities.ITEM_EXPORT_BUS[MV], EnumFacing.SOUTH)
                .where('K', MetaTileEntities.FLUID_IMPORT_HATCH[MV], EnumFacing.SOUTH)
                .where(' ', Blocks.WATER.getDefaultState());
        GTLiteAPI.MAP_MACHINE_CASING.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> ((WrappedIntTier) entry.getValue()).getIntTier()))
                .forEach(entry -> shapeInfo.add(builder.where('X', entry.getKey()).build()));
        return shapeInfo;
    }

    @Override
    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        this.getFrontOverlay().renderOrientedState(renderState, translation, pipeline, getFrontFacing(), this.logic.isActive(), this.logic.isWorkingEnabled());
    }

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        AlgaeFarmRecipeLogic recipeLogic = this.logic;
        MultiblockDisplayText.builder(textList, this.isStructureFormed())
                .setWorkingStatus(recipeLogic.isWorkingEnabled(), recipeLogic.isActive())
                .setWorkingStatusKeys(
                        "gregtech.multiblock.idling",
                        "gregtech.multiblock.work_paused",
                        "gtlitecore.machine.algae_farm.running")
                .addWorkingStatusLine();
    }

    @Override
    public boolean hasMaintenanceMechanics() {
        return false;
    }

    public IMultipleTankHandler getImportFluid() {
        return this.inputFluidInventory;
    }

    public IItemHandlerModifiable getImportItem() {
        return this.itemImportInventory;
    }

    @Override
    public int getProgress() {
        return logic.getProgressTime();
    }

    @Override
    public int getMaxProgress() {
        return logic.getMaxProgress();
    }

    @Override
    public boolean isWorkingEnabled() {
        return logic.isWorkingEnabled();
    }

    @Override
    public void setWorkingEnabled(boolean b) {
        logic.setWorkingEnabled(b);
    }

    @Nonnull
    @Override
    public List<ITextComponent> getDataInfo() {
        return new LinkedList<>();
    }

    public boolean fillItemInventory(ItemStack stack, boolean simulate) {
        return GTTransferUtils.addItemsToItemHandler(outputItemInventory, simulate, Collections.singletonList(stack));
    }

    @Override
    public NBTTagCompound writeToNBT(@Nonnull NBTTagCompound data) {
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

    public boolean isActive() {
        return (this.isStructureFormed() && this.logic.isActive() && this.logic.isWorkingEnabled());
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing side) {
        if (capability == GregtechTileCapabilities.CAPABILITY_WORKABLE)
            return GregtechTileCapabilities.CAPABILITY_WORKABLE.cast(this);
        if (capability == GregtechTileCapabilities.CAPABILITY_CONTROLLABLE)
            return GregtechTileCapabilities.CAPABILITY_CONTROLLABLE.cast(this);
        return super.getCapability(capability, side);
    }

    @Override
    protected boolean shouldShowVoidingModeButton() {
        return false;
    }

    @Override
    public void receiveCustomData(int dataId, PacketBuffer buf) {
        super.receiveCustomData(dataId, buf);
        this.logic.receiveCustomData(dataId, buf);
    }

}