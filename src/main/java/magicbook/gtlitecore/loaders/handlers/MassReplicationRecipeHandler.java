package magicbook.gtlitecore.loaders.handlers;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.PropertyKey;
import magicbook.gtlitecore.common.GTLiteConfigHolder;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.IV;
import static gregtech.api.GTValues.L;
import static gregtech.api.GTValues.VA;
import static gregtech.api.recipes.RecipeMaps.MASS_FABRICATOR_RECIPES;
import static gregtech.api.recipes.RecipeMaps.REPLICATOR_RECIPES;
import static gregtech.api.unification.material.Materials.UUMatter;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.TURBINE_MIXER_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.BosonicUUMatter;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.FermionicUUMatter;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.FreeElectronGas;
import static magicbook.gtlitecore.api.unification.materials.helper.PeriodicMaterialHelper.periodicTableMaterials;

/**
 * Mass Replication Handler.
 *
 * @author Magic_Sweepy
 *
 * <p>
 *     Ref: {@code gregicadditions/recipes/RecipeHandler#matterReplication(Material)}.
 *     Thanks for original Gregicality Legacy devs, I just do some tweak in GTCEu environment.
 * </p>
 *
 * @since 2.8.8-beta
 */
public class MassReplicationRecipeHandler {

    public static void register() {
        //  Some utilities
        int replicationTimeFactor = GTLiteConfigHolder.machines.replicationTimeFactor;
        //  Traverse all Elements in {@code periodicTableMaterials}.
        for (Material periodicTableMaterial : periodicTableMaterials) {
            //  Mass of Element, used to check product UU Matter type.
            int mass = (int) periodicTableMaterial.getMass();
            //  UU Matter type, dependenced on Mass of Element.
            FluidStack uuMatter = mass % 2 == 0 ? BosonicUUMatter.getFluid(mass) : FermionicUUMatter.getFluid(mass);
            //  If Element have fluid (liquid or gas), then add fluid replication recipe.
            if (periodicTableMaterial.hasProperty(PropertyKey.FLUID)) {
                //  If Element has Ingot Property, then return 144L, if not, then return 1000L.
                int amount = periodicTableMaterial.hasProperty(PropertyKey.INGOT) ? L : 1000;
                //  Element -> UU Matter + Free Electron Gas.
                MASS_FABRICATOR_RECIPES.recipeBuilder()
                        .fluidInputs(periodicTableMaterial.getFluid(amount))
                        .fluidOutputs(uuMatter)
                        .fluidOutputs(FreeElectronGas.getFluid(mass))
                        .EUt(32)
                        .duration(mass * replicationTimeFactor)
                        .buildAndRegister();
                //  UU Matter + Free Electron Gas -> Element
                REPLICATOR_RECIPES.recipeBuilder()
                        .notConsumable(periodicTableMaterial.getFluid(amount))
                        .fluidInputs(uuMatter)
                        .fluidInputs(FreeElectronGas.getFluid(mass))
                        .fluidOutputs(periodicTableMaterial.getFluid(amount))
                        .EUt(32)
                        .duration(mass * replicationTimeFactor)
                        .buildAndRegister();
                //  Another recipe use total UU Matter.
                REPLICATOR_RECIPES.recipeBuilder()
                        .notConsumable(periodicTableMaterial.getFluid(amount))
                        .fluidInputs(UUMatter.getFluid(mass))
                        .fluidOutputs(periodicTableMaterial.getFluid(amount))
                        .EUt(32)
                        .duration(mass * replicationTimeFactor)
                        .buildAndRegister();
            } else {
                // If Element does not have fluid (liquid or gas), then check if it has dust property.
                if (periodicTableMaterial.hasProperty(PropertyKey.DUST)) {
                    //  Element -> UU Matter + Free Electron Gas.
                    MASS_FABRICATOR_RECIPES.recipeBuilder()
                            .input(dust, periodicTableMaterial)
                            .fluidOutputs(uuMatter)
                            .fluidOutputs(FreeElectronGas.getFluid(mass))
                            .EUt(32)
                            .duration(mass * replicationTimeFactor)
                            .buildAndRegister();
                    //  UU Matter + Free Electron Gas -> Element
                    REPLICATOR_RECIPES.recipeBuilder()
                            .notConsumable(dust, periodicTableMaterial)
                            .fluidInputs(uuMatter)
                            .fluidInputs(FreeElectronGas.getFluid(mass))
                            .output(dust, periodicTableMaterial)
                            .EUt(32)
                            .duration(mass * replicationTimeFactor)
                            .buildAndRegister();
                    //  Another recipe use total UU Matter.
                    REPLICATOR_RECIPES.recipeBuilder()
                            .notConsumable(dust, periodicTableMaterial)
                            .fluidInputs(UUMatter.getFluid(mass))
                            .output(dust, periodicTableMaterial)
                            .EUt(32)
                            .duration(mass * replicationTimeFactor)
                            .buildAndRegister();
                }
            }
        }

        //  Bosonic UU Matter + Fermionic UUMatter + Free Electron Gas -> UU Matter
        TURBINE_MIXER_RECIPES.recipeBuilder()
                .fluidInputs(BosonicUUMatter.getFluid(1000))
                .fluidInputs(FermionicUUMatter.getFluid(1000))
                .fluidInputs(FreeElectronGas.getFluid(2000))
                .fluidOutputs(UUMatter.getFluid(1000))
                .EUt(VA[IV])
                .duration(5 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }
}
