package magicbook.gtlitecore.api;

import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.util.BaseCreativeTab;
import gregtech.common.blocks.BlockMachineCasing;
import gregtech.common.blocks.MetaBlocks;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import magicbook.gtlitecore.api.block.IBlockTier;
import magicbook.gtlitecore.api.block.impl.WrappedIntTier;
import magicbook.gtlitecore.api.metatileentity.multi.IYottaTankData;
import magicbook.gtlitecore.api.unification.GTLiteMaterials;
import magicbook.gtlitecore.common.blocks.*;
import magicbook.gtlitecore.common.items.GTLiteMetaItems;
import net.minecraft.block.state.IBlockState;

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

    public static void init() {

        //  Wire Coil Init
        for (BlockWireCoil.CoilType type : BlockWireCoil.CoilType.values()) {
            HEATING_COILS.put(GTLiteMetaBlocks.WIRE_COIL.getState(type), type);
        }

        //  Yotta Tank Cell Init
        for (BlockYottaTankCell.YottaTankCellTier tier : BlockYottaTankCell.YottaTankCellTier.values()) {
            MAP_YOT_TANK_CELL.put(GTLiteMetaBlocks.YOTTA_TANK_CELL.getState(tier), tier);
        }

        //  Precise Assembler Casing Tier
        MAP_PA_CASING.put(GTLiteMetaBlocks.PRECISE_ASSEMBLER_CASING.getState(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK1),
                new WrappedIntTier(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK1, 1));
        MAP_PA_CASING.put(GTLiteMetaBlocks.PRECISE_ASSEMBLER_CASING.getState(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK2),
                new WrappedIntTier(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK2, 2));
        MAP_PA_CASING.put(GTLiteMetaBlocks.PRECISE_ASSEMBLER_CASING.getState(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK3),
                new WrappedIntTier(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK3, 3));
        MAP_PA_CASING.put(GTLiteMetaBlocks.PRECISE_ASSEMBLER_CASING.getState(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK4),
                new WrappedIntTier(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK4, 4));
        MAP_PA_CASING.put(GTLiteMetaBlocks.PRECISE_ASSEMBLER_CASING.getState(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK5),
                new WrappedIntTier(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK5, 5));
        MAP_PA_CASING.put(GTLiteMetaBlocks.PRECISE_ASSEMBLER_CASING.getState(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK6),
                new WrappedIntTier(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK6, 6));
        MAP_PA_CASING.put(GTLiteMetaBlocks.PRECISE_ASSEMBLER_CASING.getState(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK7),
                new WrappedIntTier(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK7, 7));
        MAP_PA_CASING.put(GTLiteMetaBlocks.PRECISE_ASSEMBLER_CASING.getState(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK8),
                new WrappedIntTier(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK8, 8));
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
        MAP_CA_CASING.put(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getState(BlockComponentAssemblyLineCasing.CasingTier.LV),
                new WrappedIntTier(BlockComponentAssemblyLineCasing.CasingTier.LV, 1));
        MAP_CA_CASING.put(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getState(BlockComponentAssemblyLineCasing.CasingTier.MV),
                new WrappedIntTier(BlockComponentAssemblyLineCasing.CasingTier.MV, 2));
        MAP_CA_CASING.put(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getState(BlockComponentAssemblyLineCasing.CasingTier.HV),
                new WrappedIntTier(BlockComponentAssemblyLineCasing.CasingTier.HV, 3));
        MAP_CA_CASING.put(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getState(BlockComponentAssemblyLineCasing.CasingTier.EV),
                new WrappedIntTier(BlockComponentAssemblyLineCasing.CasingTier.EV, 4));
        MAP_CA_CASING.put(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getState(BlockComponentAssemblyLineCasing.CasingTier.IV),
                new WrappedIntTier(BlockComponentAssemblyLineCasing.CasingTier.IV, 5));
        MAP_CA_CASING.put(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getState(BlockComponentAssemblyLineCasing.CasingTier.LuV),
                new WrappedIntTier(BlockComponentAssemblyLineCasing.CasingTier.LuV, 6));
        MAP_CA_CASING.put(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getState(BlockComponentAssemblyLineCasing.CasingTier.ZPM),
                new WrappedIntTier(BlockComponentAssemblyLineCasing.CasingTier.ZPM, 7));
        MAP_CA_CASING.put(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getState(BlockComponentAssemblyLineCasing.CasingTier.UV),
                new WrappedIntTier(BlockComponentAssemblyLineCasing.CasingTier.UV, 8));
        MAP_CA_CASING.put(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getState(BlockComponentAssemblyLineCasing.CasingTier.UHV),
                new WrappedIntTier(BlockComponentAssemblyLineCasing.CasingTier.UHV, 9));
        MAP_CA_CASING.put(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getState(BlockComponentAssemblyLineCasing.CasingTier.UEV),
                new WrappedIntTier(BlockComponentAssemblyLineCasing.CasingTier.UEV, 10));
        MAP_CA_CASING.put(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getState(BlockComponentAssemblyLineCasing.CasingTier.UIV),
                new WrappedIntTier(BlockComponentAssemblyLineCasing.CasingTier.UIV, 11));
        MAP_CA_CASING.put(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getState(BlockComponentAssemblyLineCasing.CasingTier.UXV),
                new WrappedIntTier(BlockComponentAssemblyLineCasing.CasingTier.UXV, 12));
        MAP_CA_CASING.put(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getState(BlockComponentAssemblyLineCasing.CasingTier.OpV),
                new WrappedIntTier(BlockComponentAssemblyLineCasing.CasingTier.OpV, 13));
        MAP_CA_CASING.put(GTLiteMetaBlocks.COMPONENT_ASSEMBLY_LINE_CASING.getState(BlockComponentAssemblyLineCasing.CasingTier.MAX),
                new WrappedIntTier(BlockComponentAssemblyLineCasing.CasingTier.MAX, 14));

        //  Field Casing Tier
        MAP_FIELD_CASING.put(GTLiteMetaBlocks.FIELD_CASING.getState(BlockFieldCasing.FieldCasingTier.ZPM),
                new WrappedIntTier(BlockFieldCasing.FieldCasingTier.ZPM, 1));
        MAP_FIELD_CASING.put(GTLiteMetaBlocks.FIELD_CASING.getState(BlockFieldCasing.FieldCasingTier.UV),
                new WrappedIntTier(BlockFieldCasing.FieldCasingTier.UV, 2));
        MAP_FIELD_CASING.put(GTLiteMetaBlocks.FIELD_CASING.getState(BlockFieldCasing.FieldCasingTier.UHV),
                new WrappedIntTier(BlockFieldCasing.FieldCasingTier.UHV, 3));
        MAP_FIELD_CASING.put(GTLiteMetaBlocks.FIELD_CASING.getState(BlockFieldCasing.FieldCasingTier.UEV),
                new WrappedIntTier(BlockFieldCasing.FieldCasingTier.UEV, 4));
        MAP_FIELD_CASING.put(GTLiteMetaBlocks.FIELD_CASING.getState(BlockFieldCasing.FieldCasingTier.UIV),
                new WrappedIntTier(BlockFieldCasing.FieldCasingTier.UIV, 5));
        MAP_FIELD_CASING.put(GTLiteMetaBlocks.FIELD_CASING.getState(BlockFieldCasing.FieldCasingTier.UXV),
                new WrappedIntTier(BlockFieldCasing.FieldCasingTier.UXV, 6));
        MAP_FIELD_CASING.put(GTLiteMetaBlocks.FIELD_CASING.getState(BlockFieldCasing.FieldCasingTier.OpV),
                new WrappedIntTier(BlockFieldCasing.FieldCasingTier.OpV, 7));
        MAP_FIELD_CASING.put(GTLiteMetaBlocks.FIELD_CASING.getState(BlockFieldCasing.FieldCasingTier.MAX),
                new WrappedIntTier(BlockFieldCasing.FieldCasingTier.MAX, 8));

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
    }
}