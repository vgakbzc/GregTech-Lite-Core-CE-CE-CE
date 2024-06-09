package magicbook.gtlitecore.api.unification.materials;

import gregtech.api.fluids.FluidBuilder;
import gregtech.api.fluids.store.FluidStorageKeys;
import gregtech.api.unification.material.properties.*;

import static gregtech.api.GTValues.UEV;
import static gregtech.api.GTValues.V;
import static gregtech.api.unification.material.Materials.*;

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
        Actinium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Astatine.setProperty(PropertyKey.FLUID, new FluidProperty());
        Berkelium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Bohrium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Bromine.setProperty(PropertyKey.FLUID, new FluidProperty());
        Caesium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Californium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Copernicium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Curium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Dubnium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Dysprosium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Einsteinium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Erbium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Francium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Gadolinium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Germanium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Hafnium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Holmium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Iodine.setProperty(PropertyKey.FLUID, new FluidProperty());
        Lawrencium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Livermorium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Meitnerium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Mendelevium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Moscovium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Nihonium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Nobelium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Polonium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Praseodymium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Protactinium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Radium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Roentgenium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Rubidium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Rutherfordium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Scandium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Seaborgium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Sodium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Strontium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Technetium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Tellurium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Tennessine.setProperty(PropertyKey.FLUID, new FluidProperty());
        Terbium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Thulium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Ytterbium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Zirconium.setProperty(PropertyKey.FLUID, new FluidProperty());

        /* -------------------------------- Element Materials with Plasma -------------------------------- */
        var fpPropertyBoron = new FluidProperty();
        fpPropertyBoron.getStorage().enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        fpPropertyBoron.getStorage().enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder());
        Boron.setProperty(PropertyKey.FLUID, fpPropertyBoron);

        var fpPropertyCalcium = new FluidProperty();
        fpPropertyCalcium.getStorage().enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        fpPropertyCalcium.getStorage().enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder());
        Calcium.setProperty(PropertyKey.FLUID, fpPropertyCalcium);

        Neon.getProperty(PropertyKey.FLUID).getStorage()
                .enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder());

        var fpPropertySulfur = new FluidProperty();
        fpPropertySulfur.getStorage().enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        fpPropertySulfur.getStorage().enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder());
        Sulfur.setProperty(PropertyKey.FLUID, fpPropertySulfur);

        Zinc.getProperty(PropertyKey.FLUID).getStorage()
                .enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder());

        Niobium.getProperty(PropertyKey.FLUID).getStorage()
                .enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder());

        Titanium.getProperty(PropertyKey.FLUID).getStorage()
                .enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder());

        Krypton.getProperty(PropertyKey.FLUID).getStorage()
                .enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder());

        Silver.getProperty(PropertyKey.FLUID).getStorage()
                .enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder());

        Bismuth.getProperty(PropertyKey.FLUID).getStorage()
                .enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder());

        Xenon.getProperty(PropertyKey.FLUID).getStorage()
                .enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder());

        Radon.getProperty(PropertyKey.FLUID).getStorage()
                .enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder());

        var fpPropertyNeptunium = new FluidProperty();
        fpPropertyNeptunium.getStorage().enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        fpPropertyNeptunium.getStorage().enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder());
        Neptunium.setProperty(PropertyKey.FLUID, fpPropertyNeptunium);

        var fpPropertyFermium = new FluidProperty();
        fpPropertyFermium.getStorage().enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder());
        fpPropertyFermium.getStorage().enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder());
        Fermium.setProperty(PropertyKey.FLUID, fpPropertyFermium);

        Plutonium241.getProperty(PropertyKey.FLUID).getStorage()
                .enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder());

        Lead.getProperty(PropertyKey.FLUID).getStorage()
                .enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder());

        Thorium.getProperty(PropertyKey.FLUID).getStorage()
                .enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder());

        /* ---------------------------------------- Misc Materials --------------------------------------- */
        NetherStar.setProperty(PropertyKey.FLUID, new FluidProperty());
        SodiumBisulfate.setProperty(PropertyKey.FLUID, new FluidProperty());
        AmmoniumChloride.setProperty(PropertyKey.FLUID, new FluidProperty());
        SodiumHydroxide.setProperty(PropertyKey.FLUID, new FluidProperty());

        /* --------------------------------------- Misc Properties --------------------------------------- */
        Germanium.setProperty(PropertyKey.BLAST, new BlastProperty(1211, BlastProperty.GasTier.HIGH));
        Seaborgium.setProperty(PropertyKey.WIRE, new WireProperties((int) V[UEV], 32, 32, false));

        PalladiumRaw.setFormula("PdCl2", true);
        RarestMetalMixture.setFormula("IrOs?", true);
        IridiumMetalResidue.setFormula("Ir2O3", true);

        Dysprosium.setMaterialRGB(0xDD79DD);
        Erbium.setMaterialRGB(0xCC6633);
        Holmium.setMaterialRGB(0xC38E2F);
        Terbium.setMaterialRGB(0xA274A2);
        Thulium.setMaterialRGB(0x44B6A0);

    }
}
