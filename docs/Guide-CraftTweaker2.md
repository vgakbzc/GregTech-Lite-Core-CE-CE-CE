#  Introduction

Same as Recipe Builder system of GTCEu, in `gtlitecore`, 
we also stores all recipes in related class.

> Package: mods.gtlitecore.recipe.RecipeMap;

All RecipeMaps are defined by name, so you can use Zen Getter like GTCEu as below:

```
import mods.gtlitecore.recipe.RecipeMap;

val chemical_dryer as RecipeMap = <recipemap:chemical_dryer>
```


##  RecipeMap List

###  Single Machine RecipeMap

| Machine Name        | RecipeMap Name        | Item Inputs | Item Outputs | Fluid Inputs | Fluid Outputs |
|---------------------|-----------------------|-------------|--------------|--------------|---------------|
| Chemical Dryer      | `chemical_dryer`      | 1           | 2            | 1            | 1             |
| Vacuum Chamber      | `vacuum_chamber`      | 4           | 1            | 2            | 1             |
| Bio Reactor         | `bio_reactor`         | 6           | 1            | 3            | 2             |
| Condenser           | `condenser`           | 1           | 1            | 1            | 0             |
| Simulator           | `simulator`           | 2           | 2            | 0            | 0             |
| Component Assembler | `component_assembler` | 6           | 1            | 1            | 0             |
| Auto Chisel         | `auto_chisel`         | 2           | 1            | 0            | 0             |

###  Multiblock Machine RecipeMap

| Machine Name                  | RecipeMap Name                                                   | Item Inputs | Item Outputs | Fluid Inputs | Fluid Outputs |
|-------------------------------|------------------------------------------------------------------|-------------|--------------|--------------|---------------|
| Industrial Drilling Rig       | `industrial_drilling_rig`                                        | 1           | 1            | 0            | 1             |
| Catalytic Reformer            | `catalytic_reformer`                                             | 1           | 0            | 1            | 4             |
| Sonicator                     | `sonicator`                                                      | 0           | 1            | 2            | 2             |
| Nanoscale Fabricator          | `nanoscale_fabricator`                                           | 6           | 1            | 2            | 0             |
| Industrial Roaster            | `industrial_roaster`                                             | 3           | 3            | 3            | 3             |
| Crystallization Crucible      | `crystallization_crucible`                                       | 6           | 1            | 3            | 0             |
| CVD Unit                      | `cvd_unit`                                                       | 2           | 2            | 3            | 3             |
| Plasma CVD Unit               | `plasma_cvd_unit`                                                | 2           | 2            | 3            | 3             |
| Laser CVD Unit                | `laser_cvd_unit`                                                 | 2           | 2            | 3            | 3             |
| Burner Reactor                | `burner_reactor`                                                 | 3           | 3            | 3            | 3             |
| Cryogenic Reactor             | `cryogenic_reactor`                                              | 3           | 2            | 3            | 2             |
| Fuel Refine Factory           | `fuel_refine_factory`                                            | 3           | 4            | 4            | 2             |
| Isa Mill                      | `isa_mill`                                                       | 3           | 3            | 0            | 0             |
| Flotation Cell Regulator      | `flotation_cell_regulator`                                       | 6           | 0            | 1            | 1             |
| Vacuum Drying Furnace         | `vacuum_drying_furnace`                                          | 1           | 9            | 2            | 0             |
| Unmanned Drone Airport        | `unmanned_drone_airport`                                         | 2           | 9            | 1            | 0             |
| Ion Implantator               | `ion_implantator`                                                | 3           | 1            | 1            | 0             |
| Precise Assembler             | `precise_assembler`                                              | 4           | 1            | 4            | 0             |
| Component Assembly Line       | `component_assembly_line`                                        | 12          | 1            | 12           | 0             |
| Tree Growth Factory           | `tree_growth_factory`                                            | 2           | 4            | 2            | 0             |
| Collider                      | `collider`                                                       | 6           | 6            | 6            | 6             |
| Dimensional Oscillator        | `dimensional_oscillator`                                         | 3           | 3            | 3            | 3             |
| Stellar Furnace               | `stellar_furnace`                                                | 6           | 6            | 6            | 6             |
| Plasma Condenser              | `plasma_condenser`                                               | 3           | 3            | 3            | 3             |
| Decay Generator               | `decay_generator`                                                | 1           | 1            | 1            | 1             |
| Suprachronal Assembly Line    | `suprachronal_assembly_line`                                     | 16          | 1            | 4            | 0             |
| Space Elevator                | `space_elevator_drilling_module`                                 | 2           | 0            | 1            | 1             |
|                               | `space_elevator_mining_module`                                   | 4           | 9            | 2            | 0             |
|                               | `space_elevator_assembling_module`                               | 16          | 1            | 4            | 0             |
| Molecular Transformer         | `molecular_transformer`                                          | 1           | 1            | 0            | 0             |
| Cosmic Ray Detector           | `cosmic_ray_detector`                                            | 4           | 4            | 2            | 2             |
| PCB Factory                   | `pcb_factory`                                                    | 6           | 9            | 3            | 0             |
| Neutral Network Nexus         | `neutral_network_nexus_assembling_mode`                          | 6           | 1            | 3            | 0             |
|                               | `neutral_network_nexus_breeding_mode`                            | 6           | 1            | 3            | 0             |
|                               | `neutral_network_nexus_hybridizing_mode`                         | 6           | 6            | 3            | 3             |
| Quantum Force Transformer     | `quantum_force_transformer`                                      | 6           | 6            | 6            | 6             |
| Turbine Mixer                 | `turbine_mixer`                                                  | 9           | 1            | 6            | 1             |
| Heat Exchanger                | `heat_exchanger`                                                 | 0           | 0            | 2            | 3             |
| Bioware Simulator             | `bioware_simulator`                                              | 2           | 2            | 2            | 2             |
| Large EUV Mask Aligner        | `nano_scale_mask_aligner`                                        | 4           | 2            | 2            | 0             |
| Algae Culture Tank            | `algae_culture_tank`                                             | 2           | 1            | 2            | 0             |
| Large Gas Collector           | `large_gas_collector`                                            | 2           | 0            | 0            | 1             |
| Virtual Cosmos Simulator      | `virtual_cosmos_simulator`                                       | 1           | 81           | 0            | 18            |
| Large Circuit Assembly Line   | `large_circuit_assembly_line`                                    | 7           | 1            | 1            | 0             |
| Planetary Gas Siphon          | `planetary_gas_siphon`                                           | 4           | 0            | 1            | 1             |
| Suprachronal Neutronium Forge | `dimensionally_transcendent_neutronium_forge_transmutation_mode` | 1           | 0            | 1            | 1             |
|                               | `dimensionally_transcendent_neutronium_forge_fusion_mode`        | 1           | 0            | 20           | 1             |
|                               | `dimensionally_transcendent_neutronium_forge_collision_mode`     | 9           | 9            | 9            | 9             |
| Nicoll-Dyson Beamer           | `nicoll_dyson_beamer_oscillating_module`                         | 6           | 6            | 6            | 6             |
|                               | `nicoll_dyson_beamer_burning_module`                             | 9           | 9            | 9            | 9             |
|                               | `nicoll_dyson_beamer_forging_module`                             | 3           | 2            | 1            | 0             |
| Eternity Garden               | `eternity_garden`                                                | 7           | 7            | 7            | 7             |

###  Generator RecipeMap

| Machine Name                | RecipeMap Name                | Item Inputs | Item Outputs | Fluid Inputs | Fluid Outputs |
|-----------------------------|-------------------------------|-------------|--------------|--------------|---------------|
| Naquadah Reactor            | `naquadah_reactor`            | 0           | 0            | 1            | 0             |
| Rocket Engine               | `rocket_engine`               | 0           | 0            | 1            | 0             |
| Hyper Reactor Mark I        | `hyper_reactor_mk1`           | 0           | 0            | 1            | 0             |
| Hyper Reactor Mark II       | `hyper_reactor_mk2`           | 0           | 0            | 1            | 0             |
| Hyper Reactor Mark III      | `hyper_reactor_mk3`           | 0           | 0            | 1            | 0             |
| High Pressure Steam Turbine | `high_pressure_steam_turbine` | 0           | 0            | 1            | 1             |
| Supercritical Steam Turbine | `supercritical_steam_turbine` | 0           | 0            | 1            | 1             |
| Biomass Generator           | `biomass_generator`           | 0           | 0            | 1            | 0             |

###  Pseudo RecipeMap
| Machine Name             | RecipeMap Name      | Item Inputs | Item Outputs | Fluid Inputs | Fluid Outputs |
|--------------------------|---------------------|-------------|--------------|--------------|---------------|
| Large Processing Factory | `processing_mode_a` | 1           | 2            | 1            | 1             |
|                          | `processing_mode_b` | 2           | 2            | 1            | 1             |
|                          | `processing_mode_c` | 2           | 2            | 1            | 1             |
| Dyson Swarm              | `dyson_swarm`       | 2           | 8            | 0            | 0             |