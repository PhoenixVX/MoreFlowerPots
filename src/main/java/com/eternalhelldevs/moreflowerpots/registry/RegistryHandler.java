package com.eternalhelldevs.moreflowerpots.registry;

import com.eternalhelldevs.moreflowerpots.MoreFlowerPots;
import com.eternalhelldevs.moreflowerpots.blocks.TemplatePotBlock;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.lang.reflect.Field;

@SuppressWarnings("unused")
public class RegistryHandler {
    public static final ItemGroup ITEM_GROUP = FabricItemGroup.builder(
            new Identifier(MoreFlowerPots.MOD_ID, "item_group"))
            .icon(() -> new ItemStack(Items.FLOWER_POT))
            .build();
    public static final Block WHITE_FLOWER_POT = new TemplatePotBlock(FabricBlockSettings.of(Material.DECORATION).strength(0.0f).nonOpaque());
    public static final Block ORANGE_FLOWER_POT = new TemplatePotBlock(FabricBlockSettings.of(Material.DECORATION).strength(0.0f).nonOpaque());
    public static final Block MAGENTA_FLOWER_POT = new TemplatePotBlock(FabricBlockSettings.of(Material.DECORATION).strength(0.0f).nonOpaque());
    public static final Block LIGHT_BLUE_FLOWER_POT = new TemplatePotBlock(FabricBlockSettings.of(Material.DECORATION).strength(0.0f).nonOpaque());
    public static final Block YELLOW_FLOWER_POT = new TemplatePotBlock(FabricBlockSettings.of(Material.DECORATION).strength(0.0f).nonOpaque());
    public static final Block LIME_FLOWER_POT = new TemplatePotBlock(FabricBlockSettings.of(Material.DECORATION).strength(0.0f).nonOpaque());
    public static final Block PINK_FLOWER_POT = new TemplatePotBlock(FabricBlockSettings.of(Material.DECORATION).strength(0.0f).nonOpaque());
    public static final Block GRAY_FLOWER_POT = new TemplatePotBlock(FabricBlockSettings.of(Material.DECORATION).strength(0.0f).nonOpaque());
    public static final Block LIGHT_GRAY_FLOWER_POT = new TemplatePotBlock(FabricBlockSettings.of(Material.DECORATION).strength(0.0f).nonOpaque());
    public static final Block CYAN_FLOWER_POT = new TemplatePotBlock(FabricBlockSettings.of(Material.DECORATION).strength(0.0f).nonOpaque());
    public static final Block PURPLE_FLOWER_POT = new TemplatePotBlock(FabricBlockSettings.of(Material.DECORATION).strength(0.0f).nonOpaque());
    public static final Block BLUE_FLOWER_POT = new TemplatePotBlock(FabricBlockSettings.of(Material.DECORATION).strength(0.0f).nonOpaque());
    public static final Block BROWN_FLOWER_POT = new TemplatePotBlock(FabricBlockSettings.of(Material.DECORATION).strength(0.0f).nonOpaque());
    public static final Block GREEN_FLOWER_POT = new TemplatePotBlock(FabricBlockSettings.of(Material.DECORATION).strength(0.0f).nonOpaque());
    public static final Block RED_FLOWER_POT = new TemplatePotBlock(FabricBlockSettings.of(Material.DECORATION).strength(0.0f).nonOpaque());
    public static final Block BLACK_FLOWER_POT = new TemplatePotBlock(FabricBlockSettings.of(Material.DECORATION).strength(0.0f).nonOpaque());
    public static final Block IRON_FLOWER_POT = new TemplatePotBlock(FabricBlockSettings.of(Material.DECORATION).strength(0.0f).nonOpaque());
    public static final Block GOLD_FLOWER_POT = new TemplatePotBlock(FabricBlockSettings.of(Material.DECORATION).strength(0.0f).nonOpaque());
    public static final Block WHITE_GLAZED_FLOWER_POT = new TemplatePotBlock(FabricBlockSettings.of(Material.DECORATION).strength(0.0f).nonOpaque());
    public static final Block ORANGE_GLAZED_FLOWER_POT = new TemplatePotBlock(FabricBlockSettings.of(Material.DECORATION).strength(0.0f).nonOpaque());
    public static final Block MAGENTA_GLAZED_FLOWER_POT = new TemplatePotBlock(FabricBlockSettings.of(Material.DECORATION).strength(0.0f).nonOpaque());
    public static final Block LIGHT_BLUE_GLAZED_FLOWER_POT = new TemplatePotBlock(FabricBlockSettings.of(Material.DECORATION).strength(0.0f).nonOpaque());
    public static final Block YELLOW_GLAZED_FLOWER_POT = new TemplatePotBlock(FabricBlockSettings.of(Material.DECORATION).strength(0.0f).nonOpaque());
    public static final Block LIME_GLAZED_FLOWER_POT = new TemplatePotBlock(FabricBlockSettings.of(Material.DECORATION).strength(0.0f).nonOpaque());
    public static final Block PINK_GLAZED_FLOWER_POT = new TemplatePotBlock(FabricBlockSettings.of(Material.DECORATION).strength(0.0f).nonOpaque());
    public static final Block GRAY_GLAZED_FLOWER_POT = new TemplatePotBlock(FabricBlockSettings.of(Material.DECORATION).strength(0.0f).nonOpaque());
    public static final Block LIGHT_GRAY_GLAZED_FLOWER_POT = new TemplatePotBlock(FabricBlockSettings.of(Material.DECORATION).strength(0.0f).nonOpaque());
    public static final Block CYAN_GLAZED_FLOWER_POT = new TemplatePotBlock(FabricBlockSettings.of(Material.DECORATION).strength(0.0f).nonOpaque());
    public static final Block PURPLE_GLAZED_FLOWER_POT = new TemplatePotBlock(FabricBlockSettings.of(Material.DECORATION).strength(0.0f).nonOpaque());
    public static final Block BLUE_GLAZED_FLOWER_POT = new TemplatePotBlock(FabricBlockSettings.of(Material.DECORATION).strength(0.0f).nonOpaque());
    public static final Block BROWN_GLAZED_FLOWER_POT = new TemplatePotBlock(FabricBlockSettings.of(Material.DECORATION).strength(0.0f).nonOpaque());
    public static final Block GREEN_GLAZED_FLOWER_POT = new TemplatePotBlock(FabricBlockSettings.of(Material.DECORATION).strength(0.0f).nonOpaque());
    public static final Block RED_GLAZED_FLOWER_POT = new TemplatePotBlock(FabricBlockSettings.of(Material.DECORATION).strength(0.0f).nonOpaque());
    public static final Block BLACK_GLAZED_FLOWER_POT = new TemplatePotBlock(FabricBlockSettings.of(Material.DECORATION).strength(0.0f).nonOpaque());

    public static void register() {
        for (Field field : RegistryHandler.class.getDeclaredFields()) {
            try {
                Object object = field.get(null);
                if (object instanceof Block block) {
                    Identifier identifier = new Identifier(MoreFlowerPots.MOD_ID, field.getName().toLowerCase());

                    Registry.register(Registries.BLOCK, identifier, block);
                    Item registeredItem = Registry.register(Registries.ITEM, identifier, new BlockItem(block, new Item.Settings()));
                    ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP).register(entries -> entries.add(registeredItem));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
