package com.eternalhelldevs.moreflowerpots;

import com.eternalhelldevs.moreflowerpots.registry.RegistryHandler;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.SurvivesExplosionLootCondition;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class MFPDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(RecipeGenerator::new);
        pack.addProvider(LootTableGenerator::new);
        pack.addProvider(TagGenerator::new);
    }

    private static class RecipeGenerator extends FabricRecipeProvider {
        public RecipeGenerator(FabricDataOutput output) {
            super(output);
        }

        @Override
        public void generate(RecipeExporter exporter) {

            Map<Block, Item> flowerToDyeMap = new HashMap<>();
            Map<Block, Item> flowerToGlazeMap = new HashMap<>();

            flowerToDyeMap.put(RegistryHandler.BLACK_FLOWER_POT, Items.BLACK_DYE);
            flowerToDyeMap.put(RegistryHandler.BLUE_FLOWER_POT, Items.BLUE_DYE);
            flowerToDyeMap.put(RegistryHandler.BROWN_FLOWER_POT, Items.BROWN_DYE);
            flowerToDyeMap.put(RegistryHandler.CYAN_FLOWER_POT, Items.CYAN_DYE);
            flowerToDyeMap.put(RegistryHandler.GRAY_FLOWER_POT, Items.GRAY_DYE);
            flowerToDyeMap.put(RegistryHandler.GREEN_FLOWER_POT, Items.GREEN_DYE);
            flowerToDyeMap.put(RegistryHandler.LIGHT_BLUE_FLOWER_POT, Items.LIGHT_BLUE_DYE);
            flowerToDyeMap.put(RegistryHandler.LIGHT_GRAY_FLOWER_POT, Items.LIGHT_GRAY_DYE);
            flowerToDyeMap.put(RegistryHandler.LIME_FLOWER_POT, Items.LIME_DYE);
            flowerToDyeMap.put(RegistryHandler.MAGENTA_FLOWER_POT, Items.MAGENTA_DYE);
            flowerToDyeMap.put(RegistryHandler.ORANGE_FLOWER_POT, Items.ORANGE_DYE);
            flowerToDyeMap.put(RegistryHandler.PINK_FLOWER_POT, Items.PINK_DYE);
            flowerToDyeMap.put(RegistryHandler.PURPLE_FLOWER_POT, Items.PURPLE_DYE);
            flowerToDyeMap.put(RegistryHandler.RED_FLOWER_POT, Items.RED_DYE);
            flowerToDyeMap.put(RegistryHandler.WHITE_FLOWER_POT, Items.WHITE_DYE);
            flowerToDyeMap.put(RegistryHandler.YELLOW_FLOWER_POT, Items.YELLOW_DYE);

            flowerToGlazeMap.put(RegistryHandler.BLACK_GLAZED_FLOWER_POT, Items.BLACK_GLAZED_TERRACOTTA);
            flowerToGlazeMap.put(RegistryHandler.BLUE_GLAZED_FLOWER_POT, Items.BLUE_GLAZED_TERRACOTTA);
            flowerToGlazeMap.put(RegistryHandler.BROWN_GLAZED_FLOWER_POT, Items.BROWN_GLAZED_TERRACOTTA);
            flowerToGlazeMap.put(RegistryHandler.CYAN_GLAZED_FLOWER_POT, Items.CYAN_GLAZED_TERRACOTTA);
            flowerToGlazeMap.put(RegistryHandler.GREEN_GLAZED_FLOWER_POT, Items.GREEN_GLAZED_TERRACOTTA);
            flowerToGlazeMap.put(RegistryHandler.LIGHT_BLUE_GLAZED_FLOWER_POT, Items.LIGHT_BLUE_GLAZED_TERRACOTTA);
            flowerToGlazeMap.put(RegistryHandler.MAGENTA_GLAZED_FLOWER_POT, Items.MAGENTA_GLAZED_TERRACOTTA);
            flowerToGlazeMap.put(RegistryHandler.ORANGE_GLAZED_FLOWER_POT, Items.ORANGE_GLAZED_TERRACOTTA);
            flowerToGlazeMap.put(RegistryHandler.PINK_GLAZED_FLOWER_POT, Items.PINK_GLAZED_TERRACOTTA);
            flowerToGlazeMap.put(RegistryHandler.PURPLE_GLAZED_FLOWER_POT, Items.PURPLE_GLAZED_TERRACOTTA);
            flowerToGlazeMap.put(RegistryHandler.RED_GLAZED_FLOWER_POT, Items.RED_GLAZED_TERRACOTTA);
            flowerToGlazeMap.put(RegistryHandler.WHITE_GLAZED_FLOWER_POT, Items.WHITE_GLAZED_TERRACOTTA);
            flowerToGlazeMap.put(RegistryHandler.YELLOW_GLAZED_FLOWER_POT, Items.YELLOW_GLAZED_TERRACOTTA);
            for (Map.Entry<Block, Item> entry : flowerToDyeMap.entrySet()) {
                Block block = entry.getKey();
                Item item = entry.getValue();
                offerFlowerPotOutput(exporter, block, Items.FLOWER_POT, item);
                offerSingleFlowerPotOutput(exporter, block, Items.BRICK, item);
            }

            for (Map.Entry<Block, Item> entry : flowerToGlazeMap.entrySet()) {
                Block block = entry.getKey();
                Item item = entry.getValue();
                offerGlazedFlowerPotOutput(exporter, block, item);
            }
        }

        @SuppressWarnings("SameParameterValue")
        private static void offerFlowerPotOutput(RecipeExporter exporter, Block block, Item primaryItem, Item secondaryItem) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, block, 8)
                    .pattern("###")
                    .pattern("#X#")
                    .pattern("###")
                    .input('#', primaryItem)
                    .input('X', secondaryItem)
                    .criterion(FabricRecipeProvider.hasItem(primaryItem), FabricRecipeProvider.conditionsFromItem(primaryItem))
                    .offerTo(exporter);
        }

        private static void offerGlazedFlowerPotOutput(RecipeExporter exporter, Block block, Item glazedItem) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, block, 4)
                    .pattern("# #")
                    .pattern(" # ")
                    .input('#', glazedItem)
                    .criterion(FabricRecipeProvider.hasItem(glazedItem), FabricRecipeProvider.conditionsFromItem(glazedItem))
                    .offerTo(exporter);
        }

        @SuppressWarnings("SameParameterValue")
        private static void offerSingleFlowerPotOutput(RecipeExporter exporter, Block block, Item primaryItem, Item secondaryItem) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, block, 1)
                    .pattern("#X#")
                    .pattern(" # ")
                    .input('#', primaryItem)
                    .input('X', secondaryItem)
                    .criterion(FabricRecipeProvider.hasItem(primaryItem), FabricRecipeProvider.conditionsFromItem(primaryItem))
                    .offerTo(exporter, new Identifier(MoreFlowerPots.MOD_ID, Registries.BLOCK.getId(block).getPath() + "_single"));
        }
    }

    private static class LootTableGenerator extends SimpleFabricLootTableProvider {

        public LootTableGenerator(FabricDataOutput output) {
            super(output, LootContextTypes.BLOCK);
        }

        @Override
        public void accept(BiConsumer<Identifier, LootTable.Builder> exporter) {
            for (Block block : RegistryHandler.BLOCKS) {
                Identifier blockId = Registries.BLOCK.getId(block);
                LootPool.Builder poolBuilder = new LootPool.Builder()
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(block))
                        .conditionally(SurvivesExplosionLootCondition.builder());
                LootTable.Builder tableBuilder = new LootTable.Builder()
                        .type(this.lootContextType)
                        .pool(poolBuilder);
                exporter.accept(blockId, tableBuilder);
            }
        }
    }

    private static class TagGenerator extends FabricTagProvider.BlockTagProvider {
        public TagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
            super(output, registriesFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
            for (Block block : RegistryHandler.BLOCKS) {
                getOrCreateTagBuilder(BlockTags.FLOWER_POTS).add(block);
            }
        }
    }
}
