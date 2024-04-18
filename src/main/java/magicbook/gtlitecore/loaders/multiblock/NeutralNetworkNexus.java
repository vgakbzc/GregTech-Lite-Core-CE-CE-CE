package magicbook.gtlitecore.loaders.multiblock;

import gregtech.api.unification.material.Material;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.GTLiteValues.VZ;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class NeutralNetworkNexus {

    public static void init() {
        AssemblingMode();
        BreedingMode();
        HybridizingMode();
    }

    private static void AssemblingMode() {
        NanotubeRecipes();
        NanosensorRecipes();
    }

    private static void BreedingMode() {

        //  Easy Carbon Nanotube/Nanosensor recipe
        //  Used for this machine's controller recipe, maybe.
        PRECISE_ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Polybenzimidazole)
                .input(plate, Polytetrafluoroethylene, 4)
                .input(CARBON_FIBERS, 16)
                .input(dust, Carbon, 32)
                .fluidInputs(SodiumPersulfate.getFluid(L * 24))
                .fluidInputs(Iron3Chloride.getFluid(L * 24))
                .fluidInputs(Xenon.getFluid(6000))
                .fluidInputs(Lubricant.getFluid(18000))
                .output(nanotube, Carbon)
                .EUt(VA[ZPM])
                .duration(400)
                .CasingTier(2)
                .buildAndRegister();

        PRECISE_ASSEMBLER_RECIPES.recipeBuilder()
                .input(SENSOR_ZPM)
                .input(lens, NetherStar, 4)
                .input(CARBON_FIBERS, 16)
                .input(dust, Carbon, 32)
                .fluidInputs(Epoxy.getFluid(L * 24))
                .fluidInputs(SiliconeRubber.getFluid(L * 24))
                .fluidInputs(Krypton.getFluid(6000))
                .fluidInputs(Lubricant.getFluid(18000))
                .output(nanosensor, Carbon)
                .EUt(VA[ZPM])
                .duration(2)
                .CasingTier(2)
                .buildAndRegister();

        //  Basic Breeding
        createBasicBreeding(Carbon, VZ[LV], 6400, Diamond);
        createBasicBreeding(Tin,    VZ[LV], 3800, Glass);
        //createBasicBreeding(Cobalt, VZ[MV], 5300);

        //  Advanced Breeding
        createAdvancedBreeding(Silver,    VZ[HV], 3200, NetherStar);
        createAdvancedBreeding(Gold,      VZ[HV], 3600, Prasiolite);
        createAdvancedBreeding(Platinum,  VZ[HV], 3400, Glass);
        createAdvancedBreeding(Titanium,  VZ[EV], 2200, Ruby);
        createAdvancedBreeding(Tungsten,  VZ[IV], 2800, Sapphire);
        createAdvancedBreeding(Naquadah,  VZ[IV], 1800, Emerald);
        createAdvancedBreeding(Neodymium, VZ[EV], 2400, LeadZirconateTitanate);

        //  Elite Breeding
        createEliteBreeding(Graphene,         VZ[EV],  1800, NetherStar, LuTmYVO);
        createEliteBreeding(Europium,         VZ[LuV], 800 , Celestite,  PrHoYLF);
        createEliteBreeding(Americium,        VZ[ZPM], 600 , Emerald,    CeLAG);
        createEliteBreeding(Dubnium,          VZ[UV],  400 , Sapphire,   LeadZirconateTitanate);
        createEliteBreeding(NaquadahEnriched, VZ[LuV], 1400, NdYAG,      NetherStar);

        //  Ultimate Breeding
        createUltimateBreeding(Fullerene,              VZ[UV],  500 , NdYAG);
        createUltimateBreeding(CarbonNanotube,         VZ[UHV], 300 , LeadZirconateTitanate);
        createUltimateBreeding(Naquadria,              VZ[ZPM], 1000, CeLAG);
        createUltimateBreeding(Tritanium,              VZ[UV],  380 , LuTmYVO);
        createUltimateBreeding(Orichalcum,             VZ[UV],  240 , PrHoYLF);

        //  Infinite Breeding

        //  Fullerene Polymer Matrix Swarm
        NEUTRAL_NETWORK_NEXUS_BREEDING_MODE.recipeBuilder()
                .notConsumable(CHROMATIC_LENS)
                .notConsumable(QUANTUM_ANOMALY)
                .input(nanotube, FullerenePolymerMatrix)
                .input(nanosensor, FullerenePolymerMatrix)
                .input(UHASOC_CHIP, 32)
                .input(GRAPHENE_ALIGNED_CNT, 16)
                .fluidInputs(PCBCoolant.getFluid(32000))
                .fluidInputs(CarbonNanotube.getFluid(8000))
                .fluidInputs(Zylon.getFluid(L * 4))
                .output(swarm, FullerenePolymerMatrix, 4)
                .EUt(VZ[UIV])
                .duration(160)
                .tier(3)
                .buildAndRegister();

        //  White Dwarf Matter Swarm
        NEUTRAL_NETWORK_NEXUS_BREEDING_MODE.recipeBuilder()
                .notConsumable(lens, CelestialCrystal)
                .notConsumable(lens, LithiumNiobate)
                .notConsumable(QUANTUM_ANOMALY)
                .input(nanotube, WhiteDwarfMatter)
                .input(nanosensor, WhiteDwarfMatter)
                .input(UHASOC_CHIP, 64)
                .fluidInputs(PCBCoolant.getFluid(32000))
                .fluidInputs(TemporalFluid.getFluid(8000))
                .fluidInputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(L * 4))
                .output(swarm, WhiteDwarfMatter, 8)
                .EUt(VZ[OpV])
                .duration(80)
                .tier(3)
                .buildAndRegister();

        //  Black Dwarf Matter Swarm
        NEUTRAL_NETWORK_NEXUS_BREEDING_MODE.recipeBuilder()
                .notConsumable(lens, NetherStar)
                .notConsumable(lens, MagnetoResonatic)
                .notConsumable(QUANTUM_ANOMALY)
                .input(nanotube, BlackDwarfMatter)
                .input(nanosensor, BlackDwarfMatter)
                .input(UHASOC_CHIP, 64)
                .fluidInputs(PCBCoolant.getFluid(32000))
                .fluidInputs(HiggsBosons.getFluid(8000))
                .fluidInputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(L * 4))
                .output(swarm, BlackDwarfMatter, 8)
                .EUt(VZ[OpV])
                .duration(80)
                .tier(3)
                .buildAndRegister();

        //  Galaxium Swarm
        NEUTRAL_NETWORK_NEXUS_BREEDING_MODE.recipeBuilder()
                .notConsumable(CHROMATIC_LENS)
                .notConsumable(QUANTUM_ANOMALY)
                .input(nanotube, Galaxium)
                .input(nanosensor, Galaxium)
                .input(UHASOC_WAFER, 64)
                .input(DIMENSION_GAP, 4)
                .fluidInputs(PCBCoolant.getFluid(32000))
                .fluidInputs(Eternity.getFluid(8000))
                .fluidInputs(Spacetime.getFluid(L * 4))
                .output(swarm, Galaxium, 16)
                .EUt(VZ[MAX])
                .duration(40)
                .tier(3)
                .buildAndRegister();

    }

    private static void HybridizingMode() {}

    private static void NanotubeRecipes() {
        createNanotubeRecipe(Silver, VA[MV], 180);
        createNanotubeRecipe(Gold, VA[MV], 180);
        createNanotubeRecipe(Graphene, VA[EV], 340);
        createNanotubeRecipe(Fullerene, VA[UV], 880);

        //  Carbon
        for (FluidStack stack : new FluidStack[]{
                HSQ.getFluid(2000),
                KPR.getFluid(1000)}) {
            for (FluidStack substack : new FluidStack[] {
                    Polyethylene.getFluid(L * 4),
                    PolyvinylChloride.getFluid(L * 3),
                    Polytetrafluoroethylene.getFluid(L * 2),
                    Epoxy.getFluid(L),
                    ReinforcedEpoxyResin.getFluid(L / 2),
                    Polybenzimidazole.getFluid(L / 4),
                    KaptonK.getFluid(L / 6),
                    KaptonE.getFluid(L / 8),
                    Polyetheretherketone.getFluid(L / 12),
                    Kevlar.getFluid(L / 24),
                    Zylon.getFluid(L / 48),
                    FullerenePolymerMatrix.getFluid(1)
            }) {
                NEUTRAL_NETWORK_NEXUS_ASSEMBLING_MODE.recipeBuilder()
                        .input(CARBON_MESH, 4)
                        .input(CARBON_MESH, 2)
                        .fluidInputs(new FluidStack[]{stack})
                        .fluidInputs(new FluidStack[]{substack})
                        .output(nanotube, Carbon)
                        .EUt(VA[LV])
                        .duration(40)
                        .buildAndRegister();
            }
        }

        createNanotubeRecipe(CarbonNanotube, VA[UHV], 1020);
        createNanotubeRecipe(Platinum, VA[HV], 290);
        createNanotubeRecipe(Europium, VA[LuV], 600);
        createNanotubeRecipe(Titanium, VA[EV], 320);
        createNanotubeRecipe(Tungsten, VA[IV], 560);
        createNanotubeRecipe(Neodymium, VA[EV], 390);
        createNanotubeRecipe(Americium, VA[ZPM], 730);
        createNanotubeRecipe(Dubnium, VA[UV], 800);
        createNanotubeRecipe(Naquadah, VA[IV], 580);
        createNanotubeRecipe(NaquadahEnriched, VA[LuV], 640);
        createNanotubeRecipe(Naquadria, VA[ZPM], 700);
        createNanotubeRecipe(Tin, VA[LV], 30);
        createNanotubeRecipe(Tritanium, VA[ZPM], 660);
        createNanotubeRecipe(Orichalcum, VA[UV], 810);
        createNanotubeRecipe(FullerenePolymerMatrix, VA[UEV], 210);
        createNanotubeRecipe(WhiteDwarfMatter, VA[UIV], 180);
        createNanotubeRecipe(BlackDwarfMatter, VA[UIV], 180);
        createNanotubeRecipe(Galaxium, VA[UXV], 120);
    }

    private static void NanosensorRecipes() {
        createNanosensorRecipe(Silver, VA[MV], 180);
        createNanosensorRecipe(Gold, VA[MV], 180);
        createNanosensorRecipe(Graphene, VA[EV], 340);
        createNanosensorRecipe(Fullerene, VA[UV], 880);

        //  Carbon
        for (FluidStack stack : new FluidStack[] {
                SodiumPersulfate.getFluid(8000),
                Iron3Chloride.getFluid(4000),
                TetramethylammoniumHydroxide.getFluid(2000),
                EDP.getFluid(500)
        }) {
            for (FluidStack substack : new FluidStack[] {
                    Helium.getFluid(L * 8),
                    Neon.getFluid(L * 4),
                    Argon.getFluid(L * 2),
                    Krypton.getFluid(L),
                    Xenon.getFluid(L / 2),
                    Radon.getFluid(L / 4),
                    MetastableOganesson.getFluid(L / 8)
            }) {
                for (FluidStack substack2 : new FluidStack[] {
                        Water.getFluid(1000),
                        DistilledWater.getFluid(500),
                        Lubricant.getFluid(250)
                }) {
                    NEUTRAL_NETWORK_NEXUS_ASSEMBLING_MODE.recipeBuilder()
                            .input(lens, Glass)
                            .input(CARBON_FIBERS, 8)
                            .fluidInputs(new FluidStack[]{stack})
                            .fluidInputs(new FluidStack[]{substack})
                            .fluidInputs(new FluidStack[]{substack2})
                            .output(nanosensor, Carbon)
                            .EUt(VA[IV])
                            .duration(200)
                            .buildAndRegister();
                }
            }
        }

        createNanosensorRecipe(CarbonNanotube, VA[UHV], 1020);
        createNanosensorRecipe(Platinum, VA[HV], 290);
        createNanosensorRecipe(Europium, VA[LuV], 600);
        createNanosensorRecipe(Titanium, VA[EV], 320);
        createNanosensorRecipe(Tungsten, VA[IV], 560);
        createNanosensorRecipe(Neodymium, VA[EV], 390);
        createNanosensorRecipe(Americium, VA[ZPM], 730);
        createNanosensorRecipe(Dubnium, VA[UV], 800);
        createNanosensorRecipe(Naquadah, VA[IV], 580);
        createNanosensorRecipe(NaquadahEnriched, VA[LuV], 640);
        createNanosensorRecipe(Naquadria, VA[ZPM], 700);
        createNanosensorRecipe(Tin, VA[LV], 30);
        createNanosensorRecipe(Tritanium, VA[ZPM], 660);
        createNanosensorRecipe(Orichalcum, VA[UV], 810);
        createNanosensorRecipe(FullerenePolymerMatrix, VA[UEV], 210);
        createNanosensorRecipe(WhiteDwarfMatter, VA[UIV], 180);
        createNanosensorRecipe(BlackDwarfMatter, VA[UIV], 180);
        createNanosensorRecipe(Galaxium, VA[UXV], 120);
    }

    private static void createBasicBreeding(Material material,
                                            int consumeEnergy,
                                            int duration,
                                            Material lensMaterial) {
        NEUTRAL_NETWORK_NEXUS_BREEDING_MODE.recipeBuilder()
                .notConsumable(lens, lensMaterial)
                .input(nanotube, material)
                .input(nanosensor, material)
                .input(SIMPLE_SYSTEM_ON_CHIP, 8)
                .input(dust, Carbon, 4)
                .fluidInputs(PCBCoolant.getFluid(2000))
                .output(swarm, material)
                .EUt(consumeEnergy)
                .duration(duration)
                .tier(1)
                .buildAndRegister();
    }

    private static void createAdvancedBreeding(Material material,
                                               int consumeEnergy,
                                               int duration,
                                               Material lensMaterial) {
        NEUTRAL_NETWORK_NEXUS_BREEDING_MODE.recipeBuilder()
                .notConsumable(lens, lensMaterial)
                .input(nanotube, material)
                .input(nanosensor, material)
                .input(SYSTEM_ON_CHIP, 8)
                .input(dust, Carbon, 8)
                .fluidInputs(PCBCoolant.getFluid(4000))
                .output(swarm, material)
                .EUt(consumeEnergy)
                .duration(duration)
                .tier(1)
                .buildAndRegister();
    }

    private static void createEliteBreeding(Material material,
                                            int consumeEnergy,
                                            int duration,
                                            Material lensMaterial1,
                                            Material lensMaterial2) {
        NEUTRAL_NETWORK_NEXUS_BREEDING_MODE.recipeBuilder()
                .notConsumable(lens, lensMaterial1)
                .notConsumable(lens, lensMaterial2)
                .input(nanotube, material)
                .input(nanosensor, material)
                .input(ADVANCED_SYSTEM_ON_CHIP, 8)
                .input(dust, Carbon, 16)
                .fluidInputs(PCBCoolant.getFluid(8000))
                .output(swarm, material)
                .EUt(consumeEnergy)
                .duration(duration)
                .tier(2)
                .buildAndRegister();
    }

    private static void createUltimateBreeding(Material material,
                                               int consumeEnergy,
                                               int duration,
                                               Material lensMaterial) {
        NEUTRAL_NETWORK_NEXUS_BREEDING_MODE.recipeBuilder()
                .notConsumable(lens, lensMaterial)
                .notConsumable(QUANTUM_ANOMALY)
                .input(nanotube, material)
                .input(nanosensor, material)
                .input(HIGHLY_ADVANCED_SOC, 8)
                .input(dust, Carbon, 32)
                .fluidInputs(PCBCoolant.getFluid(16000))
                .output(swarm, material)
                .EUt(consumeEnergy)
                .duration(duration)
                .tier(2)
                .buildAndRegister();
    }

    private static void createNanotubeRecipe(Material material,
                                             int consumeEnergy,
                                             int duration) {
        for (FluidStack stack : new FluidStack[]{
                HSQ.getFluid(2000),
                KPR.getFluid(1000)}) {
            for (FluidStack substack : new FluidStack[] {
                    Polyethylene.getFluid(L * 4),
                    PolyvinylChloride.getFluid(L * 3),
                    Polytetrafluoroethylene.getFluid(L * 2),
                    Epoxy.getFluid(L),
                    ReinforcedEpoxyResin.getFluid(L / 2),
                    Polybenzimidazole.getFluid(L / 4),
                    KaptonK.getFluid(L / 6),
                    KaptonE.getFluid(L / 8),
                    Polyetheretherketone.getFluid(L / 12),
                    Kevlar.getFluid(L / 24),
                    Zylon.getFluid(L / 48),
                    FullerenePolymerMatrix.getFluid(1)
            }) {
                NEUTRAL_NETWORK_NEXUS_ASSEMBLING_MODE.recipeBuilder()
                        .input(plate, material, 4)
                        .input(CARBON_MESH, 2)
                        .fluidInputs(new FluidStack[]{stack})
                        .fluidInputs(new FluidStack[]{substack})
                        .output(nanotube, material)
                        .EUt(consumeEnergy)
                        .duration(duration)
                        .buildAndRegister();
            }
        }
    }

    private static void createNanosensorRecipe(Material material,
                                               int consumeEnergy,
                                               int duration) {
        for (FluidStack stack : new FluidStack[] {
                SodiumPersulfate.getFluid(8000),
                Iron3Chloride.getFluid(4000),
                TetramethylammoniumHydroxide.getFluid(2000),
                EDP.getFluid(500)
        }) {
            for (FluidStack substack : new FluidStack[] {
                    Helium.getFluid(L * 8),
                    Neon.getFluid(L * 4),
                    Argon.getFluid(L * 2),
                    Krypton.getFluid(L),
                    Xenon.getFluid(L / 2),
                    Radon.getFluid(L / 4),
                    MetastableOganesson.getFluid(L / 8)
            }) {
                for (FluidStack substack2 : new FluidStack[] {
                        Water.getFluid(1000),
                        DistilledWater.getFluid(500),
                        Lubricant.getFluid(250)
                }) {
                    NEUTRAL_NETWORK_NEXUS_ASSEMBLING_MODE.recipeBuilder()
                            .input(stick, material)
                            .input(lens, Glass)
                            .input(CARBON_FIBERS, 2)
                            .input(wireFine, material, 4)
                            .fluidInputs(new FluidStack[]{stack})
                            .fluidInputs(new FluidStack[]{substack})
                            .fluidInputs(new FluidStack[]{substack2})
                            .output(nanosensor, material)
                            .EUt(consumeEnergy)
                            .duration(duration)
                            .buildAndRegister();
                }
            }
        }
    }
}
