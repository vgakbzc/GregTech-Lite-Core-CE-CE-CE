package magicbook.gtlitecore.common.blocks;

import gregtech.api.block.VariantActiveBlock;
import gregtech.api.items.toolitem.ToolClasses;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import org.jetbrains.annotations.NotNull;

public class BlockActiveUniqueCasing extends VariantActiveBlock<BlockActiveUniqueCasing.ActiveCasingType> {

    public BlockActiveUniqueCasing() {
        super(Material.IRON);
        setTranslationKey("active_unique_casing");
        setHardness(5.0f);
        setResistance(10.0f);
        setSoundType(SoundType.METAL);
        setHarvestLevel(ToolClasses.WRENCH, 2);
        setDefaultState(this.getState(ActiveCasingType.ADVANCED_ASSEMBLY_LINE_CASING));
    }

    @Override
    public boolean canCreatureSpawn(@NotNull IBlockState state,
                                    @NotNull IBlockAccess world,
                                    @NotNull BlockPos pos,
                                    @NotNull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public enum ActiveCasingType implements IStringSerializable {
        ADVANCED_ASSEMBLY_LINE_CASING("advanced_assembly_line_casing"),
        ADVANCED_ASSEMBLY_CONTROL_CASING("advanced_assembly_control_casing"),
        BIOWARE_COMPUTING_CASING("bioware_computing_casing"),
        ULTIMATE_ENGINE_INTAKE_CASING("ultimate_engine_intake_casing"),
        ADVANCED_CRUSHING_WHEEL("advanced_crushing_wheel"),
        CIRCUIT_ASSEMBLY_LINE_CASING("circuit_assembly_line_casing"),
        ADVANCED_SLICING_BLADE("advanced_slicing_blade");

        private final String name;

        ActiveCasingType(String name) {
            this.name = name;
        }

        @NotNull
        @Override
        public String getName() {
            return this.name;
        }
    }
}
