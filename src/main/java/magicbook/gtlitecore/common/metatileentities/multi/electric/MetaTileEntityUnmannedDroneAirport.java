package magicbook.gtlitecore.common.metatileentities.multi.electric;

import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.unification.material.Materials;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.*;
import magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps;
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

public class MetaTileEntityUnmannedDroneAirport extends RecipeMapMultiblockController {

    public MetaTileEntityUnmannedDroneAirport(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GTLiteRecipeMaps.DRONE_AIRPORT_RECIPES);
        this.recipeMapWorkable = new MultiblockRecipeLogic(this, true);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityUnmannedDroneAirport(metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("    F     F", "    F     F", "     FCCCF ", "     F   F ", "           ", "           ")
                .aisle("F          ", "F          ", "FFFFFCXXXCF", " AAAF     F", " AAA       ", "           ")
                .aisle("           ", "           ", "FAAACXXXXXC", "P###P      ", "P###P      ", " AAA       ")
                .aisle("           ", "           ", "FAAACXXXXXC", "A#G#A      ", "A#G#A      ", " AMA       ")
                .aisle("           ", "           ", "FAAACXXXXXC", "P###P      ", "P###P      ", " AAA       ")
                .aisle("F          ", "F          ", "FFFFFCXXXCF", " AAAF     F", " ASA       ", "           ")
                .aisle("    F     F", "    F     F", "     FCCCF ", "     F   F ", "           ", "           ")
                .where('S', this.selfPredicate())
                .where('C', states(getCasingState()))
                .where('X', states(getSecondCasingState()))
                .where('A', states(getThirdCasingState())
                        .setMinGlobalLimited(25)
                        .or(autoAbilities()))
                .where('G', states(getFourthCasingState()))
                .where('P', states(getBoilerCasingState()))
                .where('F', states(getFrameState()))
                .where('M', abilities(MultiblockAbility.MUFFLER_HATCH))
                .where(' ', any())
                .where('#', air())
                .build();
    }

    private static IBlockState getCasingState() {
        return MetaBlocks.WARNING_SIGN.getState(BlockWarningSign.SignType.YELLOW_STRIPES);
    }

    private static IBlockState getSecondCasingState() {
        return MetaBlocks.CLEANROOM_CASING.getState(BlockCleanroomCasing.CasingType.PLASCRETE);
    }

    private static IBlockState getThirdCasingState() {
        return MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STEEL_SOLID);
    }

    private static IBlockState getFourthCasingState() {
        return MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.STEEL_GEARBOX);
    }

    private static IBlockState getBoilerCasingState() {
        return MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.STEEL_PIPE);
    }

    private static IBlockState getFrameState() {
        return MetaBlocks.FRAMES.get(Materials.Steel).getBlock(Materials.Steel);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return Textures.SOLID_STEEL_CASING;
    }

    @Override
    public void addInformation(@Nonnull ItemStack stack,
                               @Nullable World player,
                               @Nonnull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gregtech.machine.perfect_oc"));
        tooltip.add(I18n.format("gtlitecore.machine.unmanned_drone_airport.tooltip.1"));
        tooltip.add(I18n.format("gtlitecore.machine.unmanned_drone_airport.tooltip.2"));
    }

    @Override
    public boolean hasMufflerMechanics() {
        return true;
    }
}
