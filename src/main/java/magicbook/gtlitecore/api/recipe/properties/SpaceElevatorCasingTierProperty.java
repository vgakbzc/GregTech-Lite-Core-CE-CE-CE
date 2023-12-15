package magicbook.gtlitecore.api.recipe.properties;

import gregtech.api.recipes.recipeproperties.RecipeProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import org.apache.commons.lang3.Validate;

import java.util.Map;
import java.util.TreeMap;

public class SpaceElevatorCasingTierProperty extends RecipeProperty<Integer> {

    public static final String KEY = "machineLevel";
    private static final TreeMap<Integer, String> registeredSpaceElevatorCasingTiers = new TreeMap<>();
    private static SpaceElevatorCasingTierProperty INSTANCE;

    private SpaceElevatorCasingTierProperty() {
        super(KEY, Integer.class);
    }

    public static SpaceElevatorCasingTierProperty getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SpaceElevatorCasingTierProperty();
        }
        return INSTANCE;
    }

    @Override
    public void drawInfo(Minecraft minecraft,
                         int x,
                         int y,
                         int color,
                         Object value) {
        minecraft.fontRenderer.drawString(I18n.format("gtlitecore.machine.space_elevator.tier",
                castValue(value).toString()) + getSpaceElevatorTier(castValue(value)), x, y, color);
    }

    private static String getSpaceElevatorTier(Integer casingTier) {
        Map.Entry<Integer, String> mapEntry = registeredSpaceElevatorCasingTiers.ceilingEntry(casingTier);

        if (mapEntry == null) {
            throw new IllegalArgumentException("Tier is above registered maximum Casing Tier.");
        }

        return String.format("%s", mapEntry.getValue());
    }

    public static void registerSpaceElevatorCasingTier(int tier,
                                                       String shortName) {
        Validate.notNull(shortName);
        registeredSpaceElevatorCasingTiers.put(tier, shortName);
    }
}
