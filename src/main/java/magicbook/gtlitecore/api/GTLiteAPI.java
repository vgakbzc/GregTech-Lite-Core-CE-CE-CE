package magicbook.gtlitecore.api;

import gregtech.api.util.BaseCreativeTab;
import gregtech.common.blocks.BlockMachineCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import magicbook.gtlitecore.api.block.IBlockTier;
import magicbook.gtlitecore.api.block.impl.WrappedIntTier;
import magicbook.gtlitecore.common.blocks.BlockPreciseAssemblerCasing;
import magicbook.gtlitecore.common.blocks.BlockWireCoil;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import net.minecraft.block.state.IBlockState;

import static gregtech.api.GregTechAPI.HEATING_COILS;

public class GTLiteAPI {

    //  Creative Tabs
    public static final BaseCreativeTab TAB_GTLITE = new BaseCreativeTab("gtlite", () -> { return MetaItems.BASIC_TAPE.getStackForm();}, true);

    //  Hash Maps
    public static final Object2ObjectOpenHashMap<IBlockState, IBlockTier> MAP_PA_CASING = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, IBlockTier> MAP_PA_INTERNAL_CASING = new Object2ObjectOpenHashMap<>();

    public static void init() {

        //  Wire Coil Init
        for (BlockWireCoil.CoilType type : BlockWireCoil.CoilType.values()) {
            HEATING_COILS.put(GTLiteMetaBlocks.WIRE_COIL.getState(type), type);
        }

        //  Precise Assembler Casing Tier
        MAP_PA_CASING.put(GTLiteMetaBlocks.PRECISE_ASSEMBLER_CASING.getState(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK1),
                new WrappedIntTier(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK1, 1));
        MAP_PA_CASING.put(GTLiteMetaBlocks.PRECISE_ASSEMBLER_CASING.getState(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK2),
                new WrappedIntTier(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK2, 2));
        MAP_PA_CASING.put(GTLiteMetaBlocks.PRECISE_ASSEMBLER_CASING.getState(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK3),
                new WrappedIntTier(BlockPreciseAssemblerCasing.AssemblyCasingTier.MK3, 3));
        MAP_PA_INTERNAL_CASING.put(MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.LuV),
                new WrappedIntTier(BlockMachineCasing.MachineCasingType.LuV, 1));
        MAP_PA_INTERNAL_CASING.put(MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.ZPM),
                new WrappedIntTier(BlockMachineCasing.MachineCasingType.ZPM, 2));
        MAP_PA_INTERNAL_CASING.put(MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.UV),
                new WrappedIntTier(BlockMachineCasing.MachineCasingType.UV, 3));
    }
}