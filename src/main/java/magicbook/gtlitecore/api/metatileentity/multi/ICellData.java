package magicbook.gtlitecore.api.metatileentity.multi;

import javax.annotation.Nonnull;

public interface ICellData {

    int getTier();

    long getCapacity();

    @Nonnull String getCellName();
}
