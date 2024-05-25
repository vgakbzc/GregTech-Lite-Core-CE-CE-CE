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
public class BlockLargeChemicalComplexCasing extends VariantBlock<BlockLargeChemicalComplexCasing.LCCCasingType> {

    public BlockLargeChemicalComplexCasing() {
        super(Material.IRON);
        this.setTranslationKey("large_chemical_complex_casing");
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.METAL);
        this.setHarvestLevel("wrench", 3);
        this.setDefaultState(this.getState(LCCCasingType.CHEMICAL_ACTIVE_CATALYTIC_FRAMEWORK_CASING));
    }

    @Override
    public boolean canCreatureSpawn(@Nonnull IBlockState state,
                                    @Nonnull IBlockAccess world,
                                    @Nonnull BlockPos pos,
                                    @Nonnull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public enum LCCCasingType implements IStringSerializable {
        CHEMICAL_ACTIVE_CATALYTIC_FRAMEWORK_CASING("chemical_active_catalytic_framework_casing"),
        CATALYTIC_BED_SUPPORT_FRAMEWORK_CASING("catalytic_bed_support_framework_casing");

        private final String name;

        LCCCasingType(String name) {
            this.name = name;
        }

        @Nonnull
        @Override
        public String getName() {
            return name;
        }
    }
}
