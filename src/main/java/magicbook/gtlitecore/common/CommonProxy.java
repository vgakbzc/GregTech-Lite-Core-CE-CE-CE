package magicbook.gtlitecore.common;

import gregtech.api.GregTechAPI;
import gregtech.api.cover.CoverDefinition;
import gregtech.common.blocks.BlockWireCoil;
import gregtech.loaders.recipe.CraftingComponent;
import magicbook.gtlitecore.GTLiteCore;
import magicbook.gtlitecore.api.utils.GTLiteLog;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.function.Function;

@Mod.EventBusSubscriber(modid = GTLiteCore.MODID)
public class CommonProxy {

    public void preLoad() {}

    @SubscribeEvent
    public static void syncConfigValues(@Nonnull ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(GTLiteCore.MODID)) {
            ConfigManager.sync(GTLiteCore.MODID, Config.Type.INSTANCE);
        }
    }

    @SubscribeEvent
    public static void registerBlocks(@Nonnull RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();
        GTLiteLog.logger.info("Registering Blocks...");

    }

    @SubscribeEvent
    public static void registerItems(@Nonnull RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        GTLiteLog.logger.info("Registering Items...");
    }

    @Nonnull
    private static <T extends Block>ItemBlock createItemBlock(@Nonnull T block, @Nonnull Function<T, ItemBlock> producer) {
        ItemBlock itemBlock = producer.apply(block);
        itemBlock.setRegistryName(Objects.requireNonNull(block.getRegistryName()));
        return itemBlock;
    }

    @SubscribeEvent
    public static void registerCoverBehavior(GregTechAPI.RegisterEvent<CoverDefinition> event) {
        GTLiteLog.logger.info("Registering Cover Behaviors...");
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        GTLiteLog.logger.info("Registering recipes...");

    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void registerMaterialComponents(GregTechAPI.RegisterEvent<CraftingComponent> event) {
        GTLiteLog.logger.info("Registering material components...");
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void registerWireCoil(GregTechAPI.RegisterEvent<BlockWireCoil> event) {
        GTLiteLog.logger.info("Registering wire coils...");

    }
}
