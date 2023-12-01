package magicbook.gtlitecore.common.items;

import gregtech.api.items.metaitem.MetaItem;

import java.util.List;

public class GTLiteMetaItems {
    public static final List<MetaItem<?>> ITEMS = GTLiteMetaItems1.getMetaItems();

    //  Boards
    public static MetaItem<?>.MetaValueItem GOOWARE_BOARD;
    public static MetaItem<?>.MetaValueItem OPTICAL_BOARD;
    public static MetaItem<?>.MetaValueItem SPINTRONIC_BOARD;
    public static MetaItem<?>.MetaValueItem MAGNETO_RESONATIC_BOARD;

    //  Circuit Boards
    public static MetaItem<?>.MetaValueItem GOOWARE_CIRCUIT_BOARD;
    public static MetaItem<?>.MetaValueItem OPTICAL_CIRCUIT_BOARD;
    public static MetaItem<?>.MetaValueItem SPINTRONIC_CIRCUIT_BOARD;
    public static MetaItem<?>.MetaValueItem MAGNETO_RESONATIC_CIRCUIT_BOARD;

    //  Circuits
    public static MetaItem<?>.MetaValueItem GOOWARE_PROCESSOR;
    public static MetaItem<?>.MetaValueItem GOOWARE_ASSEMBLY;
    public static MetaItem<?>.MetaValueItem GOOWARE_COMPUTER;
    public static MetaItem<?>.MetaValueItem GOOWARE_MAINFRAME;
    public static MetaItem<?>.MetaValueItem OPTICAL_PROCESSOR;
    public static MetaItem<?>.MetaValueItem OPTICAL_ASSEMBLY;
    public static MetaItem<?>.MetaValueItem OPTICAL_COMPUTER;
    public static MetaItem<?>.MetaValueItem OPTICAL_MAINFRAME;
    public static MetaItem<?>.MetaValueItem SPINTRONIC_PROCESSOR;
    public static MetaItem<?>.MetaValueItem SPINTRONIC_ASSEMBLY;
    public static MetaItem<?>.MetaValueItem SPINTRONIC_COMPUTER;
    public static MetaItem<?>.MetaValueItem SPINTRONIC_MAINFRAME;
    public static MetaItem<?>.MetaValueItem COSMIC_PROCESSOR;
    public static MetaItem<?>.MetaValueItem COSMIC_ASSEMBLY;
    public static MetaItem<?>.MetaValueItem COSMIC_COMPUTER;
    public static MetaItem<?>.MetaValueItem COSMIC_MAINFRAME;
    public static MetaItem<?>.MetaValueItem SUPRACAUSAL_PROCESSOR;
    public static MetaItem<?>.MetaValueItem SUPRACAUSAL_ASSEMBLY;
    public static MetaItem<?>.MetaValueItem SUPRACAUSAL_COMPUTER;
    public static MetaItem<?>.MetaValueItem SUPRACAUSAL_MAINFRAME;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_CIRCUIT_ULV;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_CIRCUIT_LV;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_CIRCUIT_MV;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_CIRCUIT_HV;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_CIRCUIT_EV;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_CIRCUIT_IV;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_CIRCUIT_LuV;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_CIRCUIT_ZPM;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_CIRCUIT_UV;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_CIRCUIT_UHV;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_CIRCUIT_UEV;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_CIRCUIT_UIV;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_CIRCUIT_UXV;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_CIRCUIT_OpV;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_CIRCUIT_MAX;
    public static MetaItem<?>.MetaValueItem MAGNETO_RESONATIC_CIRCUIT_ULV;
    public static MetaItem<?>.MetaValueItem MAGNETO_RESONATIC_CIRCUIT_LV;
    public static MetaItem<?>.MetaValueItem MAGNETO_RESONATIC_CIRCUIT_MV;
    public static MetaItem<?>.MetaValueItem MAGNETO_RESONATIC_CIRCUIT_HV;
    public static MetaItem<?>.MetaValueItem MAGNETO_RESONATIC_CIRCUIT_EV;
    public static MetaItem<?>.MetaValueItem MAGNETO_RESONATIC_CIRCUIT_IV;
    public static MetaItem<?>.MetaValueItem MAGNETO_RESONATIC_CIRCUIT_LuV;
    public static MetaItem<?>.MetaValueItem MAGNETO_RESONATIC_CIRCUIT_ZPM;
    public static MetaItem<?>.MetaValueItem MAGNETO_RESONATIC_CIRCUIT_UV;
    public static MetaItem<?>.MetaValueItem MAGNETO_RESONATIC_CIRCUIT_UHV;
    public static MetaItem<?>.MetaValueItem MAGNETO_RESONATIC_CIRCUIT_UEV;
    public static MetaItem<?>.MetaValueItem MAGNETO_RESONATIC_CIRCUIT_UIV;
    public static MetaItem<?>.MetaValueItem MAGNETO_RESONATIC_CIRCUIT_UXV;
    public static MetaItem<?>.MetaValueItem MAGNETO_RESONATIC_CIRCUIT_OpV;
    public static MetaItem<?>.MetaValueItem MAGNETO_RESONATIC_CIRCUIT_MAX;

    //  Boules and Wafers
    public static MetaItem<?>.MetaValueItem NANO_PIC_WAFER;
    public static MetaItem<?>.MetaValueItem NANO_PIC_CHIP;
    public static MetaItem<?>.MetaValueItem PICO_PIC_WAFER;
    public static MetaItem<?>.MetaValueItem PICO_PIC_CHIP;
    public static MetaItem<?>.MetaValueItem FEMTO_PIC_WAFER;
    public static MetaItem<?>.MetaValueItem FEMTO_PIC_CHIP;
    public static MetaItem<?>.MetaValueItem DUBNIUM_BOULE;
    public static MetaItem<?>.MetaValueItem DUBNIUM_WAFER;

    //  Voltage Coils
    public static MetaItem<?>.MetaValueItem VOLTAGE_COIL_UHV;
    public static MetaItem<?>.MetaValueItem VOLTAGE_COIL_UEV;
    public static MetaItem<?>.MetaValueItem VOLTAGE_COIL_UIV;
    public static MetaItem<?>.MetaValueItem VOLTAGE_COIL_UXV;
    public static MetaItem<?>.MetaValueItem VOLTAGE_COIL_OpV;

    //  Others
    public static MetaItem<?>.MetaValueItem GRINDBALL_SOAPSTONE;
    public static MetaItem<?>.MetaValueItem GRINDBALL_ALUMINIUM;

    private GTLiteMetaItems() {}

    public static void init() {
        GTLiteMetaItems1 item1 = new GTLiteMetaItems1();
    }

    public static void initSubItems() {
        GTLiteMetaItems1.registerItems();
    }
}
