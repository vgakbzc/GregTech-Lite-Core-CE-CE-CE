package magicbook.gtlitecore.mixin.gcym;

import gregicality.multiblocks.api.capability.impl.GCYMMultiblockRecipeLogic;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(targets = "gregicality.multiblocks.common.metatileentities.multiblock.standard.MetaTileEntityMegaBlastFurnace$MegaBlastFurnaceRecipeLogic", remap = false)
public class MixinMegaBlastFurnaceRecipeLogic extends GCYMMultiblockRecipeLogic {

    public MixinMegaBlastFurnaceRecipeLogic(RecipeMapMultiblockController tileEntity) {
        super(tileEntity);
    }

    /**
     * @param maxProgress Get 1/2 progress time.
     */
    @Override
    public void setMaxProgress(int maxProgress) {
        this.maxProgressTime = maxProgress / 2;
    }
}
