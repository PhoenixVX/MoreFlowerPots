package com.eternalhelldevs.moreflowerpots.util;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public record Flower(String name, Block block) implements Comparable<Flower> {
    public static final HashMap<String, Flower> FLOWERS = new HashMap<>();
    public static final Flower NONE;

    public static Collection<Block> getAllFlowerBlocks() {
        HashSet<Block> blocks = new HashSet<>();
        for (Flower flower : FLOWERS.values()) {
            blocks.add(flower.block); // getBlock()?
        }
        return blocks;
    }

    @Override
    public int compareTo(@NotNull Flower o) {
        if (!FLOWERS.containsValue(this)) {
            if (!FLOWERS.containsValue(o)) {
                return 0;
            }
            return 1;
        }
        if (!FLOWERS.containsValue(o)) {
            return -1;
        }
        return 0;
    }

    static {
        FLOWERS.put("air", new Flower("air", Blocks.AIR));
        for (Block block : ModUtil.PLANTS) {
            FLOWERS.put(Registries.BLOCK.getId(block).getPath(), new Flower(Registries.BLOCK.getId(block).getPath(), block));
        }
        /* BOP is not available on Fabric.
        if (FabricLoader.getInstance().getAllMods().contains("biomesoplenty")) {
            for (Block block : BOPCompat.BOP_PLANTS) {
                FLOWERS.put("bop_" + Registry.BLOCK.getId(block).getPath(), new Flower("bop_" + Registry.BLOCK.getId(block)getPath(), block));
            }
        }*/
        NONE = FLOWERS.get("air");
    }
}
