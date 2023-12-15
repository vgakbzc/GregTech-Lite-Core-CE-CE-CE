package magicbook.gtlitecore.common.blocks;

import gregtech.api.block.VariantBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class BlockMetalCasing extends VariantBlock<BlockMetalCasing.MetalCasingType> {
    public BlockMetalCasing() {
        super(Material.IRON);
        this.setTranslationKey("metal_casing");
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.METAL);
        this.setHarvestLevel("wrench", 2);
        this.setDefaultState(this.getState(MetalCasingType.ZIRCONIUM_CARBIDE_CASING));
    }

    public boolean canCreatureSpawn(@Nonnull IBlockState state,
                                    @Nonnull IBlockAccess world,
                                    @Nonnull BlockPos pos,
                                    @Nonnull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public enum MetalCasingType implements IStringSerializable {
        ZIRCONIUM_CARBIDE_CASING("zirconium_carbide_casing"),
        STABALLOY_CASING("staballoy_casing"),
        QUANTUM_CASING("quantum_casing"),
        HG1223_CASING("hg_1223_casing"),
        EGLIN_STEEL_CASING("eglin_steel_casing"),
        INCONEL_792_CASING("inconel_792_casing");

        private final String name;

        MetalCasingType(String name) {
            this.name = name;
        }

        @Nonnull
        @Override
        public String getName() {
            return name;
        }
    }
}
