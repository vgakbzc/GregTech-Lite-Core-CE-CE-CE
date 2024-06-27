package magicbook.gtlitecore.integration;

import magicbook.gtlitecore.api.utils.GTLiteLog;
import magicbook.gtlitecore.api.utils.Mods;
import magicbook.gtlitecore.common.GTLiteConfigHolder;
import magicbook.gtlitecore.integration.appliedenergistics2.AE2RecipeLoader;
import magicbook.gtlitecore.integration.architecturecraft.ArchitectureCraftRecipeLoader;
import magicbook.gtlitecore.integration.chisel.AutoChiselRecipeLoader;
import magicbook.gtlitecore.integration.chisel.ChiselMachineRecipeLoader;
import magicbook.gtlitecore.integration.chisel.ChiselMiscRecipes;
import magicbook.gtlitecore.integration.enderstorage.EnderStorageRecipeLoader;
import magicbook.gtlitecore.integration.fluiddrawers.FluidDrawersRecipeLoader;
import magicbook.gtlitecore.integration.futuremc.FutureMCRecipeLoader;
import magicbook.gtlitecore.integration.gcym.GCYMOverrideRecipeLoader;
import magicbook.gtlitecore.integration.gregtech.CompatMaterialRecipeLoader;
import magicbook.gtlitecore.integration.gregtechfoodoption.GTFORecipeManager;
import magicbook.gtlitecore.integration.ironchest.IronChestRecipeLoader;
import magicbook.gtlitecore.integration.littletiles.LittleTilesRecipeLoader;
import magicbook.gtlitecore.integration.naturescompass.NaturesCompassRecipeLoader;
import magicbook.gtlitecore.integration.packagedauto.PackagedAutoRecipeLoader;
import magicbook.gtlitecore.integration.snad.SnadRecipeLoader;
import magicbook.gtlitecore.integration.storagedrawers.StorageDrawersMiscRecipes;
import magicbook.gtlitecore.integration.supersoundmuffler.SuperSoundMufflerRecipeLoader;
import magicbook.gtlitecore.integration.theoneprobe.provider.RecipeFluidOutputInfoProvider;
import magicbook.gtlitecore.integration.theoneprobe.provider.RecipeItemOutputInfoProvider;
import magicbook.gtlitecore.integration.torchmaster.TorchMasterRecipeLoader;
import mcjty.theoneprobe.TheOneProbe;
import mcjty.theoneprobe.api.ITheOneProbe;

public class GTLiteIntegration {

    public static void onInit() {

        //  The One Probe Integration
        if (Mods.TheOneProbe.isModLoaded() && GTLiteConfigHolder.compats.enableTOPModule) {
                GTLiteLog.logger.info("Registering The One Probe Integration...");
                ITheOneProbe oneProbe = TheOneProbe.theOneProbeImp;
                oneProbe.registerProvider(new RecipeItemOutputInfoProvider());
                oneProbe.registerProvider(new RecipeFluidOutputInfoProvider());
        }
    }

    public static void registerRecipes() {

        //  Applied Energistics 2
        if (Mods.AppliedEnergistics2.isModLoaded()) {
            AE2RecipeLoader.init();
        }

        //  Architecture Craft
        if (Mods.ArchitectureCraft.isModLoaded()) {
            ArchitectureCraftRecipeLoader.init();
        }

        //  Chisel
        if (Mods.Chisel.isModLoaded() && GTLiteConfigHolder.compats.enableChiselModule) {
            ChiselMachineRecipeLoader.init();
            AutoChiselRecipeLoader.init();
        }

        if (Mods.Chisel.isModLoaded()) {
            ChiselMiscRecipes.init();
        }

        //  Ender Storage
        if (Mods.EnderStorage.isModLoaded()) {
            EnderStorageRecipeLoader.init();
        }

        //  Fluid Drawers
        if (Mods.FluidDrawers.isModLoaded()) {
            FluidDrawersRecipeLoader.init();
        }

        //  Future MC
        if (Mods.FutureMC.isModLoaded()) {
            FutureMCRecipeLoader.init();
        }

        //  GregTech
        if (Mods.GregTech.isModLoaded())
            CompatMaterialRecipeLoader.init(); // This class is recipes for Materials in {@link GTLiteModCompatibilityMaterials} class.

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

        //  Little Tiles
        if (Mods.LittleTiles.isModLoaded()) {
            LittleTilesRecipeLoader.init();
        }

        //  Natures Compass
        if (Mods.NaturesCompass.isModLoaded()) {
            NaturesCompassRecipeLoader.init();
        }

        //  Packaged Auto
        if (Mods.PackagedAuto.isModLoaded()) {
            PackagedAutoRecipeLoader.init();
        }

        //  Snad
        if (Mods.Snad.isModLoaded()) {
            SnadRecipeLoader.init();
        }

        //  Storage Drawers
        if (Mods.StorageDrawers.isModLoaded()) {
            StorageDrawersMiscRecipes.init();
        }

        //  Super Sound Muffler
        if (Mods.SuperSoundMuffler.isModLoaded()) {
            SuperSoundMufflerRecipeLoader.init();
        }

        //  Torch Master
        if (Mods.TorchMaster.isModLoaded()) {
            TorchMasterRecipeLoader.init();
        }
    }


    public GTLiteIntegration() {}
}
