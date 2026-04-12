package pismeno.gregstinkering.common.recipes;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.category.RecipeCategories;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.items.MetaItems;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import pismeno.gregstinkering.Config;
import pismeno.gregstinkering.unification.GTCMetaItem;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.tools.TinkerMaterials;
import slimeknights.tconstruct.tools.TinkerTools;

import java.util.Iterator;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static pismeno.gregstinkering.common.tools.GTCTinkerMaterials.*;
import static pismeno.gregstinkering.unification.GTCGregtechMaterials.*;

public class MachineRecipes {
    public static void init() {
        initToolParts();
        initBowstrings();
        initFletchings();
        initShapeExtruders();
        initOther();
    }

    private MachineRecipes() {}

    private static void initToolParts() {
        if (Config.addMachineRecipesForTCMaterials){
            buildToolPartRecipes(TinkerMaterials.bronze, Bronze, VA[ULV]);
            buildToolPartRecipes(TinkerMaterials.iron, Iron, VA[ULV]);
            buildToolPartRecipes(TinkerMaterials.pigiron, PigIron, VA[ULV]);
            buildToolPartRecipes(TinkerMaterials.copper, Copper, VA[ULV]);
            buildToolPartRecipes(TinkerMaterials.lead, Lead, VA[ULV]);
            buildToolPartRecipes(TinkerMaterials.steel, Steel, VA[LV]);
            buildToolPartRecipes(TinkerMaterials.cobalt, Cobalt, VA[LV]);
            buildToolPartRecipes(TinkerMaterials.ardite, Ardite, VA[LV]);

            buildExtractorRecipes(TinkerMaterials.bronze, Bronze, VA[ULV]);
            buildExtractorRecipes(TinkerMaterials.iron, Iron, VA[ULV]);
            buildExtractorRecipes(TinkerMaterials.pigiron, PigIron, VA[ULV]);
            buildExtractorRecipes(TinkerMaterials.copper, Copper, VA[ULV]);
            buildExtractorRecipes(TinkerMaterials.lead, Lead, VA[LV]);
            buildExtractorRecipes(TinkerMaterials.steel, Steel, VA[LV]);
            buildExtractorRecipes(TinkerMaterials.cobalt, Cobalt, VA[LV]);
            buildExtractorRecipes(TinkerMaterials.ardite, Ardite, VA[LV]);
        }

        Iterator<Material> materials = MATERIALS.iterator();

        while (materials.hasNext()) {
            Material material = materials.next();
            buildToolPartRecipes(material, ASSOCIATED.get(material), TIER.get(material));
            buildExtractorRecipes(material, ASSOCIATED.get(material), TIER.get(material));
        }
    }

    private static void initBowstrings() {
        Iterator<Material> materials = BOWSTRING_MATERIALS.iterator();

        while (materials.hasNext()) {
            Material material = materials.next();
            buildBowstringRecipes(material, ASSOCIATED.get(material), TIER.get(material));
        }
    }

    private static void initFletchings() {
        Iterator materials = FLETCHING_MATERIALS.iterator();

        while (materials.hasNext()) {
            Material material = (Material) materials.next();
            buildFletchingRecipes(material, ASSOCIATED.get(material), TIER.get(material));
        }
    }

    private static void initShapeExtruders() {
        buildExtruderShapeRecipes("pick_head", GTCMetaItem.SHAPE_EXTRUDER_PICKAXE);
        buildExtruderShapeRecipes("arrow_head", GTCMetaItem.SHAPE_EXTRUDER_ARROWHEAD);
        buildExtruderShapeRecipes("axe_head", GTCMetaItem.SHAPE_EXTRUDER_AXE);
        buildExtruderShapeRecipes("large_sword_blade", GTCMetaItem.SHAPE_EXTRUDER_BEHEADER);
        buildExtruderShapeRecipes("binding", GTCMetaItem.SHAPE_EXTRUDER_BINDING);
        buildExtruderShapeRecipes("bow_limb", GTCMetaItem.SHAPE_EXTRUDER_BOWLIMB);
        buildExtruderShapeRecipes("cross_guard", GTCMetaItem.SHAPE_EXTRUDER_CROSSGUARD);
        buildExtruderShapeRecipes("excavator_head", GTCMetaItem.SHAPE_EXTRUDER_EXCAVATOR);
        buildExtruderShapeRecipes("pan_head", GTCMetaItem.SHAPE_EXTRUDER_FRYPAN);
        buildExtruderShapeRecipes("hand_guard", GTCMetaItem.SHAPE_EXTRUDER_GUARD);
        buildExtruderShapeRecipes("hammer_head", GTCMetaItem.SHAPE_EXTRUDER_HAMMER);
        buildExtruderShapeRecipes("kama_head", GTCMetaItem.SHAPE_EXTRUDER_KAMA);
        buildExtruderShapeRecipes("knife_blade", GTCMetaItem.SHAPE_EXTRUDER_KNIFEBLADE);
        buildExtruderShapeRecipes("large_plate", GTCMetaItem.SHAPE_EXTRUDER_LARGEPLATE);
        buildExtruderShapeRecipes("broad_axe_head", GTCMetaItem.SHAPE_EXTRUDER_LUMBERAXE);
        buildExtruderShapeRecipes("scythe_head", GTCMetaItem.SHAPE_EXTRUDER_SCYTHE);
        buildExtruderShapeRecipes("sharpening_kit", GTCMetaItem.SHAPE_EXTRUDER_SHARPENINGKIT);
        buildExtruderShapeRecipes("shovel_head", GTCMetaItem.SHAPE_EXTRUDER_SHOVEL);
        buildExtruderShapeRecipes("sign_head", GTCMetaItem.SHAPE_EXTRUDER_SIGN);
        buildExtruderShapeRecipes("sword_blade", GTCMetaItem.SHAPE_EXTRUDER_SWORDBLADE);
        buildExtruderShapeRecipes("tool_rod", GTCMetaItem.SHAPE_EXTRUDER_TOOLROD);
        buildExtruderShapeRecipes("tough_binding", GTCMetaItem.SHAPE_EXTRUDER_TOUGHBINDING);
        buildExtruderShapeRecipes("tough_tool_rod", GTCMetaItem.SHAPE_EXTRUDER_TOUGHTOOLROD);
        buildExtruderShapeRecipes("wide_guard", GTCMetaItem.SHAPE_EXTRUDER_WIDEGUARD);

        RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder()
                .inputs(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("tconstruct", "pattern"))))
                .notConsumable(getPattern("bow_string"))
                .outputs(getPattern("bow_string"))
                .duration(50).EUt(2).buildAndRegister();

        RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder()
                .inputs(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("tconstruct", "pattern"))))
                .notConsumable(getPattern("fletching"))
                .outputs(getPattern("fletching"))
                .duration(50).EUt(2).buildAndRegister();

        for (int i = 0; i <= 4; i++) {
            RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder()
                    .inputs(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("tconstruct", "cast"))))
                    .notConsumable(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("tconstruct", "cast_custom")), 1, i))
                    .outputs(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("tconstruct", "cast_custom")), 1, i))
                    .duration(120).EUt(22).buildAndRegister();
        }
    }

    private static void initOther() {
        RecipeMaps.MIXER_RECIPES.recipeBuilder()
                .input(OrePrefix.dust, Cobalt)
                .input(OrePrefix.dust, Ardite)
                .output(OrePrefix.dust, Manyullyn, 2)
                .duration(190).EUt(120).buildAndRegister();

        addAlloySmelter(Cobalt, 1, Ardite, 1, Manyullyn, 250, VA[MV]);
        addAlloySmelter(Copper, 1, Aluminium, 3, Aluminiumbrass, 10, VA[ULV]);
    }

    private static void buildExtruderShapeRecipes(String castType, MetaItem<?>.MetaValueItem shapeValue) {
        ItemStack cast = getCast(castType);
        ItemStack pattern = getPattern(castType);
        ItemStack shape = shapeValue.getStackForm();
        ItemStack blank = MetaItems.SHAPE_EMPTY.getStackForm();

        RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder()
                .inputs(blank)
                .notConsumable(cast)
                .outputs(shape)
                .duration(240).EUt(32).buildAndRegister();

        RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder()
                .inputs(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("tconstruct", "cast"))))
                .notConsumable(cast)
                .outputs(cast)
                .duration(120).EUt(22).buildAndRegister();

        RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder()
                .inputs(blank)
                .notConsumable(shape)
                .outputs(shape)
                .duration(120).EUt(22).buildAndRegister();

        RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder()
                .inputs(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("tconstruct", "pattern"))))
                .notConsumable(pattern)
                .outputs(pattern)
                .duration(50).EUt(2).buildAndRegister();
    }

    private static void buildToolPartRecipes(Material material, gregtech.api.unification.material.Material gtMaterial, int eut) {
        RecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                .inputs(OreDictUnifier.get(OrePrefix.ingot, gtMaterial, 2))
                .notConsumable(GTCMetaItem.SHAPE_EXTRUDER_ARROWHEAD)
                .outputs(TinkerTools.arrowHead.getItemstackWithMaterial(material))
                .duration(400).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                .inputs(OreDictUnifier.get(OrePrefix.ingot, gtMaterial, 8))
                .notConsumable(GTCMetaItem.SHAPE_EXTRUDER_BEHEADER)
                .outputs(TinkerTools.largeSwordBlade.getItemstackWithMaterial(material))
                .duration(1200).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                .inputs(OreDictUnifier.get(OrePrefix.ingot, gtMaterial, 1))
                .notConsumable(GTCMetaItem.SHAPE_EXTRUDER_BINDING)
                .outputs(TinkerTools.binding.getItemstackWithMaterial(material))
                .duration(600).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                .inputs(OreDictUnifier.get(OrePrefix.ingot, gtMaterial, 3))
                .notConsumable(GTCMetaItem.SHAPE_EXTRUDER_TOUGHBINDING)
                .outputs(TinkerTools.toughBinding.getItemstackWithMaterial(material))
                .duration(900).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                .inputs(OreDictUnifier.get(OrePrefix.ingot, gtMaterial, 3))
                .notConsumable(GTCMetaItem.SHAPE_EXTRUDER_BOWLIMB)
                .outputs(TinkerTools.bowLimb.getItemstackWithMaterial(material))
                .duration(600).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                .inputs(OreDictUnifier.get(OrePrefix.ingot, gtMaterial, 1))
                .notConsumable(GTCMetaItem.SHAPE_EXTRUDER_GUARD)
                .outputs(TinkerTools.handGuard.getItemstackWithMaterial(material))
                .duration(600).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                .inputs(OreDictUnifier.get(OrePrefix.ingot, gtMaterial, 1))
                .notConsumable(GTCMetaItem.SHAPE_EXTRUDER_CROSSGUARD)
                .outputs(TinkerTools.crossGuard.getItemstackWithMaterial(material))
                .duration(600).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                .inputs(OreDictUnifier.get(OrePrefix.ingot, gtMaterial, 1))
                .notConsumable(GTCMetaItem.SHAPE_EXTRUDER_WIDEGUARD)
                .outputs(TinkerTools.wideGuard.getItemstackWithMaterial(material))
                .duration(600).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                .inputs(OreDictUnifier.get(OrePrefix.ingot, gtMaterial, 2))
                .notConsumable(GTCMetaItem.SHAPE_EXTRUDER_SHOVEL)
                .outputs(TinkerTools.shovelHead.getItemstackWithMaterial(material))
                .duration(900).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                .inputs(OreDictUnifier.get(OrePrefix.ingot, gtMaterial, 8))
                .notConsumable(GTCMetaItem.SHAPE_EXTRUDER_EXCAVATOR)
                .outputs(TinkerTools.excavatorHead.getItemstackWithMaterial(material))
                .duration(1200).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                .inputs(OreDictUnifier.get(OrePrefix.ingot, gtMaterial, 8))
                .notConsumable(GTCMetaItem.SHAPE_EXTRUDER_HAMMER)
                .outputs(TinkerTools.hammerHead.getItemstackWithMaterial(material))
                .duration(1200).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                .inputs(OreDictUnifier.get(OrePrefix.ingot, gtMaterial, 2))
                .notConsumable(GTCMetaItem.SHAPE_EXTRUDER_KAMA)
                .outputs(TinkerTools.kamaHead.getItemstackWithMaterial(material))
                .duration(900).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                .inputs(OreDictUnifier.get(OrePrefix.ingot, gtMaterial, 1))
                .notConsumable(GTCMetaItem.SHAPE_EXTRUDER_KNIFEBLADE)
                .outputs(TinkerTools.knifeBlade.getItemstackWithMaterial(material))
                .duration(700).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                .inputs(OreDictUnifier.get(OrePrefix.ingot, gtMaterial, 8))
                .notConsumable(GTCMetaItem.SHAPE_EXTRUDER_LARGEPLATE)
                .outputs(TinkerTools.largePlate.getItemstackWithMaterial(material))
                .duration(1200).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                .inputs(OreDictUnifier.get(OrePrefix.ingot, gtMaterial, 2))
                .notConsumable(GTCMetaItem.SHAPE_EXTRUDER_AXE)
                .outputs(TinkerTools.axeHead.getItemstackWithMaterial(material))
                .duration(900).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                .inputs(OreDictUnifier.get(OrePrefix.ingot, gtMaterial, 8))
                .notConsumable(GTCMetaItem.SHAPE_EXTRUDER_LUMBERAXE)
                .outputs(TinkerTools.broadAxeHead.getItemstackWithMaterial(material))
                .duration(1200).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                .inputs(OreDictUnifier.get(OrePrefix.ingot, gtMaterial, 2))
                .notConsumable(GTCMetaItem.SHAPE_EXTRUDER_PICKAXE)
                .outputs(TinkerTools.pickHead.getItemstackWithMaterial(material))
                .duration(900).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                .inputs(OreDictUnifier.get(OrePrefix.ingot, gtMaterial, 2))
                .notConsumable(GTCMetaItem.SHAPE_EXTRUDER_SHARPENINGKIT)
                .outputs(TinkerTools.sharpeningKit.getItemstackWithMaterial(material))
                .duration(900).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                .inputs(OreDictUnifier.get(OrePrefix.ingot, gtMaterial, 3))
                .notConsumable(GTCMetaItem.SHAPE_EXTRUDER_SIGN)
                .outputs(TinkerTools.signHead.getItemstackWithMaterial(material))
                .duration(1200).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                .inputs(OreDictUnifier.get(OrePrefix.ingot, gtMaterial, 2))
                .notConsumable(GTCMetaItem.SHAPE_EXTRUDER_SWORDBLADE)
                .outputs(TinkerTools.swordBlade.getItemstackWithMaterial(material))
                .duration(900).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                .inputs(OreDictUnifier.get(OrePrefix.ingot, gtMaterial, 1))
                .notConsumable(GTCMetaItem.SHAPE_EXTRUDER_TOOLROD)
                .outputs(TinkerTools.toolRod.getItemstackWithMaterial(material))
                .duration(600).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                .inputs(OreDictUnifier.get(OrePrefix.ingot, gtMaterial, 3))
                .notConsumable(GTCMetaItem.SHAPE_EXTRUDER_TOUGHTOOLROD)
                .outputs(TinkerTools.toughToolRod.getItemstackWithMaterial(material))
                .duration(900).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                .inputs(OreDictUnifier.get(OrePrefix.ingot, gtMaterial, 8))
                .notConsumable(GTCMetaItem.SHAPE_EXTRUDER_SCYTHE)
                .outputs(TinkerTools.scytheHead.getItemstackWithMaterial(material))
                .duration(1200).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                .inputs(OreDictUnifier.get(OrePrefix.ingot, gtMaterial, 3))
                .notConsumable(GTCMetaItem.SHAPE_EXTRUDER_FRYPAN)
                .outputs(TinkerTools.panHead.getItemstackWithMaterial(material))
                .duration(1200).EUt(eut).buildAndRegister();
    }

    private static void buildExtractorRecipes(Material material, gregtech.api.unification.material.Material gtMaterial, int eut) {
        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
                .inputs(TinkerTools.arrowHead.getItemstackWithMaterial(material))
                .fluidOutputs(new FluidStack(gtMaterial.getFluid(), 2 * 144))
                .category(RecipeCategories.EXTRACTOR_RECYCLING)
                .duration(40 * 2).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
                .inputs(TinkerTools.largeSwordBlade.getItemstackWithMaterial(material))
                .fluidOutputs(new FluidStack(gtMaterial.getFluid(), 8 * 144))
                .category(RecipeCategories.EXTRACTOR_RECYCLING)
                .duration(120 * 2).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
                .inputs(TinkerTools.binding.getItemstackWithMaterial(material))
                .fluidOutputs(new FluidStack(gtMaterial.getFluid(), 1 * 144))
                .category(RecipeCategories.EXTRACTOR_RECYCLING)
                .duration(60 * 2).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
                .inputs(TinkerTools.toughBinding.getItemstackWithMaterial(material))
                .fluidOutputs(new FluidStack(gtMaterial.getFluid(), 3 * 144))
                .category(RecipeCategories.EXTRACTOR_RECYCLING)
                .duration(90 * 2).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
                .inputs(TinkerTools.bowLimb.getItemstackWithMaterial(material))
                .fluidOutputs(new FluidStack(gtMaterial.getFluid(), 3 * 144))
                .category(RecipeCategories.EXTRACTOR_RECYCLING)
                .duration(60 * 2).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
                .inputs(TinkerTools.handGuard.getItemstackWithMaterial(material))
                .fluidOutputs(new FluidStack(gtMaterial.getFluid(), 1 * 144))
                .category(RecipeCategories.EXTRACTOR_RECYCLING)
                .duration(60 * 2).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
                .inputs(TinkerTools.crossGuard.getItemstackWithMaterial(material))
                .fluidOutputs(new FluidStack(gtMaterial.getFluid(), 1 * 144))
                .category(RecipeCategories.EXTRACTOR_RECYCLING)
                .duration(60 * 2).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
                .inputs(TinkerTools.wideGuard.getItemstackWithMaterial(material))
                .fluidOutputs(new FluidStack(gtMaterial.getFluid(), 1 * 144))
                .category(RecipeCategories.EXTRACTOR_RECYCLING)
                .duration(60 * 2).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
                .inputs(TinkerTools.shovelHead.getItemstackWithMaterial(material))
                .fluidOutputs(new FluidStack(gtMaterial.getFluid(), 2 * 144))
                .category(RecipeCategories.EXTRACTOR_RECYCLING)
                .duration(90 * 2).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
                .inputs(TinkerTools.excavatorHead.getItemstackWithMaterial(material))
                .fluidOutputs(new FluidStack(gtMaterial.getFluid(), 8 * 144))
                .category(RecipeCategories.EXTRACTOR_RECYCLING)
                .duration(120 * 2).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
                .inputs(TinkerTools.hammerHead.getItemstackWithMaterial(material))
                .fluidOutputs(new FluidStack(gtMaterial.getFluid(), 8 * 144))
                .category(RecipeCategories.EXTRACTOR_RECYCLING)
                .duration(120 * 2).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
                .inputs(TinkerTools.kamaHead.getItemstackWithMaterial(material))
                .fluidOutputs(new FluidStack(gtMaterial.getFluid(), 2 * 144))
                .category(RecipeCategories.EXTRACTOR_RECYCLING)
                .duration(90 * 2).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
                .inputs(TinkerTools.knifeBlade.getItemstackWithMaterial(material))
                .fluidOutputs(new FluidStack(gtMaterial.getFluid(), 1 * 144))
                .category(RecipeCategories.EXTRACTOR_RECYCLING)
                .duration(70 * 2).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
                .inputs(TinkerTools.largePlate.getItemstackWithMaterial(material))
                .fluidOutputs(new FluidStack(gtMaterial.getFluid(), 8 * 144))
                .category(RecipeCategories.EXTRACTOR_RECYCLING)
                .duration(120 * 2).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
                .inputs(TinkerTools.axeHead.getItemstackWithMaterial(material))
                .fluidOutputs(new FluidStack(gtMaterial.getFluid(), 2 * 144))
                .category(RecipeCategories.EXTRACTOR_RECYCLING)
                .duration(90 * 2).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
                .inputs(TinkerTools.broadAxeHead.getItemstackWithMaterial(material))
                .fluidOutputs(new FluidStack(gtMaterial.getFluid(), 8 * 144))
                .category(RecipeCategories.EXTRACTOR_RECYCLING)
                .duration(120 * 2).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
                .inputs(TinkerTools.pickHead.getItemstackWithMaterial(material))
                .fluidOutputs(new FluidStack(gtMaterial.getFluid(), 2 * 144))
                .category(RecipeCategories.EXTRACTOR_RECYCLING)
                .duration(90 * 2).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
                .inputs(TinkerTools.sharpeningKit.getItemstackWithMaterial(material))
                .fluidOutputs(new FluidStack(gtMaterial.getFluid(), 2 * 144))
                .category(RecipeCategories.EXTRACTOR_RECYCLING)
                .duration(90 * 2).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
                .inputs(TinkerTools.signHead.getItemstackWithMaterial(material))
                .fluidOutputs(new FluidStack(gtMaterial.getFluid(), 3 * 144))
                .category(RecipeCategories.EXTRACTOR_RECYCLING)
                .duration(120 * 2).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
                .inputs(TinkerTools.swordBlade.getItemstackWithMaterial(material))
                .fluidOutputs(new FluidStack(gtMaterial.getFluid(), 2 * 144))
                .category(RecipeCategories.EXTRACTOR_RECYCLING)
                .duration(90 * 2).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
                .inputs(TinkerTools.toolRod.getItemstackWithMaterial(material))
                .fluidOutputs(new FluidStack(gtMaterial.getFluid(), 1 * 144))
                .category(RecipeCategories.EXTRACTOR_RECYCLING)
                .duration(60 * 2).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
                .inputs(TinkerTools.toughToolRod.getItemstackWithMaterial(material))
                .fluidOutputs(new FluidStack(gtMaterial.getFluid(), 3 * 144))
                .category(RecipeCategories.EXTRACTOR_RECYCLING)
                .duration(90 * 2).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
                .inputs(TinkerTools.scytheHead.getItemstackWithMaterial(material))
                .fluidOutputs(new FluidStack(gtMaterial.getFluid(), 8 * 144))
                .category(RecipeCategories.EXTRACTOR_RECYCLING)
                .duration(120 * 2).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
                .inputs(TinkerTools.panHead.getItemstackWithMaterial(material))
                .fluidOutputs(new FluidStack(gtMaterial.getFluid(), 3 * 144))
                .category(RecipeCategories.EXTRACTOR_RECYCLING)
                .duration(120 * 2).EUt(eut).buildAndRegister();
    }

    private static void buildBowstringRecipes(Material material, gregtech.api.unification.material.Material gtMaterial, int eut) {
        RecipeMaps.WIREMILL_RECIPES.recipeBuilder()
                .inputs(OreDictUnifier.get(OrePrefix.foil, gtMaterial, 4))
                .outputs(TinkerTools.bowString.getItemstackWithMaterial(material))
                .circuitMeta(7)
                .duration(400).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
                .inputs(TinkerTools.bowString.getItemstackWithMaterial(material))
                .fluidOutputs(new FluidStack(gtMaterial.getFluid(), 4 * 36))
                .category(RecipeCategories.EXTRACTOR_RECYCLING)
                .duration(40 * 2).EUt(eut).buildAndRegister();
    }

    private static void buildFletchingRecipes(Material material, gregtech.api.unification.material.Material gtMaterial, int eut) {
        RecipeMaps.BENDER_RECIPES.recipeBuilder()
                .inputs(OreDictUnifier.get(OrePrefix.foil, gtMaterial, 8))
                .outputs(TinkerTools.fletching.getItemstackWithMaterial(material))
                .circuitMeta(7)
                .duration(400).EUt(eut).buildAndRegister();

        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
                .inputs(TinkerTools.fletching.getItemstackWithMaterial(material))
                .fluidOutputs(new FluidStack(gtMaterial.getFluid(), 8 * 36))
                .category(RecipeCategories.EXTRACTOR_RECYCLING)
                .duration(40 * 2).EUt(eut).buildAndRegister();
    }

    private static void addAlloySmelter(gregtech.api.unification.material.Material material1, int count1, gregtech.api.unification.material.Material material2, int count2, gregtech.api.unification.material.Material output, int duration, int EUt) {
        RecipeMaps.ALLOY_SMELTER_RECIPES.recipeBuilder()
                .duration(duration).EUt(EUt)
                .input(OrePrefix.ingot, material1, count1)
                .input(OrePrefix.dust, material2, count2)
                .output(OrePrefix.ingot, output, count1 + count2)
                .buildAndRegister();

        RecipeMaps.ALLOY_SMELTER_RECIPES.recipeBuilder()
                .duration(duration).EUt(EUt)
                .input(OrePrefix.dust, material1, count1)
                .input(OrePrefix.ingot, material2, count2)
                .output(OrePrefix.ingot, output, count1 + count2)
                .buildAndRegister();

        RecipeMaps.ALLOY_SMELTER_RECIPES.recipeBuilder()
                .duration(duration).EUt(EUt)
                .input(OrePrefix.ingot, material1, count1)
                .input(OrePrefix.ingot, material2, count2)
                .output(OrePrefix.ingot, output, count1 + count2)
                .buildAndRegister();

        RecipeMaps.ALLOY_SMELTER_RECIPES.recipeBuilder()
                .duration(duration).EUt(EUt)
                .input(OrePrefix.dust, material1, count1)
                .input(OrePrefix.dust, material2, count2)
                .output(OrePrefix.ingot, output, count1 + count2)
                .buildAndRegister();
    }

    private static ItemStack getCast(String type) {
        ItemStack cast = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("tconstruct", "cast")));
        NBTTagCompound tag = new NBTTagCompound();

        tag.setString("PartType", "tconstruct:" + type);
        cast.setTagCompound(tag);

        return cast;
    }

    private static ItemStack getPattern(String type) {
        ItemStack pattern = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("tconstruct", "pattern")));
        NBTTagCompound tag = new NBTTagCompound();

        tag.setString("PartType", "tconstruct:" + type);
        pattern.setTagCompound(tag);

        return pattern;
    }
}
