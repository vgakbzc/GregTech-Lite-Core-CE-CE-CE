package magicbook.gtlitecore.api.unification.materials.info;

import gregtech.api.unification.material.info.MaterialIconSet;
import magicbook.gtlitecore.api.item.IItemRenderer;
import magicbook.gtlitecore.api.item.IItemRendererManager;
import net.minecraft.util.ResourceLocation;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MaterialIconSetWithRenderer extends MaterialIconSet implements IItemRenderer, IItemRendererManager {

    private IItemRendererManager rendererManager;

    public MaterialIconSetWithRenderer(@NotNull String name,
                                       IItemRendererManager rendererManager) {
        super(name);
        this.rendererManager = rendererManager;
    }

    public MaterialIconSetWithRenderer(@NotNull String name,
                                       @NotNull MaterialIconSet parentIconset,
                                       IItemRendererManager rendererManager) {
        super(name, parentIconset);
        this.rendererManager = rendererManager;
    }

    public MaterialIconSetWithRenderer(@NotNull String name,
                                       @Nullable MaterialIconSet parentIconset,
                                       boolean isRootIconset,
                                       IItemRendererManager rendererManager) {
        super(name, parentIconset, isRootIconset);
        this.rendererManager = rendererManager;
    }

    @Override
    public IItemRendererManager getRendererManager() {
        return rendererManager;
    }

    @Override
    public void onRendererRegistry(ResourceLocation location) {
        rendererManager.onRendererRegistry(location);
    }
}
