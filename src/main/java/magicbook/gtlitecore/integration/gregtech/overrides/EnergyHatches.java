package magicbook.gtlitecore.integration.gregtech.overrides;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.stack.UnificationEntry;
import magicbook.gtlitecore.common.GTLiteConfigHolder;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLY_LINE_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gregtech.common.metatileentities.MetaTileEntities.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;
import static magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities.*;

public class EnergyHatches {

    public static void init() {
        EnergyHatches1A();
        EnergyHatches4A();
        EnergyHatches16A();
        EnergyHatches64A();
        Transformers();
        PowerTransformers();
        HiAmpTransformers();
    }

    private static void EnergyHatches1A() {

        //  Delete UHV vanilla recipes
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLY_LINE_RECIPES,
                new ItemStack[]{HULL[UHV].getStackForm(),
                        OreDictUnifier.get(cableGtSingle, Europium, 4),
                        ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(2),
                        OreDictUnifier.get(circuit, MarkerMaterials.Tier.UHV),
                        OreDictUnifier.get(wireGtDouble, RutheniumTriniumAmericiumNeutronate, 2)},
                new FluidStack[]{SodiumPotassium.getFluid(12000),
                        SolderingAlloy.getFluid(5760)});

        GTRecipeHandler.removeRecipesByInputs(ASSEMBLY_LINE_RECIPES,
                new ItemStack[]{HULL[UHV].getStackForm(),
                        OreDictUnifier.get(spring, Europium, 4),
                        ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(2),
                        OreDictUnifier.get(circuit, MarkerMaterials.Tier.UHV),
                        OreDictUnifier.get(wireGtDouble, RutheniumTriniumAmericiumNeutronate, 2)},
                new FluidStack[]{SodiumPotassium.getFluid(12000),
                        SolderingAlloy.getFluid(5760)});

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[UHV])
                .input(cableGtSingle, Europium, 4)
                .input(NANO_PIC_CHIP, 2)
                .input(circuit, MarkerMaterials.Tier.UHV)
                .input(VOLTAGE_COIL_UHV, 2)
                .fluidInputs(SodiumPotassium.getFluid(12000))
                .fluidInputs(SolderingAlloy.getFluid(5760))
                .output(ENERGY_INPUT_HATCH[UHV])
                .EUt(VA[UHV])
                .duration(1000)
                .stationResearch(b -> b
                        .researchStack(ENERGY_INPUT_HATCH[UV].getStackForm())
                        .CWUt(128)
                        .EUt(VA[UV]))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[UHV])
                .input(spring, Europium, 4)
                .input(NANO_PIC_CHIP, 2)
                .input(circuit, MarkerMaterials.Tier.UHV)
                .input(VOLTAGE_COIL_UHV, 2)
                .fluidInputs(SodiumPotassium.getFluid(12000))
                .fluidInputs(SolderingAlloy.getFluid(5760))
                .output(ENERGY_OUTPUT_HATCH[UHV])
                .EUt(VA[UHV])
                .duration(1000)
                .stationResearch(b -> b
                        .researchStack(ENERGY_OUTPUT_HATCH[UV].getStackForm())
                        .CWUt(128)
                        .EUt(VA[UV]))
                .buildAndRegister();

        if (GTLiteConfigHolder.machines.enableHighTier1AEnergyHatch) {
            //  UEV
            ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(HULL[UEV])
                    .input(cableGtSingle, PedotTMA, 4)
                    .input(NANO_PIC_CHIP, 2)
                    .input(circuit, MarkerMaterials.Tier.UEV)
                    .input(VOLTAGE_COIL_UEV, 2)
                    .fluidInputs(SodiumPotassium.getFluid(14000))
                    .fluidInputs(SolderingAlloy.getFluid(11520))
                    .output(ENERGY_INPUT_HATCH[UEV])
                    .EUt(VA[UEV])
                    .duration(1200)
                    .stationResearch(b -> b
                            .researchStack(ENERGY_INPUT_HATCH[UHV].getStackForm())
                            .CWUt(256)
                            .EUt(VA[UHV]))
                    .buildAndRegister();

            ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(HULL[UEV])
                    .input(spring, PedotTMA, 4)
                    .input(NANO_PIC_CHIP, 2)
                    .input(circuit, MarkerMaterials.Tier.UEV)
                    .input(VOLTAGE_COIL_UEV, 2)
                    .fluidInputs(SodiumPotassium.getFluid(14000))
                    .fluidInputs(SolderingAlloy.getFluid(11520))
                    .output(ENERGY_OUTPUT_HATCH[UEV])
                    .EUt(VA[UEV])
                    .duration(1200)
                    .stationResearch(b -> b
                            .researchStack(ENERGY_OUTPUT_HATCH[UHV].getStackForm())
                            .CWUt(256)
                            .EUt(VA[UHV]))
                    .buildAndRegister();

            //  UIV
            ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(HULL[UIV])
                    .input(cableGtSingle, Solarium, 4)
                    .input(PICO_PIC_CHIP, 2)
                    .input(circuit, MarkerMaterials.Tier.UIV)
                    .input(VOLTAGE_COIL_UIV, 2)
                    .fluidInputs(SodiumPotassium.getFluid(16000))
                    .fluidInputs(SolderingAlloy.getFluid(23040))
                    .output(ENERGY_INPUT_HATCH[UIV])
                    .EUt(VA[UIV])
                    .duration(1400)
                    .stationResearch(b -> b
                            .researchStack(ENERGY_INPUT_HATCH[UEV].getStackForm())
                            .CWUt(512)
                            .EUt(VA[UEV]))
                    .buildAndRegister();

            ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(HULL[UIV])
                    .input(spring, Solarium, 4)
                    .input(PICO_PIC_CHIP, 2)
                    .input(circuit, MarkerMaterials.Tier.UIV)
                    .input(VOLTAGE_COIL_UIV, 2)
                    .fluidInputs(SodiumPotassium.getFluid(16000))
                    .fluidInputs(SolderingAlloy.getFluid(23040))
                    .output(ENERGY_OUTPUT_HATCH[UIV])
                    .EUt(VA[UIV])
                    .duration(1400)
                    .stationResearch(b -> b
                            .researchStack(ENERGY_OUTPUT_HATCH[UEV].getStackForm())
                            .CWUt(512)
                            .EUt(VA[UEV]))
                    .buildAndRegister();

            //  UXV
            ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(HULL[UXV])
                    .input(cableGtSingle, Hypogen, 4)
                    .input(PICO_PIC_CHIP, 2)
                    .input(circuit, MarkerMaterials.Tier.UXV)
                    .input(VOLTAGE_COIL_UXV, 2)
                    .fluidInputs(SodiumPotassium.getFluid(18000))
                    .fluidInputs(SolderingAlloy.getFluid(46080))
                    .output(ENERGY_INPUT_HATCH[UXV])
                    .EUt(VA[UXV])
                    .duration(1600)
                    .stationResearch(b -> b
                            .researchStack(ENERGY_INPUT_HATCH[UIV].getStackForm())
                            .CWUt(1024)
                            .EUt(VA[UIV]))
                    .buildAndRegister();

            ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(HULL[UXV])
                    .input(spring, Hypogen, 4)
                    .input(PICO_PIC_CHIP, 2)
                    .input(circuit, MarkerMaterials.Tier.UXV)
                    .input(VOLTAGE_COIL_UXV, 2)
                    .fluidInputs(SodiumPotassium.getFluid(18000))
                    .fluidInputs(SolderingAlloy.getFluid(46080))
                    .output(ENERGY_OUTPUT_HATCH[UXV])
                    .EUt(VA[UXV])
                    .duration(1600)
                    .stationResearch(b -> b
                            .researchStack(ENERGY_OUTPUT_HATCH[UIV].getStackForm())
                            .CWUt(1024)
                            .EUt(VA[UIV]))
                    .buildAndRegister();

            //  OpV
            ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(HULL[OpV])
                    .input(cableGtSingle, Galaxium, 4)
                    .input(FEMTO_PIC_CHIP, 2)
                    .input(circuit, MarkerMaterials.Tier.OpV)
                    .input(VOLTAGE_COIL_OpV, 2)
                    .fluidInputs(SodiumPotassium.getFluid(20000))
                    .fluidInputs(SolderingAlloy.getFluid(92160))
                    .output(ENERGY_INPUT_HATCH[OpV])
                    .EUt(VA[OpV])
                    .duration(1800)
                    .stationResearch(b -> b
                            .researchStack(ENERGY_INPUT_HATCH[UXV].getStackForm())
                            .CWUt(2048)
                            .EUt(VA[UXV]))
                    .buildAndRegister();

            ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(HULL[OpV])
                    .input(spring, Galaxium, 4)
                    .input(FEMTO_PIC_CHIP, 2)
                    .input(circuit, MarkerMaterials.Tier.OpV)
                    .input(VOLTAGE_COIL_OpV, 2)
                    .fluidInputs(SodiumPotassium.getFluid(20000))
                    .fluidInputs(SolderingAlloy.getFluid(92160))
                    .output(ENERGY_OUTPUT_HATCH[OpV])
                    .EUt(VA[OpV])
                    .duration(1800)
                    .stationResearch(b -> b
                            .researchStack(ENERGY_OUTPUT_HATCH[UXV].getStackForm())
                            .CWUt(2048)
                            .EUt(VA[UXV]))
                    .buildAndRegister();
        }
    }

    private static void EnergyHatches4A() {

        //  Delete vanilla UHV recipes
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, ENERGY_INPUT_HATCH[UHV].getStackForm(), OreDictUnifier.get(wireGtQuadruple, Europium, 2), OreDictUnifier.get(plate, Neutronium, 2));
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, ENERGY_OUTPUT_HATCH[UHV].getStackForm(), OreDictUnifier.get(wireGtQuadruple, Europium, 2), OreDictUnifier.get(plate, Neutronium, 2));

        //  fixme it seems ceu dev missing these... so if this recipe be deleted in future versions, this change should delete.
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, TRANSFORMER[ZPM].getStackForm(), ENERGY_OUTPUT_HATCH[ZPM].getStackForm(), OreDictUnifier.get(wireGtQuadruple, VanadiumGallium, 2), OreDictUnifier.get(plate, NaquadahAlloy, 2));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(ENERGY_OUTPUT_HATCH[ZPM])
                .input(wireGtQuadruple, VanadiumGallium, 2)
                .input(plate, NaquadahAlloy, 2)
                .output(ENERGY_OUTPUT_HATCH_4A[3]) // from EV to ZPM
                .EUt(VA[LuV])
                .duration(100)
                .buildAndRegister();

        if (GTLiteConfigHolder.machines.enableLVtoHV4AEnergyHatch) {
            //  4A output addons for LV, MV, HV
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(ENERGY_OUTPUT_HATCH[LV])
                    .input(wireGtQuadruple, Tin, 2)
                    .input(plate, Steel, 2)
                    .output(OUTPUT_ENERGY_HATCH_4A[0])
                    .EUt(VA[ULV])
                    .duration(100)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(ENERGY_OUTPUT_HATCH[MV])
                    .input(wireGtQuadruple, Copper, 2)
                    .input(plate, Aluminium, 2)
                    .output(OUTPUT_ENERGY_HATCH_4A[1])
                    .EUt(VA[LV])
                    .duration(100)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(ENERGY_OUTPUT_HATCH[HV])
                    .input(wireGtQuadruple, Gold, 2)
                    .input(plate, StainlessSteel, 2)
                    .output(OUTPUT_ENERGY_HATCH_4A[2])
                    .EUt(VA[MV])
                    .duration(100)
                    .buildAndRegister();
        }

        //  UHV
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(ENERGY_INPUT_HATCH[UHV])
                .input(wireGtQuadruple, Europium, 2)
                .input(plate, Orichalcum, 2)
                .output(ENERGY_INPUT_HATCH_4A[5]) // from IV to UHV
                .EUt(VA[UV])
                .duration(100)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(ENERGY_OUTPUT_HATCH[UHV])
                .input(wireGtQuadruple, Europium, 2)
                .input(plate, Orichalcum, 2)
                .output(ENERGY_OUTPUT_HATCH_4A[5]) // from EV to UHV
                .EUt(VA[UV])
                .duration(100)
                .buildAndRegister();

        if (GTLiteConfigHolder.machines.enableHighTier4AEnergyHatch) {
            //  UEV
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(ENERGY_INPUT_HATCH[UEV])
                    .input(wireGtQuadruple, PedotTMA, 2)
                    .input(plate, Adamantium, 2)
                    .output(INPUT_ENERGY_HATCH_4A[0]) // from gtlitecore
                    .EUt(VA[UHV])
                    .duration(100)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(ENERGY_OUTPUT_HATCH[UEV])
                    .input(wireGtQuadruple, PedotTMA, 2)
                    .input(plate, Adamantium, 2)
                    .output(OUTPUT_ENERGY_HATCH_4A[3]) // from gtlitecore
                    .EUt(VA[UHV])
                    .duration(100)
                    .buildAndRegister();

            //  UIV
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(ENERGY_INPUT_HATCH[UIV])
                    .input(wireGtQuadruple, Solarium, 2)
                    .input(plate, Infinity, 2)
                    .output(INPUT_ENERGY_HATCH_4A[1]) // from gtlitecore
                    .EUt(VA[UEV])
                    .duration(100)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(ENERGY_OUTPUT_HATCH[UIV])
                    .input(wireGtQuadruple, Solarium, 2)
                    .input(plate, Infinity, 2)
                    .output(OUTPUT_ENERGY_HATCH_4A[4]) // from gtlitecore
                    .EUt(VA[UEV])
                    .duration(100)
                    .buildAndRegister();

            //  UXV
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(ENERGY_INPUT_HATCH[UXV])
                    .input(wireGtQuadruple, Hypogen, 2)
                    .input(plate, CosmicNeutronium, 2)
                    .output(INPUT_ENERGY_HATCH_4A[2]) // from gtlitecore
                    .EUt(VA[UIV])
                    .duration(100)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(ENERGY_OUTPUT_HATCH[UXV])
                    .input(wireGtQuadruple, Hypogen, 2)
                    .input(plate, CosmicNeutronium, 2)
                    .output(OUTPUT_ENERGY_HATCH_4A[5]) // from gtlitecore
                    .EUt(VA[UIV])
                    .duration(100)
                    .buildAndRegister();

            //  OpV
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(ENERGY_INPUT_HATCH[OpV])
                    .input(wireGtQuadruple, Galaxium, 2)
                    .input(plate, Spacetime, 2)
                    .output(INPUT_ENERGY_HATCH_4A[3]) // from gtlitecore
                    .EUt(VA[UXV])
                    .duration(100)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(ENERGY_OUTPUT_HATCH[OpV])
                    .input(wireGtQuadruple, Galaxium, 2)
                    .input(plate, Spacetime, 2)
                    .output(OUTPUT_ENERGY_HATCH_4A[6]) // from gtlitecore
                    .EUt(VA[UXV])
                    .duration(100)
                    .buildAndRegister();
        }
    }

    private static void EnergyHatches16A() {

        //  Delete vanilla UHV recipes
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, HI_AMP_TRANSFORMER[UV].getStackForm(), ENERGY_INPUT_HATCH_4A[5].getStackForm(2), OreDictUnifier.get(wireGtOctal, Europium, 2), OreDictUnifier.get(plate, Neutronium, 4));
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, HI_AMP_TRANSFORMER[UV].getStackForm(), ENERGY_OUTPUT_HATCH_4A[5].getStackForm(), OreDictUnifier.get(wireGtOctal, Europium, 2), OreDictUnifier.get(plate, Neutronium, 4));

        if (GTLiteConfigHolder.machines.enableLVtoEV16AEnergyHatch) {
            //  16A output addons for LV, MV, HV, EV
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HI_AMP_TRANSFORMER[LV])
                    .input(OUTPUT_ENERGY_HATCH_4A[0])
                    .input(wireGtOctal, Tin, 2)
                    .input(plate, Steel, 4)
                    .output(OUTPUT_ENERGY_HATCH_16A[0])
                    .EUt(VA[ULV])
                    .duration(200)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HI_AMP_TRANSFORMER[MV])
                    .input(OUTPUT_ENERGY_HATCH_4A[1])
                    .input(wireGtOctal, Copper, 2)
                    .input(plate, Aluminium, 4)
                    .output(OUTPUT_ENERGY_HATCH_16A[1])
                    .EUt(VA[LV])
                    .duration(200)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HI_AMP_TRANSFORMER[HV])
                    .input(OUTPUT_ENERGY_HATCH_4A[2])
                    .input(wireGtOctal, Gold, 2)
                    .input(plate, StainlessSteel, 4)
                    .output(OUTPUT_ENERGY_HATCH_16A[2])
                    .EUt(VA[MV])
                    .duration(200)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HI_AMP_TRANSFORMER[EV])
                    .input(ENERGY_OUTPUT_HATCH_4A[0])
                    .input(wireGtOctal, Aluminium, 2)
                    .input(plate, Titanium, 4)
                    .output(OUTPUT_ENERGY_HATCH_16A[3])
                    .EUt(VA[HV])
                    .duration(200)
                    .buildAndRegister();
        }

        //  UHV
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HI_AMP_TRANSFORMER[UHV])
                .input(ENERGY_INPUT_HATCH_4A[5], 2)
                .input(wireGtOctal, Europium, 2)
                .input(plate, Orichalcum, 4)
                .output(ENERGY_INPUT_HATCH_16A[4])
                .EUt(VA[UV])
                .duration(200)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HI_AMP_TRANSFORMER[UHV])
                .input(ENERGY_OUTPUT_HATCH_4A[5])
                .input(wireGtOctal, Europium, 2)
                .input(plate, Orichalcum, 4)
                .output(ENERGY_OUTPUT_HATCH_16A[4])
                .EUt(VA[UV])
                .duration(200)
                .buildAndRegister();

        if (GTLiteConfigHolder.machines.enableHighTier16AEnergyHatch) {
            //  UEV
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HI_AMP_TRANSFORMER[UEV])
                    .input(INPUT_ENERGY_HATCH_4A[0], 2) // from gtlitecore
                    .input(wireGtOctal, PedotTMA, 2)
                    .input(plate, Adamantium, 4)
                    .output(INPUT_ENERGY_HATCH_16A[0]) // from gtlitecore
                    .EUt(VA[UHV])
                    .duration(200)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HI_AMP_TRANSFORMER[UEV])
                    .input(OUTPUT_ENERGY_HATCH_4A[3]) // from gtlitecore
                    .input(wireGtOctal, PedotTMA, 2)
                    .input(plate, Adamantium, 4)
                    .output(OUTPUT_ENERGY_HATCH_16A[4]) // from gtlitecore
                    .EUt(VA[UHV])
                    .duration(200)
                    .buildAndRegister();

            //  UIV
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HI_AMP_TRANSFORMER[UIV])
                    .input(INPUT_ENERGY_HATCH_4A[1], 2) // from gtlitecore
                    .input(wireGtOctal, Solarium, 2)
                    .input(plate, Infinity, 4)
                    .output(INPUT_ENERGY_HATCH_16A[1]) // from gtlitecore
                    .EUt(VA[UEV])
                    .duration(200)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HI_AMP_TRANSFORMER[UIV])
                    .input(OUTPUT_ENERGY_HATCH_4A[4]) // from gtlitecore
                    .input(wireGtOctal, Solarium, 2)
                    .input(plate, Infinity, 4)
                    .output(OUTPUT_ENERGY_HATCH_16A[5]) // from gtlitecore
                    .EUt(VA[UEV])
                    .duration(200)
                    .buildAndRegister();

            //  UXV
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HI_AMP_TRANSFORMER[UXV])
                    .input(INPUT_ENERGY_HATCH_4A[2], 2) // from gtlitecore
                    .input(wireGtOctal, Hypogen, 2)
                    .input(plate, CosmicNeutronium, 4)
                    .output(INPUT_ENERGY_HATCH_16A[2]) // from gtlitecore
                    .EUt(VA[UIV])
                    .duration(200)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HI_AMP_TRANSFORMER[UXV])
                    .input(OUTPUT_ENERGY_HATCH_4A[5]) // from gtlitecore
                    .input(wireGtOctal, Hypogen, 2)
                    .input(plate, CosmicNeutronium, 4)
                    .output(OUTPUT_ENERGY_HATCH_16A[6]) // from gtlitecore
                    .EUt(VA[UIV])
                    .duration(200)
                    .buildAndRegister();

            //  OpV
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HI_AMP_TRANSFORMER[OpV])
                    .input(INPUT_ENERGY_HATCH_4A[3], 2) // from gtlitecore
                    .input(wireGtOctal, Galaxium, 2)
                    .input(plate, Spacetime, 4)
                    .output(INPUT_ENERGY_HATCH_16A[3]) // from gtlitecore
                    .EUt(VA[UXV])
                    .duration(200)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HI_AMP_TRANSFORMER[OpV])
                    .input(OUTPUT_ENERGY_HATCH_4A[6]) // from gtlitecore
                    .input(wireGtOctal, Galaxium, 2)
                    .input(plate, Spacetime, 4)
                    .output(OUTPUT_ENERGY_HATCH_16A[7]) // from gtlitecore
                    .EUt(VA[UXV])
                    .duration(200)
                    .buildAndRegister();
        }
    }

    private static void EnergyHatches64A() {

        //  Delete vanilla UHV recipes
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, POWER_TRANSFORMER[UV].getStackForm(), ENERGY_INPUT_HATCH_16A[4].getStackForm(), OreDictUnifier.get(wireGtHex, Europium, 2), OreDictUnifier.get(plate, Neutronium, 6));
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, POWER_TRANSFORMER[UV].getStackForm(), ENERGY_OUTPUT_HATCH_16A[4].getStackForm(), OreDictUnifier.get(wireGtHex, Europium, 2), OreDictUnifier.get(plate, Neutronium, 6));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(POWER_TRANSFORMER[UHV])
                .input(ENERGY_INPUT_HATCH_16A[4])
                .input(wireGtHex, Europium, 2)
                .input(plate, Orichalcum, 6)
                .output(SUBSTATION_ENERGY_INPUT_HATCH[4])
                .EUt(VA[UV])
                .duration(400)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(POWER_TRANSFORMER[UHV])
                .input(ENERGY_OUTPUT_HATCH_16A[4])
                .input(wireGtHex, Europium, 2)
                .input(plate, Orichalcum, 6)
                .output(SUBSTATION_ENERGY_OUTPUT_HATCH[4])
                .EUt(VA[UV])
                .duration(400)
                .buildAndRegister();

        if (GTLiteConfigHolder.machines.enableHighTier64ASubstationEnergyHatch) {
            //  UEV
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(POWER_TRANSFORMER[UEV])
                    .input(INPUT_ENERGY_HATCH_16A[0])
                    .input(wireGtHex, PedotTMA, 2)
                    .input(plate, Adamantium, 6)
                    .output(SUBSTATION_INPUT_ENERGY_HATCH[0])
                    .EUt(VA[UHV])
                    .duration(400)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(POWER_TRANSFORMER[UEV])
                    .input(OUTPUT_ENERGY_HATCH_16A[4])
                    .input(wireGtHex, PedotTMA, 2)
                    .input(plate, Adamantium, 6)
                    .output(SUBSTATION_OUTPUT_ENERGY_HATCH[0])
                    .EUt(VA[UHV])
                    .duration(400)
                    .buildAndRegister();

            //  UIV
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(POWER_TRANSFORMER[UIV])
                    .input(INPUT_ENERGY_HATCH_16A[1])
                    .input(wireGtHex, Solarium, 2)
                    .input(plate, Infinity, 6)
                    .output(SUBSTATION_INPUT_ENERGY_HATCH[1])
                    .EUt(VA[UEV])
                    .duration(400)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(POWER_TRANSFORMER[UIV])
                    .input(OUTPUT_ENERGY_HATCH_16A[5])
                    .input(wireGtHex, Solarium, 2)
                    .input(plate, Infinity, 6)
                    .output(SUBSTATION_OUTPUT_ENERGY_HATCH[1])
                    .EUt(VA[UEV])
                    .duration(400)
                    .buildAndRegister();

            //  UXV
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(POWER_TRANSFORMER[UXV])
                    .input(INPUT_ENERGY_HATCH_16A[2])
                    .input(wireGtHex, Hypogen, 2)
                    .input(plate, CosmicNeutronium, 6)
                    .output(SUBSTATION_INPUT_ENERGY_HATCH[2])
                    .EUt(VA[UIV])
                    .duration(400)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(POWER_TRANSFORMER[UXV])
                    .input(OUTPUT_ENERGY_HATCH_16A[6])
                    .input(wireGtHex, Hypogen, 2)
                    .input(plate, CosmicNeutronium, 6)
                    .output(SUBSTATION_OUTPUT_ENERGY_HATCH[2])
                    .EUt(VA[UIV])
                    .duration(400)
                    .buildAndRegister();

            //  OpV
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(POWER_TRANSFORMER[OpV])
                    .input(INPUT_ENERGY_HATCH_16A[3])
                    .input(wireGtHex, Galaxium, 2)
                    .input(plate, Spacetime, 6)
                    .output(SUBSTATION_INPUT_ENERGY_HATCH[3])
                    .EUt(VA[UXV])
                    .duration(400)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(POWER_TRANSFORMER[OpV])
                    .input(OUTPUT_ENERGY_HATCH_16A[7])
                    .input(wireGtHex, Galaxium, 2)
                    .input(plate, Spacetime, 6)
                    .output(SUBSTATION_OUTPUT_ENERGY_HATCH[3])
                    .EUt(VA[UXV])
                    .duration(400)
                    .buildAndRegister();
        }
    }

    private static void Transformers() {

        //  UHV
        ModHandler.addShapedRecipe(true, "machine.transformer.uhv", TRANSFORMER[UHV].getStackForm(),
                "PWW", "WH ", "PWW",
                'W', new UnificationEntry(cableGtSingle, Europium),
                'P', NANO_PIC_CHIP,
                'H', HULL[UHV].getStackForm());

        if (GTLiteConfigHolder.machines.enableHighTierTransformer) {
            //  UEV
            ModHandler.addShapedRecipe(true, "machine.transformer.uev", TRANSFORMER[UEV].getStackForm(),
                    "PWW", "WH ", "PWW",
                    'W', new UnificationEntry(cableGtSingle, PedotTMA),
                    'P', NANO_PIC_CHIP,
                    'H', HULL[UEV].getStackForm());

            //  UIV
            ModHandler.addShapedRecipe(true, "machine.transformer.uiv", TRANSFORMER[UIV].getStackForm(),
                    "PWW", "WH ", "PWW",
                    'W', new UnificationEntry(cableGtSingle, Solarium),
                    'P', PICO_PIC_CHIP,
                    'H', HULL[UIV].getStackForm());

            //  UXV
            ModHandler.addShapedRecipe(true, "machine.transformer.uxv", TRANSFORMER[UXV].getStackForm(),
                    "PWW", "WH ", "PWW",
                    'W', new UnificationEntry(cableGtSingle, Hypogen),
                    'P', PICO_PIC_CHIP,
                    'H', HULL[UXV].getStackForm());

            //  OpV
            ModHandler.addShapedRecipe(true, "machine.transformer.opv", TRANSFORMER[OpV].getStackForm(),
                    "PWW", "WH ", "PWW",
                    'W', new UnificationEntry(cableGtSingle, Galaxium),
                    'P', FEMTO_PIC_CHIP,
                    'H', HULL[OpV].getStackForm());
        }

    }

    private static void PowerTransformers() {

        //  UHV
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HI_AMP_TRANSFORMER[UHV])
                .input(ELECTRIC_PUMP_IV)
                .input(cableGtOctal, PedotTMA)
                .input(cableGtHex, Europium, 2)
                .input(springSmall, Europium)
                .input(spring, PedotTMA)
                .fluidInputs(Lubricant.getFluid(2000))
                .output(POWER_TRANSFORMER[UHV])
                .EUt(VA[UHV])
                .duration(200)
                .buildAndRegister();

        if (GTLiteConfigHolder.machines.enableHighTierPowerTransformer) {
            //  UEV
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HI_AMP_TRANSFORMER[UEV])
                    .input(ELECTRIC_PUMP_LuV)
                    .input(cableGtOctal, Solarium)
                    .input(cableGtHex, PedotTMA, 2)
                    .input(springSmall, PedotTMA)
                    .input(spring, Solarium)
                    .fluidInputs(Lubricant.getFluid(2000))
                    .output(POWER_TRANSFORMER[UEV])
                    .EUt(VA[UEV])
                    .duration(200)
                    .buildAndRegister();

            //  UIV
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HI_AMP_TRANSFORMER[UIV])
                    .input(ELECTRIC_PUMP_LuV)
                    .input(cableGtOctal, Hypogen)
                    .input(cableGtHex, Solarium, 2)
                    .input(springSmall, Solarium)
                    .input(spring, Hypogen)
                    .fluidInputs(Lubricant.getFluid(2000))
                    .output(POWER_TRANSFORMER[UIV])
                    .EUt(VA[UIV])
                    .duration(200)
                    .buildAndRegister();

            //  UXV
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HI_AMP_TRANSFORMER[UXV])
                    .input(ELECTRIC_PUMP_ZPM)
                    .input(cableGtOctal, Galaxium)
                    .input(cableGtHex, Hypogen, 2)
                    .input(springSmall, Hypogen)
                    .input(spring, Galaxium)
                    .fluidInputs(Lubricant.getFluid(2000))
                    .output(POWER_TRANSFORMER[UXV])
                    .EUt(VA[UXV])
                    .duration(200)
                    .buildAndRegister();

            //  OpV
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HI_AMP_TRANSFORMER[OpV])
                    .input(ELECTRIC_PUMP_ZPM)
                    .input(cableGtOctal, Universium)
                    .input(cableGtHex, Hypogen, 2)
                    .input(springSmall, Hypogen)
                    .input(spring, Universium)
                    .fluidInputs(Lubricant.getFluid(2000))
                    .output(POWER_TRANSFORMER[OpV])
                    .EUt(VA[OpV])
                    .duration(200)
                    .buildAndRegister();
        }
    }

    private static void HiAmpTransformers() {

        //  UHV
        ModHandler.addShapedRecipe(true, "machine.transformer.hi_amp.uhv", HI_AMP_TRANSFORMER[UHV].getStackForm(),
                "VQQ", "PH ", "VQQ",
                'V', VOLTAGE_COIL_UHV,
                'H', HULL[UHV].getStackForm(),
                'P', new UnificationEntry(cableGtQuadruple, PedotTMA),
                'Q', new UnificationEntry(cableGtQuadruple, Europium));

        if (GTLiteConfigHolder.machines.enableHighTierHiAmpTransformer) {
            //  UEV
            ModHandler.addShapedRecipe(true, "machine.transformer.hi_amp.uev", HI_AMP_TRANSFORMER[UEV].getStackForm(),
                    "VQQ", "PH ", "VQQ",
                    'V', VOLTAGE_COIL_UEV,
                    'H', HULL[UEV].getStackForm(),
                    'P', new UnificationEntry(cableGtQuadruple, Solarium),
                    'Q', new UnificationEntry(cableGtQuadruple, PedotTMA));

            //  UIV
            ModHandler.addShapedRecipe(true, "machine.transformer.hi_amp.uiv", HI_AMP_TRANSFORMER[UIV].getStackForm(),
                    "VQQ", "PH ", "VQQ",
                    'V', VOLTAGE_COIL_UIV,
                    'H', HULL[UIV].getStackForm(),
                    'P', new UnificationEntry(cableGtQuadruple, Hypogen),
                    'Q', new UnificationEntry(cableGtQuadruple, Solarium));

            //  UXV
            ModHandler.addShapedRecipe(true, "machine.transformer.hi_amp.uxv", HI_AMP_TRANSFORMER[UXV].getStackForm(),
                    "VQQ", "PH ", "VQQ",
                    'V', VOLTAGE_COIL_UXV,
                    'H', HULL[UXV].getStackForm(),
                    'P', new UnificationEntry(cableGtQuadruple, Galaxium),
                    'Q', new UnificationEntry(cableGtQuadruple, Hypogen));

            //  OpV
            ModHandler.addShapedRecipe(true, "machine.transformer.hi_amp.opv", HI_AMP_TRANSFORMER[OpV].getStackForm(),
                    "VQQ", "PH ", "VQQ",
                    'V', VOLTAGE_COIL_OpV,
                    'H', HULL[OpV].getStackForm(),
                    'P', new UnificationEntry(cableGtQuadruple, Universium),
                    'Q', new UnificationEntry(cableGtQuadruple, Galaxium));
        }
    }
}
