package magicbook.gtlitecore.loaders.multiblock;

import gregtech.api.unification.material.Material;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.block;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.CONDENSER_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix.singularity;

public class Condenser {

    public static void init() {
        MagicSingularities();
        MetricSingularities();
    }

    private static void MagicSingularities() {
        createSingularityRecipe(Naquadah, true);
        createSingularityRecipe(NaquadahEnriched, true);
        createSingularityRecipe(Naquadria, true);
        createSingularityRecipe(Orichalcum, true);
        createSingularityRecipe(Adamantium, true);
        createSingularityRecipe(Vibranium, true);
        createSingularityRecipe(Taranium, true);
        createSingularityRecipe(Mithril, true);
        createSingularityRecipe(Solarium, true);
        createSingularityRecipe(LunaSilver, true);
        createSingularityRecipe(Neutronium, true);
        createSingularityRecipe(NetherStar, true);
        createSingularityRecipe(Glowstone, true);
        createSingularityRecipe(Ichorium, true);
        createSingularityRecipe(CrystalMatrix, true);
        createSingularityRecipe(Infinity, true);
    }

    private static void MetricSingularities() {
        createSingularityRecipe(Iron, true);
        createSingularityRecipe(Copper, true);
        createSingularityRecipe(Tin, true);
        createSingularityRecipe(Gold, true);
        createSingularityRecipe(Silver, true);
        createSingularityRecipe(Lead, true);
        createSingularityRecipe(Zinc, true);
        createSingularityRecipe(Titanium, true);
        createSingularityRecipe(Tungsten, true);
        createSingularityRecipe(Vanadium, true);
        createSingularityRecipe(Platinum, true);
        createSingularityRecipe(Palladium, true);
        createSingularityRecipe(Ruthenium, true);
        createSingularityRecipe(Rhodium, true);
        createSingularityRecipe(Iridium, true);
        createSingularityRecipe(Osmium, true);
    }

    private static void createSingularityRecipe(Material material,
                                                boolean isSolid) {
        if (isSolid) {
            CONDENSER_RECIPES.recipeBuilder()
                    .input(block, material, 64)
                    .output(singularity, material)
                    .EUt(VA[IV])
                    .duration((int) material.getMass() * 8)
                    .buildAndRegister();
        } else {
            CONDENSER_RECIPES.recipeBuilder()
                    .fluidInputs(material.getFluid(L * 9 * 64))
                    .output(singularity, material)
                    .EUt(VA[IV])
                    .duration((int) material.getMass() * 8)
                    .buildAndRegister();
        }
    }
}
