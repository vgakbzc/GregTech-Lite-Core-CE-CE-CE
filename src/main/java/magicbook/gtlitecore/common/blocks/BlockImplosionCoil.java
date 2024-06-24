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
public class BlockImplosionCoil extends VariantBlock<BlockImplosionCoil.ImplosionCoilType> {

    public BlockImplosionCoil() {
        super(Material.IRON);
        this.setTranslationKey("implosion_coil");
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.METAL);
        this.setHarvestLevel("wrench", 2);
        this.setDefaultState(this.getState(ImplosionCoilType.ORICHALCUM));
    }

    @Override
    public boolean canCreatureSpawn(@NotNull IBlockState state,
                                    @NotNull IBlockAccess world,
                                    @NotNull BlockPos pos,
                                    @NotNull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public enum ImplosionCoilType implements IStringSerializable {
        ORICHALCUM("orichalcum"),                 // UV
        ADAMANTIUM("adamantium"),                 // UHV
        VIBRANIUM("vibranium"),                   // UEV
        INFINITY("infinity"),                     // UIV
        SPACETIME("spacetime"),                   // UXV
        TRANSCENDENT_METAL("transcendent_metal"), // OpV
        ETERNITY("eternity");                     // MAX

        private final String name;

        ImplosionCoilType(String name) {
            this.name = name;
        }

        @NotNull
        @Override
        public String getName() {
            return name;
        }

    }
}
