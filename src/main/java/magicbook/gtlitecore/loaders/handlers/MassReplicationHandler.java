package magicbook.gtlitecore.loaders.handlers;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.ore.OrePrefix;
import magicbook.gtlitecore.api.unification.GTLiteMaterials;
import magicbook.gtlitecore.common.GTLiteConfigHolder;
import net.minecraftforge.fluids.FluidStack;

import java.util.ArrayList;
import java.util.List;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.MASS_FABRICATOR_RECIPES;
import static gregtech.api.recipes.RecipeMaps.REPLICATOR_RECIPES;
import static gregtech.api.unification.material.Materials.UUMatter;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.TURBINE_MIXER_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

/**
 * Mass Replication Handler.
 *
 * @author Magic_Sweepy
 *
 * <p>
 *     Ref: {@code gregicadditions/recipes/RecipeHandler#matterReplication(Material)}.
 *     Thanks for original Gregicality Legacy devs, I just do some tweak in GTCEu environment.
 *     TODO Replaced this loop to Processing Handler system.
 * </p>
 *
 * @since 2.8.8-beta
 */
public class MassReplicationHandler {

    //  Array list of all Periodic Table Materials.
    private static final List<Material> periodicTableMaterials = new ArrayList<>();

    public static void register() {

        //  Pre-register Periodic Table Materials to list.
        periodicTableMaterials.add(Materials.Hydrogen);                  // 1   H
        periodicTableMaterials.add(Materials.Helium);                    // 2   He
        periodicTableMaterials.add(Materials.Lithium);                   // 3   Li
        periodicTableMaterials.add(Materials.Beryllium);                 // 4   Be
        periodicTableMaterials.add(Materials.Boron);                     // 5   B
        periodicTableMaterials.add(Materials.Carbon);                    // 6   C
        periodicTableMaterials.add(Materials.Nitrogen);                  // 7   N
        periodicTableMaterials.add(Materials.Oxygen);                    // 8   O
        periodicTableMaterials.add(Materials.Fluorine);                  // 9   F
        periodicTableMaterials.add(Materials.Neon);                      // 10  Ne
        periodicTableMaterials.add(Materials.Sodium);                    // 11  Na
        periodicTableMaterials.add(Materials.Magnesium);                 // 12  Mg
        periodicTableMaterials.add(Materials.Aluminium);                 // 13  Al
        periodicTableMaterials.add(Materials.Silicon);                   // 14  Si
        periodicTableMaterials.add(Materials.Phosphorus);                // 15  P
        periodicTableMaterials.add(Materials.Sulfur);                    // 16  S
        periodicTableMaterials.add(Materials.Chlorine);                  // 17  Cl
        periodicTableMaterials.add(Materials.Argon);                     // 18  Ar
        periodicTableMaterials.add(Materials.Potassium);                 // 19  K
        periodicTableMaterials.add(Materials.Calcium);                   // 20  Cl
        periodicTableMaterials.add(Materials.Scandium);                  // 21  Sc
        periodicTableMaterials.add(Materials.Titanium);                  // 22  Ti
        periodicTableMaterials.add(Materials.Vanadium);                  // 23  V
        periodicTableMaterials.add(Materials.Chrome);                    // 24  Cr
        periodicTableMaterials.add(Materials.Manganese);                 // 25  Mn
        periodicTableMaterials.add(Materials.Iron);                      // 26  Fe
        periodicTableMaterials.add(Materials.Cobalt);                    // 27  Co
        periodicTableMaterials.add(Materials.Nickel);                    // 28  Ni
        periodicTableMaterials.add(Materials.Copper);                    // 29  Cu
        periodicTableMaterials.add(Materials.Zinc);                      // 30  Zn
        periodicTableMaterials.add(Materials.Gallium);                   // 31  Ga
        periodicTableMaterials.add(Materials.Germanium);                 // 32  Ge
        periodicTableMaterials.add(Materials.Arsenic);                   // 33  As
        periodicTableMaterials.add(Materials.Selenium);                  // 34  Se
        periodicTableMaterials.add(Materials.Bromine);                   // 35  Br
        periodicTableMaterials.add(Materials.Krypton);                   // 36  Kr
        periodicTableMaterials.add(Materials.Rubidium);                  // 37  Ru
        periodicTableMaterials.add(Materials.Strontium);                 // 38  Sr
        periodicTableMaterials.add(Materials.Yttrium);                   // 39  Y
        periodicTableMaterials.add(Materials.Zirconium);                 // 40  Zr
        periodicTableMaterials.add(Materials.Niobium);                   // 41  Nb
        periodicTableMaterials.add(Materials.Molybdenum);                // 42  Mo
        periodicTableMaterials.add(Materials.Technetium);                // 43  Tc
        periodicTableMaterials.add(Materials.Ruthenium);                 // 44  Ru
        periodicTableMaterials.add(Materials.Rhodium);                   // 45  Rh
        periodicTableMaterials.add(Materials.Palladium);                 // 46  Pd
        periodicTableMaterials.add(Materials.Silver);                    // 47  Ag
        periodicTableMaterials.add(Materials.Cadmium);                   // 48  Cd
        periodicTableMaterials.add(Materials.Indium);                    // 49  In
        periodicTableMaterials.add(Materials.Tin);                       // 50  Sn
        periodicTableMaterials.add(Materials.Antimony);                  // 51  Sb
        periodicTableMaterials.add(Materials.Tellurium);                 // 52  Te
        periodicTableMaterials.add(Materials.Iodine);                    // 53  I
        periodicTableMaterials.add(Materials.Xenon);                     // 54  Xe
        periodicTableMaterials.add(Materials.Caesium);                   // 55  Cs
        periodicTableMaterials.add(Materials.Barium);                    // 56  Ba
        periodicTableMaterials.add(Materials.Lanthanum);                 // 57  La
        periodicTableMaterials.add(Materials.Cerium);                    // 58  Ce
        periodicTableMaterials.add(Materials.Praseodymium);              // 59  Pr
        periodicTableMaterials.add(Materials.Neodymium);                 // 60  Nd
        periodicTableMaterials.add(Materials.Promethium);                // 61  Pm
        periodicTableMaterials.add(Materials.Samarium);                  // 62  Sm
        periodicTableMaterials.add(Materials.Europium);                  // 63  Eu
        periodicTableMaterials.add(Materials.Gadolinium);                // 64  Gd
        periodicTableMaterials.add(Materials.Terbium);                   // 65  Tb
        periodicTableMaterials.add(Materials.Dysprosium);                // 66  Dy
        periodicTableMaterials.add(Materials.Holmium);                   // 67  Ho
        periodicTableMaterials.add(Materials.Erbium);                    // 68  Er
        periodicTableMaterials.add(Materials.Thulium);                   // 69  Tm
        periodicTableMaterials.add(Materials.Ytterbium);                 // 70  Yb
        periodicTableMaterials.add(Materials.Lutetium);                  // 71  Lu
        periodicTableMaterials.add(Materials.Hafnium);                   // 72  Hf
        periodicTableMaterials.add(Materials.Tantalum);                  // 73  Ta
        periodicTableMaterials.add(Materials.Tungsten);                  // 74  W
        periodicTableMaterials.add(Materials.Rhenium);                   // 75  Re
        periodicTableMaterials.add(Materials.Osmium);                    // 76  Os
        periodicTableMaterials.add(Materials.Iridium);                   // 77  Ir
        periodicTableMaterials.add(Materials.Platinum);                  // 78  Pt
        periodicTableMaterials.add(Materials.Gold);                      // 79  Au
        periodicTableMaterials.add(Materials.Mercury);                   // 80  Hg
        periodicTableMaterials.add(Materials.Thallium);                  // 81  Tl
        periodicTableMaterials.add(Materials.Lead);                      // 82  Pb
        periodicTableMaterials.add(Materials.Bismuth);                   // 83  Bi
        periodicTableMaterials.add(Materials.Polonium);                  // 84  Po
        periodicTableMaterials.add(Materials.Astatine);                  // 85  At
        periodicTableMaterials.add(Materials.Radon);                     // 86  Rn
        periodicTableMaterials.add(Materials.Francium);                  // 87  Fr
        periodicTableMaterials.add(Materials.Radium);                    // 88  Ra
        periodicTableMaterials.add(Materials.Actinium);                  // 89  Ac
        periodicTableMaterials.add(Materials.Thorium);                   // 90  Th
        periodicTableMaterials.add(Materials.Protactinium);              // 91  Pa
        periodicTableMaterials.add(Materials.Uranium235);                // 92  U-235
        periodicTableMaterials.add(Materials.Uranium238);                // 92  U-238
        periodicTableMaterials.add(Materials.Neptunium);                 // 93  Np
        periodicTableMaterials.add(Materials.Plutonium239);              // 94  Pu-239
        periodicTableMaterials.add(Materials.Plutonium241);              // 94  Pu-241
        periodicTableMaterials.add(Materials.Americium);                 // 95  Am
        periodicTableMaterials.add(Materials.Curium);                    // 96  Cm
        periodicTableMaterials.add(Materials.Berkelium);                 // 97  Bk
        periodicTableMaterials.add(Materials.Californium);               // 98  Cf
        periodicTableMaterials.add(Materials.Einsteinium);               // 99  Es
        periodicTableMaterials.add(Materials.Fermium);                   // 100 Fm
        periodicTableMaterials.add(Materials.Mendelevium);               // 101 Md
        periodicTableMaterials.add(Materials.Nobelium);                  // 102 No
        periodicTableMaterials.add(Materials.Lawrencium);                // 103 Lr
        periodicTableMaterials.add(Materials.Rutherfordium);             // 104 Rf
        periodicTableMaterials.add(Materials.Dubnium);                   // 105 Db
        periodicTableMaterials.add(Materials.Seaborgium);                // 106 Sg
        periodicTableMaterials.add(Materials.Bohrium);                   // 107 Bh
        periodicTableMaterials.add(GTLiteMaterials.MetastableHassium);   // 108 Hs
        periodicTableMaterials.add(Materials.Meitnerium);                // 109 Mt
        periodicTableMaterials.add(Materials.Darmstadtium);              // 110 Ds
        periodicTableMaterials.add(Materials.Roentgenium);               // 111 Rg
        periodicTableMaterials.add(Materials.Copernicium);               // 112 Cn
        periodicTableMaterials.add(Materials.Nihonium);                  // 113 Nh
        periodicTableMaterials.add(GTLiteMaterials.MetastableFlerovium); // 114 Fl
        periodicTableMaterials.add(Materials.Moscovium);                 // 115 Mc
        periodicTableMaterials.add(Materials.Livermorium);               // 116 Lv
        periodicTableMaterials.add(Materials.Tennessine);                // 117 Ts
        periodicTableMaterials.add(GTLiteMaterials.MetastableOganesson); // 118 Og

        //  Some utilities
        int replicationTimeFactor = GTLiteConfigHolder.machines.replicationTimeFactor;

        //  Traverse all Elements in {@code periodicTableMaterials}.
        for (Material periodicTableMaterial : periodicTableMaterials) {
            //  Mass of Element, used to check product UU Matter type.
            int mass = (int) periodicTableMaterial.getMass();
            //  UU Matter type, dependenced on Mass of Element.
            FluidStack uuMatter = mass % 2 == 0 ? BosonicUUMatter.getFluid(mass) : FermionicUUMatter.getFluid(mass);
            //  If Element have fluid (liquid or gas), then add fluid replication recipe.
            if (periodicTableMaterial.hasProperty(PropertyKey.FLUID)) {
                //  If Element has Ingot Property, then return 144L, if not, then return 1000L.
                int amount = periodicTableMaterial.hasProperty(PropertyKey.INGOT) ? L : 1000;
                //  Element -> UU Matter + Free Electron Gas.
                MASS_FABRICATOR_RECIPES.recipeBuilder()
                        .fluidInputs(periodicTableMaterial.getFluid(amount))
                        .fluidOutputs(uuMatter)
                        .fluidOutputs(FreeElectronGas.getFluid(mass))
                        .EUt(32)
                        .duration(mass * replicationTimeFactor)
                        .buildAndRegister();
                //  UU Matter + Free Electron Gas -> Element
                REPLICATOR_RECIPES.recipeBuilder()
                        .notConsumable(periodicTableMaterial.getFluid(amount))
                        .fluidInputs(uuMatter)
                        .fluidInputs(FreeElectronGas.getFluid(mass))
                        .fluidOutputs(periodicTableMaterial.getFluid(amount))
                        .EUt(32)
                        .duration(mass * replicationTimeFactor)
                        .buildAndRegister();
                //  Another recipe use total UU Matter.
                REPLICATOR_RECIPES.recipeBuilder()
                        .notConsumable(periodicTableMaterial.getFluid(amount))
                        .fluidInputs(UUMatter.getFluid(mass))
                        .fluidOutputs(periodicTableMaterial.getFluid(amount))
                        .EUt(32)
                        .duration(mass * replicationTimeFactor)
                        .buildAndRegister();
            } else {
                // If Element does not have fluid (liquid or gas), then check if it has dust property.
                if (periodicTableMaterial.hasProperty(PropertyKey.DUST)) {
                    //  Element -> UU Matter + Free Electron Gas.
                    MASS_FABRICATOR_RECIPES.recipeBuilder()
                            .input(dust, periodicTableMaterial)
                            .fluidOutputs(uuMatter)
                            .fluidOutputs(FreeElectronGas.getFluid(mass))
                            .EUt(32)
                            .duration(mass * replicationTimeFactor)
                            .buildAndRegister();
                    //  UU Matter + Free Electron Gas -> Element
                    REPLICATOR_RECIPES.recipeBuilder()
                            .notConsumable(dust, periodicTableMaterial)
                            .fluidInputs(uuMatter)
                            .fluidInputs(FreeElectronGas.getFluid(mass))
                            .output(dust, periodicTableMaterial)
                            .EUt(32)
                            .duration(mass * replicationTimeFactor)
                            .buildAndRegister();
                    //  Another recipe use total UU Matter.
                    REPLICATOR_RECIPES.recipeBuilder()
                            .notConsumable(dust, periodicTableMaterial)
                            .fluidInputs(UUMatter.getFluid(mass))
                            .output(dust, periodicTableMaterial)
                            .EUt(32)
                            .duration(mass * replicationTimeFactor)
                            .buildAndRegister();
                }
            }
        }

        //  Bosonic UU Matter + Fermionic UUMatter + Free Electron Gas -> UU Matter
        TURBINE_MIXER_RECIPES.recipeBuilder()
                .fluidInputs(BosonicUUMatter.getFluid(1000))
                .fluidInputs(FermionicUUMatter.getFluid(1000))
                .fluidInputs(FreeElectronGas.getFluid(2000))
                .fluidOutputs(UUMatter.getFluid(1000))
                .EUt(VA[IV])
                .duration(5 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }
}
