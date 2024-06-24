package magicbook.gtlitecore.common.metatileentities.multi.electric;

import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.Widget;
import gregtech.api.gui.widgets.ClickButtonWidget;
import gregtech.api.gui.widgets.WidgetGroup;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.client.utils.TooltipHelper;
import gregtech.common.blocks.BlockBoilerCasing;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;
import magicbook.gtlitecore.api.capability.impl.HeatExchangerRecipeLogic;
import magicbook.gtlitecore.api.metatileentity.multi.IHeatExchanger;
import magicbook.gtlitecore.api.metatileentity.multi.NoEnergyMultiblockController;
import magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static gregtech.api.gui.widgets.AdvancedTextWidget.withHoverTextTranslate;
import static net.minecraft.util.text.TextFormatting.*;

/**
 * Heat Exchanger
 *
 * @author Gate Guardian
 *
 * <p>
 *     TODO In Nuclear Fission branch, GTCEu add a new machine which also named by 'Heat Exchanger',
 *     if this branch is merged, should renamed it to 'Reactor Heat Exchanger'.
 * </p>
 *
 * @since 2.7.4-beta
 */
public class MetaTileEntityHeatExchanger extends NoEnergyMultiblockController implements IHeatExchanger {

    private final int heatTime = 150;
    private int thresholdPercentage = 100;

    public MetaTileEntityHeatExchanger(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GTLiteRecipeMaps.HEAT_EXCHANGE_RECIPES);
        this.recipeMapWorkable = new HeatExchangerRecipeLogic(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityHeatExchanger(metaTileEntityId);
    }

    @NotNull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("CCC", "CCC", "CCC", "CCC")
                .aisle("CIC", "CPC", "CPC", "CEC")
                .aisle("CSC", "CCC", "CCC", "CCC")
                .where('S', selfPredicate())
                .where('C', states(getCasingState())
                        .setMinGlobalLimited(24)
                        .or(abilities(MultiblockAbility.EXPORT_FLUIDS))
                        .or(abilities(MultiblockAbility.IMPORT_FLUIDS)))
                .where('P', states(getBoilerCasingState()))
                .where('I', abilities(MultiblockAbility.IMPORT_FLUIDS))
                .where('E', abilities(MultiblockAbility.EXPORT_FLUIDS))
                .build();
    }

    private static IBlockState getCasingState() {
        return MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.TITANIUM_STABLE);
    }

    private static IBlockState getBoilerCasingState() {
        return MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.TITANIUM_PIPE);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return Textures.STABLE_TITANIUM_CASING;
    }

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        super.addDisplayText(textList);
        if (isStructureFormed()) {
            HeatExchangerRecipeLogic logic = (HeatExchangerRecipeLogic)recipeMapWorkable;
            textList.add(new TextComponentTranslation("gtlitecore.machine.heat_exchanger.rate." + logic.isSuperheat(), logic.getRate()));
            int efficiency = (int) Math.ceil(logic.getHeatEfficiency() * (40 + 0.6 * thresholdPercentage));
            textList.add(new TextComponentTranslation("gtlitecore.machine.heat_exchanger.efficiency",
                    (efficiency == 0 ? DARK_RED : efficiency <= 40 ? RED : efficiency == 100 ? GREEN : YELLOW).toString() + efficiency + "%"));
            ITextComponent throttleText = new TextComponentTranslation("gtlitecore.machine.heat_exchanger.threshold",
                    AQUA.toString() + getThrottle() + "%");
            withHoverTextTranslate(throttleText, "gtlitecore.machine.heat_exchanger.threshold.tooltip");
            textList.add(throttleText);
        }
    }

    @Override
    @NotNull
    protected Widget getFlexButton(int x, int y, int width, int height) {
        WidgetGroup group = new WidgetGroup(x, y, width, height);
        group.addWidget(new ClickButtonWidget(0, 0, 9, 18, "", this::decrementThreshold)
                .setButtonTexture(GuiTextures.BUTTON_THROTTLE_MINUS)
                .setTooltipText("gtlitecore.machine.heat_exchanger.threshold_decrement"));
        group.addWidget(new ClickButtonWidget(9, 0, 9, 18, "", this::incrementThreshold)
                .setButtonTexture(GuiTextures.BUTTON_THROTTLE_PLUS)
                .setTooltipText("gtlitecore.machine.heat_exchanger.threshold_increment"));
        return group;
    }

    private void incrementThreshold(Widget.ClickData clickData) {
        this.thresholdPercentage = MathHelper.clamp(thresholdPercentage + 5, 25, 100);
    }

    private void decrementThreshold(Widget.ClickData clickData) {
        this.thresholdPercentage = MathHelper.clamp(thresholdPercentage - 5, 25, 100);
    }

    @Override
    public String[] getDescription() {
        return new String[]{I18n.format("gtlitecore.machine.heat_exchanger.description")};
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World player,
                               @NotNull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gtlitecore.machine.heat_exchanger.heat_time_tooltip", heatTime));
        tooltip.add(TooltipHelper.BLINKING_RED + I18n.format("gtlitecore.machine.heat_exchanger.explosion_tooltip"));
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound data) {
        data.setInteger("ThresholdPercentage", thresholdPercentage);
        return super.writeToNBT(data);
    }

    @Override
    public void readFromNBT(NBTTagCompound data) {
        thresholdPercentage = data.getInteger("ThresholdPercentage");
        super.readFromNBT(data);
    }

    @Override
    public void writeInitialSyncData(PacketBuffer buf) {
        super.writeInitialSyncData(buf);
        buf.writeVarInt(thresholdPercentage);
    }

    @Override
    public void receiveInitialSyncData(PacketBuffer buf) {
        super.receiveInitialSyncData(buf);
        thresholdPercentage = buf.readVarInt();
    }

    @Override
    public int getThrottle() {
        return thresholdPercentage;
    }

    @Override
    public int getHeatTime() {
        return heatTime;
    }

    @Override
    public int getParallel() {
        return 1;
    }

    @Override
    public boolean hasMaintenanceMechanics() {
        return false;
    }

    @Override
    public boolean canVoidRecipeItemOutputs() {
        return true;
    }

    @Override
    public boolean canVoidRecipeFluidOutputs() {
        return true;
    }

    @Override
    protected boolean shouldShowVoidingModeButton() {
        return false;
    }
}