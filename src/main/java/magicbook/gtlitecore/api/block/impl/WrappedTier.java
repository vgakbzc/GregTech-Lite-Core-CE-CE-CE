package magicbook.gtlitecore.api.block.impl;

import magicbook.gtlitecore.api.block.IBlockTier;
import net.minecraft.util.IStringSerializable;
import org.jetbrains.annotations.NotNull;

public class WrappedTier implements IBlockTier {

    private final IStringSerializable inner;

    public WrappedTier(IStringSerializable inner) {
        this.inner = inner;
    }

    @NotNull
    @Override
    public String getName() {
        return inner.getName();
    }
}
