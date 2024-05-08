package magicbook.gtlitecore.mixin.threng;

import io.github.phantamanta44.libnine.gui.L9Container;
import io.github.phantamanta44.threng.inventory.base.ContainerTile;
import magicbook.gtlitecore.integration.threng.IContainerTile;
import net.minecraft.tileentity.TileEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = ContainerTile.class, remap = false)
public abstract class MixinContainerTile<T extends TileEntity> extends L9Container implements IContainerTile<T> {

    @Final
    @Shadow
    protected T tile;

    @Override
    public T getTile() {
        return this.tile;
    }
}
