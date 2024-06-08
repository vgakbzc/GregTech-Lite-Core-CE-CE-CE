package magicbook.gtlitecore.api.unification.materials;

import gregtech.api.fluids.FluidBuilder;
import gregtech.api.fluids.attribute.FluidAttributes;
import gregtech.api.unification.material.Material;
import magicbook.gtlitecore.api.annotation.MaterialIDRange;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.util.GTUtility.gregtechId;
import static gregtechfoodoption.GTFOMaterialHandler.AceticAnhydride;
import static magicbook.gtlitecore.api.annotation.processor.MaterialIDProvider.getID;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteMaterialIconSet.REAGENT;

/**
 * Organic Chemistry Materials
 *
 * @author Magic_Sweepy
 *
 * <p>
 *     This class is a part of {@code Material} class.
 * </p>
 *
 * @since 2.8.7-beta
 */
@MaterialIDRange(startID = 13001, endID = 15000)
public class GTLiteOrganicChemistryMaterials {

    public static void register() {
        //  13001 Kapton-K
        KaptonK = new Material.Builder(getID(), gregtechId("kapton_k"))
                .polymer()
                .liquid()
                .color(16764498)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE, GENERATE_FOIL)
                .components(Carbon, 12, Hydrogen, 12, Nitrogen, 2, Oxygen, 1)
                .build()
                .setFormula("(C7H2N2O4)(O(C6H4)2)", true);

        //  13002 Kapton-E
        KaptonE = new Material.Builder(getID(), gregtechId("kapton_e"))
                .polymer()
                .liquid()
                .color(16768908)
                .flags(DISABLE_DECOMPOSITION, GENERATE_PLATE, NO_SMASHING, NO_SMELTING, GENERATE_FOIL)
                .components(Carbon, 12, Hydrogen, 12, Nitrogen, 2, Oxygen, 1)
                .build()
                .setFormula("O(C6H4NH2)2", true);

        //  13003 Polyetherketone
        Polyetheretherketone = new Material.Builder(getID(), gregtechId("polyetheretherketone"))
                .polymer()
                .liquid()
                .color(0x45433D)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE)
                .components(Carbon, 20, Hydrogen, 12, Oxygen, 3)
                .fluidPipeProperties(2000, 700, true)
                .build();

        //  13004 Kevlar
        Kevlar = new Material.Builder(getID(), gregtechId("kevlar"))
                .polymer()
                .liquid()
                .color(0xF0F078)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE)
                .components(Carbon, 14, Hydrogen, 10, Nitrogen, 2, Oxygen, 2)
                .build()
                .setFormula("(C6H4)2(CO)2(NH)2", true);

        //  13005 Zylon
        Zylon = new Material.Builder(getID(), gregtechId("zylon"))
                .polymer()
                .liquid()
                .color(0xFFE000)
                .iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE, GENERATE_FOIL)
                .components(Carbon, 14, Hydrogen, 6, Nitrogen, 2, Oxygen, 2)
                .build();

        //  13006 Fullerene Polymer Matrix
        FullerenePolymerMatrix = new Material.Builder(getID(), gregtechId("fullerene_polymer_matrix"))
                .polymer()
                .liquid(new FluidBuilder().temperature(500))
                .color(0x2F0B01)
                .iconSet(SHINY)
                .components(Lead, 1, Iron, 1, Carbon, 153, Hydrogen, 36, Nitrogen, 1, Oxygen, 2)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE, GENERATE_FOIL, GENERATE_ROD, GENERATE_FINE_WIRE)
                .build();

        //  13007 Cosmic Fabric
        CosmicFabric = new Material.Builder(getID(), gregtechId("cosmic_fabric"))
                .polymer()
                .liquid(new FluidBuilder().temperature(83654))
                .plasma()
                .color(0x9E19CF)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE, GENERATE_FOIL, GENERATE_FINE_WIRE)
                .build();

        //  13008 Methyl Formate
        MethylFormate = new Material.Builder(getID(), gregtechId("methyl_formate"))
                .liquid()
                .color(0xFFAAAA)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 4, Carbon, 2, Oxygen, 2)
                .build()
                .setFormula("HCO2CH3", true);

        //  13009 Formic Acid
        FormicAcid = new Material.Builder(getID(), gregtechId("formic_acid"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xFFAA77)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 2, Carbon, 1, Oxygen, 2)
                .build()
                .setFormula("HCOOH", true);

        //  13010 Ethylhexanol
        Ethylhexanol = new Material.Builder(getID(), gregtechId("ethylhexanol"))
                .liquid()
                .color(0xFEEA9A)
                .components(Carbon, 8, Hydrogen, 10, Oxygen, 1)
                .build();

        //  13011 Diethylhexyl Phosphoric Acid
        DiethylhexylPhosphoricAcid = new Material.Builder(getID(), gregtechId("diethylhexyl_phosphoric_acid"))
                .liquid()
                .color(0xFFFF99)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 16, Hydrogen, 35, Oxygen, 4, Phosphorus, 1)
                .build()
                .setFormula("(C8H7O)2PO2H", true);

        //  13012 Acetone Cyanohydrin
        AcetoneCyanohydrin = new Material.Builder(getID(), gregtechId("acetone_cyanohydrin"))
                .liquid()
                .color(0xA1FFD0)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 4, Hydrogen, 7, Nitrogen, 1, Oxygen, 1)
                .build();

        //  13013 PMMA
        PMMA = new Material.Builder(getID(), gregtechId("polymethylmethacrylate"))
                .polymer()
                .liquid()
                .color(9554657)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE, GENERATE_FOIL, GENERATE_FINE_WIRE)
                .components(Carbon, 5, Hydrogen, 8, Oxygen, 2)
                .build();

        //  13014 Dimethyl Carbonate
        DimethylCarbonate = new Material.Builder(getID(), gregtechId("dimethyl_carbonate"))
                .liquid()
                .color(0xC5EB9E)
                .components(Carbon, 3, Hydrogen, 6, Oxygen, 3)
                .build()
                .setFormula("(CH3O)2CO", true);

        //  13015 Diphenyl Carbonate
        DiphenylCarbonate = new Material.Builder(getID(), gregtechId("diphenyl_carbonate"))
                .liquid()
                .color(DimethylCarbonate.getMaterialRGB() + Benzene.getMaterialRGB())
                .components(Carbon, 13, Hydrogen, 10, Oxygen, 3)
                .build();

        //  13016 BPA Polycarbonate
        BPAPolycarbonate = new Material.Builder(getID(), gregtechId("bpa_polycarbonate"))
                .polymer()
                .liquid()
                .color(0xE3EBDA)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE)
                .components(Carbon, 16, Hydrogen, 14, Oxygen, 3)
                .build();

        //  13017 Propadiene
        Propadiene = new Material.Builder(getID(), gregtechId("propadiene"))
                .liquid()
                .color(0xBD8F61)
                .components(Carbon, 3, Hydrogen, 4)
                .build();

        //  13018 Isobutyric Acid
        IsobutyricAcid = new Material.Builder(getID(), gregtechId("isobutyric_acid"))
                .liquid()
                .color(Propene.getMaterialRGB() + Propadiene.getMaterialRGB())
                .components(Carbon, 4, Hydrogen, 8, Oxygen, 2)
                .build();

        //  13019 Isobutyric Anhydride
        IsobutyricAnhydride = new Material.Builder(getID(), gregtechId("isobutyric_anhydride"))
                .liquid()
                .color(IsobutyricAcid.getMaterialRGB() - AceticAnhydride.getMaterialRGB())
                .components(Carbon, 8, Hydrogen, 14, Oxygen, 3)
                .build();

        //  13020 Dimethylketene
        Dimethylketene = new Material.Builder(getID(), gregtechId("dimethylketene"))
                .liquid()
                .color(0x0925BE)
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 2)
                .build();

        //  13021 Tetramethylcyclobutanediol
        Tetramethylcyclobutanediol = new Material.Builder(getID(), gregtechId("tetramethylcyclobutanediol"))
                .liquid()
                .color(Dimethylketene.getMaterialRGB() + Hydrogen.getMaterialRGB())
                .components(Carbon, 8, Hydrogen, 16, Oxygen, 2)
                .build();

        //  13022 CBDO Polycarbonate
        CBDOPolycarbonate = new Material.Builder(getID(), gregtechId("cbdo_polycarbonate"))
                .polymer()
                .liquid()
                .color(0xDFDFDF)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE, GENERATE_FOIL, GENERATE_FINE_WIRE)
                .components(Carbon, 9, Hydrogen, 14, Oxygen, 3)
                .build();

        //  13023 Butanediol
        Butanediol = new Material.Builder(getID(), gregtechId("butanediol"))
                .liquid()
                .color(0xAAC4DA)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 2)
                .build()
                .setFormula("C4H8(OH)2", true);

        //  13024 Diacetyl
        Diacetyl = new Material.Builder(getID(),  gregtechId("diacetyl"))
                .liquid()
                .color(0xF7FF65)
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 2)
                .build();

        //  13025 Ethylene Glycol
        EthyleneGlycol = new Material.Builder(getID(), gregtechId("ethylene_glycol"))
                .liquid()
                .color(0x286632)
                .components(Carbon, 2, Hydrogen, 6, Oxygen, 2)
                .build()
                .setFormula("C2H4(OH)2", true);

        //  13026 EDOT
        Edot = new Material.Builder(getID(), gregtechId("edot"))
                .liquid()
                .color(11665367)
                .components(Carbon, 6, Hydrogen, 6, Oxygen, 2, Sulfur, 1)
                .build();

        //  13027 Polystyrene
        Polystyrene = new Material.Builder(getID(), gregtechId("polystyrene"))
                .fluid()
                .color(14795458)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 8, Hydrogen, 8)
                .build();

        //  13028 Polystyrene Sulfonate
        PolystyreneSulfonate = new Material.Builder(getID(), gregtechId("polystyrene_sulfonate"))
                .polymer()
                .liquid()
                .color(14777458)
                .flags(DISABLE_DECOMPOSITION, GENERATE_PLATE)
                .components(Carbon, 8, Hydrogen, 8, Sulfur, 1, Oxygen, 3)
                .build()
                .setFormula("C8H7SO3H", true);

        //  13029 PEDOT:PSS
        PedotPSS = new Material.Builder(getID(), gregtechId("pedot_pss"))
                .polymer()
                .liquid()
                .color(14771623)
                .flags(DISABLE_DECOMPOSITION, GENERATE_FINE_WIRE)
                .components(Edot, 1, PolystyreneSulfonate, 1)
                .cableProperties(V[UHV], 24, 0, true)
                .build();

        //  13030 PEDOT-TMA
        PedotTMA = new Material.Builder(getID(), gregtechId("pedot_tma"))
                .ingot()
                .liquid()
                .color(0x5E9EE1)
                .flags(DISABLE_DECOMPOSITION, GENERATE_ROD, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_PLATE, GENERATE_FOIL, GENERATE_FINE_WIRE)
                .components(Edot, 1, PMMA, 2)
                .cableProperties(V[UEV], 8, 6, false)
                .build();

        //  13031 Para Xylene
        ParaXylene = new Material.Builder(getID(), gregtechId("para_xylene"))
                .liquid()
                .color(0x666040)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 8, Hydrogen, 10)
                .build()
                .setFormula("C6H4(CH3)2", true);

        //  13032 Durene
        Durene = new Material.Builder(getID(), gregtechId("durene"))
                .dust()
                .color(0x336040)
                .iconSet(FINE)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 14)
                .build()
                .setFormula("C6H2(CH3)4", true);

        //  13033 Pyromellitic Dianhydride
        PyromelliticDianhydride = new Material.Builder(getID(), gregtechId("pyromellitic_dianhydride"))
                .dust()
                .color(0xF0EAD6)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 2, Oxygen, 6)
                .build()
                .setFormula("C6H2(C2O3)2", true);

        //  13034 Oxydianiline
        Oxydianiline = new Material.Builder(getID(), gregtechId("oxydianiline"))
                .dust()
                .color(0xF0E130)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 12, Hydrogen, 12, Nitrogen, 2, Oxygen, 1)
                .build()
                .setFormula("O(C6H4NH2)2", true);

        //  13035 Dimethylformamide
        Dimethylformamide = new Material.Builder(getID(), gregtechId("dimethylformamide"))
                .liquid()
                .color(0x42BDFF)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 3, Hydrogen, 7, Nitrogen, 1, Oxygen, 1)
                .build()
                .setFormula("(CH3)2NC(O)H", true);

        //  13036 Phthalic Anhydride
        PhthalicAnhydride = new Material.Builder(getID(), gregtechId("phthalic_anhydride"))
                .dust()
                .color(0xEEAAEE)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 8, Hydrogen, 4, Oxygen, 3)
                .build()
                .setFormula("C6H4(CO)2O", true);

        //  13037 Biphenyl Tetracarboxylic Acid Dianhydride
        BiphenylTetracarboxylicAcidDianhydride = new Material.Builder(getID(), gregtechId("biphenyl_tetracarboxylic_acid_dianhydride"))
                .dust()
                .color(0xFF7F50)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 16, Hydrogen, 6, Oxygen, 6)
                .build()
                .setFormula("(C8H3O3)2", true);

        //  13038 Nitroaniline
        Nitroaniline = new Material.Builder(getID(), gregtechId("nitroaniline"))
                .liquid()
                .color(0x2A6E68)
                .components(Carbon, 6, Hydrogen, 6, Nitrogen, 2, Oxygen, 2)
                .build()
                .setFormula("H2NC6H4NO2", true);

        //  13039 Para Phenylenediamine
        ParaPhenylenediamine = new Material.Builder(getID(), gregtechId("para_phenylenediamine"))
                .dust()
                .color(0x4A8E7B)
                .iconSet(ROUGH)
                .components(Carbon, 6, Hydrogen, 8, Nitrogen, 2)
                .build()
                .setFormula("H2NC6H4NH2", true);

        //  13040 Bistrichloromethylbenzene
        Bistrichloromethylbenzene = new Material.Builder(getID(), gregtechId("bistrichloromethylbenzene"))
                .liquid()
                .color(0xCF8498)
                .components(Carbon, 8, Hydrogen, 4, Chlorine, 6)
                .build()
                .setFormula("C6H4(CCl3)2", true);

        //  13041 Acetylene
        Acetylene = new Material.Builder(getID(), gregtechId("acetylene"))
                .liquid()
                .color(0x959C60)
                .components(Carbon, 2, Hydrogen, 2)
                .build();

        //  13042 Tetrabromoethane
        Tetrabromoethane = new Material.Builder(getID(), gregtechId("tetrabromoethane"))
                .liquid()
                .color(0x5AAADA)
                .components(Carbon, 2, Hydrogen, 2, Bromine, 4)
                .build();

        //  13043 Terephthalic Acid
        TerephthalicAcid = new Material.Builder(getID(), gregtechId("terephthalic_acid"))
                .dust()
                .color(0x5ACCDA)
                .iconSet(ROUGH)
                .components(Carbon, 8, Hydrogen, 6, Oxygen, 4)
                .build()
                .setFormula("C6H4(CO2H)2", true);

        //  13044 Terephthaloyl Chloride
        TerephthaloylChloride = new Material.Builder(getID(), gregtechId("terephthaloyl_chloride"))
                .dust()
                .color(0xFAC4DA)
                .iconSet(SHINY)
                .components(Carbon, 8, Hydrogen, 4, Oxygen, 2, Chlorine, 2)
                .build()
                .setFormula("C6H4(COCl)2", true);

        //  13045 γ-Butyrolactone
        GammaButyrolactone = new Material.Builder(getID(), gregtechId("gamma_butyrolactone"))
                .liquid()
                .color(0xAF04D6)
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 2)
                .build();

        //  13046 Methylamine
        Methylamine = new Material.Builder(getID(), gregtechId("methylamine"))
                .gas()
                .color(0xAA6600)
                .components(Carbon, 1, Hydrogen, 5, Nitrogen, 1)
                .build()
                .setFormula("CH3NH2", true);

        //  13047 N-Methyl Pyrrolidone
        NMethylPyrrolidone = new Material.Builder(getID(), gregtechId("n_methyl_pyrrolidone"))
                .liquid()
                .color(0xA504D6)
                .components(Carbon, 5, Hydrogen, 9, Nitrogen, 1, Oxygen, 1)
                .build();

        //  13048 Dichloroethane
        Dichloroethane = new Material.Builder(getID(), gregtechId("dichloroethane"))
                .liquid()
                .color(0xDAAED3)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 2, Hydrogen, 4, Chlorine, 2)
                .build();

        //  13049 Trichloroethylene
        Trichloroethylene = new Material.Builder(getID(), gregtechId("trichloroethylene"))
                .liquid()
                .color(0xB685B1)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 2, Hydrogen, 1, Chlorine, 3)
                .build();

        //  13050 Chloroacetic Acid
        ChloroaceticAcid = new Material.Builder(getID(), gregtechId("chloroacetic_acid"))
                .dust()
                .color(0x38541A)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(SHINY)
                .components(Carbon, 2, Hydrogen, 3, Chlorine, 1, Oxygen, 2)
                .build();

        //  13051 Malonic Acid
        MalonicAcid = new Material.Builder(getID(), gregtechId("malonic_acid"))
                .dust()
                .color(0x61932E)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(SHINY)
                .components(Carbon, 3, Hydrogen, 4, Oxygen, 4)
                .build();

        //  13052 Dimethylamine Hydrochloride
        DimethylamineHydrochloride = new Material.Builder(getID(), gregtechId("dimethylamine_hydrochloride"))
                .liquid()
                .color(0xE3EBDC)
                .components(Dimethylamine, 1, HydrochloricAcid, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("C2H8NCl", true);

        //  13053 Ethylenediamine
        Ethylenediamine = new Material.Builder(getID(), gregtechId("ethylenediamine"))
                .liquid()
                .color(0xD00ED0)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 2, Hydrogen, 8, Nitrogen, 2)
                .build()
                .setFormula("C2H4(NH2)2", true);

        //  13054 Formaldehyde
        Formaldehyde = new Material.Builder(getID(), gregtechId("formaldehyde"))
                .liquid()
                .color(0x858F40)
                .components(Carbon, 1, Hydrogen, 2, Oxygen, 1)
                .build();

        //  13055 Tetrasodium EDTA
        TetrasodiumEDTA = new Material.Builder(getID(), gregtechId("tetrasodium_edta"))
                .dust()
                .color(0x8890E0)
                .iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 12, Nitrogen, 2, Oxygen, 8, Sodium, 4)
                .build();

        //  13056 Ethylenediaminetetraacetic Acid
        EthylenediaminetetraaceticAcid = new Material.Builder(getID(), gregtechId("ethylenediaminetetraacetic_acid"))
                .dust()
                .liquid()
                .color(0x87E6D9)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 16, Nitrogen, 2, Oxygen, 8)
                .build();

        //  13057 Trimethylamine
        Trimethylamine = new Material.Builder(getID(), gregtechId("trimethylamine"))
                .gas()
                .color(0xBB7700)
                .components(Carbon, 3, Hydrogen, 9, Nitrogen, 1)
                .build()
                .setFormula("(CH3)3N", true);

        //  13058 Tetramethylammonium Chloride
        TetramethylammoniumChloride = new Material.Builder(getID(), gregtechId("tetramethylammonium_chloride"))
                .dust()
                .color(0x27FF81)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(METALLIC)
                .components(Carbon, 4, Hydrogen, 12, Nitrogen, 1, Chlorine, 1)
                .build()
                .setFormula("N(CH3)4Cl", true);

        //  13059 Tetramethylammonium Hydroxide
        TetramethylammoniumHydroxide = new Material.Builder(getID(), gregtechId("tetramethylammonium_hydroxide"))
                .liquid()
                .color(4259798)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 1, Carbon, 4, Hydrogen, 12, Oxygen, 1, Hydrogen, 1)
                .build()
                .setFormula("N(CH3)4OH", true);

        //  13060 Hydrogen Peroxide
        HydrogenPeroxide = new Material.Builder(getID(), gregtechId("hydrogen_peroxide"))
                .liquid()
                .color(0xD2FFFF)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 2, Oxygen, 2)
                .build();

        //  13061 Pyrocatechol
        Pyrocatechol = new Material.Builder(getID(), gregtechId("pyrocatechol"))
                .dust()
                .color(0x784421)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(DULL)
                .components(Carbon, 6, Hydrogen, 6, Oxygen, 2)
                .build();

        //  13062 Ethylene Oxide
        EthyleneOxide = new Material.Builder(getID(), gregtechId("ethylene_oxide"))
                .gas()
                .color(0xDCBFE1)
                .components(Carbon, 2, Hydrogen, 4, Oxygen, 1)
                .build();

        //  13063 Indene
        Indene = new Material.Builder(getID(), gregtechId("indene"))
                .liquid()
                .color(0x171429)
                .components(Carbon, 9, Hydrogen, 8)
                .build();

        //  13064 Indanone
        Indanone = new Material.Builder(getID(), gregtechId("indanone"))
                .dust()
                .color(0x2E1616)
                .iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 9, Hydrogen, 8, Oxygen, 1)
                .build();

        //  13065 Truxene
        Truxene = new Material.Builder(getID(), gregtechId("truxene"))
                .liquid()
                .color(0x1A3336)
                .components(Carbon, 27, Hydrogen, 18)
                .build();

        //  13066 Bromomethane
        Bromomethane = new Material.Builder(getID(), gregtechId("bromomethane"))
                .gas()
                .color(0xC82C31)
                .components(Carbon, 1, Hydrogen, 3, Bromine, 1)
                .build();

        //  13067 Bromo Bromomethyl Naphthalene
        BromoBromomethylNaphthalene = new Material.Builder(getID(), gregtechId("bromo_bromomethyl_naphthalene"))
                .liquid()
                .color(0x52122E)
                .components(Carbon, 11, Hydrogen, 8, Bromine, 2)
                .build();

        //  13068 Butanol
        Butanol = new Material.Builder(getID(), gregtechId("butanol"))
                .liquid()
                .color(0xC7AF2E)
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 1)
                .build()
                .setFormula("C4H9OH", true);

        //  13069 Bromobutane
        Bromobutane = new Material.Builder(getID(), gregtechId("bromobutane"))
                .gas()
                .color(0xE6E8A2)
                .components(Butene, 1, HydrobromicAcid, 1)
                .build()
                .setFormula("C4H9Br", true);

        //  13070 Butyllithium
        Butyllithium = new Material.Builder(getID(), gregtechId("butyllithium"))
                .liquid()
                .color(0xE683B6B)
                .components(Butene, 1, Hydrogen, 1, Lithium, 1)
                .build()
                .setFormula("C4H9Li", true);

        //  13071 Palladium Acetate
        PalladiumAcetate = new Material.Builder(getID(), gregtechId("palladium_acetate"))
                .dust()
                .color(0x693C2D)
                .iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Palladium, 1, AceticAcid, 2)
                .build()
                .setFormula("Pd(CH3COOH)2", true);

        //  13072 Geodesic Polyarene
        GeodesicPolyarene = new Material.Builder(getID(), gregtechId("geodesic_polyarene"))
                .dust()
                .color(0x9E81A8)
                .iconSet(METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 60, Hydrogen, 30)
                .build();

        //  13073 Hydrazine
        Hydrazine = new Material.Builder(getID(), gregtechId("hydrazine"))
                .liquid()
                .color(0xB50707)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 2, Hydrogen, 4)
                .build();

        //  13074 Ethylanthraquinone
        Ethylanthraquinone = new Material.Builder(getID(), gregtechId("ethylanthraquinone"))
                .liquid()
                .color(0xCC865A)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 16, Hydrogen, 12, Oxygen, 2)
                .build()
                .setFormula("C6H4(CO)2C6H3Et", true);

        //  13075 Ethylanthrahydroquinone
        Ethylanthrahydroquinone = new Material.Builder(getID(), gregtechId("ethylanthrahydroquinone"))
                .liquid()
                .color(0xAD531A)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 16, Hydrogen, 18, Oxygen, 2)
                .build()
                .setFormula("C6H4(CH2OH)2C6H3Et", true);

        //  13076 Cycloparaphenylene
        Cycloparaphenylene = new Material.Builder(getID(), gregtechId("cycloparaphenylene"))
                .liquid()
                .color(0x60545A)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 6, Hydrogen, 4)
                .build();

        //  13077 Cyclooctadiene
        Cyclooctadiene = new Material.Builder(getID(), gregtechId("cyclooctadiene"))
                .liquid()
                .color(0x40AC40)
                .components(Carbon, 8, Hydrogen, 12)
                .build();

        //  13078 Dichlorocyclooctadieneplatinium
        Dichlorocyclooctadieneplatinium = new Material.Builder(getID(), gregtechId("dichlorocyclooctadieneplatinium"))
                .dust()
                .color(0xD4E982)
                .iconSet(BRIGHT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 8, Hydrogen, 12, Chlorine, 2, Platinum, 1)
                .build();

        //  13079 Diiodobiphenyl
        Diiodobiphenyl = new Material.Builder(getID(), gregtechId("diiodobiphenyl"))
                .dust()
                .color(0x000C52)
                .iconSet(METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 12, Hydrogen, 8, Iodine, 2)
                .build();

        //  13080 Hydroxylamine Disulfate
        HydroxylamineDisulfate = new Material.Builder(getID(), gregtechId("hydroxylamine_disulfate"))
                .liquid()
                .color(0x91A6D2)
                .components(Nitrogen, 4, Hydrogen, 16, Oxygen, 10, Sulfur, 2)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("(NH3OH)2(NH4)2(SO4)2", true);

        //  13081 Hydroxylamine
        Hydroxylamine = new Material.Builder(getID(), gregtechId("hydroxylamine"))
                .liquid()
                .color(0x91C791)
                .components(Hydrogen, 3, Nitrogen, 1, Oxygen, 1)
                .build()
                .setFormula("H3NO", true);

        //  13082 Octene
        Octene = new Material.Builder(getID(), gregtechId("octene"))
                .liquid()
                .color(0x818022)
                .components(Carbon, 8, Hydrogen, 16)
                .build();

        //  13083 Methylhydrazine
        Methylhydrazine = new Material.Builder(getID(), gregtechId("methylhydrazine"))
                .liquid()
                .color(0x321452)
                .components(Carbon, 1, Hydrogen, 6, Nitrogen, 2)
                .build();

        //  13084 Hexafluoropropylene
        Hexafluoropropylene = new Material.Builder(getID(), gregtechId("hexafluoropropylene"))
                .liquid()
                .color(0x141D6F)
                .components(Carbon, 3, Fluorine, 6)
                .build();

        //  13085 Fluorinated Ethylene Propylene
        FluorinatedEthylenePropylene = new Material.Builder(getID(), gregtechId("fluorinated_ethylene_propylene"))
                .liquid() // TODO polymer?
                .color(0xC8C8C8)
                .iconSet(DULL)
                .components(Carbon, 5, Fluorine, 10)
                .build();

        //  13086 Nitrile Butadiene Rubber
        NitrileButadieneRubber = new Material.Builder(getID(), gregtechId("nitrile_butadiene_rubber"))
                .polymer()
                .liquid(new FluidBuilder().temperature(433))
                .color(0x211A18)
                .flags(DISABLE_DECOMPOSITION, GENERATE_PLATE, GENERATE_RING)
                .components(Carbon, 7, Hydrogen, 9, Nitrogen, 1)
                .build();

        //  13087 Poly (Phosphonitrile Fluoro) Rubber
        PolyPhosphonitrileFluoroRubber = new Material.Builder(getID(), gregtechId("poly_phosphonitrile_fluoro_rubber"))
                .polymer()
                .liquid()
                .color(0x372B28)
                .flags(DISABLE_DECOMPOSITION, GENERATE_PLATE, GENERATE_RING, GENERATE_FOIL)
                .components(Carbon, 24, Hydrogen, 16, Oxygen, 8, Nitrogen, 4, Phosphorus, 4, Fluorine, 40)
                .build();

        //  13088 Acrylonitrile
        Acrylonitrile = new Material.Builder(getID(), gregtechId("acrylonitrile"))
                .liquid()
                .color(Propene.getMaterialRGB())
                .components(Carbon, 3, Hydrogen, 3, Nitrogen, 1)
                .build();

        //  13089 Phosphonitrilic Chloride Trimer
        PhosphonitrilicChlorideTrimer = new Material.Builder(getID(), gregtechId("phosphonitrilic_chloride_trimer"))
                .liquid()
                .color(0x082C38)
                .components(Chlorine, 6, Nitrogen, 3, Phosphorus, 3)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  13090 Fluorobenzene
        Fluorobenzene = new Material.Builder(getID(), gregtechId("fluorobenzene"))
                .liquid()
                .color(0x7CCA88)
                .components(Carbon, 6, Hydrogen, 5, Fluorine, 1)
                .build();

        //  13091 Octafluoro Pentanol
        OctafluoroPentanol = new Material.Builder(getID(), gregtechId("octafluoro_pentanol"))
                .liquid()
                .color(0xE5EBDE)
                .components(Carbon, 5, Hydrogen, 4, Fluorine, 8, Oxygen, 1)
                .build();

        //  13092 Turpentine
        Turpentine = new Material.Builder(getID(), gregtechId("turpentine"))
                .liquid()
                .color(0x93BD46)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 16)
                .build();

        //  13093 Tetrahydrofuran
        Tetrahydrofuran = new Material.Builder(getID(), gregtechId("tetrahydrofuran"))
                .liquid()
                .color(0x0BCF52)
                .components(Carbon, 4, Hydrogen, 8, Oxygen, 1)
                .build()
                .setFormula("(CH2)4O", true);

        //  13094 Ethylene Dibromide
        EthyleneDibromide = new Material.Builder(getID(), gregtechId("ethylene_dibromide"))
                .liquid()
                .color(0x4F1743)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 2, Hydrogen, 4, Bromine, 2)
                .build();

        //  13095 Grignard Reagent
        GrignardReagent = new Material.Builder(getID(), gregtechId("grignard_reagent"))
                .liquid()
                .color(0xA12AA1)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 1, Hydrogen, 3, Magnesium, 1, Bromine, 1)
                .build();

        //  13096 Diethyl Suflide
        DiethylSuflide = new Material.Builder(getID(), gregtechId("diethyl_sulfide"))
                .liquid()
                .color(0xFF7E4B)
                .flags(DISABLE_DECOMPOSITION)
                .components(Ethylene, 2, Sulfur, 1)
                .build()
                .setFormula("(C2H5)2S", true);

        //  13097 Ammonium Cyanate
        AmmoniumCyanate = new Material.Builder(getID(), gregtechId("ammonium_cyanate"))
                .liquid()
                .color(0x3a5dcf)
                .components(Hydrogen, 4, Nitrogen, 2, Carbon, 1, Oxygen, 1)
                .build()
                .setFormula("NH4CNO", true);

        //  13098 Carbamide
        Carbamide = new Material.Builder(getID(), gregtechId("carbamide"))
                .dust()
                .color(0x16EF57)
                .iconSet(ROUGH)
                .components(Carbon, 1, Hydrogen, 4, Nitrogen, 2, Oxygen, 1)
                .build();

        //  13099 Tributylamine
        Tributylamine = new Material.Builder(getID(), gregtechId("tributylamine"))
                .liquid()
                .color(0x801a80)
                .components(Carbon, 12, Hydrogen, 27, Nitrogen, 1)
                .build()
                .setFormula("(C4H9)3N", true);

        //  13100 Dichloromethane
        Dichloromethane = new Material.Builder(getID(), gregtechId("dichloromethane"))
                .liquid()
                .color(0xB87FC7)
                .components(Carbon, 1, Hydrogen, 2, Chlorine, 2)
                .build();

        //  13101 Difluorobenzophenone
        Difluorobenzophenone = new Material.Builder(getID(), gregtechId("difluorobenzophenone"))
                .dust()
                .color(0xC44DA5)
                .iconSet(SHINY)
                .components(Carbon, 13, Hydrogen, 8, Oxygen, 1, Fluorine, 2)
                .build()
                .setFormula("(FC6H4)2CO", true);

        //  13102 Hydroquinone
        Hydroquinone = new Material.Builder(getID(), gregtechId("hydroquinone"))
                .liquid()
                .color(0x83251A)
                .components(Carbon, 6, Hydrogen, 6, Oxygen, 2)
                .build()
                .setFormula("C6H4(OH)2", true);

        //  13103 Fluorotoluene
        Fluorotoluene = new Material.Builder(getID(), gregtechId("fluorotoluene"))
                .liquid()
                .color(0x6EC5B8)
                .components(Carbon, 7, Hydrogen, 7, Fluorine, 1)
                .build();

        //  13104 Resorcinol
        Resorcinol = new Material.Builder(getID(), gregtechId("resorcinol"))
                .liquid()
                .color(0x9DA38D)
                .components(Carbon, 6, Hydrogen, 6, Oxygen, 2)
                .build();

        //  13105 Pre Zylon
        PreZylon = new Material.Builder(getID(), gregtechId("pre_zylon"))
                .dust()
                .color(0x623250)
                .iconSet(DULL)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING)
                .components(Carbon, 20, Hydrogen, 22, Nitrogen, 2, Oxygen, 2)
                .build();

        //  13106 Terephthalaldehyde
        Terephthalaldehyde = new Material.Builder(getID(), gregtechId("terephthalaldehyde"))
                .dust()
                .color(0x567C2D)
                .iconSet(ROUGH)
                .components(Carbon, 8, Hydrogen, 6, Oxygen, 2)
                .build();

        //  13107 Dinitrodipropanyloxybenzene
        Dinitrodipropanyloxybenzene = new Material.Builder(getID(), gregtechId("dinitrodipropanyloxybenzene"))
                .liquid()
                .color(0x9FAD1D)
                .components(Carbon, 12, Hydrogen, 16, Oxygen, 6, Nitrogen, 2)
                .build()
                .setFormula("C12H16O2(NO2)2", true);

        //  13108 Isochloropropane
        Isochloropropane = new Material.Builder(getID(), gregtechId("isochloropropane"))
                .liquid()
                .color(0xC3AC65)
                .components(Carbon, 3, Hydrogen, 7, Chlorine, 1)
                .build()
                .setFormula("CH3CHClCH3", true);

        //  13109 Dibromomethylbenzene
        Dibromomethylbenzene = new Material.Builder(getID(), gregtechId("dibromomethylbenzene"))
                .liquid()
                .color(0x9F4839)
                .components(Carbon, 7, Hydrogen, 6, Bromine, 2)
                .build();

        //  13110 Hexanitrohexaaxaisowurtzitane
        Hexanitrohexaaxaisowurtzitane = new Material.Builder(getID(), gregtechId("hexanitrohexaaxaisowurtzitane"))
                .dust()
                .color(0x0B7222)
                .iconSet(BRIGHT)
                .components(Carbon, 6, Hydrogen, 6, Nitrogen, 12, Oxygen, 12)
                .build();

        //  13111 Crude Hexanitrohexaaxaisowurtzitane
        CrudeHexanitrohexaaxaisowurtzitane = new Material.Builder(getID(), gregtechId("crude_hexanitrohexaaxaisowurtzitane"))
                .dust()
                .color(0x5799EC)
                .iconSet(DULL)
                .components(Carbon, 6, Hydrogen, 6, Nitrogen, 12, Oxygen, 12)
                .build();

        //  13112 Tetraacetyldinitrosohexaazaisowurtzitane
        Tetraacetyldinitrosohexaazaisowurtzitane = new Material.Builder(getID(), gregtechId("tetraacetyldinitrosohexaazaisowurtzitane"))
                .dust()
                .color(0xEA7584)
                .iconSet(ROUGH)
                .components(Carbon, 14, Hydrogen, 18, Nitrogen, 8, Oxygen, 6)
                .build();

        //  13113 Benzaldehyde
        Benzaldehyde = new Material.Builder(getID(), gregtechId("benzaldehyde"))
                .liquid()
                .color(0x957D53)
                .components(Carbon, 7, Hydrogen, 6, Oxygen, 1)
                .build();

        //  13114 Dibenzyltetraacetylhexaazaisowurtzitane
        Dibenzyltetraacetylhexaazaisowurtzitane = new Material.Builder(getID(), gregtechId("dibenzyltetraacetylhexaazaisowurtzitane"))
                .dust()
                .color(0xB7E8EE)
                .iconSet(DULL)
                .components(Carbon, 28, Hydrogen, 32, Nitrogen, 6, Oxygen, 4)
                .build();

        //  13115 Hexabenzylhexaazaisowurtzitane
        Hexabenzylhexaazaisowurtzitane = new Material.Builder(getID(), gregtechId("hexabenzylhexaazaisowurtzitane"))
                .dust()
                .color(0x48561E)
                .iconSet(DULL)
                .components(Carbon, 48, Hydrogen, 48 ,Nitrogen, 6)
                .build();

        //  13116 Succinimide
        Succinimide = new Material.Builder(getID(), gregtechId("succinimide"))
                .dust()
                .color(0x1774B6)
                .iconSet(ROUGH)
                .components(Carbon, 4, Hydrogen, 5, Nitrogen, 1, Oxygen, 2)
                .build();

        //  13117 SuccinimidylAcetate
        SuccinimidylAcetate = new Material.Builder(getID(), gregtechId("succinimidyl_acetate"))
                .dust()
                .color(0x1D3605)
                .iconSet(ROUGH)
                .components(Carbon, 6, Hydrogen, 7, Nitrogen, 1, Oxygen, 4)
                .build();

        //  13118 N-Hydroxysuccinimide
        NHydroxysuccinimide = new Material.Builder(getID(), gregtechId("n_hydroxysuccinimide"))
                .dust()
                .color(0x33BAFB)
                .iconSet(DULL)
                .components(Carbon, 4, Hydrogen, 5, Nitrogen, 1, Oxygen, 3)
                .build()
                .setFormula("(CH2CO)2NOH", true);

        //  13119 Succinic Anhydride
        SuccinicAnhydride = new Material.Builder(getID(), gregtechId("succinic_anhydride"))
                .dust()
                .color(0xA2569D)
                .components(Carbon, 4, Hydrogen, 4, Oxygen, 3)
                .build()
                .setFormula("(CH2CO)2O", true);

        //  13120 Hydroxylamine Hydrochloride
        HydroxylamineHydrochloride = new Material.Builder(getID(), gregtechId("hydroxylamine_hydrochloride"))
                .liquid()
                .color(0x893E28)
                .components(Hydrogen, 4, Oxygen, 1, Nitrogen, 1, Chlorine,1 )
                .build()
                .setFormula("HONH2HCl", true);

        //  13121 Succinic Acid
        SuccinicAcid = new Material.Builder(getID(), gregtechId("succinic_acid"))
                .dust()
                .color(0x0C3A5B)
                .iconSet(DULL)
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 4)
                .build();

        //  13122 Maleic Anhydride
        MaleicAnhydride = new Material.Builder(getID(), gregtechId("maleic_anhydride"))
                .liquid()
                .color(0x610C2F)
                .components(Carbon, 4, Hydrogen, 2, Oxygen, 3)
                .build();

        //  13123 Hydroxylammonium Sulfate
        HydroxylammoniumSulfate = new Material.Builder(getID(), gregtechId("hydroxylammonium_sulfate"))
                .dust()
                .color(0x999933)
                .iconSet(DULL)
                .components(Nitrogen, 2, Hydrogen, 8, Oxygen, 6, Sulfur, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("(NH3OH)2SO4", true);

        //  13124 Potassium Hydroxylaminedisulfonate
        PotassiumHydroxylaminedisulfonate = new Material.Builder(getID(), gregtechId("potassium_hydroxylaminedisulfonate"))
                .dust()
                .color(0x627D25)
                .iconSet(ROUGH)
                .components(Potassium, 2, Nitrogen, 1, Hydrogen, 1, Sulfur, 2, Oxygen, 7)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  13125 NitrousAcid
        NitrousAcid = new Material.Builder(getID(), gregtechId("nitrous_acid"))
                .liquid(new FluidBuilder().attributes(FluidAttributes.ACID))
                .color(0x7D82A3)
                .components(Hydrogen, 1, Nitrogen, 1, Oxygen, 2)
                .build();

        //  13126 Acetonitrile
        Acetonitrile = new Material.Builder(getID(), gregtechId("acetonitrile"))
                .dust()
                .color(0x7D82A3)
                .iconSet(ROUGH)
                .components(Carbon, 2, Hydrogen, 3, Nitrogen, 1)
                .build()
                .setFormula("CH3CN", true);

        //  13127 Benzylamine
        Benzylamine = new Material.Builder(getID(), gregtechId("benzylamine"))
                .liquid()
                .color(0x527A92)
                .components(Carbon, 7, Hydrogen, 9, Nitrogen, 1)
                .build();

        //  13128 Acetamide
        Acetamide = new Material.Builder(getID(), gregtechId("acetamide"))
                .dust()
                .color(0x7D82A3)
                .iconSet(DULL)
                .components(Carbon, 2, Hydrogen, 5, Nitrogen, 1, Oxygen, 1)
                .build()
                .setFormula("CH3CONH2", true);

        //  13129 Ammonium Acetate
        AmmoniumAcetate = new Material.Builder(getID(), gregtechId("ammonium_acetate"))
                .dust()
                .color(0x646882)
                .components(Carbon, 2, Hydrogen, 7, Oxygen, 2, Nitrogen, 1)
                .build()
                .setFormula("NH4CH3CO2", true);

        //  13130 Hexamethylenetetramine
        Hexamethylenetetramine = new Material.Builder(getID(), gregtechId("hexamethylenetetramine"))
                .dust()
                .color(0x53576D)
                .iconSet(DULL)
                .components(Carbon, 6, Hydrogen, 12, Nitrogen, 4)
                .build()
                .setFormula("(CH2)6N4", true);

        //  13131 Benzyl Chloride
        BenzylChloride = new Material.Builder(getID(), gregtechId("benzyl_chloride"))
                .liquid()
                .color(0x6699CC)
                .components(Carbon, 7, Hydrogen, 7, Chlorine, 1)
                .build();

        //  13132 HSQ (Hydrogen Silsequioxane)
        HSQ = new Material.Builder(getID(), gregtechId("hsq"))
                .polymer()
                .liquid()
                .color(0xB8F2F8)
                .components(Hydrogen, 1, Silicon, 1, Oxygen, 2)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("-[-HSiO1.5-]-", true);

        //  13133 Methyltrichlorosilane
        Methyltrichlorosilane = new Material.Builder(getID(), gregtechId("methyltrichlorosilane"))
                .liquid()
                .color(0x4D7CB4)
                .components(Carbon, 1, Hydrogen, 3, Chlorine, 3, Silicon, 1)
                .build();

        //  13134 Methyltrimethoxysilane
        Methyltrimethoxysilane = new Material.Builder(getID(), gregtechId("methyltrimethoxysilane"))
                .liquid()
                .color(0x666699)
                .components(Carbon, 4, Hydrogen, 12, Silicon, 1, Oxygen, 3)
                .build()
                .setFormula("CH3Si(CH3O)3", true);

        //  13135 Polymethylsilesquioxane
        Polymethylsilesquioxane = new Material.Builder(getID(), gregtechId("polymethylsilesquioxane"))
                .liquid()
                .color(0x8799B8)
                .components(Carbon, 4, Hydrogen, 12, Silicon, 1, Oxygen, 3)
                .build()
                .setFormula("CH3Si(OCH3)3", true);

        //  13136 KPR
        KPR = new Material.Builder(getID(), gregtechId("kpr"))
                .liquid()
                .color(0x98125C)
                .components(Carbon, 11, Hydrogen, 12, Oxygen, 3)
                .build();

        //  13137 CinnamoylChloride
        CinnamoylChloride = new Material.Builder(getID(), gregtechId("cinnamoyl_chloride"))
                .liquid()
                .color(0xE27C94)
                .components(Carbon, 9, Hydrogen, 7, Chlorine, 1, Oxygen, 1)
                .build();

        //  13138 Cinnamic Acid
        CinnamicAcid = new Material.Builder(getID(), gregtechId("cinnamic_acid"))
                .liquid(new FluidBuilder().attributes(FluidAttributes.ACID))
                .color(0xCDFF72)
                .components(Carbon, 9, Hydrogen, 8, Oxygen, 2)
                .build();

        //  13139 Bisethylenedithiotetraselenafulvalene
        Bisethylenedithiotetraselenafulvalene = new Material.Builder(getID(), gregtechId("bisethylenedithiotetraselenafulvalene"))
                .dust()
                .color(0x98E993)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(ROUGH)
                .components(Carbon, 10, Hydrogen, 8, Sulfur, 4, Selenium, 4)
                .build();

        //  13140 Bromodihydrothiine
        Bromodihydrothiine = new Material.Builder(getID(), gregtechId("bromodihydrothiine"))
                .liquid()
                .color(0x66F36E)
                .components(Carbon, 4, Hydrogen, 4, Sulfur, 2, Bromine, 2)
                .build();

        //  13141 Dibromoacrolein
        Dibromoacrolein = new Material.Builder(getID(), gregtechId("dibromoacrolein"))
                .liquid()
                .color(0x7C4660)
                .components(Carbon, 2, Hydrogen, 2, Bromine, 2, Oxygen, 2)
                .build();

        //  13142 Palladium-Fullerene Matrix
        PalladiumFullereneMatrix = new Material.Builder(getID(), gregtechId("palladium_fullerene_matrix"))
                .dust()
                .color(0x40AEE0)
                .iconSet(SHINY)
                .components(Palladium, 1, Carbon, 73, Hydrogen, 15, Nitrogen, 1, Iron, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  13143 PCBS
        PCBS = new Material.Builder(getID(), gregtechId("pcbs"))
                .liquid()
                .color(0x11B557)
                .components(Carbon, 80, Hydrogen, 21, Oxygen, 2)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  13144 Phenylpentanoic Acid
        PhenylpentanoicAcid = new Material.Builder(getID(), gregtechId("phenylpentanoic_acid"))
                .liquid()
                .color(0x6F4303)
                .components(Carbon, 11, Hydrogen, 14, Oxygen, 2)
                .build();

        //  13145 Dimethyl Sulfide
        DimethylSulfide = new Material.Builder(getID(), gregtechId("dimethyl_sulfide"))
                .liquid()
                .color(0xFFC66B)
                .components(Carbon, 2, Hydrogen, 6, Sulfur, 1)
                .build()
                .setFormula("(CH3)2S", true);

        //  13146 Ferrocenylfulleropyrddolidine
        Ferrocenylfulleropyrddolidine = new Material.Builder(getID(), gregtechId("ferrocenylfulleropyrddolidine"))
                .liquid()
                .color(0x67AE4C)
                .components(Carbon, 74, Hydrogen, 19, Iron, 1, Nitrogen, 1)
                .build();

        //  13147 Sarcosine
        Sarcosine = new Material.Builder(getID(), gregtechId("sarcosine"))
                .dust()
                .color(0x328534)
                .iconSet(SHINY)
                .components(Carbon, 3, Hydrogen, 7, Nitrogen, 1, Oxygen, 2)
                .build();

        //  13148 Glycine
        Glycine = new Material.Builder(getID(), gregtechId("glycine"))
                .liquid()
                .color(0x95BA83)
                .components(Carbon, 2, Hydrogen, 5, Nitrogen, 1, Oxygen, 2)
                .build()
                .setFormula("NH2CH2COOH", true);

        //  13149 Ferrocene
        Ferrocene = new Material.Builder(getID(), gregtechId("ferrocene"))
                .liquid()
                .color(0x4D3B61)
                .components(Carbon, 10, Hydrogen, 10, Iron, 1)
                .build();

        //  13150 Trifluoromethanesulfonic acid
        TrifluoromethanesulfonicAcid = new Material.Builder(getID(), gregtechId("trifluoromethanesulfonic_acid"))
                .liquid(new FluidBuilder().attributes(FluidAttributes.ACID))
                .color(0x852043)
                .components(Hydrogen, 1, Oxygen, 3, Sulfur, 1, Carbon, 1, Fluorine, 3)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("HOSO2CF3", true);

        //  13151 Calcium Trifluoromethansulphonate
        CalciumTrifluoromethansulphonate = new Material.Builder(getID(), gregtechId("calcium_trifluoromethansulphonate"))
                .liquid()
                .color(TrifluoromethanesulfonicAcid.getMaterialRGB() + Calcium.getMaterialRGB())
                .components(Calcium, 1, Oxygen, 6, Sulfur, 2, Carbon, 2, Fluorine, 6)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("Ca(OSO2CF3)2", true);

        //  13152 Lithium Trifluoromethansulphonate
        LithiumTrifluoromethansulphonate = new Material.Builder(getID(), gregtechId("lithium_trifluoromethansulphonate"))
                .dust()
                .color(TrifluoromethanesulfonicAcid.getMaterialRGB() + Lithium.getMaterialRGB())
                .iconSet(BRIGHT)
                .components(Lithium, 1, Oxygen, 3, Sulfur, 1, Carbon, 1, Fluorine, 3)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("LiOSO2CF3", true);

        //  13153 Viscoelastic Polyurethane
        ViscoelasticPolyurethane = new Material.Builder(getID(), gregtechId("viscoelastic_polyurethane"))
                .liquid()
                .color(0xE8F0E0)
                .iconSet(DULL)
                .components(Calcite, 1, Carbon, 19, Hydrogen, 22, Nitrogen, 2, Oxygen, 6)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("C20H22N2O9Ca?", true);

        //  13154 Polyurethane
        Polyurethane = new Material.Builder(getID(), gregtechId("polyurethane"))
                .polymer()
                .liquid()
                .color(0xEDF5E4)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE, GENERATE_FOIL)
                .components(Carbon, 17, Hydrogen, 16, Nitrogen, 2, Oxygen, 4)
                .build();

        //  13155 Toluene Diisocyanate
        TolueneDiisocyanate = new Material.Builder(getID(), gregtechId("toluene_diisocyanate"))
                .liquid()
                .color(0xC8EBA4)
                .components(Carbon, 9, Hydrogen, 6, Nitrogen, 2, Oxygen, 2)
                .build();

        //  13156 Azafullerene
        Azafullerene = new Material.Builder(getID(), gregtechId("azafullerene"))
                .liquid()
                .color(0xAB94AA)
                .components(Carbon, 60, Hydrogen, 12, Nitrogen, 12)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  13157 Aminated Fullerene
        AminatedFullerene = new Material.Builder(getID(), gregtechId("aminated_fullerene"))
                .liquid()
                .color(0xAB6FA8)
                .components(Carbon, 60, Hydrogen, 12, Nitrogen, 12)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  13158 Tertbutylcarbonylazide
        Tertbutylcarbonylazide = new Material.Builder(getID(), gregtechId("Tertbutylcarbonylazide"))
                .liquid()
                .color(0x6E9A7F)
                .components(Carbon, 5, Hydrogen, 9, Nitrogen, 3, Oxygen, 2)
                .build();

        //  13159 Tertbutanol
        Tertbutanol = new Material.Builder(getID(), gregtechId("tertbutanol"))
                .liquid()
                .color(0x80B394)
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 1)
                .build();

        //  13160 Ditertbutyl Dicarbonate
        DitertbutylDicarbonate = new Material.Builder(getID(), gregtechId("ditertbutyl_dicarbonate"))
                .dust()
                .color(0x799A86)
                .iconSet(ROUGH)
                .components(Carbon, 10, Hydrogen, 18, Oxygen, 5)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  13161 Cyclopentadiene
        Cyclopentadiene = new Material.Builder(getID(), gregtechId("cyclopentadiene"))
                .liquid()
                .color(0x8BEB2A)
                .components(Carbon, 5, Hydrogen, 6)
                .build();

        //  13162 Lithium Cyclopentadienide
        LithiumCyclopentadienide = new Material.Builder(getID(), gregtechId("lithium_cyclopentadienide"))
                .liquid()
                .color(0x963D5F)
                .components(Carbon, 5, Hydrogen, 5, Lithium, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  13163 Californium Cyclopentadienide
        CaliforniumCyclopentadienide = new Material.Builder(getID(), gregtechId("californium_cyclopentadienide"))
                .liquid()
                .color(0x821554)
                .components(Carbon, 15, Hydrogen, 15, Californium, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  13164 Isophthaloylbisdiethylthiourea
        Isophthaloylbisdiethylthiourea = new Material.Builder(getID(), gregtechId("isophthaloylbisdiethylthiourea"))
                .liquid()
                .color(0xA2D4E1)
                .components(Carbon, 18, Hydrogen, 26, Nitrogen, 4, Oxygen, 2, Sulfur, 2)
                .build();

        //  13165 Diethylthiourea
        Diethylthiourea = new Material.Builder(getID(), gregtechId("diethylthiourea"))
                .liquid()
                .color(0x8D8EC2)
                .components(Carbon, 5, Hydrogen, 12, Nitrogen, 2, Sulfur, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("(C2H5NH)2CS", true);

        //  13166 Phenylenedioxydiacetic Acid
        PhenylenedioxydiaceticAcid = new Material.Builder(getID(), gregtechId("phenylenedioxydiacetic_acid"))
                .liquid()
                .color(0xFFBBBA)
                .components(Carbon, 10, Hydrogen, 10, Oxygen, 6)
                .build();

        //  13167 Ethylamine
        Ethylamine = new Material.Builder(getID(), gregtechId("ethylamine"))
                .liquid()
                .color(0x9E9E9E)
                .components(Carbon, 2, Hydrogen, 7, Nitrogen, 1)
                .build()
                .setFormula("C2H5NH2", true);

        //  13168 B27
        B27 = new Material.Builder(getID(), gregtechId("b_27"))
                .liquid()
                .color(0xC2B7E3)
                .components(Carbon, 142, Hydrogen, 230, Nitrogen, 36, Oxygen, 44, Sulfur, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  13169 Biotin
        Biotin = new Material.Builder(getID(), gregtechId("biotin"))
                .liquid()
                .color(0x08C74A)
                .components(Carbon, 10, Hydrogen, 16, Nitrogen, 2, Oxygen, 3, Sulfur, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  13170 Linoleic Acid
        LinoleicAcid = new Material.Builder(getID(), gregtechId("linoleic_acid"))
                .liquid()
                .color(0x919C2B)
                .components(Carbon, 18, Hydrogen, 32, Oxygen, 2)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  13171 Vitamin A
        VitaminA = new Material.Builder(getID(), gregtechId("vitamin_a"))
                .liquid()
                .color(0xAB5EC3)
                .components(Carbon, 20, Hydrogen, 30, Oxygen, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  13172 β-Ionone
        BetaIonone = new Material.Builder(getID(), gregtechId("beta_ionone"))
                .liquid()
                .color(0xC3A0B2)
                .components(Carbon, 13, Hydrogen, 20, Oxygen, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  13173 Citral
        Citral = new Material.Builder(getID(), gregtechId("citral"))
                .liquid()
                .color(0xE4E77E)
                .components(Carbon, 10, Hydrogen, 16, Oxygen, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  13174 β-Pinene
        BetaPinene = new Material.Builder(getID(), gregtechId("beta_pinene"))
                .dust()
                .color(0xFD8CFF)
                .iconSet(DULL)
                .components(Carbon, 10, Hydrogen, 16)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  13175 Propargyl Chloride
        PropargylChloride = new Material.Builder(getID(), gregtechId("propargyl_chloride"))
                .liquid()
                .color(0x156101)
                .components(Carbon, 3, Hydrogen, 3, Chlorine, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("HC2CH2Cl", true);

        //  13176 Propargyl Alcohol
        PropargylAlcohol = new Material.Builder(getID(), gregtechId("propargyl_alcohol"))
                .liquid()
                .color(0xB7AB44)
                .components(Carbon, 3, Hydrogen, 4, Oxygen, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("CHCCH2OH", true);

        //  13177 Ethanolamine
        Ethanolamine = new Material.Builder(getID(), gregtechId("ethanolamine"))
                .liquid()
                .color(0xD3DEA2)
                .components(Carbon, 2, Hydrogen, 7, Nitrogen, 1, Oxygen, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("HOCH2CH2NH2", true);

        //  13178 Methoxybenzylidene Butylaniline (MBBA)
        MBBA = new Material.Builder(getID(), gregtechId("methoxybenzylidene_butylaniline"))
                .liquid()
                .color(0xB60099)
                .components(Carbon, 18, Hydrogen, 21, Nitrogen, 1, Oxygen, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  13179 Methoxybenzaldehyde
        Methoxybenzaldehyde = new Material.Builder(getID(), gregtechId("methoxybenzaldehyde"))
                .liquid()
                .color(0x803281)
                .components(Carbon, 8, Hydrogen, 8, Oxygen, 2)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  13180 Butylaniline
        Butylaniline = new Material.Builder(getID(), gregtechId("butylaniline"))
                .liquid()
                .color(0x55BD53)
                .components(Carbon, 10, Hydrogen, 15, Nitrogen, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  13181 Iodoxybenzoic Acid
        IodoxybenzoicAcid = new Material.Builder(getID(), gregtechId("iodoxybenzoic_acid"))
                .dust()
                .color(0x533AA9)
                .iconSet(SHINY)
                .components(Carbon, 7, Hydrogen, 5, Iodine, 1, Oxygen, 4)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  13182 Trimethylchlorosilane
        Trimethylchlorosilane = new Material.Builder(getID(), gregtechId("trimethylchlorosilane"))
                .liquid()
                .color(0x702169)
                .components(Carbon, 3, Hydrogen, 9, Silicon, 1, Chlorine, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("(CH3)3SiCl", true);

        //  13183 Trimethylsilane
        Trimethylsilane = new Material.Builder(getID(), gregtechId("trimethylsilane"))
                .liquid()
                .color(0x737373)
                .components(Carbon, 3, Hydrogen, 10, Silicon, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("(CH3)3SiH", true);

        //  13184 Iodobenzoic Acid
        IodobenzoicAcid = new Material.Builder(getID(), gregtechId("iodobenzoic_acid"))
                .liquid(new FluidBuilder().attributes(FluidAttributes.ACID))
                .color(0xCDB9BC)
                .components(Carbon, 7, Hydrogen, 5, Iodine, 1, Oxygen, 2)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  13185 Tetraethylammonium Bromide
        TetraethylammoniumBromide = new Material.Builder(getID(), gregtechId("tetraethylammonium_bromide"))
                .liquid()
                .color(0x9983A4)
                .components(Carbon, 8, Hydrogen, 20, Nitrogen, 1, Bromine, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("(C2H5)4NBr", true);

        //  13186 Tetraethylammonium Nonahydriorhenidetechnetide
        TetraethylammoniumNonahydriorhenidetechnetide = new Material.Builder(getID(), gregtechId("tetraethylammonium_nonahydriorhenidetechnetide"))
                .dust()
                .color(0xDA76B6)
                .iconSet(BRIGHT)
                .components(Carbon, 8, Hydrogen, 38, Rhenium, 1, Technetium, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("(C2H5)4N(ReH9)(TcH9)", true);

        //  13187 Piranha Solution
        PiranhaSolution = new Material.Builder(getID(), gregtechId("piranha_solution"))
                .liquid()
                .color(0x5B59C7)
                .components(HydrogenPeroxide, 1, SulfuricAcid, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  13188 Phillips Chromium Catalyst
        PhillipsChromiumCatalyst = new Material.Builder(getID(), gregtechId("phillips_chromium_catalyst"))
                .dust()
                .color(0x8CA4B9)
                .iconSet(REAGENT)
                .components(SilicaGel, 1, ChromiumTrioxide, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  13189 Cobalt Acetate
        CobaltAcetate = new Material.Builder(getID(), gregtechId("cobalt_acetate"))
                .dust()
                .color(0xED915C)
                .iconSet(ROUGH)
                .components(Cobalt, 1, Carbon, 4, Hydrogen, 6, Oxygen, 4)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("Co(C2H3O2)2", true);

        //  13190 Triethylaluminum
        Triethylaluminum = new Material.Builder(getID(), gregtechId("triethylaluminum"))
                .liquid()
                .color(0x32A0AA)
                .iconSet(SHINY)
                .components(Aluminium, 2, Carbon, 12, Hydrogen, 30)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("Al2(C2H5)6", true);

        //  13191 Ziegler-Natta Catalyst
        ZieglerNattaCatalyst = new Material.Builder(getID(), gregtechId("ziegler_natta_catalyst"))
                .dust()
                .color(0xD063A4)
                .iconSet(REAGENT)
                .components(Triethylaluminum, 1, TitaniumTetrachloride, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  13192 Zirconocene Dichloride
        ZirconoceneDichloride = new Material.Builder(getID(), gregtechId("zirconocene_dichloride"))
                .dust()
                .color(0x2F9C5B)
                .iconSet(DULL)
                .components(Zirconium, 1, Carbon, 10, Hydrogen, 10, Chlorine, 2)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("Zr(C5H5)2Cl2", true);

        //  13193 Sodium Cyclopentadiene
        SodiumCyclopentadiene = new Material.Builder(getID(), gregtechId("sodium_cyclopentadiene"))
                .liquid()
                .color(0x469AD0)
                .components(Sodium, 1, Cyclopentadiene, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  13194 Methylaluminoxane
        Methylaluminoxane = new Material.Builder(getID(), gregtechId("methylaluminoxane"))
                .dust()
                .color(0x79FFC9)
                .iconSet(DULL)
                .components(Aluminium, 1, Carbon, 1, Hydrogen, 3, Oxygen, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  13195 Kaminsky Catalyst
        KaminskyCatalyst = new Material.Builder(getID(), gregtechId("kaminsky_catalyst"))
                .dust()
                .color(0xEC386A)
                .iconSet(REAGENT)
                .components(ZirconoceneDichloride, 1, Methylaluminoxane, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  13196 Teflon
        Teflon = new Material.Builder(getID(), gregtechId("teflon"))
                .liquid(new FluidBuilder().temperature(605))
                .color(0x6B2E60)
                .components(Polytetrafluoroethylene, 15, Polyethylene, 3, Carbon, 1, Sodium, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  13197 Para Toluic Acid
        ParaToluicAcid = new Material.Builder(getID(), gregtechId("para_toluic_acid"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x4FA597)
                .components(Carbon, 8, Hydrogen, 8, Oxygen, 2)
                .build();

        //  13198 Methylparatoluate
        Methylparatoluate = new Material.Builder(getID(), gregtechId("methylparatoluate"))
                .liquid()
                .color(0x76BCB0)
                .components(Carbon, 9, Hydrogen, 10, Oxygen, 2)
                .build();

        //  13199 Dimethyl Terephthalate
        DimethylTerephthalate = new Material.Builder(getID(), gregtechId("dimethyl_terephthalate"))
                .liquid()
                .color(0x05D8AF)
                .components(Carbon, 10, Hydrogen, 10, Oxygen, 4)
                .build();

        //  13200 Polyethylene Terephthalate (PET)
        PolyethyleneTerephthalate = new Material.Builder(getID(), gregtechId("polyethylene_terephthalate"))
                .polymer()
                .liquid()
                .color(0x1E5C58)
                .components(Carbon, 10, Hydrogen, 6, Oxygen, 4)
                .build();

        //  13201 Perfluorobenzene
        Perfluorobenzene = new Material.Builder(getID(), gregtechId("perfluorobenzene"))
                .liquid()
                .color(0x39733B)
                .components(Carbon, 6, Fluorine, 6)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  13202 Borane Dimethylsulfide
        BoraneDimethylsulfide = new Material.Builder(getID(), gregtechId("borane_dimethylsulfide"))
                .liquid()
                .color(Lead.getMaterialRGB() + Boron.getMaterialRGB())
                .components(Carbon, 2, Hydrogen, 9, Boron, 1, Sulfur, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  13203 Decaborane
        Decaborane = new Material.Builder(getID(), gregtechId("decaborane"))
                .dust()
                .color(0x4C994F)
                .iconSet(ROUGH)
                .components(Boron, 10, Hydrogen, 14)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  13204 Boron Trifluoride Etherate
        BoronTrifluorideEtherate = new Material.Builder(getID(), gregtechId("boron_trifluoride_etherate"))
                .liquid()
                .color(0xBF6E6E)
                .components(Boron, 1, Fluorine, 3, Carbon, 4, Hydrogen, 7, Oxygen, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("(BF3)(C2H5)2O", true);

        //  13205 Diethyl Ether
        DiethylEther = new Material.Builder(getID(), gregtechId("diethyl_ether"))
                .liquid()
                .color(0xFFA4A3)
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("(C2H5)2O", true);
    }

}
