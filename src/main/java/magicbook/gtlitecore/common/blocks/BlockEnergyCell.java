package magicbook.gtlitecore.common.blocks;

import gregtech.api.block.VariantBlock;
import magicbook.gtlitecore.api.metatileentity.multi.ICellData;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@ParametersAreNonnullByDefault
public class BlockEnergyCell extends VariantBlock<BlockEnergyCell.CellTier> {

    public BlockEnergyCell() {
        super(Material.IRON);
        this.setTranslationKey("energy_cell");
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.METAL);
        this.setHarvestLevel("wrench", 3);
        this.setDefaultState(this.getState(BlockEnergyCell.CellTier.HV));
    }

    @Override
    public boolean canCreatureSpawn(@NotNull IBlockState state,
                                    @NotNull IBlockAccess world,
                                    @NotNull BlockPos pos,
                                    @NotNull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    @Override
    public void addInformation(@NotNull ItemStack stack,
                               @Nullable World world,
                               @NotNull List<String> tooltip,
                               @NotNull ITooltipFlag advanced) {
        super.addInformation(stack, world, tooltip, advanced);
        CellTier cellTier = this.getState(stack);
        if (cellTier.getCapacity() != 0L) {
            tooltip.add(I18n.format("gregtech.universal.tooltip.energy_storage_capacity", cellTier.getCapacity()));
        }
    }

    public static long cellCapacityBase = 25000000L;

    public enum CellTier implements IStringSerializable, ICellData {
        HV(1, cellCapacityBase),
        EV(2, (long) (cellCapacityBase * Math.pow(4, 1))),
        IV(3, (long) (cellCapacityBase * Math.pow(4, 2))),
        LuV(4, (long) (cellCapacityBase * Math.pow(4, 3))),
        ZPM(5, (long) (cellCapacityBase * Math.pow(4, 4))),
        UV(6, (long) (cellCapacityBase * Math.pow(4, 5))),
        UHV(7, (long) (cellCapacityBase * Math.pow(4, 6))),
        UEV(8, (long) (cellCapacityBase * Math.pow(4, 7))),
        UIV(9, (long) (cellCapacityBase * Math.pow(4, 8))),
        UXV(10, (long) (cellCapacityBase * Math.pow(4, 9))),
        OpV(11, (long) (cellCapacityBase * Math.pow(4, 10))),
        MAX(12, Math.min((long) (cellCapacityBase * Math.pow(4, 11)), Long.MAX_VALUE));

        private final int tier;
        private final long capacity;

        CellTier(int tier, long capacity) {
            this.tier = tier;
            this.capacity = capacity;
        }

        @Override
        public int getTier() {
            return this.tier;
        }

        @Override
        public long getCapacity() {
            return this.capacity;
        }

        @NotNull
        @Override
        public String getCellName() {
            return this.name().toLowerCase();
        }

        @NotNull
        @Override
        public String getName() {
            return this.getCellName();
        }
    }
}
