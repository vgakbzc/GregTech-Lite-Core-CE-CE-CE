package magicbook.gtlitecore.api.recipe.machines;

import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import net.minecraftforge.items.IItemHandlerModifiable;

import org.jetbrains.annotations.NotNull;

/**
 * Suprachronal Assembly Line Recipe Map
 *
 * @author Zalgo239
 */
public class RecipeMapSuprachronalAssemblyLine<R extends RecipeBuilder<R>> extends RecipeMap<R> {

    public RecipeMapSuprachronalAssemblyLine(String unlocalizedName,
                                             int maxInputs,
                                             int maxOutputs,
                                             int maxFluidInputs,
                                             int maxFluidOutputs,
                                             R defaultRecipe,
                                             boolean isHidden) {
        super(unlocalizedName, maxInputs, maxOutputs, maxFluidInputs, maxFluidOutputs, defaultRecipe, isHidden);
    }

    @NotNull
    @Override
    public ModularUI.Builder createJeiUITemplate(IItemHandlerModifiable importItems,
                                                 IItemHandlerModifiable exportItems,
                                                 FluidTankList importFluids,
                                                 FluidTankList exportFluids,
                                                 int yOffset) {
        ModularUI.Builder builder = ModularUI.builder(GuiTextures.BACKGROUND, 176, 176)
                .widget(new ProgressWidget(200, 80, 1, 54, 72, GuiTextures.PROGRESS_BAR_ASSEMBLY_LINE, ProgressWidget.MoveType.HORIZONTAL));
        this.addInventorySlotGroup(builder, importItems, importFluids, false, yOffset);
        this.addInventorySlotGroup(builder, exportItems, exportFluids, true, yOffset);
        return builder;
    }

    @Override
    protected void addInventorySlotGroup(ModularUI.Builder builder,
                                         @NotNull IItemHandlerModifiable itemHandler,
                                         @NotNull FluidTankList fluidHandler,
                                         boolean isOutputs,
                                         int yOffset) {
        int itemInputsCount = itemHandler.getSlots();
        int fluidInputsCount = fluidHandler.getTanks();
        boolean invertFluids = false;
        if (itemInputsCount == 0) {
            int tmp = itemInputsCount;
            itemInputsCount = fluidInputsCount;
            fluidInputsCount = tmp;
            invertFluids = true;
        }
        int[] inputSlotGrid = determineSlotsGrid(itemInputsCount);
        int itemSlotsToLeft = inputSlotGrid[0];
        int itemSlotsToDown = inputSlotGrid[1];
        int startInputsX = 80 - itemSlotsToLeft * 18;
        int startInputsY = 37 - (int) (itemSlotsToDown / 2.0 * 18);

        if (!isOutputs) {
            for (int i = 0; i < itemSlotsToDown; i++) {
                for (int j = 0; j < itemSlotsToLeft; j++) {
                    int slotIndex = i * itemSlotsToLeft + j/* + 1*/; // needed for data slot
                    addSlot(builder, startInputsX + 18 * j, startInputsY + 18 * i, slotIndex, itemHandler, fluidHandler, invertFluids, false);
                }
            }
            if (fluidInputsCount > 0 || invertFluids) {
                if (itemSlotsToDown >= fluidInputsCount) {
                    int startSpecX = startInputsX + 18 * 5;
                    for (int i = 0; i < fluidInputsCount; i++) {
                        addSlot(builder, startSpecX, startInputsY + 18 * i, i, itemHandler, fluidHandler, true, false);
                    }
                }
            }
        } else {
            addSlot(builder, startInputsX + 18 * 4, 1, 0/*18*/, itemHandler, fluidHandler, invertFluids, true); // Output Slot - 18 for data slot
        }
    }
}
