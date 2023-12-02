package magicbook.gtlitecore.loaders;

import magicbook.gtlitecore.loaders.blocks.Crucibles;
import magicbook.gtlitecore.loaders.chain.*;
import magicbook.gtlitecore.loaders.components.MachineComponents;
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

        PEDOTChain.init();
        PMMAChain.init();
    }

    private static void initOreProcessings() {
       PlatinumGroupProcessing.init();
       RareEarthProcessing.init();
       TaraniumProcessing.init();

       IsaMillOreProcessing.init();
    }
}