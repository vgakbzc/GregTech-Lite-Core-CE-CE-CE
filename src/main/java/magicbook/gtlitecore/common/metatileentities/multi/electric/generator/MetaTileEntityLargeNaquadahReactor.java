package magicbook.gtlitecore.common.metatileentities.multi.electric.generator;

import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockUniqueCasing;
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
import gregtech.common.blocks.MetaBlocks;
import magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps;
import magicbook.gtlitecore.client.GTLiteTextures;
import magicbook.gtlitecore.common.blocks.BlockBoilerCasing;
import magicbook.gtlitecore.common.blocks.BlockMultiblockCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import java.util.List;

import static gregtech.api.GTValues.*;

public class MetaTileEntityLargeNaquadahReactor extends FuelMultiblockController {

    public MetaTileEntityLargeNaquadahReactor(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GTLiteRecipeMaps.NAQUADAH_REACTOR_RECIPES, UHV);
        this.recipeMapWorkable.setMaximumOverclockVoltage(V[UHV]);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityLargeNaquadahReactor(metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle(" CCC ", " CUC ", " CCC ", "  C  ", "  C  ", " CCC ", " CUC ", " CCC ")
                .aisle("CCCCC", "CP#PC", "CG#GC", " P#P ", " P#P ", "CG#GC", "CP#PC", " CCC ")
                .aisle("CCCCC", "U#F#U", "C#F#C", "C#F#C", "C#F#C", "C#F#C", "U#F#U", " COC ")
                .aisle("CCCCC", "CP#PC", "CG#GC", " P#P ", " P#P ", "CG#GC", "CP#PC", " CCC ")
                .aisle(" CCC ", " CSC ", " CCC ", "  C  ", "  C  ", " CCC ", " CUC ", " CCC ")
                .where('S', this.selfPredicate())
                .where('C', states(getCasingState())
                        .setMinGlobalLimited(70)
                        .or(autoAbilities(false, true, false, false, true, false, false))
                        .or(metaTileEntities(MultiblockAbility.REGISTRY.get(MultiblockAbility.OUTPUT_ENERGY).stream()
                                .filter(mte -> {
                                    IEnergyContainer container = mte.getCapability(GregtechCapabilities.CAPABILITY_ENERGY_CONTAINER, null);
                                    return container != null && container.getOutputVoltage() == GTValues.V[UHV];})
                                .toArray(MetaTileEntity[]::new))
                                .setExactLimit(1)
                                .setPreviewCount(1)))
                .where('U', states(getUniqueCasingState()))
                .where('G', states(getSecondCasingState()))
                .where('F', states(getFrameState()))
                .where('P', states(getBoilerCasingState()))
                .where('O', abilities(MultiblockAbility.MUFFLER_HATCH))
                .where(' ', any())
                .where('#', air())
                .build();
    }

    private static IBlockState getCasingState() {
        return GTLiteMetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.NAQUADRIA_CASING);
    }

    private static IBlockState getSecondCasingState() {
        return MetaBlocks.MULTIBLOCK_CASING.getState(gregtech.common.blocks.BlockMultiblockCasing.MultiblockCasingType.GRATE_CASING);
    }

    private static IBlockState getUniqueCasingState() {
        return GCYMMetaBlocks.UNIQUE_CASING.getState(BlockUniqueCasing.UniqueCasingType.HEAT_VENT);
    }

    private static IBlockState getBoilerCasingState() {
        return GTLiteMetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.POLYBENZIMIDAZOLE);
    }

    private static IBlockState getFrameState() {
        return MetaBlocks.FRAMES.get(Materials.Naquadria).getBlock(Materials.Naquadria);
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
        tooltip.add(I18n.format("gtlitecore.machine.large_naquadah_reactor.tooltip.1"));
        tooltip.add(I18n.format("gtlitecore.machine.large_naquadah_reactor.tooltip.2"));
    }

    @Override
    public void runMufflerEffect(float xPos, float yPos, float zPos, float xSpd, float ySpd, float zSpd) {
        this.getWorld().spawnParticle(EnumParticleTypes.SPELL_WITCH, xPos, yPos, zPos, xSpd, ySpd, zSpd);
    }
}
