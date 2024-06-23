package magicbook.gtlitecore.integration.appliedenergistics2.upgrades;

import net.minecraft.item.ItemStack;

public interface IUpgradeType {

    AE2UpgradeType getType(ItemStack stack);
}
