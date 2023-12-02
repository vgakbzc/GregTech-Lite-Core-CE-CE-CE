package magicbook.gtlitecore.common.items;

import gregtech.api.items.metaitem.StandardMetaItem;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.ore.OrePrefix;
import magicbook.gtlitecore.api.GTLiteAPI;
import magicbook.gtlitecore.common.items.behaviors.GrindBallBehavior;

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
        MAGNETO_RESONATIC_BOARD = this.addItem(3, "board.magneto_resonatic");

        //  Circuit Boards
        GOOWARE_CIRCUIT_BOARD = this.addItem(4, "circuit_board.gooware");
        OPTICAL_CIRCUIT_BOARD = this.addItem(5, "circuit_board.optical");
        SPINTRONIC_CIRCUIT_BOARD = this.addItem(6, "circuit_board.spintronic");
        MAGNETO_RESONATIC_CIRCUIT_BOARD = this.addItem(7, "circuit_board.magneto_resonatic");

        //  Circuits
        GOOWARE_PROCESSOR = this.addItem(8, "circuit.gooware_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.ZPM);
        GOOWARE_ASSEMBLY = this.addItem(9, "circuit.gooware_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UV);
        GOOWARE_COMPUTER = this.addItem(10, "circuit.gooware_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV);
        GOOWARE_MAINFRAME = this.addItem(11, "circuit.gooware_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);
        OPTICAL_PROCESSOR = this.addItem(12, "circuit.optical_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UV);
        OPTICAL_ASSEMBLY = this.addItem(13, "circuit.optical_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV);
        OPTICAL_COMPUTER = this.addItem(14, "circuit.optical_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);
        OPTICAL_MAINFRAME = this.addItem(15, "circuit.optical_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);
        SPINTRONIC_PROCESSOR = this.addItem(16, "circuit.spintronic_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV);
        SPINTRONIC_ASSEMBLY = this.addItem(17, "circuit.spintronic_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);
        SPINTRONIC_COMPUTER = this.addItem(18, "circuit.spintronic_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);
        SPINTRONIC_MAINFRAME = this.addItem(19, "circuit.spintronic_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV);
        COSMIC_PROCESSOR = this.addItem(20, "circuit.cosmic_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);
        COSMIC_ASSEMBLY = this.addItem(21, "circuit.cosmic_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);
        COSMIC_COMPUTER = this.addItem(22, "circuit.cosmic_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV);
        COSMIC_MAINFRAME = this.addItem(23, "circuit.cosmic_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.OpV);
        SUPRACAUSAL_PROCESSOR = this.addItem(24, "circuit.supracausal_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);
        SUPRACAUSAL_ASSEMBLY = this.addItem(25, "circuit.supracausal_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV);
        SUPRACAUSAL_COMPUTER = this.addItem(26, "circuit.supracausal_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.OpV);
        SUPRACAUSAL_MAINFRAME = this.addItem(27, "circuit.supracausal_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.MAX);
        SUPRACHRONAL_CIRCUIT_ULV = this.addItem(28, "circuit.suprachronal.ulv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.ULV);
        SUPRACHRONAL_CIRCUIT_LV = this.addItem(29, "circuit.suprachronal.lv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.LV);
        SUPRACHRONAL_CIRCUIT_MV = this.addItem(30, "circuit.suprachronal.mv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.MV);
        SUPRACHRONAL_CIRCUIT_HV = this.addItem(31, "circuit.suprachronal.hv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.HV);
        SUPRACHRONAL_CIRCUIT_EV = this.addItem(32, "circuit.suprachronal.ev").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.EV);
        SUPRACHRONAL_CIRCUIT_IV = this.addItem(33, "circuit.suprachronal.iv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.IV);
        SUPRACHRONAL_CIRCUIT_LuV = this.addItem(34, "circuit.suprachronal.luv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.LuV);
        SUPRACHRONAL_CIRCUIT_ZPM = this.addItem(35, "circuit.suprachronal.zpm").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.ZPM);
        SUPRACHRONAL_CIRCUIT_UV = this.addItem(36, "circuit.suprachronal.uv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UV);
        SUPRACHRONAL_CIRCUIT_UHV = this.addItem(37, "circuit.suprachronal.uhv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV);
        SUPRACHRONAL_CIRCUIT_UEV = this.addItem(38, "circuit.suprachronal.uev").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);
        SUPRACHRONAL_CIRCUIT_UIV = this.addItem(39, "circuit.suprachronal.uiv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);
        SUPRACHRONAL_CIRCUIT_UXV = this.addItem(40, "circuit.suprachronal.uxv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV);
        SUPRACHRONAL_CIRCUIT_OpV = this.addItem(41, "circuit.suprachronal.opv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.OpV);
        SUPRACHRONAL_CIRCUIT_MAX = this.addItem(42, "circuit.suprachronal.max").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.MAX);
        MAGNETO_RESONATIC_CIRCUIT_ULV = this.addItem(43, "circuit.magneto_resonatic.ulv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.ULV);
        MAGNETO_RESONATIC_CIRCUIT_LV = this.addItem(44, "circuit.magneto_resonatic.lv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.LV);
        MAGNETO_RESONATIC_CIRCUIT_MV = this.addItem(45, "circuit.magneto_resonatic.mv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.MV);
        MAGNETO_RESONATIC_CIRCUIT_HV = this.addItem(46, "circuit.magneto_resonatic.hv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.HV);
        MAGNETO_RESONATIC_CIRCUIT_EV = this.addItem(47, "circuit.magneto_resonatic.ev").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.EV);
        MAGNETO_RESONATIC_CIRCUIT_IV = this.addItem(48, "circuit.magneto_resonatic.iv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.IV);
        MAGNETO_RESONATIC_CIRCUIT_LuV = this.addItem(49, "circuit.magneto_resonatic.luv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.LuV);
        MAGNETO_RESONATIC_CIRCUIT_ZPM = this.addItem(50, "circuit.magneto_resonatic.zpm").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.ZPM);
        MAGNETO_RESONATIC_CIRCUIT_UV = this.addItem(51, "circuit.magneto_resonatic.uv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UV);
        MAGNETO_RESONATIC_CIRCUIT_UHV = this.addItem(52, "circuit.magneto_resonatic.uhv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV);
        MAGNETO_RESONATIC_CIRCUIT_UEV = this.addItem(53, "circuit.magneto_resonatic.uev").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);
        MAGNETO_RESONATIC_CIRCUIT_UIV = this.addItem(54, "circuit.magneto_resonatic.uiv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);
        MAGNETO_RESONATIC_CIRCUIT_UXV = this.addItem(55, "circuit.magneto_resonatic.uxv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV);
        MAGNETO_RESONATIC_CIRCUIT_OpV = this.addItem(56, "circuit.magneto_resonatic.opv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.OpV);
        MAGNETO_RESONATIC_CIRCUIT_MAX = this.addItem(57, "circuit.magneto_resonatic.max").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.MAX);



        //  Boules and Wafers
        NANO_PIC_WAFER = this.addItem(200, "wafer.nano_pic");
        NANO_PIC_CHIP = this.addItem(201, "wafer.chip.nano_pic");
        PICO_PIC_WAFER = this.addItem(202, "wafer.pico_pic");
        PICO_PIC_CHIP = this.addItem(203, "wafer.chip.pico_pic");
        FEMTO_PIC_WAFER = this.addItem(204, "wafer.femto_pic");
        FEMTO_PIC_CHIP = this.addItem(205, "wafer.chip.femto_pic");
        DUBNIUM_BOULE = this.addItem(206, "boule.dubnium");
        DUBNIUM_WAFER = this.addItem(207, "wafer.dubnium");

        //  Voltage Coils
        VOLTAGE_COIL_UHV = this.addItem(250, "voltage_coil.uhv");
        VOLTAGE_COIL_UEV = this.addItem(251, "voltage_coil.uev");
        VOLTAGE_COIL_UIV = this.addItem(252, "voltage_coil.uiv");
        VOLTAGE_COIL_UXV = this.addItem(253, "voltage_coil.uxv");
        VOLTAGE_COIL_OpV = this.addItem(254, "voltage_coil.opv");

        //  Others
        GRINDBALL_SOAPSTONE = this.addItem(300, "grindball.soapstone").setMaxStackSize(1).addComponents(new GrindBallBehavior());
        GRINDBALL_ALUMINIUM = this.addItem(301, "grindball.aluminium").setMaxStackSize(1).addComponents(new GrindBallBehavior());
        COMPONENT_GRINDER_BORON_NITRIDE = this.addItem(302, "component.grinder.boron_nitride");

        MAGNETRON = this.addItem(310, "magnetron");
    }
}
