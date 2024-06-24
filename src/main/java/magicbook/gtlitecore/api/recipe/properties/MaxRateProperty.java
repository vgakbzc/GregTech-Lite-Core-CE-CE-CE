package magicbook.gtlitecore.api.recipe.properties;

import gregtech.api.recipes.recipeproperties.RecipeProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import org.jetbrains.annotations.NotNull;

public class MaxRateProperty extends RecipeProperty<Integer> {

    public static final String KEY = "max_rate";
    private static MaxRateProperty INSTANCE;

    private MaxRateProperty() {
        super(KEY, Integer.class);
    }

    public static MaxRateProperty getInstance() {
        if (INSTANCE == null)
            INSTANCE = new MaxRateProperty();
        return INSTANCE;
    }

    @Override
    public void drawInfo(@NotNull Minecraft minecraft, int x, int y, int color, Object value) {
        minecraft.fontRenderer.drawString(I18n.format("gtlitecore.recipe.max_rate", castValue(value)), x, y, color);
    }
}
