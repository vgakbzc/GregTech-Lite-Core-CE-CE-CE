package magicbook.gtlitecore.common.metatileentities.multi.electric;

import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import codechicken.lib.vec.Vector3;
import gregtech.api.capability.GregtechDataCodes;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiMapMultiblockController;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.util.GTUtility;
import gregtech.api.util.RelativeDirection;
import gregtech.client.particle.GTLaserBeamParticle;
import gregtech.client.particle.GTParticleManager;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.common.ConfigHolder;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.core.sound.GTSoundEvents;
import magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps;
import magicbook.gtlitecore.client.renderer.texture.GTLiteTextures;
import magicbook.gtlitecore.common.blocks.BlockActiveUniqueCasing;
import magicbook.gtlitecore.common.blocks.BlockStructureCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.IItemHandlerModifiable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.input.Keyboard;

import java.util.List;
import java.util.function.Function;

/**
 * Large Circuit Assembly Line
 *
 * @author Magic_Sweepy
 *
 * @since 2.8.7-beta
 */
public class MetaTileEntityLargeCircuitAssemblyLine extends MultiMapMultiblockController {

    private static final ResourceLocation LASER_LOCATION = GTUtility.gregtechId("textures/fx/laser/laser.png");
    private static final ResourceLocation LASER_HEAD_LOCATION = GTUtility.gregtechId("textures/fx/laser/laser_start.png");
    @SideOnly(Side.CLIENT)
    private GTLaserBeamParticle[][] beamParticles;
    private int beamCount;

    public MetaTileEntityLargeCircuitAssemblyLine(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, new RecipeMap[]{
                RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES,
                GTLiteRecipeMaps.LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES});
        this.recipeMapWorkable = new LargeCircuitAssemblyLineRecipeLogic(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityLargeCircuitAssemblyLine(metaTileEntityId);
    }

    @NotNull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start(RelativeDirection.FRONT, RelativeDirection.UP, RelativeDirection.RIGHT)
                .aisle("FIF", "RTR", "SYG")
                .aisle("FIF", "RTR", "GYG")
                .setRepeatable(3, 15)
                .aisle("FOF", "RTR", "GYG")
                .where('S', this.selfPredicate())
                .where('F', states(getCasingState())
                        .or(abilities(MultiblockAbility.MAINTENANCE_HATCH)
                                .setExactLimit(1))
                        .or(abilities(MultiblockAbility.IMPORT_FLUIDS)
                                .setMaxGlobalLimited(4)
                                .setPreviewCount(1)))
                .where('O', abilities(MultiblockAbility.EXPORT_ITEMS)
                        .setExactLimit(1)
                        .addTooltips("gregtech.multiblock.pattern.location_end"))
                .where('Y', states(getSecondCasingState())
                        .or(abilities(MultiblockAbility.INPUT_ENERGY)
                                .setMinGlobalLimited(1)
                                .setMaxGlobalLimited(3)))
                .where('I', abilities(MultiblockAbility.IMPORT_ITEMS))
                .where('G', states(getSecondCasingState()))
                .where('R', states(getGlassState()))
                .where('T', states(getThirdCasingState()))
                .where(' ', any())
                .build();
    }

    private static IBlockState getCasingState() {
        return GTLiteMetaBlocks.STRUCTURE_CASING.getState(BlockStructureCasing.StructureCasingType.OSMIRIDIUM_CASING);
    }

    private static IBlockState getSecondCasingState() {
        return GTLiteMetaBlocks.STRUCTURE_CASING.getState(BlockStructureCasing.StructureCasingType.ADVANCED_GRATE_CASING);
    }

    private static IBlockState getThirdCasingState() {
        return GTLiteMetaBlocks.ACTIVE_UNIQUE_CASING.getState(BlockActiveUniqueCasing.ActiveCasingType.CIRCUIT_ASSEMBLY_LINE_CASING);
    }

    private static IBlockState getGlassState() {
        return MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.FUSION_GLASS);
    }

    @Override
    protected Function<BlockPos, Integer> multiblockPartSorter() {
        return RelativeDirection.LEFT.getSorter(this.getFrontFacing(), this.getUpwardsFacing(), this.isFlipped());
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return iMultiblockPart == null && isStructureFormed() ? GTLiteTextures.ADVANCED_GRATE_OSMIRIDIUM_FRONT : GTLiteTextures.OSMIRIDIUM_CASING;
    }

    @Override
    public void renderMetaTileEntity(CCRenderState renderState,
                                     Matrix4 translation,
                                     IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        this.getFrontOverlay().renderOrientedState(renderState, translation, pipeline, this.getFrontFacing(), this.recipeMapWorkable.isActive(), this.recipeMapWorkable.isWorkingEnabled());
    }

    @Override
    public SoundEvent getBreakdownSound() {
        return GTSoundEvents.BREAKDOWN_MECHANICAL;
    }

    @Override
    public void update() {
        super.update();
        if (ConfigHolder.client.shader.assemblyLineParticles) {
            if (this.getRecipeMapWorkable().isWorking()) {
                int maxBeams = this.getAbilities(MultiblockAbility.IMPORT_ITEMS).size() + 1;
                int maxProgress = this.getRecipeMapWorkable().getMaxProgress();
                int beamTime = Math.max(1, maxProgress / maxBeams);
                int currentBeamCount = Math.min(maxBeams, this.getRecipeMapWorkable().getProgress() / beamTime);
                if (currentBeamCount != this.beamCount) {
                    this.beamCount = currentBeamCount;
                    this.writeCustomData(GregtechDataCodes.UPDATE_PARTICLE, this::writeParticles);
                }
            } else if (this.beamCount != 0) {
                this.beamCount = 0;
                this.writeCustomData(GregtechDataCodes.UPDATE_PARTICLE, this::writeParticles);
            }
        }
    }

    @Override
    public void writeInitialSyncData(PacketBuffer buf) {
        super.writeInitialSyncData(buf);
        this.writeParticles(buf);
    }

    @Override
    public void receiveInitialSyncData(PacketBuffer buf) {
        super.receiveInitialSyncData(buf);
        this.readParticles(buf);
    }

    @Override
    public void receiveCustomData(int dataId, PacketBuffer buf) {
        if (dataId == GregtechDataCodes.UPDATE_PARTICLE) {
            this.readParticles(buf);
        } else {
            super.receiveCustomData(dataId, buf);
        }
    }

    @Override
    public void onRemoval() {
        super.onRemoval();
        if (this.getWorld().isRemote && this.beamParticles != null) {
            GTLaserBeamParticle[][] var1 = this.beamParticles;
            int var2 = var1.length;

            for (int var3 = 0; var3 < var2; ++var3) {
                GTLaserBeamParticle[] particle = var1[var3];
                if (particle[0] != null) {
                    particle[0].setExpired();
                    particle[1].setExpired();
                }
            }

            this.beamParticles = null;
        }

    }

    private void writeParticles(@NotNull PacketBuffer buf) {
        buf.writeVarInt(this.beamCount);
    }

    @SideOnly(Side.CLIENT)
    private void readParticles(@NotNull PacketBuffer buf) {
        this.beamCount = buf.readVarInt();
        if (this.beamParticles == null) {
            this.beamParticles = new GTLaserBeamParticle[17][2];
        }

        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(this.getPos());
        EnumFacing relativeUp = RelativeDirection.UP.getRelativeFacing(this.getFrontFacing(), this.getUpwardsFacing(), this.isFlipped());
        EnumFacing relativeLeft = RelativeDirection.LEFT.getRelativeFacing(this.getFrontFacing(), this.getUpwardsFacing(), this.isFlipped());
        boolean negativeUp = relativeUp.getAxisDirection() == EnumFacing.AxisDirection.NEGATIVE;

        for(int i = 0; i < this.beamParticles.length; ++i) {
            GTLaserBeamParticle particle = this.beamParticles[i][0];
            if (i < this.beamCount && particle == null) {
                pos.setPos(this.getPos());
                if (negativeUp) {
                    pos.move(relativeUp.getOpposite());
                }

                Vector3 startPos = (new Vector3()).add(pos.move(relativeLeft, i)).add(relativeUp.getAxis() == EnumFacing.Axis.X ? 0.0 : 0.5, relativeUp.getAxis() == EnumFacing.Axis.Y ? 0.0 : 0.5, relativeUp.getAxis() == EnumFacing.Axis.Z ? 0.0 : 0.5);
                Vector3 endPos = startPos.copy().subtract(relativeUp.getXOffset(), relativeUp.getYOffset(), relativeUp.getZOffset());
                this.beamParticles[i][0] = this.createALParticles(startPos, endPos);
                pos.setPos(this.getPos());
                if (negativeUp) {
                    pos.move(relativeUp.getOpposite());
                }

                startPos = (new Vector3()).add(pos.move(relativeLeft, i).move(this.getFrontFacing().getOpposite(), 2)).add(relativeUp.getAxis() == EnumFacing.Axis.X ? 0.0 : 0.5, relativeUp.getAxis() == EnumFacing.Axis.Y ? 0.0 : 0.5, relativeUp.getAxis() == EnumFacing.Axis.Z ? 0.0 : 0.5);
                endPos = startPos.copy().subtract(relativeUp.getXOffset(), relativeUp.getYOffset(), relativeUp.getZOffset());
                this.beamParticles[i][1] = this.createALParticles(startPos, endPos);
                GTParticleManager.INSTANCE.addEffect(this.beamParticles[i][0]);
                GTParticleManager.INSTANCE.addEffect(this.beamParticles[i][1]);
            } else if (i >= this.beamCount && particle != null) {
                particle.setExpired();
                this.beamParticles[i][0] = null;
                this.beamParticles[i][1].setExpired();
                this.beamParticles[i][1] = null;
            }
        }
    }

    @SideOnly(Side.CLIENT)
    private @NotNull GTLaserBeamParticle createALParticles(Vector3 startPos, Vector3 endPos) {
        return (new GTLaserBeamParticle(this, startPos, endPos)).setBody(LASER_LOCATION).setBeamHeight(0.125F).setDoubleVertical(true).setHead(LASER_HEAD_LOCATION).setHeadWidth(0.1F).setEmit(0.2F);
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World world,
                               @NotNull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, world, tooltip, advanced);
        tooltip.add(I18n.format("gtlitecore.machine.large_circuit_assembly_line.tooltip.1"));
        tooltip.add(I18n.format("gtlitecore.machine.large_circuit_assembly_line.tooltip.2"));
        tooltip.add(I18n.format("gtlitecore.machine.large_circuit_assembly_line.tooltip.3"));
        tooltip.add(I18n.format("gtlitecore.machine.large_circuit_assembly_line.tooltip.4"));
        tooltip.add(I18n.format("gtlitecore.machine.large_circuit_assembly_line.tooltip.5"));
        tooltip.add(I18n.format("gtlitecore.machine.large_circuit_assembly_line.tooltip.6"));
        tooltip.add(I18n.format("gtlitecore.machine.large_circuit_assembly_line.tooltip.7"));
        tooltip.add(I18n.format("gtlitecore.machine.large_circuit_assembly_line.tooltip.8"));
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
            tooltip.add(I18n.format("gtlitecore.machine.large_circuit_assembly_line.tooltip.shift.1"));
            tooltip.add(I18n.format("gtlitecore.machine.large_circuit_assembly_line.tooltip.shift.2"));
            tooltip.add(I18n.format("gtlitecore.machine.large_circuit_assembly_line.tooltip.shift.3"));
        } else {
            tooltip.add(I18n.format("gregtech.tooltip.hold_shift"));
        }
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }

    /**
     * This is an easy method to get layer of this machine, you do not need to catch current layer, just catch number of item import hatch.
     * @return Number (current) of item import bus in multiblock structure.
     */
    private int getInputInventorySize() {
        List<IItemHandlerModifiable> itemInputInventory = this.getAbilities(MultiblockAbility.IMPORT_ITEMS);
        return itemInputInventory.size();
    }

    private class LargeCircuitAssemblyLineRecipeLogic extends MultiblockRecipeLogic {

        public LargeCircuitAssemblyLineRecipeLogic(RecipeMapMultiblockController tileEntity) {
            super(tileEntity);
        }

        /**
         * @return Check if machine in Circuit Assembler mode.
         */
        private boolean isCircAssembler() {
            return this.getRecipeMap() == RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES;
        }

        /**
         * @return This parallel dependencies to Input inventory size, and if you do not build more layer, then return zero.
         */
        @Override
        public int getParallelLimit() {
            return (getInputInventorySize() - 4) * 4;
        }

        /**
         * @param maxProgress If machine in common circuit assembler, then get 1/2 progress time.
         */
        @Override
        public void setMaxProgress(int maxProgress) {
            if (isCircAssembler()) {
                this.maxProgressTime = maxProgress / 2;
            } else {
                this.maxProgressTime = maxProgress;
            }
        }
    }
}
