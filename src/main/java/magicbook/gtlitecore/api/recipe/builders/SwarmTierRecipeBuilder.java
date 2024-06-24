package magicbook.gtlitecore.api.recipe.builders;

import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.util.EnumValidationResult;
import magicbook.gtlitecore.api.recipe.properties.SwarmTierProperty;
import magicbook.gtlitecore.api.utils.GTLiteLog;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jetbrains.annotations.NotNull;

public class SwarmTierRecipeBuilder extends RecipeBuilder<SwarmTierRecipeBuilder> {

    public SwarmTierRecipeBuilder() {}

    public SwarmTierRecipeBuilder(Recipe recipe,
                                  RecipeMap<SwarmTierRecipeBuilder> recipeMap) {
        super(recipe, recipeMap);
    }

    public SwarmTierRecipeBuilder(RecipeBuilder<SwarmTierRecipeBuilder> recipeBuilder) {
        super(recipeBuilder);
    }

    @Override
    public SwarmTierRecipeBuilder copy() {
        return new SwarmTierRecipeBuilder(this);
    }

    public int getSwarmTier() {
        return this.recipePropertyStorage == null ? 0 : this.recipePropertyStorage.getRecipePropertyValue(SwarmTierProperty.getInstance(), 0);
    }

    @Override
    public boolean applyProperty(@NotNull String key, Object value) {
        if (key.equals(SwarmTierProperty.KEY)) {
            this.tier(((Number) value).intValue());
            return true;
        }
        return super.applyProperty(key, value);
    }

    public SwarmTierRecipeBuilder tier(int tier) {
        if (tier <= 0) {
            GTLiteLog.logger.error("Swarm Tier cannot be less than or equal to 0", new IllegalArgumentException());
            recipeStatus = EnumValidationResult.INVALID;
        }
        this.applyProperty(SwarmTierProperty.getInstance(), tier);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append(SwarmTierProperty.getInstance().getKey(), getSwarmTier())
                .toString();
    }
}
