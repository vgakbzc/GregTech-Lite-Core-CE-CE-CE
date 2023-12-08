package magicbook.gtlitecore.loaders;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.BlockMachineCasing;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.loaders.recipe.CraftingComponent;
import gregtech.loaders.recipe.MetaTileEntityLoader;
import magicbook.gtlitecore.common.blocks.*;

import static gregicality.multiblocks.api.unification.GCYMMaterials.*;
import static gregicality.multiblocks.common.metatileentities.GCYMMetaTileEntities.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gregtech.common.metatileentities.MetaTileEntities.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;
import static magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities.*;

public class MachineRecipeLoader {
    public static void init() {
        SingleMachineRecipes();
        MultiblockControllerRecipes();
        MachineCasingRecipes();
    }

    private static void SingleMachineRecipes() {

        //  Chemical Dryer
        MetaTileEntityLoader.registerMachineRecipe(true, CHEMICAL_DRYER,
                "WCW", "SHS", "WCW",
                'W', CraftingComponent.CABLE,
                'C', CraftingComponent.CIRCUIT,
                'S', CraftingComponent.SPRING,
                'H', CraftingComponent.HULL);

        //  TODO Steam Vacuum Chamber

        //  Vacuum Chamber
        MetaTileEntityLoader.registerMachineRecipe(true, VACUUM_CHAMBER,
                "GCG", "PHP", "GWG",
                'W', CraftingComponent.CABLE,
                'C', CraftingComponent.CIRCUIT,
                'P', CraftingComponent.PUMP,
                'G', CraftingComponent.GLASS,
                'H', CraftingComponent.HULL);

        //  Naquadah Reactor
        MetaTileEntityLoader.registerMachineRecipe(true, NAQUADAH_REACTOR,
                "RCR", "FHF", "WCW",
                'R', CraftingComponent.STICK_RADIOACTIVE,
                'C', CraftingComponent.CIRCUIT,
                'F', CraftingComponent.FIELD_GENERATOR,
                'W', CraftingComponent.CABLE,
                'H', CraftingComponent.HULL);

        //  Rocket Engine
        MetaTileEntityLoader.registerMachineRecipe(true, ROCKET_ENGINE,
                "PXP", "MHM", "DWD",
                'P', CraftingComponent.PISTON,
                'X', CraftingComponent.CIRCUIT,
                'M', CraftingComponent.MOTOR,
                'H', CraftingComponent.HULL,
                'D', CraftingComponent.DOUBLE_PLATE,
                'W', CraftingComponent.CABLE);

        //  Component Assembler
        MetaTileEntityLoader.registerMachineRecipe(true, COMPONENT_ASSEMBLER,
                "PPP", "CHR", "WXW",
                'P', CraftingComponent.PLATE,
                'H', CraftingComponent.HULL,
                'C', CraftingComponent.CONVEYOR,
                'R', CraftingComponent.ROBOT_ARM,
                'W', CraftingComponent.CABLE,
                'X', CraftingComponent.CIRCUIT);
    }

    private static void MultiblockControllerRecipes() {

        //  Industrial Drilling Reg
        ModHandler.addShapedRecipe(true, "industrial_drilling_reg", INDUSTRIAL_DRILLING_REG.getStackForm(),
                "PKP", "CHC", "MMM",
                'P', ELECTRIC_PISTON_UV.getStackForm(),
                'K', new UnificationEntry(cableGtQuadruple, YttriumBariumCuprate),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.UHV),
                'H', HULL[UV].getStackForm(),
                'M', ELECTRIC_MOTOR_UV.getStackForm());

        //  Catalytic Reformer
        ModHandler.addShapedRecipe(true, "catalytic_reformer", CATALYTIC_REFORMER.getStackForm(),
                "MCM", "PHP", "MKM",
                'M', new UnificationEntry(pipeNormalFluid, StainlessSteel),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.IV),
                'P', ELECTRIC_PUMP_EV.getStackForm(),
                'H', HULL[EV].getStackForm(),
                'K', new UnificationEntry(cableGtDouble, Aluminium));

        //  Sonicator
        ModHandler.addShapedRecipe(true, "sonicator", SONICATOR.getStackForm(),
                "LFL", "PHP", "CPC",
                'L', new UnificationEntry(pipeLargeFluid, Naquadah),
                'F', FIELD_GENERATOR_UV.getStackForm(),
                'P', ELECTRIC_PUMP_UV.getStackForm(),
                'H', HULL[UV].getStackForm(),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.UV));

        //  Hydraulic Fracker
        ModHandler.addShapedRecipe(true, "fracker", HYDRAULIC_FRACKER.getStackForm(),
                "CLC", "GHG", "PPP",
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.UV),
                'L', new UnificationEntry(pipeLargeFluid, Naquadah),
                'G', new UnificationEntry(gear, NaquadahAlloy),
                'H', HULL[ZPM].getStackForm(),
                'P', ELECTRIC_PUMP_ZPM.getStackForm());

        //  Nanoscale Fabricator
        ModHandler.addShapedRecipe(true, "nanoscale_fabricator", NANOSCALE_FABRICATOR.getStackForm(),
                "KSK", "EHE", "CFC",
                'K', new UnificationEntry(cableGtSingle, Europium),
                'S', SENSOR_UHV.getStackForm(),
                'E', EMITTER_UHV.getStackForm(),
                'H', HULL[UHV].getStackForm(),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.UEV),
                'F', FIELD_GENERATOR_UHV.getStackForm());

        //  Roaster
        ModHandler.addShapedRecipe(true, "roaster", INDUSTRIAL_ROASTER.getStackForm(),
                "KSK", "CHC", "PPP",
                'K', new UnificationEntry(cableGtQuadruple, Platinum),
                'S', new UnificationEntry(spring, Tungsten),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.EV),
                'H', HULL[EV].getStackForm(),
                'P', new UnificationEntry(plate, TitaniumCarbide));

        //  Crystallization Crucible
        ModHandler.addShapedRecipe(true, "crystallization_crucible", CRYSTALLIZATION_CRUCIBLE.getStackForm(),
                "CMC", "LHL", "PCP",
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.IV),
                'M', new UnificationEntry(plateDouble, MolybdenumDisilicide),
                'L', new UnificationEntry(pipeNormalFluid, Titanium),
                'H', HULL[EV].getStackForm(),
                'P', new UnificationEntry(plate, Titanium));

        //  CVD Unit
        ModHandler.addShapedRecipe(true, "cvd_unit", CVD_UNIT.getStackForm(),
                "PKP", "CHC", "ESE",
                'P', new UnificationEntry(plate, BlueSteel),
                'K', new UnificationEntry(cableGtSingle, Aluminium),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.EV),
                'H', HULL[EV].getStackForm(),
                'S', SENSOR_EV.getStackForm(),
                'E', EMITTER_EV.getStackForm());

        //  Plasma CVD Unit
        ModHandler.addShapedRecipe(true, "plasma_cvd_unit", PLASMA_CVD_UNIT.getStackForm(),
                "PKP", "CHC", "ESE",
                'P', new UnificationEntry(plate, Vibranium),
                'K', new UnificationEntry(cableGtSingle, SiliconCarbide),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.UEV),
                'H', HULL[UHV].getStackForm(),
                'S', SENSOR_UHV.getStackForm(),
                'E', EMITTER_UHV.getStackForm());

        //  Laser CVD Unit
        ModHandler.addShapedRecipe(true, "laser_cvd_unit", LASER_CVD_UNIT.getStackForm(),
                "EOE", "CHC", "PPP",
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.UEV),
                'H', HULL[UHV].getStackForm(),
                'P', new UnificationEntry(plate, Orichalcum),
                'E', EMITTER_UHV.getStackForm(),
                'O', OPTICAL_FIBER.getStackForm()
        );

        //  Burner Reactor
        ModHandler.addShapedRecipe(true, "burner_reactor", BURNER_REACTOR.getStackForm(),
                "KRK", "IHI", "CMC",
                'K', new UnificationEntry(cableGtSingle, Platinum),
                'R', new UnificationEntry(rotor, TungstenSteel),
                'I', new UnificationEntry(pipeSmallFluid, Tungsten),
                'H', HULL[IV].getStackForm(),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.IV),
                'M', ELECTRIC_MOTOR_IV.getStackForm());

        //  Cryogenic Reactor
        ModHandler.addShapedRecipe(true, "cryogenic_reactor", CRYOGENIC_REACTOR.getStackForm(),
                "KRK", "IHI", "CWC",
                'K', new UnificationEntry(cableGtSingle, Platinum),
                'R', new UnificationEntry(rotor, Titanium),
                'I', new UnificationEntry(pipeSmallFluid, StainlessSteel),
                'H', HULL[IV].getStackForm(),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.IV),
                'W', ELECTRIC_PUMP_IV.getStackForm());

        //  Large Naquadah Reactor
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(NAQUADAH_REACTOR[3])
                .input(frameGt, Naquadria, 2)
                .input(ELECTRIC_PUMP_UHV, 2)
                .input(FIELD_GENERATOR_UHV, 2)
                .input(plate, Tritanium, 4)
                .input(circuit, MarkerMaterials.Tier.UHV, 4)
                .input(ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 16)
                .input(wireGtQuadruple, YttriumBariumCuprate, 4)
                .fluidInputs(Orichalcum.getFluid(L * 4))
                .output(LARGE_NAQUADAH_REACTOR)
                .EUt(VA[UHV])
                .duration(600)
                .buildAndRegister();

        //  TODO Isa Mill

        //  TODO Flotation Cell Regulator

        //  TODO Vacuum Drying Furnace

        //  Volcanus
        ModHandler.addShapedRecipe(true, "volcanus", VOLCANUS.getStackForm(),
                "GXG", "RHR", "PWP",
                'G', new UnificationEntry(gear, HSSG),
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.LuV),
                'H', ELECTRIC_BLAST_FURNACE.getStackForm(),
                'R', ROBOT_ARM_IV.getStackForm(),
                'P', new UnificationEntry(plate, AusteniticStainlessSteel904L),
                'W', VOLTAGE_COIL_IV.getStackForm());

        //  Cryogenic Freezer
        ModHandler.addShapedRecipe(true, "cryogenic_freezer", CRYOGENIC_FREEZER.getStackForm(),
                "SXS", "EHE", "PWP",
                'S', new UnificationEntry(spring, HSSG),
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.LuV),
                'H', VACUUM_FREEZER.getStackForm(),
                'E', ELECTRIC_PUMP_IV.getStackForm(),
                'P', new UnificationEntry(plate, TanmolyiumBetaC),
                'W', new UnificationEntry(cableGtSingle, Platinum));

        //  Fuel Refine Factory
        ModHandler.addShapedRecipe(true, "fuel_refine_factory", FUEL_REFINE_FACTORY.getStackForm(),
                "RFR", "CHC", "PWP",
                'H', MetaTileEntities.HULL[UHV].getStackForm(),
                'P', ELECTRIC_PUMP_UHV,
                'F', new UnificationEntry(pipeHugeFluid, Duranium),
                'R', new UnificationEntry(rotor, Orichalcum),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.UHV),
                'W', new UnificationEntry(cableGtQuadruple, SiliconCarbide));

        //  Ion Implantator
        ModHandler.addShapedRecipe(true, "ion_implantator", ION_IMPLANTATOR.getStackForm(),
                "WCW", "EHP", "WKW",
                'E', EMITTER_UHV.getStackForm(),
                'P', ELECTRIC_PUMP_UHV.getStackForm(),
                'H', HULL[UHV].getStackForm(),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.UHV),
                'K', new UnificationEntry(cableGtSingle, Europium),
                'W', new UnificationEntry(plate, Adamantium));

        //  Unmanned Drone Airport
        ModHandler.addShapedRecipe(true, "unmanned_drone_airport", UNMANNED_DRONE_AIRPORT.getStackForm(),
                "PDP", "CHC", "WWW",
                'H', HULL[HV].getStackForm(),
                'D', MINING_DRONE_HV.getStackForm(),
                'C', CONVEYOR_MODULE_HV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Gold),
                'P', new UnificationEntry(plate, StainlessSteel));

        //  Space Elevator
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[UV])
                .input(frameGt, Pikyonium64B, 4)
                .input(MINING_DRONE_UV, 8)
                .input(plate, Tritanium, 16)
                .input(UNMANNED_DRONE_AIRPORT, 16)
                .input(GRAVITATION_ENGINE, 8)
                .input(CONVEYOR_MODULE_UV, 16)
                .input(ROBOT_ARM_UV, 16)
                .input(gear, Cinobite, 3)
                .input(gearSmall, TitanSteel, 6)
                .input(POWER_THRUSTER_ADVANCED, 32)
                .input(WIRELESS, 64)
                .input(wireGtSingle, EnrichedNaquadahTriniumEuropiumDuranide, 16)
                .fluidInputs(SolderingAlloy.getFluid(128000))
                .fluidInputs(Lubricant.getFluid(300000))
                .fluidInputs(MethylhydrazineNitrateRocketFuel.getFluid(16000))
                .fluidInputs(DenseHydrazineMixtureFuel.getFluid(16000))
                .output(SPACE_ELEVATOR)
                .stationResearch(b -> b
                        .researchStack(UNMANNED_DRONE_AIRPORT.getStackForm())
                        .CWUt(256)
                        .EUt(VA[UV]))
                .EUt(VA[UV])
                .duration(1200)
                .buildAndRegister();

        //  Fusion Reactor Mk IV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.FUSION_COIL_MK2))
                .input(circuit, MarkerMaterials.Tier.UEV, 4)
                .input(GRAVI_STAR)
                .input(plateDouble, Dubnium)
                .input(FIELD_GENERATOR_UV, 2)
                .input(NANO_PIC_CHIP, 64)
                .input(NANO_PIC_CHIP, 64)
                .input(wireGtSingle, PedotPSS, 32)
                .fluidInputs(SolderingAlloy.getFluid(2304))
                .fluidInputs(Europium.getFluid(2304))
                .fluidInputs(Polyetheretherketone.getFluid(L * 4))
                .output(ADVANCED_FUSION_REACTOR[0])
                .EUt(VA[UV])
                .duration(1000)
                .stationResearch(b -> b
                        .researchStack(FUSION_REACTOR[2].getStackForm())
                        .CWUt(192)
                        .EUt(VA[UHV]))
                .buildAndRegister();

        //  Fusion Reactor Mk V
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.FUSION_COIL_MK3))
                .input(circuit, MarkerMaterials.Tier.UIV, 4)
                .input(UNSTABLE_STAR)
                .input(plateDouble, Livermorium)
                .input(FIELD_GENERATOR_UHV, 2)
                .input(PICO_PIC_CHIP, 64)
                .input(PICO_PIC_CHIP, 64)
                .input(wireGtSingle, QuantumAlloy, 32)
                .fluidInputs(SolderingAlloy.getFluid(4608))
                .fluidInputs(Americium.getFluid(4608))
                .fluidInputs(Kevlar.getFluid(L * 4))
                .output(ADVANCED_FUSION_REACTOR[1])
                .EUt(VA[UHV])
                .duration(1000)
                .stationResearch(b -> b
                        .researchStack(ADVANCED_FUSION_REACTOR[0].getStackForm())
                        .CWUt(384)
                        .EUt(VA[UEV]))
                .buildAndRegister();

        //  Precise Assembler
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(LARGE_ASSEMBLER.getStackForm())
                .input(frameGt, MARM200Steel, 4)
                .input(ROBOT_ARM_IV, 2)
                .input(CONVEYOR_MODULE_IV, 2)
                .input(plate, Stellite100, 4)
                .input(gear, TanmolyiumBetaC, 4)
                .input(cableGtQuadruple, Naquadah, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 6))
                .fluidInputs(Lubricant.getFluid(3000))
                .fluidInputs(HastelloyN.getFluid(L * 2))
                .outputs(PRECISE_ASSEMBLER.getStackForm())
                .scannerResearch(b -> b
                        .researchStack(LARGE_ASSEMBLER.getStackForm())
                        .EUt(VA[IV])
                        .duration(1200))
                .EUt(VA[LuV])
                .duration(1200)
                .buildAndRegister();

        //  Component Assembly Line
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ASSEMBLY_LINE)
                .input(frameGt, Cinobite, 4)
                .input(PRECISE_ASSEMBLER, 4)
                .input(COMPONENT_ASSEMBLER[IV], 16)
                .input(ROBOT_ARM_UV, 4)
                .input(CONVEYOR_MODULE_UV, 4)
                .input(plateDouble, IncoloyMA813, 8)
                .input(plateDouble, Pikyonium64B, 8)
                .input(gear, TitanSteel)
                .input(gearSmall, TitanSteel, 3)
                .input(wireGtQuadruple, EnrichedNaquadahTriniumEuropiumDuranide, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 32))
                .fluidInputs(Lubricant.getFluid(16000))
                .output(COMPONENT_ASSEMBLY_LINE)
                .EUt(VA[UV])
                .duration(1200)
                .stationResearch(b -> b
                        .researchStack(COMPONENT_ASSEMBLER[IV].getStackForm())
                        .CWUt(32)
                        .EUt(VA[UV]))
                .buildAndRegister();

        //  Advanced Assembly Line
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[UV])
                .input(frameGt, Pikyonium64B, 4)
                .inputs(PRECISE_ASSEMBLER.getStackForm(4))
                .input(ASSEMBLER[IV], 8)
                .input(CIRCUIT_ASSEMBLER[IV], 8)
                .input(ROBOT_ARM_UV, 4)
                .input(EMITTER_UV, 2)
                .input(CONVEYOR_MODULE_UV, 2)
                .input(plateDouble, HY1301, 8)
                .input(plateDouble, HMS1J79Alloy, 8)
                .input(gear, Cinobite)
                .input(gearSmall, Cinobite, 3)
                .input(wireGtQuadruple, UraniumRhodiumDinaquadide, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 32))
                .fluidInputs(Lubricant.getFluid(16000))
                .output(ADVANCED_ASSEMBLY_LINE)
                .EUt(VA[UV])
                .duration(1200)
                .stationResearch(b -> b
                        .researchStack(ASSEMBLY_LINE.getStackForm())
                        .CWUt(32)
                        .EUt(VA[UV]))
                .buildAndRegister();

        //  Compressed Fusion Reactor Mk I
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[LuV])
                .input(FUSION_REACTOR[0], 16)
                .input(plate, Europium, 4)
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(ELECTRIC_PUMP_LuV, 2)
                .input(FIELD_GENERATOR_LuV, 2)
                .input(cableGtQuadruple, NiobiumTitanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 40))
                .fluidInputs(Ruridit.getFluid(L * 10))
                .fluidInputs(Polybenzimidazole.getFluid(L * 4))
                .output(COMPRESSED_FUSION_REACTOR[0])
                .scannerResearch(b -> b
                        .researchStack(FUSION_REACTOR[0].getStackForm())
                        .EUt(VA[LuV])
                        .duration(1200))
                .EUt(VA[LuV])
                .duration(1200)
                .buildAndRegister();

        //  Compressed Fusion Reactor Mk II
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[ZPM])
                .input(FUSION_REACTOR[1], 16)
                .input(plate, Americium, 4)
                .input(circuit, MarkerMaterials.Tier.UV, 4)
                .input(ELECTRIC_PUMP_ZPM, 2)
                .input(FIELD_GENERATOR_ZPM, 2)
                .input(cableGtQuadruple, VanadiumGallium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 40))
                .fluidInputs(Osmiridium.getFluid(L * 10))
                .fluidInputs(Polybenzimidazole.getFluid(L * 4))
                .output(COMPRESSED_FUSION_REACTOR[1])
                .scannerResearch(b -> b
                        .researchStack(FUSION_REACTOR[1].getStackForm())
                        .EUt(VA[ZPM])
                        .duration(1200))
                .EUt(VA[ZPM])
                .duration(1200)
                .buildAndRegister();

        //  Compressed Fusion Reactor Mk III
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[UV])
                .input(FUSION_REACTOR[2], 16)
                .input(plate, Dubnium, 4)
                .input(circuit, MarkerMaterials.Tier.UHV, 4)
                .input(ELECTRIC_PUMP_UV, 2)
                .input(FIELD_GENERATOR_UV, 2)
                .input(cableGtQuadruple, YttriumBariumCuprate, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 40))
                .fluidInputs(Tritanium.getFluid(L * 10))
                .fluidInputs(Polybenzimidazole.getFluid(L * 4))
                .output(COMPRESSED_FUSION_REACTOR[2])
                .stationResearch(b -> b
                        .researchStack(FUSION_REACTOR[2].getStackForm())
                        .EUt(VA[UV])
                        .CWUt(64))
                .EUt(VA[UV])
                .duration(1200)
                .buildAndRegister();

        //  Compressed Fusion Reactor Mk IV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[UHV])
                .input(ADVANCED_FUSION_REACTOR[0], 16)
                .input(plate, Livermorium, 4)
                .input(circuit, MarkerMaterials.Tier.UEV, 4)
                .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.CRYOSTAT, 4))
                .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.DIVERTOR, 4))
                .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.VACUUM, 4))
                .input(ELECTRIC_PUMP_UHV, 2)
                .input(FIELD_GENERATOR_UHV, 2)
                .input(cableGtQuadruple, Europium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 40))
                .fluidInputs(Adamantium.getFluid(L * 10))
                .fluidInputs(Polyetheretherketone.getFluid(L * 4))
                .output(COMPRESSED_FUSION_REACTOR[3])
                .stationResearch(b -> b
                        .researchStack(ADVANCED_FUSION_REACTOR[0].getStackForm())
                        .EUt(VA[UHV])
                        .CWUt(128))
                .EUt(VA[UHV])
                .duration(1200)
                .buildAndRegister();

        //  Compressed Fusion Reactor Mk V
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[UEV])
                .input(ADVANCED_FUSION_REACTOR[1], 16)
                .input(plate, MetastableFlerovium, 4)
                .input(circuit, MarkerMaterials.Tier.UIV, 4)
                .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.ADVANCED_CRYOSTAT, 4))
                .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.ADVANCED_DIVERTOR, 4))
                .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.ADVANCED_VACUUM, 4))
                .input(ELECTRIC_PUMP_UEV, 2)
                .input(FIELD_GENERATOR_UEV, 2)
                .input(cableGtQuadruple, PedotTMA, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 40))
                .fluidInputs(Mithril.getFluid(L * 10))
                .fluidInputs(Zylon.getFluid(L * 4))
                .output(COMPRESSED_FUSION_REACTOR[4])
                .stationResearch(b -> b
                        .researchStack(ADVANCED_FUSION_REACTOR[1].getStackForm())
                        .EUt(VA[UEV])
                        .CWUt(256))
                .EUt(VA[UEV])
                .duration(1200)
                .buildAndRegister();

        //  Tree Growth Factory
        ModHandler.addShapedRecipe(true, "tree_growth_factory", TREE_GROWTH_FACTORY.getStackForm(),
                "RSR", "PHP", "WCW",
                'S', COVER_SCREEN,
                'R', new UnificationEntry(spring, Steel),
                'H', HULL[MV].getStackForm(),
                'P', ELECTRIC_PUMP_MV,
                'C', new UnificationEntry(toolHeadBuzzSaw, Aluminium),
                'W', new UnificationEntry(cableGtSingle, Copper));

        //  Stellar Furnace
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Hdcs, 4)
                .inputs(VOLTAGE_COIL_UV.getStackForm(2))
                .input(circuit, MarkerMaterials.Tier.UEV, 4)
                .input(plate, IncoloyMA813, 4)
                .input(plateDouble, IncoloyMA956, 4)
                .input(gear, Tritanium, 2)
                .input(gearSmall, Tritanium, 4)
                .input(screw, Adamantium, 16)
                .input(wireFine, Seaborgium, 64)
                .input(wireFine, Seaborgium, 64)
                .fluidInputs(SolderingAlloy.getFluid(5760))
                .fluidInputs(Lubricant.getFluid(5760))
                .fluidInputs(Ichorium.getFluid(L * 2))
                .outputs(STELLAR_FURNACE.getStackForm())
                .stationResearch(b -> b
                        .researchStack(GTLiteMetaBlocks.UNIQUE_CASING.getItemVariant(BlockUniqueCasing.UniqueCasingType.STELLAR_CONTAINMENT_CASING))
                        .CWUt(128)
                        .EUt(VA[UHV]))
                .EUt(VA[UEV])
                .duration(1200)
                .buildAndRegister();

        //  Plasma Condenser
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, HSSS)
                .input(plate, RhodiumPlatedPalladium, 4)
                .input(circuit, MarkerMaterials.Tier.UV, 2)
                .input(ELECTRIC_MOTOR_UV, 2)
                .input(ELECTRIC_PUMP_UV, 2)
                .input(SENSOR_UV, 2)
                .input(gear, TungstenCarbide, 4)
                .input(screw, Inconel792, 16)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(BlueSteel.getFluid(2880))
                .fluidInputs(CobaltBrass.getFluid(2880))
                .outputs(PLASMA_CONDENSER.getStackForm())
                .EUt(VA[UV])
                .duration(600)
                .stationResearch(b -> b
                        .researchStack(VACUUM_FREEZER.getStackForm())
                        .CWUt(30)
                        .EUt(VA[ZPM]))
                .buildAndRegister();

        //  Collider
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, MARM200Steel)
                .inputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.HIGH_ENERGY_CASING))
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(plate, Pikyonium64B, 4)
                .input(FIELD_GENERATOR_ZPM, 4)
                .inputs(NEUTRON_REFLECTOR.getStackForm(2))
                .input(cableGtQuadruple, VanadiumGallium, 2)
                .fluidInputs(HY1301.getFluid(L * 4))
                .outputs(COLLIDER.getStackForm())
                .EUt(VA[ZPM])
                .duration(1200)
                .buildAndRegister();

        //  Decay Generator
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, NaquadahAlloy)
                .inputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.HIGH_ENERGY_CASING))
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(plate, IncoloyMA813, 4)
                .input(FIELD_GENERATOR_ZPM, 4)
                .inputs(NEUTRON_REFLECTOR.getStackForm(2))
                .input(cableGtQuadruple, VanadiumGallium, 2)
                .fluidInputs(Tantalloy61.getFluid(L * 4))
                .outputs(DECAY_GENERATOR.getStackForm())
                .EUt(VA[ZPM])
                .duration(1200)
                .buildAndRegister();

        //  Mega Oil Cracking Unit
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, HMS1J22Alloy, 4)
                .inputs(CRACKER.getStackForm(16))
                .input(circuit, MarkerMaterials.Tier.IV, 16)
                .input(plateDouble, HG1223, 4)
                .input(plateDouble, Staballoy, 4)
                .input(gear, MaragingSteel250, 4)
                .input(gearSmall, Stellite, 16)
                .input(cableGtQuadruple, Aluminium, 4)
                .fluidInputs(HSSS.getFluid(L * 4))
                .outputs(MEGA_OIL_CRACKING_UNIT.getStackForm())
                .EUt(VA[EV])
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Mega Chemical Reactor
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, MARM200Steel, 4)
                .inputs(LARGE_CHEMICAL_REACTOR.getStackForm(16))
                .input(circuit, MarkerMaterials.Tier.LuV, 16)
                .input(plateDouble, HMS1J79Alloy, 4)
                .input(plateDouble, IncoloyDS, 4)
                .input(gear, Inconel625, 4)
                .input(gearSmall, Tantalloy61, 16)
                .input(cableGtQuadruple, VanadiumGallium, 4)
                .fluidInputs(Osmiridium.getFluid(L * 4))
                .outputs(MEGA_CHEMICAL_REACTOR.getStackForm())
                .EUt(VA[IV])
                .duration(800)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Mega Alloy Blast Smelter
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, AusteniticStainlessSteel904L, 4)
                .inputs(ALLOY_BLAST_SMELTER.getStackForm(16))
                .input(circuit, MarkerMaterials.Tier.LuV, 16)
                .input(plateDouble, Pikyonium64B, 4)
                .input(plateDouble, HastelloyC59, 4)
                .input(gear, HY1301, 4)
                .input(gearSmall, TanmolyiumBetaC, 16)
                .input(wireGtQuadruple, NiobiumTitanium, 4)
                .fluidInputs(Inconel792.getFluid(L * 4))
                .outputs(MEGA_ALLOY_BLAST_SMELTER.getStackForm())
                .EUt(VA[LuV])
                .duration(1200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Large Steam Compressor
        ModHandler.addShapedRecipe(true, "large_steam_compressor", LARGE_STEAM_COMPRESSOR.getStackForm(),
                "CPC", "GFG", "CPC",
                'C', MetaBlocks.METAL_CASING.getItemVariant(BlockMetalCasing.MetalCasingType.BRONZE_BRICKS),
                'F', new UnificationEntry(frameGt, Brass),
                'G', new UnificationEntry(gear, Potin),
                'P', ELECTRIC_PISTON_ULV);
    }

    private static void MachineCasingRecipes() {

        //  Inconel-625 Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[EV], 2)
                .input(plate, Inconel625, 4)
                .input(plate, HSSE, 8)
                .input(ring, Inconel625, 8)
                .input(bolt, Inconel625, 16)
                .fluidInputs(Titanium.getFluid(L * 8))
                .outputs(GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.INCONEL625_CASING, 2))
                .EUt(VA[EV])
                .duration(240)
                .buildAndRegister();

        //  Inconel-625 Gearbox Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, HSSS)
                .input(gear, Inconel625, 3)
                .input(gearSmall, HSSG, 6)
                .input(bolt, HSSE, 16)
                .input(COMPONENT_GRINDER_TUNGSTEN, 2)
                .fluidInputs(Zeron100.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.INCONEL625_GEARBOX_CASING, 2))
                .EUt(VA[LuV])
                .duration(300)
                .buildAndRegister();

        //  Inconel-625 Pipe Casing
        ModHandler.addShapedRecipe(true, "inconel_625_pipe", GTLiteMetaBlocks.BOILER_CASING.getItemVariant(BlockBoilerCasing.BoilerCasingType.INCONEL625, 2),
                "APA", "PFP", "APA",
                'F', new UnificationEntry(frameGt, MaragingSteel300),
                'P', new UnificationEntry(pipeNormalFluid, Inconel625),
                'A', new UnificationEntry(plate, NiobiumTitanium));

        //  Grindball Hatch
        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .input(dust, Soapstone, 4)
                .input(SHAPE_MOLD_BALL)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(GRINDBALL_SOAPSTONE)
                .EUt(VA[MV])
                .duration(300)
                .buildAndRegister();

        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .input(dust, Aluminium, 4)
                .input(SHAPE_MOLD_BALL)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(GRINDBALL_ALUMINIUM)
                .EUt(VA[HV])
                .duration(300)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[EV])
                .input(frameGt, TungstenSteel)
                .input(gear, Titanium, 4)
                .input(COMPONENT_GRINDER_TUNGSTEN)
                .input(wireFine, Tungsten, 16)
                .fluidInputs(RTMAlloy.getFluid(L * 4))
                .output(MULTIPART_GRIND_BALL_HATCH)
                .EUt(VA[IV])
                .duration(600)
                .buildAndRegister();

        //  Hatelloy-N Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[EV], 2)
                .input(plate, Nichrome, 4)
                .input(plate, WatertightSteel, 4)
                .input(stickLong, HSSG, 2)
                .input(bolt, HastelloyN, 16)
                .fluidInputs(StainlessSteel.getFluid(L * 8))
                .outputs(GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.HASTELLOY_N_CASING, 2))
                .EUt(VA[IV])
                .duration(280)
                .buildAndRegister();

        //  Hastelloy-N Gearbox Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, HSSG)
                .input(plate, HSSG, 4)
                .input(gear, HastelloyN, 3)
                .input(gearSmall, HSSG, 6)
                .input(bolt, TungstenCarbide, 16)
                .fluidInputs(HastelloyX.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.HASTELLOY_N_GEARBOX_CASING, 2))
                .EUt(VA[LuV])
                .duration(140)
                .buildAndRegister();

        //  Hastelloy-N Pipe Casing
        ModHandler.addShapedRecipe(true, "hastelloy_n_pipe", GTLiteMetaBlocks.BOILER_CASING.getItemVariant(BlockBoilerCasing.BoilerCasingType.HASTELLOY_N, 2),
                "APA", "PFP", "APA",
                'F', new UnificationEntry(frameGt, WatertightSteel),
                'P', new UnificationEntry(pipeNormalFluid, HastelloyN),
                'A', new UnificationEntry(plate, VanadiumGallium));

        //  Flotation Cell
        ModHandler.addShapedRecipe(true, "flotation_cell", GTLiteMetaBlocks.UNIQUE_CASING.getItemVariant(BlockUniqueCasing.UniqueCasingType.FLOTATION_CELL, 2),
                "AAA", "AGA", "APA",
                'P', ELECTRIC_PUMP_IV,
                'A', new UnificationEntry(plate, HastelloyN),
                'G', MetaBlocks.MULTIBLOCK_CASING.getItemVariant(gregtech.common.blocks.BlockMultiblockCasing.MultiblockCasingType.GRATE_CASING));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, HastelloyN, 7)
                .inputs(MetaBlocks.MULTIBLOCK_CASING.getItemVariant(gregtech.common.blocks.BlockMultiblockCasing.MultiblockCasingType.GRATE_CASING))
                .input(ELECTRIC_PUMP_IV)
                .outputs(GTLiteMetaBlocks.UNIQUE_CASING.getItemVariant(BlockUniqueCasing.UniqueCasingType.FLOTATION_CELL, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Red Steel Casing
        ModHandler.addShapedRecipe(true, "vacuum_casing", GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.RED_STEEL_CASING, 2),
                "PhP", "TFT","PwP",
                'P', new UnificationEntry(plateDouble, RedSteel),
                'T', new UnificationEntry(plate, TitaniumCarbide),
                'F', new UnificationEntry(frameGt, CobaltBrass));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plateDouble, RedSteel, 4)
                .input(plate, TitaniumCarbide, 2)
                .input(frameGt, CobaltBrass)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.RED_STEEL_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Advanced Invar Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.METAL_CASING.getItemVariant(BlockMetalCasing.MetalCasingType.INVAR_HEATPROOF))
                .circuitMeta(6)
                .fluidInputs(AusteniticStainlessSteel904L.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.ADVANCED_INVAR_CASING))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Advanced Aluminium Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.METAL_CASING.getItemVariant(BlockMetalCasing.MetalCasingType.ALUMINIUM_FROSTPROOF))
                .circuitMeta(6)
                .fluidInputs(TanmolyiumBetaC.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.ADVANCED_ALUMINIUM_CASING))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Polybenzimidazole Pipe Casing
        ModHandler.addShapedRecipe(true, "polybenzimidazole_pipe", GTLiteMetaBlocks.BOILER_CASING.getItemVariant(BlockBoilerCasing.BoilerCasingType.POLYBENZIMIDAZOLE, 2),
                "APA", "PFP", "APA",
                'F', new UnificationEntry(frameGt, Polybenzimidazole),
                'P', new UnificationEntry(pipeNormalFluid, Polybenzimidazole),
                'A', new UnificationEntry(plate, Polybenzimidazole));

        //  Talonite Casing
        ModHandler.addShapedRecipe(true, "talonite_casing", GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.TALONITE_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, Talonite),
                'F', new UnificationEntry(frameGt, Talonite));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Talonite, 6)
                .input(frameGt, Talonite)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.TALONITE_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Naquadria Casing
        ModHandler.addShapedRecipe(true, "naquadria_casing", GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.NAQUADRIA_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, Naquadria),
                'F', new UnificationEntry(frameGt, NaquadahAlloy));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Naquadria, 6)
                .input(frameGt, NaquadahAlloy)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.NAQUADRIA_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Hastelloy-X78 Casing
        ModHandler.addShapedRecipe(true, "hastelloy_x78_casing", GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.HASTELLOY_X78_CASING, 2),
                "PhP", "TFT","PwP",
                'P', new UnificationEntry(plateDouble, HastelloyX),
                'T', new UnificationEntry(plate, HastelloyX78),
                'F', new UnificationEntry(frameGt, HastelloyX));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plateDouble, HastelloyX, 4)
                .input(plate, HastelloyX78, 2)
                .input(frameGt, HastelloyX)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.HASTELLOY_X78_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Fusion Casing Mk IV
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[UHV])
                .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.FUSION_COIL_MK2))
                .input(VOLTAGE_COIL_UHV, 2)
                .input(FIELD_GENERATOR_UV)
                .input(plate, Dubnium, 6)
                .fluidInputs(Polyetheretherketone.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.FUSION_CASING_MK4, 2))
                .EUt(VA[UHV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Fusion Casing Mk V
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[UEV])
                .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.FUSION_COIL_MK3))
                .input(VOLTAGE_COIL_UEV, 2)
                .input(FIELD_GENERATOR_UHV)
                .input(plate, Livermorium, 6)
                .fluidInputs(Zylon.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.FUSION_CASING_MK5, 2))
                .EUt(VA[UEV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Fusion Coil Mk 2
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.FUSION_CASING.getItemVariant(gregtech.common.blocks.BlockFusionCasing.CasingType.FUSION_COIL))
                .input(FIELD_GENERATOR_LuV, 2)
                .input(ELECTRIC_PUMP_LuV)
                .input(NEUTRON_REFLECTOR, 2)
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(pipeSmallFluid, Europium, 4)
                .input(plate, Americium, 4)
                .fluidInputs(YttriumBariumCuprate.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.FUSION_COIL_MK2))
                .EUt(VA[UV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Fusion Coil Mk 3
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.FUSION_COIL_MK2))
                .input(FIELD_GENERATOR_ZPM, 2)
                .input(ELECTRIC_PUMP_ZPM)
                .input(NEUTRON_REFLECTOR, 2)
                .input(circuit, MarkerMaterials.Tier.UV, 4)
                .input(pipeSmallFluid, Duranium, 4)
                .input(plate, Dubnium, 4)
                .fluidInputs(Europium.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.FUSION_COIL_MK3))
                .EUt(VA[UHV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Fusion Coil Mk 4
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.FUSION_COIL_MK3))
                .input(FIELD_GENERATOR_UV, 2)
                .input(ELECTRIC_PUMP_UV)
                .input(NEUTRON_REFLECTOR, 2)
                .input(circuit, MarkerMaterials.Tier.UHV, 4)
                .input(pipeSmallFluid, Lafium, 4)
                .input(plate, Livermorium, 4)
                .fluidInputs(Americium.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.FusionCasingType.FUSION_COIL_MK4))
                .EUt(VA[UEV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Precise Assembler Casing Mk I
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .input(ROBOT_ARM_EV, 2)
                .input(plateDouble, MARM200CeSteel, 2)
                .input(circuit, MarkerMaterials.Tier.LuV)
                .input(gearSmall, Stellite, 4)
                .input(cableGtQuadruple, Naquadah, 2)
                .input(screw, HSSG, 32)
                .fluidInputs(BlackSteel.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.PRECISE_ASSEMBLER_CASING.getItemVariant(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK1, 4))
                .EUt(VA[IV])
                .duration(400)
                .buildAndRegister();

        //  Precise Assembler Casing Mk II
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .inputs(GTLiteMetaBlocks.PRECISE_ASSEMBLER_CASING.getItemVariant(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK1))
                .input(ROBOT_ARM_IV, 2)
                .input(plateDouble, HastelloyC59, 2)
                .input(circuit, MarkerMaterials.Tier.ZPM)
                .input(gearSmall, TanmolyiumBetaC, 8)
                .input(cableGtQuadruple, Tritanium, 2)
                .input(screw, HSSE, 32)
                .fluidInputs(Zeron100.getFluid(576))
                .outputs(GTLiteMetaBlocks.PRECISE_ASSEMBLER_CASING.getItemVariant(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK2, 4))
                .EUt(VA[LuV])
                .duration(400)
                .buildAndRegister();

        //  Precise Assembler Casing Mk III
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UV))
                .inputs(GTLiteMetaBlocks.PRECISE_ASSEMBLER_CASING.getItemVariant(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK2))
                .input(ROBOT_ARM_LuV, 2)
                .input(plateDouble, HMS1J79Alloy, 2)
                .input(circuit, MarkerMaterials.Tier.UV)
                .input(gearSmall, HY1301, 8)
                .input(cableGtQuadruple, SiliconCarbide, 2)
                .input(screw, HSSS, 32)
                .fluidInputs(IncoloyMA813.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.PRECISE_ASSEMBLER_CASING.getItemVariant(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK3, 4))
                .EUt(VA[ZPM])
                .duration(800)
                .buildAndRegister();

        //  Iridium Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.METAL_CASING.getItemVariant(BlockMetalCasing.MetalCasingType.STEEL_SOLID))
                .fluidInputs(Iridium.getFluid(L * 2))
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.IRIDIUM_CASING))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Advanced Filter Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Iridium)
                .inputs(MetaBlocks.CLEANROOM_CASING.getItemVariant(gregtech.common.blocks.BlockCleanroomCasing.CasingType.FILTER_CASING))
                .input(ELECTRIC_MOTOR_UV)
                .input(rotor, Iridium)
                .input(ITEM_FILTER)
                .input(FLUID_FILTER)
                .input(stickLong, Iridium, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.CLEANROOM_CASING.getItemVariant(BlockCleanroomCasing.CleanroomCasingType.ADVANCED_FILTER_CASING))
                .EUt(VA[LuV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Component Assembly Line Casings
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Steel, 1)
                .input(plateDense, Steel, 4)
                .input(ROBOT_ARM_LV, 4)
                .input(ELECTRIC_PISTON_LV, 8)
                .input(ELECTRIC_MOTOR_LV, 10)
                .input(gear, Steel, 4)
                .input(wireGtQuadruple, Tin, 6)
                .input(circuit, MarkerMaterials.Tier.LV, 16)
                .fluidInputs(SolderingAlloy.getFluid(576))
                .outputs(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.LV, 4))
                .EUt(VA[LV])
                .duration(320)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Aluminium, 1)
                .input(plateDense, Aluminium, 4)
                .input(ROBOT_ARM_MV, 4)
                .input(ELECTRIC_PISTON_MV, 8)
                .input(ELECTRIC_MOTOR_MV, 10)
                .input(gear, Aluminium, 4)
                .input(wireGtQuadruple, Copper, 6)
                .input(circuit, MarkerMaterials.Tier.MV, 8)
                .input(circuit, MarkerMaterials.Tier.LV, 16)
                .fluidInputs(SolderingAlloy.getFluid(576))
                .outputs(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.MV, 4))
                .EUt(VA[MV])
                .duration(320)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, StainlessSteel, 1)
                .input(plateDense, StainlessSteel, 4)
                .input(ROBOT_ARM_HV, 4)
                .input(ELECTRIC_PISTON_HV, 8)
                .input(ELECTRIC_MOTOR_HV, 10)
                .input(gear, StainlessSteel, 4)
                .input(wireGtQuadruple, Gold, 6)
                .input(circuit, MarkerMaterials.Tier.HV, 8)
                .input(circuit, MarkerMaterials.Tier.MV, 16)
                .fluidInputs(SolderingAlloy.getFluid(576))
                .outputs(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.HV, 4))
                .EUt(VA[HV])
                .duration(320)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Titanium, 1)
                .input(plateDense, Titanium, 4)
                .input(ROBOT_ARM_EV, 4)
                .input(ELECTRIC_PISTON_EV, 8)
                .input(ELECTRIC_MOTOR_EV, 10)
                .input(gear, Titanium, 4)
                .input(wireGtQuadruple, Aluminium, 6)
                .input(circuit, MarkerMaterials.Tier.EV, 8)
                .input(circuit, MarkerMaterials.Tier.HV, 16)
                .fluidInputs(SolderingAlloy.getFluid(576))
                .outputs(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.EV, 4))
                .EUt(VA[EV])
                .duration(320)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, TungstenSteel, 1)
                .input(plateDense, TungstenSteel, 4)
                .input(ROBOT_ARM_IV, 4)
                .input(ELECTRIC_PISTON_IV, 8)
                .input(ELECTRIC_MOTOR_IV, 10)
                .input(gear, TungstenSteel, 4)
                .input(wireGtQuadruple, Tungsten, 6)
                .input(circuit, MarkerMaterials.Tier.IV, 8)
                .input(circuit, MarkerMaterials.Tier.EV, 16)
                .fluidInputs(SolderingAlloy.getFluid(576))
                .outputs(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.IV, 4))
                .EUt(VA[IV])
                .duration(320)
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, RhodiumPlatedPalladium)
                .input(plateDense, RhodiumPlatedPalladium, 6)
                .input(ROBOT_ARM_LuV, 8)
                .input(ELECTRIC_PISTON_LUV, 10)
                .input(ELECTRIC_MOTOR_LuV, 16)
                .input(gear, RhodiumPlatedPalladium, 4)
                .input(gearSmall, RhodiumPlatedPalladium, 16)
                .input(cableGtQuadruple, NiobiumTitanium, 8)
                .input(circuit, MarkerMaterials.Tier.LuV, 8)
                .input(circuit, MarkerMaterials.Tier.IV, 16)
                .fluidInputs(SolderingAlloy.getFluid(3456))
                .fluidInputs(Zeron100.getFluid(1728))
                .fluidInputs(TanmolyiumBetaC.getFluid(864))
                .fluidInputs(Lubricant.getFluid(4000))
                .outputs(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.LuV, 4))
                .EUt(VA[LuV])
                .duration(600)
                .scannerResearch(b -> b
                        .researchStack(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.IV))
                        .EUt(VA[IV])
                        .duration(1200))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, NaquadahAlloy)
                .input(plateDense, NaquadahAlloy, 6)
                .input(ROBOT_ARM_ZPM, 8)
                .input(ELECTRIC_PISTON_ZPM, 10)
                .input(ELECTRIC_MOTOR_ZPM, 16)
                .input(gear, NaquadahAlloy, 4)
                .input(gearSmall, NaquadahAlloy, 16)
                .input(cableGtQuadruple, VanadiumGallium, 8)
                .input(circuit, MarkerMaterials.Tier.ZPM, 8)
                .input(circuit, MarkerMaterials.Tier.LuV, 16)
                .fluidInputs(SolderingAlloy.getFluid(3456))
                .fluidInputs(MARM200CeSteel.getFluid(1728))
                .fluidInputs(HastelloyC59.getFluid(864))
                .fluidInputs(Lubricant.getFluid(4000))
                .outputs(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.ZPM, 4))
                .EUt(VA[ZPM])
                .duration(600)
                .scannerResearch(b -> b
                        .researchStack(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.LuV))
                        .EUt(VA[LuV])
                        .duration(1200))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Darmstadtium)
                .input(plateDense, Darmstadtium, 6)
                .input(ROBOT_ARM_UV, 8)
                .input(ELECTRIC_PISTON_UV, 10)
                .input(ELECTRIC_MOTOR_UV, 16)
                .input(gear, Darmstadtium, 4)
                .input(gearSmall, Darmstadtium, 16)
                .input(cableGtQuadruple, YttriumBariumCuprate, 8)
                .input(circuit, MarkerMaterials.Tier.UV, 8)
                .input(circuit, MarkerMaterials.Tier.ZPM, 16)
                .fluidInputs(SolderingAlloy.getFluid(3456))
                .fluidInputs(HMS1J79Alloy.getFluid(1728))
                .fluidInputs(Pikyonium64B.getFluid(864))
                .fluidInputs(Lubricant.getFluid(4000))
                .outputs(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.UV, 4))
                .EUt(VA[UV])
                .duration(600)
                .scannerResearch(b -> b
                        .researchStack(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.ZPM))
                        .EUt(VA[ZPM])
                        .duration(1200))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Orichalcum)
                .input(plateDense, Orichalcum, 6)
                .input(ROBOT_ARM_UHV, 8)
                .input(ELECTRIC_PISTON_UHV, 10)
                .input(ELECTRIC_MOTOR_UHV, 16)
                .input(gear, Orichalcum, 4)
                .input(gearSmall, Orichalcum, 16)
                .input(cableGtQuadruple, Europium, 8)
                .input(circuit, MarkerMaterials.Tier.UHV, 8)
                .input(circuit, MarkerMaterials.Tier.UV, 16)
                .fluidInputs(SolderingAlloy.getFluid(3456))
                .fluidInputs(TitanSteel.getFluid(1728))
                .fluidInputs(Cinobite.getFluid(864))
                .fluidInputs(Lubricant.getFluid(4000))
                .outputs(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.UHV, 4))
                .EUt(VA[UHV])
                .duration(600)
                .scannerResearch(b -> b
                        .researchStack(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.UV))
                        .EUt(VA[UV])
                        .duration(1200))
                .buildAndRegister();

        //  TODO UEV-MAX Component Assembly Line Casings

        //  Farm Casing
        ModHandler.addShapedRecipe(true, "farm_casing", GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.ASEPTIC_FARM_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, TreatedWood),
                'F', new UnificationEntry(frameGt, Aluminium));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, TreatedWood, 6)
                .input(frameGt, Aluminium)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.ASEPTIC_FARM_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Zirconium Carbide Casing
        ModHandler.addShapedRecipe(true, "zirconium_carbide_casing", GTLiteMetaBlocks.METAL_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMetalCasing.MetalCasingType.ZIRCONIUM_CARBIDE_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, ZirconiumCarbide),
                'F', new UnificationEntry(frameGt, ZirconiumCarbide));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, ZirconiumCarbide, 6)
                .input(frameGt, ZirconiumCarbide)
                .circuitMeta(6)
                .outputs(GTLiteMetaBlocks.METAL_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMetalCasing.MetalCasingType.ZIRCONIUM_CARBIDE_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Stellar Containment Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, MaragingSteel250)
                .input(plate, Hdcs, 4)
                .inputs(VOLTAGE_COIL_ZPM.getStackForm(2))
                .input(screw, IncoloyMA813, 8)
                .fluidInputs(Inconel792.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.UNIQUE_CASING.getItemVariant(BlockUniqueCasing.UniqueCasingType.STELLAR_CONTAINMENT_CASING))
                .EUt(VA[UHV])
                .duration(50)
                .buildAndRegister();

        //  High Energy Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Osmiridium)
                .input(plate, Osmiridium, 6)
                .input(circuit, MarkerMaterials.Tier.LuV)
                .input(wireFine, Iridium, 16)
                .input(wireFine, Cupronickel, 16)
                .input(wireGtSingle, VanadiumGallium, 2)
                .outputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.HIGH_ENERGY_CASING, 2))
                .EUt(VA[ZPM])
                .duration(100)
                .buildAndRegister();

        //  Advanced High Energy Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Europium)
                .input(plate, Europium, 6)
                .input(circuit, MarkerMaterials.Tier.ZPM)
                .input(wireFine, Ruridit, 16)
                .input(wireFine, Kanthal, 16)
                .input(wireGtSingle, YttriumBariumCuprate, 2)
                .outputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.ADVANCED_HIGH_ENERGY_CASING, 2))
                .EUt(VA[UV])
                .duration(100)
                .buildAndRegister();

        //  Ultimate High Energy Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Americium)
                .input(plate, Americium, 6)
                .input(circuit, MarkerMaterials.Tier.UV)
                .input(wireFine, Hdcs, 16)
                .input(wireFine, Nichrome, 16)
                .input(wireGtSingle, Europium, 2)
                .outputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.ULTIMATE_HIGH_ENERGY_CASING, 2))
                .EUt(VA[UHV])
                .duration(100)
                .buildAndRegister();

        //  Molecular Coil
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, TungstenSteel)
                .input(plate, BlueSteel, 4)
                .input(wireFine, Tantalum, 16)
                .input(wireFine, Palladium, 16)
                .input(foil, Rhodium, 8)
                .input(wireGtDouble, Naquadah, 4)
                .fluidInputs(RTMAlloy.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.MOLECULAR_COIL, 2))
                .EUt(VA[ZPM])
                .duration(160)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Hollow Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, RhodiumPlatedPalladium)
                .input(pipeNormalFluid, Naquadah, 2)
                .input(ELECTRIC_PUMP_IV, 2)
                .input(ring, StainlessSteel, 32)
                .input(wireGtSingle, Platinum, 2)
                .fluidInputs(BlackSteel.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.HOLLOW_CASING, 2))
                .EUt(VA[IV])
                .duration(200)
                .buildAndRegister();

        //  Spacetime Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Neutronium)
                .inputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.HOLLOW_CASING))
                .input(plate, Infinity, 6)
                .input(FIELD_GENERATOR_UEV, 2)
                .input(wireFine, Vibranium, 16)
                .fluidInputs(Rhugnor.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.SPACETIME_CASING, 2))
                .EUt(VA[UEV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Dimensional Bridge Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Orichalcum)
                .inputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.ADVANCED_HIGH_ENERGY_CASING))
                .input(plate, Vibranium, 6)
                .input(FIELD_GENERATOR_UHV, 2)
                .input(wireFine, YttriumBariumCuprate, 16)
                .fluidInputs(Tritanium.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.DIMENSIONAL_BRIDGE_CASING, 2))
                .EUt(VA[UHV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Field Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, NaquadahAlloy)
                .input(plate, Kanthal, 4)
                .input(FIELD_GENERATOR_ZPM, 2)
                .input(wireGtSingle, VanadiumGallium, 2)
                .fluidInputs(PCBCoolant.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.FIELD_CASING.getItemVariant(BlockFieldCasing.FieldCasingTier.ZPM, 2))
                .EUt(VA[ZPM])
                .duration(150)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Darmstadtium)
                .input(plate, Nichrome, 4)
                .input(FIELD_GENERATOR_UV, 2)
                .input(wireGtSingle, YttriumBariumCuprate, 2)
                .fluidInputs(PCBCoolant.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.FIELD_CASING.getItemVariant(BlockFieldCasing.FieldCasingTier.UV, 2))
                .EUt(VA[UV])
                .duration(150)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Orichalcum)
                .input(plate, RTMAlloy, 4)
                .input(FIELD_GENERATOR_UHV, 2)
                .input(wireGtSingle, Europium, 2)
                .fluidInputs(PCBCoolant.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.FIELD_CASING.getItemVariant(BlockFieldCasing.FieldCasingTier.UHV, 2))
                .EUt(VA[UHV])
                .duration(150)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Adamantium)
                .input(plate, HSSG, 4)
                .input(FIELD_GENERATOR_UEV, 2)
                .input(wireGtSingle, PedotTMA, 2)
                .fluidInputs(PCBCoolant.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.FIELD_CASING.getItemVariant(BlockFieldCasing.FieldCasingTier.UEV, 2))
                .EUt(VA[UEV])
                .duration(150)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Infinity)
                .input(plate, Naquadah, 4)
                .input(FIELD_GENERATOR_UIV, 2)
                .input(wireGtSingle, Solarium, 2)
                .fluidInputs(PCBCoolant.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.FIELD_CASING.getItemVariant(BlockFieldCasing.FieldCasingTier.UIV, 2))
                .EUt(VA[UIV])
                .duration(150)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, CosmicNeutronium)
                .input(plate, Trinium, 4)
                .input(FIELD_GENERATOR_UXV, 2)
                .input(wireGtSingle, Hypogen, 2)
                .fluidInputs(PCBCoolant.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.FIELD_CASING.getItemVariant(BlockFieldCasing.FieldCasingTier.UXV, 2))
                .EUt(VA[UXV])
                .duration(150)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  TODO OpV and MAX field casing

        //  Space Elevator Casings
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, TungstenCarbide)
                .inputs(MetaBlocks.METAL_CASING.getItemVariant(BlockMetalCasing.MetalCasingType.TUNGSTENSTEEL_ROBUST))
                .input(plate, Pikyonium64B, 6)
                .input(wireFine, Zinc, 16)
                .fluidInputs(Kanthal.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.SPACE_ELEVATOR_CASING.getItemVariant(BlockSpaceElevatorCasing.ElevatorCasingType.BASIC_CASING, 2))
                .EUt(VA[UV])
                .duration(50)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Osmiridium)
                .input(plate, IncoloyMA813, 6)
                .input(ELECTRIC_PUMP_IV, 2)
                .input(CONVEYOR_MODULE_IV, 2)
                .input(ROBOT_ARM_IV, 2)
                .input(wireFine, Tantalum, 16)
                .fluidInputs(RTMAlloy.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.SPACE_ELEVATOR_CASING.getItemVariant(BlockSpaceElevatorCasing.ElevatorCasingType.INTERNAL_STRUCTURE, 2))
                .EUt(VA[UV])
                .duration(50)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Naquadah)
                .input(plate, TungstenSteel, 6)
                .input(NEUTRON_REFLECTOR, 2)
                .input(stick, Inconel625, 2)
                .input(stick, MARM200Steel, 2)
                .input(wireFine, Lead, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.SPACE_ELEVATOR_CASING.getItemVariant(BlockSpaceElevatorCasing.ElevatorCasingType.SUPPORT_STRUCTURE, 2))
                .EUt(VA[UV])
                .duration(50)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.CLEANROOM_CASING.getItemVariant(gregtech.common.blocks.BlockCleanroomCasing.CasingType.PLASCRETE))
                .fluidInputs(FluorinatedEthylenePropylene.getFluid(L * 2))
                .outputs(GTLiteMetaBlocks.SPACE_ELEVATOR_CASING.getItemVariant(BlockSpaceElevatorCasing.ElevatorCasingType.FLOOR))
                .circuitMeta(6)
                .EUt(VA[HV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[UV])
                .input(ELECTRIC_MOTOR_UV, 2)
                .input(circuit, MarkerMaterials.Tier.UV, 4)
                .input(plate, HSSS, 4)
                .input(gear, Duranium, 3)
                .input(gearSmall, HY1301, 6)
                .input(wireFine, YttriumBariumCuprate, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 40))
                .fluidInputs(Lubricant.getFluid(16000))
                .fluidInputs(Tantalloy61.getFluid(L * 4))
                .outputs(GTLiteMetaBlocks.SPACE_ELEVATOR_CASING.getItemVariant(BlockSpaceElevatorCasing.ElevatorCasingType.CABLE_CASING))
                .EUt(VA[UV])
                .duration(200)
                .stationResearch(b -> b
                        .researchStack(GTLiteMetaBlocks.SPACE_ELEVATOR_CASING.getItemVariant(BlockSpaceElevatorCasing.ElevatorCasingType.BASIC_CASING))
                        .CWUt(128)
                        .EUt(VA[UV]))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[IV])
                .input(frameGt, HSSG)
                .input(ELECTRIC_MOTOR_IV, 4)
                .input(wireFine, Platinum, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 4))
                .fluidInputs(Lubricant.getFluid(1600))
                .fluidInputs(Americium.getFluid(L))
                .outputs(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getItemVariant(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK1, 4))
                .EUt(VA[ZPM])
                .duration(200)
                .stationResearch(b -> b
                        .researchStack(GTLiteMetaBlocks.SPACE_ELEVATOR_CASING.getItemVariant(BlockSpaceElevatorCasing.ElevatorCasingType.INTERNAL_STRUCTURE))
                        .CWUt(64)
                        .EUt(VA[ZPM]))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, HSSE)
                .inputs(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getItemVariant(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK1))
                .input(ELECTRIC_MOTOR_LuV, 4)
                .input(wireFine, NiobiumTitanium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 4))
                .fluidInputs(Lubricant.getFluid(1600))
                .fluidInputs(Orichalcum.getFluid(L))
                .outputs(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getItemVariant(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK2, 4))
                .EUt(VA[UV])
                .duration(200)
                .stationResearch(b -> b
                        .researchStack(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getItemVariant(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK1))
                        .CWUt(128)
                        .EUt(VA[UV]))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, HSSS)
                .inputs(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getItemVariant(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK2))
                .input(ELECTRIC_MOTOR_ZPM, 4)
                .input(wireFine, VanadiumGallium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 8))
                .fluidInputs(Lubricant.getFluid(3200))
                .fluidInputs(Adamantium.getFluid(L))
                .outputs(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getItemVariant(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK3, 4))
                .EUt(VA[UHV])
                .duration(200)
                .stationResearch(b -> b
                        .researchStack(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getItemVariant(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK2))
                        .CWUt(256)
                        .EUt(VA[UHV]))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Hdcs)
                .inputs(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getItemVariant(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK3))
                .input(ELECTRIC_MOTOR_UV, 4)
                .input(wireFine, YttriumBariumCuprate, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 8))
                .fluidInputs(Lubricant.getFluid(3200))
                .fluidInputs(Mithril.getFluid(L))
                .outputs(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getItemVariant(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK4, 4))
                .EUt(VA[UEV])
                .duration(200)
                .stationResearch(b -> b
                        .researchStack(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getItemVariant(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK3))
                        .CWUt(512)
                        .EUt(VA[UEV]))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Infinity)
                .inputs(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getItemVariant(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK4))
                .input(ELECTRIC_MOTOR_UHV, 4)
                .input(wireFine, Europium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 16))
                .fluidInputs(Lubricant.getFluid(6400))
                .fluidInputs(Rhugnor.getFluid(L))
                .outputs(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getItemVariant(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK5, 4))
                .EUt(VA[UIV])
                .duration(200)
                .stationResearch(b -> b
                        .researchStack(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getItemVariant(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK4))
                        .CWUt(1024)
                        .EUt(VA[UIV]))
                .buildAndRegister();

        //  Advanced Assembly Control Casing
        ModHandler.addShapedRecipe(true, "casing_assembly_control.advanced", GTLiteMetaBlocks.ACTIVE_UNIQUE_CASING.getItemVariant(BlockActiveUniqueCasing.ActiveCasingType.ADVANCED_ASSEMBLY_CONTROL_CASING, 2),
                "OPO", "SFE", "OMO",
                'O', new UnificationEntry(circuit, MarkerMaterials.Tier.UV),
                'P', ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT,
                'F', new UnificationEntry(frameGt, NaquadahAlloy),
                'S', SENSOR_ZPM,
                'E', EMITTER_ZPM,
                'M', ELECTRIC_MOTOR_ZPM);

        //  Advanced Assembly Casing
        ModHandler.addShapedRecipe(true, "casing_assembly_line.advanced", GTLiteMetaBlocks.ACTIVE_UNIQUE_CASING.getItemVariant(BlockActiveUniqueCasing.ActiveCasingType.ADVANCED_ASSEMBLY_LINE_CASING, 2),
                "PGP", "RFR", "PGP",
                'P', new UnificationEntry(plate, Iridium),
                'G', new UnificationEntry(gear, Osmiridium),
                'R', ROBOT_ARM_ZPM,
                'F', new UnificationEntry(frameGt, NaquadahAlloy));
    }
}