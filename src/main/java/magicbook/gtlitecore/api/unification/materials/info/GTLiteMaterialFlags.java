package magicbook.gtlitecore.api.unification.materials.info;

import gregtech.api.unification.material.info.MaterialFlag;
import gregtech.api.unification.material.info.MaterialFlags;
import gregtech.api.unification.material.properties.PropertyKey;

/**
 * Material Flags
 *
 * @author Magic_Sweepy
 *
 * <p>
 *     Material Flag class of gtlitecore, like {@link MaterialFlags}.
 *     Please see related classes: {@link GTLiteOrePrefix},
 *     and {@link GTLiteMaterialIconSet}, etc.
 * </p>
 *
 * @since 2.8.7-beta
 */
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

    public static final MaterialFlag GENERATE_NANOTUBE = new MaterialFlag.Builder("generate_nanotube")
            .build();

    public static final MaterialFlag GENERATE_NANOSENSOR = new MaterialFlag.Builder("generate_nanosensor")
            .build();

    /** @deprecated **/
    @Deprecated
    public static final MaterialFlag GENERATE_SINGULARITY = new MaterialFlag.Builder("generate_singularity")
            .build();

}
