package magicbook.gtlitecore.integration.gregtech.overrides;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.common.blocks.BlockFusionCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.foil;
import static gregtech.api.unification.ore.OrePrefix.wireGtDouble;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class SuperconductorCoil {

    public static void init() {

        //  Delete original UHV recipe, because RTAN is UIV stage wire in {@code gtlitecore},
        //  but in vanilla GregTech, this wire is UHV Superconductor.
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                new ItemStack[]{ OreDictUnifier.get(wireGtDouble, RutheniumTriniumAmericiumNeutronate, 4), OreDictUnifier.get(foil, NiobiumTitanium, 4) },
                new FluidStack[]{ Trinium.getFluid(L * 4) });

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireGtDouble, PedotPSS, 4)
                .input(foil, NiobiumTitanium, 4)
                .fluidInputs(Trinium.getFluid(L * 4))
                .outputs(MetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.CasingType.SUPERCONDUCTOR_COIL))
                .EUt(VA[UHV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  Add recipe use UEV Superconductor (Quantum Alloy)
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireGtDouble, QuantumAlloy, 2)
                .input(foil, NiobiumTitanium, 2)
                .fluidInputs(Trinium.getFluid(L * 4))
                .outputs(MetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.CasingType.SUPERCONDUCTOR_COIL))
                .EUt(VA[UEV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  Add recipe use UIV Superconductor (Fullerene Superconductor)
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireGtDouble, FullereneSuperconductor, 2)
                .input(foil, NiobiumTitanium, 2)
                .fluidInputs(Trinium.getFluid(L * 4))
                .outputs(MetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.CasingType.SUPERCONDUCTOR_COIL, 2))
                .EUt(VA[UIV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  UXV Superconductor (Boron Francium Carbide Superconductor)
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireGtDouble, BoronFranciumCarbideSuperconductor, 2)
                .input(foil, NiobiumTitanium, 2)
                .fluidInputs(Trinium.getFluid(L * 4))
                .outputs(MetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.CasingType.SUPERCONDUCTOR_COIL, 4))
                .EUt(VA[UXV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  OpV Superconductor (Neutronium Superconductor)
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireGtDouble, NeutroniumSuperconductor, 2)
                .input(foil, NiobiumTitanium, 2)
                .fluidInputs(Trinium.getFluid(L * 4))
                .outputs(MetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.CasingType.SUPERCONDUCTOR_COIL, 8))
                .EUt(VA[OpV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  MAX Superconductor (Cosmic Matter Superconductor)
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireGtDouble, CosmicMatterSuperconductor, 2)
                .input(foil, NiobiumTitanium, 2)
                .fluidInputs(Trinium.getFluid(L * 4))
                .outputs(MetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.CasingType.SUPERCONDUCTOR_COIL, 16))
                .EUt(VA[MAX])
                .duration(5 * SECOND)
                .buildAndRegister();
    }
}
