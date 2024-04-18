package magicbook.gtlitecore.integration.gregtech.overrides;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.stack.UnificationEntry;
import magicbook.gtlitecore.common.blocks.BlockHermeticCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;

import static gregtech.api.unification.ore.OrePrefix.pipeLargeFluid;
import static gregtech.api.unification.ore.OrePrefix.plate;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

/**
 * Override of Hermetic Casings.
 *
 * @author Magic_Sweepy
 *
 * @since 2.8.7-beta
 */
public class HermeticCasings {

    public static void init() {

        //  Hermetic Casings
        ModHandler.addShapedRecipe(true, "hermetic_casing_uev", GTLiteMetaBlocks.HERMETIC_CASING.getItemVariant(BlockHermeticCasing.HermeticCasingType.HERMETIC_UEV),
                "ppp", "pPp", "ppp",
                'p', new UnificationEntry(plate, Adamantium),
                'P', new UnificationEntry(pipeLargeFluid, Lafium));

        ModHandler.addShapedRecipe(true, "hermetic_casing_uiv", GTLiteMetaBlocks.HERMETIC_CASING.getItemVariant(BlockHermeticCasing.HermeticCasingType.HERMETIC_UIV),
                "ppp", "pPp", "ppp",
                'p', new UnificationEntry(plate, Infinity),
                'P', new UnificationEntry(pipeLargeFluid, CrystalMatrix));

        ModHandler.addShapedRecipe(true, "hermetic_casing_uxv", GTLiteMetaBlocks.HERMETIC_CASING.getItemVariant(BlockHermeticCasing.HermeticCasingType.HERMETIC_UXV),
                "ppp", "pPp", "ppp",
                'p', new UnificationEntry(plate, CosmicNeutronium),
                'P', new UnificationEntry(pipeLargeFluid, QuantumchromodynamicallyConfinedMatter));

        ModHandler.addShapedRecipe(true, "hermetic_casing_opv", GTLiteMetaBlocks.HERMETIC_CASING.getItemVariant(BlockHermeticCasing.HermeticCasingType.HERMETIC_OpV),
                "ppp", "pPp", "ppp",
                'p', new UnificationEntry(plate, Spacetime),
                'P', new UnificationEntry(pipeLargeFluid, Fatalium));
    }
}
