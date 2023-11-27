package magicbook.gtlitecore.common.items;

import gregtech.api.items.metaitem.StandardMetaItem;
import magicbook.gtlitecore.api.GTLiteAPI;

import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class GTLiteMetaItems1 extends StandardMetaItem {
    public GTLiteMetaItems1() {
        this.setRegistryName("gtlite_meta_item_1");
        setCreativeTab(GTLiteAPI.TAB_GTLITE);
    }

    public void registerSubItems() {

        //  Boards
        GOOWARE_BOARD = this.addItem(0, "board.gooware");
        OPTICAL_BOARD = this.addItem(1, "board.optical");
        SPINTRONIC_BOARD = this.addItem(2, "board.spintronic");

        //  Circuit Boards
        GOOWARE_CIRCUIT_BOARD = this.addItem(3, "circuit_board.gooware");
        OPTICAL_CIRCUIT_BOARD = this.addItem(4, "circuit_board.optical");
        SPINTRONIC_CIRCUIT_BOARD = this.addItem(5, "circuit_board.spintronic");

    }
}
