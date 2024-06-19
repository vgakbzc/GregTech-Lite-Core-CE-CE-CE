package magicbook.gtlitecore.loaders.multiblock;

import gregtech.api.unification.material.MarkerMaterials;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.PACKER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.COMPONENT_ASSEMBLY_LINE_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;
import static net.minecraft.init.Items.*;

public class ComponentAssemblyLine {

    public static void init() {
        Motor();
        Piston();
        Conveyor();
        Pump();
        RobotArm();
        Emitter();
        Sensor();
        FieldGen();
        WrapItems();
    }

    private static void Motor() {

        //  ULV (15s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(pipeTinyFluid, Bronze, 64)
                .input(pipeTinyFluid, Bronze, 64)
                .input(stickLong, WroughtIron, 64)
                .input(stickLong, IronMagnetic, 32)
                .input(wireGtHex, Lead, 16)
                .output(ELECTRIC_MOTOR_ULV, 64)
                .EUt(VA[ULV])
                .duration(300)
                .tier(LV)
                .buildAndRegister();

        //  LV (15s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(cableGtHex, Tin, 8)
                .input(stickLong, Iron, 64)
                .input(stickLong, IronMagnetic, 32)
                .input(wireGtHex, Copper, 16)
                .output(ELECTRIC_MOTOR_LV, 64)
                .EUt(VA[LV])
                .duration(300)
                .tier(LV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(cableGtHex, Tin, 8)
                .input(stickLong, Steel, 64)
                .input(stickLong, SteelMagnetic, 32)
                .input(wireGtHex, Copper, 16)
                .output(ELECTRIC_MOTOR_LV, 64)
                .EUt(VA[LV])
                .duration(300)
                .tier(LV)
                .buildAndRegister();

        //  MV (30s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(cableGtHex, Copper, 8)
                .input(stickLong, Aluminium, 64)
                .input(stickLong, SteelMagnetic, 32)
                .input(wireGtHex, Cupronickel, 32)
                .output(ELECTRIC_MOTOR_MV, 64)
                .EUt(VA[MV])
                .duration(600)
                .tier(MV)
                .buildAndRegister();

        //  HV (30s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(cableGtHex, Silver, 16)
                .input(stickLong, StainlessSteel, 64)
                .input(stickLong, SteelMagnetic, 32)
                .input(wireGtHex, Electrum, 32)
                .output(ELECTRIC_MOTOR_HV, 64)
                .EUt(VA[HV])
                .duration(600)
                .tier(HV)
                .buildAndRegister();

        //  EV (45s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(cableGtHex, Aluminium, 16)
                .input(stickLong, Titanium, 64)
                .input(stickLong, NeodymiumMagnetic, 32)
                .input(wireGtHex, Kanthal, 32)
                .output(ELECTRIC_MOTOR_EV, 64)
                .EUt(VA[EV])
                .duration(900)
                .tier(EV)
                .buildAndRegister();

        //  IV (45s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(cableGtHex, Tungsten, 16)
                .input(stickLong, TungstenSteel, 64)
                .input(stickLong, NeodymiumMagnetic, 32)
                .input(wireGtHex, Graphene, 32)
                .output(ELECTRIC_MOTOR_IV, 64)
                .EUt(VA[IV])
                .duration(900)
                .tier(IV)
                .buildAndRegister();

        //  LuV (60s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(stickLong, SamariumMagnetic, 64)
                .input(stickLong, HSSS, 64)
                .input(stickLong, HSSS, 64)
                .input(cableGtHex, NiobiumTitanium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 64))
                .fluidInputs(Lubricant.getFluid(16000))
                .fluidInputs(HSSS.getFluid(8704))
                .fluidInputs(Ruridit.getFluid(L * 8 * 64))
                .output(ELECTRIC_MOTOR_LuV, 64)
                .EUt(VA[LuV])
                .duration(1200)
                .tier(LuV)
                .buildAndRegister();

        //  ZPM (60s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(stickLong, SamariumMagnetic, 64)
                .input(stickLong, Osmiridium, 64)
                .input(stickLong, Osmiridium, 64)
                .input(stickLong, Osmiridium, 64)
                .input(stickLong, Osmiridium, 64)
                .input(cableGtHex, VanadiumGallium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 2 * 64))
                .fluidInputs(Lubricant.getFluid(32000))
                .fluidInputs(Osmiridium.getFluid(17408))
                .fluidInputs(Europium.getFluid(L * 12 * 64))
                .output(ELECTRIC_MOTOR_ZPM, 64)
                .EUt(VA[ZPM])
                .duration(1200)
                .tier(ZPM)
                .buildAndRegister();

        //  UV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(stickLong, SamariumMagnetic, 64)
                .input(stickLong, Tritanium, 64)
                .input(stickLong, Tritanium, 64)
                .input(stickLong, Tritanium, 64)
                .input(stickLong, Tritanium, 64)
                .input(cableGtHex, YttriumBariumCuprate, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 4 * 64))
                .fluidInputs(Lubricant.getFluid(64000))
                .fluidInputs(Naquadria.getFluid(L * 4 * 64))
                .fluidInputs(Tritanium.getFluid(17408))
                .fluidInputs(Americium.getFluid(L * 16 * 64))
                .output(ELECTRIC_MOTOR_UV, 64)
                .EUt(VA[UV])
                .duration(1500)
                .tier(UV)
                .buildAndRegister();

        //  UHV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(stickLong, ChromiumGermaniumTellurideMagnetic, 64)
                .input(stickLong, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(cableGtHex, Europium, 8) // cable
                .fluidInputs(SolderingAlloy.getFluid(L * 8 * 64))
                .fluidInputs(Lubricant.getFluid(192000))
                .fluidInputs(Vibranium.getFluid(L * 64))
                .fluidInputs(Adamantium.getFluid(17408))
                .fluidInputs(SiliconCarbide.getFluid(L * 16 * 64))
                .output(ELECTRIC_MOTOR_UHV, 64)
                .EUt(VA[UHV])
                .duration(1500)
                .tier(UHV)
                .buildAndRegister();

        //  UEV (90s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(stickLong, ChromiumGermaniumTellurideMagnetic, 64)
                .input(stickLong, Hdcs, 64)
                .input(stickLong, Hdcs, 64)
                .input(stickLong, Hdcs, 64)
                .input(stickLong, Hdcs, 64)
                .input(cableGtHex, PedotTMA, 8) // cable
                .fluidInputs(SolderingAlloy.getFluid(L * 16 * 64))
                .fluidInputs(Lubricant.getFluid(320000))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2 * 64))
                .fluidInputs(Ichorium.getFluid(L * 64))
                .fluidInputs(Hdcs.getFluid(17408))
                .fluidInputs(Seaborgium.getFluid(L * 16 * 64))
                .output(ELECTRIC_MOTOR_UEV, 64)
                .EUt(VA[UEV])
                .duration(1800)
                .tier(UEV)
                .buildAndRegister();

        //  UIV (90s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(stickLong, PhosphorusDopedEuropiumIronArsenideMagnetic, 64)
                .input(stickLong, Legendarium, 64)
                .input(stickLong, Legendarium, 64)
                .input(stickLong, Legendarium, 64)
                .input(stickLong, Legendarium, 64)
                .input(cableGtHex, Solarium, 8) // cable
                .fluidInputs(SolderingAlloy.getFluid(L * 32 * 64))
                .fluidInputs(Lubricant.getFluid(448000))
                .fluidInputs(Zylon.getFluid(L * 4 * 64))
                .fluidInputs(Astralium.getFluid(L * 2 * 64))
                .fluidInputs(Legendarium.getFluid(17408))
                .fluidInputs(Abyssalloy.getFluid(L * 16 * 64))
                .output(ELECTRIC_MOTOR_UIV, 64)
                .EUt(VA[UIV])
                .duration(1800)
                .tier(UIV)
                .buildAndRegister();

        //  UXV (105s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(stickLong, PhosphorusDopedEuropiumIronArsenideMagnetic, 64)
                .input(stickLong, MagnetoHydrodynamicallyConstrainedStarMatter, 64)
                .input(stickLong, MagnetoHydrodynamicallyConstrainedStarMatter, 64)
                .input(stickLong, MagnetoHydrodynamicallyConstrainedStarMatter, 64)
                .input(stickLong, MagnetoHydrodynamicallyConstrainedStarMatter, 64)
                .input(cableGtHex, Hypogen, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 64 * 64))
                .fluidInputs(Lubricant.getFluid(576000))
                .fluidInputs(FullerenePolymerMatrix.getFluid(L * 8 * 64))
                .fluidInputs(Hikarium.getFluid(L * 4 * 64))
                .fluidInputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(17408))
                .fluidInputs(BlackDwarfMatter.getFluid(L * 16 * 64))
                .output(ELECTRIC_MOTOR_UXV, 64)
                .EUt(VA[UXV])
                .duration(2100)
                .tier(UXV)
                .buildAndRegister();

        //  OpV (105s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(stickLong, BismuthLawrenciumStrontiumCuprateMagnetic, 64)
                .input(stickLong, TranscendentMetal, 64)
                .input(stickLong, TranscendentMetal, 64)
                .input(stickLong, TranscendentMetal, 64)
                .input(stickLong, TranscendentMetal, 64)
                .input(cableGtHex, Galaxium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 128 * 64))
                .fluidInputs(Lubricant.getFluid(704000))
                .fluidInputs(CosmicFabric.getFluid(L * 16 * 64))
                .fluidInputs(Arcanium.getFluid(L * 8 * 64))
                .fluidInputs(TranscendentMetal.getFluid(17408))
                .fluidInputs(Shirabon.getFluid(L * 16 * 64))
                .output(ELECTRIC_MOTOR_OpV, 64)
                .EUt(VA[OpV])
                .duration(2100)
                .tier(OpV)
                .buildAndRegister();

        //  MAX (120s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(stickLong, BismuthLawrenciumStrontiumCuprateMagnetic, 64)
                .input(stickLong, Omnium, 64)
                .input(stickLong, Omnium, 64)
                .input(stickLong, Omnium, 64)
                .input(stickLong, Omnium, 64)
                .input(cableGtHex, Universium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 256 * 64))
                .fluidInputs(Lubricant.getFluid(13000 * 64))
                .fluidInputs(SpacetimeContinuum.getFluid(L * 32 * 64))
                .fluidInputs(PrimordialMatter.getFluid(L * 16 * 64))
                .fluidInputs(Omnium.getFluid(17408))
                .fluidInputs(Magmatter.getFluid(L * 16 * 64))
                .output(ELECTRIC_MOTOR_MAX, 64)
                .EUt(VA[MAX])
                .duration(2400)
                .tier(MAX)
                .buildAndRegister();
    }

    private static void Piston() {

        //  ULV (15s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(stickLong, WroughtIron, 64)
                .input(pipeTinyFluid, Bronze, 64)
                .input(pipeTinyFluid, Bronze, 64)
                .input(plateDouble, WroughtIron, 64)
                .input(plateDouble, WroughtIron, 32)
                .input(gearSmall, WroughtIron, 64)
                .input(ELECTRIC_MOTOR_ULV, 64)
                .output(ELECTRIC_PISTON_ULV, 64)
                .EUt(VA[ULV])
                .duration(300)
                .tier(LV)
                .buildAndRegister();

        //  LV (15s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(stickLong, Steel, 64)
                .input(cableGtHex, Tin, 8)
                .input(plateDouble, Steel, 64)
                .input(plateDouble, Steel, 32)
                .input(gearSmall, Steel, 64)
                .input(ELECTRIC_MOTOR_LV, 64)
                .output(ELECTRIC_PISTON_LV, 64)
                .EUt(VA[LV])
                .duration(300)
                .tier(LV)
                .buildAndRegister();

        //  MV (30s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(stickLong, Aluminium, 64)
                .input(cableGtHex, Copper, 8)
                .input(plateDouble, Aluminium, 64)
                .input(plateDouble, Aluminium, 32)
                .input(gearSmall, Aluminium, 64)
                .input(ELECTRIC_MOTOR_MV, 64)
                .output(ELECTRIC_PISTON_MV, 64)
                .EUt(VA[MV])
                .duration(600)
                .tier(MV)
                .buildAndRegister();

        //  HV (30s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(stickLong, StainlessSteel, 64)
                .input(cableGtHex, Gold, 8)
                .input(plateDouble, StainlessSteel, 64)
                .input(plateDouble, StainlessSteel, 32)
                .input(gearSmall, StainlessSteel, 64)
                .input(ELECTRIC_MOTOR_HV, 64)
                .output(ELECTRIC_PISTON_HV, 64)
                .EUt(VA[HV])
                .duration(600)
                .tier(HV)
                .buildAndRegister();

        //  EV (45s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(stickLong, Titanium, 64)
                .input(cableGtHex, Aluminium, 8)
                .input(plateDouble, Titanium, 64)
                .input(plateDouble, Titanium, 32)
                .input(gearSmall, Titanium, 64)
                .input(ELECTRIC_MOTOR_EV, 64)
                .output(ELECTRIC_PISTON_EV, 64)
                .EUt(VA[EV])
                .duration(900)
                .tier(EV)
                .buildAndRegister();

        //  IV (45s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(stickLong, TungstenSteel, 64)
                .input(cableGtHex, Tungsten, 8)
                .input(plateDouble, TungstenSteel, 64)
                .input(plateDouble, TungstenSteel, 32)
                .input(gearSmall, TungstenSteel, 64)
                .input(ELECTRIC_MOTOR_IV, 64)
                .output(ELECTRIC_PISTON_IV, 64)
                .EUt(VA[IV])
                .duration(900)
                .tier(IV)
                .buildAndRegister();

        //  LuV (60s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(ELECTRIC_MOTOR_LuV, 64)
                .input(plateDouble, HSSS, 64)
                .input(plateDouble, HSSS, 64)
                .input(stickLong, HSSS, 64)
                .input(stickLong, HSSS, 64)
                .input(cableGtHex, NiobiumTitanium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 64))
                .fluidInputs(Lubricant.getFluid(16000))
                .fluidInputs(HSSS.getFluid(80896))
                .output(ELECTRIC_PISTON_LUV, 64)
                .EUt(VA[LuV])
                .duration(1200)
                .tier(LuV)
                .buildAndRegister();

        //  ZPM (60s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(ELECTRIC_MOTOR_ZPM, 64)
                .input(plateDouble, Osmiridium, 64)
                .input(plateDouble, Osmiridium, 64)
                .input(stickLong, Osmiridium, 64)
                .input(stickLong, Osmiridium, 64)
                .input(cableGtHex, VanadiumGallium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 2 * 64))
                .fluidInputs(Lubricant.getFluid(32000))
                .fluidInputs(Osmiridium.getFluid(80896))
                .output(ELECTRIC_PISTON_ZPM, 64)
                .EUt(VA[ZPM])
                .duration(1200)
                .tier(ZPM)
                .buildAndRegister();

        //  UV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(ELECTRIC_MOTOR_UV, 64)
                .input(plateDouble, Tritanium, 64) // plate
                .input(plateDouble, Tritanium, 64)
                .input(stickLong, Tritanium, 64) // stick
                .input(stickLong, Tritanium, 64)
                .input(cableGtHex, YttriumBariumCuprate, 8) // cable
                .fluidInputs(SolderingAlloy.getFluid(L * 4 * 64))
                .fluidInputs(Lubricant.getFluid(64000))
                .fluidInputs(Naquadria.getFluid(L * 4 * 64))
                .fluidInputs(Tritanium.getFluid(25600))
                .fluidInputs(NaquadahAlloy.getFluid(L * 4 * 64 + L * 2 * 64))
                .output(ELECTRIC_PISTON_UV, 64)
                .EUt(VA[UV])
                .duration(1500)
                .tier(UV)
                .buildAndRegister();

        //  UHV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(ELECTRIC_MOTOR_UHV, 64)
                .input(plateDouble, Adamantium, 64)
                .input(plateDouble, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(cableGtHex, Europium, 8) // cable
                .fluidInputs(SolderingAlloy.getFluid(L * 8 * 64))
                .fluidInputs(Lubricant.getFluid(192000))
                .fluidInputs(Vibranium.getFluid(L * 64))
                .fluidInputs(Adamantium.getFluid(25600))
                .fluidInputs(Orichalcum.getFluid(L * 4 * 64 + L * 2 * 64)) // gear + small gear
                .output(ELECTRIC_PISTON_UHV, 64)
                .EUt(VA[UHV])
                .duration(1500)
                .tier(UHV)
                .buildAndRegister();

        //  UEV (90s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(ELECTRIC_MOTOR_UEV, 64)
                .input(plateDouble, Hdcs, 64)
                .input(plateDouble, Hdcs, 64)
                .input(stickLong, Hdcs, 64)
                .input(stickLong, Hdcs, 64)
                .input(cableGtHex, PedotTMA, 8) // cable
                .fluidInputs(SolderingAlloy.getFluid(L * 16 * 64))
                .fluidInputs(Lubricant.getFluid(320000))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2 * 64))
                .fluidInputs(Ichorium.getFluid(L * 64))
                .fluidInputs(Hdcs.getFluid(25600))
                .fluidInputs(Adamantium.getFluid(L * 4 * 64 + L * 2 * 64)) // gear + small gear
                .output(ELECTRIC_PISTON_UEV, 64)
                .EUt(VA[UEV])
                .duration(1800)
                .tier(UEV)
                .buildAndRegister();

        //  UIV (90s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(ELECTRIC_MOTOR_UIV, 64)
                .input(plateDouble, Legendarium, 64)
                .input(plateDouble, Legendarium, 64)
                .input(stickLong, Legendarium, 64)
                .input(stickLong, Legendarium, 64)
                .input(cableGtHex, Solarium, 8) // cable
                .fluidInputs(SolderingAlloy.getFluid(L * 32 * 64))
                .fluidInputs(Lubricant.getFluid(448000))
                .fluidInputs(Zylon.getFluid(L * 4 * 64))
                .fluidInputs(Astralium.getFluid(L * 2 * 64))
                .fluidInputs(Legendarium.getFluid(25600))
                .fluidInputs(Infinity.getFluid(L * 4 * 64 + L * 2 * 64))
                .output(ELECTRIC_PISTON_UIV, 64)
                .EUt(VA[UIV])
                .duration(1800)
                .tier(UIV)
                .buildAndRegister();

        //  UXV (105s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(ELECTRIC_MOTOR_UXV, 64)
                .input(plateDouble, MagnetoHydrodynamicallyConstrainedStarMatter, 64) // plate
                .input(plateDouble, MagnetoHydrodynamicallyConstrainedStarMatter, 64)
                .input(stickLong, MagnetoHydrodynamicallyConstrainedStarMatter, 64)
                .input(stickLong, MagnetoHydrodynamicallyConstrainedStarMatter, 64)
                .input(cableGtHex, Hypogen, 8) // cable
                .fluidInputs(SolderingAlloy.getFluid(L * 64 * 64))
                .fluidInputs(Lubricant.getFluid(576000))
                .fluidInputs(FullerenePolymerMatrix.getFluid(L * 8 * 64))
                .fluidInputs(Hikarium.getFluid(L * 4 * 64))
                .fluidInputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(25600))
                .fluidInputs(CosmicNeutronium.getFluid(L * 4 * 64 + L * 2 * 64)) // gear + small gear
                .output(ELECTRIC_PISTON_UXV, 64)
                .EUt(VA[UXV])
                .duration(2100)
                .tier(UXV)
                .buildAndRegister();

        //  OpV (105s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(ELECTRIC_MOTOR_OpV, 64)
                .input(plateDouble, TranscendentMetal, 64) // plate
                .input(plateDouble, TranscendentMetal, 64)
                .input(stickLong, TranscendentMetal, 64)
                .input(stickLong, TranscendentMetal, 64)
                .input(cableGtHex, Galaxium, 8) // cable
                .fluidInputs(SolderingAlloy.getFluid(L * 128 * 64))
                .fluidInputs(Lubricant.getFluid(704000))
                .fluidInputs(CosmicFabric.getFluid(L * 16 * 64))
                .fluidInputs(Arcanium.getFluid(L * 8 * 64))
                .fluidInputs(TranscendentMetal.getFluid(25600))
                .fluidInputs(Spacetime.getFluid(L * 4 * 64 + L * 2 * 64)) // gear + small gear
                .output(ELECTRIC_PISTON_OpV, 64)
                .EUt(VA[OpV])
                .duration(2100)
                .tier(OpV)
                .buildAndRegister();

        //  MAX (120s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(ELECTRIC_MOTOR_MAX, 64)
                .input(plateDouble, Omnium, 64)
                .input(plateDouble, Omnium, 64)
                .input(stickLong, Omnium, 64)
                .input(stickLong, Omnium, 64)
                .input(cableGtHex, Universium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 256 * 64))
                .fluidInputs(Lubricant.getFluid(13000 * 64))
                .fluidInputs(SpacetimeContinuum.getFluid(L * 32 * 64))
                .fluidInputs(PrimordialMatter.getFluid(L * 16 * 64))
                .fluidInputs(Omnium.getFluid(25600))
                .fluidInputs(Eternity.getFluid(L * 4 * 64 + L * 2 * 64))
                .output(ELECTRIC_PISTON_MAX, 64)
                .EUt(VA[MAX])
                .duration(2400)
                .tier(MAX)
                .buildAndRegister();
    }

    private static void Conveyor() {

        //  ULV (15s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .input(pipeTinyFluid, Bronze, 64)
                .input(ELECTRIC_MOTOR_ULV, 64)
                .input(ELECTRIC_MOTOR_ULV, 64)
                .input("wool", 64)
                .input("wool", 64)
                .input("wool", 64)
                .input("wool", 64)
                .input("wool", 64)
                .input("wool", 64)
                .output(CONVEYOR_MODULE_ULV, 64)
                .EUt(VA[ULV])
                .duration(300)
                .tier(LV)
                .buildAndRegister();

        for (FluidStack stack : new FluidStack[]{
                Rubber.getFluid(L * 6 * 64),
                SiliconeRubber.getFluid(L * 6 * 64),
                StyreneButadieneRubber.getFluid(L * 6 * 64),
                NitrileButadieneRubber.getFluid(L * 6 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 6 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(3)
                    .input(pipeTinyFluid, Bronze, 64)
                    .input(ELECTRIC_MOTOR_ULV, 64)
                    .input(ELECTRIC_MOTOR_ULV, 64)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_ULV, 64)
                    .EUt(VA[ULV])
                    .duration(300)
                    .tier(LV)
                    .buildAndRegister();
        }

        //  LV (15s)
        for (FluidStack stack : new FluidStack[]{
                Rubber.getFluid(L * 6 * 64),
                SiliconeRubber.getFluid(L * 6 * 64),
                StyreneButadieneRubber.getFluid(L * 6 * 64),
                NitrileButadieneRubber.getFluid(L * 6 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 6 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(3)
                    .input(cableGtHex, Tin, 4)
                    .input(ELECTRIC_MOTOR_LV, 64)
                    .input(ELECTRIC_MOTOR_LV, 64)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_LV, 64)
                    .EUt(VA[LV])
                    .duration(300)
                    .tier(LV)
                    .buildAndRegister();
        }

        //  MV (30s)
        for (FluidStack stack : new FluidStack[]{
                Rubber.getFluid(L * 6 * 64),
                SiliconeRubber.getFluid(L * 6 * 64),
                StyreneButadieneRubber.getFluid(L * 6 * 64),
                NitrileButadieneRubber.getFluid(L * 6 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 6 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(3)
                    .input(cableGtHex, Copper, 4)
                    .input(ELECTRIC_MOTOR_MV, 64)
                    .input(ELECTRIC_MOTOR_MV, 64)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_MV, 64)
                    .EUt(VA[MV])
                    .duration(600)
                    .tier(MV)
                    .buildAndRegister();
        }

        //  HV (30s)
        for (FluidStack stack : new FluidStack[]{
                Rubber.getFluid(L * 6 * 64),
                SiliconeRubber.getFluid(L * 6 * 64),
                StyreneButadieneRubber.getFluid(L * 6 * 64),
                NitrileButadieneRubber.getFluid(L * 6 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 6 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(3)
                    .input(cableGtHex, Gold, 4)
                    .input(ELECTRIC_MOTOR_HV, 64)
                    .input(ELECTRIC_MOTOR_HV, 64)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_HV, 64)
                    .EUt(VA[HV])
                    .duration(600)
                    .tier(HV)
                    .buildAndRegister();
        }

        //  EV (45s)
        for (FluidStack stack : new FluidStack[]{
                Rubber.getFluid(L * 6 * 64),
                SiliconeRubber.getFluid(L * 6 * 64),
                StyreneButadieneRubber.getFluid(L * 6 * 64),
                NitrileButadieneRubber.getFluid(L * 6 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 6 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(3)
                    .input(cableGtHex, Aluminium, 4)
                    .input(ELECTRIC_MOTOR_EV, 64)
                    .input(ELECTRIC_MOTOR_EV, 64)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_EV, 64)
                    .EUt(VA[EV])
                    .duration(900)
                    .tier(EV)
                    .buildAndRegister();
        }

        //  IV (45s)
        for (FluidStack stack : new FluidStack[]{
                SiliconeRubber.getFluid(L * 6 * 64),
                StyreneButadieneRubber.getFluid(L * 6 * 64),
                NitrileButadieneRubber.getFluid(L * 6 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 6 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(3)
                    .input(cableGtHex, Tungsten, 4)
                    .input(ELECTRIC_MOTOR_IV, 64)
                    .input(ELECTRIC_MOTOR_IV, 64)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_IV, 64)
                    .EUt(VA[IV])
                    .duration(900)
                    .tier(IV)
                    .buildAndRegister();
        }

        //  LuV (60s)
        for (FluidStack stack : new FluidStack[]{
                StyreneButadieneRubber.getFluid(L * 8 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 8 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(3)
                    .input(ELECTRIC_MOTOR_LuV, 64)
                    .input(ELECTRIC_MOTOR_LuV, 64)
                    .input(plateDouble, HSSS, 64)
                    .input(stickLong, HSSS, 32)
                    .input(cableGtHex, NiobiumTitanium, 8)
                    .fluidInputs(SolderingAlloy.getFluid(L * 64))
                    .fluidInputs(Lubricant.getFluid(16000))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidInputs(HSSS.getFluid(25600))
                    .output(CONVEYOR_MODULE_LuV, 64)
                    .EUt(VA[LuV])
                    .duration(1200)
                    .tier(LuV)
                    .buildAndRegister();
        }

        //  ZPM (60s)
        for (FluidStack stack : new FluidStack[]{
                StyreneButadieneRubber.getFluid(L * 16 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 16 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(3)
                    .input(ELECTRIC_MOTOR_ZPM, 64)
                    .input(ELECTRIC_MOTOR_ZPM, 64)
                    .input(plateDouble, Osmiridium, 64)
                    .input(stickLong, Osmiridium, 32)
                    .input(cableGtHex, VanadiumGallium, 8)
                    .fluidInputs(SolderingAlloy.getFluid(L * 2 * 64))
                    .fluidInputs(Lubricant.getFluid(32000))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidInputs(Osmiridium.getFluid(25600))
                    .output(CONVEYOR_MODULE_ZPM, 64)
                    .EUt(VA[ZPM])
                    .duration(1200)
                    .tier(ZPM)
                    .buildAndRegister();
        }

        //  UV (75s)
        for (FluidStack stack : new FluidStack[]{
                StyreneButadieneRubber.getFluid(L * 24 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 24 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(3)
                    .input(ELECTRIC_MOTOR_UV, 64)
                    .input(ELECTRIC_MOTOR_UV, 64)
                    .input(plateDouble, Tritanium, 64)
                    .input(stickLong, Tritanium, 32)
                    .input(cableGtHex, YttriumBariumCuprate, 8)
                    .fluidInputs(SolderingAlloy.getFluid(L * 4 * 64))
                    .fluidInputs(Lubricant.getFluid(64000))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidInputs(Naquadria.getFluid(L * 4 * 64))
                    .fluidInputs(Tritanium.getFluid(25600))
                    .output(CONVEYOR_MODULE_UV, 64)
                    .EUt(VA[UV])
                    .duration(1500)
                    .tier(UV)
                    .buildAndRegister();
        }

        //  UHV (75s)
        for (FluidStack stack : new FluidStack[]{
                StyreneButadieneRubber.getFluid(L * 32 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 32 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(3)
                    .input(ELECTRIC_MOTOR_UHV, 64)
                    .input(ELECTRIC_MOTOR_UHV, 64)
                    .input(plateDouble, Adamantium, 64)
                    .input(stickLong, Adamantium, 32)
                    .input(cableGtHex, Europium, 8)
                    .fluidInputs(SolderingAlloy.getFluid(L * 8 * 64))
                    .fluidInputs(Lubricant.getFluid(192000))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidInputs(Vibranium.getFluid(L * 64))
                    .fluidInputs(Adamantium.getFluid(25600))
                    .output(CONVEYOR_MODULE_UHV, 64)
                    .EUt(VA[UHV])
                    .duration(1500)
                    .tier(UHV)
                    .buildAndRegister();
        }

        //  UEV (90s)
        for (FluidStack stack : new FluidStack[]{
                StyreneButadieneRubber.getFluid(L * 40 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 40 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(3)
                    .input(ELECTRIC_MOTOR_UEV, 64)
                    .input(ELECTRIC_MOTOR_UEV, 64)
                    .input(plateDouble, Hdcs, 64)
                    .input(stickLong, Hdcs, 32)
                    .input(cableGtHex, PedotTMA, 8)
                    .fluidInputs(SolderingAlloy.getFluid(L * 16 * 64))
                    .fluidInputs(Lubricant.getFluid(320000))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidInputs(Ichorium.getFluid(L * 2 * 64))
                    .fluidInputs(Hdcs.getFluid(25600))
                    .output(CONVEYOR_MODULE_UEV, 64)
                    .EUt(VA[UEV])
                    .duration(1800)
                    .tier(UEV)
                    .buildAndRegister();
        }

        //  UIV (90s)
        for (FluidStack stack : new FluidStack[]{
                StyreneButadieneRubber.getFluid(L * 48 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 48 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(3)
                    .input(ELECTRIC_MOTOR_UIV, 64)
                    .input(ELECTRIC_MOTOR_UIV, 64)
                    .input(plateDouble, Legendarium, 64)
                    .input(stickLong, Legendarium, 32)
                    .input(cableGtHex, Solarium, 8)
                    .fluidInputs(SolderingAlloy.getFluid(L * 32 * 64))
                    .fluidInputs(Lubricant.getFluid(448000))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidInputs(Astralium.getFluid(L * 4 * 64))
                    .fluidInputs(Legendarium.getFluid(25600))
                    .output(CONVEYOR_MODULE_UIV, 64)
                    .EUt(VA[UIV])
                    .duration(1800)
                    .tier(UIV)
                    .buildAndRegister();
        }

        //  UXV (105s)
        for (FluidStack stack : new FluidStack[]{
                StyreneButadieneRubber.getFluid(L * 56 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 56 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(3)
                    .input(ELECTRIC_MOTOR_UXV, 64)
                    .input(ELECTRIC_MOTOR_UXV, 64)
                    .input(plateDouble, MagnetoHydrodynamicallyConstrainedStarMatter, 64)
                    .input(stickLong, MagnetoHydrodynamicallyConstrainedStarMatter, 32)
                    .input(cableGtHex, Hypogen, 8)
                    .fluidInputs(SolderingAlloy.getFluid(L * 64 * 64))
                    .fluidInputs(Lubricant.getFluid(576000))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidInputs(Hikarium.getFluid(L * 8 * 64))
                    .fluidInputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(25600)) // round + screw
                    .output(CONVEYOR_MODULE_UXV, 64)
                    .EUt(VA[UXV])
                    .duration(2100)
                    .tier(UXV)
                    .buildAndRegister();
        }

        //  OpV (105s)
        for (FluidStack stack : new FluidStack[]{
                StyreneButadieneRubber.getFluid(L * 64 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 64 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(3)
                    .input(ELECTRIC_MOTOR_OpV, 64)
                    .input(ELECTRIC_MOTOR_OpV, 64)
                    .input(plateDouble, TranscendentMetal, 64)
                    .input(stickLong, TranscendentMetal, 64)
                    .input(cableGtHex, Galaxium, 8)
                    .fluidInputs(SolderingAlloy.getFluid(L * 128 * 64))
                    .fluidInputs(Lubricant.getFluid(704000))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidInputs(Arcanium.getFluid(L * 16 * 64))
                    .fluidInputs(TranscendentMetal.getFluid(25600))
                    .output(CONVEYOR_MODULE_OpV, 64)
                    .EUt(VA[OpV])
                    .duration(2100)
                    .tier(OpV)
                    .buildAndRegister();
        }

        //  MAX (120s)
        for (FluidStack stack : new FluidStack[]{
                StyreneButadieneRubber.getFluid(L * 64 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 64 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(3)
                    .input(ELECTRIC_MOTOR_MAX, 64)
                    .input(ELECTRIC_MOTOR_MAX, 64)
                    .input(plateDouble, Omnium, 64)
                    .input(stickLong, Omnium, 64)
                    .input(cableGtHex, Universium, 8)
                    .fluidInputs(SolderingAlloy.getFluid(L * 256 * 64))
                    .fluidInputs(Lubricant.getFluid(13000 * 64))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidInputs(PrimordialMatter.getFluid(L * 32 * 64))
                    .fluidInputs(Omnium.getFluid(25600))
                    .output(CONVEYOR_MODULE_MAX, 64)
                    .EUt(VA[MAX])
                    .duration(2400)
                    .tier(MAX)
                    .buildAndRegister();
        }
    }

    private static void Pump() {

        //  ULV (15s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(4)
                .input(pipeTinyFluid, Bronze, 64)
                .input(stickLong, WroughtIron, 8)
                .input("wool", 64)
                .input("wool", 64)
                .input(ELECTRIC_MOTOR_ULV, 64)
                .fluidInputs(Copper.getFluid(L * 3 * 64))
                .fluidInputs(WroughtIron.getFluid(L * 4 * 64))
                .output(ELECTRIC_PUMP_ULV, 64)
                .EUt(VA[ULV])
                .duration(300)
                .tier(LV)
                .buildAndRegister();

        for (FluidStack stack : new FluidStack[]{
                Rubber.getFluid(L * 32),
                SiliconeRubber.getFluid(L * 32),
                StyreneButadieneRubber.getFluid(L * 32),
                NitrileButadieneRubber.getFluid(L * 32),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 32)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(4)
                    .input(pipeTinyFluid, Bronze, 64)
                    .input(stickLong, WroughtIron, 8)
                    .input(ELECTRIC_MOTOR_ULV, 64)
                    .fluidInputs(Copper.getFluid(L * 3 * 64))
                    .fluidInputs(WroughtIron.getFluid(L * 4 * 64))
                    .fluidInputs(new FluidStack[]{stack})
                    .output(ELECTRIC_PUMP_ULV, 64)
                    .EUt(VA[ULV])
                    .duration(300)
                    .tier(LV)
                    .buildAndRegister();
        }

        //  LV (15s)
        for (FluidStack stack : new FluidStack[]{
                Rubber.getFluid(L * 32),
                SiliconeRubber.getFluid(L * 32),
                StyreneButadieneRubber.getFluid(L * 32),
                NitrileButadieneRubber.getFluid(L * 32),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 32)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(4)
                    .input(cableGtHex, Tin, 4)
                    .input(stickLong, Tin, 8)
                    .input(ELECTRIC_MOTOR_LV, 64)
                    .fluidInputs(Bronze.getFluid(L * 3 * 64)) // PipeNormalFluid
                    .fluidInputs(Tin.getFluid(L * 4 * 64)) // Rotor
                    .fluidInputs(new FluidStack[]{stack})
                    .output(ELECTRIC_PUMP_LV, 64)
                    .EUt(VA[LV])
                    .duration(300)
                    .tier(LV)
                    .buildAndRegister();
        }

        //  MV (30s)
        for (FluidStack stack : new FluidStack[]{
                Rubber.getFluid(L * 32),
                SiliconeRubber.getFluid(L * 32),
                StyreneButadieneRubber.getFluid(L * 32),
                NitrileButadieneRubber.getFluid(L * 32),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 32)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(4)
                    .input(cableGtHex, Copper, 4)
                    .input(stickLong, Bronze, 8)
                    .input(ELECTRIC_MOTOR_MV, 64)
                    .fluidInputs(Steel.getFluid(L * 3 * 64)) // PipeNormalFluid
                    .fluidInputs(Bronze.getFluid(L * 4 * 64)) // Rotor
                    .fluidInputs(new FluidStack[]{stack})
                    .output(ELECTRIC_PUMP_MV, 64)
                    .EUt(VA[MV])
                    .duration(600)
                    .tier(MV)
                    .buildAndRegister();
        }

        //  HV (30s)
        for (FluidStack stack : new FluidStack[]{
                Rubber.getFluid(L * 32),
                SiliconeRubber.getFluid(L * 32),
                StyreneButadieneRubber.getFluid(L * 32),
                NitrileButadieneRubber.getFluid(L * 32),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 32)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(4)
                    .input(cableGtHex, Gold, 4)
                    .input(stickLong, Steel, 8)
                    .input(ELECTRIC_MOTOR_HV, 64)
                    .fluidInputs(StainlessSteel.getFluid(L * 3 * 64)) // PipeNormalFluid
                    .fluidInputs(Steel.getFluid(L * 4 * 64)) // Rotor
                    .fluidInputs(new FluidStack[]{stack})
                    .output(ELECTRIC_PUMP_HV, 64)
                    .EUt(VA[HV])
                    .duration(600)
                    .tier(HV)
                    .buildAndRegister();
        }

        //  EV (45s)
        for (FluidStack stack : new FluidStack[]{
                Rubber.getFluid(L * 32),
                SiliconeRubber.getFluid(L * 32),
                StyreneButadieneRubber.getFluid(L * 32),
                NitrileButadieneRubber.getFluid(L * 32),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 32)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(4)
                    .input(cableGtHex, Aluminium, 4)
                    .input(stickLong, StainlessSteel, 8)
                    .input(ELECTRIC_MOTOR_EV, 64)
                    .fluidInputs(Titanium.getFluid(L * 3 * 64)) // PipeNormalFluid
                    .fluidInputs(StainlessSteel.getFluid(L * 4 * 64)) // Rotor
                    .fluidInputs(new FluidStack[]{stack})
                    .output(ELECTRIC_PUMP_EV, 64)
                    .EUt(VA[EV])
                    .duration(900)
                    .tier(EV)
                    .buildAndRegister();
        }

        //  IV (45s)
        for (FluidStack stack : new FluidStack[]{
                SiliconeRubber.getFluid(L * 32),
                StyreneButadieneRubber.getFluid(L * 32),
                NitrileButadieneRubber.getFluid(L * 32),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 32)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(4)
                    .input(cableGtHex, Tungsten, 4)
                    .input(stickLong, TungstenSteel, 8)
                    .input(ELECTRIC_MOTOR_IV, 64)
                    .fluidInputs(TungstenSteel.getFluid(L * 3 * 64 + L * 4 * 64)) // PipeNormalFluid + Rotor
                    .fluidInputs(new FluidStack[]{stack})
                    .output(ELECTRIC_PUMP_IV, 64)
                    .EUt(VA[IV])
                    .duration(900)
                    .tier(IV)
                    .buildAndRegister();
        }

        //  LuV (60s)
        for (FluidStack stack : new FluidStack[]{
                SiliconeRubber.getFluid(L * 64),
                NitrileButadieneRubber.getFluid(L * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(4)
                    .input(ELECTRIC_MOTOR_LuV, 64)
                    .input(plateDouble, HSSS, 64)
                    .input(stickLong, HSSS, 64)
                    .input(cableGtHex, NiobiumTitanium, 8)
                    .fluidInputs(SolderingAlloy.getFluid(L * 64))
                    .fluidInputs(Lubricant.getFluid(16000))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidInputs(NiobiumTitanium.getFluid(L * 64)) // PipeSmallFluid
                    .fluidInputs(HSSS.getFluid(L * 4 * 64)) //  Rotor
                    .output(ELECTRIC_PUMP_LuV, 64)
                    .EUt(VA[LuV])
                    .duration(1200)
                    .tier(LuV)
                    .buildAndRegister();
        }

        //  ZPM (60s)
        for (FluidStack stack : new FluidStack[]{
                SiliconeRubber.getFluid(L * 128),
                NitrileButadieneRubber.getFluid(L * 128)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(4)
                    .input(ELECTRIC_MOTOR_ZPM, 64)
                    .input(plateDouble, Osmiridium, 64)
                    .input(stickLong, Osmiridium, 64)
                    .input(cableGtHex, VanadiumGallium, 8)
                    .fluidInputs(SolderingAlloy.getFluid(L * 2 * 64))
                    .fluidInputs(Lubricant.getFluid(32000))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidInputs(Polybenzimidazole.getFluid(L * 3 * 64)) // pipeNormalFluid
                    .fluidInputs(Osmiridium.getFluid(L * 4 * 64)) // Rotor
                    .output(ELECTRIC_PUMP_ZPM, 64)
                    .EUt(VA[ZPM])
                    .duration(1200)
                    .tier(ZPM)
                    .buildAndRegister();
        }

        //  UV (75s)
        for (FluidStack stack : new FluidStack[]{
                SiliconeRubber.getFluid(L * 256),
                NitrileButadieneRubber.getFluid(L * 256)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(4)
                    .input(ELECTRIC_MOTOR_UV, 64)
                    .input(plateDouble, Tritanium, 64)
                    .input(stickLong, Tritanium, 64)
                    .input(cableGtHex, YttriumBariumCuprate, 8)
                    .fluidInputs(SolderingAlloy.getFluid(L * 4 * 64))
                    .fluidInputs(Lubricant.getFluid(64000))
                    .fluidInputs(Naquadria.getFluid(L * 4 * 64))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidInputs(Naquadah.getFluid(L * 6 * 64)) // PipeLargeFluid
                    .fluidInputs(NaquadahAlloy.getFluid(L * 4 * 64)) //  Rotor
                    .output(ELECTRIC_PUMP_UV, 64)
                    .EUt(VA[UV])
                    .duration(1500)
                    .tier(UV)
                    .buildAndRegister();
        }

        //  UHV (75s)
        for (FluidStack stack : new FluidStack[]{
                SiliconeRubber.getFluid(L * 512),
                NitrileButadieneRubber.getFluid(L * 512)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(4)
                    .input(ELECTRIC_MOTOR_UHV, 64)
                    .input(plateDouble, Adamantium, 64)
                    .input(stickLong, Adamantium, 64)
                    .input(cableGtHex, Europium, 8)
                    .fluidInputs(SolderingAlloy.getFluid(L * 8 * 64))
                    .fluidInputs(Lubricant.getFluid(192000))
                    .fluidInputs(Vibranium.getFluid(L * 64))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidInputs(Duranium.getFluid(L * 6 * 64)) // PipeLargeFluid
                    .fluidInputs(Orichalcum.getFluid(L * 4 * 64)) // Rotor
                    .output(ELECTRIC_PUMP_UHV, 64)
                    .EUt(VA[UHV])
                    .duration(1500)
                    .tier(UHV)
                    .buildAndRegister();
        }

        //  UEV (90s)
        for (FluidStack stack : new FluidStack[]{
                SiliconeRubber.getFluid(L * 1024),
                NitrileButadieneRubber.getFluid(L * 1024)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(4)
                    .input(ELECTRIC_MOTOR_UEV, 64)
                    .input(plateDouble, Hdcs, 64)
                    .input(stickLong, Hdcs, 64)
                    .input(cableGtHex, PedotTMA, 8)
                    .fluidInputs(SolderingAlloy.getFluid(L * 16 * 64))
                    .fluidInputs(Lubricant.getFluid(320000))
                    .fluidInputs(Polyetheretherketone.getFluid(L * 2 * 64))
                    .fluidInputs(Ichorium.getFluid(L * 64))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidInputs(Lafium.getFluid(L * 6 * 64)) // PipeLargeFluid
                    .fluidInputs(Adamantium.getFluid(L * 4 * 64)) // Rotor
                    .output(ELECTRIC_PUMP_UEV, 64)
                    .EUt(VA[UEV])
                    .duration(1800)
                    .tier(UEV)
                    .buildAndRegister();
        }

        //  UIV (90s)
        for (FluidStack stack : new FluidStack[]{
                SiliconeRubber.getFluid(L * 1024),
                NitrileButadieneRubber.getFluid(L * 1024)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(4)
                    .input(ELECTRIC_MOTOR_UIV, 64)
                    .input(plateDouble, Legendarium, 64)
                    .input(stickLong, Legendarium, 64)
                    .input(cableGtHex, Solarium, 8)
                    .fluidInputs(SolderingAlloy.getFluid(L * 32 * 64))
                    .fluidInputs(Lubricant.getFluid(448000))
                    .fluidInputs(Zylon.getFluid(L * 4 * 64))
                    .fluidInputs(Astralium.getFluid(L * 2 * 64))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidInputs(CrystalMatrix.getFluid(L * 6 * 64)) // PipeLargeFluid
                    .fluidInputs(Infinity.getFluid(L * 4 * 64)) // Rotor
                    .output(ELECTRIC_PUMP_UIV, 64)
                    .EUt(VA[UIV])
                    .duration(1800)
                    .tier(UIV)
                    .buildAndRegister();
        }

        //  UXV (105s)
        for (FluidStack stack : new FluidStack[]{
                SiliconeRubber.getFluid(L * 1024),
                NitrileButadieneRubber.getFluid(L * 1024)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(4)
                    .input(ELECTRIC_MOTOR_UXV, 64)
                    .input(plateDouble, MagnetoHydrodynamicallyConstrainedStarMatter, 64)
                    .input(stickLong, MagnetoHydrodynamicallyConstrainedStarMatter, 64)
                    .input(cableGtHex, Solarium, 8)
                    .fluidInputs(SolderingAlloy.getFluid(L * 64 * 64))
                    .fluidInputs(Lubricant.getFluid(576000))
                    .fluidInputs(FullerenePolymerMatrix.getFluid(L * 8 * 64))
                    .fluidInputs(Hikarium.getFluid(L * 4 * 64))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidInputs(QuantumchromodynamicallyConfinedMatter.getFluid(L * 6 * 64)) // PipeLargeFluid
                    .fluidInputs(CosmicNeutronium.getFluid(L * 4 * 64)) // Rotor
                    .output(ELECTRIC_PUMP_UXV, 64)
                    .EUt(VA[UXV])
                    .duration(2100)
                    .tier(UXV)
                    .buildAndRegister();
        }
        //  OpV (105s)
        for (FluidStack stack : new FluidStack[]{
                SiliconeRubber.getFluid(L * 1024),
                NitrileButadieneRubber.getFluid(L * 1024)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(4)
                    .input(ELECTRIC_MOTOR_OpV, 64)
                    .input(plateDouble, TranscendentMetal, 64)
                    .input(stickLong, TranscendentMetal, 64)
                    .input(cableGtHex, Galaxium, 8)
                    .fluidInputs(SolderingAlloy.getFluid(L * 128 * 64))
                    .fluidInputs(Lubricant.getFluid(704000))
                    .fluidInputs(CosmicFabric.getFluid(L * 16 * 64))
                    .fluidInputs(Arcanium.getFluid(L * 8 * 64))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidInputs(Fatalium.getFluid(L * 6 * 64)) // PipeLargeFluid
                    .fluidInputs(Spacetime.getFluid(L * 4 * 64)) // Rotor
                    .output(ELECTRIC_PUMP_OpV, 64)
                    .EUt(VA[OpV])
                    .duration(2100)
                    .tier(OpV)
                    .buildAndRegister();
        }

        //  MAX (120s)
        for (FluidStack stack : new FluidStack[]{
                SiliconeRubber.getFluid(L * 1024),
                NitrileButadieneRubber.getFluid(L * 1024)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(4)
                    .input(ELECTRIC_MOTOR_MAX, 64)
                    .input(plateDouble, Omnium, 64)
                    .input(stickLong, Omnium, 64)
                    .input(cableGtHex, Universium, 8)
                    .fluidInputs(SolderingAlloy.getFluid(L * 256 * 64))
                    .fluidInputs(Lubricant.getFluid(13000 * 64))
                    .fluidInputs(SpacetimeContinuum.getFluid(L * 32 * 64))
                    .fluidInputs(PrimordialMatter.getFluid(L * 16 * 64))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidInputs(Aetherium.getFluid(L * 6 * 64))
                    .fluidInputs(Eternity.getFluid(L * 4 * 64))
                    .output(ELECTRIC_PUMP_MAX, 64)
                    .EUt(VA[MAX])
                    .duration(2400)
                    .tier(MAX)
                    .buildAndRegister();
        }
    }

    private static void RobotArm() {

        //  ULV (15s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(pipeTinyFluid, Bronze, 64)
                .input(pipeTinyFluid, Bronze, 64)
                .input(pipeTinyFluid, Bronze, 64)
                .input(stickLong, WroughtIron, 64)
                .input(ELECTRIC_MOTOR_ULV, 64)
                .input(ELECTRIC_MOTOR_ULV, 64)
                .input(ELECTRIC_PISTON_ULV, 64)
                .input(circuit, MarkerMaterials.Tier.ULV, 64)
                .output(ROBOT_ARM_ULV, 64)
                .EUt(VA[ULV])
                .duration(300)
                .tier(LV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(pipeTinyFluid, Bronze, 64)
                .input(pipeTinyFluid, Bronze, 64)
                .input(pipeTinyFluid, Bronze, 64)
                .input(stickLong, WroughtIron, 64)
                .input(ELECTRIC_MOTOR_ULV, 64)
                .input(ELECTRIC_MOTOR_ULV, 64)
                .input(ELECTRIC_PISTON_ULV, 64)
                .input(WRAP_CIRCUIT_ULV, 4) // 4 * 16
                .output(ROBOT_ARM_ULV, 64)
                .EUt(VA[ULV])
                .duration(300)
                .tier(LV)
                .buildAndRegister();

        //  LV (15s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(cableGtHex, Tin, 12)
                .input(stickLong, Steel, 64)
                .input(ELECTRIC_MOTOR_LV, 64)
                .input(ELECTRIC_MOTOR_LV, 64)
                .input(ELECTRIC_PISTON_LV, 64)
                .input(circuit, MarkerMaterials.Tier.LV, 64)
                .output(ROBOT_ARM_LV, 64)
                .EUt(VA[LV])
                .duration(300)
                .tier(LV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(cableGtHex, Tin, 12)
                .input(stickLong, Steel, 64)
                .input(ELECTRIC_MOTOR_LV, 64)
                .input(ELECTRIC_MOTOR_LV, 64)
                .input(ELECTRIC_PISTON_LV, 64)
                .input(WRAP_CIRCUIT_LV, 4) // 4 * 16
                .output(ROBOT_ARM_LV, 64)
                .EUt(VA[LV])
                .duration(300)
                .tier(LV)
                .buildAndRegister();

        //  MV (30s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(cableGtHex, Copper, 12)
                .input(stickLong, Aluminium, 64)
                .input(ELECTRIC_MOTOR_MV, 64)
                .input(ELECTRIC_MOTOR_MV, 64)
                .input(ELECTRIC_PISTON_MV, 64)
                .input(circuit, MarkerMaterials.Tier.MV, 64)
                .output(ROBOT_ARM_MV, 64)
                .EUt(VA[MV])
                .duration(600)
                .tier(MV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(cableGtHex, Copper, 12)
                .input(stickLong, Aluminium, 64)
                .input(ELECTRIC_MOTOR_MV, 64)
                .input(ELECTRIC_MOTOR_MV, 64)
                .input(ELECTRIC_PISTON_MV, 64)
                .input(WRAP_CIRCUIT_MV, 4) // 4 * 16
                .output(ROBOT_ARM_MV, 64)
                .EUt(VA[MV])
                .duration(600)
                .tier(MV)
                .buildAndRegister();

        //  HV (30s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(cableGtHex, Gold, 12)
                .input(stickLong, StainlessSteel, 64)
                .input(ELECTRIC_MOTOR_HV, 64)
                .input(ELECTRIC_MOTOR_HV, 64)
                .input(ELECTRIC_PISTON_HV, 64)
                .input(circuit, MarkerMaterials.Tier.HV, 64)
                .output(ROBOT_ARM_HV, 64)
                .EUt(VA[HV])
                .duration(600)
                .tier(HV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(cableGtHex, Gold, 12)
                .input(stickLong, StainlessSteel, 64)
                .input(ELECTRIC_MOTOR_HV, 64)
                .input(ELECTRIC_MOTOR_HV, 64)
                .input(ELECTRIC_PISTON_HV, 64)
                .input(WRAP_CIRCUIT_HV, 4) // 4 * 16
                .output(ROBOT_ARM_HV, 64)
                .EUt(VA[HV])
                .duration(600)
                .tier(HV)
                .buildAndRegister();

        //  EV (45s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(cableGtHex, Aluminium, 12)
                .input(stickLong, Titanium, 64)
                .input(ELECTRIC_MOTOR_EV, 64)
                .input(ELECTRIC_MOTOR_EV, 64)
                .input(ELECTRIC_PISTON_EV, 64)
                .input(circuit, MarkerMaterials.Tier.EV, 64)
                .output(ROBOT_ARM_EV, 64)
                .EUt(VA[EV])
                .duration(900)
                .tier(EV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(cableGtHex, Aluminium, 12)
                .input(stickLong, Titanium, 64)
                .input(ELECTRIC_MOTOR_EV, 64)
                .input(ELECTRIC_MOTOR_EV, 64)
                .input(ELECTRIC_PISTON_EV, 64)
                .input(WRAP_CIRCUIT_EV, 4) // 4 * 16
                .output(ROBOT_ARM_EV, 64)
                .EUt(VA[EV])
                .duration(900)
                .tier(EV)
                .buildAndRegister();

        //  IV (45s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(cableGtHex, Tungsten, 12)
                .input(stickLong, TungstenSteel, 64)
                .input(ELECTRIC_MOTOR_IV, 64)
                .input(ELECTRIC_MOTOR_IV, 64)
                .input(ELECTRIC_PISTON_IV, 64)
                .input(circuit, MarkerMaterials.Tier.IV, 64)
                .output(ROBOT_ARM_IV, 64)
                .EUt(VA[IV])
                .duration(900)
                .tier(IV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(cableGtHex, Tungsten, 12)
                .input(stickLong, TungstenSteel, 64)
                .input(ELECTRIC_MOTOR_IV, 64)
                .input(ELECTRIC_MOTOR_IV, 64)
                .input(ELECTRIC_PISTON_IV, 64)
                .input(WRAP_CIRCUIT_IV, 4) // 4 * 16
                .output(ROBOT_ARM_IV, 64)
                .EUt(VA[IV])
                .duration(900)
                .tier(IV)
                .buildAndRegister();

        //  LuV (60s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(stickLong, HSSS, 64)
                .input(stickLong, HSSS, 64)
                .input(stickLong, HSSS, 64)
                .input(stickLong, HSSS, 64)
                .input(ELECTRIC_MOTOR_LuV, 64)
                .input(ELECTRIC_MOTOR_LuV, 64)
                .input(ELECTRIC_PISTON_LUV, 64)
                .input(WRAP_CIRCUIT_LuV, 4) // 4 * 16
                .input(WRAP_CIRCUIT_IV, 8) // 8 * 16 = 2 * 64
                .input(WRAP_CIRCUIT_EV, 16) // 16 * 16
                .input(cableGtHex, NiobiumTitanium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 4 * 64))
                .fluidInputs(Lubricant.getFluid(16000))
                .fluidInputs(HSSS.getFluid(L * 4 * 64 + L * 3 * 64)) //  Gear + 3 Small Gear
                .output(ROBOT_ARM_LuV, 64)
                .EUt(VA[LuV])
                .duration(1200)
                .tier(LuV)
                .buildAndRegister();

        //  ZPM (60s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(stickLong, Osmiridium,  64)
                .input(stickLong, Osmiridium, 64)
                .input(stickLong, Osmiridium, 64)
                .input(stickLong, Osmiridium, 64)
                .input(ELECTRIC_MOTOR_ZPM, 64)
                .input(ELECTRIC_MOTOR_ZPM, 64)
                .input(ELECTRIC_PISTON_ZPM, 64)
                .input(WRAP_CIRCUIT_ZPM, 4) // 4 * 16
                .input(WRAP_CIRCUIT_LuV, 8) // 8 * 16 = 2 * 64
                .input(WRAP_CIRCUIT_IV, 16) // 16 * 16 = 4 * 64
                .input(cableGtHex, VanadiumGallium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 8 * 64))
                .fluidInputs(Lubricant.getFluid(32000))
                .fluidInputs(Osmiridium.getFluid(L * 4 * 64 + L * 3 * 64)) //  Gear + 3 Small Gear
                .output(ROBOT_ARM_ZPM, 64)
                .EUt(VA[ZPM])
                .duration(1200)
                .tier(ZPM)
                .buildAndRegister();

        //  UV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(stickLong, Tritanium,  64)
                .input(stickLong, Tritanium, 64)
                .input(stickLong, Tritanium, 64)
                .input(stickLong, Tritanium, 64)
                .input(ELECTRIC_MOTOR_UV, 64)
                .input(ELECTRIC_MOTOR_UV, 64)
                .input(ELECTRIC_PISTON_UV, 64)
                .input(WRAP_CIRCUIT_UV, 4) // 4 * 16
                .input(WRAP_CIRCUIT_ZPM, 8) // 8 * 16 = 2 * 64
                .input(WRAP_CIRCUIT_LuV, 16) // 16 * 16 = 4 * 64
                .input(cableGtHex, YttriumBariumCuprate, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 12 * 64))
                .fluidInputs(Lubricant.getFluid(64000))
                .fluidInputs(Naquadria.getFluid(L * 4 * 64))
                .fluidInputs(Tritanium.getFluid(L * 4 * 64 + L * 3 * 64)) //  Gear + 3 Small Gear
                .output(ROBOT_ARM_UV, 64)
                .EUt(VA[UV])
                .duration(1500)
                .tier(UV)
                .buildAndRegister();

        //  UHV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(stickLong, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(ELECTRIC_MOTOR_UHV, 64)
                .input(ELECTRIC_MOTOR_UHV, 64)
                .input(ELECTRIC_PISTON_UHV, 64)
                .input(WRAP_CIRCUIT_UHV, 4) // 4 * 16
                .input(WRAP_CIRCUIT_UV, 8) // 8 * 16 = 2 * 64
                .input(WRAP_CIRCUIT_ZPM, 16) // 16 * 16 = 4 * 64
                .input(cableGtHex, Europium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 16 * 64))
                .fluidInputs(Lubricant.getFluid(192000))
                .fluidInputs(Vibranium.getFluid(L * 64))
                .fluidInputs(Adamantium.getFluid(L * 4 * 64 + L * 3 * 64)) // Gear + 3 Small Gear
                .output(ROBOT_ARM_UHV, 64)
                .EUt(VA[UHV])
                .duration(1500)
                .tier(UHV)
                .buildAndRegister();

        //  UEV (90s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(stickLong, Hdcs, 64)
                .input(stickLong, Hdcs, 64)
                .input(stickLong, Hdcs, 64)
                .input(stickLong, Hdcs, 64)
                .input(ELECTRIC_MOTOR_UEV, 64)
                .input(ELECTRIC_MOTOR_UEV, 64)
                .input(ELECTRIC_PISTON_UEV, 64)
                .input(WRAP_CIRCUIT_UEV, 4) // 4 * 16
                .input(WRAP_CIRCUIT_UHV, 8) // 8 * 16 = 2 * 64
                .input(WRAP_CIRCUIT_UV, 16) // 16 * 16 = 4 * 64
                .input(cableGtHex, PedotTMA, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 20 * 64))
                .fluidInputs(Lubricant.getFluid(320000))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2 * 64))
                .fluidInputs(Ichorium.getFluid(L * 64))
                .fluidInputs(Hdcs.getFluid(L * 4 * 64 + L * 3 * 64)) // Gear + 3 Small Gear
                .output(ROBOT_ARM_UEV, 64)
                .EUt(VA[UEV])
                .duration(1800)
                .tier(UEV)
                .buildAndRegister();

        //  UIV (90s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(stickLong, Legendarium, 64)
                .input(stickLong, Legendarium, 64)
                .input(stickLong, Legendarium, 64)
                .input(stickLong, Legendarium, 64)
                .input(ELECTRIC_MOTOR_UIV, 64)
                .input(ELECTRIC_MOTOR_UIV, 64)
                .input(ELECTRIC_PISTON_UIV, 64)
                .input(WRAP_CIRCUIT_UIV, 4) // 4 * 16
                .input(WRAP_CIRCUIT_UEV, 8) // 8 * 16 = 2 * 64
                .input(WRAP_CIRCUIT_UHV, 16) // 16 * 16 = 4 * 64
                .input(cableGtHex, Solarium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 24 * 64))
                .fluidInputs(Lubricant.getFluid(448000))
                .fluidInputs(Zylon.getFluid(L * 4 * 64))
                .fluidInputs(Astralium.getFluid(L * 2 * 64))
                .fluidInputs(Legendarium.getFluid(L * 4 * 64 + L * 3 * 64)) // Gear + 3 Small Gear
                .output(ROBOT_ARM_UIV, 64)
                .EUt(VA[UIV])
                .duration(1800)
                .tier(UIV)
                .buildAndRegister();

        //  UXV (105s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(stickLong, MagnetoHydrodynamicallyConstrainedStarMatter, 64)
                .input(stickLong, MagnetoHydrodynamicallyConstrainedStarMatter, 64)
                .input(stickLong, MagnetoHydrodynamicallyConstrainedStarMatter, 64)
                .input(stickLong, MagnetoHydrodynamicallyConstrainedStarMatter, 64)
                .input(ELECTRIC_MOTOR_UXV, 64)
                .input(ELECTRIC_MOTOR_UXV, 64)
                .input(ELECTRIC_PISTON_UXV, 64)
                .input(WRAP_CIRCUIT_UXV, 4) // 4 * 16
                .input(WRAP_CIRCUIT_UIV, 8) // 8 * 16 = 2 * 64
                .input(WRAP_CIRCUIT_UEV, 16) // 16 * 16 = 4 * 64
                .input(cableGtHex, Hypogen, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 28 * 64))
                .fluidInputs(Lubricant.getFluid(576000))
                .fluidInputs(FullerenePolymerMatrix.getFluid(L * 8 * 64))
                .fluidInputs(Hikarium.getFluid(L * 4 * 64))
                .fluidInputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(L * 4 * 64 + L * 3 * 64)) // Gear + 3 Small Gear
                .output(ROBOT_ARM_UXV, 64)
                .EUt(VA[UXV])
                .duration(2100)
                .tier(UXV)
                .buildAndRegister();

        //  OpV (105s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(stickLong, TranscendentMetal, 64)
                .input(stickLong, TranscendentMetal, 64)
                .input(stickLong, TranscendentMetal, 64)
                .input(stickLong, TranscendentMetal, 64)
                .input(ELECTRIC_MOTOR_OpV, 64)
                .input(ELECTRIC_MOTOR_OpV, 64)
                .input(ELECTRIC_PISTON_OpV, 64)
                .input(WRAP_CIRCUIT_OpV, 4) // 4 * 16
                .input(WRAP_CIRCUIT_UXV, 8) // 8 * 16 = 2 * 64
                .input(WRAP_CIRCUIT_UIV, 16) // 16 * 16 = 4 * 64
                .input(cableGtHex, Galaxium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 32 * 64))
                .fluidInputs(Lubricant.getFluid(704000))
                .fluidInputs(CosmicFabric.getFluid(L * 16 * 64))
                .fluidInputs(Arcanium.getFluid(L * 8 * 64))
                .fluidInputs(TranscendentMetal.getFluid(L * 4 * 64 + L * 3 * 64)) // Gear + 3 Small Gear
                .output(ROBOT_ARM_OpV, 64)
                .EUt(VA[OpV])
                .duration(2100)
                .tier(OpV)
                .buildAndRegister();

        //  MAX (120s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(stickLong, Omnium, 64)
                .input(stickLong, Omnium, 64)
                .input(stickLong, Omnium, 64)
                .input(stickLong, Omnium, 64)
                .input(ELECTRIC_MOTOR_MAX, 64)
                .input(ELECTRIC_MOTOR_MAX, 64)
                .input(ELECTRIC_PISTON_MAX, 64)
                .input(WRAP_CIRCUIT_MAX, 4)
                .input(WRAP_CIRCUIT_OpV, 8)
                .input(WRAP_CIRCUIT_UXV, 16)
                .input(cableGtHex, Universium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 64 * 64))
                .fluidInputs(Lubricant.getFluid(13000 * 64))
                .fluidInputs(SpacetimeContinuum.getFluid(L * 32 * 64))
                .fluidInputs(PrimordialMatter.getFluid(L * 16 * 64))
                .fluidInputs(Omnium.getFluid(L * 4 * 64 + L * 3 * 64))
                .output(ROBOT_ARM_MAX, 64)
                .EUt(VA[MAX])
                .duration(2400)
                .tier(MAX)
                .buildAndRegister();
    }

    private static void Emitter() {

        //  ULV (15s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .input(stickLong, TinAlloy, 64)
                .input(stickLong, TinAlloy, 64)
                .input(pipeTinyFluid, Bronze, 64)
                .input(pipeTinyFluid, Bronze, 64)
                .input(circuit, MarkerMaterials.Tier.ULV, 64)
                .input(circuit, MarkerMaterials.Tier.ULV, 64)
                .input(gem, Sapphire, 64)
                .output(EMITTER_ULV, 64)
                .EUt(VA[ULV])
                .duration(300)
                .tier(LV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .input(stickLong, TinAlloy, 64)
                .input(stickLong, TinAlloy, 64)
                .input(pipeTinyFluid, Bronze, 64)
                .input(pipeTinyFluid, Bronze, 64)
                .input(WRAP_CIRCUIT_ULV, 8) // 8 * 16 = 2 * 64
                .input(gem, Sapphire, 64)
                .output(EMITTER_ULV, 64)
                .EUt(VA[ULV])
                .duration(300)
                .tier(LV)
                .buildAndRegister();

        //  LV (15s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .input(stickLong, Brass, 64)
                .input(stickLong, Brass, 64)
                .input(cableGtHex, Tin, 8)
                .input(circuit, MarkerMaterials.Tier.LV, 64)
                .input(circuit, MarkerMaterials.Tier.LV, 64)
                .input(gem, Quartzite, 64)
                .output(EMITTER_LV, 64)
                .EUt(VA[LV])
                .duration(300)
                .tier(LV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .input(stickLong, Brass, 64)
                .input(stickLong, Brass, 64)
                .input(cableGtHex, Tin, 8)
                .input(WRAP_CIRCUIT_LV, 8) // 8 * 16 = 2 * 64
                .input(gem, Quartzite, 64)
                .output(EMITTER_LV, 64)
                .EUt(VA[LV])
                .duration(300)
                .tier(LV)
                .buildAndRegister();

        //  MV (30s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .input(stickLong, Electrum, 64)
                .input(stickLong, Electrum, 64)
                .input(cableGtHex, Copper, 8)
                .input(circuit, MarkerMaterials.Tier.MV, 64)
                .input(circuit, MarkerMaterials.Tier.MV, 64)
                .input(gemFlawless, Emerald, 64)
                .output(EMITTER_MV, 64)
                .EUt(VA[MV])
                .duration(600)
                .tier(MV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .input(stickLong, Electrum, 64)
                .input(stickLong, Electrum, 64)
                .input(cableGtHex, Copper, 8)
                .input(WRAP_CIRCUIT_MV, 8) // 8 * 16 = 2 * 64
                .input(gemFlawless, Emerald, 64)
                .output(EMITTER_MV, 64)
                .EUt(VA[MV])
                .duration(600)
                .tier(MV)
                .buildAndRegister();

        //  HV (30s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .input(stickLong, Chrome, 64)
                .input(stickLong, Chrome, 64)
                .input(cableGtHex, Gold, 8)
                .input(circuit, MarkerMaterials.Tier.HV, 64)
                .input(circuit, MarkerMaterials.Tier.HV, 64)
                .input(ENDER_EYE, 64)
                .output(EMITTER_HV, 64)
                .EUt(VA[HV])
                .duration(600)
                .tier(HV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .input(stickLong, Chrome, 64)
                .input(stickLong, Chrome, 64)
                .input(cableGtHex, Gold, 8)
                .input(WRAP_CIRCUIT_HV, 8) // 8 * 16 = 2 * 64
                .input(ENDER_EYE, 64)
                .output(EMITTER_HV, 64)
                .EUt(VA[HV])
                .duration(600)
                .tier(HV)
                .buildAndRegister();

        //  EV (45s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .input(stickLong, Platinum, 64)
                .input(stickLong, Platinum, 64)
                .input(cableGtHex, Aluminium, 8)
                .input(circuit, MarkerMaterials.Tier.EV, 64)
                .input(circuit, MarkerMaterials.Tier.EV, 64)
                .input(QUANTUM_EYE, 64)
                .output(EMITTER_EV, 64)
                .EUt(VA[EV])
                .duration(900)
                .tier(EV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .input(stickLong, Platinum, 64)
                .input(stickLong, Platinum, 64)
                .input(cableGtHex, Aluminium, 8)
                .input(WRAP_CIRCUIT_EV, 8) // 8 * 16 = 2 * 64
                .input(QUANTUM_EYE, 64)
                .output(EMITTER_EV, 64)
                .EUt(VA[EV])
                .duration(900)
                .tier(EV)
                .buildAndRegister();

        //  IV (45s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .input(stickLong, Iridium, 64)
                .input(stickLong, Iridium, 64)
                .input(cableGtHex, Tungsten, 8)
                .input(circuit, MarkerMaterials.Tier.IV, 64)
                .input(circuit, MarkerMaterials.Tier.IV, 64)
                .input(QUANTUM_STAR, 64)
                .output(EMITTER_IV, 64)
                .EUt(VA[IV])
                .duration(900)
                .tier(IV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .input(stickLong, Iridium, 64)
                .input(stickLong, Iridium, 64)
                .input(cableGtHex, Tungsten, 8)
                .input(WRAP_CIRCUIT_IV, 8) // 8 * 16 = 2 * 64
                .input(QUANTUM_STAR, 64)
                .output(EMITTER_IV, 64)
                .EUt(VA[IV])
                .duration(900)
                .tier(IV)
                .buildAndRegister();

        //  LuV (60s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .input(frameGt, HSSS, 64)
                .input(ELECTRIC_MOTOR_LuV, 64)
                .input(QUANTUM_STAR, 64)
                .input(WRAP_CIRCUIT_LuV, 8) // 8 * 16 = 2 * 64
                .input(cableGtHex, NiobiumTitanium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 2 * 64))
                .fluidInputs(Ruridit.getFluid(L * 4 * 64)) //  4 * Long Stick
                .fluidInputs(Palladium.getFluid(L * 24 * 64)) //  Foil (64 + 32 -> 16 * 4 + 8 * 4)
                .output(EMITTER_LuV, 64)
                .EUt(VA[LuV])
                .duration(1200)
                .tier(LuV)
                .buildAndRegister();

        //  ZPM (60s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .input(frameGt, NaquadahAlloy, 64)
                .input(ELECTRIC_MOTOR_ZPM, 64)
                .input(QUANTUM_STAR, 64)
                .input(QUANTUM_STAR, 64)
                .input(WRAP_CIRCUIT_ZPM, 8) // 8 * 16 = 2 * 64
                .input(cableGtHex, VanadiumGallium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 4 * 64))
                .fluidInputs(Osmiridium.getFluid(L * 4 * 64)) //  4 * Long Stick
                .fluidInputs(Trinium.getFluid(L * 24 * 64)) //  Foil (64 + 32 -> 16 * 4 + 8 * 4)
                .output(EMITTER_ZPM, 64)
                .EUt(VA[ZPM])
                .duration(1200)
                .tier(ZPM)
                .buildAndRegister();

        //  UV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .input(frameGt, Tritanium, 64)
                .input(ELECTRIC_MOTOR_UV, 64)
                .input(GRAVI_STAR, 64)
                .input(WRAP_CIRCUIT_UV, 8) // 8 * 16 = 2 * 64
                .input(cableGtHex, YttriumBariumCuprate, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 8 * 64))
                .fluidInputs(Naquadria.getFluid(L * 24 * 64 + L * 4 * 64)) // foil + recipe fluids
                .fluidInputs(Tritanium.getFluid(L * 4 * 64)) //  4 * long stick
                .output(EMITTER_UV, 64)
                .EUt(VA[UV])
                .duration(1500)
                .tier(UV)
                .buildAndRegister();

        //  UHV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .input(frameGt, Adamantium, 64)
                .input(ELECTRIC_MOTOR_UHV, 64)
                .input(GRAVI_STAR, 64)
                .input(GRAVI_STAR, 64)
                .input(WRAP_CIRCUIT_UHV, 8) // 8 * 16 = 2 * 64
                .input(cableGtHex, Europium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 16 * 64))
                .fluidInputs(Vibranium.getFluid(L * 24 * 64 + L * 64)) // foil + recipe fluids
                .fluidInputs(Adamantium.getFluid(L * 4 * 64)) // long stick
                .output(EMITTER_UHV, 64)
                .EUt(VA[UHV])
                .duration(1500)
                .tier(UHV)
                .buildAndRegister();

        //  UEV (90s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .input(frameGt, Hdcs, 64)
                .input(ELECTRIC_MOTOR_UEV, 64)
                .input(GRAVI_STAR, 64)
                .input(GRAVI_STAR, 64)
                .input(GRAVI_STAR, 64)
                .input(GRAVI_STAR, 64)
                .input(WRAP_CIRCUIT_UEV, 8) // 8 * 16 = 2 * 64
                .input(cableGtHex, PedotTMA, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 32 * 64))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2 * 64))
                .fluidInputs(Ichorium.getFluid(L * 24 * 64 + L * 64)) // foil + recipe fluids
                .fluidInputs(Hdcs.getFluid(L * 4 * 64)) // long stick
                .output(EMITTER_UEV, 64)
                .EUt(VA[UEV])
                .duration(1800)
                .tier(UEV)
                .buildAndRegister();

        //  UIV (90s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .input(frameGt, Legendarium, 64)
                .input(ELECTRIC_MOTOR_UIV, 64)
                .input(UNSTABLE_STAR, 64)
                .input(WRAP_CIRCUIT_UIV, 8) // 8 * 16 = 2 * 64
                .input(cableGtHex, Solarium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 64 * 64))
                .fluidInputs(Zylon.getFluid(L * 4 * 64))
                .fluidInputs(Astralium.getFluid(313344))
                .fluidInputs(Legendarium.getFluid(L * 4 * 64)) // long stick
                .output(EMITTER_UIV, 64)
                .EUt(VA[UIV])
                .duration(1800)
                .tier(UIV)
                .buildAndRegister();

        //  UXV (105s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .input(frameGt, MagnetoHydrodynamicallyConstrainedStarMatter, 64)
                .input(ELECTRIC_MOTOR_UXV, 64)
                .input(UNSTABLE_STAR, 64)
                .input(UNSTABLE_STAR, 64)
                .input(WRAP_CIRCUIT_UXV, 8) // 8 * 16 = 2 * 64
                .input(cableGtHex, Hypogen, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 128 * 64))
                .fluidInputs(FullerenePolymerMatrix.getFluid(L * 8 * 64))
                .fluidInputs(Hikarium.getFluid(331776))
                .fluidInputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(L * 4 * 64)) // long stick
                .output(EMITTER_UXV, 64)
                .EUt(VA[UXV])
                .duration(2100)
                .tier(UXV)
                .buildAndRegister();

        //  OpV (105s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .input(frameGt, TranscendentMetal, 64)
                .input(ELECTRIC_MOTOR_OpV, 64)
                .input(UNSTABLE_STAR, 64)
                .input(UNSTABLE_STAR, 64)
                .input(UNSTABLE_STAR, 64)
                .input(UNSTABLE_STAR, 64)
                .input(WRAP_CIRCUIT_OpV, 8) // 8 * 16 = 2 * 64
                .input(cableGtHex, Galaxium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 256 * 64))
                .fluidInputs(CosmicFabric.getFluid(L * 16 * 64))
                .fluidInputs(Arcanium.getFluid(368640))
                .fluidInputs(TranscendentMetal.getFluid(L * 4 * 64))
                .output(EMITTER_OpV, 64)
                .EUt(VA[OpV])
                .duration(2100)
                .tier(OpV)
                .buildAndRegister();

        //  MAX (120s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .input(frameGt, Omnium, 64)
                .input(ELECTRIC_MOTOR_MAX, 64)
                .input(ZENITH_STAR, 64)
                .input(WRAP_CIRCUIT_MAX, 8)
                .input(cableGtHex, Universium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 512 * 64))
                .fluidInputs(SpacetimeContinuum.getFluid(L * 32 * 64))
                .fluidInputs(PrimordialMatter.getFluid(L * 16 * 64))
                .fluidInputs(Omnium.getFluid(L * 4 * 64))
                .output(EMITTER_MAX, 64)
                .EUt(VA[MAX])
                .duration(2400)
                .tier(MAX)
                .buildAndRegister();
    }

    private static void Sensor() {

        //  ULV (15s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .input(stickLong, TinAlloy, 32)
                .input(plateDouble, WroughtIron, 64)
                .input(plateDouble, WroughtIron, 64)
                .input(circuit, MarkerMaterials.Tier.ULV, 64)
                .input(gem, Sapphire, 64)
                .output(SENSOR_ULV, 64)
                .EUt(VA[ULV])
                .duration(300)
                .tier(LV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .input(stickLong, Iron, 32)
                .input(plateDouble, WroughtIron, 64)
                .input(plateDouble, WroughtIron, 64)
                .input(WRAP_CIRCUIT_ULV, 4) // 4 * 16
                .input(gem, Sapphire, 64)
                .output(SENSOR_ULV, 64)
                .EUt(VA[ULV])
                .duration(300)
                .tier(LV)
                .buildAndRegister();

        //  LV (15s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .input(stickLong, Brass, 32)
                .input(plateDouble, Steel, 64)
                .input(plateDouble, Steel, 64)
                .input(circuit, MarkerMaterials.Tier.LV, 64)
                .input(gem, Quartzite, 64)
                .output(SENSOR_LV, 64)
                .EUt(VA[LV])
                .duration(300)
                .tier(LV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .input(stickLong, Brass, 32)
                .input(plateDouble, Steel, 64)
                .input(plateDouble, Steel, 64)
                .input(WRAP_CIRCUIT_LV, 4) // 4 * 16
                .input(gem, Quartzite, 64)
                .output(SENSOR_LV, 64)
                .EUt(VA[LV])
                .duration(300)
                .tier(LV)
                .buildAndRegister();

        //  MV (30s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .input(stickLong, Electrum, 32)
                .input(plateDouble, Aluminium, 64)
                .input(plateDouble, Aluminium, 64)
                .input(circuit, MarkerMaterials.Tier.MV, 64)
                .input(gemFlawless, Emerald, 64)
                .output(SENSOR_MV, 64)
                .EUt(VA[MV])
                .duration(600)
                .tier(MV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .input(stickLong, Electrum, 32)
                .input(plateDouble, Aluminium, 64)
                .input(plateDouble, Aluminium, 64)
                .input(WRAP_CIRCUIT_MV, 4) // 4 * 16
                .input(gemFlawless, Emerald, 64)
                .output(SENSOR_MV, 64)
                .EUt(VA[MV])
                .duration(600)
                .tier(MV)
                .buildAndRegister();

        //  HV (30s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .input(stickLong, Chrome, 32)
                .input(plateDouble, StainlessSteel, 64)
                .input(plateDouble, StainlessSteel, 64)
                .input(circuit, MarkerMaterials.Tier.HV, 64)
                .input(ENDER_EYE, 64)
                .output(SENSOR_HV, 64)
                .EUt(VA[HV])
                .duration(600)
                .tier(HV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .input(stickLong, Chrome, 32)
                .input(plateDouble, StainlessSteel, 64)
                .input(plateDouble, StainlessSteel, 64)
                .input(WRAP_CIRCUIT_HV, 4) // 4 * 16
                .input(ENDER_EYE, 64)
                .output(SENSOR_HV, 64)
                .EUt(VA[HV])
                .duration(600)
                .tier(HV)
                .buildAndRegister();

        //  EV (45s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .input(stickLong, Platinum, 32)
                .input(plateDouble, Titanium, 64)
                .input(plateDouble, Titanium, 64)
                .input(circuit, MarkerMaterials.Tier.EV, 64)
                .input(QUANTUM_EYE, 64)
                .output(SENSOR_EV, 64)
                .EUt(VA[EV])
                .duration(900)
                .tier(EV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .input(stickLong, Platinum, 32)
                .input(plateDouble, Titanium, 64)
                .input(plateDouble, Titanium, 64)
                .input(WRAP_CIRCUIT_EV, 4) // 4 * 16
                .input(QUANTUM_EYE, 64)
                .output(SENSOR_EV, 64)
                .EUt(VA[EV])
                .duration(900)
                .tier(EV)
                .buildAndRegister();

        //  IV (45s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .input(stickLong, Iridium, 32)
                .input(plateDouble, TungstenSteel, 64)
                .input(plateDouble, TungstenSteel, 64)
                .input(circuit, MarkerMaterials.Tier.IV, 64)
                .input(QUANTUM_STAR, 64)
                .output(SENSOR_IV, 64)
                .EUt(VA[IV])
                .duration(900)
                .tier(IV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .input(stickLong, Iridium, 32)
                .input(plateDouble, TungstenSteel, 64)
                .input(plateDouble, TungstenSteel, 64)
                .input(WRAP_CIRCUIT_IV, 4) // 4 * 16
                .input(QUANTUM_STAR, 64)
                .output(SENSOR_IV, 64)
                .EUt(VA[IV])
                .duration(900)
                .tier(IV)
                .buildAndRegister();

        //  LuV (60s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .input(frameGt, HSSS, 64)
                .input(ELECTRIC_MOTOR_LuV, 64)
                .input(plateDouble, Ruridit, 64)
                .input(plateDouble, Ruridit, 64)
                .input(QUANTUM_STAR, 64)
                .input(WRAP_CIRCUIT_LuV, 8) // 8 * 16 = 2 * 64
                .input(cableGtHex, NiobiumTitanium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 2 * 64))
                .fluidInputs(Palladium.getFluid(L * 24 * 64)) //  Foil (64 + 32 -> 16 * 4 + 8 * 4)
                .output(SENSOR_LuV, 64)
                .EUt(VA[LuV])
                .duration(1200)
                .tier(LuV)
                .buildAndRegister();

        //  ZPM (60s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .input(frameGt, NaquadahAlloy, 64)
                .input(ELECTRIC_MOTOR_ZPM, 64)
                .input(plateDouble, Osmiridium, 64)
                .input(plateDouble, Osmiridium, 64)
                .input(QUANTUM_STAR, 64)
                .input(QUANTUM_STAR, 64)
                .input(WRAP_CIRCUIT_ZPM, 8) // 8 * 16 = 2 * 64
                .input(cableGtHex, VanadiumGallium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 4 * 64))
                .fluidInputs(Trinium.getFluid(L * 24 * 64)) //  Foil (64 + 32 -> 16 * 4 + 8 * 4)
                .output(SENSOR_ZPM, 64)
                .EUt(VA[ZPM])
                .duration(1200)
                .tier(ZPM)
                .buildAndRegister();

        //  UV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .input(frameGt, Tritanium, 64)
                .input(ELECTRIC_MOTOR_UV, 64)
                .input(plateDouble, Tritanium, 64)
                .input(plateDouble, Tritanium, 64)
                .input(GRAVI_STAR, 64)
                .input(WRAP_CIRCUIT_UV, 8) // 8 * 16 = 2 * 64
                .input(cableGtHex, YttriumBariumCuprate, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 8 * 64))
                .fluidInputs(Naquadria.getFluid(L * 24 * 64 + L * 4 * 64)) // foil + recipe fluids
                .output(SENSOR_UV, 64)
                .EUt(VA[UV])
                .duration(1500)
                .tier(UV)
                .buildAndRegister();

        //  UHV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .input(frameGt, Adamantium, 64)
                .input(ELECTRIC_MOTOR_UHV, 64)
                .input(plateDouble, Adamantium, 64)
                .input(plateDouble, Adamantium, 64)
                .input(GRAVI_STAR, 64)
                .input(GRAVI_STAR, 64)
                .input(WRAP_CIRCUIT_UHV, 8) // 8 * 16 = 2 * 64
                .input(cableGtHex, Europium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 16 * 64))
                .fluidInputs(Vibranium.getFluid(L * 64)) // recipe fluids
                .fluidInputs(Orichalcum.getFluid(L * 24 * 64)) // foil
                .output(SENSOR_UHV, 64)
                .EUt(VA[UHV])
                .duration(1500)
                .tier(UHV)
                .buildAndRegister();

        //  UEV (90s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .input(frameGt, Hdcs, 64)
                .input(ELECTRIC_MOTOR_UEV, 64)
                .input(plateDouble, Hdcs, 64)
                .input(plateDouble, Hdcs, 64)
                .input(GRAVI_STAR, 64)
                .input(GRAVI_STAR, 64)
                .input(GRAVI_STAR, 64)
                .input(GRAVI_STAR, 64)
                .input(WRAP_CIRCUIT_UEV, 8) // 8 * 16 = 2 * 64
                .input(cableGtHex, PedotTMA, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 32 * 64))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2 * 64))
                .fluidInputs(Ichorium.getFluid(L * 64)) // recipe fluids
                .fluidInputs(Seaborgium.getFluid(L * 24 * 64)) // foil
                .output(SENSOR_UEV, 64)
                .EUt(VA[UEV])
                .duration(1800)
                .tier(UEV)
                .buildAndRegister();

        //  UIV (90s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .input(frameGt, Legendarium, 64)
                .input(ELECTRIC_MOTOR_UIV, 64)
                .input(plateDouble, Legendarium, 64)
                .input(plateDouble, Legendarium, 64)
                .input(UNSTABLE_STAR, 64)
                .input(WRAP_CIRCUIT_UIV, 8) // 8 * 16 = 2 * 64
                .input(cableGtHex, Solarium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 64 * 64))
                .fluidInputs(Zylon.getFluid(L * 4 * 64))
                .fluidInputs(Astralium.getFluid(L * 2 * 64)) // recipe fluids
                .fluidInputs(CelestialTungsten.getFluid(L * 24 * 64)) // foil
                .output(SENSOR_UIV, 64)
                .EUt(VA[UIV])
                .duration(1800)
                .tier(UIV)
                .buildAndRegister();

        //  UXV (105s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .input(frameGt, MagnetoHydrodynamicallyConstrainedStarMatter, 64)
                .input(ELECTRIC_MOTOR_UXV, 64)
                .input(plateDouble, MagnetoHydrodynamicallyConstrainedStarMatter, 64)
                .input(plateDouble, MagnetoHydrodynamicallyConstrainedStarMatter, 64)
                .input(UNSTABLE_STAR, 64)
                .input(UNSTABLE_STAR, 64)
                .input(WRAP_CIRCUIT_UXV, 8) // 8 * 16 = 2 * 64
                .input(cableGtHex, Hypogen, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 128 * 64))
                .fluidInputs(FullerenePolymerMatrix.getFluid(L * 8 * 64))
                .fluidInputs(Hikarium.getFluid(L * 4 * 64)) // recipe fluids
                .fluidInputs(WhiteDwarfMatter.getFluid(L * 24 * 64)) // foil
                .output(SENSOR_UXV, 64)
                .EUt(VA[UXV])
                .duration(2100)
                .tier(UXV)
                .buildAndRegister();

        //  OpV (105s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .input(frameGt, TranscendentMetal, 64)
                .input(ELECTRIC_MOTOR_OpV, 64)
                .input(plateDouble, TranscendentMetal, 64)
                .input(plateDouble, TranscendentMetal, 64)
                .input(UNSTABLE_STAR, 64)
                .input(UNSTABLE_STAR, 64)
                .input(UNSTABLE_STAR, 64)
                .input(UNSTABLE_STAR, 64)
                .input(WRAP_CIRCUIT_OpV, 8) // 8 * 16 = 2 * 64
                .input(cableGtHex, Galaxium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 256 * 64))
                .fluidInputs(CosmicFabric.getFluid(L * 16 * 64))
                .fluidInputs(Arcanium.getFluid(L * 8 * 64)) // recipe fluids
                .fluidInputs(Edenium.getFluid(L * 24 * 64)) // foil
                .output(SENSOR_OpV, 64)
                .EUt(VA[OpV])
                .duration(2100)
                .tier(OpV)
                .buildAndRegister();

        //  MAX (120s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .input(frameGt, Omnium, 64)
                .input(ELECTRIC_MOTOR_MAX, 64)
                .input(plateDouble, Omnium, 64)
                .input(plateDouble, Omnium, 64)
                .input(ZENITH_STAR, 64)
                .input(WRAP_CIRCUIT_MAX, 8)
                .input(cableGtHex, Universium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 512 * 64))
                .fluidInputs(SpacetimeContinuum.getFluid(L * 32 * 64))
                .fluidInputs(PrimordialMatter.getFluid(L * 16 * 64))
                .fluidInputs(Aetherium.getFluid(L * 24 * 64))
                .output(SENSOR_MAX, 64)
                .EUt(VA[MAX])
                .duration(2400)
                .tier(MAX)
                .buildAndRegister();
    }

    private static void FieldGen() {

        //  ULV (15s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(gem, Ruby, 64)
                .input(plateDouble, WroughtIron, 64)
                .input(circuit, MarkerMaterials.Tier.ULV, 64)
                .input(circuit, MarkerMaterials.Tier.ULV, 64)
                .input(pipeLargeFluid, Lead, 64)
                .input(pipeLargeFluid, Lead, 64)
                .input(pipeLargeFluid, Lead, 64)
                .input(pipeLargeFluid, Lead, 64)
                .output(FIELD_GENERATOR_ULV, 64)
                .EUt(VA[ULV])
                .duration(300)
                .tier(LV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(gem, Ruby, 64)
                .input(plateDouble, WroughtIron, 64)
                .input(WRAP_CIRCUIT_ULV, 8) // 8 * 16 = 2 * 64
                .input(pipeLargeFluid, Lead, 64)
                .input(pipeLargeFluid, Lead, 64)
                .input(pipeLargeFluid, Lead, 64)
                .input(pipeLargeFluid, Lead, 64)
                .output(FIELD_GENERATOR_ULV, 64)
                .EUt(VA[ULV])
                .duration(300)
                .tier(LV)
                .buildAndRegister();

        //  LV (15s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ENDER_PEARL, 64)
                .input(plateDouble, Steel, 64)
                .input(circuit, MarkerMaterials.Tier.LV, 64)
                .input(circuit, MarkerMaterials.Tier.LV, 64)
                .input(wireGtHex, ManganesePhosphide, 64)
                .output(FIELD_GENERATOR_LV, 64)
                .EUt(VA[LV])
                .duration(300)
                .tier(LV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ENDER_PEARL, 64)
                .input(plateDouble, Steel, 64)
                .input(WRAP_CIRCUIT_LV, 8) // 8 * 16 = 2 * 64
                .input(wireGtHex, ManganesePhosphide, 64)
                .output(FIELD_GENERATOR_LV, 64)
                .EUt(VA[LV])
                .duration(300)
                .tier(LV)
                .buildAndRegister();

        //  MV (30s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ENDER_EYE, 64)
                .input(plateDouble, Aluminium, 64)
                .input(circuit, MarkerMaterials.Tier.MV, 64)
                .input(circuit, MarkerMaterials.Tier.MV, 64)
                .input(wireGtHex, MagnesiumDiboride, 64)
                .output(FIELD_GENERATOR_MV, 64)
                .EUt(VA[MV])
                .duration(600)
                .tier(MV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ENDER_EYE, 64)
                .input(plateDouble, Aluminium, 64)
                .input(WRAP_CIRCUIT_MV, 8) // 8 * 16 = 2 * 64
                .input(wireGtHex, MagnesiumDiboride, 64)
                .output(FIELD_GENERATOR_MV, 64)
                .EUt(VA[MV])
                .duration(600)
                .tier(MV)
                .buildAndRegister();

        //  HV (30s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(QUANTUM_EYE, 64)
                .input(plateDouble, StainlessSteel, 64)
                .input(circuit, MarkerMaterials.Tier.HV, 64)
                .input(circuit, MarkerMaterials.Tier.HV, 64)
                .input(wireGtHex, MercuryBariumCalciumCuprate, 64)
                .output(FIELD_GENERATOR_HV, 64)
                .EUt(VA[HV])
                .duration(600)
                .tier(HV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(QUANTUM_EYE, 64)
                .input(plateDouble, StainlessSteel, 64)
                .input(WRAP_CIRCUIT_HV, 8) // 8 * 16 = 2 * 64
                .input(wireGtHex, MercuryBariumCalciumCuprate, 64)
                .output(FIELD_GENERATOR_HV, 64)
                .EUt(VA[HV])
                .duration(600)
                .tier(HV)
                .buildAndRegister();

        //  EV (45s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(NETHER_STAR, 64)
                .input(plateDouble, Titanium, 64)
                .input(plateDouble, Titanium, 64)
                .input(circuit, MarkerMaterials.Tier.EV, 64)
                .input(circuit, MarkerMaterials.Tier.EV, 64)
                .input(wireGtHex, UraniumTriplatinum, 64)
                .output(FIELD_GENERATOR_EV, 64)
                .EUt(VA[EV])
                .duration(900)
                .tier(EV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(NETHER_STAR, 64)
                .input(plateDouble, Titanium, 64)
                .input(plateDouble, Titanium, 64)
                .input(WRAP_CIRCUIT_EV, 8) // 8 * 16 = 2 * 64
                .input(wireGtHex, UraniumTriplatinum, 64)
                .output(FIELD_GENERATOR_EV, 64)
                .EUt(VA[EV])
                .duration(900)
                .tier(EV)
                .buildAndRegister();

        //  IV (45s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(QUANTUM_STAR, 64)
                .input(plateDouble, TungstenSteel, 64)
                .input(plateDouble, TungstenSteel, 64)
                .input(circuit, MarkerMaterials.Tier.IV, 64)
                .input(circuit, MarkerMaterials.Tier.IV, 64)
                .input(wireGtHex, SamariumIronArsenicOxide, 64)
                .output(FIELD_GENERATOR_IV, 64)
                .EUt(VA[IV])
                .duration(900)
                .tier(IV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(QUANTUM_STAR, 64)
                .input(plateDouble, TungstenSteel, 64)
                .input(plateDouble, TungstenSteel, 64)
                .input(WRAP_CIRCUIT_IV, 8) // 8 * 16 = 2 * 64
                .input(wireGtHex, SamariumIronArsenicOxide, 64)
                .output(FIELD_GENERATOR_IV, 64)
                .EUt(VA[IV])
                .duration(900)
                .tier(IV)
                .buildAndRegister();

        //  LuV (60s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, HSSS, 64)
                .input(plateDouble, HSSS, 64)
                .input(plateDouble, HSSS, 64)
                .input(plateDouble, HSSS, 64)
                .input(QUANTUM_STAR, 64)
                .input(EMITTER_LuV, 64)
                .input(EMITTER_LuV, 64)
                .input(WRAP_CIRCUIT_LuV, 8) // 8 * 16 = 2 * 64
                .input(cableGtHex, NiobiumTitanium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 4 * 64))
                .fluidInputs(IndiumTinBariumTitaniumCuprate.getFluid(L * 16 * 64)) // Fine Wire (1 Ingot -> 8, 16 * 8 -> 64 * 2)
                .output(FIELD_GENERATOR_LuV, 64)
                .EUt(VA[LuV])
                .duration(1200)
                .tier(LuV)
                .buildAndRegister();

        //  ZPM (60s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, NaquadahAlloy, 64)
                .input(plateDouble, NaquadahAlloy, 64)
                .input(plateDouble, NaquadahAlloy, 64)
                .input(plateDouble, NaquadahAlloy, 64)
                .input(QUANTUM_STAR, 64)
                .input(EMITTER_ZPM, 64)
                .input(EMITTER_ZPM, 64)
                .input(WRAP_CIRCUIT_ZPM, 8) // 8 * 16 = 2 * 64
                .input(cableGtHex, VanadiumGallium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 8 * 64))
                .fluidInputs(UraniumRhodiumDinaquadide.getFluid(L * 16 * 64)) // Fine Wire (1 Ingot -> 8, 16 * 8 -> 64 * 2)
                .output(FIELD_GENERATOR_ZPM, 64)
                .EUt(VA[ZPM])
                .duration(1200)
                .tier(ZPM)
                .buildAndRegister();

        //  UV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Tritanium, 64)
                .input(plateDouble, Tritanium, 64)
                .input(plateDouble, Tritanium, 64)
                .input(plateDouble, Tritanium, 64)
                .input(GRAVI_STAR, 64)
                .input(EMITTER_UV, 64)
                .input(EMITTER_UV, 64)
                .input(WRAP_CIRCUIT_UV, 8) // 8 * 16 = 2 * 64
                .input(cableGtHex, YttriumBariumCuprate, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 12 * 64))
                .fluidInputs(Naquadria.getFluid(L * 4 * 64))
                .fluidInputs(EnrichedNaquadahTriniumEuropiumDuranide.getFluid(L * 16 * 64)) // Fine Wire (1 Ingot -> 8, 16 * 8 -> 64 * 2)
                .output(FIELD_GENERATOR_UV, 64)
                .EUt(VA[UV])
                .duration(1500)
                .tier(UV)
                .buildAndRegister();

        //  UHV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Adamantium, 64)
                .input(plateDouble, Adamantium, 64)
                .input(plateDouble, Adamantium, 64)
                .input(plateDouble, Adamantium, 64)
                .input(GRAVI_STAR, 64)
                .input(GRAVI_STAR, 64)
                .input(EMITTER_UHV, 64)
                .input(EMITTER_UHV, 64)
                .input(WRAP_CIRCUIT_UHV, 8) // 8 * 16 = 2 * 64
                .input(cableGtHex, Europium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 16 * 64))
                .fluidInputs(Vibranium.getFluid(L * 64))
                .fluidInputs(PedotPSS.getFluid(L * 16 * 64)) // wire fine
                .output(FIELD_GENERATOR_UHV, 64)
                .EUt(VA[UHV])
                .duration(1500)
                .tier(UHV)
                .buildAndRegister();

        //  UEV (90s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Hdcs, 64)
                .input(plateDouble, Hdcs, 64)
                .input(plateDouble, Hdcs, 64)
                .input(plateDouble, Hdcs, 64)
                .input(GRAVI_STAR, 64)
                .input(GRAVI_STAR, 64)
                .input(GRAVI_STAR, 64)
                .input(GRAVI_STAR, 64)
                .input(EMITTER_UEV, 64)
                .input(EMITTER_UEV, 64)
                .input(WRAP_CIRCUIT_UEV, 8) // 8 * 16 = 2 * 64
                .input(cableGtHex, PedotTMA, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 20 * 64))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2 * 64))
                .fluidInputs(Ichorium.getFluid(L * 64))
                .fluidInputs(QuantumAlloy.getFluid(L * 16 * 64)) // wire fine
                .output(FIELD_GENERATOR_UEV, 64)
                .EUt(VA[UEV])
                .duration(1800)
                .tier(UEV)
                .buildAndRegister();

        //  UIV (90s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Legendarium, 64)
                .input(plateDouble, Legendarium, 64)
                .input(plateDouble, Legendarium, 64)
                .input(plateDouble, Legendarium, 64)
                .input(UNSTABLE_STAR, 64)
                .input(EMITTER_UIV, 64)
                .input(EMITTER_UIV, 64)
                .input(WRAP_CIRCUIT_UIV, 8) // 8 * 16 = 2 * 64
                .input(cableGtHex, Solarium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 24 * 64))
                .fluidInputs(Zylon.getFluid(L * 4 * 64))
                .fluidInputs(Astralium.getFluid(L * 2 * 64))
                .fluidInputs(FullereneSuperconductor.getFluid(L * 16 * 64)) // wire fine
                .output(FIELD_GENERATOR_UIV, 64)
                .EUt(VA[UIV])
                .duration(1800)
                .tier(UIV)
                .buildAndRegister();

        //  UXV (105s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, MagnetoHydrodynamicallyConstrainedStarMatter, 64)
                .input(plateDouble, MagnetoHydrodynamicallyConstrainedStarMatter, 64)
                .input(plateDouble, MagnetoHydrodynamicallyConstrainedStarMatter, 64)
                .input(plateDouble, MagnetoHydrodynamicallyConstrainedStarMatter, 64)
                .input(UNSTABLE_STAR, 64)
                .input(UNSTABLE_STAR, 64)
                .input(EMITTER_UXV, 64)
                .input(EMITTER_UXV, 64)
                .input(WRAP_CIRCUIT_UXV, 8) // 8 * 16 = 2 * 64
                .input(cableGtHex, Hypogen, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 28 * 64))
                .fluidInputs(FullerenePolymerMatrix.getFluid(L * 8 * 64))
                .fluidInputs(Hikarium.getFluid(L * 4 * 64))
                .fluidInputs(BoronFranciumCarbideSuperconductor.getFluid(L * 16 * 64)) // wire fine
                .output(FIELD_GENERATOR_UXV, 64)
                .EUt(VA[UXV])
                .duration(2100)
                .tier(UXV)
                .buildAndRegister();

        //  OpV (105s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, TranscendentMetal, 64)
                .input(plateDouble, TranscendentMetal, 64)
                .input(plateDouble, TranscendentMetal, 64)
                .input(plateDouble, TranscendentMetal, 64)
                .input(UNSTABLE_STAR, 64)
                .input(UNSTABLE_STAR, 64)
                .input(UNSTABLE_STAR, 64)
                .input(UNSTABLE_STAR, 64)
                .input(EMITTER_OpV, 64)
                .input(EMITTER_OpV, 64)
                .input(WRAP_CIRCUIT_OpV, 8) // 8 * 16 = 2 * 64
                .input(cableGtHex, Galaxium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 32 * 64))
                .fluidInputs(CosmicFabric.getFluid(L * 16 * 64))
                .fluidInputs(Arcanium.getFluid(L * 8 * 64))
                .fluidInputs(NeutroniumSuperconductor.getFluid(L * 16 * 64)) // wire fine
                .output(FIELD_GENERATOR_OpV, 64)
                .EUt(VA[OpV])
                .duration(2100)
                .tier(OpV)
                .buildAndRegister();

        //  MAX (120s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Omnium, 64)
                .input(plateDouble, Omnium, 64)
                .input(plateDouble, Omnium, 64)
                .input(plateDouble, Omnium, 64)
                .input(ZENITH_STAR, 64)
                .input(EMITTER_MAX, 64)
                .input(EMITTER_MAX, 64)
                .input(WRAP_CIRCUIT_MAX, 8)
                .input(cableGtHex, Universium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 64 * 64))
                .fluidInputs(SpacetimeContinuum.getFluid(L * 32 * 64))
                .fluidInputs(PrimordialMatter.getFluid(L * 16 * 64))
                .fluidInputs(CosmicMatterSuperconductor.getFluid(L * 16 * 64))
                .output(FIELD_GENERATOR_MAX, 64)
                .EUt(VA[MAX])
                .duration(2400)
                .tier(MAX)
                .buildAndRegister();
    }

    private static void WrapItems() {

        //  Wrap circuits for Robot arm, Emitter, Sensor and Field Generator recipes in Component Assembly Line.
        //  In old version, 1 wrap item = 64 item, but we need more soft than 1 stack...
        //  In some machine (e.g. Large Circuit Assembly Line), maybe this setting is useful.
        PACKER_RECIPES.recipeBuilder()
                .input(circuit, MarkerMaterials.Tier.ULV, 16)
                .circuitMeta(16)
                .output(WRAP_CIRCUIT_ULV)
                .EUt(VA[ULV])
                .duration(100)
                .buildAndRegister();

        PACKER_RECIPES.recipeBuilder()
                .input(circuit, MarkerMaterials.Tier.LV, 16)
                .circuitMeta(16)
                .output(WRAP_CIRCUIT_LV)
                .EUt(VA[ULV])
                .duration(100)
                .buildAndRegister();

        PACKER_RECIPES.recipeBuilder()
                .input(circuit, MarkerMaterials.Tier.MV, 16)
                .circuitMeta(16)
                .output(WRAP_CIRCUIT_MV)
                .EUt(VA[ULV])
                .duration(100)
                .buildAndRegister();

        PACKER_RECIPES.recipeBuilder()
                .input(circuit, MarkerMaterials.Tier.HV, 16)
                .circuitMeta(16)
                .output(WRAP_CIRCUIT_HV)
                .EUt(VA[ULV])
                .duration(100)
                .buildAndRegister();

        PACKER_RECIPES.recipeBuilder()
                .input(circuit, MarkerMaterials.Tier.EV, 16)
                .circuitMeta(16)
                .output(WRAP_CIRCUIT_EV)
                .EUt(VA[ULV])
                .duration(100)
                .buildAndRegister();

        PACKER_RECIPES.recipeBuilder()
                .input(circuit, MarkerMaterials.Tier.IV, 16)
                .circuitMeta(16)
                .output(WRAP_CIRCUIT_IV)
                .EUt(VA[ULV])
                .duration(100)
                .buildAndRegister();

        PACKER_RECIPES.recipeBuilder()
                .input(circuit, MarkerMaterials.Tier.LuV, 16)
                .circuitMeta(16)
                .output(WRAP_CIRCUIT_LuV)
                .EUt(VA[ULV])
                .duration(100)
                .buildAndRegister();

        PACKER_RECIPES.recipeBuilder()
                .input(circuit, MarkerMaterials.Tier.ZPM, 16)
                .circuitMeta(16)
                .output(WRAP_CIRCUIT_ZPM)
                .EUt(VA[ULV])
                .duration(100)
                .buildAndRegister();

        PACKER_RECIPES.recipeBuilder()
                .input(circuit, MarkerMaterials.Tier.UV, 16)
                .circuitMeta(16)
                .output(WRAP_CIRCUIT_UV)
                .EUt(VA[ULV])
                .duration(100)
                .buildAndRegister();

        PACKER_RECIPES.recipeBuilder()
                .input(circuit, MarkerMaterials.Tier.UHV, 16)
                .circuitMeta(16)
                .output(WRAP_CIRCUIT_UHV)
                .EUt(VA[ULV])
                .duration(100)
                .buildAndRegister();

        PACKER_RECIPES.recipeBuilder()
                .input(circuit, MarkerMaterials.Tier.UEV, 16)
                .circuitMeta(16)
                .output(WRAP_CIRCUIT_UEV)
                .EUt(VA[ULV])
                .duration(100)
                .buildAndRegister();

        PACKER_RECIPES.recipeBuilder()
                .input(circuit, MarkerMaterials.Tier.UIV, 16)
                .circuitMeta(16)
                .output(WRAP_CIRCUIT_UIV)
                .EUt(VA[ULV])
                .duration(100)
                .buildAndRegister();

        PACKER_RECIPES.recipeBuilder()
                .input(circuit, MarkerMaterials.Tier.UXV, 16)
                .circuitMeta(16)
                .output(WRAP_CIRCUIT_UXV)
                .EUt(VA[ULV])
                .duration(100)
                .buildAndRegister();

        PACKER_RECIPES.recipeBuilder()
                .input(circuit, MarkerMaterials.Tier.OpV, 16)
                .circuitMeta(16)
                .output(WRAP_CIRCUIT_OpV)
                .EUt(VA[ULV])
                .duration(100)
                .buildAndRegister();

        PACKER_RECIPES.recipeBuilder()
                .input(circuit, MarkerMaterials.Tier.MAX, 16)
                .circuitMeta(16)
                .output(WRAP_CIRCUIT_MAX)
                .EUt(VA[ULV])
                .duration(100)
                .buildAndRegister();

    }
}
