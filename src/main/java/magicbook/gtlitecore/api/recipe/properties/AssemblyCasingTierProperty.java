package magicbook.gtlitecore.api.recipe.properties;

import gregtech.api.recipes.recipeproperties.RecipeProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import org.apache.commons.lang3.Validate;

import java.util.Map;
import java.util.TreeMap;

public class AssemblyCasingTierProperty extends RecipeProperty<Integer> {

    public static final String KEY = "machineLevel";
    private static final TreeMap<Integer, String> registeredAssemblyCasingTiers = new TreeMap<>();
    private static AssemblyCasingTierProperty INSTANCE;

    private AssemblyCasingTierProperty() {
        super(KEY, Integer.class);
    }

    public static AssemblyCasingTierProperty getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AssemblyCasingTierProperty();
        }
        return INSTANCE;
    }

    @Override
    public void drawInfo(Minecraft minecraft,
                         int x,
                         int y,
                         int color,
                         Object value) {
        minecraft.fontRenderer.drawString(I18n.format("gtlitecore.machine.precise_assembler.tier",
                castValue(value).toString()) + getAssemblyCasingTier(castValue(value)), x, y, color);
    }

    private static String getAssemblyCasingTier(Integer casingTier) {
        Map.Entry<Integer, String> mapEntry = registeredAssemblyCasingTiers.ceilingEntry(casingTier);

        if (mapEntry == null) {
            throw new IllegalArgumentException("Tier is above registered maximum Casing Tier.");
        }

        return String.format("%s", mapEntry.getValue());
    }

    public static void registerAssemblyCasingTier(int tier,
                                                  String shortName) {
        Validate.notNull(shortName);
        registeredAssemblyCasingTiers.put(tier, shortName);
    }
}