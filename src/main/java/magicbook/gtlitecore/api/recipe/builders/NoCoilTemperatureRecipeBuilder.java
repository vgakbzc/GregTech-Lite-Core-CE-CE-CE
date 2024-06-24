package magicbook.gtlitecore.api.recipe.builders;

import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.recipeproperties.RecipePropertyStorage;
import gregtech.api.util.EnumValidationResult;
import gregtech.api.util.TextFormattingUtil;
import gregtech.api.util.ValidationResult;
import magicbook.gtlitecore.api.recipe.properties.NoCoilTemperatureProperty;
import magicbook.gtlitecore.api.utils.GTLiteLog;
import magicbook.gtlitecore.common.metatileentities.multi.electric.MetaTileEntityNanoscaleFabricator;
import org.apache.commons.lang3.builder.ToStringBuilder;

import org.jetbrains.annotations.NotNull;

/**
 * No Coil Temperature Recipe Builder
 *
 * <p>
 *     Used for some multiblock machine which does not has wire coil,
 *     but require a temperature info view (maybe has a new predicate in same time).
 *     Like {@link MetaTileEntityNanoscaleFabricator},
 *     this multiblock has a new predicate, but has no coil and require a temperature info,
 *     so used this recipe builder to support auxiliary temperature.
 * </p>
 */
public class NoCoilTemperatureRecipeBuilder extends RecipeBuilder<NoCoilTemperatureRecipeBuilder> {

    public NoCoilTemperatureRecipeBuilder() {}

    public NoCoilTemperatureRecipeBuilder(Recipe recipe,
                                          RecipeMap<NoCoilTemperatureRecipeBuilder> recipeMap) {
        super(recipe, recipeMap);
    }

    public NoCoilTemperatureRecipeBuilder(NoCoilTemperatureRecipeBuilder builder) {
        super(builder);
    }

    public NoCoilTemperatureRecipeBuilder copy() {
        return new NoCoilTemperatureRecipeBuilder(this);
    }

    @Override
    public boolean applyProperty(@NotNull String key, Object value) {
        if (key.equals(NoCoilTemperatureProperty.KEY)) {
            temperature(((Number) value).intValue());
            return true;
        }
        return super.applyProperty(key, value);
    }

    public NoCoilTemperatureRecipeBuilder temperature(int temperature) {
        if (temperature <= 0) {
            GTLiteLog.logger.error("Temperature cannot be less than or equal to 0", new IllegalArgumentException());
            this.recipeStatus = EnumValidationResult.INVALID;
        }
        applyProperty(NoCoilTemperatureProperty.getInstance(), temperature);
        return this;
    }

    public ValidationResult<Recipe> build() {
        if (this.recipePropertyStorage == null)
            this.recipePropertyStorage = new RecipePropertyStorage();
        if (this.recipePropertyStorage.hasRecipeProperty(NoCoilTemperatureProperty.getInstance())) {
            if (this.recipePropertyStorage.getRecipePropertyValue(NoCoilTemperatureProperty.getInstance(), -1) <= 0)
                this.recipePropertyStorage.store(NoCoilTemperatureProperty.getInstance(), 298);
        } else {
            this.recipePropertyStorage.store(NoCoilTemperatureProperty.getInstance(), 298);
        }
        return super.build();
    }

    public int getTemperature() {
        return (this.recipePropertyStorage == null) ? 0 : this.recipePropertyStorage.getRecipePropertyValue(NoCoilTemperatureProperty.getInstance(), 0);
    }

    public String toString() {
        return (new ToStringBuilder(this))
                .appendSuper(super.toString())
                .append(NoCoilTemperatureProperty.getInstance().getKey(), TextFormattingUtil.formatNumbers(getTemperature()))
                .toString();
    }
}