package magicbook.gtlitecore.common.metatileentities.multi.electric.adv;

import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.MultiblockShapeInfo;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.utils.TooltipHelper;
import gregtech.common.metatileentities.MetaTileEntities;
import magicbook.gtlitecore.api.GTLiteAPI;
import magicbook.gtlitecore.api.block.impl.WrappedIntTier;
import magicbook.gtlitecore.api.capability.GTLiteDataCode;
import magicbook.gtlitecore.api.utils.GTLiteUtils;
import magicbook.gtlitecore.client.renderer.texture.GTLiteTextures;
import magicbook.gtlitecore.common.blocks.BlockSupportCasing;
import magicbook.gtlitecore.common.blocks.BlockTransparentUniqueCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static gregtech.api.GTValues.UV;
import static magicbook.gtlitecore.api.pattern.GTLiteTraceabilityPredicate.modulationCavities;
import static magicbook.gtlitecore.api.pattern.GTLiteTraceabilityPredicate.resonantCavities;

public class MetaTileEntityElementReplicator extends RecipeMapMultiblockController {

    private int modulationCavityTier;
    private int resonantCavityTier;
    private static boolean init = false;
    private static List<IBlockState> finalListModulationCavity;
    private static List<IBlockState> finalListResonantCavity;

    public MetaTileEntityElementReplicator(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, RecipeMaps.REPLICATOR_RECIPES);
        this.recipeMapWorkable = new ElementReplicatorRecipeLogic(this);
        initMap();
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityElementReplicator(metaTileEntityId);
    }

    private void initMap() {
        if (init) return;

        List<IBlockState> ListModulationCavity = GTLiteAPI.MAP_MODULATION_CAVITY.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> ((WrappedIntTier) entry.getValue()).getIntTier()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        List<IBlockState> ListResonantCavity = GTLiteAPI.MAP_RESONANT_CAVITY.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> ((WrappedIntTier) entry.getValue()).getIntTier()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        int maxLeng = GTLiteUtils.maxLength(new ArrayList<List<IBlockState>>() {{
            add(ListModulationCavity);
            add(ListResonantCavity);
        }});

        finalListModulationCavity = GTLiteUtils.consistentList(ListModulationCavity, maxLeng);
        finalListResonantCavity = GTLiteUtils.consistentList(ListResonantCavity, maxLeng);

        init = true;
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        Object modulationCavityTier = context.get("ModulationCavityTieredStats");
        Object resonantCavityTier = context.get("ResonantCavityTieredStats");
        this.modulationCavityTier = GTLiteUtils.getOrDefault(
                () -> modulationCavityTier instanceof WrappedIntTier,
                () -> ((WrappedIntTier) modulationCavityTier).getIntTier(), 0);
        this.resonantCavityTier = GTLiteUtils.getOrDefault(
                () -> resonantCavityTier instanceof WrappedIntTier,
                () -> ((WrappedIntTier) resonantCavityTier).getIntTier(), 0);
        this.writeCustomData(GTLiteDataCode.ChannelElementReplicator1, buf -> buf.writeInt(this.modulationCavityTier));
        this.writeCustomData(GTLiteDataCode.ChannelElementReplicator2, buf -> buf.writeInt(this.resonantCavityTier));
    }

    @Override
    public void update() {
        super.update();
        if (this.getWorld().isRemote) {
            if (this.modulationCavityTier == 0) {
                this.writeCustomData(GTLiteDataCode.ChannelElementReplicator3, buf -> {});
            }
            if (this.resonantCavityTier == 0) {
                this.writeCustomData(GTLiteDataCode.ChannelElementReplicator4, buf -> {});
            }
        }
    }

    @NotNull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("   CCC   ", "   CDC   ", "   CGC   ", "   CGC   ", "   CDC   ", "   CCC   ")
                .aisle("  CCCCC  ", "  DXRXD  ", "  G###G  ", "  G###G  ", "  DXRXD  ", "  CCCCC  ")
                .aisle(" CCCCCCC ", " DXRMRXD ", " G#####G ", " G#####G ", " DXRMRXD ", " CCCCCCC ")
                .aisle("CCCCCCCCC", "CXRMPMRXC", "C###P###C", "C###P###C", "CXRMPMRXC", "CCCCCCCCC")
                .aisle("CCCCCCCCC", "DRMPPPMRD", "G##PPP##G", "G##PPP##G", "DRMPPPMRD", "CCCCSCCCC")
                .aisle("CCCCCCCCC", "CXRMPMRXC", "C###P###C", "C###P###C", "CXRMPMRXC", "CCCCCCCCC")
                .aisle(" CCCCCCC ", " DXRMRXD ", " G#####G ", " G#####G ", " DXRMRXD ", " CCCCCCC ")
                .aisle("  CCCCC  ", "  DXRXD  ", "  G###G  ", "  G###G  ", "  DXRXD  ", "  CCCCC  ")
                .aisle("   CCC   ", "   CDC   ", "   CGC   ", "   CGC   ", "   CDC   ", "   CCC   ")
                .where('S', this.selfPredicate())
                .where('C', states(getCasingState())
                        .setMinGlobalLimited(120)
                        .or(autoAbilities()))
                .where('D', states(getSecondCasingState()))
                .where('X', states(getCoilState()))
                .where('P', states(getThirdCasingState()))
                .where('G', states(getFourthCasingState()))
                .where('M', modulationCavities())
                .where('R', resonantCavities())
                .where('#', air())
                .where(' ', any())
                .build();
    }

    private static IBlockState getCasingState() {
        return GTLiteMetaBlocks.SUPPORT_CASING.getState(BlockSupportCasing.SupportCasingType.ELEMENT_CONSTRAINED_CASING);
    }

    private static IBlockState getSecondCasingState() {
        return GTLiteMetaBlocks.SUPPORT_CASING.getState(BlockSupportCasing.SupportCasingType.MASS_FABRICATOR_CASING);
    }

    private static IBlockState getThirdCasingState() {
        return GTLiteMetaBlocks.SUPPORT_CASING.getState(BlockSupportCasing.SupportCasingType.HIGH_VOLTAGE_CURRENT_CAPACITOR);
    }

    private static IBlockState getFourthCasingState() {
        return GTLiteMetaBlocks.TRANSPARENT_UNIQUE_CASING.getState(BlockTransparentUniqueCasing.TransparentUniqueCasingType.PARTICLE_SUPPRESSION_CASING);
    }

    private static IBlockState getCoilState() {
        return GTLiteMetaBlocks.SUPPORT_CASING.getState(BlockSupportCasing.SupportCasingType.MASS_FABRICATOR_COIL);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GTLiteTextures.ELEMENT_CONSTRAINED_CASING;
    }

    @SideOnly(Side.CLIENT)
    @NotNull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return GTLiteTextures.ELEMENT_REPLICATOR_OVERLAY;
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
        MultiblockShapeInfo.Builder builder = null;
        if (Blocks.AIR != null) {
            builder = MultiblockShapeInfo.builder()
                    .aisle("   CCC   ", "   CDC   ", "   CGC   ", "   CGC   ", "   CDC   ", "   CCC   ")
                    .aisle("  CCCCC  ", "  DXRXD  ", "  G###G  ", "  G###G  ", "  DXRXD  ", "  CCCCC  ")
                    .aisle(" CCCCCCC ", " DXRMRXD ", " G#####G ", " G#####G ", " DXRMRXD ", " CCCCCCC ")
                    .aisle("CCCCCCCCC", "CXRMPMRXC", "C###P###C", "C###P###C", "CXRMPMRXC", "CCCkClCCC")
                    .aisle("CCCCCCCCC", "DRMPPPMRD", "G##PPP##G", "G##PPP##G", "DRMPPPMRD", "CCCiSjCCC")
                    .aisle("CCCCCCCCC", "CXRMPMRXC", "C###P###C", "C###P###C", "CXRMPMRXC", "CCCemeCCC")
                    .aisle(" CCCCCCC ", " DXRMRXD ", " G#####G ", " G#####G ", " DXRMRXD ", " CCCCCCC ")
                    .aisle("  CCCCC  ", "  DXRXD  ", "  G###G  ", "  G###G  ", "  DXRXD  ", "  CCCCC  ")
                    .aisle("   CCC   ", "   CDC   ", "   CGC   ", "   CGC   ", "   CDC   ", "   CCC   ")
                    .where('S', GTLiteMetaTileEntities.ELEMENT_REPLICATOR, EnumFacing.SOUTH)
                    .where('C', getCasingState())
                    .where('D', getSecondCasingState())
                    .where('X', getCoilState())
                    .where('P', getThirdCasingState())
                    .where('G', getFourthCasingState())
                    .where('i', MetaTileEntities.ITEM_IMPORT_BUS_ME, EnumFacing.UP)
                    .where('j', MetaTileEntities.ITEM_EXPORT_BUS_ME, EnumFacing.UP)
                    .where('k', MetaTileEntities.FLUID_IMPORT_HATCH_ME, EnumFacing.UP)
                    .where('l', MetaTileEntities.FLUID_EXPORT_HATCH_ME, EnumFacing.UP)
                    .where('m', MetaTileEntities.AUTO_MAINTENANCE_HATCH, EnumFacing.UP)
                    .where('e', GTLiteMetaTileEntities.WIRELESS_INPUT_ENERGY_HATCH[UV], EnumFacing.UP)
                    .where('#', Blocks.AIR.getDefaultState());
        }
        MultiblockShapeInfo.Builder finalBuilder = builder;
        AtomicInteger count = new AtomicInteger();
        finalListModulationCavity.stream()
                .map(b -> {
                    if (finalBuilder != null) {
                        finalBuilder.where('M', b);
                        finalBuilder.where('R', finalListResonantCavity.get(count.get()));
                        count.getAndIncrement();
                    }
                    return finalBuilder;
                })
                .filter(Objects::nonNull)
                .forEach(b -> shapeInfo.add(b.build()));
        return shapeInfo;
    }

    @Override
    public void receiveCustomData(int dataId, PacketBuffer buf) {
        super.receiveCustomData(dataId, buf);
        if (dataId == GTLiteDataCode.ChannelElementReplicator1) {
            this.modulationCavityTier = buf.readInt();
        }
        if (dataId == GTLiteDataCode.ChannelElementReplicator2) {
            this.resonantCavityTier = buf.readInt();
        }
        if (dataId == GTLiteDataCode.ChannelElementReplicator3) {
            this.writeCustomData(GTLiteDataCode.ChannelElementReplicator1, buf1 -> buf1.writeInt(this.modulationCavityTier));
        }
        if (dataId == GTLiteDataCode.ChannelElementReplicator4) {
            this.writeCustomData(GTLiteDataCode.ChannelElementReplicator2, buf2 -> buf2.writeInt(this.resonantCavityTier));
        }
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World player,
                               @NotNull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(TooltipHelper.RAINBOW_SLOW + I18n.format("gregtech.machine.perfect_oc"));
        tooltip.add(I18n.format("gtlitecore.machine.element_replicator.tooltip.1"));
        tooltip.add(I18n.format("gtlitecore.universal.tooltip.get_parallel_by_voltage"));
        tooltip.add(I18n.format("gtlitecore.machine.element_replicator.tooltip.2"));
        tooltip.add(I18n.format("gtlitecore.machine.element_replicator.tooltip.3"));
        tooltip.add(I18n.format("gtlitecore.machine.element_replicator.tooltip.4"));
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }

    public int getModulationCavityTier() {
        return this.modulationCavityTier;
    }

    public int getResonantCavityTier() {
        return this.resonantCavityTier;
    }

    protected class ElementReplicatorRecipeLogic extends MultiblockRecipeLogic {

        public ElementReplicatorRecipeLogic(RecipeMapMultiblockController tileEntity) {
            super(tileEntity, true);
        }

        @Override
        public void setMaxProgress(int maxProgress) {
            this.maxProgressTime = (int) Math.floor(maxProgress * Math.pow(0.8, getResonantCavityTier()));
        }

        @Override
        public int getParallelLimit() {
            int tier = GTUtility.getTierByVoltage(getMaxVoltage());
            return 4 * getModulationCavityTier() * tier;
        }
    }
}
