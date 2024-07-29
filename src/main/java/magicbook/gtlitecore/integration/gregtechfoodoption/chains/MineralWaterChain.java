package magicbook.gtlitecore.integration.gregtechfoodoption.chains;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtechfoodoption.item.GTFOMetaItem;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.foil;
import static gregtech.api.unification.ore.OrePrefix.plate;
import static gregtech.api.unification.ore.OrePrefix.ring;
import static gregtech.common.items.MetaItems.SHAPE_MOLD_BALL;
import static gregtech.common.items.MetaItems.SHAPE_MOLD_CYLINDER;

public class MineralWaterChain {

    public static void init() {

        //  Thermos Casing
        FORMING_PRESS_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_CYLINDER)
                .input(plate, Technetium, 2)
                .input(plate, Polytetrafluoroethylene, 2)
                .output(GTFOMetaItem.THERMOS_CASING)
                .EUt(VA[IV])
                .duration(400)
                .buildAndRegister();

        //  Thermos Cap
        FORMING_PRESS_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_BALL)
                .input(plate, TungstenSteel)
                .input(ring, Rubber, 2)
                .input(foil, Polytetrafluoroethylene, 2)
                .output(GTFOMetaItem.THERMOS_CAP)
                .EUt(VA[IV])
                .duration(200)
                .buildAndRegister();

        //  Thermos Cap + Thermos Casing -> Thermos
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(GTFOMetaItem.THERMOS_CAP)
                .input(GTFOMetaItem.THERMOS_CASING)
                .output(GTFOMetaItem.THERMOS)
                .EUt(VH[ULV])
                .duration(40)
                .buildAndRegister();

        //  Thermos -> Mineral Water
        CANNER_RECIPES.recipeBuilder()
                .input(GTFOMetaItem.THERMOS)
                .fluidInputs(DistilledWater.getFluid(1000))
                .output(GTFOMetaItem.MINERAL_WATER)
                .EUt(VA[HV])
                .duration(20)
                .buildAndRegister();

        //  After eating, Mineral Water -> Used Thermos, then cycle in this recipe.
        PACKER_RECIPES.recipeBuilder()
                .input(GTFOMetaItem.USED_THERMOS)
                .output(GTFOMetaItem.LEACHED_THERMOS_CASING)
                .output(GTFOMetaItem.THERMOS_CAP)
                .EUt(VA[ULV])
                .duration(20)
                .buildAndRegister();

        //  Leached Thermos Casing -> Thermos Casing
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(GTFOMetaItem.LEACHED_THERMOS_CASING)
                .fluidInputs(AquaRegia.getFluid(L))
                .output(GTFOMetaItem.THERMOS_CASING)
                .EUt(VA[EV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }
}
