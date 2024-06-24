package magicbook.gtlitecore.api.recipe.machines;

import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.widgets.RecipeProgressWidget;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import net.minecraftforge.items.IItemHandlerModifiable;

import org.jetbrains.annotations.NotNull;

public class RecipeMapLargeChemicalComplex<R extends RecipeBuilder<R>> extends RecipeMap<R> {

    public RecipeMapLargeChemicalComplex(@NotNull String unlocalizedName,
                                         int maxInputs,
                                         int maxOutputs,
                                         int maxFluidInputs,
                                         int maxFluidOutputs,
                                         @NotNull R defaultRecipeBuilder,
                                         boolean isHidden) {
        super(unlocalizedName, maxInputs, maxOutputs, maxFluidInputs, maxFluidOutputs, defaultRecipeBuilder, isHidden);
    }

    @Override
    public ModularUI.Builder createJeiUITemplate(IItemHandlerModifiable importItems, IItemHandlerModifiable exportItems, FluidTankList importFluids, FluidTankList exportFluids, int yOffset) {
        int newYOffset = yOffset + 18;
        ModularUI.Builder builder = ModularUI.builder(GuiTextures.BACKGROUND, 176, 186)
                .widget(new RecipeProgressWidget(200, 78 , 23 + newYOffset - 6 + 20 - 10, 20, 20, progressBarTexture, moveType, this));
        this.addInventorySlotGroup(builder, importItems, importFluids, false, newYOffset);
        this.addInventorySlotGroup(builder, exportItems, exportFluids, true, newYOffset);
        return builder;
    }

    @Override
    protected void addInventorySlotGroup(ModularUI.Builder builder, IItemHandlerModifiable itemHandler, FluidTankList fluidHandler, boolean isOutputs, int yOffset) {
        int startInputsX = 78 - 4 - 4 * 18;
        int startInputsY = 37 - 2 * 18 + yOffset;

        if (!isOutputs) {
            for (int i = 0; i < 4; i++) {
                addSlot(builder, startInputsX + 18 * i, startInputsY, i, itemHandler, fluidHandler, false, false);
                addSlot(builder, startInputsX + 18 * i, startInputsY + 18, i + 4, itemHandler, fluidHandler, false, true);
                addSlot(builder, startInputsX + 18 * i, startInputsY + 18 * 2, i, itemHandler, fluidHandler, true, false);
                addSlot(builder, startInputsX + 18 * i, startInputsY + 18 * 3, i + 4, itemHandler, fluidHandler, true, false);
            }
        } else {
            int StartInputsX = 78 + 20 + 5;

            for (int i = 0; i < 4; i++) {
                addSlot(builder, StartInputsX + 18 * i, startInputsY, i, itemHandler, fluidHandler, false, true);
                addSlot(builder, StartInputsX + 18 * i, startInputsY + 18, i + 4, itemHandler, fluidHandler, false, true);
                addSlot(builder, StartInputsX + 18 * i, startInputsY + 18 * 2, i, itemHandler, fluidHandler, true, true);
                addSlot(builder, StartInputsX + 18 * i, startInputsY + 18 * 3, i + 4, itemHandler, fluidHandler, true, true);
            }
        }
    }
}
