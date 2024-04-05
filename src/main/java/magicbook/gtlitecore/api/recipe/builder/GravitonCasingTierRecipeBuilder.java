package magicbook.gtlitecore.api.recipe.builder;

import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.util.EnumValidationResult;
import magicbook.gtlitecore.api.recipe.properties.GravitonCasingTierProperty;
import magicbook.gtlitecore.api.utils.GTLiteLog;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.annotation.Nonnull;

/**
 * @author Magic_Sweepy
 */
public class GravitonCasingTierRecipeBuilder extends RecipeBuilder<GravitonCasingTierRecipeBuilder> {

    public GravitonCasingTierRecipeBuilder() {}

    public GravitonCasingTierRecipeBuilder(Recipe recipe,
                                           RecipeMap<GravitonCasingTierRecipeBuilder> recipeMap) {
        super(recipe, recipeMap);
    }

    public GravitonCasingTierRecipeBuilder(RecipeBuilder<GravitonCasingTierRecipeBuilder> recipeBuilder) {
        super(recipeBuilder);
    }

    @Override
    public GravitonCasingTierRecipeBuilder copy() {
        return new GravitonCasingTierRecipeBuilder(this);
    }

    public int getGravitonTier() {
        return this.recipePropertyStorage == null ? 0 : this.recipePropertyStorage.getRecipePropertyValue(GravitonCasingTierProperty.getInstance(), 0);
    }

    @Override
    public boolean applyProperty(@Nonnull String key, Object value) {
        if (key.equals(GravitonCasingTierProperty.KEY)) {
            this.CasingTier(((Number) value).intValue());
            return true;
        }
        return super.applyProperty(key, value);
    }

    public GravitonCasingTierRecipeBuilder CasingTier(int Tier) {
        if (Tier <= 0) {
            GTLiteLog.logger.error("Casing Tier cannot be less than or equal to 0", new IllegalArgumentException());
            recipeStatus = EnumValidationResult.INVALID;
        }

        this.applyProperty(GravitonCasingTierProperty.getInstance(), Tier);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append(GravitonCasingTierProperty.getInstance().getKey(), getGravitonTier())
                .toString();
    }
}
