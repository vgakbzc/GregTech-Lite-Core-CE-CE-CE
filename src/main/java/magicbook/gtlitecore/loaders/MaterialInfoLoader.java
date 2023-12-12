package magicbook.gtlitecore.loaders;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.stack.ItemMaterialInfo;
import gregtech.api.unification.stack.MaterialStack;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.BlockMachineCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;
import magicbook.gtlitecore.common.blocks.BlockTransparentCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.blocks.BlockHermeticCasing.HermeticCasingsType.HERMETIC_UHV;
import static gregtech.common.metatileentities.MetaTileEntities.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.VOLTAGE_COIL_UEV;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.VOLTAGE_COIL_UHV;

public class MaterialInfoLoader {

    public static void init() {
        MachineCasings();
        Glasses();
        VoltageCoils();
    }

    private static void MachineCasings() {

        //  UHV Machine Casing
        ModHandler.removeRecipeByName("gregtech:casing_uhv");
        ModHandler.addShapedRecipe(true, "casing_uhv", MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UHV),
                "PPP", "PwP", "PPP",
                'P', new UnificationEntry(plate, Orichalcum));

        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, IntCircuitIngredient.getIntegratedCircuit(8), OreDictUnifier.get(plate, Neutronium, 8));
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Orichalcum, 8)
                .circuitMeta(8)
                .outputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UHV))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        OreDictUnifier.registerOre(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UHV),
                new ItemMaterialInfo(new MaterialStack(Orichalcum, M * 8)));

        //  UHV Machine Hull
        OreDictUnifier.registerOre(HULL[UHV].getStackForm(), new ItemMaterialInfo(
                new MaterialStack(Orichalcum, M * 8),
                new MaterialStack(Europium, M),
                new MaterialStack(Polyetheretherketone, M * 2)
        ));

        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                new ItemStack[]{OreDictUnifier.get(cableGtSingle, Europium, 2), MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UHV)},
                new FluidStack[]{Polybenzimidazole.getFluid(288)});

        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UHV))
                .input(cableGtSingle, Europium, 2)
                .fluidInputs(Polyetheretherketone.getFluid(L * 2))
                .output(MetaTileEntities.HULL[9])
                .EUt(16)
                .duration(50)
                .buildAndRegister();

        //  UHV Hermetic Casing
        ModHandler.removeRecipeByName("gregtech:hermetic_casing_max");
        ModHandler.addShapedRecipe(true, "hermetic_casing_uhv", MetaBlocks.HERMETIC_CASING.getItemVariant(HERMETIC_UHV),
                "PPP", "PFP", "PPP",
                'P', new UnificationEntry(plate, Orichalcum),
                'F', new UnificationEntry(pipeLargeFluid, Duranium));

        //  UHV Quantum Chest
        ModHandler.removeRecipeByName("gregtech:quantum_chest_uhv");
        ModHandler.addShapedRecipe(true, "quantum_chest_uhv", MetaTileEntities.QUANTUM_CHEST[9].getStackForm(),
                "CPC", "PHP", "CFC",
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.UHV),
                'P', new UnificationEntry(plate, Orichalcum),
                'F', MetaItems.FIELD_GENERATOR_UV.getStackForm(),
                'H', MetaTileEntities.HULL[UHV].getStackForm());

        //  UHV Quantum Tank
        ModHandler.removeRecipeByName("gregtech:quantum_tank_uhv");
        ModHandler.addShapedRecipe(true, "quantum_tank_uhv", MetaTileEntities.QUANTUM_TANK[9].getStackForm(),
                "CGC", "PHP", "CUC",
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.UHV),
                'P', new UnificationEntry(plate, Orichalcum),
                'U', MetaItems.ELECTRIC_PUMP_UV.getStackForm(),
                'G', MetaItems.FIELD_GENERATOR_UV.getStackForm(),
                'H', MetaBlocks.HERMETIC_CASING.getItemVariant(HERMETIC_UHV));

        //  UEV Casing
        ModHandler.addShapedRecipe(true, "casing_uev", MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UEV),
                "PPP", "PwP", "PPP",
                'P', new UnificationEntry(plate, Adamantium));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Adamantium, 8)
                .circuitMeta(8)
                .outputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UEV))
                .duration(50)
                .EUt(16)
                .buildAndRegister();

        //  UEV Hull
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UEV))
                .input(cableGtSingle, PedotTMA, 2)
                .fluidInputs(Polyetheretherketone.getFluid(L * 2))
                .output(MetaTileEntities.HULL[UEV])
                .EUt(16)
                .duration(50)
                .buildAndRegister();

        //  UIV Casing
        ModHandler.addShapedRecipe(true, "casing_uiv", MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UIV),
                "PPP", "PwP", "PPP",
                'P', new UnificationEntry(plate, Infinity));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Infinity, 8)
                .circuitMeta(8)
                .outputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UIV))
                .duration(50)
                .EUt(16)
                .buildAndRegister();

        //  UIV Hull
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UIV))
                .input(cableGtSingle, Solarium, 2)
                .fluidInputs(Polyetheretherketone.getFluid(L * 2))
                .output(MetaTileEntities.HULL[UIV])
                .EUt(16)
                .duration(50)
                .buildAndRegister();

        //  UXV Casing
        ModHandler.addShapedRecipe(true, "casing_uxv", MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UXV),
                "PPP", "PwP", "PPP",
                'P', new UnificationEntry(plate, CosmicNeutronium));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, CosmicNeutronium, 8)
                .circuitMeta(8)
                .outputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UXV))
                .duration(50)
                .EUt(16)
                .buildAndRegister();

        //  UXV Hull
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UXV))
                .input(cableGtSingle, Hypogen, 2)
                .fluidInputs(Zylon.getFluid(L * 2))
                .output(MetaTileEntities.HULL[UXV])
                .EUt(16)
                .duration(50)
                .buildAndRegister();

        //  OpV Casing
        ModHandler.addShapedRecipe(true, "casing_opv", MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.OpV),
                "PPP", "PwP", "PPP",
                'P', new UnificationEntry(plate, Spacetime));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Spacetime, 8)
                .circuitMeta(8)
                .outputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.OpV))
                .duration(50)
                .EUt(16)
                .buildAndRegister();
    }

    private static void Glasses() {

        //  BPA Polycarbonate Glass
        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .input(plate, BPAPolycarbonate, 4)
                .notConsumable(MetaItems.SHAPE_MOLD_BLOCK)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .outputs(GTLiteMetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockTransparentCasing.TransparentCasingType.BPA_POLYCARBONATE_GLASS))
                .EUt(VA[EV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        OreDictUnifier.registerOre(GTLiteMetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockTransparentCasing.TransparentCasingType.BPA_POLYCARBONATE_GLASS),
                new ItemMaterialInfo(new MaterialStack(BPAPolycarbonate, M * 4)));

        //  PMMA Glass
        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .input(plate, PMMA, 4)
                .notConsumable(MetaItems.SHAPE_MOLD_BLOCK)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .outputs(GTLiteMetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockTransparentCasing.TransparentCasingType.PMMA_GLASS))
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        OreDictUnifier.registerOre(GTLiteMetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockTransparentCasing.TransparentCasingType.PMMA_GLASS),
                new ItemMaterialInfo(new MaterialStack(PMMA, M * 4)));

        //  CBDO Glass
        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .input(plate, CBDOPolycarbonate, 4)
                .notConsumable(MetaItems.SHAPE_MOLD_BLOCK)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .outputs(GTLiteMetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockTransparentCasing.TransparentCasingType.CBDO_POLYCARBONATE_GLASS))
                .EUt(VA[LuV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        OreDictUnifier.registerOre(GTLiteMetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockTransparentCasing.TransparentCasingType.CBDO_POLYCARBONATE_GLASS),
                new ItemMaterialInfo(new MaterialStack(CBDOPolycarbonate, M * 4)));

        //  Infinity Glass
        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .input(plate, Infinity, 4)
                .notConsumable(MetaItems.SHAPE_MOLD_BLOCK)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .outputs(GTLiteMetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockTransparentCasing.TransparentCasingType.INFINITY_GLASS))
                .EUt(VA[ZPM])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        OreDictUnifier.registerOre(GTLiteMetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockTransparentCasing.TransparentCasingType.INFINITY_GLASS),
                new ItemMaterialInfo(new MaterialStack(Infinity, M * 4)));
    }

    private static void VoltageCoils() {
        //  UHV Voltage Coil
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(stick, ChromiumGermaniumTellurideMagnetic)
                .input(wireFine, Vibranium, 16)
                .circuitMeta(1)
                .output(VOLTAGE_COIL_UHV)
                .EUt(VA[UHV])
                .duration(200)
                .buildAndRegister();

        OreDictUnifier.registerOre(VOLTAGE_COIL_UHV.getStackForm(), new ItemMaterialInfo (
                new MaterialStack(ChromiumGermaniumTellurideMagnetic, M / 2),
                new MaterialStack(Vibranium, M * 2)));

        //  UEV Voltage Coil
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(stick, ChromiumGermaniumTellurideMagnetic)
                .input(wireFine, Mithril, 16)
                .circuitMeta(1)
                .output(VOLTAGE_COIL_UEV)
                .EUt(VA[UEV])
                .duration(200)
                .buildAndRegister();

        OreDictUnifier.registerOre(VOLTAGE_COIL_UEV.getStackForm(), new ItemMaterialInfo (
                new MaterialStack(ChromiumGermaniumTellurideMagnetic, M / 2),
                new MaterialStack(Mithril, M * 2)));

        //  UIV Voltage Coil
    }
}
