package magicbook.gtlitecore.integration.appliedenergistics2.recipes;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.stack.ItemMaterialInfo;
import gregtech.api.unification.stack.MaterialStack;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.BlockBatteryPart;
import gregtech.common.blocks.MetaBlocks;
import magicbook.gtlitecore.api.utils.Mods;
import magicbook.gtlitecore.common.blocks.BlockEnergyCell;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static gregicality.multiblocks.api.unification.GCYMMaterials.HSLASteel;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLY_LINE_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gregtech.common.metatileentities.MetaTileEntities.ALUMINIUM_DRUM;
import static gregtech.common.metatileentities.MetaTileEntities.HULL;
import static magicbook.gtlitecore.api.GTLiteValues.MINUTE;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.api.utils.GTLiteUtility.gtliteId;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class AE2MachineRecipeLoader {

    public static void init() {

        //  Charger
        ModHandler.removeRecipeByOutput(Mods.AppliedEnergistics2.getItemByID("charger"));
        ModHandler.addShapedRecipe(true, "charger", Mods.AppliedEnergistics2.getItemByID("charger"),
                "PPP", "SL ", "PPP",
                'P', new UnificationEntry(plate, DarkSteel),
                'S', new UnificationEntry(stick, ElectricalSteel),
                'L', new UnificationEntry(lens, Fluix));

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(plate, DarkSteel, 6)
                .input(stick, ElectricalSteel)
                .input(lens, Fluix)
                .outputs(Mods.AppliedEnergistics2.getItemByID("charger"))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Inscriber
        ModHandler.removeRecipeByOutput(Mods.AppliedEnergistics2.getItemByID("inscriber"));
        ModHandler.addShapedRecipe(true, "inscriber", Mods.AppliedEnergistics2.getItemByID("inscriber"),
                "PIP", "PG ", "PIP",
                'P', new UnificationEntry(plate, ElectricalSteel),
                'G', new UnificationEntry(gear, Fluix),
                'I', ELECTRIC_PISTON_LV);

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(plate, ElectricalSteel, 5)
                .input(gear, Fluix)
                .input(ELECTRIC_PISTON_LV, 2)
                .outputs(Mods.AppliedEnergistics2.getItemByID("inscriber"))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  ME Controller
        ModHandler.removeRecipeByOutput(Mods.AppliedEnergistics2.getItemByID("controller"));
        ModHandler.addShapedRecipe(true, "me_controller", Mods.AppliedEnergistics2.getItemByID("controller", 2),
                "PXP", "YFY", "PXP",
                'P', new UnificationEntry(plate, DarkSteel),
                'F', new UnificationEntry(frameGt, Fluix),
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.LV),
                'Y', Mods.AppliedEnergistics2.getMetaItemByID("material", 24)); // Engineering Processor

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(frameGt, Fluix)
                .input(plate, DarkSteel, 4)
                .input(circuit, MarkerMaterials.Tier.LV, 2)
                .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 24, 2)) // Engineering Processor
                .outputs(Mods.AppliedEnergistics2.getItemByID("controller", 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  ME Chest
        //  If {@code ironchest} is loaded, then use Iron Chest replaced vanilla Chest in this recipe.
        ModHandler.removeRecipeByOutput(Mods.AppliedEnergistics2.getItemByID("chest"));
        if (Mods.IronChest.isModLoaded()) {
            ModHandler.addShapedRecipe(true, "me_chest", Mods.AppliedEnergistics2.getItemByID("chest"),
                    "WYW", "PCP", "WGW",
                    'P', new UnificationEntry(plate, DarkSteel),
                    'C', Mods.IronChest.getMetaItemByID("iron_chest", 0), // Iron Chest
                    'G', new UnificationEntry(gear, Fluix),
                    'W', "cableAeGlass", // ME Glass Cable
                    'Y', Mods.AppliedEnergistics2.getMetaItemByID("material", 22)); // Logic Processor

            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(2)
                    .inputs(Mods.IronChest.getMetaItemByID("iron_chest", 0)) // Iron Chest
                    .input(plate, DarkSteel, 2)
                    .input(gear, Fluix)
                    .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 22)) // Logic Processor
                    .input("cableAeGlass", 4) // ME Glass Cable
                    .outputs(Mods.AppliedEnergistics2.getItemByID("chest"))
                    .EUt(VA[LV])
                    .duration(50)
                    .buildAndRegister();
        } else {
            ModHandler.addShapedRecipe(true, "me_chest", Mods.AppliedEnergistics2.getItemByID("chest"),
                    "WYW", "PCP", "WGW",
                    'P', new UnificationEntry(plate, DarkSteel),
                    'C', new ItemStack(Blocks.CHEST),
                    'G', new UnificationEntry(gear, Fluix),
                    'W', "cableAeGlass",
                    'Y', Mods.AppliedEnergistics2.getMetaItemByID("material", 22)); // Logic Processor

            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(2)
                    .inputs(new ItemStack(Blocks.CHEST))
                    .input(plate, DarkSteel, 2)
                    .input(gear, Fluix)
                    .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 22)) // Logic Processor
                    .input("cableAeGlass") // ME Glass Cable
                    .outputs(Mods.AppliedEnergistics2.getItemByID("chest"))
                    .EUt(VA[LV])
                    .duration(50)
                    .buildAndRegister();
        }

        //  ME Driver
        ModHandler.removeRecipeByOutput(Mods.AppliedEnergistics2.getItemByID("drive"));
        ModHandler.addShapedRecipe(true, "me_driver", Mods.AppliedEnergistics2.getItemByID("drive"),
                "PYP", "WFW", "PXP",
                'P', new UnificationEntry(plate, ElectricalSteel),
                'F', new UnificationEntry(frameGt, DarkSteel),
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.LV),
                'W', "cableAeGlass", // ME Glass Cable
                'Y', Mods.AppliedEnergistics2.getMetaItemByID("material", 24)); // Engineering Processor

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(frameGt, DarkSteel)
                .input(plate, ElectricalSteel, 4)
                .input(circuit, MarkerMaterials.Tier.LV)
                .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 24)) // Engineering Processor
                .input("cableAeGlass", 2) // ME Glass Cable
                .outputs(Mods.AppliedEnergistics2.getItemByID("drive"))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  ME Security Terminal
        ModHandler.removeRecipeByOutput(Mods.AppliedEnergistics2.getItemByID("security_station"));
        ModHandler.addShapedRecipe(true, "me_security_terminal", Mods.AppliedEnergistics2.getItemByID("security_station"),
                "PYP", "ACB", "PZP",
                'P', new UnificationEntry(plate, EnergeticAlloy),
                'Z', new UnificationEntry(screw, Soularium),
                'C', Mods.AppliedEnergistics2.getItemByID("chest"), // ME Chest
                'A', Mods.AppliedEnergistics2.getMetaItemByID("material", 37), // 16k Item Storage Component
                'B', Mods.AppliedEnergistics2.getMetaItemByID("material", 56), // 16k Fluid Storage Component
                'Y', Mods.AppliedEnergistics2.getMetaItemByID("material", 24)); // Engineering Processor

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .inputs(Mods.AppliedEnergistics2.getItemByID("chest"))
                .input(plate, EnergeticAlloy, 4)
                .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 37)) // 16k Item Storage Component
                .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 56)) // 16k Fluid Storage Component
                .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 24)) // Engineering Processor
                .input(screw, Soularium)
                .outputs(Mods.AppliedEnergistics2.getItemByID("security_station"))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  ME Interface & Fluid Interface
        ModHandler.removeRecipeByName(Mods.AppliedEnergistics2.getID() + ":" + "network/blocks/interfaces_interface");
        ModHandler.removeRecipeByName(Mods.AppliedEnergistics2.getID() + ":" + "network/blocks/fluid_interfaces_interface");

        ItemStack[] machineHulls = { HULL[LV].getStackForm(), HULL[MV].getStackForm(), HULL[HV].getStackForm(), HULL[EV].getStackForm(), HULL[IV].getStackForm(),
                HULL[LuV].getStackForm() };

        ItemStack[] robotArms = { ROBOT_ARM_LV.getStackForm(), ROBOT_ARM_MV.getStackForm(), ROBOT_ARM_HV.getStackForm(), ROBOT_ARM_EV.getStackForm(),
                ROBOT_ARM_IV.getStackForm(), ROBOT_ARM_LuV.getStackForm() };

        ItemStack[] robotArms2x = { ROBOT_ARM_LV.getStackForm(2), ROBOT_ARM_MV.getStackForm(2), ROBOT_ARM_HV.getStackForm(2),
                ROBOT_ARM_EV.getStackForm(2), ROBOT_ARM_IV.getStackForm(2), ROBOT_ARM_LuV.getStackForm(2)};

        ItemStack[] electricPumps = { ELECTRIC_PUMP_LV.getStackForm(), ELECTRIC_PUMP_MV.getStackForm(), ELECTRIC_PUMP_HV.getStackForm(), ELECTRIC_PUMP_EV.getStackForm(),
                ELECTRIC_PUMP_IV.getStackForm(), ELECTRIC_PUMP_LuV.getStackForm() };

        ItemStack[] electricPumps2x = { ELECTRIC_PUMP_LV.getStackForm(2), ELECTRIC_PUMP_MV.getStackForm(2), ELECTRIC_PUMP_HV.getStackForm(2),
                ELECTRIC_PUMP_EV.getStackForm(2), ELECTRIC_PUMP_IV.getStackForm(2), ELECTRIC_PUMP_LuV.getStackForm(2) };

        Material[] frameGts = { Steel, Aluminium, StainlessSteel, Titanium, TungstenSteel, RhodiumPlatedPalladium };

        int[] products = { 2, 4, 8, 16, 32, 64 };

        for (int i = 0; i < machineHulls.length; i++) {
            ModHandler.addShapedRecipe(true, "me_interface_" + VN[i + 1].toLowerCase(), Mods.AppliedEnergistics2.getItemByID("interface", products[i]),
                    "FRF", "CMD", "FRF",
                    'F', new UnificationEntry(frameGt, frameGts[i]),
                    'M', machineHulls[i],
                    'R', robotArms[i],
                    'C', Mods.AppliedEnergistics2.getMetaItemByID("material", 43), // Formation Core
                    'D', Mods.AppliedEnergistics2.getMetaItemByID("material", 44)); // Annihilation Core

            ModHandler.addShapedRecipe(true, "me_fluid_interface_" + VN[i + 1].toLowerCase(), Mods.AppliedEnergistics2.getItemByID("fluid_interface", products[i]),
                    "FPF", "CMD", "FPF",
                    'F', new UnificationEntry(frameGt, frameGts[i]),
                    'M', machineHulls[i],
                    'P', electricPumps[i],
                    'C', Mods.AppliedEnergistics2.getMetaItemByID("material", 43), // Formation Core
                    'D', Mods.AppliedEnergistics2.getMetaItemByID("material", 44)); // Annihilation Core

            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(2)
                    .inputs(machineHulls[i])
                    .input(frameGt, frameGts[i], 4)
                    .inputs(robotArms2x[i])
                    .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 43))
                    .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 44))
                    .outputs(Mods.AppliedEnergistics2.getItemByID("interface", products[i]))
                    .EUt(VA[LV])
                    .duration(50)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(2)
                    .inputs(machineHulls[i])
                    .input(frameGt, frameGts[i], 4)
                    .inputs(electricPumps2x[i])
                    .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 43))
                    .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 44))
                    .outputs(Mods.AppliedEnergistics2.getItemByID("fluid_interface", products[i]))
                    .EUt(VA[LV])
                    .duration(50)
                    .buildAndRegister();
        }

        //  Only Allowed player recycle materials of Annihilation/Formation Core in ME Interface/Fluid Interface.
        OreDictUnifier.registerOre(Mods.AppliedEnergistics2.getItemByID("interface"),
                new ItemMaterialInfo(new MaterialStack(CertusQuartz, M / 4),
                        new MaterialStack(NetherQuartz, M / 4),
                        new MaterialStack(Fluix, M / 4)));

        OreDictUnifier.registerOre(Mods.AppliedEnergistics2.getItemByID("fluid_interface"),
                new ItemMaterialInfo(new MaterialStack(CertusQuartz, M / 4),
                        new MaterialStack(NetherQuartz, M / 4),
                        new MaterialStack(Fluix, M / 4)));

        //  Molecular Assembler
        ModHandler.removeRecipeByOutput(Mods.AppliedEnergistics2.getItemByID("molecular_assembler"));
        ModHandler.addShapedRecipe(true, "molecular_assembler", Mods.AppliedEnergistics2.getItemByID("molecular_assembler", 2),
                "PGP", "ACB", "PGP",
                'P', new UnificationEntry(plate, ElectricalSteel),
                'C', new ItemStack(Blocks.CRAFTING_TABLE),
                'A', Mods.AppliedEnergistics2.getMetaItemByID("material", 44), // Annihilation Core
                'B', Mods.AppliedEnergistics2.getMetaItemByID("material", 43), // Formation Core
                'G', Mods.AppliedEnergistics2.getItemByID("quartz_glass")); // Quartz Glass

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .inputs(new ItemStack(Blocks.CRAFTING_TABLE))
                .inputs(Mods.AppliedEnergistics2.getItemByID("quartz_glass")) // Quartz Glass
                .input(plate, ElectricalSteel, 4)
                .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 43)) // Formation Core
                .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 44)) // Annihilation Core
                .outputs(Mods.AppliedEnergistics2.getItemByID("molecular_assembler", 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Allowed used Crafting Station (in same name mod) to make Molecular Assembler.
        if (Mods.CraftingStation.isModLoaded()) {
            ModHandler.addShapedRecipe(true, "molecular_assembler_crafting_station", Mods.AppliedEnergistics2.getItemByID("molecular_assembler", 2),
                    "PGP", "ACB", "PGP",
                    'P', new UnificationEntry(plate, ElectricalSteel),
                    'C', Mods.CraftingStation.getItemByID("crafting_station"), // Crafting Station
                    'A', Mods.AppliedEnergistics2.getMetaItemByID("material", 44), // Annihilation Core
                    'B', Mods.AppliedEnergistics2.getMetaItemByID("material", 43), // Formation Core
                    'G', Mods.AppliedEnergistics2.getItemByID("quartz_glass")); // Quartz Glass

            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(2)
                    .inputs(Mods.CraftingStation.getItemByID("crafting_station")) // Crafting Station
                    .inputs(Mods.AppliedEnergistics2.getItemByID("quartz_glass")) // Quartz Glass
                    .input(plate, ElectricalSteel, 4)
                    .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 43)) // Formation Core
                    .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 44)) // Annihilation Core
                    .outputs(Mods.AppliedEnergistics2.getItemByID("molecular_assembler", 2))
                    .EUt(VA[LV])
                    .duration(50)
                    .buildAndRegister();
        }

        //  ME IO Port
        ModHandler.removeRecipeByOutput(Mods.AppliedEnergistics2.getItemByID("io_port"));
        ModHandler.addShapedRecipe(true, "io_port", Mods.AppliedEnergistics2.getItemByID("io_port"),
                "WYW", "PDP", "WGW",
                'P', new UnificationEntry(plate, ElectricalSteel),
                'G', new UnificationEntry(gearSmall, RedstoneAlloy),
                'D', Mods.AppliedEnergistics2.getItemByID("drive"),
                'W', "cableAeGlass", // ME Glass Cable
                'Y', Mods.AppliedEnergistics2.getMetaItemByID("material", 22)); // Logic Processor

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .inputs(Mods.AppliedEnergistics2.getItemByID("drive"))
                .input(plate, ElectricalSteel, 2)
                .input(gearSmall, RedstoneAlloy)
                .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 22)) // Logic Processor
                .input("cableAeGlass", 4) // ME Glass Cable
                .outputs(Mods.AppliedEnergistics2.getItemByID("io_port"))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Spatial IO Port
        ModHandler.removeRecipeByOutput(Mods.AppliedEnergistics2.getItemByID("spatial_io_port"));
        ModHandler.addShapedRecipe(true, "spatial_io_port", Mods.AppliedEnergistics2.getItemByID("spatial_io_port"),
                "PSP", "WCW", "PYP",
                'C', Mods.AppliedEnergistics2.getItemByID("io_port"), // ME IO Port
                'S', Mods.AppliedEnergistics2.getItemByID("spatial_pylon"), // Spatial Pylon
                'P', new UnificationEntry(plate, VibrantAlloy),
                'W', "cableAeGlass", // ME Glass Cable
                'Y', Mods.AppliedEnergistics2.getMetaItemByID("material", 24)); // Engineering Processor

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .inputs(Mods.AppliedEnergistics2.getItemByID("io_port"))
                .inputs(Mods.AppliedEnergistics2.getItemByID("spatial_pylon"))
                .input(plate, VibrantAlloy, 4)
                .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 24)) // Engineering Processor
                .input("cableAeGlass", 2) // ME Glass Cable
                .outputs(Mods.AppliedEnergistics2.getItemByID("spatial_io_port"))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Sptial Pylon
        ModHandler.removeRecipeByOutput(Mods.AppliedEnergistics2.getItemByID("spatial_pylon"));
        ModHandler.addShapedRecipe(true, "spatial_pylon", Mods.AppliedEnergistics2.getItemByID("spatial_pylon", 2),
                "PGP", "AFA", "PXP",
                'F', new UnificationEntry(frameGt, Soularium),
                'P', new UnificationEntry(plate, Fluix),
                'G', FIELD_GENERATOR_LV,
                'X', FLUIX_LOGIC_COMPUTER,
                'A', Mods.AppliedEnergistics2.getItemByID("quartz_vibrant_glass")); // Vibrant Quartz Glass

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(frameGt, Soularium)
                .input(plate, Fluix, 4)
                .input(FIELD_GENERATOR_LV)
                .input(FLUIX_LOGIC_COMPUTER)
                .inputs(Mods.AppliedEnergistics2.getItemByID("quartz_vibrant_glass", 2))
                .outputs(Mods.AppliedEnergistics2.getItemByID("spatial_pylon", 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Cell Workbench
        ModHandler.removeRecipeByOutput(Mods.AppliedEnergistics2.getItemByID("cell_workbench"));
        ModHandler.addShapedRecipe(true, "cell_workbench", Mods.AppliedEnergistics2.getItemByID("cell_workbench"),
                "PAP", "PCP", "P P",
                'P', new UnificationEntry(plate, CertusQuartz),
                'C', new ItemStack(Blocks.CRAFTING_TABLE),
                'A', Mods.AppliedEnergistics2.getMetaItemByID("material", 23)); // Calculation Processor

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .inputs(new ItemStack(Blocks.CRAFTING_TABLE))
                .input(plate, CertusQuartz, 6)
                .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 23)) // Calculation Processor
                .outputs(Mods.AppliedEnergistics2.getItemByID("cell_workbench"))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Allowed used Crafting Station (in same name mod) to make Cell Workbench.
        if (Mods.CraftingStation.isModLoaded()) {
            ModHandler.addShapedRecipe(true, "cell_workbench_crafting_station", Mods.AppliedEnergistics2.getItemByID("cell_workbench"),
                    "PAP", "PCP", "P P",
                    'P', new UnificationEntry(plate, CertusQuartz),
                    'C', Mods.CraftingStation.getItemByID("crafting_station"),
                    'A', Mods.AppliedEnergistics2.getMetaItemByID("material", 23)); // Calculation Processor

            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(2)
                    .inputs(Mods.CraftingStation.getItemByID("crafting_station"))
                    .input(plate, CertusQuartz, 6)
                    .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 23)) // Calculation Processor
                    .outputs(Mods.AppliedEnergistics2.getItemByID("cell_workbench"))
                    .EUt(VA[LV])
                    .duration(50)
                    .buildAndRegister();
        }

        //  Matter Condenser
        ModHandler.removeRecipeByOutput(Mods.AppliedEnergistics2.getItemByID("condenser"));
        ModHandler.addShapedRecipe(true, "matter_condenser", Mods.AppliedEnergistics2.getItemByID("condenser"),
                "PGP", "SFS", "PWP",
                'F', new UnificationEntry(frameGt, CertusQuartz),
                'G', new UnificationEntry(gear, Fluix),
                'P', new UnificationEntry(plate, CertusQuartz),
                'W', "cableAeGlass", // ME Glass Cable
                'S', ELECTRIC_PISTON_LV);

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(frameGt, CertusQuartz)
                .input(plate, CertusQuartz, 4)
                .input(gear, Fluix)
                .input(ELECTRIC_PISTON_LV, 2)
                .input("cableAeGlass") // ME Glass Cable
                .outputs(Mods.AppliedEnergistics2.getItemByID("condenser"))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Energy Acceptor
        ModHandler.removeRecipeByOutput(Mods.AppliedEnergistics2.getItemByID("energy_acceptor"));
        ModHandler.addShapedRecipe(true, "energy_acceptor", Mods.AppliedEnergistics2.getItemByID("energy_acceptor"),
                "PGP", "GCG", "PGP",
                'C', new UnificationEntry(frameGt, Fluix),
                'G', Mods.AppliedEnergistics2.getItemByID("quartz_vibrant_glass"), // Vibrant Quartz Glass
                'P', new UnificationEntry(plate, ElectricalSteel));

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(frameGt, Fluix)
                .input(plate, ElectricalSteel, 4)
                .inputs(Mods.AppliedEnergistics2.getItemByID("quartz_vibrant_glass", 4))
                .outputs(Mods.AppliedEnergistics2.getItemByID("energy_acceptor"))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Vibration Chamber
        ModHandler.removeRecipeByOutput(Mods.AppliedEnergistics2.getItemByID("vibration_chamber"));
        if (Mods.MoreFurnaces.isModLoaded()) {
            ModHandler.addShapedRecipe(true, "vibration_chamber", Mods.AppliedEnergistics2.getItemByID("vibration_chamber"),
                    "SSS", "SFS", "SCS",
                    'C', new UnificationEntry(gear, CertusQuartz),
                    'F', Mods.MoreFurnaces.getMetaItemByID("furnaceblock", 0), // Iron Furnace
                    'S', Mods.AppliedEnergistics2.getItemByID("smooth_sky_stone_block"));

            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(2)
                    .inputs(Mods.MoreFurnaces.getMetaItemByID("furnaceblock", 0)) // Iron Furnace
                    .inputs(Mods.AppliedEnergistics2.getItemByID("smooth_sky_stone_block", 7))
                    .input(gear, CertusQuartz)
                    .outputs(Mods.AppliedEnergistics2.getItemByID("vibration_chamber"))
                    .EUt(VA[LV])
                    .duration(50)
                    .buildAndRegister();
        } else {
            ModHandler.addShapedRecipe(true, "vibration_chamber", Mods.AppliedEnergistics2.getItemByID("vibration_chamber"),
                    "SSS", "SFS", "SCS",
                    'C', new UnificationEntry(gear, CertusQuartz),
                    'F', new ItemStack(Blocks.FURNACE),
                    'S', Mods.AppliedEnergistics2.getItemByID("smooth_sky_stone_block"));

            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(2)
                    .inputs(new ItemStack(Blocks.FURNACE))
                    .inputs(Mods.AppliedEnergistics2.getItemByID("smooth_sky_stone_block", 7))
                    .input(gear, CertusQuartz)
                    .outputs(Mods.AppliedEnergistics2.getItemByID("vibration_chamber"))
                    .EUt(VA[LV])
                    .duration(50)
                    .buildAndRegister();
        }

        //  Quartz Growth Accelerator
        ModHandler.removeRecipeByOutput(Mods.AppliedEnergistics2.getItemByID("quartz_growth_accelerator"));
        ModHandler.addShapedRecipe(true, "quartz_growth_accelerator", Mods.AppliedEnergistics2.getItemByID("quartz_growth_accelerator"),
                "PAP", "RFR", "PAP",
                'F', new UnificationEntry(frameGt, DarkSteel),
                'R', new UnificationEntry(stick, Fluix),
                'P', new UnificationEntry(plate, CertusQuartz),
                'A', new UnificationEntry(plate, NetherQuartz));

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(frameGt, DarkSteel)
                .input(plate, CertusQuartz, 4)
                .input(plate, NetherQuartz, 2)
                .input(stick, Fluix, 2)
                .outputs(Mods.AppliedEnergistics2.getItemByID("quartz_growth_accelerator"))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Quartz Growth Chamber (AE2 Stuff)
        if (Mods.AE2Stuff.isModLoaded()) {
            ModHandler.removeRecipeByName(Mods.AE2Stuff.getID() + ":" + "recipe1");
            if (Mods.LazyAE2.isModLoaded()) {
                ModHandler.addShapedRecipe(true, "quartz_growth_chamber", Mods.AE2Stuff.getItemByID("grower"),
                        "WPW", "GCG", "WYW",
                        'G', new UnificationEntry(gear, Fluix),
                        'C', Mods.AppliedEnergistics2.getItemByID("quartz_growth_accelerator"),
                        'P', Mods.AppliedEnergistics2.getMetaItemByID("material", 9), // Fluix Pearl
                        'Y', Mods.LazyAE2.getMetaItemByID("material", 6), // Parallel Processor
                        'W', "cableAeGlass"); // ME Glass Cable

                ASSEMBLER_RECIPES.recipeBuilder()
                        .circuitMeta(2)
                        .inputs(Mods.AppliedEnergistics2.getItemByID("quartz_growth_accelerator"))
                        .input(gear, Fluix, 2)
                        .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 9)) // Fluix Pearl
                        .inputs(Mods.LazyAE2.getMetaItemByID("material", 6)) // Parallel Processor
                        .input("cableAeGlass", 4) // ME Glass Cable
                        .outputs(Mods.AE2Stuff.getItemByID("grower"))
                        .EUt(VA[LV])
                        .duration(50)
                        .buildAndRegister();
            } else {
                ModHandler.addShapedRecipe(true, "quartz_growth_chamber", Mods.AE2Stuff.getItemByID("grower"),
                        "WPW", "GCG", "WYW",
                        'G', new UnificationEntry(gear, Fluix),
                        'C', Mods.AppliedEnergistics2.getItemByID("quartz_growth_accelerator"),
                        'P', Mods.AppliedEnergistics2.getMetaItemByID("material", 9), // Fluix Pearl
                        'Y', Mods.AppliedEnergistics2.getMetaItemByID("material", 23), // Calculation Processor
                        'W', "cableAeGlass"); // ME Glass Cable

                ASSEMBLER_RECIPES.recipeBuilder()
                        .circuitMeta(2)
                        .inputs(Mods.AppliedEnergistics2.getItemByID("quartz_growth_accelerator"))
                        .input(gear, Fluix, 2)
                        .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 9)) // Fluix Pearl
                        .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 23)) // Calculation Processor
                        .input("cableAeGlass", 4) // ME Glass Cable
                        .outputs(Mods.AE2Stuff.getItemByID("grower"))
                        .EUt(VA[LV])
                        .duration(50)
                        .buildAndRegister();
            }
        }

        //  ME Quantum Ring
        ModHandler.removeRecipeByOutput(Mods.AppliedEnergistics2.getItemByID("quantum_ring"));
        if (Mods.LazyAE2.isModLoaded()) {
            ModHandler.addShapedRecipe(true, "me_quantum_ring", Mods.AppliedEnergistics2.getItemByID("quantum_ring", 2),
                    "PXP", "ZCW", "PYP",
                    'P', new UnificationEntry(plate, EnrichedAlloy),
                    'C', Mods.AppliedEnergistics2.getItemByID("energy_cell"),
                    'W', "cableAeDenseSmart",
                    'X', Mods.LazyAE2.getMetaItemByID("material", 6), // Parallel Processor
                    'Y', Mods.LazyAE2.getMetaItemByID("material", 14), // Speculative Processor
                    'Z', DEDUCTION_PROCESSOR);

            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(2)
                    .inputs(Mods.AppliedEnergistics2.getItemByID("energy_cell"))
                    .input(plate, EnrichedAlloy, 4)
                    .inputs(Mods.LazyAE2.getMetaItemByID("material", 6)) // Parallel Processor
                    .inputs(Mods.LazyAE2.getMetaItemByID("material", 14)) // Speculative Processor
                    .input(DEDUCTION_PROCESSOR)
                    .input("cableAeDenseSmart")
                    .outputs(Mods.AppliedEnergistics2.getItemByID("quantum_ring", 2))
                    .EUt(VA[LV])
                    .duration(50)
                    .buildAndRegister();
        } else {
            ModHandler.addShapedRecipe(true, "me_quantum_ring", Mods.AppliedEnergistics2.getItemByID("quantum_ring", 2),
                    "PXP", "ZCW", "PYP",
                    'P', new UnificationEntry(plate, EnrichedAlloy),
                    'C', Mods.AppliedEnergistics2.getItemByID("energy_cell"),
                    'W', "cableAeDenseSmart",
                    'X', Mods.AppliedEnergistics2.getItemByID("material", 22), // Logic Processor
                    'Y', Mods.AppliedEnergistics2.getItemByID("material", 23), // Calculation Processor
                    'Z', Mods.AppliedEnergistics2.getItemByID("material", 24)); // Engineering Processor

            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(2)
                    .inputs(Mods.AppliedEnergistics2.getItemByID("energy_cell"))
                    .input(plate, EnrichedAlloy, 4)
                    .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 22)) // Logic Processor
                    .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 23)) // Calculation Processor
                    .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 24)) // Engineering Processor
                    .input("cableAeDenseSmart")
                    .outputs(Mods.AppliedEnergistics2.getItemByID("quantum_ring", 2))
                    .EUt(VA[LV])
                    .duration(50)
                    .buildAndRegister();
        }

        //  ME Quantum Link Chamber
        ModHandler.removeRecipeByOutput(Mods.AppliedEnergistics2.getItemByID("quantum_link"));
        ModHandler.addShapedRecipe("me_quantum_link_chamber", Mods.AppliedEnergistics2.getItemByID("quantum_link", 2),
                "GPG", "PFP", "GPG",
                'G', Mods.AppliedEnergistics2.getItemByID("quartz_vibrant_glass"),
                'P', Mods.AppliedEnergistics2.getMetaItemByID("material", 9), // Fluix Pearl
                'F', FIELD_GENERATOR_LV);

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .inputs(Mods.AppliedEnergistics2.getItemByID("quartz_vibrant_glass", 4))
                .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 9, 4)) // Fluix Pearl
                .input(FIELD_GENERATOR_LV)
                .outputs(Mods.AppliedEnergistics2.getItemByID("quantum_link", 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        // ------------------------------- Crafting Storage Units --------------------------------

        //  Crafting Unit
        ModHandler.removeRecipeByOutput(Mods.AppliedEnergistics2.getItemByID("crafting_unit"));
        Material[] middlePlates = { TinAlloy, VanadiumSteel, BlackSteel, HSLASteel, BlueSteel, RedSteel };
        for (int i = 0; i < products.length; i++) {
            ModHandler.addShapedRecipe(true, "crafting_unit_" + VN[i + 1], Mods.AppliedEnergistics2.getItemByID("crafting_unit", products[i]),
                    "PYP", "WXW", "PYP",
                    'P', new UnificationEntry(plate, middlePlates[i]),
                    'W', "cableAeGlass", // ME Glass Cable
                    'X', Mods.AppliedEnergistics2.getMetaItemByID("material", 22), // Logic Processor
                    'Y', Mods.AppliedEnergistics2.getMetaItemByID("material", 23)); // Calculation Processor

            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(2)
                    .input(plate, middlePlates[i], 4)
                    .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 22))
                    .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 23, 2))
                    .input("cableAeGlass", 2)
                    .outputs(Mods.AppliedEnergistics2.getItemByID("crafting_unit", products[i]))
                    .EUt(VA[LV])
                    .duration(50)
                    .buildAndRegister();
        }

        //  1x
        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .inputs(Mods.AppliedEnergistics2.getItemByID("crafting_unit"))
                .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 35)) // 1k Item Storage Component
                .outputs(Mods.AppliedEnergistics2.getItemByID("crafting_storage_1k"))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  4x
        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .inputs(Mods.AppliedEnergistics2.getItemByID("crafting_unit"))
                .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 36)) // 4k Item Storage Component
                .outputs(Mods.AppliedEnergistics2.getItemByID("crafting_storage_4k"))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  16x
        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .inputs(Mods.AppliedEnergistics2.getItemByID("crafting_unit"))
                .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 37)) // 16k Item Storage Component
                .outputs(Mods.AppliedEnergistics2.getItemByID("crafting_storage_16k"))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  64x
        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .inputs(Mods.AppliedEnergistics2.getItemByID("crafting_unit"))
                .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 38)) // 64k Item Storage Component
                .outputs(Mods.AppliedEnergistics2.getItemByID("crafting_storage_64k"))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        if (Mods.NeevesAE2Addition.isModLoaded()) {
            //  256x
            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(2)
                    .inputs(Mods.AppliedEnergistics2.getItemByID("crafting_unit"))
                    .inputs(Mods.NeevesAE2Addition.getMetaItemByID("material", 1)) // 256k Item Storage Component
                    .outputs(Mods.NeevesAE2Addition.getItemByID("storage_crafting_256k"))
                    .EUt(VA[LV])
                    .duration(50)
                    .buildAndRegister();

            //  1024x
            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(2)
                    .inputs(Mods.AppliedEnergistics2.getItemByID("crafting_unit"))
                    .inputs(Mods.NeevesAE2Addition.getMetaItemByID("material", 2)) // 1024k Item Storage Component
                    .outputs(Mods.NeevesAE2Addition.getItemByID("storage_crafting_1024k"))
                    .EUt(VA[LV])
                    .duration(50)
                    .buildAndRegister();

            //  4096x
            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(2)
                    .inputs(Mods.AppliedEnergistics2.getItemByID("crafting_unit"))
                    .inputs(Mods.NeevesAE2Addition.getMetaItemByID("material", 3)) // 4096k Item Storage Component
                    .outputs(Mods.NeevesAE2Addition.getItemByID("storage_crafting_4096k"))
                    .EUt(VA[LV])
                    .duration(50)
                    .buildAndRegister();

            //  16384x
            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(2)
                    .inputs(Mods.AppliedEnergistics2.getItemByID("crafting_unit"))
                    .inputs(Mods.NeevesAE2Addition.getMetaItemByID("material", 4)) // 16384k Item Storage Component
                    .outputs(Mods.NeevesAE2Addition.getItemByID("storage_crafting_16384k"))
                    .EUt(VA[LV])
                    .duration(50)
                    .buildAndRegister();
        }

        // -------------------------------- Crafting Accelerators --------------------------------

        //  1x
        //  If Lazy AE2 ({@code threng}) is loaded, then remove original recipe of Crafting Accelerator,
        //  change processor requirement to Parallel Processor in Lazy AE2.
        if (Mods.LazyAE2.isModLoaded()) {
            ModHandler.removeRecipeByOutput(Mods.AppliedEnergistics2.getItemByID("crafting_accelerator"));
            GameRegistry.addShapelessRecipe(gtliteId("crafting_accelerator.1x"), new ResourceLocation(Mods.GregTechLiteCore.getID()), Mods.AppliedEnergistics2.getItemByID("crafting_accelerator"),
                    Ingredient.fromStacks(Mods.LazyAE2.getMetaItemByID("material", 6)), // Parallel Processor
                    Ingredient.fromStacks(Mods.AppliedEnergistics2.getItemByID("crafting_unit")));

            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(2)
                    .inputs(Mods.AppliedEnergistics2.getItemByID("crafting_unit"))
                    .inputs(Mods.LazyAE2.getMetaItemByID("material", 6)) // Parallel Processor
                    .outputs(Mods.AppliedEnergistics2.getItemByID("crafting_accelerator"))
                    .EUt(VA[LV])
                    .duration(50)
                    .buildAndRegister();
        } else {
            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(2)
                    .inputs(Mods.AppliedEnergistics2.getItemByID("crafting_unit"))
                    .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 24)) // Engineering Processor
                    .outputs(Mods.AppliedEnergistics2.getItemByID("crafting_accelerator"))
                    .EUt(VA[LV])
                    .duration(50)
                    .buildAndRegister();
        }

        if (Mods.NeevesAE2Addition.isModLoaded()) {
            //  4x
            ModHandler.removeRecipeByOutput(Mods.NeevesAE2Addition.getItemByID("coprocessor_4x"));
            ModHandler.addShapedRecipe(true, "crafting_accelerator.4x", Mods.NeevesAE2Addition.getItemByID("coprocessor_4x"),
                    "PAP", "WCW", "PBP",
                    'P', new UnificationEntry(plate, Fluix),
                    'C', Mods.AppliedEnergistics2.getItemByID("crafting_accelerator"),
                    'A', Mods.AppliedEnergistics2.getMetaItemByID("material", 23), // Calculation Processor
                    'B', DEDUCTION_PROCESSOR,
                    'W', "cableAeGlass");

            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(2)
                    .inputs(Mods.AppliedEnergistics2.getItemByID("crafting_accelerator"))
                    .input(plate, Fluix, 4)
                    .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 23)) // Calculation Processor
                    .input(DEDUCTION_PROCESSOR)
                    .input("cableAeGlass", 2)
                    .outputs(Mods.NeevesAE2Addition.getItemByID("coprocessor_4x"))
                    .EUt(VA[LV])
                    .duration(50)
                    .buildAndRegister();

            //  16x
            ModHandler.removeRecipeByOutput(Mods.NeevesAE2Addition.getItemByID("coprocessor_16x"));
            if (Mods.LazyAE2.isModLoaded()) {
                ModHandler.addShapedRecipe(true, "crafting_accelerator.16x", Mods.NeevesAE2Addition.getItemByID("coprocessor_16x"),
                        "PAP", "WCW", "PBP",
                        'P', new UnificationEntry(plateDouble, RedstoneAlloy),
                        'C', Mods.NeevesAE2Addition.getItemByID("coprocessor_4x"),
                        'A', Mods.AppliedEnergistics2.getMetaItemByID("material", 22), // Logic Processor
                        'B', Mods.LazyAE2.getMetaItemByID("material", 14), // Speculative Processor
                        'W', "cableAeCovered");

                ASSEMBLER_RECIPES.recipeBuilder()
                        .circuitMeta(2)
                        .inputs(Mods.NeevesAE2Addition.getItemByID("coprocessor_4x"))
                        .input(plateDouble, RedstoneAlloy, 4)
                        .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 22)) // Logic Processor
                        .inputs(Mods.LazyAE2.getMetaItemByID("material", 14)) // Speculative Processor
                        .input("cableAeCovered", 2)
                        .outputs(Mods.NeevesAE2Addition.getItemByID("coprocessor_16x"))
                        .EUt(VA[LV])
                        .duration(50)
                        .buildAndRegister();
            } else {
                ModHandler.addShapedRecipe(true, "crafting_accelerator.16x", Mods.NeevesAE2Addition.getItemByID("coprocessor_16x"),
                        "PAP", "WCW", "PBP",
                        'P', new UnificationEntry(plateDouble, RedstoneAlloy),
                        'C', Mods.NeevesAE2Addition.getItemByID("coprocessor_4x"),
                        'A', Mods.AppliedEnergistics2.getMetaItemByID("material", 22), // Logic Processor
                        'B', Mods.AppliedEnergistics2.getMetaItemByID("material", 24), // Engineering Processor
                        'W', "cableAeCovered");

                ASSEMBLER_RECIPES.recipeBuilder()
                        .circuitMeta(2)
                        .inputs(Mods.NeevesAE2Addition.getItemByID("coprocessor_4x"))
                        .input(plateDouble, RedstoneAlloy, 4)
                        .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 22)) // Logic Processor
                        .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 24)) // Engineering Processor
                        .input("cableAeCovered", 2)
                        .outputs(Mods.NeevesAE2Addition.getItemByID("coprocessor_16x"))
                        .EUt(VA[LV])
                        .duration(50)
                        .buildAndRegister();
            }

            //  64x
            ModHandler.removeRecipeByOutput(Mods.NeevesAE2Addition.getItemByID("coprocessor_64x"));
            ModHandler.addShapedRecipe(true, "crafting_accelerator.64x", Mods.NeevesAE2Addition.getItemByID("coprocessor_64x"),
                    "PXP", "WCW", "PYP",
                    'P', new UnificationEntry(plateDouble, Soularium),
                    'C', Mods.NeevesAE2Addition.getItemByID("coprocessor_16x"),
                    'X', Mods.AppliedEnergistics2.getMetaItemByID("material", 38), // 64k Item Storage Component
                    'Y', FLUIX_LOGIC_PROCESSOR,
                    'W', "cableAeSmart");

            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(2)
                    .inputs(Mods.NeevesAE2Addition.getItemByID("coprocessor_16x"))
                    .input(plateDouble, Soularium, 4)
                    .input(FLUIX_LOGIC_PROCESSOR)
                    .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 38))
                    .input("cableAeSmart", 2)
                    .outputs(Mods.NeevesAE2Addition.getItemByID("coprocessor_64x"))
                    .EUt(VA[LV])
                    .duration(50)
                    .buildAndRegister();

            //  TODO 256x, Use Fluix Logic Assembly

            //  TODO 1024x, Use Fluix Logic Computer

            //  TODO 4096x, Use Fluix Logic Mainframe
        }

        //  Creative Energy Unit
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, FluxedElectrum)
                .inputs(MetaBlocks.BATTERY_BLOCK.getItemVariant(BlockBatteryPart.BatteryPartType.ULTIMATE_UHV, 2))
                .inputs(GTLiteMetaBlocks.ENERGY_CELL.getItemVariant(BlockEnergyCell.CellTier.UV, 4))
                .inputs(Mods.AppliedEnergistics2.getItemByID("fluix_block", 64))
                .input(plateDouble, Duranium, 4)
                .input(plateDouble, Cinobite, 4)
                .input(circuit, MarkerMaterials.Tier.UHV, 6)
                .input(FLUIX_LOGIC_MAINFRAME, 12)
                .input(EMITTER_UV, 8)
                .input(SENSOR_UV, 8)
                .input(FIELD_GENERATOR_UV, 8)
                .input(NANO_PIC_WAFER, 64)
                .input(NANO_PIC_WAFER, 64)
                .input(gear, StellarAlloy, 16)
                .input(cableGtQuadruple, NaquadahAlloy, 16)
                .input(screw, Tritanium, 24)
                .fluidInputs(Lafium.getFluid(L * 80))
                .fluidInputs(EnrichedHolmium.getFluid(L * 60))
                .fluidInputs(TitanSteel.getFluid(L * 40))
                .fluidInputs(ArceusAlloy2B.getFluid(L * 20))
                .outputs(Mods.AppliedEnergistics2.getItemByID("creative_energy_cell"))
                .EUt(VA[UV])
                .duration(MINUTE)
                .stationResearch(b -> b
                        .researchStack(Mods.AppliedEnergistics2.getItemByID("dense_energy_cell"))
                        .EUt(VA[UV])
                        .CWUt(576))
                .buildAndRegister();

        // ------------------------------------------------ AE2FC Machines ------------------------------------------------

        if (Mods.AE2FluidCrafting.isModLoaded()) {
            //  Fluid Discretizer
            ModHandler.removeRecipeByOutput(Mods.AE2FluidCrafting.getItemByID("fluid_discretizer"));
            if (Mods.LazyAE2.isModLoaded()) {
                ModHandler.addShapedRecipe(true, "fluid_discretizer", Mods.AE2FluidCrafting.getItemByID("fluid_discretizer"),
                        "IXI", "ACB", "IYI",
                        'C', Mods.AppliedEnergistics2.getItemByID("condenser"),
                        'X', Mods.AppliedEnergistics2.getMetaItemByID("material", 24), // Engineering Processor
                        'Y', Mods.LazyAE2.getMetaItemByID("material", 14), // Speculative Processor
                        'A', Mods.AppliedEnergistics2.getMetaItemByID("part", 220), // ME Storage Bus
                        'B', Mods.AppliedEnergistics2.getMetaItemByID("part", 221), // ME Fluid Storage Bus
                        'I', "ingotFluixSteel");

                ASSEMBLER_RECIPES.recipeBuilder()
                        .circuitMeta(2)
                        .inputs(Mods.AppliedEnergistics2.getItemByID("condenser"))
                        .inputs(Mods.AppliedEnergistics2.getMetaItemByID("part", 220)) // ME Storage Bus
                        .inputs(Mods.AppliedEnergistics2.getMetaItemByID("part", 221)) // ME Fluid Storage Bus
                        .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 24)) // Engineering Processor
                        .inputs(Mods.LazyAE2.getMetaItemByID("material", 14)) // Speculative Processor
                        .input("ingotFluixSteel", 4)
                        .outputs(Mods.AE2FluidCrafting.getItemByID("fluid_discretizer"))
                        .EUt(VA[LV])
                        .duration(50)
                        .buildAndRegister();
            } else {
                ModHandler.addShapedRecipe(true, "fluid_discretizer", Mods.AE2FluidCrafting.getItemByID("fluid_discretizer"),
                        "IXI", "ACB", "IYI",
                        'C', Mods.AppliedEnergistics2.getItemByID("condenser"),
                        'X', Mods.AppliedEnergistics2.getMetaItemByID("material", 24), // Engineering Processor
                        'Y', Mods.AppliedEnergistics2.getMetaItemByID("material", 23), // Calculation Processor
                        'A', Mods.AppliedEnergistics2.getMetaItemByID("part", 220), // ME Storage Bus
                        'B', Mods.AppliedEnergistics2.getMetaItemByID("part", 221), // ME Fluid Storage Bus
                        'I', "ingotFluixSteel");

                ASSEMBLER_RECIPES.recipeBuilder()
                        .circuitMeta(2)
                        .inputs(Mods.AppliedEnergistics2.getItemByID("condenser"))
                        .inputs(Mods.AppliedEnergistics2.getMetaItemByID("part", 220)) // ME Storage Bus
                        .inputs(Mods.AppliedEnergistics2.getMetaItemByID("part", 221)) // ME Fluid Storage Bus
                        .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 24)) // Engineering Processor
                        .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 23)) // Calculation Processor
                        .input("ingotFluixSteel", 4)
                        .outputs(Mods.AE2FluidCrafting.getItemByID("fluid_discretizer"))
                        .EUt(VA[LV])
                        .duration(50)
                        .buildAndRegister();
            }

            //  Fluid Packet Encoder
            ModHandler.removeRecipeByOutput(Mods.AE2FluidCrafting.getItemByID("fluid_pattern_encoder"));
            ModHandler.addShapedRecipe(true, "fluid_pattern_encoder", Mods.AE2FluidCrafting.getItemByID("fluid_pattern_encoder"),
                    "PXP", "ACA", "A A",
                    'C', new ItemStack(Blocks.CRAFTING_TABLE),
                    'P', new UnificationEntry(plate, Lapis),
                    'A', new UnificationEntry(plate, ElectricalSteel),
                    'X', Mods.AppliedEnergistics2.getMetaItemByID("material", 24)); // Engineering Processor

            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(2)
                    .inputs(new ItemStack(Blocks.CRAFTING_TABLE))
                    .input(plate, ElectricalSteel, 4)
                    .input(plate, Lapis)
                    .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 24))
                    .outputs(Mods.AE2FluidCrafting.getItemByID("fluid_pattern_encoder"))
                    .EUt(VA[LV])
                    .duration(50)
                    .buildAndRegister();

            //  Allowed used Crafting Station (in same name mod) to make Fluid Packet Encoder.
            if (Mods.CraftingStation.isModLoaded()) {
                ModHandler.addShapedRecipe(true, "fluid_pattern_encoder_crafting_station", Mods.AE2FluidCrafting.getItemByID("fluid_pattern_encoder"),
                        "PXP", "ACA", "A A",
                        'C', Mods.CraftingStation.getItemByID("crafting_station"), // Crafting Station
                        'P', new UnificationEntry(plate, Lapis),
                        'A', new UnificationEntry(plate, ElectricalSteel),
                        'X', Mods.AppliedEnergistics2.getMetaItemByID("material", 24)); // Engineering Processor

                ASSEMBLER_RECIPES.recipeBuilder()
                        .circuitMeta(2)
                        .inputs(Mods.CraftingStation.getItemByID("crafting_station")) // Crafting Station
                        .input(plate, ElectricalSteel, 4)
                        .input(plate, Lapis)
                        .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 24))
                        .outputs(Mods.AE2FluidCrafting.getItemByID("fluid_pattern_encoder"))
                        .EUt(VA[LV])
                        .duration(50)
                        .buildAndRegister();

            }

            //  Fluid Packet Decoder
            ModHandler.removeRecipeByOutput(Mods.AE2FluidCrafting.getItemByID("fluid_packet_decoder"));
            ModHandler.addShapedRecipe(true, "fluid_packet_decoder", Mods.AE2FluidCrafting.getItemByID("fluid_packet_decoder"),
                    "PEP", "YFY", "PWP",
                    'F', new UnificationEntry(frameGt, VividAlloy),
                    'P', new UnificationEntry(plate, StainlessSteel),
                    'E', ELECTRIC_PUMP_HV,
                    'Y', Mods.AppliedEnergistics2.getMetaItemByID("material", 24), // Engineering Processor
                    'W', "cableAeGlass");

            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(2)
                    .input(frameGt, VividAlloy)
                    .input(plate, StainlessSteel, 4)
                    .input(ELECTRIC_PUMP_HV)
                    .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 24, 2))
                    .input("cableAeGlass")
                    .outputs(Mods.AE2FluidCrafting.getItemByID("fluid_packet_decoder"))
                    .EUt(VA[LV])
                    .duration(50)
                    .buildAndRegister();

            //  Ingredient Buffer
            ModHandler.removeRecipeByOutput(Mods.AE2FluidCrafting.getItemByID("ingredient_buffer"));
            ModHandler.addShapedRecipe(true, "ingredient_buffer", Mods.AE2FluidCrafting.getItemByID("ingredient_buffer"),
                    "PAP", "XGY", "PBP",
                    'P', new UnificationEntry(plate, ElectricalSteel),
                    'A', Mods.AppliedEnergistics2.getMetaItemByID("material", 35), // 1k Item Storage Component
                    'B', Mods.AppliedEnergistics2.getMetaItemByID("material", 54), // 1k Fluid Storage Component
                    'X', Mods.AppliedEnergistics2.getMetaItemByID("material", 43), // Formation Core
                    'Y', Mods.AppliedEnergistics2.getMetaItemByID("material", 44), // Annihilation Core
                    'G', Mods.AppliedEnergistics2.getItemByID("quartz_glass"));

            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(2)
                    .inputs(Mods.AppliedEnergistics2.getItemByID("quartz_glass"))
                    .input(plate, ElectricalSteel, 4)
                    .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 35)) // 1k Item Storage Component
                    .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 54)) // 1k Fluid Storage Component
                    .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 43)) // Formation Core
                    .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 44)) // Annihilation Core
                    .outputs(Mods.AE2FluidCrafting.getItemByID("ingredient_buffer"))
                    .EUt(VA[LV])
                    .duration(50)
                    .buildAndRegister();

            //  Large Ingredient Buffer
            ModHandler.removeRecipeByOutput(Mods.AE2FluidCrafting.getItemByID("large_ingredient_buffer"));
            ModHandler.addShapedRecipe(true, "large_ingredient_buffer", Mods.AE2FluidCrafting.getItemByID("large_ingredient_buffer"),
                    "PGP", "GBG", "PGP",
                    'P', new UnificationEntry(plate, Fluix),
                    'B', Mods.AE2FluidCrafting.getItemByID("ingredient_buffer"),
                    'G', Mods.AppliedEnergistics2.getItemByID("quartz_vibrant_glass")); // Vibrant Quartz Glass

            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(2)
                    .inputs(Mods.AE2FluidCrafting.getItemByID("ingredient_buffer"))
                    .input(plate, Fluix, 4)
                    .inputs(Mods.AppliedEnergistics2.getItemByID("quartz_vibrant_glass", 4))
                    .outputs(Mods.AE2FluidCrafting.getItemByID("large_ingredient_buffer"))
                    .EUt(VA[LV])
                    .duration(50)
                    .buildAndRegister();

            //  Burette
            ModHandler.removeRecipeByOutput(Mods.AE2FluidCrafting.getItemByID("burette"));
            if (Mods.EnderIO.isModLoaded()) {
                ModHandler.addShapedRecipe(true, "burette", Mods.AE2FluidCrafting.getItemByID("burette"),
                        "PXP", "GCG", "PVP",
                        'P', new UnificationEntry(plate, Lapis),
                        'C', Mods.EnderIO.getItemByID("block_tank"),
                        'G', Mods.AppliedEnergistics2.getItemByID("quartz_vibrant_glass"), // Vibrant Quartz Glass
                        'X', Mods.AppliedEnergistics2.getMetaItemByID("material", 23), // Calculation Processor
                        'V', FLUID_CELL_GLASS_VIAL);

                ASSEMBLER_RECIPES.recipeBuilder()
                        .circuitMeta(2)
                        .inputs(Mods.EnderIO.getItemByID("block_tank"))
                        .input(plate, Lapis, 4)
                        .inputs(Mods.AppliedEnergistics2.getItemByID("quartz_vibrant_glass", 2)) // Vibrant Quartz Glass
                        .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 23)) // Calculation Processor
                        .input(FLUID_CELL_GLASS_VIAL)
                        .outputs(Mods.AE2FluidCrafting.getItemByID("burette"))
                        .EUt(VA[LV])
                        .duration(50)
                        .buildAndRegister();
            } else {
                ModHandler.addShapedRecipe(true, "burette", Mods.AE2FluidCrafting.getItemByID("burette"),
                        "PXP", "GCG", "PVP",
                        'P', new UnificationEntry(plate, Lapis),
                        'C', ALUMINIUM_DRUM.getStackForm(),
                        'G', Mods.AppliedEnergistics2.getItemByID("quartz_vibrant_glass"), // Vibrant Quartz Glass
                        'X', Mods.AppliedEnergistics2.getMetaItemByID("material", 23), // Calculation Processor
                        'V', FLUID_CELL_GLASS_VIAL);

                ASSEMBLER_RECIPES.recipeBuilder()
                        .circuitMeta(2)
                        .inputs(ALUMINIUM_DRUM.getStackForm())
                        .input(plate, Lapis, 4)
                        .inputs(Mods.AppliedEnergistics2.getItemByID("quartz_vibrant_glass", 2)) // Vibrant Quartz Glass
                        .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 23)) // Calculation Processor
                        .input(FLUID_CELL_GLASS_VIAL)
                        .outputs(Mods.AE2FluidCrafting.getItemByID("burette"))
                        .EUt(VA[LV])
                        .duration(50)
                        .buildAndRegister();
            }

            //  Fluid Assembler
            ModHandler.removeRecipeByOutput(Mods.AE2FluidCrafting.getItemByID("fluid_assembler"));
            ModHandler.addShapedRecipe(true, "fluid_assembler", Mods.AE2FluidCrafting.getItemByID("fluid_assembler"),
                    "PDP", "XMY", "PDP",
                    'P', new UnificationEntry(plate, CertusQuartz),
                    'D', FLUID_FILTER,
                    'M', Mods.AppliedEnergistics2.getItemByID("molecular_assembler"),
                    'X', Mods.AppliedEnergistics2.getMetaItemByID("material", 22), // Logic Processor
                    'Y', Mods.AppliedEnergistics2.getMetaItemByID("material", 23)); // Calculation Processor

            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(2)
                    .inputs(Mods.AppliedEnergistics2.getItemByID("molecular_assembler"))
                    .input(plate, CertusQuartz, 4)
                    .input(FLUID_FILTER, 2)
                    .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 22)) // Logic Processor
                    .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 23)) // Calculation Processor
                    .outputs(Mods.AE2FluidCrafting.getItemByID("fluid_assembler"))
                    .EUt(VA[LV])
                    .duration(50)
                    .buildAndRegister();


        }

        // ---------------------------------------------- Lazy AE2 Machines -----------------------------------------------

        if (Mods.LazyAE2.isModLoaded()) {
            //  Fluix Aggregator
            ModHandler.removeRecipeByOutput(Mods.LazyAE2.getMetaItemByID("machine", 0));
            ModHandler.addShapedRecipe(true, "fluix_aggregator", Mods.LazyAE2.getMetaItemByID("machine", 0),
                    "PPP", "XCY", "WIW",
                    'P', new UnificationEntry(plate, RedstoneAlloy),
                    'C', Mods.AppliedEnergistics2.getItemByID("condenser"),
                    'X', Mods.AppliedEnergistics2.getMetaItemByID("material", 22), // Logic Processor
                    'Y', Mods.LazyAE2.getMetaItemByID("material", 6), // Parallel Processor
                    'I', "ingotFluixIron",
                    'W', "cableAeGlass");

            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(2)
                    .inputs(Mods.AppliedEnergistics2.getItemByID("condenser"))
                    .input(plate, RedstoneAlloy, 3)
                    .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 22)) // Logic Processor
                    .inputs(Mods.LazyAE2.getMetaItemByID("material", 6)) // Parallel Processor
                    .input("ingotFluixIron")
                    .input("cableAeGlass", 2)
                    .outputs(Mods.LazyAE2.getMetaItemByID("machine", 0))
                    .EUt(VA[LV])
                    .duration(50)
                    .buildAndRegister();

            //  Pulse Centrifuge
            ModHandler.removeRecipeByOutput(Mods.LazyAE2.getMetaItemByID("machine", 1));
            ModHandler.addShapedRecipe(true, "pulse_centrifuge", Mods.LazyAE2.getMetaItemByID("machine", 1),
                    "PAP", "XFY", "PBP",
                    'F', new UnificationEntry(frameGt, PulsatingIron),
                    'P', new UnificationEntry(plate, DarkSteel),
                    'X', Mods.AppliedEnergistics2.getMetaItemByID("material", 22), // Logic Processor
                    'Y', DEDUCTION_PROCESSOR,
                    'A', Mods.AppliedEnergistics2.getItemByID("molecular_assembler"),
                    'B', Mods.LazyAE2.getMetaItemByID("material", 6)); // Parallel Processor

            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(2)
                    .input(frameGt, PulsatingIron)
                    .input(plate, DarkSteel, 4)
                    .inputs(Mods.AppliedEnergistics2.getItemByID("molecular_assembler"))
                    .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 22)) // Logic Processor
                    .input(DEDUCTION_PROCESSOR)
                    .inputs(Mods.LazyAE2.getMetaItemByID("material", 6)) // Parallel Processor
                    .outputs(Mods.LazyAE2.getMetaItemByID("machine", 1))
                    .EUt(VA[LV])
                    .duration(50)
                    .buildAndRegister();

            //  Etcher
            ModHandler.removeRecipeByOutput(Mods.LazyAE2.getMetaItemByID("machine", 2));
            if (Mods.AE2Stuff.isModLoaded()) {
                ModHandler.addShapedRecipe(true, "etcher", Mods.LazyAE2.getMetaItemByID("machine", 2),
                        "AXB", "GCG", "DYE",
                        'C', Mods.AE2Stuff.getItemByID("inscriber"),
                        'X', FLUIX_LOGIC_PROCESSOR,
                        'Y', Mods.AppliedEnergistics2.getMetaItemByID("material", 43), // Formation Core
                        'A', Mods.AppliedEnergistics2.getMetaItemByID("material", 19), // Inscriber Silicon Press
                        'B', Mods.AppliedEnergistics2.getMetaItemByID("material", 13), // Inscriber Calculation Press
                        'D', Mods.AppliedEnergistics2.getMetaItemByID("material", 15), // Inscriber Logic Press
                        'E', Mods.AppliedEnergistics2.getMetaItemByID("material", 14), // Inscriber Engineering Press
                        'G', Mods.AppliedEnergistics2.getItemByID("quartz_vibrant_glass")); // Vibrant Quartz Glass

                ASSEMBLER_RECIPES.recipeBuilder()
                        .circuitMeta(2)
                        .inputs(Mods.AE2Stuff.getItemByID("inscriber"))
                        .inputs(Mods.AppliedEnergistics2.getItemByID("quartz_vibrant_glass", 2))
                        .input(FLUIX_LOGIC_PROCESSOR)
                        .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 43)) // Formation Core
                        .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 19)) // Inscriber Silicon Press
                        .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 13)) // Inscriber Calculation Press
                        .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 15)) // Inscriber Logic Press
                        .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 14)) // Inscriber Engineering Press
                        .outputs(Mods.LazyAE2.getMetaItemByID("machine", 2))
                        .EUt(VA[LV])
                        .duration(50)
                        .buildAndRegister();

            } else {
                ModHandler.addShapedRecipe(true, "etcher", Mods.LazyAE2.getMetaItemByID("machine", 2),
                        "AXB", "GCG", "DYE",
                        'C', Mods.AppliedEnergistics2.getItemByID("inscriber"),
                        'X', FLUIX_LOGIC_PROCESSOR,
                        'Y', Mods.AppliedEnergistics2.getMetaItemByID("material", 43), // Formation Core
                        'A', Mods.AppliedEnergistics2.getMetaItemByID("material", 19), // Inscriber Silicon Press
                        'B', Mods.AppliedEnergistics2.getMetaItemByID("material", 13), // Inscriber Calculation Press
                        'D', Mods.AppliedEnergistics2.getMetaItemByID("material", 15), // Inscriber Logic Press
                        'E', Mods.AppliedEnergistics2.getMetaItemByID("material", 14), // Inscriber Engineering Press
                        'G', Mods.AppliedEnergistics2.getItemByID("quartz_vibrant_glass")); // Vibrant Quartz Glass

                ASSEMBLER_RECIPES.recipeBuilder()
                        .circuitMeta(2)
                        .inputs(Mods.AppliedEnergistics2.getItemByID("inscriber"))
                        .inputs(Mods.AppliedEnergistics2.getItemByID("quartz_vibrant_glass", 2))
                        .input(FLUIX_LOGIC_PROCESSOR)
                        .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 43)) // Formation Core
                        .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 19)) // Inscriber Silicon Press
                        .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 13)) // Inscriber Calculation Press
                        .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 15)) // Inscriber Logic Press
                        .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 14)) // Inscriber Engineering Press
                        .outputs(Mods.LazyAE2.getMetaItemByID("machine", 2))
                        .EUt(VA[LV])
                        .duration(50)
                        .buildAndRegister();
            }

            //  Large Molecular Assembler casings
            ModHandler.removeRecipeByName(Mods.LazyAE2.getID() + ":" + "ma_frame");
            ModHandler.addShapedRecipe(true, "large_molecular_assembler_frame", Mods.LazyAE2.getItemByID("big_assembler", 16),
                    "IBI", "BCB", "IBI",
                    'C', new ItemStack(Blocks.CRAFTING_TABLE),
                    'B', Mods.AppliedEnergistics2.getItemByID("smooth_sky_stone_block"),
                    'I', "ingotFluixSteel");

            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(2)
                    .inputs(new ItemStack(Blocks.CRAFTING_TABLE))
                    .inputs(Mods.AppliedEnergistics2.getItemByID("smooth_sky_stone_block", 4))
                    .input("ingotFluixSteel", 4)
                    .outputs(Mods.LazyAE2.getItemByID("big_assembler", 16))
                    .EUt(VA[LV])
                    .duration(50)
                    .buildAndRegister();

            //  Allowed used Crafting Station (in same name mod) to make Large Molecular Assembler Frame.
            if (Mods.CraftingStation.isModLoaded()) {
                ModHandler.addShapedRecipe(true, "large_molecular_assembler_frame_crafting_station", Mods.LazyAE2.getItemByID("big_assembler", 16),
                        "IBI", "BCB", "IBI",
                        'C', Mods.CraftingStation.getItemByID("crafting_station"),
                        'B', Mods.AppliedEnergistics2.getItemByID("smooth_sky_stone_block"),
                        'I', "ingotFluixSteel");

                ASSEMBLER_RECIPES.recipeBuilder()
                        .circuitMeta(2)
                        .inputs(Mods.CraftingStation.getItemByID("crafting_station"))
                        .inputs(Mods.AppliedEnergistics2.getItemByID("smooth_sky_stone_block", 4))
                        .input("ingotFluixSteel", 4)
                        .outputs(Mods.LazyAE2.getItemByID("big_assembler", 16))
                        .EUt(VA[LV])
                        .duration(50)
                        .buildAndRegister();
            }

            ModHandler.removeRecipeByOutput(Mods.LazyAE2.getMetaItemByID("big_assembler", 1));
            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(6)
                    .inputs(Mods.LazyAE2.getMetaItemByID("big_assembler", 0))
                    .fluidInputs(DarkSteel.getFluid(L * 2))
                    .outputs(Mods.LazyAE2.getMetaItemByID("big_assembler", 1))
                    .EUt(VA[LV])
                    .duration(50)
                    .buildAndRegister();
        }

        // ---------------------------------------------- AE2Stuff Machines -----------------------------------------------
        if (Mods.AE2Stuff.isModLoaded()) {
            //  Advanced Inscriber
            ModHandler.removeRecipeByName(Mods.AE2Stuff.getID() + ":" + "recipe2");
            ModHandler.addShapedRecipe(true, "advanced_inscriber", Mods.AE2Stuff.getItemByID("inscriber"),
                    "IAI", "MCM", "IXI",
                    'M', CONVEYOR_MODULE_LV,
                    'C', Mods.AppliedEnergistics2.getItemByID("inscriber"),
                    'A', Mods.AppliedEnergistics2.getMetaItemByID("material", 30), // Acceleration Card
                    'X', Mods.AppliedEnergistics2.getMetaItemByID("material", 9), // Fluix Pearl
                    'I', "ingotFluixSteel");

            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(2)
                    .inputs(Mods.AppliedEnergistics2.getItemByID("inscriber"))
                    .input(CONVEYOR_MODULE_LV, 2)
                    .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 30))
                    .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 9))
                    .input("ingotFluixSteel", 4)
                    .outputs(Mods.AE2Stuff.getItemByID("inscriber"))
                    .EUt(VA[LV])
                    .duration(50)
                    .buildAndRegister();

            //  Wireless Connector
            ModHandler.removeRecipeByName(Mods.AE2Stuff.getID() + ":" + "recipe4");
            if (Mods.LazyAE2.isModLoaded()) {
                ModHandler.addShapedRecipe(true, "wireless_connector", Mods.AE2Stuff.getItemByID("wireless"),
                        "CAC", "IXI", "CBC",
                        'A', Mods.AppliedEnergistics2.getMetaItemByID("material", 24), // Engineering Processor
                        'B', Mods.LazyAE2.getMetaItemByID("material", 6), // Parallel Processor
                        'X', Mods.AppliedEnergistics2.getMetaItemByID("material", 41), // Wireless Receiver
                        'I', "ingotFluixSteel",
                        'C', "crystalPureFluix");

                ASSEMBLER_RECIPES.recipeBuilder()
                        .circuitMeta(2)
                        .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 41)) // Wireless Receiver
                        .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 24)) // Engineering Processor
                        .inputs(Mods.LazyAE2.getMetaItemByID("material", 6)) // Parallel Processor
                        .input("crystalFluix", 4)
                        .input("ingotFluidSteel", 2)
                        .outputs(Mods.AE2Stuff.getItemByID("wireless"))
                        .EUt(VA[LV])
                        .duration(50)
                        .buildAndRegister();
            } else {
                ModHandler.addShapedRecipe(true, "wireless_connector", Mods.AE2Stuff.getItemByID("wireless"),
                        "CAC", "IXI", "CBC",
                        'A', Mods.AppliedEnergistics2.getMetaItemByID("material", 24), // Engineering Processor
                        'B', Mods.AppliedEnergistics2.getMetaItemByID("material", 23), // Calculation Processor
                        'X', Mods.AppliedEnergistics2.getMetaItemByID("material", 41), // Wireless Receiver
                        'I', "ingotFluixSteel",
                        'C', "crystalPureFluix");

                ASSEMBLER_RECIPES.recipeBuilder()
                        .circuitMeta(2)
                        .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 41)) // Wireless Receiver
                        .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 24)) // Engineering Processor
                        .inputs(Mods.AppliedEnergistics2.getMetaItemByID("material", 23)) // Calculation Processor
                        .input("crystalFluix", 4)
                        .input("ingotFluidSteel", 2)
                        .outputs(Mods.AE2Stuff.getItemByID("wireless"))
                        .EUt(VA[LV])
                        .duration(50)
                        .buildAndRegister();
            }

        }

    }
}
