package magicbook.gtlitecore.api.recipe.properties;

import gregtech.api.recipes.recipeproperties.RecipeProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import org.apache.commons.lang3.Validate;

import java.util.Map;
import java.util.TreeMap;

public class GravitonCasingTierProperty extends RecipeProperty<Integer> {

    public static final String KEY = "machineLevel";
    private static final TreeMap<Integer, String> registeredGravitonCasingTier = new TreeMap<>();
    private static GravitonCasingTierProperty INSTANCE;

    private GravitonCasingTierProperty() {
        super(KEY, Integer.class);
    }

    public static GravitonCasingTierProperty getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GravitonCasingTierProperty();
        }
        return INSTANCE;
    }

    @Override
    public void drawInfo(Minecraft minecraft,
                         int x,
                         int y,
                         int color,
                         Object value) {
        minecraft.fontRenderer.drawString(I18n.format("gtlitecore.machine.nicoll_dyson_beamer.tier",
                castValue(value).toString()) + getGravitonCasingTier(castValue(value)), x, y, color);
    }

    private static String getGravitonCasingTier(Integer casingTier) {
        Map.Entry<Integer, String> mapEntry = registeredGravitonCasingTier.ceilingEntry(casingTier);

        if (mapEntry == null) {
            throw new IllegalArgumentException("Tier is above registered maximum Casing Tier.");
        }

        return String.format("%s", mapEntry.getValue());
    }

    public static void registerGravitonCasingTier(int tier, String shortName) {
        Validate.notNull(shortName);
        registeredGravitonCasingTier.put(tier, shortName);
    }
}
