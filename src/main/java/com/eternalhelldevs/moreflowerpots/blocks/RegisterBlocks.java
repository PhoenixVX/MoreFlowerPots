package com.eternalhelldevs.moreflowerpots.blocks;

import com.eternalhelldevs.moreflowerpots.MoreFlowerPots;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterBlocks {
    public static String ModIdentifier = MoreFlowerPots.ModIdentifier;
    public static final Block TEMPLATE_POT = new TemplatePotBlock(FabricBlockSettings.of(Material.METAL).hardness(4.0f));

    public static void register() {

    }
}
