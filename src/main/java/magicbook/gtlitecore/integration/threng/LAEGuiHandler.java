package magicbook.gtlitecore.integration.threng;

import io.github.phantamanta44.threng.client.gui.GuiLevelMaintainer;
import mcp.MethodsReturnNonnullByDefault;
import mezz.jei.api.gui.IGhostIngredientHandler;

import java.util.ArrayList;
import java.util.List;

@MethodsReturnNonnullByDefault
public class LAEGuiHandler implements IGhostIngredientHandler<GuiLevelMaintainer> {

    @SuppressWarnings("unchecked")
    @Override
    public <I> List<Target<I>> getTargets(GuiLevelMaintainer gui, I ingredient, boolean doStart) {
        List<Target<I>> targets = new ArrayList<>();
        List<Target<?>> guiTarget = ((IGuiLevelMaintainer) gui).getTargets(ingredient);
        targets.addAll((List<Target<I>>) (Object) guiTarget);
        return targets;
    }

    @Override
    public void onComplete() {}
}
