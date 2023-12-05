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
                .fluidPipeProperties(2000, 700, true)
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

        //  13031 Para Xylene
        ParaXylene = new Material.Builder(getId(), gregtechId("para_xylene"))
                .liquid()
                .color(0x666040)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 8, Hydrogen, 10)
                .build()
                .setFormula("C6H4(CH3)2", true);

        //  13032 Durene
        Durene = new Material.Builder(getId(), gregtechId("durene"))
                .dust()
                .color(0x336040)
                .iconSet(FINE)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 14)
                .build()
                .setFormula("C6H2(CH3)4", true);

        //  13033 Pyromellitic Dianhydride
        PyromelliticDianhydride = new Material.Builder(getId(), gregtechId("pyromellitic_dianhydride"))
                .dust()
                .color(0xF0EAD6)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 2, Oxygen, 6)
                .build()
                .setFormula("C6H2(C2O3)2", true);

        //  13034 Oxydianiline
        Oxydianiline = new Material.Builder(getId(), gregtechId("oxydianiline"))
                .dust()
                .color(0xF0E130)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 12, Hydrogen, 12, Nitrogen, 2, Oxygen, 1)
                .build()
                .setFormula("O(C6H4NH2)2", true);

        //  13035 Dimethylformamide
        Dimethylformamide = new Material.Builder(getId(), gregtechId("dimethylformamide"))
                .liquid()
                .color(0x42BDFF)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 3, Hydrogen, 7, Nitrogen, 1, Oxygen, 1)
                .build()
                .setFormula("(CH3)2NC(O)H", true);

        //  13036 Phthalic Anhydride
        PhthalicAnhydride = new Material.Builder(getId(), gregtechId("phthalic_anhydride"))
                .dust()
                .color(0xEEAAEE)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 8, Hydrogen, 4, Oxygen, 3)
                .build()
                .setFormula("C6H4(CO)2O", true);

        //  13037 Biphenyl Tetracarboxylic Acid Dianhydride
        BiphenylTetracarboxylicAcidDianhydride = new Material.Builder(getId(), gregtechId("biphenyl_tetracarboxylic_acid_dianhydride"))
                .dust()
                .color(0xFF7F50)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 16, Hydrogen, 6, Oxygen, 6)
                .build()
                .setFormula("(C8H3O3)2", true);

        //  13038 Nitroaniline
        Nitroaniline = new Material.Builder(getId(), gregtechId("nitroaniline"))
                .liquid()
                .color(0x2A6E68)
                .components(Carbon, 6, Hydrogen, 6, Nitrogen, 2, Oxygen, 2)
                .build()
                .setFormula("H2NC6H4NO2", true);

        //  13039 Para Phenylenediamine
        ParaPhenylenediamine = new Material.Builder(getId(), gregtechId("para_phenylenediamine"))
                .dust()
                .color(0x4A8E7B)
                .iconSet(ROUGH)
                .components(Carbon, 6, Hydrogen, 8, Nitrogen, 2)
                .build()
                .setFormula("H2NC6H4NH2", true);

        //  13040 Bistrichloromethylbenzene
        Bistrichloromethylbenzene = new Material.Builder(getId(), gregtechId("bistrichloromethylbenzene"))
                .liquid()
                .color(0xCF8498)
                .components(Carbon, 8, Hydrogen, 4, Chlorine, 6)
                .build()
                .setFormula("C6H4(CCl3)2", true);

        //  13041 Acetylene
        Acetylene = new Material.Builder(getId(), gregtechId("acetylene"))
                .liquid()
                .color(0x959C60)
                .components(Carbon, 2, Hydrogen, 2)
                .build();

        //  13042 Tetrabromoethane
        Tetrabromoethane = new Material.Builder(getId(), gregtechId("tetrabromoethane"))
                .liquid()
                .color(0x5AAADA)
                .components(Carbon, 2, Hydrogen, 2, Bromine, 4)
                .build();

        //  13043 Terephthalic Acid
        TerephthalicAcid = new Material.Builder(getId(), gregtechId("terephthalic_acid"))
                .dust()
                .color(0x5ACCDA)
                .iconSet(ROUGH)
                .components(Carbon, 8, Hydrogen, 6, Oxygen, 4)
                .build()
                .setFormula("C6H4(CO2H)2", true);

        //  13044 Terephthaloyl Chloride
        TerephthaloylChloride = new Material.Builder(getId(), gregtechId("terephthaloyl_chloride"))
                .dust()
                .color(0xFAC4DA)
                .iconSet(SHINY)
                .components(Carbon, 8, Hydrogen, 4, Oxygen, 2, Chlorine, 2)
                .build()
                .setFormula("C6H4(COCl)2", true);

        //  13045 γ-Butyrolactone
        GammaButyrolactone = new Material.Builder(getId(), gregtechId("gamma_butyrolactone"))
                .liquid()
                .color(0xAF04D6)
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 2)
                .build();

        //  13046 Methylamine
        Methylamine = new Material.Builder(getId(), gregtechId("methylamine"))
                .gas()
                .color(0xAA6600)
                .components(Carbon, 1, Hydrogen, 5, Nitrogen, 1)
                .build()
                .setFormula("CH3NH2", true);

        //  13047 N-Methyl Pyrrolidone
        NMethylPyrrolidone = new Material.Builder(getId(), gregtechId("n_methyl_pyrrolidone"))
                .liquid()
                .color(0xA504D6)
                .components(Carbon, 5, Hydrogen, 9, Nitrogen, 1, Oxygen, 1)
                .build();

        //  13048 Dichloroethane
        Dichloroethane = new Material.Builder(getId(), gregtechId("dichloroethane"))
                .liquid()
                .color(0xDAAED3)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 2, Hydrogen, 4, Chlorine, 2)
                .build();

        //  13049 Trichloroethylene
        Trichloroethylene = new Material.Builder(getId(), gregtechId("trichloroethylene"))
                .liquid()
                .color(0xB685B1)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 2, Hydrogen, 1, Chlorine, 3)
                .build();

        //  13050 Chloroacetic Acid
        ChloroaceticAcid = new Material.Builder(getId(), gregtechId("chloroacetic_acid"))
                .dust()
                .color(0x38541A)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(SHINY)
                .components(Carbon, 2, Hydrogen, 3, Chlorine, 1, Oxygen, 2)
                .build();

        //  13051 Malonic Acid
        MalonicAcid = new Material.Builder(getId(), gregtechId("malonic_acid"))
                .dust()
                .color(0x61932E)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(SHINY)
                .components(Carbon, 3, Hydrogen, 4, Oxygen, 4)
                .build();

        //  13052 Dimethylamine Hydrochloride
        DimethylamineHydrochloride = new Material.Builder(getId(), gregtechId("dimethylamine_hydrochloride"))
                .liquid()
                .color(0xE3EBDC)
                .components(Dimethylamine, 1, HydrochloricAcid, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("C2H8NCl", true);

        //  13053 Ethylenediamine
        Ethylenediamine = new Material.Builder(getId(), gregtechId("ethylenediamine"))
                .liquid()
                .color(0xD00ED0)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 2, Hydrogen, 8, Nitrogen, 2)
                .build()
                .setFormula("C2H4(NH2)2", true);

        //  13054 Formaldehyde
        Formaldehyde = new Material.Builder(getId(), gregtechId("formaldehyde"))
                .liquid()
                .color(0x858F40)
                .components(Carbon, 1, Hydrogen, 2, Oxygen, 1)
                .build();

        //  13055 Tetrasodium EDTA
        TetrasodiumEDTA = new Material.Builder(getId(), gregtechId("tetrasodium_edta"))
                .dust()
                .color(0x8890E0)
                .iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 12, Nitrogen, 2, Oxygen, 8, Sodium, 4)
                .build();

        //  13056 Ethylenediaminetetraacetic Acid
        EthylenediaminetetraaceticAcid = new Material.Builder(getId(), gregtechId("ethylenediaminetetraacetic_acid"))
                .dust()
                .liquid()
                .color(0x87E6D9)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 16, Nitrogen, 2, Oxygen, 8)
                .build();

        //  13057 Trimethylamine
        Trimethylamine = new Material.Builder(getId(), gregtechId("trimethylamine"))
                .gas()
                .color(0xBB7700)
                .components(Carbon, 3, Hydrogen, 9, Nitrogen, 1)
                .build()
                .setFormula("(CH3)3N", true);

        //  13058 Tetramethylammonium Chloride
        TetramethylammoniumChloride = new Material.Builder(getId(), gregtechId("tetramethylammonium_chloride"))
                .dust()
                .color(0x27FF81)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(METALLIC)
                .components(Carbon, 4, Hydrogen, 12, Nitrogen, 1, Chlorine, 1)
                .build()
                .setFormula("N(CH3)4Cl", true);

        //  13059 Tetramethylammonium Hydroxide
        TetramethylammoniumHydroxide = new Material.Builder(getId(), gregtechId("tetramethylammonium_hydroxide"))
                .liquid()
                .color(4259798)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 1, Carbon, 4, Hydrogen, 12, Oxygen, 1, Hydrogen, 1)
                .build()
                .setFormula("N(CH3)4OH", true);

        //  13060 Hydrogen Peroxide
        HydrogenPeroxide = new Material.Builder(getId(), gregtechId("hydrogen_peroxide"))
                .liquid()
                .color(0xD2FFFF)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 2, Oxygen, 2)
                .build();

        //  13061 Pyrocatechol
        Pyrocatechol = new Material.Builder(getId(), gregtechId("pyrocatechol"))
                .dust()
                .color(0x784421)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(DULL)
                .components(Carbon, 6, Hydrogen, 6, Oxygen, 2)
                .build();

        //  13062 Ethylene Oxide
        EthyleneOxide = new Material.Builder(getId(), gregtechId("ethylene_oxide"))
                .gas()
                .color(0xDCBFE1)
                .components(Carbon, 2, Hydrogen, 4, Oxygen, 1)
                .build();

        //  13063 Indene
        Indene = new Material.Builder(getId(), gregtechId("indene"))
                .liquid()
                .color(0x171429)
                .components(Carbon, 9, Hydrogen, 8)
                .build();

        //  13064 Indanone
        Indanone = new Material.Builder(getId(), gregtechId("indanone"))
                .dust()
                .color(0x2E1616)
                .iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 9, Hydrogen, 8, Oxygen, 1)
                .build();

        //  13065 Truxene
        Truxene = new Material.Builder(getId(), gregtechId("truxene"))
                .liquid()
                .color(0x1A3336)
                .components(Carbon, 27, Hydrogen, 18)
                .build();

        //  13066 Bromomethane
        Bromomethane = new Material.Builder(getId(), gregtechId("bromomethane"))
                .gas()
                .color(0xC82C31)
                .components(Carbon, 1, Hydrogen, 3, Bromine, 1)
                .build();

        //  13067 Bromo Bromomethyl Naphthalene
        BromoBromomethylNaphthalene = new Material.Builder(getId(), gregtechId("bromo_bromomethyl_naphthalene"))
                .liquid()
                .color(0x52122E)
                .components(Carbon, 11, Hydrogen, 8, Bromine, 2)
                .build();

        //  13068 Butanol
        Butanol = new Material.Builder(getId(), gregtechId("butanol"))
                .liquid()
                .color(0xC7AF2E)
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 1)
                .build()
                .setFormula("C4H9OH", true);

        //  13069 Bromobutane
        Bromobutane = new Material.Builder(getId(), gregtechId("bromobutane"))
                .gas()
                .color(0xE6E8A2)
                .components(Butene, 1, HydrobromicAcid, 1)
                .build()
                .setFormula("C4H9Br", true);

        //  13070 Butyllithium
        Butyllithium = new Material.Builder(getId(), gregtechId("butyllithium"))
                .liquid()
                .color(0xE683B6B)
                .components(Butene, 1, Hydrogen, 1, Lithium, 1)
                .build()
                .setFormula("C4H9Li", true);

        //  13071 Palladium Acetate
        PalladiumAcetate = new Material.Builder(getId(), gregtechId("palladium_acetate"))
                .dust()
                .color(0x693C2D)
                .iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Palladium, 1, AceticAcid, 2)
                .build()
                .setFormula("Pd(CH3COOH)2", true);

        //  13072 Geodesic Polyarene
        GeodesicPolyarene = new Material.Builder(getId(), gregtechId("geodesic_polyarene"))
                .dust()
                .color(0x9E81A8)
                .iconSet(METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 60, Hydrogen, 30)
                .build();

        //  13073 Hydrazine
        Hydrazine = new Material.Builder(getId(), gregtechId("hydrazine"))
                .liquid()
                .color(0xB50707)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 2, Hydrogen, 4)
                .build();

        //  13074 Ethylanthraquinone
        Ethylanthraquinone = new Material.Builder(getId(), gregtechId("ethylanthraquinone"))
                .liquid()
                .color(0xCC865A)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 16, Hydrogen, 12, Oxygen, 2)
                .build()
                .setFormula("C6H4(CO)2C6H3Et", true);

        //  13075 Ethylanthrahydroquinone
        Ethylanthrahydroquinone = new Material.Builder(getId(), gregtechId("ethylanthrahydroquinone"))
                .liquid()
                .color(0xAD531A)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 16, Hydrogen, 18, Oxygen, 2)
                .build()
                .setFormula("C6H4(CH2OH)2C6H3Et", true);

        //  13076 Cycloparaphenylene
        Cycloparaphenylene = new Material.Builder(getId(), gregtechId("cycloparaphenylene"))
                .liquid()
                .color(0x60545A)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 6, Hydrogen, 4)
                .build();

        //  13077 Cyclooctadiene
        Cyclooctadiene = new Material.Builder(getId(), gregtechId("cyclooctadiene"))
                .liquid()
                .color(0x40AC40)
                .components(Carbon, 8, Hydrogen, 12)
                .build();

        //  13078 Dichlorocyclooctadieneplatinium
        Dichlorocyclooctadieneplatinium = new Material.Builder(getId(), gregtechId("dichlorocyclooctadieneplatinium"))
                .dust()
                .color(0xD4E982)
                .iconSet(BRIGHT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 8, Hydrogen, 12, Chlorine, 2, Platinum, 1)
                .build();

        //  13079 Diiodobiphenyl
        Diiodobiphenyl = new Material.Builder(getId(), gregtechId("diiodobiphenyl"))
                .dust()
                .color(0x000C52)
                .iconSet(METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 12, Hydrogen, 8, Iodine, 2)
                .build();

        //  13080 Hydroxylamine Disulfate
        HydroxylamineDisulfate = new Material.Builder(getId(), gregtechId("hydroxylamine_disulfate"))
                .liquid()
                .color(0x91A6D2)
                .components(Nitrogen, 4, Hydrogen, 16, Oxygen, 10, Sulfur, 2)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("(NH3OH)2(NH4)2(SO4)2", true);

        //  13081 Hydroxylamine
        Hydroxylamine = new Material.Builder(getId(), gregtechId("hydroxylamine"))
                .liquid()
                .color(0x91C791)
                .components(Hydrogen, 3, Nitrogen, 1, Oxygen, 1)
                .build()
                .setFormula("H3NO", true);

        //  13082 Octene
        Octene = new Material.Builder(getId(), gregtechId("octene"))
                .liquid()
                .color(0x818022)
                .components(Carbon, 8, Hydrogen, 16)
                .build();

        //  13083 Methylhydrazine
        Methylhydrazine = new Material.Builder(getId(), gregtechId("methylhydrazine"))
                .liquid()
                .color(0x321452)
                .components(Carbon, 1, Hydrogen, 6, Nitrogen, 2)
                .build();

        //  13084 Hexafluoropropylene
        Hexafluoropropylene = new Material.Builder(getId(), gregtechId("hexafluoropropylene"))
                .liquid()
                .color(0x141D6F)
                .components(Carbon, 3, Fluorine, 6)
                .build();

        //  13085 Fluorinated Ethylene Propylene
        FluorinatedEthylenePropylene = new Material.Builder(getId(), gregtechId("fluorinated_ethylene_propylene"))
                .liquid() // TODO polymer?
                .color(0xC8C8C8)
                .iconSet(DULL)
                .components(Carbon, 5, Fluorine, 10)
                .build();

        //  13086 Nitrile Butadiene Rubber
        NitrileButadieneRubber = new Material.Builder(getId(), gregtechId("nitrile_butadiene_rubber"))
                .polymer()
                .liquid(new FluidBuilder().temperature(433))
                .color(0x211A18)
                .flags(DISABLE_DECOMPOSITION, GENERATE_PLATE, GENERATE_RING)
                .components(Carbon, 7, Hydrogen, 9, Nitrogen, 1)
                .build();

        //  13087 Poly (Phosphonitrile Fluoro) Rubber
        PolyPhosphonitrileFluoroRubber = new Material.Builder(getId(), gregtechId("poly_phosphonitrile_fluoro_rubber"))
                .polymer()
                .liquid()
                .color(0x372B28)
                .flags(DISABLE_DECOMPOSITION, GENERATE_PLATE, GENERATE_RING)
                .components(Carbon, 24, Hydrogen, 16, Oxygen, 8, Nitrogen, 4, Phosphorus, 4, Fluorine, 40)
                .build();

        //  13088 Acrylonitrile
        Acrylonitrile = new Material.Builder(getId(), gregtechId("acrylonitrile"))
                .liquid()
                .color(Propene.getMaterialRGB())
                .components(Carbon, 3, Hydrogen, 3, Nitrogen, 1)
                .build();

        //  13089 Phosphonitrilic Chloride Trimer
        PhosphonitrilicChlorideTrimer = new Material.Builder(getId(), gregtechId("phosphonitrilic_chloride_trimer"))
                .liquid()
                .color(0x082C38)
                .components(Chlorine, 6, Nitrogen, 3, Phosphorus, 3)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  13090 Fluorobenzene
        Fluorobenzene = new Material.Builder(getId(), gregtechId("fluorobenzene"))
                .liquid()
                .color(0x7CCA88)
                .components(Carbon, 6, Hydrogen, 5, Fluorine, 1)
                .build();

        //  13091 Octafluoro Pentanol
        OctafluoroPentanol = new Material.Builder(getId(), gregtechId("octafluoro_pentanol"))
                .liquid()
                .color(0xE5EBDE)
                .components(Carbon, 5, Hydrogen, 4, Fluorine, 8, Oxygen, 1)
                .build();

        //  13092 Turpentine
        Turpentine = new Material.Builder(getId(), gregtechId("turpentine"))
                .liquid()
                .color(0x93BD46)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 16)
                .build();

        //  13093 Tetrahydrofuran
        Tetrahydrofuran = new Material.Builder(getId(), gregtechId("tetrahydrofuran"))
                .liquid()
                .color(0x0BCF52)
                .components(Carbon, 4, Hydrogen, 8, Oxygen, 1)
                .build()
                .setFormula("(CH2)4O", true);

        //  13094 Ethylene Dibromide
        EthyleneDibromide = new Material.Builder(getId(), gregtechId("ethylene_dibromide"))
                .liquid()
                .color(0x4F1743)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 2, Hydrogen, 4, Bromine, 2)
                .build();

        //  13095 Grignard Reagent
        GrignardReagent = new Material.Builder(getId(), gregtechId("grignard_reagent"))
                .liquid()
                .color(0xA12AA1)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 1, Hydrogen, 3, Magnesium, 1, Bromine, 1)
                .build();

        //  13096 Diethyl Suflide
        DiethylSuflide = new Material.Builder(getId(), gregtechId("diethyl_sulfide"))
                .liquid()
                .color(0xFF7E4B)
                .flags(DISABLE_DECOMPOSITION)
                .components(Ethylene, 2, Sulfur, 1)
                .build()
                .setFormula("(C2H5)2S", true);

        //  13097 Ammonium Cyanate
        AmmoniumCyanate = new Material.Builder(getId(), gregtechId("ammonium_cyanate"))
                .liquid()
                .color(0x3a5dcf)
                .components(Hydrogen, 4, Nitrogen, 2, Carbon, 1, Oxygen, 1)
                .build()
                .setFormula("NH4CNO", true);

        //  13098 Carbamide
        Carbamide = new Material.Builder(getId(), gregtechId("carbamide"))
                .dust()
                .color(0x16EF57)
                .iconSet(ROUGH)
                .components(Carbon, 1, Hydrogen, 4, Nitrogen, 2, Oxygen, 1)
                .build();

        //  13099 Tributylamine
        Tributylamine = new Material.Builder(getId(), gregtechId("tributylamine"))
                .liquid()
                .color(0x801a80)
                .components(Carbon, 12, Hydrogen, 27, Nitrogen, 1)
                .build()
                .setFormula("(C4H9)3N", true);

        //  13100 Dichloromethane
        Dichloromethane = new Material.Builder(getId(), gregtechId("dichloromethane"))
                .liquid()
                .color(0xB87FC7)
                .components(Carbon, 1, Hydrogen, 2, Chlorine, 2)
                .build();
    }

    private static int getId() {
        if (startId < endId) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
