package magicbook.gtlitecore.integration.appliedenergistics2.items;

import appeng.api.AEApi;
import appeng.api.parts.IPart;
import appeng.api.parts.IPartItem;
import appeng.core.features.ActivityState;
import appeng.core.features.ItemStackSrc;
import appeng.items.AEBaseItem;
import com.google.common.base.Preconditions;
import magicbook.gtlitecore.integration.appliedenergistics2.parts.AE2PartType;
import magicbook.gtlitecore.integration.appliedenergistics2.parts.PartTypeWithVariant;
import magicbook.gtlitecore.integration.appliedenergistics2.parts.RegisteredComparator;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

@SuppressWarnings("rawtypes")
public class AE2BaseItemPart extends AEBaseItem implements IPartItem {

    private static final int INITIAL_REGISTERED_CAPACITY = AE2PartType.values().length;
    private static final Comparator<Map.Entry<Integer, PartTypeWithVariant>> REGISTERED_COMPARATOR = new RegisteredComparator();
    private final Map<Integer, PartTypeWithVariant> registered;

    public static AE2BaseItemPart INSTANCE;

    public AE2BaseItemPart() {
        this.registered = new HashMap<>(INITIAL_REGISTERED_CAPACITY);
        this.setHasSubtypes(true);
        INSTANCE = this;
    }

    @NotNull
    @Override
    public String getTranslationKey(@NotNull ItemStack stack) {
        var type = this.getTypeByStack(stack);
        if (type == null)
            return "item.gtlitecore.invalid";
        return type.getUnlocalizedName().toLowerCase();
    }

    @Nullable
    public AE2PartType getTypeByStack(final @NotNull ItemStack stack) {
        final var pt = this.registered.get(stack.getItemDamage());
        if (pt != null)
            return pt.part();
        return null;
    }

    @Override
    protected void getCheckedSubItems(final CreativeTabs creativeTab, final NonNullList<ItemStack> stack) {
        final List<Map.Entry<Integer, PartTypeWithVariant>> types = new ArrayList<>(this.registered.entrySet());
        types.sort(REGISTERED_COMPARATOR);
        for (final var part : types) {
            stack.add(new ItemStack(this, 1, part.getKey()));
        }
    }

    @Nullable
    @Override
    public IPart createPartFromItemStack(ItemStack stack) {
        final var type = this.getTypeByStack(stack);
        if (type == null)
            return null;

        final var part = type.getPart();
        if (part == null)
            return null;

        try {
            if (type.getConstructor() == null)
                type.setConstructor(part.getConstructor(ItemStack.class));
            return type.getConstructor().newInstance(stack);
        } catch (InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    @NotNull
    @Override
    public String getItemStackDisplayName(final @NotNull ItemStack stack) {
        final var pt = this.getTypeByStack(stack);
        if (pt != null && pt.getExtraName() != null)
            return super.getItemStackDisplayName(stack) + " - " + pt.getExtraName().getLocal();
        return super.getItemStackDisplayName(stack);
    }

    @NotNull
    public EnumActionResult onItemUse(@NotNull EntityPlayer player, @NotNull World w, @NotNull BlockPos pos, @NotNull EnumHand hand, @NotNull EnumFacing side,
                                      float hitX, float hitY, float hitZ) {
        return AEApi.instance().partHelper().placeBus(player.getHeldItem(hand), pos, side, player, hand, w);
    }

    @NotNull
    public final ItemStackSrc registerPart(AE2PartType partType) {
        Preconditions.checkNotNull(partType);
        return this.registerPart(partType, 0);
    }

    public ItemStackSrc registerPart(AE2PartType partType, int varId) {
        assert partType != null;
        assert varId >= 0;
        //  Verify Registered value.
        for (final var p : this.registered.values()) {
            if (p.part() == partType && p.variant() == varId)
                throw new IllegalStateException("Cannot create the same material twice...");
        }

        var enabled = partType.isEnabled();
        final var partDamage = partType.getBaseDamage() + varId;
        final var state = ActivityState.from(enabled);
        final var output = new ItemStackSrc(this, partDamage, state);
        final var pti = new PartTypeWithVariant(partType, varId);

        this.processMetaOverlap(enabled, partDamage, partType, pti);
        return output;
    }

    private void processMetaOverlap(final boolean enabled, final int partDamage, final AE2PartType partType, final PartTypeWithVariant pti) {
        assert partDamage >= 0;
        assert partType != null;
        assert pti != null;

        final var registeredPartType = this.registered.get(partDamage);
        if (registeredPartType != null)
            throw new IllegalStateException("Meta Overlap detected with type " + partType + " and damage " + partDamage + ". Found " + registeredPartType + " there already.");
        if (enabled)
            this.registered.put(partDamage, pti);
    }

    public int variantOf(final int itemDamage) {
        final var registeredPartType = this.registered.get(itemDamage);
        if (registeredPartType != null) {
            return registeredPartType.variant();
        }

        return 0;
    }

    @Override
    protected void addCheckedInformation(ItemStack stack, World world, List<String> lines, ITooltipFlag advancedTooltips) {
        super.addCheckedInformation(stack, world, lines, advancedTooltips);
        final var pt = this.getTypeByStack(stack);
        if (pt != null)
            pt.addCheckedInformation(stack, world, lines, advancedTooltips);
    }
}
