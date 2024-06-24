package magicbook.gtlitecore.api.recipe.builders;

import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.util.EnumValidationResult;
import magicbook.gtlitecore.api.recipe.properties.AssemblyCasingTierProperty;
import magicbook.gtlitecore.api.utils.GTLiteLog;
import magicbook.gtlitecore.common.metatileentities.multi.electric.adv.MetaTileEntityPreciseAssembler;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jetbrains.annotations.NotNull;

/**
 * Precise Assembly Casing Recipe Builder
 *
 * @author Magic_Sweepy
 *
 * <p>
 *     This class creates a recipe builder for Precise Assembler Casing Tier system,
 *     please see: {@link MetaTileEntityPreciseAssembler}.
 *     You should use {@link MultiblockRecipeLogic#checkRecipe(Recipe)} to implement correspondent function about this recipe.
 *     About related recipe property, please see: {@link AssemblyCasingTierProperty}.
 * </p>
 */
public class AssemblyCasingTierRecipeBuilder extends RecipeBuilder<AssemblyCasingTierRecipeBuilder> {

    public AssemblyCasingTierRecipeBuilder() {}

    public AssemblyCasingTierRecipeBuilder(Recipe recipe,
                                           RecipeMap<AssemblyCasingTierRecipeBuilder> recipeMap) {
        super(recipe, recipeMap);
    }

    public AssemblyCasingTierRecipeBuilder(RecipeBuilder<AssemblyCasingTierRecipeBuilder> recipeBuilder) {
        super(recipeBuilder);
    }

    @Override
    public AssemblyCasingTierRecipeBuilder copy() {
        return new AssemblyCasingTierRecipeBuilder(this);
    }

    public int getAssemblyCasingTier() {
        return this.recipePropertyStorage == null ? 0 : this.recipePropertyStorage.getRecipePropertyValue(AssemblyCasingTierProperty.getInstance(), 0);
    }

    @Override
    public boolean applyProperty(@NotNull String key, Object value) {
        if (key.equals(AssemblyCasingTierProperty.KEY)) {
            this.tier(((Number) value).intValue());
            return true;
        }
        return super.applyProperty(key, value);
    }

    public AssemblyCasingTierRecipeBuilder tier(int casingTier) {
        if (casingTier <= 0) {
            GTLiteLog.logger.error("Casing Tier cannot be less than or equal to 0", new IllegalArgumentException());
            recipeStatus = EnumValidationResult.INVALID;
        }
        this.applyProperty(AssemblyCasingTierProperty.getInstance(), casingTier);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append(AssemblyCasingTierProperty.getInstance().getKey(), getAssemblyCasingTier())
                .toString();
    }
}
