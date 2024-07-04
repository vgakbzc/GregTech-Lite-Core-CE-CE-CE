package magicbook.gtlitecore.common.metatileentities;

import gregicality.multiblocks.common.metatileentities.multiblock.standard.MetaTileEntityLargeMassFabricator;
import gregicality.multiblocks.common.metatileentities.multiblock.standard.MetaTileEntityLargeReplicator;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.SimpleGeneratorMetaTileEntity;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.Materials;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockTurbineCasing;
import gregtech.common.blocks.MetaBlocks;
import magicbook.gtlitecore.api.metatileentity.single.SimpleSteamMetaTileEntity;
import magicbook.gtlitecore.api.metatileentity.single.SteamProgressIndicator;
import magicbook.gtlitecore.api.metatileentity.single.SteamProgressIndicators;
import magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps;
import magicbook.gtlitecore.api.unification.GTLiteMaterials;
import magicbook.gtlitecore.api.utils.GTLiteUtility;
import magicbook.gtlitecore.api.utils.Mods;
import magicbook.gtlitecore.client.renderer.texture.GTLiteTextures;
import magicbook.gtlitecore.common.GTLiteConfigHolder;
import magicbook.gtlitecore.common.blocks.BlockFusionCasing;
import magicbook.gtlitecore.common.blocks.BlockMetalCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import magicbook.gtlitecore.common.metatileentities.electric.MetaTileEntityLightningRod;
import magicbook.gtlitecore.common.metatileentities.multi.electric.*;
import magicbook.gtlitecore.common.metatileentities.multi.electric.adv.*;
import magicbook.gtlitecore.common.metatileentities.multi.electric.generator.*;
import magicbook.gtlitecore.common.metatileentities.multi.part.*;
import magicbook.gtlitecore.common.metatileentities.multi.steam.MetaTileEntityLargePrimitiveBlastFurnace;
import magicbook.gtlitecore.common.metatileentities.multi.steam.MetaTileEntityLargeSteamCompressor;
import magicbook.gtlitecore.common.metatileentities.multi.storage.MetaTileEntityYottaFluidTank;

import static gregtech.api.GTValues.*;
import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;
import static gregtech.common.metatileentities.MetaTileEntities.registerSimpleMetaTileEntity;
import static magicbook.gtlitecore.api.utils.GTLiteUtility.gtliteId;

/**
 * Meta Tile Entities
 *
 * @author Magic_Sweepy
 *
 * <p>
 *     This class is the {@code MetaTileEntity} class of {@code gtlitecore},
 *     ID range of {@code gtlitecore} meta tile entities:
 *
 *     <ul>
 *         <li>14000-14999: Multiblock Parts,</li>
 *         <li>15000-16000: Single Machines,</li>
 *         <li>16001-20000: Multiblock Machines.</li>
 *     </ul>
 *
 *     Some ID is free in this range (but maybe add new machines in this free IDs).
 * </p>
 *
 * @since 2.8.7-beta
 */
@SuppressWarnings("all")
public class GTLiteMetaTileEntities {

    ////////////////////////
    //  Multiblock Parts  //
    ////////////////////////

    //  ID Range: 14000-14999
    public static MetaTileEntityGrindBallHatch MULTIPART_GRIND_BALL_HATCH;
    public static final MetaTileEntityReinforcedRotorHolder[] MULTIPART_REINFORCED_ROTOR_HOLDER = new MetaTileEntityReinforcedRotorHolder[14];
    public static final MetaTileEntityAdvancedEnergyHatch[] INPUT_ENERGY_HATCH_4A = new MetaTileEntityAdvancedEnergyHatch[4];
    public static final MetaTileEntityAdvancedEnergyHatch[] INPUT_ENERGY_HATCH_16A = new MetaTileEntityAdvancedEnergyHatch[4];
    public static final MetaTileEntityAdvancedEnergyHatch[] OUTPUT_ENERGY_HATCH_4A = new MetaTileEntityAdvancedEnergyHatch[7];
    public static final MetaTileEntityAdvancedEnergyHatch[] OUTPUT_ENERGY_HATCH_16A = new MetaTileEntityAdvancedEnergyHatch[8];
    public static final MetaTileEntityAdvancedSubstationEnergyHatch[] SUBSTATION_INPUT_ENERGY_HATCH = new MetaTileEntityAdvancedSubstationEnergyHatch[4];
    public static final MetaTileEntityAdvancedSubstationEnergyHatch[] SUBSTATION_OUTPUT_ENERGY_HATCH = new MetaTileEntityAdvancedSubstationEnergyHatch[4];
    public static final MetaTileEntityAdvancedFluidHatch[] IMPORT_FLUID_HATCH = new MetaTileEntityAdvancedFluidHatch[4];
    public static final MetaTileEntityAdvancedFluidHatch[] EXPORT_FLUID_HATCH = new MetaTileEntityAdvancedFluidHatch[4];
    public static final MetaTileEntityAdvancedItemBus[] IMPORT_ITEM_HATCH = new MetaTileEntityAdvancedItemBus[4];
    public static final MetaTileEntityAdvancedItemBus[] EXPORT_ITEM_HATCH = new MetaTileEntityAdvancedItemBus[4];
    public static final MetaTileEntityAdvancedMultiFluidHatch[] QUADRUPLE_IMPORT_FLUID_HATCH = new MetaTileEntityAdvancedMultiFluidHatch[4];
    public static final MetaTileEntityAdvancedMultiFluidHatch[] QUADRUPLE_EXPORT_FLUID_HATCH = new MetaTileEntityAdvancedMultiFluidHatch[4];
    public static final MetaTileEntityAdvancedMultiFluidHatch[] NONUPLE_IMPORT_FLUID_HATCH = new MetaTileEntityAdvancedMultiFluidHatch[4];
    public static final MetaTileEntityAdvancedMultiFluidHatch[] NONUPLE_EXPORT_FLUID_HATCH = new MetaTileEntityAdvancedMultiFluidHatch[4];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_INPUT_ENERGY_HATCH = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_OUTPUT_ENERGY_HATCH = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_INPUT_ENERGY_HATCH_4A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_OUTPUT_ENERGY_HATCH_4A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_INPUT_ENERGY_HATCH_16A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_OUTPUT_ENERGY_HATCH_16A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_INPUT_ENERGY_HATCH_64A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_OUTPUT_ENERGY_HATCH_64A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_INPUT_ENERGY_HATCH_256A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_OUTPUT_ENERGY_HATCH_256A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_INPUT_ENERGY_HATCH_1024A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_OUTPUT_ENERGY_HATCH_1024A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_INPUT_ENERGY_HATCH_4096A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_OUTPUT_ENERGY_HATCH_4096A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_INPUT_ENERGY_HATCH_16384A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_OUTPUT_ENERGY_HATCH_16384A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_INPUT_ENERGY_HATCH_65536A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_OUTPUT_ENERGY_HATCH_65536A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_INPUT_ENERGY_HATCH_262144A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_OUTPUT_ENERGY_HATCH_262144A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_INPUT_ENERGY_HATCH_1048576A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityWirelessEnergyHatch[] WIRELESS_OUTPUT_ENERGY_HATCH_1048576A = new MetaTileEntityWirelessEnergyHatch[15];
    public static final MetaTileEntityAdvancedSubstationEnergyHatch[] LOW_POWER_SUBSTATION_OUTPUT_ENERGY_HATCH = new MetaTileEntityAdvancedSubstationEnergyHatch[4];
    public static MetaTileEntityCatalystHatch CATALYST_HATCH;

    public static MetaTileEntityQCComponentEmpty QC_EMPTY_COMPONENT;
    public static final MetaTileEntityQCComponentComputation[] QC_COMPUTATION_COMPONENT = new MetaTileEntityQCComponentComputation[2];
    public static final MetaTileEntityQCComponentCooler[] QC_COOLER_COMPONENT = new MetaTileEntityQCComponentCooler[2];
    public static MetaTileEntityQCComponentBridge QC_BRIDGE_COMPONENT;

    ///////////////////////
    //  Single Machines  //
    ///////////////////////

    //  ID Range: 15000-16000
    public static SimpleMachineMetaTileEntity[] CHEMICAL_DEHYDRATOR = new SimpleMachineMetaTileEntity[V.length - 1];
    public static SimpleSteamMetaTileEntity[] STEAM_VACUUM_CHAMBER = new SimpleSteamMetaTileEntity[2];
    public static SimpleMachineMetaTileEntity[] VACUUM_CHAMBER = new SimpleMachineMetaTileEntity[V.length - 1];
    public static final SimpleGeneratorMetaTileEntity[] NAQUADAH_REACTOR = new SimpleGeneratorMetaTileEntity[4];
    public static final SimpleGeneratorMetaTileEntity[] ROCKET_ENGINE = new SimpleGeneratorMetaTileEntity[3];
    public static SimpleMachineMetaTileEntity[] COMPONENT_ASSEMBLER = new SimpleMachineMetaTileEntity[IV + 1];
    public static SimpleMachineMetaTileEntity[] BIO_REACTOR = new SimpleMachineMetaTileEntity[V.length - 1];
    public static SimpleMachineMetaTileEntity[] CONDENSER = new SimpleMachineMetaTileEntity[6];
    public static SimpleMachineMetaTileEntity[] SIMULATOR = new SimpleMachineMetaTileEntity[IV + 1];
    public static final SimpleGeneratorMetaTileEntity[] BIOMASS_GENERATOR = new SimpleGeneratorMetaTileEntity[3];
    public static final MetaTileEntityLightningRod[] LIGHTNING_ROD = new MetaTileEntityLightningRod[3];
    public static SimpleMachineMetaTileEntity[] AUTO_CHISEL = new SimpleMachineMetaTileEntity[3];
    public static SimpleMachineMetaTileEntity[] MASS_FABRICATOR = new SimpleMachineMetaTileEntity[V.length - 1];
    public static SimpleMachineMetaTileEntity[] REPLICATOR = new SimpleMachineMetaTileEntity[V.length - 1];

    ///////////////////////////
    //  Multiblock Machines  //
    ///////////////////////////

    //  ID Range: 16001-20000
    public static MetaTileEntityIndustrialDrillingRig INDUSTRIAL_DRILLING_RIG;
    public static MetaTileEntityCatalyticReformer CATALYTIC_REFORMER;
    public static MetaTileEntitySonicator SONICATOR;
    public static MetaTileEntityHydraulicFracker HYDRAULIC_FRACKER;
    public static MetaTileEntityNanoscaleFabricator NANOSCALE_FABRICATOR;
    public static MetaTileEntityIndustrialRoaster INDUSTRIAL_ROASTER;
    public static MetaTileEntityCrystallizationCrucible CRYSTALLIZATION_CRUCIBLE;
    public static MetaTileEntityCVDUnit CVD_UNIT;
    public static MetaTileEntityPlasmaCVDUnit PLASMA_CVD_UNIT;
    public static MetaTileEntityLaserCVDUnit LASER_CVD_UNIT;
    public static MetaTileEntityBurnerReactor BURNER_REACTOR;
    public static MetaTileEntityCryogenicReactor CRYOGENIC_REACTOR;
    public static MetaTileEntityLargeNaquadahReactor LARGE_NAQUADAH_REACTOR;
    public static MetaTileEntityHyperReactorMkI HYPER_REACTOR_MK1;
    public static MetaTileEntityHyperReactorMkII HYPER_REACTOR_MK2;
    public static MetaTileEntityHyperReactorMkIII HYPER_REACTOR_MK3;
    public static MetaTileEntityIsaMill ISA_MILL;
    public static MetaTileEntityFlotationCellRegulator FLOTATION_CELL_REGULATOR;
    public static MetaTileEntityVacuumDryingFurnace VACUUM_DRYING_FURNACE;
    public static MetaTileEntityVolcanus VOLCANUS;
    public static MetaTileEntityCryogenicFreezer CRYOGENIC_FREEZER;
    public static MetaTileEntityFuelRefineFactory FUEL_REFINE_FACTORY;
    public static MetaTileEntityIonImplantator ION_IMPLANTATOR;
    public static MetaTileEntityUnmannedDroneAirport UNMANNED_DRONE_AIRPORT;
    public static MetaTileEntitySpaceElevator SPACE_ELEVATOR;
    public static MetaTileEntityVirtualCosmosSimulator VIRTUAL_COSMOS_SIMULATOR;
    public static MetaTileEntityCollider COLLIDER;
    public static MetaTileEntityDimensionalOscillator DIMENSIONAL_OSCILLATOR;
    public static MetaTileEntityDecayGenerator DECAY_GENERATOR;

    public static final MetaTileEntityAdvancedFusionReactor[] ADVANCED_FUSION_REACTOR = new MetaTileEntityAdvancedFusionReactor[2];
    public static MetaTileEntityPreciseAssembler PRECISE_ASSEMBLER;
    public static MetaTileEntityComponentAssemblyLine COMPONENT_ASSEMBLY_LINE;
    public static MetaTileEntityAdvancedAssemblyLine ADVANCED_ASSEMBLY_LINE;
    public static final MetaTileEntityCompressedFusionReactor[] COMPRESSED_FUSION_REACTOR = new MetaTileEntityCompressedFusionReactor[5];

    public static MetaTileEntityMegaChemicalReactor MEGA_CHEMICAL_REACTOR;
    public static MetaTileEntityMegaAlloyBlastSmelter MEGA_ALLOY_BLAST_SMELTER;
    public static MetaTileEntityMegaOilCrackingUnit MEGA_OIL_CRACKING_UNIT;
    public static MetaTileEntityStellarFurnace STELLAR_FURNACE;
    public static MetaTileEntityPlasmaCondenser PLASMA_CONDENSER;
    public static MetaTileEntityCosmicRayDetector COSMIC_RAY_DETECTOR;
    public static MetaTileEntitySuprachronalAssemblyLine SUPRACHRONAL_ASSEMBLY_LINE;
    public static MetaTileEntityMolecularTransformer MOLECULAR_TRANSFORMER;
    public static MetaTileEntityQuantumForceTransformer QUANTUM_FORCE_TRANSFORMER;
    public static MetaTileEntityExtremeIndustrialGreenhouse EXTREME_INDUSTRIAL_GREENHOUSE;
    public static MetaTileEntityLargeSteamCompressor LARGE_STEAM_COMPRESSOR;
    public static MetaTileEntityLargePrimitiveBlastFurnace LARGE_PRIMITIVE_BLAST_FURNACE;
    public static MetaTileEntityHeatExchanger HEAT_EXCHANGER;
    public static MetaTileEntityExtremeHeatExchanger EXTREME_HEAT_EXCHANGER;
    public static MetaTileEntityMegaHeatExchanger MEGA_HEAT_EXCHANGER;
    public static MetaTileEntityTreeGrowthFactory TREE_GROWTH_FACTORY;
    public static MetaTileEntityLargeProcessingFactory LARGE_PROCESSING_FACTORY;
    public static MetaTileEntityAdvancedProcessingArray EXTREME_PROCESSING_ARRAY;
    public static MetaTileEntityAdvancedProcessingArray ULTIMATE_PROCESSING_ARRAY;
    public static MetaTileEntityLargeAlloySmelter LARGE_ALLOY_SMELTER;
    public static MetaTileEntityMegaTurbine MEGA_STEAM_TURBINE;
    public static MetaTileEntityMegaTurbine MEGA_GAS_TURBINE;
    public static MetaTileEntityMegaTurbine MEGA_PLASMA_TURBINE;
    public static MetaTileEntityLargeHighPressueSteamTurbine HIGH_PRESSURE_STEAM_TURBINE;
    public static MetaTileEntityLargeSupercriticalSteamTurbine SUPERCRITICAL_STEAM_TURBINE;
    public static MetaTileEntityMegaTurbine MEGA_HIGH_PRESSURE_STEAM_TURBINE;
    public static MetaTileEntityMegaTurbine MEGA_SUPERCRITICAL_STEAM_TURBINE;
    public static MetaTileEntityLargeRocketEngine LARGE_ROCKET_ENGINE;
    public static MetaTileEntityLargeBiomassGenerator LARGE_BIOMASS_GENERATOR;
    public static MetaTileEntityNeutralNetworkNexus NEUTRAL_NETWORK_NEXUS;
    public static MetaTileEntityPCBFactory PCB_FACTORY;
    public static MetaTileEntityDangoteDistillery DANGOTE_DISTILLERY;
    public static MetaTileEntityAmazonWarehousingDepot AMAZON_WAREHOUSING_DEPOT;
    public static MetaTileEntityArcFurnaceArray ARC_FURNACE_ARRAY;
    public static MetaTileEntityElectrolyticTank ELECTROLYTIC_TANK;
    public static MetaTileEntityTurbineMixer TURBINE_MIXER;
    public static MetaTileEntityIndustrialCentrifuge INDUSTRIAL_CENTRIFUGE;
    public static MetaTileEntityZhuHaiFishingPond ZHUHAI_FISHING_POND;
    public static MetaTileEntityCokingTower COKING_TOWER;
    public static MetaTileEntityAdvancedLargeMiner EXTREME_LARGE_MINER;
    public static MetaTileEntityAdvancedLargeMiner ULTIMATE_LARGE_MINER;
    public static MetaTileEntityAdvancedLargeMiner INFINITY_LARGE_MINER;
    public static MetaTileEntityAdvancedFluidDrill ADVANCED_FLUID_DRILL_RIG;
    public static MetaTileEntityAdvancedFluidDrill EXTREME_FLUID_DRILL_RIG;
    public static MetaTileEntityAdvancedFluidDrill ULTIMATE_FLUID_DRILL_RIG;
    public static MetaTileEntityAdvancedFluidDrill INFINITY_FLUID_DRILL_RIG;
    public static MetaTileEntityLargeCircuitAssemblyLine LARGE_CIRCUIT_ASSEMBLY_LINE;
    public static MetaTileEntityElectromagneticSeparationPlant ELECTROMAGNETIC_SEPARATION_PLANT;
    public static MetaTileEntityLargeVacuumChamber LARGE_VACUUM_CHAMBER;
    public static MetaTileEntityLargeBioReactor LARGE_BIO_REACTOR;
    public static MetaTileEntityLargeEUVMaskAligner LARGE_EUV_MASK_ALIGNER;
    public static MetaTileEntityIonLithographyFactory ION_LITHOGRAPHY_FACTORY;
    public static MetaTileEntityLargeHighPressureFormingUnit LARGE_HIGH_PRESSURE_FORMING_UNIT;
    public static MetaTileEntityLargeTurrentLathingFactory LARGE_TURRENT_LATHING_FACTORY;
    public static MetaTileEntityDysonSwarm DYSON_SWARM;
    public static MetaTileEntityIntegratedOreProcessor INTEGRATED_ORE_PROCESSOR;
    public static MetaTileEntityLargeFluidPhaseTransformer LARGE_FLUID_PHASE_TRANSFORMER;
    public static MetaTileEntityIndustrialVacuumChamber INDUSTRIAL_VACUUM_CHAMBER;
    public static MetaTileEntityIndustrialBioReactor INDUSTRIAL_BIO_REACTOR;
    public static MetaTileEntityPlanetaryGasSiphon PLANETARY_GAS_SIPHON;
    public static MetaTileEntityBiowareSimulator BIOWARE_SIMULATOR;
    public static MetaTileEntityAlgaeCultureTank ALGAE_CULTURE_TANK;
    public static MetaTileEntityLargeGasCollector LARGE_GAS_COLLECTOR;
    public static MetaTileEntityUltimateCombustionEngine ULTIMATE_COMBUSTION_ENGINE;
    public static MetaTileEntityIndustrialInductionFurnace INDUSTRIAL_INDUCTION_FURNACE;
    public static MetaTileEntityHorizontalShaftImpactMacerator HORIZONTAL_SHAFT_IMPACT_MACERATOR;
    public static MetaTileEntityTroughTypeOreWasher TROUGH_TYPE_ORE_WASHER;
    public static MetaTileEntityFixedSiftingPlant FIXED_SIFTING_PLANT;
    public static MetaTileEntityLargeWiremillArray LARGE_WIREMILL_ARRAY;
    public static MetaTileEntityElectricImplosionCompressor ELECTRIC_IMPLOSION_COMPRESSOR;
    public static MetaTileEntityLargeRockBreaker LARGE_ROCK_BREAKER;
    public static MetaTileEntityIndustrialRockBreaker INDUSTRIAL_ROCK_BREAKER;
    public static MetaTileEntityLargeMassFabricator LARGE_MASS_FABRICATOR;
    public static MetaTileEntityLargeReplicator LARGE_REPLICATOR;
    public static MetaTileEntityDimensionalMixer DIMENSIONAL_MIXER;
    public static MetaTileEntityAlgaeFarm ALGAE_FARM;
    public static MetaTileEntityMegaBlastFurnace MEGA_BLAST_FURNACE;
    public static MetaTileEntityMegaVacuumFreezer MEGA_VACUUM_FREEZER;
    public static MetaTileEntityCirculativeCoolingTower CIRCULATIVE_COOLING_TOWER;
    public static MetaTileEntityLargeAutoChisel LARGE_AUTO_CHISEL;
    public static MetaTileEntityIndustrial3DPrinter INDUSTRIAL_3D_PRINTER;
    public static MetaTileEntityYottaFluidTank YOTTA_FLUID_TANK;
    public static MetaTileEntityEnergySubstation ENERGY_SUBSTATION;
    public static MetaTileEntityDimensionallyTranscendentPlasmaForge DIMENSIONALLY_TRANSCENDENT_PLASMA_FORGE;
    public static MetaTileEntityQuantumComputer QUANTUM_COMPUTER;
    public static MetaTileEntityNicollDysonBeamer NICOLL_DYSON_BEAMER;
    public static MetaTileEntitySuprachronalNeutroniumForge SUPRACHRONAL_NEUTRONIUM_FORGE;
    public static MetaTileEntityMassFabricatorCPU MASS_FABRICATOR_CPU;
    public static MetaTileEntityElementReplicator ELEMENT_REPLICATOR;

    /**
     * Register a Steam machine and its correspondence High Pressure Steam machine.
     *
     * <p>
     *     Please see {@link SimpleSteamMetaTileEntity}, this method is packaged of this class,
     *     and used for init some basic steam machines, like {@link #STEAM_VACUUM_CHAMBER}.
     * </p>
     *
     * @param machines           Steam {@code MetaTileEntity} machine.
     * @param startId            Start ID of Machine, each machine use two ID (use the first ID you wanted),
     *                           this method will generated Steam and High Hressure Steam two version of your machine.
     * @param name               Unlocalized Name, use {@code bronze} and {@code steel} as suffix auto,
     *                           two suffixes correspondence to two version of your machine (Steam and High Pressure Steam).
     * @param recipeMap          Machine {@code RecipeMap}, you can use {@code RecipeMap} in {@link GTLiteRecipeMaps} or {@link RecipeMaps},
     *                           or another {@code RecipeMap} class in other addition mods.
     * @param progressIndicator  Progress Bar Indicator, this parameter is not same as progress bar in {@link Textures},
     *                           please see {@link SteamProgressIndicator}.
     * @param texture            Overlay textures, please use textures in {@link GTLiteTextures} or {@link Textures},
     *                           or another {@code Texture} class in other addition mods.
     * @param isBricked          Extended texture of machine, if {@code isBricked} is true, then add bricked texture on side and front,
     *                           please see: {@link Textures#STEAM_BRICKED_CASING_BRONZE} and {@link Textures#STEAM_BRICKED_CASING_STEEL}.
     *
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

    /**
     * Register a Multiblock Part of {@code MetaTileEntity}.
     *
     * @param id   ID of Multiblock Part.
     * @param mte  {@code MetaTileEntity}, should use your Multiblock Part class.
     */
    private static <F extends MetaTileEntity> F registerPartMetaTileEntity(int id, F mte) {
        if (id > 1000)
            return null;
        return registerMetaTileEntity(id + 13999, mte);
    }

    /**
     * Register a {@code MetaTileEntity} machine.
     *
     * @param id   ID of {@code MetaTileEntity} machine.
     * @param mte  {@code MetaTileEntity}, should use your {@code MetaTileEntity} class.
     */
    private static <T extends MultiblockControllerBase> T registerMultiMetaTileEntity(int id, T mte) {
        return registerMetaTileEntity(id + 16000, mte);
    }

    public static void init() {

        //////////////////////////
        //  Multiblock Parts    //
        //  Range: 14000-14999  //
        //////////////////////////

        MULTIPART_GRIND_BALL_HATCH = registerPartMetaTileEntity(1, new MetaTileEntityGrindBallHatch(gtliteId("grind_ball_hatch")));

        //  LV-OpV Reinforced Rotor Holder
        for (int i = 0; i < 13; i++) {
            String tier = VN[i + 1].toLowerCase();
            MULTIPART_REINFORCED_ROTOR_HOLDER[i] = registerPartMetaTileEntity(2 + i, new MetaTileEntityReinforcedRotorHolder(gtliteId("reinforced_rotor_holder." + tier), i + 1));
        }

        //  UEV-OpV 4A Energy Hatch
        INPUT_ENERGY_HATCH_4A[0] = registerPartMetaTileEntity(15, new MetaTileEntityAdvancedEnergyHatch(gtliteId("energy_hatch.input_4a.uev"), UEV, 4, false));
        INPUT_ENERGY_HATCH_4A[1] = registerPartMetaTileEntity(16, new MetaTileEntityAdvancedEnergyHatch(gtliteId("energy_hatch.input_4a.uiv"), UIV, 4, false));
        INPUT_ENERGY_HATCH_4A[2] = registerPartMetaTileEntity(17, new MetaTileEntityAdvancedEnergyHatch(gtliteId("energy_hatch.input_4a.uxv"), UXV, 4, false));
        INPUT_ENERGY_HATCH_4A[3] = registerPartMetaTileEntity(18, new MetaTileEntityAdvancedEnergyHatch(gtliteId("energy_hatch.input_4a.opv"), OpV, 4, false));

        //  UEV-OpV 16A Energy Hatch
        INPUT_ENERGY_HATCH_16A[0] = registerPartMetaTileEntity(19, new MetaTileEntityAdvancedEnergyHatch(gtliteId("energy_hatch.input_16a.uev"), UEV, 16, false));
        INPUT_ENERGY_HATCH_16A[1] = registerPartMetaTileEntity(20, new MetaTileEntityAdvancedEnergyHatch(gtliteId("energy_hatch.input_16a.uiv"), UIV, 16, false));
        INPUT_ENERGY_HATCH_16A[2] = registerPartMetaTileEntity(21, new MetaTileEntityAdvancedEnergyHatch(gtliteId("energy_hatch.input_16a.uxv"), UXV, 16, false));
        INPUT_ENERGY_HATCH_16A[3] = registerPartMetaTileEntity(22, new MetaTileEntityAdvancedEnergyHatch(gtliteId("energy_hatch.input_16a.opv"), OpV, 16, false));

        //  LV-HV and UEV-OpV 4A Dynamo Hatch
        OUTPUT_ENERGY_HATCH_4A[0] = registerPartMetaTileEntity(23, new MetaTileEntityAdvancedEnergyHatch(gtliteId("energy_hatch.output_4a.lv"), LV, 4, true));
        OUTPUT_ENERGY_HATCH_4A[1] = registerPartMetaTileEntity(24, new MetaTileEntityAdvancedEnergyHatch(gtliteId("energy_hatch.output_4a.mv"), MV, 4, true));
        OUTPUT_ENERGY_HATCH_4A[2] = registerPartMetaTileEntity(25, new MetaTileEntityAdvancedEnergyHatch(gtliteId("energy_hatch.output_4a.hv"), HV, 4, true));
        OUTPUT_ENERGY_HATCH_4A[3] = registerPartMetaTileEntity(26, new MetaTileEntityAdvancedEnergyHatch(gtliteId("energy_hatch.output_4a.uev"),UEV, 4, true));
        OUTPUT_ENERGY_HATCH_4A[4] = registerPartMetaTileEntity(27, new MetaTileEntityAdvancedEnergyHatch(gtliteId("energy_hatch.output_4a.uiv"),UIV, 4, true));
        OUTPUT_ENERGY_HATCH_4A[5] = registerPartMetaTileEntity(28, new MetaTileEntityAdvancedEnergyHatch(gtliteId("energy_hatch.output_4a.uxv"),UXV, 4, true));
        OUTPUT_ENERGY_HATCH_4A[6] = registerPartMetaTileEntity(29, new MetaTileEntityAdvancedEnergyHatch(gtliteId("energy_hatch.output_4a.opv"),OpV, 4, true));

        //  LV-EV and UEV-OpV 16A Dynamo Hatch
        OUTPUT_ENERGY_HATCH_16A[0] = registerPartMetaTileEntity(30, new MetaTileEntityAdvancedEnergyHatch(gtliteId("energy_hatch.output_16a.lv"), LV, 16, true));
        OUTPUT_ENERGY_HATCH_16A[1] = registerPartMetaTileEntity(31, new MetaTileEntityAdvancedEnergyHatch(gtliteId("energy_hatch.output_16a.mv"), MV, 16, true));
        OUTPUT_ENERGY_HATCH_16A[2] = registerPartMetaTileEntity(32, new MetaTileEntityAdvancedEnergyHatch(gtliteId("energy_hatch.output_16a.hv"), HV, 16, true));
        OUTPUT_ENERGY_HATCH_16A[3] = registerPartMetaTileEntity(33, new MetaTileEntityAdvancedEnergyHatch(gtliteId("energy_hatch.output_16a.ev"), EV, 16, true));
        OUTPUT_ENERGY_HATCH_16A[4] = registerPartMetaTileEntity(34, new MetaTileEntityAdvancedEnergyHatch(gtliteId("energy_hatch.output_16a.uev"), UEV, 16, true));
        OUTPUT_ENERGY_HATCH_16A[5] = registerPartMetaTileEntity(35, new MetaTileEntityAdvancedEnergyHatch(gtliteId("energy_hatch.output_16a.uiv"), UIV, 16, true));
        OUTPUT_ENERGY_HATCH_16A[6] = registerPartMetaTileEntity(36, new MetaTileEntityAdvancedEnergyHatch(gtliteId("energy_hatch.output_16a.uxv"), UXV, 16, true));
        OUTPUT_ENERGY_HATCH_16A[7] = registerPartMetaTileEntity(37, new MetaTileEntityAdvancedEnergyHatch(gtliteId("energy_hatch.output_16a.opv"), OpV, 16, true));

        //  UEV-OpV 64A Substation Energy Hatch
        SUBSTATION_INPUT_ENERGY_HATCH[0] = registerPartMetaTileEntity(38, new MetaTileEntityAdvancedSubstationEnergyHatch(gtliteId("substation_hatch.input_64a.uev"), UEV, 64, false));
        SUBSTATION_INPUT_ENERGY_HATCH[1] = registerPartMetaTileEntity(39, new MetaTileEntityAdvancedSubstationEnergyHatch(gtliteId("substation_hatch.input_64a.uiv"), UIV, 64, false));
        SUBSTATION_INPUT_ENERGY_HATCH[2] = registerPartMetaTileEntity(40, new MetaTileEntityAdvancedSubstationEnergyHatch(gtliteId("substation_hatch.input_64a.uxv"), UXV, 64, false));
        SUBSTATION_INPUT_ENERGY_HATCH[3] = registerPartMetaTileEntity(41, new MetaTileEntityAdvancedSubstationEnergyHatch(gtliteId("substation_hatch.input_64a.opv"), OpV, 64, false));

        //  UEV-OpV 64A Substation Dynamo Hatch
        SUBSTATION_OUTPUT_ENERGY_HATCH[0] = registerPartMetaTileEntity(42, new MetaTileEntityAdvancedSubstationEnergyHatch(gtliteId("substation_hatch.output_64a.uev"), UEV, 64, true));
        SUBSTATION_OUTPUT_ENERGY_HATCH[1] = registerPartMetaTileEntity(43, new MetaTileEntityAdvancedSubstationEnergyHatch(gtliteId("substation_hatch.output_64a.uiv"), UIV, 64, true));
        SUBSTATION_OUTPUT_ENERGY_HATCH[2] = registerPartMetaTileEntity(44, new MetaTileEntityAdvancedSubstationEnergyHatch(gtliteId("substation_hatch.output_64a.uxv"), UXV, 64, true));
        SUBSTATION_OUTPUT_ENERGY_HATCH[3] = registerPartMetaTileEntity(45, new MetaTileEntityAdvancedSubstationEnergyHatch(gtliteId("substation_hatch.output_64a.opv"), OpV, 64, true));

        //  UEV-OpV Item Import Hatch
        IMPORT_ITEM_HATCH[0] = registerPartMetaTileEntity(46, new MetaTileEntityAdvancedItemBus(gtliteId("item_hatch.import.uev"), UEV, false));
        IMPORT_ITEM_HATCH[1] = registerPartMetaTileEntity(47, new MetaTileEntityAdvancedItemBus(gtliteId("item_hatch.import.uiv"), UIV, false));
        IMPORT_ITEM_HATCH[2] = registerPartMetaTileEntity(48, new MetaTileEntityAdvancedItemBus(gtliteId("item_hatch.import.uxv"), UXV, false));
        IMPORT_ITEM_HATCH[3] = registerPartMetaTileEntity(49, new MetaTileEntityAdvancedItemBus(gtliteId("item_hatch.import.opv"), OpV, false));

        //  UEV-OpV Item Export Hatch
        EXPORT_ITEM_HATCH[0] = registerPartMetaTileEntity(50,  new MetaTileEntityAdvancedItemBus(gtliteId("item_hatch.export.uev"), UEV, true));
        EXPORT_ITEM_HATCH[1] = registerPartMetaTileEntity(51,  new MetaTileEntityAdvancedItemBus(gtliteId("item_hatch.export.uiv"), UIV, true));
        EXPORT_ITEM_HATCH[2] = registerPartMetaTileEntity(52,  new MetaTileEntityAdvancedItemBus(gtliteId("item_hatch.export.uxv"), UXV, true));
        EXPORT_ITEM_HATCH[3] = registerPartMetaTileEntity(53,  new MetaTileEntityAdvancedItemBus(gtliteId("item_hatch.export.opv"), OpV, true));

        //  UEV-OpV Fluid Import Hatch
        IMPORT_FLUID_HATCH[0] = registerPartMetaTileEntity(54, new MetaTileEntityAdvancedFluidHatch(gtliteId("fluid_hatch.import.uev"), UEV, false));
        IMPORT_FLUID_HATCH[1] = registerPartMetaTileEntity(55, new MetaTileEntityAdvancedFluidHatch(gtliteId("fluid_hatch.import.uiv"), UIV, false));
        IMPORT_FLUID_HATCH[2] = registerPartMetaTileEntity(56, new MetaTileEntityAdvancedFluidHatch(gtliteId("fluid_hatch.import.uxv"), UXV, false));
        IMPORT_FLUID_HATCH[3] = registerPartMetaTileEntity(57, new MetaTileEntityAdvancedFluidHatch(gtliteId("fluid_hatch.import.opv"), OpV, false));

        //  UEV-OpV Fluid Export Hatch
        EXPORT_FLUID_HATCH[0] = registerPartMetaTileEntity(58,  new MetaTileEntityAdvancedFluidHatch(gtliteId("fluid_hatch.export.uev"), UEV, true));
        EXPORT_FLUID_HATCH[1] = registerPartMetaTileEntity(59,  new MetaTileEntityAdvancedFluidHatch(gtliteId("fluid_hatch.export.uiv"), UIV, true));
        EXPORT_FLUID_HATCH[2] = registerPartMetaTileEntity(60,  new MetaTileEntityAdvancedFluidHatch(gtliteId("fluid_hatch.export.uxv"), UXV, true));
        EXPORT_FLUID_HATCH[3] = registerPartMetaTileEntity(61,  new MetaTileEntityAdvancedFluidHatch(gtliteId("fluid_hatch.export.opv"), OpV, true));

        //  UEV-OpV Quadruple Fluid Import Hatch
        QUADRUPLE_IMPORT_FLUID_HATCH[0] = registerPartMetaTileEntity(62, new MetaTileEntityAdvancedMultiFluidHatch(gtliteId("fluid_hatch.import_4x.uev"), UEV, 4, false));
        QUADRUPLE_IMPORT_FLUID_HATCH[1] = registerPartMetaTileEntity(63, new MetaTileEntityAdvancedMultiFluidHatch(gtliteId("fluid_hatch.import_4x.uiv"), UIV, 4, false));
        QUADRUPLE_IMPORT_FLUID_HATCH[2] = registerPartMetaTileEntity(64, new MetaTileEntityAdvancedMultiFluidHatch(gtliteId("fluid_hatch.import_4x.uxv"), UXV, 4, false));
        QUADRUPLE_IMPORT_FLUID_HATCH[3] = registerPartMetaTileEntity(65, new MetaTileEntityAdvancedMultiFluidHatch(gtliteId("fluid_hatch.import_4x.opv"), OpV, 4, false));

        //  UEV-OpV Nonuple Fluid Import Hatch
        NONUPLE_IMPORT_FLUID_HATCH[0] = registerPartMetaTileEntity(66, new MetaTileEntityAdvancedMultiFluidHatch(gtliteId("fluid_hatch.import_9x.uev"), UEV, 9, false));
        NONUPLE_IMPORT_FLUID_HATCH[1] = registerPartMetaTileEntity(67, new MetaTileEntityAdvancedMultiFluidHatch(gtliteId("fluid_hatch.import_9x.uiv"), UIV, 9, false));
        NONUPLE_IMPORT_FLUID_HATCH[2] = registerPartMetaTileEntity(68, new MetaTileEntityAdvancedMultiFluidHatch(gtliteId("fluid_hatch.import_9x.uxv"), UXV, 9, false));
        NONUPLE_IMPORT_FLUID_HATCH[3] = registerPartMetaTileEntity(69, new MetaTileEntityAdvancedMultiFluidHatch(gtliteId("fluid_hatch.import_9x.opv"), OpV, 9, false));

        //  UEV-OpV Quadruple Fluid Export Hatch
        QUADRUPLE_EXPORT_FLUID_HATCH[0] = registerPartMetaTileEntity(70, new MetaTileEntityAdvancedMultiFluidHatch(gtliteId("fluid_hatch.export_4x.uev"), UEV, 4, true));
        QUADRUPLE_EXPORT_FLUID_HATCH[1] = registerPartMetaTileEntity(71, new MetaTileEntityAdvancedMultiFluidHatch(gtliteId("fluid_hatch.export_4x.uiv"), UIV, 4, true));
        QUADRUPLE_EXPORT_FLUID_HATCH[2] = registerPartMetaTileEntity(72, new MetaTileEntityAdvancedMultiFluidHatch(gtliteId("fluid_hatch.export_4x.uxv"), UXV, 4, true));
        QUADRUPLE_EXPORT_FLUID_HATCH[3] = registerPartMetaTileEntity(73, new MetaTileEntityAdvancedMultiFluidHatch(gtliteId("fluid_hatch.export_4x.opv"), OpV, 4, true));

        //  UEV-OpV Nonuple Fluid Export Hatch
        NONUPLE_EXPORT_FLUID_HATCH[0] = registerPartMetaTileEntity(74, new MetaTileEntityAdvancedMultiFluidHatch(gtliteId("fluid_hatch.export_9x.uev"), UEV, 9, true));
        NONUPLE_EXPORT_FLUID_HATCH[1] = registerPartMetaTileEntity(75, new MetaTileEntityAdvancedMultiFluidHatch(gtliteId("fluid_hatch.export_9x.uiv"), UIV, 9, true));
        NONUPLE_EXPORT_FLUID_HATCH[2] = registerPartMetaTileEntity(76, new MetaTileEntityAdvancedMultiFluidHatch(gtliteId("fluid_hatch.export_9x.uxv"), UXV, 9, true));
        NONUPLE_EXPORT_FLUID_HATCH[3] = registerPartMetaTileEntity(77, new MetaTileEntityAdvancedMultiFluidHatch(gtliteId("fluid_hatch.export_9x.opv"), OpV, 9, true));

        //  ULV-MAX Wireless Energy/Dynamo Hatch (consist of high-amp version)
        for (int i = 0; i < 15; i++) {
            String tier = VN[i].toLowerCase();
            WIRELESS_INPUT_ENERGY_HATCH[i]          = registerPartMetaTileEntity(78 + i,       new MetaTileEntityWirelessEnergyHatch(gtliteId("wireless_energy_hatch.input."          + tier), i, 2,       false));
            WIRELESS_INPUT_ENERGY_HATCH_4A[i]       = registerPartMetaTileEntity(78 + 15 + i,  new MetaTileEntityWirelessEnergyHatch(gtliteId("wireless_energy_hatch.input_4a."       + tier), i, 4,       false));
            WIRELESS_INPUT_ENERGY_HATCH_16A[i]      = registerPartMetaTileEntity(78 + 30 + i,  new MetaTileEntityWirelessEnergyHatch(gtliteId("wireless_energy_hatch.input_16a."      + tier), i, 16,      false));
            WIRELESS_INPUT_ENERGY_HATCH_64A[i]      = registerPartMetaTileEntity(78 + 45 + i,  new MetaTileEntityWirelessEnergyHatch(gtliteId("wireless_energy_hatch.input_64a."      + tier), i, 64,      false));
            WIRELESS_INPUT_ENERGY_HATCH_256A[i]     = registerPartMetaTileEntity(78 + 60 + i,  new MetaTileEntityWirelessEnergyHatch(gtliteId("wireless_energy_hatch.input_256a."     + tier), i, 256,     false));
            WIRELESS_INPUT_ENERGY_HATCH_1024A[i]    = registerPartMetaTileEntity(78 + 75 + i,  new MetaTileEntityWirelessEnergyHatch(gtliteId("wireless_energy_hatch.input_1024a."    + tier), i, 1024,    false));
            WIRELESS_INPUT_ENERGY_HATCH_4096A[i]    = registerPartMetaTileEntity(78 + 90 + i,  new MetaTileEntityWirelessEnergyHatch(gtliteId("wireless_energy_hatch.input_4096a."    + tier), i, 4096,    false));
            WIRELESS_INPUT_ENERGY_HATCH_16384A[i]   = registerPartMetaTileEntity(78 + 105 + i, new MetaTileEntityWirelessEnergyHatch(gtliteId("wireless_energy_hatch.input_16384a."   + tier), i, 16384,   false));
            WIRELESS_INPUT_ENERGY_HATCH_65536A[i]   = registerPartMetaTileEntity(78 + 120 + i, new MetaTileEntityWirelessEnergyHatch(gtliteId("wireless_energy_hatch.input_65536a."   + tier), i, 65536,   false));
            WIRELESS_INPUT_ENERGY_HATCH_262144A[i]  = registerPartMetaTileEntity(78 + 135 + i, new MetaTileEntityWirelessEnergyHatch(gtliteId("wireless_energy_hatch.input_262144a."  + tier), i, 262144,  false));
            WIRELESS_INPUT_ENERGY_HATCH_1048576A[i] = registerPartMetaTileEntity(78 + 150 + i, new MetaTileEntityWirelessEnergyHatch(gtliteId("wireless_energy_hatch.input_1048576a." + tier), i, 1048576, false));

            WIRELESS_OUTPUT_ENERGY_HATCH[i]          = registerPartMetaTileEntity(78 + 165 + i, new MetaTileEntityWirelessEnergyHatch(gtliteId("wireless_energy_hatch.output."          + tier), i, 2,       true));
            WIRELESS_OUTPUT_ENERGY_HATCH_4A[i]       = registerPartMetaTileEntity(78 + 180 + i, new MetaTileEntityWirelessEnergyHatch(gtliteId("wireless_energy_hatch.output_4a."       + tier), i, 4,       true));
            WIRELESS_OUTPUT_ENERGY_HATCH_16A[i]      = registerPartMetaTileEntity(78 + 195 + i, new MetaTileEntityWirelessEnergyHatch(gtliteId("wireless_energy_hatch.output_16a."      + tier), i, 16,      true));
            WIRELESS_OUTPUT_ENERGY_HATCH_64A[i]      = registerPartMetaTileEntity(78 + 210 + i, new MetaTileEntityWirelessEnergyHatch(gtliteId("wireless_energy_hatch.output_64a."      + tier), i, 64,      true));
            WIRELESS_OUTPUT_ENERGY_HATCH_256A[i]     = registerPartMetaTileEntity(78 + 225 + i, new MetaTileEntityWirelessEnergyHatch(gtliteId("wireless_energy_hatch.output_256a."     + tier), i, 256,     true));
            WIRELESS_OUTPUT_ENERGY_HATCH_1024A[i]    = registerPartMetaTileEntity(78 + 240 + i, new MetaTileEntityWirelessEnergyHatch(gtliteId("wireless_energy_hatch.output_1024a."    + tier), i, 1024,    true));
            WIRELESS_OUTPUT_ENERGY_HATCH_4096A[i]    = registerPartMetaTileEntity(78 + 255 + i, new MetaTileEntityWirelessEnergyHatch(gtliteId("wireless_energy_hatch.output_4096a."    + tier), i, 4096,    true));
            WIRELESS_OUTPUT_ENERGY_HATCH_16384A[i]   = registerPartMetaTileEntity(78 + 270 + i, new MetaTileEntityWirelessEnergyHatch(gtliteId("wireless_energy_hatch.output_16384a."   + tier), i, 16384,   true));
            WIRELESS_OUTPUT_ENERGY_HATCH_65536A[i]   = registerPartMetaTileEntity(78 + 285 + i, new MetaTileEntityWirelessEnergyHatch(gtliteId("wireless_energy_hatch.output_65536a."   + tier), i, 65536,   true));
            WIRELESS_OUTPUT_ENERGY_HATCH_262144A[i]  = registerPartMetaTileEntity(78 + 300 + i, new MetaTileEntityWirelessEnergyHatch(gtliteId("wireless_energy_hatch.output_262144a."  + tier), i, 262144,  true));
            WIRELESS_OUTPUT_ENERGY_HATCH_1048576A[i] = registerPartMetaTileEntity(78 + 315 + i, new MetaTileEntityWirelessEnergyHatch(gtliteId("wireless_energy_hatch.output_1048576a." + tier), i, 1048576, true));
        }

        LOW_POWER_SUBSTATION_OUTPUT_ENERGY_HATCH[0] = registerPartMetaTileEntity(410, new MetaTileEntityAdvancedSubstationEnergyHatch(gtliteId("substation_hatch.output_64a.lv"), LV, 64, true));
        LOW_POWER_SUBSTATION_OUTPUT_ENERGY_HATCH[1] = registerPartMetaTileEntity(411, new MetaTileEntityAdvancedSubstationEnergyHatch(gtliteId("substation_hatch.output_64a.mv"), MV, 64, true));
        LOW_POWER_SUBSTATION_OUTPUT_ENERGY_HATCH[2] = registerPartMetaTileEntity(412, new MetaTileEntityAdvancedSubstationEnergyHatch(gtliteId("substation_hatch.output_64a.hv"), HV, 64, true));
        LOW_POWER_SUBSTATION_OUTPUT_ENERGY_HATCH[3] = registerPartMetaTileEntity(413, new MetaTileEntityAdvancedSubstationEnergyHatch(gtliteId("substation_hatch.output_64a.ev"), EV, 64, true));

        CATALYST_HATCH = registerPartMetaTileEntity(450, new MetaTileEntityCatalystHatch(gtliteId("catalyst_hatch")));

        //  Quantum Computer Components
        QC_EMPTY_COMPONENT                        = registerPartMetaTileEntity(500, new MetaTileEntityQCComponentEmpty(      gtliteId("qc_empty_component")));
        QC_COMPUTATION_COMPONENT[0]               = registerPartMetaTileEntity(501, new MetaTileEntityQCComponentComputation(gtliteId("qc_computation_component"),                                          false));
        QC_COMPUTATION_COMPONENT[1]               = registerPartMetaTileEntity(502, new MetaTileEntityQCComponentComputation(gtliteId("qc_advanced_computation_component"),                                 true));
        QC_COOLER_COMPONENT[0]                    = registerPartMetaTileEntity(503, new MetaTileEntityQCComponentCooler(     gtliteId("qc_heat_sink_component"),                                            false));
        QC_COOLER_COMPONENT[1]                    = registerPartMetaTileEntity(504, new MetaTileEntityQCComponentCooler(     gtliteId("qc_active_cooler_component"),                                        true));
        QC_BRIDGE_COMPONENT                       = registerPartMetaTileEntity(505, new MetaTileEntityQCComponentBridge(     gtliteId("qc_bridge_component")));

        //  Single Machines
        //  Range: 15000-16000

        //  LV-OpV Chemical Dehydrator
        registerSimpleMetaTileEntity(CHEMICAL_DEHYDRATOR, 15000, "chemical_dehydrator", GTLiteRecipeMaps.CHEMICAL_DEHYDRATOR_RECIPES, GTLiteTextures.CHEMICAL_DEHYDRATOR_OVERLAY, true, GTLiteUtility::gtliteId, GTUtility.hvCappedTankSizeFunction);

        //  Steam/High Pressure Steam + LV-OpV Vacuum Chamber
        registerSimpleSteamMetaTileEntity(STEAM_VACUUM_CHAMBER, 15013, "vacuum_chamber", GTLiteRecipeMaps.VACUUM_CHAMBER_RECIPES, SteamProgressIndicators.COMPRESS, Textures.GAS_COLLECTOR_OVERLAY, false);
        registerSimpleMetaTileEntity(VACUUM_CHAMBER, 15015, "vacuum_chamber", GTLiteRecipeMaps.VACUUM_CHAMBER_RECIPES, Textures.GAS_COLLECTOR_OVERLAY, true, GTLiteUtility::gtliteId, GTUtility.hvCappedTankSizeFunction);

        //  IV-UV Naquadah Reactor
        NAQUADAH_REACTOR[0] = registerMetaTileEntity(15028, new SimpleGeneratorMetaTileEntity(gtliteId("naquadah_reactor.iv"), GTLiteRecipeMaps.NAQUADAH_REACTOR_RECIPES, GTLiteTextures.NAQUADAH_REACTOR_OVERLAY, 5, GTUtility.genericGeneratorTankSizeFunction));
        NAQUADAH_REACTOR[1] = registerMetaTileEntity(15029, new SimpleGeneratorMetaTileEntity(gtliteId("naquadah_reactor.luv"), GTLiteRecipeMaps.NAQUADAH_REACTOR_RECIPES, GTLiteTextures.NAQUADAH_REACTOR_OVERLAY, 6, GTUtility.genericGeneratorTankSizeFunction));
        NAQUADAH_REACTOR[2] = registerMetaTileEntity(15030, new SimpleGeneratorMetaTileEntity(gtliteId("naquadah_reactor.zpm"), GTLiteRecipeMaps.NAQUADAH_REACTOR_RECIPES, GTLiteTextures.NAQUADAH_REACTOR_OVERLAY, 7, GTUtility.genericGeneratorTankSizeFunction));
        NAQUADAH_REACTOR[3] = registerMetaTileEntity(15031, new SimpleGeneratorMetaTileEntity(gtliteId("naquadah_reactor.uv"), GTLiteRecipeMaps.NAQUADAH_REACTOR_RECIPES, GTLiteTextures.NAQUADAH_REACTOR_OVERLAY, 8, GTUtility.genericGeneratorTankSizeFunction));

        //  HV-IV Rocket Engine
        ROCKET_ENGINE[0] = registerMetaTileEntity(15032, new SimpleGeneratorMetaTileEntity(gtliteId("rocket_engine.hv"), GTLiteRecipeMaps.ROCKET_ENGINE_RECIPES, GTLiteTextures.ROCKET_ENGINE_OVERLAY, 3, GTUtility.genericGeneratorTankSizeFunction));
        ROCKET_ENGINE[1] = registerMetaTileEntity(15033, new SimpleGeneratorMetaTileEntity(gtliteId("rocket_engine.ev"), GTLiteRecipeMaps.ROCKET_ENGINE_RECIPES, GTLiteTextures.ROCKET_ENGINE_OVERLAY, 4, GTUtility.genericGeneratorTankSizeFunction));
        ROCKET_ENGINE[2] = registerMetaTileEntity(15034, new SimpleGeneratorMetaTileEntity(gtliteId("rocket_engine.iv"), GTLiteRecipeMaps.ROCKET_ENGINE_RECIPES, GTLiteTextures.ROCKET_ENGINE_OVERLAY, 5, GTUtility.genericGeneratorTankSizeFunction));

        //  LV-IV Component Assembler
        registerSimpleMetaTileEntity(COMPONENT_ASSEMBLER, 15035, "component_assembler", GTLiteRecipeMaps.COMPONENT_ASSEMBLER_RECIPES, Textures.ASSEMBLER_OVERLAY, true, GTLiteUtility::gtliteId, GTUtility.hvCappedTankSizeFunction);

        //  LV-OpV Bio Reactor
        registerSimpleMetaTileEntity(BIO_REACTOR, 15040, "bio_reactor", GTLiteRecipeMaps.BIO_REACTOR_RECIPES, GTLiteTextures.BIO_REACTOR_OVERLAY, true, GTLiteUtility::gtliteId, GTUtility.hvCappedTankSizeFunction);

        //  UV-OpV Condenser
        CONDENSER[0] = registerMetaTileEntity(15053, new SimpleMachineMetaTileEntity(gtliteId("condenser.uv"), GTLiteRecipeMaps.CONDENSER_RECIPES, GTLiteTextures.CONDENSER_OVERLAY, 8, true, GTUtility.genericGeneratorTankSizeFunction));
        CONDENSER[1] = registerMetaTileEntity(15054, new SimpleMachineMetaTileEntity(gtliteId("condenser.uhv"), GTLiteRecipeMaps.CONDENSER_RECIPES, GTLiteTextures.CONDENSER_OVERLAY, 9, true, GTUtility.genericGeneratorTankSizeFunction));
        CONDENSER[2] = registerMetaTileEntity(15055, new SimpleMachineMetaTileEntity(gtliteId("condenser.uev"), GTLiteRecipeMaps.CONDENSER_RECIPES, GTLiteTextures.CONDENSER_OVERLAY, 10, true, GTUtility.genericGeneratorTankSizeFunction));
        CONDENSER[3] = registerMetaTileEntity(15056, new SimpleMachineMetaTileEntity(gtliteId("condenser.uiv"), GTLiteRecipeMaps.CONDENSER_RECIPES, GTLiteTextures.CONDENSER_OVERLAY, 11, true, GTUtility.genericGeneratorTankSizeFunction));
        CONDENSER[4] = registerMetaTileEntity(15057, new SimpleMachineMetaTileEntity(gtliteId("condenser.uxv"), GTLiteRecipeMaps.CONDENSER_RECIPES, GTLiteTextures.CONDENSER_OVERLAY, 12, true, GTUtility.genericGeneratorTankSizeFunction));
        CONDENSER[5] = registerMetaTileEntity(15058, new SimpleMachineMetaTileEntity(gtliteId("condenser.opv"), GTLiteRecipeMaps.CONDENSER_RECIPES, GTLiteTextures.CONDENSER_OVERLAY, 13, true, GTUtility.genericGeneratorTankSizeFunction));

        //  LV-IV Simulator
        registerSimpleMetaTileEntity(SIMULATOR, 15059, "simulator", GTLiteRecipeMaps.SIMULATOR_RECIPES, GTLiteTextures.SIMULATOR_OVERLAY, true, GTLiteUtility::gtliteId, GTUtility.hvCappedTankSizeFunction);
        BIOMASS_GENERATOR[0] = registerMetaTileEntity(15064, new SimpleGeneratorMetaTileEntity(gtliteId("biomass_generator.ev"), GTLiteRecipeMaps.BIOMASS_GENERATOR_RECIPES, GTLiteTextures.BIOMASS_GENERATOR_OVERLAY, 4, GTUtility.genericGeneratorTankSizeFunction));
        BIOMASS_GENERATOR[1] = registerMetaTileEntity(15065, new SimpleGeneratorMetaTileEntity(gtliteId("biomass_generator.iv"), GTLiteRecipeMaps.BIOMASS_GENERATOR_RECIPES, GTLiteTextures.BIOMASS_GENERATOR_OVERLAY, 5, GTUtility.genericGeneratorTankSizeFunction));
        BIOMASS_GENERATOR[2] = registerMetaTileEntity(15066, new SimpleGeneratorMetaTileEntity(gtliteId("biomass_generator.luv"), GTLiteRecipeMaps.BIOMASS_GENERATOR_RECIPES, GTLiteTextures.BIOMASS_GENERATOR_OVERLAY, 6, GTUtility.genericGeneratorTankSizeFunction));
        LIGHTNING_ROD[0] = registerMetaTileEntity(15067, new MetaTileEntityLightningRod(gtliteId("lightning_rod.hv"), HV));
        LIGHTNING_ROD[1] = registerMetaTileEntity(15068, new MetaTileEntityLightningRod(gtliteId("lightning_rod.ev"), EV));
        LIGHTNING_ROD[2] = registerMetaTileEntity(15069, new MetaTileEntityLightningRod(gtliteId("lightning_rod.iv"), IV));

        //  LV-HV Auto Chisel (Required Chisel Module enable)
        if (Mods.Chisel.isModLoaded()) {
            if (GTLiteConfigHolder.compats.enableChiselModule) {
                AUTO_CHISEL[0] = registerMetaTileEntity(15070, new SimpleMachineMetaTileEntity(gtliteId("auto_chisel.lv"), GTLiteRecipeMaps.AUTO_CHISEL_RECIPES, Textures.AUTOCLAVE_OVERLAY, 1, true, GTUtility.genericGeneratorTankSizeFunction));
                AUTO_CHISEL[1] = registerMetaTileEntity(15071, new SimpleMachineMetaTileEntity(gtliteId("auto_chisel.mv"), GTLiteRecipeMaps.AUTO_CHISEL_RECIPES, Textures.AUTOCLAVE_OVERLAY, 2, true, GTUtility.genericGeneratorTankSizeFunction));
                AUTO_CHISEL[2] = registerMetaTileEntity(15072, new SimpleMachineMetaTileEntity(gtliteId("auto_chisel.hv"), GTLiteRecipeMaps.AUTO_CHISEL_RECIPES, Textures.AUTOCLAVE_OVERLAY, 3, true, GTUtility.genericGeneratorTankSizeFunction));
            }
        }

        if (GTLiteConfigHolder.machines.enableUUMatterChain) {
            registerSimpleMetaTileEntity(MASS_FABRICATOR, 15073, "mass_fabricator", RecipeMaps.MASS_FABRICATOR_RECIPES, Textures.MASS_FABRICATOR_OVERLAY, true, GTLiteUtility::gtliteId, GTUtility.hvCappedTankSizeFunction);
            registerSimpleMetaTileEntity(REPLICATOR, 15088, "replicator", RecipeMaps.REPLICATOR_RECIPES, Textures.REPLICATOR_OVERLAY, true, GTLiteUtility::gtliteId, GTUtility.hvCappedTankSizeFunction);
        }

        //  Multiblock Machines
        //  Range: 16001-20000
        INDUSTRIAL_DRILLING_RIG = registerMultiMetaTileEntity(1, new MetaTileEntityIndustrialDrillingRig(gtliteId("industrial_drilling_rig")));
        CATALYTIC_REFORMER = registerMultiMetaTileEntity(2, new MetaTileEntityCatalyticReformer(gtliteId("catalytic_reformer")));
        SONICATOR = registerMultiMetaTileEntity(3, new MetaTileEntitySonicator(gtliteId("sonicator")));
        HYDRAULIC_FRACKER = registerMultiMetaTileEntity(4, new MetaTileEntityHydraulicFracker(gtliteId("hydraulic_fracker"), ZPM));
        NANOSCALE_FABRICATOR = registerMultiMetaTileEntity(5, new MetaTileEntityNanoscaleFabricator(gtliteId("nanoscale_fabricator")));
        INDUSTRIAL_ROASTER = registerMultiMetaTileEntity(6, new MetaTileEntityIndustrialRoaster(gtliteId("industrial_roaster")));
        CRYSTALLIZATION_CRUCIBLE = registerMultiMetaTileEntity(7, new MetaTileEntityCrystallizationCrucible(gtliteId("crystallization_crucible")));
        CVD_UNIT = registerMultiMetaTileEntity(8, new MetaTileEntityCVDUnit(gtliteId("cvd_unit")));
        PLASMA_CVD_UNIT = registerMultiMetaTileEntity(9, new MetaTileEntityPlasmaCVDUnit(gtliteId("plasma_cvd_unit")));
        LASER_CVD_UNIT = registerMultiMetaTileEntity(10, new MetaTileEntityLaserCVDUnit(gtliteId("laser_cvd_unit")));
        BURNER_REACTOR = registerMultiMetaTileEntity(11, new MetaTileEntityBurnerReactor(gtliteId("burner_reactor")));
        CRYOGENIC_REACTOR = registerMultiMetaTileEntity(12, new MetaTileEntityCryogenicReactor(gtliteId("cryogenic_reactor")));
        LARGE_NAQUADAH_REACTOR = registerMultiMetaTileEntity(13, new MetaTileEntityLargeNaquadahReactor(gtliteId("large_naquadah_reactor")));
        HYPER_REACTOR_MK1 = registerMultiMetaTileEntity(14, new MetaTileEntityHyperReactorMkI(gtliteId("hyper_reactor_mk1")));
        HYPER_REACTOR_MK2 = registerMultiMetaTileEntity(15, new MetaTileEntityHyperReactorMkII(gtliteId("hyper_reactor_mk2")));
        HYPER_REACTOR_MK3 = registerMultiMetaTileEntity(16, new MetaTileEntityHyperReactorMkIII(gtliteId("hyper_reactor_mk3")));
        ISA_MILL = registerMultiMetaTileEntity(17, new MetaTileEntityIsaMill(gtliteId("isa_mill")));
        FLOTATION_CELL_REGULATOR = registerMultiMetaTileEntity(18, new MetaTileEntityFlotationCellRegulator(gtliteId("flotation_cell_regulator")));
        VACUUM_DRYING_FURNACE = registerMultiMetaTileEntity(19, new MetaTileEntityVacuumDryingFurnace(gtliteId("vacuum_drying_furnace")));
        VOLCANUS = registerMultiMetaTileEntity(20, new MetaTileEntityVolcanus(gtliteId("volcanus")));
        CRYOGENIC_FREEZER = registerMultiMetaTileEntity(21, new MetaTileEntityCryogenicFreezer(gtliteId("cryogenic_freezer")));
        FUEL_REFINE_FACTORY = registerMultiMetaTileEntity(22, new MetaTileEntityFuelRefineFactory(gtliteId("fuel_refine_factory")));
        ION_IMPLANTATOR = registerMultiMetaTileEntity(23, new MetaTileEntityIonImplantator(gtliteId("ion_implantator")));
        UNMANNED_DRONE_AIRPORT = registerMultiMetaTileEntity(24, new MetaTileEntityUnmannedDroneAirport(gtliteId("unmanned_drone_airport")));
        SPACE_ELEVATOR = registerMultiMetaTileEntity(25, new MetaTileEntitySpaceElevator(gtliteId("space_elevator")));
        VIRTUAL_COSMOS_SIMULATOR = registerMultiMetaTileEntity(26, new MetaTileEntityVirtualCosmosSimulator(gtliteId("virtual_cosmos_simulator")));
        COLLIDER = registerMultiMetaTileEntity(27, new MetaTileEntityCollider(gtliteId("collider")));
        DIMENSIONAL_OSCILLATOR = registerMultiMetaTileEntity(28, new MetaTileEntityDimensionalOscillator(gtliteId("dimensional_oscillator")));
        DECAY_GENERATOR = registerMultiMetaTileEntity(29, new MetaTileEntityDecayGenerator(gtliteId("decay_generator")));
        ADVANCED_FUSION_REACTOR[0] = registerMultiMetaTileEntity(30, new MetaTileEntityAdvancedFusionReactor(gtliteId("fusion_reactor_mk4"), UHV, GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.FUSION_CASING_MK4), GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.FUSION_COIL_MK2), GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.CRYOSTAT), GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.DIVERTOR), GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.VACUUM)));
        ADVANCED_FUSION_REACTOR[1] = registerMultiMetaTileEntity(31, new MetaTileEntityAdvancedFusionReactor(gtliteId("fusion_reactor_mk5"), UEV, GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.FUSION_CASING_MK5), GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.FUSION_COIL_MK3), GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.ADVANCED_CRYOSTAT), GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.ADVANCED_DIVERTOR), GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.ADVANCED_VACUUM)));
        PRECISE_ASSEMBLER = registerMultiMetaTileEntity(32, new MetaTileEntityPreciseAssembler(gtliteId("precise_assembler")));
        COMPONENT_ASSEMBLY_LINE = registerMultiMetaTileEntity(33, new MetaTileEntityComponentAssemblyLine(gtliteId("component_assembly_line")));
        ADVANCED_ASSEMBLY_LINE = registerMultiMetaTileEntity(34, new MetaTileEntityAdvancedAssemblyLine(gtliteId("advanced_assembly_line")));
        COMPRESSED_FUSION_REACTOR[0] = registerMultiMetaTileEntity(35, new MetaTileEntityCompressedFusionReactor(gtliteId("compressed_fusion_reactor.luv"), LuV, MetaBlocks.FUSION_CASING.getState(gregtech.common.blocks.BlockFusionCasing.CasingType.FUSION_CASING), MetaBlocks.FUSION_CASING.getState(gregtech.common.blocks.BlockFusionCasing.CasingType.SUPERCONDUCTOR_COIL), MetaBlocks.FRAMES.get(Materials.Naquadah).getBlock(Materials.Naquadah)));
        COMPRESSED_FUSION_REACTOR[1] = registerMultiMetaTileEntity(36, new MetaTileEntityCompressedFusionReactor(gtliteId("compressed_fusion_reactor.zpm"), ZPM, MetaBlocks.FUSION_CASING.getState(gregtech.common.blocks.BlockFusionCasing.CasingType.FUSION_CASING_MK2), MetaBlocks.FUSION_CASING.getState(gregtech.common.blocks.BlockFusionCasing.CasingType.FUSION_COIL), MetaBlocks.FRAMES.get(Materials.NaquadahEnriched).getBlock(Materials.NaquadahEnriched)));
        COMPRESSED_FUSION_REACTOR[2] = registerMultiMetaTileEntity(37, new MetaTileEntityCompressedFusionReactor(gtliteId("compressed_fusion_reactor.uv"), UV, MetaBlocks.FUSION_CASING.getState(gregtech.common.blocks.BlockFusionCasing.CasingType.FUSION_CASING_MK3), MetaBlocks.FUSION_CASING.getState(gregtech.common.blocks.BlockFusionCasing.CasingType.FUSION_COIL), MetaBlocks.FRAMES.get(Materials.Naquadria).getBlock(Materials.Naquadria)));
        COMPRESSED_FUSION_REACTOR[3] = registerMultiMetaTileEntity(38, new MetaTileEntityCompressedFusionReactor(gtliteId("compressed_fusion_reactor.uhv"), UHV, GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.FUSION_CASING_MK4), GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.FUSION_COIL_MK2), MetaBlocks.FRAMES.get(Materials.Tritanium).getBlock(Materials.Tritanium)));
        COMPRESSED_FUSION_REACTOR[4] = registerMultiMetaTileEntity(39, new MetaTileEntityCompressedFusionReactor(gtliteId("compressed_fusion_reactor.uev"), UEV, GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.FUSION_CASING_MK5), GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.FUSION_COIL_MK3), MetaBlocks.FRAMES.get(GTLiteMaterials.Orichalcum).getBlock(GTLiteMaterials.Orichalcum)));
        MEGA_ALLOY_BLAST_SMELTER = registerMultiMetaTileEntity(40, new MetaTileEntityMegaAlloyBlastSmelter(gtliteId("mega_alloy_blast_smelter")));
        MEGA_CHEMICAL_REACTOR = registerMultiMetaTileEntity(41, new MetaTileEntityMegaChemicalReactor(gtliteId("mega_chemical_reactor")));
        MEGA_OIL_CRACKING_UNIT = registerMultiMetaTileEntity(42, new MetaTileEntityMegaOilCrackingUnit(gtliteId("mega_oil_cracking_unit")));
        STELLAR_FURNACE = registerMultiMetaTileEntity(43, new MetaTileEntityStellarFurnace(gtliteId("stellar_furnace")));
        PLASMA_CONDENSER = registerMultiMetaTileEntity(44, new MetaTileEntityPlasmaCondenser(gtliteId("plasma_condenser")));
        COSMIC_RAY_DETECTOR = registerMultiMetaTileEntity(45, new MetaTileEntityCosmicRayDetector(gtliteId("cosmic_ray_detector")));
        SUPRACHRONAL_ASSEMBLY_LINE = registerMultiMetaTileEntity(46, new MetaTileEntitySuprachronalAssemblyLine(gtliteId("suprachronal_assembly_line")));
        MOLECULAR_TRANSFORMER = registerMultiMetaTileEntity(47, new MetaTileEntityMolecularTransformer(gtliteId("molecular_transformer")));
        QUANTUM_FORCE_TRANSFORMER = registerMultiMetaTileEntity(48, new MetaTileEntityQuantumForceTransformer(gtliteId("quantum_force_transformer")));
        EXTREME_INDUSTRIAL_GREENHOUSE = registerMultiMetaTileEntity(49, new MetaTileEntityExtremeIndustrialGreenhouse(gtliteId("extreme_industrial_greenhouse")));
        LARGE_STEAM_COMPRESSOR = registerMultiMetaTileEntity(50, new MetaTileEntityLargeSteamCompressor(gtliteId("large_steam_compressor")));
        LARGE_PRIMITIVE_BLAST_FURNACE = registerMultiMetaTileEntity(51, new MetaTileEntityLargePrimitiveBlastFurnace(gtliteId("large_primitive_blast_furnace")));
        HEAT_EXCHANGER = registerMultiMetaTileEntity(52, new MetaTileEntityHeatExchanger(gtliteId("heat_exchanger")));
        EXTREME_HEAT_EXCHANGER = registerMultiMetaTileEntity(53, new MetaTileEntityExtremeHeatExchanger(gtliteId("extreme_heat_exchanger")));
        MEGA_HEAT_EXCHANGER = registerMultiMetaTileEntity(54, new MetaTileEntityMegaHeatExchanger(gtliteId("mega_heat_exchanger")));
        TREE_GROWTH_FACTORY = registerMultiMetaTileEntity(55, new MetaTileEntityTreeGrowthFactory(gtliteId("tree_growth_factory")));
        LARGE_PROCESSING_FACTORY = registerMultiMetaTileEntity(56, new MetaTileEntityLargeProcessingFactory(gtliteId("large_processing_factory")));
        EXTREME_PROCESSING_ARRAY = registerMultiMetaTileEntity(57, new MetaTileEntityAdvancedProcessingArray(gtliteId("extreme_processing_array"), 0));
        ULTIMATE_PROCESSING_ARRAY = registerMultiMetaTileEntity(58, new MetaTileEntityAdvancedProcessingArray(gtliteId("ultimate_processing_array"), 1));
        LARGE_ALLOY_SMELTER = registerMultiMetaTileEntity(59, new MetaTileEntityLargeAlloySmelter(gtliteId("large_alloy_smelter")));
        MEGA_STEAM_TURBINE = registerMultiMetaTileEntity(60, new MetaTileEntityMegaTurbine(gtliteId("mega_turbine.steam"), RecipeMaps.STEAM_TURBINE_FUELS, HV, MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.STEEL_TURBINE_CASING), MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.STEEL_GEARBOX), Textures.SOLID_STEEL_CASING, false, GTLiteTextures.MEGA_TURBINE_OVERLAY));
        MEGA_GAS_TURBINE = registerMultiMetaTileEntity(61, new MetaTileEntityMegaTurbine(gtliteId("mega_turbine.gas"), RecipeMaps.GAS_TURBINE_FUELS, EV, MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.STAINLESS_TURBINE_CASING), MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.STAINLESS_STEEL_GEARBOX), Textures.CLEAN_STAINLESS_STEEL_CASING, true, GTLiteTextures.MEGA_TURBINE_OVERLAY));
        MEGA_PLASMA_TURBINE = registerMultiMetaTileEntity(62, new MetaTileEntityMegaTurbine(gtliteId("mega_turbine.plasma"), RecipeMaps.PLASMA_GENERATOR_FUELS, IV, MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.TUNGSTENSTEEL_TURBINE_CASING), MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.TUNGSTENSTEEL_GEARBOX), Textures.ROBUST_TUNGSTENSTEEL_CASING, false, GTLiteTextures.MEGA_TURBINE_OVERLAY));
        HIGH_PRESSURE_STEAM_TURBINE = registerMultiMetaTileEntity(63, new MetaTileEntityLargeHighPressueSteamTurbine(gtliteId("high_pressure_steam_turbine")));
        SUPERCRITICAL_STEAM_TURBINE = registerMultiMetaTileEntity(64, new MetaTileEntityLargeSupercriticalSteamTurbine(gtliteId("supercritical_steam_turbine")));
        MEGA_HIGH_PRESSURE_STEAM_TURBINE = registerMultiMetaTileEntity(65, new MetaTileEntityMegaTurbine(gtliteId("mega_high_pressure_steam_turbine"), GTLiteRecipeMaps.HIGH_PRESSURE_STEAM_TURBINE_RECIPES, EV, MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.TITANIUM_TURBINE_CASING), MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.TITANIUM_GEARBOX), Textures.STABLE_TITANIUM_CASING, false, GTLiteTextures.MEGA_TURBINE_OVERLAY));
        MEGA_SUPERCRITICAL_STEAM_TURBINE = registerMultiMetaTileEntity(66, new MetaTileEntityMegaTurbine(gtliteId("mega_supercritical_steam_turbine"), GTLiteRecipeMaps.SUPERCRITICAL_STEAM_TURBINE_RECIPES, LuV, GTLiteMetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.MAR_M200_CASING), MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.TUNGSTENSTEEL_GEARBOX), GTLiteTextures.MAR_M200_STEEL_CASING, false, GTLiteTextures.MEGA_TURBINE_OVERLAY));
        LARGE_ROCKET_ENGINE = registerMultiMetaTileEntity(67, new MetaTileEntityLargeRocketEngine(gtliteId("large_rocket_engine")));
        LARGE_BIOMASS_GENERATOR = registerMultiMetaTileEntity(68, new MetaTileEntityLargeBiomassGenerator(gtliteId("large_biomass_generator")));
        NEUTRAL_NETWORK_NEXUS = registerMultiMetaTileEntity(69, new MetaTileEntityNeutralNetworkNexus(gtliteId("neutral_network_nexus")));
        PCB_FACTORY = registerMultiMetaTileEntity(70, new MetaTileEntityPCBFactory(gtliteId("pcb_factory")));
        DANGOTE_DISTILLERY = registerMultiMetaTileEntity(71, new MetaTileEntityDangoteDistillery(gtliteId("dangote_distillery")));
        AMAZON_WAREHOUSING_DEPOT = registerMultiMetaTileEntity(72, new MetaTileEntityAmazonWarehousingDepot(gtliteId("amazon_warehousing_depot")));
        ARC_FURNACE_ARRAY = registerMultiMetaTileEntity(73, new MetaTileEntityArcFurnaceArray(gtliteId("arc_furnace_array")));
        ELECTROLYTIC_TANK = registerMultiMetaTileEntity(74, new MetaTileEntityElectrolyticTank(gtliteId("electrolytic_tank")));
        TURBINE_MIXER = registerMultiMetaTileEntity(75, new MetaTileEntityTurbineMixer(gtliteId("turbine_mixer")));
        INDUSTRIAL_CENTRIFUGE = registerMultiMetaTileEntity(76, new MetaTileEntityIndustrialCentrifuge(gtliteId("industrial_centrifuge")));
        ZHUHAI_FISHING_POND = registerMultiMetaTileEntity(77, new MetaTileEntityZhuHaiFishingPond(gtliteId("zhuhai_fishing_pond")));
        COKING_TOWER = registerMultiMetaTileEntity(78, new MetaTileEntityCokingTower(gtliteId("coking_tower")));
        EXTREME_LARGE_MINER = registerMultiMetaTileEntity(79, new MetaTileEntityAdvancedLargeMiner(gtliteId("large_miner.zpm"), 7, 1, 9, 7, Materials.Protactinium, 64));
        ULTIMATE_LARGE_MINER = registerMultiMetaTileEntity(80, new MetaTileEntityAdvancedLargeMiner(gtliteId("large_miner.uv"), 8, 1, 18, 8, Materials.Einsteinium, 128));
        INFINITY_LARGE_MINER = registerMultiMetaTileEntity(81, new MetaTileEntityAdvancedLargeMiner(gtliteId("large_miner.uhv"), 9, 1, 36, 9, Materials.Mendelevium, 256));
        ADVANCED_FLUID_DRILL_RIG = registerMultiMetaTileEntity(82, new MetaTileEntityAdvancedFluidDrill(gtliteId("fluid_drill_rig.iv"), 5));
        EXTREME_FLUID_DRILL_RIG = registerMultiMetaTileEntity(83, new MetaTileEntityAdvancedFluidDrill(gtliteId("fluid_drill_rig.luv"), 6));
        ULTIMATE_FLUID_DRILL_RIG = registerMultiMetaTileEntity(84, new MetaTileEntityAdvancedFluidDrill(gtliteId("fluid_drill_rig.zpm"), 7));
        INFINITY_FLUID_DRILL_RIG = registerMultiMetaTileEntity(85, new MetaTileEntityAdvancedFluidDrill(gtliteId("fluid_drill_rig.uv"), 8));
        LARGE_CIRCUIT_ASSEMBLY_LINE = registerMultiMetaTileEntity(86, new MetaTileEntityLargeCircuitAssemblyLine(gtliteId("large_circuit_assembly_line")));
        ELECTROMAGNETIC_SEPARATION_PLANT = registerMultiMetaTileEntity(87, new MetaTileEntityElectromagneticSeparationPlant(gtliteId("electromagnetic_separation_plant")));
        LARGE_VACUUM_CHAMBER = registerMultiMetaTileEntity(88, new MetaTileEntityLargeVacuumChamber(gtliteId("large_vacuum_chamber")));
        LARGE_BIO_REACTOR = registerMultiMetaTileEntity(89, new MetaTileEntityLargeBioReactor(gtliteId("large_bio_reactor")));
        LARGE_EUV_MASK_ALIGNER = registerMultiMetaTileEntity(90, new MetaTileEntityLargeEUVMaskAligner(gtliteId("large_euv_mask_aligner")));
        ION_LITHOGRAPHY_FACTORY = registerMultiMetaTileEntity(91, new MetaTileEntityIonLithographyFactory(gtliteId("ion_lithography_factory")));
        LARGE_HIGH_PRESSURE_FORMING_UNIT = registerMultiMetaTileEntity(92, new MetaTileEntityLargeHighPressureFormingUnit(gtliteId("large_high_pressure_forming_unit")));
        LARGE_TURRENT_LATHING_FACTORY = registerMultiMetaTileEntity(93, new MetaTileEntityLargeTurrentLathingFactory(gtliteId("large_turrent_lathing_factory")));
        DYSON_SWARM = registerMultiMetaTileEntity(94, new MetaTileEntityDysonSwarm(gtliteId("dyson_swarm")));
        INTEGRATED_ORE_PROCESSOR = registerMultiMetaTileEntity(95, new MetaTileEntityIntegratedOreProcessor(gtliteId("integrated_ore_processor")));
        LARGE_FLUID_PHASE_TRANSFORMER = registerMultiMetaTileEntity(96, new MetaTileEntityLargeFluidPhaseTransformer(gtliteId("large_fluid_phase_transformer")));
        INDUSTRIAL_VACUUM_CHAMBER = registerMultiMetaTileEntity(97, new MetaTileEntityIndustrialVacuumChamber(gtliteId("industrial_vacuum_chamber")));
        INDUSTRIAL_BIO_REACTOR = registerMultiMetaTileEntity(98, new MetaTileEntityIndustrialBioReactor(gtliteId("industrial_bio_reactor")));
        PLANETARY_GAS_SIPHON = registerMultiMetaTileEntity(99, new MetaTileEntityPlanetaryGasSiphon(gtliteId("planetary_gas_siphon")));
        BIOWARE_SIMULATOR = registerMultiMetaTileEntity(100, new MetaTileEntityBiowareSimulator(gtliteId("bioware_simulator")));
        ALGAE_CULTURE_TANK = registerMultiMetaTileEntity(101, new MetaTileEntityAlgaeCultureTank(gtliteId("algae_culture_tank")));
        LARGE_GAS_COLLECTOR = registerMultiMetaTileEntity(102, new MetaTileEntityLargeGasCollector(gtliteId("large_gas_collector")));
        ULTIMATE_COMBUSTION_ENGINE = registerMultiMetaTileEntity(103, new MetaTileEntityUltimateCombustionEngine(gtliteId("ultimate_combustion_engine"), LuV));
        INDUSTRIAL_INDUCTION_FURNACE = registerMultiMetaTileEntity(104, new MetaTileEntityIndustrialInductionFurnace(gtliteId("industrial_induction_furnace")));
        HORIZONTAL_SHAFT_IMPACT_MACERATOR = registerMultiMetaTileEntity(105, new MetaTileEntityHorizontalShaftImpactMacerator(gtliteId("horizontal_shaft_impact_macerator")));
        TROUGH_TYPE_ORE_WASHER = registerMultiMetaTileEntity(106, new MetaTileEntityTroughTypeOreWasher(gtliteId("trough_type_ore_washer")));
        FIXED_SIFTING_PLANT = registerMultiMetaTileEntity(107, new MetaTileEntityFixedSiftingPlant(gtliteId("fixed_sifting_plant")));
        LARGE_WIREMILL_ARRAY = registerMultiMetaTileEntity(108, new MetaTileEntityLargeWiremillArray(gtliteId("large_wiremill_array")));
        //  Free ID: 109
        ELECTRIC_IMPLOSION_COMPRESSOR = registerMultiMetaTileEntity(110, new MetaTileEntityElectricImplosionCompressor(gtliteId("electric_implosion_compressor")));
        //  111 MATERIAL_TRANSMUTATION_ARRAY
        //  112
        //  113
        //  114
        LARGE_ROCK_BREAKER = registerMultiMetaTileEntity(115, new MetaTileEntityLargeRockBreaker(gtliteId("large_rock_breaker")));
        INDUSTRIAL_ROCK_BREAKER = registerMultiMetaTileEntity(116, new MetaTileEntityIndustrialRockBreaker(gtliteId("industrial_rock_breaker")));
        if (GTLiteConfigHolder.machines.enableUUMatterChain) {
            LARGE_MASS_FABRICATOR = registerMultiMetaTileEntity(117, new MetaTileEntityLargeMassFabricator(gtliteId("large_mass_fabricator")));
            LARGE_REPLICATOR = registerMultiMetaTileEntity(118, new MetaTileEntityLargeReplicator(gtliteId("large_replicator")));
        }
        //  119
        DIMENSIONAL_MIXER = registerMultiMetaTileEntity(120, new MetaTileEntityDimensionalMixer(gtliteId("dimensional_mixer")));
        ALGAE_FARM = registerMultiMetaTileEntity(121, new MetaTileEntityAlgaeFarm(gtliteId("algae_farm")));
        MEGA_BLAST_FURNACE = registerMultiMetaTileEntity(122, new MetaTileEntityMegaBlastFurnace(gtliteId("mega_blast_furnace")));
        MEGA_VACUUM_FREEZER = registerMultiMetaTileEntity(123, new MetaTileEntityMegaVacuumFreezer(gtliteId("mega_vacuum_freezer")));
        //  Free ID: 123-129
        CIRCULATIVE_COOLING_TOWER = registerMultiMetaTileEntity(130, new MetaTileEntityCirculativeCoolingTower(gtliteId("circulative_cooling_tower")));
        //  Free ID: 131-139
        if (Mods.Chisel.isModLoaded()) {
            if (GTLiteConfigHolder.compats.enableChiselModule) {
                LARGE_AUTO_CHISEL = registerMultiMetaTileEntity(140, new MetaTileEntityLargeAutoChisel(gtliteId("large_auto_chisel")));
            }
        }
        //  141
        if (Mods.Chisel.isModLoaded()) {
            if (GTLiteConfigHolder.compats.enableChiselModule) {
                INDUSTRIAL_3D_PRINTER = registerMultiMetaTileEntity(142, new MetaTileEntityIndustrial3DPrinter(gtliteId("industrial_3d_printer")));
            }
        }
        //  Free ID: 143-149
        YOTTA_FLUID_TANK = registerMultiMetaTileEntity(150, new MetaTileEntityYottaFluidTank(gtliteId("yotta_fluid_tank")));
        //  151 TWENTY_FIVE_FLUID_TANK
        ENERGY_SUBSTATION = registerMultiMetaTileEntity(152, new MetaTileEntityEnergySubstation(gtliteId("energy_substation")));
        //  Free ID: 153-199
        DIMENSIONALLY_TRANSCENDENT_PLASMA_FORGE = registerMultiMetaTileEntity(200, new MetaTileEntityDimensionallyTranscendentPlasmaForge(gtliteId("dimensionally_transcendent_plasma_forge")));
        QUANTUM_COMPUTER = registerMultiMetaTileEntity(201, new MetaTileEntityQuantumComputer(gtliteId("quantum_computer")));
        NICOLL_DYSON_BEAMER = registerMultiMetaTileEntity(202, new MetaTileEntityNicollDysonBeamer(gtliteId("nicoll_dyson_beamer")));
        SUPRACHRONAL_NEUTRONIUM_FORGE = registerMultiMetaTileEntity(203, new MetaTileEntitySuprachronalNeutroniumForge(gtliteId("suprachronal_neutronium_forge")));
        MASS_FABRICATOR_CPU = registerMultiMetaTileEntity(204, new MetaTileEntityMassFabricatorCPU(gtliteId("mass_fabricator_cpu")));
        ELEMENT_REPLICATOR = registerMultiMetaTileEntity(205, new MetaTileEntityElementReplicator(gtliteId("element_replicator")));
    }
}
