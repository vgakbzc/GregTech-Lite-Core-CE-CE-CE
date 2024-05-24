package magicbook.gtlitecore.common.items.behaviors;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.items.metaitem.stats.IItemDurabilityManager;
import gregtech.api.items.metaitem.stats.IItemMaxStackSizeProvider;
import gregtech.common.items.behaviors.AbstractMaterialPartBehavior;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

/**
 * @author Magic_Sweepy
 * @since 2.8.8-beta
 */
public class CatalystBehavior extends AbstractMaterialPartBehavior implements IItemMaxStackSizeProvider {

    public void applyCatalystDamage(ItemStack stack, int damageApplied) {
        int catalystDurability = this.getPartMaxDurability(stack);
        int resultDamage = getPartDamage(stack) + damageApplied;
        if (resultDamage >= catalystDurability)
            stack.shrink(1);
        else
            this.setPartDamage(stack, resultDamage);
    }

    @Nullable
    public static CatalystBehavior getInstanceFor(@Nonnull ItemStack stack) {
        if (!(stack.getItem() instanceof MetaItem))
            return null;

        MetaItem<?>.MetaValueItem valueItem = ((MetaItem<?>) stack.getItem()).getItem(stack);
        if (valueItem == null)
            return null;

        IItemDurabilityManager durabilityManager = valueItem.getDurabilityManager();

        if (!(durabilityManager instanceof CatalystBehavior))
            return null;
        return (CatalystBehavior) durabilityManager;
    }

    @Override
    public int getPartMaxDurability(ItemStack stack) {
        return 50;
    }

    @Override
    public void addInformation(ItemStack stack, List<String> lines) {
        int maxDurability = getPartMaxDurability(stack);
        int damage = getPartDamage(stack);
        lines.add(I18n.format("metaitem.tool.tooltip.durability", maxDurability - damage, maxDurability));
    }

    @Override
    public int getMaxStackSize(ItemStack itemStack, int defaultValue) {
        return 16;
    }
}
