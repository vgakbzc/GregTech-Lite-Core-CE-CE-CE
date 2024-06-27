package magicbook.gtlitecore.integration.appliedenergistics2.recipes;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.stack.UnificationEntry;
import magicbook.gtlitecore.api.utils.Mods;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.integration.appliedenergistics2.utils.AE2RecipeHandler.removeInscriberRecipe;

public class AE2MiscRecipes {

    public static void init() {

        //  Quartz Glass
        ModHandler.removeRecipeByName(Mods.AppliedEnergistics2.getID() + ":" + "decorative/quartz_glass");
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .inputs(new ItemStack(Blocks.GLASS))
                .input(dust, Quartzite, 2)
                .outputs(Mods.AppliedEnergistics2.getItemByID("quartz_glass", 2))
                .EUt(VA[LV])
                .duration(4 * SECOND)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .inputs(new ItemStack(Blocks.GLASS))
                .input(dust, NetherQuartz, 2)
                .outputs(Mods.AppliedEnergistics2.getItemByID("quartz_glass", 2))
                .EUt(VA[LV])
                .duration(2 * SECOND)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .inputs(new ItemStack(Blocks.GLASS))
                .input(dust, CertusQuartz, 2)
                .outputs(Mods.AppliedEnergistics2.getItemByID( "quartz_glass", 2))
                .EUt(VA[LV])
                .duration(SECOND)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .inputs(new ItemStack(Blocks.GLASS))
                .input(dust, Fluix, 2)
                .outputs(Mods.AppliedEnergistics2.getItemByID("quartz_glass", 4))
                .EUt(VA[LV])
                .duration(SECOND)
                .buildAndRegister();

        //  Vibrant Quartz Glass
        ModHandler.removeRecipeByOutput(Mods.AppliedEnergistics2.getItemByID("quartz_vibrant_glass"));
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .inputs(Mods.AppliedEnergistics2.getItemByID("quartz_glass"))
                .input(dust, Glowstone, 2)
                .outputs(Mods.AppliedEnergistics2.getItemByID("quartz_vibrant_glass"))
                .EUt(VA[LV])
                .duration(SECOND)
                .buildAndRegister();

        //  Wireless Receiver
        ModHandler.removeRecipeByOutput(Mods.AppliedEnergistics2.getMetaItemByID("material", 41));
        ModHandler.addShapedRecipe(true, "wireless_receiver", Mods.AppliedEnergistics2.getMetaItemByID("material", 41),
                " E ", "POP", " P ",
                'P', new UnificationEntry(plate, CertusQuartz),
                'E', Mods.AppliedEnergistics2.getMetaItemByID("material", 9), // Fluix Pearl
                'O', Mods.AppliedEnergistics2.getMetaItemByID("part", 140));  // Quartz Fiber

        //  Wireless Booster
        ModHandler.removeRecipeByOutput(Mods.AppliedEnergistics2.getMetaItemByID("material", 42));
        ModHandler.addShapedRecipe(true, "wireless_booster", Mods.AppliedEnergistics2.getMetaItemByID("material", 42),
                "   ", "DOE", "PPP",
                'D', Mods.AppliedEnergistics2.getMetaItemByID("material", 1), // Charged Certus Crystal
                'E', new UnificationEntry(dust, EnderPearl),
                'P', new UnificationEntry(plate, ElectricalSteel),
                'O', Mods.AppliedEnergistics2.getMetaItemByID("part", 140));  // Quartz Fiber

        //  Basic Card
        ModHandler.removeRecipeByOutput(Mods.AppliedEnergistics2.getMetaItemByID("material", 25));
        ModHandler.addShapedRecipe(true, "basic_card", Mods.AppliedEnergistics2.getMetaItemByID("material", 25, 16),
                "PA ", "RXA", "PA ",
                'P', new UnificationEntry(plate, Gold),
                'R', new UnificationEntry(wireFine, RedAlloy),
                'A', new UnificationEntry(plate, Iron),
                'X', Mods.AppliedEnergistics2.getMetaItemByID("material", 23)); // Calculation Processor

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(plate, Gold, 2)
                .input(plate, Iron, 3)
                .input(wireFine, RedAlloy)
                .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 23)) // Calculation Processor
                .outputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 25, 16))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Advanced Card
        ModHandler.removeRecipeByOutput(Mods.AppliedEnergistics2.getMetaItemByID("material", 28));
        ModHandler.addShapedRecipe(true, "advanced_card", Mods.AppliedEnergistics2.getMetaItemByID("material", 28, 16),
                "PA ", "RXA", "PA ",
                'P', new UnificationEntry(plate, Electrum),
                'R', new UnificationEntry(wireFine, RedstoneAlloy),
                'A', new UnificationEntry(plate, ElectricalSteel),
                'X', Mods.AppliedEnergistics2.getMetaItemByID("material", 25)); // Basic Card

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(plate, Electrum, 2)
                .input(plate, ElectricalSteel, 3)
                .input(wireFine, RedstoneAlloy)
                .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 25)) // Basic Card
                .outputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 28, 16)) // Advanced Card
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Quantum Link Card
        removeInscriberRecipe(Mods.AppliedEnergistics2.getMetaItemByID("material", 59));
        ModHandler.addShapedRecipe(true, "quantum_link_card", Mods.AppliedEnergistics2.getMetaItemByID("material", 59),
                "EXS", "QCQ", "SXE",
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.MV),
                'E', EMITTER_LV,
                'S', SENSOR_LV,
                'C', Mods.AppliedEnergistics2.getMetaItemByID("material", 28), // Advanced Card
                'Q', Mods.AppliedEnergistics2.getMetaItemByID("material", 47)); // Singularity

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 28))
                .input(circuit, MarkerMaterials.Tier.MV, 2)
                .input(EMITTER_LV, 2)
                .input(SENSOR_LV, 2)
                .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 47, 2))
                .outputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 59))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Sky Stone Process
        MACERATOR_RECIPES.recipeBuilder()
                .inputs(Mods.AppliedEnergistics2.getItemByID("sky_stone_block"))
                .outputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 45)) // Sky Stone Dust
                .EUt(VA[ULV])
                .duration(45)
                .buildAndRegister();

        //  Allowed Rock Breaker product Sky Stone Block.
        ROCK_BREAKER_RECIPES.recipeBuilder()
                .notConsumable(Mods.AppliedEnergistics2.getItemByID("sky_stone_block"))
                .outputs(Mods.AppliedEnergistics2.getItemByID("sky_stone_block"))
                .EUt(VHA[MV])
                .duration(4 * SECOND)
                .buildAndRegister();

        //  Allowed player centrifuge Sky Stone Dust to get some Certus Quartz dust.
        CENTRIFUGE_RECIPES.recipeBuilder()
                .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 45, 9))
                .output(dust, CertusQuartz, 3)
                .output(dust, Ash, 2)
                .output(dust, Stone, 4)
                .EUt(VA[MV])
                .duration((int) (4.5 * SECOND))
                .buildAndRegister();

        //  Mini TNT
        ModHandler.removeRecipeByOutput(Mods.AppliedEnergistics2.getItemByID("tiny_tnt"));
        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(GELLED_TOLUENE, 2)
                .fluidInputs(SulfuricAcid.getFluid(100))
                .outputs(Mods.AppliedEnergistics2.getItemByID("tiny_tnt"))
                .EUt(VA[ULV])
                .duration(SECOND)
                .buildAndRegister();

        //  Sky Compass
        ModHandler.removeRecipeByOutput(Mods.AppliedEnergistics2.getItemByID("sky_compass"));
        ModHandler.addShapedRecipe(true, "sky_compass", Mods.AppliedEnergistics2.getItemByID("sky_compass"),
                " P ", "PCP", " P ",
                'P', new UnificationEntry(plate, DarkSteel),
                'C', Mods.AppliedEnergistics2.getMetaItemByID("material", 1)); // Charged Certus Quartz

        //  Quartz Fixture
        ModHandler.removeRecipeByName(Mods.AppliedEnergistics2.getID() + ":" + "decorative/quartz_fixture");
        ModHandler.addShapedRecipe(true, "quartz_fixture", Mods.AppliedEnergistics2.getItemByID("quartz_fixture", 4),
                " X ", " R ",
                'R', new UnificationEntry(stick, ElectricalSteel),
                'X', Mods.AppliedEnergistics2.getMetaItemByID("material", 1)); // Charged Certus Quartz

        //  Light Detector
        ModHandler.removeRecipeByOutput(Mods.AppliedEnergistics2.getItemByID("light_detector"));
        ModHandler.addShapedRecipe(true, "light_detector", Mods.AppliedEnergistics2.getItemByID("light_detector", 4),
                " X ", " R ",
                'R', new UnificationEntry(stick, ElectricalSteel),
                'X', new UnificationEntry(gem, NetherQuartz));

    }
}
