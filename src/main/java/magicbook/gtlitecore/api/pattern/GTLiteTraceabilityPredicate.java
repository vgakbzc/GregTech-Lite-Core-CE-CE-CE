package magicbook.gtlitecore.api.pattern;

import gregtech.api.block.VariantActiveBlock;
import gregtech.api.metatileentity.ITieredMetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockAbilityPart;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.PatternStringError;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.util.BlockInfo;
import gregtech.common.blocks.BlockFireboxCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.multi.electric.MetaTileEntityPowerSubstation;
import magicbook.gtlitecore.api.GTLiteAPI;
import magicbook.gtlitecore.api.block.impl.WrappedIntTier;
import magicbook.gtlitecore.api.metatileentity.multi.GTLiteMultiblockAbility;
import magicbook.gtlitecore.api.metatileentity.multi.IYottaTankData;
import magicbook.gtlitecore.api.pattern.predicates.TierTraceabilityPredicate;
import magicbook.gtlitecore.common.metatileentities.multi.electric.MetaTileEntityIndustrialRoaster;
import magicbook.gtlitecore.common.metatileentities.multi.part.MetaTileEntityReinforcedRotorHolder;
import magicbook.gtlitecore.common.metatileentities.multi.storage.MetaTileEntityYottaFluidTank;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.lang3.ArrayUtils;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static magicbook.gtlitecore.api.GTLiteAPI.*;
import static magicbook.gtlitecore.api.utils.GTLiteUtility.getCandidates;
import static magicbook.gtlitecore.api.utils.GTLiteUtility.getTileEntity;

/**
 * Traceability Predicate for gtlitecore
 *
 * @author Magic_Sweepy
 *
 * <p>
 *     Traceability Predicate class like {@link TraceabilityPredicate},
 *     used to load all traceability predicate for multiblocks.
 * </p>
 *
 * @since 2.8.7-beta
 */
public class GTLiteTraceabilityPredicate {

    /**
     * Firebox Casing Predicate.
     *
     * <p>
     *     This is a heating coil like predicate, used in {@link MetaTileEntityIndustrialRoaster}.
     *     Extended predicate related {@code temperature} parameter is init in {@code formStructure()},
     *     and each firebox (in {@link BlockFireboxCasing}) get a special temperature by oridinal.
     * </p>
     */
    public static Supplier<TraceabilityPredicate> FIRE_BOX = () -> new TraceabilityPredicate(blockWorldState -> {
        //  Block State Getter.
        IBlockState blockState = blockWorldState.getBlockState();
        //  Check if block is Firebox Casing in {@code BlockFireboxCasing} class.
        //  If you want to init Firebox Casings in other classes, then you should add it in this predicate.
        if ((blockState.getBlock() instanceof BlockFireboxCasing BlockFireboxCasing)) {
            //  Get Casing Type of Firebox Casing block.
            BlockFireboxCasing.FireboxCasingType casingType = BlockFireboxCasing.getState(blockState);
            Object currentCasingType = blockWorldState.getMatchContext().getOrPut("CasingType", casingType);
            //  Add error hint to Multiblock Structure Info view in JEI page.
            if (!currentCasingType.toString().equals(casingType.toString())) {
                blockWorldState.setError(new PatternStringError("gtlitecore.machine.pattern.firebox"));
                return false;
            }
            blockWorldState.getMatchContext().getOrPut("VABlock", new LinkedList<>()).add(blockWorldState.getPos());
            return true;
        }
        return false;
    }, () -> ArrayUtils.addAll(Arrays.stream(BlockFireboxCasing.FireboxCasingType.values())
            .map(type -> new BlockInfo(MetaBlocks.BOILER_FIREBOX_CASING.getState(type), null))
            .toArray(BlockInfo[]::new)))
            .addTooltips("gtlitecore.machine.pattern.firebox");

    /**
     * Firebox Casing Predicate Getter.
     *
     * @return  Get {@link #FIRE_BOX} predicate.
     */
    public static TraceabilityPredicate fireBoxes() {
        return FIRE_BOX.get();
    }

    /**
     * Yotta Fluid Tank Cell Predicate.
     *
     * <p>
     *     This is the basic predicate of Yotta Tank, please see: {@code BATTERY_PREDICATE},
     *     this predicate is another predicate in {@link MetaTileEntityPowerSubstation},
     *     but two predicates use same method. Yotta Tank Cells init in {@link GTLiteAPI}.
     * </p>
     *
     */
    public static final Supplier<TraceabilityPredicate> CELL_PREDICATE = () -> new TraceabilityPredicate(blockWorldState -> {
        IBlockState state = blockWorldState.getBlockState();
        if (MAP_YOT_TANK_CELL.containsKey(state)) {
            IYottaTankData cells = MAP_YOT_TANK_CELL.get(state);
            //  If Cell is not empty and Capacity is nonnull.
            if (cells.getTier() != -1 && cells.getCapacity() > 0) {
                //  Get Fluid Cell name, form like `YOTCell_T1`.
                String key = MetaTileEntityYottaFluidTank.YOT_CELL_HEADER + cells.getFluidCellName();
                //  Match Wrapper in MetaTileEntity class.
                MetaTileEntityYottaFluidTank.YOTTankMatchWrapper wrapper = blockWorldState.getMatchContext().get(key);
                //  If Match Wrapper is null, then create a new Match Wrapper.
                if (wrapper == null)
                    wrapper = new MetaTileEntityYottaFluidTank.YOTTankMatchWrapper(cells);
                blockWorldState.getMatchContext().set(key, wrapper.increment());
            }
            return true;
        }
        return false;
    }, () -> MAP_YOT_TANK_CELL.entrySet().stream()
            .sorted(Comparator.comparingInt(entry -> entry.getValue().getTier()))
            .map(entry -> new BlockInfo(entry.getKey(), null))
            .toArray(BlockInfo[]::new))
            .addTooltips("gtlitecore.machine.yotta_fluid_tank.error.cells");

    /**
     * Fluid Cell Predicate Getter.
     *
     * @return  Get {@link #CELL_PREDICATE} predicate.
     */
    public static TraceabilityPredicate fluidCells() {
        return CELL_PREDICATE.get();
    }

    /**
     * (Reinforced) Rotor Holder Predicate.
     *
     * <p>
     *     Just a rotor holder predicate rewrite for {@link MetaTileEntityReinforcedRotorHolder}.
     * </p>
     */
    public static Supplier<TraceabilityPredicate> ROTOR_HOLDER = () -> new TraceabilityPredicate(blockWorldState -> {
        TileEntity tileEntity = blockWorldState.getTileEntity();
        //  Check if TileEntity is GregTech TileEntity (all GregTech MetaTileEntity impl this interface).
        if (tileEntity instanceof IGregTechTileEntity) {
            List<ResourceLocation> list = MultiblockAbility.REGISTRY.get(GTLiteMultiblockAbility.REINFORCED_ROTOR_HOLDER_ABILITY).stream()
                    .map(mte -> mte.metaTileEntityId)
                    .collect(Collectors.toList());
            //  Get MetaTileEntity.
            MetaTileEntity mte = ((IGregTechTileEntity) tileEntity).getMetaTileEntity();
            if (list.contains(mte.metaTileEntityId)) {
                int tier = ((ITieredMetaTileEntity) mte).getTier();
                Object currentTier = blockWorldState.getMatchContext().getOrPut("RotorHolderTier", tier);
                if (!currentTier.equals(tier)) {
                    blockWorldState.setError(new PatternStringError("gtlitecore.machine.reinforced_rotor_holder.error"));
                    return false;
                }
                Set<IMultiblockPart> partsFound = blockWorldState.getMatchContext().getOrCreate("MultiblockParts", HashSet::new);
                partsFound.add((IMultiblockPart) mte);
                return true;
            }
        }
        return false;
    }, () -> MultiblockAbility.REGISTRY.get(GTLiteMultiblockAbility.REINFORCED_ROTOR_HOLDER_ABILITY).stream()
            .sorted(Comparator.comparingInt(mte -> ((ITieredMetaTileEntity) mte).getTier()))
            .map(mte -> new BlockInfo(MetaBlocks.MACHINE.getDefaultState(), getTileEntity(mte)))
            .toArray(BlockInfo[]::new))
            .addTooltips("gtlitecore.machine.reinforced_rotor_holder.error");

    /**
     * Rotor Holder Predicate Getter.
     *
     * @return  Get {@link #ROTOR_HOLDER} predicate.
     */
    public static TraceabilityPredicate rotorHolders() {
        return ROTOR_HOLDER.get();
    }

    /**
     * Optional State in Multiblock Structure.
     *
     * <p>
     *     This is a special state for {@link FactoryBlockPattern},
     *     used for some update meta tile entities.
     * </p>
     *
     * @param mark           Symbol to get these infoes in formStructure().
     * @param allowedStates  Allowed state, i.e. block mean of this symbol (like: 'S', getCasingState()),
     *                       and getCasingState() is a {@link IBlockState} getter.
     * @return               Just like blockMatcher parameter in {@link FactoryBlockPattern},
     *                       you can use correspond text (mark) to check if the aisle is your upgrade structure part.
     */
    public static TraceabilityPredicate optionalStates(String mark, IBlockState... allowedStates) {
        return new TraceabilityPredicate(blockWorldState -> {
            IBlockState state = blockWorldState.getBlockState();
            if (state.getBlock() instanceof VariantActiveBlock) {
                blockWorldState.getMatchContext().getOrPut("VABlock", new LinkedList<>()).add(blockWorldState.getPos());
            }
            if (ArrayUtils.contains(allowedStates, state)) {
                return (blockWorldState.getMatchContext().getOrPut(mark, true));
            }
            return blockWorldState.getMatchContext().get(mark) == null;
        }, getCandidates(allowedStates));
    }

    /**
     * Optional Ability in Multiblock Structure.
     *
     * <p>
     *     This is a special ability for {@link FactoryBlockPattern},
     *     used for some update meta tile entities.
     * </p>
     *
     * @param mark              Symbol to get these infoes in formStructure().
     * @param allowedAbilities  Allowed ability, i.e. ability mean of this symbol,
     *                          like: {@code abilities(MultiblockAbility.IMPORT_ITEM},
     *                          please use abilities in {@link MultiblockAbility}) and gtlitecore's ability class,
     *                          i.e. {@link GTLiteMultiblockAbility}.
     * @return                  Just like abilities() in {@link MultiblockControllerBase},
     *                          you can use correspond text (mark) to check if the ability is your upgrade structure part.
     */
    public static TraceabilityPredicate optionalAbilities(String mark, MultiblockAbility<?>... allowedAbilities) {
        return new TraceabilityPredicate(blockWorldState -> {
            TileEntity tileEntity = blockWorldState.getTileEntity();
            if (tileEntity instanceof IGregTechTileEntity) {
                MetaTileEntity metaTileEntity = ((IGregTechTileEntity) tileEntity).getMetaTileEntity();
                if (metaTileEntity instanceof IMultiblockAbilityPart<?>
                        && ArrayUtils.contains(allowedAbilities, ((IMultiblockAbilityPart<?>) metaTileEntity).getAbility())) {
                    Set<IMultiblockPart> partsFound = blockWorldState.getMatchContext().getOrCreate("MultiblockParts", HashSet::new);
                    partsFound.add((IMultiblockPart) metaTileEntity);
                    return (blockWorldState.getMatchContext().getOrPut(mark, true));
                }
            }
            return blockWorldState.getMatchContext().get(mark) == null;
        }, getCandidates(Arrays.stream(allowedAbilities).flatMap(ability -> MultiblockAbility.REGISTRY.get(ability).stream()).toArray(MetaTileEntity[]::new)));
    }

    //  Precise Assembler Casing Predicate
    public static Supplier<TierTraceabilityPredicate> PA_CASING = () -> new TierTraceabilityPredicate(MAP_PA_CASING,
            Comparator.comparing((s) -> ((WrappedIntTier) MAP_PA_CASING.get(s)).getIntTier()), "PACasing", null);

    /**
     * Precise Assembler Casing Predicate Getter.
     *
     * @return  Get {@link #PA_CASING} predicate.
     */
    public static TraceabilityPredicate paCasings() {
        return PA_CASING.get();
    }

    //  Precise Assembler Internal Casing Predicate
    public static Supplier<TierTraceabilityPredicate> PA_INTERNAL_CASING = () -> new TierTraceabilityPredicate(MAP_PA_INTERNAL_CASING,
            Comparator.comparing((s) -> ((WrappedIntTier) MAP_PA_INTERNAL_CASING.get(s)).getIntTier()), "PAInternalCasing", null);

    /**
     * Precise Assembler Internal Casing Predicate Getter.
     *
     * @return  Get {@link #PA_INTERNAL_CASING} predicate.
     */
    public static TraceabilityPredicate paInternalCasings() {
        return PA_INTERNAL_CASING.get();
    }

    //  Component Assembly Line Predicate
    public static Supplier<TierTraceabilityPredicate> CA_CASING = () -> new TierTraceabilityPredicate(MAP_CA_CASING,
            Comparator.comparing((s) -> ((WrappedIntTier) MAP_CA_CASING.get(s)).getIntTier()), "CACasing", null);

    /**
     * Component Assembly Line Casing Predicate Getter.
     *
     * @return  Get {@link #CA_CASING} predicate.
     */
    public static TraceabilityPredicate caCasings() {
        return CA_CASING.get();
    }

    //  Field Casing Predicate
    public static Supplier<TierTraceabilityPredicate> FIELD_CASING = () -> new TierTraceabilityPredicate(MAP_FIELD_CASING,
            Comparator.comparing((s) -> ((WrappedIntTier) MAP_FIELD_CASING.get(s)).getIntTier()), "FieldCasing", null);

    /**
     * Field Casing Predicate Getter.
     *
     * @return  Get {@link #FIELD_CASING} predicate.
     */
    public static TraceabilityPredicate fieldCasings() {
        return FIELD_CASING.get();
    }

    //  Space Elevator Motor Casing Predicate
    public static Supplier<TierTraceabilityPredicate> SPACE_ELEVATOR_MOTOR = () -> new TierTraceabilityPredicate(MAP_SPACE_ELEVATOR_MOTOR,
            Comparator.comparing((s) -> ((WrappedIntTier) MAP_SPACE_ELEVATOR_MOTOR.get(s)).getIntTier()), "SpaceElevatorMotor", null);

    /**
     * Space Elevator Casing Predicate Getter.
     *
     * @return  Get {@link #SPACE_ELEVATOR_MOTOR} predicate.
     */
    public static TraceabilityPredicate spaceElevatorMotors() {
        return SPACE_ELEVATOR_MOTOR.get();
    }

    //  Cooling Core Predicate
    public static Supplier<TierTraceabilityPredicate> COOLING_CORE = () -> new TierTraceabilityPredicate(MAP_COOLING_CORE,
            Comparator.comparing((s) -> ((WrappedIntTier) MAP_COOLING_CORE.get(s)).getIntTier()), "CoolingCore", null);

    /**
     * Cooling Core Predicate Getter.
     *
     * @return  Get {@link #COOLING_CORE} predicate.
     */
    public static TraceabilityPredicate coolingCores() {
        return COOLING_CORE.get();
    }

    //  Graviton Casing Predicate
    public static Supplier<TierTraceabilityPredicate> GRAVITON_CASING = () -> new TierTraceabilityPredicate(MAP_GRAVITON_CASING,
            Comparator.comparing((s) -> ((WrappedIntTier) MAP_GRAVITON_CASING.get(s)).getIntTier()), "GravitonCasing", null);

    /**
     * Graviton Casing Predicate Getter.
     *
     * @return  Get {@link #GRAVITON_CASING} predicate.
     */
    public static TraceabilityPredicate gravitonCasings() {
        return GRAVITON_CASING.get();
    }

    //  Fusion Coil Predicate
    public static Supplier<TierTraceabilityPredicate> FUSION_COIL = () -> new TierTraceabilityPredicate(MAP_FUSION_COIL,
            Comparator.comparing((s) -> ((WrappedIntTier) MAP_FUSION_COIL.get(s)).getIntTier()), "FusionCoil", null);

    /**
     * Fusion Coil Predicate Getter.
     *
     * @return  Get {@link #FUSION_COIL} predicate.
     */
    public static TraceabilityPredicate fusionCoils() {
        return FUSION_COIL.get();
    }

    //  Implosion Coil Predicate
    public static Supplier<TierTraceabilityPredicate> IMPLOSION_COIL = () -> new TierTraceabilityPredicate(MAP_IMPLOSION_COIL,
            Comparator.comparing((s) -> ((WrappedIntTier) MAP_IMPLOSION_COIL.get(s)).getIntTier()), "ImplosionCoil", null);

    /**
     * Implosion Coil Predicate Getter.
     *
     * @return  Get {@link #IMPLOSION_COIL} predicate.
     */
    public static TraceabilityPredicate implosionCoils() {
        return IMPLOSION_COIL.get();
    }

    //  Machine Casing Predicate
    public static Supplier<TierTraceabilityPredicate> MACHINE_CASING = () -> new TierTraceabilityPredicate(MAP_MACHINE_CASING,
            Comparator.comparing((s) -> ((WrappedIntTier) MAP_MACHINE_CASING.get(s)).getIntTier()), "MachineCasing", null);

    /**
     * Machine Casing Predicate Getter.
     *
     * @return  Get {@link #MACHINE_CASING} predicate.
     */
    public static TraceabilityPredicate machineCasings() {
        return MACHINE_CASING.get();
    }

    //  Algae Culture Tank Predicate
    public static Supplier<TierTraceabilityPredicate> ACT_CASING = () -> new TierTraceabilityPredicate(MAP_ACT_CASING,
            Comparator.comparing((s) -> ((WrappedIntTier) MAP_ACT_CASING.get(s)).getIntTier()), "AlgaeCultureTankCasing", null);

    /**
     * Algae Culture Tank Predicate Getter.
     *
     * @return  Get {@link #ACT_CASING} predicate.
     */
    public static TraceabilityPredicate actCasings() {
        return ACT_CASING.get();
    }

    //  Modulation Cavity Predicate
    public static Supplier<TierTraceabilityPredicate> MODULATION_CAVITY = () -> new TierTraceabilityPredicate(MAP_MODULATION_CAVITY,
            Comparator.comparing((s) -> ((WrappedIntTier) MAP_MODULATION_CAVITY.get(s)).getIntTier()), "ModulationCavity", null);

    /**
     * Modulation Cavity Predicate Getter.
     *
     * @return  Get {@link #MODULATION_CAVITY} predicate.
     */
    public static TraceabilityPredicate modulationCavities() {
        return MODULATION_CAVITY.get();
    }

    //  Resonant Cavity Predicate
    public static Supplier<TierTraceabilityPredicate> RESONANT_CAVITY = () -> new TierTraceabilityPredicate(MAP_RESONANT_CAVITY,
            Comparator.comparing((s) -> ((WrappedIntTier) MAP_RESONANT_CAVITY.get(s)).getIntTier()), "ResonantCavity", null);

    /**
     * Resonant Cavity Predicate Getter.
     *
     * @return  Get {@link #RESONANT_CAVITY} predicate.
     */
    public static TraceabilityPredicate resonantCavities() {
        return RESONANT_CAVITY.get();
    }
}