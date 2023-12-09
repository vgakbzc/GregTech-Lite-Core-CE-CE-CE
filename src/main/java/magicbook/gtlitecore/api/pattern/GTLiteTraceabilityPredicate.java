package magicbook.gtlitecore.api.pattern;

import gregtech.api.metatileentity.ITieredMetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.pattern.PatternStringError;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.util.BlockInfo;
import gregtech.common.blocks.BlockFireboxCasing;
import gregtech.common.blocks.MetaBlocks;
import magicbook.gtlitecore.api.block.impl.WrappedIntTier;
import magicbook.gtlitecore.api.metatileentity.multi.GTLiteMultiblockAbility;
import magicbook.gtlitecore.api.pattern.predicates.TierTraceabilityPredicate;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.lang3.ArrayUtils;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static magicbook.gtlitecore.api.GTLiteAPI.*;
import static magicbook.gtlitecore.api.utils.GTLiteUtils.getTileEntity;

public class GTLiteTraceabilityPredicate {

    public static Supplier<TraceabilityPredicate> FIRE_BOX = () -> new TraceabilityPredicate(blockWorldState -> {
        IBlockState blockState = blockWorldState.getBlockState();
        if ((blockState.getBlock() instanceof BlockFireboxCasing BlockFireboxCasing)) {
            BlockFireboxCasing.FireboxCasingType casingType = BlockFireboxCasing.getState(blockState);
            Object currentCasingType = blockWorldState.getMatchContext().getOrPut("CasingType", casingType);
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

    public static Supplier<TraceabilityPredicate> ROTOR_HOLDER = () -> new TraceabilityPredicate(blockWorldState -> {
        TileEntity tileEntity = blockWorldState.getTileEntity();
        if (tileEntity instanceof IGregTechTileEntity) {
            List<ResourceLocation> list = MultiblockAbility.REGISTRY.get(GTLiteMultiblockAbility.REINFORCED_ROTOR_HOLDER_ABILITY).stream()
                    .map(mte -> mte.metaTileEntityId)
                    .collect(Collectors.toList());
            MetaTileEntity mte = ((IGregTechTileEntity)tileEntity).getMetaTileEntity();
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

    public static Supplier<TierTraceabilityPredicate> PA_CASING = () -> new TierTraceabilityPredicate(MAP_PA_CASING,
            Comparator.comparing((s) -> ((WrappedIntTier) MAP_PA_CASING.get(s)).getIntTier()), "PACasing", null);

    public static Supplier<TierTraceabilityPredicate> PA_INTERNAL_CASING = () -> new TierTraceabilityPredicate(MAP_PA_INTERNAL_CASING,
            Comparator.comparing((s) -> ((WrappedIntTier) MAP_PA_INTERNAL_CASING.get(s)).getIntTier()), "PAInternalCasing", null);

    public static Supplier<TierTraceabilityPredicate> CA_CASING = () -> new TierTraceabilityPredicate(MAP_CA_CASING,
            Comparator.comparing((s) -> ((WrappedIntTier) MAP_CA_CASING.get(s)).getIntTier()), "CACasing", null);

    public static Supplier<TierTraceabilityPredicate> FIELD_CASING = () -> new TierTraceabilityPredicate(MAP_FIELD_CASING,
            Comparator.comparing((s) -> ((WrappedIntTier) MAP_FIELD_CASING.get(s)).getIntTier()), "FieldCasing", null);

    public static Supplier<TierTraceabilityPredicate> SPACE_ELEVATOR_MOTOR = () -> new TierTraceabilityPredicate(MAP_SPACE_ELEVATOR_MOTOR,
            Comparator.comparing((s) -> ((WrappedIntTier) MAP_SPACE_ELEVATOR_MOTOR.get(s)).getIntTier()), "SpaceElevatorMotor", null);
}