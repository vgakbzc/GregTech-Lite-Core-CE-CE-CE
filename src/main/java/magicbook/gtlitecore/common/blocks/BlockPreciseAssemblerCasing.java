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
public class BlockPreciseAssemblerCasing extends VariantBlock<BlockPreciseAssemblerCasing.AssemblyCasingTier> {

    public BlockPreciseAssemblerCasing() {
        super(Material.IRON);
        this.setTranslationKey("precise_assembler_casing");
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.METAL);
        this.setHarvestLevel("wrench", 3);
        this.setDefaultState(this.getState(AssemblyCasingTier.MK1));
    }

    @Override
    public boolean canCreatureSpawn(@NotNull IBlockState state,
                                    @NotNull IBlockAccess world,
                                    @NotNull BlockPos pos,
                                    @NotNull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public enum AssemblyCasingTier implements IStringSerializable {
        MK1("mk1"),
        MK2("mk2"),
        MK3("mk3"),
        MK4("mk4"),
        MK5("mk5"),
        MK6("mk6"),
        MK7("mk7"),
        MK8("mk8");

        private final String name;

        AssemblyCasingTier(String name) {
            this.name = name;
        }

        @NotNull
        @Override
        public String getName() {
            return name;
        }
    }
}
