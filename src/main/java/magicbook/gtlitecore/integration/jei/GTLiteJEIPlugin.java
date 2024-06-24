package magicbook.gtlitecore.integration.jei;

import appeng.api.definitions.IItemDefinition;
import io.github.phantamanta44.threng.client.gui.GuiLevelMaintainer;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import magicbook.gtlitecore.integration.threng.LAEGuiHandler;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.ingredients.VanillaTypes;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;

import org.jetbrains.annotations.NotNull;
import java.util.Arrays;

@SuppressWarnings("unused")
@JEIPlugin
public class GTLiteJEIPlugin implements IModPlugin {

    private static final ObjectOpenHashSet<ItemStack> ingredientItemBlacklist = new ObjectOpenHashSet<>();
    private static final ObjectOpenHashSet<IItemDefinition> ingredientAE2ItemBlacklist = new ObjectOpenHashSet<>();

    private static final Object2ObjectOpenHashMap<ItemStack, String[]> ingredientDescriptions = new Object2ObjectOpenHashMap<>();
    private static final Object2ObjectOpenHashMap<IItemDefinition, String[]> ingredientAE2Descriptions = new Object2ObjectOpenHashMap<>();

    @Override
    public void register(@NotNull IModRegistry registry) {
        //  Lazy AE2 Integration.
        registry.addGhostIngredientHandler(GuiLevelMaintainer.class, new LAEGuiHandler());

        var blacklist = registry.getJeiHelpers().getIngredientBlacklist();

        //  Item Blacklists.
        for (var blacklistEntry : ingredientItemBlacklist) {
            blacklist.addIngredientToBlacklist(blacklistEntry);
        }

        for (var blacklistEntry : ingredientAE2ItemBlacklist) {
            blacklistEntry.maybeStack(1).ifPresent(blacklist::addIngredientToBlacklist);
        }

        //  JEI Page Descriptions.
        for (var descEntry : ingredientDescriptions.object2ObjectEntrySet()) {
            registry.addIngredientInfo(descEntry.getKey(), VanillaTypes.ITEM, Arrays.stream(descEntry.getValue())
                    .map(I18n::format)
                    .toArray(String[]::new));
        }

        for (var descEntry : ingredientAE2Descriptions.object2ObjectEntrySet()) {
            descEntry.getKey().maybeStack(1).ifPresent(stack -> {
                registry.addIngredientInfo(stack, VanillaTypes.ITEM, Arrays.stream(descEntry.getValue())
                        .map(I18n::format)
                        .toArray(String[]::new));
            });
        }
    }

    public static void addItemToBlacklist(ItemStack ingredient) {
        ingredientItemBlacklist.add(ingredient);
    }

    public static void addItemToBlacklist(IItemDefinition ingredient) {
        ingredientAE2ItemBlacklist.add(ingredient);
    }

    public static void addDescription(ItemStack stack, String... descriptions) {
        ingredientDescriptions.put(stack, descriptions);
    }

    public static void addDescription(IItemDefinition definition, String... descriptions) {
        ingredientAE2Descriptions.put(definition, descriptions);
    }
}
