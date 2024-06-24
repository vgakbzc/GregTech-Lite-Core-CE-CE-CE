package magicbook.gtlitecore.integration.appliedenergistics2.utils;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class StateMapperHelper extends StateMapperBase {

    private final ResourceLocation registryName;

    public StateMapperHelper(ResourceLocation registryName) {
        this.registryName = registryName;
    }

    @NotNull
    @Override
    public ModelResourceLocation getModelResourceLocation(@NotNull IBlockState state) {
        return new ModelResourceLocation(this.registryName, this.getPropertyString(state.getProperties()));
    }
}
