package magicbook.gtlitecore.integration.appliedenergistics2.recipes;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.stack.UnificationEntry;
import magicbook.gtlitecore.api.utils.Mods;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.api.utils.GTLiteUtils.getMetaItemById;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;
import static magicbook.gtlitecore.integration.appliedenergistics2.utils.AE2RecipeHandler.*;

public class AE2MaterialRecipeLoader {

    public static void init() {

        //  Quartz Fiber as Nether Quartz fine wire.
        ModHandler.removeRecipeByOutput(Mods.AppliedEnergistics2.getMetaItemByID("part", 140));
        WIREMILL_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .input(gem, NetherQuartz)
                .outputs(Mods.AppliedEnergistics2.getMetaItemByID("part", 140, 8))
                .EUt(VA[ULV])
                .duration((int) (NetherQuartz.getMass() * 2))
                .buildAndRegister();

        EXTRUDER_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_EXTRUDER_WIRE)
                .input(gem, NetherQuartz)
                .outputs(Mods.AppliedEnergistics2.getMetaItemByID("part", 140, 8))
                .EUt(VA[MV])
                .duration(SECOND)
                .buildAndRegister();

        //  Compact with Certus Quartz fine wire.
        WIREMILL_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .input(gem, CertusQuartz)
                .output(wireFine, CertusQuartz, 8)
                .EUt(VA[ULV])
                .duration((int) (CertusQuartz.getMass() * 2))
                .buildAndRegister();

        EXTRUDER_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_EXTRUDER_WIRE)
                .input(gem, CertusQuartz)
                .output(wireFine, CertusQuartz, 8)
                .EUt(VA[MV])
                .duration((int) (3.5 * SECOND))
                .buildAndRegister();

        //  Compact with Fluix fine wire.
        WIREMILL_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .input(gem, Fluix)
                .output(wireFine, Fluix, 8)
                .EUt(VA[ULV])
                .duration((int) (Fluix.getMass() * 2))
                .buildAndRegister();

        EXTRUDER_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_EXTRUDER_WIRE)
                .input(gem, Fluix)
                .output(wireFine, Fluix, 8)
                .EUt(VA[MV])
                .duration(4 * SECOND)
                .buildAndRegister();

        // ---------------------------------------------------------------- Printed Plates ----------------------------------------------------------------

        //  Printed Silicon
        removeInscriberRecipe(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 20));
        addInscriberRecipe(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 20), // Printed Silicon
                           OreDictUnifier.get(plate, Silicon),
                true,
                           getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 19), // Inscriber Silicon Press
                           null);

        //  Printed Redstone Alloy
        //  New crafting component for AE2 processors, just a replacement of redstone dust in Inscriber recipes.
        addInscriberRecipe(REDSTONE_ALLOY_BOARD.getStackForm(),
                           OreDictUnifier.get(plate, RedstoneAlloy),
                true,
                           getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 19), // Inscriber Silicon Press
                           null);

        //  Printed Calculation Circuit
        removeInscriberRecipe(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 16));
        addInscriberRecipe(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 16),
                           OreDictUnifier.get(plate, CertusQuartz),
                true,
                           getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 13), // Inscriber Calculation Press
                           null);

        //  Printed Engineering Circuit
        removeInscriberRecipe(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 17));
        addInscriberRecipe(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 17),
                           OreDictUnifier.get(plate, Diamond),
                true,
                           getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 14), // Inscriber Engineering Press
                           null);

        //  Printed Logic Circuit
        removeInscriberRecipe(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 18));
        addInscriberRecipe(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 18),
                           OreDictUnifier.get(plate, Gold),
                true,
                           getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 15), // Inscriber Logic Press
                           null);

        //  Printed Deduction Circuit
        addInscriberRecipe(DEDUCTION_CIRCUIT_BOARD.getStackForm(),
                           OreDictUnifier.get(plate, Amethyst),
                true,
                           getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 13), // Inscriber Calculation Press
                           null);

        //  Printed Parallel Circuit
        addInscriberRecipe(PARALLEL_CIRCUIT_BOARD.getStackForm(),
                           OreDictUnifier.get(plate, Cobalt),
                           true,
                           getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 14), // Inscriber Engineering Press
                           null);

        //  Printed Speculative Circuit
        addInscriberRecipe(SPECULATIVE_CIRCUIT_BOARD.getStackForm(),
                           OreDictUnifier.get(plate, Nickel),
                           true,
                           getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 15), // Inscriber Logic Press
                           null);

        //  Logic Processor
        removeInscriberRecipe(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 22));
        addInscriberRecipe(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 22),
                           REDSTONE_ALLOY_BOARD.getStackForm(),
                           false,
                           getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 18), // Printed Logic Circuit
                           getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 20)); // Printed Silicon

        if (Mods.LazyAE2.isModLoaded()) {
            removeEtcherRecipe(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 22));
            addEtcherRecipe(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 22),
                    "plateGold",
                    "plateRedstoneAlloy",
                    "plateSilicon");
        }

        //  Calculation Processor
        removeInscriberRecipe(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 23));
        addInscriberRecipe(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 23),
                           REDSTONE_ALLOY_BOARD.getStackForm(),
                           false,
                           getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 16), // Printed Calculation Circuit
                           getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 20)); // Printed Silicon

        if (Mods.LazyAE2.isModLoaded()) {
            removeEtcherRecipe(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 23));
            addEtcherRecipe(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 23),
                    "plateCertusQuartz",
                    "plateRedstoneAlloy",
                    "plateSilicon");
        }

        //  Engineering Processor
        removeInscriberRecipe(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 24));
        addInscriberRecipe(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 24),
                           REDSTONE_ALLOY_BOARD.getStackForm(),
                           false,
                           getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 17), // Printed Engineering Circuit
                           getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 20)); // Printed Silicon

        if (Mods.LazyAE2.isModLoaded()) {
            removeEtcherRecipe(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 24));
            addEtcherRecipe(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 24),
                    "plateDiamond",
                    "plateRedstoneAlloy",
                    "plateSilicon");
        }

        if (Mods.LazyAE2.isModLoaded()) {
            //  Parallel Processor
            addInscriberRecipe(getMetaItemById(Mods.LazyAE2.getID(), "material", 6),
                    REDSTONE_ALLOY_BOARD.getStackForm(),
                    false,
                    PARALLEL_CIRCUIT_BOARD.getStackForm(),
                    getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 20)); // Printed Silicon

            removeEtcherRecipe(getMetaItemById(Mods.LazyAE2.getID(), "material", 6));
            addEtcherRecipe(getMetaItemById(Mods.LazyAE2.getID(), "material", 6),
                    "plateCobalt",
                    "plateRedstoneAlloy",
                    "plateSilicon");

            //  Speculative Process
            addInscriberRecipe(getMetaItemById(Mods.LazyAE2.getID(), "material", 14),
                    REDSTONE_ALLOY_BOARD.getStackForm(),
                    false,
                    SPECULATIVE_CIRCUIT_BOARD.getStackForm(),
                    getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 20)); // Printed Silicon

            removeEtcherRecipe(getMetaItemById(Mods.LazyAE2.getID(), "material", 14));
            addEtcherRecipe(getMetaItemById(Mods.LazyAE2.getID(), "material", 14),
                    "plateNickel",
                    "plateRedstoneAlloy",
                    "plateSilicon");
        }

        //  Deduction Processor
        addInscriberRecipe(DEDUCTION_PROCESSOR.getStackForm(),
                REDSTONE_ALLOY_BOARD.getStackForm(),
                false,
                DEDUCTION_CIRCUIT_BOARD.getStackForm(),
                getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 20)); // Printed Silicon

        if (Mods.LazyAE2.isModLoaded()) {
            addEtcherRecipe(DEDUCTION_PROCESSOR.getStackForm(),
                    "plateAmethyst",
                    "plateRedstoneAlloy",
                    "plateSilicon");
        }

        //  TODO Add Original Item in Lazy AE2 (getMetaItemById(Mods.LazyAE2.getID(), "material", 4, 2)) to blacklist.

        //  Fluix Logic Processor
        if (Mods.LazyAE2.isModLoaded()) {
            ModHandler.addShapedRecipe(true, "fluix_logic_processor", FLUIX_LOGIC_PROCESSOR.getStackForm(2),
                    "IAI", "XBX", "ICI",
                    'A', getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 22), // Logic Processor
                    'B', getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 23), // Calculation Processor
                    'C', getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 24), // Engineering Processor
                    'I', getMetaItemById(Mods.LazyAE2.getID(), "material", 0), // Fluix Steel
                    'X', new UnificationEntry(wireFine, RedAlloy));
        } else {
            ModHandler.addShapedRecipe(true, "fluix_logic_processor", FLUIX_LOGIC_PROCESSOR.getStackForm(2),
                    "IAI", "XBX", "ICI",
                    'A', getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 22), // Logic Processor
                    'B', getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 23), // Calculation Processor
                    'C', getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 24), // Engineering Processor
                    'I', new UnificationEntry(plate, Fluix),
                    'X', new UnificationEntry(wireFine, RedAlloy));
        }

        //  Fluix Logic Assembly
        if (Mods.LazyAE2.isModLoaded()) {
            ModHandler.addShapedRecipe(true, "fluix_logic_assembly", FLUIX_LOGIC_ASSEMBLY.getStackForm(2),
                    "PAP", "XCX", "PBP",
                    'A', getMetaItemById(Mods.LazyAE2.getID(), "material", 6), // Parallel Processor
                    'B', getMetaItemById(Mods.LazyAE2.getID(), "material", 14), // Speculative Processor
                    'C', DEDUCTION_PROCESSOR.getStackForm(),
                    'P', getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 9), // Fluix Pearl
                    'X', FLUIX_LOGIC_PROCESSOR.getStackForm()); // Fluix Logic Unit
        } else {
            ModHandler.addShapedRecipe(true, "fluix_logic_assembly", FLUIX_LOGIC_ASSEMBLY.getStackForm(2),
                    "PAP", "XCX", "PAP",
                    'A', getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 22), // Logic Processor
                    'C', DEDUCTION_PROCESSOR,
                    'P', getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 9), // Fluix Pearl
                    'X', FLUIX_LOGIC_PROCESSOR.getStackForm()); // Fluix Logic Unit
        }

        //  Fluix Logic Computer
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(ENGRAVED_LAPOTRON_CHIP)
                .input(FLUIX_LOGIC_ASSEMBLY, 2)
                .input(SMD_DIODE, 8)
                .input(NOR_MEMORY_CHIP, 4)
                .input(RANDOM_ACCESS_MEMORY, 16)
                .input(wireFine, CrystallinePinkSlime, 8)
                .fluidInputs(RedstoneAlloy.getFluid(L * 4))
                .output(FLUIX_LOGIC_COMPUTER)
                .EUt(VA[HV])
                .duration(10 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Fluix Logic Mainframe
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Signalum)
                .input(FLUIX_LOGIC_COMPUTER, 2)
                .input(QUANTUM_EYE)
                .input(RANDOM_ACCESS_MEMORY, 32)
                .input(foil, Polytetrafluoroethylene, 16)
                .input(wireFine, MelodicAlloy, 32)
                .fluidInputs(Soularium.getFluid(L * 8))
                .output(FLUIX_LOGIC_MAINFRAME)
                .EUt(VA[EV])
                .duration(20 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Fluix Pearl
        //  If Lazy AE2 is loaded, then only add Aggregator recipe for this material, if not, then add GT style Alloy Smelter recipes.
        ModHandler.removeRecipeByOutput(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 9));
        if (Mods.LazyAE2.isModLoaded()) {
            addAggregatorRecipe(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 9),
                    "gemEnderPearl",
                    "dustSkyStone",
                    "crystalFluix");
        } else {
            ALLOY_SMELTER_RECIPES.recipeBuilder()
                    .input(gem, EnderPearl)
                    .input(gem, Fluix, 2)
                    .outputs(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 9, 2))
                    .EUt(VA[MV])
                    .duration(SECOND)
                    .buildAndRegister();

            ALLOY_SMELTER_RECIPES.recipeBuilder()
                    .input(gem, EnderPearl)
                    .input(dust, Fluix, 2)
                    .outputs(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 9, 2))
                    .EUt(VA[MV])
                    .duration(SECOND)
                    .buildAndRegister();

            ALLOY_SMELTER_RECIPES.recipeBuilder()
                    .input(dust, EnderPearl)
                    .input(gem, Fluix, 2)
                    .outputs(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 9, 2))
                    .EUt(VA[MV])
                    .duration(SECOND)
                    .buildAndRegister();

            ALLOY_SMELTER_RECIPES.recipeBuilder()
                    .input(dust, EnderPearl)
                    .input(dust, Fluix, 2)
                    .outputs(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 9, 2))
                    .EUt(VA[MV])
                    .duration(SECOND)
                    .buildAndRegister();
        }

        //  Remove some misc recipes.
        ModHandler.removeRecipeByName(Mods.AppliedEnergistics2.getID() + ":" + "materials/formationcore");
        ModHandler.removeRecipeByName(Mods.AppliedEnergistics2.getID() + ":" + "materials/annihilationcore");
        ModHandler.removeRecipeByName(Mods.AppliedEnergistics2.getID() + ":" + "network/wireless_booster");

        //  Formation Core
        ModHandler.removeRecipeByOutput(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 43));
        ModHandler.addShapedRecipe(true, "formation_core", getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 43, 4),
                "   ", "CDX", "   ",
                'C', new UnificationEntry(gem, CertusQuartz),
                'D', new UnificationEntry(wireFine, Fluix),
                'X', getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 22)); // Logic Processor

        if (Mods.LazyAE2.isModLoaded()) {
            addAggregatorRecipe(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 43, 16),
                    "gemCertusQuartz",
                    "plateFluix",
                    "wireFineGold");
        }

        //  Annihilation Core
        ModHandler.removeRecipeByOutput(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 44));
        ModHandler.addShapedRecipe(true, "annihilation_core", getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 44, 4),
                "   ", "CDX", "   ",
                'C', new UnificationEntry(gem, NetherQuartz),
                'D', new UnificationEntry(wireFine, Fluix),
                'X', getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 22)); // Logic Processor

        if (Mods.LazyAE2.isModLoaded()) {
            addAggregatorRecipe(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 44, 16),
                    "gemNetherQuartz",
                    "plateFluix",
                    "wireFineGold");
        }

        //  Lazy AE2 related Materials
        if (Mods.LazyAE2.isModLoaded()) {
            //  Remove deprecated item recipes.
            removeAggregatorRecipe(getMetaItemById(Mods.LazyAE2.getID(), "material", 1));
            removeAggregatorRecipe(getMetaItemById(Mods.LazyAE2.getID(), "material", 5));
            removeAggregatorRecipe(getMetaItemById(Mods.LazyAE2.getID(), "material", 7));
            removeCentrifugeRecipe(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 4));
            removeCentrifugeRecipe(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 46));

            //  Carbonic Fluix Complex
            //  This item supported an advanced recipe of Fluix Iron, if you in LV stage, then you can use this recipe to make it.
            ModHandler.removeRecipeByOutput(getMetaItemById(Mods.LazyAE2.getID(), "material", 1));
            MIXER_RECIPES.recipeBuilder()
                    .input(dust, Fluix)
                    .input(dust, Carbon)
                    .outputs(getMetaItemById(Mods.LazyAE2.getID(), "material", 1, 2))
                    .EUt(VA[LV])
                    .duration(SECOND)
                    .buildAndRegister();

            //  Fluix Iron
            //  A basic recipe of Fluix Iron, do not need Carbonic Fluix Complex.
            addInscriberRecipe(getMetaItemById(Mods.LazyAE2.getID(), "material", 2),
                    OreDictUnifier.get(ingot, WroughtIron),
                    false,
                    OreDictUnifier.get(dust, Fluix),
                    getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 45)); // Sky Stone Dust

            //  Fluix Steel
            ModHandler.removeFurnaceSmelting(getMetaItemById(Mods.LazyAE2.getID(), "material", 2));// FIXME seems not loading
            removeAggregatorRecipe(getMetaItemById(Mods.LazyAE2.getID(), "material", 0));
            addAggregatorRecipe(getMetaItemById(Mods.LazyAE2.getID(), "material", 0),
                    "ingotFluixIron",
                    "dustCoke",
                    "dustSkyStone");
        }

    }
}
