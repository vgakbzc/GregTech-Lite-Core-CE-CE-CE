package magicbook.gtlitecore.integration.appliedenergistics2.features;

import org.jetbrains.annotations.Nullable;
import java.util.EnumSet;

public enum AE2Features implements IAE2Feature {

    //  Please use `ITEM_NAME(EnumSet.allOf(itemName.class))` to register features.
    ;

    //  Mixin file path, in AE2 Integration, we use many sub files for Mixin.
    private String[] mixins;
    //  Sub Features.
    private EnumSet<? extends IAE2SubFeature> subFeatures = null;

    private boolean enabled;

    AE2Features() {}

    AE2Features(String mixins) {
        this();
        this.mixins = new String[]{ mixins };
    }

    AE2Features(EnumSet<? extends IAE2SubFeature> subFeatures) {
        this.subFeatures = subFeatures;
    }

    AE2Features(EnumSet<? extends IAE2SubFeature> subFeatures, String mixins) {
        this(subFeatures);
        this.mixins = new String[]{ mixins };
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Nullable
    public EnumSet<? extends IAE2SubFeature> getSubFeatures() {
        return this.subFeatures;
    }

    @Nullable
    public String[] getMixins() {
        return this.mixins;
    }
}
