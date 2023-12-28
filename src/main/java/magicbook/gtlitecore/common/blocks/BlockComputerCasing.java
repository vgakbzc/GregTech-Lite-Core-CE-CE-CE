package magicbook.gtlitecore.common.blocks;

import gregtech.api.block.VariantBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.IStringSerializable;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class BlockComputerCasing extends VariantBlock<BlockComputerCasing.ComputerCasingType> {
    public BlockComputerCasing() {
        super(Material.IRON);
        this.setTranslationKey("computer_casing");
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.METAL);
        this.setHarvestLevel("wrench", 3);
        this.setDefaultState(this.getState(ComputerCasingType.BIOWARE_COMPUTER_CASING));
    }

    public enum ComputerCasingType implements IStringSerializable {
        BIOWARE_COMPUTER_CASING("bioware_computer_casing"),
        ADVANCED_BIOWARE_COMPUTER_CASING("advanced_bioware_computer_casing"),
        BIOWARE_COMPUTER_HEAT_VENT("bioware_computer_heat_vent");

        private final String name;

        ComputerCasingType(String name) {
            this.name = name;
        }

        @Nonnull
        @Override
        public String getName() {
            return name;
        }
    }
}
