package magicbook.gtlitecore.integration.appliedenergistics2.features;

import javax.annotation.Nullable;

public interface IAE2SubFeature extends IAE2Feature {

    String name();

    @Nullable
    String getDescription();

    void setEnabled(boolean enabled);

    @Nullable
    String getMixins();
}
