package magicbook.gtlitecore.common.items;

import gregtech.api.GTValues;
import gregtech.api.GregTechAPI;
import gregtech.api.items.metaitem.ElectricStats;
import gregtech.api.items.metaitem.StandardMetaItem;
import gregtech.api.items.metaitem.stats.IItemComponent;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.items.behaviors.ProspectorScannerBehavior;
import gregtech.common.items.behaviors.TooltipBehavior;
import magicbook.gtlitecore.api.GTLiteAPI;
import magicbook.gtlitecore.common.items.behaviors.GrindBallBehavior;
import magicbook.gtlitecore.common.items.behaviors.StructureWriterBehavior;
import net.minecraft.client.resources.I18n;

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

        //  SMDs
        OPTICAL_TRANSISTOR = this.addItem(58, "component.optical_smd.transistor");
        OPTICAL_RESISTOR = this.addItem(59, "component.optical_smd.resistor");
        OPTICAL_CAPACITOR = this.addItem(60, "component.optical_smd.capacitor");
        OPTICAL_DIODE = this.addItem(61, "component.optical_smd.diode");
        OPTICAL_INDUCTOR = this.addItem(62, "component.optical_smd.inductor");
        SPINTRONIC_TRANSISTOR = this.addItem(63, "component.spintronic_smd.transistor");
        SPINTRONIC_RESISTOR = this.addItem(64, "component.spintronic_smd.resistor");
        SPINTRONIC_CAPACITOR = this.addItem(65, "component.spintronic_smd.capacitor");
        SPINTRONIC_DIODE = this.addItem(66, "component.spintronic_smd.diode");
        SPINTRONIC_INDUCTOR = this.addItem(67, "component.spintronic_smd.inductor");
        COSMIC_TRANSISTOR = this.addItem(68, "component.cosmic_smd.transistor");
        COSMIC_RESISTOR = this.addItem(69, "component.cosmic_smd.resistor");
        COSMIC_CAPACITOR = this.addItem(70, "component.cosmic_smd.capacitor");
        COSMIC_DIODE = this.addItem(71, "component.cosmic_smd.diode");
        COSMIC_INDUCTOR = this.addItem(72, "component.cosmic_smd.inductor");
        SUPRACAUSAL_TRANSISTOR = this.addItem(73, "component.supracausal_smd.transistor");
        SUPRACAUSAL_RESISTOR = this.addItem(74, "component.supracausal_smd.resistor");
        SUPRACAUSAL_CAPACITOR = this.addItem(75, "component.supracausal_smd.capacitor");
        SUPRACAUSAL_DIODE = this.addItem(76, "component.supracausal_smd.diode");
        SUPRACAUSAL_INDUCTOR = this.addItem(77, "component.supracausal_smd.inductor");

        //  Circuit Components
        BZ_REACTION_CHAMBER = this.addItem(78, "component.gooware.reaction_chamber");
        NONLINEAR_CHEMICAL_OSCILLATOR = this.addItem(79, "component.gooware.nonlinear_chemical_oscillator");
        OPTICAL_LASER_CONTROL_UNIT = this.addItem(80, "component.optical.optical_laser_control_unit");
        ESR_COMPUTATION_UNIT = this.addItem(81, "component.spintronic.esr_computation_unit");
        COSMIC_INFORMATION_MODULE = this.addItem(82, "component.cosmic.information_module");
        HOLOGRAPHIC_INFORMATION_IMC = this.addItem(83, "component.cosmic.holographic_imc");
        SPACETIME_CONDENSER = this.addItem(84, "component.supracausal.spacetime_condenser");
        LIGHT_CONE_MODULE = this.addItem(85, "component.supracausal.light_cone_module");
        OPTICAL_FIBER = this.addItem(86, "component.optical.optical_fiber");
        DIELECTRIC_MIRROR = this.addItem(87, "component.optical.dielectric_mirror");
        EMPTY_LASER_ASSEMBLY = this.addItem(88, "component.optical.emitter.empty");
        HELIUM_NEON_LASER = this.addItem(89, "component.optical.emitter.helium_neon");
        ND_YAG_LASER = this.addItem(90, "component.optical.emitter.nd_yag");
        TOPOLOGICAL_INSULATOR_TUBE = this.addItem(91, "component.spintronic.topological_insulator");
        BOSE_EINSTEIN_CONDENSATE_CONTAINMENT_UNIT = this.addItem(92, "component.spintronic.bose_einstein_condensate_containment_unit");
        BOSE_EINSTEIN_CONDENSATE = this.addItem(93, "component.spintronic.bose_einstein_condensate");
        CLADDED_OPTICAL_FIBER_CORE = this.addItem(94, "component.cosmic.cladded_optical_fiber_core");
        CLOSED_TIMELIKE_CURVE_COMPUTATIONAL_UNIT = this.addItem(95, "component.cosmic.closed_timelike_curve_computational_unit");
        CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT = this.addItem(96, "component.cosmic.closed_timelike_curve_guidance_unit");
        NUCLEAR_CLOCK = this.addItem(97, "component.cosmic.nuclear_clock");
        MANIFOLD_OSCILLATORY_POWER_CELL = this.addItem(98, "component.cosmic.manifold_oscillatory_power_cell");
        SCINTILLATOR = this.addItem(99, "component.cosmic.scintillator");
        SCINTILLATOR_CRYSTAL = this.addItem(100, "component.cosmic.scintillator_crystal");
        TOPOLOGICAL_MANIPULATOR_UNIT = this.addItem(101, "component.supracausal.topological_manipulator_unit");
        GRAVITON_TRANSDUCER = this.addItem(102, "component.supracausal.graviton_transducer");
        RELATIVISTIC_SPINORIAL_MEMORY_SYSTEM = this.addItem(103, "component.supracausal.relativistic_spinorial_memory_system");
        MACROWORMHOLE_GENERATOR = this.addItem(104, "component.supracausal.macrowormhole_generator");
        MICROWORMHOLE_GENERATOR = this.addItem(105, "component.supracausal.microwormhole_generator");
        STABILIZED_WORMHOLE_GENERATOR = this.addItem(106, "component.supracausal.stabilized_wormhole_generator");
        EIGENFOLDED_SPACETIME_MANIFOLD = this.addItem(107, "component.supracausal.eigenfolded_space_time_manifold");
        RECURSIVELY_FOLDED_NEGATIVE_SPACE = this.addItem(108, "component.supracausal.recursively_folded_negative_space");

        BIO_CELL = this.addItem(120, "component.gooware.bio_cell");
        BIO_DISH = this.addItem(121, "component.gooware.bio_dish");

        VACUUM_TUBE_COMPONENT = this.addItem(149, "component.primitive.vacuum_tube_component");
        DIAMOND_CHIP = this.addItem(150, "component.crystal.diamond_chip");
        RUBY_CHIP = this.addItem(151, "component.crystal.ruby_chip");
        SAPPHIRE_CHIP = this.addItem(152, "component.crystal.sapphire_chip");
        DIAMOND_MODULATOR = this.addItem(153, "component.crystal.diamond_modulator");
        RUBY_MODULATOR = this.addItem(154, "component.crystal.ruby_modulator");
        SAPPHIRE_MODULATOR = this.addItem(155, "component.crystal.sapphire_modulator");
        CRYSTAL_SOC_SOCKET = this.addItem(156, "component.crystal.system_on_chip_socket");

        //  Boules and Wafers
        NANO_PIC_WAFER = this.addItem(200, "wafer.nano_pic");
        NANO_PIC_CHIP = this.addItem(201, "wafer.chip.nano_pic");
        PICO_PIC_WAFER = this.addItem(202, "wafer.pico_pic");
        PICO_PIC_CHIP = this.addItem(203, "wafer.chip.pico_pic");
        FEMTO_PIC_WAFER = this.addItem(204, "wafer.femto_pic");
        FEMTO_PIC_CHIP = this.addItem(205, "wafer.chip.femto_pic");
        DUBNIUM_BOULE = this.addItem(206, "boule.dubnium");
        DUBNIUM_WAFER = this.addItem(207, "wafer.dubnium");
        PHASE_CHANGE_MEMORY = this.addItem(208, "wafer.chip.phase_change_memory");
        OPTICAL_NOR_MEMORY_CHIP = this.addItem(209, "wafer.chip.optical_nor_memory_chip");
        SPIN_TRANSFER_TORQUE_MEMORY = this.addItem(210, "wafer.chip.spin_transfer_torque_memory");
        SPINTRONIC_NAND_MEMORY_CHIP = this.addItem(211, "wafer.chip.spintronic_nand_memory_chip");
        UNTREATED_COSMIC_CPU = this.addItem(212, "wafer.untreated_cosmic_cpu");
        COSMIC_CPU = this.addItem(213, "wafer.cosmic_cpu");
        COSMIC_CPU_CHIP = this.addItem(214, "wafer.chip.cosmic_cpu");
        COSMIC_MEMORY_CHIP = this.addItem(215, "wafer.chip.cosmic_memory");

        UHASOC_WAFER = this.addItem(218, "wafer.uhasoc");
        UHASOC_CHIP = this.addItem(219, "wafer.chip.uhasoc");
        CUBIC_ZIRCONIA_EUROPIUM_BOULE = this.addItem(220, "boule.cubic_zirconia.europium");
        CUBIC_ZIRCONIA_EUROPIUM_WAFER = this.addItem(221, "wafer.cubic_zirconia.europium");
        CRYSTAL_INTERFACE_WAFER = this.addItem(222, "wafer.crystal_interface");
        CRYSTAL_INTERFACE_CHIP = this.addItem(223, "wafer.chip.crystal_interface");
        INTRAVITAL_SOC = this.addItem(224, "component.gooware.intravital_soc");
        STRONTIUM_CARBONATE_BOHRIUM_BOULE = this.addItem(225, "boule.strontium_carbonate.bohrium");
        STRONTIUM_CARBONATE_BOHRIUM_WAFER = this.addItem(226, "wafer.strontium_carbonate.bohrium");
        STRONTIUM_CARBONATE_OPTICAL_WAFER = this.addItem(227, "component.optical.strontium_carbonate_wafer");
        OPTICAL_IMC_BOARD = this.addItem(228, "component.optical.optical_imc_board");
        PHOTOELECTRON_SOC = this.addItem(229, "component.optical.photoelectron_soc");

        //  Voltage Coils
        VOLTAGE_COIL_UHV = this.addItem(250, "voltage_coil.uhv");
        VOLTAGE_COIL_UEV = this.addItem(251, "voltage_coil.uev");
        VOLTAGE_COIL_UIV = this.addItem(252, "voltage_coil.uiv");
        VOLTAGE_COIL_UXV = this.addItem(253, "voltage_coil.uxv");
        VOLTAGE_COIL_OpV = this.addItem(254, "voltage_coil.opv");

        //  Covers
        ELECTRIC_MOTOR_ULV = this.addItem(255, "cover.electric_motor.ulv");
        ELECTRIC_PISTON_ULV = this.addItem(256, "cover.electric_piston.ulv");
        ELECTRIC_PUMP_ULV = this.addItem(257, "cover.electric_pump.ulv");
        CONVEYOR_MODULE_ULV = this.addItem(258, "cover.conveyor_module.ulv");
        ROBOT_ARM_ULV = this.addItem(259, "cover.robot_arm.ulv");
        EMITTER_ULV = this.addItem(260, "cover.emitter.ulv");
        SENSOR_ULV = this.addItem(261, "cover.sensor.ulv");
        FIELD_GENERATOR_ULV = this.addItem(262, "cover.field_generator.ulv");
        ELECTRIC_MOTOR_MAX = this.addItem(263, "cover.electric_motor.max");
        ELECTRIC_PISTON_MAX = this.addItem(264, "cover.electric_piston.max");
        ELECTRIC_PUMP_MAX = this.addItem(265, "cover.electric_pump.max");
        CONVEYOR_MODULE_MAX = this.addItem(266, "cover.conveyor_module.max");
        ROBOT_ARM_MAX = this.addItem(267, "cover.robot_arm.max");
        EMITTER_MAX = this.addItem(268, "cover.emitter.max");
        SENSOR_MAX = this.addItem(269, "cover.sensor.max");
        FIELD_GENERATOR_MAX = this.addItem(270, "cover.field_generator.max");
        //  Free Id: 270-275 for UHV-OpV Solar Panels
        COVER_SOLAR_PANEL_MAX = this.addItem(276, "cover.solar_panel.max").addComponents(new TooltipBehavior((lines) -> {
            lines.add(I18n.format("metaitem.cover.solar.panel.tooltip.1"));
            lines.add(I18n.format("metaitem.cover.solar.panel.tooltip.2"));
            lines.add(I18n.format("gregtech.universal.tooltip.voltage_out", GTValues.V[GTValues.MAX], GTValues.VNF[GTValues.MAX]));}));

        //  Tools
        PROSPECTOR_EV = this.addItem(280, "tool.prospector.ev").addComponents(new IItemComponent[]{ElectricStats.createElectricItem(500000000L, 4), new ProspectorScannerBehavior(5, 4)}).setMaxStackSize(1).setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);
        PROSPECTOR_ZPM = this.addItem(281, "tool.prospector.zpm").addComponents(new IItemComponent[]{ElectricStats.createElectricItem(4000000000L, 7), new ProspectorScannerBehavior(7, 7)}).setMaxStackSize(1).setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);

        BATTERY_HULL_SMALL_LITHIUM_SULFIDE = this.addItem(285, "battery.hull.uhv");
        BATTERY_HULL_MEDIUM_LITHIUM_SULFIDE = this.addItem(286, "battery.hull.uev");
        BATTERY_HULL_LARGE_LITHIUM_SULFIDE = this.addItem(287, "battery.hull.uiv");
        BATTERY_HULL_SMALL_LANTHANUM_NICKEL_OXIDE = this.addItem(288, "battery.hull.uxv");
        BATTERY_HULL_MEDIUM_LANTHANUM_NICKEL_OXIDE = this.addItem(289, "battery.hull.opv");
        BATTERY_HULL_LARGE_LANTHANUM_NICKEL_OXIDE = this.addItem(290, "battery.hull.max");
        BATTERY_UHV_LITHIUM_SULFIDE = this.addItem(291, "battery.uhv.lithium_sulfide").addComponents(new IItemComponent[]{ElectricStats.createRechargeableBattery(10485760000L, 9)}).setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.UHV).setModelAmount(8).setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);
        BATTERY_UEV_LITHIUM_SULFIDE = this.addItem(292, "battery.uev.lithium_sulfide").addComponents(new IItemComponent[]{ElectricStats.createRechargeableBattery(41943040000L, 10)}).setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.UEV).setModelAmount(8).setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);
        BATTERY_UIV_LITHIUM_SULFIDE = this.addItem(293, "battery.uiv.lithium_sulfide").addComponents(new IItemComponent[]{ElectricStats.createRechargeableBattery(167772160000L, 11)}).setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.UIV).setModelAmount(8).setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);
        BATTERY_UXV_LANTHANUM_NICKEL_OXIDE = this.addItem(294, "battery.uxv.lanthanum_nickel_oxide").addComponents(new IItemComponent[]{ElectricStats.createRechargeableBattery(671088640000L, 12)}).setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.UXV).setModelAmount(8).setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);
        BATTERY_OpV_LANTHANUM_NICKEL_OXIDE = this.addItem(295, "battery.opv.lanthanum_nickel_oxide").addComponents(new IItemComponent[]{ElectricStats.createRechargeableBattery(2684354560000L, 13)}).setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.OpV).setModelAmount(8).setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);
        BATTERY_MAX_LANTHANUM_NICKEL_OXIDE = this.addItem(296, "battery.max.lanthanum_nickel_oxide").addComponents(new IItemComponent[]{ElectricStats.createRechargeableBattery(10737418240000L, 14)}).setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.MAX).setModelAmount(8).setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);

        //  Others
        GRINDBALL_SOAPSTONE = this.addItem(300, "grindball.soapstone").setMaxStackSize(1).addComponents(new GrindBallBehavior());
        GRINDBALL_ALUMINIUM = this.addItem(301, "grindball.aluminium").setMaxStackSize(1).addComponents(new GrindBallBehavior());
        COMPONENT_GRINDER_BORON_NITRIDE = this.addItem(302, "component.grinder.boron_nitride");
        COMPONENT_GRINDER_BLACK_PLUTONIUM = this.addItem(303, "component.grinder.black_plutonium");
        QCD_PROTECTIVE_PLATING = this.addItem(304, "qcd_protective_plating");
        CARBON_ALLOTROPE_MIXTURE = this.addItem(305, "mixture.carbon_allotrope");
        GRAPHENE_ALIGNED_CNT = this.addItem(306, "cnt.graphene_aligned");
        UNSTABLE_STAR = this.addItem(307, "unstable_star");
        ZENITH_STAR = this.addItem(308, "zenith_star");
        QUANTUM_ANOMALY = this.addItem(309, "quantum_anomaly");
        MAGNETRON = this.addItem(310, "magnetron");
        SEPARATION_ELECTROMAGNET = this.addItem(311, "separation_electromagnet");
        COSMIC_FABRIC = this.addItem(312, "cosmic_fabric");
        MEMORY_FOAM_PLATE = this.addItem(313, "memory_foam_plate");
        FULLERENE_FIBER = this.addItem(314, "highly_insulating_fullerene_foil");
        HYPERDIMENSIONAL_DRONE = this.addItem(315, "hyperdimensional_drone");
        HYPERDIMENSIONAL_OSCILLATING_MATTER = this.addItem(316, "hyperdimensional_oscillating_matter");
        CHROMATIC_LENS = this.addItem(317, "chromatic_lens").addOreDict("craftingLensChromatic");
        NEUTRONIUM_SPHERE = this.addItem(318, "neutronium_sphere");
        TRIPLET_NEUTRONIUM_SPHERE = this.addItem(319, "triplet_neutronium_sphere");
        MINING_DRONE_LV = this.addItem(320, "mining_drone.lv");
        MINING_DRONE_MV = this.addItem(321, "mining_drone.mv");
        MINING_DRONE_HV = this.addItem(322, "mining_drone.hv");
        MINING_DRONE_EV = this.addItem(323, "mining_drone.ev");
        MINING_DRONE_IV = this.addItem(324, "mining_drone.iv");
        MINING_DRONE_LuV = this.addItem(325, "mining_drone.luv");
        MINING_DRONE_ZPM = this.addItem(326, "mining_drone.zpm");
        MINING_DRONE_UV = this.addItem(327, "mining_drone.uv");
        MINING_DRONE_UHV = this.addItem(328, "mining_drone.uhv");
        MINING_DRONE_UEV = this.addItem(329, "mining_drone.uev");
        MINING_DRONE_UIV = this.addItem(330, "mining_drone.uiv");
        MINING_DRONE_UXV = this.addItem(331, "mining_drone.uxv");
        MINING_DRONE_OpV = this.addItem(332, "mining_drone.opv");
        MINING_DRONE_MAX = this.addItem(333, "mining_drone.max");

        //  High Energy Physics Items
        PLASMA_CONTAINMENT_CELL = this.addItem(350, "plasma_containment_cell");
        RHENIUM_PLASMA_CONTAINMENT_CELL = this.addItem(351, "rhenium_plasma_containment_cell");
        NEUTRON_PLASMA_CONTAINMENT_CELL = this.addItem(352, "neutron_plasma_containment_cell");
        EXTREMELY_DURABLE_PLASMA_CONTAINMENT_CELL = this.addItem(353, "extremely_durable_plasma_containment_cell");
        DENSE_NEUTRON_PLASMA_CONTAINMENT_CELL = this.addItem(354, "dense_neutron_plasma_containment_cell");
        COSMIC_NEUTRON_PLASMA_CONTAINMENT_CELL = this.addItem(355, "cosmic_neutron_plasma_containment_cell");
        TIME_DILATION_CONTAINMENT_UNIT = this.addItem(356, "time_dilation_containment_unit");
        CONTAINED_RN_SINGULARITY = this.addItem(357, "contained_reissner_nordstrom_singularity");
        CONTAINED_KN_SINGULARITY = this.addItem(358, "contained_kerr_newmann_singularity");
        CONTAINED_KERR_SINGULARITY = this.addItem(359, "contained_kerr_singularity");
        CONTAINED_HIGH_DENSITY_PROTONIC_MATTER = this.addItem(360, "contained_high_density_protonic_matter");
        CONTAINED_EXOTIC_MATTER = this.addItem(361, "contained_exotic_matter");
        CHARGED_TRIPLET_NEUTRONIUM_SPHERE = this.addItem(362, "charged_triplet_neutronium_sphere");
        COSMIC_FABRIC_PLASMA_CONTAINMENT_CELL = this.addItem(363, "cosmic_fabric_plasma_containment_cell").addComponents(new TooltipBehavior((lines) -> {
            lines.add(I18n.format("metaitem.cosmic_fabric_plasma_containment_cell.tooltip.1"));
            lines.add(I18n.format("metaitem.cosmic_fabric_plasma_containment_cell.tooltip.2"));
            lines.add(I18n.format("metaitem.cosmic_fabric_plasma_containment_cell.tooltip.3"));
        }));

        //  Algae
        BARNARDA_C_BASE = this.addItem(370, "alga.barnarda_c.base");
        BARNARDA_C_CHLORELLA = this.addItem(371, "alga.barnarda_c.chlorella").addOreDict("dyePurple");
        BARNARDA_C_BRYOPSIS_HYPNOIDES = this.addItem(372, "alga.barnarda_c.bryopsis_hypnoides").addOreDict("dyeGreen");
        BARNARDA_C_ZOOXANTHELLAE = this.addItem(373, "alga.barnarda_c.zooxanthellae").addOreDict("dyeOrange");
        TAU_CETI_F_BASE = this.addItem(374, "alga.tau_ceti_f.base");
        TAU_CETI_F_SCENEDESMUS_OBLIQUUS = this.addItem(375, "alga.tau_ceti_f.scenedesmus_obliquus").addOreDict("dyeLime");
        TAU_CETI_F_PHAEOPHYTA = this.addItem(376, "alga.tau_ceti_f.phaeophyta").addOreDict("dyeBrown");
        TAU_CETI_F_SPIRULINA = this.addItem(377, "alga.tau_ceti_f.spirulina").addOreDict("dyeBlue");
        PROXIMA_B_BASE = this.addItem(378, "alga.proxima_b.base");
        PROXIMA_B_CONCHOSPORE = this.addItem(379, "alga.proxima_b.conchospore").addOreDict("dyeRed");
        PROXIMA_B_POLYSIPHONIA_SENTICULOSA = this.addItem(380, "alga.proxima_b.polysiphonia_senticulosa").addOreDict("dyeYellow");
        PROXIMA_B_SPIROGYRA = this.addItem(381, "alga.proxima_b.spirogyra").addOreDict("dyeGray");

        //  Memory Cards
        MEMORY_CARD_BASE = this.addItem(385, "memory_card.base");
        MEMORY_CARD_ZOMBIE = this.addItem(386, "memory_card.zombie");
        MEMORY_CARD_SKELETON = this.addItem(387, "memory_card.skeleton");
        MEMORY_CARD_CREEPER = this.addItem(388, "memory_card.creeper");
        MEMORY_CARD_SPIDER = this.addItem(389, "memory_card.spider");
        MEMORY_CARD_SLIME = this.addItem(390, "memory_card.slime");
        MEMORY_CARD_WITCH = this.addItem(391, "memory_card.witch");
        MEMORY_CARD_GUARDIAN = this.addItem(392, "memory_card.guardian");
        MEMORY_CARD_ENDERMAN = this.addItem(393, "memory_card.enderman");
        MEMORY_CARD_WITHER_SKELETON = this.addItem(394, "memory_card.wither_skeleton");
        MEMORY_CARD_BLAZE = this.addItem(395, "memory_card.blaze");
        MEMORY_CARD_GHAST = this.addItem(396, "memory_card.ghast");
        MEMORY_CARD_SHULKER = this.addItem(397, "memory_card.shulker");
        MEMORY_CARD_WITHER = this.addItem(398, "memory_card.wither");
        MEMORY_CARD_ENDER_DRAGON = this.addItem(399, "memory_card.ender_dragon");

        //  Particles
        ALPHA_PARTICLE = this.addItem(400, "particle.alpha");

        //  Wrap Items
        WRAP_CIRCUIT_ULV = this.addItem(500, "wrap.circuit.ulv");
        WRAP_CIRCUIT_LV = this.addItem(501, "wrap.circuit.lv");
        WRAP_CIRCUIT_MV = this.addItem(502, "wrap.circuit.mv");
        WRAP_CIRCUIT_HV = this.addItem(503, "wrap.circuit.hv");
        WRAP_CIRCUIT_EV = this.addItem(504, "wrap.circuit.ev");
        WRAP_CIRCUIT_IV = this.addItem(505, "wrap.circuit.iv");
        WRAP_CIRCUIT_LuV = this.addItem(506, "wrap.circuit.luv");
        WRAP_CIRCUIT_ZPM = this.addItem(507, "wrap.circuit.zpm");
        WRAP_CIRCUIT_UV = this.addItem(508, "wrap.circuit.uv");
        WRAP_CIRCUIT_UHV = this.addItem(509, "wrap.circuit.uhv");
        WRAP_CIRCUIT_UEV = this.addItem(510, "wrap.circuit.uev");
        WRAP_CIRCUIT_UIV = this.addItem(511, "wrap.circuit.uiv");
        WRAP_CIRCUIT_UXV = this.addItem(512, "wrap.circuit.uxv");
        WRAP_CIRCUIT_OpV = this.addItem(513, "wrap.circuit.opv");
        WRAP_CIRCUIT_MAX = this.addItem(514, "wrap.circuit.max");

        //  Singularities
        MAGIC_SINGULARITY = this.addItem(800, "singularity.magic");
        METRIC_SINGULARITY = this.addItem(801, "singularity.metric");
        EXOTIC_SINGULARITY = this.addItem(802, "singularity.exotic");
        ANCIENT_SINGULARITY = this.addItem(803, "singularity.ancient");
        VOID_SINGULARITY = this.addItem(804, "singularity.void");
        EIGEN_SINGULARITY = this.addItem(805, "singularity.eigen");
        WEIRD_SINGULARITY = this.addItem(806, "singularity.weird");

        //  Debug Items
        STRUCTURE_WRITER = this.addItem(10000, "debug.structure_writer").addComponents(StructureWriterBehavior.INSTANCE);
    }
}
