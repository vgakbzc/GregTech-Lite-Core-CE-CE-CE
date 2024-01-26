package magicbook.gtlitecore.client.renderer;

import net.minecraft.entity.item.EntityItem;

@Deprecated
public interface IEntityItemTickCallback {

    void onEntityTick(EntityItem item);
}
