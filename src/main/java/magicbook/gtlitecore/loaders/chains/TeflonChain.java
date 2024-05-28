package magicbook.gtlitecore.loaders.chains;

import gregtech.api.metatileentity.multiblock.CleanroomType;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.VACUUM_CHAMBER_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.Teflon;

public class TeflonChain {

    public static void init() {

        //  15C2F4 + 3C2H2 + C + Na -> (C2F4)15(C2H2)3CNa
        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .input(dust, Polytetrafluoroethylene, 15)
                .input(dust, Polyethylene, 3)
                .input(dust, Carbon)
                .fluidInputs(Sodium.getFluid(1000))
                .fluidOutputs(Teflon.getFluid(2880))
                .EUt(VA[UHV])
                .duration(10 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }
}
