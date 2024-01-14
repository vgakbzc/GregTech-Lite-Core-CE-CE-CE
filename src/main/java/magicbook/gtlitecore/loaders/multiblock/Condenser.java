package magicbook.gtlitecore.loaders.multiblock;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix.*;

public class Condenser {

    public static void init() {

        MagicSingularities();
        MetricSingularities();
    }

    private static void MagicSingularities() {

        //  Naquadah Singularity
        CONDENSER_RECIPES.recipeBuilder()
                .input(block, Naquadah, 64)
                .output(singularity, Naquadah)
                .EUt(VA[IV])
                .duration((int) Naquadah.getMass())
                .buildAndRegister();

        //  Enriched Naquadah Singularity
        CONDENSER_RECIPES.recipeBuilder()
                .input(block, NaquadahEnriched, 64)
                .output(singularity, NaquadahEnriched)
                .EUt(VA[IV])
                .duration((int) NaquadahEnriched.getMass())
                .buildAndRegister();

        //  Naquadria Singularity
        CONDENSER_RECIPES.recipeBuilder()
                .input(block, Naquadria, 64)
                .output(singularity, Naquadria)
                .EUt(VA[IV])
                .duration((int) Naquadria.getMass())
                .buildAndRegister();

        //  Orichalcum Singularity
        CONDENSER_RECIPES.recipeBuilder()
                .input(block, Orichalcum, 64)
                .output(singularity, Orichalcum)
                .EUt(VA[IV])
                .duration((int) Orichalcum.getMass())
                .buildAndRegister();

        //  Adamantium Singularity
        CONDENSER_RECIPES.recipeBuilder()
                .input(block, Adamantium, 64)
                .output(singularity, Adamantium)
                .EUt(VA[IV])
                .duration((int) Adamantium.getMass())
                .buildAndRegister();

        //  Vibranium Singularity
        CONDENSER_RECIPES.recipeBuilder()
                .input(block, Vibranium, 64)
                .output(singularity, Vibranium)
                .EUt(VA[IV])
                .duration((int) Vibranium.getMass())
                .buildAndRegister();

        //  Taranium Singularity
        CONDENSER_RECIPES.recipeBuilder()
                .input(block, Taranium, 64)
                .output(singularity, Taranium)
                .EUt(VA[IV])
                .duration((int) Taranium.getMass())
                .buildAndRegister();

        //  Mithril Singularity
        CONDENSER_RECIPES.recipeBuilder()
                .input(block, Mithril, 64)
                .output(singularity, Mithril)
                .EUt(VA[IV])
                .duration((int) Mithril.getMass())
                .buildAndRegister();

        //  Solarium Singularity
        CONDENSER_RECIPES.recipeBuilder()
                .input(block, Solarium, 64)
                .output(singularity, Solarium)
                .EUt(VA[IV])
                .duration((int) Solarium.getMass())
                .buildAndRegister();

        //  Luna Silver Singularity
        CONDENSER_RECIPES.recipeBuilder()
                .input(block, LunaSilver, 64)
                .output(singularity, LunaSilver)
                .EUt(VA[IV])
                .duration((int) LunaSilver.getMass())
                .buildAndRegister();

        //  Neutronium Singularity
        CONDENSER_RECIPES.recipeBuilder()
                .input(block, Neutronium, 64)
                .output(singularity, Neutronium)
                .EUt(VA[IV])
                .duration((int) Neutronium.getMass())
                .buildAndRegister();

        //  Nether Star Singularity
        CONDENSER_RECIPES.recipeBuilder()
                .input(block, NetherStar, 64)
                .output(singularity, NetherStar)
                .EUt(VA[IV])
                .duration((int) NetherStar.getMass())
                .buildAndRegister();

        //  Glowstone Singularity
        CONDENSER_RECIPES.recipeBuilder()
                .input(block, Glowstone, 64)
                .output(singularity, Glowstone)
                .EUt(VA[IV])
                .duration((int) Glowstone.getMass())
                .buildAndRegister();

        //  Ichorium Singularity
        CONDENSER_RECIPES.recipeBuilder()
                .input(block, Ichorium, 64)
                .output(singularity, Ichorium)
                .EUt(VA[IV])
                .duration((int) Ichorium.getMass())
                .buildAndRegister();

        //  Crystal Matrix Singularity
        CONDENSER_RECIPES.recipeBuilder()
                .input(block, CrystalMatrix, 64)
                .output(singularity, CrystalMatrix)
                .EUt(VA[IV])
                .duration((int) CrystalMatrix.getMass())
                .buildAndRegister();

        //  Infinity Singularity
        CONDENSER_RECIPES.recipeBuilder()
                .input(block, Infinity, 64)
                .output(singularity, Infinity)
                .EUt(VA[IV])
                .duration((int) Infinity.getMass())
                .buildAndRegister();
    }

    private static void MetricSingularities() {

        //  Iron Singularity
        CONDENSER_RECIPES.recipeBuilder()
                .input(block, Iron, 64)
                .output(singularity, Iron)
                .EUt(VA[IV])
                .duration((int) Iron.getMass())
                .buildAndRegister();

        //  Copper Singularity
        CONDENSER_RECIPES.recipeBuilder()
                .input(block, Copper, 64)
                .output(singularity, Copper)
                .EUt(VA[IV])
                .duration((int) Copper.getMass())
                .buildAndRegister();

        //  Tin Singularity
        CONDENSER_RECIPES.recipeBuilder()
                .input(block, Tin, 64)
                .output(singularity, Tin)
                .EUt(VA[IV])
                .duration((int) Tin.getMass())
                .buildAndRegister();

        //  Gold Singularity
        CONDENSER_RECIPES.recipeBuilder()
                .input(block, Gold, 64)
                .output(singularity, Gold)
                .EUt(VA[IV])
                .duration((int) Gold.getMass())
                .buildAndRegister();

        //  Silver Singularity
        CONDENSER_RECIPES.recipeBuilder()
                .input(block, Silver, 64)
                .output(singularity, Silver)
                .EUt(VA[IV])
                .duration((int) Silver.getMass())
                .buildAndRegister();

        //  Lead Singularity
        CONDENSER_RECIPES.recipeBuilder()
                .input(block, Lead, 64)
                .output(singularity, Lead)
                .EUt(VA[IV])
                .duration((int) Lead.getMass())
                .buildAndRegister();

        //  Zinc Singularity
        CONDENSER_RECIPES.recipeBuilder()
                .input(block, Zinc, 64)
                .output(singularity, Zinc)
                .EUt(VA[IV])
                .duration((int) Zinc.getMass())
                .buildAndRegister();

        //  Titanium Singularity
        CONDENSER_RECIPES.recipeBuilder()
                .input(block, Titanium, 64)
                .output(singularity, Titanium)
                .EUt(VA[IV])
                .duration((int) Titanium.getMass())
                .buildAndRegister();

        //  Tungsten Singularity
        CONDENSER_RECIPES.recipeBuilder()
                .input(block, Tungsten, 64)
                .output(singularity, Tungsten)
                .EUt(VA[IV])
                .duration((int) Tungsten.getMass())
                .buildAndRegister();

        //  Vanadium Singularity
        CONDENSER_RECIPES.recipeBuilder()
                .input(block, Vanadium, 64)
                .output(singularity, Vanadium)
                .EUt(VA[IV])
                .duration((int) Vanadium.getMass())
                .buildAndRegister();

        //  Platinum Singularity
        CONDENSER_RECIPES.recipeBuilder()
                .input(block, Platinum, 64)
                .output(singularity, Platinum)
                .EUt(VA[IV])
                .duration((int) Platinum.getMass())
                .buildAndRegister();

        //  Palladium Singularity
        CONDENSER_RECIPES.recipeBuilder()
                .input(block, Palladium, 64)
                .output(singularity, Palladium)
                .EUt(VA[IV])
                .duration((int) Palladium.getMass())
                .buildAndRegister();

        //  Ruthenium Singularity
        CONDENSER_RECIPES.recipeBuilder()
                .input(block, Ruthenium, 64)
                .output(singularity, Ruthenium)
                .EUt(VA[IV])
                .duration((int) Ruthenium.getMass())
                .buildAndRegister();

        //  Rhodium Singularity
        CONDENSER_RECIPES.recipeBuilder()
                .input(block, Rhodium, 64)
                .output(singularity, Rhodium)
                .EUt(VA[IV])
                .duration((int) Rhodium.getMass())
                .buildAndRegister();

        //  Iridium Singularity
        CONDENSER_RECIPES.recipeBuilder()
                .input(block, Iridium, 64)
                .output(singularity, Iridium)
                .EUt(VA[IV])
                .duration((int) Iridium.getMass())
                .buildAndRegister();

        //  Osmium Singularity
        CONDENSER_RECIPES.recipeBuilder()
                .input(block, Osmium, 64)
                .output(singularity, Osmium)
                .EUt(VA[IV])
                .duration((int) Osmium.getMass())
                .buildAndRegister();

    }
}
