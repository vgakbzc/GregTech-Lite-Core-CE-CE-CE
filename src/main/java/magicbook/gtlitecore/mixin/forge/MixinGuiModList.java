package magicbook.gtlitecore.mixin.forge;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.client.GuiModList;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@SuppressWarnings("all")
@Mixin(GuiModList.class)
public abstract class MixinGuiModList {

    @Shadow(remap = false)
    private ModContainer selectedMod;

    @ModifyArg(
            method = "initGui()V",
            at = @At(value = "INVOKE",
                     target = "Ljava/util/List;add(Ljava/lang/Object;)Z",
                     ordinal = 1),
            remap = true
    )
    private Object initGui$configButton(Object button) {
        ((GuiButton) button).displayString = I18n.format("fml.button.config");
        return button;
    }

    @ModifyArg(
            method = "initGui()V",
            at = @At(value = "INVOKE",
                     target = "Ljava/util/List;add(Ljava/lang/Object;)Z",
                     ordinal = 2),
            remap = true
    )
    private Object initGui$disableButton(Object button) {
        ((GuiButton)button).displayString = I18n.format("fml.button.disable");
        return button;
    }

    @ModifyArg(
            method = "drawScreen(IIF)V",
            at = @At(value = "INVOKE",
                     target = "Lnet/minecraftforge/fml/client/GuiModList;drawCenteredString(Lnet/minecraft/client/gui/FontRenderer;Ljava/lang/String;III)V"),
            index = 1,
            remap = true
    )
    private String drawScreen(String modList) {
        return I18n.format("fml.menu.mods.modlist");
    }

    @ModifyArg(
            method = "updateCache()V",
            at = @At(
                    value = "INVOKE",
                    target = "Ljava/util/List;add(Ljava/lang/Object;)Z",
                    ordinal = 0
            ),
            remap = false
    )
    private Object updateCache$Name(Object e) {
        return TextFormatting.GREEN + (String)e;
    }

    @ModifyArg(
            method = "updateCache()V",
            at = @At(value = "INVOKE",
                     target = "Ljava/util/List;add(Ljava/lang/Object;)Z",
                     ordinal = 1),
            remap = false
    )
    private Object updateCache$version(Object e) {
        return I18n.format("fml.mod.details.version", selectedMod.getDisplayVersion(), selectedMod.getVersion() );
    }

    @ModifyArg(
            method = "updateCache()V",
            at = @At(value = "INVOKE",
                     target = "Ljava/util/List;add(Ljava/lang/Object;)Z",
                     ordinal = 2),
            remap = false
    )
    private Object updateCache$modid(Object e) {
        return I18n.format("fml.mod.details.modid", selectedMod.getModId(), Loader.instance().getModState(selectedMod).toString());
    }

    @ModifyArg(
            method = "updateCache()V",
            at = @At(value = "INVOKE",
                     target = "Ljava/util/List;add(Ljava/lang/Object;)Z",
                     ordinal = 3),
            remap = false
    )
    private Object updateCache$credits(Object e) {
        return I18n.format("fml.mod.details.credits", (I18n.hasKey(selectedMod.getMetadata().credits) ? I18n.format(selectedMod.getMetadata().credits) : selectedMod.getMetadata().credits));
    }

    @ModifyArg(
            method = "updateCache()V",
            at = @At(value = "INVOKE",
                     target = "Ljava/util/List;add(Ljava/lang/Object;)Z",
                     ordinal = 4),
            remap = false
    )
    private Object updateCache$author(Object e) {
        return I18n.format("fml.mod.details.authors", selectedMod.getMetadata().getAuthorList());
    }

    @ModifyArg(
            method = "updateCache()V",
            at = @At(value = "INVOKE",
                     target = "Ljava/util/List;add(Ljava/lang/Object;)Z",
                     ordinal = 5),
            remap = false
    )
    private Object updateCache$URL(Object e) {
        return I18n.format("fml.mod.details.url", selectedMod.getMetadata().url);
    }

    @ModifyArg(
            method = "updateCache()V",
            at = @At(value = "INVOKE",
                     target = "Ljava/util/List;add(Ljava/lang/Object;)Z",
                     ordinal = 6),
            remap = false
    )
    private Object updateCache$noChildmods(Object e) {
        return I18n.format("fml.mod.details.nochildmods");
    }

    @ModifyArg(
            method = "updateCache()V",
            at = @At(value = "INVOKE",
                     target = "Ljava/util/List;add(Ljava/lang/Object;)Z",
                     ordinal = 7),
            remap = false
    )
    private Object updateCache$childmods(Object e) {
        return I18n.format("fml.mod.details.childmods", selectedMod.getMetadata().getChildModList() + TextFormatting.WHITE);
    }

    @ModifyArg(
            method = "updateCache()V",
            at = @At(value = "INVOKE",
                     target = "Ljava/util/List;add(Ljava/lang/Object;)Z",
                     ordinal = 8),
            remap = false
    )
    private Object updateCache$updateAvailable(Object e) {
        if (e instanceof String) {
            String vercheckURL = (String)e;
            return I18n.format("fml.mod.details.updateavailable", vercheckURL.replace("Update Available: ", ""));
        }
        return e;
    }

    @ModifyArg(
            method = "updateCache()V",
            at = @At(value = "INVOKE",
                     target = "Ljava/util/List;add(Ljava/lang/Object;)Z",
                     ordinal = 10),
            remap = false
    )
    private Object updateCache$description(Object e) {
        return (I18n.hasKey(selectedMod.getMetadata().description) ? I18n.format(selectedMod.getMetadata().description) : selectedMod.getMetadata().description);
    }

    @ModifyArg(
            method = "updateCache()V",
            at = @At(value = "INVOKE",
                     target = "Ljava/util/List;add(Ljava/lang/Object;)Z",
                     ordinal = 12),
            remap = false
    )
    private Object updateCache$autoGeneratedVersion(Object e) {
        return I18n.format("fml.mod.details.autogenerated.version", selectedMod.getVersion());
    }

    @ModifyArg(
            method = "updateCache()V",
            at = @At(value = "INVOKE",
                     target = "Ljava/util/List;add(Ljava/lang/Object;)Z",
                     ordinal = 13),
            remap = false
    )
    private Object updateCache$autoGeneratedModState(Object e) {
        return I18n.format("fml.mod.details.autogenerated.modstate", Loader.instance().getModState(selectedMod).toString());
    }

    @ModifyArg(
            method = "updateCache()V",
            at = @At(value = "INVOKE",
                     target = "Ljava/util/List;add(Ljava/lang/Object;)Z",
                     ordinal = 14),
            remap = false
    )
    private Object updateCache$updateAvailable2(Object e) {
        if (e instanceof String) {
            String vercheckURL = (String)e;
            return I18n.format("fml.mod.details.updateavailable", vercheckURL.replace("Update Available: ", ""));
        }
        return e;
    }

    @ModifyArg(
            method = "updateCache()V",
            at = @At(value = "INVOKE",
                     target = "Ljava/util/List;add(Ljava/lang/Object;)Z",
                     ordinal = 16),
            remap = false
    )
    private Object updateCache$autoGeneratedNoModInfo(Object e) {
        return TextFormatting.RED + I18n.format("fml.mod.details.autogenerated.nomodinfo");
    }

    @ModifyArg(
            method = "updateCache()V",
            at = @At(
                    value = "INVOKE",
                    target = "Ljava/util/List;add(Ljava/lang/Object;)Z",
                    ordinal = 17
            ),
            remap = false
    )
    private Object updateCache$autoGeneratedAskAuthor(Object e) {
        return TextFormatting.RED + I18n.format("fml.mod.details.autogenerated.askauthor");
    }

    @ModifyArg(
            method = "updateCache()V",
            at = @At(value = "INVOKE",
                     target = "Ljava/util/List;add(Ljava/lang/Object;)Z",
                     ordinal = 19),
            remap = false
    )
    private Object updateCache$updateChanges(Object e) {
        return I18n.format("fml.mod.details.updatechanges");
    }
}
