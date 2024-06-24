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
public class BlockExplosive extends VariantBlock<BlockExplosive.ExplosiveType> {

    public BlockExplosive() {
        super(Material.TNT);
        setTranslationKey("explosive_block");
        setHardness(2.0f);
        setResistance(5.0f);
        setSoundType(SoundType.CLOTH);
        setHarvestLevel("pickaxe", 2);
        setDefaultState(getState(ExplosiveType.NAQUADRIA_CHARGE));
    }

    @Override
    public boolean canCreatureSpawn(@NotNull IBlockState state,
                                    @NotNull IBlockAccess world,
                                    @NotNull BlockPos pos,
                                    @NotNull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public enum ExplosiveType implements IStringSerializable {
        NAQUADRIA_CHARGE("naquadria_charge"),
        TARANIUM_CHARGE("taranium_charge"),
        LEPTONIC_CHARGE("leptonic_charge"),
        QUANTUM_CHROMODYNAMIC_CHARGE("quantum_chromodynamic_charge");

        private final String name;

        ExplosiveType(String name) {
            this.name = name;
        }

        @NotNull
        @Override
        public String getName() {
            return name;
        }
    }
}
