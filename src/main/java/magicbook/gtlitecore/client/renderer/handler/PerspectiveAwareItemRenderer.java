package magicbook.gtlitecore.client.renderer.handler;

import codechicken.lib.render.item.IItemRenderer;
import com.google.common.collect.ImmutableList;
import magicbook.gtlitecore.client.utils.IEntityItemTickCallback;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.model.IModelState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class PerspectiveAwareItemRenderer implements IItemRenderer, IEntityItemTickCallback {

    @Nullable
    protected EntityLivingBase renderEntity;

    protected World world;

    protected BlockPos entityPos;

    private final IModelState state;

    protected PerspectiveAwareItemRenderer(IModelState state) {
        this.state = state;
    }

    @Override
    public boolean isAmbientOcclusion() {
        return true;
    }

    @Override
    public boolean isGui3d() {
        return false;
    }

    @Override
    public ItemOverrideList getOverrides() {
        return new EntityCachingOverrideList((entity, world) -> {
            renderEntity = entity;
            this.world = world;
            if (entity != null) {
                entityPos = entity.getPosition();
            }
        });
    }

    @Override
    public IModelState getTransforms() {
        return state;
    }

    @Override
    public void onEntityTick(EntityItem item) {
        entityPos = item.getPosition();
    }

    private static class EntityCachingOverrideList extends ItemOverrideList {

        private IEntityCallback callback;

        public EntityCachingOverrideList(IEntityCallback callback) {
            super(ImmutableList.of());
            this.callback = callback;
        }

        @NotNull
        @Override
        public IBakedModel handleItemState(@NotNull IBakedModel originalModel, @NotNull ItemStack stack, World world, EntityLivingBase entity) {
            callback.onEntityStuffs(entity, world);
            return super.handleItemState(originalModel, stack, world, entity);
        }
    }

    private interface IEntityCallback {

        void onEntityStuffs(EntityLivingBase entity, World world);
    }
}