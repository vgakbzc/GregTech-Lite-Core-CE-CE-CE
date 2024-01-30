package magicbook.gtlitecore.loaders.multiblock;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.MIXER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.TURBINE_MIXER_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class TurbineMixer {

    public static void init() {

        //  This recipe is bigger than mixer, so...maybe we can add all gcym Alloy Smelter recipe in this recipe!
        //  Of course, its product dust material.

        PeriodiciumComponents();

        //  Periodicium
        TURBINE_MIXER_RECIPES.recipeBuilder()
                .input(dust, AlkalisGroupAlloy, 6) // LiNaKRbCsFr
                .input(dust, AlkalineEarthGroupAlloy, 6) // BeMgCaSrBaRa
                .input(dust, TransitionLAlloy, 8) // TiVCrMnFeCoNiCu
                .input(dust, TransitionHAlloy, 8) // ZrNbMoTcHfTaWRe
                .input(dust, PlatinumGroupAlloy, 8) // AuAgPtPdRuRhIrOs
                .input(dust, RefractoryAlloy, 8) // AlZnGaGeCdInSnSb
                .input(dust, RareEarthAlloy, 32) // LaCePrNdPmSmEuGdTbDyHoErTmYbLuScYAcThPaUNpPuAmCmBkCfEsFmMdNoLr
                .input(dust, SuperheavyLAlloy, 8) // RfDbSgBhHsMtDsRg
                .input(dust, SuperheavyHAlloy, 7) // CnNhFlMcLvTsOg
                .fluidInputs(HalogenMixture.getFluid(5000)) // FClBrIAt
                .fluidInputs(NonMetallicMixture.getFluid(10000)) // HBCNOSiPSAsSeTe
                .fluidInputs(InertGasMixture.getFluid(6000)) // HeNeArKrXeRn
                .fluidInputs(ToxicAlloy.getFluid(L * 5)) // HgTlPbBiPo
                .output(dust, Periodicium, 118)
                .EUt(VA[UEV])
                .duration(20)
                .buildAndRegister();

    }

    private static void PeriodiciumComponents() {

        //  Alkalis Group Alloy
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Lithium)
                .input(dust, Sodium)
                .input(dust, Potassium)
                .input(dust, Rubidium)
                .input(dust, Caesium)
                .input(dust, Francium)
                .output(dust, AlkalisGroupAlloy, 6)
                .EUt(VA[UV])
                .duration(240)
                .buildAndRegister();

        //  Alkaline Earth Group Alloy
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Beryllium)
                .input(dust, Magnesium)
                .input(dust, Calcium)
                .input(dust, Strontium)
                .input(dust, Barium)
                .input(dust, Radium)
                .output(dust, AlkalineEarthGroupAlloy, 6)
                .EUt(VA[UV])
                .duration(280)
                .buildAndRegister();

        //  Transition-L Alloy
        TURBINE_MIXER_RECIPES.recipeBuilder()
                .circuitMeta(8)
                .input(dust, Titanium)
                .input(dust, Vanadium)
                .input(dust, Chrome)
                .input(dust, Manganese)
                .input(dust, Iron)
                .input(dust, Cobalt)
                .input(dust, Nickel)
                .input(dust, Copper)
                .output(dust, TransitionLAlloy, 8)
                .EUt(VA[UHV])
                .duration(350)
                .buildAndRegister();

        //  Transition-H Alloy
        TURBINE_MIXER_RECIPES.recipeBuilder()
                .circuitMeta(8)
                .input(dust, Zirconium)
                .input(dust, Niobium)
                .input(dust, Molybdenum)
                .input(dust, Technetium)
                .input(dust, Hafnium)
                .input(dust, Tantalum)
                .input(dust, Tungsten)
                .input(dust, Rhenium)
                .output(dust, TransitionHAlloy, 8)
                .EUt(VA[UHV])
                .duration(380)
                .buildAndRegister();

        //  Platinum Group Alloy
        TURBINE_MIXER_RECIPES.recipeBuilder()
                .circuitMeta(8)
                .input(dust, Gold)
                .input(dust, Silver)
                .input(dust, Platinum)
                .input(dust, Palladium)
                .input(dust, Ruthenium)
                .input(dust, Rhodium)
                .input(dust, Iridium)
                .input(dust, Osmium)
                .output(dust, PlatinumGroupAlloy, 8)
                .EUt(VA[UV])
                .duration(400)
                .buildAndRegister();

        //  Refractory Alloy
        TURBINE_MIXER_RECIPES.recipeBuilder()
                .circuitMeta(8)
                .input(dust, Aluminium)
                .input(dust, Zinc)
                .input(dust, Gallium)
                .input(dust, Germanium)
                .input(dust, Cadmium)
                .input(dust, Indium)
                .input(dust, Tin)
                .input(dust, Antimony)
                .output(dust, RefractoryAlloy, 8)
                .EUt(VA[UHV])
                .duration(220)
                .buildAndRegister();

        //  Lanthanum Group-L Alloy
        TURBINE_MIXER_RECIPES.recipeBuilder()
                .circuitMeta(8)
                .input(dust, Lanthanum)
                .input(dust, Cerium)
                .input(dust, Praseodymium)
                .input(dust, Neodymium)
                .input(dust, Promethium)
                .input(dust, Samarium)
                .input(dust, Europium)
                .input(dust, Scandium)
                .output(dust, LanthanumGroupLAlloy, 8)
                .EUt(VA[UEV])
                .duration(140)
                .buildAndRegister();

        //  Lanthanum Group-H Alloy
        TURBINE_MIXER_RECIPES.recipeBuilder()
                .circuitMeta(8)
                .input(dust, Gadolinium)
                .input(dust, Terbium)
                .input(dust, Dysprosium)
                .input(dust, Holmium)
                .input(dust, Erbium)
                .input(dust, Thulium)
                .input(dust, Ytterbium)
                .input(dust, Lutetium)
                .output(dust, LanthanumGroupHAlloy, 8)
                .EUt(VA[UEV])
                .duration(180)
                .buildAndRegister();

        //  Actinium Group-L Alloy
        TURBINE_MIXER_RECIPES.recipeBuilder()
                .circuitMeta(8)
                .input(dust, Actinium)
                .input(dust, Thorium)
                .input(dust, Protactinium)
                .input(dust, Uranium238)
                .input(dust, Neptunium)
                .input(dust, Plutonium241)
                .input(dust, Americium)
                .input(dust, Yttrium)
                .output(dust, ActiniumGroupLAlloy, 8)
                .EUt(VA[UEV])
                .duration(160)
                .buildAndRegister();

        //  Actinium Group-H Alloy
        TURBINE_MIXER_RECIPES.recipeBuilder()
                .circuitMeta(8)
                .input(dust, Curium)
                .input(dust, Berkelium)
                .input(dust, Californium)
                .input(dust, Einsteinium)
                .input(dust, Fermium)
                .input(dust, Mendelevium)
                .input(dust, Nobelium)
                .input(dust, Lawrencium)
                .output(dust, ActiniumGroupHAlloy, 8)
                .EUt(VA[UEV])
                .duration(200)
                .buildAndRegister();

        //  Rare Earth Alloy
        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(4)
                .input(dust, LanthanumGroupLAlloy, 8)
                .input(dust, LanthanumGroupHAlloy, 8)
                .input(dust, ActiniumGroupLAlloy, 8)
                .input(dust, ActiniumGroupHAlloy, 8)
                .output(dust, RareEarthAlloy, 32)
                .EUt(VA[MV])
                .duration(50)
                .buildAndRegister();

        //  Halogen Mixture
        TURBINE_MIXER_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(dust, Iodine)
                .fluidInputs(Fluorine.getFluid(1000))
                .fluidInputs(Chlorine.getFluid(1000))
                .fluidInputs(Bromine.getFluid(1000))
                .fluidInputs(Astatine.getFluid(1000))
                .fluidOutputs(HalogenMixture.getFluid(5000))
                .EUt(VA[ZPM])
                .duration(600)
                .buildAndRegister();

        //  Non-metallic Mixture
        TURBINE_MIXER_RECIPES.recipeBuilder()
                .input(dust, Boron)
                .input(dust, Carbon)
                .input(dust, Silicon)
                .input(dust, Phosphorus)
                .input(dust, Sulfur)
                .input(dust, Arsenic)
                .input(dust, Selenium)
                .input(dust, Tellurium)
                .circuitMeta(10)
                .fluidInputs(Hydrogen.getFluid(1000))
                .fluidInputs(Nitrogen.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(1000))
                .fluidOutputs(NonMetallicMixture.getFluid(10000))
                .EUt(VA[ZPM])
                .duration(600)
                .buildAndRegister();

        //  Inert Gas Mixture
        TURBINE_MIXER_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .fluidInputs(Helium.getFluid(1000))
                .fluidInputs(Neon.getFluid(1000))
                .fluidInputs(Argon.getFluid(1000))
                .fluidInputs(Krypton.getFluid(1000))
                .fluidInputs(Xenon.getFluid(1000))
                .fluidInputs(Radon.getFluid(1000))
                .fluidOutputs(InertGasMixture.getFluid(6000))
                .EUt(VA[ZPM])
                .duration(600)
                .buildAndRegister();

        //  Toxic Alloy
        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(dust, Thallium)
                .input(dust, Lead)
                .input(dust, Bismuth)
                .input(dust, Polonium)
                .fluidInputs(Mercury.getFluid(1000))
                .output(dust, ToxicAlloy, 5)
                .EUt(VA[UV])
                .duration(40)
                .buildAndRegister();
    }
}
