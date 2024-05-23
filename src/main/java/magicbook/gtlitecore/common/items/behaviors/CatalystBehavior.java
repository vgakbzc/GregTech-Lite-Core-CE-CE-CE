package magicbook.gtlitecore.common.items.behaviors;

import gregtech.api.items.metaitem.stats.IItemMaxStackSizeProvider;
import gregtech.common.items.behaviors.AbstractMaterialPartBehavior;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;

import java.util.List;

/**
 * @author Magic_Sweepy
 * @since 2.8.8-beta
 */
public class CatalystBehavior extends AbstractMaterialPartBehavior implements IItemMaxStackSizeProvider {

    @Override
    public int getPartMaxDurability(ItemStack itemStack) {
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
        return 1;
    }
}
