package magicbook.gtlitecore.common.metatileentities.multi.electric;

import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockUniqueCasing;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.ingredients.GTRecipeInput;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import magicbook.gtlitecore.api.capability.ICatalystHatch;
import magicbook.gtlitecore.api.metatileentity.multi.GTLiteMultiblockAbility;
import magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps;
import magicbook.gtlitecore.api.recipe.properties.LargeChemicalComplexProperty;
import magicbook.gtlitecore.client.renderer.texture.GTLiteTextures;
import magicbook.gtlitecore.common.CommonProxy;
import magicbook.gtlitecore.common.blocks.BlockBoilerCasing;
import magicbook.gtlitecore.common.blocks.BlockLargeChemicalComplexCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import magicbook.gtlitecore.common.items.GTLiteMetaItems;
import magicbook.gtlitecore.loaders.RecipeManager;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MetaTileEntityLargeChemicalComplex extends RecipeMapMultiblockController {

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
    }


    @Override
    public void invalidateStructure() {
        super.invalidateStructure();
        this.mainUpgradeNumber = 0;
    }

    @Override
    public boolean checkRecipe(@Nonnull Recipe recipe,
                               boolean consumeIfSuccess) {
        return super.checkRecipe(recipe, consumeIfSuccess)
                && recipe.getProperty(LargeChemicalComplexProperty.getInstance(), 0) <= this.mainUpgradeNumber;
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("CCCCCCC", "CCCCCCC", "CCCCCCC", "CCCCCCC")
                .aisle("CPPPPPC", "U#####U", "U#####U", "CCCCCCC")
                .aisle("CCCCCCC", "U#####U", "U#####U", "CCCCCCC")
                .aisle("CPPPPPC", "U#####U", "U#####U", "CCCCCCC")
                .aisle("CCCSCCC", "CGGGGGC", "CGGGGGC", "CCCCCCC")
                //  Controller
                .where('S', this.selfPredicate())
                //  Main Structure (T1)
                .where('C', states(getCasingState("T1StructureCasing"))
                        .setMinGlobalLimited(60)
                        .or(autoAbilities(true, true, true, true, true, true, false))
                        .or(abilities(GTLiteMultiblockAbility.CATALYST_MULTIBLOCK_ABILITY)
                                .setPreviewCount(1)))
                .where('P', states(getBoilerCasingState()))
                .where('U', states(getUniqueCasingState()))
                .where('G', states(getGlassState()))
                //  Other miscs
                .where('#', air())
                .where(' ', any())
                .build();
    }

    private static IBlockState getCasingState(String type) {
        return switch (type) {
            case "T1StructureCasing" ->
                    GTLiteMetaBlocks.LARGE_CHEMICAL_COMPLEX_CASING.getState(BlockLargeChemicalComplexCasing.LCCCasingType.CHEMICAL_ACTIVE_CATALYTIC_FRAMEWORK_CASING);
            case "T2StructureCasing" ->
                    GTLiteMetaBlocks.LARGE_CHEMICAL_COMPLEX_CASING.getState(BlockLargeChemicalComplexCasing.LCCCasingType.CATALYTIC_BED_SUPPORT_FRAMEWORK_CASING);
            default -> null;
        };
    }

    private static IBlockState getBoilerCasingState() {
        return GTLiteMetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.POLYBENZIMIDAZOLE);
    }

    private static IBlockState getUniqueCasingState() {
        return GCYMMetaBlocks.UNIQUE_CASING.getState(BlockUniqueCasing.UniqueCasingType.HEAT_VENT);
    }

    private static IBlockState getGlassState() {
        return MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.FUSION_GLASS);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GTLiteTextures.CHEMICAL_ACTIVE_CATALYTIC_FRAMEWORK_CASING;
    }

    public ICatalystHatch getCatalystHatch() {
        List<ICatalystHatch> abilities = this.getAbilities(GTLiteMultiblockAbility.CATALYST_MULTIBLOCK_ABILITY);
        if (abilities.isEmpty())
            return null;
        return abilities.get(0);
    }

    /**
     * Catalyst Workable Handler.
     *
     * @author Magic_Sweepy
     *
     * <p>
     *     This is a internal class of Large Chemical Complex (LCC),
     *     used to provided an extended Catalyst predicate for LCC and Catalyst Hatch,
     *     because only LCC use Catalyst Hatch in {@code gtlitecore}, so we called it
     *     by LCC below. This class create a list to stored all non-consumable catalyst,
     *     because all catalyst in LCC will be damaged (each has 50 durability).
     *     All non-consumable catalyst will init befor {@link RecipeManager} inited,
     *     so this is auto-predicate all LCC recipes to protect its can be working normally.
     *     Catalyst damaged is create in Recipe Logic.
     * </p>
     *
     * @see CommonProxy#registerRecipes(RegistryEvent.Register)
     * @see LargeChemicalComplexRecipeLogic
     *
     * @since 2.8.8-beta
     */
    public static class CatalystWorkableHandler {

        public static List<ItemStack> notConsumableCatalyst = new ArrayList<>();

        public static void addCatalyst() {
            notConsumableCatalyst.add(MetaItems.INTEGRATED_CIRCUIT.getStackForm());
            notConsumableCatalyst.add(MetaItems.BLACKLIGHT.getStackForm());
        }

        public static boolean checkCatalyst(ItemStack stack) {
            for (ItemStack catalyst : notConsumableCatalyst) {
                if (stack.isItemEqual(catalyst))
                    return true;
            }
            return false;
        }

        public static boolean checkCatalyst(List<ItemStack> stacks) {
            return stacks.stream().allMatch(CatalystWorkableHandler::checkCatalyst);
        }
    }

    protected class LargeChemicalComplexRecipeLogic extends MultiblockRecipeLogic {

        private MetaTileEntityLargeChemicalComplex metaTileEntity;

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
                        .collect(Collectors.toList());

                //  Get all inputs in LCC recipe, check if catalyst exist.
                List<GTRecipeInput> inputs = recipe.getInputs().stream()
                        .filter(GTRecipeInput::isNonConsumable)
                        .filter(i -> !CatalystWorkableHandler.checkCatalyst(Arrays.stream(i.getInputStacks()).collect(Collectors.toList())))
                        .collect(Collectors.toList());

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

        @Override
        protected void completeRecipe() {
            super.completeRecipe();
            this.metaTileEntity.getCatalystHatch().catalystConsumed(1);
        }

    }

}
