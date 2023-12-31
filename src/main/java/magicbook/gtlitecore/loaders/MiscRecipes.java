package magicbook.gtlitecore.loaders;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.stack.UnificationEntry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gregtechfoodoption.GTFOMaterialHandler.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.BURNER_REACTOR_RECIPES;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.CVD_UNIT_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class MiscRecipes {

    public static void init() {
        MixerRecipes();
        ToolRecipes();
        OtherRecipes();
    }

    private static void MixerRecipes() {

        //  Blazing Pyrotheum
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Redstone)
                .input(dust, Sulfur)
                .fluidInputs(Blaze.getFluid(L * 2))
                .fluidOutputs(BlazingPyrotheum.getFluid(4000))
                .EUt(VA[MV])
                .duration(120)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(BlazingPyrotheum.getFluid(4000))
                .output(dust, Redstone)
                .output(dust, Sulfur)
                .fluidOutputs(Blaze.getFluid(L * 2))
                .EUt(VA[LV])
                .duration(240)
                .buildAndRegister();

        //  Gelid Cryotheum
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Electrotine)
                .input(Items.SNOWBALL)
                .fluidInputs(Ice.getFluid(2000))
                .fluidOutputs(GelidCryotheum.getFluid(4000))
                .EUt(VA[MV])
                .duration(120)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(GelidCryotheum.getFluid(4000))
                .output(dust, Electrotine)
                .output(Items.SNOWBALL)
                .fluidOutputs(Ice.getFluid(2000))
                .EUt(VA[LV])
                .duration(240)
                .buildAndRegister();

        //  Eglin Steel Base
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Iron, 4)
                .input(dust, Kanthal)
                .input(dust, Invar, 5)
                .circuitMeta(10)
                .output(dust, EglinSteelBase, 10)
                .EUt(VA[MV])
                .duration(100)
                .buildAndRegister();

        //  Eglin Steel
        MIXER_RECIPES.recipeBuilder()
                .input(dust, EglinSteelBase, 10)
                .input(dust, Sulfur)
                .input(dust, Silicon)
                .input(dust, Carbon)
                .circuitMeta(13)
                .output(dust, EglinSteel, 13)
                .EUt(VA[MV])
                .duration(120)
                .buildAndRegister();

        //  Silicon Carbide
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Graphite)
                .input(dust, Silicon)
                .circuitMeta(2)
                .output(dust, SiliconCarbide, 2)
                .duration(300)
                .EUt(VA[EV])
                .buildAndRegister();

        //  MAR-Ce-M200 Steel
        MIXER_RECIPES.recipeBuilder()
                .input(dust, MARM200Steel, 18)
                .input(dust, Cerium)
                .output(dust, MARM200CeSteel, 19)
                .EUt(VA[IV])
                .duration(350)
                .buildAndRegister();

        //  Zirconium Carbide
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Zirconium)
                .input(dust, Carbon)
                .circuitMeta(2)
                .output(dust, ZirconiumCarbide, 2)
                .EUt(VA[MV])
                .duration(120)
                .buildAndRegister();

        //  Maraging Steel 250
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Steel, 16)
                .input(dust, Molybdenum)
                .input(dust, Titanium)
                .input(dust, Nickel, 4)
                .input(dust, Cobalt, 2)
                .circuitMeta(24)
                .output(dust, MaragingSteel250, 24)
                .EUt(VA[EV])
                .duration(200)
                .buildAndRegister();

        //  HG-1223
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Barium, 2)
                .input(dust, Calcium, 2)
                .input(dust, Copper, 3)
                .fluidInputs(Mercury.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(8000))
                .circuitMeta(16)
                .output(dust, HG1223, 16)
                .EUt(VA[EV])
                .duration(240)
                .buildAndRegister();

        //  Staballoy
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Uranium238, 9)
                .input(dust, Titanium)
                .circuitMeta(10)
                .output(dust, Staballoy, 10)
                .EUt(VA[EV])
                .duration(260)
                .buildAndRegister();

        //  HMS-1J22 Alloy
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Nickel, 12)
                .input(dust, TinAlloy, 8)
                .input(dust, Chrome, 4)
                .input(dust, Phosphorus, 2)
                .input(dust, Silicon, 2)
                .circuitMeta(28)
                .output(dust, HMS1J22Alloy, 28)
                .EUt(VA[EV])
                .duration(580)
                .buildAndRegister();

        //  Inconel-792
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Nickel, 2)
                .input(dust, Niobium)
                .input(dust, Aluminium, 2)
                .input(dust, Nichrome)
                .circuitMeta(6)
                .output(dust, Inconel792, 6)
                .EUt(VA[IV])
                .duration(250)
                .buildAndRegister();

        //  Stellite
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Chrome, 9)
                .input(dust, Cobalt, 9)
                .input(dust, Manganese, 5)
                .input(dust, Titanium)
                .circuitMeta(24)
                .output(dust, Stellite, 24)
                .EUt(VA[EV])
                .duration(310)
                .buildAndRegister();

        //  Talonite
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Cobalt, 4)
                .input(dust, Chrome, 3)
                .input(dust, Phosphorus, 2)
                .input(dust, Molybdenum)
                .circuitMeta(10)
                .output(dust, Talonite, 10)
                .EUt(VA[HV])
                .duration(340)
                .buildAndRegister();

        //  Super Austenitic Stainless Steel-904L
        MIXER_RECIPES.recipeBuilder()
                .input(dust, StainlessSteel, 8)
                .input(dust, NickelZincFerrite, 4)
                .input(dust, Kanthal, 4)
                .input(dust, Molybdenum, 4)
                .circuitMeta(20)
                .output(dust, AusteniticStainlessSteel904L, 20)
                .EUt(VA[EV])
                .duration(600)
                .buildAndRegister();

        //  Tanmolyium Beta-C
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Titanium, 5)
                .input(dust, Molybdenum, 5)
                .input(dust, Vanadium, 2)
                .input(dust, Chrome, 3)
                .input(dust, Aluminium)
                .circuitMeta(16)
                .output(dust, TanmolyiumBetaC, 16)
                .EUt(VA[EV])
                .duration(400)
                .buildAndRegister();

        //  Oganesson Breeding Base
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Titanium.getFluid(L * 2))
                .fluidInputs(Californium.getFluid(L * 2))
                .fluidOutputs(OganessonBreedingBase.getFluid(L * 4))
                .EUt(VA[IV])
                .duration(120)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Radium-Radon Mixture
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Radium.getFluid(1000))
                .fluidInputs(Radon.getFluid(1000))
                .fluidOutputs(RadiumRadonMixture.getFluid(1000))
                .EUt(VA[ZPM])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(RadiumRadonMixture.getFluid(1000))
                .fluidOutputs(Radium.getFluid(1000))
                .fluidOutputs(Radon.getFluid(1000))
                .EUt(VA[LV])
                .duration(360)
                .buildAndRegister();

        //  Scandium-Titanium Mixture
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Scandium.getFluid(L))
                .fluidInputs(Titanium.getFluid(L))
                .fluidOutputs(ScandiumTitaniumMixture.getFluid(L * 2))
                .EUt(VA[ZPM])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(ScandiumTitaniumMixture.getFluid(L * 2))
                .fluidOutputs(Scandium.getFluid(L))
                .fluidOutputs(Titanium.getFluid(L))
                .EUt(VA[LV])
                .duration(360)
                .buildAndRegister();

        //  Lithium Titanate

        //  TiCl4 + 2N2O4 + 2O -> Ti(NO3)4 + 4Cl
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(TitaniumTetrachloride.getFluid(1000))
                .fluidInputs(DinitrogenTetroxide.getFluid(2000))
                .fluidInputs(Oxygen.getFluid(2000))
                .output(dust, TitaniumNitrate, 17)
                .fluidOutputs(Chlorine.getFluid(4000))
                .EUt(VA[EV])
                .duration(230)
                .buildAndRegister();

        //  Ti(NO3)4 + 2NaOH -> Li2TiO3 + Na2CO3 + 4HNO3
        BLAST_RECIPES.recipeBuilder()
                .input(dust, TitaniumNitrate, 17)
                .input(dust, SodiumHydroxide, 6)
                .inputs(LithiumCarbonate.getItemStack(6))
                .output(ingotHot, LithiumTitanate, 6)
                .output(dust, SodaAsh, 6)
                .fluidOutputs(NitricAcid.getFluid(4000))
                .EUt(VA[EV])
                .duration(320)
                .blastFurnaceTemp(3100)
                .buildAndRegister();

        //  Fracturing Fluid
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Alumina)
                .input(dust, Iodine)
                .input("blockSand", 3)
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(FracuringFluid.getFluid(1000))
                .duration(100)
                .EUt(VA[IV])
                .buildAndRegister();

        //  Starlight Liquid
        CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(EMITTER_UV)
                .input(dust, Celestite)
                .fluidInputs(NetherStar.getFluid(16))
                .fluidInputs(Ice.getFluid(1000))
                .fluidOutputs(StarlightLiquid.getFluid(1000))
                .EUt(VA[UV])
                .duration(20)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Celestial Crystal
        AUTOCLAVE_RECIPES.recipeBuilder()
                .notConsumable(dust, AstralTitanium)
                .input(dust, Quartzite)
                .fluidInputs(StarlightLiquid.getFluid(L))
                .output(gem, CelestialCrystal)
                .EUt(VA[UHV])
                .duration(20)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder()
                .notConsumable(dust, CelestialTungsten)
                .input(dust, Quartzite)
                .fluidInputs(StarlightLiquid.getFluid(L))
                .output(gem, CelestialCrystal)
                .EUt(VA[UHV])
                .duration(20)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder()
                .notConsumable(dust, AstralTitanium)
                .input(dust, NetherQuartz)
                .fluidInputs(StarlightLiquid.getFluid(L))
                .output(gem, CelestialCrystal)
                .EUt(VA[UHV])
                .duration(20)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder()
                .notConsumable(dust, CelestialTungsten)
                .input(dust, NetherQuartz)
                .fluidInputs(StarlightLiquid.getFluid(L))
                .output(gem, CelestialCrystal)
                .EUt(VA[UHV])
                .duration(20)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder()
                .notConsumable(dust, AstralTitanium)
                .input(dust, CertusQuartz)
                .fluidInputs(StarlightLiquid.getFluid(L))
                .output(gem, CelestialCrystal)
                .EUt(VA[UHV])
                .duration(20)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder()
                .notConsumable(dust, CelestialTungsten)
                .input(dust, CertusQuartz)
                .fluidInputs(StarlightLiquid.getFluid(L))
                .output(gem, CelestialCrystal)
                .EUt(VA[UHV])
                .duration(20)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Astralium
        PYROLYSE_RECIPES.recipeBuilder()
                .input(dust, CelestialCrystal)
                .notConsumable(stickLong, CarbonNanotube)
                .fluidInputs(NaquadahEnriched.getFluid(L))
                .output(ingotHot, Astralium)
                .fluidOutputs(Naquadah.getFluid(L / 4))
                .EUt(VA[UEV])
                .duration(200)
                .buildAndRegister();

        //  Nitinol-60
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Nickel, 2)
                .input(dust, Titanium, 3)
                .circuitMeta(5)
                .output(dust, Nitinol60, 5)
                .EUt(VA[EV])
                .duration(100)
                .buildAndRegister();

    }

    private static void OtherRecipes() {

        //  Gravi Star
        GTRecipeHandler.removeRecipesByInputs(AUTOCLAVE_RECIPES,
                new ItemStack[]{QUANTUM_STAR.getStackForm()},
                new FluidStack[]{Neutronium.getFluid(288)});

        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(QUANTUM_STAR)
                .fluidInputs(Orichalcum.getFluid(288))
                .output(GRAVI_STAR)
                .EUt(VA[IV])
                .duration(480)
                .buildAndRegister();

        //  Unstable Star
        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(GRAVI_STAR)
                .fluidInputs(Rhugnor.getFluid(288))
                .output(UNSTABLE_STAR)
                .EUt(VA[LuV])
                .duration(240)
                .buildAndRegister();

        //  Zenith Star
        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(UNSTABLE_STAR)
                .fluidInputs(CosmicComputingMixture.getFluid(288))
                .output(ZENITH_STAR)
                .EUt(VA[ZPM])
                .duration(120)
                .buildAndRegister();

        //  Chromatic Lens
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(lens, NetherStar)
                .fluidInputs(RainbowSap.getFluid(L * 2))
                .output(CHROMATIC_LENS)
                .EUt(VA[UV])
                .duration(200)
                .buildAndRegister();
    }

    private static void ToolRecipes() {

        //  c-BN sawblade
        LATHE_RECIPES.recipeBuilder()
                .input(gemExquisite, CubicBoronNitride)
                .output(toolHeadBuzzSaw, CubicBoronNitride)
                .duration((int) (CubicBoronNitride.getMass() * 4))
                .EUt(240)
                .buildAndRegister();

        //  Boron Nitride Grinder
        ModHandler.addShapedRecipe("component_grinder_boron_nitride", COMPONENT_GRINDER_BORON_NITRIDE.getStackForm(),
                "PDP", "DGD", "PDP",
                'P', new UnificationEntry(plate, CubicBoronNitride),
                'D', new UnificationEntry(plateDouble, Vibranium),
                'G', new UnificationEntry(gem, CubicHeterodiamond));

        //  Celestial Crystal Grinder
        ModHandler.addShapedRecipe("component_grinder_celestial_crystal", COMPONENT_GRINDER_BLACK_PLUTONIUM.getStackForm(),
                "PDP", "DGD", "PDP",
                'P', new UnificationEntry(plate, BlackPlutonium),
                'D', new UnificationEntry(plateDouble, BlackTitanium),
                'G', new UnificationEntry(gem, CelestialCrystal));

        //  Prospector EV
        ModHandler.addShapedRecipe(true, "prospector_ev.battery", PROSPECTOR_EV.getStackForm(),
                "EPS", "XCX", "PBP",
                'E', EMITTER_EV,
                'S', SENSOR_EV,
                'P', new UnificationEntry(plate, Titanium),
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.EV),
                'C', COVER_SCREEN,
                'B', BATTERY_EV_VANADIUM);

        ModHandler.addShapedRecipe(true, "prospector_ev.lapotron", PROSPECTOR_EV.getStackForm(),
                "EPS", "XCX", "PBP",
                'E', EMITTER_EV,
                'S', SENSOR_EV,
                'P', new UnificationEntry(plate, Titanium),
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.EV),
                'C', COVER_SCREEN,
                'B', LAPOTRON_CRYSTAL);

        //  Prospector ZPM
        ModHandler.addShapedRecipe(true, "prospector_zpm.battery", PROSPECTOR_ZPM.getStackForm(),
                "EPS", "XCX", "PBP",
                'E', EMITTER_ZPM,
                'S', SENSOR_ZPM,
                'P', new UnificationEntry(plate, NaquadahAlloy),
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.ZPM),
                'C', COVER_SCREEN,
                'B', BATTERY_ZPM_NAQUADRIA);

        ModHandler.addShapedRecipe(true, "prospector_zpm.lapotron", PROSPECTOR_ZPM.getStackForm(),
                "EPS", "XCX", "PBP",
                'E', EMITTER_ZPM,
                'S', SENSOR_ZPM,
                'P', new UnificationEntry(plate, NaquadahAlloy),
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.ZPM),
                'C', COVER_SCREEN,
                'B', ENERGY_MODULE);

        //  UHV Battery Hull
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Europium, 4)
                .input(plate, Tritanium, 2)
                .input(plate, LithiumSulfide, 2)
                .fluidInputs(KaptonK.getFluid(L))
                .output(BATTERY_HULL_SMALL_LITHIUM_SULFIDE)
                .EUt(VA[UV])
                .duration(100)
                .buildAndRegister();

        //  UEV Battery Hull
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, PedotTMA, 4)
                .input(plate, Adamantium, 6)
                .input(plate, LithiumSulfide, 6)
                .fluidInputs(KaptonE.getFluid(L))
                .output(BATTERY_HULL_MEDIUM_LITHIUM_SULFIDE)
                .EUt(VA[UHV])
                .duration(100)
                .buildAndRegister();

        //  UIV Battery Hull
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Solarium, 4)
                .input(plate, Infinity, 18)
                .input(plate, LithiumSulfide, 18)
                .fluidInputs(Polyetheretherketone.getFluid(L))
                .output(BATTERY_HULL_LARGE_LITHIUM_SULFIDE)
                .EUt(VA[UEV])
                .duration(100)
                .buildAndRegister();

        //  UXV Battery Hull
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Hypogen, 4)
                .input(plate, Orichalcum, 2)
                .input(plate, LanthanumNickelOxide, 2)
                .fluidInputs(Zylon.getFluid(L))
                .output(BATTERY_HULL_SMALL_LANTHANUM_NICKEL_OXIDE)
                .EUt(VA[UIV])
                .duration(100)
                .buildAndRegister();

        //  OpV Battery Hull
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Galaxium, 4)
                .input(plate, Mithril, 6)
                .input(plate, LanthanumNickelOxide, 6)
                .fluidInputs(Kevlar.getFluid(L))
                .output(BATTERY_HULL_MEDIUM_LANTHANUM_NICKEL_OXIDE)
                .EUt(VA[UXV])
                .duration(100)
                .buildAndRegister();

        //  MAX Battery Hull
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Universium, 4)
                .input(plate, Astralium, 18)
                .input(plate, LanthanumNickelOxide, 18)
                .fluidInputs(FullerenePolymerMatrix.getFluid(L))
                .output(BATTERY_HULL_LARGE_LANTHANUM_NICKEL_OXIDE)
                .EUt(VA[OpV])
                .duration(100)
                .buildAndRegister();

        //  Small Lithium Sulfide Battery
        CANNER_RECIPES.recipeBuilder()
                .input(BATTERY_HULL_SMALL_LITHIUM_SULFIDE)
                .input(dust, LithiumTrifluoromethansulphonate, 2)
                .output(BATTERY_UHV_LITHIUM_SULFIDE)
                .EUt(VA[UV])
                .duration(100)
                .buildAndRegister();

        //  Medium Lithium Sulfide Battery
        CANNER_RECIPES.recipeBuilder()
                .input(BATTERY_HULL_MEDIUM_LITHIUM_SULFIDE)
                .input(dust, LithiumTrifluoromethansulphonate, 8)
                .output(BATTERY_UEV_LITHIUM_SULFIDE)
                .EUt(VA[UHV])
                .duration(400)
                .buildAndRegister();

        //  Large Lithium Sulfide Battery
        CANNER_RECIPES.recipeBuilder()
                .input(BATTERY_HULL_LARGE_LITHIUM_SULFIDE)
                .input(dust, LithiumTrifluoromethansulphonate, 16)
                .output(BATTERY_UIV_LITHIUM_SULFIDE)
                .EUt(VA[UEV])
                .duration(1600)
                .buildAndRegister();

        //  Small Lanthanum Nickel Oxide Battery
        CANNER_RECIPES.recipeBuilder()
                .input(BATTERY_HULL_SMALL_LANTHANUM_NICKEL_OXIDE)
                .input(dust, BerylliumDifluoride, 2)
                .fluidInputs(RadonDifluoride.getFluid(1000))
                .output(BATTERY_UXV_LANTHANUM_NICKEL_OXIDE)
                .EUt(VA[UIV])
                .duration(100)
                .buildAndRegister();

        //  Medium Lanthanum Nickel Oxide Battery
        CANNER_RECIPES.recipeBuilder()
                .input(BATTERY_HULL_MEDIUM_LANTHANUM_NICKEL_OXIDE)
                .input(dust, BerylliumDifluoride, 8)
                .fluidInputs(RadonDifluoride.getFluid(4000))
                .output(BATTERY_OpV_LANTHANUM_NICKEL_OXIDE)
                .EUt(VA[UXV])
                .duration(400)
                .buildAndRegister();

        //  Large Lanthanum Nickel Oxide Battery
        CANNER_RECIPES.recipeBuilder()
                .input(BATTERY_HULL_LARGE_LANTHANUM_NICKEL_OXIDE)
                .input(dust, BerylliumDifluoride, 16)
                .fluidInputs(RadonDifluoride.getFluid(16000))
                .output(BATTERY_MAX_LANTHANUM_NICKEL_OXIDE)
                .EUt(VA[OpV])
                .duration(1600)
                .buildAndRegister();

        //  2LiH + 2S -> Li2S + H2S
        BLAST_RECIPES.recipeBuilder()
                .input(ingot, LithiumHydride, 2)
                .input(dust, Sulfur, 2)
                .output(ingotHot, LithiumSulfide, 3)
                .fluidOutputs(HydrogenSulfide.getFluid(1000))
                .EUt(VA[UV])
                .duration(300)
                .blastFurnaceTemp(8372)
                .buildAndRegister();

        //  7La2O3 + 7NiO + Ca + 2EDTA -> 7La2NiO4 + CaO + 15CO + 5CH4 + 4NH3
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, LanthanumOxide, 35)
                .input(dust, Garnierite, 14)
                .input(dust, Calcium)
                .fluidInputs(EthylenediaminetetraaceticAcid.getFluid(2000))
                .output(dust, LanthanumNickelOxide, 49)
                .output(dust, Quicklime, 2)
                .fluidOutputs(CarbonMonoxide.getFluid(15000))
                .fluidOutputs(Methane.getFluid(5000))
                .fluidOutputs(Ammonia.getFluid(4000))
                .EUt(VA[LuV])
                .duration(420)
                .buildAndRegister();

        //  SO3 + 3HF + C -> HOSO2CF3 + 2H
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Carbon)
                .fluidInputs(SulfurTrioxide.getFluid(1000))
                .fluidInputs(HydrofluoricAcid.getFluid(3000))
                .fluidOutputs(TrifluoromethanesulfonicAcid.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(2000))
                .EUt(VA[ZPM])
                .duration(20)
                .temperature(3442)
                .buildAndRegister();

        //  CaCO3 (ore) -> CaCO3 (pure)
        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, Calcite, 5)
                .output(dust, CalciumCarbonate, 5)
                .EUt(VA[MV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  HOSO2CF3 + Ca(OH)2 -> Ca(OSO2CF3)2 + 2H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, CalciumHydroxide, 5)
                .fluidInputs(TrifluoromethanesulfonicAcid.getFluid(1000))
                .fluidOutputs(CalciumTrifluoromethansulphonate.getFluid(1000))
                .fluidOutputs(Water.getFluid(2000))
                .EUt(VA[ZPM])
                .duration(15)
                .buildAndRegister();

        //  Ca(OSO2CF3)2 + Li2CO3 = 2LiCSO3F3 + CaCO3
        CVD_UNIT_RECIPES.recipeBuilder()
                .inputs(LithiumCarbonate.getItemStack(6))
                .fluidInputs(CalciumTrifluoromethansulphonate.getFluid(1000))
                .output(dust, LithiumTrifluoromethansulphonate, 18)
                .output(dust, CalciumCarbonate, 5)
                .EUt(VA[EV])
                .duration(340)
                .temperature(1600)
                .buildAndRegister();

        //  Another BeF2 Recipe
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Beryllium)
                .fluidInputs(Fluorine.getFluid(2000))
                .circuitMeta(2)
                .output(dust, BerylliumDifluoride, 3)
                .EUt(VA[LV])
                .duration(100)
                .buildAndRegister();
    }
}
