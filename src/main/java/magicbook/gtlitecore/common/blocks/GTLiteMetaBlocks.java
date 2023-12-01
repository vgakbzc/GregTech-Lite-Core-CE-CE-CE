package magicbook.gtlitecore.common.blocks;

import gregtech.common.blocks.MetaBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GTLiteMetaBlocks {

    public static BlockMultiblockCasing MULTIBLOCK_CASING;
    public static BlockBoilerCasing BOILER_CASING;
    public static BlockUniqueCasing UNIQUE_CASING;
    public static BlockFusionCasing FUSION_CASING;
    public static BlockTransparentCasing TRANSPARENT_CASING;
    public static BlockCrucible CRUCIBLE;

    private GTLiteMetaBlocks() {}

    public static void init() {
        MULTIBLOCK_CASING = new BlockMultiblockCasing();
        MULTIBLOCK_CASING.setRegistryName("multiblock_casing");
        BOILER_CASING = new BlockBoilerCasing();
        BOILER_CASING.setRegistryName("boiler_casing");
        UNIQUE_CASING = new BlockUniqueCasing();
        UNIQUE_CASING.setRegistryName("unique_casing");
        FUSION_CASING = new BlockFusionCasing();
        FUSION_CASING.setRegistryName("fusion_casing");
        TRANSPARENT_CASING = new BlockTransparentCasing();
        TRANSPARENT_CASING.setRegistryName("transparent_casing");
        CRUCIBLE = new BlockCrucible();
        CRUCIBLE.setRegistryName("crucible");
    }

    @SideOnly(Side.CLIENT)
    public static void registerItemModels() {
        registerItemModel(MULTIBLOCK_CASING);
        registerItemModel(BOILER_CASING);
        registerItemModel(UNIQUE_CASING);
        registerItemModel(FUSION_CASING);
        registerItemModel(CRUCIBLE);

        TRANSPARENT_CASING.onModelRegister();
    }

    @SideOnly(Side.CLIENT)
    private static void registerItemModel(Block block) {
        for (IBlockState state : block.getBlockState().getValidStates()) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block),
                    block.getMetaFromState(state),
                    new ModelResourceLocation(block.getRegistryName(),
                            MetaBlocks.statePropertiesToString(state.getProperties())));
        }
    }
}
