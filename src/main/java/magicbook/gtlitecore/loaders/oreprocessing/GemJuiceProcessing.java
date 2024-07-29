package magicbook.gtlitecore.loaders.oreprocessing;

import static gregtech.api.GTValues.MV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.recipes.RecipeMaps.BLAST_RECIPES;
import static gregtech.api.recipes.RecipeMaps.CENTRIFUGE_RECIPES;
import static gregtech.api.recipes.RecipeMaps.MIXER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static magicbook.gtlitecore.api.GTLiteValues.MINUTE;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class GemJuiceProcessing {

    public static void init() {

        //  Green Sapphire Juice
        MIXER_RECIPES.recipeBuilder()
                .input(crushed, GreenSapphire)
                .input(dustTiny, SodiumHydroxide)
                .circuitMeta(1)
                .fluidInputs(HydrochloricAcid.getFluid(1000))
                .fluidOutputs(GreenSapphireJuice.getFluid(1000))
                .EUt(VA[MV])
                .duration(2 * SECOND)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(crushedPurified, GreenSapphire)
                .input(dustTiny, SodiumHydroxide)
                .circuitMeta(1)
                .fluidInputs(HydrochloricAcid.getFluid(1000))
                .fluidOutputs(GreenSapphireJuice.getFluid(1000))
                .EUt(VA[MV])
                .duration(2 * SECOND)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dustImpure, GreenSapphire)
                .input(dustTiny, SodiumHydroxide)
                .circuitMeta(1)
                .fluidInputs(HydrochloricAcid.getFluid(1000))
                .fluidOutputs(GreenSapphireJuice.getFluid(1000))
                .EUt(VA[MV])
                .duration(2 * SECOND)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dustPure, GreenSapphire)
                .input(dustTiny, SodiumHydroxide)
                .circuitMeta(1)
                .fluidInputs(HydrochloricAcid.getFluid(1000))
                .fluidOutputs(GreenSapphireJuice.getFluid(1000))
                .EUt(VA[MV])
                .duration(2 * SECOND)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(GreenSapphireJuice.getFluid(1000))
                .output(dust, AluminiumHydroxide, 3)
                .chancedOutput(dust, Iron, 300, 150)
                .chancedOutput(dust, Vanadium, 200, 100)
                .chancedOutput(dust, Manganese, 200, 100)
                .chancedOutput(dust, Beryllium, 200, 100)
                .fluidOutputs(HydrochloricAcid.getFluid(1000))
                .EUt(VA[MV])
                .duration((int) (2.25 * SECOND))
                .buildAndRegister();

        //  Sapphire Juice
        MIXER_RECIPES.recipeBuilder()
                .input(crushed, Sapphire)
                .input(dustTiny, SodiumHydroxide)
                .circuitMeta(1)
                .fluidInputs(HydrochloricAcid.getFluid(1000))
                .fluidOutputs(SapphireJuice.getFluid(1000))
                .EUt(VA[MV])
                .duration(2 * SECOND)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(crushedPurified, Sapphire)
                .input(dustTiny, SodiumHydroxide)
                .circuitMeta(1)
                .fluidInputs(HydrochloricAcid.getFluid(1000))
                .fluidOutputs(SapphireJuice.getFluid(1000))
                .EUt(VA[MV])
                .duration(2 * SECOND)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dustImpure, Sapphire)
                .input(dustTiny, SodiumHydroxide)
                .circuitMeta(1)
                .fluidInputs(HydrochloricAcid.getFluid(1000))
                .fluidOutputs(SapphireJuice.getFluid(1000))
                .EUt(VA[MV])
                .duration(2 * SECOND)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dustPure, Sapphire)
                .input(dustTiny, SodiumHydroxide)
                .circuitMeta(1)
                .fluidInputs(HydrochloricAcid.getFluid(1000))
                .fluidOutputs(SapphireJuice.getFluid(1000))
                .EUt(VA[MV])
                .duration(2 * SECOND)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(SapphireJuice.getFluid(1000))
                .output(dust, AluminiumHydroxide, 3)
                .chancedOutput(dust, Iron, 300, 150)
                .chancedOutput(dust, Vanadium, 200, 100)
                .chancedOutput(dust, Magnesium, 200, 100)
                .fluidOutputs(HydrochloricAcid.getFluid(1000))
                .EUt(VA[MV])
                .duration((int) (2.25 * SECOND))
                .buildAndRegister();

        //  Ruby Juice
        MIXER_RECIPES.recipeBuilder()
                .input(crushed, Ruby)
                .input(dustTiny, SodiumHydroxide)
                .circuitMeta(1)
                .fluidInputs(HydrochloricAcid.getFluid(1000))
                .fluidOutputs(RubyJuice.getFluid(1000))
                .EUt(VA[MV])
                .duration(2 * SECOND)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(crushedPurified, Ruby)
                .input(dustTiny, SodiumHydroxide)
                .circuitMeta(1)
                .fluidInputs(HydrochloricAcid.getFluid(1000))
                .fluidOutputs(RubyJuice.getFluid(1000))
                .EUt(VA[MV])
                .duration(2 * SECOND)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dustImpure, Ruby)
                .input(dustTiny, SodiumHydroxide)
                .circuitMeta(1)
                .fluidInputs(HydrochloricAcid.getFluid(1000))
                .fluidOutputs(RubyJuice.getFluid(1000))
                .EUt(VA[MV])
                .duration(2 * SECOND)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dustPure, Ruby)
                .input(dustTiny, SodiumHydroxide)
                .circuitMeta(1)
                .fluidInputs(HydrochloricAcid.getFluid(1000))
                .fluidOutputs(RubyJuice.getFluid(1000))
                .EUt(VA[MV])
                .duration(2 * SECOND)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(RubyJuice.getFluid(1000))
                .output(dust, AluminiumHydroxide, 3)
                .chancedOutput(dust, Chrome, 5000, 1000)
                .chancedOutput(dust, Iron, 300, 150)
                .chancedOutput(dust, Vanadium, 200, 100)
                .chancedOutput(dust, Magnesium, 200, 100)
                .fluidOutputs(HydrochloricAcid.getFluid(1000))
                .EUt(VA[MV])
                .duration((int) (2.25 * SECOND))
                .buildAndRegister();

        //  Al2O3 + 3H -> 2Al + 3H2O
        BLAST_RECIPES.recipeBuilder()
                .input(dust, Alumina, 5)
                .circuitMeta(1)
                .fluidInputs(Hydrogen.getFluid(3000))
                .output(ingot, Aluminium, 2)
                .fluidOutputs(Steam.getFluid(3000))
                .EUt(VA[MV])
                .duration(MINUTE + 20 * SECOND)
                .blastFurnaceTemp(963) // Cupronickel coil
                .buildAndRegister();

        //  2Al2O3 + 3C -> 4Al + 3CO2
        BLAST_RECIPES.recipeBuilder()
                .input(dust, Alumina, 10)
                .input(dust, Carbon, 3)
                .circuitMeta(2)
                .output(ingot, Aluminium, 4)
                .fluidOutputs(CarbonDioxide.getFluid(3000))
                .EUt(VA[MV])
                .duration(MINUTE)
                .blastFurnaceTemp(2054) // Kanthal coil
                .buildAndRegister();
    }
}
