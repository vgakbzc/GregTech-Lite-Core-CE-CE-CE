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
public class BlockMachineCasing extends VariantBlock<BlockMachineCasing.MachineCasingType> {
    public BlockMachineCasing() {
        super(Material.IRON);
        this.setTranslationKey("machine_casing");
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.METAL);
        this.setHarvestLevel("wrench", 2);
        this.setDefaultState(this.getState(MachineCasingType.CURIUM_CASING));
    }

    public boolean canCreatureSpawn(@Nonnull IBlockState state,
                                    @Nonnull IBlockAccess world,
                                    @Nonnull BlockPos pos,
                                    @Nonnull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public enum MachineCasingType implements IStringSerializable {
        CURIUM_CASING("curium_casing"),
        URANIUM_CASING("uranium_casing"),
        POTIN_CASING("potin_casing"),
        PLUTONIUM_CASING("plutonium_casing"),
        BLACK_STEEL_CASING("black_steel_casing");
        //  todo Berkelium
        //  todo Californium
        //  todo Uranium
        //  todo Neptonium
        //  todo Plutonium
        //  and others...

        private final String name;

        MachineCasingType(String name) {
            this.name = name;
        }

        @Nonnull
        @Override
        public String getName() {
            return name;
        }
    }
}
