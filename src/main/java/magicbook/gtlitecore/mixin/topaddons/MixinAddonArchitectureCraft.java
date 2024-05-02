package magicbook.gtlitecore.mixin.topaddons;

import com.elytradev.architecture.common.shape.EnumShape;
import io.github.drmanganese.topaddons.addons.AddonArchitectureCraft;
import magicbook.gtlitecore.api.utils.Translator;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(value = AddonArchitectureCraft.class, remap = false)
public class MixinAddonArchitectureCraft {

    /**
     * Overwrites the same name method (@code {#getShapeName(ItemStack)})
     * in original class {@link AddonArchitectureCraft}.
     * 
     * @author IntegerLimit
     *
     * @reason It uses the old Shape Class. Overwriting instead of Injecting will hopefully make sure the class does NOT
     *         get loaded, causing a {@code ClassNotFoundException}.
     */
    @Overwrite
    private static String getShapeName(ItemStack stack) {
        var compound = stack.getTagCompound();
        return Translator.translate(EnumShape.forId(compound == null ? 0 : compound.getInteger("Shape")).translationKey);
    }
}