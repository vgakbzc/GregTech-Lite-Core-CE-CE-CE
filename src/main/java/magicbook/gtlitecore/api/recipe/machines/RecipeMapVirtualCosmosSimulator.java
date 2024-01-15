package magicbook.gtlitecore.api.recipe.machines;

import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import magicbook.gtlitecore.api.gui.GTLiteGuiTextures;
import net.minecraftforge.items.IItemHandlerModifiable;

import javax.annotation.Nonnull;

public class RecipeMapVirtualCosmosSimulator<R extends RecipeBuilder<R>> extends RecipeMap<R> {

    public RecipeMapVirtualCosmosSimulator(@Nonnull String unlocalizedName,
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
        ModularUI.Builder builder = ModularUI.builder(GuiTextures.BACKGROUND, 176, 176)
                .widget(new ProgressWidget(200, 70, 12, 72, 40, GTLiteGuiTextures.PROGRESS_BAR_VIRTUAL_COSMOS_SIMULATOR, ProgressWidget.MoveType.HORIZONTAL_BACKWARDS))
                .widget(new ProgressWidget(200, 131, 15, 3, 12, GTLiteGuiTextures.PROGRESS_BAR_COMPONENT_ASSEMBLY_LINE_2, ProgressWidget.MoveType.VERTICAL_DOWNWARDS));
        this.addInventorySlotGroup(builder, importItems, importFluids, false, yOffset);
        this.addInventorySlotGroup(builder, exportItems, exportFluids, true, yOffset);
        return builder;
    }

    @Override
    protected void addInventorySlotGroup(ModularUI.Builder builder, IItemHandlerModifiable itemHandler, FluidTankList fluidHandler, boolean isOutputs, int yOffset) {

        int startInputsX = 70 - 3 * 18;
        int startInputsY = 45 - 2 * 18;


        if (isOutputs) {
            //  item output slots
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    int slotIndex = i * 3 + j;
                    addSlot(builder, startInputsX + 18 * j, startInputsY + 18 * i, slotIndex, itemHandler, fluidHandler, false, true);
                }
            }

            // fluid output slots
            int startFluidX = startInputsX + 18 * 4;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    int slotIndex = i * 4 + j;
                    addSlot(builder, startFluidX + 18 * j, startInputsY + 18 + 18 * i, slotIndex, itemHandler, fluidHandler, true, true);
                }
            }
        } else {
            // input slot
            addSlot(builder, startInputsX + 18 * 7, 9, 0, itemHandler, fluidHandler, false, false);
        }
    }
}
