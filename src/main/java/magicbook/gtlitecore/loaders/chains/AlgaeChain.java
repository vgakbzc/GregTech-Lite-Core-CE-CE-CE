package magicbook.gtlitecore.loaders.chains;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import magicbook.gtlitecore.common.GTLiteConfigHolder;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.common.items.MetaItems.*;
import static gregtechfoodoption.GTFOMaterialHandler.LithiumCarbonate;
import static magicbook.gtlitecore.api.GTLiteValues.MINUTE;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class AlgaeChain {

    public static void init() {
        CommonAlgae();
        CelluloseFiber();
        AlienAlgae();

        //  Piranha Solution
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(HydrogenPeroxide.getFluid(1000))
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .circuitMeta(2)
                .fluidOutputs(PiranhaSolution.getFluid(2000))
                .EUt(VA[LV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  Contaminated Petri Dish -> Petri Dish
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(CONTAMINATED_PETRI_DISH)
                .fluidInputs(PiranhaSolution.getFluid(100))
                .output(PETRI_DISH)
                .EUt(VA[LV])
                .duration(5 * SECOND)
                .buildAndRegister();

        ExoticGasProcessing();
    }

    private static void CommonAlgae() {

        //  Ordinal Algae + H2O -> CH4
        FERMENTING_RECIPES.recipeBuilder()
                .input(ORDINARY_ALGAE, 10)
                .fluidInputs(DistilledWater.getFluid(500))
                .fluidOutputs(Methane.getFluid(500))
                .EUt((int) V[MV] / 2)
                .duration(5 * SECOND)
                .buildAndRegister();


        //  Green Algae + Brown Algae + 5H2O -> 5H2SO4
        CHEMICAL_RECIPES.recipeBuilder()
                .input(GREEN_ALGAE, 10)
                .input(BROWN_ALGAE, 6)
                .fluidInputs(DistilledWater.getFluid(5000))
                .fluidOutputs(SulfuricAcid.getFluid(5000))
                .EUt(VHA[MV])
                .duration(50 * SECOND)
                .buildAndRegister();

        //  Green Algae + Dirt + 0.1 H2O -> Biological Resin
        CHEMICAL_RECIPES.recipeBuilder()
                .inputs(new ItemStack(Blocks.DIRT))
                .input(GREEN_ALGAE, 5)
                .fluidInputs(DistilledWater.getFluid(100))
                .output(BIOLOGICAL_RESIN)
                .EUt(VA[LV])
                .duration(SECOND)
                .buildAndRegister();

        //  Brown Algae + 2H2O -> 3.3 Li2CO3
        FERMENTING_RECIPES.recipeBuilder()
                .input(BROWN_ALGAE, 40)
                .fluidInputs(DistilledWater.getFluid(2000))
                .outputs(LithiumCarbonate.getItemStack(20))
                .EUt(VA[LV])
                .duration(30 * SECOND)
                .buildAndRegister();

        //  Brown Algae -> 0.5 LiCl
        BLAST_RECIPES.recipeBuilder()
                .input(BROWN_ALGAE, 4)
                .circuitMeta(8)
                .output(dust, LithiumChloride)
                .EUt(VA[MV])
                .duration(2 * SECOND)
                .blastFurnaceTemp(1400)
                .buildAndRegister();

        //  Brown Alge -> Alginic Acid
        EXTRACTOR_RECIPES.recipeBuilder()
                .input(BROWN_ALGAE, 5)
                .output(ALGINIC_ACID)
                .EUt(VA[LV])
                .duration(SECOND)
                .buildAndRegister();

        //  Gold Algae -> 0.25 NH3
        EXTRACTOR_RECIPES.recipeBuilder()
                .input(GOLD_ALGAE)
                .fluidOutputs(Ammonia.getFluid(100))
                .EUt(VA[MV])
                .duration(3 * SECOND)
                .buildAndRegister();

        //  Blue Algae -> 0.1 Ethanol
        EXTRACTOR_RECIPES.recipeBuilder()
                .input(BLUE_ALGAE)
                .fluidOutputs(Ethanol.getFluid(100))
                .EUt(VA[MV])
                .duration(3 * SECOND)
                .buildAndRegister();

        //  todo Blue algae -> Butanol
    }

    private static void CelluloseFiber() {

        //  Red Algae -> Red Cellulose Fiber
        WIREMILL_RECIPES.recipeBuilder()
                .input(RED_ALGAE, 10)
                .circuitMeta(4)
                .output(RED_CELLULOSE_FIBER, 5)
                .EUt(VA[LV])
                .duration(8 * SECOND)
                .buildAndRegister();

        //  Green Algae -> Green Cellulose Fiber
        WIREMILL_RECIPES.recipeBuilder()
                .input(GREEN_ALGAE, 10)
                .circuitMeta(4)
                .output(GREEN_CELLULOSE_FIBER, 5)
                .EUt(VA[LV])
                .duration(8 * SECOND)
                .buildAndRegister();

        //  Gold Algae -> Gold Cellulose Fiber
        WIREMILL_RECIPES.recipeBuilder()
                .input(GOLD_ALGAE, 10)
                .circuitMeta(4)
                .output(GOLD_CELLULOSE_FIBER, 5)
                .EUt(VA[LV])
                .duration(8 * SECOND)
                .buildAndRegister();

        //  Red Cellulose Fiber -> CaCO3
        EXTRACTOR_RECIPES.recipeBuilder()
                .input(RED_CELLULOSE_FIBER, 3)
                .output(dust, Calcite, 5)
                .EUt(VHA[HV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  Green Cellulose Fiber -> 0.25 CH4O
        EXTRACTOR_RECIPES.recipeBuilder()
                .input(GREEN_ALGAE, 3)
                .fluidOutputs(Methanol.getFluid(250))
                .EUt(VA[LV])
                .duration(2 * SECOND)
                .buildAndRegister();

        //  Brown Algae + Gold Cellulose Fiber + 5H2O -> 5H2SO4
        CHEMICAL_RECIPES.recipeBuilder()
                .input(BROWN_ALGAE, 10)
                .input(GOLD_CELLULOSE_FIBER, 2)
                .fluidInputs(DistilledWater.getFluid(5000))
                .fluidOutputs(SulfuricAcid.getFluid(5000))
                .EUt(180) // HV
                .duration(6 * SECOND)
                .buildAndRegister();

        //  Red Cellulose Fiber + Gold Cellulose Fiber -> 18C4H9OH + 9C3H6O + 3C2H6O
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(RED_CELLULOSE_FIBER, 16)
                .input(GOLD_CELLULOSE_FIBER, 6)
                .fluidInputs(FermentedBiomass.getFluid(48000))
                .fluidOutputs(Butanol.getFluid(18000))
                .fluidOutputs(Acetone.getFluid(9000))
                .fluidOutputs(Ethanol.getFluid(3000))
                .EUt(VA[LV])
                .duration(2 * MINUTE)
                .buildAndRegister();

        //  Red Cellulose Fiber + Gold Cellulose Fiber + Green Cellulose Fiber + 2CH4 -> 2C2H2
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(RED_CELLULOSE_FIBER, 4)
                .input(GOLD_CELLULOSE_FIBER, 6)
                .input(GREEN_CELLULOSE_FIBER, 8)
                .fluidInputs(Methane.getFluid(2000))
                .fluidOutputs(Ethylene.getFluid(2000))
                .EUt(VHA[MV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  Alginic Acid + Green Cellulose Fiber -> Cellulose Pulp
        MIXER_RECIPES.recipeBuilder()
                .input(ALGINIC_ACID, 2)
                .input(GREEN_CELLULOSE_FIBER, 8)
                .output(CELLULOSE_PULP, 10)
                .EUt(VA[LV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  Cellulose Pulp -> Paper
        FORMING_PRESS_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_PLATE)
                .input(CELLULOSE_PULP, 4)
                .output(Items.PAPER, 4)
                .EUt(VA[LV])
                .duration(2 * SECOND)
                .buildAndRegister();

        //  Cellulose Pulp + Biological Resin -> Sticky Resin
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(BIOLOGICAL_RESIN)
                .input(CELLULOSE_PULP, 8)
                .output(STICKY_RESIN, 64)
                .EUt(VA[LV])
                .duration(MINUTE)
                .buildAndRegister();
    }

    private static void AlienAlgae() {

        //  Marine Algae
        ALGAE_CULTURE_TANK_RECIPES.recipeBuilder()
                .input(ENERGIUM_DUST, 8)
                .input(dust, Borax)
                .input(ORDINARY_ALGAE, 64)
                .fluidInputs(RawGrowthMedium.getFluid(1000))
                .fluidOutputs(MarineAlgae.getFluid(1000))
                .EUt(VA[HV])
                .duration(30 * SECOND)
                .buildAndRegister();

        //  Marine Algae -> Alien Marine Algae
        BIO_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(MarineAlgae.getFluid(1000))
                .fluidInputs(Mutagen.getFluid(200))
                .chancedFluidOutput(AlienMarineAlgae.getFluid(250), 5000, 500)
                .fluidOutputs(MarineAlgae.getFluid(750))
                .EUt(VA[IV])
                .duration(10 * SECOND)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .buildAndRegister();

        BIO_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(MarineAlgae.getFluid(1000))
                .fluidInputs(ExoticMutagen.getFluid(200))
                .fluidOutputs(AlienMarineAlgae.getFluid(250))
                .fluidOutputs(MarineAlgae.getFluid(750))
                .EUt(VA[LuV])
                .duration(10 * SECOND)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .buildAndRegister();

        //  Green Algae -> Bryopsis Hypnoides
        ALGAE_CULTURE_TANK_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(PETRI_DISH)
                .input(GREEN_ALGAE, 64)
                .input(dust, Lapotron, 16)
                .input(dust, Iodine, 2)
                .fluidInputs(AlienMarineAlgae.getFluid(50))
                .output(BARNARDA_C_BRYOPSIS_HYPNOIDES, 64)
                .output(CONTAMINATED_PETRI_DISH)
                .EUt(VA[IV])
                .duration(30 * SECOND)
                .buildAndRegister();

        //  Red Algae + Gold Algae -> Chlorella
        ALGAE_CULTURE_TANK_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(PETRI_DISH)
                .input(RED_ALGAE, 32)
                .input(GOLD_ALGAE, 32)
                .input(dust, Lapotron, 16)
                .input(dust, Iodine, 2)
                .fluidInputs(AlienMarineAlgae.getFluid(50))
                .output(BARNARDA_C_CHLORELLA, 64)
                .output(CONTAMINATED_PETRI_DISH)
                .EUt(VA[IV])
                .duration(30 * SECOND)
                .buildAndRegister();

        //  Red Algae + Brown Algae -> Conchospore
        ALGAE_CULTURE_TANK_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .input(PETRI_DISH)
                .input(RED_ALGAE, 32)
                .input(BROWN_ALGAE, 32)
                .input(dust, Lapotron, 16)
                .input(dust, Iodine, 2)
                .fluidInputs(AlienMarineAlgae.getFluid(50))
                .output(PROXIMA_B_CONCHOSPORE, 64)
                .output(CONTAMINATED_PETRI_DISH)
                .EUt(VA[IV])
                .duration(30 * SECOND)
                .buildAndRegister();

        //  Red Algae -> Phaeophyta
        ALGAE_CULTURE_TANK_RECIPES.recipeBuilder()
                .circuitMeta(4)
                .input(PETRI_DISH)
                .input(RED_ALGAE, 64)
                .input(dust, Lapotron, 16)
                .input(dust, Iodine, 2)
                .fluidInputs(AlienMarineAlgae.getFluid(50))
                .output(TAU_CETI_F_PHAEOPHYTA, 64)
                .output(CONTAMINATED_PETRI_DISH)
                .EUt(VA[IV])
                .duration(30 * SECOND)
                .buildAndRegister();

        //  Gold Algae -> Polysiphonia Senticulosa
        ALGAE_CULTURE_TANK_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(PETRI_DISH)
                .input(GOLD_ALGAE, 64)
                .input(dust, Lapotron, 16)
                .input(dust, Iodine, 2)
                .fluidInputs(AlienMarineAlgae.getFluid(50))
                .output(PROXIMA_B_POLYSIPHONIA_SENTICULOSA, 64)
                .output(CONTAMINATED_PETRI_DISH)
                .EUt(VA[IV])
                .duration(30 * SECOND)
                .buildAndRegister();

        //  Green Algae + Gold Algae -> Scenedesmus Obliquus
        ALGAE_CULTURE_TANK_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .input(PETRI_DISH)
                .input(GREEN_ALGAE, 32)
                .input(GOLD_ALGAE, 32)
                .input(dust, Lapotron, 16)
                .input(dust, Iodine, 2)
                .fluidInputs(AlienMarineAlgae.getFluid(50))
                .output(TAU_CETI_F_SCENEDESMUS_OBLIQUUS, 64)
                .output(CONTAMINATED_PETRI_DISH)
                .EUt(VA[IV])
                .duration(30 * SECOND)
                .buildAndRegister();

        //  Green Algae + Brown Algae -> Spirogyra
        ALGAE_CULTURE_TANK_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .input(PETRI_DISH)
                .input(GREEN_ALGAE, 32)
                .input(BROWN_ALGAE, 32)
                .input(dust, Lapotron, 16)
                .input(dust, Iodine, 2)
                .fluidInputs(AlienMarineAlgae.getFluid(50))
                .output(PROXIMA_B_SPIROGYRA, 64)
                .output(CONTAMINATED_PETRI_DISH)
                .EUt(VA[IV])
                .duration(30 * SECOND)
                .buildAndRegister();

        //  Blue Algae -> Spirulina
        ALGAE_CULTURE_TANK_RECIPES.recipeBuilder()
                .circuitMeta(8)
                .input(PETRI_DISH)
                .input(BLUE_ALGAE, 64)
                .input(dust, Lapotron, 16)
                .input(dust, Iodine, 2)
                .fluidInputs(AlienMarineAlgae.getFluid(50))
                .output(TAU_CETI_F_SPIRULINA, 64)
                .output(CONTAMINATED_PETRI_DISH)
                .EUt(VA[IV])
                .duration(30 * SECOND)
                .buildAndRegister();

        //  Blue Algae + Red Algae -> Zooxanthellae
        ALGAE_CULTURE_TANK_RECIPES.recipeBuilder()
                .circuitMeta(9)
                .input(PETRI_DISH)
                .input(BLUE_ALGAE, 32)
                .input(RED_ALGAE, 32)
                .input(dust, Lapotron, 16)
                .input(dust, Iodine, 2)
                .fluidInputs(AlienMarineAlgae.getFluid(50))
                .output(BARNARDA_C_ZOOXANTHELLAE, 64)
                .output(CONTAMINATED_PETRI_DISH)
                .EUt(VA[IV])
                .duration(30 * SECOND)
                .buildAndRegister();
    }

    private static void ExoticGasProcessing() {

        //  Algae -> Crude Exotic Gas
        PYROLYSE_RECIPES.recipeBuilder()
                .input(BARNARDA_C_BRYOPSIS_HYPNOIDES, 4)
                .fluidInputs(NaturalGas.getFluid(200))
                .circuitMeta(1)
                .fluidOutputs(CrudeExoticGas.getFluid(200))
                .EUt(VA[IV])
                .duration(10)
                .buildAndRegister();

        PYROLYSE_RECIPES.recipeBuilder()
                .input(BARNARDA_C_CHLORELLA, 4)
                .fluidInputs(NaturalGas.getFluid(200))
                .circuitMeta(1)
                .fluidOutputs(CrudeExoticGas.getFluid(200))
                .EUt(VA[IV])
                .duration(10)
                .buildAndRegister();

        PYROLYSE_RECIPES.recipeBuilder()
                .input(BARNARDA_C_ZOOXANTHELLAE, 4)
                .fluidInputs(NaturalGas.getFluid(200))
                .circuitMeta(1)
                .fluidOutputs(CrudeExoticGas.getFluid(200))
                .EUt(VA[IV])
                .duration(10)
                .buildAndRegister();

        PYROLYSE_RECIPES.recipeBuilder()
                .input(PROXIMA_B_CONCHOSPORE, 4)
                .fluidInputs(NaturalGas.getFluid(200))
                .circuitMeta(1)
                .fluidOutputs(CrudeExoticGas.getFluid(200))
                .EUt(VA[IV])
                .duration(10)
                .buildAndRegister();

        PYROLYSE_RECIPES.recipeBuilder()
                .input(PROXIMA_B_POLYSIPHONIA_SENTICULOSA, 4)
                .fluidInputs(NaturalGas.getFluid(200))
                .circuitMeta(1)
                .fluidOutputs(CrudeExoticGas.getFluid(200))
                .EUt(VA[IV])
                .duration(10)
                .buildAndRegister();

        PYROLYSE_RECIPES.recipeBuilder()
                .input(PROXIMA_B_SPIROGYRA, 4)
                .fluidInputs(NaturalGas.getFluid(200))
                .circuitMeta(1)
                .fluidOutputs(CrudeExoticGas.getFluid(200))
                .EUt(VA[IV])
                .duration(10)
                .buildAndRegister();

        PYROLYSE_RECIPES.recipeBuilder()
                .input(TAU_CETI_F_PHAEOPHYTA, 4)
                .fluidInputs(NaturalGas.getFluid(200))
                .circuitMeta(1)
                .fluidOutputs(CrudeExoticGas.getFluid(200))
                .EUt(VA[IV])
                .duration(10)
                .buildAndRegister();

        PYROLYSE_RECIPES.recipeBuilder()
                .input(TAU_CETI_F_SCENEDESMUS_OBLIQUUS, 4)
                .fluidInputs(NaturalGas.getFluid(200))
                .circuitMeta(1)
                .fluidOutputs(CrudeExoticGas.getFluid(200))
                .EUt(VA[IV])
                .duration(10)
                .buildAndRegister();

        PYROLYSE_RECIPES.recipeBuilder()
                .input(TAU_CETI_F_SPIRULINA, 4)
                .fluidInputs(NaturalGas.getFluid(200))
                .circuitMeta(1)
                .fluidOutputs(CrudeExoticGas.getFluid(200))
                .EUt(VA[IV])
                .duration(10)
                .buildAndRegister();

        //  Crude Exotic Gas -> Cracked Crude Exotic Gas
        CRACKING_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(CrudeExoticGas.getFluid(1000))
                .fluidInputs(MetastableOganesson.getFluid(1000))
                .fluidOutputs(CrackedCrudeExoticGas.getFluid(2000))
                .EUt(VA[UV])
                .duration(100)
                .buildAndRegister();

        //  Cs + F -> CsF
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Caesium)
                .fluidInputs(Fluorine.getFluid(1000))
                .circuitMeta(1)
                .fluidOutputs(CaesiumFluoride.getFluid(1000))
                .EUt(VA[MV])
                .duration(100)
                .buildAndRegister();

        //  Xe + 3O -> XeO3
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Xenon.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(3000))
                .circuitMeta(3)
                .fluidOutputs(XenonTrioxide.getFluid(1000))
                .EUt(VA[MV])
                .duration(100)
                .buildAndRegister();

        //  Rn + 3O -> RnO3
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Radon.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(3000))
                .circuitMeta(3)
                .fluidOutputs(RadonTrioxide.getFluid(1000))
                .EUt(VA[HV])
                .duration(100)
                .buildAndRegister();

        //  RnO3 + 2HF -> RnF2 + H2O + O (lost)
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(RadonTrioxide.getFluid(1000))
                .fluidInputs(HydrofluoricAcid.getFluid(2000))
                .fluidOutputs(RadonDifluoride.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .EUt(VA[EV])
                .duration(50)
                .buildAndRegister();

        //  *Nq* dust + RnF2 + 6HF -> Rn*Nq*F8 + 6H
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Naquadria)
                .fluidInputs(RadonDifluoride.getFluid(1000))
                .fluidInputs(HydrofluoricAcid.getFluid(6000))
                .fluidOutputs(RadonNaquadriaOctafluoride.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(6000))
                .EUt(VA[UV])
                .duration(20)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  CsF + XeO3 -> CsXeO3F
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(CaesiumFluoride.getFluid(1000))
                .fluidInputs(XenonTrioxide.getFluid(1000))
                .fluidOutputs(CaesiumXenontrioxideFluoride.getFluid(1000))
                .EUt(VA[MV])
                .duration(480)
                .buildAndRegister();

        //  Rn*Nq*F8 + CsXeO3F -> *Nq*CsXeF9 + RnO3
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(RadonNaquadriaOctafluoride.getFluid(1000))
                .fluidInputs(CaesiumXenontrioxideFluoride.getFluid(1000))
                .fluidOutputs(NaquadriaCaesiumXenonnonfluoride.getFluid(1000))
                .fluidOutputs(RadonTrioxide.getFluid(1000))
                .EUt(VA[IV])
                .duration(800)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Cracked Crude Exotic Gas + *Nq*CsXeF9 -> Naquadic Exotic Gas
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(CrackedCrudeExoticGas.getFluid(8000))
                .fluidInputs(NaquadriaCaesiumXenonnonfluoride.getFluid(1000))
                .fluidOutputs(NaquadicExoticGas.getFluid(4000))
                .fluidOutputs(NaquadriaCaesiumfluoride.getFluid(1000))
                .EUt(VA[UHV])
                .temperature(40976)
                .duration(200)
                .buildAndRegister();

        //  Naquadic Exotic Gas process
        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(NaquadicExoticGas.getFluid(4000))
                .output(dust, Tiberium)
                .fluidOutputs(SuperheavyExoticGas.getFluid(200))
                .fluidOutputs(HeavyExoticGas.getFluid(400))
                .fluidOutputs(MediumExoticGas.getFluid(1400))
                .fluidOutputs(LightExoticGas.getFluid(2000))
                .EUt(VA[UHV])
                .duration(200)
                .buildAndRegister();

        //  *Nq*F2CsF -> *Nq* (cycle) + Cs (cycle) + 3F
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder()
                .fluidInputs(NaquadriaCaesiumfluoride.getFluid(1000))
                .output(dust, Naquadria)
                .output(dust, Caesium)
                .fluidOutputs(Fluorine.getFluid(3000))
                .EUt(VA[ZPM])
                .duration(40)
                .buildAndRegister();

        //  Exotic Gas
        if (GTLiteConfigHolder.misc.enableExoticGasTurbineRecipe) {
            GAS_TURBINE_FUELS.recipeBuilder()
                    .fluidInputs(CrudeExoticGas.getFluid(1))
                    .EUt(GTLiteConfigHolder.misc.heatValueCrudeExoticGas)
                    .duration(240)
                    .buildAndRegister();

            GAS_TURBINE_FUELS.recipeBuilder()
                    .fluidInputs(SuperheavyExoticGas.getFluid(1))
                    .EUt(GTLiteConfigHolder.misc.heatValueExoticGas)
                    .duration(480)
                    .buildAndRegister();

            GAS_TURBINE_FUELS.recipeBuilder()
                    .fluidInputs(HeavyExoticGas.getFluid(2))
                    .EUt(GTLiteConfigHolder.misc.heatValueExoticGas)
                    .duration(360)
                    .buildAndRegister();

            GAS_TURBINE_FUELS.recipeBuilder()
                    .fluidInputs(MediumExoticGas.getFluid(4))
                    .EUt(GTLiteConfigHolder.misc.heatValueExoticGas)
                    .duration(180)
                    .buildAndRegister();

            GAS_TURBINE_FUELS.recipeBuilder()
                    .fluidInputs(LightExoticGas.getFluid(8))
                    .EUt(GTLiteConfigHolder.misc.heatValueExoticGas)
                    .duration(90)
                    .buildAndRegister();
        }
    }
}
