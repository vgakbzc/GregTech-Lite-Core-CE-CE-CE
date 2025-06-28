package magicbook.gtlitecore.loaders.chains;

import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtechfoodoption.GTFOMaterialHandler;
import magicbook.gtlitecore.api.unification.GTLiteMaterials;
import net.minecraft.block.material.Material;

import static gregtech.api.GTValues.*;

public class BerylliumScandiumOxideChain {
    public static void init() {
        RecipeMaps.BLAST_RECIPES.recipeBuilder()
                .input(OrePrefix.dust, Materials.Scandium, 2)
                .input(OrePrefix.dust, Materials.Beryllium, 4)
                .fluidInputs(Materials.Oxygen.getFluid(7000))
                .output(OrePrefix.ingot, GTLiteMaterials.BerylliumScandiumOxide, 13)
                .EUt(VA[MV])
                .duration(60 * 20 * 13)
                .blastFurnaceTemp(1728)
                .buildAndRegister();
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(OrePrefix.dustSmall, Materials.CupricOxide)
                .fluidInputs(
                        Materials.Ethanol.getFluid(2000),
                        Materials.Oxygen.getFluid(1000)
                )
                .fluidOutputs(
                        Materials.Water.getFluid(1000),
                        GTFOMaterialHandler.Acetaldehyde.getFluid(2000)
                )
                .EUt(30)
                .duration(860)
                .buildAndRegister();
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(OrePrefix.dustSmall, Materials.SodiumHydroxide)
                .notConsumable(OrePrefix.dustSmall, Materials.Nickel)
                .fluidInputs(
                        GTFOMaterialHandler.Acetaldehyde.getFluid(4000),
                        Materials.Hydrogen.getFluid(3000)
                )
                .fluidOutputs(
                        GTLiteMaterials.Ethylhexanol.getFluid(1000),
                        Materials.Water.getFluid(3000)
                )
                .EUt(24)
                .duration(720)
                .buildAndRegister();
        RecipeMaps.CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(OrePrefix.crushed, Materials.CassiteriteSand, 1)
                .fluidInputs(GTLiteMaterials.DiethylhexylPhosphoricAcid.getFluid(100))
                .output(OrePrefix.crushedPurified, Materials.CassiteriteSand, 1)
                .fluidOutputs(GTLiteMaterials.ScandiumHydroxideSolution.getFluid(100))
                .chancedOutput(OrePrefix.dust, Materials.RareEarth, 1, 1000, 1500)
                .EUt(VA[LV])
                .duration(250)
                .buildAndRegister();
        RecipeMaps.MIXER_RECIPES.recipeBuilder()
                .fluidInputs(
                        Materials.HydrochloricAcid.getFluid(3000),
                        GTLiteMaterials.ScandiumHydroxideSolution.getFluid(1000)
                )
                .fluidOutputs(
                        Materials.Water.getFluid(875)
                )
                .output(OrePrefix.dust, GTLiteMaterials.ScandiumChloride, 4)
                .EUt(30)
                .duration(200)
                .buildAndRegister();
        RecipeMaps.BLAST_RECIPES.recipeBuilder()
                .input(OrePrefix.dust, GTLiteMaterials.ScandiumChloride, 8)
                .fluidInputs(Materials.Steam.getFluid(3000))
                .output(OrePrefix.dust, GTLiteMaterials.ScandiumOxide, 5)
                .fluidOutputs(Materials.HydrochloricAcid.getFluid(6000))
                .EUt(90)
                .duration(900)
                .blastFurnaceTemp(1536)
                .buildAndRegister();
    }
}
