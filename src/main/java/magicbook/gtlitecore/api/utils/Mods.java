package magicbook.gtlitecore.api.utils;

import gregtech.api.util.ModIncompatibilityException;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.FMLLaunchHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Mods Interaction/Compability Warning utilities
 *
 * @author Magic_Sweepy
 *
 * <p>
 *     This class is a Mod Interaction utility class for GregTech Lite Modpack,
 *     it is different as the same name class in GregTech, for example,
 *     in GregTech, you should import the internal class {@code Names} to get {@code modid},
 *     and in this class, you can use the method {@link #getID()}.
 * </p>
 *
 * @since 2.8.8-beta
 */
@SuppressWarnings("unused")
public enum Mods {

    //  Sort By first letter (A to Z).

    ActuallyAdditions("actuallyadditions"),
    AppliedEnergistics2("appliedenergistics2"),
    ArchitectureCraft("architecturecraft"),

    Chisel("chisel"),
    ConnectedTexturesMod("ctm"),
    ContentTweaker("contenttweaker"),
    CraftingStation("craftingstation"),
    CraftTweaker("crafttweaker"),

    EnderCore("endercore"),
    EnderIO("enderio"),
    EnderIOEndergy("enderioendergy"),
    EnderIOMachines("enderiomachines"),
    EnderIOConduits("enderioconduits"),
    EnderIOAE2Conduits("enderioconduitsappliedenergistics"),
    EnderStorage("enderstorage"),
    EnderUtilities("enderutilities"),
    /**
     * TODO Add {@link #extraCheck} to hint player this mod is incompat,
     *      because {@code epcore} (1.12.2) is a longterm unmaintained mod,
     *      this mod is also my mod (I am one of authors).
     */
    EpimorphismCore("epcore"),
    ExtendedAE("extendedae"),
    ExtraUtilities2("extrautils2"),

    FluidDrawers("fluiddrawers"),
    FutureMC("futuremc"),

    GregTech("gregtech"),
    GregTechLiteCore("gtlitecore"),
    GregTechFoodOption("gregtechfoodoption"),
    GregicalityMultiblocks("gcym"),
    /**
     * TODO Add {@link #extraCheck} to hint player this mod is incompat,
     *      because {@code gtlitecore} is inheritor of {@code gcys},
     *      and {@code gtlitecore} use the same Mod Name of {@code gcys}.
     */
    GregicalityScience("gcys"),
    GroovyScript("groovyscript"),

    IronChest("ironchest"),

    JustEnoughItems("jei"),

    LazyAE2("threng"),
    LittleTiles("littletiles"),

    NaturesCompass("naturescompass"),
    /**
     * TODO Add {@link #extraCheck} to hint player this mod is incompat,
     *      because in GregTech Lite Modpack, this mod use special version,
     *      called by {@code nae2-gtlite-edition}. We should hint player
     *      do not use common version to change this Mod.
     */
    NeevesAE2Addition("nae2"),

    PackagedAuto("packagedauto"),

    Snad("snad"),
    StorageDrawers("storagedrawers"),
    SuperSoundMuffler("supersoundmuffler"),

    TheOneProbe("theoneprobe"),
    TOPAddons("topaddons"),
    TorchMaster("torchmaster");

    private final String ID;
    private final Function<Mods, Boolean> extraCheck;
    private Boolean modLoaded;

    /**
     * @param ID  Mod ID.
     */
    Mods(String ID) {
        this.ID =ID;
        this.extraCheck = null;
    }

    /**
     * Mods with Extra Check.
     *
     * <p>
     *     A basic example of {@link #extraCheck}: checking if a mod is at a specific version,
     *     or a sub-mod is loaded, we can used in cases like NC v.s. NCO,
     *     where {@link #ID} is the same. So the version has to be parsed to test which is loaded.
     *     Another case is checking for specific Forestry modules, checking if Forestry is loaded
     *     and if a specific module is enabled.
     * </p>
     *
     * @param ID          Mod ID.
     * @param extraCheck  A supplier that can be used to test additional factors.
     */
    Mods(String ID, Function<Mods, Boolean> extraCheck) {
        this.ID = ID;
        this.extraCheck = extraCheck;
    }

    /**
     * Get Mod ID by Mod ({@link #ID} Getter).
     *
     * @return  Mod ID.
     */
    public String getID() {
        return this.ID;
    }

    /**
     * Check if Mod with given {@link #ID} is loaded.
     *
     * @return  If Mod is loaded then return true, else return false.
     */
    public boolean isModLoaded() {
        //  Assign all Mod in this class a {@link modLoaded} parameter.
        if (this.modLoaded == null) {
            this.modLoaded = Loader.isModLoaded(this.ID);
            if (this.modLoaded) {
                //  If Mod has {@link extraCheck}, and it is not meeting the conditions,
                //  then return false (this is also a extended predicate condiction).
                if (this.extraCheck != null && !this.extraCheck.apply(this)) {
                    this.modLoaded = false;
                }
            }
        }
        return this.modLoaded;
    }

    /**
     * Used to throw an exception if this Mod is found to be loaded.
     *
     * <p>
     *     <strong>This must be called in or after {@link FMLPreInitializationEvent}!</strong>
     * </p>
     *
     * @param customMessages  Exception Messages.
     */
    public void throwIncompatibilityIfLoaded(String... customMessages) {
        if (this.isModLoaded()) {
            String modName = TextFormatting.BOLD + this.ID + TextFormatting.RESET;
            List<String> messages = new ArrayList<>();

            messages.add(modName + " mod detected, this mod is in compatible with GregTech Lite Core.");
            messages.addAll(Arrays.asList(customMessages));

            if (FMLLaunchHandler.side() == Side.SERVER) {
                throw new RuntimeException(String.join(",", messages));
            } else {
                throwClientIncompatibilityException(messages);
            }
        }
    }

    /**
     * Throw a Client-only Incompability Exception.
     *
     * @param messages  Exception message.
     *
     * @see ModIncompatibilityException
     */
    @SideOnly(Side.CLIENT)
    private static void throwClientIncompatibilityException(List<String> messages) {
        throw new ModIncompatibilityException(messages);
    }

    //  Helpers for the extra checker

    /**
     * Test if the mod version string contains the passed value.
     *
     * @param versionPart  Version Part.
     */
    private static Function<Mods, Boolean> versionContains(String versionPart) {
        return mod -> {
            //  If Mod ID is null, then return false.
            if (mod.ID == null)
                return false;
            //  If mod is not be loaded, then return false.
            if (!mod.isModLoaded())
                return false;
            //  Get Mod Container by Mod ID.
            ModContainer container = Loader.instance().getIndexedModList().get(mod.ID);
            //  If Mod Container is null, then return false.
            if (container == null)
                return false;
            //  Get Mod version by Mod Container.
            return container.getVersion().contains(versionPart);
        };
    }

    /**
     * Test if the mod version string does not contain the passed value.
     *
     * @param versionPart  Version Part.
     */
    private static Function<Mods, Boolean> versionExcludes(String versionPart) {
        return mod -> {
            //  If Mod ID is null, then return false.
            if (mod.ID == null)
                return false;
            //  If mod is not be loaded, then return false.
            if (!mod.isModLoaded())
                return false;
            //  Get Mod Container by Mod ID.
            ModContainer container = Loader.instance().getIndexedModList().get(mod.ID);
            //  If Mod Container is null, then return false.
            if (container == null)
                return false;
            //  Get Mod version by Mod Container.
            return !container.getVersion().contains(versionPart);
        };
    }

}
