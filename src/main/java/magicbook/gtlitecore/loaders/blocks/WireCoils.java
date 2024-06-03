package magicbook.gtlitecore.loaders.blocks;

import gregtech.api.block.VariantBlock;
import gregtech.api.unification.material.Material;
import magicbook.gtlitecore.common.blocks.BlockWireCoil;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import net.minecraft.util.IStringSerializable;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.unification.material.Materials.Seaborgium;
import static gregtech.api.unification.material.Materials.Tritanium;
import static gregtech.api.unification.ore.OrePrefix.foil;
import static gregtech.api.unification.ore.OrePrefix.wireGtDouble;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class WireCoils {

    public static void init() {

        //  Adamantium Coil, 13501K, UHV, 50s
        createCoilRecipe(UHV,
                GTLiteMetaBlocks.WIRE_COIL,
                BlockWireCoil.CoilType.ADAMANTIUM,
                Adamantium,
                SiliconCarbide,
                Tritanium);

        //  Ichorium Coil, 16600K, UEV, 55s
        createCoilRecipe(UEV,
                GTLiteMetaBlocks.WIRE_COIL,
                BlockWireCoil.CoilType.ICHORIUM,
                Ichorium,
                Seaborgium,
                Adamantium);

        //  Astralium, 18400K, UIV, 60s
        createCoilRecipe(UIV,
                GTLiteMetaBlocks.WIRE_COIL,
                BlockWireCoil.CoilType.ASTRALIUM,
                Astralium,
                Abyssalloy,
                Ichorium);

        //  Hikarium, 22000K, UXV, 65s
        createCoilRecipe(UXV,
                GTLiteMetaBlocks.WIRE_COIL,
                BlockWireCoil.CoilType.HIKARIUM,
                Hikarium,
                BlackDwarfMatter,
                Astralium);
    }

    /**
     * Create common Wire Coil Block recipe.
     *
     * @param coilTier              Tier of Coil Block (related {@code EUt} and {@code duration}).
     * @param outputCoilType        Variant Block class of {@code MetaBlock}.
     * @param outputCoil            Casing type of {@code MetaBlock}.
     * @param wireGtDoubleMaterial  Double Wire {@code material} of Wire Coil.
     * @param foilMaterial          Foil {@code material} of Wire Coil.
     * @param fluidMaterial         Fluid {@code material} of Wire Coil.
     */
    private static <T extends Enum<T> & IStringSerializable> void createCoilRecipe(int coilTier,
                                                                                   VariantBlock<T> outputCoilType,
                                                                                   T outputCoil,
                                                                                   Material wireGtDoubleMaterial,
                                                                                   Material foilMaterial,
                                                                                   Material fluidMaterial) {
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireGtDouble, wireGtDoubleMaterial, 8)
                .input(foil, foilMaterial, 8)
                .fluidInputs(fluidMaterial.getFluid(L))
                .outputs(outputCoilType.getItemVariant(outputCoil))
                .EUt(VA[coilTier])
                .duration((10 + (5 * (coilTier - 1))) * SECOND)
                .buildAndRegister();
    }
}
