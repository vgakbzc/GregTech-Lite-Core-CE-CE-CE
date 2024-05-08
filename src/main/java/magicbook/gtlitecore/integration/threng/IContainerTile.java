package magicbook.gtlitecore.integration.threng;

import net.minecraft.tileentity.TileEntity;

public interface IContainerTile<T extends TileEntity> {

    T getTile();
}
