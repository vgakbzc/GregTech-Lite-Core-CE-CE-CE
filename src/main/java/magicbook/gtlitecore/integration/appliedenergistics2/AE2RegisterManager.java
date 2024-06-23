package magicbook.gtlitecore.integration.appliedenergistics2;

import appeng.bootstrap.components.*;
import magicbook.gtlitecore.integration.appliedenergistics2.items.AE2Items;
import magicbook.gtlitecore.integration.appliedenergistics2.models.ModelLoaderWrapper;
import magicbook.gtlitecore.integration.appliedenergistics2.upgrades.AE2Upgrades;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class AE2RegisterManager {

    private final AE2Registry registry;
    private final AE2Items item;
    private final AE2Upgrades upgrade;

    public AE2RegisterManager() {
        MinecraftForge.EVENT_BUS.register(this);
        this.registry = new AE2Registry();
        this.item = new AE2Items(this.registry);
        this.upgrade = new AE2Upgrades(this.registry);
    }

    public void onPreInit(FMLPreInitializationEvent event) {
        this.registry.getBootstrapComponents(IPreInitComponent.class)
                .forEachRemaining(b -> b.preInitialize(event.getSide()));
    }

    public void onInit(FMLInitializationEvent event) {
        this.registry.getBootstrapComponents(IInitComponent.class)
                .forEachRemaining(b -> b.initialize(event.getSide()));
    }

    public void onPostInit(FMLPostInitializationEvent event) {
        this.registry.getBootstrapComponents(IPostInitComponent.class)
                .forEachRemaining(b -> b.postInitialize(event.getSide()));
    }

    @SubscribeEvent
    public void registerItems(final RegistryEvent.Register<Item> event) {
        final var registry = event.getRegistry();
        final var side = FMLCommonHandler.instance().getEffectiveSide();
        this.registry.getBootstrapComponents(IItemRegistrationComponent.class)
                .forEachRemaining(b -> b.itemRegistration(side, registry));
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void registerModels(final ModelRegistryEvent event) {
        final var registry = new ModelLoaderWrapper();
        final var side = FMLCommonHandler.instance().getEffectiveSide();
        this.registry.getBootstrapComponents(IModelRegistrationComponent.class)
                .forEachRemaining(b -> b.modelRegistration(side, registry));
    }

    public AE2Items getAE2Items() {
        return this.item;
    }

    public AE2Upgrades getAE2Upgrades() {
        return this.upgrade;
    }

}
