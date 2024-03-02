package magicbook.gtlitecore.common.blocks;

import gregtech.api.block.VariantBlock;
import magicbook.gtlitecore.api.metatileentity.multi.IYottaTankData;
import magicbook.gtlitecore.api.utils.GTLiteUtils;
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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

import static gregtech.api.GTValues.*;

@ParametersAreNonnullByDefault
public class BlockYottaTankCell extends VariantBlock<BlockYottaTankCell.YottaTankCellTier> {

    public BlockYottaTankCell() {
        super(Material.IRON);
        this.setTranslationKey("yotta_tank_cell");
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.METAL);
        this.setHarvestLevel("wrench", 2);
        setDefaultState(this.getState(YottaTankCellTier.T1));
    }

    @Override
    public boolean canCreatureSpawn(@Nonnull IBlockState state,
                                    @Nonnull IBlockAccess world,
                                    @Nonnull BlockPos pos,
                                    @Nonnull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    @Override
    public void addInformation(@Nonnull ItemStack stack,
                               @Nullable World world,
                               @Nonnull List<String> tooltip,
                               @Nonnull ITooltipFlag advanced) {
        super.addInformation(stack, world, tooltip, advanced);
        tooltip.add(I18n.format("gtlitecore.machine.yotta_fluid_tank.cell_capacitor", GTLiteUtils.formatNumbers(getState(stack).getCapacity())));
    }

    public enum YottaTankCellTier implements IStringSerializable, IYottaTankData {
        T1(LV, 1000000L),
        T2(MV, 100000000L),
        T3(HV, 10000000000L),
        T4(EV, 1000000000000L),
        T5(IV, 100000000000000L),
        T6(LuV, 10000000000000000L),
        T7(ZPM, 1000000000000000000L),
        T8(UV, 3000000000000000000L),
        T9(UHV, 5000000000000000000L),
        T10(UEV, Long.MAX_VALUE);

        private final int tier;
        private final long capacity;

        YottaTankCellTier() {
            this.tier = -1;
            this.capacity = 0;
        }

        YottaTankCellTier(int tier, long capacity) {
            this.tier = tier;
            this.capacity = capacity;
        }

        @Override
        public int getTier() {
            return tier;
        }

        @Override
        public long getCapacity() {
            return capacity;
        }

        @Nonnull
        @Override
        public String getFluidCellName() {
            return name().toLowerCase();
        }

        @Nonnull
        @Override
        public String getName() {
            return getFluidCellName();
        }
    }
}
