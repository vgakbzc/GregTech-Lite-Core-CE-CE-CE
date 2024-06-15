package magicbook.gtlitecore.integration;

import magicbook.gtlitecore.api.utils.GTLiteLog;
import magicbook.gtlitecore.api.utils.Mods;
import magicbook.gtlitecore.common.GTLiteConfigHolder;
import magicbook.gtlitecore.integration.architecturecraft.ArchitectureCraftMiscRecipes;
import magicbook.gtlitecore.integration.chisel.AutoChiselRecipeLoader;
import magicbook.gtlitecore.integration.chisel.ChiselMachineRecipeLoader;
import magicbook.gtlitecore.integration.chisel.ChiselMiscRecipes;
import magicbook.gtlitecore.integration.gcym.GCYMOverrideRecipeLoader;
import magicbook.gtlitecore.integration.gregtechfoodoption.GTFORecipeManager;
import magicbook.gtlitecore.integration.ironchest.IronChestRecipeLoader;
import magicbook.gtlitecore.integration.theoneprobe.provider.RecipeFluidOutputInfoProvider;
import magicbook.gtlitecore.integration.theoneprobe.provider.RecipeItemOutputInfoProvider;
import mcjty.theoneprobe.TheOneProbe;
import mcjty.theoneprobe.api.ITheOneProbe;

public class GTLiteIntegration {

    public static void onInit() {
        //  The One Probe Integration
        if (Mods.TheOneProbe.isModLoaded()) {
            if (GTLiteConfigHolder.compats.enableTOPModule) {
                GTLiteLog.logger.info("Registering The One Probe Integration...");
                ITheOneProbe oneProbe = TheOneProbe.theOneProbeImp;
                oneProbe.registerProvider(new RecipeItemOutputInfoProvider());
                oneProbe.registerProvider(new RecipeFluidOutputInfoProvider());
            }
        }
    }

    public static void registerRecipes() {

        //  Architecture Craft
        if (Mods.ArchitectureCraft.isModLoaded()) {
            ArchitectureCraftMiscRecipes.init();
        }

        //  Chisel
        if (Mods.Chisel.isModLoaded() && GTLiteConfigHolder.compats.enableChiselModule) {
            ChiselMachineRecipeLoader.init();
            AutoChiselRecipeLoader.init();
        }

        if (Mods.Chisel.isModLoaded()) {
            ChiselMiscRecipes.init();
        }

        //  Gregicality Multiblocks
        if (Mods.GregicalityMultiblocks.isModLoaded()) {
            GCYMOverrideRecipeLoader.init();
        }

        //  GregTech Food Option
        if (Mods.GregTechFoodOption.isModLoaded()) {
            GTFORecipeManager.init();
            GTFORecipeManager.initChains();
        }

        //  Iron Chest
        if (Mods.IronChest.isModLoaded()) {
            IronChestRecipeLoader.init();
        }

    }


    public GTLiteIntegration() {}
}
