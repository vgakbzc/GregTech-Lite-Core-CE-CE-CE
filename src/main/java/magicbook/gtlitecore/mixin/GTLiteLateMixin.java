package magicbook.gtlitecore.mixin;

import com.google.common.collect.ImmutableList;
import magicbook.gtlitecore.integration.appliedenergistics2.features.AE2Features;
import zone.rong.mixinbooter.ILateMixinLoader;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class GTLiteLateMixin implements ILateMixinLoader {

    @Override
    public List<String> getMixinConfigs() {
        var mixins = new ArrayList<String>();
        //  Basic Mod Late Mixin config.
        mixins.add("mixins.gtlitecore_late.json");
        //  AE2 Integration Features Mixin.
        for (var featureEntry : AE2Features.values()) {
            //  If Feature is disbaled, then continue.
            if (!featureEntry.isEnabled())
                continue;
            //  If Featrue has correspondence Mixin, then add it to Late Mixin config.
            var featureMixins = featureEntry.getMixins();
            if (featureMixins != null) {
                for (var featureMixin : featureMixins) {
                    //  File format: `mixins.gtlitecore.ae2_integration.featureMixinName.json`.
                    mixins.add(String.format("mixins.gtlitecore.ae2_integration.%s.json", featureMixin));
                }
            }
            //  Check Sub Features and do same step.
            var subFeatures = featureEntry.getSubFeatures();
            if (subFeatures != null) {
                for (var subFeature : subFeatures) {
                    if (!subFeature.isEnabled())
                        continue;
                    var subFeatureMixins = subFeature.getMixins();
                    if (subFeatureMixins != null) {
                        mixins.add(String.format("mixins.gtlitecore.ae2_integration.%s.json", subFeatureMixins));
                    }
                }
            }
        }
        return ImmutableList.copyOf(mixins);
    }

}
