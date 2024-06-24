package magicbook.gtlitecore.api.recipe.machines;

import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.common.items.MetaItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Pseudo Group Recipe Map
 *
 * @author Gate Guardian
 */
public class RecipeMapPseudoGroup<R extends RecipeBuilder<R>> extends RecipeMap<R> {

    private final RecipeMap<R> recipeMap1;
    private final RecipeMap<R> recipeMap2;
    private final RecipeMap<R> recipeMap3;

    public RecipeMapPseudoGroup(@NotNull String unlocalizedName,
                                int maxInputs,
                                int maxOutputs,
                                int maxFluidInputs,
                                int maxFluidOutputs,
                                @NotNull R defaultRecipeBuilder,
                                RecipeMap<R> recipeMap1,
                                RecipeMap<R> recipeMap2,
                                RecipeMap<R> recipeMap3,
                                boolean isHidden) {
        super(unlocalizedName, maxInputs, maxOutputs, maxFluidInputs, maxFluidOutputs, defaultRecipeBuilder, isHidden);
        this.recipeMap1 = recipeMap1;
        this.recipeMap2 = recipeMap2;
        this.recipeMap3 = recipeMap3;
    }

    @Override
    @Nullable
    public Recipe findRecipe(long voltage,
                             List<ItemStack> inputs,
                             List<FluidStack> fluidInputs,
                             boolean exactVoltage) {
        final List<ItemStack> items = inputs.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        final List<FluidStack> fluids = fluidInputs.stream().filter(f -> f != null && f.amount != 0).collect(Collectors.toList());

        return switch (checkCircuit(inputs)) {
            case 20 -> getRecipe(voltage, inputs, fluidInputs, exactVoltage, items, fluids, recipeMap1);
            case 21 -> getRecipe(voltage, inputs, fluidInputs, exactVoltage, items, fluids, recipeMap2);
            case 22 -> getRecipe(voltage, inputs, fluidInputs, exactVoltage, items, fluids, recipeMap3);
            default -> null;
        };
    }

    private Recipe getRecipe(long voltage,
                             List<ItemStack> inputs,
                             List<FluidStack> fluidInputs,
                             boolean exactVoltage,
                             List<ItemStack> items,
                             List<FluidStack> fluids,
                             @NotNull RecipeMap<R> recipeMap) {
        return recipeMap.find(items, fluids, recipe -> {
           if (exactVoltage && recipe.getEUt() != voltage) {
               return false; // if exact voltage is required, the recipe is not considered valid
           }

           if (recipe.getEUt() > voltage) {
               return false; // there is not enough voltage to consider the recipe valid
           }
           return recipe.matches(false, inputs, fluidInputs);
        });
    }

    private int checkCircuit(@NotNull List<ItemStack> inputs) {
        for (ItemStack stack : inputs) {
            if (MetaItems.INTEGRATED_CIRCUIT.isItemEqual(stack)) {
                // only circuits with correct configuration will be considered
                int num = IntCircuitIngredient.getCircuitConfiguration(stack);
                if (num >= 20 && num <= 22)
                    return num;
            }
        }
        return 0;
    }
}
