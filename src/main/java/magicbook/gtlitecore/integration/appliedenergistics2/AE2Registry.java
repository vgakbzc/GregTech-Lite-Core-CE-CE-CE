package magicbook.gtlitecore.integration.appliedenergistics2;

import appeng.bootstrap.IBootstrapComponent;
import appeng.util.Platform;
import magicbook.gtlitecore.integration.appliedenergistics2.blocks.AE2BlockBuilder;
import magicbook.gtlitecore.integration.appliedenergistics2.blocks.IAE2BlockBuilder;
import magicbook.gtlitecore.integration.appliedenergistics2.components.AE2BuiltInModelComponent;
import magicbook.gtlitecore.integration.appliedenergistics2.components.AE2ModelOverrideComponent;
import magicbook.gtlitecore.integration.appliedenergistics2.components.AE2TileEntityComponent;
import magicbook.gtlitecore.integration.appliedenergistics2.items.AE2ItemBuilder;
import magicbook.gtlitecore.integration.appliedenergistics2.items.IAE2ItemBuilder;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class AE2Registry {

    //  TileEntityDefinition Component (rewrite from AE2).
    public final AE2TileEntityComponent tileEntityComponent;
    //  Bootstrap Component map.
    private final Map<Class<? extends IBootstrapComponent>, List<IBootstrapComponent>> bootstrapComponents;
    //  Model Override Component.
    @SideOnly(Side.CLIENT)
    private AE2ModelOverrideComponent modelOverrideComponent;
    //  Built in Model Component.
    @SideOnly(Side.CLIENT)
    private AE2BuiltInModelComponent builtInModelComponent;

    public AE2Registry() {
        //  Initialization Bootstrap Component map.
        this.bootstrapComponents = new HashMap<>();
        //  Add TileEntityDefinition Component to Bootstrap Components.
        this.tileEntityComponent = new AE2TileEntityComponent();
        this.addBootstrapComponent(this.tileEntityComponent);

        if (Platform.isClient()) {
            //  Add Model Override Component to Bootstrap Component.
            this.modelOverrideComponent = new AE2ModelOverrideComponent();
            this.addBootstrapComponent(this.modelOverrideComponent);
            //  Add Built in Model Component to Bootstrap Component.
            this.builtInModelComponent = new AE2BuiltInModelComponent();
            this.addBootstrapComponent(this.builtInModelComponent);
        }
    }

    /**
     * Add Component to AE2 Bootstrap Components.
     *
     * @param component  Component.
     */
    @SuppressWarnings("unchecked")
    public void addBootstrapComponent(IBootstrapComponent component) {
        Arrays.stream(component.getClass().getInterfaces())
                .filter(IBootstrapComponent.class::isAssignableFrom)
                .forEach(c -> this.addBootstrapComponent((Class<? extends IBootstrapComponent>) c, component));
    }

    /**
     * Add Component to AE2 Bootstrap Components.
     *
     * @param eventType  Bootstrap Event Type.
     * @param component  Component.
     */
    public <T extends IBootstrapComponent> void addBootstrapComponent(Class<? extends IBootstrapComponent> eventType, T component) {
        this.bootstrapComponents.computeIfAbsent(eventType, c -> new ArrayList<>()).add(component);
    }

    /**
     * Get Bootstrap Component by Event Type.
     *
     * @param eventType  Bootstrap Event Type.
     * @return           Bootstrap Component.
     */
    @SuppressWarnings("unchecked")
    public <T extends IBootstrapComponent> Iterator<T> getBootstrapComponents(Class<T> eventType) {
        return (Iterator<T>) this.bootstrapComponents.getOrDefault(eventType, Collections.emptyList()).iterator();
    }

    /**
     * Add Built in Model.
     *
     * @param path   Model path.
     * @param model  Model.
     */
    @SideOnly(Side.CLIENT)
    public void addBuiltInModel(String path, IModel model) {
        this.builtInModelComponent.addModel(path, model);
    }

    /**
     * Add Override Model.
     *
     * @param resourcePath  Model Path.
     * @param customizer    Customizer.
     */
    @SideOnly(Side.CLIENT)
    public void addModelOverride(String resourcePath,
                                 BiFunction<ModelResourceLocation, IBakedModel, IBakedModel> customizer) {
        this.modelOverrideComponent.addOverride(resourcePath, customizer);
    }

    /**
     * Add AE2 Item by {@code id} and {@code itemSupplier}.
     *
     * @param id    Item ID.
     * @param item  Item Supplier.
     * @return      AE2 Item.
     */
    public IAE2ItemBuilder addItem(String id, Supplier<Item> item) {
        return new AE2ItemBuilder(this, id, item);
    }

    /**
     * Add AE2 Block by {@code id} and {@code blockSupplier}.
     *
     * @param id     Block ID.
     * @param block  Block Supplier.
     * @return       AE2 Block.
     */
    public IAE2BlockBuilder addBlock(String id, Supplier<Block> block) {
        return new AE2BlockBuilder(this, id, block);
    }
}
