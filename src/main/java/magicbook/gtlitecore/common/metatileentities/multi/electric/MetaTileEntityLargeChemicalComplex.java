/*package magicbook.gtlitecore.common.metatileentities.multi.electric;

import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.ingredients.GTRecipeInput;
import gregtech.common.items.MetaItems;
import magicbook.gtlitecore.api.metatileentity.multi.GTLiteMultiblockAbility;
import magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps;
import magicbook.gtlitecore.common.CommonProxy;
import magicbook.gtlitecore.common.metatileentities.multi.part.MetaTileEntityCatalystHatch;
import magicbook.gtlitecore.loaders.RecipeManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MetaTileEntityLargeChemicalComplex extends RecipeMapMultiblockController {

    //  1
    //    pbi casing +
    //
    //    pbi pipe(ZPM), 2(UV),3(UHV),4
    //    hastelloy k243
    //
    //    casing(UEV)

    //  Upgrade Number
    private byte mainUpgradeNumber = 0;
    private byte cryoUpgradeNumber = 0;
    private byte burnerUpgradeNumber = 0;
    private byte cvdUpgradeNumber = 0;
    private byte sonicatorUpgradeNumber = 0;
    private byte bioUpgradeNumber = 0;

    public MetaTileEntityLargeChemicalComplex(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GTLiteRecipeMaps.LARGE_CHEMICAL_COMPLEX_RECIPES);
        this.recipeMapWorkable = new LargeChemicalComplexRecipeLogic(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityLargeChemicalComplex(metaTileEntityId);
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        //  Main Structure T1
        this.mainUpgradeNumber += 1;
        //  Main Structure T2
        if (context.get("mainUpgradeT2") != null) {
            this.mainUpgradeNumber += 1;
        }
        //  Main Structure T3
        if (context.get("mainUpgradeT3") != null) {
            this.mainUpgradeNumber += 1;
        }
        //  Main Structure T4
        if (context.get("mainUpgradeT4") != null) {
            this.mainUpgradeNumber += 1;
        }
        //  Cryo
    }

    /**
     * Catalyst Workable Handler.
     *
     * @author Magic_Sweepy
     *
     * <p>
     * This is a internal class of Large Chemical Complex (LCC),
     * used to provided an extended Catalyst predicate for LCC and Catalyst Hatch,
     * because only LCC use Catalyst Hatch in {@code gtlitecore}, so we called it
     * by LCC below. This class create a list to stored all non-consumable catalyst,
     * because all catalyst in LCC will be damaged (each has 50 durability).
     * All non-consumable catalyst will init befor {@link RecipeManager} inited,
     * so this is auto-predicate all LCC recipes to protect its can be working normally.
     * </p>
     * @see CommonProxy#registerRecipes(RegistryEvent.Register)
     * @since 2.8.8-beta
     */
/*

    public static class CatalystWorkableHandler {

        public static List<ItemStack> nonConsumableCatalyst = new ArrayList<>();

        public static void addCatalyst() {
            nonConsumableCatalyst.add(MetaItems.INTEGRATED_CIRCUIT.getStackForm());
            nonConsumableCatalyst.add(MetaItems.BLACKLIGHT.getStackForm());
        }

        public static boolean checkCatalyst(ItemStack stack) {
            for (ItemStack catalyst : nonConsumableCatalyst) {
                if (stack.isItemEqual(catalyst))
                    return true;
            }
            return false;
        }

        public static boolean checkCatalyst(List<ItemStack> stacks) {
            return stacks.stream()
                    .allMatch(CatalystWorkableHandler::checkCatalyst);
        }
    }

    protected class LargeChemicalComplexRecipeLogic extends MultiblockRecipeLogic {

        public LargeChemicalComplexRecipeLogic(RecipeMapMultiblockController tileEntity) {
            super(tileEntity);
        }

        @Override
        public boolean checkRecipe(@Nonnull Recipe recipe) {
            if (super.checkRecipe(recipe)) {
                //  Get item stacks in Catalyst Hatch (if it is not empty).
                List<ItemStack> stacks = getAbilities(GTLiteMultiblockAbility.CATALYST_MULTIBLOCK_ABILITY).stream()
                        .map(s -> s.getStackInSlot(0))
                        .filter(s -> !s.isEmpty())
                        .toList();

                //  Get all inputs in LCC recipe, check if catalyst exist.
                List<GTRecipeInput> inputs = recipe.getInputs().stream()
                        .filter(GTRecipeInput::isNonConsumable)
                        .filter(i -> !CatalystWorkableHandler.checkCatalyst(Arrays.stream(i.getInputStacks()).toList()))
                        .toList();

                int count = 0;
                for (GTRecipeInput input : inputs) {
                    for (ItemStack stack : stacks) {
                        if (input.acceptsStack(stack)) {
                            count++;
                            break;
                        }
                    }
                }
                return count == inputs.size() && inputs.size() == stacks.size();
            } else {
                return false;
            }
        }
    }

}

 */
