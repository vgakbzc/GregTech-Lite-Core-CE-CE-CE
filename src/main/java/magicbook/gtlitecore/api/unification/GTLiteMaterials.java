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

    public static void init() {
        GTLiteElementMaterials.register();
        GTLiteFirstDegreeMaterials.register();
        GTLiteOrganicChemistryMaterials.register();
        GTLiteUnknownCompositionMaterials.register();
    }
}
