package magicbook.gtlitecore.api.metatileentity.multi;

import org.jetbrains.annotations.NotNull;

public interface IYottaTankData {
    int getTier();

    long getCapacity();

    @NotNull String getFluidCellName();
}
