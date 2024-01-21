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
public class BlockStructureCasing extends VariantBlock<BlockStructureCasing.StructureCasingType> {
    public BlockStructureCasing() {
        super(Material.IRON);
        this.setTranslationKey("structure_casing");
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.METAL);
        this.setHarvestLevel("wrench", 2);
        this.setDefaultState(this.getState(StructureCasingType.MARAGING_STEEL_250_CASING));
    }

    public boolean canCreatureSpawn(@Nonnull IBlockState state,
                                    @Nonnull IBlockAccess world,
                                    @Nonnull BlockPos pos,
                                    @Nonnull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public enum StructureCasingType implements IStringSerializable {
        MARAGING_STEEL_250_CASING("maraging_steel_250_casing"),
        RURIDIT_CASING("ruridit_casing"),
        OSMIRIDIUM_CASING("osmiridium_casing"); // todo find some application

        private final String name;

        StructureCasingType(String name) {
            this.name = name;
        }

        @Nonnull
        @Override
        public String getName() {
            return name;
        }
    }
}
