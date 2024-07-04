package magicbook.gtlitecore.integration.appliedenergistics2.parts;

import appeng.api.parts.IPart;
import appeng.core.localization.GuiText;
import appeng.util.Platform;
import co.neeve.nae2.common.registration.registry.helpers.PartModelsHelper;
import com.google.common.collect.ImmutableList;
import it.unimi.dsi.fastutil.ints.Int2ObjectLinkedOpenHashMap;
import magicbook.gtlitecore.integration.appliedenergistics2.features.AE2Features;
import magicbook.gtlitecore.integration.appliedenergistics2.features.IAE2Feature;
import magicbook.gtlitecore.integration.appliedenergistics2.models.IEnabled;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.lang.reflect.Constructor;
import java.util.*;

import static magicbook.gtlitecore.api.utils.GTLiteUtility.gtliteId;

public enum AE2PartType implements IEnabled {

    //  Please register your part type here like `PART_NAME("part_name", PartName.class, AE2Features.PART_NAME)`.
    ;

    private static Int2ObjectLinkedOpenHashMap<AE2PartType> cachedValues;
    private final String id;
    private final Class<? extends IPart> clazz;
    private final int baseDamage;
    private final boolean enabled;
    private final Set<ResourceLocation> models;
    private Constructor<? extends IPart> constructor;
    private GuiText extraName;
    private List<ModelResourceLocation> itemModels;

    AE2PartType(String id, Class<? extends IPart> clazz, IAE2Feature features) {
        this.id = id;
        this.clazz = clazz;
        this.baseDamage = this.ordinal();
        this.enabled = features.isEnabled();
        if (this.enabled) {
            //  Only load models if the part is enabled, otherwise we also run into class-loading issues while scanning for annotations.
            if (Platform.isClientInstall())
                this.itemModels = this.createItemModels(id);
            if (clazz != null)
                this.models = new HashSet<>(PartModelsHelper.createModels(clazz));
            else
                this.models = Collections.emptySet();
        } else {
            if (Platform.isClientInstall())
                this.itemModels = Collections.emptyList();
            this.models = Collections.emptySet();
        }
    }

    AE2PartType(String id, Class<? extends IPart> clazz, AE2Features features, GuiText extraName) {
        this(id, clazz, features);
        this.extraName = extraName;
    }

    public static Int2ObjectLinkedOpenHashMap<AE2PartType> getCachedValues() {
        if (cachedValues == null) {
            cachedValues = new Int2ObjectLinkedOpenHashMap<>();
            Arrays.stream(values()).forEach(partType -> cachedValues.put(partType.ordinal(), partType));
        }
        return cachedValues;
    }

    @SideOnly(Side.CLIENT)
    private static ModelResourceLocation modelFromBaseName(String baseName) {
        return new ModelResourceLocation(gtliteId("part/" + baseName), "inventory");
    }

    @SideOnly(Side.CLIENT)
    private List<ModelResourceLocation> createItemModels(String baseName) {
        return ImmutableList.of(modelFromBaseName(baseName));
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    public int getBaseDamage() {
        return this.baseDamage;
    }

    public Class<? extends IPart> getPart() {
        return this.clazz;
    }

    public String getUnlocalizedName() {
        return "item.gtlitecore.part." + this.name().toLowerCase();
    }

    public GuiText getExtraName() {
        return this.extraName;
    }

    public Constructor<? extends IPart> getConstructor() {
        return this.constructor;
    }

    public void setConstructor(final Constructor<? extends IPart> constructor) {
        this.constructor = constructor;
    }

    @SideOnly(Side.CLIENT)
    public List<ModelResourceLocation> getItemModels() {
        return this.itemModels;
    }

    public Set<ResourceLocation> getModels() {
        return this.models;
    }

    public String getId() {
        return this.id;
    }

    public void addCheckedInformation(ItemStack stack, World world, List<String> lines, ITooltipFlag advancedTooltips) {}
}
