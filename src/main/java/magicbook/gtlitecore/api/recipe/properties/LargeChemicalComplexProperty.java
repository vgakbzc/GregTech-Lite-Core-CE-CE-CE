package magicbook.gtlitecore.api.recipe.properties;

import gregtech.api.recipes.recipeproperties.RecipeProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import org.apache.commons.lang3.Validate;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.TreeMap;

public class LargeChemicalComplexProperty extends RecipeProperty<Integer> {

    public static final String KEY = "large_chemical_complex";
    private static final TreeMap<Integer, String> registeredLargeChemicalComplexTier = new TreeMap<>();
    private static LargeChemicalComplexProperty INSTANCE;

    private LargeChemicalComplexProperty() {
        super(KEY, Integer.class);
    }

    public static LargeChemicalComplexProperty getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LargeChemicalComplexProperty();
        }
        return INSTANCE;
    }

    @Override
    public void drawInfo(@NotNull Minecraft minecraft, int x, int y, int color, Object value) {
        minecraft.fontRenderer.drawString(I18n.format("gtlitecore.machine.large_chemical_complex.tier",
                castValue(value).toString()) + getLargeChemicalComplexTier(castValue(value)), x, y, color);
    }

    private static String getLargeChemicalComplexTier(Integer tier) {
        Map.Entry<Integer, String> mapEntry = registeredLargeChemicalComplexTier.ceilingEntry(tier);
        if (mapEntry == null) {
            throw new IllegalArgumentException("Tier is above registered maximum tier.");
        }
        return String.format("%s", mapEntry.getValue());
    }

    public static void registerLargeChemicalComplexTier(int tier, String shortName) {
        Validate.notNull(shortName);
        registeredLargeChemicalComplexTier.put(tier, shortName);
    }

}
