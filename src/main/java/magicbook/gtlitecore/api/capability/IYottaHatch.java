package magicbook.gtlitecore.api.capability;

import appeng.api.storage.data.IAEFluidStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

//  Just a transfer for our domain...
public interface IYottaHatch extends IAEFluidStack {
    FluidStack getFluidStack();

    void add(IAEFluidStack var1);

    IAEFluidStack copy();

    Fluid getFluid();
}
