package magicbook.gtlitecore.api.unification;

import gregtech.api.unification.Element;
import gregtech.api.unification.Elements;
import gregtech.api.unification.material.Material;

public class GTLiteElements {

    public static final Element Or                = addElement(130,    200,    "Orichalcum",                "Or");
    public static final Element Vb                = addElement(152,    226,    "Vibranium",                 "Vb");
    public static final Element Ad                = addElement(222,    580,    "Adamantium",                "Ad");
    public static final Element Tn                = addElement(321,    478,    "Taranium",                  "Tn");
    public static final Element Mh                = addElement(405,    564,    "Mithril",                   "Mh");
    public static final Element CrystalMatrix     = addElement(888,    888,    "CrystalMatrix",             "◊◇◊");
    public static final Element Infinity          = addElement(999,    999,    "Infinity",                  "∞");
    public static final Element Ichorium          = addElement(165,    280,    "Ichorium",                  "✦☯✧");
    public static final Element IchorLiquid       = addElement(165,    279,    "IchorLiquid",               "☯");
    public static final Element SpNt              = addElement(9999,   9999,   "CosmicNeutronium",          "SpNt");
    public static final Element SpaceTime         = addElement(10000,  10000,  "SpaceTime",                 "");
    public static final Element So                = addElement(159,    278,    "Solarium",                  "So");
    public static final Element Ln                = addElement(159,    279,    "LunaSilver",                "Ln");
    public static final Element Fs                = addElement(184,    142,    "Rhugnor",                   "Fs⚶");
    public static final Element Hy                = addElement(240,    251,    "Hypogen",                   "Hy⚶");
    public static final Element Vd                = addElement(165,    281,    "VoidMetal",                 "Vd⚶");
    public static final Element AstralTitanium    = addElement(145,    133,    "AstralTitanium",            "✧◇✧");
    public static final Element CelestialTungsten = addElement(160,    101,    "CelestialTungsten",         "✦◆✦");
    public static final Element Gx                = addElement(388,    252,    "Galaxium",                  "Gx⚶");
    public static final Element Uv                = addElement(760,    253,    "Universium",                "Uv⚶");
    public static final Element Ax                = addElement(290,    282,    "Astralium",                 "Ax⚶");
    public static final Element Hr                = addElement(640,    789,    "Hikarium",                  "Hr⚶");
    public static final Element En                = addElement(100000, 100000, "Eternity",                  "En⦼");
    public static final Element Tb                = addElement(349,    175,    "Tiberium",                  "*Tb*");
    public static final Element Sh                = addElement(230,    306,    "Shirabon",                  "Sh⏧");
    public static final Element Ed                = addElement(433,    362,    "Edenium",                   "◊Ed◊");
    public static final Element Ft                = addElement(655,    408,    "Fatalium",                  "Ft⏧");
    public static final Element Om                = addElement(99999,  99999,  "Omnium",                    "Om⦼");
    public static final Element M                 = addElement(1931,   1994,   "Magmatter",                 "M⎋");
    public static final Element Pm                = addElement(50000,  50000,  "PrimordialMatter",          "Pm⎋");
    public static final Element Quantium          = addElement(300,    300,    "Quantium",                  "Qt");
    public static final Element Nqx               = addElement(174,    360,    "ExtremelyUnstableNaquadah", "Nq⚶");

    /**
     * Add Element to GregTech Element.
     *
     * <p>
     *     This method can create a new GregTech Element
     *     which used in {@link Material.Builder#element(Element)} commonly.
     *     Because we do not need to consider Isotope problem,
     *     so we add a new method which omitted related paramters.
     * </p>
     *
     * @param protons   Protons of Element.
     * @param neutrons  Neutrons of Element.
     * @param name      Element Name.
     * @param symbol    Element Symbol.
     * @return          Create a new GregTech Element.
     *
     * @since 2.8.8-beta
     */
    private static Element addElement(long protons, long neutrons, String name, String symbol) {
        return Elements.add(protons, neutrons, -1, null, name, symbol, false);
    }

}