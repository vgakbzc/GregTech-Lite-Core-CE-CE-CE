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
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.MetaBlocks;
import magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps;
import magicbook.gtlitecore.client.GTLiteTextures;
import magicbook.gtlitecore.common.blocks.BlockActiveMultiblockCasing;
import magicbook.gtlitecore.common.blocks.BlockMultiblockCasing;
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

public class MetaTileEntityHyperReactorMkI extends FuelMultiblockController {

    public MetaTileEntityHyperReactorMkI(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GTLiteRecipeMaps.HYPER_REACTOR_MK1_RECIPES, UEV);
        this.recipeMapWorkable.setMaximumOverclockVoltage(V[UEV]);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityHyperReactorMkI(metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("CCCCC", "CGGGC", "CGGGC", "CGGGC", "CCCCC")
                .aisle("CCCCC", "G###G", "G#H#G", "G###G", "CCCCC")
                .aisle("CCCCC", "G#H#G", "GHHHG", "G#H#G", "CCCCC")
                .aisle("CCCCC", "G###G", "G#H#G", "G###G", "CCCCC")
                .aisle("CCSCC", "CGGGC", "CGGGC", "CGGGC", "CCCCC")
                .where('S', this.selfPredicate())
                .where('C', states(getCasingState())
                        .setMinGlobalLimited(55)
                        .or(autoAbilities(false, true, false, false, true, false, false))
                        .or(metaTileEntities(MultiblockAbility.REGISTRY.get(MultiblockAbility.OUTPUT_ENERGY).stream()
                            .filter(mte -> {
                                IEnergyContainer container = mte.getCapability(GregtechCapabilities.CAPABILITY_ENERGY_CONTAINER, null);
                                return container != null && container.getOutputVoltage() == GTValues.V[UEV]
                                                         && container.getOutputAmperage() == 2;
                                })
                        .toArray(MetaTileEntity[]::new)).setExactLimit(1).setPreviewCount(1)))
                .where('G', states(getGlassState()))
                .where('H', states(getUniqueCasingState()))
                .where('#', air())
                .build();
    }

    private static IBlockState getCasingState() {
        return GTLiteMetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.NAQUADRIA_CASING);
    }

    private static IBlockState getUniqueCasingState() {
        return GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getState(BlockActiveMultiblockCasing.ActiveCasingType.HYPER_CORE_MK1);
    }

    private static IBlockState getGlassState() {
        return MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.FUSION_GLASS);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GTLiteTextures.NAQUADRIA_CASING;
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
        tooltip.add(I18n.format("gtlitecore.machine.hyper_reactor_mk1.tooltip.1"));
        tooltip.add(I18n.format("gtlitecore.machine.hyper_reactor_mk1.tooltip.2"));
    }
}