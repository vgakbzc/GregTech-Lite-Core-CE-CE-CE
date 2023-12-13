package magicbook.gtlitecore.common.metatileentities.multi.part;

import gregtech.api.capability.IEnergyContainer;
import gregtech.api.metatileentity.multiblock.IMultiblockAbilityPart;
import magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;

public class MetaTileEntityEnergyHatch extends gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityEnergyHatch implements IMultiblockAbilityPart<IEnergyContainer> {

    public MetaTileEntityEnergyHatch(ResourceLocation metaTileEntityId,
                                     int tier,
                                     int amperage,
                                     boolean isExport) {
        super(metaTileEntityId, tier, amperage, isExport);
    }

    @Override
    public void getSubItems(CreativeTabs creativeTab, NonNullList<ItemStack> subItems) {

        for (gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityEnergyHatch hatch : GTLiteMetaTileEntities.INPUT_ENERGY_HATCH_4A) {
            if (hatch != null)
                subItems.add(hatch.getStackForm());
        }

        for (gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityEnergyHatch hatch : GTLiteMetaTileEntities.INPUT_ENERGY_HATCH_16A) {
            if (hatch != null)
                subItems.add(hatch.getStackForm());
        }

        for (gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityEnergyHatch hatch : GTLiteMetaTileEntities.OUTPUT_ENERGY_HATCH_4A) {
            if (hatch != null)
                subItems.add(hatch.getStackForm());
        }

        for (gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityEnergyHatch hatch : GTLiteMetaTileEntities.OUTPUT_ENERGY_HATCH_16A) {
            if (hatch != null)
                subItems.add(hatch.getStackForm());
        }
    }
}
