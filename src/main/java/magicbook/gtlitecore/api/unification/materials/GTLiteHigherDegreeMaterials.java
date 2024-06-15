package magicbook.gtlitecore.api.unification.materials;

import gregtech.api.fluids.FluidBuilder;
import gregtech.api.fluids.FluidState;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.BlastProperty;
import magicbook.gtlitecore.api.annotation.MaterialIDRange;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.Deuterium;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.info.MaterialIconSet.BRIGHT;
import static gregtech.api.unification.material.info.MaterialIconSet.DULL;
import static gregtech.api.util.GTUtility.gregtechId;
import static magicbook.gtlitecore.api.GTLiteValues.addObfuscatedFormula;
import static magicbook.gtlitecore.api.GTLiteValues.formulaWithObfuscatedA;
import static magicbook.gtlitecore.api.annotation.processor.MaterialIDProvider.getID;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteMaterialIconSet.CUSTOM_MHCSM;

/**
 * High Degree Materials
 *
 * @author Magic_Sweepy
 *
 * <p>
 *     This class is a part of {@code Material} class,
 *     all material in this class is all High Energy Physics related,
 *     or it is just science-fantastic material.
 * </p>
 *
 * @since 2.8.7-beta
 */
@MaterialIDRange(startID = 15001, endID = 16000)
public class GTLiteHigherDegreeMaterials {

    public static void register() {

        //  15001 Quark Gluon Plasma
        QuarkGluonPlasma = new Material.Builder(getID(), gregtechId("quark_gluon_plasma"))
                .plasma(new FluidBuilder().temperature((int) (V[ZPM] + V[UHV])/2))
                .color(0x8DA7DC)
                .build()
                .setFormula(formulaWithObfuscatedA("§e(u2)d(c2)s(t2)bg"), true);

        //  15002 Heavy Quarks
        HeavyQuarks = new Material.Builder(getID(), gregtechId("heavy_quarks"))
                .liquid(new FluidBuilder().temperature((int) V[ZPM]))
                .color(0xA6C8D4)
                .build()
                .setFormula(formulaWithObfuscatedA("§e(u2)ds"), true);

        //  15003 Light Quarks
        LightQuarks = new Material.Builder(getID(), gregtechId("light_quarks"))
                .liquid(new FluidBuilder().temperature((int) (V[ZPM] + V[UHV])/2))
                .color(0x7E95DF)
                .build()
                .setFormula(formulaWithObfuscatedA("§e(c2)(t2)b"), true);

        //  15004 Gluons
        Gluons = new Material.Builder(getID(), gregtechId("gluons"))
                .liquid(new FluidBuilder().temperature((int) V[UHV]))
                .color(0x564983)
                .build()
                .setFormula(formulaWithObfuscatedA("§eg"), false);

        //  15005 Instantons
        Instantons = new Material.Builder(getID(), gregtechId("instantons"))
                .liquid(new FluidBuilder().temperature((int) V[UEV]))
                .color(0x80CFEC)
                .build()
                .setFormula(formulaWithObfuscatedA("§ei"), false);

        //  15006 Higgs Bosons
        HiggsBosons = new Material.Builder(getID(), gregtechId("higgs_bosons"))
                .liquid(new FluidBuilder().state(FluidState.PLASMA).temperature((int) V[UXV]).customStill())
                .build()
                .setFormula(formulaWithObfuscatedA("§eh"), false);

        //  15007 Heavy Lepton Mixture
        HeavyLepton = new Material.Builder(getID(), gregtechId("heavy_lepton"))
                .liquid(new FluidBuilder().temperature((int)(V[UIV] - V[UV])))
                .color(0xD3A9F8)
                .build()
                .setFormula(formulaWithObfuscatedA("§e(t2)u"), true);

        //  15008 Temporal Fluid
        TemporalFluid = new Material.Builder(getID(), gregtechId("temporal_fluid"))
                .liquid(new FluidBuilder().temperature((int)(V[OpV] - V[IV])).customStill())
                .build()
                .setFormula(addObfuscatedFormula(), false);

        //  15009 Cosmic Computing Mixture
        CosmicComputingMixture = new Material.Builder(getID(), gregtechId("cosmic_computing_mixture"))
                .liquid(new FluidBuilder().temperature((int)(V[OpV])).customStill())
                .components(Gluons, 8, HeavyQuarks, 8, HeavyLepton, 32, HiggsBosons, 4, TemporalFluid, 4, Instantons, 4)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula(formulaWithObfuscatedA("§eg8((u2)ds)8((t2)u)32h4?4i4"), true);

        //  15010 Heavy Quark Enriched Mixture
        HeavyQuarkEnrichedMixture = new Material.Builder(getID(), gregtechId("heavy_quark_enriched_mixture"))
                .liquid(new FluidBuilder().temperature((int) ((V[ZPM] * 4 + V[UHV])/2)))
                .color(HeavyQuarks.getMaterialRGB() + LightQuarks.getMaterialRGB())
                .components(LightQuarks, 1, HeavyQuarks, 3)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .build()
                .setFormula(formulaWithObfuscatedA("§e(u2)d(c2)s(t2)b"), true);

        //  15011 Deuterium-Superheavy Mixture
        DeuteriumSuperheavyMixture = new Material.Builder(getID(), gregtechId("deuterium_superheavy_mixture"))
                .liquid(new FluidBuilder().temperature((int) (V[ZPM] * V[MV])/2))
                .color(0x7B9F8E)
                .components(Deuterium, 2, MetastableHassium, 1, MetastableFlerovium, 1, MetastableOganesson, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  15012 Heavy Quark Degenerate Matter
        HeavyQuarkDegenerateMatter = new Material.Builder(getID(), gregtechId("heavy_quark_degenerate_matter"))
                .ingot()
                .liquid(new FluidBuilder().temperature((int) (V[UV] + V[HV] * V[HV])))
                .plasma(new FluidBuilder().temperature((int) (V[UV] * V[HV])))
                .color(0x5DBD3A)
                .iconSet(BRIGHT)
                .blast(b -> b
                        .temp(14960, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UIV]))
                .flags(DISABLE_DECOMPOSITION, GENERATE_PLATE, GENERATE_FOIL, GENERATE_FINE_WIRE, GENERATE_ROD, GENERATE_FRAME, GENERATE_DOUBLE_PLATE)
                .cableProperties(V[UXV], 576, 1024, false)
                .build()
                .setFormula(addObfuscatedFormula(), false);

        //  15013 Magneto Hydrodynamically Constrained Star Matter
        MagnetoHydrodynamicallyConstrainedStarMatter = new Material.Builder(getID(), gregtechId("magneto_hydrodynamically_constrained_star_matter"))
                .ingot()
                .liquid(new FluidBuilder().temperature(600000000))
                .iconSet(CUSTOM_MHCSM)
                .flags(NO_SMELTING, GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_RING, GENERATE_ROUND, GENERATE_BOLT_SCREW, GENERATE_FRAME, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_FOIL, GENERATE_FINE_WIRE, GENERATE_LENS)
                .build()
                .setFormula(addObfuscatedFormula(), false);

        //  15014 Raw Star Matter
        RawStarMatter = new Material.Builder(getID(), gregtechId("raw_star_matter"))
                .liquid(new FluidBuilder().temperature(600000000).customStill())
                .build()
                .setFormula(addObfuscatedFormula(), false);

        //  15015 Dense Neutron Plasma
        DenseNeutronPlasma = new Material.Builder(getID(), gregtechId("dense_neutron_plasma"))
                .plasma(new FluidBuilder().temperature(32768000))
                .build()
                .setFormula(formulaWithObfuscatedA("§en") , false);

        //  15016 High Energy Quark-Gluon Plasma
        HighEnergyQuarkGluonPlasma = new Material.Builder(getID(), gregtechId("high_energy_quark_gluon_plasma"))
                .plasma(new FluidBuilder().temperature((int) (V[UHV] + V[UIV])/2))
                .color(0x9933CC)
                .build()
                .setFormula(formulaWithObfuscatedA("§e(u2)d(c2)s(t2)bg"), true);

        //  15017 Quantumchromodynamically Confined Matter
        QuantumchromodynamicallyConfinedMatter = new Material.Builder(getID(), gregtechId("quantumchromodynamically_confined_matter"))
                .ingot()
                .liquid()
                .color(0xF0A745)
                .iconSet(BRIGHT)
                .blast(b -> b
                        .temp(16000, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UIV]))
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FOIL, GENERATE_FINE_WIRE, GENERATE_GEAR)
                .fluidPipeProperties(80000, 20000, true, true, true, true)
                .build()
                .setFormula(addObfuscatedFormula(), false);

        //  15018 Black Dwarf Matter
        BlackDwarfMatter = new Material.Builder(getID(), gregtechId("black_dwarf_matter"))
                .ingot()
                .liquid(new FluidBuilder().temperature(266000000))
                .color(0x000000)
                .iconSet(DULL)
                .blast(b -> b
                        .temp(15800, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UXV]))
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FOIL, GENERATE_FINE_WIRE, GENERATE_GEAR)
                .cableProperties(V[UXV], 128, 256, false)
                .build()
                .setFormula(addObfuscatedFormula(), false);

        //  15019 White Dwarf Matter
        WhiteDwarfMatter = new Material.Builder(getID(), gregtechId("white_dwarf_matter"))
                .ingot()
                .liquid(new FluidBuilder().temperature(288000000))
                .iconSet(BRIGHT)
                .blast(b -> b
                        .temp(15800, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UXV]))
                .flags(GENERATE_ROD, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_FINE_WIRE)
                .cableProperties(V[UXV], 256, 128, false)
                .build()
                .setFormula(addObfuscatedFormula(), false);

        //  15020 Star Core Matter
        StarCoreMatter = new Material.Builder(getID(), gregtechId("star_core_matter"))
                .plasma(new FluidBuilder().temperature(554000000))
                .color(0x592451)
                .iconSet(DULL)
                .build()
                .setFormula(addObfuscatedFormula(), false);

        //  15021 Dimensionally Transcendent Residue
        DimensionallyTranscendentResidue = new Material.Builder(getID(), gregtechId("dimensionally_transcendent_residue"))
                .liquid(new FluidBuilder().temperature(200000000).customStill())
                .build()
                .setFormula(addObfuscatedFormula(), false);

        //  15022 Superluminal Tachyon Jet
        SuperluminalTachyonJet = new Material.Builder(getID(), gregtechId("superluminal_tachyon_jet"))
                .liquid(new FluidBuilder().temperature(89340))
                .color(0x11F7C9)
                .build()
                .setFormula(addObfuscatedFormula(), false);

        //  15023 Crude Dimensionally Transcendent Catalyst
        CrudeDimensionallyTranscendentCatalyst = new Material.Builder(getID(), gregtechId("crude_dimensionally_transcendent_catalyst"))
                .liquid(new FluidBuilder().temperature(250000000).customStill())
                .build()
                .setFormula(addObfuscatedFormula(), false);

        //  24092 Prosaic Dimensionally Transcendent Catalyst
        ProsaicDimensionallyTranscendentCatalyst = new Material.Builder(getID(), gregtechId("prosaic_dimensionally_transcendent_catalyst"))
                .liquid(new FluidBuilder().temperature(500000000).customStill())
                .build()
                .setFormula(addObfuscatedFormula(), false);

        //  24093 Resplendent Dimensionally Transcendent Catalyst
        ResplendentDimensionallyTranscendentCatalyst = new Material.Builder(getID(), gregtechId("resplendent_dimensionally_transcendent_catalyst"))
                .liquid(new FluidBuilder().temperature(750000000).customStill())
                .build()
                .setFormula(addObfuscatedFormula(), false);

        //  24094 Exotic Dimensionally Transcendent Catalyst
        ExoticDimensionallyTranscendentCatalyst = new Material.Builder(getID(), gregtechId("exotic_dimensionally_transcendent_catalyst"))
                .liquid(new FluidBuilder().temperature(1000000000).customStill())
                .build()
                .setFormula(addObfuscatedFormula(), false);

        //  24095 Zenith Dimensionally Transcendent Catalyst
        ZenithDimensionallyTranscendentCatalyst = new Material.Builder(getID(), gregtechId("zenith_dimensionally_transcendent_catalyst"))
                .liquid(new FluidBuilder().temperature(2000000000).customStill())
                .build()
                .setFormula(addObfuscatedFormula(), false);

        //  24096 Spacetime Continuum
        SpacetimeContinuum = new Material.Builder(getID(), gregtechId("spacetime_continuum"))
                .polymer()
                .liquid(new FluidBuilder().temperature(1).customStill())
                .color(0x000000)
                .iconSet(BRIGHT)
                .build()
                .setFormula(addObfuscatedFormula(), false);
    }

}
