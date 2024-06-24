package magicbook.gtlitecore.api.recipe.properties;

import gregtech.api.recipes.recipeproperties.RecipeProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import org.jetbrains.annotations.NotNull;

public class NoCoilTemperatureProperty extends RecipeProperty<Integer> {

    public static final String KEY = "temperature";
    private static NoCoilTemperatureProperty INSTANCE;

    private NoCoilTemperatureProperty() {
        super("temperature", Integer.class);
    }

    public static NoCoilTemperatureProperty getInstance() {
        if (INSTANCE == null)
            INSTANCE = new NoCoilTemperatureProperty();
        return INSTANCE;
    }

    @Override
    public void drawInfo(@NotNull Minecraft minecraft, int x, int y, int color, Object value) {
        minecraft.fontRenderer.drawString(I18n.format("gtlitecore.recipe.temperature", castValue(value)), x, y, color);
    }
}
