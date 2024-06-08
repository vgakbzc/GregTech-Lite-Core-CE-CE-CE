package magicbook.gtlitecore.loaders.multiblock;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.unification.material.Material;
import magicbook.gtlitecore.common.blocks.BlockTransparentCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;

import static gregicality.multiblocks.api.unification.GCYMMaterials.TitaniumCarbide;
import static gregicality.multiblocks.api.unification.GCYMMaterials.TitaniumTungstenCarbide;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.FIELD_GENERATOR_UXV;
import static gregtech.common.items.MetaItems.STEM_CELLS;
import static gregtech.common.metatileentities.MetaTileEntities.HULL;
import static gregtech.common.metatileentities.MetaTileEntities.WORLD_ACCELERATOR;
import static gregtechfoodoption.GTFOMaterialHandler.Blood;
import static magicbook.gtlitecore.api.GTLiteValues.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix.swarm;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class SuprachronalNeutroniumForge {

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
        createTransmutationRecipes(DragonBlood);

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

        //  T1: Crude Dimensionally Transcendent Catalyst
        //  Needs Plasma: He, Fe, Ca, Nb
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

        //  T2: Prosaic Dimensionally Transcendent Catalyst
        //  Needs Plasma: He, Fe, Ca, Nb (T1); Rn, Ni, B, S
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

        //  T3: Resplendent Dimensionally Transcendent Catalyst
        //  Needs Plasma: He, Fe, Ca, Nb (T1); Rn, Ni, B, S (T2);
        //                N, Zn, Ag, Ti
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

        //  T4: Exotic Dimensionally Transcendent Catalyst
        //  Needs Plasma: He, Fe, Ca, Nb (T1); Rn, Ni, B, S (T2);
        //                N, Zn, Ag, Ti (T3); Am, B, O, Sn
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

        //  T5: Zenith Dimensionally Transcendent Catalyst
        //  Needs Plasma: He, Fe, Ca, Nb (T1); Rn, Ni, B, S (T2);
        //                N, Zn, Ag, Ti (T3); Am, B, O, Sn (T4);
        //                Xe, Pb, Th, Pu-241
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

        //  This mode is integration of Quantum Force Transformer, Collider,
        //  Decay Generator and Molecular Transformer, so we should add more recipes.

        //  Circuit 0: Use Helium plasma to create more Alpha particle.
        //  if set chance is always 100%, 60000 Helium plasma can create 480 Alpha particle
        //  in Decay Generator (125 per 1 work). In this recipe, you can pay 180000 Helium
        //  plasma to get 6 stack Alpha Particle (no chance output).
        PLASMA_COLLISION_RECIPES.recipeBuilder()
                .circuitMeta(0)
                .fluidInputs(Helium.getPlasma(180000))
                .output(ALPHA_PARTICLE, 64)
                .output(ALPHA_PARTICLE, 64)
                .output(ALPHA_PARTICLE, 64)
                .output(ALPHA_PARTICLE, 64)
                .output(ALPHA_PARTICLE, 64)
                .output(ALPHA_PARTICLE, 64)
                .EUt(VZ[UXV])
                .duration(5 * MINUTE)
                .buildAndRegister();

        //  Circuit 1: Gluon, Photon, Z-Boson, W-Boson, Higgs Boson
        PLASMA_COLLISION_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(ALPHA_PARTICLE, 64)
                .input(ALPHA_PARTICLE, 64)
                .input(ALPHA_PARTICLE, 64)
                .input(ALPHA_PARTICLE, 64)
                .input(ALPHA_PARTICLE, 64)
                .fluidInputs(Helium.getPlasma(720000))
                .fluidInputs(Neon.getPlasma(720000))
                .fluidInputs(Argon.getPlasma(720000))
                .fluidInputs(Krypton.getPlasma(720000))
                .fluidInputs(Xenon.getPlasma(720000))
                .output(GLUON, 64)
                .output(PHOTON, 64)
                .output(Z_BOSON, 64)
                .output(W_BOSON, 64)
                .output(HIGGS_BOSON, 64)
                .EUt(VZ[UXV])
                .duration(5 * MINUTE)
                .buildAndRegister();

        //  Circuit 2: Electron, Muon, Tau, Electron Neutrino, Muon Neutrino, Tau Neutrino
        PLASMA_COLLISION_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(ALPHA_PARTICLE, 64)
                .input(ALPHA_PARTICLE, 64)
                .input(ALPHA_PARTICLE, 64)
                .input(ALPHA_PARTICLE, 64)
                .input(ALPHA_PARTICLE, 64)
                .input(ALPHA_PARTICLE, 64)
                .fluidInputs(Calcium.getPlasma(720000))
                .fluidInputs(Iron.getPlasma(720000))
                .fluidInputs(Tin.getPlasma(720000))
                .fluidInputs(Nickel.getPlasma(720000))
                .fluidInputs(Bismuth.getPlasma(720000))
                .fluidInputs(Fermium.getPlasma(720000))
                .output(ELECTRON, 64)
                .output(MUON, 64)
                .output(TAU, 64)
                .output(ELECTRON_NEUTRINO, 64)
                .output(MUON_NEUTRINO, 64)
                .output(TAU_NEUTRINO, 64)
                .EUt(VZ[UXV])
                .duration(5 * MINUTE)
                .buildAndRegister();

        //  Circuit 3: Up Quark, Down Quark, Charm Quark, Strange Quark, Top Quark, Bottom Quark
        PLASMA_COLLISION_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .input(ALPHA_PARTICLE, 64)
                .input(ALPHA_PARTICLE, 64)
                .input(ALPHA_PARTICLE, 64)
                .input(ALPHA_PARTICLE, 64)
                .input(ALPHA_PARTICLE, 64)
                .input(ALPHA_PARTICLE, 64)
                .fluidInputs(Oxygen.getPlasma(720000))
                .fluidInputs(Nitrogen.getPlasma(720000))
                .fluidInputs(Sulfur.getPlasma(720000))
                .fluidInputs(Radon.getPlasma(720000))
                .fluidInputs(Titanium.getPlasma(720000))
                .fluidInputs(Silver.getPlasma(720000))
                .output(UP_QUARK, 64)
                .output(DOWN_QUARK, 64)
                .output(CHARM_QUARK, 64)
                .output(STRANGE_QUARK, 64)
                .output(TOP_QUARK, 64)
                .output(BOTTOM_QUARK, 64)
                .EUt(VZ[UXV])
                .duration(5 * MINUTE)
                .buildAndRegister();

        //  Circuit 4: Graviton, Eta Meson, Meson, Proton, Neutron, Higgs Boson
        PLASMA_COLLISION_RECIPES.recipeBuilder()
                .circuitMeta(4)
                .input(ALPHA_PARTICLE, 64)
                .input(ALPHA_PARTICLE, 64)
                .input(ALPHA_PARTICLE, 64)
                .input(ALPHA_PARTICLE, 64)
                .input(ALPHA_PARTICLE, 64)
                .input(ALPHA_PARTICLE, 64)
                .fluidInputs(Boron.getPlasma(720000))
                .fluidInputs(Zinc.getPlasma(720000))
                .fluidInputs(Niobium.getPlasma(720000))
                .fluidInputs(Americium.getPlasma(720000))
                .fluidInputs(Thorium.getPlasma(720000))
                .fluidInputs(Lead.getPlasma(720000))
                .output(GRAVITON, 64)
                .output(ETA_MESON, 64)
                .output(MESON, 64)
                .output(PROTON, 64)
                .output(NEUTRON, 64)
                .output(HIGGS_BOSON, 64)
                .EUt(VZ[UXV])
                .duration(5 * MINUTE)
                .buildAndRegister();

        //  Circuit 5: Proton, Neutron, Electron, Lambda Baryon, Omega Baryon
        PLASMA_COLLISION_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(ALPHA_PARTICLE, 64)
                .input(ALPHA_PARTICLE, 64)
                .input(ALPHA_PARTICLE, 64)
                .input(ALPHA_PARTICLE, 64)
                .input(ALPHA_PARTICLE, 64)
                .fluidInputs(Krypton.getPlasma(720000))
                .fluidInputs(Niobium.getPlasma(720000))
                .fluidInputs(Tin.getPlasma(720000))
                .fluidInputs(Neptunium.getPlasma(720000))
                .fluidInputs(Nitrogen.getPlasma(720000))
                .output(PROTON, 64)
                .output(NEUTRON, 64)
                .output(ELECTRON, 64)
                .output(LAMBDA_BARYON, 64)
                .output(OMEGA_BARYON, 64)
                .EUt(VZ[UXV])
                .duration(5 * MINUTE)
                .buildAndRegister();

        //  Circuit 6: Rubbers
        PLASMA_COLLISION_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .notConsumable(lens, LuTmYVO)
                .notConsumable(swarm, Fullerene)
                .input(dust, Carbon, 64)
                .input(dust, Carbon, 64)
                .input(dust, Carbon, 64)
                .input(dust, Carbon, 64)
                .input(dust, Carbon, 64)
                .input(dust, Carbon, 64)
                .fluidInputs(Chlorine.getFluid(360000))
                .fluidInputs(Hydrogen.getFluid(360000))
                .fluidInputs(Oxygen.getFluid(360000))
                .fluidInputs(CrudeDimensionallyTranscendentCatalyst.getFluid(160000))
                .fluidOutputs(SiliconeRubber.getFluid(184320))
                .fluidOutputs(NitrileButadieneRubber.getFluid(184320))
                .fluidOutputs(NitrileButadieneRubber.getFluid(184320))
                .fluidOutputs(PolyPhosphonitrileFluoroRubber.getFluid(184320))
                .fluidOutputs(PolyphenyleneSulfide.getFluid(368640))
                .fluidOutputs(Polyetheretherketone.getFluid(368640))
                .fluidOutputs(Rubber.getFluid(737280))
                .EUt(VZ[UXV])
                .duration(5 * MINUTE)
                .buildAndRegister();

        //  Circuit 7: Plastics
        PLASMA_COLLISION_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .notConsumable(QUANTUM_ANOMALY)
                .notConsumable(swarm, CarbonNanotube)
                .input(dust, Carbon, 64)
                .input(dust, Carbon, 64)
                .input(dust, Carbon, 64)
                .input(dust, Carbon, 64)
                .input(dust, Carbon, 64)
                .input(dust, Carbon, 64)
                .fluidInputs(Chlorine.getFluid(360000))
                .fluidInputs(Hydrogen.getFluid(360000))
                .fluidInputs(Oxygen.getFluid(360000))
                .fluidInputs(Fluorine.getFluid(360000))
                .fluidInputs(ResplendentDimensionallyTranscendentCatalyst.getFluid(160000))
                .fluidOutputs(Zylon.getFluid(184320))
                .fluidOutputs(Kevlar.getFluid(184320))
                .fluidOutputs(KaptonE.getFluid(184320))
                .fluidOutputs(KaptonK.getFluid(368640))
                .fluidOutputs(Polybenzimidazole.getFluid(368640))
                .fluidOutputs(FluorinatedEthylenePropylene.getFluid(368640))
                .fluidOutputs(Polytetrafluoroethylene.getFluid(368640))
                .fluidOutputs(PolyvinylChloride.getFluid(737280))
                .fluidOutputs(Polyethylene.getFluid(737280))
                .EUt(VZ[UXV])
                .duration(5 * MINUTE)
                .buildAndRegister();

        //  Circuit 8: Other Misc Plastic-related Materials
        PLASMA_COLLISION_RECIPES.recipeBuilder()
                .circuitMeta(8)
                .notConsumable(CHROMATIC_LENS)
                .notConsumable(swarm, Tritanium)
                .input(dust, Carbon, 64)
                .input(dust, Carbon, 64)
                .input(dust, Carbon, 64)
                .input(dust, Carbon, 64)
                .input(dust, Carbon, 64)
                .input(dust, Carbon, 64)
                .fluidInputs(Chlorine.getFluid(360000))
                .fluidInputs(Hydrogen.getFluid(360000))
                .fluidInputs(Oxygen.getFluid(360000))
                .fluidInputs(ProsaicDimensionallyTranscendentCatalyst.getFluid(160000))
                .fluidOutputs(Polyurethane.getFluid(184320))
                .fluidOutputs(PolychlorinatedBiphenyl.getFluid(184320))
                .fluidOutputs(Polymethylsilesquioxane.getFluid(184320))
                .fluidOutputs(PolyvinylAcetate.getFluid(368640))
                .fluidOutputs(Epoxy.getFluid(368640))
                .fluidOutputs(Polystyrene.getFluid(368640))
                .fluidOutputs(Polycaprolactam.getFluid(368640))
                .fluidOutputs(PolyvinylButyral.getFluid(737280))
                .fluidOutputs(ReinforcedEpoxyResin.getFluid(737280))
                .EUt(VZ[UXV])
                .duration(5 * MINUTE)
                .buildAndRegister();

        //  Circuit 9: Platinum Group
        PLASMA_COLLISION_RECIPES.recipeBuilder()
                .circuitMeta(9)
                .notConsumable(lens, NdYAG)
                .notConsumable(swarm, Osmium)
                .input(dust, PlatinumGroupSludge, 64)
                .input(dust, PlatinumGroupSludge, 64)
                .input(dust, PlatinumGroupSludge, 64)
                .input(dust, PlatinumGroupSludge, 64)
                .input(dust, PlatinumGroupSludge, 64)
                .input(dust, PlatinumGroupSludge, 64)
                .fluidInputs(Chlorine.getFluid(720000))
                .fluidInputs(Hydrogen.getFluid(720000))
                .fluidInputs(Oxygen.getFluid(720000))
                .fluidInputs(Nitrogen.getFluid(720000))
                .fluidInputs(ExoticDimensionallyTranscendentCatalyst.getFluid(160000))
                .output(dust, Gold, 2048)
                .output(dust, Silver, 2048)
                .output(dust, Platinum, 2048)
                .output(dust, Palladium, 2048)
                .output(dust, Iridium, 2048)
                .output(dust, Osmium, 2048)
                .output(dust, Rhodium, 2048)
                .output(dust, Ruthenium, 2048)
                .EUt(VZ[UXV])
                .duration(5 * MINUTE)
                .buildAndRegister();

        //  Circuit 10: Naquadah-Bedrock Group
        PLASMA_COLLISION_RECIPES.recipeBuilder()
                .circuitMeta(10)
                .notConsumable(lens, NetherStar)
                .notConsumable(swarm, Naquadria)
                .input(dust, Naquadah, 64)
                .input(dust, Naquadah, 64)
                .input(dust, Naquadah, 64)
                .input(dust, Naquadah, 64)
                .input(dust, Naquadah, 64)
                .input(dust, Naquadah, 64)
                .fluidInputs(Hydrogen.getFluid(720000))
                .fluidInputs(Oxygen.getFluid(720000))
                .fluidInputs(Nitrogen.getFluid(720000))
                .fluidInputs(ZenithDimensionallyTranscendentCatalyst.getFluid(160000))
                .output(dust, NaquadahEnriched, 2048)
                .output(dust, Naquadria, 2048)
                .output(dust, Trinium, 2048)
                .output(dust, Tritanium, 2048)
                .output(dust, Orichalcum, 2048)
                .output(dust, Adamantium, 2048)
                .output(dust, Vibranium, 2048)
                .output(dust, Taranium, 2048)
                .output(dust, Mithril, 2048)
                .EUt(VZ[UXV])
                .duration(5 * MINUTE)
                .buildAndRegister();

        //  Circuit 11: Lanthanum Group A
        PLASMA_COLLISION_RECIPES.recipeBuilder()
                .circuitMeta(11)
                .notConsumable(lens, NdYAG)
                .notConsumable(swarm, TungstenSteel)
                .input(dust, RareEarth, 64)
                .input(dust, RareEarth, 64)
                .input(dust, RareEarth, 64)
                .input(dust, RareEarth, 64)
                .input(dust, RareEarth, 64)
                .input(dust, RareEarth, 64)
                .fluidInputs(Chlorine.getFluid(720000))
                .fluidInputs(Hydrogen.getFluid(720000))
                .fluidInputs(Oxygen.getFluid(720000))
                .fluidInputs(ProsaicDimensionallyTranscendentCatalyst.getFluid(160000))
                .output(dust, Lanthanum, 2048)
                .output(dust, Cerium, 2048)
                .output(dust, Praseodymium, 2048)
                .output(dust, Neodymium, 2048)
                .output(dust, Promethium, 2048)
                .output(dust, Samarium, 2048)
                .output(dust, Europium, 2048)
                .output(dust, Gadolinium, 2048)
                .output(dust, Terbium, 2048)
                .EUt(VZ[UXV])
                .duration(5 * MINUTE)
                .buildAndRegister();

        //  Circuit 12: Lanthanum Group B
        PLASMA_COLLISION_RECIPES.recipeBuilder()
                .circuitMeta(12)
                .notConsumable(lens, LithiumNiobate)
                .notConsumable(swarm, TungstenCarbide)
                .input(dust, RareEarth, 64)
                .input(dust, RareEarth, 64)
                .input(dust, RareEarth, 64)
                .input(dust, RareEarth, 64)
                .input(dust, RareEarth, 64)
                .input(dust, RareEarth, 64)
                .fluidInputs(Chlorine.getFluid(720000))
                .fluidInputs(Hydrogen.getFluid(720000))
                .fluidInputs(Oxygen.getFluid(720000))
                .fluidInputs(ProsaicDimensionallyTranscendentCatalyst.getFluid(160000))
                .output(dust, Dysprosium, 2048)
                .output(dust, Holmium, 2048)
                .output(dust, Erbium, 2048)
                .output(dust, Thulium, 2048)
                .output(dust, Ytterbium, 2048)
                .output(dust, Lutetium, 2048)
                .output(dust, Scandium, 2048)
                .output(dust, Yttrium, 2048)
                .output(dust, Gallium, 2048)
                .EUt(VZ[UXV])
                .duration(5 * MINUTE)
                .buildAndRegister();

        //  Circuit 13: Actinum Group A
        PLASMA_COLLISION_RECIPES.recipeBuilder()
                .circuitMeta(13)
                .notConsumable(lens, PrHoYLF)
                .notConsumable(swarm, TitaniumCarbide)
                .input(dust, RareEarth, 64)
                .input(dust, RareEarth, 64)
                .input(dust, RareEarth, 64)
                .input(dust, RareEarth, 64)
                .input(dust, RareEarth, 64)
                .input(dust, RareEarth, 64)
                .fluidInputs(Chlorine.getFluid(720000))
                .fluidInputs(Hydrogen.getFluid(720000))
                .fluidInputs(Oxygen.getFluid(720000))
                .fluidInputs(Nitrogen.getFluid(720000))
                .fluidInputs(Fluorine.getFluid(720000))
                .fluidInputs(ExoticDimensionallyTranscendentCatalyst.getFluid(160000))
                .output(dust, Actinium, 2048)
                .output(dust, Thorium, 2048)
                .output(dust, Protactinium, 2048)
                .output(dust, Uranium235, 2048)
                .output(dust, Uranium238, 2048)
                .output(dust, Neptunium, 2048)
                .output(dust, Plutonium239, 2048)
                .output(dust, Plutonium241, 2048)
                .output(dust, Americium, 2048)
                .EUt(VZ[UXV])
                .duration(5 * MINUTE)
                .buildAndRegister();

        //  Circuit 14: Actinum Group B
        PLASMA_COLLISION_RECIPES.recipeBuilder()
                .circuitMeta(14)
                .notConsumable(CHROMATIC_LENS)
                .notConsumable(swarm, TitaniumTungstenCarbide)
                .input(dust, RareEarth, 64)
                .input(dust, RareEarth, 64)
                .input(dust, RareEarth, 64)
                .input(dust, RareEarth, 64)
                .input(dust, RareEarth, 64)
                .input(dust, RareEarth, 64)
                .fluidInputs(Chlorine.getFluid(720000))
                .fluidInputs(Hydrogen.getFluid(720000))
                .fluidInputs(Oxygen.getFluid(720000))
                .fluidInputs(Nitrogen.getFluid(720000))
                .fluidInputs(Fluorine.getFluid(720000))
                .fluidInputs(ZenithDimensionallyTranscendentCatalyst.getFluid(160000))
                .output(dust, Curium, 2048)
                .output(dust, Berkelium, 2048)
                .output(dust, Californium, 2048)
                .output(dust, Einsteinium, 2048)
                .output(dust, Fermium, 2048)
                .output(dust, Mendelevium, 2048)
                .output(dust, Nobelium, 2048)
                .output(dust, Lawrencium, 2048)
                .output(dust, Indium, 2048)
                .EUt(VZ[UXV])
                .duration(5 * MINUTE)
                .buildAndRegister();

        //  Circuit 15: Adhesive
        PLASMA_COLLISION_RECIPES.recipeBuilder()
                .circuitMeta(15)
                .notConsumable(lens, Prasiolite)
                .notConsumable(swarm, Electrum)
                .input(dust, Carbon, 64)
                .input(dust, Carbon, 64)
                .input(dust, Carbon, 64)
                .input(dust, Carbon, 64)
                .input(dust, Carbon, 64)
                .input(dust, Carbon, 64)
                .fluidInputs(Hydrogen.getFluid(720000))
                .fluidInputs(Oxygen.getFluid(720000))
                .fluidInputs(CrudeDimensionallyTranscendentCatalyst.getFluid(160000))
                .fluidOutputs(Tin.getFluid(184320))
                .fluidOutputs(Lead.getFluid(184320))
                .fluidOutputs(Antimony.getFluid(368640))
                .fluidOutputs(Glue.getFluid(737280))
                .fluidOutputs(SolderingAlloy.getFluid(737280))
                .EUt(VZ[UXV])
                .duration(5 * MINUTE)
                .buildAndRegister();

        //  Circuit 16: Biological Materials A
        //  Basic Biological Materials, the most important product is Sterile Growth Medium,
        //  in next recipe, you should use this material to product other advanced materials.
        PLASMA_COLLISION_RECIPES.recipeBuilder()
                .circuitMeta(16)
                .notConsumable(lens, Emerald)
                .notConsumable(swarm, Ruthenium)
                .input(dust, Carbon, 64)
                .input(dust, Carbon, 64)
                .input(dust, Calcium, 64)
                .input(dust, Calcium, 64)
                .input(dust, Meat, 64)
                .input(dust, Meat, 64)
                .fluidInputs(Hydrogen.getFluid(720000))
                .fluidInputs(Oxygen.getFluid(720000))
                .fluidInputs(Nitrogen.getFluid(720000))
                .fluidInputs(ProsaicDimensionallyTranscendentCatalyst.getFluid(160000))
                .output(dust, Collagen, 2048)
                .output(dust, Gelatin, 2048)
                .output(dust, Agar, 2048)
                .fluidOutputs(SterileGrowthMedium.getFluid(184320))
                .fluidOutputs(Mutagen.getFluid(184320))
                .fluidOutputs(EnrichedBacterialSludge.getFluid(184320))
                .fluidOutputs(RawGrowthMedium.getFluid(368640))
                .fluidOutputs(BacterialSludge.getFluid(368640))
                .fluidOutputs(Bacteria.getFluid(368640))
                .fluidOutputs(FermentedBiomass.getFluid(737280))
                .fluidOutputs(Biomass.getFluid(737280))
                .fluidOutputs(Turpentine.getFluid(737280))
                .EUt(VZ[UXV])
                .duration(5 * MINUTE)
                .buildAndRegister();

        //  Circuit 17: Biological Materials B
        //  Product some advanced Biological Materials like B27 and Exotic Mutagen,
        //  this recipe is enriched version of same effect recipe in Quantum Force Transformer.
        PLASMA_COLLISION_RECIPES.recipeBuilder()
                .circuitMeta(17)
                .notConsumable(lens, CeLAG)
                .notConsumable(swarm, Ruridit)
                .input(dust, Carbon, 64)
                .input(dust, Carbon, 64)
                .input(dust, Calcium, 64)
                .input(dust, Calcium, 64)
                .input(dust, Meat, 64)
                .input(dust, Meat, 64)
                .fluidInputs(Hydrogen.getFluid(720000))
                .fluidInputs(Oxygen.getFluid(720000))
                .fluidInputs(Nitrogen.getFluid(720000))
                .fluidInputs(SterileGrowthMedium.getFluid(720000))
                .fluidInputs(Mutagen.getFluid(720000))
                .fluidInputs(ExoticDimensionallyTranscendentCatalyst.getFluid(160000))
                .output(STEM_CELLS, 2048)
                .output(STEM_CELLS, 2048)
                .output(STEM_CELLS, 2048)
                .output(STEM_CELLS, 2048)
                .output(STEM_CELLS, 2048)
                .output(STEM_CELLS, 2048)
                .fluidOutputs(B27.getFluid(184320))
                .fluidOutputs(BZMedium.getFluid(184320))
                .fluidOutputs(ExoticMutagen.getFluid(184320))
                .fluidOutputs(VitaminA.getFluid(368640))
                .fluidOutputs(Ethanolamine.getFluid(368640))
                .fluidOutputs(BloodPlasma.getFluid(368640))
                .fluidOutputs(Blood.getFluid(737280))
                .fluidOutputs(LinoleicAcid.getFluid(737280))
                .fluidOutputs(Biotin.getFluid(737280))
                .EUt(VZ[UXV])
                .duration(5 * MINUTE)
                .buildAndRegister();

        //  Circuit 18: Solarium and Luna Silver
        //  Used Glowstone and Electrotine to product Solarium and Luna Silver,
        //  whichs are both components of Arcanium (if you just want them,
        //  then you should put them in Electric Blast Furnace again).
        PLASMA_COLLISION_RECIPES.recipeBuilder()
                .circuitMeta(18)
                .notConsumable(X_RAY_MIRROR)
                .notConsumable(swarm, RoseGold)
                .input(dust, Glowstone, 64)
                .input(dust, Glowstone, 64)
                .input(dust, Glowstone, 64)
                .input(dust, Electrotine, 64)
                .input(dust, Electrotine, 64)
                .input(dust, Electrotine, 64)
                .fluidInputs(StarlightLiquid.getFluid(720000))
                .fluidInputs(SuperluminalTachyonJet.getFluid(720000))
                .fluidInputs(ResplendentDimensionallyTranscendentCatalyst.getFluid(160000))
                .output(dust, Solarium, 2048)
                .output(dust, LunaSilver, 2048)
                .EUt(VZ[UXV])
                .duration(10 * MINUTE)
                .buildAndRegister();

        //  Circuit 19: Hikarium and Tairitsium
        //  Used Photon and Tau particle to product Hikarium and Tairitsium dust,
        //  but but but! Please carry dusts to Electric Blast Furnace!
        PLASMA_COLLISION_RECIPES.recipeBuilder()
                .circuitMeta(19)
                .notConsumable(lens, Eternity)
                .notConsumable(swarm, FluxedElectrum)
                .input(PHOTON, 64)
                .input(PHOTON, 64)
                .input(PHOTON, 64)
                .input(TAU, 64)
                .input(TAU, 64)
                .input(TAU, 64)
                .fluidInputs(ZenithDimensionallyTranscendentCatalyst.getFluid(160000))
                .output(dust, Hikarium, 2048)
                .output(dust, Tairitsium, 2048)
                .EUt(VZ[UXV])
                .duration(10 * MINUTE)
                .buildAndRegister();

        //  Circuit 20: Temporal Fluid, Instantons and Higgs Bosons
        //  This recipe allowed player get 3 components of CCM which product in Quantum Force Transformer
        //  with 1 times work, and you just needs to use Dragon Blood and Starlight Liquid.
        PLASMA_COLLISION_RECIPES.recipeBuilder()
                .circuitMeta(27)
                .notConsumable(FIELD_GENERATOR_UXV)
                .notConsumable(swarm, Osmiridium)
                .fluidInputs(DragonBlood.getFluid(720000))
                .fluidInputs(StarlightLiquid.getFluid(720000))
                .fluidInputs(ResplendentDimensionallyTranscendentCatalyst.getFluid(160000))
                .fluidOutputs(TemporalFluid.getFluid(184320))
                .fluidOutputs(Instantons.getFluid(184320))
                .fluidOutputs(HiggsBosons.getFluid(184320))
                .EUt(VZ[UXV])
                .duration(5 * MINUTE)
                .buildAndRegister();

        //  Circuit 21: Cosmic Computing Mixture
        //  In stellar forge recipe, 1 times work use (8000, 8000, 32000, 4000, 4000, 4000) get 60000 CCM,
        //  this recipe is 10x CCM product and has extended 2x buff.
        PLASMA_COLLISION_RECIPES.recipeBuilder()
                .circuitMeta(28)
                .notConsumable(lens, Hypogen)
                .notConsumable(CHROMATIC_LENS)
                .fluidInputs(Gluons.getFluid(80000))
                .fluidInputs(HeavyQuarks.getFluid(80000))
                .fluidInputs(HeavyLepton.getFluid(320000))
                .fluidInputs(HiggsBosons.getFluid(40000))
                .fluidInputs(TemporalFluid.getFluid(40000))
                .fluidInputs(Instantons.getFluid(40000))
                .fluidInputs(ExoticDimensionallyTranscendentCatalyst.getFluid(160000))
                .fluidOutputs(CosmicComputingMixture.getFluid(1200000))
                .EUt(VZ[UXV])
                .duration(5 * MINUTE)
                .buildAndRegister();

        //  Circuit 22:

        //  Circuit 23:

        //  Circuit 24:

        //  Circuit 25:

        //  Circuit 26:

        //  Circuit 27:

        //  Circuit 28:

        //  Circuit 29:

        //  Circuit 30:

        //  Circuit 31: Aetherium Processing
        //  Aetherium is a MAX stage Material.
        PLASMA_COLLISION_RECIPES.recipeBuilder()
                .circuitMeta(31)
                .input(plate, Edenium, 4)
                .input(plate, MagnetoHydrodynamicallyConstrainedStarMatter, 8)
                .input(plate, Hypogen, 16)
                .input(plate, Octiron, 24)
                .input(stick, Shirabon, 12)
                .input(ring, Infinity, 8)
                .input(screw, Fatalium, 24)
                .input(CHARGED_HYPERCUBE)
                .fluidInputs(ZenithDimensionallyTranscendentCatalyst.getFluid(L * 64))
                .fluidInputs(Spacetime.getFluid(L * 48))
                .fluidInputs(Eternity.getFluid(L * 16))
                .fluidOutputs(Aetherium.getFluid(L * 16))
                .EUt(VZ[MAX])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  Circuit 32: Spatially Transcendent Gravitational Lens
        //  Usage: 9 (per 9 times work).
        PLASMA_COLLISION_RECIPES.recipeBuilder()
                .circuitMeta(32)
                .input(HULL[OpV])
                .inputs(GTLiteMetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockTransparentCasing.TransparentCasingType.QUANTUM_GLASS))
                .input(lens, Spacetime)
                .input(plateDouble, CosmicNeutronium, 8)
                .input(RECURSIVELY_FOLDED_NEGATIVE_SPACE, 2)
                .input(WORLD_ACCELERATOR[7], 4)
                .input(CHARM_QUARK, 16)
                .input(wireFine, Rhugnor, 32)
                .fluidInputs(ZBLANGlass.getFluid(1280000))
                .fluidInputs(GSTGlass.getFluid(1280000))
                .fluidInputs(PMMA.getFluid(1280000))
                .fluidInputs(CBDOPolycarbonate.getFluid(1280000))
                .fluidInputs(BPAPolycarbonate.getFluid(1280000))
                .fluidInputs(BorosilicateGlass.getFluid(1280000))
                .fluidInputs(ZenithDimensionallyTranscendentCatalyst.getFluid(160000))
                .outputs(GTLiteMetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockTransparentCasing.TransparentCasingType.SPATIALLY_TRANSCENDENT_GRAVITATIONAL_LENS))
                .EUt(VZ[MAX])
                .duration(MINUTE / 2)
                .buildAndRegister();

    }

    private static void createTransmutationRecipes(Material material) {
        PLASMA_TRANSMUTATION_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(material.getFluid(1000))
                .fluidOutputs(material.getPlasma(1000))
                .EUt(VZ[OpV])
                .duration(SECOND)
                .buildAndRegister();

        PLASMA_TRANSMUTATION_RECIPES.recipeBuilder()
                .circuitMeta(10)
                .fluidInputs(material.getFluid(10000))
                .fluidOutputs(material.getPlasma(10000))
                .EUt(VZ[OpV])
                .duration(SECOND)
                .buildAndRegister();
    }
}
