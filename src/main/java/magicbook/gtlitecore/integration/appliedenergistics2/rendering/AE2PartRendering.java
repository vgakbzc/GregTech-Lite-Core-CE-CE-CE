package magicbook.gtlitecore.integration.appliedenergistics2.rendering;

import appeng.api.util.AEColor;
import appeng.bootstrap.IItemRendering;
import appeng.bootstrap.ItemRenderingCustomizer;
import appeng.client.render.StaticItemColor;
import appeng.items.parts.ItemPartRendering;
import magicbook.gtlitecore.integration.appliedenergistics2.items.AE2BaseItemPart;
import magicbook.gtlitecore.integration.appliedenergistics2.parts.AE2PartType;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AE2PartRendering extends ItemRenderingCustomizer {

    private static final ModelResourceLocation MODEL_MISSING = new ModelResourceLocation("builtin/missing", "missing");
    private final AE2BaseItemPart part;

    public AE2PartRendering(AE2BaseItemPart part) {
        this.part = part;
    }

    @SideOnly(Side.CLIENT)
    public void customize(IItemRendering rendering) {
        rendering.meshDefinition(this::getItemMeshDefinition);
        rendering.color(new StaticItemColor(AEColor.TRANSPARENT));
        //  Register all Item Models as variants so they get loaded.
        rendering.variants(Arrays.stream(AE2PartType.values())
                .filter(AE2PartType::isEnabled)
                .flatMap(part -> part.getItemModels().stream())
                .collect(Collectors.toList()));
    }

    @SideOnly(Side.CLIENT)
    private ModelResourceLocation getItemMeshDefinition(ItemStack stack) {
        var partType = this.part.getTypeByStack(stack);
        var variant = this.part.variantOf(stack.getItemDamage());
        if (partType == null)
            return MODEL_MISSING;
        return partType.getItemModels().get(variant);
    }
}
