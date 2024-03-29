package magicbook.gtlitecore.integration.gcym;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.stack.UnificationEntry;
import magicbook.gtlitecore.common.GTLiteConfigHolder;

import static gregicality.multiblocks.common.metatileentities.GCYMMetaTileEntities.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gregtech.common.metatileentities.MetaTileEntities.CIRCUIT_ASSEMBLER;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities.CRYOGENIC_FREEZER;
import static magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities.VOLCANUS;

/**
 * Overrides of Gregicality Multiblocks
 *
 * @author Magic_Sweepy
 *
 * <p>
 *     Some machines in gtlitecore environment is too hard to make it, so we rewrite some recipes.
 *     Machines like Mega Blast furnace and Large Circuit Assembler is too unuseful.
 *     You can control this overrides by {@link GTLiteConfigHolder}.
 * </p>
 *
 * @since 1.2.8
 */
public class GCYMOverrideRecipeLoader {

    public static void init() {
        //  A little tweaks about Mega Blast Furnace and Mega Vacuum Freezer.
        //  Because in gtlitecore, we add Volcanus and Cryogenic Freezer, and gcym's mega machine is too unuseful.
        //  So we buff it to UV stage, and add new, more powerful mega machine for UHV stage.
        if (GTLiteConfigHolder.compats.enableEasierMegaMachines) {
            ModHandler.removeRecipeByName("gcym:mega_blast_furnace");
            ModHandler.addShapedRecipe(true, "mega_blast_furnace", MEGA_BLAST_FURNACE.getStackForm(),
                    "SXS", "FHF", "PWP",
                    'H', VOLCANUS.getStackForm(),
                    'F', FIELD_GENERATOR_UV,
                    'S', new UnificationEntry(spring, YttriumBariumCuprate),
                    'X', new UnificationEntry(circuit, MarkerMaterials.Tier.UV),
                    'P', new UnificationEntry(plate, Orichalcum),
                    'W', new UnificationEntry(wireGtQuadruple, Tritanium));

            ModHandler.removeRecipeByName("gcym:mega_vacuum_freezer");
            ModHandler.addShapedRecipe(true, "mega_vacuum_freezer", MEGA_VACUUM_FREEZER.getStackForm(),
                    "SXS", "FHF", "PWP",
                    'H', CRYOGENIC_FREEZER.getStackForm(),
                    'F', FIELD_GENERATOR_UV,
                    'S', new UnificationEntry(pipeNormalFluid, Duranium),
                    'X', new UnificationEntry(circuit, MarkerMaterials.Tier.UV),
                    'P', new UnificationEntry(plate, Orichalcum),
                    'W', new UnificationEntry(wireGtQuadruple, Tritanium));
        }

        //  This machine is too unuseful in gtlitecore environment, because we have Large Circuit Assembly Line.
        //  In vanilla CEu environment, this machine needs UV-tier circuit, is ridiculous in 15 voltages pack.
        if (GTLiteConfigHolder.compats.enableEasierLargeCircuitAssembler) {
            ModHandler.removeRecipeByName("gcym:large_circuit_assembler");
            ModHandler.addShapedRecipe(true, "large_circuit_assembler", LARGE_CIRCUIT_ASSEMBLER.getStackForm(),
                    "RER", "CXC", "WMW",
                    'X', CIRCUIT_ASSEMBLER[IV].getStackForm(),
                    'C', new UnificationEntry(circuit, MarkerMaterials.Tier.LuV),
                    'R', ROBOT_ARM_IV,
                    'E', EMITTER_IV,
                    'M', CONVEYOR_MODULE_IV,
                    'W', new UnificationEntry(cableGtSingle, Platinum));
        }

        if (GTLiteConfigHolder.compats.enableHighTierTieredHatch) {
            ModHandler.addShapedRecipe("tiered_hatch.uhv", TIERED_HATCH[UHV].getStackForm(),
                    "PPP", "PCP", "PPP",
                    'P', new UnificationEntry(plate, Orichalcum),
                    'C', new UnificationEntry(circuit, MarkerMaterials.Tier.UEV));

            ModHandler.addShapedRecipe("tiered_hatch.uev", TIERED_HATCH[UEV].getStackForm(),
                    "PPP", "PCP", "PPP",
                    'P', new UnificationEntry(plate, Adamantium),
                    'C', new UnificationEntry(circuit, MarkerMaterials.Tier.UIV));

            ModHandler.addShapedRecipe("tiered_hatch.uiv", TIERED_HATCH[UIV].getStackForm(),
                    "PPP", "PCP", "PPP",
                    'P', new UnificationEntry(plate, Infinity),
                    'C', new UnificationEntry(circuit, MarkerMaterials.Tier.UXV));

            ModHandler.addShapedRecipe("tiered_hatch.uxv", TIERED_HATCH[UXV].getStackForm(),
                    "PPP", "PCP", "PPP",
                    'P', new UnificationEntry(plate, CosmicNeutronium),
                    'C', new UnificationEntry(circuit, MarkerMaterials.Tier.OpV));

            ModHandler.addShapedRecipe("tiered_hatch.opv", TIERED_HATCH[OpV].getStackForm(),
                    "PPP", "PCP", "PPP",
                    'P', new UnificationEntry(plate, Spacetime),
                    'C', new UnificationEntry(circuit, MarkerMaterials.Tier.MAX));

            ModHandler.addShapedRecipe("tiered_hatch.max", TIERED_HATCH[MAX].getStackForm(),
                    "PPP", "PCP", "PPP",
                    'P', new UnificationEntry(plate, Eternity),
                    'C', new UnificationEntry(circuit, MarkerMaterials.Tier.MAX));
        }
    }
}
