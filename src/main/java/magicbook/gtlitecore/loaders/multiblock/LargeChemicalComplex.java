package magicbook.gtlitecore.loaders.multiblock;

import gregtech.api.metatileentity.multiblock.CleanroomType;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.Materials.SulfuricAcid;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.common.items.MetaItems.CARBON_MESH;
import static magicbook.gtlitecore.api.GTLiteValues.MINUTE;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.LARGE_CHEMICAL_COMPLEX_RECIPES;
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

            //  Infinity Mutation
            //ASSEMBLER_RECIPES.recipeBuilder()
            //        .circuitMeta(15)
            //        .input(CATALYST_BASE, 5)
            //        .input(dust, Infinity)
            //        .input(dust, Naquadria, 10)
            //        .output(CATALYST_INFINITY_MUTATION, 5)
            //        .EUt(VA[UHV])
            //        .duration(5 * SECOND)
            //        .buildAndRegister();

            //  Platinum Group
            //ASSEMBLER_RECIPES.recipeBuilder()
            //        .circuitMeta(10)
            //        .input(CATALYST_BASE, 2)
            //        .input(dust, RhodiumPlatedPalladium, 64)
            //        .input(dust, Osmiridium, 64)
            //        .input(swarm, Ruridit, 16)
            //        .fluidInputs(Helium.getPlasma(360))
            //        .output(CATALYST_PLATINUM_GROUP, 2)
            //        .EUt(VA[UV])
            //        .duration(MINUTE / 2)
            //        .buildAndRegister();

            //  Plastic Polymer
            //ASSEMBLER_RECIPES.recipeBuilder()
            //        .circuitMeta(11)
            //        .input(CATALYST_BASE, 6)
            //        .input(dust, Polybenzimidazole, 64)
            //        .input(dust, Polytetrafluoroethylene, 64)
            //        .input(swarm, Carbon, 32)
            //        .fluidInputs(Argon.getPlasma(360))
            //        .output(CATALYST_PLASTIC_POLYMER, 6)
            //        .EUt(VA[LuV])
            //        .duration(MINUTE)
            //        .buildAndRegister();

            //  Rubber Polymer
            //ASSEMBLER_RECIPES.recipeBuilder()
            //        .circuitMeta(17)
            //        .input(CATALYST_BASE, 3)
            //        .input(dust, StyreneButadieneRubber, 64)
            //        .input(dust, SiliconeRubber, 64)
            //        .input(swarm, )
            //        .output(CATALYST_RUBBER_POLYMER, 3)
            //        .EUt(VA[IV])
            //        .duration(MINUTE)
            //        .buildAndRegister();
    }

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
