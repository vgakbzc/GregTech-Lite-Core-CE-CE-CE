package magicbook.gtlitecore.loaders;

import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.stack.ItemMaterialInfo;
import gregtech.api.unification.stack.MaterialStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.common.metatileentities.MetaTileEntities.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class MaterialInfoLoader {

    public static void init() {

        OreDictUnifier.registerOre(HULL[UHV].getStackForm(), new ItemMaterialInfo(
                new MaterialStack(Orichalcum, M * 8),
                new MaterialStack(Europium, M),
                new MaterialStack(Polyetheretherketone, M * 2)
        ));
    }
}
