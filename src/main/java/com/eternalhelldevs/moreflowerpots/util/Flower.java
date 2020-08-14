package com.eternalhelldevs.moreflowerpots.util;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class Flower implements Comparable<Flower> {
    public static final HashMap<String, Flower> FLOWERS = new HashMap();
    public static final Flower NONE;
    private final Block block;
    private final String name;

    public static Collection<Block> getAllFlowerBlocks() {
        HashSet<Block> blocks = new HashSet<Block>();
        for (Flower flower : FLOWERS.values()) {
            blocks.add(flower.block); // getBlock()?
        }
        return blocks;
    }

    public Flower(String name, Block block) {
        this.name = name;
        this.block = block;
    }

    @Override
    public int compareTo(Flower o) {
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

    public String getName() {
        return this.name;
    }

    public Block getBlock() {
        return this.block;
    }

    static {
        FLOWERS.put("air", new Flower("air", Blocks.AIR));
        for (Block block : ModUtil.PLANTS) {
            FLOWERS.put(Registry.BLOCK.getId(block).getPath(), new Flower(Registry.BLOCK.getId(block).getPath(), block));
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
