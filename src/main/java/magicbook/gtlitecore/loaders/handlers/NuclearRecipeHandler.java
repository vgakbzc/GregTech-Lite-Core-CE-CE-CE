package magicbook.gtlitecore.loaders.handlers;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.IngotProperty;
import gregtech.api.unification.ore.OrePrefix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static gregtech.api.unification.material.Materials.*;

public class NuclearRecipeHandler {

    //  Hash Map: (Material, Complexity)
    private static final Map<Material, Integer> radioactiveMaterials = new HashMap<>();

    private static final List<Material> radioMaterialOxides = new ArrayList<>();
    private static final List<Material> radioMaterialNitrates = new ArrayList<>();
    private static final List<Material> radioMaterialHexachlorides = new ArrayList<>();
    private static final List<Material> radioMaterialHexafluorides = new ArrayList<>();

    public static void register() {
    }

    private static void processNuclearMaterial(OrePrefix ingotPrefix, Material material, IngotProperty property) {


    }
}
