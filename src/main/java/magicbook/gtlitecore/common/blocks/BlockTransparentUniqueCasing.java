package magicbook.gtlitecore.common.blocks;

import gregtech.api.block.VariantActiveBlock;
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

@ParametersAreNonnullByDefault
public class BlockTransparentUniqueCasing extends VariantActiveBlock<BlockTransparentUniqueCasing.TransparentUniqueCasingType> {

    public BlockTransparentUniqueCasing() {
        super(Material.GLASS);
        this.setTranslationKey("transparent_unique_casing");
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.METAL);
        this.setHarvestLevel("wrench", 4);
        this.setDefaultState(this.getState(TransparentUniqueCasingType.PARTICLE_SUPPRESSION_CASING));
        this.useNeighborBrightness = true;
    }

    @Override
    public boolean canCreatureSpawn(@NotNull IBlockState state,
                                    @NotNull IBlockAccess world,
                                    @NotNull BlockPos pos,
                                    @NotNull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    @Override
    @NotNull
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

    public enum TransparentUniqueCasingType implements IStringSerializable {
        PARTICLE_SUPPRESSION_CASING("particle_suppression_casing"),
        MOLECULAR_CONTAINMENT_CASING("molecular_containment_casing");

        private final String name;

        TransparentUniqueCasingType(String name) {
            this.name = name;
        }

        @NotNull
        @Override
        public String getName() {return this.name;}
    }

}
