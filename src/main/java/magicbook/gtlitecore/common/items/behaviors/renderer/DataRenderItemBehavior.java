package magicbook.gtlitecore.common.items.behaviors.renderer;

import codechicken.lib.model.ModelRegistryHelper;
import codechicken.lib.util.TransformUtils;
import magicbook.gtlitecore.api.item.IItemRendererManager;
import magicbook.gtlitecore.client.renderer.handler.DataItemRenderer;
import magicbook.gtlitecore.common.GTLiteConfigHolder;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;

/**
 * Data Render Item Behavior
 *
 * @author Gate Guardian
 *
 * <p>
 *     This Item Behavior is a Extended Renderer adder of Meta Item (in GregTech),
 *     used {@link DataItemRenderer} to add a extended info of data item,
 *     such as Data Stick/Orb and Module. This renderere init by another bus,
 *     and can use {@code enableDataItemRenderer} in {@link GTLiteConfigHolder#compats}
 *     to enable/disable this function (todo seems cause server crash).
 * </p>
 *
 * @since 2.8.7-beta
 */
public class DataRenderItemBehavior implements IItemRendererManager {

    @Override
    public void onRendererRegistry(ResourceLocation location) {
        ModelRegistryHelper.register(new ModelResourceLocation(location, "inventory"), new DataItemRenderer(TransformUtils.DEFAULT_ITEM, modelRegistry -> modelRegistry.getObject(new ModelResourceLocation(location, "inventory"))));
    }
}
