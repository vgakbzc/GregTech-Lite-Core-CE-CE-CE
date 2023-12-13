package magicbook.gtlitecore.common.metatileentities.multi.part;

import gregtech.api.capability.IControllable;
import gregtech.api.capability.IGhostSlotConfigurable;
import gregtech.api.metatileentity.multiblock.IMultiblockAbilityPart;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.items.IItemHandlerModifiable;

public class MetaTileEntityItemBus extends gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityItemBus implements IMultiblockAbilityPart<IItemHandlerModifiable>, IControllable, IGhostSlotConfigurable {

    /**
     * @param metaTileEntityId Number of meta tile entity.
     * @param tier Hint: we use mixin to extend its capacity, so this tier is extend to OpV.
     * @param isExport Check hatch is export.
     */
    public MetaTileEntityItemBus(ResourceLocation metaTileEntityId,
                                 int tier,
                                 boolean isExport) {
        super(metaTileEntityId, tier, isExport);
    }


}