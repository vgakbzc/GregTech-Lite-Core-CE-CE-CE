package magicbook.gtlitecore.integration.gregtech;

import magicbook.gtlitecore.api.utils.Mods;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ALLOY_SMELTER_RECIPES;
import static gregtech.api.recipes.RecipeMaps.MIXER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.utils.GTLiteUtils.getItemById;
import static magicbook.gtlitecore.api.utils.GTLiteUtils.getMetaItemById;

public class CTMaterialRecipeLoader {

    public static void init() {

        //  Dark Steel
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(ingot, Steel)
                .input(block, Obsidian)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_ingot", 32000, 2)) // Ore Dict: ingotDarkSteel
                .EUt(VA[LV])
                .duration(5 * SECOND)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(dust, Steel)
                .input(block, Obsidian)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_ingot", 32000, 2)) // Ore Dict: ingotDarkSteel
                .EUt(VA[LV])
                .duration(5 * SECOND)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(ingot, Steel)
                .input(dust, Obsidian)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_ingot", 32000, 2)) // Ore Dict: ingotDarkSteel
                .EUt(VA[LV])
                .duration(5 * SECOND)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(dust, Steel)
                .input(dust, Obsidian)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_ingot", 32000, 2)) // Ore Dict: ingotDarkSteel
                .EUt(VA[LV])
                .duration(5 * SECOND)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(dust, Steel)
                .input(dust, Obsidian)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_dust", 32000, 2)) // Ore Dict: dustDarkSteel
                .EUt(VA[LV])
                .duration((int) (2.5 * SECOND))
                .buildAndRegister();

        //  Electrical Steel
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(ingot, Steel)
                .input(ingot, Silicon)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_ingot", 32001, 2)) // Ore Dict: ingotElectricalSteel
                .EUt(VA[LV])
                .duration((int) (2.5 * SECOND))
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(ingot, Steel)
                .input(dust, Silicon)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_ingot", 32001, 2)) // Ore Dict: ingotElectricalSteel
                .EUt(VA[LV])
                .duration((int) (2.5 * SECOND))
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(dust, Steel)
                .input(ingot, Silicon)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_ingot", 32001, 2)) // Ore Dict: ingotElectricalSteel
                .EUt(VA[LV])
                .duration((int) (2.5 * SECOND))
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(dust, Steel)
                .input(dust, Silicon)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_ingot", 32001, 2)) // Ore Dict: ingotElectricalSteel
                .EUt(VA[LV])
                .duration((int) (2.5 * SECOND))
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, Steel)
                .input(dust, Silicon)
                .circuitMeta(2)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_dust", 32001, 2)) // Ore Dict: dustElectricalSteel
                .EUt(VA[LV])
                .duration((int) (1.25 * SECOND))
                .buildAndRegister();

        //  Energetic Alloy
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Gold, 2)
                .input(dust, Redstone)
                .input(dust, Glowstone)
                .circuitMeta(3)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_dust", 32002, 4)) // Ore Dict: dustEnergeticAlloy
                .EUt(VA[LV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  Vibrant Alloy
        MIXER_RECIPES.recipeBuilder()
                .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_dust", 32002)) // Ore Dict: dustEnergeticAlloy
                .input(dust, EnderPearl)
                .circuitMeta(2)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_dust", 32003, 2)) // Ore Dict: dustVibrantAlloy
                .EUt(VA[HV])
                .duration(9 * SECOND)
                .buildAndRegister();

        //  End Steel
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_ingot", 32000)) // Ore Dict: ingotDarkSteel
                .inputs(new ItemStack(Blocks.END_STONE))
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_ingot", 32004, 2)) // Ore Dict: ingotEndSteel
                .EUt(VA[EV])
                .duration(8 * SECOND)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_ingot", 32000)) // Ore Dict: ingotDarkSteel
                .input(dust, Endstone)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_ingot", 32004, 2)) // Ore Dict: ingotEndSteel
                .EUt(VA[EV])
                .duration(8 * SECOND)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_dust", 32000)) // Ore Dict: dustDarkSteel
                .inputs(new ItemStack(Blocks.END_STONE))
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_ingot", 32004, 2)) // Ore Dict: ingotEndSteel
                .EUt(VA[EV])
                .duration(8 * SECOND)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_dust", 32000)) // Ore Dict: dustDarkSteel
                .input(dust, Endstone)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_ingot", 32004, 2)) // Ore Dict: ingotEndSteel
                .EUt(VA[EV])
                .duration(8 * SECOND)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_dust", 32000)) // Ore Dict: dustDarkSteel
                .input(dust, Endstone)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_dust", 32004, 2)) // Ore Dict: dustEndSteel
                .EUt(VA[EV])
                .duration(6 * SECOND)
                .buildAndRegister();

        //  Redstone Alloy
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(dust, Redstone)
                .input(ingot, Silicon)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_ingot", 32005, 2)) // Ore Dict: ingotRedstoneAlloy
                .EUt(VA[LV])
                .duration(SECOND)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(dust, Redstone)
                .input(dust, Silicon)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_ingot", 32005, 2)) // Ore Dict: ingotRedstoneAlloy
                .EUt(VA[LV])
                .duration(SECOND)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(dust, Redstone)
                .input(dust, Silicon)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_dust", 32005, 2)) // Ore Dict: dustRedstoneAlloy
                .EUt(VA[LV])
                .duration(SECOND / 2)
                .buildAndRegister();

        //  Conductive Iron
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(ingot, Iron)
                .input(dust, Redstone)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_ingot", 32006, 2)) // Ore Dict: ingotConductiveIron
                .EUt(VA[LV])
                .duration(2 * SECOND)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(dust, Iron)
                .input(dust, Redstone)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_ingot", 32006, 2)) // Ore Dict: ingotConductiveIron
                .EUt(VA[LV])
                .duration(2 * SECOND)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(dust, Iron)
                .input(dust, Redstone)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_dust", 32006, 2)) // Ore Dict: dustConductiveIron
                .EUt(VA[LV])
                .duration((int) (1.5 * SECOND))
                .buildAndRegister();

        //  Pulsating Iron
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(ingot, Iron)
                .input(dust, Uraninite)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_ingot", 32007, 2)) // Ore Dict: ingotPulsatingIron
                .EUt(VA[ULV])
                .duration(SECOND)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(dust, Iron)
                .input(dust, Uraninite)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_ingot", 32007, 2)) // Ore Dict: ingotPulsatingIron
                .EUt(VA[ULV])
                .duration(SECOND)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(dust, Iron)
                .input(dust, Uraninite)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_dust", 32007, 2)) // Ore Dict: dustPulsatingIron
                .EUt(VA[ULV])
                .duration((int) (0.8 * SECOND))
                .buildAndRegister();

        //  Soularium
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(ingot, Gold)
                .inputs(new ItemStack(Blocks.SOUL_SAND))
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_ingot", 32008, 2)) // Ore Dict: ingotSoularium
                .EUt(VH[MV])
                .duration(12 * SECOND)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(dust, Gold)
                .inputs(new ItemStack(Blocks.SOUL_SAND))
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_ingot", 32008, 2)) // Ore Dict: ingotSoularium
                .EUt(VH[MV])
                .duration(12 * SECOND)
                .buildAndRegister();

        if (Mods.FutureMC.isModLoaded()) {
            ALLOY_SMELTER_RECIPES.recipeBuilder()
                    .input(ingot, Gold)
                    .inputs(getItemById(Mods.FutureMC.getID(), "soul_soil"))
                    .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_ingot", 32008, 2)) // Ore Dict: ingotSoularium
                    .EUt(VH[MV])
                    .duration(12 * SECOND)
                    .buildAndRegister();

            ALLOY_SMELTER_RECIPES.recipeBuilder()
                    .input(dust, Gold)
                    .inputs(getItemById(Mods.FutureMC.getID(), "soul_soil"))
                    .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_ingot", 32008, 2)) // Ore Dict: ingotSoularium
                    .EUt(VH[MV])
                    .duration(12 * SECOND)
                    .buildAndRegister();
        }

        //  Crystalline Alloy
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(ingot, BlueSteel)
                .input(ingot, Plutonium241)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_ingot", 32009, 2)) // Ore Dict: ingotCrystallineAlloy
                .EUt(VA[EV])
                .duration(8 * SECOND)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(ingot, BlueSteel)
                .input(dust, Plutonium241)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_ingot", 32009, 2)) // Ore Dict: ingotCrystallineAlloy
                .EUt(VA[EV])
                .duration(8 * SECOND)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(dust, BlueSteel)
                .input(ingot, Plutonium241)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_ingot", 32009, 2)) // Ore Dict: ingotCrystallineAlloy
                .EUt(VA[EV])
                .duration(8 * SECOND)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(dust, BlueSteel)
                .input(dust, Plutonium241)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_ingot", 32009, 2)) // Ore Dict: ingotCrystallineAlloy
                .EUt(VA[EV])
                .duration(8 * SECOND)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(dust, BlueSteel)
                .input(dust, Plutonium241)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_dust", 32009, 2)) // Ore Dict: dustCrystallineAlloy
                .EUt(VA[EV])
                .duration(6 * SECOND)
                .buildAndRegister();

        //  Melodic Alloy
        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .input(dust, BlueSteel, 2)
                .input(dust, Iridium)
                .input(dust, BlueAlloy)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_dust", 32010, 4)) // Ore Dict: dustMelodicAlloy
                .EUt(VA[LuV])
                .duration(9 * SECOND)
                .buildAndRegister();

        //  Stellar Alloy
        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .input(dust, NetherStar, 2)
                .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_dust", 32010)) // Ore Dict: dustMelodicAlloy
                .input(dust, Naquadah)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_dust", 32011, 4)) // Ore Dict: dustStellarAlloy
                .EUt(VA[ZPM])
                .duration((int) (5.5 * SECOND))
                .buildAndRegister();

        //  Crystalline Pink Slime
        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_dust", 32009, 3)) // Ore Dict: dustCrystallineAlloy
                .input(dust, RedSteel)
                .input(dust, RedAlloy, 2)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_dust", 32012, 6)) // Ore Dict: dustCrystallinePinkSlime
                .EUt(VA[IV])
                .duration(17 * SECOND)
                .buildAndRegister();

        //  Energetic Silver
        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .input(dust, Silver, 2)
                .input(dust, Redstone)
                .input(dust, Glowstone)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_dust", 32013, 4)) // Ore Dict: dustEnergeticSilver
                .EUt(VA[LV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  Vivid Alloy
        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_dust", 32013)) // Ore Dict: dustEnergeticSilver
                .input(dust, EnderPearl)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_dust", 32014, 2)) // Ore Dict: dustVividAlloy
                .EUt(VA[HV])
                .duration(9 * SECOND)
                .buildAndRegister();

        //  Construction Alloy
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(ingot, Iron)
                .input(block, Clay)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_ingot", 32015, 2))
                .EUt(VA[ULV])
                .duration(9 * SECOND)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(ingot, Iron)
                .input(dust, Clay)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_ingot", 32015, 2))
                .EUt(VA[ULV])
                .duration(9 * SECOND)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(dust, Iron)
                .input(block, Clay)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_ingot", 32015, 2))
                .EUt(VA[ULV])
                .duration(9 * SECOND)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(dust, Iron)
                .input(dust, Clay)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_ingot", 32015, 2))
                .EUt(VA[ULV])
                .duration(9 * SECOND)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(dust, Iron)
                .input(dust, Clay)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_dust", 32015, 2))
                .EUt(VA[ULV])
                .duration(7 * SECOND)
                .buildAndRegister();

        //  Lumium
        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_dust", 32004)) // Ore Dict: dustEndSteel
                .input(dust, BlueAlloy, 2)
                .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_dust", 32003, 3)) // Ore Dict: dustVibrantAlloy
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_dust", 32031, 6)) // Ore Dict: dustLumium
                .EUt(VA[IV])
                .duration(12 * SECOND)
                .buildAndRegister();

        //  Signalum
        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(4)
                .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_dust", 32031, 3)) // Ore Dict: dustLumium
                .input(dust, AnnealedCopper, 2)
                .input(dust, Blaze)
                .input(dust, Rhodium, 2)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_dust", 32032, 8))
                .EUt(VA[LuV])
                .duration(6 * SECOND)
                .buildAndRegister();

        //  Enderium
        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .inputs(getMetaItemById(Mods.GregTech.getID(), "meta_dust", 32032, 4)) // Ore Dict: dustSignalum
                .input(dust, Platinum, 2)
                .input(dust, Osmium)
                .outputs(getMetaItemById(Mods.GregTech.getID(), "meta_dust", 32033, 7))
                .EUt(VA[ZPM])
                .duration(7 * SECOND)
                .buildAndRegister();

    }
}
