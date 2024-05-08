package magicbook.gtlitecore.integration.threng;

import io.github.phantamanta44.threng.client.gui.GuiLevelMaintainer;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;

@SuppressWarnings("unused")
@JEIPlugin
public class LAE2JEIPlugin implements IModPlugin {

    @Override
    public void register(IModRegistry registry) {
        registry.addGhostIngredientHandler(GuiLevelMaintainer.class, new LAEGuiHandler());
    }
}
