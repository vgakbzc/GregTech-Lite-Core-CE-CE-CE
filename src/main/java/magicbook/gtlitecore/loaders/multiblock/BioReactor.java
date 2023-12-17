package magicbook.gtlitecore.loaders.multiblock;

import gregtech.api.metatileentity.multiblock.CleanroomType;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.BZMedium;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.BIO_CELL;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.BIO_DISH;

public class BioReactor {

    public static void init() {

        //  some vanilla biological recipes
        BIO_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Bacteria.getFluid(1000))
                .fluidInputs(Biomass.getFluid(1000))
                .fluidOutputs(BacterialSludge.getFluid(1000))
                .EUt(VA[EV])
                .duration(600)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .buildAndRegister();

        BIO_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Osmiridium)
                .circuitMeta(1)
                .fluidInputs(Bacteria.getFluid(500))
                .fluidInputs(SterileGrowthMedium.getFluid(500))
                .output(STEM_CELLS, 32)
                .fluidOutputs(BacterialSludge.getFluid(500))
                .EUt(VA[LuV])
                .duration(300)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .buildAndRegister();

        BIO_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(PETRI_DISH)
                .circuitMeta(2)
                .fluidInputs(Bacteria.getFluid(1000))
                .fluidInputs(SterileGrowthMedium.getFluid(1000))
                .output(STEM_CELLS, 64)
                .fluidOutputs(BacterialSludge.getFluid(1000))
                .EUt(VA[UV])
                .duration(100)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .buildAndRegister();

        BIO_REACTOR_RECIPES.recipeBuilder()
                .input(PETRI_DISH)
                .input(dust, Agar, 16)
                .input(dust, Tritanium)
                .fluidInputs(Biomass.getFluid(6000))
                .fluidInputs(SterileGrowthMedium.getFluid(6000))
                .output(BIO_DISH)
                .EUt(VA[ZPM])
                .duration(200)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .buildAndRegister();

        BIO_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(BIO_DISH)
                .input(STEM_CELLS, 32)
                .fluidInputs(BZMedium.getFluid(3000))
                .fluidInputs(Argon.getPlasma(3000))
                .output(BIO_CELL, 32)
                .EUt(VA[UV])
                .duration(100)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .buildAndRegister();
    }
}
