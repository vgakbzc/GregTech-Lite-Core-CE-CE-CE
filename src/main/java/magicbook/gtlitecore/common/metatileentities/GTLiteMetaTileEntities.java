package magicbook.gtlitecore.common.metatileentities;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.SimpleGeneratorMetaTileEntity;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import magicbook.gtlitecore.api.metatileentity.single.SimpleSteamMetaTileEntity;
import magicbook.gtlitecore.api.metatileentity.single.SteamProgressIndicator;
import magicbook.gtlitecore.api.metatileentity.single.SteamProgressIndicators;
import magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps;
import magicbook.gtlitecore.api.utils.GTLiteUtils;
import magicbook.gtlitecore.client.GTLiteTextures;
import magicbook.gtlitecore.common.metatileentities.multi.electric.*;
import magicbook.gtlitecore.common.metatileentities.multi.part.MetaTileEntityGrindBallHatch;

import static gregtech.api.GTValues.*;
import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;
import static gregtech.common.metatileentities.MetaTileEntities.registerSimpleMetaTileEntity;
import static magicbook.gtlitecore.api.utils.GTLiteUtils.gtliteId;

public class GTLiteMetaTileEntities {

    //  Multiblock Part range: 14000-14999
    public static MetaTileEntityGrindBallHatch MULTIPART_GRIND_BALL_HATCH;

    //  Single Machine range: 15000-16000
    public static SimpleMachineMetaTileEntity[] CHEMICAL_DRYER = new SimpleMachineMetaTileEntity[V.length - 1];
    public static SimpleSteamMetaTileEntity[] STEAM_VACUUM_CHAMBER = new SimpleSteamMetaTileEntity[2];
    public static SimpleMachineMetaTileEntity[] VACUUM_CHAMBER = new SimpleMachineMetaTileEntity[V.length - 1];
    public static final SimpleGeneratorMetaTileEntity[] NAQUADAH_REACTOR = new SimpleGeneratorMetaTileEntity[4];

    //  Multiblock Machine range: 16001-20000
    public static MetaTileEntityIndustrialDrillingReg INDUSTRIAL_DRILLING_REG;
    public static MetaTileEntityCatalyticReformer CATALYTIC_REFORMER;
    public static MetaTileEntitySonicator SONICATOR;
    public static MetaTileEntityHydraulicFracker HYDRAULIC_FRACKER;
    public static MetaTileEntityNanoscaleFabricator NANOSCALE_FABRICATOR;
    public static MetaTileEntityIndustrialRoaster INDUSTRIAL_ROASTER;
    public static MetaTileEntityCrystallizationCrucible CRYSTALLIZATION_CRUCIBLE;
    public static MetaTileEntityCVDUnit CVD_UNIT;
    public static MetaTileEntityPlasmaCVDUnit PLASMA_CVD_UNIT;
    public static MetaTileEntityBurnerReactor BURNER_REACTOR;
    public static MetaTileEntityCryogenicReactor CRYOGENIC_REACTOR;

    public static MetaTileEntityIsaMill ISA_MILL;

    /**
     * @param machines Pre-init Machine name, e.g. public static SimpleSteamMetaTileEntity[] STEAM_VACUUM_CHAMBER = new SimpleSteamMetaTileEntity[2];
     * @param startId Machine id range;
     * @param name Machine name;
     * @param recipeMap Machine recipemap;
     * @param progressIndicator Progress bar;
     * @param texture Textures;
     * @param isBricked Is Bricked textures or not.
     */
    private static void registerSimpleSteamMetaTileEntity(SimpleSteamMetaTileEntity[] machines,
                                                          int startId,
                                                          String name,
                                                          RecipeMap<?> recipeMap,
                                                          SteamProgressIndicator progressIndicator,
                                                          ICubeRenderer texture,
                                                          boolean isBricked) {
        machines[0] = registerMetaTileEntity(startId, new SimpleSteamMetaTileEntity(gtliteId(String.format("%s.bronze", name)), recipeMap, progressIndicator, texture, isBricked, false));
        machines[1] = registerMetaTileEntity(startId + 1, new SimpleSteamMetaTileEntity(gtliteId(String.format("%s.steel", name)), recipeMap, progressIndicator, texture, isBricked, true));
    }

    //  Multiblock Part range: 14000-14999
    private static <F extends MetaTileEntity> F registerPartMetaTileEntity(int id, F mte) {
        if (id > 1000) return null;
        return registerMetaTileEntity(id + 13999, mte);
    }

    //  Multiblock Machine range: 16001-20000
    private static <T extends MultiblockControllerBase> T registerMultiMetaTileEntity(int id, T mte) {
        return registerMetaTileEntity(id + 16000, mte);
    }

    public static void init() {

        //  Multiblock Part range: 14000-14999
        MULTIPART_GRIND_BALL_HATCH = registerPartMetaTileEntity(1, new MetaTileEntityGrindBallHatch(gtliteId("grind_ball_hatch")));

        //  Single Machine range: 15000-16000
        registerSimpleMetaTileEntity(CHEMICAL_DRYER, 15000, "chemical_dryer", GTLiteRecipeMaps.CHEMICAL_DRYER_RECIPES, GTLiteTextures.CHEMICAL_DRYER_OVERLAY, true, GTLiteUtils::gtliteId, GTUtility.hvCappedTankSizeFunction);
        registerSimpleSteamMetaTileEntity(STEAM_VACUUM_CHAMBER, 15013, "vacuum_chamber", GTLiteRecipeMaps.VACUUM_CHAMBER_RECIPES, SteamProgressIndicators.COMPRESS, Textures.GAS_COLLECTOR_OVERLAY, false);
        registerSimpleMetaTileEntity(VACUUM_CHAMBER, 15015, "vacuum_chamber", GTLiteRecipeMaps.VACUUM_CHAMBER_RECIPES, Textures.GAS_COLLECTOR_OVERLAY, true, GTLiteUtils::gtliteId, GTUtility.hvCappedTankSizeFunction);
        NAQUADAH_REACTOR[0] = registerMetaTileEntity(15028, new SimpleGeneratorMetaTileEntity(gtliteId("naquadah_reactor.iv"), GTLiteRecipeMaps.NAQUADAH_REACTOR_RECIPES, GTLiteTextures.NAQUADAH_REACTOR_OVERLAY, 5, GTUtility.genericGeneratorTankSizeFunction));
        NAQUADAH_REACTOR[1] = registerMetaTileEntity(15029, new SimpleGeneratorMetaTileEntity(gtliteId("naquadah_reactor.luv"), GTLiteRecipeMaps.NAQUADAH_REACTOR_RECIPES, GTLiteTextures.NAQUADAH_REACTOR_OVERLAY, 6, GTUtility.genericGeneratorTankSizeFunction));
        NAQUADAH_REACTOR[2] = registerMetaTileEntity(15030, new SimpleGeneratorMetaTileEntity(gtliteId("naquadah_reactor.zpm"), GTLiteRecipeMaps.NAQUADAH_REACTOR_RECIPES, GTLiteTextures.NAQUADAH_REACTOR_OVERLAY, 7, GTUtility.genericGeneratorTankSizeFunction));
        NAQUADAH_REACTOR[3] = registerMetaTileEntity(15031, new SimpleGeneratorMetaTileEntity(gtliteId("naquadah_reactor.uv"), GTLiteRecipeMaps.NAQUADAH_REACTOR_RECIPES, GTLiteTextures.NAQUADAH_REACTOR_OVERLAY, 8, GTUtility.genericGeneratorTankSizeFunction));

        //  Multiblock Machine range: 16001-20000
        INDUSTRIAL_DRILLING_REG = registerMultiMetaTileEntity(1, new MetaTileEntityIndustrialDrillingReg(gtliteId("industrial_drilling_reg")));
        CATALYTIC_REFORMER = registerMultiMetaTileEntity(2, new MetaTileEntityCatalyticReformer(gtliteId("catalytic_reformer")));
        SONICATOR = registerMultiMetaTileEntity(3, new MetaTileEntitySonicator(gtliteId("sonicator")));
        HYDRAULIC_FRACKER = registerMultiMetaTileEntity(4, new MetaTileEntityHydraulicFracker(gtliteId("hydraulic_fracker"), ZPM));
        NANOSCALE_FABRICATOR = registerMultiMetaTileEntity(5, new MetaTileEntityNanoscaleFabricator(gtliteId("nanoscale_fabricator")));
        INDUSTRIAL_ROASTER = registerMultiMetaTileEntity(6, new MetaTileEntityIndustrialRoaster(gtliteId("industrial_roaster")));
        CRYSTALLIZATION_CRUCIBLE = registerMultiMetaTileEntity(7, new MetaTileEntityCrystallizationCrucible(gtliteId("crystallization_crucible")));
        CVD_UNIT = registerMultiMetaTileEntity(8, new MetaTileEntityCVDUnit(gtliteId("cvd_unit")));
        PLASMA_CVD_UNIT = registerMultiMetaTileEntity(9, new MetaTileEntityPlasmaCVDUnit(gtliteId("plasma_cvd_unit")));
        //  LASER_CVD_UNIT 10
        BURNER_REACTOR = registerMultiMetaTileEntity(11, new MetaTileEntityBurnerReactor(gtliteId("burner_reactor")));
        CRYOGENIC_REACTOR = registerMultiMetaTileEntity(12, new MetaTileEntityCryogenicReactor(gtliteId("cryogenic_reactor")));
        //  LARGE_NAQUADAH_REACTOR 13
        //  HYPER REACTOR Mk1 14
        //  HYPER REACTOR Mk2 15
        //  HYPER REACTOR Mk3 16
        ISA_MILL = registerMultiMetaTileEntity(17, new MetaTileEntityIsaMill(gtliteId("isa_mill")));
    }
}
