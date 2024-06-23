package magicbook.gtlitecore.integration.appliedenergistics2.materials;

import appeng.core.features.IStackSrc;
import appeng.items.AEBaseItem;
import com.google.common.base.Preconditions;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import magicbook.gtlitecore.GTLiteCore;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class AE2BaseItemMaterial extends AEBaseItem {

    public static AE2BaseItemMaterial INSTANCE;
    private final Int2ObjectOpenHashMap<AE2MaterialType> damagedToMaterial = new Int2ObjectOpenHashMap<>();

    public AE2BaseItemMaterial() {
        this.setHasSubtypes(true);
        INSTANCE = this;
    }

    @Nonnull
    @Override
    public String getTranslationKey(ItemStack itemStack) {
        var material = GTLiteCore.getAE2RegisterManager().getAE2Materials().getById(itemStack.getItemDamage());
        if (material.isPresent()) {
            return material.get().getTranslationKey();
        }
        return "item.gtlitecore.invalid";
    }

    @Override
    protected void getCheckedSubItems(final CreativeTabs creativeTab, final NonNullList<ItemStack> itemStacks) {
        if (!this.isInCreativeTab(creativeTab)) return;

        for (var material : AE2MaterialType.getCachedValues().values()) {
            if (!material.isRegistered()) continue;

            itemStacks.add(new ItemStack(this, 1, material.ordinal()));
        }
    }

    public IStackSrc registerMaterial(AE2MaterialType materialType) {
        Preconditions.checkState(!materialType.isRegistered(), "Cannot create the same material twice.");

        var enabled = materialType.isEnabled();

        materialType.setStackSrc(new AE2MaterialStackSrc(materialType, enabled));

        if (enabled) {
            materialType.setItemInstance(this);
            materialType.markReady();
            final var newMaterialNum = materialType.getDamageValue();

            if (this.damagedToMaterial.get(newMaterialNum) == null) {
                this.damagedToMaterial.put(newMaterialNum, materialType);
            } else {
                throw new IllegalStateException("Meta Overlap detected.");
            }
        }

        return materialType.getStackSrc();
    }

    @Nullable
    public AE2MaterialType getTypeByStack(final ItemStack stack) {
        return this.damagedToMaterial.get(stack.getItemDamage());
    }
}
