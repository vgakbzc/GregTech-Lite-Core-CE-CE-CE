package magicbook.gtlitecore.common.metatileentities.multi.electric.generator;

import gregtech.api.GTValues;
import gregtech.api.capability.GregtechCapabilities;
import gregtech.api.capability.IEnergyContainer;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.FuelMultiblockController;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.unification.material.Materials;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.MetaBlocks;
import magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps;
import magicbook.gtlitecore.client.GTLiteTextures;
import magicbook.gtlitecore.common.blocks.BlockActiveMultiblockCasing;
import magicbook.gtlitecore.common.blocks.BlockUniqueCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import java.util.List;

import static gregtech.api.GTValues.*;

public class MetaTileEntityHyperReactorMkIII extends FuelMultiblockController {

    public MetaTileEntityHyperReactorMkIII(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GTLiteRecipeMaps.HYPER_REACTOR_MK3_RECIPES, UXV);
        this.recipeMapWorkable.setMaximumOverclockVoltage(V[UXV]);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityHyperReactorMkIII(metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "    CCC    ", "   CCCCC   ", "   CCCCC   ", "   CCCCC   ", "    CCC    ", "           ", "           ", "           ")
                .aisle("           ", "           ", "           ", "           ", "           ", "           ", "           ", "   CCCCC   ", "  CC###CC  ", "  C#####C  ", "  C#####C  ", "  C#####C  ", "  CC###CC  ", "   CCCCC   ", "           ", "           ")
                .aisle("  F     F  ", "  F     F  ", "  F     F  ", "  F     F  ", "  F     F  ", "  F     F  ", "  FCCCCCF  ", "  C#####C  ", " C#######C ", " C#######C ", " C#######C ", " C#######C ", " C#######C ", "  C#####C  ", "   CCCCC   ", "           ")
                .aisle("   F   F   ", "   F   F   ", "   F   F   ", "   F   F   ", "   F   F   ", "   FCCCF   ", "  CC###CC  ", " C#######C ", " C#######C ", "C#########C", "C####H####C", "C#########C", " C#######C ", " C#######C ", "  CC###CC  ", "    CCC    ")
                .aisle("           ", "           ", "           ", "           ", "           ", "   CCCCC   ", "  C#####C  ", " C#######C ", "C#########C", "G####H####G", "G###HHH###G", "G####H####G", "C#########C", " C#######C ", "  C#####C  ", "   CCCCC   ")
                .aisle("           ", "           ", "           ", "           ", "           ", "   CCCCC   ", "  C#####C  ", " C#######C ", "C####H####C", "G###HHH###G", "G##HHHHH##G", "G###HHH###G", "C####H####C", " C#######C ", "  C#####C  ", "   CCCCC   ")
                .aisle("           ", "           ", "           ", "           ", "           ", "   CCCCC   ", "  C#####C  ", " C#######C ", "C#########C", "G####H####G", "G###HHH###G", "G####H####G", "C#########C", " C#######C ", "  C#####C  ", "   CCCCC   ")
                .aisle("   F   F   ", "   F   F   ", "   F   F   ", "   F   F   ", "   F   F   ", "   FCCCF   ", "  CC###CC  ", " C#######C ", " C#######C ", "C#########C", "C####H####C", "C#########C", " C#######C ", " C#######C ", "  CC###CC  ", "    CCC    ")
                .aisle("  F     F  ", "  F     F  ", "  F     F  ", "  F     F  ", "  F     F  ", "  F     F  ", "  FCCCCCF  ", "  C#####C  ", " C#######C ", " C#######C ", " C#######C ", " C#######C ", " C#######C ", "  C#####C  ", "   CCCCC   ", "           ")
                .aisle("           ", "           ", "           ", "           ", "           ", "           ", "           ", "   CCCCC   ", "  CC###CC  ", "  C#####C  ", "  C#####C  ", "  C#####C  ", "  CC###CC  ", "   CCCCC   ", "           ", "           ")
                .aisle("           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "    CCC    ", "   CCCCC   ", "   CCSCC   ", "   CCCCC   ", "    CCC    ", "           ", "           ", "           ")
                .where('S', this.selfPredicate())
                .where('C', states(getCasingState())
                        .setMinGlobalLimited(250)
                        .or(autoAbilities(false, true, false, false, true, false, false))
                        .or(metaTileEntities(MultiblockAbility.REGISTRY.get(MultiblockAbility.OUTPUT_ENERGY).stream()
                                .filter(mte -> {
                                    IEnergyContainer container = mte.getCapability(GregtechCapabilities.CAPABILITY_ENERGY_CONTAINER, null);
                                    return container != null && container.getOutputVoltage() == GTValues.V[UEV]
                                            && container.getOutputAmperage() == 2;
                                })
                                .toArray(MetaTileEntity[]::new)).setExactLimit(1).setPreviewCount(1)))
                .where('F', states(getFrameState()))
                .where('H', states(getUniqueCasingState()))
                .where('G', states(getGlassState()))
                .where('#', air())
                .where(' ', any())
                .build();
    }

    private static IBlockState getCasingState() {
        return GTLiteMetaBlocks.UNIQUE_CASING.getState(BlockUniqueCasing.UniqueCasingType.ADVANCED_HYPER_CASING);
    }

    private static IBlockState getUniqueCasingState() {
        return GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getState(BlockActiveMultiblockCasing.ActiveCasingType.HYPER_CORE_MK3);
    }

    private static IBlockState getFrameState() {
        return MetaBlocks.FRAMES.get(Materials.Naquadria).getBlock(Materials.Naquadria);
    }

    private static IBlockState getGlassState() {
        return MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.FUSION_GLASS);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GTLiteTextures.ADVANCED_HYPER_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.POWER_SUBSTATION_OVERLAY;
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World player,
                               @Nonnull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gtlitecore.machine.hyper_reactor_mk3.tooltip.1"));
        tooltip.add(I18n.format("gtlitecore.machine.hyper_reactor_mk3.tooltip.2"));
    }
}