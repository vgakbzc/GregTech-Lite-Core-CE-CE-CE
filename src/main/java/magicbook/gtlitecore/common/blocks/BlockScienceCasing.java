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
public class BlockScienceCasing extends VariantBlock<BlockScienceCasing.ScienceCasingType> {
    public BlockScienceCasing() {
        super(Material.IRON);
        this.setTranslationKey("science_casing");
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.METAL);
        this.setHarvestLevel("wrench", 4);
        this.setDefaultState(this.getState(ScienceCasingType.HIGH_ENERGY_CASING));
    }

    public boolean canCreatureSpawn(@Nonnull IBlockState state,
                                    @Nonnull IBlockAccess world,
                                    @Nonnull BlockPos pos,
                                    @Nonnull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public enum ScienceCasingType implements IStringSerializable {
        HIGH_ENERGY_CASING("high_energy_casing"),
        ADVANCED_HIGH_ENERGY_CASING("advanced_high_energy_casing"),
        ULTIMATE_HIGH_ENERGY_CASING("ultimate_high_energy_casing"),
        MOLECULAR_COIL("molecular_coil"),
        HOLLOW_CASING("hollow_casing"),
        SPACETIME_CASING("spacetime_casing"),
        DIMENSIONAL_BRIDGE_CASING("dimensional_bridge_casing"),
        DIMENSIONAL_PRESERVE_CASING("dimensional_preserve_casing");

        private final String name;

        ScienceCasingType(String name) {
            this.name = name;
        }

        @Nonnull
        @Override
        public String getName() {
            return name;
        }
    }
}
