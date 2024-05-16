package magicbook.gtlitecore.api.recipe.builder;

import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.util.EnumValidationResult;
import magicbook.gtlitecore.api.recipe.properties.PCBFactoryBioUpgradeProperty;
import magicbook.gtlitecore.api.recipe.properties.PCBFactoryProperty;
import magicbook.gtlitecore.api.utils.GTLiteLog;
import magicbook.gtlitecore.common.metatileentities.multi.electric.MetaTileEntityPCBFactory;
import magicbook.gtlitecore.loaders.multiblock.PCBFactory;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.annotation.Nonnull;

/**
 * PCB Factory Recipe Builder
 *
 * @author Magic_Sweepy
 *
 * <p>
 *     This Recipe Builder is for the Multiblock {@link MetaTileEntityPCBFactory},
 *     used for add Main Structure tier (correspondenced to {@code mainUpgradeNumber})
 *     and Bio Chamber tier (correspondenced to {@code bioUpgradeNumber}).
 * </p>
 *
 * @see MetaTileEntityPCBFactory
 * @see PCBFactoryProperty
 * @see PCBFactoryBioUpgradeProperty
 * @see PCBFactory
 *
 * @since 2.8.8-beta
 */
public class PCBFactoryRecipeBuilder extends RecipeBuilder<PCBFactoryRecipeBuilder> {

   public PCBFactoryRecipeBuilder() {}

   public PCBFactoryRecipeBuilder(Recipe recipe,
                                  RecipeMap<PCBFactoryRecipeBuilder> recipeMap) {
       super(recipe, recipeMap);
   }

   public PCBFactoryRecipeBuilder(PCBFactoryRecipeBuilder builder) {
       super(builder);
   }

   @Override
   public PCBFactoryRecipeBuilder copy() {
       return new PCBFactoryRecipeBuilder(this);
   }

   @Override
   public boolean applyProperty(@Nonnull String key, Object value) {
       if (key.equals(PCBFactoryProperty.KEY)) {
           tier(((Number) value).intValue());
           return true;
       }

       if (key.equals(PCBFactoryBioUpgradeProperty.KEY)) {
           isBioUpgrade(((Number) value).intValue());
           return true;
       }
       return super.applyProperty(key, value);
   }

   public PCBFactoryRecipeBuilder tier(int tier) {
       if (tier < 0) {
           GTLiteLog.logger.error("PCB Factory Tier cannot be less than 0", new IllegalArgumentException());
           this.recipeStatus = EnumValidationResult.INVALID;
       }
       applyProperty(PCBFactoryProperty.getInstance(), tier);
       return this;
   }

   public PCBFactoryRecipeBuilder isBioUpgrade(int isBioUpgrade) {
       applyProperty(PCBFactoryBioUpgradeProperty.getInstance(), isBioUpgrade);
       return this;
   }

   public int getPCBFactoryTier() {
       return this.recipePropertyStorage == null ? 0 : this.recipePropertyStorage
               .getRecipePropertyValue(PCBFactoryProperty.getInstance(), 0);
   }

   public int getPCBFactoryBioUpgradeTier() {
       return this.recipePropertyStorage == null ? 0 : this.recipePropertyStorage
               .getRecipePropertyValue(PCBFactoryBioUpgradeProperty.getInstance(), 0);
   }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append(PCBFactoryProperty.getInstance().getKey(), getPCBFactoryTier())
                .append(PCBFactoryBioUpgradeProperty.getInstance().getKey(), getPCBFactoryBioUpgradeTier())
                .toString();
    }

}
