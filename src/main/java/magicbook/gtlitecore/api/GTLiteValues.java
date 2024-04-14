package magicbook.gtlitecore.api;

import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Material;

@SuppressWarnings("unused")
public class GTLiteValues {

    /////////////////////////
    //  Internal Mod Info  //
    /////////////////////////

    /**
     * This modid is same as MODID in {@link magicbook.gtlitecore.GTLiteCore},
     * but please use it in internal interaction situation (e.g. {@link magicbook.gtlitecore.common.covers.GTLiteCoverBehavior}).
     */
    public static final String MODID = "gtlitecore";

    public static final String MODNAME = "Gregicality Science";

    public static final String VERSION = "0.0.1-alpha";

    //////////////////////////
    //  Integration Mod ID  //
    //////////////////////////

    public static final String MODID_GT = "gregtech";

    public static final String MODID_GCYM = "gcym";

    public static final String MODID_GTFO = "gregtechfoodoption";

    public static final String MODID_AE2 = "appliedenergistics2";

    public static final String MODID_XU2 = "extrautils2";

    public static final String MODID_EIO = "enderio";

    public static final String MODID_TOP = "theoneprobe";

    ////////////////////
    //  Modpack Info  //
    ////////////////////

    public static final String MODPACK_NAME = "GregTech Lite";

    public static final String MODPACK_VERSION = "0.1.0-alpha";

    /**
     * Modpack Name Getter.
     *
     * @return  Modpack Name.
     */
    public static String getModpackName() {
        return MODPACK_NAME;
    }

    /**
     * Modpack Version Getter.
     *
     * @param previewVersion  Subversion of Preview.
     * @param isPreview       Check if modpack version is preview version.
     * @return                Return modpack version like 'GregTech Lite-0.1.0-alpha',
     *                        if used {@code isPreview}, then like 'GregTech Lite-0.1.0-alpha-preview-1'.
     */
    public static String getModpackVersion(int previewVersion,
                                           boolean isPreview) {
        if (isPreview) {
            return MODPACK_VERSION + "-preview-" + previewVersion;
        } else {
            return MODPACK_VERSION;
        }
    }

    ///////////////////////////////////
    //  Other Array/Value Utilities  //
    ///////////////////////////////////

    public static final Material[] tierList = {
            MarkerMaterials.Tier.ULV,
            MarkerMaterials.Tier.LV,
            MarkerMaterials.Tier.MV,
            MarkerMaterials.Tier.HV,
            MarkerMaterials.Tier.EV,
            MarkerMaterials.Tier.IV,
            MarkerMaterials.Tier.LuV,
            MarkerMaterials.Tier.ZPM,
            MarkerMaterials.Tier.UV,
            MarkerMaterials.Tier.UHV,
            MarkerMaterials.Tier.UEV,
            MarkerMaterials.Tier.UIV,
            MarkerMaterials.Tier.UXV,
            MarkerMaterials.Tier.OpV,
            MarkerMaterials.Tier.MAX
    };

    public static final Material[] colorList = {
            MarkerMaterials.Color.White,
            MarkerMaterials.Color.Orange,
            MarkerMaterials.Color.Magenta,
            MarkerMaterials.Color.LightBlue,
            MarkerMaterials.Color.Yellow,
            MarkerMaterials.Color.Lime,
            MarkerMaterials.Color.Pink,
            MarkerMaterials.Color.Gray,
            MarkerMaterials.Color.LightGray,
            MarkerMaterials.Color.Cyan,
            MarkerMaterials.Color.Purple,
            MarkerMaterials.Color.Blue,
            MarkerMaterials.Color.Brown,
            MarkerMaterials.Color.Green,
            MarkerMaterials.Color.Red,
            MarkerMaterials.Color.Black
    };
}
