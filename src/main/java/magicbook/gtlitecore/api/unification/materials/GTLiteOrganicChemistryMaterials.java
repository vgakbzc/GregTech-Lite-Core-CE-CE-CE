package magicbook.gtlitecore.api.unification.materials;

import gregtech.api.fluids.FluidBuilder;
import gregtech.api.fluids.attribute.FluidAttributes;
import gregtech.api.unification.material.Material;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.util.GTUtility.*;
import static gregtechfoodoption.GTFOMaterialHandler.AceticAnhydride;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class GTLiteOrganicChemistryMaterials {

    //  Range: 13001-15000
    private static int startId = 13001;
    private static final int endId = startId + 1999;

    public static void register() {
        //  13001 Kapton-K
        KaptonK = new Material.Builder(getId(), gregtechId("kapton_k"))
                .polymer()
                .liquid()
                .color(16764498)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE, GENERATE_FOIL)
                .components(Carbon, 12, Hydrogen, 12, Nitrogen, 2, Oxygen, 1)
                .build()
                .setFormula("(C7H2N2O4)(O(C6H4)2)", true);

        //  13002 Kapton-E
        KaptonE = new Material.Builder(getId(), gregtechId("kapton_e"))
                .polymer()
                .liquid()
                .color(16768908)
                .flags(DISABLE_DECOMPOSITION, GENERATE_PLATE, NO_SMASHING, NO_SMELTING, GENERATE_FOIL)
                .components(Carbon, 12, Hydrogen, 12, Nitrogen, 2, Oxygen, 1)
                .build()
                .setFormula("O(C6H4NH2)2", true);

        //  13003 Polyetherketone
        Polyetheretherketone = new Material.Builder(getId(), gregtechId("polyetheretherketone"))
                .polymer()
                .liquid()
                .color(0x45433D)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE)
                .components(Carbon, 20, Hydrogen, 12, Oxygen, 3)
                .build();

        //  13004 Kevlar
        Kevlar = new Material.Builder(getId(), gregtechId("kevlar"))
                .polymer()
                .liquid()
                .color(0xF0F078)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE)
                .components(Carbon, 14, Hydrogen, 10, Nitrogen, 2, Oxygen, 2)
                .build()
                .setFormula("(C6H4)2(CO)2(NH)2", true);

        //  13005 Zylon
        Zylon = new Material.Builder(getId(), gregtechId("zylon"))
                .polymer()
                .liquid()
                .color(0xFFE000)
                .iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE, GENERATE_FOIL)
                .components(Carbon, 14, Hydrogen, 6, Nitrogen, 2, Oxygen, 2)
                .build();

        //  13006 Fullerene Polymer Matrix
        FullerenePolymerMatrix = new Material.Builder(getId(), gregtechId("fullerene_polymer_matrix"))
                .polymer()
                .liquid(new FluidBuilder().temperature(500))
                .color(0x2F0B01)
                .iconSet(SHINY)
                .components(Lead, 1, Iron, 1, Carbon, 153, Hydrogen, 36, Nitrogen, 1, Oxygen, 2)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE, GENERATE_FOIL)
                .build();

        //  13007 Cosmic Fabric
        CosmicFabric = new Material.Builder(getId(), gregtechId("cosmic_fabric"))
                .polymer()
                .liquid(new FluidBuilder().temperature(83654))
                .plasma()
                .color(0x9E19CF)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE, GENERATE_FOIL)
                .build();

        //  13008 Methyl Formate
        MethylFormate = new Material.Builder(getId(), gregtechId("methyl_formate"))
                .liquid()
                .color(0xFFAAAA)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 4, Carbon, 2, Oxygen, 2)
                .build()
                .setFormula("HCO2CH3", true);

        //  13009 Formic Acid
        FormicAcid = new Material.Builder(getId(), gregtechId("formic_acid"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xFFAA77)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 2, Carbon, 1, Oxygen, 2)
                .build()
                .setFormula("HCOOH", true);

        //  13010 Ethylhexanol
        Ethylhexanol = new Material.Builder(getId(), gregtechId("ethylhexanol"))
                .liquid()
                .color(0xFEEA9A)
                .components(Carbon, 8, Hydrogen, 10, Oxygen, 1)
                .build();

        //  13011 Diethylhexyl Phosphoric Acid
        DiethylhexylPhosphoricAcid = new Material.Builder(getId(), gregtechId("diethylhexyl_phosphoric_acid"))
                .liquid()
                .color(0xFFFF99)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 16, Hydrogen, 35, Oxygen, 4, Phosphorus, 1)
                .build()
                .setFormula("(C8H7O)2PO2H", true);

        //  13012 Acetone Cyanohydrin
        AcetoneCyanohydrin = new Material.Builder(getId(), gregtechId("acetone_cyanohydrin"))
                .liquid()
                .color(0xA1FFD0)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 4, Hydrogen, 7, Nitrogen, 1, Oxygen, 1)
                .build();

        //  13013 PMMA
        PMMA = new Material.Builder(getId(), gregtechId("polymethylmethacrylate"))
                .polymer()
                .liquid()
                .color(9554657)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE)
                .components(Carbon, 5, Hydrogen, 8, Oxygen, 2)
                .build();

        //  13014 Dimethyl Carbonate
        DimethylCarbonate = new Material.Builder(getId(), gregtechId("dimethyl_carbonate"))
                .liquid()
                .color(0xC5EB9E)
                .components(Carbon, 3, Hydrogen, 6, Oxygen, 3)
                .build()
                .setFormula("(CH3O)2CO", true);

        //  13015 Diphenyl Carbonate
        DiphenylCarbonate = new Material.Builder(getId(), gregtechId("diphenyl_carbonate"))
                .liquid()
                .color(DimethylCarbonate.getMaterialRGB() + Benzene.getMaterialRGB())
                .components(Carbon, 13, Hydrogen, 10, Oxygen, 3)
                .build();

        //  13016 BPA Polycarbonate
        BPAPolycarbonate = new Material.Builder(getId(), gregtechId("bpa_polycarbonate"))
                .polymer()
                .liquid()
                .color(0xE3EBDA)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE)
                .components(Carbon, 16, Hydrogen, 14, Oxygen, 3)
                .build();

        //  13017 Propadiene
        Propadiene = new Material.Builder(getId(), gregtechId("propadiene"))
                .liquid()
                .color(0xBD8F61)
                .components(Carbon, 3, Hydrogen, 4)
                .build();

        //  13018 Isobutyric Acid
        IsobutyricAcid = new Material.Builder(getId(), gregtechId("isobutyric_acid"))
                .liquid()
                .color(Propene.getMaterialRGB() + Propadiene.getMaterialRGB())
                .components(Carbon, 4, Hydrogen, 8, Oxygen, 2)
                .build();

        //  13019 Isobutyric Anhydride
        IsobutyricAnhydride = new Material.Builder(getId(), gregtechId("isobutyric_anhydride"))
                .liquid()
                .color(IsobutyricAcid.getMaterialRGB() - AceticAnhydride.getMaterialRGB())
                .components(Carbon, 8, Hydrogen, 14, Oxygen, 3)
                .build();

        //  13020 Dimethylketene
        Dimethylketene = new Material.Builder(getId(), gregtechId("dimethylketene"))
                .liquid()
                .color(0x0925BE)
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 2)
                .build();

        //  13021 Tetramethylcyclobutanediol
        Tetramethylcyclobutanediol = new Material.Builder(getId(), gregtechId("tetramethylcyclobutanediol"))
                .liquid()
                .color(Dimethylketene.getMaterialRGB() + Hydrogen.getMaterialRGB())
                .components(Carbon, 8, Hydrogen, 16, Oxygen, 2)
                .build();

        //  13022 CBDO Polycarbonate
        CBDOPolycarbonate = new Material.Builder(getId(), gregtechId("cbdo_polycarbonate"))
                .polymer()
                .liquid()
                .color(0xDFDFDF)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE)
                .components(Carbon, 9, Hydrogen, 14, Oxygen, 3)
                .build();

        //  13023 Butanediol
        Butanediol = new Material.Builder(getId(), gregtechId("butanediol"))
                .liquid()
                .color(0xAAC4DA)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 2)
                .build()
                .setFormula("C4H8(OH)2", true);

        //  13024 Diacetyl
        Diacetyl = new Material.Builder(getId(),  gregtechId("diacetyl"))
                .liquid()
                .color(0xF7FF65)
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 2)
                .build();

        //  13025 Ethylene Glycol
        EthyleneGlycol = new Material.Builder(getId(), gregtechId("ethylene_glycol"))
                .liquid()
                .color(0x286632)
                .components(Carbon, 2, Hydrogen, 6, Oxygen, 2)
                .build()
                .setFormula("C2H4(OH)2", true);

        //  13026 EDOT
        Edot = new Material.Builder(getId(), gregtechId("edot"))
                .liquid()
                .color(11665367)
                .components(Carbon, 6, Hydrogen, 6, Oxygen, 2, Sulfur, 1)
                .build();

        //  13027 Polystyrene
        Polystyrene = new Material.Builder(getId(), gregtechId("polystyrene"))
                .fluid()
                .color(14795458)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 8, Hydrogen, 8)
                .build();

        //  13028 Polystyrene Sulfonate
        PolystyreneSulfonate = new Material.Builder(getId(), gregtechId("polystyrene_sulfonate"))
                .polymer()
                .liquid()
                .color(14777458)
                .flags(DISABLE_DECOMPOSITION, GENERATE_PLATE)
                .components(Carbon, 8, Hydrogen, 8, Sulfur, 1, Oxygen, 3)
                .build();

        //  13029 PEDOT:PSS
        PedotPSS = new Material.Builder(getId(), gregtechId("pedot_pss"))
                .polymer()
                .liquid()
                .color(14771623)
                .flags(DISABLE_DECOMPOSITION, GENERATE_FINE_WIRE)
                .components(Edot, 1, PolystyreneSulfonate, 1)
                .cableProperties(V[UHV], 24, 0, true)
                .build();

        //  13030 PEDOT-TMA
        PedotTMA = new Material.Builder(getId(), gregtechId("pedot_tma"))
                .polymer()
                .liquid()
                .color(0x5E9EE1)
                .flags(DISABLE_DECOMPOSITION, GENERATE_ROD, GENERATE_SPRING)
                .components(Edot, 1, PMMA, 2)
                .cableProperties(V[UEV], 8, 6, false)
                .build();
    }

    private static int getId() {
        if (startId < endId) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
