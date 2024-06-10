package magicbook.gtlitecore.mixin.forge;

import net.minecraft.client.resources.I18n;
import net.minecraftforge.fml.client.GuiSlotModList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@SuppressWarnings("all")
@Mixin(GuiSlotModList.class)
public abstract class MixinGuiSlotModList {

    @ModifyArg(
            method = "drawSlot(IIIILnet/minecraft/client/renderer/Tessellator;)V",
            at = @At(value = "INVOKE",
                     target = "Lnet/minecraft/client/gui/FontRenderer;trimStringToWidth(Ljava/lang/String;I)Ljava/lang/String;",
                     ordinal = 5),
            index = 0,
            remap = true
    )
    private String drawSlot$childMods(String text) {
        if (text.contains("Metadata not found")) {
            return I18n.format("fml.mod.metadata.notfound");
        }
        String numChildMods = text.substring(0, text.indexOf(" "));
        return numChildMods + " " + (numChildMods.equals("1") ? I18n.format("fml.mod.metadata.child") : I18n.format("fml.mod.metadata.childs"));
    }
}
