package magicbook.gtlitecore.api.metatileentity.multi;

import magicbook.gtlitecore.api.capability.IReinforcedRotorHolder;

import java.util.List;

public interface ITurbineMode {

    List<IReinforcedRotorHolder> getRotorHolders();
    int getMode();
}
