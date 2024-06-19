package magicbook.gtlitecore.integration.appliedenergistics2.recipes;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.stack.UnificationEntry;
import magicbook.gtlitecore.api.utils.Mods;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLY_LINE_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.plate;
import static gregtech.api.unification.ore.OrePrefix.wireFine;
import static gregtech.common.metatileentities.MetaTileEntities.QUANTUM_CHEST;
import static gregtech.common.metatileentities.MetaTileEntities.QUANTUM_TANK;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.utils.GTLiteUtils.getItemById;
import static magicbook.gtlitecore.api.utils.GTLiteUtils.getMetaItemById;

public class CellRecipes {

    public static void init() {

        //  Remove all fake recipes of Storage Cells (consists of Item and Fluid).
        ModHandler.removeRecipeByName(Mods.AppliedEnergistics2.getID() + ":" + "network/cells/storage_cell_1k");
        ModHandler.removeRecipeByName(Mods.AppliedEnergistics2.getID() + ":" + "network/cells/storage_cell_4k");
        ModHandler.removeRecipeByName(Mods.AppliedEnergistics2.getID() + ":" + "network/cells/storage_cell_16k");
        ModHandler.removeRecipeByName(Mods.AppliedEnergistics2.getID() + ":" + "network/cells/storage_cell_64k");
        ModHandler.removeRecipeByName(Mods.AppliedEnergistics2.getID() + ":" + "network/cells/fluid_storage_cell_1k");
        ModHandler.removeRecipeByName(Mods.AppliedEnergistics2.getID() + ":" + "network/cells/fluid_storage_cell_4k");
        ModHandler.removeRecipeByName(Mods.AppliedEnergistics2.getID() + ":" + "network/cells/fluid_storage_cell_16k");
        ModHandler.removeRecipeByName(Mods.AppliedEnergistics2.getID() + ":" + "network/cells/fluid_storage_cell_64k");

        //  Remove fake recipes of some misc cells like View Cells.
        ModHandler.removeRecipeByName(Mods.AppliedEnergistics2.getID() + ":" + "network/cells/view_cell");
        ModHandler.removeRecipeByName(Mods.AppliedEnergistics2.getID() + ":" + "network/cells/spatial_storage_cell_2_cubed");
        ModHandler.removeRecipeByName(Mods.AppliedEnergistics2.getID() + ":" + "network/cells/spatial_storage_cell_16_cubed");
        ModHandler.removeRecipeByName(Mods.AppliedEnergistics2.getID() + ":" + "network/cells/spatial_storage_cell_128_cubed");

        // ---------------------------------------------------- ME Storage Housing ----------------------------------------------------
        //  This AE2 Material has 5 recipes (Basic, Advanced, Extreme, Elite, Ultimate), used different plates to get more products,
        //  Basic:    Redstone Alloy,    Electrical Steel;
        //  Advanced: Energetic Alloy,   Pulsating Iron;
        //  Extreme:  Crystalline Alloy, Conductive Iron;
        //  Elite:    Melodic Alloy,     Vibrant Alloy;
        //  Ultimate: Stellar Alloy,     End Steel.
        ModHandler.removeRecipeByOutput(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 39));
        ModHandler.addShapedRecipe(true, "me_storage_housing.basic", getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 39, 4),
                "GPG", "PWP", "AAA",
                'G', getItemById(Mods.AppliedEnergistics2.getID(), "quartz_glass"),
                'P', getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32005), // Ore Dict: plateRedstoneAlloy
                'W', new UnificationEntry(wireFine, BorosilicateGlass),
                'A', getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32001)); // Ore Dict: plateElectricalSteel

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .inputs(getItemById(Mods.AppliedEnergistics2.getID(), "quartz_glass", 2))
                .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32005, 3)) // Ore Dict: plateRedstoneAlloy
                .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32001, 3)) // Ore Dict: plateElectricalSteel
                .input(wireFine, BorosilicateGlass)
                .outputs(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 39, 4))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "me_storage_housing.advanced", getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 39, 8),
                "GPG", "PWP", "AAA",
                'G', getItemById(Mods.AppliedEnergistics2.getID(), "quartz_glass"),
                'P', getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32002), // Ore Dict: plateEnergeticAlloy
                'W', new UnificationEntry(wireFine, BorosilicateGlass),
                'A', getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32007)); // Ore Dict: platePulsatingIron

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .inputs(getItemById(Mods.AppliedEnergistics2.getID(), "quartz_glass", 2))
                .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32002, 3)) // Ore Dict: plateEnergeticAlloy
                .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32007, 3)) // Ore Dict: platePulsatingIron
                .input(wireFine, BorosilicateGlass)
                .outputs(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 39, 8))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "me_storage_housing.extreme", getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 39, 16),
                "GPG", "PWP", "AAA",
                'G', getItemById(Mods.AppliedEnergistics2.getID(), "quartz_glass"),
                'P', getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32009), // Ore Dict: plateCrystallineAlloy
                'W', new UnificationEntry(wireFine, BorosilicateGlass),
                'A', getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32006)); // Ore Dict: plateConductiveIron

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .inputs(getItemById(Mods.AppliedEnergistics2.getID(), "quartz_glass", 2))
                .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32009, 3)) // Ore Dict: plateCrystallineAlloy
                .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32006, 3)) // Ore Dict: plateConductiveIron
                .input(wireFine, BorosilicateGlass)
                .outputs(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 39, 16))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "me_storage_housing.elite", getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 39, 32),
                "GPG", "PWP", "AAA",
                'G', getItemById(Mods.AppliedEnergistics2.getID(), "quartz_glass"),
                'P', getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32010), // Ore Dict: plateMelodicAlloy
                'W', new UnificationEntry(wireFine, BorosilicateGlass),
                'A', getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32003)); // Ore Dict: plateVibrantAlloy

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .inputs(getItemById(Mods.AppliedEnergistics2.getID(), "quartz_glass", 2))
                .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32010, 3)) // Ore Dict: plateMelodicAlloy
                .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32003, 3)) // Ore Dict: plateVibrantAlloy
                .input(wireFine, BorosilicateGlass)
                .outputs(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 39, 32))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "me_storage_housing.ultimate", getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 39, 64),
                "GPG", "PWP", "AAA",
                'G', getItemById(Mods.AppliedEnergistics2.getID(), "quartz_glass"),
                'P', getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32011), // Ore Dict: plateStellarAlloy
                'W', new UnificationEntry(wireFine, BorosilicateGlass),
                'A', getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32004)); // Ore Dict: plateEndSteel

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .inputs(getItemById(Mods.AppliedEnergistics2.getID(), "quartz_glass", 2))
                .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32011, 3)) // Ore Dict: plateStellarAlloy
                .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32004, 3)) // Ore Dict: plateEndSteel
                .input(wireFine, BorosilicateGlass)
                .outputs(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 39, 64))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        // ------------------------------------------------------- Blank Pattern ------------------------------------------------------
        //  This AE2 Material has 5 recipes (Basic, Advanced, Extreme, Elite, Ultimate), used different plates to get more products,
        //  Basic:    Pulsating Iron,         Electrical Steel;
        //  Advanced: Conductive Iron,        Dark Steel;
        //  Extreme:  Energetic Silver,       Soularium;
        //  Elite:    Vivid Alloy,            Vibrant Alloy;
        //  Ultimate: Crystalline Pink Slime, Lumium.
        ModHandler.removeRecipeByOutput(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 52));
        ModHandler.addShapedRecipe(true, "blank_pattern.basic", getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 52, 4),
                "GPG", "PWP", "AAA",
                'G', getItemById(Mods.AppliedEnergistics2.getID(), "quartz_vibrant_glass"),
                'P', getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32007), // Ore Dict: platePulsatingIron
                'W', new UnificationEntry(wireFine, BorosilicateGlass),
                'A', getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32001)); // Ore Dict: plateElectricalSteel

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .inputs(getItemById(Mods.AppliedEnergistics2.getID(), "quartz_vibrant_glass", 2))
                .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32007, 3)) // Ore Dict: platePulsatingIron
                .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32001, 3)) // Ore Dict: plateElectricalSteel
                .input(wireFine, BorosilicateGlass)
                .outputs(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 52, 4))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "blank_pattern.advanced", getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 52, 8),
                "GPG", "PWP", "AAA",
                'G', getItemById(Mods.AppliedEnergistics2.getID(), "quartz_vibrant_glass"),
                'P', getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32006), // Ore Dict: plateConductiveIron
                'W', new UnificationEntry(wireFine, BorosilicateGlass),
                'A', getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32000)); // Ore Dict: plateDarkSteel

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .inputs(getItemById(Mods.AppliedEnergistics2.getID(), "quartz_vibrant_glass", 2))
                .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32006, 3)) // Ore Dict: plateConductiveIron
                .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32000, 3)) // Ore Dict: plateDarkSteel
                .input(wireFine, BorosilicateGlass)
                .outputs(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 52, 8))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "blank_pattern.extreme", getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 52, 16),
                "GPG", "PWP", "AAA",
                'G', getItemById(Mods.AppliedEnergistics2.getID(), "quartz_vibrant_glass"),
                'P', getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32013), // Ore Dict: plateEnergeticSilver
                'W', new UnificationEntry(wireFine, BorosilicateGlass),
                'A', getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32008)); // Ore Dict: plateSoularium

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .inputs(getItemById(Mods.AppliedEnergistics2.getID(), "quartz_vibrant_glass", 2))
                .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32013, 3)) // Ore Dict: plateEnergeticSilver
                .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32008, 3)) // Ore Dict: plateSoularium
                .input(wireFine, BorosilicateGlass)
                .outputs(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 52, 16))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "blank_pattern.elite", getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 52, 32),
                "GPG", "PWP", "AAA",
                'G', getItemById(Mods.AppliedEnergistics2.getID(), "quartz_vibrant_glass"),
                'P', getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32014), // Ore Dict: plateVividAlloy
                'W', new UnificationEntry(wireFine, BorosilicateGlass),
                'A', getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32003)); // Ore Dict: plateVibrantAlloy

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .inputs(getItemById(Mods.AppliedEnergistics2.getID(), "quartz_vibrant_glass", 2))
                .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32014, 3)) // Ore Dict: plateVividAlloy
                .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32003, 3)) // Ore Dict: plateVibrantAlloy
                .input(wireFine, BorosilicateGlass)
                .outputs(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 52, 32))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "blank_pattern.ultimate", getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 52, 64),
                "GPG", "PWP", "AAA",
                'G', getItemById(Mods.AppliedEnergistics2.getID(), "quartz_vibrant_glass"),
                'P', getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32012), // Ore Dict: plateCrystallinePinkSlime
                'W', new UnificationEntry(wireFine, BorosilicateGlass),
                'A', getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32031)); // Ore Dict: plateLumium

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .inputs(getItemById(Mods.AppliedEnergistics2.getID(), "quartz_vibrant_glass", 2))
                .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32012, 3)) // Ore Dict: plateCrystallinePinkSlime
                .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32031, 3)) // Ore Dict: plateLumium
                .input(wireFine, BorosilicateGlass)
                .outputs(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 52, 64))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        // ---------------------------------------------------- Item Storage Cells ----------------------------------------------------
        ModHandler.removeRecipeByOutput(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 35));
        ModHandler.addShapedRecipe(true, "storage_component.item.1k", getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 35, 4),
                "PCP", "CXC", "PCP",
                'P', new UnificationEntry(plate, CertusQuartz),
                'C', new UnificationEntry(plate, Redstone),
                'X', getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 22)); // Logic Processor

        ModHandler.removeRecipeByOutput(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 36));
        ModHandler.addShapedRecipe(true, "storage_component.item.4k", getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 36, 4),
                "PCP", "CXC", "PCP",
                'P', new UnificationEntry(plate, RedAlloy),
                'C', getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 35),  // 1k Item Storage Component
                'X', getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 23)); // Calculation Processor

        ModHandler.removeRecipeByOutput(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 37));
        ModHandler.addShapedRecipe(true, "storage_component.item.16k", getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 37, 4),
                "PCP", "CXC", "PCP",
                'P', new UnificationEntry(plate, Magnalium),
                'C', getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 36),  // 4k Item Storage Component
                'X', getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 24)); // Engineering Processor

        ModHandler.removeRecipeByOutput(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 38));
        if (Mods.CraftTweaker.isModLoaded() && Mods.LazyAE2.isModLoaded()) {
            ModHandler.addShapedRecipe(true, "storage_component.item.64k", getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 38, 4),
                    "PCP", "CXC", "PCP",
                    'P', getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32002),       // Ore Dict: plateEnergeticAlloy
                    'C', getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 37), // 16k Item Storage Component
                    'X', getMetaItemById(Mods.LazyAE2.getID(), "material", 6));             // Parallel Processor
        }

        if (Mods.NeevesAE2Addition.isModLoaded()) {
            ModHandler.removeRecipeByOutput(getMetaItemById(Mods.NeevesAE2Addition.getID(), "material", 1));
            if (Mods.CraftTweaker.isModLoaded() && Mods.LazyAE2.isModLoaded()) {
                ModHandler.addShapedRecipe(true, "storage_component.item.256k", getMetaItemById(Mods.NeevesAE2Addition.getID(), "material", 1, 4),
                        "PCP", "CXC", "PCP",
                        'P', getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32003),       // Ore Dict: plateVibrantAlloy
                        'C', getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 38), // 64k Item Storage Component
                        'X', getMetaItemById(Mods.LazyAE2.getID(), "material", 14));            // Speculative Processor
            }

            ModHandler.removeRecipeByOutput(getMetaItemById(Mods.NeevesAE2Addition.getID(), "material", 2));
            if (Mods.CraftTweaker.isModLoaded() && Mods.ContentTweaker.isModLoaded()) {
                ModHandler.addShapedRecipe(true, "storage_component.item.1024k", getMetaItemById(Mods.NeevesAE2Addition.getID(), "material", 2, 4),
                        "PCP", "CXC", "PCP",
                        'P', getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32009),         // Ore Dict: plateCrystallineAlloy
                        'C', getMetaItemById(Mods.NeevesAE2Addition.getID(), "material", 1),      // 256k Item Storage Component
                        'X', getItemById(Mods.ContentTweaker.getID(), "material_deduction_processor")); // Deduction Processor
            }

            ModHandler.removeRecipeByOutput(getMetaItemById(Mods.NeevesAE2Addition.getID(), "material", 3));
            if (Mods.CraftTweaker.isModLoaded() && Mods.LazyAE2.isModLoaded()) {
                ModHandler.addShapedRecipe(true, "storage_component.item.4096k", getMetaItemById(Mods.NeevesAE2Addition.getID(), "material", 3, 4),
                        "PCP", "CXC", "PCP",
                        'P', getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32012),    // Ore Dict: plateCrystallinePinkSlime
                        'C', getMetaItemById(Mods.NeevesAE2Addition.getID(), "material", 2), // 1024k Item Storage Component
                        'X', getMetaItemById(Mods.LazyAE2.getID(), "material", 4));          // Fluix Logic Unit
            }

            ModHandler.removeRecipeByOutput(getMetaItemById(Mods.NeevesAE2Addition.getID(), "material", 4));
            if (Mods.CraftTweaker.isModLoaded() && Mods.ContentTweaker.isModLoaded()) {
                ModHandler.addShapedRecipe(true, "storage_component.item.16384k", getMetaItemById(Mods.NeevesAE2Addition.getID(), "material", 4, 4),
                        "PCP", "CXC", "PCP",
                        'P', getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32010),    // Ore Dict: plateMelodicAlloy
                        'C', getMetaItemById(Mods.NeevesAE2Addition.getID(), "material", 3), // 4096k Item Storage Component
                        'X', getItemById(Mods.ContentTweaker.getID(), "machine_core_assembly"));   // Fluix Logic Assembler
            }
        }

        // ---------------------------------------------------- Fluid Storage Cells ---------------------------------------------------
        ModHandler.removeRecipeByOutput(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 54));
        ModHandler.addShapedRecipe(true, "storage_component.fluid.1k", getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 54, 4),
                "PCP", "CXC", "PCP",
                'P', new UnificationEntry(plate, CertusQuartz),
                'C', new UnificationEntry(plate, Lapis),
                'X', getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 22)); // Logic Processor

        ModHandler.removeRecipeByOutput(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 55));
        ModHandler.addShapedRecipe(true, "storage_component.fluid.4k", getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 55, 4),
                "PCP", "CXC", "PCP",
                'P', new UnificationEntry(plate, BlueAlloy),
                'C', getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 54),  // 1k Fluid Storage Component
                'X', getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 23)); // Calculation Processor

        ModHandler.removeRecipeByOutput(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 56));
        if (Mods.CraftTweaker.isModLoaded()) {
            ModHandler.addShapedRecipe(true, "storage_component.fluid.16k", getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 56, 4),
                    "PCP", "CXC", "PCP",
                    'P', getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32007),        // Ore Dict: platePulsatingIron
                    'C', getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 55),  // 4k Fluid Storage Component
                    'X', getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 24)); // Engineering Processor
        }

        ModHandler.removeRecipeByOutput(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 57));
        if (Mods.CraftTweaker.isModLoaded() && Mods.LazyAE2.isModLoaded()) {
            ModHandler.addShapedRecipe(true, "storage_component.fluid.64k", getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 57, 4),
                    "PCP", "CXC", "PCP",
                    'P', getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32013),       // Ore Dict: plateEnergeticSilver
                    'C', getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 56), // 16k Fluid Storage Component
                    'X', getMetaItemById(Mods.LazyAE2.getID(), "material", 6));             // Parallel Processor
        }

        if (Mods.NeevesAE2Addition.isModLoaded()) {
            ModHandler.removeRecipeByOutput(getMetaItemById(Mods.NeevesAE2Addition.getID(), "material", 5));
            if (Mods.CraftTweaker.isModLoaded() && Mods.LazyAE2.isModLoaded()) {
                ModHandler.addShapedRecipe(true, "storage_component.fluid.256k", getMetaItemById(Mods.NeevesAE2Addition.getID(), "material", 5, 4),
                        "PCP", "CXC", "PCP",
                        'P', getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32014),         // Ore Dict: plateVividAlloy
                        'C', getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 57),   // 64k Fluid Storage Component
                        'X', getMetaItemById(Mods.LazyAE2.getID(), "material", 14));              // Speculative Processor
            }

            ModHandler.removeRecipeByOutput(getMetaItemById(Mods.NeevesAE2Addition.getID(), "material", 6));
            if (Mods.CraftTweaker.isModLoaded() && Mods.ContentTweaker.isModLoaded()) {
                ModHandler.addShapedRecipe(true, "storage_component.fluid.1024k", getMetaItemById(Mods.NeevesAE2Addition.getID(), "material", 6, 4),
                        "PCP", "CXC", "PCP",
                        'P', getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32004),    // Ore Dict: plateEndSteel
                        'C', getMetaItemById(Mods.NeevesAE2Addition.getID(), "material", 5), // 256k Fluid Storage Component
                        'X', getItemById(Mods.ContentTweaker.getID(), "material_deduction_processor"));
            }

            ModHandler.removeRecipeByOutput(getMetaItemById(Mods.NeevesAE2Addition.getID(), "material", 7));
            if (Mods.CraftTweaker.isModLoaded() && Mods.LazyAE2.isModLoaded()) {
                ModHandler.addShapedRecipe(true, "storage_component.fluid.4096k", getMetaItemById(Mods.NeevesAE2Addition.getID(), "material", 7, 4),
                        "PCP", "CXC", "PCP",
                        'P', getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32031),    // Ore Dict: plateLumium
                        'C', getMetaItemById(Mods.NeevesAE2Addition.getID(), "material", 6), // 1024k Fluid Storage Component
                        'X', getMetaItemById(Mods.LazyAE2.getID(), "material", 4));          // Fluix Logic Unit
            }

            ModHandler.removeRecipeByOutput(getMetaItemById(Mods.NeevesAE2Addition.getID(), "material", 8));
            if (Mods.CraftTweaker.isModLoaded() && Mods.ContentTweaker.isModLoaded()) {
                ModHandler.addShapedRecipe(true, "storage_component.fluid.16384k", getMetaItemById(Mods.NeevesAE2Addition.getID(), "material", 8, 4),
                        "PCP", "CXC", "PCP",
                        'P', getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32032),    // Ore Dict: plateSignalum
                        'C', getMetaItemById(Mods.NeevesAE2Addition.getID(), "material", 7), // 4096k Fluid Storage Component
                        'X', getItemById(Mods.ContentTweaker.getID(), "machine_core_assembly"));   // Fluix Logic Unit Assembly
            }
        }

        // -------------------------------------------- Digital Singularity Storage Cells  --------------------------------------------

        //  Thanks my friend Gate Guardian's work about NAE2-gtlite-edition,
        //  and thanks Ace111, Maple and Platinol for balancing work of these recipes.

        if (Mods.CraftTweaker.isModLoaded() && Mods.NeevesAE2Addition.isModLoaded()) {
            ModHandler.removeRecipeByOutput(getMetaItemById(Mods.NeevesAE2Addition.getID(), "material", 9));
            ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .inputs(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 47))             // AE2 Singularity
                    .input(QUANTUM_CHEST[QUANTUM_CHEST.length - 1], 4)
                    .inputs(getMetaItemById(Mods.NeevesAE2Addition.getID(), "material", 4, 8))     // 16384k Item Storage Component
                    .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32011, 4))        // Ore Dict: plateStellarAlloy
                    .fluidInputs(SolderingAlloy.getFluid(1000))
                    .outputs(getMetaItemById(Mods.NeevesAE2Addition.getID(), "material", 9))               // Digital Singularity Item Storage Component
                    .EUt(VHA[ZPM])
                    .duration(5 * SECOND)
                    .stationResearch(b -> b
                            .researchStack(getMetaItemById(Mods.NeevesAE2Addition.getID(), "material", 4)) // 16384k Item Storage Component
                            .CWUt(32)
                            .EUt(VA[ZPM]))
                    .buildAndRegister();

            ModHandler.removeRecipeByOutput(getMetaItemById(Mods.NeevesAE2Addition.getID(), "material", 10));
            ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .inputs(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 47))             // AE2 Singularity
                    .input(QUANTUM_TANK[QUANTUM_TANK.length - 1], 4)
                    .inputs(getMetaItemById(Mods.NeevesAE2Addition.getID(), "material", 8, 8))     // 16384k Fluid Storage Component
                    .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32033, 4))        // Ore Dict: plateEnderium
                    .fluidInputs(SolderingAlloy.getFluid(1000))
                    .outputs(getMetaItemById(Mods.NeevesAE2Addition.getID(), "material", 10))              // Digital Singularity Fluid Storage Component
                    .EUt(VHA[ZPM])
                    .duration(5 * SECOND)
                    .stationResearch(b -> b
                            .researchStack(getMetaItemById(Mods.NeevesAE2Addition.getID(), "material", 8)) // 16384k Fluid Storage Component
                            .CWUt(32)
                            .EUt(VA[ZPM]))
                    .buildAndRegister();
        }
    }
}
