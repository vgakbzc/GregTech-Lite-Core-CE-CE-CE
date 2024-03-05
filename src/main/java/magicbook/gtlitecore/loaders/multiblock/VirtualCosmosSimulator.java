package magicbook.gtlitecore.loaders.multiblock;

import gregtech.api.metatileentity.multiblock.CleanroomType;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.CANNER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class VirtualCosmosSimulator {

    public static void init() {
        MemoryCards();
        Recipes();
    }

    private static void MemoryCards() {
        //  Cosmic Memory Card
        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .input(MEMORY_CARD_BASE)
                .input(plate, Neutronium)
                .input(spring, Hypogen)
                .input(wireFine, TransitionHAlloy, 4)
                .fluidInputs(CosmicComputingMixture.getFluid(L))
                .output(COSMIC_MEMORY_CARD)
                .EUt(VA[UXV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Overworld
        CANNER_RECIPES.recipeBuilder()
                .input(COSMIC_MEMORY_CARD)
                .fluidInputs(Air.getFluid(1000))
                .output(COSMIC_MEMORY_CARD_OVERWORLD)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        //  Nether
        CANNER_RECIPES.recipeBuilder()
                .input(COSMIC_MEMORY_CARD)
                .fluidInputs(NetherAir.getFluid(1000))
                .output(COSMIC_MEMORY_CARD_NETHER)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        //  End
        CANNER_RECIPES.recipeBuilder()
                .input(COSMIC_MEMORY_CARD)
                .fluidInputs(EnderAir.getFluid(1000))
                .output(COSMIC_MEMORY_CARD_END)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();
    }

    private static void Recipes() {
        //  TODO Rebalance
        //  This machine should has three modes: Drone Mining Mode, Cosmic Memory Card Mode, Universal Devourer Mode...
        //  This machine has 81 slot inputs and 18 slot outputs, so we can do many things!
        //  Should this machine has Generator Mode?

        //  WARNING TODO This recipes is just in testing, so maybe too imba...

        //  Overworld
        VIRTUAL_COSMOS_SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(COSMIC_MEMORY_CARD_OVERWORLD)
                .output(dust, Stone, 240891153)
                .output(dust, Iron, 14904458)
                .output(dust, Redstone, 8577758)
                .output(dust, Coal, 7946767)
                .output(dust, Tin, 6069951)
                .output(dust, Copper, 4601556)
                .output(dust, Apatite, 4394273)
                .output(dust, Charcoal, 3951050)
                .output(dust, Gold, 2754785)
                .output(dust, Lazurite, 2334718)
                .output(dust, Sodalite, 2299106)
                .output(dust, Zinc, 2247413)
                .output(dust, Lapis, 2217594)
                .output(dust, Nickel, 1698365)
                .output(dust, Silver, 1553258)
                .output(dust, Salt, 1005473)
                .output(dust, RockSalt, 1005473)
                .output(dust, Cobalt, 950388)
                .output(dust, Oilsands, 818526)
                .output(dust, Graphite, 769969)
                .output(dust, Rheniite, 727578)
                .output(dust, GarnetSand, 727578)
                .output(dust, Zeolite, 545684)
                .output(dust, GarnetRed, 545684)
                .output(dust, TricalciumPhosphate, 445136)
                .output(dust, Thorium, 404153)
                .output(dust, Wollastonite, 363789)
                .output(dust, Soapstone, 363789)
                .output(dust, VanadiumMagnetite, 363789)
                .output(dust, Talc, 363789)
                .output(dust, GarnetYellow, 363789)
                .output(dust, Lead, 327910)
                .output(dust, Gallium, 207101)
                .output(dust, Sulfur, 204415)
                .output(dust, Diamond, 200799)
                .output(dust, Ruby, 199578)
                .output(dust, RareEarth, 190296)
                .output(dust, Pyrochlore, 184168)
                .output(dust, Grossular, 181894)
                .output(dust, Spessartine, 181894)
                .output(dust, Mica, 181894)
                .output(dust, Kyanite, 181894)
                .output(dust, Glowstone, 178088)
                .output(dust, FullersEarth, 159157)
                .output(dust, Basalt, 153600)
                .output(dust, Carbon, 153600)
                .output(dust, GraniteBlack, 153600)
                .output(dust, Cadmium, 145515)
                .output(dust, Alumina, 141600)
                .output(dust, GraniteRed, 128842)
                .output(dust, Phosphate, 128842)
                .output(dust, Asbestos, 110147)
                .output(dust, Borax, 101052)
                .output(dust, Magnesium, 97768)
                .output(dust, Alunite, 90947)
                .output(dust, Diatomite, 90947)
                .output(dust, Gypsum, 90947)
                .output(dust, Platinum, 69033)
                .output(dust, GlauconiteSand, 68210)
                .output(dust, Emerald, 68210)
                .output(dust, Calcite, 66694)
                .output(dust, Spodumene, 56842)
                .output(dust, Lepidolite, 56842)
                .output(dust, Andradite, 55073)
                .output(dust, Trona, 45473)
                .output(dust, Sphalerite, 45473)
                .output(dust, Vanadium, 40421)
                .output(dust, Manganese, 29810)
                .output(dust, SiliconDioxide, 27789)
                .output(dust, Tantalite, 25263)
                .output(dust, Sodium, 24000)
                .output(dust, Pyrolusite, 22736)
                .output(dust, Pollucite, 22736)
                .output(dust, Calcium, 20210)
                .output(dust, Lithium, 18315)
                .output(dust, Chrome, 14400)
                .output(dust, Niobium, 11115)
                .output(dust, Caesium, 11115)
                .output(dust, Sapphire, 10105)
                .output(dust, Tantalum, 2273)
                .output(dust, Rubidium, 2273)
                .fluidOutputs(Hydrogen.getFluid(11152000))
                .fluidOutputs(Oxygen.getFluid(11152000))
                .fluidOutputs(Fluorine.getFluid(11152000))
                .fluidOutputs(Chlorine.getFluid(11152000))
                .fluidOutputs(Argon.getFluid(11152000))
                .fluidOutputs(Krypton.getFluid(11152000))
                .fluidOutputs(Tin.getPlasma(2576000))
                .fluidOutputs(Iron.getPlasma(2576000))
                .fluidOutputs(Americium.getPlasma(2576000))
                .fluidOutputs(Nickel.getPlasma(2576000))
                .fluidOutputs(StarCoreMatter.getPlasma(2576000))
                .fluidOutputs(WhiteDwarfMatter.getFluid(1256000))
                .fluidOutputs(BlackDwarfMatter.getFluid(1256000))
                .fluidOutputs(DimensionallyTranscendentResidue.getFluid(576000))
                .fluidOutputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(576000))
                .fluidOutputs(TemporalFluid.getFluid(102400))
                .fluidOutputs(Galaxium.getFluid(5760))
                .fluidOutputs(Spacetime.getFluid(2880))
                .EUt((int) V[OpV])
                .duration(1200)
                .buildAndRegister();

        //  Nether
        VIRTUAL_COSMOS_SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(COSMIC_MEMORY_CARD_NETHER)
                .output(dust, Netherrack, 240891153)
                .output(dust, Iron, 14904458)
                .output(dust, Redstone, 8577758)
                .output(dust, Coal, 7946767)
                .output(dust, Tin, 6069951)
                .output(dust, Copper, 4601556)
                .output(dust, Stibnite, 4394273)
                .output(dust, Charcoal, 3951050)
                .output(dust, Gold, 2754785)
                .output(dust, Monazite, 2334718)
                .output(dust, Bastnasite, 2299106)
                .output(dust, Zinc, 2247413)
                .output(dust, Tetrahedrite, 2217594)
                .output(dust, Nickel, 1698365)
                .output(dust, Silver, 1553258)
                .output(dust, Salt, 1005473)
                .output(dust, RockSalt, 1005473)
                .output(dust, Cobalt, 950388)
                .output(dust, Oilsands, 818526)
                .output(dust, Graphite, 769969)
                .output(dust, Rheniite, 727578)
                .output(dust, Sylvanite, 727578)
                .output(dust, Electrotine, 545684)
                .output(dust, Realgar, 545684)
                .output(dust, TricalciumPhosphate, 445136)
                .output(dust, Uranium235, 404153)
                .output(dust, Wollastonite, 363789)
                .output(dust, Soapstone, 363789)
                .output(dust, VanadiumMagnetite, 363789)
                .output(dust, NetherQuartz, 363789)
                .output(dust, CertusQuartz, 363789)
                .output(dust, Antimony, 327910)
                .output(dust, Arsenic, 207101)
                .output(dust, Sulfur, 204415)
                .output(dust, Obsidian, 200799)
                .output(dust, Uranium238, 199578)
                .output(dust, RareEarth, 190296)
                .output(dust, Quartzite, 184168)
                .output(dust, Beryllium, 181894)
                .output(dust, Chalcopyrite, 181894)
                .output(dust, Bornite, 181894)
                .output(dust, Amethyst, 181894)
                .output(dust, Glowstone, 178088)
                .output(dust, Chalcocite, 159157)
                .output(dust, Opal, 153600)
                .output(dust, Carbon, 153600)
                .output(dust, QuartzSand, 153600)
                .output(dust, Cadmium, 145515)
                .output(dust, Alumina, 141600)
                .output(dust, Molybdenite, 128842)
                .output(dust, Phosphate, 128842)
                .output(dust, Asbestos, 110147)
                .output(dust, Borax, 101052)
                .output(dust, Magnesium, 97768)
                .output(dust, Alunite, 90947)
                .output(dust, Wulfenite, 90947)
                .output(dust, Gypsum, 90947)
                .output(dust, Palladium, 69033)
                .output(dust, Molybdenum, 68210)
                .output(dust, Topaz, 68210)
                .output(dust, Powellite, 66694)
                .output(dust, Samarium, 56842)
                .output(dust, Osmium, 56842)
                .output(dust, NetherStar, 55073)
                .output(dust, Neodymium, 45473)
                .output(dust, Ruthenium, 45473)
                .output(dust, Zirconium, 40421)
                .output(dust, Titanium, 29810)
                .output(dust, Phosphorus, 27789)
                .output(dust, BrownLimonite, 25263)
                .output(dust, BandedIron, 24000)
                .output(dust, Iridium, 22736)
                .output(dust, BlueTopaz, 22736)
                .output(dust, Selenium, 20210)
                .output(dust, Potassium, 18315)
                .output(dust, Astatine, 14400)
                .output(dust, Rhenium, 11115)
                .output(dust, Thallium, 11115)
                .output(dust, GreenSapphire, 10105)
                .output(dust, Polonium, 2273)
                .output(dust, Radium, 2273)
                .fluidOutputs(Lava.getFluid(11152000))
                .fluidOutputs(BlazingPyrotheum.getFluid(11152000))
                .fluidOutputs(Bromine.getFluid(11152000))
                .fluidOutputs(Redstone.getFluid(11152000))
                .fluidOutputs(Xenon.getFluid(11152000))
                .fluidOutputs(Radon.getFluid(11152000))
                .fluidOutputs(Argon.getPlasma(2576000))
                .fluidOutputs(Nitrogen.getPlasma(2576000))
                .fluidOutputs(Oxygen.getPlasma(2576000))
                .fluidOutputs(Taranium.getPlasma(2576000))
                .fluidOutputs(StarCoreMatter.getPlasma(2576000))
                .fluidOutputs(WhiteDwarfMatter.getFluid(1256000))
                .fluidOutputs(BlackDwarfMatter.getFluid(1256000))
                .fluidOutputs(DimensionallyTranscendentResidue.getFluid(576000))
                .fluidOutputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(576000))
                .fluidOutputs(TemporalFluid.getFluid(102400))
                .fluidOutputs(Galaxium.getFluid(5760))
                .fluidOutputs(Spacetime.getFluid(2880))
                .EUt((int) V[OpV])
                .duration(1200)
                .buildAndRegister();

        //  End
        VIRTUAL_COSMOS_SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(COSMIC_MEMORY_CARD_END)
                .output(dust, Endstone, 240891153)
                .output(dust, Iron, 14904458)
                .output(dust, Redstone, 8577758)
                .output(dust, Coal, 7946767)
                .output(dust, Tin, 6069951)
                .output(dust, Copper, 4601556)
                .output(dust, Naquadah, 4394273)
                .output(dust, Charcoal, 3951050)
                .output(dust, Gold, 2754785)
                .output(dust, Plutonium239, 2334718)
                .output(dust, NaquadahEnriched, 2299106)
                .output(dust, Zinc, 2247413)
                .output(dust, Bedrock, 2217594)
                .output(dust, Nickel, 1698365)
                .output(dust, Silver, 1553258)
                .output(dust, Salt, 1005473)
                .output(dust, RockSalt, 1005473)
                .output(dust, Cobalt, 950388)
                .output(dust, Oilsands, 818526)
                .output(dust, Graphite, 769969)
                .output(dust, BismuthIridiate, 727578)
                .output(dust, GermaniumTungstenNitride, 727578)
                .output(dust, Plutonium241, 545684)
                .output(dust, Bauxite, 545684)
                .output(dust, Aluminium, 445136)
                .output(dust, EnderPearl, 404153)
                .output(dust, Uraninite, 363789)
                .output(dust, Naquadria, 363789)
                .output(dust, VanadiumMagnetite, 363789)
                .output(dust, NetherQuartz, 363789)
                .output(dust, CertusQuartz, 363789)
                .output(dust, EnderEye, 327910)
                .output(dust, Arsenic, 207101)
                .output(dust, Sulfur, 204415)
                .output(dust, Pitchblende, 200799)
                .output(dust, Uranium238, 199578)
                .output(dust, RareEarth, 190296)
                .output(dust, Quartzite, 184168)
                .output(dust, OrichalcumEnergized, 181894)
                .output(dust, Chalcopyrite, 181894)
                .output(dust, Bornite, 181894)
                .output(dust, Amethyst, 181894)
                .output(dust, Glowstone, 178088)
                .output(dust, Chalcocite, 159157)
                .output(dust, Opal, 153600)
                .output(dust, Carbon, 153600)
                .output(dust, QuartzSand, 153600)
                .output(dust, Cadmium, 145515)
                .output(dust, Alumina, 141600)
                .output(dust, Molybdenite, 128842)
                .output(dust, WhitePhosphorus, 128842)
                .output(dust, Actinium, 110147)
                .output(dust, Borax, 101052)
                .output(dust, Neptunium, 97768)
                .output(dust, Silicon, 90947)
                .output(dust, Indium, 90947)
                .output(dust, Gypsum, 90947)
                .output(dust, CassiteriteSand, 69033)
                .output(dust, Protactinium, 68210)
                .output(dust, Technetium, 68210)
                .output(dust, BluePhosphorus, 66694)
                .output(dust, Lawrencium, 56842)
                .output(dust, Rutherfordium, 56842)
                .output(dust, Ytterbium, 55073)
                .output(dust, Europium, 45473)
                .output(dust, Erbium, 45473)
                .output(dust, Yttrium, 40421)
                .output(dust, TungstenSteel, 29810)
                .output(dust, BlackPhosphorus, 27789)
                .output(dust, Euxenite, 25263)
                .output(dust, YellowLimonite, 24000)
                .output(dust, Californium, 22736)
                .output(dust, GraniticMineralSand, 22736)
                .output(dust, VioletPhosphorus, 20210)
                .output(dust, Tritanium, 18315)
                .output(dust, Adamantium, 14400)
                .output(dust, Duranium, 11115)
                .output(dust, Taranium, 11115)
                .output(dust, EnrichedMithril, 10105)
                .output(dust, ProtoAdamantium, 2273)
                .output(dust, Vibranium, 2273)
                .fluidOutputs(DragonBreath.getFluid(11152000))
                .fluidOutputs(GelidCryotheum.getFluid(11152000))
                .fluidOutputs(Tennessine.getFluid(11152000))
                .fluidOutputs(DragonBlood.getFluid(11152000))
                .fluidOutputs(MetastableOganesson.getFluid(11152000))
                .fluidOutputs(MetastableHassium.getFluid(11152000))
                .fluidOutputs(HighEnergyQuarkGluonPlasma.getPlasma(2576000))
                .fluidOutputs(QuasifissioningPlasma.getPlasma(2576000))
                .fluidOutputs(CelestialTungsten.getPlasma(2576000))
                .fluidOutputs(AstralTitanium.getPlasma(2576000))
                .fluidOutputs(StarCoreMatter.getPlasma(2576000))
                .fluidOutputs(WhiteDwarfMatter.getFluid(1256000))
                .fluidOutputs(BlackDwarfMatter.getFluid(1256000))
                .fluidOutputs(DimensionallyTranscendentResidue.getFluid(576000))
                .fluidOutputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(576000))
                .fluidOutputs(TemporalFluid.getFluid(102400))
                .fluidOutputs(Galaxium.getFluid(5760))
                .fluidOutputs(Spacetime.getFluid(2880))
                .EUt((int) V[OpV])
                .duration(1200)
                .buildAndRegister();





        //  Nether

        //  End


        //VIRTUAL_COSMOS_SIMULATOR_RECIPES.recipeBuilder()
        //        .notConsumable(COSMIC_MEMORY_CARD_OVERWORLD)
        //        .output(dust, Iron, 25760000)      // 1
        //        .output(dust, Copper, 25760000)    // 2
        //        .output(dust, Tin, 25760000)       // 3
        //        .output(dust, Cobalt, 12560000)    // 4
        //        .output(dust, Nickel, 12560000)    // 5
        //        .output(dust, Silicon, 12560000)   // 6
        //        .output(dust, Aluminium, 12560000) // 7
        //        .output(dust, Chrome, 12560000)    // 8
        //        .output(dust, Niobium, 5760000)    // 9
        //        .output(dust, Tantalum, 5760000)   // 10
        //        .output(dust, Titanium, 5760000)   // 11
        //        .output(dust, Tungsten, 5760000)   // 12
        //        .fluidOutputs(Carbon.getFluid(25760000))                                     // 1
        //        .fluidOutputs(Oxygen.getFluid(25760000))                                     // 2
        //        .fluidOutputs(Hydrogen.getFluid(25760000))                                   // 3
        //        .fluidOutputs(Nitrogen.getFluid(12560000))                                   // 4
        //        .fluidOutputs(Helium.getFluid(12560000))                                     // 5
        //        .fluidOutputs(Argon.getFluid(12560000))                                      // 6
        //        .fluidOutputs(Chlorine.getFluid(12560000))                                   // 7
        //        .fluidOutputs(Fluorine.getFluid(12560000))                                   // 8
        //        .fluidOutputs(TemporalFluid.getFluid(5760000))                               // 9
        //        .fluidOutputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(576000)) // 10
        //        .fluidOutputs(StarCoreMatter.getPlasma(576000))                              // 11
        //        .fluidOutputs(Spacetime.getFluid(2880))                                      // 12
        //        .EUt(VA[UXV])
        //        .duration(1200)
        //        .buildAndRegister();

        //VIRTUAL_COSMOS_SIMULATOR_RECIPES.recipeBuilder()
        //        .notConsumable(COSMIC_MEMORY_CARD_NETHER)
        //        .output(dust, Cadmium, 25760000)   // 1
        //        .output(dust, Zirconium, 25760000) // 2
        //        .output(dust, Gallium, 25760000)   // 3
        //        .output(dust, Platinum, 12560000)  // 4
        //        .output(dust, Palladium, 12560000) // 5
        //        .output(dust, Rhenium, 12560000)   // 6
        //        .output(dust, Selenium, 12560000)  // 7
        //        .output(dust, Thallium, 12560000)  // 8
        //        .output(dust, Neodymium, 5760000)  // 9
        //        .output(dust, Samarium, 5760000)   // 10
        //        .output(dust, Arsenic, 5760000)    // 11
        //        .output(dust, NetherStar, 5760000) // 12
        //        .fluidOutputs(Lava.getFluid(25760000))                                       // 1
        //        .fluidOutputs(SulfuricAcid.getFluid(25760000))                               // 2
        //        .fluidOutputs(NitricAcid.getFluid(25760000))                                 // 3
        //        .fluidOutputs(Krypton.getFluid(12560000))                                    // 4
        //        .fluidOutputs(Redstone.getFluid(12560000))                                   // 5
        //        .fluidOutputs(Glowstone.getFluid(12560000))                                  // 6
        //        .fluidOutputs(Blaze.getFluid(12560000))                                      // 7
        //        .fluidOutputs(BlazingPyrotheum.getFluid(12560000))                           // 8
        //        .fluidOutputs(HiggsBosons.getFluid(5760000))                                 // 9
        //        .fluidOutputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(576000)) // 10
        //        .fluidOutputs(StarCoreMatter.getPlasma(576000))                              // 11
        //        .fluidOutputs(Spacetime.getFluid(2880))                                      // 12
        //        .EUt(VA[UXV])
        //        .duration(1200)
        //        .buildAndRegister();

        //VIRTUAL_COSMOS_SIMULATOR_RECIPES.recipeBuilder()
        //        .notConsumable(COSMIC_MEMORY_CARD_END)
        //        .output(dust, Naquadah, 25760000)         // 1
        //        .output(dust, NaquadahEnriched, 25760000) // 2
        //        .output(dust, Naquadria, 25760000)        // 3
        //        .output(dust, Tiberium, 12560000)         // 4
        //        .output(dust, Ruthenium, 12560000)        // 5
        //        .output(dust, Rhodium, 12560000)          // 6
        //        .output(dust, Iridium, 12560000)          // 7
        //        .output(dust, Osmium, 12560000)           // 8
        //        .output(dust, Orichalcum, 5760000)        // 9
        //        .output(dust, Adamantium, 5760000)        // 10
        //        .output(dust, Vibranium, 5760000)         // 11
        //        .output(dust, EnderPearl, 5760000)        // 12
        //        .fluidOutputs(DragonBreath.getFluid(25760000))                               // 1
        //        .fluidOutputs(Xenon.getFluid(25760000))                                      // 2
        //        .fluidOutputs(Radon.getFluid(25760000))                                      // 3
        //        .fluidOutputs(MetastableOganesson.getFluid(12560000))                        // 4
        //        .fluidOutputs(MetastableFlerovium.getFluid(12560000))                        // 5
        //        .fluidOutputs(MetastableHassium.getFluid(12560000))                          // 6
        //        .fluidOutputs(Uranium238.getFluid(12560000))                                 // 7
        //        .fluidOutputs(Plutonium241.getFluid(12560000))                               // 8
        //        .fluidOutputs(Instantons.getFluid(5760000))                                  // 9
        //        .fluidOutputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(576000)) // 10
        //        .fluidOutputs(StarCoreMatter.getPlasma(576000))                              // 11
        //        .fluidOutputs(Spacetime.getFluid(2880))                                      // 12
        //        .EUt(VA[UXV])
        //        .duration(1200)
        //        .buildAndRegister();
//
        //VIRTUAL_COSMOS_SIMULATOR_RECIPES.recipeBuilder()
        //        .notConsumable(COSMIC_MEMORY_CARD)
        //        .output(dust, Germanium, 25760000) // 1
        //        .output(dust, Yttrium, 25760000)   // 2
        //        .output(dust, Lead, 25760000)      // 3
        //        .output(dust, Antimony, 12560000)  // 4
        //        .output(dust, Bismuth, 12560000)   // 5
        //        .output(dust, Indium, 12560000)    // 6
        //        .output(dust, Lutetium, 12560000)  // 7
        //        .output(dust, Europium, 12560000)  // 8
        //        .output(dust, Americium, 5760000)  // 9
        //        .output(dust, Tellurium, 5760000)  // 10
        //        .output(dust, Thorium, 5760000)    // 11
        //        .output(dust, Rubidium, 5760000)   // 12
        //        .fluidOutputs(Molybdenum.getFluid(25760000))                                 // 1
        //        .fluidOutputs(Magnesium.getFluid(25760000))                                  // 2
        //        .fluidOutputs(Manganese.getFluid(25760000))                                  // 3
        //        .fluidOutputs(Lithium.getFluid(12560000))                                    // 4
        //        .fluidOutputs(Iodine.getFluid(12560000))                                     // 5
        //        .fluidOutputs(Beryllium.getFluid(12560000))                                  // 6
        //        .fluidOutputs(Uranium235.getFluid(12560000))                                 // 7
        //        .fluidOutputs(Plutonium239.getFluid(12560000))                               // 8
        //        .fluidOutputs(Neutronium.getFluid(5760000))                                  // 9
        //        .fluidOutputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(576000)) // 10
        //        .fluidOutputs(StarCoreMatter.getPlasma(576000))                              // 11
        //        .fluidOutputs(Spacetime.getFluid(2880))                                      // 12
        //        .EUt(VA[UXV])
        //        .duration(1200)
        //        .buildAndRegister();
//
        //VIRTUAL_COSMOS_SIMULATOR_RECIPES.recipeBuilder()
        //        .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.NAQUADRIA_CHARGE, 64))
        //        .fluidOutputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(576000)) // 1
        //        .fluidOutputs(BlackDwarfMatter.getFluid(576000))                             // 2
        //        .fluidOutputs(WhiteDwarfMatter.getFluid(576000))                             // 3
        //        .fluidOutputs(Orichalcum.getFluid(576000))                                   // 4
        //        .fluidOutputs(Adamantium.getFluid(576000))                                   // 5
        //        .fluidOutputs(Vibranium.getFluid(576000))                                    // 6
        //        .fluidOutputs(Astralium.getFluid(576000))                                    // 7
        //        .fluidOutputs(BlackTitanium.getFluid(576000))                                // 8
        //        .fluidOutputs(BlackPlutonium.getFluid(576000))                               // 9
        //        .fluidOutputs(Neutronium.getFluid(576000))                                   // 10
        //        .fluidOutputs(Lafium.getFluid(576000))                                       // 11
        //        .fluidOutputs(TitanSteel.getFluid(576000))                                   // 12
        //        .EUt(VA[UXV])
        //        .duration(1200)
        //        .buildAndRegister();
//
        //VIRTUAL_COSMOS_SIMULATOR_RECIPES.recipeBuilder()
        //        .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.TARANIUM_CHARGE, 32))
        //        .fluidOutputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(576000)) // 1
        //        .fluidOutputs(BlackDwarfMatter.getFluid(576000))                             // 2
        //        .fluidOutputs(WhiteDwarfMatter.getFluid(576000))                             // 3
        //        .fluidOutputs(LightQuarks.getFluid(576000))                                  // 4
        //        .fluidOutputs(HeavyQuarks.getFluid(576000))                                  // 5
        //        .fluidOutputs(Gluons.getFluid(576000))                                       // 6
        //        .fluidOutputs(HeavyLepton.getFluid(576000))                                  // 7
        //        .fluidOutputs(Taranium.getFluid(576000))                                     // 8
        //        .fluidOutputs(Solarium.getFluid(576000))                                     // 9
        //        .fluidOutputs(LunaSilver.getFluid(576000))                                   // 10
        //        .fluidOutputs(Trinium.getFluid(576000))                                      // 11
        //        .fluidOutputs(Tritanium.getFluid(576000))                                    // 12
        //        .EUt(VA[UXV])
        //        .duration(1200)
        //        .buildAndRegister();
//
        //VIRTUAL_COSMOS_SIMULATOR_RECIPES.recipeBuilder()
        //        .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.LEPTONIC_CHARGE, 16))
        //        .fluidOutputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(576000)) // 1
        //        .fluidOutputs(BlackDwarfMatter.getFluid(576000))                             // 2
        //        .fluidOutputs(WhiteDwarfMatter.getFluid(576000))                             // 3
        //        .fluidOutputs(HeavyQuarkDegenerateMatter.getFluid(576000))                   // 4
        //        .fluidOutputs(QuantumchromodynamicallyConfinedMatter.getFluid(576000))       // 5
        //        .fluidOutputs(AstralTitanium.getFluid(576000))                               // 6
        //        .fluidOutputs(CelestialTungsten.getFluid(576000))                            // 7
        //        .fluidOutputs(CrystalMatrix.getFluid(576000))                                // 8
        //        .fluidOutputs(Infinity.getFluid(576000))                                     // 9
        //        .fluidOutputs(Rhugnor.getFluid(576000))                                      // 10
        //        .fluidOutputs(DragonBlood.getFluid(576000))                                  // 11
        //        .fluidOutputs(Mithril.getFluid(576000))                                      // 12
        //        .EUt(VA[UXV])
        //        .duration(1200)
        //        .buildAndRegister();
//
        //VIRTUAL_COSMOS_SIMULATOR_RECIPES.recipeBuilder()
        //        .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.QUANTUM_CHROMODYNAMIC_CHARGE, 4))
        //        .fluidOutputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(576000)) // 1
        //        .fluidOutputs(BlackDwarfMatter.getFluid(576000))                             // 2
        //        .fluidOutputs(WhiteDwarfMatter.getFluid(576000))                             // 3
        //        .fluidOutputs(Instantons.getFluid(576000))                                   // 4
        //        .fluidOutputs(HiggsBosons.getFluid(576000))                                  // 5
        //        .fluidOutputs(TemporalFluid.getFluid(576000))                                // 6
        //        .fluidOutputs(DimensionallyTranscendentResidue.getFluid(576000))             // 7
        //        .fluidOutputs(CosmicNeutronium.getFluid(576000))                             // 8
        //        .fluidOutputs(Hikarium.getFluid(576000))                                     // 9
        //        .fluidOutputs(Galaxium.getFluid(576000))                                     // 10
        //        .fluidOutputs(HeavyQuarkDegenerateMatter.getFluid(576000))                   // 11
        //        .fluidOutputs(QuantumchromodynamicallyConfinedMatter.getFluid(576000))       // 12
        //        .EUt(VA[UXV])
        //        .duration(1200)
        //        .buildAndRegister();

    }
}
