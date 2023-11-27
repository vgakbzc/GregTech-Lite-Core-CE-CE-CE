package magicbook.gtlitecore.api.unification;

import gregtech.api.unification.material.Material;
import magicbook.gtlitecore.api.unification.materials.GTLiteElementMaterials;
import magicbook.gtlitecore.api.unification.materials.GTLiteUnknownCompositionMaterials;

public class GTLiteMaterials {
    //  Element Materials (Range: 10000-11000)
    public static Material Orichalcum;
    public static Material Vibranium;
    public static Material Adamantium;
    public static Material Taranium;
    public static Material Mithril;

    //  Unknown Composition Materials (Range: 18000-20000)
    public static Material FracuringFluid;

    public static void init() {
        GTLiteElementMaterials.register();
        GTLiteUnknownCompositionMaterials.register();
    }
}
