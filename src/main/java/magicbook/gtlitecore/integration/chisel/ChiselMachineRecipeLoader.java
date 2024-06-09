package magicbook.gtlitecore.integration.chisel;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.loaders.recipe.CraftingComponent;
import gregtech.loaders.recipe.MetaTileEntityLoader;
import net.minecraftforge.oredict.OreDictionary;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static gregicality.multiblocks.api.unification.GCYMMaterials.HSLASteel;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.CONVEYOR_MODULE_HV;
import static gregtech.common.items.MetaItems.ELECTRIC_MOTOR_HV;
import static gregtech.loaders.recipe.CraftingComponent.*;
import static magicbook.gtlitecore.api.GTLiteValues.MODID_CHISEL;
import static magicbook.gtlitecore.api.utils.GTLiteUtils.getItemById;
import static magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities.*;

public class ChiselMachineRecipeLoader {

    public static void init() {

        OreDictionary.registerOre("craftingChisel", getItemById(MODID_CHISEL, "chisel_iron"));
        OreDictionary.registerOre("craftingChisel", getItemById(MODID_CHISEL, "chisel_diamond"));
        OreDictionary.registerOre("craftingChisel", getItemById(MODID_CHISEL, "chisel_hitech"));

        CraftingComponent.Component LOWER_CIRCUIT = new CraftingComponent.Component(Stream.of(
                        new Object[]{0, new UnificationEntry(gem, Diamond)},
                        new Object[]{1, new UnificationEntry(circuit, MarkerMaterials.Tier.ULV)},
                        new Object[]{2, new UnificationEntry(circuit, MarkerMaterials.Tier.LV)},
                        new Object[]{3, new UnificationEntry(circuit, MarkerMaterials.Tier.MV)},
                        new Object[]{4, new UnificationEntry(circuit, MarkerMaterials.Tier.HV)},
                        new Object[]{5, new UnificationEntry(circuit, MarkerMaterials.Tier.EV)},
                        new Object[]{6, new UnificationEntry(circuit, MarkerMaterials.Tier.IV)},
                        new Object[]{7, new UnificationEntry(circuit, MarkerMaterials.Tier.LuV)},
                        new Object[]{8, new UnificationEntry(circuit, MarkerMaterials.Tier.ZPM)},
                        new Object[]{9, new UnificationEntry(circuit, MarkerMaterials.Tier.UV)},
                        new Object[]{10, new UnificationEntry(circuit, MarkerMaterials.Tier.UHV)},
                        new Object[]{11, new UnificationEntry(circuit, MarkerMaterials.Tier.UEV)},
                        new Object[]{12, new UnificationEntry(circuit, MarkerMaterials.Tier.UIV)},
                        new Object[]{13, new UnificationEntry(circuit, MarkerMaterials.Tier.UXV)},
                        new Object[]{14, new UnificationEntry(circuit, MarkerMaterials.Tier.OpV)})
                .collect(Collectors.toMap((data) -> (Integer)data[0], (data) -> data[1])));

        MetaTileEntityLoader.registerMachineRecipe(true, AUTO_CHISEL,
                "GYG", "CHX", "WMW",
                'H', HULL,
                'M', MOTOR,
                'W', CABLE,
                'C', CONVEYOR,
                'X', "craftingChisel",
                'Y', LOWER_CIRCUIT,
                'G', GLASS);

        ModHandler.addShapedRecipe(true, "large_auto_chisel", LARGE_AUTO_CHISEL.getStackForm(),
                "GMG", "CXC", "WYW",
                'C', AUTO_CHISEL[2].getStackForm(),
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.HV),
                'W', new UnificationEntry(cableGtSingle, BlueAlloy),
                'Y', CONVEYOR_MODULE_HV,
                'G', MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.TEMPERED_GLASS),
                'M', ELECTRIC_MOTOR_HV);

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Iron, 4)
                .input(LARGE_AUTO_CHISEL, 16)
                .input(circuit, MarkerMaterials.Tier.HV, 16)
                .input(plateDouble, StainlessSteel, 4)
                .input(plateDouble, Chrome, 4)
                .input(gear, Invar, 4)
                .input(gearSmall, HSLASteel, 16)
                .input(cableGtQuadruple, Kanthal, 4)
                .fluidInputs(Tungsten.getFluid(L * 4))
                .output(INDUSTRIAL_3D_PRINTER)
                .EUt(VA[HV])
                .duration(300)
                .buildAndRegister();
    }
}
