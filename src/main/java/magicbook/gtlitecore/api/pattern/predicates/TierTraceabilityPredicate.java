package magicbook.gtlitecore.api.pattern.predicates;

import gregtech.api.block.VariantActiveBlock;
import gregtech.api.pattern.BlockWorldState;
import gregtech.api.pattern.PatternStringError;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.util.BlockInfo;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import magicbook.gtlitecore.api.block.IBlockTier;
import net.minecraft.block.state.IBlockState;
import org.jetbrains.annotations.Nullable;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Tier Traceability Predicate
 *
 * @author Gate Guardian
 *
 * <p>
 *     Special Traceability Predicate used {@link IBlockTier},
 *     add tier system of special blocks (use hash map to init these blocks).
 * </p>
 *
 * @since 2.7.4-beta
 */
public class TierTraceabilityPredicate extends TraceabilityPredicate {

    private final Object2ObjectOpenHashMap<IBlockState, IBlockTier> map;
    private final String name;
    private final String errorKey;
    private Supplier<BlockInfo[]> candidatesCache;

    private final Comparator<IBlockState> comparator;
    private final Predicate<IBlockState> predicate;

    public TierTraceabilityPredicate(Object2ObjectOpenHashMap<IBlockState, IBlockTier> map,
                                     String name,
                                     @Nullable String errorKey){
        this(map, Comparator.comparing((s) -> map.get(s).getName()), BlockState -> true, name, errorKey);
    }

    public TierTraceabilityPredicate(Object2ObjectOpenHashMap<IBlockState, IBlockTier> map,
                                     Predicate<IBlockState> predicate,
                                     String name,
                                     @Nullable String errorKey){
        this(map, Comparator.comparing((s) -> map.get(s).getName()), predicate, name, errorKey);
    }

    public TierTraceabilityPredicate(Object2ObjectOpenHashMap<IBlockState, IBlockTier> map,
                                     Comparator<IBlockState> comparator,
                                     String name,
                                     @Nullable String errorKey){
        this(map, comparator, BlockState -> true, name, errorKey);
    }

    public TierTraceabilityPredicate(Object2ObjectOpenHashMap<IBlockState, IBlockTier> map,
                                     Comparator<IBlockState> comparator,
                                     Predicate<IBlockState> predicate,
                                     String name,
                                     @Nullable String errorKey){
        super();
        this.map = map;
        this.name = name;

        if (errorKey == null) {
            this.errorKey = "gregtech.multiblock.pattern.error.casing";
        } else {
            this.errorKey = errorKey;
            this.addTooltips(this.errorKey);
        }
        this.common.add(new SimplePredicate(predicate(), candidates()));
        this.comparator = comparator;
        this.predicate = predicate;
    }

    private Predicate<BlockWorldState> predicate(){
        return (blockWorldState) -> {
            IBlockState blockState = blockWorldState.getBlockState();

            if (map.containsKey(blockState)) {
                IBlockTier stats = map.get(blockState);
                Object tier = stats.getTier();
                Object currentTier = blockWorldState.getMatchContext().getOrPut(name, tier);
                if (!currentTier.equals(tier)) {
                    blockWorldState.setError(new PatternStringError(errorKey));
                    return false;
                } else {
                    blockWorldState.getMatchContext().getOrPut(name + "TieredStats", stats);
                    if(blockState.getBlock() instanceof VariantActiveBlock){
                        (blockWorldState.getMatchContext().getOrPut("VABlock", new LinkedList<>())).add(blockWorldState.getPos());
                    }
                    return true;
                }
            } else {
                return false;
            }
        };
    }

    private Supplier<BlockInfo[]> candidates(){
        if (candidatesCache == null) {
            candidatesCache = () -> map.keySet().stream()
                    .filter(predicate)
                    .sorted(comparator)
                    .map(type -> new BlockInfo(type, null,map.get(type).getInfo()))
                    .toArray(BlockInfo[]::new);
        }
        return candidatesCache;
    }
}
