package magicbook.gtlitecore.integration.appliedenergistics2.upgrades;

import appeng.api.implementations.items.IItemGroup;
import appeng.api.implementations.tiles.ISegmentedInventory;
import appeng.api.parts.IPartHost;
import appeng.core.features.IStackSrc;
import appeng.items.AEBaseItem;
import appeng.util.InventoryAdaptor;
import appeng.util.Platform;
import appeng.util.inv.AdaptorItemHandler;
import com.google.common.base.Preconditions;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import magicbook.gtlitecore.GTLiteCore;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class AE2BaseItemUpgrade extends AEBaseItem implements IUpgradeType {

    public static AE2BaseItemUpgrade INSTANCE;
    private final Int2ObjectOpenHashMap<AE2UpgradeType> damagedToUpgrade = new Int2ObjectOpenHashMap<>();

    public AE2BaseItemUpgrade() {
        this.setHasSubtypes(true);
        INSTANCE = this;
    }

    @Nonnull
    @Override
    public String getTranslationKey(ItemStack itemStack) {
        var upgrade = GTLiteCore.getAE2RegisterManager().getAE2Upgrades().getById(itemStack.getItemDamage());
        if (upgrade.isPresent())
            return upgrade.get().getTranslationKey();
        return "item.gtlitecore.invalid";
    }

    @Override
    protected void getCheckedSubItems(final CreativeTabs creativeTab, final NonNullList<ItemStack> itemStacks) {
        //  If Sub Item is not in our Creative Tab, then return.
        if (!this.isInCreativeTab(creativeTab))
            return;
        //  For all Upgrades in AE2UpgradeType class, check it if registered and ad dit to item stacks.
        for (var upgrade : AE2UpgradeType.getCachedValues().values()) {
            //  If Upgrade is not be registered, then continue.
            if (!upgrade.isRegistered())
                continue;
            //  Add correspondence Item for Upgrade.
            itemStacks.add(new ItemStack(this, 1, upgrade.ordinal()));
        }
    }

    @SideOnly(Side.CLIENT)
    public void addCheckedInformation(ItemStack stack, World world, List<String> lines, ITooltipFlag advancedTooltips) {
        //  Get Upgrade Type by Item Stack.
        var u = this.getType(stack);
        //  If Item Stack is not null, then add Checked Information for it.
        if (u != null) {
            List<String> textList = new ArrayList<>();
            u.addCheckedInformation(stack, world, lines, advancedTooltips);
            if (!lines.isEmpty()) {
                lines.add("");
            }
            for (var j : u.getSupported().entrySet()) {
                String name = null;
                int limit = j.getValue();
                if (j.getKey().getItem() instanceof IItemGroup ig) {
                    var str = ig.getUnlocalizedGroupName(u.getSupported().keySet(), j.getKey());
                    if (str != null) {
                        name = Platform.gui_localize(str) + (limit > 1 ? " (" + limit + ')' : "");
                    }
                }
                if (name == null) {
                    name = j.getKey().getDisplayName() + (limit > 1 ? " (" + limit + ')' : "");
                }
                if (!textList.contains(name)) {
                    textList.add(name);
                }
            }
            lines.addAll(textList);
        }
    }

    @Nullable
    public AE2UpgradeType getType(ItemStack stack) {
        return GTLiteCore.getAE2RegisterManager().getAE2Upgrades().getById(stack.getItemDamage()).orElse(null);
    }

    @Nonnull
    @Override
    public EnumActionResult onItemUseFirst(EntityPlayer player, @Nonnull World world, @Nonnull BlockPos pos, @Nonnull EnumFacing side,
                                           float hitX, float hitY, float hitZ, @Nonnull EnumHand hand) {
        if (player.isSneaking()) {
            var te = world.getTileEntity(pos);
            IItemHandler upgrades = null;
            if (te instanceof IPartHost) {
                var sp = ((IPartHost) te).selectPart(new Vec3d(hitX, hitY, hitZ));
                if (sp.part instanceof IAE2UpgradeHost) {
                    upgrades = ((ISegmentedInventory) sp.part).getInventoryByName("upgrades");
                }
            } else if (te instanceof IAE2UpgradeHost) {
                upgrades = ((ISegmentedInventory) te).getInventoryByName("upgrades");
            }

            if (upgrades != null && !player.getHeldItem(hand).isEmpty()
                    && player.getHeldItem(hand).getItem() instanceof IAE2UpgradeModule um) {
                var u = um.getType(player.getHeldItem(hand));
                if (u != null) {
                    if (player.world.isRemote) {
                        return EnumActionResult.PASS;
                    }
                    InventoryAdaptor ad = new AdaptorItemHandler(upgrades);
                    player.setHeldItem(hand, ad.addItems(player.getHeldItem(hand)));
                    return EnumActionResult.SUCCESS;
                }
            }
        }
        return super.onItemUseFirst(player, world, pos, side, hitX, hitY, hitZ, hand);
    }

    public IStackSrc registerUpgrade(AE2UpgradeType upgradeType) {
        //  Check upgradeType state, if it is not be registered, then throw an error.
        Preconditions.checkState(!upgradeType.isRegistered(), "Cannot create the same material twice.");

        //  Set Stack Src to AE2 Upgrade Stack Src.
        var enabled = upgradeType.isEnabled();
        upgradeType.setStackSrc(new AE2UpgradeStackSrc(upgradeType, enabled));

        //  If it is enabled then mark it ready (means is now registered) and put it to Stack Src.
        if (enabled) {
            upgradeType.setItemInstance(this);
            upgradeType.markReady();
            final var newUpgradeNum = upgradeType.getDamageValue();
            if (this.damagedToUpgrade.get(newUpgradeNum) == null) {
                this.damagedToUpgrade.put(newUpgradeNum, upgradeType);
            } else {
                throw new IllegalStateException("Meta Overlap detected.");
            }
        }

        return upgradeType.getStackSrc();
    }
}
