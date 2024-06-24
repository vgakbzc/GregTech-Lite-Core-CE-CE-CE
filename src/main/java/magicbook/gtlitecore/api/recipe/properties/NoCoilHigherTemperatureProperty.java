package magicbook.gtlitecore.api.recipe.properties;

import gregtech.api.recipes.recipeproperties.RecipeProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;

import org.jetbrains.annotations.NotNull;
import java.math.BigInteger;

public class NoCoilHigherTemperatureProperty extends RecipeProperty<BigInteger> {

    public static final String KEY = "temperature";
    private static NoCoilHigherTemperatureProperty INSTANCE;

    private NoCoilHigherTemperatureProperty() {
        super(KEY, BigInteger.class);
    }

    public static NoCoilHigherTemperatureProperty getInstance() {
        if (INSTANCE == null)
            INSTANCE = new NoCoilHigherTemperatureProperty();
        return INSTANCE;
    }

    @Override
    public void drawInfo(@NotNull Minecraft minecraft, int x, int y, int color, Object value) {
        minecraft.fontRenderer.drawString(I18n.format("gtlitecore.recipe.temperature", castValue(value)), x, y, color);
    }
}
