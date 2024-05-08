package magicbook.gtlitecore.integration.threng;

import mezz.jei.api.gui.IGhostIngredientHandler;

import java.util.List;

public interface IGuiLevelMaintainer {

    List<IGhostIngredientHandler.Target<?>> getTargets(Object ingredient);
}
