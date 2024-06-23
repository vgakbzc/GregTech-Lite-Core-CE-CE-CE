package magicbook.gtlitecore.integration.appliedenergistics2.materials;

import appeng.core.features.IStackSrc;
import com.google.common.base.Preconditions;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class AE2MaterialStackSrc implements IStackSrc {

    private final AE2MaterialType src;
    private final boolean enabled;

    public AE2MaterialStackSrc(AE2MaterialType src, boolean enabled) {
        Preconditions.checkNotNull(src);
        this.src = src;
        this.enabled = enabled;
    }

    @Override
    public ItemStack stack(int stackSize) {
        return this.src.stack(stackSize);
    }

    @Override
    public Item getItem() {
        return this.src.getItemInstance();
    }

    @Override
    public int getDamage() {
        return this.src.getDamageValue();
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
