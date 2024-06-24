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

public class BlockActiveMultiblockCasing extends VariantActiveBlock<BlockActiveMultiblockCasing.ActiveCasingType> {

    public BlockActiveMultiblockCasing() {
        super(Material.IRON);
        setTranslationKey("active_multiblock_casing");
        setHardness(5.0f);
        setResistance(10.0f);
        setSoundType(SoundType.METAL);
        setHarvestLevel(ToolClasses.WRENCH, 2);
        setDefaultState(this.getState(ActiveCasingType.HYPER_CORE_MK1));
    }

    @Override
    public boolean canCreatureSpawn(@NotNull IBlockState state,
                                    @NotNull IBlockAccess world,
                                    @NotNull BlockPos pos,
                                    @NotNull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public enum ActiveCasingType implements IStringSerializable {
        HYPER_CORE_MK1("hyper_core_mk1"),
        HYPER_CORE_MK2("hyper_core_mk2"),
        HYPER_CORE_MK3("hyper_core_mk3"),
        MOTOR_CASING_MK1("motor_casing_mk1"),
        MOTOR_CASING_MK2("motor_casing_mk2"),
        MOTOR_CASING_MK3("motor_casing_mk3"),
        MOTOR_CASING_MK4("motor_casing_mk4"),
        MOTOR_CASING_MK5("motor_casing_mk5");

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
