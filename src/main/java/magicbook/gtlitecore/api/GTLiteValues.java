package magicbook.gtlitecore.api;

import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.ore.OrePrefix;
import magicbook.gtlitecore.GTLiteCore;
import net.minecraftforge.fml.common.Loader;

import java.util.function.Function;

@SuppressWarnings("unused")
public class GTLiteValues {

    /**
     * Special Voltage for some recipes needs integer based energy consumed.
     */
    public static final int[] VZ = new int[] { 1, 30, 100, 500, 2000, 8000, 30000, 100000, 500000, 2000000, 8000000, 30000000, 100000000, 500000000, 2000000000 };

    /**
     * Tier list for {@link OrePrefix#circuit}, used in some recipes.
     */
    public static final Material[] tierList = { MarkerMaterials.Tier.ULV, MarkerMaterials.Tier.LV, MarkerMaterials.Tier.MV, MarkerMaterials.Tier.HV, MarkerMaterials.Tier.EV, MarkerMaterials.Tier.IV, MarkerMaterials.Tier.LuV, MarkerMaterials.Tier.ZPM, MarkerMaterials.Tier.UV, MarkerMaterials.Tier.UHV, MarkerMaterials.Tier.UEV, MarkerMaterials.Tier.UIV, MarkerMaterials.Tier.UXV, MarkerMaterials.Tier.OpV, MarkerMaterials.Tier.MAX };

    /**
     * Color list for recipes (used in some special situation like {@link OrePrefix#lens}).
     */
    public static final Material[] colorList = { MarkerMaterials.Color.White, MarkerMaterials.Color.Orange, MarkerMaterials.Color.Magenta, MarkerMaterials.Color.LightBlue, MarkerMaterials.Color.Yellow, MarkerMaterials.Color.Lime, MarkerMaterials.Color.Pink, MarkerMaterials.Color.Gray, MarkerMaterials.Color.LightGray, MarkerMaterials.Color.Cyan, MarkerMaterials.Color.Purple, MarkerMaterials.Color.Blue, MarkerMaterials.Color.Brown, MarkerMaterials.Color.Green, MarkerMaterials.Color.Red, MarkerMaterials.Color.Black };

    /**
     * Used for recipes, please see {@link RecipeBuilder#duration(int)},
     * because 1 second = 20 tick (in game), so we can use this to add 1 second.
     */
    public static final int SECOND = 20;

    /**
     * Used for recipes, please see {@link RecipeBuilder#duration(int)},
     * because 1 minute = 60 second = 1200 tick (in game), so we can use this to add 1 minute.
     */
    public static final int MINUTE = 60 * SECOND;

    /**
     * Used for recipes, please see {@link RecipeBuilder#duration(int)},
     * because 1 hour = 60 minute = 3600 second, so we can use this to add 1 hour.
     */
    public static final int HOUR = 60 * MINUTE;

    /**
     * Used for recipes, please see {@link RecipeBuilder#duration(int)},
     * just 1/2 {@link #HOUR} (means 30 minute and 1800 second).
     */
    public static final int HALF_HOUR = HOUR / 2;

    /**
     * Used for recipes, please see {@link RecipeBuilder#duration(int)},
     * just 1/4 {@link #HOUR} and 1/2 {@link #HALF_HOUR} (means 15 minute and 900 second).
     */
    public static final int QUAT_HOUR = HOUR / 4;

    /**
     * This modid is same as {@link GTLiteCore#MODID}.
     * Hint: this parameter is internal, we use it on class in {@code gtlitecore}.
     * Do not use this parameter in external situation (please use the first).
     */
    public static final String MODID = "gtlitecore";

    /**
     * This mod name is same as {@link GTLiteCore#NAME}.
     * Hint: this parameter is internal, we use it on class in {@code gtlitecore}.
     * Do not use this parameter in external situation (please use the first).
     */
    public static final String NAME = "Gregicality Science";

    /**
     * This mod version is same as {@link GTLiteCore#VERSION}.
     * Hint: this parameter is internal, we use it on class in {@code gtlitecore}.
     * Do not use this parameter in external situation (please use the first).
     */
    public static final String VERSION = "0.0.1-alpha";

    /**
     * Integration {@code modid}, please see: {@code integration/gregtech}.
     */
    public static final String MODID_GT = "gregtech";

    /**
     * Integration {@code modid}, please see: {@code integration/gcym}.
     */
    public static final String MODID_GCYM = "gcym";

    /**
     * Integration {@code modid}, please see: {@code integration/gregtechfoodoption}.
     */
    public static final String MODID_GTFO = "gregtechfoodoption";

    /**
     * Integration {@code modid}.
     */
    public static final String MODID_AE2 = "appliedenergistics2";

    /**
     * Integration {@code modid}.
     */
    public static final String MODID_XU2 = "extrautils2";

    /**
     * Integration {@code modid}.
     */
    public static final String MODID_EIO = "enderio";

    /**
     * Integration {@code modid}, please see: {@code integration/theoneprobe}.
     */
    public static final String MODID_TOP = "theoneprobe";

    /**
     * Modpack Info class
     *
     * <p>
     *     This class is a public class to descript Modpack's Info,
     *     used to add integration descriptions and other external check.
     * </p>
     *
     */
    public static class ModpackInfo {

        public static final String MODPACK_NAME = "GregTech Lite";
        public static final String MODPACK_NAME_SHORT = "gtlite";
        public static final String MODPACK_VERSION = "0.1.0-alpha";

        public static final String ACTUALLY_ADDITIONS = "actuallyadditions";
        public static final String APPLIED_ENERGISTICS2 = "appliedenergistics2";
        public static final String AE2_FLUID_CRAFTING = "ae2fc";
        public static final String AE2_STUFF = "ae2stuff";
        public static final String ARCHITECTURE_CRAFT = "architecturecraft";
        public static final String BETTER_P2P = "betterp2p";
        public static final String BETTER_QUESTING = "betterquesting";
        public static final String BUILDING_GADGETS = "buildinggadgets";
        public static final String CHEST_TRANSPORTER = "chesttransporter";
        public static final String CHISEL = "chisel";
        public static final String CRAFTING_STATION = "craftingstation";
        public static final String CONNECTED_TEXTURES_MOD = "ctm";
        public static final String CRAFT_TWEAKER = "crafttweaker";
        public static final String ELEVATOR = "elevator";
        public static final String ENDER_CORE = "endercore";
        public static final String ENDER_IO = "enderio";
        public static final String ENDER_IO_ENDERGY = "enderioendergy";
        public static final String ENDER_IO_MACHINES = "enderiomachines";
        public static final String ENDER_IO_CONDUITS = "enderioconduits";
        public static final String ENDER_IO_AE2_CONDUITS = "enderioconduitsappliedenergistics";
        public static final String ENDER_STORAGE = "enderstorage";
        public static final String ENDER_UTILITIES = "enderutilities";
        public static final String EXTENDED_AE = "extendedae";
        public static final String EXTRA_UTILS = "extrautils2";
        public static final String FLUID_DRAWERS = "fluiddrawers";
        public static final String FUTURE_MC = "futuremc";
        public static final String GREGTECH = "gregtech";
        public static final String GCYM = "gcym";
        public static final String GCYS = "gtlitecore";
        public static final String GREGTECH_FOOD_OPTION = "gregtechfoodoption";
        public static final String GREGTECH_DRAWERS = "gregtechdrawers";
        public static final String IRON_CHEST = "ironchest";
        public static final String LAZY_AE2 = "lazyae2";
        public static final String LITTLE_TILES = "littletiles";
        public static final String MOAR_SIGNS = "moarsigns";
        public static final String MORE_FURNACES = "morefurnaces";
        public static final String NAE2 = "nae2";
        public static final String NATURES_COMPASS = "naturescompass";
        public static final String PACKAGED_AUTO = "packagedauto";
        public static final String SIMPLY_BACKPACKS = "simplybackpacks";
        public static final String SNAD = "snad";
        public static final String STORAGE_DRAWERS = "storagedrawers";
        public static final String SUPER_SOUND_MUFFLER = "supersoundmuffler";
        public static final String TOP = "theoneprobe";
        public static final String TOP_ADDONS = "topaddons";
        public static final String TORCH_MASTER = "torchmaster";
        public static final String XTONES = "xtones";

        public static String getModpackName() {
            return MODPACK_NAME;
        }

        public static String getModpackShortName() {
            return MODPACK_NAME_SHORT;
        }

        public static String getModpackVersion() {
            return MODPACK_VERSION;
        }

        public static String getModpackVersion(int preview) {
            return MODPACK_VERSION + "-" + preview;
        }

        public static String getModpackNightlyVersion(int nightly) {
            return MODPACK_VERSION + "-" + nightly;
        }

        public static String getModpackNightlyVersion(int preview, int nightly) {
            return MODPACK_VERSION + "-" + preview + "-" + nightly;
        }

        public enum Mods {
            ActuallyAdditions(ACTUALLY_ADDITIONS),
            AppliedEnergistics2(APPLIED_ENERGISTICS2),
            AE2FluidCrafting(AE2_FLUID_CRAFTING),
            AE2Stuff(AE2_STUFF),
            ArchitectureCraft(ARCHITECTURE_CRAFT),
            BetterP2P(BETTER_P2P),
            BetterQuesting(BETTER_QUESTING),
            BuildingGadgets(BUILDING_GADGETS),
            ChestTransporter(CHEST_TRANSPORTER),
            Chisel(CHISEL),
            CraftingStation(CRAFTING_STATION),
            ConnectedTexturesMod(CONNECTED_TEXTURES_MOD),
            CraftTweaker2(CRAFT_TWEAKER),
            Elevator(ELEVATOR),
            EnderCore(ENDER_CORE),
            EnderIO(ENDER_IO),
            EnderIOEndergy(ENDER_IO_ENDERGY),
            EnderIOMachines(ENDER_IO_MACHINES),
            EnderIOConduits(ENDER_IO_CONDUITS),
            EnderIOAE2Conduits(ENDER_IO_AE2_CONDUITS),
            EnderStorage(ENDER_STORAGE),
            EnderUtilities(ENDER_UTILITIES),
            ExtendedAE(EXTENDED_AE),
            ExtraUtilities2(EXTRA_UTILS),
            FluidDrawers(FLUID_DRAWERS),
            FutureMC(FUTURE_MC),
            GregTech(GREGTECH),
            GregicalityMultiblocks(GCYM),
            GregicalityScience(GCYS),
            GregTechFoodOption(GREGTECH_FOOD_OPTION),
            GregTechDrawers(GREGTECH_DRAWERS),
            IronChest(IRON_CHEST),
            LazyAE2(LAZY_AE2),
            LittleTiles(LITTLE_TILES),
            MoarSigns(MOAR_SIGNS),
            MoreFurnaces(MORE_FURNACES),
            NeevesAE2(NAE2),
            NaturesCompass(NATURES_COMPASS),
            PackagedAuto(PACKAGED_AUTO),
            SimplyBackpacks(SIMPLY_BACKPACKS),
            Snad(SNAD),
            StorageDrawers(STORAGE_DRAWERS),
            SuperSoundMuffler(SUPER_SOUND_MUFFLER),
            TheOneProbe(TOP),
            TOPAddons(TOP_ADDONS),
            TorchMaster(TORCH_MASTER),
            Xtones(XTONES);

            private final String ID;
            private final Function<Mods, Boolean> extraCheck;
            private Boolean isModLoaded;

            Mods(String ID) {
                this.ID = ID;
                this.extraCheck = null;
            }

            Mods(String ID, Function<Mods, Boolean> extraCheck) {
                this.ID = ID;
                this.extraCheck = extraCheck;
            }

            /**
             * @return  Check if mod is loaded in Modpack.
             */
            public boolean isModLoaded() {
                if (this.isModLoaded == null) {
                    this.isModLoaded = Loader.isModLoaded(this.ID);
                    if (this.isModLoaded) {
                        if (this.extraCheck != null && !this.extraCheck.apply(this)) {
                            this.isModLoaded = false;
                        }
                    }
                }
                return this.isModLoaded;
            }
        }

    }

    private GTLiteValues() {}
}
