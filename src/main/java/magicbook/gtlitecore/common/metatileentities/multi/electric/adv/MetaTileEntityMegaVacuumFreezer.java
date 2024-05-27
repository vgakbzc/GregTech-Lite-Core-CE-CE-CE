package magicbook.gtlitecore.common.metatileentities.multi.electric.adv;

import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.recipes.RecipeMaps;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.client.utils.TooltipHelper;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;
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

public class MetaTileEntityMegaVacuumFreezer extends RecipeMapMultiblockController {

    public MetaTileEntityMegaVacuumFreezer(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, RecipeMaps.VACUUM_RECIPES);
        this.recipeMapWorkable = new MegaVacuumFreezerRecipeLogic(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityMegaVacuumFreezer(metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("CCCCCCCCCCCCCCC", "CCCCCCCCCCCCCCC", "CCCCCCCCCCCCCCC", "CCCCCCCCCCCCCCC", "CCCCCCCCCCCCCCC", "CCCCCCCCCCCCCCC", "CCCCCCCCCCCCCCC", "CCCCCCCCCCCCCCC", "CCCCCCCCCCCCCCC", "CCCCCCCCCCCCCCC", "CCCCCCCCCCCCCCC", "CCCCCCCCCCCCCCC", "CCCCCCCCCCCCCCC", "CCCCCCCCCCCCCCC", "CCCCCCCCCCCCCCC")
                .aisle("CCCCCCCCCCCCCCC", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "CCCCCCCCCCCCCCC")
                .aisle("CCCCCCCCCCCCCCC", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "CCCCCCCCCCCCCCC")
                .aisle("CCCCCCCCCCCCCCC", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "CCCCCCCCCCCCCCC")
                .aisle("CCCCCCCCCCCCCCC", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "CCCCCCCCCCCCCCC")
                .aisle("CCCCCCCCCCCCCCC", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "CCCCCCCCCCCCCCC")
                .aisle("CCCCCCCCCCCCCCC", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "CCCCCCCCCCCCCCC")
                .aisle("CCCCCCCCCCCCCCC", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "CCCCCCCCCCCCCCC")
                .aisle("CCCCCCCCCCCCCCC", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "CCCCCCCCCCCCCCC")
                .aisle("CCCCCCCCCCCCCCC", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "CCCCCCCCCCCCCCC")
                .aisle("CCCCCCCCCCCCCCC", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "CCCCCCCCCCCCCCC")
                .aisle("CCCCCCCCCCCCCCC", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "CCCCCCCCCCCCCCC")
                .aisle("CCCCCCCCCCCCCCC", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "CCCCCCCCCCCCCCC")
                .aisle("CCCCCCCCCCCCCCC", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "C#############C", "CCCCCCCCCCCCCCC")
                .aisle("CCCCCCCCCCCCCCC", "CCCCCCCCCCCCCCC", "CCCCCCCCCCCCCCC", "CCCCCCCCCCCCCCC", "CCCCCCCCCCCCCCC", "CCCCCCCCCCCCCCC", "CCCCCCCCCCCCCCC", "CCCCCCCSCCCCCCC", "CCCCCCCCCCCCCCC", "CCCCCCCCCCCCCCC", "CCCCCCCCCCCCCCC", "CCCCCCCCCCCCCCC", "CCCCCCCCCCCCCCC", "CCCCCCCCCCCCCCC", "CCCCCCCCCCCCCCC")
                .where('S', this.selfPredicate())
                .where('C', states(getCasingState())
                        .setMinGlobalLimited(800)
                        .or(autoAbilities()))
                .where('#', air())
                .build();
    }

    private static IBlockState getCasingState() {
        return MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.ALUMINIUM_FROSTPROOF);
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World player,
                               @Nonnull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(TooltipHelper.RAINBOW_SLOW + I18n.format("gregtech.machine.perfect_oc"));
        tooltip.add(I18n.format("gtlitecore.machine.mega_vacuum_freezer.tooltip.1"));
        tooltip.add(I18n.format("gtlitecore.universal.tooltip.max_parallel", 1024));
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return Textures.FROST_PROOF_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.VACUUM_FREEZER_OVERLAY;
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }

    protected static class MegaVacuumFreezerRecipeLogic extends MultiblockRecipeLogic {

        private final MetaTileEntityMegaVacuumFreezer vacuumFreezer;

        public MegaVacuumFreezerRecipeLogic(RecipeMapMultiblockController tileEntity) {
            super(tileEntity, true);
            this.vacuumFreezer = (MetaTileEntityMegaVacuumFreezer) tileEntity;
        }

        @Override
        public int getParallelLimit() {
            return 1024;
        }

        @Override
        public void setMaxProgress(int maxProgress) {
            this.maxProgressTime = maxProgress / 2;
        }

    }
}
