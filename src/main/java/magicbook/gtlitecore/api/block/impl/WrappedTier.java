package magicbook.gtlitecore.api.block.impl;

import magicbook.gtlitecore.api.block.IBlockTier;
import net.minecraft.util.IStringSerializable;

import javax.annotation.Nonnull;

public class WrappedTier implements IBlockTier {

    private final IStringSerializable inner;

    public WrappedTier(IStringSerializable inner) {
        this.inner = inner;
    }

    @Override
    @Nonnull
    public String getName() {
        return inner.getName();
    }
}
