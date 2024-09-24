package magicbook.gtlitecore.api.unification.materials;

import gregtech.api.fluids.FluidBuilder;
import gregtech.api.fluids.store.FluidStorageKeys;
import gregtech.api.unification.material.properties.*;

import static gregtech.api.GTValues.UEV;
import static gregtech.api.GTValues.V;
import static gregtech.api.unification.material.Materials.*;
import static magicbook.gtlitecore.api.utils.GTLiteUtility.superscriptNumbers;

public class GTLiteMaterialPropertyAddition {

    public static void init() {
        /* --------------------------------- Element Materials with Ingot -------------------------------- */
        Actinium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Berkelium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Bohrium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Californium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Copernicium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Curium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Dubnium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Einsteinium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Fermium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Francium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Germanium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Hafnium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Lawrencium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Livermorium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Meitnerium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Mendelevium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Moscovium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Neptunium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Nihonium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Nobelium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Polonium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Promethium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Protactinium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Rhenium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Roentgenium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Rutherfordium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Seaborgium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Strontium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Technetium.setProperty(PropertyKey.INGOT, new IngotProperty());

        /* ---------------------------------- Element Materials with Dust -------------------------------- */
        Erbium.setProperty(PropertyKey.DUST, new DustProperty());
        Iodine.setProperty(PropertyKey.DUST, new DustProperty());
        Praseodymium.setProperty(PropertyKey.DUST, new DustProperty());
        Radium.setProperty(PropertyKey.DUST, new DustProperty());
        Rubidium.setProperty(PropertyKey.DUST, new DustProperty());
        Selenium.setProperty(PropertyKey.DUST, new DustProperty());
        Scandium.setProperty(PropertyKey.DUST, new DustProperty());
        Terbium.setProperty(PropertyKey.DUST, new DustProperty());
        Thallium.setProperty(PropertyKey.DUST, new DustProperty());
        Thulium.setProperty(PropertyKey.DUST, new DustProperty());

        /* --------------------------------- Element Materials with Fluid -------------------------------- */
        var fpActinium = new FluidProperty();
        fpActinium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Actinium.setProperty(PropertyKey.FLUID, fpActinium);

        var fpAstatine = new FluidProperty();
        fpAstatine.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Astatine.setProperty(PropertyKey.FLUID, fpAstatine);

        var fpBerkelium = new FluidProperty();
        fpBerkelium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Berkelium.setProperty(PropertyKey.FLUID, fpBerkelium);

        var fpBohrium = new FluidProperty();
        fpBohrium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Bohrium.setProperty(PropertyKey.FLUID, fpBohrium);

        var fpBromine = new FluidProperty();
        fpBromine.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Bromine.setProperty(PropertyKey.FLUID, fpBromine);

        var fpCaesium = new FluidProperty();
        fpCaesium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Caesium.setProperty(PropertyKey.FLUID, fpCaesium);

        var fpCalifornium = new FluidProperty();
        fpCalifornium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Californium.setProperty(PropertyKey.FLUID, fpCalifornium);

        var fpCopernicium = new FluidProperty();
        fpCopernicium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Copernicium.setProperty(PropertyKey.FLUID, fpCopernicium);

        var fpCurium = new FluidProperty();
        fpCurium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Curium.setProperty(PropertyKey.FLUID, fpCurium);

        var fpDubnium = new FluidProperty();
        fpDubnium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Dubnium.setProperty(PropertyKey.FLUID, fpDubnium);

        var fpDysprosium = new FluidProperty();
        fpDysprosium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Dysprosium.setProperty(PropertyKey.FLUID, fpDysprosium);

        var fpEinsteinium = new FluidProperty();
        fpEinsteinium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Einsteinium.setProperty(PropertyKey.FLUID, fpEinsteinium);

        var fpErbium = new FluidProperty();
        fpErbium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Erbium.setProperty(PropertyKey.FLUID, fpErbium);

        var fpFrancium = new FluidProperty();
        fpFrancium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Francium.setProperty(PropertyKey.FLUID, fpFrancium);

        var fpHafnium = new FluidProperty();
        fpHafnium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Hafnium.setProperty(PropertyKey.FLUID, fpHafnium);

        var fpHolmium = new FluidProperty();
        fpHolmium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Holmium.setProperty(PropertyKey.FLUID, fpHolmium);

        var fpIodine = new FluidProperty();
        fpIodine.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Iodine.setProperty(PropertyKey.FLUID, fpIodine);

        var fpLawrencium = new FluidProperty();
        fpLawrencium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Lawrencium.setProperty(PropertyKey.FLUID, fpLawrencium);

        var fpLivermorium = new FluidProperty();
        fpLivermorium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Livermorium.setProperty(PropertyKey.FLUID, fpLivermorium);

        var fpMeitnerium = new FluidProperty();
        fpMeitnerium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Meitnerium.setProperty(PropertyKey.FLUID, fpMeitnerium);

        var fpMendelevium = new FluidProperty();
        fpMendelevium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Mendelevium.setProperty(PropertyKey.FLUID, fpMendelevium);

        var fpMoscovium = new FluidProperty();
        fpMoscovium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Moscovium.setProperty(PropertyKey.FLUID, fpMoscovium);

        var fpNihonium = new FluidProperty();
        fpNihonium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Nihonium.setProperty(PropertyKey.FLUID, fpNihonium);

        var fpNobelium = new FluidProperty();
        fpNobelium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Nobelium.setProperty(PropertyKey.FLUID, fpNobelium);

        var fpPolonium = new FluidProperty();
        fpPolonium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Polonium.setProperty(PropertyKey.FLUID, fpPolonium);

        var fpPraseodymium = new FluidProperty();
        fpPraseodymium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Praseodymium.setProperty(PropertyKey.FLUID, fpPraseodymium);

        var fpProtactinium = new FluidProperty();
        fpProtactinium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Protactinium.setProperty(PropertyKey.FLUID, fpProtactinium);

        var fpRadium = new FluidProperty();
        fpRadium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Radium.setProperty(PropertyKey.FLUID, fpRadium);

        var fpRoentgenium = new FluidProperty();
        fpRoentgenium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Roentgenium.setProperty(PropertyKey.FLUID, fpRoentgenium);

        var fpRubidium = new FluidProperty();
        fpRubidium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Rubidium.setProperty(PropertyKey.FLUID, fpRubidium);

        var fpRutherfordium = new FluidProperty();
        fpRutherfordium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Rutherfordium.setProperty(PropertyKey.FLUID, fpRutherfordium);

        var fpScandium = new FluidProperty();
        fpScandium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Scandium.setProperty(PropertyKey.FLUID, fpScandium);

        var fpSeaborgium = new FluidProperty();
        fpSeaborgium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Seaborgium.setProperty(PropertyKey.FLUID, fpSeaborgium);

        var fpStrontium = new FluidProperty();
        fpStrontium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Strontium.setProperty(PropertyKey.FLUID, fpStrontium);

        var fpTechnetium = new FluidProperty();
        fpTechnetium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Technetium.setProperty(PropertyKey.FLUID, fpTechnetium);

        var fpTellurium = new FluidProperty();
        fpTellurium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Tellurium.setProperty(PropertyKey.FLUID, fpTellurium);

        var fpTennessine = new FluidProperty();
        fpTennessine.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Tennessine.setProperty(PropertyKey.FLUID, fpTennessine);

        var fpTerbium = new FluidProperty();
        fpTerbium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Terbium.setProperty(PropertyKey.FLUID, fpTerbium);

        var fpThulium = new FluidProperty();
        fpThulium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Thulium.setProperty(PropertyKey.FLUID, fpThulium);

        var fpYtterbium = new FluidProperty();
        fpYtterbium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Ytterbium.setProperty(PropertyKey.FLUID, fpYtterbium);

        var fpZirconium = new FluidProperty();
        fpZirconium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        Zirconium.setProperty(PropertyKey.FLUID, fpZirconium);

        /* -------------------------------- Element Materials with Plasma -------------------------------- */
        var fpPropertyBoron = new FluidProperty();
        fpPropertyBoron.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        fpPropertyBoron.enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder());
        Boron.setProperty(PropertyKey.FLUID, fpPropertyBoron);

        var fpPropertyCalcium = new FluidProperty();
        fpPropertyCalcium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        fpPropertyCalcium.enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder());
        Calcium.setProperty(PropertyKey.FLUID, fpPropertyCalcium);

        Neon.getProperty(PropertyKey.FLUID)
                .enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder());

        var fpPropertySulfur = new FluidProperty();
        fpPropertySulfur.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        fpPropertySulfur.enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder());
        Sulfur.setProperty(PropertyKey.FLUID, fpPropertySulfur);

        Zinc.getProperty(PropertyKey.FLUID).enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder());

        Niobium.getProperty(PropertyKey.FLUID).enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder());

        Titanium.getProperty(PropertyKey.FLUID).enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder());

        Krypton.getProperty(PropertyKey.FLUID).enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder());

        Silver.getProperty(PropertyKey.FLUID).enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder());

        Bismuth.getProperty(PropertyKey.FLUID).enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder());

        Xenon.getProperty(PropertyKey.FLUID).enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder());

        Radon.getProperty(PropertyKey.FLUID).enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder());

        var fpPropertyNeptunium = new FluidProperty();
        fpPropertyNeptunium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        fpPropertyNeptunium.enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder());
        Neptunium.setProperty(PropertyKey.FLUID, fpPropertyNeptunium);

        var fpPropertyFermium = new FluidProperty();
        fpPropertyFermium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        fpPropertyFermium.enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder());
        Fermium.setProperty(PropertyKey.FLUID, fpPropertyFermium);

        Plutonium241.getProperty(PropertyKey.FLUID).enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder());

        Lead.getProperty(PropertyKey.FLUID).enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder());

        Thorium.getProperty(PropertyKey.FLUID).enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder());

        var fpPropertyGermanium = new FluidProperty();
        fpPropertyGermanium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        fpPropertyGermanium.enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder());
        Germanium.setProperty(PropertyKey.FLUID, fpPropertyGermanium);

        Chrome.getProperty(PropertyKey.FLUID).enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder());

        var fpPropertyGadolinium = new FluidProperty();
        fpPropertyGadolinium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        fpPropertyGadolinium.enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder());

        Gadolinium.setProperty(PropertyKey.FLUID, fpPropertyGadolinium);

        var fpPropertySodium = new FluidProperty();
        fpPropertySodium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        fpPropertySodium.enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder());

        Sodium.setProperty(PropertyKey.FLUID, fpPropertySodium);

        var fpPropertyRhenium = new FluidProperty();
        fpPropertyRhenium.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        fpPropertyRhenium.enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder());

        Rhenium.setProperty(PropertyKey.FLUID, fpPropertyRhenium);

        /* ---------------------------------------- Misc Materials --------------------------------------- */
        var fpNetherStar = new FluidProperty();
        fpNetherStar.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        NetherStar.setProperty(PropertyKey.FLUID, fpNetherStar);

        var fpSodiumBisulfate = new FluidProperty();
        fpSodiumBisulfate.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        SodiumBisulfate.setProperty(PropertyKey.FLUID, fpSodiumBisulfate);

        var fpAmmoniumChloride = new FluidProperty();
        fpAmmoniumChloride.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        AmmoniumChloride.setProperty(PropertyKey.FLUID, fpAmmoniumChloride);

        var fpSodiumHydroxide = new FluidProperty();
        fpSodiumHydroxide.enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        SodiumHydroxide.setProperty(PropertyKey.FLUID, fpSodiumHydroxide);

        /* --------------------------------------- Misc Properties --------------------------------------- */
        Germanium.setProperty(PropertyKey.BLAST, new BlastProperty(1211, BlastProperty.GasTier.HIGH));
        Hafnium.setProperty(PropertyKey.BLAST, new BlastProperty(2227, BlastProperty.GasTier.HIGHER));
        Seaborgium.setProperty(PropertyKey.WIRE, new WireProperties((int) V[UEV], 32, 32, false));

        PalladiumRaw.setFormula("PdCl2", true);
        RarestMetalMixture.setFormula("IrOs?", true);
        IridiumMetalResidue.setFormula("Ir2O3", true);

        Uranium235.setFormula(superscriptNumbers("235U"), false);
        Uranium238.setFormula(superscriptNumbers("238U"), false);
        Plutonium239.setFormula(superscriptNumbers("239Pu"), false);
        Plutonium241.setFormula(superscriptNumbers("241Pu"), false);

        Dysprosium.setMaterialRGB(0xDD79DD);
        Erbium.setMaterialRGB(0xCC6633);
        Holmium.setMaterialRGB(0xC38E2F);
        Terbium.setMaterialRGB(0xA274A2);
        Thulium.setMaterialRGB(0x44B6A0);

    }
}
