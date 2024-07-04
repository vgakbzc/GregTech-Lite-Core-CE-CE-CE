package magicbook.gtlitecore.integration.gregtech;

import magicbook.gtlitecore.api.utils.Mods;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.api.utils.GTLiteUtility.getItemById;
import static magicbook.gtlitecore.api.utils.GTLiteUtility.getMetaItemById;

public class CompatMaterialRecipeLoader {

    public static void init() {

        //  Fluix
        AUTOCLAVE_RECIPES.recipeBuilder()
                .inputs(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 1)) // Charged Certus Crystal
                .input(gem, NetherQuartz)
                .fluidInputs(Redstone.getFluid(L))
                .output(gem, Fluix)
                .EUt(VA[LV])
                .duration(SECOND)
                .buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder()
                .inputs(getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 1)) // Charged Certus Crystal
                .input(dust, NetherQuartz)
                .fluidInputs(Redstone.getFluid(L))
                .output(gem, Fluix)
                .EUt(VA[LV])
                .duration(SECOND)
                .buildAndRegister();

        //  Dark Steel
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(ingot, Steel)
                .input(block, Obsidian)
                .output(ingot, DarkSteel, 2)
                .EUt(VA[LV])
                .duration(5 * SECOND)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(dust, Steel)
                .input(block, Obsidian)
                .output(ingot, DarkSteel, 2)
                .EUt(VA[LV])
                .duration(5 * SECOND)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(ingot, Steel)
                .input(dust, Obsidian)
                .output(ingot, DarkSteel, 2)
                .EUt(VA[LV])
                .duration(5 * SECOND)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(dust, Steel)
                .input(dust, Obsidian)
                .output(ingot, DarkSteel, 2)
                .EUt(VA[LV])
                .duration(5 * SECOND)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(dust, Steel)
                .input(dust, Obsidian)
                .output(dust, DarkSteel, 2)
                .EUt(VA[LV])
                .duration((int) (2.5 * SECOND))
                .buildAndRegister();

        //  Electrical Steel
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(ingot, Steel)
                .input(ingot, Silicon)
                .output(ingot, ElectricalSteel, 2)
                .EUt(VA[LV])
                .duration((int) (2.5 * SECOND))
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(ingot, Steel)
                .input(dust, Silicon)
                .output(ingot, ElectricalSteel, 2)
                .EUt(VA[LV])
                .duration((int) (2.5 * SECOND))
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(dust, Steel)
                .input(ingot, Silicon)
                .output(ingot, ElectricalSteel, 2)
                .EUt(VA[LV])
                .duration((int) (2.5 * SECOND))
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(dust, Steel)
                .input(dust, Silicon)
                .output(ingot, ElectricalSteel, 2)
                .EUt(VA[LV])
                .duration((int) (2.5 * SECOND))
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(dust, Steel)
                .input(dust, Silicon)
                .output(dust, ElectricalSteel, 2)
                .EUt(VA[LV])
                .duration((int) (1.25 * SECOND))
                .buildAndRegister();

        //  Redstone Alloy
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(dust, Redstone)
                .input(ingot, Silicon)
                .output(ingot, RedstoneAlloy, 2)
                .EUt(VA[LV])
                .duration(SECOND)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(dust, Redstone)
                .input(dust, Silicon)
                .output(ingot, RedstoneAlloy, 2)
                .EUt(VA[LV])
                .duration(SECOND)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(dust, Redstone)
                .input(dust, Silicon)
                .output(dust, RedstoneAlloy, 2)
                .EUt(VA[LV])
                .duration(SECOND / 2)
                .buildAndRegister();

        //  Soularium
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(ingot, Gold)
                .inputs(new ItemStack(Blocks.SOUL_SAND))
                .output(ingot, Soularium, 2)
                .EUt(VH[MV])
                .duration(12 * SECOND)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(dust, Gold)
                .inputs(new ItemStack(Blocks.SOUL_SAND))
                .output(ingot, Soularium, 2)
                .EUt(VH[MV])
                .duration(12 * SECOND)
                .buildAndRegister();

        if (Mods.FutureMC.isModLoaded()) {
            ALLOY_SMELTER_RECIPES.recipeBuilder()
                    .input(ingot, Gold)
                    .inputs(getItemById(Mods.FutureMC.getID(), "soul_soil"))
                    .output(ingot, Soularium, 2)
                    .EUt(VH[MV])
                    .duration(12 * SECOND)
                    .buildAndRegister();

            ALLOY_SMELTER_RECIPES.recipeBuilder()
                    .input(dust, Gold)
                    .inputs(getItemById(Mods.FutureMC.getID(), "soul_soil"))
                    .output(ingot, Soularium, 2)
                    .EUt(VH[MV])
                    .duration(12 * SECOND)
                    .buildAndRegister();
        }

        //  Pulsating Iron
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(ingot, Iron)
                .input(dust, Uraninite)
                .output(ingot, PulsatingIron, 2)
                .EUt(VA[ULV])
                .duration(SECOND)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(dust, Iron)
                .input(dust, Uraninite)
                .output(ingot, PulsatingIron, 2)
                .EUt(VA[ULV])
                .duration(SECOND)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(dust, Iron)
                .input(dust, Uraninite)
                .output(dust, PulsatingIron, 2)
                .EUt(VA[ULV])
                .duration((int) (0.8 * SECOND))
                .buildAndRegister();

        //  Conductive Iron
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(ingot, Iron)
                .input(dust, Redstone)
                .output(ingot, ConductiveIron, 2)
                .EUt(VA[LV])
                .duration(2 * SECOND)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(dust, Iron)
                .input(dust, Redstone)
                .output(ingot, ConductiveIron, 2)
                .EUt(VA[LV])
                .duration(2 * SECOND)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(dust, Iron)
                .input(dust, Redstone)
                .output(dust, ConductiveIron, 2)
                .EUt(VA[LV])
                .duration((int) (1.5 * SECOND))
                .buildAndRegister();

        //  Energetic Alloy
        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .input(dust, Gold, 2)
                .input(dust, Redstone)
                .input(dust, Glowstone)
                .output(dust, EnergeticAlloy, 4)
                .EUt(VA[LV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  Vibrant Alloy
        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(dust, EnergeticAlloy)
                .input(dust, EnderPearl)
                .output(dust, VibrantAlloy, 2)
                .EUt(VA[MV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  Cooling Vibrant Alloy via MV Chemical Bath
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(ingotHot, VibrantAlloy)
                .fluidInputs(Water.getFluid(100))
                .output(ingot, VibrantAlloy)
                .EUt(VA[MV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  End Steel
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(ingot, DarkSteel)
                .inputs(new ItemStack(Blocks.END_STONE))
                .output(ingot, EndSteel, 2)
                .EUt(VA[EV])
                .duration(8 * SECOND)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(ingot, DarkSteel)
                .input(dust, Endstone)
                .output(ingot, EndSteel, 2)
                .EUt(VA[EV])
                .duration(8 * SECOND)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(dust, DarkSteel)
                .inputs(new ItemStack(Blocks.END_STONE))
                .output(ingot, EndSteel, 2)
                .EUt(VA[EV])
                .duration(8 * SECOND)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(dust, DarkSteel)
                .input(dust, Endstone)
                .output(ingot, EndSteel, 2)
                .EUt(VA[EV])
                .duration(8 * SECOND)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(dust, DarkSteel)
                .input(dust, Endstone)
                .output(dust, EndSteel, 2)
                .EUt(VA[EV])
                .duration(6 * SECOND)
                .buildAndRegister();

        //  Lumium
        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .input(dust, EndSteel)
                .input(dust, BlueAlloy, 2)
                .input(dust, VibrantAlloy, 3)
                .output(dust, Lumium, 6)
                .EUt(VA[IV])
                .duration(8 * SECOND)
                .buildAndRegister();

        //  Signalum
        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(4)
                .input(dust, Lumium, 3)
                .input(dust, AnnealedCopper, 2)
                .input(dust, Blaze)
                .input(dust, Rhodium, 2)
                .output(dust, Signalum, 8)
                .EUt(VA[LuV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  Enderium
        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(4)
                .input(dust, Signalum, 4)
                .input(dust, Platinum, 2)
                .input(dust, Osmium)
                .input(dust, EnderEye)
                .output(dust, Enderium, 8)
                .EUt(VA[ZPM])
                .duration(12 * SECOND)
                .buildAndRegister();

        //  Construction Alloy
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(ingot, Iron)
                .input(block, Clay)
                .output(ingot, ConstructionAlloy, 2)
                .EUt(VA[ULV])
                .duration(9 * SECOND)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(ingot, Iron)
                .input(dust, Clay)
                .output(ingot, ConstructionAlloy, 2)
                .EUt(VA[ULV])
                .duration(9 * SECOND)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(dust, Iron)
                .input(block, Clay)
                .output(ingot, ConstructionAlloy, 2)
                .EUt(VA[ULV])
                .duration(9 * SECOND)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(dust, Iron)
                .input(dust, Clay)
                .output(ingot, ConstructionAlloy, 2)
                .EUt(VA[ULV])
                .duration(9 * SECOND)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(dust, Iron)
                .input(dust, Clay)
                .output(dust, ConstructionAlloy, 2)
                .EUt(VA[ULV])
                .duration(7 * SECOND)
                .buildAndRegister();

        //  Enriched Alloy
        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .input(dust, ConstructionAlloy, 2)
                .input(dust, Lithium)
                .input(dust, Cobalt)
                .output(dust, EnrichedAlloy, 4)
                .EUt(VA[LV])
                .duration((int) (1.5 * SECOND))
                .buildAndRegister();

        //  Energetic Silver
        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .input(dust, Silver, 2)
                .input(dust, Redstone)
                .input(dust, Glowstone)
                .output(dust, EnergeticSilver, 4)
                .EUt(VA[LV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  Vivid Alloy
        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(dust, EnergeticSilver)
                .input(dust, EnderPearl)
                .output(dust, VividAlloy, 2)
                .EUt(VA[MV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  Cooling Vivid Alloy via MV Chemical Bath
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(ingotHot, VividAlloy)
                .fluidInputs(Water.getFluid(100))
                .output(ingot, VividAlloy)
                .EUt(VA[MV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  Crystalline Alloy
        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .input(dust, VividAlloy, 2)
                .input(dust, Emerald)
                .input(dust, Plutonium241)
                .output(dust, CrystallineAlloy, 4)
                .EUt(VA[EV])
                .duration(6 * SECOND)
                .buildAndRegister();

        //  Crystalline Pink Slime
        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .input(dust, CrystallineAlloy, 3)
                .input(dust, RedSteel)
                .input(dust, RedstoneAlloy, 2)
                .output(dust, CrystallinePinkSlime, 6)
                .EUt(VA[IV])
                .duration(8 * SECOND)
                .buildAndRegister();

        //  Melodic Alloy
        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .input(dust, CrystallinePinkSlime, 2)
                .input(dust, Iridium)
                .input(dust, BlueAlloy)
                .output(dust, MelodicAlloy, 4)
                .EUt(VA[LuV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  Stellar Alloy
        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .input(dust, NetherStar, 2)
                .input(dust, MelodicAlloy)
                .input(dust, Naquadah)
                .output(dust, StellarAlloy, 4)
                .EUt(VA[ZPM])
                .duration(12 * SECOND)
                .buildAndRegister();

    }
}
