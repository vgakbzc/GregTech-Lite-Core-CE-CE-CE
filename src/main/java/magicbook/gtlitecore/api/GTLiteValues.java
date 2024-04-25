package magicbook.gtlitecore.api;

import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Material;

@SuppressWarnings("unused")
public class GTLiteValues {

    /**
     * Special Voltage for some recipes needs integer based energy consumed.
     */
    public static final int[] VZ = new int[] { 1, 30, 100, 500, 2000, 8000, 30000, 100000, 500000, 2000000, 8000000, 30000000, 100000000, 500000000, 2000000000 };

    /**
     * Tier list for {@link gregtech.api.unification.ore.OrePrefix#circuit}, used in some recipes.
     */
    public static final Material[] tierList = { MarkerMaterials.Tier.ULV, MarkerMaterials.Tier.LV, MarkerMaterials.Tier.MV, MarkerMaterials.Tier.HV, MarkerMaterials.Tier.EV, MarkerMaterials.Tier.IV, MarkerMaterials.Tier.LuV, MarkerMaterials.Tier.ZPM, MarkerMaterials.Tier.UV, MarkerMaterials.Tier.UHV, MarkerMaterials.Tier.UEV, MarkerMaterials.Tier.UIV, MarkerMaterials.Tier.UXV, MarkerMaterials.Tier.OpV, MarkerMaterials.Tier.MAX };

    /**
     * Color list for recipes (used in some special situation like {@link gregtech.api.unification.ore.OrePrefix#lens}).
     */
    public static final Material[] colorList = { MarkerMaterials.Color.White, MarkerMaterials.Color.Orange, MarkerMaterials.Color.Magenta, MarkerMaterials.Color.LightBlue, MarkerMaterials.Color.Yellow, MarkerMaterials.Color.Lime, MarkerMaterials.Color.Pink, MarkerMaterials.Color.Gray, MarkerMaterials.Color.LightGray, MarkerMaterials.Color.Cyan, MarkerMaterials.Color.Purple, MarkerMaterials.Color.Blue, MarkerMaterials.Color.Brown, MarkerMaterials.Color.Green, MarkerMaterials.Color.Red, MarkerMaterials.Color.Black };

    /**
     * Used for recipes, please see {@link gregtech.api.recipes.RecipeBuilder#duration(int)},
     * because 1 second = 20 tick (in game), so we can use this to add 1 second.
     */
    public static final int SECOND = 20;

    /**
     * Used for recipes, please see {@link gregtech.api.recipes.RecipeBuilder#duration(int)},
     * because 1 minute = 60 second = 1200 tick (in game), so we can use this to add 1 minute.
     */
    public static final int MINUTE = 60 * SECOND;

    /**
     * Used for recipes, please see {@link gregtech.api.recipes.RecipeBuilder#duration(int)},
     * because 1 hour = 60 minute = 3600 second, so we can use this to add 1 hour.
     */
    public static final int HOUR = 60 * MINUTE;

    /**
     * Used for recipes, please see {@link gregtech.api.recipes.RecipeBuilder#duration(int)},
     * just 1/2 {@link #HOUR} (means 30 minute and 1800 second).
     */
    public static final int HALF_HOUR = HOUR / 2;

    /**
     * Used for recipes, please see {@link gregtech.api.recipes.RecipeBuilder#duration(int)},
     * just 1/4 {@link #HOUR} and 1/2 {@link #HALF_HOUR} (means 15 minute and 900 second).
     */
    public static final int QUAT_HOUR = HOUR / 4;

    /**
     * This modid is same as {@link magicbook.gtlitecore.GTLiteCore#MODID},
     * but please use it in internal interaction situation, such as:
     *  {@link magicbook.gtlitecore.common.covers.GTLiteCoverBehavior}
     * or other same situations.
     */
    public static final String MODID = "gtlitecore";

    /**
     * This mod name is same as {@link magicbook.gtlitecore.GTLiteCore#NAME}.
     */
    public static final String NAME = "Gregicality Science";

    /**
     * This mod version is same as {@link magicbook.gtlitecore.GTLiteCore#VERSION}.
     */
    public static final String VERSION = "0.0.1-alpha";


    public static final String MODID_GT = "gregtech";

    public static final String MODID_GCYM = "gcym";

    public static final String MODID_GTFO = "gregtechfoodoption";

    public static final String MODID_AE2 = "appliedenergistics2";

    public static final String MODID_XU2 = "extrautils2";

    public static final String MODID_EIO = "enderio";

    public static final String MODID_TOP = "theoneprobe";

    /**
     * Internal class of modpack info.
     * TODO add mod check methods.
     */
    public static class ModpackInfo {

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
    }

    private GTLiteValues() {}
}
