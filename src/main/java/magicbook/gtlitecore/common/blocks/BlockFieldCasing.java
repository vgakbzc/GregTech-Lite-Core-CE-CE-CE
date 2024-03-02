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
public class BlockFieldCasing extends VariantBlock<BlockFieldCasing.FieldCasingTier> {

    public BlockFieldCasing() {
        super(Material.IRON);
        this.setTranslationKey("field_casing");
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.METAL);
        this.setHarvestLevel("wrench", 4);
        this.setDefaultState(this.getState(FieldCasingTier.ZPM));
    }

    @Override
    public boolean canCreatureSpawn(@Nonnull IBlockState state,
                                    @Nonnull IBlockAccess world,
                                    @Nonnull BlockPos pos,
                                    @Nonnull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public enum FieldCasingTier implements IStringSerializable {
        ZPM("zpm"),
        UV("uv"),
        UHV("uhv"),
        UEV("uev"),
        UIV("uiv"),
        UXV("uxv"),
        OpV("opv"),
        MAX("max");

        private final String name;

        FieldCasingTier(String name) {
            this.name = name;
        }

        @Nonnull
        @Override
        public String getName() {
            return name;
        }
    }
}