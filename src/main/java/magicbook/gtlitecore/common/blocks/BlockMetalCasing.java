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
public class BlockMetalCasing extends VariantBlock<BlockMetalCasing.MetalCasingType> {

    public BlockMetalCasing() {
        super(Material.IRON);
        this.setTranslationKey("metal_casing");
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.METAL);
        this.setHarvestLevel("wrench", 2);
        this.setDefaultState(this.getState(MetalCasingType.ZIRCONIUM_CARBIDE_CASING));
    }

    @Override
    public boolean canCreatureSpawn(@NotNull IBlockState state,
                                    @NotNull IBlockAccess world,
                                    @NotNull BlockPos pos,
                                    @NotNull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public enum MetalCasingType implements IStringSerializable {
        ZIRCONIUM_CARBIDE_CASING("zirconium_carbide_casing"),
        STABALLOY_CASING("staballoy_casing"),
        QUANTUM_CASING("quantum_casing"),
        HG1223_CASING("hg_1223_casing"),
        EGLIN_STEEL_CASING("eglin_steel_casing"),
        INCONEL_792_CASING("inconel_792_casing"),
        AUSTENITIC_STAINLESS_STEEL_CASING("austenitic_stainless_steel_casing"),
        MAR_M200_CASING("mar_m200_casing"),
        HSS_S_CASING("hss_s_casing"),
        EINSTEINIUM_CASING("einsteinium_casing"),
        NITINOL_60_CASING("nitinol_60_casing"),
        MENDELEVIUM_CASING("mendelevium_casing"),
        FERMIUM_CASING("fermium_casing"),
        PROTACTINIUM_CASING("protactinium_casing"),
        HSS_G_CASING("hss_g_casing"),
        INCOLOY_MA_813_CASING("incoloy_ma_813_casing");

        private final String name;

        MetalCasingType(String name) {
            this.name = name;
        }

        @NotNull
        @Override
        public String getName() {
            return name;
        }
    }
}
