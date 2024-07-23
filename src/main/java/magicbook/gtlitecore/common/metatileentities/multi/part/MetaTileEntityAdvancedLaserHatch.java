package magicbook.gtlitecore.common.metatileentities.multi.part;

import gregtech.api.capability.ILaserContainer;
import gregtech.api.metatileentity.IDataInfoProvider;
import gregtech.api.metatileentity.multiblock.IMultiblockAbilityPart;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityLaserHatch;
import magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;

public class MetaTileEntityAdvancedLaserHatch extends MetaTileEntityLaserHatch implements IMultiblockAbilityPart<ILaserContainer>, IDataInfoProvider {

    public MetaTileEntityAdvancedLaserHatch(ResourceLocation metaTileEntityId,
                                            int tier,
                                            int amperage,
                                            boolean isExport) {
        super(metaTileEntityId, isExport, tier, amperage);
    }

    @Override
    public void getSubItems(CreativeTabs creativeTab, NonNullList<ItemStack> subItems) {
        for (MetaTileEntityLaserHatch bus : GTLiteMetaTileEntities.LASER_INPUT_HATCH_16384A) {
            if (bus != null)
                subItems.add(bus.getStackForm());
        }

        for (MetaTileEntityLaserHatch bus : GTLiteMetaTileEntities.LASER_INPUT_HATCH_65536A) {
            if (bus != null)
                subItems.add(bus.getStackForm());
        }

        for (MetaTileEntityLaserHatch bus : GTLiteMetaTileEntities.LASER_INPUT_HATCH_262144A) {
            if (bus != null)
                subItems.add(bus.getStackForm());
        }

        for (MetaTileEntityLaserHatch bus : GTLiteMetaTileEntities.LASER_INPUT_HATCH_1048576A) {
            if (bus != null)
                subItems.add(bus.getStackForm());
        }

        for (MetaTileEntityLaserHatch bus : GTLiteMetaTileEntities.LASER_OUTPUT_HATCH_16384A) {
            if (bus != null)
                subItems.add(bus.getStackForm());
        }

        for (MetaTileEntityLaserHatch bus : GTLiteMetaTileEntities.LASER_OUTPUT_HATCH_65536A) {
            if (bus != null)
                subItems.add(bus.getStackForm());
        }

        for (MetaTileEntityLaserHatch bus : GTLiteMetaTileEntities.LASER_OUTPUT_HATCH_262144A) {
            if (bus != null)
                subItems.add(bus.getStackForm());
        }

        for (MetaTileEntityLaserHatch bus : GTLiteMetaTileEntities.LASER_OUTPUT_HATCH_1048576A) {
            if (bus != null)
                subItems.add(bus.getStackForm());
        }

    }
}
