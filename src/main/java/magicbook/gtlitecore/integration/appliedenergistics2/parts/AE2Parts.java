package magicbook.gtlitecore.integration.appliedenergistics2.parts;

import appeng.api.AEApi;
import appeng.core.features.DamagedItemDefinition;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import magicbook.gtlitecore.integration.appliedenergistics2.AE2Registry;
import magicbook.gtlitecore.integration.appliedenergistics2.IRegisterDefinition;
import magicbook.gtlitecore.integration.appliedenergistics2.items.AE2BaseItemPart;
import magicbook.gtlitecore.integration.appliedenergistics2.rendering.AE2PartRendering;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class AE2Parts implements IRegisterDefinition<DamagedItemDefinition> {

    private final Object2ObjectOpenHashMap<String, DamagedItemDefinition> itemIdList = new Object2ObjectOpenHashMap<>();

    //  Please pre-register your part here like `private final DamagedItemDefinition partName;`.

    //  Part Item Base class.
    private final AE2BaseItemPart partBase;

    public AE2Parts(AE2Registry registry) {
        this.partBase = new AE2BaseItemPart();
        registry.addItem("part", () -> this.partBase)
                .rendering(new AE2PartRendering(this.partBase))
                .build();

        //  Register all Part Models.
        var partModels = AEApi.instance().registries().partModels();
        for (var partType : AE2PartType.values()) {
            partModels.registerModels(partType.getModels());
        }

        //  Please register all parts here use `registerPart()` method.
    }

    public static Optional<AE2PartType> getById(int itemDamage) {
        return Optional.ofNullable(AE2PartType.getCachedValues().getOrDefault(itemDamage, null));
    }

    @Override
    public Optional<DamagedItemDefinition> getById(String id) {
        return Optional.ofNullable(this.itemIdList.getOrDefault(id, null));
    }

    @NotNull
    private DamagedItemDefinition registerPart(AE2BaseItemPart part, AE2PartType partType) {
        var damagedItemDefinition = new DamagedItemDefinition(partType.getId(), part.registerPart(partType));
        this.itemIdList.put(partType.getId(), damagedItemDefinition);
        return damagedItemDefinition;
    }

}
