package magicbook.gtlitecore.loaders;

import magicbook.gtlitecore.loaders.blocks.Crucibles;
import magicbook.gtlitecore.loaders.chains.*;
import magicbook.gtlitecore.loaders.circuits.GoowareCircuits;
import magicbook.gtlitecore.loaders.components.MachineComponents;
import magicbook.gtlitecore.loaders.multiblock.DroneAirport;
import magicbook.gtlitecore.loaders.oreprocessing.IsaMillOreProcessing;
import magicbook.gtlitecore.loaders.oreprocessing.PlatinumGroupProcessing;
import magicbook.gtlitecore.loaders.oreprocessing.RareEarthProcessing;
import magicbook.gtlitecore.loaders.oreprocessing.TaraniumProcessing;

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
        //  TODO SeleniiumTelluriumChain.init();
        //  TODO TurpentineChain.init();
    }

    private static void initOreProcessings() {
       PlatinumGroupProcessing.init();
       RareEarthProcessing.init();
       TaraniumProcessing.init();

       IsaMillOreProcessing.init();
    }

    private static void initCircuits() {
        GoowareCircuits.init();
    }

    private static void initMultiRecipes() {
        DroneAirport.init();
    }
}