package magicbook.gtlitecore.common.metatileentities.multi.electric;

import gregicality.multiblocks.api.unification.GCYMMaterials;
import gregtech.api.capability.impl.ItemHandlerList;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.Widget;
import gregtech.api.gui.widgets.ClickButtonWidget;
import gregtech.api.gui.widgets.WidgetGroup;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.MultiblockDisplayText;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.*;
import gregtech.api.recipes.Recipe;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Materials;
import gregtech.api.util.GTUtility;
import gregtech.api.util.TextComponentUtil;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.utils.TooltipHelper;
import gregtech.common.blocks.*;
import gregtech.common.metatileentities.MetaTileEntities;
import magicbook.gtlitecore.api.pattern.GTLiteTraceabilityPredicate;
import magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps;
import magicbook.gtlitecore.api.recipe.builders.PCBFactoryRecipeBuilder;
import magicbook.gtlitecore.api.recipe.properties.PCBFactoryBioUpgradeProperty;
import magicbook.gtlitecore.api.recipe.properties.PCBFactoryProperty;
import magicbook.gtlitecore.api.unification.GTLiteMaterials;
import magicbook.gtlitecore.client.renderer.texture.GTLiteTextures;
import magicbook.gtlitecore.common.blocks.BlockPCBFactoryCasing;
import magicbook.gtlitecore.common.blocks.BlockStructureCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities;
import magicbook.gtlitecore.loaders.multiblock.PCBFactory;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.IItemHandlerModifiable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import static gregtech.api.GTValues.LuV;
import static gregtech.api.unification.material.Materials.Gold;
import static gregtech.api.unification.material.Materials.Silver;
import static magicbook.gtlitecore.api.pattern.GTLiteTraceabilityPredicate.optionalStates;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix.swarm;
import static magicbook.gtlitecore.api.utils.GTLiteUtility.clamp;

/**
 * PCB Factory
 *
 * @author Magic_Sweepy
 *
 * <p>
 *     This machine is a port of same name machine in GT5 Unofficial (by BlueWeabo),
 *     use my friend Gate Guardian's work {@link GTLiteTraceabilityPredicate#optionalStates(String, IBlockState...)}
 *     and related predicate. This machine use a special Recipe Map {@link GTLiteRecipeMaps#PCB_FACTORY_RECIPES},
 *     and has two properties: PCB Factory Tier ({@code tier}) and Bio Upgrade Tier ({@code isBioUpgrade}),
 *     now we just have one Bio Upgrade: Bio Chamber, so this properties is maybe too complex than its effect.
 * </p>
 *
 * @see PCBFactoryRecipeBuilder
 * @see PCBFactoryProperty
 * @see PCBFactoryBioUpgradeProperty
 * @see PCBFactory
 *
 * @since 2.8.8-beta
 */
public class MetaTileEntityPCBFactory extends RecipeMapMultiblockController {

    //  Upgrade Number
    private byte mainUpgradeNumber = 0;
    private byte bioUpgradeNumber = 0;
    private byte coolingUpgradeNumber = 0;

    //  Special Parameters (Default: 100μm, Range: 25μm-200μm)
    private int traceSize = 100;
    private final int minTraceSize = 25;
    private final int maxTraceSize = 200;

    //  Traceability Predicate Utility
    //  Used to check snow layer on block (for Multiblock Structure).
    private static final TraceabilityPredicate SNOW_LAYER = new TraceabilityPredicate(blockWorldState -> GTUtility.isBlockSnow(blockWorldState.getBlockState()));

    public MetaTileEntityPCBFactory(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GTLiteRecipeMaps.PCB_FACTORY_RECIPES);
        this.recipeMapWorkable = new PCBFactoryRecipeLogic(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityPCBFactory(metaTileEntityId);
    }

    /**
     * Structure Form checker of this machine.
     *
     * <p>
     *     This machine has a asynchronous upgrade system, which use 3 parameters to control it:
     *
     *     <ul>
     *         <li>{@link #mainUpgradeNumber} -> Main Structure tier (has 3 Upgrades).</li>
     *         <li>{@link #bioUpgradeNumber} -> Bio Upgrade tier (has 1 Upgrades).</li>
     *         <li>{@link #coolingUpgradeNumber} -> Cooling Upgrade tier (has 2 Upgrades).</li>
     *     </ul>
     *
     *     Some parameters are useful for {@link MultiblockRecipeLogic}, other used for check
     *     recipe requirements ({@link #bioUpgradeNumber}). If {@link #mainUpgradeNumber} bigger
     *     than 1, then player can get more parallel by Swarm amount of all Input Inventory.
     * </p>
     *
     * @param context  Pattern Text Matcher.
     */
    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        //  Main Structure T1
        this.mainUpgradeNumber +=1;
        //  Main Structure T2
        if (context.get("mainUpgradeT2") != null) {
            this.mainUpgradeNumber += 1;
        }
        //  Main Structure T3
        if (context.get("mainUpgradeT3") != null) {
            this.mainUpgradeNumber += 1;
        }
        //  Bio Upgrade
        if (context.get("bioUpgrade") != null) {
            this.bioUpgradeNumber += 1;
        }
        //  Cooling Upgrade T1 (Liquid Cooling Tower)
        if (context.get("coolingUpgradeT1") != null) {
            this.coolingUpgradeNumber += 1;
        }
        //  Cooling Upgrade T2 (Thermosink)
        if (context.get("coolingUpgradeT2") != null) {
            this.coolingUpgradeNumber += 1;
        }
    }

    /**
     * Default number of Parameters:
     *
     * <ul>
     *     <li>{@link #mainUpgradeNumber} -> 0;</li>
     *     <li>{@link #bioUpgradeNumber} -> 0;</li>
     *     <li>{@link #coolingUpgradeNumber} -> 0.</li>
     * </ul>
     */
    @Override
    public void invalidateStructure() {
        super.invalidateStructure();
        this.mainUpgradeNumber = 0;
        this.bioUpgradeNumber = 0;
        this.coolingUpgradeNumber = 0;
    }

    /**
     * Dependency of Parameters:
     *
     * <ul>
     *     <li>{@link #mainUpgradeNumber} -> Main tier of recipes.</li>
     *     <li>{@link #bioUpgradeNumber} -> Check if recipe needs Bio Chamber.</li>
     * </ul>
     *
     * @param recipe            All PCB Factory recipes.
     * @param consumeIfSuccess  Check if recipe can work.
     * @return                  If recipe required Main Tier smaller than {@link #mainUpgradeNumber},
     *                          and if recipe needs Bio Chamber Upgrade, then return {@code true}
     *                          when PCB Factory has this auxiliary structure exactly.
     */
    @Override
    public boolean checkRecipe(@NotNull Recipe recipe,
                               boolean consumeIfSuccess) {
        return super.checkRecipe(recipe, consumeIfSuccess)
                && recipe.getProperty(PCBFactoryProperty.getInstance(), 0) <= this.mainUpgradeNumber
                && recipe.getProperty(PCBFactoryBioUpgradeProperty.getInstance(), 0) <= this.bioUpgradeNumber;
    }

    /**
     * Structure Pattern of PCB Factory.
     *
     * @author BlueWeabo (original author)
     *
     * <p>
     *     In the original machine in GT5 Unofficial, some structure block is different,
     *     such as Damascus Steel frame, because in GTCEu, Damascus Steel does not have recipes,
     *     only way of obtaining Damascus Steel ingot is through vanilla treasure. All differents
     *     between PCB Factory in {@code gtlitecore} and GT5 Unofficial below:
     *
     *     <ul>
     *         <li>Main Structure (T1): {@code frameGtDamascusSteel} -> {@code frameGtHslaSteel};</li>
     *         <li>Main Structure (T2): {@code frameGtDuranium} -> {@code frameGtTungstenSteel};</li>
     *         <li>Liquid Cooling Tower (Cooling Upgrade T1): {@code frameGtDamascusSteel} -> {@code frameGtBlackSteel};</li>
     *         <li>Bio Chamber (Bio Upgrade): {@code frameGtDamascusSteel} -> {@code frameGtSiliconCarbide};</li>
     *         <li>Thermosink (Cooling Upgrade T2): {@code frameGtDamascusSteel} -> {@code frameGtNaquadah}.</li>
     *     </ul>
     * </p>
     *
     * @return  Total Structure of PCB Factory.
     */
    @NotNull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("              gHHHg  nTTTn       ", "              gPPPg  nQQQn       ", "              g   g  n   n       ", "              g   g  n   n       ", "              gJJJg  nRRRn       ", "              g   g  n   n       ", "              g   g  n   n       ", "              g   g  n   n       ", "              g   g  n   n       ", "              gIIIg  nTTTn       ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ")
                .aisle("              HHHHH  TTTTT       ", "              PIIIP  QOOOQ       ", "               III    OOO        ", "               III    OOO        ", "              JIIIJ  ROOOR       ", "               III    OOO        ", "               III    OOO        ", "               PPP    QQQ        ", "               III    TTT        ", "              I###I  T###T       ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ")
                .aisle("              HHHHH  TTTTT       ", "              PI*IP  QOUOQ       ", "               I#I    OUO        ", "               I#I    OUO        ", "              JI#IJ  ROUOR       ", "               I#I    OUO        ", "               I#I    OUO        ", "               P#P    QUQ        ", "               I#I    TUT        ", "              I###I  T###T       ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ")
                .aisle(" KKKKK        HHHHH  TTTTT       ", "              PIIIP  QOOOQ       ", "               III    OOO        ", "               III    OOO        ", "              JIIIJ  ROOOR       ", "               III    OOO        ", "               III    OOO        ", "               PPP    QQQ        ", "               III    TTT        ", "              I###I  T###T       ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ")
                .aisle("KKKKKKK       gHHHg  nTTTn       ", "  KKK         gPPPg  nQQQn       ", "  KKK         g   g  n   n       ", "  KKK         g   g  n   n       ", "  KKK         gJJJg  nRRRn       ", "  KKK         g   g  n   n       ", "  KKK         g   g  n   n       ", "  KKK         g   g  n   n       ", "  KKK         g   g  n   n       ", "  KKK         gIIIg  nTTTn       ", "  KKK                            ", "  KKK                            ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ")
                .aisle("KKKKKKK                          ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", "  LLL                            ", "  LLL                            ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ")
                .aisle("KKKKKKK                          ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", "  L#L                            ", " K###K                           ", "  L#L                            ", "  L#L                            ", "  LKL                            ", "  LKL                            ", "   K                             ", "   K                             ", "   K                             ", "   K                             ", "   K                             ", "                                 ")
                .aisle("KKKKKKK  fEEf                    ", " K###K   fEEf                    ", " K###K   fEEf                    ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", "  L#L                            ", " K###K                           ", "  L#L                            ", "  L#L                            ", "  L#L                            ", "  L#L                            ", "  L#L                            ", "  L#L                            ", "  L#L                            ", "  L#L                            ", "   K                             ", "   K                             ")
                .aisle("KKKKKKK  EEEE                    ", " K###K   E##E                    ", " K###K   E##E                    ", " K###K   fEEf                    ", " K###K   fEEf                    ", " K###K                           ", "  L#L                            ", "  L#L                            ", "  L#L                            ", " K###K                           ", "  L#L                            ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", "  L#L                            ", "  L#L                            ", "   K                             ", "   K                             ")
                .aisle("KKKKKKK  EEEEFCCCCCF             ", " K###K   E##EFCCCCCF             ", " K###K   E##EFCCCCCF             ", " K###K   E##EFCCCCCF             ", " K###K   E##EF     F             ", " K###K   fEEf                    ", "  L#L                            ", "  L#L                            ", "  L#L                            ", " K###K                           ", "  L#L                            ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", "  L#L                            ", "  LKL                            ", "   K                             ", "                                 ")
                .aisle("KKKKKKK  EEEECcccccC hMMMh  hMMMh", " K###K   E##EC#####C hNNNh  hNNNh", " K###K   E##EC#####C hNNNh  hNNNh", " K###K   E##EC#####C hNNNh  hNNNh", " K###K   E##ECCCCCCC h   h  h   h", " K###K   EEEEF     F             ", "  LLL    fEEf                    ", "  LLL                            ", "  LLL                            ", " K###K                           ", " K###K                           ", " K###K                           ", " K#L#K                           ", " K#L#K                           ", " K#L#K                           ", " K###K                           ", " K###K                           ", " K###K                           ", "  LLL                            ", "  LLL                            ", "                                 ", "                                 ")
                .aisle("KKKKKKK  EEEECcccccC MMMMM  MMMMM", "  KKK    E##ED#XXX#D N###N  N###N", "  KKK    E##ED#####D N###N  N###N", "  KKK    E##EC#####C N###N  N###N", "  KKK    E##ECCCCCCC  MMM    MMM ", "  KKK    EEEEF     F             ", "         fEEf                    ", "                                 ", "                                 ", "  KKK                            ", "  KKK                            ", "  KKK                            ", "  K K                            ", "  K K                            ", "  K K                            ", "  KKK                            ", "  KKK                            ", "  KKK                            ", "                                 ", "                                 ", "                                 ", "                                 ")
                .aisle(" KKKKK   EEEECcccccC MMMMM  MMMMM", "         E##ED#XXX#D N###N  N###N", "         E##ED#####D N###N  N###N", "         E##EC#####C N###N  N###N", "         E##ECCCCCCC  MMM    MMM ", "         EEEEFFFFFFF   M      M  ", "         fEEf           MMMMMM   ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ")
                .aisle("         EEEECcccccC MMMMM  MMMMM", "         E##ED#XXX#D N###N  N###N", "         E##ED#####D N###N  N###N", "         E##EC#####C N###N  N###N", "         E##ECGGGGGC  MMM    MMM ", "         EEEEF     F             ", "         fEEf                    ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ")
                .aisle("         EEEECcccccC hMMMh  hMMMh", "         E##EC#####C hNNNh  hNNNh", "         E##EC#####C hNNNh  hNNNh", "         E##EC#####C hNNNh  hNNNh", "         E##ECGGGGGC h   h  h   h", "         EEEEF     F             ", "         fEEf                    ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ")
                .aisle("         EEEEFCCSCCF             ", "         E##EFGGGGGF             ", "         E##EFGGGGGF             ", "         E##EFGGGGGF             ", "         E##EFFFFFFF             ", "         fEEf                    ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ")
                .aisle("         EEEE                    ", "         E##E                    ", "         E##E                    ", "         fEEf                    ", "         fEEf                    ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ")
                .aisle("         fEEf                    ", "         fEEf                    ", "         fEEf                    ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ")
                //  Controller
                .where('S', this.selfPredicate())
                //  Main Structure (T1)
                .where('C', states(getCasingState("T1StructureCasing")) // Basic Photolithographic Framework casing
                        .setMinGlobalLimited(40)
                        .or(this.autoAbilities())) // Energy hatch (1-3), Maintenance hatch, Item import/export hatch, Fluid import hatch
                .where('c', states(getSecondCasingState())) // Plascrete
                .where('D', states(getThirdCasingState("T1Grate")))  // Grate casing
                .where('F', states(getFrameState("T1Frame"))) // HSLA Steel frame
                .where('G', states(getGlassState("T1StructureGlass"))) // Laminated glass
                .where('X', states(getThirdCasingState("T1Substrate"))) // Substrate casing
                //  Main Structure (T2)
                .where('E', optionalStates("mainUpgradeT2", getCasingState("T2StructureCasing"))) // Mold Printing Assembly Framework casing
                .where('f', optionalStates("mainUpgradeT2", getFrameState("T2Frame"))) // Tungsten Steel Frame
                //  Liquid Cooling Tower (Cooling Upgrade T1)
                .where('H', optionalStates("coolingUpgradeT1", getCasingState("T2StructureCasing"))) // Mold Printing Assembly Framework casing
                .where('I', optionalStates("coolingUpgradeT1", getCasingState("NaquadahAlloyCasing"))) // Naquadah Alloy casing
                .where('J', optionalStates("coolingUpgradeT1", getThirdCasingState("CoolingTowerIntake"))) // Extreme Intake casing
                .where('P', optionalStates("coolingUpgradeT1", getBoilerCasingState())) // Tungsten Steel Pipe casing
                .where('g', optionalStates("coolingUpgradeT1", getFrameState("CoolingTowerFrame"))) // Black Steel Frame
                //  Main Structure (T3)
                .where('K', optionalStates("mainUpgradeT3", getCasingState("T3StructureCasing"))) // Radiation Proof Scan Framework casing
                .where('L', optionalStates("mainUpgradeT3", getCasingState("NaquadahAlloyCasing"))) // Naquadah Alloy casing
                //  Bio Chamber (Bio Upgrade)
                .where('M', optionalStates("bioUpgrade", getCasingState("BioChamberCasing"))) // Biological Sterile Machine casing
                .where('h', optionalStates("bioUpgrade", getFrameState("BioChamberFrame"))) // Silicon Carbide frame
                .where('N', optionalStates("bioUpgrade", getGlassState("BioChamberGlass"))) // Cleanroom glass
                //  Thermosink (Cooling Upgrade T2)
                .where('O', optionalStates("coolingUpgradeT2", getCasingState("ThermosinkCasing"))) // Infinity Cooled Machine casing
                .where('Q', optionalStates("coolingUpgradeT2", getBoilerCasingState())) // Tungsten Steel Pipe casing
                .where('R', optionalStates("coolingUpgradeT2", getThirdCasingState("CoolingTowerIntake"))) // Extreme Intake casing
                .where('T', optionalStates("coolingUpgradeT2", getCasingState("T2StructureCasing"))) // Mold Printing Assembly Framework casing
                .where('U', optionalStates("coolingUpgradeT2", getCoilState())) // Superconductor Coil block
                .where('n', optionalStates("coolingUpgradeT2", getFrameState("ThermosinkFrame"))) // Naquadah frame
                //  Other Miscs
                .where('#', air())
                .where('*', air()
                        .or(SNOW_LAYER))
                .where(' ', any())
                .build();
    }

    /**
     * Casing State Getter.
     *
     * <p>
     *     Getter for Multiblock Structure:
     *
     *     <ul>
     *         <li>{@code T1StructureCasing} -> Basic Photolithographic Framework Casing (Main Structure T1);</li>
     *         <li>{@code T2StructureCasing} -> Mold Printing Assembly Framework Casing (Main Structure T2, Cooling Upgrade T1, T2);</li>
     *         <li>{@code T3StructureCasing} -> Radiation Proof Scan Framework Casing (Main Structure T3);</li>
     *         <li>{@code NaquadahAlloyCasing} -> Naquadah Alloy Casing (Main Structure T3, Cooling Upgrade T1);</li>
     *         <li>{@code BioChamberCasing} -> Biological Sterile Machine Casing (Bio Upgrade).</li>
     *     </ul>
     * </p>
     *
     * @param type  Type of Block State.
     * @return      Block State for Getter.
     */
    private static IBlockState getCasingState(String type) {
        return switch (type) {
            case "T1StructureCasing" ->
                    GTLiteMetaBlocks.PCB_FACTORY_CASING.getState(BlockPCBFactoryCasing.PCBFactoryCasingType.BASIC_PHOTOLITHOGRAPHIC_FRAMEWORK_CASING);
            case "T2StructureCasing" ->
                    GTLiteMetaBlocks.PCB_FACTORY_CASING.getState(BlockPCBFactoryCasing.PCBFactoryCasingType.MOLD_PRINTING_ASSEMBLY_FRAMEWORK_CASING);
            case "T3StructureCasing" ->
                    GTLiteMetaBlocks.PCB_FACTORY_CASING.getState(BlockPCBFactoryCasing.PCBFactoryCasingType.RADIATION_PROOF_SCAN_FRAMEWORK_CASING);
            case "NaquadahAlloyCasing" ->
                    GTLiteMetaBlocks.STRUCTURE_CASING.getState(BlockStructureCasing.StructureCasingType.NAQUADAH_ALLOY_CASING);
            case "BioChamberCasing" ->
                    GTLiteMetaBlocks.PCB_FACTORY_CASING.getState(BlockPCBFactoryCasing.PCBFactoryCasingType.BIOLOGICAL_STERILE_MACHINE_CASING);
            case "ThermosinkCasing" ->
                    GTLiteMetaBlocks.PCB_FACTORY_CASING.getState(BlockPCBFactoryCasing.PCBFactoryCasingType.INFINITY_COOLED_MACHINE_CASING);
            default -> null;
        };
    }

    private static IBlockState getSecondCasingState() {
        return MetaBlocks.CLEANROOM_CASING.getState(BlockCleanroomCasing.CasingType.PLASCRETE);
    }

    /**
     * Casing State Getter.
     *
     * <p>
     *     Getter for Multiblock Structure:
     *
     *     <ul>
     *         <li>{@code T1Grate} -> Grate Casing (Main Structure T1);</li>
     *         <li>{@code T1Substrate} -> Substrate Casing (Main Structure T2);</li>
     *         <li>{@code CoolingTowerIntake} -> Extreme Engine Intake Casing (Cooling Upgrade T1, T2);</li>
     *     </ul>
     *
     *     In GT5 Unofficial block corresponded {@code T1Substrate} is {@code frameGtVibrantAlloy},
     *     but in {@code gtlitecore}, we have this special multiblock casing ^^.
     * </p>
     *
     * @param type  Type of Block State.
     * @return      Block State for Getter.
     */
    private static IBlockState getThirdCasingState(String type) {
        return switch (type) {
            case "T1Grate" ->
                    MetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.GRATE_CASING);
            case "T1Substrate" ->
                    GTLiteMetaBlocks.MULTIBLOCK_CASING.getState(magicbook.gtlitecore.common.blocks.BlockMultiblockCasing.MultiblockCasingType.SUBSTRATE_CASING);
            case "CoolingTowerIntake" ->
                    MetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.EXTREME_ENGINE_INTAKE_CASING);
            default -> null;
        };
    }

    private static IBlockState getBoilerCasingState() {
        return MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.TUNGSTENSTEEL_PIPE);
    }

    private static IBlockState getCoilState() {
        return MetaBlocks.FUSION_CASING.getState(BlockFusionCasing.CasingType.SUPERCONDUCTOR_COIL);
    }

    /**
     * Frame State Getter.
     *
     * <p>
     *     Getter for Multiblock Structure:
     *
     *     <ul>
     *         <li>{@code T1Frame} -> {@code frameGtHslaSteel} (Main Structure T1);</li>
     *         <li>{@code T2Frame} -> {@code frameGtTungstenSteel} (Main Structure T2);</li>
     *         <li>{@code CoolingTowerFrame} -> {@code frameGtBlackSteel} (Cooling Upgrade T1);</li>
     *         <li>{@code BioChamberFrame} -> {@code frameGtSiliconCarbide} (Bio Upgrade);</li>
     *         <li>{@code ThermosinkFrame} -> {@code frameGtNaquadah} (Cooling Upgrade T2).</li>
     *     </ul>
     * </p>
     *
     * @param type  Type of Block State.
     * @return      Block State for Getter.
     */
    private static IBlockState getFrameState(String type) {
        return switch (type) {
            case "T1Frame" ->
                    MetaBlocks.FRAMES.get(GCYMMaterials.HSLASteel).getBlock(GCYMMaterials.HSLASteel);
            case "T2Frame" ->
                    MetaBlocks.FRAMES.get(Materials.TungstenSteel).getBlock(Materials.TungstenSteel);
            case "CoolingTowerFrame" ->
                    MetaBlocks.FRAMES.get(Materials.BlackSteel).getBlock(Materials.BlackSteel);
            case "BioChamberFrame" ->
                    MetaBlocks.FRAMES.get(GTLiteMaterials.SiliconCarbide).getBlock(GTLiteMaterials.SiliconCarbide);
            case "ThermosinkFrame" ->
                    MetaBlocks.FRAMES.get(Materials.Naquadah).getBlock(Materials.Naquadah);
            default -> null;
        };
    }

    /**
     * Glass State Getter.
     *
     * <p>
     *     Getter for Multiblock Structure:
     *
     *     <ul>
     *         <li>{@code T1StructureGlass} -> Laminated Glass (Main Structure T1);</li>
     *         <li>{@code BioChamberGlass} -> Cleanroom Glass (Bio Upgrade).</li>
     *     </ul>
     * </p>
     *
     * @param type  Type of Block State.
     * @return      Block State for Getter.
     */
    private static IBlockState getGlassState(String type) {
        return switch (type) {
            case "T1StructureGlass"
                -> MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.LAMINATED_GLASS);
            case "BioChamberGlass"
                -> MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.CLEANROOM_GLASS);
            default -> null;
        };
    }

    /**
     * Flex Button of Trace size.
     *
     * <p>
     *     This method create two button about {@link #traceSize} (Unit: μm),
     *     this parameter control many things in {@link PCBFactoryRecipeLogic}.
     *     In this button, you can increment and decrement {@link #traceSize}
     *     in range {@link #minTraceSize} to {@link #maxTraceSize}.
     * </p>
     *
     * @return  Flex Button of Multiblock Controller GUI.
     */
    @NotNull
    @Override
    protected Widget getFlexButton(int x, int y, int width, int height) {
        WidgetGroup group = new WidgetGroup(x, y, width, height);
        group.addWidget(new ClickButtonWidget(0, 0, 9, 18, "", this::decrementTraceSize)
                .setButtonTexture(GuiTextures.BUTTON_THROTTLE_MINUS)
                .setTooltipText("gtlitecore.machine.pcb_factory.trace_size.decrement"));
        group.addWidget(new ClickButtonWidget(9, 0, 9, 18, "", this::incrementTraceSize)
                .setButtonTexture(GuiTextures.BUTTON_THROTTLE_PLUS)
                .setTooltipText("gtlitecore.machine.pcb_factory.trace_size.increment"));
        return group;
    }

    private void incrementTraceSize(Widget.ClickData clickData) {
        this.traceSize = clamp(traceSize - 25, minTraceSize, maxTraceSize);
    }

    private void decrementTraceSize(Widget.ClickData clickData) {
        this.traceSize = clamp(traceSize + 25, minTraceSize, maxTraceSize);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound data) {
        data.setInteger("TraceSize", traceSize);
        return super.writeToNBT(data);
    }

    @Override
    public void readFromNBT(NBTTagCompound data) {
        traceSize = data.getInteger("TraceSize");
        super.readFromNBT(data);
    }

    @Override
    public void writeInitialSyncData(PacketBuffer buf) {
        super.writeInitialSyncData(buf);
        buf.writeVarInt(traceSize);
    }

    @Override
    public void receiveInitialSyncData(PacketBuffer buf) {
        super.receiveInitialSyncData(buf);
        traceSize = buf.readVarInt();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GTLiteTextures.BASIC_PHOTOLITHOGRAPHIC_FRAMEWORK_CASING;
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
        assert Blocks.AIR != null;
        MultiblockShapeInfo.Builder builder = MultiblockShapeInfo.builder()
                    .aisle("              gHHHg  nTTTn       ", "              gPPPg  nQQQn       ", "              g   g  n   n       ", "              g   g  n   n       ", "              gJJJg  nRRRn       ", "              g   g  n   n       ", "              g   g  n   n       ", "              g   g  n   n       ", "              g   g  n   n       ", "              gIIIg  nTTTn       ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ")
                    .aisle("              HHHHH  TTTTT       ", "              PIIIP  QOOOQ       ", "               III    OOO        ", "               III    OOO        ", "              JIIIJ  ROOOR       ", "               III    OOO        ", "               III    OOO        ", "               PPP    QQQ        ", "               III    TTT        ", "              I###I  T###T       ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ")
                    .aisle("              HHHHH  TTTTT       ", "              PI*IP  QOUOQ       ", "               I#I    OUO        ", "               I#I    OUO        ", "              JI#IJ  ROUOR       ", "               I#I    OUO        ", "               I#I    OUO        ", "               P#P    QUQ        ", "               I#I    TUT        ", "              I###I  T###T       ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ")
                    .aisle(" KKKKK        HHHHH  TTTTT       ", "              PIIIP  QOOOQ       ", "               III    OOO        ", "               III    OOO        ", "              JIIIJ  ROOOR       ", "               III    OOO        ", "               III    OOO        ", "               PPP    QQQ        ", "               III    TTT        ", "              I###I  T###T       ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ")
                    .aisle("KKKKKKK       gHHHg  nTTTn       ", "  KKK         gPPPg  nQQQn       ", "  KKK         g   g  n   n       ", "  KKK         g   g  n   n       ", "  KKK         gJJJg  nRRRn       ", "  KKK         g   g  n   n       ", "  KKK         g   g  n   n       ", "  KKK         g   g  n   n       ", "  KKK         g   g  n   n       ", "  KKK         gIIIg  nTTTn       ", "  KKK                            ", "  KKK                            ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ")
                    .aisle("KKKKKKK                          ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", "  LLL                            ", "  LLL                            ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ")
                    .aisle("KKKKKKK                          ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", "  L#L                            ", " K###K                           ", "  L#L                            ", "  L#L                            ", "  LKL                            ", "  LKL                            ", "   K                             ", "   K                             ", "   K                             ", "   K                             ", "   K                             ", "                                 ")
                    .aisle("KKKKKKK  fEEf                    ", " K###K   fEEf                    ", " K###K   fEEf                    ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", "  L#L                            ", " K###K                           ", "  L#L                            ", "  L#L                            ", "  L#L                            ", "  L#L                            ", "  L#L                            ", "  L#L                            ", "  L#L                            ", "  L#L                            ", "   K                             ", "   K                             ")
                    .aisle("KKKKKKK  EEEE                    ", " K###K   E##E                    ", " K###K   E##E                    ", " K###K   fEEf                    ", " K###K   fEEf                    ", " K###K                           ", "  L#L                            ", "  L#L                            ", "  L#L                            ", " K###K                           ", "  L#L                            ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", "  L#L                            ", "  L#L                            ", "   K                             ", "   K                             ")
                    .aisle("KKKKKKK  EEEEFCCCeeF             ", " K###K   E##EFCCCCCF             ", " K###K   E##EFCCCCCF             ", " K###K   E##EFCCCCCF             ", " K###K   E##EF     F             ", " K###K   fEEf                    ", "  L#L                            ", "  L#L                            ", "  L#L                            ", " K###K                           ", "  L#L                            ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", " K###K                           ", "  L#L                            ", "  LKL                            ", "   K                             ", "                                 ")
                    .aisle("KKKKKKK  EEEECcccccC hMMMh  hMMMh", " K###K   E##EC#####C hNNNh  hNNNh", " K###K   E##EC#####C hNNNh  hNNNh", " K###K   E##EC#####C hNNNh  hNNNh", " K###K   E##ECCCCCCC h   h  h   h", " K###K   EEEEF     F             ", "  LLL    fEEf                    ", "  LLL                            ", "  LLL                            ", " K###K                           ", " K###K                           ", " K###K                           ", " K#L#K                           ", " K#L#K                           ", " K#L#K                           ", " K###K                           ", " K###K                           ", " K###K                           ", "  LLL                            ", "  LLL                            ", "                                 ", "                                 ")
                    .aisle("KKKKKKK  EEEECcccccC MMMMM  MMMMM", "  KKK    E##ED#XXX#D N###N  N###N", "  KKK    E##ED#####D N###N  N###N", "  KKK    E##EC#####C N###N  N###N", "  KKK    E##ECCCCCCC  MMM    MMM ", "  KKK    EEEEF     F             ", "         fEEf                    ", "                                 ", "                                 ", "  KKK                            ", "  KKK                            ", "  KKK                            ", "  K K                            ", "  K K                            ", "  K K                            ", "  KKK                            ", "  KKK                            ", "  KKK                            ", "                                 ", "                                 ", "                                 ", "                                 ")
                    .aisle(" KKKKK   EEEECcccccC MMMMM  MMMMM", "         E##ED#XXX#D N###N  N###N", "         E##ED#####D N###N  N###N", "         E##EC#####C N###N  N###N", "         E##ECCCCCCC  MMM    MMM ", "         EEEEFFFFFFF   M      M  ", "         fEEf           MMMMMM   ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ")
                    .aisle("         EEEECcccccC MMMMM  MMMMM", "         E##ED#XXX#D N###N  N###N", "         E##ED#####D N###N  N###N", "         E##EC#####C N###N  N###N", "         E##ECGGGGGC  MMM    MMM ", "         EEEEF     F             ", "         fEEf                    ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ")
                    .aisle("         EEEECcccccC hMMMh  hMMMh", "         E##EC#####C hNNNh  hNNNh", "         E##EC#####C hNNNh  hNNNh", "         E##EC#####C hNNNh  hNNNh", "         E##ECGGGGGC h   h  h   h", "         EEEEF     F             ", "         fEEf                    ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ")
                    .aisle("         EEEEFijSmkF             ", "         E##EFGGGGGF             ", "         E##EFGGGGGF             ", "         E##EFGGGGGF             ", "         E##EFFFFFFF             ", "         fEEf                    ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ")
                    .aisle("         EEEE                    ", "         E##E                    ", "         E##E                    ", "         fEEf                    ", "         fEEf                    ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ")
                    .aisle("         fEEf                    ", "         fEEf                    ", "         fEEf                    ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ", "                                 ")
                    .where('S', GTLiteMetaTileEntities.PCB_FACTORY, EnumFacing.SOUTH)
                    .where('C', getCasingState("T1StructureCasing")) // Basic Photolithographic Framework casing
                    .where('c', getSecondCasingState()) // Plascrete
                    .where('D', getThirdCasingState("T1Grate"))  // Grate casing
                    .where('F', getFrameState("T1Frame")) // HSLA Steel frame
                    .where('G', getGlassState("T1StructureGlass")) // Laminated glass
                    .where('X', getThirdCasingState("T1Substrate")) // Substrate casing
                    .where('i', MetaTileEntities.ITEM_IMPORT_BUS_ME, EnumFacing.SOUTH)
                    .where('j', MetaTileEntities.ITEM_EXPORT_BUS_ME, EnumFacing.SOUTH)
                    .where('k', MetaTileEntities.FLUID_IMPORT_HATCH_ME, EnumFacing.SOUTH)
                    .where('m', MetaTileEntities.AUTO_MAINTENANCE_HATCH, EnumFacing.SOUTH)
                    .where('e', MetaTileEntities.ENERGY_INPUT_HATCH[LuV], EnumFacing.NORTH)
                    .where('#', Blocks.AIR.getDefaultState())
                    .where('*', Blocks.AIR.getDefaultState())
                    .where(' ', Blocks.AIR.getDefaultState());
            shapeInfo.add(builder.build());
            //  Main Structure (T2)
            shapeInfo.add(builder
                    .where('E', getCasingState("T2StructureCasing")) // Mold Printing Assembly Framework casing
                    .where('f', getFrameState("T2Frame")) // Tungsten Steel Frame
                    .build());
            //  Liquid Cooling Tower (Cooling Upgrade T1)
            shapeInfo.add(builder
                    .where('H', getCasingState("T2StructureCasing")) // Mold Printing Assembly Framework casing
                    .where('I', getCasingState("NaquadahAlloyCasing")) // Naquadah Alloy casing
                    .where('J', getThirdCasingState("CoolingTowerIntake")) // Extreme Intake casing
                    .where('P', getBoilerCasingState()) // Tungsten Steel Pipe casing
                    .where('g', getFrameState("CoolingTowerFrame")) // Black Steel Frame
                    .build());
            //  Main Structure (T3)
            shapeInfo.add(builder
                    .where('K', getCasingState("T3StructureCasing")) // Radiation Proof Scan Framework casing
                    .where('L', getCasingState("NaquadahAlloyCasing")) // Naquadah Alloy casing
                    .build());
            //  Bio Chamber (Bio Upgrade)
            shapeInfo.add(builder
                    .where('M', getCasingState("BioChamberCasing")) // Biological Sterile Machine casing
                    .where('h', getFrameState("BioChamberFrame")) // Silicon Carbide frame
                    .where('N', getGlassState("BioChamberGlass")) // Cleanroom glass
                    .build());
            //  Thermosink (Cooling Upgrade T2)
            shapeInfo.add(builder
                    .where('O', getCasingState("ThermosinkCasing")) // Infinity Cooled Machine casing
                    .where('Q', getBoilerCasingState()) // Tungsten Steel Pipe casing
                    .where('R', getThirdCasingState("CoolingTowerIntake")) // Extreme Intake casing
                    .where('T', getCasingState("T2StructureCasing")) // Mold Printing Assembly Framework casing
                    .where('U', getCoilState()) // Superconductor Coil block
                    .where('n', getFrameState("ThermosinkFrame")) // Naquadah frame
                    .build());
        return shapeInfo;
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World player,
                               @NotNull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.1"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.2"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.3"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.4"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.5"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.6"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.7"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.8"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.9")
                + TooltipHelper.RAINBOW_SLOW + I18n.format("gtlitecore.machine.pcb_factory.tooltip.9.25")
                + TextFormatting.GRAY + I18n.format("gtlitecore.machine.pcb_factory.tooltip.9.5"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.10"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.11"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.12"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.13"));
        tooltip.add(I18n.format("gtlitecore.machine.pcb_factory.tooltip.14"));
    }

    @Override
    public String[] getDescription() {
        return new String[]{I18n.format("gtlitecore.machine.pcb_factory.description")};
    }

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        MultiblockDisplayText.builder(textList, this.isStructureFormed())
                .addCustom((tl) -> {
                    if (this.isStructureFormed()) {
                        tl.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "gtlitecore.machine.pcb_factory.structure.info", this.getMainUpgradeNumber(), this.getTraceSize()));
                        if (this.getCoolingUpgradeNumber() > 0) {
                            tl.add(TextComponentUtil.translationWithColor(TextFormatting.AQUA, "gtlitecore.machine.pcb_factory.structure.cooling_tower"));
                            if (this.getCoolingUpgradeNumber() == 2) {
                                tl.add(TextComponentUtil.translationWithColor(TextFormatting.BLUE, "gtlitecore.machine.pcb_factory.structure.thermosink"));
                            }
                        }
                        if (this.getBioUpgradeNumber() == 1)  {
                            tl.add(TextComponentUtil.translationWithColor(TextFormatting.GREEN, "gtlitecore.machine.pcb_factory.structure.bio_chamber"));
                        }
                    }
                })
                .setWorkingStatus(this.recipeMapWorkable.isWorkingEnabled(), this.recipeMapWorkable.isActive())
                .addEnergyUsageLine(this.recipeMapWorkable.getEnergyContainer())
                .addEnergyTierLine(GTUtility.getTierByVoltage(this.recipeMapWorkable.getMaxVoltage()))
                .addParallelsLine(this.recipeMapWorkable.getParallelLimit())
                .addWorkingStatusLine()
                .addProgressLine(this.recipeMapWorkable.getProgressPercent());
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }

    @Override
    protected boolean shouldShowVoidingModeButton() {
        return true;
    }

    public int getMainUpgradeNumber() {
        return this.mainUpgradeNumber;
    }

    public int getBioUpgradeNumber() {
        return this.bioUpgradeNumber;
    }

    public int getCoolingUpgradeNumber() {
        return this.coolingUpgradeNumber;
    }

    public int getTraceSize() {
        return this.traceSize;
    }

    private class PCBFactoryRecipeLogic extends MultiblockRecipeLogic {

        public PCBFactoryRecipeLogic(RecipeMapMultiblockController tileEntity) {
            super(tileEntity);
        }

        /**
         * Tweak OC effect of PCB Factory.
         *
         * <ul>
         *     <li>{@link #coolingUpgradeNumber = 0} -> No OC ({@code 1.0});</li>
         *     <li>{@link #coolingUpgradeNumber = 1} -> Common OC ({@code 2.0};</li>
         *     <li>{@link #coolingUpgradeNumber = 2} -> Perfect OC ({@code 4.0}.</li>
         * </ul>
         *
         * @return  Duration Divisor of OC Duration.
         */
        @Override
        protected double getOverclockingDurationDivisor() {
            return switch (coolingUpgradeNumber) {
                case 1 -> 2.0;
                case 2 -> 4.0;
                default -> 1.0;
            };
        }

        @Override
        public int getParallelLimit() {
            return this.calculateParallelBySwarm();
        }

        public int calculateParallelBySwarm() {
            List<IItemHandlerModifiable> itemInputInventory = getAbilities(MultiblockAbility.IMPORT_ITEMS);
            IItemHandlerModifiable itemInputs = new ItemHandlerList(itemInputInventory);
            int parallelBase = 0;
            for (int i = 0; i < itemInputs.getSlots(); i++) {
                parallelBase = itemInputs.getStackInSlot(i).getCount();
                if (mainUpgradeNumber == 2) {
                    if (itemInputs.getStackInSlot(i).isItemEqual(OreDictUnifier.get(swarm, Silver))) {
                        return parallelBase;
                    }
                }
                if (mainUpgradeNumber == 3) {
                    if (itemInputs.getStackInSlot(i).isItemEqual(OreDictUnifier.get(swarm, Gold))) {
                        return parallelBase * 2;
                    }
                }
            }
            return parallelBase;
        }

        /**
         * Check {@link #traceSize} and get related Progress time.
         *
         * <ul>
         *     <li>{@code 25μm} -> {@code 40% Progress time};</li>
         *     <li>{@code 50μm} -> {@code 60% Progress time};</li>
         *     <li>{@code 75μm} -> {@code 80% Progress time};</li>
         *     <li>{@code 100μm} -> {@code 100% Progress time} (Default);</li>
         *     <li>{@code 125μm} -> {@code 120% Progress time};</li>
         *     <li>{@code 150μm} -> {@code 140% Progress time};</li>
         *     <li>{@code 175μm} -> {@code 160% Progress time};</li>
         *     <li>{@code 200μm} -> {@code 180% Progress time}.</li>
         * </ul>
         *
         * @param maxProgress  Actually Progress time.
         */
        @Override
        public void setMaxProgress(int maxProgress) {
            this.maxProgressTime = switch (traceSize) {
                case 25 -> (int) Math.floor(0.4 * maxProgress);
                case 50 -> (int) Math.floor(0.6 * maxProgress);
                case 75 -> (int) Math.floor(0.8 * maxProgress);
                case 125 -> (int) Math.floor(1.2 * maxProgress);
                case 150 -> (int) Math.floor(1.4 * maxProgress);
                case 175 -> (int) Math.floor(1.6 * maxProgress);
                case 200 -> (int) Math.floor(1.8 * maxProgress);
                default -> maxProgress;
            };
        }

        /**
         * Get Eneryg Consumed by {@link #traceSize}.
         *
         * <ul>
         *     <li>{@code 25μm} -> {@code 250% Energy Consumed};</li>
         *     <li>{@code 50μm} -> {@code 200% Energy Consumed};</li>
         *     <li>{@code 75μm} -> {@code 150% Energy Consumed};</li>
         *     <li>{@code 100μm} -> {@code 100% Energy Consumed} (Default);</li>
         *     <li>{@code 125μm} -> {@code 90% Energy Consumed};</li>
         *     <li>{@code 150μm} -> {@code 80% Energy Consumed};</li>
         *     <li>{@code 175μm} -> {@code 70% Energy Consumed};</li>
         *     <li>{@code 200μm} -> {@code 60% Energy Consumed}.</li>
         * </ul>
         */
        @Override
        protected void updateRecipeProgress() {
            int actuallyEnergyConsumed = (int) (this.recipeEUt * switch (traceSize) {
                case 25 -> 2.5;
                case 50 -> 2;
                case 75 -> 1.5;
                case 125 -> 0.9;
                case 150 -> 0.8;
                case 175 -> 0.7;
                case 200 -> 0.6;
                default -> 1;
            });
            if (this.canRecipeProgress && this.drawEnergy(actuallyEnergyConsumed, true)) {
                this.drawEnergy(actuallyEnergyConsumed, false);
                if (++this.progressTime > this.maxProgressTime) {
                    this.completeRecipe();
                }
                if (this.hasNotEnoughEnergy && this.getEnergyInputPerSecond() > 19L * (long) actuallyEnergyConsumed) {
                    this.hasNotEnoughEnergy = false;
                }
            } else if (actuallyEnergyConsumed > 0) {
                this.hasNotEnoughEnergy = true;
                this.decreaseProgress();
            }
        }

    }

}