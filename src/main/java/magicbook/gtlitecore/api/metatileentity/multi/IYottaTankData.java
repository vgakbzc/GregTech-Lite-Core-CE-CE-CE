package magicbook.gtlitecore.api.metatileentity.multi;

import javax.annotation.Nonnull;

public interface IYottaTankData {
    int getTier();

    long getCapacity();

    @Nonnull String getFluidCellName();
}
