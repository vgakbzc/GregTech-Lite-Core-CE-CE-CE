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
public class BlockSupportCasing extends VariantBlock<BlockSupportCasing.SupportCasingType> {

    public BlockSupportCasing() {
        super(Material.IRON);
        this.setTranslationKey("support_casing");
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.METAL);
        this.setHarvestLevel("wrench", 2);
        this.setDefaultState(this.getState(SupportCasingType.HASTELLOY_K243_CASING));
    }

    @Override
    public boolean canCreatureSpawn(@NotNull IBlockState state,
                                    @NotNull IBlockAccess world,
                                    @NotNull BlockPos pos,
                                    @NotNull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public enum SupportCasingType implements IStringSerializable {
        HASTELLOY_K243_CASING("hastelloy_k243_casing"),
        SUBSTATION_EXTERNAL_CASING("substation_external_casing"),
        MASS_FABRICATOR_COIL("mass_fabricator_coil"),
        ELEMENT_CONSTRAINED_CASING("element_constrained_casing"),
        MASS_FABRICATOR_CASING("mass_fabricator_casing"),
        HIGH_VOLTAGE_CURRENT_CAPACITOR("high_voltage_current_capacitor");

        private final String name;

        SupportCasingType(String name) {
            this.name = name;
        }

        @NotNull
        @Override
        public String getName() {
            return name;
        }
    }
}
