package magicbook.gtlitecore.common.blocks;

import gregtech.api.block.VariantBlock;
import magicbook.gtlitecore.api.utils.GTLiteUtils;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BlockCrucible extends VariantBlock<BlockCrucible.CrucibleType> {

    public BlockCrucible() {
        super(Material.IRON);
        setTranslationKey("crucible");
        setHardness(5.0f);
        setResistance(10.0f);
        setSoundType(SoundType.METAL);
        setHarvestLevel("pickaxe", 1);
        setDefaultState(getState(CrucibleType.BRONZE_CRUCIBLE));
    }

    @Override
    public void addInformation(@NotNull ItemStack stack,
                               @Nullable World world,
                               @NotNull List<String> tooltip,
                               @NotNull ITooltipFlag advanced) {
        super.addInformation(stack, world, tooltip, advanced);
        tooltip.add(I18n.format("gregtech.multiblock.blast_furnace.max_temperature", TextFormatting.RED + GTLiteUtils.formatNumbers(getState(stack).getTemperature()) + "K"));
    }

    public enum CrucibleType implements IStringSerializable {
        BRONZE_CRUCIBLE("bronze", 1696),
        INVAR_CRUCIBLE("invar", 2395),
        QUARTZ_CRUCIBLE("quartz", 2482),
        CHROME_CRUCIBLE("chrome", 2725),
        VANADIUM_CRUCIBLE("vanadium", 2728),
        NIOBIUM_TITANIUM_CRUCIBLE("niobium_titanium", 2931),
        IRIDIUM_CRUCIBLE("iridium", 3398),
        MOLYBDENUM_CRUCIBLE("molybdenum", 3620),
        TUNGSTEN_CRUCIBLE("tungsten", 3695),
        OSMIUM_CRUCIBLE("osmium", 4132),
        GRAPHITE_CRUCIBLE("graphite", 4750),
        BORON_NITRIDE_CRUCIBLE("boron_nitride", 5328);

        private final String name;
        private final int temperature;

        @NotNull
        @Override
        public String getName() {
            return name;
        }

        public int getTemperature() {
            return this.temperature;
        }

        CrucibleType(String name, int temperature) {
            this.name = name;
            this.temperature = temperature;
        }
    }
}
