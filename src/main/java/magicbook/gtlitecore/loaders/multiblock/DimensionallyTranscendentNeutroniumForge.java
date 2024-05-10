package magicbook.gtlitecore.loaders.multiblock;

import gregtech.api.unification.material.Material;
import magicbook.gtlitecore.common.blocks.BlockYottaTankCell;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;

import static gregicality.multiblocks.api.unification.GCYMMaterials.TitaniumCarbide;
import static gregicality.multiblocks.api.unification.GCYMMaterials.TitaniumTungstenCarbide;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.api.unification.ore.OrePrefix.lens;
import static gregtech.common.items.MetaItems.*;
import static gregtech.common.items.MetaItems.STEM_CELLS;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.GTLiteValues.VZ;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix.swarm;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class DimensionallyTranscendentNeutroniumForge {

    public static void init() {
        TransmutationMode();
        FusionMode();
        CollisionMode();
    }

    private static void TransmutationMode() {

        /* -------------------------------- MK1 -------------------------------- */
        createTransmutationRecipes(Helium);
        createTransmutationRecipes(Calcium);
        createTransmutationRecipes(Boron);
        createTransmutationRecipes(Neon);

        /* -------------------------------- MK2 -------------------------------- */
        createTransmutationRecipes(Oxygen);
        createTransmutationRecipes(Nitrogen);
        createTransmutationRecipes(Iron);
        createTransmutationRecipes(Argon);
        createTransmutationRecipes(Tin);
        createTransmutationRecipes(Sulfur);
        createTransmutationRecipes(Zinc);
        createTransmutationRecipes(Niobium);
        createTransmutationRecipes(Titanium);
        createTransmutationRecipes(Krypton);
        createTransmutationRecipes(Adamantium);

        /* -------------------------------- MK3 -------------------------------- */
        createTransmutationRecipes(Nickel);
        createTransmutationRecipes(Americium);
        createTransmutationRecipes(Silver);
        createTransmutationRecipes(Bismuth);
        createTransmutationRecipes(Xenon);
        createTransmutationRecipes(Radon);
        createTransmutationRecipes(Vibranium);
        createTransmutationRecipes(Mithril);
        createTransmutationRecipes(Taranium);


        /* -------------------------------- MK4 -------------------------------- */
        createTransmutationRecipes(Neptunium);
        createTransmutationRecipes(Fermium);

        /* -------------------------------- MK5 -------------------------------- */
        createTransmutationRecipes(Plutonium241);
        createTransmutationRecipes(Lead);
        createTransmutationRecipes(Thorium);
        createTransmutationRecipes(Hypogen);
        createTransmutationRecipes(AstralTitanium);
        createTransmutationRecipes(CelestialTungsten);
        createTransmutationRecipes(Fatalium);
    }

    private static void FusionMode() {

        //  Crude Dimensionally Transcendent Catalyst
        PLASMA_FUSION_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(Helium.getPlasma(1000))
                .fluidInputs(Iron.getPlasma(1000))
                .fluidInputs(Calcium.getPlasma(1000))
                .fluidInputs(Niobium.getPlasma(1000))
                .fluidOutputs(CrudeDimensionallyTranscendentCatalyst.getFluid(1000))
                .EUt(VZ[OpV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  Prosaic Dimensionally Transcendent Catalyst
        PLASMA_FUSION_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .fluidInputs(Helium.getPlasma(1000))
                .fluidInputs(Iron.getPlasma(1000))
                .fluidInputs(Calcium.getPlasma(1000))
                .fluidInputs(Niobium.getPlasma(1000))
                .fluidInputs(Radon.getPlasma(1000))
                .fluidInputs(Nickel.getPlasma(1000))
                .fluidInputs(Boron.getPlasma(1000))
                .fluidInputs(Sulfur.getPlasma(1000))
                .fluidOutputs(ProsaicDimensionallyTranscendentCatalyst.getFluid(1000))
                .EUt(VZ[OpV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  Resplendent Dimensionally Transcendent Catalyst
        PLASMA_FUSION_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .fluidInputs(Helium.getPlasma(1000))
                .fluidInputs(Iron.getPlasma(1000))
                .fluidInputs(Calcium.getPlasma(1000))
                .fluidInputs(Niobium.getPlasma(1000))
                .fluidInputs(Radon.getPlasma(1000))
                .fluidInputs(Nickel.getPlasma(1000))
                .fluidInputs(Boron.getPlasma(1000))
                .fluidInputs(Sulfur.getPlasma(1000))
                .fluidInputs(Nitrogen.getPlasma(1000))
                .fluidInputs(Zinc.getPlasma(1000))
                .fluidInputs(Silver.getPlasma(1000))
                .fluidInputs(Titanium.getPlasma(1000))
                .fluidOutputs(ResplendentDimensionallyTranscendentCatalyst.getFluid(1000))
                .EUt(VZ[OpV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  Exotic Dimensionally Transcendent Catalyst
        PLASMA_FUSION_RECIPES.recipeBuilder()
                .circuitMeta(4)
                .fluidInputs(Helium.getPlasma(1000))
                .fluidInputs(Iron.getPlasma(1000))
                .fluidInputs(Calcium.getPlasma(1000))
                .fluidInputs(Niobium.getPlasma(1000))
                .fluidInputs(Radon.getPlasma(1000))
                .fluidInputs(Nickel.getPlasma(1000))
                .fluidInputs(Boron.getPlasma(1000))
                .fluidInputs(Sulfur.getPlasma(1000))
                .fluidInputs(Nitrogen.getPlasma(1000))
                .fluidInputs(Zinc.getPlasma(1000))
                .fluidInputs(Silver.getPlasma(1000))
                .fluidInputs(Titanium.getPlasma(1000))
                .fluidInputs(Americium.getPlasma(1000))
                .fluidInputs(Bismuth.getPlasma(1000))
                .fluidInputs(Oxygen.getPlasma(1000))
                .fluidInputs(Tin.getPlasma(1000))
                .fluidOutputs(ExoticDimensionallyTranscendentCatalyst.getFluid(1000))
                .EUt(VZ[OpV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  Zenith Dimensionally Transcendent Catalyst
        PLASMA_FUSION_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .fluidInputs(Helium.getPlasma(1000))
                .fluidInputs(Iron.getPlasma(1000))
                .fluidInputs(Calcium.getPlasma(1000))
                .fluidInputs(Niobium.getPlasma(1000))
                .fluidInputs(Radon.getPlasma(1000))
                .fluidInputs(Nickel.getPlasma(1000))
                .fluidInputs(Boron.getPlasma(1000))
                .fluidInputs(Sulfur.getPlasma(1000))
                .fluidInputs(Nitrogen.getPlasma(1000))
                .fluidInputs(Zinc.getPlasma(1000))
                .fluidInputs(Silver.getPlasma(1000))
                .fluidInputs(Titanium.getPlasma(1000))
                .fluidInputs(Americium.getPlasma(1000))
                .fluidInputs(Bismuth.getPlasma(1000))
                .fluidInputs(Oxygen.getPlasma(1000))
                .fluidInputs(Tin.getPlasma(1000))
                .fluidInputs(Xenon.getPlasma(1000))
                .fluidInputs(Lead.getPlasma(1000))
                .fluidInputs(Thorium.getPlasma(1000))
                .fluidInputs(Plutonium241.getPlasma(1000))
                .fluidOutputs(ZenithDimensionallyTranscendentCatalyst.getFluid(1000))
                .EUt(VZ[OpV])
                .duration(10 * SECOND)
                .buildAndRegister();
    }

    private static void CollisionMode() {

        PLASMA_COLLISION_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(Helium.getPlasma(16000))
                .output(GLUON)
                .output(PHOTON)
                .output(Z_BOSON)
                .output(W_BOSON)
                .output(HIGGS_BOSON)
                .EUt(VA[UV])
                .duration(10 * SECOND)
                .buildAndRegister();

        PLASMA_COLLISION_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .fluidInputs(Neon.getPlasma(16000))
                .output(ELECTRON)
                .output(MUON)
                .output(TAU)
                .output(ELECTRON_NEUTRINO)
                .output(MUON_NEUTRINO)
                .output(TAU_NEUTRINO)
                .EUt(VA[UV])
                .duration(10 * SECOND)
                .buildAndRegister();

        PLASMA_COLLISION_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .fluidInputs(Argon.getPlasma(16000))
                .output(UP_QUARK)
                .output(DOWN_QUARK)
                .output(CHARM_QUARK)
                .output(STRANGE_QUARK)
                .output(TOP_QUARK)
                .output(BOTTOM_QUARK)
                .EUt(VA[UV])
                .duration(10 * SECOND)
                .buildAndRegister();

        PLASMA_COLLISION_RECIPES.recipeBuilder()
                .circuitMeta(4)
                .fluidInputs(Krypton.getPlasma(16000))
                .output(GRAVITON)
                .output(ETA_MESON)
                .output(MESON)
                .output(PROTON)
                .output(NEUTRON)
                .output(HIGGS_BOSON)
                .EUt(VA[UV])
                .duration(10 * SECOND)
                .buildAndRegister();

        PLASMA_COLLISION_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .fluidInputs(Xenon.getPlasma(16000))
                .output(PROTON)
                .output(NEUTRON)
                .output(ELECTRON)
                .output(LAMBDA_BARYON)
                .output(OMEGA_BARYON)
                .EUt(VA[UV])
                .duration(10 * SECOND)
                .buildAndRegister();

        PLASMA_COLLISION_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .notConsumable(lens, MagnetoHydrodynamicallyConstrainedStarMatter)
                .notConsumable(QUANTUM_ANOMALY)
                .notConsumable(swarm, FullerenePolymerMatrix)
                .input(dust, Carbon, 64)
                .fluidInputs(Chlorine.getFluid(64000))
                .fluidInputs(Hydrogen.getFluid(64000))
                .fluidInputs(Oxygen.getPlasma(64000))
                .fluidInputs(Radon.getPlasma(16000))
                .output(dust, Glass, 64)
                .output(dust, BorosilicateGlass, 64)
                .output(dust, ErbiumDopedZBLANGlass, 64)
                .output(dust, PraseodymiumDopedZBLANGlass, 64)
                .output(dust, GSTGlass, 64)
                .fluidOutputs(Rubber.getFluid(2576000))
                .fluidOutputs(SiliconeRubber.getFluid(1288000))
                .fluidOutputs(StyreneButadieneRubber.getFluid(1288000))
                .fluidOutputs(NitrileButadieneRubber.getFluid(644000))
                .fluidOutputs(PolyPhosphonitrileFluoroRubber.getFluid(644000))
                .fluidOutputs(PolyphenyleneSulfide.getFluid(322000))
                .fluidOutputs(BPAPolycarbonate.getFluid(166000))
                .fluidOutputs(CBDOPolycarbonate.getFluid(166000))
                .fluidOutputs(PMMA.getFluid(83000))
                .EUt(VA[UXV])
                .duration(30 * SECOND)
                .buildAndRegister();

        PLASMA_COLLISION_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .notConsumable(lens, Infinity)
                .notConsumable(CHROMATIC_LENS)
                .fluidInputs(Chlorine.getFluid(64000))
                .fluidInputs(Hydrogen.getFluid(64000))
                .fluidInputs(Fluorine.getFluid(64000))
                .fluidInputs(Oxygen.getPlasma(64000))
                .fluidInputs(Lead.getPlasma(64000))
                .output(dust, Epoxy, 64)
                .output(dust, ReinforcedEpoxyResin, 64)
                .output(dust, PolystyreneSulfonate, 64)
                .output(dust, Polycaprolactam, 64)
                .output(dust, KaptonE, 64)
                .output(dust, KaptonK, 64)
                .output(dust, HSQ, 64)
                .fluidOutputs(Polyethylene.getFluid(2576000))
                .fluidOutputs(PolyvinylChloride.getFluid(1288000))
                .fluidOutputs(Polytetrafluoroethylene.getFluid(1288000))
                .fluidOutputs(Polybenzimidazole.getFluid(644000))
                .fluidOutputs(Polyetheretherketone.getFluid(644000))
                .fluidOutputs(Zylon.getFluid(322000))
                .fluidOutputs(Kevlar.getFluid(166000))
                .fluidOutputs(FullerenePolymerMatrix.getFluid(166000))
                .fluidOutputs(CosmicFabric.getFluid(83000))
                .EUt(VA[UXV])
                .duration(30 * SECOND)
                .buildAndRegister();

        PLASMA_COLLISION_RECIPES.recipeBuilder()
                .circuitMeta(8)
                .notConsumable(lens, Hypogen)
                .notConsumable(lens, CelestialCrystal)
                .input(dust, PlatinumGroupSludge, 64)
                .input(dust, PlatinumGroupSludge, 64)
                .input(dust, PlatinumGroupSludge, 64)
                .input(dust, PlatinumGroupSludge, 64)
                .input(dust, PlatinumGroupSludge, 64)
                .input(dust, PlatinumGroupSludge, 64)
                .output(dust, Gold, 64)
                .output(dust, Silver, 64)
                .output(dust, Platinum, 64)
                .output(dust, Palladium, 64)
                .output(dust, Iridium, 64)
                .output(dust, Osmium, 64)
                .output(dust, Rhodium, 64)
                .output(dust, Ruthenium, 64)
                .fluidOutputs(Ruridit.getFluid(2576000))
                .fluidOutputs(HSSS.getFluid(1288000))
                .fluidOutputs(Osmiridium.getFluid(644000))
                .fluidOutputs(RhodiumPlatedPalladium.getFluid(322000))
                .fluidOutputs(Botmium.getFluid(166000))
                .fluidOutputs(PlatinumGroupAlloy.getFluid(83000))
                .EUt(VA[UXV])
                .duration(30 * SECOND)
                .buildAndRegister();

        PLASMA_COLLISION_RECIPES.recipeBuilder()
                .circuitMeta(9)
                .notConsumable(lens, Eternity)
                .notConsumable(EMITTER_UXV)
                .input(dust, RareEarth, 64)
                .input(dust, RareEarth, 64)
                .input(dust, RareEarth, 64)
                .input(dust, RareEarth, 64)
                .input(dust, RareEarth, 64)
                .input(dust, RareEarth, 64)
                .fluidInputs(Titanium.getPlasma(64000))
                .fluidInputs(Thorium.getPlasma(64000))
                .output(dust, Lanthanum, 64)
                .output(dust, Cerium, 64)
                .output(dust, Praseodymium, 64)
                .output(dust, Neodymium, 64)
                .output(dust, Promethium, 64)
                .output(dust, Samarium, 64)
                .output(dust, Europium, 64)
                .output(dust, Gadolinium, 64)
                .output(dust, Terbium, 64)
                .fluidOutputs(SuperheavyLAlloy.getFluid(2576000))
                .fluidOutputs(LanthanumGroupLAlloy.getFluid(1288000))
                .fluidOutputs(LanthanumGroupHAlloy.getFluid(1288000))
                .fluidOutputs(ActiniumGroupLAlloy.getFluid(644000))
                .fluidOutputs(ActiniumGroupHAlloy.getFluid(644000))
                .EUt(VA[UXV])
                .duration(30 * SECOND)
                .buildAndRegister();

        PLASMA_COLLISION_RECIPES.recipeBuilder()
                .circuitMeta(10)
                .notConsumable(lens, Spacetime)
                .notConsumable(SENSOR_UXV)
                .input(dust, RareEarth, 64)
                .input(dust, RareEarth, 64)
                .input(dust, RareEarth, 64)
                .input(dust, RareEarth, 64)
                .input(dust, RareEarth, 64)
                .input(dust, RareEarth, 64)
                .fluidInputs(Boron.getPlasma(64000))
                .fluidInputs(Neptunium.getPlasma(64000))
                .output(dust, Dysprosium, 64)
                .output(dust, Holmium, 64)
                .output(dust, Erbium, 64)
                .output(dust, Thulium, 64)
                .output(dust, Ytterbium, 64)
                .output(dust, Lutetium, 64)
                .output(dust, Zirconium, 64)
                .output(dust, Hafnium, 64)
                .output(dust, Gallium, 64)
                .fluidOutputs(SuperheavyHAlloy.getFluid(2576000))
                .fluidOutputs(Titanium.getFluid(1288000))
                .fluidOutputs(Tungsten.getFluid(1288000))
                .fluidOutputs(TungstenSteel.getFluid(644000))
                .fluidOutputs(TitaniumCarbide.getFluid(644000))
                .fluidOutputs(TungstenCarbide.getFluid(322000))
                .fluidOutputs(TitaniumTungstenCarbide.getFluid(322000))
                .fluidOutputs(AstralTitanium.getFluid(166000))
                .fluidOutputs(CelestialTungsten.getFluid(166000))
                .EUt(VA[UXV])
                .duration(30 * SECOND)
                .buildAndRegister();

        PLASMA_COLLISION_RECIPES.recipeBuilder()
                .circuitMeta(11)
                .notConsumable(CHROMATIC_LENS)
                .notConsumable(ELECTRON)
                .input(dust, Naquadah, 64)
                .input(dust, Naquadah, 64)
                .input(dust, Naquadah, 64)
                .input(dust, Naquadah, 64)
                .input(dust, Naquadah, 64)
                .input(dust, Naquadah, 64)
                .fluidInputs(Hydrogen.getFluid(64000))
                .fluidInputs(Fluorine.getFluid(64000))
                .fluidInputs(Oxygen.getPlasma(64000))
                .fluidInputs(Taranium.getPlasma(64000))
                .output(dust, NaquadahEnriched, 64)
                .output(dust, Naquadria, 64)
                .output(dust, Trinium, 64)
                .output(dust, Tritanium, 64)
                .output(dust, Taranium, 64)
                .output(dust, Orichalcum, 64)
                .output(dust, Adamantium, 64)
                .output(dust, Vibranium, 64)
                .output(dust, Mithril, 64)
                .fluidOutputs(Indium.getFluid(2576000))
                .fluidOutputs(NiobiumTitanium.getFluid(1288000))
                .fluidOutputs(IndiumGalliumPhosphide.getFluid(1288000))
                .fluidOutputs(Uranium235.getFluid(644000))
                .fluidOutputs(Uranium238.getFluid(644000))
                .fluidOutputs(Plutonium239.getFluid(322000))
                .fluidOutputs(Plutonium241.getFluid(322000))
                .fluidOutputs(Curium.getFluid(166000))
                .fluidOutputs(Berkelium.getFluid(166000))
                .EUt(VA[UXV])
                .duration(30 * SECOND)
                .buildAndRegister();

        PLASMA_COLLISION_RECIPES.recipeBuilder()
                .circuitMeta(12)
                .notConsumable(HIGGS_BOSON)
                .notConsumable(GTLiteMetaBlocks.YOTTA_TANK_CELL.getItemVariant(BlockYottaTankCell.YottaTankCellTier.T10))
                .notConsumable(swarm, Neutronium)
                .input(dust, SuperheavyLAlloy, 64)
                .fluidInputs(Silver.getPlasma(64000))
                .output(dust, Bohrium, 64)
                .output(dust, Meitnerium, 64)
                .output(dust, Darmstadtium, 64)
                .output(dust, Roentgenium, 64)
                .output(dust, Copernicium, 64)
                .output(dust, MetastableHassium, 64)
                .output(dust, MetastableFlerovium, 64)
                .output(dust, MetastableOganesson, 64)
                .fluidOutputs(Californium.getFluid(2576000))
                .fluidOutputs(Einsteinium.getFluid(1288000))
                .fluidOutputs(Fermium.getFluid(1288000))
                .fluidOutputs(Mendelevium.getFluid(644000))
                .fluidOutputs(Nobelium.getFluid(644000))
                .fluidOutputs(Lawrencium.getFluid(322000))
                .fluidOutputs(Rutherfordium.getFluid(322000))
                .fluidOutputs(Dubnium.getFluid(166000))
                .fluidOutputs(Seaborgium.getFluid(166000))
                .EUt(VA[UXV])
                .duration(30 * SECOND)
                .buildAndRegister();

        PLASMA_COLLISION_RECIPES.recipeBuilder()
                .circuitMeta(13)
                .notConsumable(CHARM_QUARK)
                .notConsumable(QUANTUM_ANOMALY)
                .input(dust, SuperheavyHAlloy, 64)
                .fluidInputs(Americium.getPlasma(64000))
                .output(dust, Nihonium, 64)
                .output(dust, Livermorium, 64)
                .fluidOutputs(Tennessine.getFluid(2576000))
                .fluidOutputs(Francium.getFluid(1288000))
                .fluidOutputs(Radium.getFluid(1288000))
                .fluidOutputs(Helium.getFluid(644000))
                .fluidOutputs(Neon.getFluid(644000))
                .fluidOutputs(Argon.getFluid(322000))
                .fluidOutputs(Krypton.getFluid(322000))
                .fluidOutputs(Xenon.getFluid(166000))
                .fluidOutputs(Radon.getFluid(166000))
                .EUt(VA[UXV])
                .duration(30 * SECOND)
                .buildAndRegister();

        PLASMA_COLLISION_RECIPES.recipeBuilder()
                .circuitMeta(14)
                .notConsumable(SCINTILLATOR_CRYSTAL)
                .notConsumable(OMEGA_BARYON)
                .input(dust, Carbon, 64)
                .input(dust, Carbon, 64)
                .input(dust, Carbon, 64)
                .input(dust, Meat, 64)
                .input(dust, Meat, 64)
                .input(dust, Meat, 64)
                .output(STEM_CELLS, 64)
                .output(STEM_CELLS, 64)
                .output(STEM_CELLS, 64)
                .output(STEM_CELLS, 64)
                .output(STEM_CELLS, 64)
                .output(STEM_CELLS, 64)
                .fluidInputs(Hydrogen.getFluid(64000))
                .fluidInputs(Oxygen.getPlasma(64000))
                .fluidInputs(Calcium.getPlasma(64000))
                .fluidOutputs(Glue.getFluid(2576000))
                .fluidOutputs(Antimony.getFluid(1288000))
                .fluidOutputs(SolderingAlloy.getFluid(1288000))
                .fluidOutputs(SterileGrowthMedium.getFluid(644000))
                .fluidOutputs(RawGrowthMedium.getFluid(644000))
                .fluidOutputs(BZMedium.getFluid(322000))
                .fluidOutputs(Biotin.getFluid(322000))
                .fluidOutputs(VitaminA.getFluid(166000))
                .fluidOutputs(LinoleicAcid.getFluid(166000))
                .EUt(VA[UXV])
                .duration(30 * SECOND)
                .buildAndRegister();

    }

    private static void createTransmutationRecipes(Material material) {
        PLASMA_TRANSMUTATION_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(material.getFluid(1000))
                .fluidOutputs(material.getPlasma(1000))
                .EUt(VA[OpV])
                .duration(SECOND)
                .buildAndRegister();

        PLASMA_TRANSMUTATION_RECIPES.recipeBuilder()
                .circuitMeta(10)
                .fluidInputs(material.getFluid(10000))
                .fluidOutputs(material.getPlasma(10000))
                .EUt(VA[OpV])
                .duration(SECOND)
                .buildAndRegister();
    }
}
