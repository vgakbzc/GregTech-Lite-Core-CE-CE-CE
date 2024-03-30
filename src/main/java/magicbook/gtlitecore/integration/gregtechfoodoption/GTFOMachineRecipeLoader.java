package magicbook.gtlitecore.integration.gregtechfoodoption;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.loaders.recipe.CraftingComponent;
import gregtech.loaders.recipe.MetaTileEntityLoader;
import gregtechfoodoption.recipe.GTFOMachineRecipes;
import magicbook.gtlitecore.common.GTLiteConfigHolder;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.plateDense;
import static gregtechfoodoption.machines.GTFOTileEntities.SLICER;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

/**
 * Overrides of GregTech Food Option Machines
 *
 * @author Magic_Sweepy
 *
 * <p>
 *     Because some machines in gregtechfoodoption do not support UHV+ stage recipes, so we rewrite it.
 *     We reinit a component map about dense plate, the original map is in {@link GTFOMachineRecipes#init()}.
 *     This override can not control by {@link GTLiteConfigHolder}, because it just a compatibility between two mods.
 * </p>
 *
 * @since 1.11.1
 */
public class GTFOMachineRecipeLoader {

    public static void init() {
        //  Remove original recipes, use gtlitecore register machine recipes.
        String[] voltageList = {"lv", "mv", "hv", "ev", "iv", "luv", "zpm", "uv", "uhv"};
        for (int i = 0; i < 9; i++) {
            ModHandler.removeRecipeByName("gregtechfoodoption:gregtechfoodoption.machine.slicer." + voltageList[i]);
        }

        //  A new map of dense plate component, is not same as gregtechfoodoption's.
        CraftingComponent.Component PLATE_DENSE = new CraftingComponent.Component(Stream.of(
                        new Object[]{0, new UnificationEntry(plateDense, WroughtIron)},
                        new Object[]{1, new UnificationEntry(plateDense, Steel)},
                        new Object[]{2, new UnificationEntry(plateDense, Aluminium)},
                        new Object[]{3, new UnificationEntry(plateDense, StainlessSteel)},
                        new Object[]{4, new UnificationEntry(plateDense, Titanium)},
                        new Object[]{5, new UnificationEntry(plateDense, TungstenSteel)},
                        new Object[]{6, new UnificationEntry(plateDense, RhodiumPlatedPalladium)},
                        new Object[]{7, new UnificationEntry(plateDense, NaquadahAlloy)},
                        new Object[]{8, new UnificationEntry(plateDense, Darmstadtium)},
                        new Object[]{9, new UnificationEntry(plateDense, Orichalcum)},
                        new Object[]{10, new UnificationEntry(plateDense, Adamantium)},
                        new Object[]{11, new UnificationEntry(plateDense, Infinity)},
                        new Object[]{12, new UnificationEntry(plateDense, CosmicNeutronium)},
                        new Object[]{13, new UnificationEntry(plateDense, Spacetime)},
                        new Object[]{14, new UnificationEntry(plateDense, Eternity)})
                .collect(Collectors.toMap((data) -> (Integer)data[0], (data) -> data[1])));

        //  new recipes of Slicer
        MetaTileEntityLoader.registerMachineRecipe(SLICER,
                "PXW", "SHX", "DCW",
                'P', CraftingComponent.PISTON,
                'X', CraftingComponent.CIRCUIT,
                'W', CraftingComponent.CABLE,
                'S', CraftingComponent.SAWBLADE,
                'H', CraftingComponent.HULL,
                'D', PLATE_DENSE,
                'C', CraftingComponent.CONVEYOR);
    }
}
