package magicbook.gtlitecore.api;

import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.util.BaseCreativeTab;
import gregtech.common.blocks.BlockMachineCasing;
import gregtech.common.blocks.MetaBlocks;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import magicbook.gtlitecore.api.block.IBlockTier;
import magicbook.gtlitecore.api.block.impl.WrappedIntTier;
import magicbook.gtlitecore.api.metatileentity.multi.ICellData;
import magicbook.gtlitecore.api.metatileentity.multi.IYottaTankData;
import magicbook.gtlitecore.api.unification.GTLiteMaterials;
import magicbook.gtlitecore.common.blocks.*;
import magicbook.gtlitecore.common.blocks.components.*;
import magicbook.gtlitecore.common.items.GTLiteMetaItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import static gregtech.api.GregTechAPI.HEATING_COILS;

public class GTLiteAPI {

    //  Creative Tabs
    public static final BaseCreativeTab TAB_GTLITE = new BaseCreativeTab("gtlite", () -> OreDictUnifier.get(OrePrefix.gear, GTLiteMaterials.Legendarium), true);
    public static final BaseCreativeTab TAB_GTLITE_BLOCK = new BaseCreativeTab("gtlite.block", () -> GTLiteMetaBlocks.MACHINE_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockMachineCasing.MachineCasingType.LAURENIUM_CASING), false);
    public static final BaseCreativeTab TAB_GTLITE_BLOCK_DECORATIVE = new BaseCreativeTab("gtlite.decorative_block", () -> GTLiteMetaBlocks.DECORATIVE_TRANSPARENT_CASING.getItemVariant(BlockDecorativeTransparentCasing.DecorativeTransparentCasingType.TITANIUM_REINFORCED_BOROSILICATE_GLASS), false);
    public static final BaseCreativeTab TAB_GTLITE_CIRCUIT = new BaseCreativeTab("gtlite.circuit", () -> GTLiteMetaItems.OPTICAL_PROCESSOR.getStackForm(), false);
    public static final BaseCreativeTab TAB_GTLITE_TOOL = new BaseCreativeTab("gtlite.tool", () -> GTLiteMetaItems.STRUCTURE_WRITER.getStackForm(), false);
    public static final BaseCreativeTab TAB_GTLITE_PARTICLE = new BaseCreativeTab("gtlite.particle", () -> GTLiteMetaItems.ALPHA_PARTICLE.getStackForm(), false);
    public static final BaseCreativeTab TAB_GTLITE_WRAP = new BaseCreativeTab("gtlite.wrap", () -> GTLiteMetaItems.WRAP_PLASTIC_CIRCUIT_BOARD.getStackForm(), false);
    public static final BaseCreativeTab TAB_GTLITE_FOOD = new BaseCreativeTab("gtlite.food", () -> new ItemStack(Items.CAKE), false);
    public static final BaseCreativeTab TAB_GTLITE_AE2_INTEGRATION = new BaseCreativeTab("gtlite.ae2_integration", () -> GTLiteMetaItems.ASTRAL_ARRAY.getStackForm(), false);

    //  Hash Maps
    public static final Object2ObjectOpenHashMap<IBlockState, IBlockTier> MAP_PA_CASING = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, IBlockTier> MAP_PA_INTERNAL_CASING = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, IBlockTier> MAP_CA_CASING = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, IBlockTier> MAP_FIELD_CASING = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, IBlockTier> MAP_SPACE_ELEVATOR_MOTOR = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, IYottaTankData> MAP_YOT_TANK_CELL = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, IBlockTier> MAP_COOLING_CORE = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, IBlockTier> MAP_GRAVITON_CASING = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, IBlockTier> MAP_FUSION_COIL = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, IBlockTier> MAP_IMPLOSION_COIL = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, IBlockTier> MAP_MACHINE_CASING = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, IBlockTier> MAP_ACT_CASING = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, ICellData> MAP_ES_CELLS = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, IBlockTier> MAP_MODULATION_CAVITY = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, IBlockTier> MAP_RESONANT_CAVITY = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, IBlockTier> MAP_MOTOR_CASING = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, IBlockTier> MAP_PISTON_CASING = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, IBlockTier> MAP_ROBOT_ARM_CASING = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, IBlockTier> MAP_PUMP_CASING = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, IBlockTier> MAP_CONVEYOR_CASING = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, IBlockTier> MAP_EMITTER_CASING = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, IBlockTier> MAP_SENSOR_CASING = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, IBlockTier> MAP_FIELD_GEN_CASING = new Object2ObjectOpenHashMap<>();

    public static void init() {

        //  Wire Coil Init
        for (BlockWireCoil.CoilType type : BlockWireCoil.CoilType.values()) {
            HEATING_COILS.put(GTLiteMetaBlocks.WIRE_COIL.getState(type), type);
        }

        //  Yotta Tank Cell Init
        for (BlockYottaTankCell.YottaTankCellTier tier : BlockYottaTankCell.YottaTankCellTier.values()) {
            MAP_YOT_TANK_CELL.put(GTLiteMetaBlocks.YOTTA_TANK_CELL.getState(tier), tier);
        }

        //  Energy Cell Init
        for (BlockEnergyCell.CellTier tier : BlockEnergyCell.CellTier.values()) {
            MAP_ES_CELLS.put(GTLiteMetaBlocks.ENERGY_CELL.getState(tier), tier);
        }

        //  Component Casings Init
        for (BlockMotorCasing.MotorCasingTier tier : BlockMotorCasing.MotorCasingTier.values()) {
            MAP_MOTOR_CASING.put(GTLiteMetaBlocks.MOTOR_CASING.getState(tier),
                    new WrappedIntTier(tier, tier.ordinal() + 1));
        }

        for (BlockPistonCasing.PistonCasingTier tier : BlockPistonCasing.PistonCasingTier.values()) {
            MAP_PISTON_CASING.put(GTLiteMetaBlocks.PISTON_CASING.getState(tier),
                    new WrappedIntTier(tier, tier.ordinal() + 1));
        }

        for (BlockRobotArmCasing.RobotArmCasingTier tier : BlockRobotArmCasing.RobotArmCasingTier.values()) {
            MAP_ROBOT_ARM_CASING.put(GTLiteMetaBlocks.ROBOT_ARM_CASING.getState(tier),
                    new WrappedIntTier(tier, tier.ordinal() + 1));
        }

        for (BlockPumpCasing.PumpCasingTier tier : BlockPumpCasing.PumpCasingTier.values()) {
            MAP_PUMP_CASING.put(GTLiteMetaBlocks.PUMP_CASING.getState(tier),
                    new WrappedIntTier(tier, tier.ordinal() + 1));
        }

        for (BlockConveyorCasing.ConveyorCasingTier tier : BlockConveyorCasing.ConveyorCasingTier.values()) {
            MAP_CONVEYOR_CASING.put(GTLiteMetaBlocks.CONVEYOR_CASING.getState(tier),
                    new WrappedIntTier(tier, tier.ordinal() + 1));
        }

        for (BlockEmitterCasing.EmitterCasingTier tier : BlockEmitterCasing.EmitterCasingTier.values()) {
            MAP_EMITTER_CASING.put(GTLiteMetaBlocks.EMITTER_CASING.getState(tier),
                    new WrappedIntTier(tier, tier.ordinal() + 1));
        }

        for (BlockSensorCasing.SensorCasingTier tier : BlockSensorCasing.SensorCasingTier.values()) {
            MAP_SENSOR_CASING.put(GTLiteMetaBlocks.SENSOR_CASING.getState(tier),
                    new WrappedIntTier(tier, tier.ordinal() + 1));
        }

        for (BlockFieldGenCasing.FieldGenCasingTier tier : BlockFieldGenCasing.FieldGenCasingTier.values()) {
            MAP_FIELD_GEN_CASING.put(GTLiteMetaBlocks.FIELD_GEN_CASING.getState(tier),
                    new WrappedIntTier(tier, tier.ordinal() + 1));
        }

        //  Precise Assembler Casing Tier
        for (BlockPreciseAssemblerCasing.AssemblyCasingTier tier : BlockPreciseAssemblerCasing.AssemblyCasingTier.values()) {
            MAP_PA_CASING.put(GTLiteMetaBlocks.PRECISE_ASSEMBLER_CASING.getState(tier),
                    new WrappedIntTier(tier, tier.ordinal() + 1));
        }

        MAP_PA_INTERNAL_CASING.put(MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.LuV),
                new WrappedIntTier(BlockMachineCasing.MachineCasingType.LuV, 1));
        MAP_PA_INTERNAL_CASING.put(MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.ZPM),
                new WrappedIntTier(BlockMachineCasing.MachineCasingType.ZPM, 2));
        MAP_PA_INTERNAL_CASING.put(MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.UV),
                new WrappedIntTier(BlockMachineCasing.MachineCasingType.UV, 3));
        MAP_PA_INTERNAL_CASING.put(MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.UHV),
                new WrappedIntTier(BlockMachineCasing.MachineCasingType.UHV, 4));
        MAP_PA_INTERNAL_CASING.put(MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.UEV),
                new WrappedIntTier(BlockMachineCasing.MachineCasingType.UEV, 5));
        MAP_PA_INTERNAL_CASING.put(MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.UIV),
                new WrappedIntTier(BlockMachineCasing.MachineCasingType.UIV, 6));
        MAP_PA_INTERNAL_CASING.put(MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.UXV),
                new WrappedIntTier(BlockMachineCasing.MachineCasingType.UXV, 7));
        MAP_PA_INTERNAL_CASING.put(MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.OpV),
                new WrappedIntTier(BlockMachineCasing.MachineCasingType.OpV, 8));

        //  Component Assembly Line Casing Tier
        for (BlockComponentAssemblyLineCasing.CasingTier tier : BlockComponentAssemblyLineCasing.CasingTier.values()) {
            MAP_CA_CASING.put(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getState(tier),
                    new WrappedIntTier(tier, tier.ordinal() + 1));
        }

        //  Field Casing Tier
        for (BlockFieldCasing.FieldCasingTier tier : BlockFieldCasing.FieldCasingTier.values()) {
            MAP_FIELD_CASING.put(GTLiteMetaBlocks.FIELD_CASING.getState(tier),
                    new WrappedIntTier(tier, tier.ordinal() + 1));
        }

        //  Space Elevator Motor Tier
        MAP_SPACE_ELEVATOR_MOTOR.put(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getState(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK1),
                new WrappedIntTier(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK1, 1));
        MAP_SPACE_ELEVATOR_MOTOR.put(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getState(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK2),
                new WrappedIntTier(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK2, 2));
        MAP_SPACE_ELEVATOR_MOTOR.put(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getState(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK3),
                new WrappedIntTier(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK3, 3));
        MAP_SPACE_ELEVATOR_MOTOR.put(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getState(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK4),
                new WrappedIntTier(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK4, 4));
        MAP_SPACE_ELEVATOR_MOTOR.put(GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getState(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK5),
                new WrappedIntTier(BlockActiveMultiblockCasing.ActiveCasingType.MOTOR_CASING_MK5, 5));

        //  Cooling Core
        MAP_COOLING_CORE.put(GTLiteMetaBlocks.COOLING_CORE.getState(BlockCoolingCore.CoolingCoreTier.MK1),
                new WrappedIntTier(BlockCoolingCore.CoolingCoreTier.MK1, 1));

        MAP_COOLING_CORE.put(GTLiteMetaBlocks.COOLING_CORE.getState(BlockCoolingCore.CoolingCoreTier.MK2),
                new WrappedIntTier(BlockCoolingCore.CoolingCoreTier.MK2, 2));

        MAP_COOLING_CORE.put(GTLiteMetaBlocks.COOLING_CORE.getState(BlockCoolingCore.CoolingCoreTier.MK3),
                new WrappedIntTier(BlockCoolingCore.CoolingCoreTier.MK3, 3));

        MAP_COOLING_CORE.put(GTLiteMetaBlocks.COOLING_CORE.getState(BlockCoolingCore.CoolingCoreTier.MK4),
                new WrappedIntTier(BlockCoolingCore.CoolingCoreTier.MK4, 4));

        //  Graviton Casing
        MAP_GRAVITON_CASING.put(GTLiteMetaBlocks.GRAVITON_CASING.getState(BlockGravitonCasing.GravitonCasingType.REMOTE_GRAVITON_FLOW_MODULATOR),
                new WrappedIntTier(BlockGravitonCasing.GravitonCasingType.REMOTE_GRAVITON_FLOW_MODULATOR, 1));

        MAP_GRAVITON_CASING.put(GTLiteMetaBlocks.GRAVITON_CASING.getState(BlockGravitonCasing.GravitonCasingType.MEDIAL_GRAVITON_FLOW_MODULATOR),
                new WrappedIntTier(BlockGravitonCasing.GravitonCasingType.MEDIAL_GRAVITON_FLOW_MODULATOR, 2));

        MAP_GRAVITON_CASING.put(GTLiteMetaBlocks.GRAVITON_CASING.getState(BlockGravitonCasing.GravitonCasingType.CENTRAL_GRAVITON_FLOW_MODULATOR),
                new WrappedIntTier(BlockGravitonCasing.GravitonCasingType.CENTRAL_GRAVITON_FLOW_MODULATOR, 3));

        //  Fusion Coil
        MAP_FUSION_COIL.put(MetaBlocks.FUSION_CASING.getState(gregtech.common.blocks.BlockFusionCasing.CasingType.SUPERCONDUCTOR_COIL),
                new WrappedIntTier(gregtech.common.blocks.BlockFusionCasing.CasingType.SUPERCONDUCTOR_COIL, 1));

        MAP_FUSION_COIL.put(MetaBlocks.FUSION_CASING.getState(gregtech.common.blocks.BlockFusionCasing.CasingType.FUSION_COIL),
                new WrappedIntTier(gregtech.common.blocks.BlockFusionCasing.CasingType.FUSION_COIL, 2));

        MAP_FUSION_COIL.put(GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.FUSION_COIL_MK2),
                new WrappedIntTier(BlockFusionCasing.FusionCasingType.FUSION_COIL_MK2, 3));

        MAP_FUSION_COIL.put(GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.FUSION_COIL_MK3),
                new WrappedIntTier(BlockFusionCasing.FusionCasingType.FUSION_COIL_MK3, 4));

        MAP_FUSION_COIL.put(GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.FUSION_COIL_MK4),
                new WrappedIntTier(BlockFusionCasing.FusionCasingType.FUSION_COIL_MK4, 5));

        //  Implosion Coil
        MAP_IMPLOSION_COIL.put(GTLiteMetaBlocks.IMPLOSION_COIL.getState(BlockImplosionCoil.ImplosionCoilType.ORICHALCUM),
                new WrappedIntTier(BlockImplosionCoil.ImplosionCoilType.ORICHALCUM, 1));

        MAP_IMPLOSION_COIL.put(GTLiteMetaBlocks.IMPLOSION_COIL.getState(BlockImplosionCoil.ImplosionCoilType.ADAMANTIUM),
                new WrappedIntTier(BlockImplosionCoil.ImplosionCoilType.ADAMANTIUM, 2));

        MAP_IMPLOSION_COIL.put(GTLiteMetaBlocks.IMPLOSION_COIL.getState(BlockImplosionCoil.ImplosionCoilType.VIBRANIUM),
                new WrappedIntTier(BlockImplosionCoil.ImplosionCoilType.VIBRANIUM, 3));

        MAP_IMPLOSION_COIL.put(GTLiteMetaBlocks.IMPLOSION_COIL.getState(BlockImplosionCoil.ImplosionCoilType.INFINITY),
                new WrappedIntTier(BlockImplosionCoil.ImplosionCoilType.INFINITY, 4));

        MAP_IMPLOSION_COIL.put(GTLiteMetaBlocks.IMPLOSION_COIL.getState(BlockImplosionCoil.ImplosionCoilType.SPACETIME),
                new WrappedIntTier(BlockImplosionCoil.ImplosionCoilType.SPACETIME, 5));

        MAP_IMPLOSION_COIL.put(GTLiteMetaBlocks.IMPLOSION_COIL.getState(BlockImplosionCoil.ImplosionCoilType.TRANSCENDENT_METAL),
                new WrappedIntTier(BlockImplosionCoil.ImplosionCoilType.TRANSCENDENT_METAL, 6));

        MAP_IMPLOSION_COIL.put(GTLiteMetaBlocks.IMPLOSION_COIL.getState(BlockImplosionCoil.ImplosionCoilType.ETERNITY),
                new WrappedIntTier(BlockImplosionCoil.ImplosionCoilType.ETERNITY, 7));

        //  Machine Casing
        for (BlockMachineCasing.MachineCasingType tier : BlockMachineCasing.MachineCasingType.values()) {
            MAP_MACHINE_CASING.put(MetaBlocks.MACHINE_CASING.getState(tier),
                    new WrappedIntTier(tier, tier.ordinal()));
        }

        //  Algae Culture Tank Casing
        MAP_ACT_CASING.put(MetaBlocks.METAL_CASING.getState(gregtech.common.blocks.BlockMetalCasing.MetalCasingType.STAINLESS_CLEAN),
                new WrappedIntTier(gregtech.common.blocks.BlockMetalCasing.MetalCasingType.STAINLESS_CLEAN, 1));

        MAP_ACT_CASING.put(GTLiteMetaBlocks.STRUCTURE_CASING.getState(BlockStructureCasing.StructureCasingType.DURALUMINIUM_ALLOY_CASING),
                new WrappedIntTier(BlockStructureCasing.StructureCasingType.DURALUMINIUM_ALLOY_CASING, 2));

        MAP_ACT_CASING.put(GTLiteMetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.AUSTENITIC_STAINLESS_STEEL_CASING),
                new WrappedIntTier(BlockMetalCasing.MetalCasingType.AUSTENITIC_STAINLESS_STEEL_CASING, 3));

        MAP_ACT_CASING.put(GTLiteMetaBlocks.MACHINE_CASING.getState(magicbook.gtlitecore.common.blocks.BlockMachineCasing.MachineCasingType.NIOBIUM_TITANIUM_CASING),
                new WrappedIntTier(magicbook.gtlitecore.common.blocks.BlockMachineCasing.MachineCasingType.NIOBIUM_TITANIUM_CASING, 4));

        MAP_ACT_CASING.put(GTLiteMetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.FERMIUM_CASING),
                new WrappedIntTier(BlockMetalCasing.MetalCasingType.FERMIUM_CASING, 5));

        //  Modulation Cavity
        MAP_MODULATION_CAVITY.put(GTLiteMetaBlocks.MODULATION_CAVITY.getState(BlockModulationCavity.ModulationCavityTier.I),
                new WrappedIntTier(BlockModulationCavity.ModulationCavityTier.I, 1));

        MAP_MODULATION_CAVITY.put(GTLiteMetaBlocks.MODULATION_CAVITY.getState(BlockModulationCavity.ModulationCavityTier.II),
                new WrappedIntTier(BlockModulationCavity.ModulationCavityTier.II, 2));

        MAP_MODULATION_CAVITY.put(GTLiteMetaBlocks.MODULATION_CAVITY.getState(BlockModulationCavity.ModulationCavityTier.III),
                new WrappedIntTier(BlockModulationCavity.ModulationCavityTier.III, 3));

        MAP_MODULATION_CAVITY.put(GTLiteMetaBlocks.MODULATION_CAVITY.getState(BlockModulationCavity.ModulationCavityTier.IV),
                new WrappedIntTier(BlockModulationCavity.ModulationCavityTier.IV, 4));

        //  Resonant Cavity
        MAP_RESONANT_CAVITY.put(GTLiteMetaBlocks.RESONANT_CAVITY.getState(BlockResonantCavity.ResonantCavityTier.I),
                new WrappedIntTier(BlockResonantCavity.ResonantCavityTier.I, 1));

        MAP_RESONANT_CAVITY.put(GTLiteMetaBlocks.RESONANT_CAVITY.getState(BlockResonantCavity.ResonantCavityTier.II),
                new WrappedIntTier(BlockResonantCavity.ResonantCavityTier.II, 2));

        MAP_RESONANT_CAVITY.put(GTLiteMetaBlocks.RESONANT_CAVITY.getState(BlockResonantCavity.ResonantCavityTier.III),
                new WrappedIntTier(BlockResonantCavity.ResonantCavityTier.III, 3));

        MAP_RESONANT_CAVITY.put(GTLiteMetaBlocks.RESONANT_CAVITY.getState(BlockResonantCavity.ResonantCavityTier.IV),
                new WrappedIntTier(BlockResonantCavity.ResonantCavityTier.IV, 4));

    }
}