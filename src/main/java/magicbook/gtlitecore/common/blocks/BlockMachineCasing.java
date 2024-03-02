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

    @Override
    public boolean canCreatureSpawn(@Nonnull IBlockState state,
                                    @Nonnull IBlockAccess world,
                                    @Nonnull BlockPos pos,
                                    @Nonnull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public enum MachineCasingType implements IStringSerializable {
        CURIUM_CASING("curium_casing"), // todo find some application
        URANIUM_CASING("uranium_casing"),
        POTIN_CASING("potin_casing"),
        PLUTONIUM_CASING("plutonium_casing"),
        BLACK_STEEL_CASING("black_steel_casing"),
        TUMBAGA_CASING("tumbaga_casing"),
        RHODIUM_PLATED_PALLADIUM_CASING("rhodium_plated_palladium_casing"),
        BERKELIUM_CASING("berkelium_casing"), // todo find some application
        CALIFORNIUM_CASING("californium_casing"), // todo find some application
        NEPTUNIUM_CASING("neptunium_casing"), // todo find some application
        NOBELIUM_CASING("nobelium_casing"), // todo find some application
        LAWRENCIUM_CASING("lawrencium_casing"), // todo find some application
        NIOBIUM_TITANIUM_CASING("niobium_titanium_casing"),
        BOTMIUM_CASING("botmium_casing"),
        LAURENIUM_CASING("laurenium_casing"),
        INCOLOY_DS_CASING("incoloy_ds_casing");

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
