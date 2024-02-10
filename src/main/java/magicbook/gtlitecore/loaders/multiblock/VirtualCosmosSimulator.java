package magicbook.gtlitecore.loaders.multiblock;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import magicbook.gtlitecore.common.blocks.BlockExplosive;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.CANNER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class VirtualCosmosSimulator {

    public static void init() {

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

        VIRTUAL_COSMOS_SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(COSMIC_MEMORY_CARD_OVERWORLD)
                .output(dust, Iron, 25760000)      // 1
                .output(dust, Copper, 25760000)    // 2
                .output(dust, Tin, 25760000)       // 3
                .output(dust, Cobalt, 12560000)    // 4
                .output(dust, Nickel, 12560000)    // 5
                .output(dust, Silicon, 12560000)   // 6
                .output(dust, Aluminium, 12560000) // 7
                .output(dust, Chrome, 12560000)    // 8
                .output(dust, Niobium, 5760000)    // 9
                .output(dust, Tantalum, 5760000)   // 10
                .output(dust, Titanium, 5760000)   // 11
                .output(dust, Tungsten, 5760000)   // 12
                .fluidOutputs(Carbon.getFluid(25760000))                                     // 1
                .fluidOutputs(Oxygen.getFluid(25760000))                                     // 2
                .fluidOutputs(Hydrogen.getFluid(25760000))                                   // 3
                .fluidOutputs(Nitrogen.getFluid(12560000))                                   // 4
                .fluidOutputs(Helium.getFluid(12560000))                                     // 5
                .fluidOutputs(Argon.getFluid(12560000))                                      // 6
                .fluidOutputs(Chlorine.getFluid(12560000))                                   // 7
                .fluidOutputs(Fluorine.getFluid(12560000))                                   // 8
                .fluidOutputs(TemporalFluid.getFluid(5760000))                               // 9
                .fluidOutputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(576000)) // 10
                .fluidOutputs(StarCoreMatter.getPlasma(576000))                              // 11
                .fluidOutputs(Spacetime.getFluid(2880))                                      // 12
                .EUt(VA[UXV])
                .duration(1200)
                .buildAndRegister();

        VIRTUAL_COSMOS_SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(COSMIC_MEMORY_CARD_NETHER)
                .output(dust, Cadmium, 25760000)   // 1
                .output(dust, Zirconium, 25760000) // 2
                .output(dust, Gallium, 25760000)   // 3
                .output(dust, Platinum, 12560000)  // 4
                .output(dust, Palladium, 12560000) // 5
                .output(dust, Rhenium, 12560000)   // 6
                .output(dust, Selenium, 12560000)  // 7
                .output(dust, Thallium, 12560000)  // 8
                .output(dust, Neodymium, 5760000)  // 9
                .output(dust, Samarium, 5760000)   // 10
                .output(dust, Arsenic, 5760000)    // 11
                .output(dust, NetherStar, 5760000) // 12
                .fluidOutputs(Lava.getFluid(25760000))                                       // 1
                .fluidOutputs(SulfuricAcid.getFluid(25760000))                               // 2
                .fluidOutputs(NitricAcid.getFluid(25760000))                                 // 3
                .fluidOutputs(Krypton.getFluid(12560000))                                    // 4
                .fluidOutputs(Redstone.getFluid(12560000))                                   // 5
                .fluidOutputs(Glowstone.getFluid(12560000))                                  // 6
                .fluidOutputs(Blaze.getFluid(12560000))                                      // 7
                .fluidOutputs(BlazingPyrotheum.getFluid(12560000))                           // 8
                .fluidOutputs(HiggsBosons.getFluid(5760000))                                 // 9
                .fluidOutputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(576000)) // 10
                .fluidOutputs(StarCoreMatter.getPlasma(576000))                              // 11
                .fluidOutputs(Spacetime.getFluid(2880))                                      // 12
                .EUt(VA[UXV])
                .duration(1200)
                .buildAndRegister();

        VIRTUAL_COSMOS_SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(COSMIC_MEMORY_CARD_END)
                .output(dust, Naquadah, 25760000)         // 1
                .output(dust, NaquadahEnriched, 25760000) // 2
                .output(dust, Naquadria, 25760000)        // 3
                .output(dust, Tiberium, 12560000)         // 4
                .output(dust, Ruthenium, 12560000)        // 5
                .output(dust, Rhodium, 12560000)          // 6
                .output(dust, Iridium, 12560000)          // 7
                .output(dust, Osmium, 12560000)           // 8
                .output(dust, Orichalcum, 5760000)        // 9
                .output(dust, Adamantium, 5760000)        // 10
                .output(dust, Vibranium, 5760000)         // 11
                .output(dust, EnderPearl, 5760000)        // 12
                .fluidOutputs(DragonBreath.getFluid(25760000))                               // 1
                .fluidOutputs(Xenon.getFluid(25760000))                                      // 2
                .fluidOutputs(Radon.getFluid(25760000))                                      // 3
                .fluidOutputs(MetastableOganesson.getFluid(12560000))                        // 4
                .fluidOutputs(MetastableFlerovium.getFluid(12560000))                        // 5
                .fluidOutputs(MetastableHassium.getFluid(12560000))                          // 6
                .fluidOutputs(Uranium238.getFluid(12560000))                                 // 7
                .fluidOutputs(Plutonium241.getFluid(12560000))                               // 8
                .fluidOutputs(Instantons.getFluid(5760000))                                  // 9
                .fluidOutputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(576000)) // 10
                .fluidOutputs(StarCoreMatter.getPlasma(576000))                              // 11
                .fluidOutputs(Spacetime.getFluid(2880))                                      // 12
                .EUt(VA[UXV])
                .duration(1200)
                .buildAndRegister();

        VIRTUAL_COSMOS_SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(COSMIC_MEMORY_CARD)
                .output(dust, Germanium, 25760000) // 1
                .output(dust, Yttrium, 25760000)   // 2
                .output(dust, Lead, 25760000)      // 3
                .output(dust, Antimony, 12560000)  // 4
                .output(dust, Bismuth, 12560000)   // 5
                .output(dust, Indium, 12560000)    // 6
                .output(dust, Lutetium, 12560000)  // 7
                .output(dust, Europium, 12560000)  // 8
                .output(dust, Americium, 5760000)  // 9
                .output(dust, Tellurium, 5760000)  // 10
                .output(dust, Thorium, 5760000)    // 11
                .output(dust, Rubidium, 5760000)   // 12
                .fluidOutputs(Molybdenum.getFluid(25760000))                                 // 1
                .fluidOutputs(Magnesium.getFluid(25760000))                                  // 2
                .fluidOutputs(Manganese.getFluid(25760000))                                  // 3
                .fluidOutputs(Lithium.getFluid(12560000))                                    // 4
                .fluidOutputs(Iodine.getFluid(12560000))                                     // 5
                .fluidOutputs(Beryllium.getFluid(12560000))                                  // 6
                .fluidOutputs(Uranium235.getFluid(12560000))                                 // 7
                .fluidOutputs(Plutonium239.getFluid(12560000))                               // 8
                .fluidOutputs(Neutronium.getFluid(5760000))                                  // 9
                .fluidOutputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(576000)) // 10
                .fluidOutputs(StarCoreMatter.getPlasma(576000))                              // 11
                .fluidOutputs(Spacetime.getFluid(2880))                                      // 12
                .EUt(VA[UXV])
                .duration(1200)
                .buildAndRegister();

        VIRTUAL_COSMOS_SIMULATOR_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.NAQUADRIA_CHARGE, 64))
                .fluidOutputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(576000)) // 1
                .fluidOutputs(BlackDwarfMatter.getFluid(576000))                             // 2
                .fluidOutputs(WhiteDwarfMatter.getFluid(576000))                             // 3
                .fluidOutputs(Orichalcum.getFluid(576000))                                   // 4
                .fluidOutputs(Adamantium.getFluid(576000))                                   // 5
                .fluidOutputs(Vibranium.getFluid(576000))                                    // 6
                .fluidOutputs(Astralium.getFluid(576000))                                    // 7
                .fluidOutputs(BlackTitanium.getFluid(576000))                                // 8
                .fluidOutputs(BlackPlutonium.getFluid(576000))                               // 9
                .fluidOutputs(Neutronium.getFluid(576000))                                   // 10
                .fluidOutputs(Lafium.getFluid(576000))                                       // 11
                .fluidOutputs(TitanSteel.getFluid(576000))                                   // 12
                .EUt(VA[UXV])
                .duration(1200)
                .buildAndRegister();

        VIRTUAL_COSMOS_SIMULATOR_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.TARANIUM_CHARGE, 32))
                .fluidOutputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(576000)) // 1
                .fluidOutputs(BlackDwarfMatter.getFluid(576000))                             // 2
                .fluidOutputs(WhiteDwarfMatter.getFluid(576000))                             // 3
                .fluidOutputs(LightQuarks.getFluid(576000))                                  // 4
                .fluidOutputs(HeavyQuarks.getFluid(576000))                                  // 5
                .fluidOutputs(Gluons.getFluid(576000))                                       // 6
                .fluidOutputs(HeavyLepton.getFluid(576000))                                  // 7
                .fluidOutputs(Taranium.getFluid(576000))                                     // 8
                .fluidOutputs(Solarium.getFluid(576000))                                     // 9
                .fluidOutputs(LunaSilver.getFluid(576000))                                   // 10
                .fluidOutputs(Trinium.getFluid(576000))                                      // 11
                .fluidOutputs(Tritanium.getFluid(576000))                                    // 12
                .EUt(VA[UXV])
                .duration(1200)
                .buildAndRegister();

        VIRTUAL_COSMOS_SIMULATOR_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.LEPTONIC_CHARGE, 16))
                .fluidOutputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(576000)) // 1
                .fluidOutputs(BlackDwarfMatter.getFluid(576000))                             // 2
                .fluidOutputs(WhiteDwarfMatter.getFluid(576000))                             // 3
                .fluidOutputs(HeavyQuarkDegenerateMatter.getFluid(576000))                   // 4
                .fluidOutputs(QuantumchromodynamicallyConfinedMatter.getFluid(576000))       // 5
                .fluidOutputs(AstralTitanium.getFluid(576000))                               // 6
                .fluidOutputs(CelestialTungsten.getFluid(576000))                            // 7
                .fluidOutputs(CrystalMatrix.getFluid(576000))                                // 8
                .fluidOutputs(Infinity.getFluid(576000))                                     // 9
                .fluidOutputs(Rhugnor.getFluid(576000))                                      // 10
                .fluidOutputs(DragonBlood.getFluid(576000))                                  // 11
                .fluidOutputs(Mithril.getFluid(576000))                                      // 12
                .EUt(VA[UXV])
                .duration(1200)
                .buildAndRegister();

        VIRTUAL_COSMOS_SIMULATOR_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.QUANTUM_CHROMODYNAMIC_CHARGE, 4))
                .fluidOutputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(576000)) // 1
                .fluidOutputs(BlackDwarfMatter.getFluid(576000))                             // 2
                .fluidOutputs(WhiteDwarfMatter.getFluid(576000))                             // 3
                .fluidOutputs(Instantons.getFluid(576000))                                   // 4
                .fluidOutputs(HiggsBosons.getFluid(576000))                                  // 5
                .fluidOutputs(TemporalFluid.getFluid(576000))                                // 6
                .fluidOutputs(DimensionallyTranscendentResidue.getFluid(576000))             // 7
                .fluidOutputs(CosmicNeutronium.getFluid(576000))                             // 8
                .fluidOutputs(Hikarium.getFluid(576000))                                     // 9
                .fluidOutputs(Galaxium.getFluid(576000))                                     // 10
                .fluidOutputs(HeavyQuarkDegenerateMatter.getFluid(576000))                   // 11
                .fluidOutputs(QuantumchromodynamicallyConfinedMatter.getFluid(576000))       // 12
                .EUt(VA[UXV])
                .duration(1200)
                .buildAndRegister();

    }
}
