package magicbook.gtlitecore.common.items.behaviors.renderer;

import codechicken.lib.model.ModelRegistryHelper;
import codechicken.lib.util.TransformUtils;
import magicbook.gtlitecore.api.item.IHaloRenderBehavior;
import magicbook.gtlitecore.client.renderer.handler.HaloItemRenderer;
import magicbook.gtlitecore.mixin.gregtech.MixinMetaItem;
import magicbook.gtlitecore.mixin.gregtech.MixinMetaPrefixItem;
import magicbook.gtlitecore.mixin.gregtech.MixinMetaValueItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.function.Supplier;

/**
 * Halo Render Item Behavior.
 *
 * @author Gate Guardian
 *
 * <p>
 *     This Item Behavior is a Extended Renderer adder of Meta Item (in GregTech),
 *     used {@link HaloItemRenderer} to add a halo to item (and same effect for Meta Value/Prefix Item).
 *     Thanks my friend tong-ge fix problem of {@link #getHaloTexture()}.
 * </p>
 *
 * @see HaloItemRenderer
 * @see MixinMetaItem
 * @see MixinMetaValueItem
 * @see MixinMetaPrefixItem
 *
 * @since 2.7.4-beta
 */
public class HaloRenderItemBehavior implements IHaloRenderBehavior {

    private final int haloSize;
    private final int haloColour;
    private final Supplier<?> supplier;
    private final boolean drawPulse;

    public HaloRenderItemBehavior(int haloSize,
                                  int haloColour,
                                  Supplier<?> supplier,
                                  boolean drawPulse) {
        this.haloSize = haloSize;
        this.haloColour = haloColour;
        this.supplier = supplier;
        this.drawPulse = drawPulse;
    }

    @Override
    public boolean shouldDrawHalo() {
        return true;
    }

    /**
     * Halo Texture Getter.
     *
     * @return Halo Texture.
     */
    @SideOnly(Side.CLIENT)
    @Override
    public TextureAtlasSprite getHaloTexture() {
        return (TextureAtlasSprite) supplier.get();
    }

    /**
     * Halo Color Getter.
     *
     * @return Color of Halo.
     */
    @Override
    public int getHaloColour() {
        return haloColour;
    }

    /**
     * Halo Size Getter.
     *
     * @return Size of Halo.
     */
    @Override
    public int getHaloSize() {
        return haloSize;
    }

    @Override
    public boolean shouldDrawPulse() {
        return drawPulse;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void onRendererRegistry(ResourceLocation location) {
        ModelRegistryHelper.register(new ModelResourceLocation(location, "inventory"), new HaloItemRenderer(TransformUtils.DEFAULT_ITEM, modelRegistry -> modelRegistry.getObject(new ModelResourceLocation(location, "inventory"))));
    }
}
