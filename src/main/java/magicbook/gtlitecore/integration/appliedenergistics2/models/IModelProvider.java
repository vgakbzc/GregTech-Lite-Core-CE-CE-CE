package magicbook.gtlitecore.integration.appliedenergistics2.models;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public interface IModelProvider extends IEnabled {

    ModelResourceLocation getModel();
}
