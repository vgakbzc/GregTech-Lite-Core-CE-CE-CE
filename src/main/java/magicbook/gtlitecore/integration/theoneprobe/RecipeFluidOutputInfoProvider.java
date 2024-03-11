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

    public RecipeFluidOutputInfoProvider() {
    }

    @Override
    protected @Nonnull Capability<IWorkable> getCapability() {
        return GregtechTileCapabilities.CAPABILITY_WORKABLE;
    }

    //  fixme is so ugly to me...so maybe find some time to improved it be more beautiful.
    @Override
    protected void addProbeInfo(IWorkable capability,
                                IProbeInfo info,
                                EntityPlayer player,
                                TileEntity tileEntity,
                                IProbeHitData data) {
        if (capability.getProgress() > 0 && capability instanceof AbstractRecipeLogic) {
            IProbeInfo verticalPane = info.vertical(info.defaultLayoutStyle().alignment(ElementAlignment.ALIGN_TOPLEFT));
            List<FluidStack> fluidOutputs = new ArrayList<>(ObfuscationReflectionHelper.getPrivateValue(AbstractRecipeLogic.class, (AbstractRecipeLogic) capability, "fluidOutputs"));
            //  check if fluid output is empty.
            if (!fluidOutputs.isEmpty()) {
                //  title (looks like: Fluid Outputs: XXX).
                verticalPane.text(TextStyleClass.INFO + "{*gtlitecore.top.fluid_outputs*}");
                //  if recipe outputs have many fluids, then view all fluids (so we ergodic it).
                for (FluidStack fluidStack : fluidOutputs) {
                    //  check if recipe does not have fluid outputs (maybe also check if amount is zero or invalid).
                    if (fluidStack != null && fluidStack.amount > 0) {
                        //  used to add item icon (just like a iron bucket and some fluid in it).
                        ItemStack fluidBukkit = FluidUtil.getFilledBucket(fluidStack); //  get bucket format of fluid, just used to icon.
                        //  fixme use getLocalizedName() may be cause server side fluid name problem, but use {*fluidStack.getUnlocalizedName()*} cause the same problem in client-side (in my test, so should find some time to fix this problem).
                        if (fluidStack.amount >= 1000) { //  check if fluid stack amount greater than or equal to 1000, just used to abbreviate format.
                            verticalPane.horizontal(info.defaultLayoutStyle().alignment(ElementAlignment.ALIGN_TOPLEFT)).item(fluidBukkit).text(TextStyleClass.INFO + fluidStack.getLocalizedName() + " * " + (fluidStack.amount / 1000) + "B");
                        } else {
                            verticalPane.horizontal(info.defaultLayoutStyle().alignment(ElementAlignment.ALIGN_TOPLEFT)).item(fluidBukkit).text(TextStyleClass.INFO + fluidStack.getLocalizedName() + " * " + fluidStack.amount + "mB");
                        }
                    }
                }
            }
        }
    }

    //  hint: the original codes is too unfriendly to read in some special situation like distillation recipes,
    //  but idk how to fix it, so I just use vertical textline to change it, hope is useful.

    //if (capability.getProgress() > 0 && capability instanceof AbstractRecipeLogic) {
    //    IProbeInfo horizontalPane = info.horizontal(info.defaultLayoutStyle().alignment(ElementAlignment.ALIGN_CENTER));
    //    List<FluidStack> fluidOutputs = new ArrayList<>(ObfuscationReflectionHelper.getPrivateValue(AbstractRecipeLogic.class, (AbstractRecipeLogic) capability, "fluidOutputs"));
    //    if (!fluidOutputs.isEmpty()) {
    //        horizontalPane.text(TextStyleClass.INFO + "{*gtlitecore.top.fluid_outputs*}");
    //        for (FluidStack fluidStack : fluidOutputs) {
    //            if (fluidStack != null && fluidStack.amount > 0) {
    //                ItemStack fluidBukkit = FluidUtil.getFilledBucket(fluidStack);
    //                horizontalPane.item(fluidBukkit);
    //                //  If machine product many fluid stacks (greater than 2), then draw icon and amount only.
    //                if (fluidOutputs.size() > 2) {
    //                    if (fluidStack.amount >= 1000) {
    //                        horizontalPane.text(TextStyleClass.INFO + " * " + (fluidStack.amount / 1000) + "B");
    //                    } else {
    //                        horizontalPane.text(TextStyleClass.INFO + " * " + fluidStack.amount + "mB");
    //                    }
    //                }
    //            }
    //            if (fluidOutputs.size() <= 2) {
    //                if (fluidStack != null) {
    //                    //  If machine product one or two fluid stacks, thend draw inco, localized name and amount.
    //                    horizontalPane.text(TextStyleClass.INFO + fluidStack.getLocalizedName() + " * " + fluidStack.amount + "mB");
    //                }
    //            }
    //        }
    //    }
    //}

    @Override
    public String getID() {
        return "gtlitecore:recipe_info_fluid_output";
    }
}
