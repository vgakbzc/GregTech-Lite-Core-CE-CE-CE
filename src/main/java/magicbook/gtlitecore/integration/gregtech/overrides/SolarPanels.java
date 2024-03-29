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

        //  ULV Solar Panel
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

        //  LV Solar Panel
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

        //  MV Solar Panel
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

        //  HV Solar Panel
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

        //  EV Solar Panel
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

        //  IV Solar Panel
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

        //  LuV Solar Panel
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, NaquadahAlloy)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, IndiumGalliumPhosphide, 8)
                .input(VOLTAGE_COIL_LuV, 2)
                .input(foil, VanadiumGallium, 8)
                .input(wireFine, Naquadah, 16)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .fluidInputs(BorosilicateGlass.getFluid(3000))
                .output(COVER_SOLAR_PANEL_LUV, 2)
                .scannerResearch(b -> b
                        .researchStack(COVER_SOLAR_PANEL_IV.getStackForm())
                        .EUt(VA[UV])
                        .duration(600))
                .EUt(VA[UV])
                .duration(200)
                .buildAndRegister();

        //  ZPM Solar Panel
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Duranium)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, IndiumGalliumPhosphide, 16)
                .input(VOLTAGE_COIL_ZPM, 2)
                .input(foil, YttriumBariumCuprate, 8)
                .input(wireFine, Trinium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 2))
                .fluidInputs(BorosilicateGlass.getFluid(6000))
                .fluidInputs(Polyetheretherketone.getFluid(L))
                .output(COVER_SOLAR_PANEL_ZPM, 2)
                .stationResearch(b -> b
                        .researchStack(COVER_SOLAR_PANEL_LUV.getStackForm())
                        .EUt(VA[UHV])
                        .CWUt(32))
                .EUt(VA[UHV])
                .duration(200)
                .buildAndRegister();

        //  UV Solar Panel
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Orichalcum)
                .input(COVER_SOLAR_PANEL, 2)
                .input(plate, IndiumGalliumPhosphide, 32)
                .input(VOLTAGE_COIL_UV, 2)
                .input(foil, Europium, 8)
                .input(wireFine, Tritanium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 2))
                .fluidInputs(BorosilicateGlass.getFluid(6000))
                .fluidInputs(Polyetheretherketone.getFluid(L))
                .output(COVER_SOLAR_PANEL_UV, 2)
                .stationResearch(b -> b
                        .researchStack(COVER_SOLAR_PANEL_ZPM.getStackForm())
                        .EUt(VA[UEV])
                        .CWUt(64))
                .EUt(VA[UEV])
                .duration(200)
                .buildAndRegister();

        //  MAX Solar Panel (todo update this recipe when gtlitecore have UHV-OpV Solar Panels)
    }
}
