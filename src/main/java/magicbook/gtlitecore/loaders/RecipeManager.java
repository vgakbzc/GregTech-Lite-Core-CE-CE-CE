package magicbook.gtlitecore.loaders;

import magicbook.gtlitecore.loaders.blocks.Crucibles;
import magicbook.gtlitecore.loaders.blocks.WireCoils;
import magicbook.gtlitecore.loaders.chains.*;
import magicbook.gtlitecore.loaders.circuits.*;
import magicbook.gtlitecore.loaders.components.MachineComponents;
import magicbook.gtlitecore.loaders.multiblock.ComponentAssembler;
import magicbook.gtlitecore.loaders.multiblock.ComponentAssemblyLine;
import magicbook.gtlitecore.loaders.multiblock.DroneAirport;
import magicbook.gtlitecore.loaders.oreprocessing.*;

public class RecipeManager {

    private RecipeManager() {}

    public static void init() {
        initBlocks();
        MachineComponents.init();
        MaterialInfoLoader.init();
        MachineRecipeLoader.init();
        MiscRecipes.init();
        RecipeConflicts.init();
      
        initChains();
        initOreProcessings();
        initCircuits();
        initMultiRecipes();

        FusionLoader.init();
        OverrideRecipeLoader.init();
    }

    private static void initBlocks() {
        WireCoils.init();
        Crucibles.init();
    }

    private static void initChains() {
        AcetyleneChain.init();
        AmmoniaChain.init();
        BoronNitrideChain.init();
        BrineChain.init();
        BPAPolycarbonateChain.init();
        BZMediumChain.init();
        CBDOPolycarbonateChain.init();
        CyanogenChain.init();
        DimethylformamideChain.init();
        DragonChain.init();
        EDTAChain.init();
        EtchingMaterialsChain.init();
        EthyleneGlycolChain.init();
        FEPChain.init();
        FullereneChain.init();
        GalliumNitrideChain.init();
        GrapheneChain.init();
        HydrogenPeroxideChain.init();
        //  TODO IsotopesChain.init();
        KaptonChain.init();
        KevlarChain.init();
        //  TODO MagneticsChain.init();
        MethylamineChain.init();
        NanotubesChain.init();
        OilChain.init();
        PEDOTChain.init();
        PhosphorusChain.init();
        //  TODO PhotoresistivesChain.init();
        PMMAChain.init();
        RocketFuelChain.init();
        RubberChain.init();
        SeleniumTelluriumChain.init();
        TurpentineChain.init();
        ZirconiumChain.init();
    }

    private static void initOreProcessings() {
        GermaniumProcessing.init();
        MolybdenumProcessing.init();
        NiobiumTantalumProcessing.init();
        PlatinumGroupProcessing.init();
        RareEarthProcessing.init();
        RubidiumProcessing.init();
        TaraniumProcessing.init();

        IsaMillOreProcessing.init();
    }
  
    private static void initCircuits() {
        ProcessorCircuits.init();
        NanoCircuits.init();
        QuantumCircuits.init();
        CrystalCircuits.init();
        WetwareCircuits.init();
        GoowareCircuits.init();
        OpticalCircuits.init();
    }

    private static void initMultiRecipes() {
        DroneAirport.init();
        ComponentAssembler.init();
        ComponentAssemblyLine.init();
    }
}