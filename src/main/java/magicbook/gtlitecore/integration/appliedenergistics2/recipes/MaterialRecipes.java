package magicbook.gtlitecore.integration.appliedenergistics2.recipes;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.stack.UnificationEntry;
import magicbook.gtlitecore.api.utils.Mods;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ALLOY_SMELTER_RECIPES;
import static gregtech.api.recipes.RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.utils.GTLiteUtils.*;

public class MaterialRecipes {

    //  In GregTech Lite Modpack, `Inscriber Silicon Press` is renamed to `Inscriber Engraving Press`,
    //  because there are two Printed Plate needs to use this press (and same to other presses).

    public static void init() {

        //  Fluix Logic Unit
        //  This is advanced version of all AE2 processors,
        //  used for some advanced machines, cells or components.
        ModHandler.removeRecipeByOutput(getMetaItemById(Mods.LazyAE2.getID(), "material", 4));
        if (Mods.ContentTweaker.isModLoaded() && Mods.LazyAE2.isModLoaded()) {
            ModHandler.addShapedRecipe(true, "fluix_logic_unit", getMetaItemById(Mods.LazyAE2.getID(), "material", 4, 2),
                    "IAI", "XBX", "ICI",
                    'A', getMetaItemById(Mods.LazyAE2.getID(), "material", 6),               // Parallel Processor
                    'B', getMetaItemById(Mods.LazyAE2.getID(), "material", 14),              // Speculative Processor
                    'C', getItemById(Mods.ContentTweaker.getID(), "material_deduction_processor"),
                    'I', getMetaItemById(Mods.LazyAE2.getID(), "material", 0),               // Fluix Steel
                    'X', new UnificationEntry(wireFine, RedAlloy));
        }

        //  Fluix Logic Assembly
        //  Processor Assembly of Fluix Logic Unit, in GregTech Lite Modpack,
        //  we extended this material to a completed circuit chain.
        if (Mods.ContentTweaker.isModLoaded() && Mods.LazyAE2.isModLoaded()) {
            ModHandler.addShapedRecipe(true, "fluix_logic_assembly", getItemById(Mods.ContentTweaker.getID(), "machine_core_assembly", 2),
                    "PAP", "XCX", "PBP",
                    'X', getMetaItemById(Mods.LazyAE2.getID(), "material", 4),              // Fluix Logic Unit
                    'C', getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 24), // Engineering Processor
                    'A', getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 22), // Logic Processor
                    'B', getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 23), // Calculation Processor
                    'P', getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 9)); // Fluix Pearl
        }

        //  Fluix Logic Computer
        if (Mods.ContentTweaker.isModLoaded()) {
            CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                    .input(ENGRAVED_LAPOTRON_CHIP)
                    .inputs(getItemById(Mods.ContentTweaker.getID(), "machine_core_assembly", 2))
                    .input(SMD_DIODE, 8)
                    .input(NOR_MEMORY_CHIP, 4)
                    .input(RANDOM_ACCESS_MEMORY, 16)
                    .input("wireFineCrystallinePinkSlime")
                    .fluidInputs(getFluidById("redstone_alloy", L * 4))
                    .outputs(getItemById(Mods.ContentTweaker.getID(), "machine_core_computer"))
                    .EUt(VA[IV])
                    .duration(10 * SECOND)
                    .cleanroom(CleanroomType.CLEANROOM)
                    .buildAndRegister();
        }

        //  Fluix Logic Mainframe
        if (Mods.ContentTweaker.isModLoaded()) {
            CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                    .input("frameGtSignalum")
                    .inputs(getItemById(Mods.ContentTweaker.getID(), "machine_core_computer", 2))
                    .input(QUANTUM_EYE)
                    .input(RANDOM_ACCESS_MEMORY, 32)
                    .input(foil, Polytetrafluoroethylene, 16)
                    .input("wireFineMelodicAlloy", 32)
                    .fluidInputs(getFluidById("soularium", L * 8))
                    .outputs(getItemById(Mods.ContentTweaker.getID(), "machine_core_mainframe"))
                    .EUt(VA[LuV])
                    .duration(20 * SECOND)
                    .cleanroom(CleanroomType.CLEANROOM)
                    .buildAndRegister();
        }

        //  Formation Core
        ModHandler.removeRecipeByOutput(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 43));
        ModHandler.addShapedRecipe(true, "formation_core", getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 43, 4),
                "   ", "CDX", "   ",
                'C', "crystalCertusQuartz",
                'D', "dustFluix",
                'X', getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 22)); // Logic Processor

        //  Annihilation Core
        ModHandler.removeRecipeByOutput(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 44));
        ModHandler.addShapedRecipe(true, "annihilation_core", getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 44, 4),
                "   ", "CDX", "   ",
                'C', new UnificationEntry(gem, NetherQuartz),
                'D', "dustFluix",
                'X', getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 22));

        //  Quartz Glass
        ModHandler.removeRecipeByOutput(getItemById(Mods.AppliedEnergistics2.getID(), "quartz_glass"));
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .inputs(new ItemStack(Blocks.GLASS))
                .input(dust, Quartzite, 2)
                .outputs(getItemById(Mods.AppliedEnergistics2.getID(), "quartz_glass", 2))
                .EUt(VA[LV])
                .duration(4 * SECOND)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .inputs(new ItemStack(Blocks.GLASS))
                .input(dust, NetherQuartz, 2)
                .outputs(getItemById(Mods.AppliedEnergistics2.getID(), "quartz_glass", 2))
                .EUt(VA[LV])
                .duration(2 * SECOND)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .inputs(new ItemStack(Blocks.GLASS))
                .input(dust, CertusQuartz, 2)
                .outputs(getItemById(Mods.AppliedEnergistics2.getID(), "quartz_glass", 2))
                .EUt(VA[LV])
                .duration(SECOND)
                .buildAndRegister();

        //  Vibrant Quartz Glass
        ModHandler.removeRecipeByOutput(getItemById(Mods.AppliedEnergistics2.getID(), "quartz_vibrant_glass"));
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .inputs(getItemById(Mods.AppliedEnergistics2.getID(), "quartz_glass"))
                .input(dust, Glowstone, 2)
                .outputs(getItemById(Mods.AppliedEnergistics2.getID(), "quartz_vibrant_glass"))
                .EUt(VA[LV])
                .duration(SECOND)
                .buildAndRegister();

        //  Wireless Receiver
        ModHandler.removeRecipeByOutput(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 41));
        ModHandler.addShapedRecipe(true, "wireless_receiver", getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 41),
                " E ", "POP", " P ",
                'P', new UnificationEntry(plate, CertusQuartz),
                'E', getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 9), // Fluix Pearl
                'O', getMetaItemById(Mods.AppliedEnergistics2.getID(), "part", 140));  // Quartz FIber

        //  Wireless Booster
        ModHandler.removeRecipeByOutput(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 42));
        ModHandler.addShapedRecipe(true, "wireless_booster", getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 42),
                "   ", "DOE", "PPP",
                'D', getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 1), // Charged Certus Crystal
                'E', new UnificationEntry(dust, EnderPearl),
                'P', "plateElectricalSteel");

    }
}
