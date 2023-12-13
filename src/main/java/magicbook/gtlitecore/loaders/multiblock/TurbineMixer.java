package magicbook.gtlitecore.loaders.multiblock;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.TURBINE_MIXER_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class TurbineMixer {

    public static void init() {

        //  this recipe is bigger than mixer, so...maybe we can add all gcym Alloy Smelter recipe in this recipe!
        //  of course, its product dust material.

        //  An easy testing recipe
        TURBINE_MIXER_RECIPES.recipeBuilder()
                .input(dust, Inconel792, 8)
                .input(dust, EglinSteel, 5)
                .input(dust, NaquadahAlloy, 4)
                .input(dust, TungstenSteel, 4)
                .input(dust, Cerium, 3)
                .input(dust, Antimony, 2)
                .input(dust, Platinum, 2)
                .input(dust, Ytterbium)
                .circuitMeta(8)
                .output(dust, Pikyonium64B, 29)
                .EUt(VA[ZPM])
                .duration(6000)
                .buildAndRegister();

        //  Platinum Group Alloy (AuAgPtPdRuRhIrOs)
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
                .EUt(VA[LuV])
                .duration(340)
                .buildAndRegister();

        //  Inert Gas Mixture (HeNeArKrXeRn)
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

        //  Halogen Mixture (FClBrIAt)
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

        //  Non-metallic Mixture (HBCNOSiPSAsSeTe)
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

        //  Rare Earth Alloy
        TURBINE_MIXER_RECIPES.recipeBuilder()
                .input(dust, LanthanumGroupLAlloy, 8)
                .input(dust, LanthanumGroupHAlloy, 8)
                .input(dust, ActiniumGroupLAlloy, 8)
                .input(dust, ActiniumGroupHAlloy, 8)
                .circuitMeta(4)
                .output(dust, RareEarthAlloy, 32)
                .EUt(VA[MV])
                .duration(50)
                .buildAndRegister();

        //  Periodicium
        TURBINE_MIXER_RECIPES.recipeBuilder()
                .input(dust, PlatinumGroupAlloy, 8) // AuAgPtPdRuRhIrOs
                .input(dust, AlkalisGroupAlloy, 6) // LiNaKRbCsFr
                .input(dust, AlkalineEarthGroupAlloy, 6) // BeMgCaSrBaRa
                .input(dust, TransitionLAlloy, 8) // TiVCrMnFeCoNiCu
                .input(dust, TransitionHAlloy, 8) // ZrNbMoTcHfTaWRe
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
}
