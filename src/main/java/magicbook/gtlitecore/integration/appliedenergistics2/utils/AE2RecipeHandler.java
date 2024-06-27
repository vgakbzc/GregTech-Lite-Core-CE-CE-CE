package magicbook.gtlitecore.integration.appliedenergistics2.utils;

import appeng.api.AEApi;
import appeng.api.features.IInscriberRecipe;
import appeng.api.features.IInscriberRecipeBuilder;
import appeng.api.features.IInscriberRegistry;
import appeng.api.features.InscriberProcessType;
import io.github.phantamanta44.libnine.LibNine;
import io.github.phantamanta44.libnine.util.IDisplayableMatcher;
import io.github.phantamanta44.threng.ThrEng;
import io.github.phantamanta44.threng.recipe.AggRecipe;
import io.github.phantamanta44.threng.recipe.EtchRecipe;
import io.github.phantamanta44.threng.recipe.PurifyRecipe;
import io.github.phantamanta44.threng.recipe.ThrEngRecipes;
import magicbook.gtlitecore.api.utils.GTLiteLog;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * AE2 Recipe Handler
 *
 * @author Magic_Sweepy
 *
 * <p>
 *     This class is provided recipe tweak method for AE2 and related mods,
 *     used for {@code gtlitecore} internal situation.
 * </p>
 *
 * @see ThrEngRecipes
 */
public class AE2RecipeHandler {

    /**
     * Add AE2 Inscriber Recipes.
     *
     * @param output       Output Item.
     * @param input        Input Item.
     * @param isInscribe   Process Type of Inscriber, {@code true} means {@code topInput} item is not consumable.
     * @param topInput     Top Input Item.
     * @param bottomInput  Bottom Input Item.
     */
    public static void addInscriberRecipe(ItemStack output,
                                          ItemStack input,
                                          boolean isInscribe,
                                          @Nullable ItemStack topInput,
                                          @Nullable ItemStack bottomInput) {
        IInscriberRecipeBuilder recipeBuilder = AEApi.instance().registries().inscriber().builder()
                .withInputs(Collections.singleton(input))
                .withTopOptional(Collections.singleton(topInput))
                .withBottomOptional(Collections.singleton(bottomInput))
                .withOutput(output)
                .withProcessType(isInscribe ? InscriberProcessType.INSCRIBE : InscriberProcessType.PRESS);
        AEApi.instance().registries().inscriber().addRecipe(recipeBuilder.build());
    }

    /**
     * Remove AE2 Inscriber Recipes.
     *
     * @param output  Output Item.
     */
    public static void removeInscriberRecipe(ItemStack output) {
        IInscriberRegistry registry = AEApi.instance().registries().inscriber();
        List<IInscriberRecipe> recipeList = registry.getRecipes().stream()
                .filter(r -> r.getOutput().isItemEqual(output))
                .collect(Collectors.toList());
        Objects.requireNonNull(registry);
        recipeList.forEach(registry::removeRecipe);
    }

    /**
     * Add Lazy AE2 Aggregator Recipes by Ore Dict.
     *
     * @param output  Output Item.
     * @param input1  Input Ore Dict 1.
     * @param input2  Input Ore Dict 2.
     * @param input3  Input Ore Dict 3.
     */
    public static void addAggregatorRecipe(ItemStack output,
                                           String input1,
                                           String input2,
                                           @Nullable String input3) {
        ThrEng.PROXY.registerPostInitTask(() -> {
            LibNine.PROXY.getRecipeManager().getRecipeList(AggRecipe.class)
                    .add(new AggRecipe(Stream.of(input1, input2, input3)
                            .map(AE2RecipeHandler::matchesOreDict)
                            .collect(Collectors.toList()), output));
        });
    }

    /**
     * Remove Lazy AE2 Aggregator Recipes by Output Item Stack.
     *
     * @param output  Output Item.
     */
    public static void removeAggregatorRecipe(ItemStack output) {
        ThrEng.PROXY.registerPostInitTask(() -> {
            if (!LibNine.PROXY.getRecipeManager().getRecipeList(AggRecipe.class).recipes()
                    .removeIf((r) -> output.isItemEqual(r.getOutput().getOutput()))) {
                GTLiteLog.logger.warn("No Aggregator recipes were removed for call: {}. [Lazy AE2 Module]", output.toString());
            }
        });
    }

    /**
     * Add Lazy AE2 Centrifuge Recipes by Ore Dict.
     *
     * @param output  Output Item.
     * @param input   Input Item.
     */
    public static void addCentrifugeRecipe(ItemStack output,
                                           String input) {
        ThrEng.PROXY.registerPostInitTask(() -> {
            LibNine.PROXY.getRecipeManager().getRecipeList(PurifyRecipe.class)
                    .add(new PurifyRecipe(matchesOreDict(input), output));
        });
    }

    /**
     * Remove Lazy AE2 Centrifuge Recipes by Output Item Stack.
     *
     * @param output  Output Item.
     */
    public static void removeCentrifugeRecipe(ItemStack output) {
        ThrEng.PROXY.registerPostInitTask(() -> {
            if (!LibNine.PROXY.getRecipeManager().getRecipeList(PurifyRecipe.class).recipes()
                    .removeIf((r) -> output.isItemEqual(r.getOutput().getOutput()))) {
                GTLiteLog.logger.warn("No Centrifuge recipes were removed for call: {}. [Lazy AE2 Module]", output.toString());
            }
        });
    }

    /**
     * Add Lazy AE2 Etcher Recipes by Ore Dict.
     *
     * @param output       Output Item.
     * @param input        Input Item.
     * @param topInput     Top Input Item.
     * @param bottomInput  Bottom Input Item.
     */
    public static void addEtcherRecipe(ItemStack output,
                                       String input,
                                       @Nullable String topInput,
                                       @Nullable String bottomInput) {
        ThrEng.PROXY.registerPostInitTask(() -> {
            LibNine.PROXY.getRecipeManager().getRecipeList(EtchRecipe.class)
                    .add(new EtchRecipe(matchesOreDict(topInput), matchesOreDict(bottomInput), matchesOreDict(input), output));
        });
    }

    /**
     * Remove Lazy AE2 Etcher Recipes by Output Item Stack.
     *
     * @param output  Output Item.
     */
    public static void removeEtcherRecipe(ItemStack output) {
        ThrEng.PROXY.registerPostInitTask(() -> {
            if (!LibNine.PROXY.getRecipeManager().getRecipeList(EtchRecipe.class).recipes()
                    .removeIf((r) -> output.isItemEqual(r.getOutput().getOutput()))) {
                GTLiteLog.logger.warn("No Etcher recipes were removed for call: {}. [Lazy AE2 Module]", output.toString());
            }
        });
    }

    /**
     * Matches {@code oreDict} by Displayable Matcher of Item Stack.
     *
     * @param oreDict  Target {@code oreDict}.
     * @return         Get correspondence Item Stack by {@code oreDict}.
     */
    @Contract(value = "_ -> new", pure = true)
    @NotNull
    public static IDisplayableMatcher<ItemStack> matchesOreDict(String oreDict) {
        return IDisplayableMatcher.ofMany(
                () -> OreDictionary.getOres(oreDict, false),
                (s) -> matchesOreDict(s, oreDict));
    }

    /**
     * Matches {@code oreDict} by {@code stack}.
     *
     * @param stack    Target {@code stack}.
     * @param oreDict  Target {@code oreDict}.
     * @return         Check if {@code stack} has target {@code oreDict}.
     */
    public static boolean matchesOreDict(@NotNull ItemStack stack, String oreDict) {
        //  Check if stack is empty.
        if (stack.isEmpty()) {
            return false;
        } else {
            int targetOreDict = OreDictionary.getOreID(oreDict);
            int[] oreDicts = OreDictionary.getOreIDs(stack);
            //  For all Ore Dicts of {@code stack}, if it has same Ore Dict to {@code targetOreDict},
            //  then return true, if not then return false.
            for (int tOreDict : oreDicts) {
                if (tOreDict == targetOreDict)
                    return true;
            }
        }
        return false;
    }


}
