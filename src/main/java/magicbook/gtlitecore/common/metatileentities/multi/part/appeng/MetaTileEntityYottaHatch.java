package magicbook.gtlitecore.common.metatileentities.multi.part.appeng;

import appeng.api.AEApi;
import appeng.api.config.AccessRestriction;
import appeng.api.config.Actionable;
import appeng.api.networking.IGrid;
import appeng.api.networking.IGridNode;
import appeng.api.networking.events.MENetworkCellArrayUpdate;
import appeng.api.networking.events.MENetworkStorageEvent;
import appeng.api.networking.security.IActionHost;
import appeng.api.networking.security.IActionSource;
import appeng.api.networking.storage.IStorageGrid;
import appeng.api.storage.*;
import appeng.api.storage.channels.IFluidStorageChannel;
import appeng.api.storage.data.IAEFluidStack;
import appeng.api.storage.data.IItemList;
import appeng.api.util.AEPartLocation;
import appeng.api.util.DimensionalCoord;
import appeng.fluids.util.AEFluidStack;
import appeng.me.helpers.AENetworkProxy;
import appeng.me.helpers.IGridProxyable;
import codechicken.lib.raytracer.CuboidRayTraceResult;
import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregtech.api.capability.GregtechDataCodes;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.widgets.*;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockAbilityPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.common.metatileentities.multi.multiblockpart.appeng.MetaTileEntityAEHostablePart;
import magicbook.gtlitecore.api.capability.IYottaHatch;
import magicbook.gtlitecore.api.metatileentity.multi.GTLiteMultiblockAbility;
import magicbook.gtlitecore.api.utils.GTLiteUtils;
import magicbook.gtlitecore.client.GTLiteTextures;
import magicbook.gtlitecore.common.metatileentities.multi.storage.MetaTileEntityYottaFluidTank;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Yotta Hatch
 *
 * @author GlodBlock (original author)
 *
 * <p>
 *     This multiblock part is a special I/O hatch for Yotta Fluid Tank.
 *     It can create bridge between ME Network and Yotta Fluid Tank.
 *     hmmm...may be this part is like a ME Fluid Storage Bus?
 * </p>
 *
 * <p>FIXME this part can not read yotta fluid tank fluid to ae2, but why???</p>
 */
public class MetaTileEntityYottaHatch extends MetaTileEntityAEHostablePart implements IMultiblockAbilityPart<IYottaHatch>, IGridProxyable, IActionHost, ICellContainer, IMEInventory<IAEFluidStack>, IMEInventoryHandler<IAEFluidStack> {

    public MetaTileEntityYottaFluidTank host;
    private final IYottaHatch fluidContainer;
    private AccessRestriction readMode = AccessRestriction.READ_WRITE;
    private final AccessRestriction[] AEModes = new AccessRestriction[] {
            AccessRestriction.NO_ACCESS,
            AccessRestriction.READ,
            AccessRestriction.WRITE,
            AccessRestriction.READ_WRITE
    };
    private int priority;

    public MetaTileEntityYottaHatch(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, 5, false);
        this.fluidContainer = null;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityYottaHatch(metaTileEntityId);
    }

    @Override
    public void renderMetaTileEntity(CCRenderState renderState,
                                     Matrix4 translation,
                                     IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        if (this.shouldRenderOverlay()) {
            GTLiteTextures.YOTTA_HATCH.renderSided(getFrontFacing(), renderState, translation, pipeline);
        }
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World player,
                               @Nonnull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gtlitecore.machine.yotta_hatch.tooltip.1"));
        tooltip.add(I18n.format("gtlitecore.machine.yotta_hatch.tooltip.2"));
        tooltip.add(I18n.format("gtlitecore.machine.yotta_hatch.tooltip.3"));
        tooltip.add(I18n.format("gtlitecore.machine.yotta_hatch.tooltip.4"));
    }

    @Override
    protected ModularUI createUI(@Nonnull EntityPlayer player) {
        ServerWidgetGroup group = new ServerWidgetGroup(() -> true);
        group.addWidget(new ImageWidget(62, 36, 53, 20, GuiTextures.DISPLAY)
                .setTooltip("gtlitecore.machine.yotta_fluid_tank.display"));
        group.addWidget(new IncrementButtonWidget(118, 36, 30, 20, 1, 10, 100, 1000, this::setCurrentPriority)
                .setDefaultTooltip()
                .setShouldClientCallback(false));
        group.addWidget(new IncrementButtonWidget(29, 36, 30, 20, -1, -10, -100, -1000, this::setCurrentPriority)
                .setDefaultTooltip()
                .setShouldClientCallback(false));
        group.addWidget(new TextFieldWidget2(63, 42, 51, 20, this::getPriorityToString, (val) -> {
            if (val != null && !val.isEmpty()) {
                this.setCurrentPriority(Integer.parseInt(val));
            }
        }).setCentered(true).setNumbersOnly(1, priority).setValidator(GTLiteUtils.getTextFieldValidator(() -> this.priority)));
        return ModularUI.defaultBuilder()
                .widget(new LabelWidget(5, 5, this.getMetaFullName()))
                .widget(group)
                .bindPlayerInventory(player.inventory, GuiTextures.SLOT, 0)
                .build(this.getHolder(), player);
    }

    private void setCurrentPriority(int priority) {
        this.priority = priority;
    }

    private String getPriorityToString() {
        return Integer.toString(this.priority);
    }

    @Override
    public boolean onScrewdriverClick(EntityPlayer player,
                                      EnumHand hand,
                                      EnumFacing facing,
                                      CuboidRayTraceResult hitResult) {
        this.readMode = AEModes[(readMode.ordinal() + 1) % 4];
        //player.sendMessage(new TextComponentTranslation("gtlitecore.machine.yotta_fluid_tank.read_mode"));
        return true;
    }

    @Override
    public NBTTagCompound writeToNBT(net.minecraft.nbt.NBTTagCompound data) {
        super.writeToNBT(data);
        data.setInteger("AEPriority", this.priority);
        data.setInteger("AEMode", this.readMode.ordinal());
        return data;
    }

    @Override
    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        this.priority = data.getInteger("AEPriority");
        this.readMode = AEModes[data.getInteger("AEMode")];
    }

    @Override
    public boolean isWorkingEnabled() {
        return true;
    }

    @Override
    public void setWorkingEnabled(boolean workingEnabled) {
        if (this.getWorld() != null && !this.getWorld().isRemote)
            writeCustomData(GregtechDataCodes.WORKING_ENABLED, buf -> buf.writeBoolean(workingEnabled));
    }

    @Override
    public MultiblockAbility<IYottaHatch> getAbility() {
        return GTLiteMultiblockAbility.YOTTA_HATCH_MULTIBLOCK_ABILITY;
    }

    @Override
    public void registerAbilities(List<IYottaHatch> list) {
        list.add(fluidContainer);
    }

    @Override
    public void update() {
        if (host == null)
            return;
        if (!this.getWorld().isRemote) {
            if (isChanged()) {
                IGridNode node = getGridNode(null);
                if (node != null) {
                    IGrid grid = node.getGrid();
                    if (grid != null) {
                        grid.postEvent(new MENetworkCellArrayUpdate());
                        IStorageGrid storageGrid = grid.getCache(IStorageGrid.class);
                        if (storageGrid == null) {
                            node.getGrid().postEvent(new MENetworkStorageEvent(null, getChannel()));
                        } else {
                            node.getGrid().postEvent(new MENetworkStorageEvent(storageGrid.getInventory(getChannel()), getChannel()));
                        }
                        node.getGrid().postEvent(new MENetworkCellArrayUpdate());
                    }
                }
            }
        }
        super.update();
    }

    private boolean isChanged() {
        if (host == null)
            return false;
        return host.getFluid() != null;
    }

    @Override
    public DimensionalCoord getLocation() {
        int posX = this.getPos().getX();
        int posY = this.getPos().getY();
        int posZ = this.getPos().getZ();
        return new DimensionalCoord(this.getWorld(), posX, posY, posZ);
    }

    @Nullable
    @Override
    public IGridNode getGridNode(@Nonnull AEPartLocation location) {
        AENetworkProxy gp = getProxy();
        return gp != null ? gp.getNode() : null;
    }

    @Override
    public void securityBreak() {}

    @Override
    public void blinkCell(int i) {}

    @Nonnull
    @Override
    public IGridNode getActionableNode() {
        AENetworkProxy gp = getProxy();
        return gp != null ? gp.getNode() : null;
    }

    @Override
    public List<IMEInventoryHandler> getCellArray(IStorageChannel<?> channel) {
        List<IMEInventoryHandler> list = new ArrayList<>();
        if (channel == getChannel()) {
            list.add(this);
        }
        return list;
    }

    @Override
    public AccessRestriction getAccess() {
        return AccessRestriction.READ_WRITE;
    }

    @Override
    public boolean isPrioritized(IAEFluidStack iaeFluidStack) {
        return true;
    }

    @Override
    public boolean canAccept(IAEFluidStack iaeFluidStack) {
        return true;
    }

    @Override
    public int getPriority() {
        return this.priority;
    }

    @Override
    public int getSlot() {
        return 0;
    }

    @Override
    public boolean validForPass(int i) {
        return true;
    }

    @Override
    public IAEFluidStack injectItems(IAEFluidStack fluidStack,
                                     Actionable actionable,
                                     IActionSource iActionSource) {
        long amount = fill(fluidStack, false);
        if (amount == fluidStack.getStackSize()) {
            if (actionable.equals(Actionable.MODULATE))
                fill(fluidStack, true);
            return null;
        }
        return fluidStack;
    }

    public int fill(FluidStack resource,
                    boolean doFill) {
        if (host == null || !host.isActive())
            return 0;
        if (host.getFluid() != null && !host.getFluid().getLocalizedName().equals("") && !host.getFluid().equals(resource.getFluid().getName()))
            return 0;
        if (host.getFluid() == null || host.getFluid().getLocalizedName().equals("") || host.getFluid().equals(resource.getFluid().getName())) {
            host.setFluid(new FluidStack(resource.getFluid(),0));
            if (host.getFluidTank().getCapacity().subtract(host.getFluidTank().getStored()).compareTo(BigInteger.valueOf(resource.amount)) >= 0) {
                if (doFill)
                    host.getFluidTank().fill(resource.amount);
                return resource.amount;
            } else {
                long left = 0;
                int added = host.getFluidTank().getCapacity().subtract(host.getFluidTank().getStored()).intValue();
                if (doFill)
                    left = host.getFluidTank().fill(added);
                return (int) left;
            }
        }
        return 0;
    }

    public long fill(IAEFluidStack resource, boolean doFill) {
        if (host == null  || !host.isActive())
            return 0;
        if (host.getFluid() != null && !host.getFluid().getLocalizedName().equals("") && !host.getFluid().equals(resource.getFluid().getName()))
            return 0;
        if (host.getFluid() == null || host.getFluid().getLocalizedName().equals("") || host.getFluid().equals(resource.getFluid().getName())){
            host.setFluid(new FluidStack(resource.getFluid(),0));
            if (host.getFluidTank().getCapacity().subtract(host.getFluidTank().getStored()).compareTo(BigInteger.valueOf(resource.getStackSize())) >= 0) {
                if (doFill)
                    host.getFluidTank().fill(resource.getStackSize());
                return resource.getStackSize();
            } else {
                long left = 0;
                long added = host.getFluidTank().getCapacity().subtract(host.getFluidTank().getStored()).longValue();
                if (doFill)
                    left = host.getFluidTank().fill(added);
                return left;
            }
        }
        return 0;
    }
    @Override
    public IAEFluidStack extractItems(IAEFluidStack fluidStack,
                                      Actionable actionable,
                                      IActionSource iActionSource) {
        IAEFluidStack ready = drain(fluidStack, false);
        if (ready != null) {
            if (actionable.equals(Actionable.MODULATE)) drain(ready, true);
            return ready;
        } else return null;
    }

    public FluidStack drain(FluidStack resource, boolean doDrain) {
        if (host == null || !host.isActive())
            return null;
        if (host.getFluid() != null && !host.getFluid().getLocalizedName().equals("") && !host.getFluid().equals(resource.getFluid().getName()))
            return null;
        int ready;
        if (host.getFluidTank().getStored().compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
            ready = Integer.MAX_VALUE;
        } else
            ready = host.getFluidTank().getStored().intValue();
        ready = Math.min(ready, resource.amount);
        if (doDrain)
            host.getFluidTank().drain(ready);
        return new FluidStack(resource.getFluid(), ready);
    }

    public IAEFluidStack drain(IAEFluidStack resource, boolean doDrain) {
        if (host == null || !host.isActive())
            return null;
        if (host.getFluid() != null && !host.getFluid().getLocalizedName().equals("") && !host.getFluid().equals(resource.getFluid().getName()))
            return null;
        long ready;
        if (host.getFluidTank().getStored().compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0) {
            ready = Long.MAX_VALUE;
        } else
            ready = host.getFluidTank().getStored().longValue();
        ready = Math.min(ready, resource.getStackSize());
        if (doDrain)
            host.getFluidTank().drain(ready);
        IAEFluidStack copy = resource.copy();
        copy.setStackSize(ready);
        return copy;
    }

    @Override
    public IItemList<IAEFluidStack> getAvailableItems(IItemList<IAEFluidStack> itemList) {
        if (host == null || !host.isActive())
            return itemList;
        if (host.getFluid() == null || host.getFluid().getLocalizedName().equals("") || host.getFluidTank().getStored().compareTo(BigInteger.ZERO) <= 0)
            return itemList;
        int ready;
        if (host.getFluidTank().getStored().compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
            ready = Integer.MAX_VALUE;
        } else
            ready = host.getFluidTank().getStored().intValue();
        itemList.add(AEFluidStack.fromFluidStack(new FluidStack(host.getFluid(),ready)));
        return itemList;
    }

    @Override
    public IStorageChannel<IAEFluidStack> getChannel() {
        return AEApi.instance().storage().getStorageChannel(IFluidStorageChannel.class);
    }

    @Override
    public void saveChanges(@Nullable ICellInventory<?> iCellInventory) {}
}
