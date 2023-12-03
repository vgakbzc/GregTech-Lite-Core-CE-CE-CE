package magicbook.gtlitecore.api.recipe.properties;

import gregtech.api.recipes.recipeproperties.RecipeProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import org.apache.commons.lang3.Validate;

import java.util.Map;
import java.util.TreeMap;

public class ComponentCasingTierProperty extends RecipeProperty<Integer> {

    public static final String KEY = "machineLevel";
    private static final TreeMap<Integer, String> registeredComponentCasingTier = new TreeMap<>();
    private static ComponentCasingTierProperty INSTANCE;

    private ComponentCasingTierProperty() {
        super(KEY, Integer.class);
    }

    public static ComponentCasingTierProperty getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ComponentCasingTierProperty();
        }
        return INSTANCE;
    }

    @Override
    public void drawInfo(Minecraft minecraft,
                         int x,
                         int y,
                         int color,
                         Object value) {
        minecraft.fontRenderer.drawString(I18n.format("gtlitecore.machine.component_assembly_line.tier",
                castValue(value).toString()) + getComponentCasingTier(castValue(value)), x, y, color);
    }

    private static String getComponentCasingTier(Integer casingTier) {
        Map.Entry<Integer, String> mapEntry = registeredComponentCasingTier.ceilingEntry(casingTier);

        if (mapEntry == null) {
            throw new IllegalArgumentException("Tier is above registered maximum Casing Tier.");
        }

        return String.format("%s", mapEntry.getValue());
    }

    public static void registerComponentCasingTier(int tier, String shortName) {
        Validate.notNull(shortName);
        registeredComponentCasingTier.put(tier, shortName);
    }
}
