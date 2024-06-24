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

/**
 * Science Casings
 *
 * @author Technus
 *
 * <p>Some high-tech style blocks from TecTech (on MIT License).</p>
 * <p>Please see <a href="https://github.com/Technus/TecTech">TecTech</a>, these textures are beautiful!</p>
 */
@ParametersAreNonnullByDefault
public class BlockScienceCasing extends VariantBlock<BlockScienceCasing.ScienceCasingType> {

    public BlockScienceCasing() {
        super(Material.IRON);
        this.setTranslationKey("science_casing");
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.METAL);
        this.setHarvestLevel("wrench", 4);
        this.setDefaultState(this.getState(ScienceCasingType.HIGH_ENERGY_CASING));
    }

    @Override
    public boolean canCreatureSpawn(@NotNull IBlockState state,
                                    @NotNull IBlockAccess world,
                                    @NotNull BlockPos pos,
                                    @NotNull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public enum ScienceCasingType implements IStringSerializable {
        HIGH_ENERGY_CASING("high_energy_casing"),
        ADVANCED_HIGH_ENERGY_CASING("advanced_high_energy_casing"),
        ULTIMATE_HIGH_ENERGY_CASING("ultimate_high_energy_casing"),
        MOLECULAR_COIL("molecular_coil"),
        HOLLOW_CASING("hollow_casing"),
        SPACETIME_CASING("spacetime_casing"),
        DIMENSIONAL_BRIDGE_CASING("dimensional_bridge_casing"),
        DIMENSIONAL_PRESERVE_CASING("dimensional_preserve_casing"),
        SINGULARITY_REINFORCED_STELLAR_SHIELDING_CASING("singularity_reinforced_stellar_shielding_casing"),
        CELESTIAL_MATTER_GUIDANCE_CASING("celestial_matter_guidance_casing"),
        BOUNDLESS_GRAVITATIONALLY_SEVERED_STRUCTURE_CASING("boundless_gravitationally_severed_structure_casing"),
        TRANSCENDENTALLY_AMPLIFIED_MAGNETIC_CONFINEMENT_CASING("transcendentally_amplified_magnetic_confinement_casing");

        private final String name;

        ScienceCasingType(String name) {
            this.name = name;
        }

        @NotNull
        @Override
        public String getName() {
            return name;
        }
    }
}
