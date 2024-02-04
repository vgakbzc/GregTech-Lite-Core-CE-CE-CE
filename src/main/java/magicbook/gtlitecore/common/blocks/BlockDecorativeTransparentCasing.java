package magicbook.gtlitecore.common.blocks;

import gregtech.api.block.VariantBlock;
import gregtech.api.items.toolitem.ToolClasses;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Decorative Transparent Casings
 *
 * @author Gate Guardian, Magic_Sweepy
 *
 * <p>This transparent casings are some decorative glasses redo by bartworks.</p>
 */
@ParametersAreNonnullByDefault
public class BlockDecorativeTransparentCasing extends VariantBlock<BlockDecorativeTransparentCasing.DecorativeTransparentCasingType> {

    public BlockDecorativeTransparentCasing() {
        super(Material.GLASS);
        setTranslationKey("decorative_transparent_casing");
        setHardness(5.0F);
        setResistance(10.0F);
        setSoundType(SoundType.GLASS);
        setHarvestLevel(ToolClasses.PICKAXE, 3);
        setDefaultState(this.getState(DecorativeTransparentCasingType.BOROSILICATE_GLASS));
        this.useNeighborBrightness = true;
    }

    @Override
    public boolean canCreatureSpawn(@Nonnull IBlockState state,
                                    @Nonnull IBlockAccess world,
                                    @Nonnull BlockPos pos,
                                    @Nonnull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    @Override
    @Nonnull
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public boolean canRenderInLayer(IBlockState state,
                                    BlockRenderLayer layer) {
        return layer == BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("deprecation")
    public boolean shouldSideBeRendered(IBlockState state,
                                        IBlockAccess world,
                                        BlockPos pos,
                                        EnumFacing side) {
        IBlockState sideState = world.getBlockState(pos.offset(side));

        return sideState.getBlock() == this ?
                getState(sideState) != getState(state) :
                super.shouldSideBeRendered(state, world, pos, side);
    }

    public enum DecorativeTransparentCasingType implements IStringSerializable {
        BOROSILICATE_GLASS("borosilicate_glass"),
        TITANIUM_REINFORCED_BOROSILICATE_GLASS("titanium_reinforced_borosilicate_glass"),
        TUNGSTEN_REINFORCED_BOROSILICATE_GLASS("tungsten_reinforced_borosilicate_glass"),
        OSMIUM_REINFORCED_BOROSILICATE_GLASS("osmium_reinforced_borosilicate_glass"),
        NAQUADAH_REINFORCED_BOROSILICATE_GLASS("naquadah_reinforced_borosilicate_glass"),
        TRINIUM_REINFORCED_BOROSILICATE_GLASS("trinium_reinforced_borosilicate_glass"),
        MITHRIL_REINFORCED_BOROSILICATE_GLASS("mithril_reinforced_borosilicate_glass"),
        NEUTRONIUM_REINFORCED_BOROSILICATE_GLASS("neutronium_reinforced_borosilicate_glass"),
        ABYSSALLOY_REINFORCED_BOROSILICATE_GLASS("abyssalloy_reinforced_borosilicate_glass"),
        HEAVY_QUARK_DEGENERATE_MATTER_REINFORCED_BOROSILICATE_GLASS("heavy_quark_degenerate_matter_reinforced_borosilicate_glass"),
        TRANSCENDENT_METAL_REINFORCED_BOROSILICATE_GLASS("transcendent_metal_reinforced_borosilicate_glass");

        private final String name;

        DecorativeTransparentCasingType(String name) {
            this.name = name;
        }

        @Nonnull
        @Override
        public String getName() {return this.name;}
    }
}
