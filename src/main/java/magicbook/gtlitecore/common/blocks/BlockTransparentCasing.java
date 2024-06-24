package magicbook.gtlitecore.common.blocks;

import gregtech.api.block.VariantActiveBlock;
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

import org.jetbrains.annotations.NotNull;
import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Transparent Casing
 *
 * @author Gate Guardian, Technus, TechLoad22
 *
 * <p>Transparent casings from my friends Gate Guardian's works, TecTech and Gregicality Science.</p>
 */
@ParametersAreNonnullByDefault
public class BlockTransparentCasing extends VariantActiveBlock<BlockTransparentCasing.TransparentCasingType> {

    public BlockTransparentCasing() {
        super(Material.GLASS);
        this.setTranslationKey("transparent_casing");
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.GLASS);
        this.setHarvestLevel(ToolClasses.PICKAXE, 3);
        this.setDefaultState(this.getState(TransparentCasingType.BPA_POLYCARBONATE_GLASS));
        this.useNeighborBrightness = true;
    }

    @Override
    public boolean canCreatureSpawn(@NotNull IBlockState state,
                                    @NotNull IBlockAccess world,
                                    @NotNull BlockPos pos,
                                    @NotNull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    @NotNull
    @Override
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

    public enum TransparentCasingType implements IStringSerializable {
        BPA_POLYCARBONATE_GLASS("bpa_polycarbonate_glass"),
        PMMA_GLASS("pmma_glass"),
        CBDO_POLYCARBONATE_GLASS("cbdo_polycarbonate_glass"),
        INFINITY_GLASS("infinity_glass"),
        QUANTUM_GLASS("quantum_glass"),
        SPATIALLY_TRANSCENDENT_GRAVITATIONAL_LENS("spatially_transcendent_gravitational_lens");

        private final String name;

        TransparentCasingType(String name) {
            this.name = name;
        }
        @NotNull
        @Override
        public String getName() {return this.name;}
    }
}
