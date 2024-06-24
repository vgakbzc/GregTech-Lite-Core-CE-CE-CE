package magicbook.gtlitecore.common.metatileentities.multi.electric;

import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.MultiblockShapeInfo;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.BlockMultiblockCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.MetaTileEntities;
import magicbook.gtlitecore.api.GTLiteAPI;
import magicbook.gtlitecore.api.block.impl.WrappedIntTier;
import magicbook.gtlitecore.api.capability.GTLiteDataCode;
import magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps;
import magicbook.gtlitecore.api.utils.GTLiteUtils;
import magicbook.gtlitecore.client.renderer.texture.GTLiteTextures;
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
import org.lwjgl.input.Keyboard;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static gregtech.api.GTValues.HV;
import static magicbook.gtlitecore.api.pattern.GTLiteTraceabilityPredicate.actCasings;

public class MetaTileEntityAlgaeCultureTank extends RecipeMapMultiblockController {

    private int tier;
    private static boolean init = false;
    private static List<IBlockState> finalListCasing;

    public MetaTileEntityAlgaeCultureTank(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GTLiteRecipeMaps.ALGAE_CULTURE_TANK_RECIPES);
        this.recipeMapWorkable = new AlgaeCultureTankRecipeLogic(this);
        initMap();
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityAlgaeCultureTank(metaTileEntityId);
    }

    private void initMap() {
        if (init) return;

        List<IBlockState> ListCasing = GTLiteAPI.MAP_ACT_CASING.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> ((WrappedIntTier) entry.getValue()).getIntTier()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        int maxLeng = GTLiteUtils.maxLength(new ArrayList<List<IBlockState>>(){{
            add(ListCasing);
        }});

        finalListCasing = GTLiteUtils.consistentList(ListCasing, maxLeng);
        init = true;
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        Object CasingTier = context.get("AlgaeCultureTankCasingTieredStats");
        this.tier = GTLiteUtils.getOrDefault(
                () -> CasingTier instanceof WrappedIntTier,
                () -> ((WrappedIntTier) CasingTier).getIntTier(), 0);
        this.writeCustomData(GTLiteDataCode.ChannelAlgaeCultureTank1, buf -> buf.writeInt(this.tier));
    }

    @Override
    public void update() {
        super.update();
        if (this.getWorld().isRemote && this.tier == 0) {
            this.writeCustomData(GTLiteDataCode.ChannelAlgaeCultureTank2, buf -> {});
        }
    }

    @NotNull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("C   C", "CCCCC", "CGGGC", "CGGGC", " CCC ")
                .aisle("     ", "CDDDC", "G###G", "G###G", "CCCCC")
                .aisle("     ", "CDDDC", "G###G", "G###G", "CCCCC")
                .aisle("     ", "CDDDC", "G###G", "G###G", "CCCCC")
                .aisle("C   C", "CCSCC", "CGGGC", "CGGGC", " CCC ")
                .where('S', this.selfPredicate())
                .where('C', actCasings()
                        .setMinGlobalLimited(40)
                        .or(autoAbilities()))
                .where('D', states(getCasingState()))
                .where('G', states(getGlassState()))
                .where('#', air())
                .where(' ', any())
                .build();
    }

    private static IBlockState getCasingState() {
        return MetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.GRATE_CASING);
    }

    private static IBlockState getGlassState() {
        return MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.TEMPERED_GLASS);
    }

    @SuppressWarnings("all")
    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return switch (this.tier) {
            case 1 -> Textures.CLEAN_STAINLESS_STEEL_CASING;
            case 2 -> GTLiteTextures.DURALUMINIUM_ALLOY_CASING;
            case 3 -> GTLiteTextures.AUSTENITIC_STAINLESS_STEEL_CASING;
            case 4 -> GTLiteTextures.NIOBIUM_TITANIUM_CASING;
            case 5 -> GTLiteTextures.FERMIUM_CASING;
            default -> Textures.CLEAN_STAINLESS_STEEL_CASING;
        };
    }

    @SideOnly(Side.CLIENT)
    @NotNull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return GTLiteTextures.ALGAE_CULTURE_TANK_OVERLAY;
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
        MultiblockShapeInfo.Builder builder = null;
        builder = MultiblockShapeInfo.builder()
                .aisle("C   C", "CEMEC", "CGGGC", "CGGGC", " CCC ")
                .aisle("     ", "CDDDC", "G###G", "G###G", "CCCCC")
                .aisle("     ", "CDDDC", "G###G", "G###G", "CCCCC")
                .aisle("     ", "CDDDC", "G###G", "G###G", "CCCCC")
                .aisle("C   C", "IJSKL", "CGGGC", "CGGGC", " CCC ")
                .where('S', GTLiteMetaTileEntities.ALGAE_CULTURE_TANK, EnumFacing.SOUTH)
                .where('D', getCasingState())
                .where('G', getGlassState())
                .where('I', MetaTileEntities.ITEM_IMPORT_BUS[HV], EnumFacing.SOUTH)
                .where('J', MetaTileEntities.ITEM_EXPORT_BUS[HV], EnumFacing.SOUTH)
                .where('K', MetaTileEntities.FLUID_IMPORT_HATCH[HV], EnumFacing.SOUTH)
                .where('L', MetaTileEntities.FLUID_EXPORT_HATCH[HV], EnumFacing.SOUTH)
                .where('M', MetaTileEntities.MAINTENANCE_HATCH, EnumFacing.NORTH)
                .where('E', MetaTileEntities.ENERGY_INPUT_HATCH[HV], EnumFacing.NORTH)
                .where('#', Blocks.AIR.getDefaultState());
        MultiblockShapeInfo.Builder finalBuilder = builder;
        AtomicInteger count = new AtomicInteger();
        finalListCasing.stream()
                .map(b -> {
                    if (finalBuilder != null) {
                        finalBuilder.where('C', b);
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
        if (dataId == GTLiteDataCode.ChannelPreciseAssembler1) {
            this.tier = buf.readInt();
        }
        if (dataId == GTLiteDataCode.ChannelPreciseAssembler2) {
            this.writeCustomData(GTLiteDataCode.ChannelPreciseAssembler1, buf1 -> buf1.writeInt(this.tier));
        }
    }

    @Override
    public void writeInitialSyncData(PacketBuffer buf) {
        super.writeInitialSyncData(buf);
        buf.writeInt(this.tier);
    }

    @Override
    public void receiveInitialSyncData(PacketBuffer buf) {
        super.receiveInitialSyncData(buf);
        this.tier = buf.readInt();
    }

    @Override
    public void addInformation(@NotNull ItemStack stack,
                               @Nullable World player,
                               @NotNull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gtlitecore.machine.algae_culture_tank.tooltip.1"));
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
            tooltip.add(I18n.format("gtlitecore.machine.algae_culture_tank.tooltip_shift.1"));
            tooltip.add(I18n.format("gtlitecore.machine.algae_culture_tank.tooltip_shift.2"));
            tooltip.add(I18n.format("gtlitecore.machine.algae_culture_tank.tooltip_shift.3"));
            tooltip.add(I18n.format("gtlitecore.machine.algae_culture_tank.tooltip_shift.4"));
        } else {
            tooltip.add(I18n.format("gregtech.tooltip.hold_shift"));
        }
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }

    private class AlgaeCultureTankRecipeLogic extends MultiblockRecipeLogic {

        public AlgaeCultureTankRecipeLogic(RecipeMapMultiblockController tileEntity) {
            super(tileEntity);
        }

        @Override
        protected double getOverclockingDurationDivisor() {
            if (tier == 1)
                return 1.0D;
            else if (tier == 2)
                return 2.0D;
            else if (tier == 3)
                return 1.0D;
            else if (tier == 4)
                return 4.0D;
            else if (tier == 5)
                return 2.0D;
            else
                return 1.0D;
        }

        @Override
        protected double getOverclockingVoltageMultiplier() {
            if (tier == 1)
                return 1.0D;
            else if (tier == 2)
                return 2.0D;
            else if (tier == 3)
                return 1.0D;
            else if (tier == 4)
                return 4.0D;
            else if (tier == 5)
                return 2.0D;
            else
                return 1.0D;
        }

        @Override
        public void setMaxProgress(int maxProgress) {
            if (tier == 5)
                this.maxProgressTime = maxProgress / 2;
        }

        @Override
        public int getParallelLimit() {
            if (tier == 3)
                return 16;
            else if (tier == 4)
                return 8;
            else if (tier == 5)
                return 4;
            else
                return 1;
        }
    }
}
