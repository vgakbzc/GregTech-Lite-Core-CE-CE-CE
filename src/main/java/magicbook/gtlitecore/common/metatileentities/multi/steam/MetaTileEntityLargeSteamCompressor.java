package magicbook.gtlitecore.common.metatileentities.multi.steam;

import gregtech.api.capability.impl.SteamMultiWorkable;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapSteamMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.recipes.RecipeMaps;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.client.utils.TooltipHelper;
import gregtech.common.ConfigHolder;
import gregtech.common.blocks.BlockBoilerCasing;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MetaTileEntityLargeSteamCompressor extends RecipeMapSteamMultiblockController {

    private static final int PARALLEL_LIMIT = 8;

    public MetaTileEntityLargeSteamCompressor(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, RecipeMaps.COMPRESSOR_RECIPES, CONVERSION_RATE);
        this.recipeMapWorkable = new SteamMultiWorkable(this, CONVERSION_RATE);
        this.recipeMapWorkable.setParallelLimit(PARALLEL_LIMIT);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityLargeSteamCompressor(metaTileEntityId);
    }

    @NotNull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("CCC", "CCC", "CCC")
                .aisle("CCC", "CPC", "CCC")
                .aisle("CCC", "CPC", "CCC")
                .aisle("CCC", "CSC", "CCC")
                .where('S', this.selfPredicate())
                .where('C', states(getCasingState())
                        .setMinGlobalLimited(27)
                        .or(this.autoAbilities()))
                .where('P', states(getBoilerCasingState()))
                .build();
    }

    private static IBlockState getCasingState() {
        return ConfigHolder.machines.steelSteamMultiblocks ? MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STEEL_SOLID) : MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.BRONZE_BRICKS);
    }

    private static IBlockState getBoilerCasingState() {
        return ConfigHolder.machines.steelSteamMultiblocks ? MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.STEEL_PIPE) : MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.BRONZE_PIPE);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
        return ConfigHolder.machines.steelSteamMultiblocks ? Textures.SOLID_STEEL_CASING : Textures.BRONZE_PLATED_BRICKS;
    }

    @SideOnly(Side.CLIENT)
    @NotNull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.COMPRESSOR_OVERLAY;
    }

    @Override
    public boolean hasMaintenanceMechanics() {
        return false;
    }

    @Override
    public int getItemOutputLimit() {
        return 1;
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World player,
                               @NotNull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gregtech.universal.tooltip.parallel", 8));
        tooltip.add(TooltipHelper.BLINKING_ORANGE + I18n.format("gregtech.multiblock.require_steam_parts", new Object[0]));
    }
}
