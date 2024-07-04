package magicbook.gtlitecore.integration.appliedenergistics2.materials;

import appeng.core.features.IStackSrc;
import it.unimi.dsi.fastutil.ints.Int2ObjectLinkedOpenHashMap;
import magicbook.gtlitecore.api.utils.Mods;
import magicbook.gtlitecore.integration.appliedenergistics2.features.AE2Features;
import magicbook.gtlitecore.integration.appliedenergistics2.models.IModelProvider;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Arrays;

import static magicbook.gtlitecore.api.utils.GTLiteUtility.gtliteId;

public enum AE2MaterialType implements IModelProvider {

    //  Please register your Material here like `MATERIAL_NAME("material_id", AE2Features.MATERIAL_FEATURE)`.
    ;

    private static Int2ObjectLinkedOpenHashMap<AE2MaterialType> cachedValues;
    private final String id;
    private final AE2Features features;
    private final String translationKey;
    private final ModelResourceLocation model;
    private boolean isRegistered;
    private int damageValue = this.ordinal();
    private Item itemInstance;
    private IStackSrc stackSrc;

    AE2MaterialType(String id, AE2Features features) {
        this.id = id;
        this.features = features;
        this.translationKey = "item." + Mods.GregTechLiteCore.getID() + ".material." + id;
        this.model = new ModelResourceLocation(gtliteId("material/" + id), "inventory");
    }

    public static Int2ObjectLinkedOpenHashMap<AE2MaterialType> getCachedValues() {
        if (cachedValues == null) {
            cachedValues = new Int2ObjectLinkedOpenHashMap<>();
            Arrays.stream(values()).forEach(materialType -> cachedValues.put(materialType.ordinal(), materialType));
        }
        return cachedValues;
    }

    public String getId() {
        return this.id;
    }

    public AE2Features getFeatures() {
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

    @Override
    public boolean isEnabled() {
        return this.features.isEnabled();
    }

    public void markReady() {
        this.isRegistered = true;
    }

    public int getDamageValue() {
        return this.damageValue;
    }

    void setDamageValue(final int damageValue) {
        this.damageValue = damageValue;
    }

    public Item getItemInstance() {
        return this.itemInstance;
    }

    public void setItemInstance(final Item itemInstance) {
        this.itemInstance = itemInstance;
    }

    public AE2MaterialStackSrc getStackSrc() {
        return (AE2MaterialStackSrc) this.stackSrc;
    }

    public void setStackSrc(final AE2MaterialStackSrc stackSrc) {
        this.stackSrc = stackSrc;
    }

    @Override
    public ModelResourceLocation getModel() {
        return this.model;
    }

}
