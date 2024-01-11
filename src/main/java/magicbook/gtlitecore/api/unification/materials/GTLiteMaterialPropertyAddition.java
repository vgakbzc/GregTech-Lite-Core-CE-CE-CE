package magicbook.gtlitecore.api.unification.materials;

import gregtech.api.unification.material.properties.*;
import magicbook.gtlitecore.common.GTLiteConfigHolder;

import static gregicality.multiblocks.api.unification.GCYMMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
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
        Californium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Californium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Curium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Curium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Radium.setProperty(PropertyKey.DUST, new DustProperty());
        Radium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Neptunium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Neptunium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Bohrium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Bohrium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Sodium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Meitnerium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Meitnerium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Roentgenium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Roentgenium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Copernicium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Copernicium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Nihonium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Nihonium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Moscovium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Moscovium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Tennessine.setProperty(PropertyKey.FLUID, new FluidProperty());
        Francium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Francium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Technetium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Technetium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Protactinium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Protactinium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Berkelium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Berkelium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Einsteinium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Einsteinium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Fermium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Fermium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Mendelevium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Mendelevium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Nobelium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Nobelium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Lawrencium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Lawrencium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Boron.setProperty(PropertyKey.FLUID, new FluidProperty());

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
        Einsteinium.addFlags(GENERATE_PLATE);
        Fermium.addFlags(GENERATE_PLATE);
        Mendelevium.addFlags(GENERATE_PLATE);
        Berkelium.addFlags(GENERATE_PLATE);
        Protactinium.addFlags(GENERATE_PLATE);
        Curium.addFlags(GENERATE_PLATE);
        Plutonium239.addFlags(GENERATE_PLATE);
        Californium.addFlags(GENERATE_PLATE);
        Neptunium.addFlags(GENERATE_PLATE);
        Nobelium.addFlags(GENERATE_PLATE);
        Lawrencium.addFlags(GENERATE_PLATE);
        Technetium.addFlags(GENERATE_PLATE);

        //  Double Plate
        HastelloyX.addFlags(GENERATE_DOUBLE_PLATE);
        Dubnium.addFlags(GENERATE_DOUBLE_PLATE);
        Livermorium.addFlags(GENERATE_DOUBLE_PLATE);
        Rhenium.addFlags(GENERATE_DOUBLE_PLATE);
        IncoloyMA956.addFlags(GENERATE_DOUBLE_PLATE);
        Tritanium.addFlags(GENERATE_DOUBLE_PLATE);
        HSSS.addFlags(GENERATE_DOUBLE_PLATE);
        RedSteel.addFlags(GENERATE_DOUBLE_PLATE);
        TitaniumCarbide.addFlags(GENERATE_DOUBLE_PLATE);
        Plutonium239.addFlags(GENERATE_DOUBLE_PLATE);

        //  Dense
        Steel.addFlags(GENERATE_DENSE);
        Rhenium.addFlags(GENERATE_DENSE);

        //  Foil
        Nickel.addFlags(GENERATE_FOIL);
        Germanium.addFlags(GENERATE_FOIL);
        Rhenium.addFlags(GENERATE_FOIL);

        //  Frame
        Polybenzimidazole.addFlags(GENERATE_FRAME);
        Naquadria.addFlags(GENERATE_FRAME);
        RhodiumPlatedPalladium.addFlags(GENERATE_FRAME);
        Darmstadtium.addFlags(GENERATE_FRAME);
        Naquadah.addFlags(GENERATE_FRAME);
        NaquadahEnriched.addFlags(GENERATE_FRAME);
        Osmiridium.addFlags(GENERATE_FRAME);
        Americium.addFlags(GENERATE_FRAME);
        Uranium238.addFlags(GENERATE_FRAME);
        Plutonium241.addFlags(GENERATE_FRAME);
        VanadiumSteel.addFlags(GENERATE_FRAME);
        RedSteel.addFlags(GENERATE_FRAME);
        CobaltBrass.addFlags(GENERATE_FRAME);
        Einsteinium.addFlags(GENERATE_FRAME);
        Fermium.addFlags(GENERATE_FRAME);
        Mendelevium.addFlags(GENERATE_FRAME);
        Protactinium.addFlags(GENERATE_FRAME);
        Trinium.addFlags(GENERATE_FRAME);
        Curium.addFlags(GENERATE_FRAME);
        Berkelium.addFlags(GENERATE_FRAME);
        Californium.addFlags(GENERATE_FRAME);
        Neptunium.addFlags(GENERATE_FRAME);
        Nobelium.addFlags(GENERATE_FRAME);
        Lawrencium.addFlags(GENERATE_FRAME);
        NiobiumNitride.addFlags(GENERATE_FRAME);

        //  Stick
        Dubnium.addFlags(GENERATE_ROD);
        Livermorium.addFlags(GENERATE_ROD);
        Graphene.addFlags(GENERATE_ROD);
        Einsteinium.addFlags(GENERATE_ROD);
        Fermium.addFlags(GENERATE_ROD);
        Mendelevium.addFlags(GENERATE_ROD);
        Berkelium.addFlags(GENERATE_ROD);
        Protactinium.addFlags(GENERATE_ROD);
        Curium.addFlags(GENERATE_ROD);
        Californium.addFlags(GENERATE_ROD);
        Neptunium.addFlags(GENERATE_ROD);
        Nobelium.addFlags(GENERATE_ROD);
        Lawrencium.addFlags(GENERATE_ROD);

        //  Long Stick
        IronMagnetic.addFlags(GENERATE_LONG_ROD);
        WroughtIron.addFlags(GENERATE_LONG_ROD);
        SteelMagnetic.addFlags(GENERATE_LONG_ROD);
        NeodymiumMagnetic.addFlags(GENERATE_LONG_ROD);
        Chrome.addFlags(GENERATE_LONG_ROD);

        //  Spring
        Trinium.addFlags(GENERATE_SPRING);
        Tritanium.addFlags(GENERATE_SPRING);
        RutheniumTriniumAmericiumNeutronate.addFlags(GENERATE_SPRING);

        //  Small Spring
        Europium.addFlags(GENERATE_SPRING_SMALL);

        //  Gear
        RhodiumPlatedPalladium.addFlags(GENERATE_GEAR);
        Darmstadtium.addFlags(GENERATE_GEAR);

        //  Small Gear
        WroughtIron.addFlags(GENERATE_SMALL_GEAR);

        //  Bolt & Screw
        Dubnium.addFlags(GENERATE_BOLT_SCREW);
        Livermorium.addFlags(GENERATE_BOLT_SCREW);

        //  Rotor
        WroughtIron.addFlags(GENERATE_ROTOR);
        Berkelium.addFlags(GENERATE_ROTOR);

        //  Wire Fine
        Seaborgium.addFlags(GENERATE_FINE_WIRE);
        Kanthal.addFlags(GENERATE_FINE_WIRE);
        Nichrome.addFlags(GENERATE_FINE_WIRE);
        VanadiumGallium.addFlags(GENERATE_FINE_WIRE);
        Titanium.addFlags(GENERATE_FINE_WIRE);
        RutheniumTriniumAmericiumNeutronate.addFlags(GENERATE_FINE_WIRE);
        Graphene.addFlags(GENERATE_FINE_WIRE);
        Neodymium.addFlags(GENERATE_FINE_WIRE);
        Dubnium.addFlags(GENERATE_FINE_WIRE);
        NaquadahEnriched.addFlags(GENERATE_FINE_WIRE);
        Rhenium.addFlags(GENERATE_FINE_WIRE);

        //  Crystallization
        Monazite.addFlags(DISABLE_CRYSTALLIZATION);
        Sapphire.addFlags(CRYSTALLIZABLE);
        Ruby.addFlags(CRYSTALLIZABLE);
        Emerald.addFlags(CRYSTALLIZABLE);
        Olivine.addFlags(CRYSTALLIZABLE);
        Amethyst.addFlags(CRYSTALLIZABLE);
        Opal.addFlags(CRYSTALLIZABLE);
        //NetherStar.addFlags(CRYSTALLIZABLE); // TODO Another Nether Star recipe, may be set components

        //  Nano Swarm
        Iron.addFlags(GENERATE_NANOTUBE, GENERATE_NANOSENSOR, GENERATE_SWARM); // W.I.P
        IronMagnetic.addFlags(GENERATE_NANOTUBE, GENERATE_NANOSENSOR, GENERATE_SWARM); // W.I.P
        Copper.addFlags(GENERATE_NANOTUBE, GENERATE_NANOSENSOR, GENERATE_SWARM); // W.I.P
        Nickel.addFlags(GENERATE_NANOTUBE, GENERATE_NANOSENSOR, GENERATE_SWARM); // W.I.P
        Cobalt.addFlags(GENERATE_NANOTUBE, GENERATE_NANOSENSOR, GENERATE_SWARM); // W.I.P
        Lead.addFlags(GENERATE_NANOTUBE, GENERATE_NANOSENSOR, GENERATE_SWARM); // W.I.P
        Redstone.addFlags(GENERATE_NANOTUBE, GENERATE_NANOSENSOR, GENERATE_SWARM); // W.I.P

        RedAlloy.addFlags(GENERATE_NANOTUBE, GENERATE_NANOSENSOR, GENERATE_SWARM); // W.I.P

        Carbon.addFlags(GENERATE_NANOTUBE, GENERATE_NANOSENSOR, GENERATE_SWARM); // For Quantum Force Transformer Plastic recipe
        CarbonNanotube.addFlags(GENERATE_NANOTUBE, GENERATE_NANOSENSOR, GENERATE_SWARM); // For Quantum Force Transformer Plastic recipe

        Graphene.addFlags(GENERATE_NANOTUBE, GENERATE_NANOSENSOR, GENERATE_SWARM); // For Quantum Force Transformer Rubber recipe
        Fullerene.addFlags(GENERATE_NANOTUBE, GENERATE_NANOSENSOR, GENERATE_SWARM); // For Quantum Force Transformer Rubber recipe

        Platinum.addFlags(GENERATE_NANOTUBE, GENERATE_NANOSENSOR, GENERATE_SWARM); // For Quantum Force Transformer Platinum group recipe

        Europium.addFlags(GENERATE_NANOTUBE, GENERATE_NANOSENSOR, GENERATE_SWARM); // For Quantum Force Transformer Thorium-Uranium group recipe

        Titanium.addFlags(GENERATE_NANOTUBE, GENERATE_NANOSENSOR, GENERATE_SWARM); // For Quantum Force Transformer Titanium-Tungsten-Indium recipe
        Tungsten.addFlags(GENERATE_NANOTUBE, GENERATE_NANOSENSOR, GENERATE_SWARM); // For Quantum Force Transformer Titanium-Tungsten-Indium recipe

        Neodymium.addFlags(GENERATE_NANOTUBE, GENERATE_NANOSENSOR, GENERATE_SWARM); // For Quantum Force Transformer Rare earth recipe
        Americium.addFlags(GENERATE_NANOTUBE, GENERATE_NANOSENSOR, GENERATE_SWARM); // For Quantum Force Transformer Rare earth recipe
        Dubnium.addFlags(GENERATE_NANOTUBE, GENERATE_NANOSENSOR, GENERATE_SWARM); // For Quantum Force Transformer Rare earth recipe

        Naquadah.addFlags(GENERATE_NANOTUBE, GENERATE_NANOSENSOR, GENERATE_SWARM); // For Quantum Force Transformer Naquadah group recipe
        NaquadahEnriched.addFlags(GENERATE_NANOTUBE, GENERATE_NANOSENSOR, GENERATE_SWARM); // For Quantum Force Transformer Naquadah group recipe

        Naquadria.addFlags(GENERATE_NANOTUBE, GENERATE_NANOSENSOR, GENERATE_SWARM); // For Quantum Force Transformer Biological recipe

        Tin.addFlags(GENERATE_NANOTUBE, GENERATE_NANOSENSOR, GENERATE_SWARM); // For Quantum Force Transformer Adhesive recipe

        Tritanium.addFlags(GENERATE_NANOTUBE, GENERATE_NANOSENSOR, GENERATE_SWARM); // For Quantum Force Transformer Higgs Bosons recipe

        Orichalcum.addFlags(GENERATE_NANOTUBE, GENERATE_NANOSENSOR, GENERATE_SWARM); // For Quantum Force Transformer Instanton recipe

        Silver.addFlags(GENERATE_NANOTUBE, GENERATE_NANOSENSOR, GENERATE_SWARM); // For PCB factory Etching recipes
        Gold.addFlags(GENERATE_NANOTUBE, GENERATE_NANOSENSOR, GENERATE_SWARM); // For PCB factory Etching recipes

        Eternity.addFlags(GENERATE_SWARM); // For end game

        //  Singularity
        Iron.addFlags(GENERATE_SINGULARITY); // W.I.P
        Gold.addFlags(GENERATE_SINGULARITY);
        Infinity.addFlags(GENERATE_SINGULARITY); // For end game
        Eternity.addFlags(GENERATE_SINGULARITY); // For end game

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
