package magicbook.gtlitecore.integration.gregtech.overrides;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.stack.UnificationEntry;
import magicbook.gtlitecore.api.utils.Mods;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.GTLiteValues.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.api.utils.GTLiteUtils.getFluidById;
import static magicbook.gtlitecore.api.utils.GTLiteUtils.getMetaItemById;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

/**
 * Override of Solar Panels
 *
 * @author Magic_Sweepy
 *
 * @since 2.8.7-beta
 */
public class SolarPanels {

    public static void init() {

        //  Remove all Solar Panel recipes.
        ModHandler.removeRecipeByName("gregtech:solar_panel_basic");
        ModHandler.removeRecipeByName("gregtech:solar_panel_ulv");
        ModHandler.removeRecipeByName("gregtech:solar_panel_lv");

        // ---------------------------------------- Material Components ----------------------------------------

        //  Reinforced Aluminium Plate
        //  This Material Plate is does not a GregTech Material,
        //  it is only a Crafting Component of Solar Panels, used to Basic Solar Panel.
        FORMING_PRESS_RECIPES.recipeBuilder()
                .circuitMeta(4)
                .input(plate, Aluminium, 2)
                .input(plate, Iron, 4)
                .output(REINFORCED_ALUMINIUM_PLATE)
                .EUt(VA[MV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  Composite Reinforced Aluminium Plate
        //  Advanced version of Reinforced Aluminium Plate, used to ULV Solar Panel.
        FORMING_PRESS_RECIPES.recipeBuilder()
                .circuitMeta(4)
                .input(REINFORCED_ALUMINIUM_PLATE)
                .input(plate, VanadiumSteel, 4)
                .input(CARBON_FIBER_PLATE, 4)
                .output(COMPOSITE_REINFORCED_ALUMINIUM_PLATE)
                .EUt(VA[MV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  Irradiant Reinforced Aluminium Plate
        //  Ultimate version of Reinforced Aluminium Plate, used to LV Solar Panel.
        //  This recipe use some item in EnderIO and Materials in Modpack CrT supported.
        if (Mods.CraftTweaker.isModLoaded() && Mods.EnderIO.isModLoaded()) {
            FORMING_PRESS_RECIPES.recipeBuilder()
                    .circuitMeta(4)
                    .input(COMPOSITE_REINFORCED_ALUMINIUM_PLATE)
                    .inputs(getMetaItemById(Mods.EnderIO.getID(), "item_material", 14)) // Ore Dict: itemPulsatingCrystal
                    .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32007, 2)) // Ore Dict: platePulsatingIron
                    .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_screw", 32007, 4)) // Ore Dict: screwPulsatingIron
                    .output(IRRADIANT_REINFORCED_ALUMINIUM_PLATE)
                    .EUt(VA[MV])
                    .duration(20 * SECOND)
                    .buildAndRegister();
        }

        //  Reinforced Titanium Plate
        //  Another Reinforced Material Plate, higher than Irradiant Reinforced Aluminium Plate.
        //  Used to MV Solar Panel.
        FORMING_PRESS_RECIPES.recipeBuilder()
                .circuitMeta(4)
                .input(plate, Titanium, 2)
                .input(plate, Aluminium, 4)
                .output(REINFORCED_TITANIUM_PLATE)
                .EUt(VA[EV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  Composite Reinforced Titanium Plate
        //  Advanced version of Reinforced Titanium Plate, used to HV Solar Panel.
        FORMING_PRESS_RECIPES.recipeBuilder()
                .circuitMeta(4)
                .input(REINFORCED_TITANIUM_PLATE)
                .input(plate, Kanthal, 4)
                .input(CARBON_FIBER_PLATE, 4)
                .output(COMPOSITE_REINFORCED_TITANIUM_PLATE)
                .EUt(VA[EV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  Irradiant Reinforced Titanium Plate
        //  Ultimate version of Reinforced Titanium Plate, used to EV Solar Panel.
        if (Mods.CraftTweaker.isModLoaded() && Mods.EnderIO.isModLoaded()) {
            FORMING_PRESS_RECIPES.recipeBuilder()
                    .circuitMeta(4)
                    .input(COMPOSITE_REINFORCED_TITANIUM_PLATE)
                    .inputs(getMetaItemById(Mods.EnderIO.getID(), "item_material", 17)) // Ore Dict: itemAttractorCrystal
                    .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32009)) // Ore Dict: plateCrystallineAlloy
                    .input(plate, Lapis, 2)
                    .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_screw", 32006, 4)) // Ore Dict: screwConductiveIron
                    .output(IRRADIANT_REINFORCED_TITANIUM_PLATE)
                    .EUt(VA[EV])
                    .duration(20 * SECOND)
                    .buildAndRegister();
        }

        //  Reinforced Tungsten Plate
        //  Another Reinforced Material Plate, higher than Irradiant Reinforced Titanium Plate.
        //  Used to IV Solar Panel.
        FORMING_PRESS_RECIPES.recipeBuilder()
                .circuitMeta(4)
                .input(plate, Tungsten, 2)
                .input(plate, Titanium, 4)
                .output(REINFORCED_TUNGSTEN_PLATE)
                .EUt(VA[LuV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  Composite Reinforced Tungsten Plate
        //  Advanced version of Reinforced Tungsten Plate, used to LuV Solar Panel.
        FORMING_PRESS_RECIPES.recipeBuilder()
                .circuitMeta(4)
                .input(REINFORCED_TUNGSTEN_PLATE)
                .input(plate, RTMAlloy, 4)
                .input(CARBON_FIBER_PLATE, 4)
                .output(COMPOSITE_REINFORCED_TUNGSTEN_PLATE)
                .EUt(VA[LuV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  Irradiant Reinforced Tungsten Plate
        //  Ultimate version of Reinforced Tungsten Plate, used to ZPM Solar Panel.
        if (Mods.CraftTweaker.isModLoaded() && Mods.EnderIO.isModLoaded()) {
            FORMING_PRESS_RECIPES.recipeBuilder()
                    .circuitMeta(4)
                    .input(COMPOSITE_REINFORCED_TUNGSTEN_PLATE)
                    .inputs(getMetaItemById(Mods.EnderIO.getID(), "item_material", 15)) // Ore Dict: itemVibrantCrystal
                    .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32012)) // Ore Dict: plateCrystallinePinkSlime
                    .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32000, 2)) // Ore Dict: plateDarkSteel
                    .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_screw", 32002, 4)) // Ore Dict: screwEnergeticAlloy
                    .output(IRRADIANT_REINFORCED_TUNGSTEN_PLATE)
                    .EUt(VA[LuV])
                    .duration(20 * SECOND)
                    .buildAndRegister();
        }

        //  Reinforced Naquadah Plate
        //  Another Reinforced Material Plate, higher than Irradiant Reinforced Tungsten Plate.
        //  Used to UV Solar Panel.
        FORMING_PRESS_RECIPES.recipeBuilder()
                .circuitMeta(4)
                .input(plate, Naquadah, 2)
                .input(plate, Tungsten, 4)
                .output(REINFORCED_NAQUADAH_PLATE)
                .EUt(VA[UV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  Composite Reinforced Naquadah Plate
        //  Advanced version of Reinforced Naquadah Plate, used to UHV Solar Panel.
        FORMING_PRESS_RECIPES.recipeBuilder()
                .circuitMeta(4)
                .input(REINFORCED_NAQUADAH_PLATE)
                .input(plate, HSSS, 4)
                .input(CARBON_FIBER_PLATE, 4)
                .output(COMPOSITE_REINFORCED_NAQUADAH_PLATE)
                .EUt(VA[UV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  Irradiant Reinforced Naquadah Plate
        //  Ultimate version of Reinforced Naquadah Plate, used to UEV Solar Panel.
        if (Mods.CraftTweaker.isModLoaded() && Mods.EnderIO.isModLoaded()) {
            FORMING_PRESS_RECIPES.recipeBuilder()
                    .circuitMeta(4)
                    .input(COMPOSITE_REINFORCED_NAQUADAH_PLATE)
                    .inputs(getMetaItemById(Mods.EnderIO.getID(), "item_material", 18)) // Ore Dict: itemWeatherCrystal
                    .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32010)) // Ore Dict: plateMelodicAlloy
                    .input(plate, Osmiridium, 2)
                    .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_screw", 32003, 4)) // Ore Dict: screwVibrantAlloy
                    .output(IRRADIANT_REINFORCED_NAQUADAH_PLATE)
                    .EUt(VA[UV])
                    .duration(20 * SECOND)
                    .buildAndRegister();
        }

        //  Reinforced Neutronium Plate
        //  Another Reinforced Material Plate, higher than Irradiant Reinforced Naquadah Plate.
        //  Used to UIV Solar Panel.
        FORMING_PRESS_RECIPES.recipeBuilder()
                .circuitMeta(4)
                .input(plate, Neutronium, 2)
                .input(plate, Naquadah, 4)
                .output(REINFORCED_NEUTRONIUM_PLATE)
                .EUt(VA[UEV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  Composite Reinforced Neutronium Plate
        //  Advanced version of Reinforced Neutronium Plate, used to UXV Solar Panel.
        FORMING_PRESS_RECIPES.recipeBuilder()
                .circuitMeta(4)
                .input(REINFORCED_NEUTRONIUM_PLATE)
                .input(plate, Hdcs, 4)
                .input(CARBON_FIBER_PLATE, 4)
                .output(COMPOSITE_REINFORCED_NEUTRONIUM_PLATE)
                .EUt(VA[UEV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  Irradiant Reinforced Neutronium Plate
        //  Ultimate version of Reinforced Neutronium Plate, used to OpV Solar Panel.
        if (Mods.CraftTweaker.isModLoaded() && Mods.EnderUtilities.isModLoaded()) {
            FORMING_PRESS_RECIPES.recipeBuilder()
                    .circuitMeta(4)
                    .input(COMPOSITE_REINFORCED_NEUTRONIUM_PLATE)
                    .inputs(getMetaItemById(Mods.EnderUtilities.getID(), "enderpart", 17)) // Ender Core MK3
                    .input(plate, Infinity)
                    .input(plate, Tritanium, 2)
                    .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_screw", 32004, 4)) // Ore Dict: screwEndSteel
                    .output(IRRADIANT_REINFORCED_NEUTRONIUM_PLATE)
                    .EUt(VA[UEV])
                    .duration(20 * SECOND)
                    .buildAndRegister();
        }

        // -------------------------------------------- Solar Panels -------------------------------------------

        //  Basic Solar Panel
        ModHandler.addShapedRecipe(true, "solar_panel.basic", COVER_SOLAR_PANEL.getStackForm(),
                "SAS", "XPX", "WBW",
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.ULV),
                'P', CARBON_FIBER_PLATE,
                'S', SILICON_WAFER,
                'A', new UnificationEntry(plate, Glass),
                'W', new UnificationEntry(wireGtSingle, RedAlloy),
                'B', REINFORCED_ALUMINIUM_PLATE);

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(18)
                .input(SILICON_WAFER, 2)
                .input(circuit, MarkerMaterials.Tier.ULV, 2)
                .input(plate, Glass)
                .input(CARBON_FIBER_PLATE)
                .input(REINFORCED_ALUMINIUM_PLATE)
                .fluidInputs(RedAlloy.getFluid(L))
                .output(COVER_SOLAR_PANEL)
                .EUt(VA[LV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  ULV Solar Panel (a.k.a. 8A Solar Panel)
        ModHandler.addShapedRecipe(true, "solar_panel.ulv", COVER_SOLAR_PANEL_ULV.getStackForm(),
                "CSC", "XPX", "WBW",
                'C', COVER_SOLAR_PANEL,
                'S', SILICON_WAFER,
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.LV),
                'P', new UnificationEntry(plate, GalliumArsenide),
                'W', new UnificationEntry(wireGtSingle, Tin),
                'B', COMPOSITE_REINFORCED_ALUMINIUM_PLATE);

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(18)
                .input(COVER_SOLAR_PANEL, 2)
                .input(SILICON_WAFER)
                .input(circuit, MarkerMaterials.Tier.LV, 2)
                .input(plate, GalliumArsenide)
                .input(COMPOSITE_REINFORCED_ALUMINIUM_PLATE)
                .fluidInputs(Tin.getFluid(L))
                .output(COVER_SOLAR_PANEL_ULV)
                .EUt(VA[MV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  LV Solar Panel
        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(18)
                .input(COVER_SOLAR_PANEL_ULV, 2)
                .input(SILICON_WAFER)
                .input(circuit, MarkerMaterials.Tier.MV, 2)
                .input(plate, GalliumArsenide, 2)
                .input(IRRADIANT_REINFORCED_ALUMINIUM_PLATE)
                .fluidInputs(TinAlloy.getFluid(L))
                .output(COVER_SOLAR_PANEL_LV)
                .EUt(VA[HV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  MV Solar Panel
        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(18)
                .input(COVER_SOLAR_PANEL_LV, 2)
                .input(PHOSPHORUS_WAFER)
                .input(circuit, MarkerMaterials.Tier.HV, 2)
                .input(plate, GalliumArsenide, 4)
                .input(REINFORCED_TITANIUM_PLATE)
                .fluidInputs(CobaltBrass.getFluid(L))
                .output(COVER_SOLAR_PANEL_MV)
                .EUt(VA[EV])
                .duration(5 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  HV Solar Panel
        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(18)
                .input(COVER_SOLAR_PANEL_MV, 2)
                .input(PHOSPHORUS_WAFER)
                .input(circuit, MarkerMaterials.Tier.EV, 2)
                .input(plate, GalliumArsenide, 8)
                .input(COMPOSITE_REINFORCED_TITANIUM_PLATE)
                .fluidInputs(BlackSteel.getFluid(L))
                .output(COVER_SOLAR_PANEL_HV)
                .EUt(VA[IV])
                .duration(5 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  EV Solar Panel
        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(18)
                .input(COVER_SOLAR_PANEL_HV, 2)
                .input(NAQUADAH_WAFER)
                .input(circuit, MarkerMaterials.Tier.IV, 2)
                .input(plate, GalliumArsenide, 16)
                .input(IRRADIANT_REINFORCED_TITANIUM_PLATE)
                .fluidInputs(BlueSteel.getFluid(L))
                .output(COVER_SOLAR_PANEL_EV)
                .EUt(VA[LuV])
                .duration(5 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  IV Solar Panel
        //  Required Modpack CrT supported.
        if (Mods.CraftTweaker.isModLoaded()) {
            ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(frameGt, HSSE)
                    .input(COVER_SOLAR_PANEL_EV, 2)
                    .input(NAQUADAH_WAFER, 2)
                    .input(circuit, MarkerMaterials.Tier.LuV, 4)
                    .input(plate, IndiumGalliumPhosphide)
                    .input(VOLTAGE_COIL_IV, 2)
                    .input(POWER_INTEGRATED_CIRCUIT, 4)
                    .input(foil, NiobiumTitanium, 8)
                    .input(REINFORCED_TUNGSTEN_PLATE, 2)
                    .input(wireGtDouble, HSSG, 4)
                    .fluidInputs(SolderingAlloy.getFluid(L * 9))
                    .fluidInputs(BorosilicateGlass.getFluid(3000))
                    .fluidInputs(getFluidById("lumium", L * 4))
                    .output(COVER_SOLAR_PANEL_IV)
                    .EUt(VA[ZPM])
                    .duration(10 * SECOND)
                    .scannerResearch(b -> b
                            .researchStack(COVER_SOLAR_PANEL_EV.getStackForm())
                            .EUt(VA[ZPM])
                            .duration(30 * SECOND))
                    .buildAndRegister();
        }

        //  LuV Solar Panel
        //  Required Modpack CrT supported.
        if (Mods.CraftTweaker.isModLoaded()) {
            ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(frameGt, NaquadahAlloy)
                    .input(COVER_SOLAR_PANEL_IV, 2)
                    .input(NAQUADAH_WAFER, 4)
                    .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                    .input(plate, IndiumGalliumPhosphide, 2)
                    .input(VOLTAGE_COIL_LuV, 2)
                    .input(POWER_INTEGRATED_CIRCUIT, 8)
                    .input(foil, VanadiumGallium, 16)
                    .input(COMPOSITE_REINFORCED_TUNGSTEN_PLATE, 2)
                    .input(wireGtDouble, Trinium, 4)
                    .fluidInputs(SolderingAlloy.getFluid(L * 9 * 2))
                    .fluidInputs(BorosilicateGlass.getFluid(6000))
                    .fluidInputs(getFluidById("signalum", L * 4))
                    .output(COVER_SOLAR_PANEL_LUV)
                    .EUt(VA[UV])
                    .duration(15 * SECOND)
                    .scannerResearch(b -> b
                            .researchStack(COVER_SOLAR_PANEL_IV.getStackForm())
                            .EUt(VA[UV])
                            .duration(MINUTE))
                    .buildAndRegister();
        }

        //  ZPM Solar Panel
        if (Mods.CraftTweaker.isModLoaded()) {
            ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(frameGt, Duranium)
                    .input(COVER_SOLAR_PANEL_LUV, 2)
                    .input(EUROPIUM_WAFER)
                    .input(circuit, MarkerMaterials.Tier.UV, 4)
                    .input(plate, IndiumGalliumPhosphide, 4)
                    .input(VOLTAGE_COIL_ZPM, 2)
                    .input(HIGH_POWER_INTEGRATED_CIRCUIT, 4)
                    .input(foil, YttriumBariumCuprate, 16)
                    .input(IRRADIANT_REINFORCED_TUNGSTEN_PLATE, 2)
                    .input(wireGtDouble, Tritanium, 4)
                    .fluidInputs(SolderingAlloy.getFluid(L * 9 * 4))
                    .fluidInputs(BPAPolycarbonate.getFluid(9000))
                    .fluidInputs(getFluidById("enderium", L * 4))
                    .output(COVER_SOLAR_PANEL_ZPM)
                    .EUt(VA[UHV])
                    .duration(20 * SECOND)
                    .stationResearch(b -> b
                            .researchStack(COVER_SOLAR_PANEL_LUV.getStackForm())
                            .CWUt(32)
                            .EUt(VA[UHV]))
                    .buildAndRegister();
        }

        //  UV Solar Panel
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Orichalcum)
                .input(COVER_SOLAR_PANEL_ZPM, 2)
                .input(EUROPIUM_WAFER, 2)
                .input(circuit, MarkerMaterials.Tier.UHV, 4)
                .input(plate, IndiumGalliumPhosphide, 8)
                .input(VOLTAGE_COIL_UV, 2)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .input(foil, Europium, 32)
                .input(REINFORCED_NAQUADAH_PLATE, 2)
                .input(wireGtDouble, Adamantium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 9 * 8))
                .fluidInputs(BPAPolycarbonate.getFluid(12000))
                .fluidInputs(FluxedElectrum.getFluid(L * 4))
                .output(COVER_SOLAR_PANEL_UV)
                .EUt(VH[UEV])
                .duration(25 * SECOND)
                .stationResearch(b -> b
                        .researchStack(COVER_SOLAR_PANEL_ZPM.getStackForm())
                        .CWUt(64)
                        .EUt(VH[UEV]))
                .buildAndRegister();

        //  UHV Solar Panel
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Vibranium)
                .input(COVER_SOLAR_PANEL_UV, 2)
                .input(EUROPIUM_WAFER, 4)
                .input(circuit, MarkerMaterials.Tier.UEV, 4)
                .input(plate, Solarium)
                .input(VOLTAGE_COIL_UHV, 2)
                .input(ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 4)
                .input(foil, PedotTMA, 32)
                .input(COMPOSITE_REINFORCED_NAQUADAH_PLATE, 2)
                .input(wireGtDouble, Ichorium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 9 * 16))
                .fluidInputs(PMMA.getFluid(15000))
                .fluidInputs(ArceusAlloy2B.getFluid(L * 4))
                .output(COVER_SOLAR_PANEL_UHV)
                .EUt(VA[UEV])
                .duration(30 * SECOND)
                .stationResearch(b -> b
                        .researchStack(COVER_SOLAR_PANEL_UV.getStackForm())
                        .CWUt(128)
                        .EUt(VA[UEV]))
                .buildAndRegister();

        //  UEV Solar Panel
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, BlackTitanium)
                .input(COVER_SOLAR_PANEL_UHV, 2)
                .input(AMERICIUM_WAFER, 4)
                .input(circuit, MarkerMaterials.Tier.UIV, 4)
                .input(plate, Solarium, 2)
                .input(VOLTAGE_COIL_UEV, 2)
                .input(ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .input(foil, Seaborgium, 48)
                .input(IRRADIANT_REINFORCED_NAQUADAH_PLATE, 2)
                .input(wireGtDouble, Astralium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 9 * 32))
                .fluidInputs(PMMA.getFluid(18000))
                .fluidInputs(HastelloyK243.getFluid(L * 4))
                .output(COVER_SOLAR_PANEL_UEV)
                .EUt(VH[UIV])
                .duration(35 * SECOND)
                .stationResearch(b -> b
                        .researchStack(COVER_SOLAR_PANEL_UHV.getStackForm())
                        .CWUt(256)
                        .EUt(VH[UIV]))
                .buildAndRegister();

        //  UIV Solar Panel
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, BlackPlutonium)
                .input(COVER_SOLAR_PANEL_UEV, 2)
                .input(DUBNIUM_WAFER, 4)
                .input(circuit, MarkerMaterials.Tier.UXV, 4)
                .input(EMITTER_UIV, 2)
                .input(SENSOR_UIV, 2)
                .input(plate, Solarium, 4)
                .input(plate, AstralTitanium, 4)
                .input(gear, CelestialTungsten, 2)
                .input(VOLTAGE_COIL_UIV, 2)
                .input(NANO_PIC_CHIP, 16)
                .input(foil, Hypogen, 64)
                .input(REINFORCED_NEUTRONIUM_PLATE, 4)
                .input(wireGtDouble, Hikarium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 9 * 64))
                .fluidInputs(CBDOPolycarbonate.getFluid(21000))
                .fluidInputs(SuperheavyHAlloy.getFluid(L * 4))
                .output(COVER_SOLAR_PANEL_UIV)
                .EUt(VA[UIV])
                .duration(40 * SECOND)
                .stationResearch(b -> b
                        .researchStack(COVER_SOLAR_PANEL_UEV.getStackForm())
                        .CWUt(512)
                        .EUt(VA[UIV]))
                .buildAndRegister();

        //  UXV Solar Panel
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Octiron)
                .input(COVER_SOLAR_PANEL_UIV, 2)
                .input(NEUTRONIUM_WAFER, 4)
                .input(circuit, MarkerMaterials.Tier.OpV, 4)
                .input(EMITTER_UXV, 2)
                .input(SENSOR_UXV, 2)
                .input(plateDouble, Solarium, 4)
                .input(plateDouble, HeavyQuarkDegenerateMatter, 4)
                .input(gear, QuantumchromodynamicallyConfinedMatter, 2)
                .input(VOLTAGE_COIL_UXV, 2)
                .input(PICO_PIC_CHIP, 32)
                .input(foil, CosmicNeutronium, 64)
                .input(COMPOSITE_REINFORCED_NEUTRONIUM_PLATE, 4)
                .input(wireGtDouble, Arcanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 9 * 128))
                .fluidInputs(CBDOPolycarbonate.getFluid(24000))
                .fluidInputs(Arcanium.getFluid(L * 4))
                .output(COVER_SOLAR_PANEL_UXV)
                .EUt(VZ[UXV])
                .duration(80 * SECOND)
                .stationResearch(b -> b
                        .researchStack(COVER_SOLAR_PANEL_UIV.getStackForm())
                        .CWUt(1024)
                        .EUt(VA[UXV]))
                .buildAndRegister();

        //  OpV Solar Panel
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Spacetime)
                .input(COVER_SOLAR_PANEL_UXV, 2)
                .input(NEUTRONIUM_WAFER, 8)
                .input(circuit, MarkerMaterials.Tier.MAX, 4)
                .input(EMITTER_OpV, 2)
                .input(SENSOR_OpV, 2)
                .input(plateDouble, Solarium, 8)
                .input(plateDouble, Shirabon, 8)
                .input(gear, Edenium, 2)
                .input(VOLTAGE_COIL_OpV, 2)
                .input(FEMTO_PIC_CHIP, 64)
                .input(foil, Universium, 64)
                .input(IRRADIANT_REINFORCED_NEUTRONIUM_PLATE, 4)
                .input(wireGtDouble, Galaxium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 9 * 256))
                .fluidInputs(Infinity.getFluid(48000))
                .fluidInputs(Galaxium.getFluid(L * 4))
                .output(COVER_SOLAR_PANEL_OpV)
                .EUt(VZ[OpV])
                .duration(160 * SECOND)
                .stationResearch(b -> b
                        .researchStack(COVER_SOLAR_PANEL_UXV.getStackForm())
                        .CWUt(2048)
                        .EUt(VA[OpV]))
                .buildAndRegister();

        //  MAX Solar Panel
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Eternity)
                .input(COVER_SOLAR_PANEL_OpV, 2)
                .input(NEUTRONIUM_WAFER, 16)
                .input(circuit, MarkerMaterials.Tier.MAX, 16)
                .input(EMITTER_MAX, 2)
                .input(SENSOR_MAX, 2)
                .input(plateDouble, Solarium, 16)
                .input(plateDouble, Magmatter, 16)
                .input(gear, Aetherium, 2)
                .input(ULTIMATE_BATTERY_MK5)
                .input(FEMTO_PIC_WAFER, 64)
                .input(foil, Spacetime, 64)
                .input(wireGtDouble, PrimordialMatter, 4)
                .input(CHARGED_HYPERCUBE)
                .fluidInputs(SolderingAlloy.getFluid(L * 9 * 512))
                .fluidInputs(Infinity.getFluid(128000))
                .fluidInputs(Universium.getFluid(L * 4))
                .output(COVER_SOLAR_PANEL_MAX)
                .EUt(VZ[MAX])
                .duration(320 * SECOND)
                .stationResearch(b -> b
                        .researchStack(COVER_SOLAR_PANEL_OpV.getStackForm())
                        .CWUt(4096)
                        .EUt(VA[MAX]))
                .buildAndRegister();

    }
}
