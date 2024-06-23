package magicbook.gtlitecore.integration.appliedenergistics2.materials;

import appeng.core.features.DamagedItemDefinition;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import magicbook.gtlitecore.integration.appliedenergistics2.AE2Registry;
import magicbook.gtlitecore.integration.appliedenergistics2.items.AE2BaseItemMaterial;
import magicbook.gtlitecore.integration.appliedenergistics2.rendering.DamagedItemRendering;
import magicbook.gtlitecore.integration.appliedenergistics2.upgrades.IDamagedDefinition;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Optional;

public class AE2Materials implements IDamagedDefinition<DamagedItemDefinition, AE2MaterialType> {

    private final Object2ObjectOpenHashMap<String, DamagedItemDefinition> itemIdList = new Object2ObjectOpenHashMap<>();

    //  Please pre-register your materials here like `private final IItemDefinition MATERIAL_NAME`.

    //  Material Item Base class.
    private final AE2BaseItemMaterial materialBase;

    public AE2Materials(AE2Registry registry) {
        this.materialBase = new AE2BaseItemMaterial();
        registry.addItem("material", () -> this.materialBase)
                .rendering(new DamagedItemRendering<>(this))
                .build();

        //  Please register your materials here use `registerMaterial()` method.
    }

    @Nonnull
    private DamagedItemDefinition registerMaterial(AE2BaseItemMaterial material, AE2MaterialType materialType) {
        var damagedItemDefinition = new DamagedItemDefinition(materialType.getId(), material.registerMaterial(materialType));
        this.itemIdList.put(materialType.getId(), damagedItemDefinition);
        return damagedItemDefinition;
    }

    public Optional<AE2MaterialType> getById(int itemDamage) {
        return Optional.ofNullable(AE2MaterialType.getCachedValues().getOrDefault(itemDamage, null));
    }

    public Optional<DamagedItemDefinition> getById(String id) {
        return Optional.ofNullable(this.itemIdList.getOrDefault(id, null));
    }

    @Override
    public Collection<AE2MaterialType> getEntries() {
        return AE2MaterialType.getCachedValues().values();
    }

    @Nullable
    @Override
    public AE2MaterialType getType(ItemStack stack) {
        return this.materialBase.getTypeByStack(stack);
    }
}
