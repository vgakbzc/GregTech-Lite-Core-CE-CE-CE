package magicbook.gtlitecore.common.items.behaviors.renderer;

import codechicken.lib.model.ModelRegistryHelper;
import codechicken.lib.util.TransformUtils;
import magicbook.gtlitecore.api.item.ICosmicRenderBehavior;
import magicbook.gtlitecore.client.renderer.handler.CosmicItemRenderer;
import magicbook.gtlitecore.mixin.gregtech.MixinMetaItem;
import magicbook.gtlitecore.mixin.gregtech.MixinMetaPrefixItem;
import magicbook.gtlitecore.mixin.gregtech.MixinMetaValueItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.jetbrains.annotations.Nullable;
import java.util.function.Supplier;

/**
 * Cosmic Render Item Behavior.
 *
 * @author Gate Guardian
 *
 * <p>
 *     This Item Behavior is a Extended Renderer adder of Meta Item (in GregTech),
 *     used {@link CosmicItemRenderer} to add a mask to item (and same effect for Meta Value/Prefix Item).
 *     Thanks my friend tong-ge fix problem of {@link #getMaskTexture(ItemStack, EntityLivingBase)}.
 * </p>
 *
 * @see CosmicItemRenderer
 * @see MixinMetaItem
 * @see MixinMetaValueItem
 * @see MixinMetaPrefixItem
 *
 * @since 2.7.4-beta
 */
public class CosmicRenderItemBehavior implements ICosmicRenderBehavior {

    private final Supplier<?> supplier;
    private final int maskOpacity;

    public CosmicRenderItemBehavior(Supplier<TextureAtlasSprite> supplier,
                                    int maskOpacity) {
        this.supplier = supplier;
        this.maskOpacity = maskOpacity;
    }

    /**
     * Mask Texture Getter.
     *
     * @param stack   The stack being rendered.
     * @param player  The entity holding the item, May be null, If null assume either inventory, or ground.
     * @return        Mask Texture.
     */
    @SideOnly(Side.CLIENT)
    @Override
    public TextureAtlasSprite getMaskTexture(ItemStack stack,
                                             @Nullable EntityLivingBase player) {
        return (TextureAtlasSprite) supplier.get();
    }

    /**
     * Mask Opacity Getter.
     *
     * @param stack   The stack being rendered.
     * @param player  The entity holding the item, May be null, If null assume either inventory, or ground.
     * @return        Mask Opacity.
     */
    @Override
    public float getMaskOpacity(ItemStack stack,
                                @Nullable EntityLivingBase player) {
        return maskOpacity;
    }

    @Override
    public void onRendererRegistry(ResourceLocation location) {
        ModelRegistryHelper.register(new ModelResourceLocation(location, "inventory"), new CosmicItemRenderer(TransformUtils.DEFAULT_ITEM, modelRegistry -> modelRegistry.getObject(new ModelResourceLocation(location, "inventory"))));
    }
}