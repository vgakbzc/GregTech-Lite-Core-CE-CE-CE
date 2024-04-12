package magicbook.gtlitecore.api.recipe.machines;

import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.widgets.RecipeProgressWidget;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import net.minecraftforge.items.IItemHandlerModifiable;

import javax.annotation.Nonnull;

/**
 * NDB Burning Module Recipe Map
 *
 * @author Magic_Sweepy
 */
public class RecipeMapNDBBurningModule<R extends RecipeBuilder<R>> extends RecipeMap<R> {

    public RecipeMapNDBBurningModule(@Nonnull String unlocalizedName,
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
        ModularUI.Builder builder = ModularUI.builder(GuiTextures.BACKGROUND, 176, 176 + 18 * 2 + 18)
                .widget(new RecipeProgressWidget(200, 176 / 2 - 18 + 4, 18 * 3 - 4, 21, 21, progressBarTexture, moveType, this));
        this.addInventorySlotGroup(builder, importItems, importFluids, false, yOffset);
        this.addInventorySlotGroup(builder, exportItems, exportFluids, true, yOffset);
        return builder;
    }

    @Override
    protected void addInventorySlotGroup(ModularUI.Builder builder, IItemHandlerModifiable itemHandler, FluidTankList fluidHandler, boolean isOutputs, int yOffset) {

        int startInputsX = 14;
        int startInputsY = 9;

        if (!isOutputs) {
            //  item inputs slots
            for (int i = 0; i < 3; i++) { // height
                for (int j = 0; j < 3; j++) { // width
                    int slotIndex = i * 3 + j;
                    addSlot(builder, startInputsX + 18 * j, startInputsY + 18 * i, slotIndex, itemHandler, fluidHandler, false, false);
                }
            }
            //  fluid inputs slots
            int StartInputsY = startInputsY + 18 * 3;
            for (int i = 0; i < 3; i++) { // height
                for (int j = 0; j < 3; j++) { // width
                    int slotIndex = i * 3 + j;
                    addSlot(builder, startInputsX + 18 * j, StartInputsY + 18 * i, slotIndex, itemHandler, fluidHandler, true, false);
                }
            }
        } else {
            //  item outputs slots
            int StartInputsX = startInputsX + 3 * 18 + 34;
            for (int i = 0; i < 3; i++) { // height
                for (int j = 0; j < 3; j++) { // width
                    int slotIndex = i * 3 + j;
                    addSlot(builder, StartInputsX + 18 * j, startInputsY + 18 * i, slotIndex, itemHandler, fluidHandler, false, true);
                }
            }

            //  fluid outputs slots
            int StartInputsY = startInputsY + 3 * 18;
            for (int i = 0; i < 3; i++) { // height
                for (int j = 0; j < 3; j++) { // width
                    int slotIndex = i * 3 + j;
                    addSlot(builder, StartInputsX + 18 * j, StartInputsY + 18 * i, slotIndex, itemHandler, fluidHandler, true, true);
                }
            }
        }

    }
}
