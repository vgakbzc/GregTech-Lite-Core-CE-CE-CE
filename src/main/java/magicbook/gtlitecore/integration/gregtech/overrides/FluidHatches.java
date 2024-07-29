package magicbook.gtlitecore.integration.gregtech.overrides;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import magicbook.gtlitecore.common.GTLiteConfigHolder;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.unification.material.Materials.Polybenzimidazole;
import static gregtech.common.metatileentities.MetaTileEntities.*;
import static magicbook.gtlitecore.api.utils.GTRecipeHelper.createIOPartConv;
import static magicbook.gtlitecore.api.utils.GTRecipeHelper.createIOPartRecipe;
import static magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities.EXPORT_FLUID_HATCH;
import static magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities.IMPORT_FLUID_HATCH;

/**
 * Override of Fluid Hatches
 *
 * @author Magic_Sweepy
 *
 * @since 2.8.7-beta
 */
public class FluidHatches {

    public static void init() {

        //  Delete vanilla UHV Fluid I/O Hatch recipes.
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                new ItemStack[]{HULL[UHV].getStackForm(), QUANTUM_TANK[1].getStackForm(), IntCircuitIngredient.getIntegratedCircuit(1)},
                new FluidStack[]{Polybenzimidazole.getFluid(720)});

        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                new ItemStack[]{HULL[UHV].getStackForm(), QUANTUM_TANK[1].getStackForm(), IntCircuitIngredient.getIntegratedCircuit(2)},
                new FluidStack[]{Polybenzimidazole.getFluid(720)});

        //  Completed extra recipes for vanilla GregTech Fluid I/O Hatches.
        createIOPartRecipe(ULV, FLUID_IMPORT_HATCH[ULV], FLUID_EXPORT_HATCH[ULV], new ItemStack(Blocks.GLASS));
        createIOPartRecipe(LV,  FLUID_IMPORT_HATCH[LV],  FLUID_EXPORT_HATCH[LV],  new ItemStack(Blocks.GLASS));
        createIOPartRecipe(MV,  FLUID_IMPORT_HATCH[MV],  FLUID_EXPORT_HATCH[MV],  BRONZE_DRUM.getStackForm());
        createIOPartRecipe(HV,  FLUID_IMPORT_HATCH[HV],  FLUID_EXPORT_HATCH[HV],  STEEL_DRUM.getStackForm());
        createIOPartRecipe(EV,  FLUID_IMPORT_HATCH[EV],  FLUID_EXPORT_HATCH[EV],  ALUMINIUM_DRUM.getStackForm());
        createIOPartRecipe(IV,  FLUID_IMPORT_HATCH[IV],  FLUID_EXPORT_HATCH[IV],  STAINLESS_STEEL_DRUM.getStackForm());
        createIOPartRecipe(LuV, FLUID_IMPORT_HATCH[LuV], FLUID_EXPORT_HATCH[LuV], TITANIUM_DRUM.getStackForm());
        createIOPartRecipe(ZPM, FLUID_IMPORT_HATCH[ZPM], FLUID_EXPORT_HATCH[ZPM], TUNGSTENSTEEL_DRUM.getStackForm());
        createIOPartRecipe(UV,  FLUID_IMPORT_HATCH[UV],  FLUID_EXPORT_HATCH[UV],  QUANTUM_TANK[0].getStackForm());
        createIOPartRecipe(UHV, FLUID_IMPORT_HATCH[UHV], FLUID_EXPORT_HATCH[UHV], QUANTUM_TANK[1].getStackForm());

        //  If player used High Tier Fluid I/O Hatches, then add recipes for them.
        if (GTLiteConfigHolder.machines.enableHighTierFluidHatches) {
            createIOPartRecipe(UEV, IMPORT_FLUID_HATCH[0], EXPORT_FLUID_HATCH[0], QUANTUM_TANK[2].getStackForm());
            createIOPartRecipe(UIV, IMPORT_FLUID_HATCH[1], EXPORT_FLUID_HATCH[1], QUANTUM_TANK[3].getStackForm());
            createIOPartRecipe(UXV, IMPORT_FLUID_HATCH[2], EXPORT_FLUID_HATCH[2], QUANTUM_TANK[4].getStackForm());
            createIOPartRecipe(OpV, IMPORT_FLUID_HATCH[3], EXPORT_FLUID_HATCH[3], QUANTUM_TANK[5].getStackForm());

            //  Add I to O and O to I convension of UEV-OpV Fluid I/O Hatches.
            createIOPartConv(UEV, IMPORT_FLUID_HATCH[0], EXPORT_FLUID_HATCH[0], true);
            createIOPartConv(UIV, IMPORT_FLUID_HATCH[1], EXPORT_FLUID_HATCH[1], true);
            createIOPartConv(UXV, IMPORT_FLUID_HATCH[2], EXPORT_FLUID_HATCH[2], true);
            createIOPartConv(OpV, IMPORT_FLUID_HATCH[3], EXPORT_FLUID_HATCH[3], true);
        }

    }
}
