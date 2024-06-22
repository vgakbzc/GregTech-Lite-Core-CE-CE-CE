package magicbook.gtlitecore.integration.jei;

import appeng.api.definitions.IItemDefinition;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

@JEIPlugin
public class GTLiteJEIPlugin implements IModPlugin {

    private static final ObjectOpenHashSet<ItemStack> ingredientItemBlacklist = new ObjectOpenHashSet<>();
    private static final ObjectOpenHashSet<IItemDefinition> ingredientAE2ItemBlacklist = new ObjectOpenHashSet<>();

    @Override
    public void register(@Nonnull IModRegistry registry) {
        var blacklist = registry.getJeiHelpers().getIngredientBlacklist();
        //  Common Item Blacklist.
        for (var blacklistEntry : ingredientItemBlacklist) {
            blacklist.addIngredientToBlacklist(blacklistEntry);
        }
        //  AE2 Item Blacklist.
        for (var blacklistEntry : ingredientAE2ItemBlacklist) {
            blacklistEntry.maybeStack(1).ifPresent(blacklist::addIngredientToBlacklist);
        }
    }

    public static void addItemToBlacklist(ItemStack ingredient) {
        ingredientItemBlacklist.add(ingredient);
    }

    public static void addAE2ItemToBlacklist(IItemDefinition ingredient) {
        ingredientAE2ItemBlacklist.add(ingredient);
    }
}
