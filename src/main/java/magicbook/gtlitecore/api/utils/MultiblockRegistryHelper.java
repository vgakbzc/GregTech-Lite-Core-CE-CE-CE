package magicbook.gtlitecore.api.utils;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import magicbook.gtlitecore.api.metatileentity.single.SimpleSteamMetaTileEntity;
import magicbook.gtlitecore.api.metatileentity.single.SteamProgressIndicator;
import magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps;
import magicbook.gtlitecore.client.renderer.texture.GTLiteTextures;

import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;
import static magicbook.gtlitecore.api.utils.GTLiteUtility.gtliteId;

public class MultiblockRegistryHelper {

    //  TODO Add these parameters to Configuration, used to make MTE registrer dynamically generated ID.
    //       Maybe a good method to resolved MTE ID conflicts when mod is loaded on some special situation.
    private static final int MTE_REGISTRY_ID = 14000;
    private static final int MTE_REGISTRY_ID_RANGE = 2000;
    private static final int MTE_REGISTRY_ID_TOTAL = MTE_REGISTRY_ID + MTE_REGISTRY_ID_RANGE;
    public static final int TE_REGISTRY_ID = MTE_REGISTRY_ID + MTE_REGISTRY_ID_RANGE / 2;

    /**
     * Register a Steam machine and its correspondence High Pressure Steam machine.
     *
     * <p>
     *     Please see {@link SimpleSteamMetaTileEntity}, this method is packaged of this class,
     *     and used for init some basic steam machines, like Steam Vacuum Chamber.
     * </p>
     *
     * @param machines           Steam {@code MetaTileEntity} machine.
     * @param startId            Start ID of Machine, each machine use two ID (use the first ID you wanted),
     *                           this method will generated Steam and High Hressure Steam two version of your machine.
     * @param name               Unlocalized Name, use {@code bronze} and {@code steel} as suffix auto,
     *                           two suffixes correspondence to two version of your machine (Steam and High Pressure Steam).
     * @param recipeMap          Machine {@code RecipeMap}, you can use {@code RecipeMap} in {@link GTLiteRecipeMaps} or {@link RecipeMaps},
     *                           or another {@code RecipeMap} class in other addition mods.
     * @param progressIndicator  Progress Bar Indicator, this parameter is not same as progress bar in {@link Textures},
     *                           please see {@link SteamProgressIndicator}.
     * @param texture            Overlay textures, please use textures in {@link GTLiteTextures} or {@link Textures},
     *                           or another {@code Texture} class in other addition mods.
     * @param isBricked          Extended texture of machine, if {@code isBricked} is true, then add bricked texture on side and front,
     *                           please see: {@link Textures#STEAM_BRICKED_CASING_BRONZE} and {@link Textures#STEAM_BRICKED_CASING_STEEL}.
     *
     */
    public static void registerSimpleSteamMetaTileEntity(SimpleSteamMetaTileEntity[] machines,
                                                          int startId,
                                                          String name,
                                                          RecipeMap<?> recipeMap,
                                                          SteamProgressIndicator progressIndicator,
                                                          ICubeRenderer texture,
                                                          boolean isBricked) {
        machines[0] = registerMetaTileEntity(startId, new SimpleSteamMetaTileEntity(gtliteId(String.format("%s.bronze", name)), recipeMap, progressIndicator, texture, isBricked, false));
        machines[1] = registerMetaTileEntity(startId + 1, new SimpleSteamMetaTileEntity(gtliteId(String.format("%s.steel", name)), recipeMap, progressIndicator, texture, isBricked, true));
    }

    /**
     * Register a Multiblock Part of {@code MetaTileEntity}.
     *
     * @param id   ID of Multiblock Part.
     * @param mte  {@code MetaTileEntity}, should use your Multiblock Part class.
     */
    public static <F extends MetaTileEntity> F registerPartMetaTileEntity(int id, F mte) {
        if (id > 1000)
            return null;
        return registerMetaTileEntity(id + MTE_REGISTRY_ID, mte);
    }

    /**
     * Register a {@code MetaTileEntity} machine.
     *
     * @param id   ID of {@code MetaTileEntity} machine.
     * @param mte  {@code MetaTileEntity}, should use your {@code MetaTileEntity} class.
     */
    public static <T extends MultiblockControllerBase> T registerMultiMetaTileEntity(int id, T mte) {
        return registerMetaTileEntity(id + MTE_REGISTRY_ID_TOTAL, mte);
    }
}
