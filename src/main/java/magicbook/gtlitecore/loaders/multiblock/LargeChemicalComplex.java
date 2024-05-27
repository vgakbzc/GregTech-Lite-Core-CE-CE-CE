package magicbook.gtlitecore.loaders.multiblock;

import gregtech.api.metatileentity.multiblock.CleanroomType;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.Materials.SulfuricAcid;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.common.items.MetaItems.CARBON_MESH;
import static gregtech.common.items.MetaItems.SHAPE_MOLD_BALL;
import static magicbook.gtlitecore.api.GTLiteValues.MINUTE;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.LARGE_CHEMICAL_COMPLEX_RECIPES;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.VACUUM_CHAMBER_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class LargeChemicalComplex {

    public static void init() {
        CatalystRecipes();
        CatalystBedRecipes();

        //  Testing utils
        LARGE_CHEMICAL_COMPLEX_RECIPES.recipeBuilder()
                .notConsumable(CATALYST_INFINITY_MUTATION)
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(Infinity.getFluid(500))
                .EUt(VA[LV])
                .duration(SECOND)
                .buildAndRegister();
    }

    private static void CatalystRecipes() {

        //  Empty Catalyst
        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(20)
                .input(plate, Steel, 8)
                .input(wireFine, Copper, 4)
                .input(screw, Tin, 6)
                .output(CATALYST_BASE)
                .EUt(VA[LV])
                .duration(MINUTE / 2)
                .buildAndRegister();

        ColoredMetalCatalystRecipes();
        InfinityMutationCatalystChain();
        PlatinumGroupCatalystChain();
        PlasticPolymerCatalystChain();
        RubberPolymerCatalystChain();
        AdhesionPromoterCatalystChain();
        IndiumCatalystChain();
        RadioactivityCatalystChain();
        RareEarthCatalystChain();
        NaquadahCatalystChain();
        RawIntelligenceCatalystChain();
        UltimatePlasticCatalystChain();
        BiologicalIntelligenceCatalystChain();
        TemporalHarmonyCatalystChain();
        FlawlessWaterCatalystChain();
        PhotoelectronicCatalystChain();
        ParticleAccelerationCatalystChain();
        SynchrotronCapableCatalystChain();
    }

    private static void ColoredMetalCatalystRecipes() {

        //  Green Metal Catalyst
        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(24)
                .input(CATALYST_BASE, 10)
                .input(dust, Aluminium, 4)
                .input(dust, Silver, 4)
                .output(CATALYST_GREEN_METAL, 10)
                .EUt(VA[LV])
                .duration(20 * SECOND)
                .buildAndRegister();

        //  Red Metal Catalyst
        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(25)
                .input(CATALYST_BASE, 10)
                .input(dust, Iron, 2)
                .input(dust, Copper, 2)
                .output(CATALYST_RED_METAL, 10)
                .EUt(VA[LV])
                .duration(20 * SECOND)
                .buildAndRegister();

        //  Yellow Metal Catalyst
        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(22)
                .input(CATALYST_BASE, 10)
                .input(dust, Tungsten, 4)
                .input(dust, Nickel, 4)
                .output(CATALYST_YELLOW_METAL, 10)
                .EUt(VA[EV])
                .duration(MINUTE)
                .buildAndRegister();

        //  Blue Metal Catalyst
        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(18)
                .input(CATALYST_BASE, 10)
                .input(dust, Cobalt, 3)
                .input(dust, Titanium, 3)
                .output(CATALYST_BLUE_METAL, 10)
                .EUt(VA[HV])
                .duration(40 * SECOND)
                .buildAndRegister();

        //  Orange Metal Catalyst
        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(28)
                .input(CATALYST_BASE, 10)
                .input(dust, Vanadium, 5)
                .input(dust, Palladium, 5)
                .output(CATALYST_ORANGE_METAL, 10)
                .EUt(VA[HV])
                .duration(40 * SECOND)
                .buildAndRegister();

        //  Purple Metal Catalyst
        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(16)
                .input(CATALYST_BASE, 10)
                .input(dust, Iridium, 6)
                .input(dust, Ruthenium, 6)
                .output(CATALYST_PURPLE_METAL, 10)
                .EUt(VA[IV])
                .duration(2 * MINUTE)
                .buildAndRegister();

        //  Brown Metal Catalyst
        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(14)
                .input(CATALYST_BASE, 10)
                .input(dust, Nickel, 4)
                .input(dust, Aluminium, 4)
                .output(CATALYST_BROWN_METAL, 10)
                .EUt(VA[LV])
                .duration(15 * SECOND)
                .buildAndRegister();

        //  Pink Metal Catalyst
        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(12)
                .input(CATALYST_BASE, 10)
                .input(dust, Platinum, 4)
                .input(dust, Rhodium, 4)
                .output(CATALYST_PINK_METAL, 10)
                .EUt(VA[EV])
                .duration(MINUTE / 2)
                .buildAndRegister();

        //  Formaldehyde Catalyst
        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(13)
                .input(CATALYST_BASE, 4)
                .input(dust, Iron, 8)
                .input(dust, Vanadium)
                .output(CATALYST_FORMALDEHYDE, 4)
                .EUt(VHA[HV])
                .duration(MINUTE / 2)
                .buildAndRegister();

        //  Solid Acid Catalyst
        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(14)
                .input(CATALYST_BASE, 5)
                .input(dust, Lapis, 2)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .output(CATALYST_SOLID_ACID, 5)
                .EUt(VA[EV])
                .duration(MINUTE / 2)
                .buildAndRegister();
    }

    private static void InfinityMutationCatalystChain() {}

    private static void PlatinumGroupCatalystChain() {}

    private static void PlasticPolymerCatalystChain() {

        //  CrO3 + SiO2 -> (CrO3)(SiO2)
        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .input(dust, ChromiumTrioxide, 4)
                .input(dust, SilicaGel, 3)
                .circuitMeta(2)
                .output(dust, PhillipsChromiumCatalyst, 7)
                .EUt(VA[MV])
                .duration(15 * SECOND)
                .buildAndRegister();

        //  CoO + 2C2H4O2 -> Co(C2H3O2)2 + H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, CobaltOxide, 2)
                .fluidInputs(AceticAcid.getFluid(2000))
                .output(dust, CobaltAcetate, 15)
                .fluidOutputs(Water.getFluid(1000))
                .EUt(VA[MV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  Plastic Polymer
        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(11)
                .input(CATALYST_BASE, 6)
                .input(dust, PhillipsChromiumCatalyst, 14) // 2
                .input(dust, CobaltAcetate, 30) // 2
                .fluidInputs(Nitrogen.getFluid(600))
                .output(CATALYST_PLASTIC_POLYMER, 6)
                .EUt(VA[LuV])
                .duration(MINUTE)
                .buildAndRegister();
    }

    private static void RubberPolymerCatalystChain() {}

    private static void AdhesionPromoterCatalystChain() {}

    private static void IndiumCatalystChain() {}

    private static void RadioactivityCatalystChain() {}

    private static void RareEarthCatalystChain() {}

    private static void NaquadahCatalystChain() {}

    private static void RawIntelligenceCatalystChain() {}

    private static void UltimatePlasticCatalystChain() {

        //  2Al + 6C2H4 + 6H -> Al2(C2H5)6
        CHEMICAL_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .input(dust, Aluminium, 2)
                .fluidInputs(Ethylene.getFluid(6000))
                .fluidInputs(Hydrogen.getFluid(6000))
                .fluidOutputs(Triethylaluminum.getFluid(1000))
                .EUt(VA[HV])
                .duration(12 * SECOND)
                .buildAndRegister();

        //  Al2(C2H5)6 + TiCl4 -> (Al2(C2H5)6)(TiCl4)
        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_BALL)
                .fluidInputs(Triethylaluminum.getFluid(1000))
                .fluidInputs(TitaniumTetrachloride.getFluid(1000))
                .output(dust, ZieglerNattaCatalyst, 49)
                .EUt(VA[EV])
                .duration(6 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Na + C5H6 -> NaC5H5 + H
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Sodium)
                .fluidInputs(Cyclopentadiene.getFluid(1000))
                .fluidOutputs(SodiumCyclopentadiene.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(1000))
                .EUt(VA[MV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  Zi + 4Cl -> ZiCl4
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Zirconium)
                .circuitMeta(4)
                .fluidInputs(Chlorine.getFluid(4000))
                .output(dust, ZirconiumTetrachloride, 5)
                .EUt(VA[LV])
                .duration((int) (2.5 * SECOND))
                .buildAndRegister();

        //  ZiCl4 + 2NaC5H5-> Zr(C5H5)2Cl2 + 2NaCl
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, ZirconiumTetrachloride, 5)
                .fluidInputs(SodiumCyclopentadiene.getFluid(2000))
                .output(dust, ZirconoceneDichloride, 23)
                .EUt(VA[IV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  Al2(CH3)6 + 2H2O -> 2AlCH3O + 4CH4
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Trimethylaluminium.getFluid(1000))
                .fluidInputs(Water.getFluid(2000))
                .output(dust, Methylaluminoxane, 12)
                .fluidOutputs(Methane.getFluid(4000))
                .EUt(VA[EV])
                .duration(12 * SECOND)
                .buildAndRegister();

        //  Zr(C5H5)2Cl2 + AlCH3O -> (Zr(C5H5)2Cl2)(AlCH3O)
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Methylaluminoxane, 12)
                .input(dust, ZirconoceneDichloride, 23)
                .output(dust, KaminskyCatalyst, 29)
                .EUt(VA[IV])
                .duration((int) (12.5 * SECOND))
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Ultimate Plastic Catalyst
        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(12)
                .input(CATALYST_BASE, 3)
                .input(dust, KaminskyCatalyst, 4) // almost 2/15
                .input(dust, ZieglerNattaCatalyst, 28) // 4/7
                .fluidInputs(Nitrogen.getPlasma(600))
                .output(CATALYST_ULTIMATE_PLASTIC, 3)
                .EUt(VA[UV])
                .duration(MINUTE / 2)
                .buildAndRegister();
    }

    private static void BiologicalIntelligenceCatalystChain() {}

    private static void TemporalHarmonyCatalystChain() {}

    private static void FlawlessWaterCatalystChain() {}

    private static void PhotoelectronicCatalystChain() {}

    private static void ParticleAccelerationCatalystChain() {}

    private static void SynchrotronCapableCatalystChain() {}

    private static void CatalystBedRecipes() {

        //  Empty Catalyst Bed
        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(20)
                .input(frameGt, Polyethylene)
                .input(CARBON_MESH, 2)
                .input(foil, Polyurethane, 4)
                .output(CATALYST_BED_BASE)
                .EUt(VA[MV])
                .duration(MINUTE / 2)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  ULV

        //  LV

        //  MV

        //  HV

        //  EV

        //  IV

        //  LuV

        //  ZPM

        //  UV

        //  UHV

        //  UEV

        //  UIV

        //  UXV

        //  OpV

        //  MAX
    }
}
