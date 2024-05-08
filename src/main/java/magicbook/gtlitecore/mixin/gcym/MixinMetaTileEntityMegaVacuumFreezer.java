package magicbook.gtlitecore.mixin.gcym;

import gregicality.multiblocks.api.metatileentity.GCYMRecipeMapMultiblockController;
import gregicality.multiblocks.common.metatileentities.multiblock.standard.MetaTileEntityMegaVacuumFreezer;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.recipes.RecipeMaps;
import gregtech.client.utils.TooltipHelper;
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

@Mixin(value = MetaTileEntityMegaVacuumFreezer.class, remap = false)
public abstract class MixinMetaTileEntityMegaVacuumFreezer extends GCYMRecipeMapMultiblockController {

    public MixinMetaTileEntityMegaVacuumFreezer(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, RecipeMaps.VACUUM_RECIPES);
    }

    @Inject(method = "<init>",
            at = @At("TAIL"))
    public void createNewConstructor(CallbackInfo ci) {
        this.recipeMapWorkable = new MultiblockRecipeLogic(this, true);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(TooltipHelper.RAINBOW_SLOW + I18n.format("gregtech.machine.perfect_oc"));
    }

}
