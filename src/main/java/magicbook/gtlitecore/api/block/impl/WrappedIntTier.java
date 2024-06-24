package magicbook.gtlitecore.api.block.impl;

import net.minecraft.util.IStringSerializable;

public class WrappedIntTier extends WrappedTier {

    private final int tier;

    public WrappedIntTier(IStringSerializable inner, int tier) {
        super(inner);
        this.tier = tier;
    }

    @Override
    public Integer getTier() {
        return tier;
    }

    public int getIntTier() {
        return tier;
    }
}
