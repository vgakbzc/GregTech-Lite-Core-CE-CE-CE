package magicbook.gtlitecore.loaders.multiblock;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Material;
import magicbook.gtlitecore.common.items.GTLiteMetaItems;
import net.minecraft.item.ItemStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix.singularity;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix.swarm;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class SuprachronalAssemblyLine {

    private static final Material[] tierList = {
            MarkerMaterials.Tier.ULV,
            MarkerMaterials.Tier.LV,
            MarkerMaterials.Tier.MV,
            MarkerMaterials.Tier.HV,
            MarkerMaterials.Tier.EV,
            MarkerMaterials.Tier.IV,
            MarkerMaterials.Tier.LuV,
            MarkerMaterials.Tier.ZPM,
            MarkerMaterials.Tier.UV,
            MarkerMaterials.Tier.UHV,
            MarkerMaterials.Tier.UEV,
            MarkerMaterials.Tier.UIV,
            MarkerMaterials.Tier.UXV,
            MarkerMaterials.Tier.OpV,
            MarkerMaterials.Tier.MAX
    };

    private static final ItemStack[] suprachronals = {
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_ULV.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_LV.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_MV.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_HV.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_EV.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_IV.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_LuV.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_ZPM.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_UV.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_UHV.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_UEV.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_UIV.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_UXV.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_OpV.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_MAX.getStackForm(),
    };

    public static void init() {

        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(singularity, Eternity)
                .output(swarm, Eternity, 64)
                .EUt(VA[OpV])
                .duration(1200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(MINING_DRONE_OpV)
                .input(swarm, Eternity, 4)
                .input(plate, CosmicFabric, 16)
                .input(circuit, MarkerMaterials.Tier.MAX, 8)
                .input(ELECTRIC_PUMP_OpV)
                .input(SENSOR_OpV)
                .input(ROBOT_ARM_OpV)
                .input(FIELD_GENERATOR_OpV)
                .input(ULTIMATE_BATTERY, 2)
                .fluidInputs(AstralTitanium.getFluid(L * 40))
                .fluidInputs(CelestialTungsten.getFluid(L * 40))
                .fluidInputs(Spacetime.getFluid(L * 4))
                .fluidInputs(Infinity.getFluid(L * 4))
                .output(HYPERDIMENSIONAL_DRONE)
                .EUt(VA[OpV])
                .duration(600)
                .stationResearch(b -> b
                        .researchStack(MINING_DRONE_OpV.getStackForm())
                        .EUt(VA[OpV])
                        .CWUt(576))
                .buildAndRegister();

        for (int tier = 0; tier < 15; tier ++) {
            SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(HYPERDIMENSIONAL_OSCILLATING_MATTER)
                    .notConsumable(HYPERDIMENSIONAL_DRONE)
                    .circuitMeta(tier)
                    .outputs(suprachronals[tier])
                    .duration(200)
                    .EUt(VA[tier])
                    .buildAndRegister();

            SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(HYPERDIMENSIONAL_OSCILLATING_MATTER)
                    .notConsumable(HYPERDIMENSIONAL_DRONE)
                    .circuitMeta(tier + 10)
                    .fluidInputs(Spacetime.getFluid(L))
                    .outputs(suprachronals[tier])
                    .duration(20)
                    .EUt(VA[tier])
                    .buildAndRegister();
        }
    }
}
