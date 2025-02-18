package magicbook.gtlitecore.common.metatileentities.multi.electric;

import gregtech.api.capability.IEnergyContainer;
import gregtech.api.capability.impl.EnergyContainerList;
import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.capability.impl.ItemHandlerList;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.unification.material.Materials;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.utils.TooltipHelper;
import gregtech.common.blocks.MetaBlocks;
import magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps;
import magicbook.gtlitecore.client.renderer.texture.GTLiteTextures;
import magicbook.gtlitecore.common.blocks.BlockFusionCasing;
import magicbook.gtlitecore.common.blocks.BlockMultiblockCasing;
import magicbook.gtlitecore.common.blocks.BlockUniqueCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MetaTileEntityStellarFurnace extends RecipeMapMultiblockController {

    public MetaTileEntityStellarFurnace(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GTLiteRecipeMaps.STELLAR_FURNACE_RECIPES);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityStellarFurnace(metaTileEntityId);
    }
    @Override
    protected void initializeAbilities() {
        this.inputInventory = new ItemHandlerList(this.getAbilities(MultiblockAbility.IMPORT_ITEMS));
        this.inputFluidInventory = new FluidTankList(this.allowSameFluidFillForOutputs(), this.getAbilities(MultiblockAbility.IMPORT_FLUIDS));
        this.outputInventory = new ItemHandlerList(this.getAbilities(MultiblockAbility.EXPORT_ITEMS));
        this.outputFluidInventory = new FluidTankList(this.allowSameFluidFillForOutputs(), this.getAbilities(MultiblockAbility.EXPORT_FLUIDS));
        List<IEnergyContainer> energyContainer = new ArrayList<>(this.getAbilities(MultiblockAbility.INPUT_ENERGY));
        energyContainer.addAll(this.getAbilities(MultiblockAbility.INPUT_LASER));
        this.energyContainer = new EnergyContainerList(energyContainer);
    }
    @NotNull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("               ", "      CCC      ", "      C C      ", "      C C      ", "      C C      ", "      C C      ", "      C C      ", "      CCC      ", "               ")
                .aisle("      C C      ", "     FFFFF     ", "               ", "               ", "               ", "               ", "               ", "     FFFFF     ", "      C C      ")
                .aisle("      C C      ", "   FF     FF   ", "               ", "               ", "               ", "               ", "               ", "   FF     FF   ", "      C C      ")
                .aisle("      C C      ", "  F         F  ", "     FFFFF     ", "               ", "               ", "               ", "     FFFFF     ", "  F         F  ", "      C C      ")
                .aisle("      C C      ", "  F         F  ", "    F XXX F    ", "      XXX      ", "      XXX      ", "      XXX      ", "    F XXX F    ", "  F         F  ", "      C C      ")
                .aisle("      C C      ", " F           F ", "   F X   X F   ", "     X   X     ", "     X   X     ", "     X   X     ", "   F X   X F   ", " F           F ", "      C C      ")
                .aisle(" CCCCCCMCCCCCC ", "CF    XXX    FC", "C  FX     XF  C", "C   X     X   C", "C   X     X   C", "C   X     X   C", "C  FX     XF  C", "CF    XXX    FC", " CCCCCCMCCCCCC ")
                .aisle("      MMM      ", "CF    XXX    FC", "   FX     XF   ", "    X     X    ", "    X     X    ", "    X     X    ", "   FX     XF   ", "CF    XXX    FC", "      MMM      ")
                .aisle(" CCCCCCMCCCCCC ", "CF    XXX    FC", "C  FX     XF  C", "C   X     X   C", "C   X     X   C", "C   X     X   C", "C  FX     XF  C", "CF    XXX    FC", " CCCCCCMCCCCCC ")
                .aisle("      C C      ", " F           F ", "   F X   X F   ", "     X   X     ", "     X   X     ", "     X   X     ", "   F X   X F   ", " F           F ", "      C C      ")
                .aisle("      C C      ", "  F         F  ", "    F XXX F    ", "      XXX      ", "      XXX      ", "      XXX      ", "    F XXX F    ", "  F         F  ", "      C C      ")
                .aisle("      C C      ", "  F         F  ", "     FFFFF     ", "               ", "               ", "               ", "     FFFFF     ", "  F         F  ", "      C C      ")
                .aisle("      C C      ", "   FF     FF   ", "               ", "               ", "               ", "               ", "               ", "   FF     FF   ", "      C C      ")
                .aisle("      C C      ", "     FFFFF     ", "               ", "               ", "               ", "               ", "               ", "     FFFFF     ", "      C C      ")
                .aisle("               ", "      CSC      ", "      C C      ", "      C C      ", "      C C      ", "      C C      ", "      C C      ", "      CCC      ", "               ")
                .where('S', this.selfPredicate())
                .where('C', states(getCasingState())
                        .setMinGlobalLimited(140)
                        .or(abilities(MultiblockAbility.INPUT_LASER).setMaxGlobalLimited(1))
                        .or(autoAbilities()))
                .where('X', states(getSecondCasingState()))
                .where('F', states(getCoilState()))
                .where('M', states(getFrameState()))
                .build();
    }

    private static IBlockState getCasingState() {
        return GTLiteMetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.TRITANIUM_CASING);
    }

    private static IBlockState getSecondCasingState() {
        return GTLiteMetaBlocks.UNIQUE_CASING.getState(BlockUniqueCasing.UniqueCasingType.STELLAR_CONTAINMENT_CASING);
    }

    private static IBlockState getCoilState() {
        return GTLiteMetaBlocks.FUSION_CASING.getState(BlockFusionCasing.FusionCasingType.FUSION_COIL_MK4);
    }

    private static IBlockState getFrameState() {
        return MetaBlocks.FRAMES.get(Materials.Tritanium).getBlock(Materials.Tritanium);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GTLiteTextures.TRITANIUM_CASING;
    }

    @SideOnly(Side.CLIENT)
    @NotNull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return GTLiteTextures.STELLAR_FURNACE_OVERLAY;
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World player,
                               @NotNull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(TooltipHelper.BLINKING_RED + I18n.format("gtlitecore.machine.stellar_furnace.tooltip.1"));
        tooltip.add(I18n.format("gtlitecore.machine.stellar_furnace.tooltip.2"));
        tooltip.add(I18n.format("gtlitecore.machine.stellar_furnace.tooltip.3"));
        tooltip.add(I18n.format("gtlitecore.machine.stellar_furnace.tooltip.4"));
        tooltip.add(I18n.format("gtlitecore.machine.stellar_furnace.tooltip.5"));
        tooltip.add(I18n.format("gtlitecore.universal.tooltip.laser_input"));
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }
}
