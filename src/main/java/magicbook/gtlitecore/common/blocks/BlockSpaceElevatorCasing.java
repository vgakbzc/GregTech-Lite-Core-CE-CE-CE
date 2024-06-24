package magicbook.gtlitecore.common.blocks;

import gregtech.api.block.VariantBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import org.jetbrains.annotations.NotNull;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class BlockSpaceElevatorCasing extends VariantBlock<BlockSpaceElevatorCasing.ElevatorCasingType> {

    public BlockSpaceElevatorCasing() {
        super(Material.IRON);
        this.setTranslationKey("space_elevator_casing");
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.METAL);
        this.setHarvestLevel("wrench", 4);
        this.setDefaultState(this.getState(ElevatorCasingType.BASIC_CASING));
    }

    @Override
    public boolean canCreatureSpawn(@NotNull IBlockState state,
                                    @NotNull IBlockAccess world,
                                    @NotNull BlockPos pos,
                                    @NotNull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public enum ElevatorCasingType implements IStringSerializable {
        BASIC_CASING("basic_casing"),
        INTERNAL_STRUCTURE("internal_structure"),
        SUPPORT_STRUCTURE("support_structure"),
        FLOOR("floor"),
        CABLE_CASING("cable_casing");

        private final String name;

        ElevatorCasingType(String name) {
            this.name = name;
        }

        @NotNull
        @Override
        public String getName() {
            return name;
        }
    }
}
