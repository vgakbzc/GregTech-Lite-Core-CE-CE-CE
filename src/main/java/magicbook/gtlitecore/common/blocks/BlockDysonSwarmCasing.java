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
public class BlockDysonSwarmCasing extends VariantBlock<BlockDysonSwarmCasing.DysonSwarmCasingType> {

    public BlockDysonSwarmCasing() {
        super(Material.IRON);
        this.setTranslationKey("dyson_swarm_casing");
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.METAL);
        this.setHarvestLevel("wrench", 3);
        this.setDefaultState(this.getState(DysonSwarmCasingType.CONTROL_CASING));
    }

    @Override
    public boolean canCreatureSpawn(@Nonnull IBlockState state,
                                    @Nonnull IBlockAccess world,
                                    @Nonnull BlockPos pos,
                                    @Nonnull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public enum DysonSwarmCasingType implements IStringSerializable {
        CONTROL_CASING("control_casing"),
        CONTROL_PRIMARY("control_primary"),
        CONTROL_SECONDARY("control_secondary"),
        CONTROL_TOROID("control_toroid"),
        DEPLOYMENT_CASING("deployment_casing"),
        DEPLOYMENT_MAGNET("deployment_magnet"),
        RECEIVER_CASING("receiver_casing"),
        HYPOGEN_COIL_BLOCK("hypogen_coil_block"),
        DEPLOYMENT_CORE("deployment_core");

        private final String name;

        DysonSwarmCasingType(String name) {
            this.name = name;
        }

        @Nonnull
        @Override
        public String getName() {
            return name;
        }
    }
}
