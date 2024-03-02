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
public class BlockFusionCasing extends VariantBlock<BlockFusionCasing.FusionCasingType> {

    public BlockFusionCasing() {
        super(Material.IRON);
        this.setTranslationKey("fusion_casing");
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.METAL);
        this.setHarvestLevel("wrench", 3);
        this.setDefaultState(this.getState(FusionCasingType.FUSION_CASING_MK4));
    }

    @Override
    public boolean canCreatureSpawn(@Nonnull IBlockState state,
                                    @Nonnull IBlockAccess world,
                                    @Nonnull BlockPos pos,
                                    @Nonnull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public enum FusionCasingType implements IStringSerializable {
        FUSION_CASING_MK4("fusion_casing_mk4"),
        FUSION_CASING_MK5("fusion_casing_mk5"),
        CRYOSTAT("cryostat"),
        ADVANCED_CRYOSTAT("advanced_cryostat"),
        DIVERTOR("divertor"),
        ADVANCED_DIVERTOR("advanced_divertor"),
        VACUUM("vacuum"),
        ADVANCED_VACUUM("advanced_vacuum"),
        FUSION_COIL_MK2("fusion_coil_mk2"),
        FUSION_COIL_MK3("fusion_coil_mk3"),
        FUSION_COIL_MK4("fusion_coil_mk4");

        private final String name;

        FusionCasingType(String name) {
            this.name = name;
        }

        @Nonnull
        @Override
        public String getName() {
            return name;
        }
    }
}
