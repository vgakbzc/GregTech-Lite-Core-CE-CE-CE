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
public class BlockUniqueCasing extends VariantBlock<BlockUniqueCasing.UniqueCasingType> {
    public BlockUniqueCasing() {
        super(Material.IRON);
        this.setTranslationKey("unique_casing");
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.METAL);
        this.setHarvestLevel("wrench", 2);
        this.setDefaultState(this.getState(UniqueCasingType.FLOTATION_CELL));
    }

    public boolean canCreatureSpawn(@Nonnull IBlockState state,
                                    @Nonnull IBlockAccess world,
                                    @Nonnull BlockPos pos,
                                    @Nonnull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public enum UniqueCasingType implements IStringSerializable {
        FLOTATION_CELL("flotation_cell"),
        HYPER_CASING("hyper_casing"),
        ADVANCED_HYPER_CASING("advanced_hyper_casing"),
        STELLAR_CONTAINMENT_CASING("stellar_containment_casing"),
        REFLECTIVE_CASING("reflective_casing");

        private final String name;

        UniqueCasingType(String name) {
            this.name = name;
        }

        @Nonnull
        @Override
        public String getName() {
            return name;
        }
    }
}
