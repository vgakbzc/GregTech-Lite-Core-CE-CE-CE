package magicbook.gtlitecore.loaders.multiblock;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.unification.material.Material;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.ore;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

@SuppressWarnings("rawtypes")
public class SpaceElevator {

    public static void init() {
        DrillingModule();
        MiningModule();
    }

    private static void DrillingModule() {
        //  LV Mining Drone
        createDrillingModuleFluidRecipe(1, MINING_DRONE_LV, Chlorobenzene, 44800, 1, VA[IV]);
        createDrillingModuleFluidRecipe(2, MINING_DRONE_LV, SulfuricAcid, 39200, 1, VA[IV]);
        createDrillingModuleFluidRecipe(3, MINING_DRONE_LV, Iron, 44800, 1, VA[IV]);
        createDrillingModuleFluidRecipe(4, MINING_DRONE_LV, RawOil, 7000, 1, VA[IV]);
        createDrillingModuleFluidRecipe(5, MINING_DRONE_LV, OilHeavy,89600, 1, VA[IV]);

        //  MV Mining Drone
        createDrillingModuleFluidRecipe(1, MINING_DRONE_MV, CarbonMonoxide, 224000, 1, VH[IV]);
        createDrillingModuleFluidRecipe(2, MINING_DRONE_MV, Helium, 140000, 1, VH[IV]);
        createDrillingModuleFluidRecipe(3, MINING_DRONE_MV, SaltWater, 140000, 1, VH[IV]);
        createDrillingModuleFluidRecipe(4, MINING_DRONE_MV, Helium3, 70000, 1, VH[IV]);
        createDrillingModuleFluidRecipe(5, MINING_DRONE_MV, Oxygen, 44800, 1, VH[IV]);

        //  HV Mining Drone
        createDrillingModuleFluidRecipe(1, MINING_DRONE_HV, Neon, 1600, 1, VA[LuV]);
        createDrillingModuleFluidRecipe(2, MINING_DRONE_HV, Hydrogen, 78400, 1, VA[LuV]);
        createDrillingModuleFluidRecipe(3, MINING_DRONE_HV, Nitrogen, 78400, 1, VA[LuV]);
        createDrillingModuleFluidRecipe(4, MINING_DRONE_HV, Methane, 89600, 1, VA[LuV]);
        createDrillingModuleFluidRecipe(5, MINING_DRONE_HV, Deuterium, 78400, 1, VA[LuV]);

        //  EV Mining Drone
        createDrillingModuleFluidRecipe(1, MINING_DRONE_EV, Tritium, 12000, 1, VH[LuV]);
        createDrillingModuleFluidRecipe(2, MINING_DRONE_EV, Argon, 1600, 1, VH[LuV]);
        createDrillingModuleFluidRecipe(3, MINING_DRONE_EV, Ammonia, 12000, 1, VH[LuV]);
        createDrillingModuleFluidRecipe(4, MINING_DRONE_EV, Ethylene, 89600, 1, VH[LuV]);
        createDrillingModuleFluidRecipe(5, MINING_DRONE_EV, HydrofluoricAcid, 33600, 1, VH[LuV]);

        //  IV Mining Drone
        createDrillingModuleFluidRecipe(1, MINING_DRONE_IV, Fluorine, 89600, 1, VA[ZPM]);
        createDrillingModuleFluidRecipe(2, MINING_DRONE_IV, Krypton, 800, 1, VA[ZPM]);
        createDrillingModuleFluidRecipe(3, MINING_DRONE_IV, Copper, 44800, 1, VA[ZPM]);
        createDrillingModuleFluidRecipe(4, MINING_DRONE_IV, DistilledWater, 89600, 1, VA[ZPM]);
        createDrillingModuleFluidRecipe(5, MINING_DRONE_IV, Xenon, 800, 1, VA[ZPM]);

        //  LuV Mining Drone
        createDrillingModuleFluidRecipe(1, MINING_DRONE_LuV, Bromine, 33600, 1, VH[ZPM]);
        createDrillingModuleFluidRecipe(2, MINING_DRONE_LuV, Radon, 800, 1, VH[ZPM]);
        createDrillingModuleFluidRecipe(3, MINING_DRONE_LuV, IodineSlurry, 12000, 1, VH[ZPM]);
        createDrillingModuleFluidRecipe(4, MINING_DRONE_LuV, HydrochloricAcid, 39200, 1, VH[ZPM]);
        createDrillingModuleFluidRecipe(5, MINING_DRONE_LuV, Tin, 44800, 1, VH[ZPM]);

        //  ZPM Mining Drone
        createDrillingModuleFluidRecipe(1, MINING_DRONE_ZPM, LiquidAir, 89600, 1, VA[UV]);
        createDrillingModuleFluidRecipe(2, MINING_DRONE_ZPM, Nickel, 44800, 1, VA[UV]);
        createDrillingModuleFluidRecipe(3, MINING_DRONE_ZPM, DinitrogenTetroxide, 39200, 1, VA[UV]);
        createDrillingModuleFluidRecipe(4, MINING_DRONE_ZPM, Steam, 78400, 1, VA[UV]);
        createDrillingModuleFluidRecipe(5, MINING_DRONE_ZPM, Toluene, 12000, 1, VA[UV]);

        //  UV Mining Drone
        createDrillingModuleFluidRecipe(1, MINING_DRONE_UV, LiquidNetherAir, 89600, 2, VH[UV]);
        createDrillingModuleFluidRecipe(2, MINING_DRONE_UV, Propene, 12000, 2, VH[UV]);
        createDrillingModuleFluidRecipe(3, MINING_DRONE_UV, PhosphoricAcid, 39200, 2, VH[UV]);
        createDrillingModuleFluidRecipe(4, MINING_DRONE_UV, Lead, 44800, 2, VH[UV]);
        createDrillingModuleFluidRecipe(5, MINING_DRONE_UV, Ethylbenzene, 12000, 2, VH[UV]);

        //  UHV Mining Drone
        createDrillingModuleFluidRecipe(1, MINING_DRONE_UHV, LiquidEnderAir, 89600, 3, VA[UHV]);
        createDrillingModuleFluidRecipe(2, MINING_DRONE_UHV, FluoroantimonicAcid, 39200, 3, VA[UHV]);
        createDrillingModuleFluidRecipe(3, MINING_DRONE_UHV, DragonBreath, 78400, 3, VA[UHV]);
        createDrillingModuleFluidRecipe(4, MINING_DRONE_UHV, CarbonDisulfide, 33600, 3, VA[UHV]);
        createDrillingModuleFluidRecipe(5, MINING_DRONE_UHV, Acetylene, 12000, 3, VA[UHV]);

        //  UEV Mining Drone
        createDrillingModulePlasmaRecipe(1, MINING_DRONE_UEV, StarCoreMatter, 39200, 4, VH[UHV]);
        createDrillingModuleFluidRecipe(2, MINING_DRONE_UEV, Niobium, 44800, 4, VH[UHV]);
        createDrillingModuleFluidRecipe(3, MINING_DRONE_UEV, NitrationMixture, 12000, 4, VH[UHV]);
        createDrillingModuleFluidRecipe(4, MINING_DRONE_UEV, Glowstone, 44800, 4, VH[UHV]);
        createDrillingModuleFluidRecipe(5, MINING_DRONE_UEV, Mercury, 78400, 4, VH[UHV]);

        //  UIV Mining Drone
        createDrillingModuleFluidRecipe(1, MINING_DRONE_UIV, RawStarMatter, 39200, 5, VA[UEV]);
        createDrillingModuleFluidRecipe(2, MINING_DRONE_UIV, BedrockSmoke, 44800, 5, VA[UEV]);
        createDrillingModuleFluidRecipe(3, MINING_DRONE_UIV, ConcentrateDragonBreath, 33600, 5, VA[UEV]);
        createDrillingModuleFluidRecipe(4, MINING_DRONE_UIV, AquaRegia, 12000, 5, VA[UEV]);
        createDrillingModuleFluidRecipe(5, MINING_DRONE_UIV, Indium, 78400, 5, VA[UEV]);

        //  UXV Mining Drone
        createDrillingModuleFluidRecipe(1, MINING_DRONE_UXV, CrudeExoticGas, 89600, 5, VH[UEV]);
        createDrillingModuleFluidRecipe(2, MINING_DRONE_UXV, OganessonBreedingBase, 44800, 5, VH[UEV]);
        createDrillingModuleFluidRecipe(3, MINING_DRONE_UXV, NetherStar, 33600, 5, VH[UEV]);
        createDrillingModuleFluidRecipe(4, MINING_DRONE_UXV, RareEarthChloridesSolution, 44800, 5, VH[UEV]);

        //  OpV Mining Drone
        createDrillingModuleFluidRecipe(1, MINING_DRONE_OpV, WhiteDwarfMatter, 33600, 5, VA[UIV]);
        createDrillingModuleFluidRecipe(2, MINING_DRONE_OpV, BlackDwarfMatter, 33600, 5, VA[UIV]);
        createDrillingModuleFluidRecipe(3, MINING_DRONE_OpV, DragonBlood, 12000, 5, VA[UIV]);
        createDrillingModuleFluidRecipe(4, MINING_DRONE_OpV, Bedrock, 78400, 5, VA[UIV]);

        //  MAX Mining Drone
        createDrillingModuleFluidRecipe(1, MINING_DRONE_MAX, Galaxium, 12000, 5, VH[UIV]);
    }

    private static void MiningModule() {

        //  LV Mining Drone

        //  Iron-Copper-Aluminium vein
        createMiningModuleRecipe(1, MINING_DRONE_LV,
                Iron, 8000,
                Copper, 8000,
                Gold, 6000,
                Magnetite, 9000,
                VanadiumMagnetite, 7000,
                Pyrite, 8000,
                Chalcopyrite, 9000,
                Sphalerite, 6000,
                Aluminium, 5000,
                1,
                VA[IV]);

        //  Nickel-Cobalt-Sulfur vein
        createMiningModuleRecipe(2, MINING_DRONE_LV,
                Nickel, 8000,
                Cobalt, 7000,
                Sulfur, 9000,
                Garnierite, 7000,
                Pentlandite, 6000,
                YellowLimonite,9000,
                BrownLimonite, 9000,
                BandedIron, 8000,
                Cobaltite, 6000,
                1,
                VA[IV]);

        //  Salt-Rock Salt vein
        createMiningModuleRecipe(3, MINING_DRONE_LV,
                Salt, 9000,
                RockSalt, 9000,
                Realgar, 7000,
                Zeolite, 8000,
                Asbestos, 9000,
                Lepidolite, 7000,
                Spodumene, 7000,
                Grossular, 6000,
                Gypsum, 7000,
                1,
                VA[IV]);

        //  Quartzites-Topaz vein
        createMiningModuleRecipe(4, MINING_DRONE_LV,
                Quartzite, 9000,
                NetherQuartz, 8000,
                CertusQuartz, 8000,
                Barite, 7000,
                BasalticMineralSand, 7000,
                GraniticMineralSand, 7000,
                FullersEarth, 8000,
                Topaz, 6000,
                BlueTopaz, 6000,
                1,
                VA[IV]);

        //  MV Mining Drone

        //  Lead-Silver-Copper vein
        createMiningModuleRecipe(1, MINING_DRONE_MV,
                Lead, 8000,
                Silver, 6000,
                Tin, 9000,
                Galena, 8000,
                Cassiterite, 7000,
                CassiteriteSand, 5000,
                Tetrahedrite, 8000,
                Stibnite, 6000,
                Bauxite, 7000,
                1,
                VH[IV]);

        //  Redstone-Diamond-Thorium vein
        createMiningModuleRecipe(2, MINING_DRONE_MV,
                Redstone, 8000,
                Diamond, 7000,
                Emerald, 6000,
                Ruby, 6000,
                Cinnabar, 7000,
                Coal, 9000,
                Graphite, 6000,
                Beryllium, 8000,
                Thorium, 6000,
                1,
                VH[IV]);

        //  Lapis-Electrotine vein
        createMiningModuleRecipe(3, MINING_DRONE_MV,
                Lapis, 8000,
                Sodalite, 7000,
                Kyanite, 9000,
                Lazurite, 8000,
                Calcite, 9000,
                Electrotine, 6000,
                Saltpeter, 7000,
                Diatomite, 8000,
                Alunite, 6000,
                1,
                VH[IV]);

        //  Oilsand-Magnesite vein
        createMiningModuleRecipe(4, MINING_DRONE_MV,
                Oilsands, 9000,
                Soapstone, 8000,
                Talc, 8000,
                GlauconiteSand, 7000,
                Trona, 6000,
                Magnesite, 7000,
                Olivine, 7000,
                Bentonite, 7000,
                Pollucite, 6000,
                1,
                VH[IV]);

        //  HV Mining Drone

        //  Lithium-Tungsten-Molybdenum vein
        createMiningModuleRecipe(1, MINING_DRONE_HV,
                Lithium, 9000,
                Molybdenum, 7000,
                Scheelite, 6000,
                Tungstate, 6000,
                Wulfenite, 8000,
                Molybdenite, 8000,
                Powellite, 7000,
                Chromite, 7000,
                Ilmenite, 6000,
                1,
                VA[LuV]);

        //  Neodymium-Platinum-Palladium vein
        createMiningModuleRecipe(2, MINING_DRONE_HV,
                Neodymium, 6000,
                Platinum, 7000,
                Palladium, 7000,
                Bastnasite, 8000,
                Monazite, 7000,
                Cooperite, 8000,
                Bornite, 9000,
                Tantalite, 8000,
                Pyrolusite, 8000,
                1,
                VA[LuV]);

        //  Sapphire-Amethyst vein
        createMiningModuleRecipe(3, MINING_DRONE_HV,
                Sapphire, 7000,
                Almandine, 7000,
                Pyrope, 8000,
                GreenSapphire, 7000,
                Amethyst, 9000,
                GarnetRed, 8000,
                GarnetYellow, 8000,
                GarnetYellow, 8000,
                Opal, 8000,
                1,
                VA[LuV]);

        //  Copper-Tantalum vein
        createMiningModuleRecipe(4, MINING_DRONE_HV,
                Malachite, 9000,
                Apatite, 8000,
                TricalciumPhosphate, 8000,
                Realgar, 9000,
                Grossular, 8000,
                Pyrolusite, 7000,
                Spessartine, 7000,
                Tantalite, 6000,
                Pyrochlore, 8000,
                1,
                VA[LuV]);

        //  EV Mining Drone

        //  Neodymium-Tungsten-Platinum vein
        createMiningModuleRecipe(1, MINING_DRONE_EV,
                Neodymium, 9000,
                Platinum, 8000,
                Cooperite, 7000,
                Tungstate, 8000,
                Scheelite, 7000,
                Bauxite, 8000,
                Palladium, 7000,
                Pyrochlore, 8000,
                Grossular, 8000,
                1,
                VH[LuV]);

        //  Monazite-Molybdenum vein
        createMiningModuleRecipe(2, MINING_DRONE_EV,
                Monazite, 9000,
                Bastnasite, 8000,
                Molybdenum, 7000,
                Molybdenite, 8000,
                Bornite, 7000,
                Tantalite, 8000,
                Almandine, 8000,
                Apatite, 7000,
                Ilmenite, 7000,
                1,
                VH[LuV]);

        //  Oilsand vein
        createMiningModuleRecipe(3, MINING_DRONE_EV,
                Oilsands, 8000,
                Oilsands, 8000,
                Oilsands, 8000,
                Oilsands, 8000,
                GraniticMineralSand, 7000,
                GarnetSand, 7000,
                BasalticMineralSand, 6000,
                GlauconiteSand, 9000,
                Quartzite, 7000,
                1,
                VH[LuV]);

        //  Silver-Gold-Platinum vein
        createMiningModuleRecipe(4, MINING_DRONE_EV,
                Silver, 7000,
                Silver, 7000,
                Gold, 6000,
                Gold, 6000,
                Platinum, 8000,
                Platinum, 8000,
                Lead, 9000,
                Tin, 9000,
                Cooperite, 7000,
                1,
                VH[LuV]);

        //  IV Mining Drone

        //  Naquadah-Plutonium-Uranium vein
        createMiningModuleRecipe(1, MINING_DRONE_IV,
                Naquadah, 6000,
                Naquadah, 6000,
                Naquadah, 6000,
                Plutonium239, 7000,
                Uraninite, 8000,
                Uraninite, 8000,
                Pitchblende, 8000,
                Pitchblende, 8000,
                Pyrochlore, 9000,
                1,
                VA[ZPM]);

        //  Thorium-Plutonium-Pitchblende vein
        createMiningModuleRecipe(2, MINING_DRONE_IV,
                Thorium, 8000,
                Thorium, 8000,
                Uraninite, 7000,
                Uraninite, 7000,
                Pitchblende, 9000,
                Pitchblende, 9000,
                Beryllium, 8000,
                Emerald, 8000,
                Olivine, 9000,
                1,
                VA[ZPM]);

        //  LuV Mining Drone

        //  Sylvanite-Gold-Silver vein
        createMiningModuleRecipe(1, MINING_DRONE_LuV,
                Gold, 8000,
                Gold, 8000,
                Gold, 8000,
                Gold, 8000,
                Silver, 9000,
                Silver, 9000,
                Silver, 9000,
                Sylvanite, 4000,
                Sylvanite, 4000,
                1,
                VH[ZPM]);

        //  Rhenite-Molybdenum vein
        createMiningModuleRecipe(2, MINING_DRONE_LuV,
                Molybdenite, 9000,
                Molybdenite, 9000,
                Molybdenite, 9000,
                Wulfenite, 8000,
                Wulfenite, 8000,
                Wulfenite, 8000,
                Rheniite, 7000,
                Rheniite, 7000,
                Rheniite, 7000,
                1,
                VH[ZPM]);

        //  ZPM Mining Drone

        //  Naquadah vein
        createMiningModuleRecipe(1, MINING_DRONE_ZPM,
                Naquadah, 8000,
                Naquadah, 8000,
                Naquadah, 8000,
                Naquadah, 8000,
                Naquadah, 8000,
                Naquadah, 8000,
                Naquadah, 8000,
                Naquadah, 8000,
                Naquadah, 8000,
                1,
                VA[UV]);

        //  UV Mining Drone

        //  Iridium-Ruthenium vein
        createMiningModuleRecipe(1, MINING_DRONE_UV,
                BismuthIridiate, 6000,
                BismuthIridiate, 6000,
                BismuthIridiate, 6000,
                BismuthRuthenate, 6000,
                BismuthRuthenate, 6000,
                BismuthRuthenate, 6000,
                Platinum, 9000,
                Cooperite, 8000,
                Palladium, 7000,
                1,
                VH[UV]);

        //  Platarsite-Picotite vein
        createMiningModuleRecipe(2, MINING_DRONE_UV,
                Platarsite, 7000,
                Platarsite, 7000,
                Platarsite, 7000,
                Platarsite, 7000,
                Picotite, 8000,
                Picotite, 8000,
                Picotite, 8000,
                Kyanite, 9000,
                Chromite, 9000,
                1,
                VH[UV]);

        //  UHV Mining Drone

        //  Naquadah-Trinium vein
        createMiningModuleRecipe(1, MINING_DRONE_UHV,
                Naquadah, 8000,
                Naquadah, 8000,
                Naquadah, 8000,
                Naquadah, 8000,
                Naquadah, 8000,
                Naquadah, 8000,
                TriniumTitanide, 3000,
                TriniumTitanide, 3000,
                TriniumTitanide, 3000,
                2,
                VA[UHV]);

        //  Gadolinite-Euxenite vein
        createMiningModuleRecipe(2, MINING_DRONE_UHV,
                Gadolinite, 7000,
                Gadolinite, 7000,
                Gadolinite, 7000,
                Gadolinite, 7000,
                Euxenite, 6000,
                Euxenite, 6000,
                Euxenite, 6000,
                Electrotine, 9000,
                Silver, 8000,
                2,
                VA[UHV]);

        //  UEV Mining Drone

        //  Proto Adamantium-Trinium vein
        createMiningModuleRecipe(1, MINING_DRONE_UEV,
                ProtoAdamantium, 3000,
                ProtoAdamantium, 3000,
                ProtoAdamantium, 3000,
                TriniumTitanide, 6000,
                TriniumTitanide, 6000,
                TriniumTitanide, 6000,
                BismuthIridiate, 8000,
                BismuthIridiate, 8000,
                GermaniumTungstenNitride, 9000,
                3,
                VA[UEV]);

        //  UIV Mining Drone

        //  Enriched Mithril-Proto Adamantium vein
        createMiningModuleRecipe(1, MINING_DRONE_UIV,
                EnrichedMithril, 3000,
                EnrichedMithril, 3000,
                EnrichedMithril, 3000,
                EnrichedMithril, 3000,
                ProtoAdamantium, 6000,
                ProtoAdamantium, 6000,
                ProtoAdamantium, 6000,
                ProtoAdamantium, 6000,
                TriniumTitanide, 8000,
                4,
                VH[UEV]);

        //  UXV Mining Drone

        //  OpV Mining Drone

        //  MAX Mining Drone

    }

    private static void createDrillingModuleFluidRecipe(int circuitMeta,
                                                        MetaItem.MetaValueItem drone,
                                                        Material fluidOutput,
                                                        int amount,
                                                        int casingTier,
                                                        int voltage) {
        for (FluidStack stack : new FluidStack[] {
                RocketFuel.getFluid(16000),
                RP1RocketFuel.getFluid(16000),
                DenseHydrazineMixtureFuel.getFluid(8000),
                MethylhydrazineNitrateRocketFuel.getFluid(8000)
        }) {
            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .circuitMeta(circuitMeta)
                    .notConsumable(drone.getStackForm(16))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(fluidOutput.getFluid(amount))
                    .EUt(voltage)
                    .duration(20)
                    .CasingTier(casingTier)
                    .buildAndRegister();
        }
    }

    private static void createDrillingModulePlasmaRecipe(int circuitMeta,
                                                         MetaItem.MetaValueItem drone,
                                                         Material fluidOutput,
                                                         int amount,
                                                         int casingTier,
                                                         int voltage) {
        for (FluidStack stack : new FluidStack[] {
                RocketFuel.getFluid(16000),
                RP1RocketFuel.getFluid(16000),
                DenseHydrazineMixtureFuel.getFluid(8000),
                MethylhydrazineNitrateRocketFuel.getFluid(8000)
        }) {
            SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
                    .circuitMeta(circuitMeta)
                    .notConsumable(drone.getStackForm(16))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(fluidOutput.getPlasma(amount))
                    .EUt(voltage)
                    .duration(20)
                    .CasingTier(casingTier)
                    .buildAndRegister();
        }
    }

    private static void createMiningModuleRecipe(int circuitMeta,
                                                 MetaItem.MetaValueItem drone,
                                                 Material ore1,
                                                 int chanceOre1,
                                                 Material ore2,
                                                 int chanceOre2,
                                                 Material ore3,
                                                 int chanceOre3,
                                                 Material ore4,
                                                 int chanceOre4,
                                                 Material ore5,
                                                 int chanceOre5,
                                                 Material ore6,
                                                 int chanceOre6,
                                                 Material ore7,
                                                 int chanceOre7,
                                                 Material ore8,
                                                 int chanceOre8,
                                                 Material ore9,
                                                 int chanceOre9,
                                                 int casingTier,
                                                 int voltage) {
        //  x1
        for (FluidStack stack : new FluidStack[] {
                RocketFuel.getFluid(32000),
                RP1RocketFuel.getFluid(32000)
        }) {
            SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                    .circuitMeta(circuitMeta)
                    .notConsumable(drone.getStackForm(16))
                    .fluidInputs(new FluidStack[]{stack})
                    .chancedOutput(ore, ore1, 256, chanceOre1, 500)
                    .chancedOutput(ore, ore2, 256, chanceOre2, 500)
                    .chancedOutput(ore, ore3, 256, chanceOre3, 500)
                    .chancedOutput(ore, ore4, 256, chanceOre4, 500)
                    .chancedOutput(ore, ore5, 256, chanceOre5, 500)
                    .chancedOutput(ore, ore6, 256, chanceOre6, 500)
                    .chancedOutput(ore, ore7, 256, chanceOre7, 500)
                    .chancedOutput(ore, ore8, 256, chanceOre8, 500)
                    .chancedOutput(ore, ore9, 256, chanceOre9, 500)
                    .EUt(voltage)
                    .duration(400)
                    .CasingTier(casingTier)
                    .buildAndRegister();
        }

        for (FluidStack stack : new FluidStack[] {
                DenseHydrazineMixtureFuel.getFluid(32000),
                MethylhydrazineNitrateRocketFuel.getFluid(32000)
        }) {
            SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                    .circuitMeta(circuitMeta)
                    .notConsumable(drone.getStackForm(16))
                    .fluidInputs(new FluidStack[]{stack})
                    .chancedOutput(ore, ore1, 256, chanceOre1, 500)
                    .chancedOutput(ore, ore2, 256, chanceOre2, 500)
                    .chancedOutput(ore, ore3, 256, chanceOre3, 500)
                    .chancedOutput(ore, ore4, 256, chanceOre4, 500)
                    .chancedOutput(ore, ore5, 256, chanceOre5, 500)
                    .chancedOutput(ore, ore6, 256, chanceOre6, 500)
                    .chancedOutput(ore, ore7, 256, chanceOre7, 500)
                    .chancedOutput(ore, ore8, 256, chanceOre8, 500)
                    .chancedOutput(ore, ore9, 256, chanceOre9, 500)
                    .EUt(voltage)
                    .duration(200)
                    .CasingTier(casingTier)
                    .buildAndRegister();
        }

        //  x2
        for (FluidStack stack : new FluidStack[] {
                RocketFuel.getFluid(64000),
                RP1RocketFuel.getFluid(64000)
        }) {
            SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                    .circuitMeta(circuitMeta + 5)
                    .notConsumable(drone.getStackForm(32))
                    .fluidInputs(new FluidStack[]{stack})
                    .chancedOutput(ore, ore1, 512, chanceOre1, 500)
                    .chancedOutput(ore, ore2, 512, chanceOre2, 500)
                    .chancedOutput(ore, ore3, 512, chanceOre3, 500)
                    .chancedOutput(ore, ore4, 512, chanceOre4, 500)
                    .chancedOutput(ore, ore5, 512, chanceOre5, 500)
                    .chancedOutput(ore, ore6, 512, chanceOre6, 500)
                    .chancedOutput(ore, ore7, 512, chanceOre7, 500)
                    .chancedOutput(ore, ore8, 512, chanceOre8, 500)
                    .chancedOutput(ore, ore9, 512, chanceOre9, 500)
                    .EUt(voltage)
                    .duration(400)
                    .CasingTier(casingTier)
                    .buildAndRegister();
        }

        for (FluidStack stack : new FluidStack[] {
                DenseHydrazineMixtureFuel.getFluid(64000),
                MethylhydrazineNitrateRocketFuel.getFluid(64000)
        }) {
            SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                    .circuitMeta(circuitMeta + 5)
                    .notConsumable(drone.getStackForm(32))
                    .fluidInputs(new FluidStack[]{stack})
                    .chancedOutput(ore, ore1, 512, chanceOre1, 500)
                    .chancedOutput(ore, ore2, 512, chanceOre2, 500)
                    .chancedOutput(ore, ore3, 512, chanceOre3, 500)
                    .chancedOutput(ore, ore4, 512, chanceOre4, 500)
                    .chancedOutput(ore, ore5, 512, chanceOre5, 500)
                    .chancedOutput(ore, ore6, 512, chanceOre6, 500)
                    .chancedOutput(ore, ore7, 512, chanceOre7, 500)
                    .chancedOutput(ore, ore8, 512, chanceOre8, 500)
                    .chancedOutput(ore, ore9, 512, chanceOre9, 500)
                    .EUt(voltage)
                    .duration(200)
                    .CasingTier(casingTier)
                    .buildAndRegister();
        }

        //  x4
        for (FluidStack stack : new FluidStack[] {
                RocketFuel.getFluid(128000),
                RP1RocketFuel.getFluid(128000)
        }) {
            SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                    .circuitMeta(circuitMeta + 10)
                    .notConsumable(drone.getStackForm(64))
                    .fluidInputs(new FluidStack[]{stack})
                    .chancedOutput(ore, ore1, 1024, chanceOre1, 500)
                    .chancedOutput(ore, ore2, 1024, chanceOre2, 500)
                    .chancedOutput(ore, ore3, 1024, chanceOre3, 500)
                    .chancedOutput(ore, ore4, 1024, chanceOre4, 500)
                    .chancedOutput(ore, ore5, 1024, chanceOre5, 500)
                    .chancedOutput(ore, ore6, 1024, chanceOre6, 500)
                    .chancedOutput(ore, ore7, 1024, chanceOre7, 500)
                    .chancedOutput(ore, ore8, 1024, chanceOre8, 500)
                    .chancedOutput(ore, ore9, 1024, chanceOre9, 500)
                    .EUt(voltage)
                    .duration(400)
                    .CasingTier(casingTier)
                    .buildAndRegister();
        }

        for (FluidStack stack : new FluidStack[] {
                DenseHydrazineMixtureFuel.getFluid(128000),
                MethylhydrazineNitrateRocketFuel.getFluid(128000)
        }) {
            SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
                    .circuitMeta(circuitMeta + 10)
                    .notConsumable(drone.getStackForm(64))
                    .fluidInputs(new FluidStack[]{stack})
                    .chancedOutput(ore, ore1, 1024, chanceOre1, 500)
                    .chancedOutput(ore, ore2, 1024, chanceOre2, 500)
                    .chancedOutput(ore, ore3, 1024, chanceOre3, 500)
                    .chancedOutput(ore, ore4, 1024, chanceOre4, 500)
                    .chancedOutput(ore, ore5, 1024, chanceOre5, 500)
                    .chancedOutput(ore, ore6, 1024, chanceOre6, 500)
                    .chancedOutput(ore, ore7, 1024, chanceOre7, 500)
                    .chancedOutput(ore, ore8, 1024, chanceOre8, 500)
                    .chancedOutput(ore, ore9, 1024, chanceOre9, 500)
                    .EUt(voltage)
                    .duration(200)
                    .CasingTier(casingTier)
                    .buildAndRegister();
        }
    }
}
