package magicbook.gtlitecore.common.items.behaviors;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.items.metaitem.stats.IItemDurabilityManager;
import gregtech.api.items.metaitem.stats.IItemMaxStackSizeProvider;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.common.items.behaviors.AbstractMaterialPartBehavior;
import magicbook.gtlitecore.common.items.GTLiteMetaItems;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Grindball Item Behavior
 *
 * @author Gate Guardian
 *
 * <p>
 *     Item behavior for grindball (used in {@link magicbook.gtlitecore.common.metatileentities.multi.part.MetaTileEntityGrindBallHatch} of {@link magicbook.gtlitecore.common.metatileentities.multi.electric.MetaTileEntityIsaMill}).
 * </p>
 */
public class GrindBallBehavior extends AbstractMaterialPartBehavior implements IItemMaxStackSizeProvider {

    @Override
    public int getPartMaxDurability(ItemStack itemStack) {
        if (GTLiteMetaItems.GRINDBALL_SOAPSTONE.isItemEqual(itemStack))
            return 50;
        else
            return 100;
    }

    public int getBallDurabilityPercent(ItemStack itemStack) {
        return 100 - 100 * getPartDamage(itemStack) / getPartMaxDurability(itemStack);
    }

    public void applyGrindBallDamage(ItemStack itemStack, int damageApplied) {
        int ballDurability = getPartMaxDurability(itemStack);
        int resultDamage = getPartDamage(itemStack) + damageApplied;
        if (resultDamage >= ballDurability) {
            itemStack.shrink(1);
        } else {
            setPartDamage(itemStack, resultDamage);
        }
    }

    @Override
    public void addInformation(ItemStack stack, List<String> lines) {
        Material material;
        if (GTLiteMetaItems.GRINDBALL_SOAPSTONE.isItemEqual(stack))
            material = Materials.Soapstone;
        else
            material = Materials.Aluminium;
        int maxDurability = getPartMaxDurability(stack);
        int damage = getPartDamage(stack);
        lines.add(I18n.format("metaitem.tool.tooltip.primary_material", material.getLocalizedName()));
        lines.add(I18n.format("metaitem.tool.tooltip.durability", maxDurability - damage, maxDurability));
    }

    @Override
    public int getMaxStackSize(ItemStack itemStack, int defaultValue) {
        return 1;
    }

    @Nullable
    public static GrindBallBehavior getInstanceFor(@NotNull ItemStack itemStack) {
        if (!(itemStack.getItem() instanceof MetaItem))
            return null;

        MetaItem<?>.MetaValueItem valueItem = ((MetaItem<?>) itemStack.getItem()).getItem(itemStack);
        if (valueItem == null)
            return null;

        IItemDurabilityManager durabilityManager = valueItem.getDurabilityManager();

        if (!(durabilityManager instanceof GrindBallBehavior))
            return null;

        return (GrindBallBehavior) durabilityManager;
    }
}
