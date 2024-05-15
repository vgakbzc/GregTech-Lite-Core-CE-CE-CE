package magicbook.gtlitecore.api.recipe.properties;

import gregtech.api.recipes.recipeproperties.RecipeProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;

public class GrindBallProperty extends RecipeProperty<Integer> {

    public static final String KEY = "grindball";
    private static GrindBallProperty INSTANCE;

    private GrindBallProperty() {
        super(KEY, Integer.class);
    }

    public static GrindBallProperty getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GrindBallProperty();
        }
        return INSTANCE;
    }

    @Override
    public void drawInfo(Minecraft minecraft, int x, int y, int color, Object value) {
        minecraft.fontRenderer.drawString(getGrindBallTier(castValue(value)), x, y, color);
    }

    private static String getGrindBallTier(int grindballTier) {
        if (grindballTier == 1) {
            return I18n.format("gtlitecore.machine.isa_mill.grind_ball.soapstone") ;
        } else {
            return I18n.format("gtlitecore.machine.isa_mill.grind_ball.aluminium");
        }
    }
}
