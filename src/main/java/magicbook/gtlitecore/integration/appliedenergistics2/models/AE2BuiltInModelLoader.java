package magicbook.gtlitecore.integration.appliedenergistics2.models;

import com.google.common.collect.ImmutableMap;
import magicbook.gtlitecore.api.utils.Mods;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class AE2BuiltInModelLoader implements ICustomModelLoader {

    private final Map<String, IModel> builtInModels;

    public AE2BuiltInModelLoader(Map<String, IModel> builtInModels) {
        this.builtInModels = ImmutableMap.copyOf(builtInModels);
    }

    //  TODO Check if this override is running properly.
    @Override
    public boolean accepts(@NotNull ResourceLocation modelLocation) {
        return modelLocation.getNamespace().equals(Mods.GregTechLiteCore)
                && this.builtInModels.containsKey(modelLocation.getPath());
    }

    @NotNull
    @Override
    public IModel loadModel(@NotNull ResourceLocation modelLocation) {
        return this.builtInModels.get(modelLocation.getPath());
    }

    //  TODO Find some substitute of IResourceManagerReloadListener.
    @SuppressWarnings("deprecation")
    @Override
    public void onResourceManagerReload(@NotNull IResourceManager resourceManager) {
        for (var model : this.builtInModels.values()) {
            if (model instanceof IResourceManagerReloadListener) {
                ((IResourceManagerReloadListener) model).onResourceManagerReload(resourceManager);
            }
        }
    }
}
