package magicbook.gtlitecore.loaders.circuits;

import gregtech.api.metatileentity.multiblock.CleanroomType;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class SupracausalCircuits {

    public static void init() {
        SMDs();
    }

    private static void SMDs() {

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireFine, WhiteDwarfMatter, 8)
                .input(plate, NeutroniumNanotube)
                .input(plate, Periodicium)
                .fluidInputs(FullerenePolymerMatrix.getFluid(L * 2))
                .output(SUPRACAUSAL_TRANSISTOR, 32)
                .EUt(VA[UIV])
                .duration(160)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CVD_UNIT_RECIPES.recipeBuilder()
                .input(dust, ChargedCaesiumCeriumCobaltIndiumAlloy)
                .input(wireFine, QuantumchromodynamicallyConfinedMatter, 4)
                .fluidInputs(FullerenePolymerMatrix.getFluid(L * 2))
                .output(SUPRACAUSAL_RESISTOR, 32)
                .EUt(VA[UIV])
                .duration(160)
                .temperature(6675)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_CVD_UNIT_RECIPES.recipeBuilder()
                .input(plate, Hypogen)
                .input(wireFine, BlackDwarfMatter, 8)
                .fluidInputs(FullerenePolymerMatrix.getFluid(L * 2))
                .output(SUPRACAUSAL_CAPACITOR, 32)
                .EUt(VA[UIV])
                .duration(160)
                .temperature(7432)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(dust, Spacetime)
                .input(dust, MagnetoHydrodynamicallyConstrainedStarMatter)
                .input(wireFine, HeavyQuarkDegenerateMatter, 8)
                .fluidInputs(FullerenePolymerMatrix.getFluid(L * 2))
                .output(SUPRACAUSAL_DIODE, 32)
                .EUt(VA[UIV])
                .duration(160)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ION_IMPLANTATOR_RECIPES.recipeBuilder()
                .input(ring, TantalumHafniumSeaborgiumCarbide)
                .input(wireFine, CosmicNeutronium, 4)
                .fluidInputs(FullerenePolymerMatrix.getFluid(L * 2))
                .output(SUPRACAUSAL_INDUCTOR, 32)
                .EUt(VA[UIV])
                .duration(160)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }
}
