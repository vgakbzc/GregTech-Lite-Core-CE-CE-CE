package magicbook.gtlitecore.integration.gregtech.overrides;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.stack.UnificationEntry;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLY_LINE_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix.swarm;
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
        //  Basic Solar Panel
        ModHandler.removeRecipeByName("gregtech:solar_panel_basic");
        ModHandler.addShapedRecipe(true, "solar_panel.basic", COVER_SOLAR_PANEL.getStackForm(),
                "SAS", "XPX",
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.ULV),
                'P', CARBON_FIBER_PLATE,
                'S', SILICON_WAFER,
                'A', new UnificationEntry(plate, Glass));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(circuit, MarkerMaterials.Tier.ULV, 2)
                .input(CARBON_FIBER_PLATE)
                .input(SILICON_WAFER, 2)
                .circuitMeta(18)
                .fluidInputs(Glass.getFluid(L))
                .output(COVER_SOLAR_PANEL, 2)
                .EUt(VA[LV])
                .duration(400)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(circuit, MarkerMaterials.Tier.ULV, 2)
                .input(CARBON_FIBER_PLATE)
                .input(SILICON_WAFER, 2)
                .circuitMeta(18)
                .fluidInputs(BorosilicateGlass.getFluid(L / 2))
                .output(COVER_SOLAR_PANEL, 2)
                .EUt(VA[LV])
                .duration(200)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(circuit, MarkerMaterials.Tier.ULV, 2)
                .input(CARBON_FIBER_PLATE)
                .input(SILICON_WAFER, 2)
                .circuitMeta(18)
                .fluidInputs(GSTGlass.getFluid(L / 4))
                .output(COVER_SOLAR_PANEL, 2)
                .EUt(VA[LV])
                .duration(100)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(circuit, MarkerMaterials.Tier.ULV, 2)
                .input(CARBON_FIBER_PLATE)
                .input(SILICON_WAFER, 2)
                .circuitMeta(18)
                .fluidInputs(ZBLANGlass.getFluid(L / 4))
                .output(COVER_SOLAR_PANEL, 2)
                .EUt(VA[LV])
                .duration(100)
                .buildAndRegister();

        //  ULV
        ModHandler.removeRecipeByName("gregtech:solar_panel_ulv");
        ModHandler.addShapedRecipe(true, "solar_panel.ulv", COVER_SOLAR_PANEL_ULV.getStackForm(),
                "AGA", "XCX", "P P",
                'C', COVER_SOLAR_PANEL,
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.LV),
                'P', new UnificationEntry(plate, GalliumArsenide),
                'A', CARBON_FIBER_PLATE,
                'G', new UnificationEntry(plate, Glass));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(COVER_SOLAR_PANEL)
                .input(circuit, MarkerMaterials.Tier.LV, 2)
                .input(CARBON_FIBER_PLATE, 2)
                .input(plate, GalliumArsenide, 2)
                .circuitMeta(18)
                .fluidInputs(Glass.getFluid(L))
                .output(COVER_SOLAR_PANEL_ULV, 2)
                .EUt(VA[MV])
                .duration(400)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(COVER_SOLAR_PANEL)
                .input(circuit, MarkerMaterials.Tier.LV, 2)
                .input(CARBON_FIBER_PLATE, 2)
                .input(plate, GalliumArsenide, 2)
                .circuitMeta(18)
                .fluidInputs(BorosilicateGlass.getFluid(L / 2))
                .output(COVER_SOLAR_PANEL_ULV, 2)
                .EUt(VA[MV])
                .duration(200)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(COVER_SOLAR_PANEL)
                .input(circuit, MarkerMaterials.Tier.LV, 2)
                .input(CARBON_FIBER_PLATE, 2)
                .input(plate, GalliumArsenide, 2)
                .circuitMeta(18)
                .fluidInputs(GSTGlass.getFluid(L / 4))
                .output(COVER_SOLAR_PANEL_ULV, 2)
                .EUt(VA[MV])
                .duration(100)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(COVER_SOLAR_PANEL)
                .input(circuit, MarkerMaterials.Tier.LV, 2)
                .input(CARBON_FIBER_PLATE, 2)
                .input(plate, GalliumArsenide, 2)
                .circuitMeta(18)
                .fluidInputs(ZBLANGlass.getFluid(L / 4))
                .output(COVER_SOLAR_PANEL_ULV, 2)
                .EUt(VA[MV])
                .duration(100)
                .buildAndRegister();

        //  LV
        ModHandler.removeRecipeByName("gregtech:solar_panel_lv");
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, CobaltBrass)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, GalliumArsenide, 4)
                .input(CARBON_FIBER_PLATE, 8)
                .input(circuit, MarkerMaterials.Tier.MV, 2)
                .input(wireFine, Cupronickel, 4)
                .circuitMeta(18)
                .fluidInputs(Glass.getFluid(L * 4))
                .output(COVER_SOLAR_PANEL_LV, 2)
                .EUt(VA[HV])
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, CobaltBrass)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, GalliumArsenide, 4)
                .input(CARBON_FIBER_PLATE, 8)
                .input(circuit, MarkerMaterials.Tier.MV, 2)
                .input(wireFine, Cupronickel, 4)
                .circuitMeta(18)
                .fluidInputs(BorosilicateGlass.getFluid(L * 2))
                .output(COVER_SOLAR_PANEL_LV, 2)
                .EUt(VA[HV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, CobaltBrass)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, GalliumArsenide, 4)
                .input(CARBON_FIBER_PLATE, 8)
                .input(circuit, MarkerMaterials.Tier.MV, 2)
                .input(wireFine, Cupronickel, 4)
                .circuitMeta(18)
                .fluidInputs(GSTGlass.getFluid(L))
                .output(COVER_SOLAR_PANEL_LV, 2)
                .EUt(VA[HV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, CobaltBrass)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, GalliumArsenide, 4)
                .input(CARBON_FIBER_PLATE, 8)
                .input(circuit, MarkerMaterials.Tier.MV, 2)
                .input(wireFine, Cupronickel, 4)
                .circuitMeta(18)
                .fluidInputs(ZBLANGlass.getFluid(L))
                .output(COVER_SOLAR_PANEL_LV, 2)
                .EUt(VA[HV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  MV
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, VanadiumSteel)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, GalliumArsenide, 8)
                .input(CARBON_FIBER_PLATE, 16)
                .input(circuit, MarkerMaterials.Tier.HV, 2)
                .input(wireFine, Kanthal, 4)
                .circuitMeta(18)
                .fluidInputs(Glass.getFluid(L * 4))
                .output(COVER_SOLAR_PANEL_MV, 2)
                .EUt(VA[EV])
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, VanadiumSteel)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, GalliumArsenide, 8)
                .input(CARBON_FIBER_PLATE, 16)
                .input(circuit, MarkerMaterials.Tier.HV, 2)
                .input(wireFine, Kanthal, 4)
                .circuitMeta(18)
                .fluidInputs(BorosilicateGlass.getFluid(L * 2))
                .output(COVER_SOLAR_PANEL_MV, 2)
                .EUt(VA[EV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, VanadiumSteel)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, GalliumArsenide, 8)
                .input(CARBON_FIBER_PLATE, 16)
                .input(circuit, MarkerMaterials.Tier.HV, 2)
                .input(wireFine, Kanthal, 4)
                .circuitMeta(18)
                .fluidInputs(GSTGlass.getFluid(L))
                .output(COVER_SOLAR_PANEL_MV, 2)
                .EUt(VA[EV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, VanadiumSteel)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, GalliumArsenide, 8)
                .input(CARBON_FIBER_PLATE, 16)
                .input(circuit, MarkerMaterials.Tier.HV, 2)
                .input(wireFine, Kanthal, 4)
                .circuitMeta(18)
                .fluidInputs(ZBLANGlass.getFluid(L))
                .output(COVER_SOLAR_PANEL_MV, 2)
                .EUt(VA[EV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  HV
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, BlueSteel)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, GalliumArsenide, 16)
                .input(CARBON_FIBER_PLATE, 32)
                .input(circuit, MarkerMaterials.Tier.EV, 2)
                .input(wireFine, Nichrome, 4)
                .circuitMeta(18)
                .fluidInputs(Glass.getFluid(L * 8))
                .output(COVER_SOLAR_PANEL_HV, 2)
                .EUt(VA[IV])
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, BlueSteel)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, GalliumArsenide, 16)
                .input(CARBON_FIBER_PLATE, 32)
                .input(circuit, MarkerMaterials.Tier.EV, 2)
                .input(wireFine, Nichrome, 4)
                .circuitMeta(18)
                .fluidInputs(BorosilicateGlass.getFluid(L * 4))
                .output(COVER_SOLAR_PANEL_HV, 2)
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, BlueSteel)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, GalliumArsenide, 16)
                .input(CARBON_FIBER_PLATE, 32)
                .input(circuit, MarkerMaterials.Tier.EV, 2)
                .input(wireFine, Nichrome, 4)
                .circuitMeta(18)
                .fluidInputs(GSTGlass.getFluid(L * 2))
                .output(COVER_SOLAR_PANEL_HV, 2)
                .EUt(VA[IV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, BlueSteel)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, GalliumArsenide, 16)
                .input(CARBON_FIBER_PLATE, 32)
                .input(circuit, MarkerMaterials.Tier.EV, 2)
                .input(wireFine, Nichrome, 4)
                .circuitMeta(18)
                .fluidInputs(ZBLANGlass.getFluid(L * 2))
                .output(COVER_SOLAR_PANEL_HV, 2)
                .EUt(VA[IV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  EV
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, TungstenCarbide)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, GalliumArsenide, 32)
                .input(CARBON_FIBER_PLATE, 64)
                .input(circuit, MarkerMaterials.Tier.IV, 2)
                .input(wireFine, RTMAlloy, 4)
                .circuitMeta(18)
                .fluidInputs(Glass.getFluid(L * 8))
                .output(COVER_SOLAR_PANEL_EV, 2)
                .EUt(VA[LuV])
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, TungstenCarbide)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, GalliumArsenide, 32)
                .input(CARBON_FIBER_PLATE, 64)
                .input(circuit, MarkerMaterials.Tier.IV, 2)
                .input(wireFine, RTMAlloy, 4)
                .circuitMeta(18)
                .fluidInputs(BorosilicateGlass.getFluid(L * 4))
                .output(COVER_SOLAR_PANEL_EV, 2)
                .EUt(VA[LuV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, TungstenCarbide)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, GalliumArsenide, 32)
                .input(CARBON_FIBER_PLATE, 64)
                .input(circuit, MarkerMaterials.Tier.IV, 2)
                .input(wireFine, RTMAlloy, 4)
                .circuitMeta(18)
                .fluidInputs(GSTGlass.getFluid(L * 2))
                .output(COVER_SOLAR_PANEL_EV, 2)
                .EUt(VA[LuV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, TungstenCarbide)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, GalliumArsenide, 32)
                .input(CARBON_FIBER_PLATE, 64)
                .input(circuit, MarkerMaterials.Tier.IV, 2)
                .input(wireFine, RTMAlloy, 4)
                .circuitMeta(18)
                .fluidInputs(ZBLANGlass.getFluid(L * 2))
                .output(COVER_SOLAR_PANEL_EV, 2)
                .EUt(VA[LuV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  IV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, HSSE)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, IndiumGalliumPhosphide, 4)
                .input(VOLTAGE_COIL_IV, 2)
                .input(foil, NiobiumTitanium, 8)
                .input(wireFine, HSSG, 16)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .fluidInputs(BorosilicateGlass.getFluid(3000))
                .output(COVER_SOLAR_PANEL_IV, 2)
                .scannerResearch(b -> b
                        .researchStack(COVER_SOLAR_PANEL_EV.getStackForm())
                        .EUt(VA[ZPM])
                        .duration(600))
                .EUt(VA[ZPM])
                .duration(200)
                .buildAndRegister();

        //  LuV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, NaquadahAlloy)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, IndiumGalliumPhosphide, 8)
                .input(VOLTAGE_COIL_LuV, 2)
                .input(foil, VanadiumGallium, 8)
                .input(wireFine, Naquadah, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 4))
                .fluidInputs(BorosilicateGlass.getFluid(6000))
                .output(COVER_SOLAR_PANEL_LUV, 2)
                .scannerResearch(b -> b
                        .researchStack(COVER_SOLAR_PANEL_IV.getStackForm())
                        .EUt(VA[UV])
                        .duration(600))
                .EUt(VA[UV])
                .duration(200)
                .buildAndRegister();

        //  ZPM
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Duranium)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, IndiumGalliumPhosphide, 16)
                .input(VOLTAGE_COIL_ZPM, 2)
                .input(foil, YttriumBariumCuprate, 8)
                .input(wireFine, Trinium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 8))
                .fluidInputs(BPAPolycarbonate.getFluid(12000))
                .output(COVER_SOLAR_PANEL_ZPM, 2)
                .stationResearch(b -> b
                        .researchStack(COVER_SOLAR_PANEL_LUV.getStackForm())
                        .EUt(VA[UV])
                        .CWUt(32))
                .EUt(VA[UV])
                .duration(200)
                .buildAndRegister();

        //  UV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Orichalcum)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, IndiumGalliumPhosphide, 32)
                .input(VOLTAGE_COIL_UV, 2)
                .input(foil, Europium, 8)
                .input(wireFine, Tritanium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 16))
                .fluidInputs(BPAPolycarbonate.getFluid(15000))
                .fluidInputs(Polybenzimidazole.getFluid(L))
                .output(COVER_SOLAR_PANEL_UV, 2)
                .stationResearch(b -> b
                        .researchStack(COVER_SOLAR_PANEL_ZPM.getStackForm())
                        .EUt(VA[UHV])
                        .CWUt(64))
                .EUt(VA[UHV])
                .duration(200)
                .buildAndRegister();

        //  UHV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Vibranium)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, IndiumGalliumPhosphide, 64)
                .input(VOLTAGE_COIL_UHV, 2)
                .input(foil, PedotTMA, 8)
                .input(wireFine, Adamantium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 32))
                .fluidInputs(PMMA.getFluid(18000))
                .fluidInputs(Adamantium.getFluid(L * 4))
                .fluidInputs(Polyetheretherketone.getFluid(L))
                .output(COVER_SOLAR_PANEL_UHV, 2)
                .stationResearch(b -> b
                        .researchStack(COVER_SOLAR_PANEL_UV.getStackForm())
                        .EUt(VA[UEV])
                        .CWUt(128))
                .EUt(VA[UEV])
                .duration(200)
                .buildAndRegister();

        //  UEV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, BlackTitanium)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, IndiumGalliumPhosphide, 64)
                .input(plate, IndiumGalliumPhosphide, 32)
                .input(VOLTAGE_COIL_UEV, 2)
                .input(foil, Solarium, 8)
                .input(wireFine, Ichorium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 64))
                .fluidInputs(PMMA.getFluid(21000))
                .fluidInputs(Hdcs.getFluid(L * 8))
                .fluidInputs(Kevlar.getFluid(L * 4))
                .output(COVER_SOLAR_PANEL_UEV, 2)
                .stationResearch(b -> b
                        .researchStack(COVER_SOLAR_PANEL_UHV.getStackForm())
                        .EUt(VA[UEV])
                        .CWUt(256))
                .EUt(VA[UEV])
                .duration(200)
                .buildAndRegister();

        //  UIV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Neutronium)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, IndiumGalliumPhosphide, 64)
                .input(plate, IndiumGalliumPhosphide, 64)
                .input(VOLTAGE_COIL_UIV, 2)
                .input(foil, Hypogen, 8)
                .input(wireFine, Astralium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 128))
                .fluidInputs(CBDOPolycarbonate.getFluid(24000))
                .fluidInputs(Legendarium.getFluid(L * 16))
                .fluidInputs(Zylon.getFluid(L * 8))
                .output(COVER_SOLAR_PANEL_UIV, 2)
                .stationResearch(b -> b
                        .researchStack(COVER_SOLAR_PANEL_UEV.getStackForm())
                        .EUt(VA[UIV])
                        .CWUt(512))
                .EUt(VA[UIV])
                .duration(200)
                .buildAndRegister();

        //  UXV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, BlackPlutonium)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, IndiumGalliumPhosphide, 64)
                .input(plate, IndiumGalliumPhosphide, 64)
                .input(plateDouble, Solarium, 16)
                .input(VOLTAGE_COIL_UXV, 2)
                .input(foil, Galaxium, 8)
                .input(wireFine, Hikarium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 256))
                .fluidInputs(CBDOPolycarbonate.getFluid(27000))
                .fluidInputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(L * 32))
                .fluidInputs(FullerenePolymerMatrix.getFluid(L * 16))
                .output(COVER_SOLAR_PANEL_UXV, 2)
                .stationResearch(b -> b
                        .researchStack(COVER_SOLAR_PANEL_UIV.getStackForm())
                        .EUt(VA[UXV])
                        .CWUt(1024))
                .EUt(VA[UXV])
                .duration(200)
                .buildAndRegister();

        //  OpV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Octiron)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plateDouble, IndiumGalliumPhosphide, 32)
                .input(plateDouble, IndiumGalliumPhosphide, 32)
                .input(plateDouble, Solarium, 32)
                .input(VOLTAGE_COIL_OpV, 2)
                .input(foil, Universium, 8)
                .input(wireFine, Arcanium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 512))
                .fluidInputs(Infinity.getFluid(30000))
                .fluidInputs(TranscendentMetal.getFluid(L * 64))
                .fluidInputs(CosmicFabric.getFluid(L * 32))
                .output(COVER_SOLAR_PANEL_OpV, 2)
                .stationResearch(b -> b
                        .researchStack(COVER_SOLAR_PANEL_UXV.getStackForm())
                        .EUt(VA[OpV])
                        .CWUt(2048))
                .EUt(VA[OpV])
                .duration(200)
                .buildAndRegister();

        //  MAX
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Edenium)
                .input(COVER_SOLAR_PANEL, 2)
                .input(SENSOR_MAX)
                .input(plateDouble, IndiumGalliumPhosphide, 32)
                .input(plateDouble, IndiumGalliumPhosphide, 32)
                .input(plateDouble, Solarium, 32)
                .input(plateDouble, Solarium, 32)
                .input(swarm, Neutronium, 8)
                .input(wireFine, Magmatter, 16)
                .input(CHARGED_HYPERCUBE)
                .fluidInputs(SolderingAlloy.getFluid(L * 1024))
                .fluidInputs(Infinity.getFluid(60000))
                .fluidInputs(Omnium.getFluid(L * 128))
                .fluidInputs(PrimordialMatter.getFluid(L * 64))
                .output(COVER_SOLAR_PANEL_MAX)
                .stationResearch(b -> b
                        .researchStack(COVER_SOLAR_PANEL_OpV.getStackForm())
                        .EUt(VA[MAX])
                        .CWUt(4096))
                .EUt(VA[MAX])
                .duration(200)
                .buildAndRegister();
    }
}
