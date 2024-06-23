package magicbook.gtlitecore.integration.appliedenergistics2.rendering;

import appeng.bootstrap.IItemRendering;
import appeng.bootstrap.ItemRenderingCustomizer;
import magicbook.gtlitecore.integration.appliedenergistics2.models.IEnabled;
import magicbook.gtlitecore.integration.appliedenergistics2.models.IModelProvider;
import magicbook.gtlitecore.integration.appliedenergistics2.upgrades.IDamagedDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.stream.Collectors;

public class DamagedItemRendering<T extends IDamagedDefinition<?, ?>> extends ItemRenderingCustomizer {

    public static final ModelResourceLocation MODEL_MISSING = new ModelResourceLocation("builtin/missing", "missing");
    private final T registry;

    public DamagedItemRendering(T registry) {
        this.registry = registry;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void customize(IItemRendering rendering) {
        rendering.variants(this.registry.getEntries().stream()
                .filter(IEnabled::isEnabled)
                .map(IModelProvider::getModel)
                .collect(Collectors.toList()));

        rendering.meshDefinition(is -> {
            var type = this.registry.getType(is);

            if (type == null) {
                return MODEL_MISSING;
            }

            return type.getModel();
        });
    }
}
