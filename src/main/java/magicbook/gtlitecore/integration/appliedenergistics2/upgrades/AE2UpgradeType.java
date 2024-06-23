package magicbook.gtlitecore.integration.appliedenergistics2.upgrades;

import appeng.api.definitions.IItemDefinition;
import appeng.core.features.IStackSrc;
import it.unimi.dsi.fastutil.ints.Int2ObjectLinkedOpenHashMap;
import magicbook.gtlitecore.api.utils.Mods;
import magicbook.gtlitecore.integration.appliedenergistics2.features.IAE2Feature;
import magicbook.gtlitecore.integration.appliedenergistics2.models.IModelProvider;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static magicbook.gtlitecore.api.utils.GTLiteUtils.gtliteId;

public enum AE2UpgradeType implements IModelProvider {

    //  Please register Upgrade Type here like `ITEM_NAME("item_id", AE2UpgradeFeatures.ITEM_NAME)`.
    ;

    private static Int2ObjectLinkedOpenHashMap<AE2UpgradeType> cachedValues;
    private final Map<ItemStack, Integer> supportedMax = new HashMap<>();
    private final String id;
    private final IAE2Feature features;
    private final String translationKey;
    private final ModelResourceLocation model;
    private final int damageValue = this.ordinal();
    private boolean isRegistered;
    private Item itemInstance;
    private IStackSrc stackSrc;

    AE2UpgradeType(String id, IAE2Feature features) {
        this.id = id;
        this.features = features;
        this.translationKey = "item." + Mods.GregTechLiteCore.getID() + ".upgrade." + id;
        this.model = new ModelResourceLocation(gtliteId("upgrade/" + id), "inventory");
    }

    public static Int2ObjectLinkedOpenHashMap<AE2UpgradeType> getCachedValues() {
        if (cachedValues == null) {
            cachedValues = new Int2ObjectLinkedOpenHashMap<>();
            Arrays.stream(values()).forEach(upgradeType -> cachedValues.put(upgradeType.ordinal(), upgradeType));
        }
        return cachedValues;
    }

    public String getId() {
        return this.id;
    }

    public IAE2Feature getFeature() {
        return this.features;
    }

    public String getTranslationKey() {
        return this.translationKey;
    }

    public ItemStack stack(final int size) {
        return new ItemStack(this.getItemInstance(), size, this.getDamageValue());
    }

    public boolean isRegistered() {
        return this.isRegistered;
    }

    public boolean isEnabled() {
        return this.features.isEnabled();
    }

    public void markReady() {
        this.isRegistered = true;
    }

    public int getDamageValue() {
        return this.damageValue;
    }

    public Item getItemInstance() {
        return this.itemInstance;
    }

    public void setItemInstance(final Item itemInstance) {
        this.itemInstance = itemInstance;
    }

    public AE2UpgradeStackSrc getStackSrc() {
        return (AE2UpgradeStackSrc) this.stackSrc;
    }

    public void setStackSrc(final AE2UpgradeStackSrc stackSrc) {
        this.stackSrc = stackSrc;
    }

    public ModelResourceLocation getModel() {
        return this.model;
    }

    public Map<ItemStack, Integer> getSupported() {
        return this.supportedMax;
    }

    public void registerItem(IItemDefinition item, int maxSupported) {
        item.maybeStack(1).ifPresent((is) -> this.registerItem(is, maxSupported));
    }

    public void registerItem(ItemStack stack, int maxSupported) {
        if (stack != null) {
            this.supportedMax.put(stack, maxSupported);
        }
    }

    public void addCheckedInformation(ItemStack stack, World world, List<String> lines, ITooltipFlag advancedTooltips) {}

}
