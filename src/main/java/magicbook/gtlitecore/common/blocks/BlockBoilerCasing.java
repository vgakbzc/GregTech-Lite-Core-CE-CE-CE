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
public class BlockBoilerCasing extends VariantBlock<BlockBoilerCasing.BoilerCasingType> {

    public BlockBoilerCasing() {
        super(Material.IRON);
        this.setTranslationKey("boiler_casing");
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.METAL);
        this.setHarvestLevel("wrench", 1);
        this.setDefaultState(this.getState(BoilerCasingType.INCONEL625));
    }

    @Override
    public boolean canCreatureSpawn(@NotNull IBlockState state,
                                    @NotNull IBlockAccess world,
                                    @NotNull BlockPos pos,
                                    @NotNull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public enum BoilerCasingType implements IStringSerializable {
        INCONEL625("inconel_625_pipe"),
        HASTELLOY_N("hastelloy_n_pipe"),
        POLYBENZIMIDAZOLE("polybenzimidazole_pipe"),
        LAFIUM("lafium_pipe"),
        BERYLLIUM_SCANDIUM_OXIDE("beryllium_scandium_oxide_pipe");

        private final String name;

        BoilerCasingType(String name) {
            this.name = name;
        }

        @NotNull
        @Override
        public String getName() {
            return name;
        }
    }
}