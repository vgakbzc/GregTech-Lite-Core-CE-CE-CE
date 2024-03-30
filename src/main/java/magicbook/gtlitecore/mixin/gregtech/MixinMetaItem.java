package magicbook.gtlitecore.mixin.gregtech;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.util.GTUtility;
import magicbook.gtlitecore.api.item.IItemRenderer;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/**
 * @author Gate Guardian
 *
 * @since 2.8.7-beta
 */
@Mixin(value = MetaItem.class, remap = false)
public abstract class MixinMetaItem extends Item {

    /**
     * @param metaValueItem  Meta item in {@link gregtech.api.items.metaitem.MetaItem.MetaValueItem}.
     * @return               Model path of meta item.
     */
    @Shadow
    protected abstract String formatModelPath(MetaItem<?>.MetaValueItem metaValueItem);

    /**
     *
     * @param metaItem       Meta item.
     * @param metaValueItem  Meta value item, used to find model path.
     * @param postfix        Postfix of item, used to add path.
     * @return               Item model, but has an extended renderer.
     *
     * @reason  Used to add extended renderer to gregtech materials.
     */
    @Redirect(
            method = "registerModels()V",
            at = @At(
                    value = "INVOKE",
                    target = "Lgregtech/api/items/metaitem/MetaItem;createItemModelPath(Lgregtech/api/items/metaitem/MetaItem$MetaValueItem;Ljava/lang/String;)Lnet/minecraft/util/ResourceLocation;"
            )
    )
    private ResourceLocation registerModels(MetaItem<?> metaItem,
                                            MetaItem<?>.MetaValueItem metaValueItem,
                                            String postfix) {
        ResourceLocation resourceLocation = GTUtility.gregtechId(this.formatModelPath(metaValueItem) + postfix);
        IItemRenderer itemRenderer = (IItemRenderer) metaValueItem;
        if (itemRenderer.getRendererManager() != null) {
            itemRenderer.getRendererManager().onRendererRegistry(resourceLocation);
        }
        return resourceLocation;
    }
}
