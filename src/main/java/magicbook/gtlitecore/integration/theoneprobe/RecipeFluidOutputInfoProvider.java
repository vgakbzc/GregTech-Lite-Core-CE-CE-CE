package magicbook.gtlitecore.integration.theoneprobe;

import gregtech.api.capability.GregtechTileCapabilities;
import gregtech.api.capability.IWorkable;
import gregtech.api.capability.impl.AbstractRecipeLogic;
import gregtech.integration.theoneprobe.provider.CapabilityInfoProvider;
import mcjty.theoneprobe.api.ElementAlignment;
import mcjty.theoneprobe.api.IProbeHitData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.TextStyleClass;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

/**
 * Fluid Output Info Provider
 *
 * @author vfyjxf
 *
 * <p>
 *     Integrated from <a href="https://github.com/vfyjxf/GregicProbe">Gregic Probe</a> for GTCE,
 *     this mod use MIT License and is stop updating now (so we integrated it in gtlitecore).
 * </p>
 */
public class RecipeFluidOutputInfoProvider extends CapabilityInfoProvider<IWorkable> {

    public RecipeFluidOutputInfoProvider() {}

    @Override
    protected @Nonnull Capability<IWorkable> getCapability() {
        return GregtechTileCapabilities.CAPABILITY_WORKABLE;
    }

    @Override
    protected void addProbeInfo(IWorkable capability,
                                IProbeInfo info,
                                EntityPlayer player,
                                TileEntity tileEntity,
                                IProbeHitData data) {
        if (capability.getProgress() > 0 && capability instanceof AbstractRecipeLogic) {
            IProbeInfo horizontalPane = info.horizontal(info.defaultLayoutStyle().alignment(ElementAlignment.ALIGN_CENTER));
            List<FluidStack> fluidOutputs = new ArrayList<>(ObfuscationReflectionHelper.getPrivateValue(AbstractRecipeLogic.class, (AbstractRecipeLogic) capability, "fluidOutputs"));
            if (!fluidOutputs.isEmpty()) {
                horizontalPane.text(TextStyleClass.INFO + "{*gtlitecore.top.fluid_outputs*}");
                for (FluidStack fluidStack : fluidOutputs) {
                    if (fluidStack != null && fluidStack.amount > 0) {
                        ItemStack fluidBukkit = FluidUtil.getFilledBucket(fluidStack);
                        horizontalPane.item(fluidBukkit);
                        if (fluidOutputs.size() > 2) {
                            if (fluidStack.amount >= 1000) {
                                horizontalPane.text(TextStyleClass.INFO + " * " + (fluidStack.amount / 1000) + "B");
                            } else {
                                horizontalPane.text(TextStyleClass.INFO + " * " + fluidStack.amount + "mB");
                            }
                        }
                    }
                    if (fluidOutputs.size() <= 2) {
                        if (fluidStack != null) {
                            //horizontalPane.text(TextStyleClass.INFO + "{*" + fluidStack.getUnlocalizedName() + "*}" + " * " + fluidStack.amount + "mB");
                            horizontalPane.text(TextStyleClass.INFO + fluidStack.getLocalizedName() + " * " + fluidStack.amount + "mB");
                        }
                    }

                }
            }
        }
    }


    @Override
    public String getID() {
        return "gtlitecore:recipe_info_fluid_output";
    }
}
