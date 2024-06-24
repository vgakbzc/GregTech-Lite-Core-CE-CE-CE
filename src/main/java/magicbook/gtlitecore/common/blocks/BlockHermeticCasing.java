package magicbook.gtlitecore.common.blocks;

import gregtech.api.block.VariantBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class BlockHermeticCasing extends VariantBlock<BlockHermeticCasing.HermeticCasingType> {

    public BlockHermeticCasing() {
        super(Material.IRON);
        this.setTranslationKey("hermetic_casing");
        this.setHardness(2.0F);
        this.setResistance(8.0F);
        this.setSoundType(SoundType.METAL);
        this.setHarvestLevel("wrench", 1);
        this.setDefaultState(this.getState(HermeticCasingType.HERMETIC_UEV));
    }

    @Override
    public boolean canCreatureSpawn(@NotNull IBlockState state,
                                    @NotNull IBlockAccess world,
                                    @NotNull BlockPos pos,
                                    @NotNull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    @NotNull
    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    public enum HermeticCasingType implements IStringSerializable {
        HERMETIC_UEV("uev"),
        HERMETIC_UIV("uiv"),
        HERMETIC_UXV("uxv"),
        HERMETIC_OpV("opv"),
        HERMETIC_MAX("max");

        private final String name;

        HermeticCasingType(String name) {
            this.name = name;
        }

        @NotNull
        @Override
        public String getName() {
            return name;
        }
    }
}