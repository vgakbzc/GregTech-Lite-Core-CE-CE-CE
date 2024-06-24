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
public class BlockMultiblockCasing extends VariantBlock<BlockMultiblockCasing.MultiblockCasingType> {

    public BlockMultiblockCasing() {
        super(Material.IRON);
        this.setTranslationKey("multiblock_casing");
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.METAL);
        this.setHarvestLevel("wrench", 2);
        this.setDefaultState(this.getState(MultiblockCasingType.SUBSTRATE_CASING));
    }

    @Override
    public boolean canCreatureSpawn(@NotNull IBlockState state,
                                    @NotNull IBlockAccess world,
                                    @NotNull BlockPos pos,
                                    @NotNull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public enum MultiblockCasingType implements IStringSerializable {
        SUBSTRATE_CASING("substrate_casing"),
        ADVANCED_SUBSTRATE_CASING("advanced_substrate_casing"),
        DRILL_HEAD("drill_head"),
        INCONEL625_CASING("inconel_625_casing"),
        INCONEL625_GEARBOX_CASING("inconel_625_gearbox_casing"),
        HASTELLOY_N_CASING("hastelloy_n_casing"),
        HASTELLOY_N_GEARBOX_CASING("hastelloy_n_gearbox_casing"),
        RED_STEEL_CASING("red_steel_casing"),
        ADVANCED_INVAR_CASING("advanced_invar_casing"),
        ADVANCED_ALUMINIUM_CASING("advanced_aluminium_casing"),
        TALONITE_CASING("talonite_casing"),
        NAQUADRIA_CASING("naquadria_casing"),
        HASTELLOY_X78_CASING("hastelloy_x78_casing"),
        IRIDIUM_CASING("iridium_casing"),
        ASEPTIC_FARM_CASING("aseptic_farm_casing"),
        TRITANIUM_CASING("tritanium_casing");

        private final String name;

        MultiblockCasingType(String name) {
            this.name = name;
        }

        @NotNull
        @Override
        public String getName() {
            return name;
        }
    }
}
