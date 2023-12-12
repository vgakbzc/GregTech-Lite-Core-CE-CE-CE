package magicbook.gtlitecore.api.unification.materials.info;

import gregtech.api.unification.material.info.MaterialFlag;
import gregtech.api.unification.material.info.MaterialFlags;
import gregtech.api.unification.material.properties.PropertyKey;

public class GTLiteMaterialFlags {

    public static final MaterialFlag GENERATE_MILLED = new MaterialFlag.Builder("generate_milled")
            .requireProps(PropertyKey.ORE)
            .build();
    public static final MaterialFlag DISABLE_CRYSTALLIZATION = new MaterialFlag.Builder("no_crystallization")
            .requireFlags(MaterialFlags.CRYSTALLIZABLE)
            .requireProps(PropertyKey.GEM)
            .build();
    public static final MaterialFlag GENERATE_BOULE = new MaterialFlag.Builder("generate_boule")
            .requireProps(PropertyKey.GEM)
            .build();

    public static final MaterialFlag GENERATE_SWARM = new MaterialFlag.Builder("generate_swarm")
            .build();
}
