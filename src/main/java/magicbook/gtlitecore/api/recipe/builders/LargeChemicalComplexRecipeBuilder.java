package magicbook.gtlitecore.api.recipe.builders;

import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.util.EnumValidationResult;
import magicbook.gtlitecore.api.recipe.properties.LargeChemicalComplexProperty;
import magicbook.gtlitecore.api.utils.GTLiteLog;
import org.apache.commons.lang3.builder.ToStringBuilder;

import org.jetbrains.annotations.NotNull;

public class LargeChemicalComplexRecipeBuilder extends RecipeBuilder<LargeChemicalComplexRecipeBuilder> {

    public LargeChemicalComplexRecipeBuilder() {}

    public LargeChemicalComplexRecipeBuilder(Recipe recipe,
                                             RecipeMap<LargeChemicalComplexRecipeBuilder> recipeMap) {
        super(recipe, recipeMap);
    }

    public LargeChemicalComplexRecipeBuilder(LargeChemicalComplexRecipeBuilder recipeBuilder) {
        super(recipeBuilder);
    }

    @Override
    public LargeChemicalComplexRecipeBuilder copy() {
        return new LargeChemicalComplexRecipeBuilder(this);
    }

    @Override
    public boolean applyProperty(@NotNull String key, Object value) {
        if (key.equals(LargeChemicalComplexProperty.KEY)) { // todo change key to properties key
            tier(((Number) value).intValue());
            return true;
        }

        // todo other upgrades
        return super.applyProperty(key, value);
    }

    public LargeChemicalComplexRecipeBuilder tier(int tier) {
        if (tier < 0) {
            GTLiteLog.logger.error("Large Chemical Complex Tier cannot be less than 0", new IllegalArgumentException());
            this.recipeStatus = EnumValidationResult.INVALID;
        }
        applyProperty(LargeChemicalComplexProperty.getInstance(), tier);
        return this;
    }

    //  todo other properties

    public int getLargeChemicalComplexTier() {
        return this.recipePropertyStorage == null ? 0 : this.recipePropertyStorage
                .getRecipePropertyValue(LargeChemicalComplexProperty.getInstance(), 0);
    }

    //  todo other properties tier getter

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append(LargeChemicalComplexProperty.getInstance().getKey(), getLargeChemicalComplexTier())
                .toString();
    }
}
