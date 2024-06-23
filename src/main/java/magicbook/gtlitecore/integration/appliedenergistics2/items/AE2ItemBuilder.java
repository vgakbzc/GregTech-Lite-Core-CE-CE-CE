package magicbook.gtlitecore.integration.appliedenergistics2.items;

import appeng.bootstrap.IBootstrapComponent;
import appeng.bootstrap.ItemRenderingCustomizer;
import appeng.bootstrap.components.IItemRegistrationComponent;
import appeng.bootstrap.components.IPostInitComponent;
import appeng.core.features.ItemDefinition;
import appeng.util.Platform;
import co.neeve.nae2.common.features.IFeature;
import magicbook.gtlitecore.api.GTLiteAPI;
import magicbook.gtlitecore.api.utils.Mods;
import magicbook.gtlitecore.integration.appliedenergistics2.AE2Registry;
import magicbook.gtlitecore.integration.appliedenergistics2.rendering.AE2ItemRendering;
import magicbook.gtlitecore.integration.jei.GTLiteJEIPlugin;
import net.minecraft.block.BlockDispenser;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class AE2ItemBuilder implements IAE2ItemBuilder {

    //  Registry.
    private final AE2Registry registry;
    private final String registryName;

    //  Item Property.
    private final Supplier<Item> itemSupplier;
    private final List<Function<Item, IBootstrapComponent>> bootstrapComponents = new ArrayList<>();
    @Nullable
    private IFeature[] features = null;
    private Supplier<IBehaviorDispenseItem> behaviorSupplier;
    @SideOnly(Side.CLIENT)
    private AE2ItemRendering itemRendering;
    private CreativeTabs creativeTab = GTLiteAPI.TAB_GTLITE_AE2_INTEGRATION;
    private boolean hidden;

    public AE2ItemBuilder(AE2Registry registry, String registryName, Supplier<Item> itemSupplier) {
        this.registry = registry;
        this.registryName = registryName;
        this.itemSupplier = itemSupplier;
        if (Platform.isClient()) {
            this.itemRendering = new AE2ItemRendering();
        }
    }

    @Override
    public IAE2ItemBuilder bootstrap(Function<Item, IBootstrapComponent> component) {
        this.bootstrapComponents.add(component);
        return this;
    }

    @Override
    public IAE2ItemBuilder features(IFeature... features) {
        this.features = features;
        return this;
    }

    @Override
    public IAE2ItemBuilder creativeTab(CreativeTabs creativeTab) {
        this.creativeTab = creativeTab;
        return this;
    }

    @Override
    public IAE2ItemBuilder rendering(ItemRenderingCustomizer customizerCallback) {
        if (Platform.isClient())
            this.customizeForClient(customizerCallback);
        return this;
    }

    @Override
    public IAE2ItemBuilder dispenserBehavior(Supplier<IBehaviorDispenseItem> behavior) {
        this.behaviorSupplier = behavior;
        return this;
    }

    @SideOnly(Side.CLIENT)
    private void customizeForClient(ItemRenderingCustomizer callback) {
        callback.customize(this.itemRendering);
    }

    @Override
    public IAE2ItemBuilder hidden() {
        this.hidden = true;
        return this;
    }

    @Override
    public ItemDefinition build() {
        if (this.features != null && Arrays.stream(this.features).noneMatch(IFeature::isEnabled)) {
            return new ItemDefinition(this.registryName, null);
        }

        var item = this.itemSupplier.get();
        item.setRegistryName(Mods.GregTechLiteCore.getID(), this.registryName);

        var definition = new ItemDefinition(this.registryName, item);
        item.setTranslationKey(Mods.GregTechLiteCore.getID() + "." + this.registryName);

        if (!this.hidden) {
            item.setCreativeTab(this.creativeTab);
        }

        // Register all extra handlers.
        this.bootstrapComponents.forEach(component -> this.registry.addBootstrapComponent(component.apply(item)));

        // Register custom dispenser behavior if requested.
        if (this.behaviorSupplier != null) {
            this.registry.addBootstrapComponent((IPostInitComponent) side -> {
                var behavior = this.behaviorSupplier.get();
                BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(item, behavior);
            });
        }

        this.registry.addBootstrapComponent((IItemRegistrationComponent) (side, reg) -> reg.register(item));

        if (Platform.isClient()) {
            if (this.hidden && Mods.JustEnoughItems.isModLoaded()) {
                GTLiteJEIPlugin.addItemToBlacklist(definition);
            }
            this.itemRendering.apply(this.registry, item);
        }
        return definition;
    }
}
