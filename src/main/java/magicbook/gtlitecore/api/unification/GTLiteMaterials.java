package magicbook.gtlitecore.api.unification;

import gregtech.api.unification.material.Material;
import magicbook.gtlitecore.api.unification.materials.GTLiteElementMaterials;
import magicbook.gtlitecore.api.unification.materials.GTLiteFirstDegreeMaterials;
import magicbook.gtlitecore.api.unification.materials.GTLiteOrganicChemistryMaterials;
import magicbook.gtlitecore.api.unification.materials.GTLiteUnknownCompositionMaterials;

public class GTLiteMaterials {
    //  Element Materials (Range: 10000-11000)
    public static Material Orichalcum;
    public static Material Vibranium;
    public static Material Adamantium;
    public static Material Taranium;
    public static Material Mithril;

    //  First Degree Materials (Range: 11001-12000)
    public static Material PlatinumGroupResidue;
    public static Material PlatinumGroupConcentrate;
    public static Material PurifiedPlatinumGroupConcentrate;
    public static Material AmmoniumHexachloroplatinate;
    public static Material AmmoniumHexachloropalladate;
    public static Material SodiumNitrate;
    public static Material HexachloroplatinicAcid;
    public static Material CarbonTetrachloride;
    public static Material RutheniumChloride;
    public static Material SodiumPeroxide;
    public static Material RhodiumOxide;
    public static Material SulfurDichloride;
    public static Material ThionylChloride;
    public static Material OsmiumTetrachloride;
    public static Material LanthanumOxide;
    public static Material CeriumOxide;
    public static Material PraseodymiumOxide;
    public static Material NeodymiumOxide;
    public static Material SamariumOxide;
    public static Material EuropiumOxide;
    public static Material GadoliniumOxide;
    public static Material TerbiumOxide;
    public static Material DysprosiumOxide;
    public static Material HolmiumOxide;
    public static Material ErbiumOxide;
    public static Material ThuliumOxide;
    public static Material YtterbiumOxide;
    public static Material LutetiumOxide;
    public static Material ScandiumOxide;
    public static Material YttriumOxide;
    public static Material AmmoniumNitrate;
    public static Material HeavyTaraniumFuel;
    public static Material MediumTaraniumFuel;
    public static Material LightTaraniumFuel;
    public static Material HeavyEnrichedTaraniumFuel;
    public static Material MediumEnrichedTaraniumFuel;
    public static Material LightEnrichedTaraniumFuel;
    public static Material OrichalcumEnergized;
    public static Material Adamantite;
    public static Material AdamantiumUnstable;
    public static Material AdamantiumEnriched;
    public static Material VibraniumUnstable;
    public static Material DeepIron;
    public static Material SodiumEthylate;
    public static Material PotassiumEthylate;
    public static Material CalciumCarbonate;
    public static Material CarbonDisulfide;
    public static Material SodiumEthylxanthate;
    public static Material PotassiumEthylxanthate;

    //  Second Degree Materials (Range: 12001-13000)

    //  Organic Chemistry Materials (Range: 13001-15000)
    public static Material KaptonK;
    public static Material KaptonE;
    public static Material Polyetheretherketone;
    public static Material Kevlar;
    public static Material Zylon;
    public static Material FullerenePolymerMatrix;
    public static Material CosmicFabric;
    public static Material MethylFormate;
    public static Material FormicAcid;
    public static Material Ethylhexanol;
    public static Material DiethylhexylPhosphoricAcid;

    //  Unknown Composition Materials (Range: 18000-20000)
    public static Material FracuringFluid;
    public static Material RareEarthHydroxidesSolution;
    public static Material RareEarthChloridesSolution;
    public static Material LaPrNdCeOxidesSolution;
    public static Material ScEuGdSmOxidesSolution;
    public static Material YTbDyHoOxidesSolution;
    public static Material ErTmYbLuOxidesSolution;
    public static Material Bedrock;
    public static Material BedrockSmoke;
    public static Material BedrockSootSolution;
    public static Material CleanBedrockSolution;
    public static Material HeavyBedrockSmoke;
    public static Material MediumBedrockSmoke;
    public static Material LightBedrockSmoke;
    public static Material UltralightBedrockSmoke;
    public static Material HeavyTaraniumGas;
    public static Material MediumTaraniumGas;
    public static Material LightTaraniumGas;
    public static Material BedrockGas;
    public static Material CrackedHeavyTaranium;
    public static Material CrackedMediumTaranium;
    public static Material CrackedLightTaranium;
    public static Material EnrichedBedrockSootSolution;
    public static Material CleanEnrichedBedrockSolution;
    public static Material HeavyEnrichedBedrockSmoke;
    public static Material MediumEnrichedBedrockSmoke;
    public static Material LightEnrichedBedrockSmoke;
    public static Material HeavyEnrichedTaraniumGas;
    public static Material MediumEnrichedTaraniumGas;
    public static Material LightEnrichedTaraniumGas;
    public static Material CrackedHeavyEnrichedTaranium;
    public static Material CrackedMediumEnrichedTaranium;
    public static Material CrackedLightEnrichedTaranium;
    public static Material CrudeNaquadahFuel;
    public static Material HeavyNaquadahFuel;
    public static Material MediumNaquadahFuel;
    public static Material LightNaquadahFuel;
    public static Material NaquadahGas;
    public static Material EnergeticNaquadria;
    public static Material HeavyHyperFuel;
    public static Material MediumHyperFuel;
    public static Material LightHyperFuel;
    public static Material AlmandineFront;
    public static Material ChalcopyriteFront;
    public static Material MonaziteFront;
    public static Material GrossularFront;
    public static Material NickelFront;
    public static Material PlatinumFront;
    public static Material PyropeFront;
    public static Material RedstoneFront;
    public static Material SpessartineFront;
    public static Material SphaleriteFront;
    public static Material PentlanditeFront;

    public static void init() {
        GTLiteElementMaterials.register();
        GTLiteFirstDegreeMaterials.register();
        GTLiteOrganicChemistryMaterials.register();
        GTLiteUnknownCompositionMaterials.register();
    }
}
