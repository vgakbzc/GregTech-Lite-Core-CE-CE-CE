package magicbook.gtlitecore.api.recipe.properties;

import gregtech.api.recipes.recipeproperties.RecipeProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import org.apache.commons.lang3.Validate;

import java.util.Map;
import java.util.TreeMap;

public class FieldCasingTierProperty extends RecipeProperty<Integer> {

    public static final String KEY = "machineLevel";
    private static final TreeMap<Integer, String> registeredFieldCasingTier = new TreeMap<>();
    private static FieldCasingTierProperty INSTANCE;

    private FieldCasingTierProperty() {
        super(KEY, Integer.class);
    }

    public static FieldCasingTierProperty getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FieldCasingTierProperty();
        }
        return INSTANCE;
    }

    @Override
    public void drawInfo(Minecraft minecraft,
                         int x,
                         int y,
                         int color,
                         Object value) {
        minecraft.fontRenderer.drawString(I18n.format("gtlitecore.machine.collider.tier",
                castValue(value).toString()) + getFieldCasingTier(castValue(value)), x, y, color);
    }

    private static String getFieldCasingTier(Integer casingTier) {
        Map.Entry<Integer, String> mapEntry = registeredFieldCasingTier.ceilingEntry(casingTier);

        if (mapEntry == null) {
            throw new IllegalArgumentException("Tier is above registered maximum Casing Tier.");
        }

        return String.format("%s", mapEntry.getValue());
    }

    public static void registerFieldCasingTier(int tier, String shortName) {
        Validate.notNull(shortName);
        registeredFieldCasingTier.put(tier, shortName);
    }
}
