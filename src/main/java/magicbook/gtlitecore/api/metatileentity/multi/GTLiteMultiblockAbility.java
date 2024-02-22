package magicbook.gtlitecore.api.metatileentity.multi;

import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import magicbook.gtlitecore.api.capability.IGrindBallHatch;
import magicbook.gtlitecore.api.capability.IReinforcedRotorHolder;
import magicbook.gtlitecore.api.capability.IYottaHatch;

public class GTLiteMultiblockAbility {

    public static final MultiblockAbility<IGrindBallHatch> GRINDBALL_MULTIBLOCK_ABILITY = new MultiblockAbility<>("grindball");
    public static final MultiblockAbility<IReinforcedRotorHolder> REINFORCED_ROTOR_HOLDER_ABILITY = new MultiblockAbility<>("reinforced_rotor_holder");
    public static final MultiblockAbility<IYottaHatch> YOTTA_HATCH_MULTIBLOCK_ABILITY = new MultiblockAbility<>("yotta_hatch");
}