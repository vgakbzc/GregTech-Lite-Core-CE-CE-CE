package magicbook.gtlitecore.integration.gregtech.overrides;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.BlockBatteryPart;
import gregtech.common.blocks.BlockMachineCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.loaders.recipe.CraftingComponent;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.unification.material.Materials.Duranium;
import static gregtech.api.unification.material.Materials.Europium;
import static gregtech.api.unification.material.Materials.Neutronium;
import static gregtech.api.unification.material.Materials.Polybenzimidazole;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.blocks.BlockHermeticCasing.HermeticCasingsType.HERMETIC_UHV;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

/**
 * Override of Machine Casings.
 *
 * @author Magic_Sweepy
 *
 * <p>
 *     This class is an override about machine casings like tiered hull,
 *     also override quantum chest/tank recipes, because in GregTech vanilla environment,
 *     UHV main material ({@link CraftingComponent#HULL}) is {@link Materials#Neutronium},
 *     but in gtlitecore, UHV main material is {@link magicbook.gtlitecore.api.unification.GTLiteMaterials#Orichalcum}.
 * </p>
 *
 * @since 2.8.7-beta
 */
public class MachineCasings {

    public static void init() {
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

        //  UHV Machine Hull assembler recipe
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

        //  OpV Hull
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.OpV))
                .input(cableGtSingle, Galaxium, 2)
                .fluidInputs(Zylon.getFluid(L * 2))
                .output(MetaTileEntities.HULL[OpV])
                .EUt(16)
                .duration(50)
                .buildAndRegister();

        //  MAX Casing
        ModHandler.addShapedRecipe(true, "casing_max", MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.MAX),
                "PPP", "PwP", "PPP",
                'P', new UnificationEntry(plate, Eternity));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Eternity, 8)
                .circuitMeta(8)
                .outputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.MAX))
                .duration(50)
                .EUt(16)
                .buildAndRegister();

        //  MAX Hull
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.MAX))
                .input(cableGtSingle, Universium, 2)
                .fluidInputs(Zylon.getFluid(L * 2))
                .output(MetaTileEntities.HULL[MAX])
                .EUt(16)
                .duration(50)
                .buildAndRegister();

        //  Empty Capacitor III (for Power Substation)
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                OreDictUnifier.get(frameGt, Neutronium),
                OreDictUnifier.get(plate, Neutronium, 6),
                OreDictUnifier.get(screw, Neutronium, 24));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Orichalcum)
                .input(plate, Orichalcum, 6)
                .input(screw, Orichalcum, 24)
                .outputs(MetaBlocks.BATTERY_BLOCK.getItemVariant(BlockBatteryPart.BatteryPartType.EMPTY_TIER_III))
                .EUt(VA[ZPM])
                .duration(400)
                .buildAndRegister();
    }
}
