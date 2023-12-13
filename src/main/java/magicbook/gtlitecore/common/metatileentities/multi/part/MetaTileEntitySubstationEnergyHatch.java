package magicbook.gtlitecore.common.metatileentities.multi.part;

import magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;

public class MetaTileEntitySubstationEnergyHatch extends gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntitySubstationEnergyHatch {

    public MetaTileEntitySubstationEnergyHatch(ResourceLocation metaTileEntityId,
                                               int tier,
                                               int amperage,
                                               boolean isExport) {
        super(metaTileEntityId, tier, amperage, isExport);
    }

    @Override
    public void getSubItems(CreativeTabs creativeTab, NonNullList<ItemStack> subItems) {
        for (gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntitySubstationEnergyHatch hatch : GTLiteMetaTileEntities.SUBSTATION_INPUT_ENERGY_HATCH) {
            if (hatch != null)
                subItems.add(hatch.getStackForm());
        }

        for (gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntitySubstationEnergyHatch hatch : GTLiteMetaTileEntities.SUBSTATION_OUTPUT_ENERGY_HATCH) {
            if (hatch != null)
                subItems.add(hatch.getStackForm());
        }
    }
}
