package magicbook.gtlitecore.integration.appliedenergistics2.features;

import org.jetbrains.annotations.Nullable;

public enum AE2UpgradeFeatures implements IAE2SubFeature {

    //  Please register Upgrade Features here like `ITEM_NAME("mixin_file_name", "item descriptions.")`,
    //  for mixin file name, please use `upgrades.item_name` (for uniformity).
    ;

    private final String mixins;
    private final String description;
    private boolean enabled;

    AE2UpgradeFeatures(String mixins, String description) {
        this.mixins = mixins;
        this.description = description;
    }

    @Nullable
    @Override
    public String getMixins() {
        return this.mixins;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
