package magicbook.gtlitecore.loaders.oreprocessing;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.SIFTER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static magicbook.gtlitecore.api.GTLiteValues.MINUTE;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;

/**
 * Zirconium Hafnium Processing
 *
 * @author Magic_Sweepy (2024/05/28)
 *
 * <p>
 *     Produces Zirconium and Hafnium by Sifting some ores.
 * </p>
 *
 * <p>Main Products: Zirconium, Hafnium</p>
 * <p>Side Products: Zinc, Iron</p>
 *
 * @since 2.8.8-beta
 */
public class ZirconiumHafniumProcessing {

    public static void init() {

        SIFTER_RECIPES.recipeBuilder()
                .input(crushedPurified, Tin)
                .output(dustPure, Tin)
                .chancedOutput(dust, Zinc, 500, 150) // 5% (+1.5%)
                .chancedOutput(dust, Zirconium, 1500, 200) // 15% (+2.0%)
                .chancedOutput(dust, Zirconium, 1000, 500) // 10% (+5.0%)
                .chancedOutput(dust, Zirconium, 500, 1000) // 5% (+10%)
                .chancedOutput(dust, Zirconium, 500, 1000) // 5% (+10%)
                .EUt(VA[HV])
                .duration(MINUTE / 2)
                .buildAndRegister();

        SIFTER_RECIPES.recipeBuilder()
                .input(crushedPurified, Cassiterite)
                .output(dustPure, Cassiterite)
                .chancedOutput(dust, Zinc, 500, 150) // 5% (+1.5%)
                .chancedOutput(dust, Zirconium, 1500, 200) // 15% (+2.0%)
                .chancedOutput(dust, Zirconium, 1000, 500) // 10% (+5.0%)
                .chancedOutput(dust, Zirconium, 500, 1000) // 5% (+10%)
                .chancedOutput(dust, Zirconium, 500, 1000) // 5% (+10%)
                .EUt(VA[HV])
                .duration(MINUTE / 2)
                .buildAndRegister();

        SIFTER_RECIPES.recipeBuilder()
                .input(crushedPurified, Ilmenite)
                .output(dustPure, Ilmenite)
                .chancedOutput(dust, Hafnium, 500, 150) // 5% (+1.5%)
                .chancedOutput(dust, Iron, 1500, 200) // 15% (+2.0%)
                .chancedOutput(dust, Iron, 1000, 500) // 10% (+5.0%)
                .chancedOutput(dust, Zirconium, 500, 1000) // 5% (+10%)
                .chancedOutput(dust, Zirconium, 500, 1000) // 5% (+10%)
                .EUt(VA[EV])
                .duration(20 * SECOND)
                .buildAndRegister();
    }
}
