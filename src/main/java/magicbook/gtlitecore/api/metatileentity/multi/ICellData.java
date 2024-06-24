package magicbook.gtlitecore.api.metatileentity.multi;

import org.jetbrains.annotations.NotNull;

public interface ICellData {

    int getTier();

    long getCapacity();

    @NotNull String getCellName();
}
