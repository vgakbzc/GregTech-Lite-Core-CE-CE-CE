package magicbook.gtlitecore.common.items.behaviors;

import gregtech.common.items.MetaItems;
import gregtech.common.items.behaviors.DataItemBehavior;
import magicbook.gtlitecore.common.items.behaviors.renderer.DataRenderItemBehavior;

public class GTLiteBehaviorAddition {

    public static void init() {
        MetaItems.TOOL_DATA_STICK.addComponents(new DataItemBehavior(), new DataRenderItemBehavior());
        MetaItems.TOOL_DATA_ORB.addComponents(new DataItemBehavior(), new DataRenderItemBehavior());
        MetaItems.TOOL_DATA_MODULE.addComponents(new DataItemBehavior(), new DataRenderItemBehavior());
    }
}
