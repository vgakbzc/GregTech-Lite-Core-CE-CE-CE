package magicbook.gtlitecore.mixin.multiblocks;

import gregicality.multiblocks.api.capability.IParallelMultiblock;
import gregicality.multiblocks.api.capability.impl.GCYMMultiblockRecipeLogic;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(GCYMMultiblockRecipeLogic.class)
public abstract class mixinGCYMMultiblockRecipeLogic extends MultiblockRecipeLogic {

    public mixinGCYMMultiblockRecipeLogic(RecipeMapMultiblockController tileEntity) {
        super(tileEntity);
    }

    public int getParallelLimit() {
        return ((IParallelMultiblock)this.metaTileEntity).isParallel() ? ((IParallelMultiblock)this.metaTileEntity).getMaxParallel() : 1;
    }
    @Override
    public void setMaxProgress(int maxProgress)
    {
        this.maxProgressTime = maxProgress/((IParallelMultiblock)this.metaTileEntity).getMaxParallel();
    }
}
