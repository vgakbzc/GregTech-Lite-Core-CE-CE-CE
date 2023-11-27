package magicbook.gtlitecore.api;

import gregtech.api.util.BaseCreativeTab;
import gregtech.common.items.MetaItems;

public class GTLiteAPI {

    //  Creative Tab
    public static final BaseCreativeTab TAB_GTLITE = new BaseCreativeTab("gtlite", () -> {
        return MetaItems.BASIC_TAPE.getStackForm();
    }, true);
}
