package magicbook.gtlitecore.api.recipe.builder;

import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.util.EnumValidationResult;
import magicbook.gtlitecore.api.recipe.properties.AssemblyCasingTierProperty;
import magicbook.gtlitecore.api.utils.GTLiteLog;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.annotation.Nonnull;

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
    public boolean applyProperty(@Nonnull String key, Object value) {
        if (key.equals(AssemblyCasingTierProperty.KEY)) {
            this.CasingTier(((Number) value).intValue());
            return true;
        }
        return super.applyProperty(key, value);
    }

    public AssemblyCasingTierRecipeBuilder CasingTier(int Tier) {
        if (Tier <= 0) {
            GTLiteLog.logger.error("Casing Tier cannot be less than or equal to 0", new IllegalArgumentException());
            recipeStatus = EnumValidationResult.INVALID;
        }
        this.applyProperty(AssemblyCasingTierProperty.getInstance(), Tier);
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
