package magicbook.gtlitecore.api.recipe.properties;

import gregtech.api.recipes.recipeproperties.RecipeProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import org.jetbrains.annotations.NotNull;

public class FlowRateProperty extends RecipeProperty<Integer> {

    public static final String KEY = "flow_rate";
    private static FlowRateProperty INSTANCE;

    private FlowRateProperty() {
        super(KEY, Integer.class);
    }

    public static FlowRateProperty getInstance() {
        if (INSTANCE == null)
            INSTANCE = new FlowRateProperty();
        return INSTANCE;
    }

    @Override
    public void drawInfo(@NotNull Minecraft minecraft, int x, int y, int color, Object value) {
        minecraft.fontRenderer.drawString(I18n.format("gtlitecore.recipe.flow_rate", castValue(value)), x, y, color);
    }
}
