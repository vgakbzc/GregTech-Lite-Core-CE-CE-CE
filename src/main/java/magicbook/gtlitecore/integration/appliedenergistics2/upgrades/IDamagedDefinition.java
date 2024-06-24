package magicbook.gtlitecore.integration.appliedenergistics2.upgrades;

import appeng.api.definitions.IItemDefinition;
import magicbook.gtlitecore.integration.appliedenergistics2.IRegisterDefinition;
import magicbook.gtlitecore.integration.appliedenergistics2.models.IModelProvider;
import net.minecraft.item.ItemStack;

import org.jetbrains.annotations.Nullable;
import java.util.Collection;

public interface IDamagedDefinition<T extends IItemDefinition, U extends IModelProvider> extends IRegisterDefinition<T> {

    Collection<U> getEntries();

    @Nullable
    U getType(ItemStack stack);
}
