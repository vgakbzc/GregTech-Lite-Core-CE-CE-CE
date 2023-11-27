package magicbook.gtlitecore.common.items;

import gregtech.api.items.metaitem.MetaItem;

import java.util.List;

public class GTLiteMetaItems {
    public static final List<MetaItem<?>> ITEMS = GTLiteMetaItems1.getMetaItems();

    //  Boards
    public static MetaItem<?>.MetaValueItem GOOWARE_BOARD;
    public static MetaItem<?>.MetaValueItem OPTICAL_BOARD;
    public static MetaItem<?>.MetaValueItem SPINTRONIC_BOARD;

    //  Circuit Boards
    public static MetaItem<?>.MetaValueItem GOOWARE_CIRCUIT_BOARD;
    public static MetaItem<?>.MetaValueItem OPTICAL_CIRCUIT_BOARD;
    public static MetaItem<?>.MetaValueItem SPINTRONIC_CIRCUIT_BOARD;

    private GTLiteMetaItems() {}

    public static void init() {
        GTLiteMetaItems1 item1 = new GTLiteMetaItems1();
    }

    public static void initSubItems() {
        GTLiteMetaItems1.registerItems();
    }
}
