package magicbook.gtlitecore.api.unification.materials.helper;

public class MaterialHelperManager {

    public static void init() {
        PeriodicMaterialHelper.register();
        RadioactiveMaterialHelper.register();
    }
}
