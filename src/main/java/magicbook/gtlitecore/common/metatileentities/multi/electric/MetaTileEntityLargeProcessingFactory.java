package magicbook.gtlitecore.common.metatileentities.multi.electric;

import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiMapMultiblockController;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.recipeproperties.IRecipePropertyStorage;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps;
import magicbook.gtlitecore.client.renderer.texture.GTLiteTextures;
import magicbook.gtlitecore.common.blocks.BlockMetalCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.List;

/**
 * Large Processing Factory
 *
 * @author Gate Guardian
 *
 * @since 2.7.4-beta
 */
public class MetaTileEntityLargeProcessingFactory extends MultiMapMultiblockController {

    public MetaTileEntityLargeProcessingFactory(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, new RecipeMap[]{
                GTLiteRecipeMaps.PROCESSING_MODE_A,
                GTLiteRecipeMaps.PROCESSING_MODE_B,
                GTLiteRecipeMaps.PROCESSING_MODE_C
        });
        this.recipeMapWorkable = new ProcessingFactoryRecipeLogic(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityLargeProcessingFactory(metaTileEntityId);
    }

    @NotNull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("CCC", "CCC", "CCC")
                .aisle("CCC", "C#C", "CMC")
                .aisle("CCC", "CSC", "CCC")
                .where('S', this.selfPredicate())
                .where('C', states(getCasingState())
                        .setMinGlobalLimited(6)
                        .or(autoAbilities()))
                .where('M', abilities(MultiblockAbility.MUFFLER_HATCH))
                .where('#', air())
                .build();
    }

    private static IBlockState getCasingState() {
        return GTLiteMetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STABALLOY_CASING);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GTLiteTextures.STABALLOY_CASING;
    }

    @SideOnly(Side.CLIENT)
    @NotNull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return GTLiteTextures.LARGE_PROCESSING_FACTORY_OVERLAY;
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World player,
                               @NotNull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gtlitecore.machine.large_processing_factory.tooltip.1"));
        tooltip.add(I18n.format("gtlitecore.machine.large_processing_factory.tooltip.2"));
        tooltip.add(I18n.format("gtlitecore.machine.large_processing_factory.tooltip.3"));
        tooltip.add(I18n.format("gtlitecore.machine.large_processing_factory.tooltip.4"));
        tooltip.add(I18n.format("gtlitecore.machine.large_processing_factory.tooltip.5"));
        tooltip.add(I18n.format("gtlitecore.machine.large_processing_factory.tooltip.6"));
        tooltip.add(I18n.format("gtlitecore.machine.large_processing_factory.tooltip.7"));
        tooltip.add(I18n.format("gtlitecore.machine.large_processing_factory.tooltip.8"));
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    protected class ProcessingFactoryRecipeLogic extends MultiblockRecipeLogic {

        public ProcessingFactoryRecipeLogic(RecipeMapMultiblockController tileEntity) {
            super(tileEntity);
        }

        @Override
        protected void modifyOverclockPre(@NotNull int[] values,
                                          @NotNull IRecipePropertyStorage storage) {
            super.modifyOverclockPre(values, storage);
            values[0] *= 0.8;
            values[1] *= 0.4;
        }

        @Override
        public int getParallelLimit() {
            return GTUtility.getFloorTierByVoltage(getMaxVoltage()) * 2;
        }
    }
}
