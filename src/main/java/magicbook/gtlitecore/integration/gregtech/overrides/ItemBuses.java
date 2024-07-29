package magicbook.gtlitecore.integration.gregtech.overrides;

import gregtech.api.items.OreDictNames;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import magicbook.gtlitecore.common.GTLiteConfigHolder;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.unification.material.Materials.Polybenzimidazole;
import static gregtech.common.metatileentities.MetaTileEntities.*;
import static magicbook.gtlitecore.api.utils.GTRecipeHelper.createIOPartConv;
import static magicbook.gtlitecore.api.utils.GTRecipeHelper.createIOPartRecipe;
import static magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities.EXPORT_ITEM_HATCH;
import static magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities.IMPORT_ITEM_HATCH;

/**
 * Override of Item Buses.
 *
 * @author Magic_Sweepy
 *
 * @since 2.8.7-beta
 */
public class ItemBuses {

    public static void init() {

        //  Delete vanilla UHV Item I/O Bus recipes.
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                new ItemStack[]{HULL[UHV].getStackForm(), QUANTUM_CHEST[1].getStackForm(), IntCircuitIngredient.getIntegratedCircuit(1)},
                new FluidStack[]{Polybenzimidazole.getFluid(720)});

        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                new ItemStack[]{HULL[UHV].getStackForm(), QUANTUM_CHEST[1].getStackForm(), IntCircuitIngredient.getIntegratedCircuit(2)},
                new FluidStack[]{Polybenzimidazole.getFluid(720)});

        //  Completed extra recipes for vanilla GregTech Item I/O Buses.
        createIOPartRecipe(ULV, ITEM_IMPORT_BUS[ULV], ITEM_EXPORT_BUS[ULV], OreDictNames.chestWood.toString());
        createIOPartRecipe(LV,  ITEM_IMPORT_BUS[LV],  ITEM_EXPORT_BUS[LV],  OreDictNames.chestWood.toString());
        createIOPartRecipe(MV,  ITEM_IMPORT_BUS[MV],  ITEM_EXPORT_BUS[MV],  BRONZE_CRATE.getStackForm());
        createIOPartRecipe(HV,  ITEM_IMPORT_BUS[HV],  ITEM_EXPORT_BUS[HV],  STEEL_CRATE.getStackForm());
        createIOPartRecipe(EV,  ITEM_IMPORT_BUS[EV],  ITEM_EXPORT_BUS[EV],  ALUMINIUM_CRATE.getStackForm());
        createIOPartRecipe(IV,  ITEM_IMPORT_BUS[IV],  ITEM_EXPORT_BUS[IV],  STAINLESS_STEEL_CRATE.getStackForm());
        createIOPartRecipe(LuV, ITEM_IMPORT_BUS[LuV], ITEM_EXPORT_BUS[LuV], TITANIUM_CRATE.getStackForm());
        createIOPartRecipe(ZPM, ITEM_IMPORT_BUS[ZPM], ITEM_EXPORT_BUS[ZPM], TUNGSTENSTEEL_CRATE.getStackForm());
        createIOPartRecipe(UV,  ITEM_IMPORT_BUS[UV],  ITEM_EXPORT_BUS[UV],  QUANTUM_CHEST[0].getStackForm());
        createIOPartRecipe(UHV, ITEM_IMPORT_BUS[UHV], ITEM_EXPORT_BUS[UHV], QUANTUM_CHEST[1].getStackForm());

        //  If player used High Tier Item I/O Buses, then add recipes for them.
        if (GTLiteConfigHolder.machines.enableHighTierItemBuses) {
            createIOPartRecipe(UEV, IMPORT_ITEM_HATCH[0], EXPORT_ITEM_HATCH[0], QUANTUM_CHEST[2].getStackForm());
            createIOPartRecipe(UIV, IMPORT_ITEM_HATCH[1], EXPORT_ITEM_HATCH[1], QUANTUM_CHEST[3].getStackForm());
            createIOPartRecipe(UXV, IMPORT_ITEM_HATCH[2], EXPORT_ITEM_HATCH[2], QUANTUM_CHEST[4].getStackForm());
            createIOPartRecipe(OpV, IMPORT_ITEM_HATCH[3], EXPORT_ITEM_HATCH[3], QUANTUM_CHEST[5].getStackForm());

            //  Add I to O and O to I convension of UEV-OpV Item I/O Buses.
            createIOPartConv(UEV, IMPORT_ITEM_HATCH[0], EXPORT_ITEM_HATCH[0], false);
            createIOPartConv(UIV, IMPORT_ITEM_HATCH[1], EXPORT_ITEM_HATCH[1], false);
            createIOPartConv(UXV, IMPORT_ITEM_HATCH[2], EXPORT_ITEM_HATCH[2], false);
            createIOPartConv(OpV, IMPORT_ITEM_HATCH[3], EXPORT_ITEM_HATCH[3], false);
        }

    }
}
