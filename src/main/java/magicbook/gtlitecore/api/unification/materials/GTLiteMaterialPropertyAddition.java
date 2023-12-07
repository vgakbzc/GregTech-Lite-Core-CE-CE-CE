package magicbook.gtlitecore.api.unification.materials;

import gregtech.api.unification.material.properties.*;
import magicbook.gtlitecore.common.GTLiteConfigHolder;

import static gregicality.multiblocks.api.unification.GCYMMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteMaterialFlags.*;

public class GTLiteMaterialPropertyAddition {
    public static void init() {

        //  Platinum Group
        PalladiumRaw.setFormula("PdCl2", true);
        RarestMetalMixture.setFormula("IrOs?", true);
        IridiumMetalResidue.setFormula("Ir2O3", true);
        SodiumBisulfate.setProperty(PropertyKey.FLUID, new FluidProperty());

        //  Rare Earth
        Praseodymium.setProperty(PropertyKey.DUST, new DustProperty());
        Scandium.setProperty(PropertyKey.DUST, new DustProperty());
        Scandium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Gadolinium.setProperty(PropertyKey.DUST, new DustProperty());
        Terbium.setProperty(PropertyKey.DUST, new DustProperty());
        Dysprosium.setProperty(PropertyKey.DUST, new DustProperty());
        Holmium.setProperty(PropertyKey.DUST, new DustProperty());
        Erbium.setProperty(PropertyKey.DUST, new DustProperty());
        Thulium.setProperty(PropertyKey.DUST, new DustProperty());
        Ytterbium.setProperty(PropertyKey.DUST, new DustProperty());
        Ytterbium.setProperty(PropertyKey.FLUID, new FluidProperty());

        //  Isa Mill Ore Process
        Thallium.setProperty(PropertyKey.DUST, new DustProperty());
        Rhenium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Selenium.setProperty(PropertyKey.DUST, new DustProperty());
        Tellurium.setProperty(PropertyKey.DUST, new DustProperty());
        Strontium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Strontium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Germanium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Germanium.setProperty(PropertyKey.BLAST, new BlastProperty(1211, BlastProperty.GasTier.HIGH));
        Germanium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Promethium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Hafnium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Hafnium.setProperty(PropertyKey.FLUID, new FluidProperty());

        //  Elements
        Calcium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Dubnium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Dubnium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Rutherfordium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Rutherfordium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Polonium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Polonium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Bromine.setProperty(PropertyKey.FLUID, new FluidProperty());
        Iodine.setProperty(PropertyKey.DUST, new DustProperty());
        Iodine.setProperty(PropertyKey.FLUID, new FluidProperty());
        Livermorium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Livermorium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Seaborgium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Seaborgium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Seaborgium.setProperty(PropertyKey.WIRE, new WireProperties((int) V[UEV], 32, 32, false));
        Actinium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Actinium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Caesium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Astatine.setProperty(PropertyKey.FLUID, new FluidProperty());
        Californium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Curium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Radium.setProperty(PropertyKey.DUST, new DustProperty());
        Radium.setProperty(PropertyKey.FLUID, new FluidProperty());

        //  Zirconium Chain
        Zirconium.setProperty(PropertyKey.DUST, new DustProperty());
        Zirconium.setProperty(PropertyKey.FLUID, new FluidProperty());

        //  Rubidium Chain
        Rubidium.setProperty(PropertyKey.DUST, new DustProperty());

        //  Ichorium Chain
        NetherStar.setProperty(PropertyKey.FLUID, new FluidProperty());

        //  Organic Chemistry
        AmmoniumChloride.setProperty(PropertyKey.FLUID, new FluidProperty());

        //  Milled
        Almandine.addFlags(GENERATE_MILLED);
        Chalcopyrite.addFlags(GENERATE_MILLED);
        Grossular.addFlags(GENERATE_MILLED);
        Monazite.addFlags(GENERATE_MILLED);
        Nickel.addFlags(GENERATE_MILLED);
        Platinum.addFlags(GENERATE_MILLED);
        Pyrope.addFlags(GENERATE_MILLED);
        Redstone.addFlags(GENERATE_MILLED);
        Spessartine.addFlags(GENERATE_MILLED);
        Sphalerite.addFlags(GENERATE_MILLED);
        Pentlandite.addFlags(GENERATE_MILLED);

        //  Plate
        Dubnium.addFlags(GENERATE_PLATE);
        Livermorium.addFlags(GENERATE_PLATE);
        Rhenium.addFlags(GENERATE_PLATE);
        RTMAlloy.addFlags(GENERATE_PLATE);

        //  Double Plate
        HastelloyX.addFlags(GENERATE_DOUBLE_PLATE);
        Dubnium.addFlags(GENERATE_DOUBLE_PLATE);
        Livermorium.addFlags(GENERATE_DOUBLE_PLATE);
        Rhenium.addFlags(GENERATE_DOUBLE_PLATE);
        IncoloyMA956.addFlags(GENERATE_DOUBLE_PLATE);

        //  Dense
        Steel.addFlags(GENERATE_DENSE);

        //  Foil
        Nickel.addFlags(GENERATE_FOIL);
        Germanium.addFlags(GENERATE_FOIL);

        //  Frame
        Polybenzimidazole.addFlags(GENERATE_FRAME);
        Naquadria.addFlags(GENERATE_FRAME);
        RhodiumPlatedPalladium.addFlags(GENERATE_FRAME);
        Darmstadtium.addFlags(GENERATE_FRAME);
        Naquadah.addFlags(GENERATE_FRAME);
        NaquadahEnriched.addFlags(GENERATE_FRAME);
        Osmiridium.addFlags(GENERATE_FRAME);

        //  Stick
        Dubnium.addFlags(GENERATE_ROD);

        //  Long Stick
        IronMagnetic.addFlags(GENERATE_LONG_ROD);

        //  Spring
        Trinium.addFlags(GENERATE_SPRING);
        Tritanium.addFlags(GENERATE_SPRING);
        RutheniumTriniumAmericiumNeutronate.addFlags(GENERATE_SPRING);

        //  Gear
        RhodiumPlatedPalladium.addFlags(GENERATE_GEAR);
        Darmstadtium.addFlags(GENERATE_GEAR);

        //  Small Gear
        WroughtIron.addFlags(GENERATE_SMALL_GEAR);

        //  Bolt & Screw
        Dubnium.addFlags(GENERATE_BOLT_SCREW);

        //  Rotor
        WroughtIron.addFlags(GENERATE_ROTOR);

        //  Wire Fine
        Seaborgium.addFlags(GENERATE_FINE_WIRE);
        Kanthal.addFlags(GENERATE_FINE_WIRE);

        //  Crystallization
        Monazite.addFlags(DISABLE_CRYSTALLIZATION);
        Sapphire.addFlags(CRYSTALLIZABLE);
        Ruby.addFlags(CRYSTALLIZABLE);
        Emerald.addFlags(CRYSTALLIZABLE);
        Olivine.addFlags(CRYSTALLIZABLE);
        Amethyst.addFlags(CRYSTALLIZABLE);
        Opal.addFlags(CRYSTALLIZABLE);
        //NetherStar.addFlags(CRYSTALLIZABLE); // TODO Another Nether Star recipe, may be set components

        //  Conflict Solutions
        RockSalt.addFlags(DISABLE_DECOMPOSITION); // Conflict between Potassium Hydroxide and Rock Salt Electrolysis
        Salt.addFlags(DISABLE_DECOMPOSITION); // Conflict between Sodium Chlorate and Salt Electrolysis

        //  Cable Properties
        WireProperties wireProp = RutheniumTriniumAmericiumNeutronate.getProperty(PropertyKey.WIRE);
        wireProp.setSuperconductor(false);
        wireProp.setLossPerBlock(32);
        wireProp.setVoltage((int) V[UIV]);

        if (GTLiteConfigHolder.chainOverrides.enableMolybdenumProcessing) {
            Molybdenite.addFlags(DISABLE_DECOMPOSITION);
            OreProperty oreProp = Molybdenite.getProperty(PropertyKey.ORE);
            oreProp.setDirectSmeltResult(null);
            Powellite.addFlags(DISABLE_DECOMPOSITION);
            Wulfenite.addFlags(DISABLE_DECOMPOSITION);
        }

        if (GTLiteConfigHolder.chainOverrides.enableNiobiumTantalumProcessing) {
            Pyrochlore.addFlags(DISABLE_DECOMPOSITION);
            Tantalite.addFlags(DISABLE_DECOMPOSITION);
        }
    }
}
