package magicbook.gtlitecore.mixin.gcym;

import gregicality.multiblocks.api.metatileentity.GCYMRecipeMapMultiblockController;
import gregicality.multiblocks.common.metatileentities.multiblock.standard.MetaTileEntityMegaBlastFurnace;
import gregtech.api.capability.IHeatingCoil;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;
import java.util.List;

@Mixin(value = MetaTileEntityMegaBlastFurnace.class, remap = false)
public abstract class MixinMetaTileEntityMegaBlastFurnace extends GCYMRecipeMapMultiblockController implements IHeatingCoil {

    public MixinMetaTileEntityMegaBlastFurnace(ResourceLocation metaTileEntityId, RecipeMap<?> recipeMap) {
        super(metaTileEntityId, RecipeMaps.BLAST_RECIPES);
        this.recipeMapWorkable = new MixinMegaBlastFurnaceRecipeLogic(this);
    }

    /**
     * <p>
     *     Used to add duration reduced effect information,
     *     please see: {@link MixinMegaBlastFurnaceRecipeLogic}.
     * </p>
     *
     * @author Magic_Sweepy
     */
    @Inject(method = "addInformation",
            at = @At("TAIL"))
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, boolean advanced,
                               CallbackInfo ci) {
        tooltip.add(I18n.format("gtlitecore.machine.volcanus.tooltip.3"));
    }

}
