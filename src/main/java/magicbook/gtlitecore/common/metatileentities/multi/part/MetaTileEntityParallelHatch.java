package magicbook.gtlitecore.common.metatileentities.multi.part;


import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregicality.multiblocks.api.capability.IParallelHatch;
import gregicality.multiblocks.api.metatileentity.GCYMMultiblockAbility;
import gregicality.multiblocks.api.render.GCYMTextures;
import gregtech.api.GTValues;
import gregtech.api.capability.GregtechTileCapabilities;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.widgets.*;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockAbilityPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityMultiblockPart;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntSupplier;

public class MetaTileEntityParallelHatch extends MetaTileEntityMultiblockPart implements IMultiblockAbilityPart<IParallelHatch>, IParallelHatch {

    private static final int MIN_PARALLEL = 1;

    private final int maxParallel;

    private int currentParallel;

    public MetaTileEntityParallelHatch(ResourceLocation metaTileEntityId, int tier) {
        super(metaTileEntityId, tier);
        this.maxParallel = (int) Math.pow(2, tier+1);
        this.currentParallel = this.maxParallel;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity metaTileEntityHolder) {
        return new MetaTileEntityParallelHatch(this.metaTileEntityId, this.getTier());
    }

    @Override
    public int getCurrentParallel() {
        return currentParallel;
    }

    public void setCurrentParallel(int parallelAmount) {
        this.currentParallel = MathHelper.clamp(this.currentParallel + parallelAmount, 1, this.maxParallel);
    }

    @Override
    protected ModularUI createUI( EntityPlayer entityPlayer) {
        ServerWidgetGroup parallelAmountGroup = new ServerWidgetGroup(() -> true);
        parallelAmountGroup.addWidget(new ImageWidget(62, 36, 53, 20, GuiTextures.DISPLAY)
                .setTooltip("gcym.machine.parallel_hatch.display"));

        parallelAmountGroup.addWidget(new IncrementButtonWidget(118, 36, 30, 20, maxParallel>64?maxParallel/64:1,  maxParallel>32?maxParallel/32:1, maxParallel>16?maxParallel/16:1, maxParallel/4, this::setCurrentParallel)
                .setDefaultTooltip()
                .setShouldClientCallback(false));
        parallelAmountGroup.addWidget(new IncrementButtonWidget(29, 36, 30, 20,  maxParallel>64?-maxParallel/64:-1, maxParallel>32?-maxParallel/32:-1,  maxParallel>16?-maxParallel/16:-1, -maxParallel/4, this::setCurrentParallel)
                .setDefaultTooltip()
                .setShouldClientCallback(false));

        parallelAmountGroup.addWidget(new TextFieldWidget2(63, 42, 51, 20, this::getParallelAmountToString, val -> {
            if (val != null && !val.isEmpty()) {
                setCurrentParallel(Integer.parseInt(val));
            }
        })
                .setCentered(true)
                .setNumbersOnly(1, this.maxParallel)
                .setMaxLength(6)
                .setValidator(getTextFieldValidator(() -> this.maxParallel)));

        return ModularUI.defaultBuilder()
                .widget(new LabelWidget(5, 5, getMetaFullName()))
                .widget(parallelAmountGroup)
                .bindPlayerInventory(entityPlayer.inventory, GuiTextures.SLOT, 0)
                .build(getHolder(), entityPlayer);
    }

    public String getParallelAmountToString() {
        return Integer.toString(this.currentParallel);
    }

    public static  Function<String, String> getTextFieldValidator(IntSupplier maxSupplier) {
        return val -> {
            if (val.isEmpty())
                return String.valueOf(MIN_PARALLEL);
            int max = maxSupplier.getAsInt();
            int num;
            try {
                num = Integer.parseInt(val);
            } catch (NumberFormatException ignored) {
                return String.valueOf(max);
            }
            if (num < MIN_PARALLEL)
                return String.valueOf(MIN_PARALLEL);
            if (num > max)
                return String.valueOf(max);
            return val;
        };
    }

    @Override
    public void addInformation(ItemStack stack,  World player,  List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gcym.machine.parallel_hatch.tooltip", this.maxParallel));
        tooltip.add(I18n.format("gregtech.universal.disabled"));
    }

    @Override
    public MultiblockAbility<IParallelHatch> getAbility() {
        return GCYMMultiblockAbility.PARALLEL_HATCH;
    }

    @Override
    public void registerAbilities( List<IParallelHatch> list) {
        list.add(this);
    }

    @Override
    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        if (shouldRenderOverlay()) {
            OrientedOverlayRenderer overlayRenderer = getOrientedOverlayRenderer();

            if (getController() != null && getController() instanceof RecipeMapMultiblockController) {
                overlayRenderer.renderOrientedState(renderState, translation, pipeline, getFrontFacing(),
                        getController().isActive(),
                        getController().getCapability(GregtechTileCapabilities.CAPABILITY_CONTROLLABLE, null)
                                .isWorkingEnabled());
            } else {
                overlayRenderer.renderOrientedState(renderState, translation, pipeline, getFrontFacing(), false, false);
            }
        }
    }

    private OrientedOverlayRenderer getOrientedOverlayRenderer() {
        if (getTier() <= GTValues.HV)
            return GCYMTextures.PARALLEL_HATCH_MK1_OVERLAY;
        else if (getTier() <= GTValues.LuV)
            return GCYMTextures.PARALLEL_HATCH_MK2_OVERLAY;
        else if (getTier() <= GTValues.UHV)
            return GCYMTextures.PARALLEL_HATCH_MK3_OVERLAY;
        else
            return GCYMTextures.PARALLEL_HATCH_MK4_OVERLAY;
    }

    @Override
    public boolean canPartShare() {
        return false;
    }

    @Override
    public NBTTagCompound writeToNBT( NBTTagCompound data) {
        data.setInteger("currentParallel", this.currentParallel);
        return super.writeToNBT(data);
    }


    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        this.currentParallel = data.getInteger("currentParallel");
    }

    @Override
    public void writeInitialSyncData(PacketBuffer buf) {
        super.writeInitialSyncData(buf);
        buf.writeInt(this.currentParallel);
    }

    @Override
    public void receiveInitialSyncData(PacketBuffer buf) {
        super.receiveInitialSyncData(buf);
        this.currentParallel = buf.readInt();
    }
}