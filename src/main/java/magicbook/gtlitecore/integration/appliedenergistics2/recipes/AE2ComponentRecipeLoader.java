package magicbook.gtlitecore.integration.appliedenergistics2.recipes;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.stack.UnificationEntry;
import magicbook.gtlitecore.api.utils.Mods;

import static gregtech.api.GTValues.LV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.GTValues.VN;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.plate;
import static gregtech.api.unification.ore.OrePrefix.screw;
import static gregtech.api.unification.ore.OrePrefix.wireFine;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.DEDUCTION_PROCESSOR;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.FLUIX_LOGIC_ASSEMBLY;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.FLUIX_LOGIC_PROCESSOR;

public class AE2ComponentRecipeLoader {

    public static void init() {

        //  ME Storage Housing
        ModHandler.removeRecipeByOutput(Mods.AppliedEnergistics2.getMetaItemByID("material", 39));

        Material[] plates = { Aluminium, Titanium, Tungsten, Iridium, Osmium };
        Material[] screws = { ConductiveIron, EnergeticAlloy, VibrantAlloy, EndSteel, Lumium };
        int[] products = { 4, 8, 16, 32, 64 };

        for (int i = 0; i < plates.length; i++) {
            ModHandler.addShapedRecipe(true, "me_storage_housing_" + VN[i + 1], Mods.AppliedEnergistics2.getMetaItemByID("material", 39, products[i]),
                    "hPS", "PGP", "SPd",
                    'P', new UnificationEntry(plate, plates[i]),
                    'S', new UnificationEntry(screw, screws[i]),
                    'G', new UnificationEntry(wireFine, CertusQuartz));

            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(3)
                    .input(plate, plates[i], 4)
                    .input(wireFine, CertusQuartz)
                    .input(screw, screws[i], 2)
                    .outputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 39, products[i]))
                    .EUt(VA[LV])
                    .duration(50)
                    .buildAndRegister();
        }

        //  Blank Pattern
        ModHandler.removeRecipeByOutput(Mods.AppliedEnergistics2.getMetaItemByID("material", 52));

        Material[] plasticPlates = { Polyethylene, PolyvinylChloride, Polytetrafluoroethylene, Polybenzimidazole, Polyetheretherketone };
        Material[] wireFines = { EnrichedAlloy, EnergeticSilver, VividAlloy, CrystallineAlloy, CrystallinePinkSlime };

        for (int i = 0; i < plasticPlates.length; i++) {
            ModHandler.addShapedRecipe(true, "blank_pattern_" + VN[i + 1], Mods.AppliedEnergistics2.getMetaItemByID("material", 52, products[i]),
                    "SPh", "PGP", "dPS",
                    'P', new UnificationEntry(plate, plasticPlates[i]),
                    'S', new UnificationEntry(screw, CertusQuartz),
                    'G', new UnificationEntry(wireFine, wireFines[i]));

            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(3)
                    .input(plate, plasticPlates[i], 4)
                    .input(wireFine, wireFines[i])
                    .input(screw, CertusQuartz, 2)
                    .outputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 52, products[i]))
                    .EUt(VA[LV])
                    .duration(50)
                    .buildAndRegister();
        }

        // ---------------------------------------------------- Item Storage Cells ----------------------------------------------------

        //  1k
        ModHandler.removeRecipeByOutput(Mods.AppliedEnergistics2.getMetaItemByID("material", 35));
        ModHandler.addShapedRecipe(true, "storage_component.item.1k", Mods.AppliedEnergistics2.getMetaItemByID("material", 35, 4),
                "PCP", "CXC", "PCP",
                'P', new UnificationEntry(plate, CertusQuartz),
                'C', new UnificationEntry(plate, Redstone),
                'X', Mods.AppliedEnergistics2.getMetaItemByID("material", 22)); // Logic Processor

        //  4k
        ModHandler.removeRecipeByOutput(Mods.AppliedEnergistics2.getMetaItemByID("material", 36));
        ModHandler.addShapedRecipe(true, "storage_component.item.4k", Mods.AppliedEnergistics2.getMetaItemByID("material", 36, 4),
                "PCP", "CXC", "PCP",
                'P', new UnificationEntry(plate, RedAlloy),
                'C', Mods.AppliedEnergistics2.getMetaItemByID("material", 35), // 1k Item Storage Component
                'X', Mods.AppliedEnergistics2.getMetaItemByID("material", 23)); // Calculation Processor

        //  16k
        ModHandler.removeRecipeByOutput(Mods.AppliedEnergistics2.getMetaItemByID("material", 37));
        ModHandler.addShapedRecipe(true, "storage_component.item.16k", Mods.AppliedEnergistics2.getMetaItemByID("material", 37, 4),
                "PCP", "CXC", "PCP",
                'P', new UnificationEntry(plate, Magnalium),
                'C', Mods.AppliedEnergistics2.getMetaItemByID("material", 36), // 4k Item Storage Component
                'X', Mods.AppliedEnergistics2.getMetaItemByID("material", 24)); // Engineering Processor

        //  64k
        ModHandler.removeRecipeByOutput(Mods.AppliedEnergistics2.getMetaItemByID("material", 38));
        if (Mods.LazyAE2.isModLoaded()) {
            ModHandler.addShapedRecipe(true, "storage_component.item.64k", Mods.AppliedEnergistics2.getMetaItemByID("material", 38, 4),
                    "PCP", "CXC", "PCP",
                    'P', new UnificationEntry(plate, EnergeticAlloy),
                    'C', Mods.AppliedEnergistics2.getMetaItemByID("material", 37), // 16k Item Storage Component
                    'X', Mods.LazyAE2.getMetaItemByID("material", 6)); // Parallel Processor
        } else {
            ModHandler.addShapedRecipe(true, "storage_component.item.64k",Mods.AppliedEnergistics2.getMetaItemByID("material", 38, 4),
                    "PCP", "CXC", "PCP",
                    'P', new UnificationEntry(plate, EnergeticAlloy),
                    'C', Mods.AppliedEnergistics2.getMetaItemByID("material", 37), // 16k Item Storage Component
                    'X', Mods.AppliedEnergistics2.getMetaItemByID("material", 22)); // Logic Processor
        }

        //  If NAE2 is loaded, then add GT style recipes for 256k-16384k Item Storage Components.
        if (Mods.NeevesAE2Addition.isModLoaded()) {
            //  256k
            if (Mods.LazyAE2.isModLoaded()) {
                ModHandler.removeRecipeByOutput(Mods.NeevesAE2Addition.getMetaItemByID("material", 1));
                ModHandler.addShapedRecipe(true, "storage_component.item.256k", Mods.NeevesAE2Addition.getMetaItemByID("material", 1, 4),
                        "PCP", "CXC", "PCP",
                        'P', new UnificationEntry(plate, VibrantAlloy),
                        'C', Mods.AppliedEnergistics2.getMetaItemByID("material", 38), // 64k Item Storage Component
                        'X', Mods.LazyAE2.getMetaItemByID("material", 14)); // Speculative Processor
            } else {
                ModHandler.removeRecipeByOutput(Mods.NeevesAE2Addition.getMetaItemByID("material", 1));
                ModHandler.addShapedRecipe(true, "storage_component.item.256k", Mods.NeevesAE2Addition.getMetaItemByID("material", 1, 4),
                        "PCP", "CXC", "PCP",
                        'P', new UnificationEntry(plate, VibrantAlloy),
                        'C', Mods.AppliedEnergistics2.getMetaItemByID("material", 38), // 64k Item Storage Component
                        'X', Mods.AppliedEnergistics2.getMetaItemByID("material", 23)); // Calculation Processor
            }

            //  1024k
            ModHandler.removeRecipeByOutput(Mods.NeevesAE2Addition.getMetaItemByID("material", 2));
            ModHandler.addShapedRecipe(true, "storage_component.item.1024k", Mods.NeevesAE2Addition.getMetaItemByID("material", 2, 4),
                    "PCP", "CXC", "PCP",
                    'P', new UnificationEntry(plate, EndSteel),
                    'C', Mods.NeevesAE2Addition.getMetaItemByID("material", 1), // 256k Item Storage Component
                    'X', DEDUCTION_PROCESSOR);

            //  4096k
            ModHandler.removeRecipeByOutput(Mods.NeevesAE2Addition.getMetaItemByID("material", 3));
            ModHandler.addShapedRecipe(true, "storage_component.item.4096k", Mods.NeevesAE2Addition.getMetaItemByID("material", 3, 4),
                    "PCP", "CXC", "PCP",
                    'P', new UnificationEntry(plate, Lumium),
                    'C', Mods.NeevesAE2Addition.getMetaItemByID("material", 2), // 1024k Item Storage Component
                    'X', FLUIX_LOGIC_PROCESSOR);

            //  16384k
            ModHandler.removeRecipeByOutput(Mods.NeevesAE2Addition.getMetaItemByID("material", 4));
            ModHandler.addShapedRecipe(true, "storage_component.item.16384k", Mods.NeevesAE2Addition.getMetaItemByID("material", 4, 4),
                    "PCP", "CXC", "PCP",
                    'P', new UnificationEntry(plate, Signalum),
                    'C', Mods.NeevesAE2Addition.getMetaItemByID("material", 3), // 4096k Item Storage Component
                    'X', FLUIX_LOGIC_ASSEMBLY);

        }

        //  TODO ME Quantum Item Storage Cell (Use Enderium plate, 16384k Component and Fluix Logic Computer).

        //  TODO ME Digital Singularity Cell (Use UIV+ stage materials, ME Quantum Item Storage Cell and Fluix Logic Mainframe).

        // ---------------------------------------------------- Fluid Storage Cells ---------------------------------------------------

        //  1k
        ModHandler.removeRecipeByOutput(Mods.AppliedEnergistics2.getMetaItemByID("material", 54));
        ModHandler.addShapedRecipe(true, "storage_component.fluid.1k", Mods.AppliedEnergistics2.getMetaItemByID("material", 54, 4),
                "PCP", "CXC", "PCP",
                'P', new UnificationEntry(plate, CertusQuartz),
                'C', new UnificationEntry(plate, Lapis),
                'X', Mods.AppliedEnergistics2.getMetaItemByID("material", 22)); // Logic Processor

        //  4k
        ModHandler.removeRecipeByOutput(Mods.AppliedEnergistics2.getMetaItemByID("material", 55));
        ModHandler.addShapedRecipe(true, "storage_component.fluid.4k", Mods.AppliedEnergistics2.getMetaItemByID("material", 55, 4),
                "PCP", "CXC", "PCP",
                'P', new UnificationEntry(plate, BlueAlloy),
                'C', Mods.AppliedEnergistics2.getMetaItemByID("material", 54), // 1k Fluid Storage Component
                'X', Mods.AppliedEnergistics2.getMetaItemByID("material", 23)); // Calculation Processor

        //  16k
        ModHandler.removeRecipeByOutput(Mods.AppliedEnergistics2.getMetaItemByID("material", 56));
        ModHandler.addShapedRecipe(true, "storage_component.fluid.16k", Mods.AppliedEnergistics2.getMetaItemByID("material", 56, 4),
                "PCP", "CXC", "PCP",
                'P', new UnificationEntry(plate, PulsatingIron),
                'C', Mods.AppliedEnergistics2.getMetaItemByID("material", 55), // 4k Fluid Storage Component
                'X', Mods.AppliedEnergistics2.getMetaItemByID("material", 24)); // Engineering Processor

        //  64k
        ModHandler.removeRecipeByOutput(Mods.AppliedEnergistics2.getMetaItemByID("material", 57));
        if (Mods.LazyAE2.isModLoaded()) {
            ModHandler.addShapedRecipe(true, "storage_component.fluid.64k", Mods.AppliedEnergistics2.getMetaItemByID("material", 57, 4),
                    "PCP", "CXC", "PCP",
                    'P', new UnificationEntry(plate, EnergeticSilver),
                    'C', Mods.AppliedEnergistics2.getMetaItemByID("material", 56), // 16k Fluid Storage Component
                    'X', Mods.LazyAE2.getMetaItemByID("material", 6)); // Parallel Processor
        } else {
            ModHandler.addShapedRecipe(true, "storage_component.fluid.64k", Mods.AppliedEnergistics2.getMetaItemByID("material", 57, 4),
                    "PCP", "CXC", "PCP",
                    'P', new UnificationEntry(plate, EnergeticSilver),
                    'C', Mods.AppliedEnergistics2.getMetaItemByID("material", 56), // 16k Fluid Storage Component
                    'X', Mods.AppliedEnergistics2.getMetaItemByID("material", 22)); // Logic Processor
        }

        //  If NAE2 is loaded, then add GT style recipes for 256k-16384k Fluid Storage Components.
        if (Mods.NeevesAE2Addition.isModLoaded()) {
            //  256k
            ModHandler.removeRecipeByOutput(Mods.NeevesAE2Addition.getMetaItemByID("material", 5));
            if (Mods.LazyAE2.isModLoaded()) {
                ModHandler.addShapedRecipe(true, "storage_component.fluid.256k", Mods.NeevesAE2Addition.getMetaItemByID("material", 5, 4),
                        "PCP", "CXC", "PCP",
                        'P', new UnificationEntry(plate, VividAlloy),
                        'C', Mods.AppliedEnergistics2.getMetaItemByID("material", 57), // 64k Fluid Storage Component
                        'X', Mods.LazyAE2.getMetaItemByID("material", 14)); // Speculative Processor
            } else {
                ModHandler.addShapedRecipe(true, "storage_component.fluid.256k", Mods.NeevesAE2Addition.getMetaItemByID("material", 5, 4),
                        "PCP", "CXC", "PCP",
                        'P', new UnificationEntry(plate, VividAlloy),
                        'C', Mods.AppliedEnergistics2.getMetaItemByID("material", 57), // 64k Fluid Storage Component
                        'X', Mods.AppliedEnergistics2.getMetaItemByID("material", 23)); // Calculation Processor
            }
            //  1024k
            ModHandler.removeRecipeByOutput(Mods.NeevesAE2Addition.getMetaItemByID("material", 6));
            ModHandler.addShapedRecipe(true, "storage_component.fluid.1024k", Mods.NeevesAE2Addition.getMetaItemByID("material", 6, 4),
                    "PCP", "CXC", "PCP",
                    'P', new UnificationEntry(plate, CrystallineAlloy),
                    'C', Mods.NeevesAE2Addition.getMetaItemByID("material", 5), // 256k Fluid Storage Component
                    'X', DEDUCTION_PROCESSOR);

            //  4096k
            ModHandler.removeRecipeByOutput(Mods.NeevesAE2Addition.getMetaItemByID("material", 7));
            ModHandler.addShapedRecipe(true, "storage_component.fluid.4096k", Mods.NeevesAE2Addition.getMetaItemByID("material", 7, 4),
                    "PCP", "CXC", "PCP",
                    'P', new UnificationEntry(plate, CrystallinePinkSlime),
                    'C', Mods.NeevesAE2Addition.getMetaItemByID("material", 6), // 1024k Fluid Storage Component
                    'X', FLUIX_LOGIC_PROCESSOR);

            //  16384k
            ModHandler.removeRecipeByOutput(Mods.NeevesAE2Addition.getMetaItemByID("material", 8));
            ModHandler.addShapedRecipe(true, "storage_component.fluid.16384k", Mods.NeevesAE2Addition.getMetaItemByID("material", 8, 4),
                    "PCP", "CXC", "PCP",
                    'P', new UnificationEntry(plate, MelodicAlloy),
                    'C', Mods.NeevesAE2Addition.getMetaItemByID("material", 7), // 4096k Fluid Storage Component
                    'X', FLUIX_LOGIC_ASSEMBLY);
        }

        //  TODO ME Quantum Fluid Storage Cell (Use Stellar plate, 16384k Component and Fluix Logic Computer).

        //  TODO ME Digital Singularity Fluid Cell (Use UIV+ stage materials, ME Quantum Item Storage Cell and Fluix Logic Mainframe).

        //  TODO Maybe add Multi-type Fluid Storage Cell.

        //  Remove all fake cell recipes (Component + Housing Material -> Cell), because we tweak Housing recipe, this recipe is too unnecessary.
        ModHandler.removeRecipeByName(Mods.AppliedEnergistics2.getID() + ":" + "network/cells/storage_cell_1k");
        ModHandler.removeRecipeByName(Mods.AppliedEnergistics2.getID() + ":" + "network/cells/storage_cell_4k");
        ModHandler.removeRecipeByName(Mods.AppliedEnergistics2.getID() + ":" + "network/cells/storage_cell_16k");
        ModHandler.removeRecipeByName(Mods.AppliedEnergistics2.getID() + ":" + "network/cells/storage_cell_64k");
        ModHandler.removeRecipeByName(Mods.AppliedEnergistics2.getID() + ":" + "network/cells/fluid_storage_cell_1k");
        ModHandler.removeRecipeByName(Mods.AppliedEnergistics2.getID() + ":" + "network/cells/fluid_storage_cell_4k");
        ModHandler.removeRecipeByName(Mods.AppliedEnergistics2.getID() + ":" + "network/cells/fluid_storage_cell_16k");
        ModHandler.removeRecipeByName(Mods.AppliedEnergistics2.getID() + ":" + "network/cells/fluid_storage_cell_64k");
        ModHandler.removeRecipeByName(Mods.AppliedEnergistics2.getID() + ":" + "network/cells/view_cell");
        ModHandler.removeRecipeByName(Mods.AppliedEnergistics2.getID() + ":" + "network/cells/spatial_storage_cell_2_cubed");
        ModHandler.removeRecipeByName(Mods.AppliedEnergistics2.getID() + ":" + "network/cells/spatial_storage_cell_16_cubed");
        ModHandler.removeRecipeByName(Mods.AppliedEnergistics2.getID() + ":" + "network/cells/spatial_storage_cell_128_cubed");

    }
}
