package magicbook.gtlitecore.api.recipe.machines;

import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.widgets.RecipeProgressWidget;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import net.minecraftforge.items.IItemHandlerModifiable;

import javax.annotation.Nonnull;

public class RecipeMapDTNFFusionMode<R extends RecipeBuilder<R>> extends RecipeMap<R> {

    public RecipeMapDTNFFusionMode(@Nonnull String unlocalizedName,
                                     int maxInputs,
                                     int maxOutputs,
                                     int maxFluidInputs,
                                     int maxFluidOutputs,
                                     @Nonnull R defaultRecipeBuilder,
                                     boolean isHidden) {
        super(unlocalizedName, maxInputs, maxOutputs, maxFluidInputs, maxFluidOutputs, defaultRecipeBuilder, isHidden);
    }

    @Override
    public ModularUI.Builder createJeiUITemplate(IItemHandlerModifiable importItems, IItemHandlerModifiable exportItems, FluidTankList importFluids, FluidTankList exportFluids, int yOffset) {
        ModularUI.Builder builder = ModularUI.builder(GuiTextures.BACKGROUND, 176, 176 + 18 * 3)
                .widget(new RecipeProgressWidget(200, 176 / 2 - 14 + 18, 18 * 2 + 7 , 22, 22, progressBarTexture, moveType, this));
        this.addInventorySlotGroup(builder, importItems, importFluids, false, yOffset);
        this.addInventorySlotGroup(builder, exportItems, exportFluids, true, yOffset);
        return builder;
    }

    @Override
    protected void addInventorySlotGroup(ModularUI.Builder builder, IItemHandlerModifiable itemHandler, FluidTankList fluidHandler, boolean isOutputs, int yOffset) {
        if (!isOutputs) {
            addSlot(builder, 14 + 18 * 3, 9, 0, itemHandler, fluidHandler, false, false);

            int startInputsX = 14;
            int startInputsY = 9 + 18;
            for (int i = 0; i < 5; i++) { // height
                for (int j = 0; j < 4; j++) { // width
                    int slotIndex = i * 4 + j;
                    addSlot(builder, startInputsX + 18 * j, startInputsY + 18 * i, slotIndex, itemHandler, fluidHandler, true, false);
                }
            }
        } else {
            int StartInputsX = 14 + 18 * 4 + 32;
            int StartInputsY = 9 + 18 * 2;
            addSlot(builder, StartInputsX, StartInputsY, 0, itemHandler, fluidHandler, true, true);
        }
    }
}
