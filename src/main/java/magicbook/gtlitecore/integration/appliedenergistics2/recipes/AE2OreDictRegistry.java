package magicbook.gtlitecore.integration.appliedenergistics2.recipes;

import gregtech.api.unification.OreDictUnifier;
import magicbook.gtlitecore.api.utils.Mods;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import static gregtech.api.unification.ore.OrePrefix.gem;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.Fluix;
import static magicbook.gtlitecore.api.utils.GTLiteUtils.getMetaItemById;

public class AE2OreDictRegistry {

    public static void registerOreDicts() {

        //  AE2
        OreDictionary.registerOre("blockSkyStone", Mods.AppliedEnergistics2.getItemByID("sky_stone_block"));
        OreDictionary.registerOre("dustSkyStone", Mods.AppliedEnergistics2.getMetaItemByID("material", 45));
        OreDictionary.registerOre("gemFluix", Mods.AppliedEnergistics2.getMetaItemByID("material", 7));
        OreDictionary.registerOre("crystalFluix", OreDictUnifier.get(gem, Fluix));
        OreDictionary.registerOre("wireFineNetherQuartz", Mods.AppliedEnergistics2.getMetaItemByID("part", 140));

        registerAE2CableOreDicts(0, 16, "cableAeGlass");
        registerAE2CableOreDicts(20, 36, "cableAeCovered");
        registerAE2CableOreDicts(40, 56, "cableAeSmart");
        registerAE2CableOreDicts(60, 76, "cableAeDenseSmart");
        registerAE2CableOreDicts(500, 516, "cableAeDenseCovered");

        //  Lazy AE2
        OreDictionary.registerOre("dustCarbonicFluix", Mods.LazyAE2.getMetaItemByID("material", 1));
        OreDictionary.registerOre("ingotFluixIron", Mods.LazyAE2.getMetaItemByID("material", 2));

    }

    /**
     * Register Ore Dicts for Items in current range (from {@code startMetaId} to {@code endMetaId}).
     *
     * @param startMetaId  Start ID of current range.
     * @param endMetaId    End ID of current range.
     * @param oreDict      Ore Dictionary.
     */
    public static void registerAE2CableOreDicts(int startMetaId, int endMetaId, String oreDict) {
        for (int i = startMetaId; i <= endMetaId; i++) {
            ItemStack stack = getMetaItemById(Mods.AppliedEnergistics2.getID(), "part", i);
            OreDictionary.registerOre(oreDict, stack);
            if (i != endMetaId)
                OreDictionary.registerOre(oreDict + "Colors", stack);
        }
    }
}
