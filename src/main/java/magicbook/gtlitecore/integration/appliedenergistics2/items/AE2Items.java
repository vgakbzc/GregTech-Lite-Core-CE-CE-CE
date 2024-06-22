package magicbook.gtlitecore.integration.appliedenergistics2.items;

import appeng.api.AEApi;
import appeng.api.config.Upgrades;
import appeng.api.definitions.IItemDefinition;
import appeng.bootstrap.components.IPostInitComponent;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import magicbook.gtlitecore.integration.appliedenergistics2.AE2Registry;
import magicbook.gtlitecore.integration.appliedenergistics2.IRegisterDefinition;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AE2Items implements IRegisterDefinition<IItemDefinition> {

    private final Object2ObjectOpenHashMap<String, IItemDefinition> itemIdList = new Object2ObjectOpenHashMap<>();

    //  Please pre-init item here, like: `private final IItemDefinition itemName;`.

    public AE2Items(AE2Registry registry) {

        //  Please init item here like `this.itemName = this.registerItem()`.

        //  Add Post-Init Bootstrap Component for Items.
        registry.addBootstrapComponent((IPostInitComponent) c -> {
            var items = AEApi.instance().definitions().items();
            var cellDef = items.cell1k();
            var fluidCellDef = items.fluidCell1k();

            //  Please check Features if it is enabled and mirrored cell upgrades here (if you need),
            //  just like `mirrorCellUpgrades(cellDef, this.itemName)`, also you can use IItemDefinition list.
        });
    }

    private IItemDefinition registerItem(IItemDefinition item) {
        this.itemIdList.put(item.identifier(), item);
        return item;
    }

    private static void mirrorCellUpgrades(IItemDefinition definition, IItemDefinition[] definitions) {
        var supported = new HashMap<Upgrades, Integer>();
        Arrays.stream(Upgrades.values()).forEach(upgrade -> {
            upgrade.getSupported().entrySet().stream()
                    .filter(d -> definition.isSameAs(d.getKey()))
                    .map(Map.Entry::getValue)
                    .findFirst()
                    .ifPresent(value -> supported.put(upgrade, value));
        });
        Arrays.stream(definitions).forEach(def -> {
            supported.forEach((key, value) -> key.registerItem(def, value));
        });
    }

    @Override
    public Optional<IItemDefinition> getById(String id) {
        return Optional.ofNullable(this.itemIdList.getOrDefault(id, null));
    }

}
