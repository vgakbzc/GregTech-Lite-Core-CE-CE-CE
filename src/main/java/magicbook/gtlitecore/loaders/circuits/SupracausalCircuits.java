package magicbook.gtlitecore.loaders.circuits;

import gregtech.api.metatileentity.multiblock.CleanroomType;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gregtechfoodoption.GTFOMaterialHandler.AceticAnhydride;
import static magicbook.gtlitecore.api.GTLiteValues.MINUTE;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix.swarm;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class SupracausalCircuits {

    public static void init() {
        CircuitBoard();
        CircuitComponent();
        SMDs();
        SoC();
        Circuits();
    }

    private static void CircuitBoard() {

        //  Supracausal Board
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(COSMIC_INFORMATION_MODULE)
                .input(plate, BlackDwarfMatter, 2)
                .input(plate, Hypogen, 2)
                .input(STABILIZED_WORMHOLE_GENERATOR)
                .input(swarm, CarbonNanotube)
                .input(wireFine, Hikarium, 8)
                .fluidInputs(Galaxium.getFluid(L))
                .output(SPACETIME_CONDENSER)
                .EUt(VA[UXV])
                .duration(SECOND)
                .stationResearch(b -> b
                        .researchStack(COSMIC_INFORMATION_MODULE.getStackForm())
                        .EUt(VA[UXV])
                        .CWUt(256))
                .buildAndRegister();

        //  Supracausal Processing Unit
        SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
                .input(frameGt, TantalumHafniumSeaborgiumCarbide)
                .input(SPACETIME_CONDENSER)
                .input(plate, CosmicFabric, 4)
                .input(NUCLEAR_CLOCK)
                .input(TOPOLOGICAL_MANIPULATOR_UNIT)
                .input(GRAVITON_TRANSDUCER)
                .input(EIGENFOLDED_SPACETIME_MANIFOLD)
                .input(RELATIVISTIC_SPINORIAL_MEMORY_SYSTEM)
                .input(BOSE_EINSTEIN_CONDENSATE, 2)
                .input(MANIFOLD_OSCILLATORY_POWER_CELL, 4)
                .input(wireGtSingle, HeavyQuarkDegenerateMatter, 2)
                .fluidInputs(CosmicComputingMixture.getFluid(4000))
                .fluidInputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(2000))
                .fluidInputs(Spacetime.getFluid(1000))
                .fluidInputs(CosmicNeutronium.getFluid(1000))
                .output(LIGHT_CONE_MODULE, 2)
                .EUt(VA[UXV])
                .duration(SECOND)
                .tier(5)
                .buildAndRegister();

    }

    private static void CircuitComponent() {

        //  Contained RN Singularity -> Contained KN Singularity
        //  back to Stellar Furnace recipes

        //  Contained KN Singularity -> Contained Kerr Singularity
        CANNER_RECIPES.recipeBuilder()
                .input(CONTAINED_KN_SINGULARITY)
                .fluidInputs(FreeElectronGas.getFluid(1000))
                .output(CONTAINED_KERR_SINGULARITY)
                .EUt(VA[UEV])
                .duration(2 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Macrowormhole Generator -> Recursively Folded Negative Space -> Eigenfolded Spacetime Manifold
        //  back to Stellar Furnace recipes

        //  Graviton Transducer
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(QCD_PROTECTIVE_PLATING, 2)
                .input(CONTAINED_RN_SINGULARITY)
                .input(MICROWORMHOLE_GENERATOR)
                .input(SENSOR_UXV)
                .fluidInputs(HiggsBosons.getFluid(L * 4))
                .output(GRAVITON_TRANSDUCER)
                .EUt(VA[UXV])
                .duration(10 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Relativistic Spinorial Memory
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Neutronium)
                .input(FIELD_GENERATOR_UXV)
                .input(BATTERY_UXV_LANTHANUM_NICKEL_OXIDE)
                .input(wireFine, HeavyQuarkDegenerateMatter, 4)
                .fluidInputs(Instantons.getFluid(L * 4))
                .output(RELATIVISTIC_SPINORIAL_MEMORY_SYSTEM)
                .EUt(VA[UXV])
                .duration(10 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Topological Manipulator Unit
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(QCD_PROTECTIVE_PLATING)
                .input(plate, Spacetime)
                .input(CONTAINED_KN_SINGULARITY)
                .input(EMITTER_UXV)
                .fluidInputs(TemporalFluid.getFluid(L * 4))
                .output(TOPOLOGICAL_MANIPULATOR_UNIT)
                .EUt(VA[UXV])
                .duration(10 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Microwormhole Generator
        PRECISE_ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Orichalcum)
                .input(FIELD_GENERATOR_UHV)
                .input(CONTAINED_KERR_SINGULARITY)
                .input(wireFine, Vibranium, 4)
                .fluidInputs(Taranium.getFluid(L * 4))
                .output(MICROWORMHOLE_GENERATOR)
                .EUt(VA[UXV])
                .duration(SECOND)
                .tier(7) // UXV
                .buildAndRegister();

        //  Macrowormhole Generator
        SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
                .input(plate, AstralTitanium)
                .input(FIELD_GENERATOR_UEV)
                .input(CONTAINED_HIGH_DENSITY_PROTONIC_MATTER)
                .input(MICROWORMHOLE_GENERATOR)
                .input(CONTAINED_KERR_SINGULARITY)
                .input(BATTERY_UEV_LITHIUM_SULFIDE)
                .fluidInputs(CelestialTungsten.getFluid(L * 4))
                .output(MACROWORMHOLE_GENERATOR)
                .EUt(VA[UXV])
                .duration(SECOND)
                .tier(5)
                .buildAndRegister();

        //  Stabilized Wormhole Generator
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(plate, Periodicium)
                .input(FIELD_GENERATOR_UXV)
                .input(CONTAINED_EXOTIC_MATTER)
                .input(MACROWORMHOLE_GENERATOR)
                .input(BATTERY_UXV_LANTHANUM_NICKEL_OXIDE)
                .fluidInputs(QuantumchromodynamicallyConfinedMatter.getFluid(L * 4))
                .output(STABILIZED_WORMHOLE_GENERATOR)
                .EUt(VA[UXV])
                .duration(SECOND)
                .stationResearch(b -> b
                        .researchStack(MACROWORMHOLE_GENERATOR.getStackForm())
                        .EUt(VA[UXV])
                        .CWUt(256))
                .buildAndRegister();

        //  Contained High Density Protonic Matter -> Contained Exotic Matter
        //  back to Stellar Furnace recipes

        //  Supracausal RAM
        FORMING_PRESS_RECIPES.recipeBuilder()
                .input(RANDOM_ACCESS_MEMORY)
                .input(plate, TransitionLAlloy, 2)
                .input(plate, BlackDwarfMatter, 2)
                .input(springSmall, WhiteDwarfMatter)
                .input(wireFine, HeavyQuarkDegenerateMatter, 4)
                .input(bolt, Taranium, 2)
                .output(SUPRACAUSAL_MEMORY_CHIP, 4)
                .EUt(VA[UXV])
                .duration(10 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

    }

    private static void SMDs() {

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireFine, WhiteDwarfMatter, 8)
                .input(plate, NeutroniumNanotube)
                .input(plate, Periodicium)
                .fluidInputs(FullerenePolymerMatrix.getFluid(L * 2))
                .output(SUPRACAUSAL_TRANSISTOR, 32)
                .EUt(VA[UIV])
                .duration(8 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CVD_UNIT_RECIPES.recipeBuilder()
                .input(dust, ChargedCaesiumCeriumCobaltIndiumAlloy)
                .input(wireFine, QuantumchromodynamicallyConfinedMatter, 4)
                .fluidInputs(FullerenePolymerMatrix.getFluid(L * 2))
                .output(SUPRACAUSAL_RESISTOR, 32)
                .EUt(VA[UIV])
                .duration(8 * SECOND)
                .temperature(6675)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_CVD_UNIT_RECIPES.recipeBuilder()
                .input(wireFine, BlackDwarfMatter, 8)
                .input(plate, Hypogen)
                .fluidInputs(FullerenePolymerMatrix.getFluid(L * 2))
                .output(SUPRACAUSAL_CAPACITOR, 32)
                .EUt(VA[UIV])
                .duration(8 * SECOND)
                .temperature(7432)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(dust, Spacetime)
                .input(dust, MagnetoHydrodynamicallyConstrainedStarMatter)
                .input(wireFine, HeavyQuarkDegenerateMatter, 8)
                .fluidInputs(FullerenePolymerMatrix.getFluid(L * 2))
                .output(SUPRACAUSAL_DIODE, 32)
                .EUt(VA[UIV])
                .duration(8 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ION_IMPLANTATOR_RECIPES.recipeBuilder()
                .input(ring, TantalumHafniumSeaborgiumCarbide, 2)
                .input(wireFine, CosmicNeutronium, 4)
                .fluidInputs(FullerenePolymerMatrix.getFluid(L * 2))
                .output(SUPRACAUSAL_INDUCTOR, 32)
                .EUt(VA[UIV])
                .duration(8 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }

    private static void SoC() {

        ElectricalSiliconNitrideFilm();

        PhotonShieldingContainmentUnit();

        //  Quantum Amplitude Squeezed Light Stabilizer

        /*
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(PHOTON_SHIELDING_CONTAINMENT_UNIT)
                .input(COATED_PHOTONIC_CRYSTAL_FILM)
                .input(plate, GalliumNitride, 2)
                .input(plate, EnrichedNaquadahAlloy, 2)
                .input(SENSOR_OpV)
                .input(lens, Zircophyllite)
                .input(OPTICAL_LASER_CONTROL_UNIT)
                .input(ROTATING_TRANSPARENT_SURFACE)
                .input(RYDBERG_SPINORIAL_ASSEMBLY)
                .input(PHOTON, 4)
                .input(BATTERY_MAX_LANTHANUM_NICKEL_OXIDE)
                .input(PIEZOELECTRIC_CRYSTAL, 8)
                .input(TOPOLOGICAL_INSULATOR_TUBE, 2)
                .input(OPTICAL_FIBER, 16)
                .fluidInputs(HalogenMixture.getFluid(16000))
                .fluidInputs()
                .fluidInputs()
                .fluidInputs()
                .output(QUANTUM_AMPLITUDE_SQUEEZED_LIGHT_STABILIZER)
                .EUt(VA[OpV])
                .duration(SECOND)
                .stationResearch()
         */

        //  Closed Lightlike Curve Receive Unit
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRICAL_SILICON_NITRIDE_FILM)
                .input(plate, Botmium, 2)
                .input(plate, Graphene, 2)
                .input(QUANTUM_AMPLITUDE_SQUEEZED_LIGHT_STABILIZER)
                .input(CHARGED_LEPTON_TRAP_CRYSTAL)
                .input(NUCLEAR_CLOCK)
                .input(CRYOGENIC_INTERFACE)
                .input(X_RAY_LASER)
                .input(swarm, Solarium)
                .input(foil, NaquadahAlloy, 24)
                .input(bolt, SuperheavyHAlloy, 8)
                .fluidInputs(Glowstone.getFluid(30000))
                .fluidInputs(ElectrolyteReflectorMixture.getFluid(6000))
                .fluidInputs(CosmicComputingMixture.getFluid(2000))
                .fluidInputs(ResplendentDimensionallyTranscendentCatalyst.getFluid(L * 4))
                .output(CLOSED_LIGHTLIKE_CURVE_RECEIVE_UNIT)
                .EUt(VA[OpV])
                .duration(2 * SECOND)
                .stationResearch(b -> b
                        .researchStack(CLOSED_TIMELIKE_CURVE_COMPUTATIONAL_UNIT.getStackForm())
                        .CWUt(1024)
                        .EUt(VA[OpV]))
                .buildAndRegister();

    }

    /**
     * Electrical Silicon Nitride Film processing
     *
     * @author Magic_Sweepy
     *
     * <p>
     *     Realization of the idea in talk of my and my friend Gate Guardian about Optical Circuit processing,
     *     this processing also product H2XeO4 (although this is ridiculous, you should pay Xenon plasma to Plasma CVD).
     * </p>
     *
     * @since 2.8.8-beta
     */
    private static void ElectricalSiliconNitrideFilm() {

        //  CH3Cl3Si + 2H -> SiCl2H2 + CH3Cl
        CHEMICAL_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .fluidInputs(Methyltrichlorosilane.getFluid(1000))
                .fluidInputs(Hydrogen.getFluid(2000))
                .fluidOutputs(Dichlorosilane.getFluid(1000))
                .fluidOutputs(Chloromethane.getFluid(1000))
                .EUt(VA[HV])
                .duration(SECOND)
                .buildAndRegister();

        //  3SiCl2H2 + 4HNO3 + 3Xe (plasma) -> Si3N4 + 3H2XeO4 + 4HCl + 2Cl
        PLASMA_CVD_UNIT_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_PLATE)
                .fluidInputs(Dichlorosilane.getFluid(3000))
                .fluidInputs(NitricAcid.getFluid(4000))
                .fluidInputs(Xenon.getPlasma(3000))
                .output(plate, SiliconNitride)
                .fluidOutputs(XenicAcid.getFluid(3000))
                .fluidOutputs(HydrochloricAcid.getFluid(4000))
                .fluidOutputs(Chlorine.getFluid(2000))
                .EUt(VA[UEV])
                .duration((int) (2.5 * SECOND))
                .temperature(1250)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Si3N4 -> Silicon Nitride Fiber
        AUTOCLAVE_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_EXTRUDER_WIRE)
                .input(dust, SiliconNitride)
                .fluidInputs(SilicaGelBase.getFluid(1000))
                .output(SILICON_NITRIDE_FIBER)
                .EUt(VA[IV])
                .duration((int) (3.5 * SECOND))
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Silicon Nitride Fiber -> Silicon Nitride Fiber Mesh
        COMPRESSOR_RECIPES.recipeBuilder()
                .input(SILICON_NITRIDE_FIBER, 2)
                .output(SILICON_NITRIDE_FIBER_MESH)
                .EUt(VA[HV])
                .duration(2 * SECOND)
                .buildAndRegister();

        //  Silicon Nitride Fiber Mesh -> Electrical Silicon Nitride Film
        ION_IMPLANTATOR_RECIPES.recipeBuilder()
                .notConsumable(ELECTRON_SOURCE)
                .input(SILICON_NITRIDE_FIBER_MESH)
                .input(foil, EnrichedHolmium, 4)
                .fluidInputs(FreeElectronGas.getFluid(1000))
                .output(ELECTRICAL_SILICON_NITRIDE_FILM)
                .EUt(VA[UHV])
                .duration(5 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }

    /**
     * Photon Shielding Containment Unit processing
     *
     * @author Lunene, Magic_Sweepy
     *
     * <p>
     *     Basic Processing Chain (and related Chemistry Chain) of Photon Shielding Containment Unit,
     *     which is a component of Closed Lightlike Curve Receive Unit (Supracausal SoC Component).
     *     Thanks Lunene create this chemistry chain of EDAB, I just do some tweak about actually situation.
     * </p>
     *
     * @since 2.8.8-beta
     */
    private static void PhotonShieldingContainmentUnit() {

        // ------------------------------ C6H4CO2C2H5(CH3)2N processing ------------------------------

        //  C7H8 + (HNO3)(H2SO4) -> C6H4CH3NO2 + (H2SO4)2(H2O)
        //  Player cost 3kL (HNO3)(H2SO4) and return 3kL (H2SO4)2(H2O), which return 2kL H2SO4,
        //  you can add more HNO3 to make 4kL (HNO3)(H2SO4) via 2kL H2SO4, so this step is no losses.
        CHEMICAL_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(Toluene.getFluid(1000))
                .fluidInputs(NitrationMixture.getFluid(1000))
                .fluidOutputs(Nitrotoluene.getFluid(1000))
                .fluidOutputs(DilutedSulfuricAcid.getFluid(1000))
                .EUt(VA[EV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  C6H4CH3NO2 + K2Cr2O7 + 3H2SO4 -> C6H4CO2HNO2 + Cr2(SO4)3 + 2KOH + 3H2O
        //  This step cost many H2SO4 via the first step player got, and return Cr2(SO4)3 to player.
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PotassiumDichromate, 11)
                .fluidInputs(Nitrotoluene.getFluid(1000))
                .fluidInputs(SulfuricAcid.getFluid(3000))
                .output(dust, ChromiumSulfate, 17)
                .output(dust, Potash, 6)
                .fluidOutputs(NitrobenzoicAcid.getFluid(1000))
                .fluidOutputs(Water.getFluid(3000))
                .EUt(VA[IV])
                .duration((int) (2.5 * SECOND))
                .buildAndRegister();

        //  Cr2(SO4)3 -> 2CrO3 + 3SO2
        //  This cycle allowed player use Cr2(SO4)3 to get CrO3, which is a original material
        //  of K2Cr2O7, so this step is just a part of sub cycle of this chemistry chain.
        ELECTROLYZER_RECIPES.recipeBuilder()
                .input(dust, ChromiumSulfate, 17)
                .output(dust, ChromiumTrioxide, 8)
                .fluidOutputs(SulfurDioxide.getFluid(3000))
                .EUt(VA[HV])
                .duration((int) (1.4 * SECOND))
                .buildAndRegister();

        //  C6H4CO2HNO2 + C2H6O -> C6H4CO2C2H5NO2 + H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(NitrobenzoicAcid.getFluid(1000))
                .fluidInputs(Ethanol.getFluid(1000))
                .fluidOutputs(EthylNitrobenzoate.getFluid(1000))
                .fluidOutputs(SulfuricAcid.getFluid(1000))
                .EUt(VA[MV])
                .duration((int) (4.5 * SECOND))
                .buildAndRegister();

        //  C6H4CO2C2H5NO2 + 6H -> C6H4CO2C2H5NH2 + 2H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(EthylNitrobenzoate.getFluid(1000))
                .fluidInputs(Hydrogen.getFluid(6000))
                .fluidOutputs(EthylAminobenzoate.getFluid(1000))
                .fluidOutputs(Water.getFluid(2000))
                .EUt(VA[HV])
                .duration((int) (3.2 * SECOND))
                .buildAndRegister();

        //  C6H4CO2C2H5NH2 + 2CH3Cl -> C6H4CO2C2H5(CH3)2N + 2HCl
        CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(dust, Palladium)
                .fluidInputs(EthylAminobenzoate.getFluid(1000))
                .fluidInputs(Chloromethane.getFluid(2000))
                .fluidOutputs(EthylDimethylaminobenzoate.getFluid(1000))
                .fluidOutputs(HydrochloricAcid.getFluid(2000))
                .EUt(VA[IV])
                .duration(5 * SECOND)
                .buildAndRegister();

        // ---------------------------- (CH3)3C6H2COPO(C6H5)2 processing -----------------------------

        //  2Mg + C6H5Cl + PCl3 + 3(C2H5)2O -> (C6H5)3P + 2MgCl2 + 3H2O + 14H
        CRYOGENIC_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Magnesium, 2)
                .fluidInputs(Chlorobenzene.getFluid(1000))
                .fluidInputs(PhosphorusTrichloride.getFluid(1000))
                .fluidInputs(DiethylEther.getFluid(3000))
                .output(dust, MagnesiumChloride, 6)
                .fluidOutputs(Triphenylphosphine.getFluid(1000))
                .fluidOutputs(Ice.getFluid(3000))
                .fluidOutputs(Hydrogen.getFluid(14000))
                .EUt(VA[LuV])
                .duration(8 * SECOND)
                .temperature(125)
                .buildAndRegister();

        //  C6H6 + 3CH3Cl -> C6H3(CH3)3 + 3HCl
        CHEMICAL_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .fluidInputs(Benzene.getFluid(1000))
                .fluidInputs(Chloromethane.getFluid(3000))
                .fluidOutputs(Trimethylbenzene.getFluid(1000))
                .fluidOutputs(HydrochloricAcid.getFluid(3000))
                .EUt(VA[MV])
                .duration(4 * SECOND)
                .buildAndRegister();

        //  C6H3(CH3)3 + C4H6O3 -> (CH3)3C6H2COCH3 + C2H4O2
        CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(dust, AluminiumTrichloride)
                .fluidInputs(Trimethylbenzene.getFluid(1000))
                .fluidInputs(AceticAnhydride.getFluid(1000))
                .fluidOutputs(Trimethylacetophenone.getFluid(1000))
                .fluidOutputs(AceticAcid.getFluid(1000))
                .EUt(VA[IV])
                .duration(2 * SECOND)
                .buildAndRegister();

        //  (CH3)3C6H2COCH3 + 3HClO -> (CH3)3C6H2CO2H + CHCl3 + 2H2O
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(dust, TetramethylammoniumChloride)
                .fluidInputs(Trimethylacetophenone.getFluid(1000))
                .fluidInputs(HypochlorousAcid.getFluid(3000))
                .fluidOutputs(TrimethylbenzoicAcid.getFluid(1000))
                .fluidOutputs(Chloroform.getFluid(1000))
                .fluidOutputs(Steam.getFluid(2000))
                .EUt(VA[EV])
                .duration(4 * SECOND)
                .temperature(1322)
                .buildAndRegister();

        //  (CH3)3C6H2CO2H + SOCl2 -> (CH3)3C6H2COCl + SO2 + HCl
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(TrimethylbenzoicAcid.getFluid(1000))
                .fluidInputs(ThionylChloride.getFluid(1000))
                .fluidOutputs(TrimethylbenzoylChloride.getFluid(1000))
                .fluidOutputs(SulfurDioxide.getFluid(1000))
                .fluidOutputs(HydrochloricAcid.getFluid(1000))
                .EUt(VA[IV])
                .duration(2 * SECOND)
                .temperature(1465)
                .buildAndRegister();

        //  Na + (CH3)3C6H2COCl + (C6H5)3P + H2O -> (CH3)3C6H2COP(C6H5)2 + C6H6 + NaOH + Cl
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Sodium)
                .fluidInputs(TrimethylbenzoylChloride.getFluid(1000))
                .fluidInputs(Triphenylphosphine.getFluid(1000))
                .fluidInputs(Water.getFluid(1000))
                .output(dust, SodiumHydroxide, 3)
                .fluidOutputs(TrimethylbenzoylDiphenylphosphine.getFluid(1000))
                .fluidOutputs(Benzene.getFluid(1000))
                .fluidOutputs(Chlorine.getFluid(1000))
                .EUt(VA[UV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  (CH3)3C6H2COP(C6H5)2 + H2O2 -> (CH3)3C6H2COPO(C6H5)2 + H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(TrimethylbenzoylDiphenylphosphine.getFluid(1000))
                .fluidInputs(HydrogenPeroxide.getFluid(1000))
                .fluidOutputs(TrimethylbenzoylDiphenylphosphineOxide.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .EUt(VA[MV])
                .duration((int) (13.5 * SECOND))
                .buildAndRegister();

        //  Photon Shielding Containment Unit
        PRECISE_ASSEMBLER_RECIPES.recipeBuilder()
                .input(OPTICAL_IMC_BOARD)
                .input(foil, PlatinumGroupAlloy, 2)
                .input(foil, PolyethyleneTerephthalate, 2)
                .input(bolt, ArtheriumB47, 8)
                .fluidInputs(Hdcs.getFluid(L * 10))
                .fluidInputs(Lubricant.getFluid(3000))
                .fluidInputs(EthylDimethylaminobenzoate.getFluid(1000))
                .fluidInputs(TrimethylbenzoylDiphenylphosphineOxide.getFluid(1000))
                .output(PHOTON_SHIELDING_CONTAINMENT_UNIT)
                .EUt(VA[UXV])
                .duration(2 * SECOND)
                .tier(8) // OpV
                .buildAndRegister();
    }

    private static void Circuits() {

        //  Supracausal Processor
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(LIGHT_CONE_MODULE)
                .input(INTRAVITAL_SOC)
                .input(SUPRACAUSAL_RESISTOR, 8)
                .input(SUPRACAUSAL_CAPACITOR, 8)
                .input(SUPRACAUSAL_TRANSISTOR, 8)
                .input(wireFine, Hypogen, 8)
                .solderMultiplier(1)
                .output(SUPRACAUSAL_PROCESSOR, 2)
                .EUt(VA[UXV])
                .duration(10 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Supracausal Assembly
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(SPACETIME_CONDENSER)
                .input(SUPRACAUSAL_PROCESSOR, 2)
                .input(SUPRACAUSAL_INDUCTOR, 6)
                .input(SUPRACAUSAL_CAPACITOR, 12)
                .input(SUPRACAUSAL_MEMORY_CHIP, 24)
                .input(wireFine, Hypogen, 16)
                .solderMultiplier(2)
                .output(SUPRACAUSAL_ASSEMBLY, 2)
                .EUt(VA[UXV])
                .duration(20 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Supracausal Supercomputer
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(SPACETIME_CONDENSER)
                .input(SUPRACAUSAL_ASSEMBLY, 2)
                .input(SUPRACAUSAL_DIODE, 8)
                .input(COSMIC_CPU_CHIP, 16) // TODO new chip or not
                .input(SUPRACAUSAL_MEMORY_CHIP, 32)
                .input(wireFine, HeavyQuarkDegenerateMatter, 24)
                .input(foil, Hikarium, 32)
                .input(plate, BlackDwarfMatter, 4)
                .fluidInputs(SolderingAlloy.getFluid(34560))
                .fluidInputs(Kevlar.getFluid(18432))
                .fluidInputs(Zylon.getFluid(9216))
                .fluidInputs(Hypogen.getFluid(4608))
                .output(SUPRACAUSAL_COMPUTER)
                .EUt(VA[UXV])
                .duration(20 * SECOND)
                .stationResearch(b -> b
                        .researchStack(SUPRACAUSAL_ASSEMBLY.getStackForm())
                        .EUt(VA[UXV])
                        .CWUt(512))
                .buildAndRegister();

        //  Supracausal Mainframe
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, CosmicNeutronium, 2)
                .input(SUPRACAUSAL_COMPUTER, 2)
                .input(SUPRACAUSAL_DIODE, 16)
                .input(SUPRACAUSAL_CAPACITOR, 16)
                .input(SUPRACAUSAL_TRANSISTOR, 16)
                .input(SUPRACAUSAL_RESISTOR, 16)
                .input(SUPRACAUSAL_INDUCTOR, 16)
                .input(foil, Hikarium, 16)
                .input(SUPRACAUSAL_MEMORY_CHIP, 32)
                .input(wireGtDouble, NeutroniumSuperconductor, 16)
                .input(plate, Hypogen, 8)
                .fluidInputs(SolderingAlloy.getFluid(43776))
                .fluidInputs(CosmicFabric.getFluid(34560))
                .fluidInputs(FullerenePolymerMatrix.getFluid(17280))
                .fluidInputs(Zylon.getFluid(8640))
                .output(SUPRACAUSAL_MAINFRAME)
                .EUt(VA[OpV])
                .duration(2 * MINUTE)
                .stationResearch(b -> b
                        .researchStack(SUPRACAUSAL_COMPUTER.getStackForm())
                        .EUt(VA[OpV])
                        .CWUt(1024))
                .buildAndRegister();
    }
}
