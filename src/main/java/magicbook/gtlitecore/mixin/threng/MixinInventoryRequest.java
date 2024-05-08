package magicbook.gtlitecore.mixin.threng;

import io.github.phantamanta44.libnine.util.data.ISerializable;
import io.github.phantamanta44.threng.tile.TileLevelMaintainer;
import magicbook.gtlitecore.integration.threng.IInventoryRequest;
import net.minecraftforge.items.IItemHandlerModifiable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = TileLevelMaintainer.InventoryRequest.class, remap = false)
public abstract class MixinInventoryRequest implements ISerializable, IItemHandlerModifiable, IInventoryRequest {

    @Final
    @Shadow
    private TileLevelMaintainer owner;

    public TileLevelMaintainer getOwner() {
        return this.owner;
    }
}
