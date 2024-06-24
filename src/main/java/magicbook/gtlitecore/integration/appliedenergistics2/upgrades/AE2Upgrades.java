package magicbook.gtlitecore.integration.appliedenergistics2.upgrades;

import appeng.core.features.DamagedItemDefinition;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import magicbook.gtlitecore.integration.appliedenergistics2.AE2Registry;
import magicbook.gtlitecore.integration.appliedenergistics2.items.AE2BaseItemUpgrade;
import magicbook.gtlitecore.integration.appliedenergistics2.rendering.DamagedItemRendering;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Optional;

public class AE2Upgrades implements IDamagedDefinition<DamagedItemDefinition, AE2UpgradeType> {

    private final Object2ObjectOpenHashMap<String, DamagedItemDefinition> itemIdList = new Object2ObjectOpenHashMap<>();

    //  Please pre-register your upgrade here like `private final IItemDefinition upgradeName`.

    //  Upgrade Item Base class.
    private final AE2BaseItemUpgrade upgradeBase;

    public AE2Upgrades(AE2Registry registry) {
        this.upgradeBase = new AE2BaseItemUpgrade();
        registry.addItem("upgrade", () -> this.upgradeBase)
                .rendering(new DamagedItemRendering<>(this))
                .build();
        //  Register your upgrade here, use `registerUpgrade()` method,
        //  please use `registry.addBootstrapComponent` to add your upgrade to a IPostInitComponent,
        //  add registerItem to AE2 Upgrade Type, like: ```
        //      registry.addBootstrapComponent((IPostInitComponent) c -> {
        //          var definitions = Api.INSTANCE.definitions();
        //          final IBlocks blocks = definitions.blocks();
        //          AE2UpgradeType.ITEM_NAME.registerItem(blocks.iOPort(), 3);
        //      })
        //  ```
        //  this code add a Upgrade to ME IO Interface and make its max size be 3.
    }

    public Optional<AE2UpgradeType> getById(int itemDamage) {
        return Optional.ofNullable(AE2UpgradeType.getCachedValues().getOrDefault(itemDamage, null));
    }

    public Optional<DamagedItemDefinition> getById(String id) {
        return Optional.ofNullable(this.itemIdList.getOrDefault(id, null));
    }

    @NotNull
    private DamagedItemDefinition registerUpgrade(AE2BaseItemUpgrade material, AE2UpgradeType upgradeType) {
        var damagedItemDefinition = new DamagedItemDefinition(upgradeType.getId(), material.registerUpgrade(upgradeType));
        this.itemIdList.put(upgradeType.getId(), damagedItemDefinition);
        return damagedItemDefinition;
    }

    @Override
    public Collection<AE2UpgradeType> getEntries() {
        return AE2UpgradeType.getCachedValues().values();
    }

    @Nullable
    @Override
    public AE2UpgradeType getType(ItemStack stack) {
        return this.upgradeBase.getType(stack);
    }

}
