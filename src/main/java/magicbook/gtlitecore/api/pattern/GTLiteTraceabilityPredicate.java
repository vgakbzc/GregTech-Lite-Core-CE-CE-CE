package magicbook.gtlitecore.api.pattern;

import gregtech.api.pattern.PatternStringError;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.util.BlockInfo;
import gregtech.common.blocks.BlockFireboxCasing;
import gregtech.common.blocks.MetaBlocks;
import magicbook.gtlitecore.api.block.impl.WrappedIntTier;
import magicbook.gtlitecore.api.pattern.predicates.TierTraceabilityPredicate;
import net.minecraft.block.state.IBlockState;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.function.Supplier;

import static magicbook.gtlitecore.api.GTLiteAPI.*;

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

    public static Supplier<TierTraceabilityPredicate> EP_PA_CASING = () -> new TierTraceabilityPredicate(MAP_PA_CASING,
            Comparator.comparing((s) -> ((WrappedIntTier) MAP_PA_CASING.get(s)).getIntTier()), "PACasing", null);

    public static Supplier<TierTraceabilityPredicate> EP_PA_INTERNAL_CASING = () -> new TierTraceabilityPredicate(MAP_PA_INTERNAL_CASING,
            Comparator.comparing((s) -> ((WrappedIntTier) MAP_PA_INTERNAL_CASING.get(s)).getIntTier()), "PAInternalCasing", null);

}