package magicbook.gtlitecore.api.utils;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntityHolder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.util.BlockInfo;
import gregtech.api.util.GTUtility;
import gregtech.api.util.TextFormattingUtil;
import gregtech.common.blocks.MetaBlocks;
import gregtech.loaders.recipe.handlers.PartsRecipeHandler;
import magicbook.gtlitecore.api.pattern.GTLiteTraceabilityPredicate;
import magicbook.gtlitecore.common.metatileentities.multi.electric.adv.MetaTileEntityPreciseAssembler;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

import static gregtech.api.GTValues.*;
import static gregtech.common.items.MetaItems.*;
import static gregtech.common.items.MetaItems.CONVEYOR_MODULE_UV;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

@SuppressWarnings("unused")
public class GTLiteUtility {

    /**
     * Get {@code ResourceLocation} of {@code gtlitecore}.
     *
     * @param path  Name in namespace {@code gtlitecore}, used to init some internal things in this mod.
     * @return      Resource Location of {@code gtlitecore}, pay attention,
     *              do not use this method in Materials init, please see {@link Materials}.
     *              You should use {@link GTUtility#gregtechId(String)}.
     */
    @NotNull
    public static ResourceLocation gtliteId(@NotNull String path) {
        return new ResourceLocation("gtlitecore", path);
    }

    /**
     * Get {@code ResourceLocation} of other mod.
     *
     * @param modid  Mod ID.
     * @param path   Name in {@code modid} namespace.
     * @return       Namespace of {@code modid}.
     */
    @NotNull
    public static ResourceLocation getId(String modid, @NotNull String path) {
        return new ResourceLocation(modid, path);
    }

    /**
     * Get item stack by {@code modid} and {@code name} of item stack.
     *
     * @param modid  Mod ID.
     * @param name   Item name.
     * @return       Item stack in {@code modid} which named by {@code name}.
     */
    @NotNull
    public static ItemStack getItemById(String modid, String name) {
        return GameRegistry.makeItemStack(modid + ":" + name, 0, 1, null);
    }

    /**
     * Get item stack by {@code modid} and {@code name} of item stack.
     *
     * @param modid   Mod ID.
     * @param name    Item name.
     * @param amount  Amount of Item.
     * @return        Allocate amount Item stack in {@code modid} which named by {@code name}.
     */
    @NotNull
    public static ItemStack getItemById(String modid, String name, int amount) {
        return GameRegistry.makeItemStack(modid + ":" + name, 0, amount, null);
    }

    /**
     * Get item stack with NBT data by {@code modid} and {@code name} of item stack.
     *
     * @param modid  Mod ID.
     * @param name   Item Name.
     * @param nbt    NBT data of Item.
     * @return       Item stack with NBT data in {@code modid} which named by {@code name}.
     */
    @NotNull
    public static ItemStack getItemById(String modid, String name, NBTTagCompound nbt) {
        return GameRegistry.makeItemStack(modid + ":" + name, 0, 1, nbt != null ? nbt.toString() : null);
    }

    /**
     * Get item stack with nbt data by {@code modid} and {@code name} of item stack.
     *
     * @param modid   Mod ID.
     * @param name    Item Name.
     * @param amount  Amount of Item.
     * @param nbt     NBT data of Item.
     * @return        Allocate amount Item stack with NBT data in {@code modid} which named by {@code name}.
     */
    @NotNull
    public static ItemStack getItemById(String modid, String name, int amount, NBTTagCompound nbt) {
        return GameRegistry.makeItemStack(modid + ":" + name, 0, amount, nbt != null ? nbt.toString() : null);
    }

    /**
     * Get item stack by {@code modid} and {@code name} of item stack which has metadata.
     *
     * @param modid  Mod ID.
     * @param name   Item name.
     * @param meta   Metadata of {@code name} item.
     * @return       Item stack in {@code modid} which named by {@code name} and has metadata {@code meta}.
     */
    @NotNull
    public static ItemStack getMetaItemById(String modid, String name, int meta) {
        return GameRegistry.makeItemStack(modid + ":" + name, meta, 1, null);
    }

    /**
     * Get item stack by {@code modid} and {@code name} of item stack which has metadata.
     *
     * @param modid   Mod ID.
     * @param name    Item name.
     * @param meta    Metadata of {@code name} item.
     * @param amount  Amount of {@code name} item.
     * @return        Allocate amount Item stack in {@code modid} which named by {@code name} and has metadata {@code meta}.
     */
    @NotNull
    public static ItemStack getMetaItemById(String modid, String name, int meta, int amount) {
        return GameRegistry.makeItemStack(modid + ":" + name, meta, amount, null);
    }

    /**
     * Get item stack with NBT data by {@code modid} and {@code name} of item stack which has metadata.
     *
     * @param modid  Mod ID.
     * @param name   Item name.
     * @param meta   Metadata of {@code name} item.
     * @param nbt    NBT data of item.
     * @return       Item stack with NBT data in {@code modid} which named by {@code name} and has metadata {@code meta}.
     */
    @NotNull
    public static ItemStack getMetaItemById(String modid, String name, int meta, NBTTagCompound nbt) {
        return GameRegistry.makeItemStack(modid + ":" + name, meta, 1, nbt != null ? nbt.toString() : null);
    }

    /**
     * Get item stack with NBT data by {@code modid} and {@code name} of item stack which has metadata.
     *
     * @param modid   Mod ID.
     * @param name    Item name.
     * @param meta    Metadata of {@code name} item.
     * @param amount  Amount of {@code name} item.
     * @param nbt     NBT data of item.
     * @return        Allocate amount Item stack with NBT data in {@code modid} which named by {@code name} and has metadata {@code meta}.
     */
    @NotNull
    public static ItemStack getMetaItemById(String modid, String name, int meta, int amount, NBTTagCompound nbt) {
        return GameRegistry.makeItemStack(modid + ":" + name, meta, amount, nbt != null ? nbt.toString() : null);
    }

    /**
     * Get fluid stack by {@code name}.
     *
     * @param name  Fluid name.
     * @return      Fluid stack named by {@code name}.
     */
    @NotNull
    public static FluidStack getFluidById(String name) {
        return Objects.requireNonNull(FluidRegistry.getFluidStack(name, 1000));
    }

    /**
     * Get fluid stack by {@code name}.
     *
     * @param name    Fluid name.
     * @param amount  Amount of {@code name} fluid.
     * @return        Allocate amount fluid stack named by {@code name}.
     */
    @NotNull
    public static FluidStack getFluidById(String name, int amount) {
        return Objects.requireNonNull(FluidRegistry.getFluidStack(name, amount));
    }

    /**
     * @param number  Long number.
     * @return        Just a rewrite of formatNumbers(),
     *                please see {@link TextFormattingUtil#formatNumbers(long)}.
     */
    public static String formatNumbers(long number) {
        return TextFormattingUtil.formatNumbers(number);
    }

    /**
     * @param number  Double number.
     * @return        Just a rewrite of formatNumbers(),
     *                please see {@link TextFormattingUtil#formatNumbers(double)}.
     */
    public static String formatNumbers(double number) {
        return TextFormattingUtil.formatNumbers(number);
    }

    /**
     * @param tag           NBT tag.
     * @param key           Key.
     * @param defaultValue  Default value.
     * @return              If tag has special key, then return integer of key (value),
     *                      if not, then return default value.
     */
    public static int getOrDefault(NBTTagCompound tag,
                                   String key,
                                   int defaultValue){
        if (tag.hasKey(key)) {
            return tag.getInteger(key);
        }
        return defaultValue;
    }

    /**
     * @return  Used to check if multiblock part has tier and set its related info.
     */
    public static <T> T getOrDefault(BooleanSupplier canGet,
                                     Supplier<T> getter,
                                     T defaultValue){
        return canGet.getAsBoolean() ? getter.get() : defaultValue;
    }

    /**
     * @param lists  List.
     * @return       List size, used to get ArrayList<List<IBlockState>> in some block tier multiblocks,
     *               please see: {@link MetaTileEntityPreciseAssembler}.
     */
    public static <T> int maxLength(List<List<T>> lists) {
        return lists.stream()
                    .mapToInt(List::size)
                    .max()
                    .orElse(0);
    }

    /**
     * @param list    List.
     * @param length  List size.
     * @return        The final list, used to recheck list of IBlockState in some block tier multiblocks,
     *                please see: {@link MetaTileEntityPreciseAssembler}.
     */
    public static <T> List<T> consistentList(List<T> list,
                                             int length) {
        if (list.size() >= length) {
            return list;
        }
        List<T> finalList = new ArrayList<>(list);
        T last = list.get(list.size() - 1);
        for (int i = 0; i < length - list.size(); i++) {
            finalList.add(last);
        }
        return finalList;
    }

    /**
     * @param tile  MetaTileEntity.
     * @return      MetaTileEntityHolder, used to get special block info in Traceability Predicate.
     *              Please see: {@link GTLiteTraceabilityPredicate#ROTOR_HOLDER}.
     */
    public static MetaTileEntityHolder getTileEntity(MetaTileEntity tile) {
        MetaTileEntityHolder holder = new MetaTileEntityHolder();
        holder.setMetaTileEntity(tile);
        holder.getMetaTileEntity().onPlacement();
        holder.getMetaTileEntity().setFrontFacing(EnumFacing.SOUTH);
        return holder;
    }

    /**
     * @param allowedStates  Allowed Block States.
     * @return               Used to build upgrade multiblock.
     */
    public static Supplier<BlockInfo[]> getCandidates(IBlockState... allowedStates) {
        return () -> Arrays.stream(allowedStates)
                .map(state -> new BlockInfo(state, null))
                .toArray(BlockInfo[]::new);
    }

    /**
     * @param metaTileEntities  Allowed Meta Tile Entities.
     * @return                  Used to build upgrade multiblock.
     */
    public static Supplier<BlockInfo[]> getCandidates(MetaTileEntity... metaTileEntities) {
        return () -> Arrays.stream(metaTileEntities)
                .filter(Objects::nonNull)
                .map(tile -> new BlockInfo(MetaBlocks.MACHINE.getDefaultState(), getTileEntity(tile)))
                .toArray(BlockInfo[]::new);
    }

    /**
     * Used to `clamp` a value ({@code int}) to a given range.
     *
     * <p>
     *     This function will `clamp` a value to given range,
     *     If {@code value} smaller than {@code min}, then return {@code min},
     *     and if {@code value} bigger than or equal to {@code min}, then check it
     *     if bigger than {@code max}, and return the smaller one.
     * </p>
     *
     * @param value  Origin value which will be clamped.
     * @param min    Range Minimium point.
     * @param max    Range Maximium point.
     * @return       Value in given range.
     */
    public static int clamp(int value, int min, int max) {
        if (value < min) {
            return min;
        } else {
            return Math.min(value, max);
        }
    }

    /**
     * Used to `clamp` a value ({@code double}) to a given range.
     *
     * <p>
     *     This function will `clamp` a value to given range,
     *     If {@code value} smaller than {@code min}, then return {@code min},
     *     and if {@code value} bigger than or equal to {@code min}, then check it
     *     if bigger than {@code max}, and return the smaller one.
     * </p>
     *
     * @param value  Origin value which will be clamped.
     * @param min    Range Minimium point.
     * @param max    Range Maximium point.
     * @return       Value in given range.
     */
    public static double clamp(double value, double min, double max) {
        if (value < min) {
            return min;
        } else {
            return Math.min(value, max);
        }
    }

    /**
     * @param stack  Item stack.
     * @return       Item stack id.
     */
    public static int stackToInt(ItemStack stack) {
        if (isStackInvalid(stack))
            return 0;
        return itemToInt(stack.getItem(), stack.getMetadata());
    }

    /**
     * @param item  Item stack.
     * @param meta  Meta data of item stack.
     * @return      Item stack id.
     */
    public static int itemToInt(Item item, int meta) {
        return Item.getIdFromItem(item) | (meta << 16);
    }

    /**
     * @param stack  Item stack.
     * @return       Check if itemstack invalid.
     */
    public static boolean isStackInvalid(Object stack) {
        return !(stack instanceof ItemStack) || ((ItemStack) stack).getCount() < 0;
    }

    /**
     * @param aStack  Item stack.
     * @return        Check if itemstack valid.
     */
    public static boolean isStackValid(Object aStack) {
        return (aStack instanceof ItemStack) && ((ItemStack) aStack).getCount() >= 0;
    }

    /**
     * @param aStack  Meta data.
     * @return        Get itemstack from meta data.
     */
    public static ItemStack intToStack(int aStack) {
        int tID = aStack & (~0 >>> 16), tMeta = aStack >>> 16;
        Item tItem = Item.getItemById(tID);
        if (tItem != null)
            return new ItemStack(tItem, 1, tMeta);
        return null;
    }

    /**
     * @param aAmount  Amount property.
     * @param aStacks  Object stack.
     * @return         Copy item stack with unsafe amount.
     */
    public static ItemStack copyAmountUnsafe(long aAmount, Object... aStacks) {
        ItemStack rStack = copy(aStacks);
        if (isStackInvalid(rStack))
            return null;
        if (aAmount > Integer.MAX_VALUE)
            aAmount = Integer.MAX_VALUE;
        else if (aAmount < 0)
            aAmount = 0;
        rStack.setCount((int) aAmount);
        return rStack;
    }

    /**
     * Rewrite of same name method in {@link ItemStack}.
     *
     * @param aStacks  Object stack.
     * @return         Copy item stack, i.e. return new item stack with the same property.
     */
    public static ItemStack copy(Object... aStacks) {
        for (Object tStack : aStacks)
            if (isStackValid(tStack))
                return ((ItemStack) tStack).copy();
        return null;
    }

    /**
     * Get {@code RecipeMap} of Large Processing Factory by {@code index}.
     *
     * @param index  Index of {@code RecipeMap}, each three Indexes correspondence one Processing Mode.
     * @return       Correspondence {@code RecipeMap} of {@code index}.
     */
    public static RecipeMap<?> getProcessingRecipe(int index) {
        return switch (index) {
            case 1 -> RecipeMaps.COMPRESSOR_RECIPES;
            case 2 -> RecipeMaps.LATHE_RECIPES;
            case 3 -> RecipeMaps.POLARIZER_RECIPES;
            case 4 -> RecipeMaps.FERMENTING_RECIPES;
            case 5 -> RecipeMaps.EXTRACTOR_RECIPES;
            case 6 -> RecipeMaps.CANNER_RECIPES;
            case 7 -> RecipeMaps.LASER_ENGRAVER_RECIPES;
            case 8 -> RecipeMaps.AUTOCLAVE_RECIPES;
            case 9 -> RecipeMaps.FLUID_SOLIDFICATION_RECIPES;
            default -> null;
        };
    }

    /**
     * Get {@code voltage} by property of {@code material}.
     *
     * <p>
     *     The original method is in {@link PartsRecipeHandler} (private),
     *     this method is used for same situation in {@code gtlitecore}.
     * </p>
     *
     * @param material  Material.
     * @return          If {@code BlastTemperature() > 2800}, then return {@code VA[LV]},
     *                  else return {@code VA[ULV]}.
     */
    public static int getVoltageMultiplier(Material material) {
        return material.getBlastTemperature() > 2800 ? VA[LV] : VA[ULV];
    }

    /**
     * Get Item Stack by NBT data.
     *
     * <p>
     *     Used to get prepare Item Stack by custom NBT data.
     *     Functionally, this method is same as {@code loadItem(NBTTagCompound, String)}.
     * </p>
     *
     * @param nbt  NBT data.
     * @return     Correspondence Item of NBT data.
     */
    public static ItemStack readItemFromNBT(NBTTagCompound nbt) {
        ItemStack stack = new ItemStack(nbt);
        if (nbt.hasKey("stackSize"))
            stack.setCount(nbt.getInteger("stackSize"));
        return stack;
    }

    /**
     * Save Item Stack to NBT data.
     *
     * <p>
     *     Used to save custom Item Stack and NBT data.
     *     Functionally, this method is same as {@code saveItem(NBTTagCompound, String, ItemStack)}.
     * </p>
     *
     * @param stack  Item Stack.
     * @param nbt    NBT data of Item Stack.
     */
    public static void writeItemToNBT(ItemStack stack, NBTTagCompound nbt) {
        stack.writeToNBT(nbt);
        if (stack.getCount() > 127) {
            nbt.setInteger("stackSize", stack.getCount());
        }
    }

    /**
     * Set Item Stack to NBT data.
     *
     * <p>
     *     Used to set custom Item Stack to NBT data,
     *     this method use {@link #writeItemToNBT(ItemStack, NBTTagCompound)} to custom NBT data.
     * </p>
     *
     * @param stack  Item Stack.
     * @return       Correspondenced NBT data which prepare to seted.
     */
    public static NBTTagCompound setItemToNBT(ItemStack stack) {
        NBTTagCompound nbt = new NBTTagCompound();
        writeItemToNBT(stack, nbt);
        return nbt;
    }

    /**
     * Check if machine structure not has static water.
     *
     * @param block  Block (use vanilla {@code block} class).
     * @return       If Block is Air or Flowing Water, then return true;
     *               If not, then return false.
     */
    public static boolean isNotStaticWater(Block block) {
        return block == Blocks.AIR || block == Blocks.FLOWING_WATER;
    }

    /**
     * Get Electric Motor Meta Item by Voltage Tier.
     *
     * @param tier  Voltage Tier.
     * @return      Correspondence Electric Motor Meta Item.
     */
    public static MetaItem<?>.MetaValueItem getMotorByTier(int tier) {
        return switch (tier) {
            case LV -> ELECTRIC_MOTOR_LV;
            case MV -> ELECTRIC_MOTOR_MV;
            case HV -> ELECTRIC_MOTOR_HV;
            case EV -> ELECTRIC_MOTOR_EV;
            case IV -> ELECTRIC_MOTOR_IV;
            case LuV -> ELECTRIC_MOTOR_LuV;
            case ZPM -> ELECTRIC_MOTOR_ZPM;
            case UV -> ELECTRIC_MOTOR_UV;
            case UHV -> ELECTRIC_MOTOR_UHV;
            case UEV -> ELECTRIC_MOTOR_UEV;
            case UIV -> ELECTRIC_MOTOR_UIV;
            case UXV -> ELECTRIC_MOTOR_UXV;
            case OpV -> ELECTRIC_MOTOR_OpV;
            case MAX -> ELECTRIC_MOTOR_MAX;
            default -> ELECTRIC_MOTOR_ULV;
        };
    }

    /**
     * Get Electric Piston Meta Item by Voltage Tier.
     *
     * @param tier  Voltage Tier.
     * @return      Correspondence Electric Piston Meta Item.
     */
    public static MetaItem<?>.MetaValueItem getPistonByTier(int tier) {
        return switch (tier) {
            case LV -> ELECTRIC_PISTON_LV;
            case MV -> ELECTRIC_PISTON_MV;
            case HV -> ELECTRIC_PISTON_HV;
            case EV -> ELECTRIC_PISTON_EV;
            case IV -> ELECTRIC_PISTON_IV;
            case LuV -> ELECTRIC_PISTON_LUV;
            case ZPM -> ELECTRIC_PISTON_ZPM;
            case UV -> ELECTRIC_PISTON_UV;
            case UHV -> ELECTRIC_PISTON_UHV;
            case UEV -> ELECTRIC_PISTON_UEV;
            case UIV -> ELECTRIC_PISTON_UIV;
            case UXV -> ELECTRIC_PISTON_UXV;
            case OpV -> ELECTRIC_PISTON_OpV;
            case MAX -> ELECTRIC_PISTON_MAX;
            default -> ELECTRIC_PISTON_ULV;
        };
    }

    /**
     * Get Robot Arm Meta Item by Voltage Tier.
     *
     * @param tier  Voltage Tier.
     * @return      Correspondence Robot Arm Meta Item.
     */
    public static MetaItem<?>.MetaValueItem getRobotArmByTier(int tier) {
        return switch (tier) {
            case LV -> ROBOT_ARM_LV;
            case MV -> ROBOT_ARM_MV;
            case HV -> ROBOT_ARM_HV;
            case EV -> ROBOT_ARM_EV;
            case IV -> ROBOT_ARM_IV;
            case LuV -> ROBOT_ARM_LuV;
            case ZPM -> ROBOT_ARM_ZPM;
            case UV -> ROBOT_ARM_UV;
            case UHV -> ROBOT_ARM_UHV;
            case UEV -> ROBOT_ARM_UEV;
            case UIV -> ROBOT_ARM_UIV;
            case UXV -> ROBOT_ARM_UXV;
            case OpV -> ROBOT_ARM_OpV;
            case MAX -> ROBOT_ARM_MAX;
            default -> ROBOT_ARM_ULV;
        };
    }

    /**
     * Get Electric Pump Meta Item by Voltage Tier.
     *
     * @param tier  Voltage Tier.
     * @return      Correspondence Electric Pump Meta Item.
     */
    public static MetaItem<?>.MetaValueItem getPumpByTier(int tier) {
        return switch (tier) {
            case LV -> ELECTRIC_PUMP_LV;
            case MV -> ELECTRIC_PUMP_MV;
            case HV -> ELECTRIC_PUMP_HV;
            case EV -> ELECTRIC_PUMP_EV;
            case IV -> ELECTRIC_PUMP_IV;
            case LuV -> ELECTRIC_PUMP_LuV;
            case ZPM -> ELECTRIC_PUMP_ZPM;
            case UV -> ELECTRIC_PUMP_UV;
            case UHV -> ELECTRIC_PUMP_UHV;
            case UEV -> ELECTRIC_PUMP_UEV;
            case UIV -> ELECTRIC_PUMP_UIV;
            case UXV -> ELECTRIC_PUMP_UXV;
            case OpV -> ELECTRIC_PUMP_OpV;
            case MAX -> ELECTRIC_PUMP_MAX;
            default -> ELECTRIC_PUMP_ULV;
        };
    }

    /**
     * Get Conveyor Module Meta Item by Voltage Tier.
     *
     * @param tier  Voltage Tier.
     * @return      Correspondence Conveyor Module Meta Item.
     */
    public static MetaItem<?>.MetaValueItem getConveyorByTier(int tier) {
        return switch (tier) {
            case LV -> CONVEYOR_MODULE_LV;
            case MV -> CONVEYOR_MODULE_MV;
            case HV -> CONVEYOR_MODULE_HV;
            case EV -> CONVEYOR_MODULE_EV;
            case IV -> CONVEYOR_MODULE_IV;
            case LuV -> CONVEYOR_MODULE_LuV;
            case ZPM -> CONVEYOR_MODULE_ZPM;
            case UV -> CONVEYOR_MODULE_UV;
            case UHV -> CONVEYOR_MODULE_UHV;
            case UEV -> CONVEYOR_MODULE_UEV;
            case UIV -> CONVEYOR_MODULE_UIV;
            case UXV -> CONVEYOR_MODULE_UXV;
            case OpV -> CONVEYOR_MODULE_OpV;
            case MAX -> CONVEYOR_MODULE_MAX;
            default -> CONVEYOR_MODULE_ULV;
        };
    }

    /**
     * Get Emitter Meta Item by Voltage Tier.
     *
     * @param tier  Voltage Tier.
     * @return      Correspondence Emitter Meta Item.
     */
    public static MetaItem<?>.MetaValueItem getEmitterByTier(int tier) {
        return switch (tier) {
            case LV -> EMITTER_LV;
            case MV -> EMITTER_MV;
            case HV -> EMITTER_HV;
            case EV -> EMITTER_EV;
            case IV -> EMITTER_IV;
            case LuV -> EMITTER_LuV;
            case ZPM -> EMITTER_ZPM;
            case UV -> EMITTER_UV;
            case UHV -> EMITTER_UHV;
            case UEV -> EMITTER_UEV;
            case UIV -> EMITTER_UIV;
            case UXV -> EMITTER_UXV;
            case OpV -> EMITTER_OpV;
            case MAX -> EMITTER_MAX;
            default -> EMITTER_ULV;
        };
    }

    /**
     * Get Sensor Meta Item by Voltage Tier.
     *
     * @param tier  Voltage Tier.
     * @return      Correspondence Sensor Meta Item.
     */
    public static MetaItem<?>.MetaValueItem getSensorByTier(int tier) {
        return switch (tier) {
            case LV -> SENSOR_LV;
            case MV -> SENSOR_MV;
            case HV -> SENSOR_HV;
            case EV -> SENSOR_EV;
            case IV -> SENSOR_IV;
            case LuV -> SENSOR_LuV;
            case ZPM -> SENSOR_ZPM;
            case UV -> SENSOR_UV;
            case UHV -> SENSOR_UHV;
            case UEV -> SENSOR_UEV;
            case UIV -> SENSOR_UIV;
            case UXV -> SENSOR_UXV;
            case OpV -> SENSOR_OpV;
            case MAX -> SENSOR_MAX;
            default -> SENSOR_ULV;
        };
    }

    /**
     * Get Field Generator Meta Item by Voltage Tier.
     *
     * @param tier  Voltage Tier.
     * @return      Correspondence Field Generator Meta Item.
     */
    public static MetaItem<?>.MetaValueItem getFieldGenByTier(int tier) {
        return switch (tier) {
            case LV -> FIELD_GENERATOR_LV;
            case MV -> FIELD_GENERATOR_MV;
            case HV -> FIELD_GENERATOR_HV;
            case EV -> FIELD_GENERATOR_EV;
            case IV -> FIELD_GENERATOR_IV;
            case LuV -> FIELD_GENERATOR_LuV;
            case ZPM -> FIELD_GENERATOR_ZPM;
            case UV -> FIELD_GENERATOR_UV;
            case UHV -> FIELD_GENERATOR_UHV;
            case UEV -> FIELD_GENERATOR_UEV;
            case UIV -> FIELD_GENERATOR_UIV;
            case UXV -> FIELD_GENERATOR_UXV;
            case OpV -> FIELD_GENERATOR_OpV;
            case MAX -> FIELD_GENERATOR_MAX;
            default -> FIELD_GENERATOR_ULV;
        };
    }
}