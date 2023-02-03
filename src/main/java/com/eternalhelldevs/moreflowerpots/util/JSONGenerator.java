package com.eternalhelldevs.moreflowerpots.util;

import net.minecraft.block.Block;
import net.minecraft.registry.Registries;

import java.io.FileWriter;
import java.io.IOException;

public class JSONGenerator {
    public static void generateBlockStates() throws IOException {
    }

    public static void generateNewPlantsModels() throws IOException {
        for (String color : ModUtil.COLORS) {
            FileWriter writer;
            String flower;
            for (Block f : ModUtil.NEW_PLANTS) {
                flower = Registries.BLOCK.getId(f).getPath();
                writer = new FileWriter(color + "_potted_" + flower + ".json");
                writer.append("{\n");
                writer.append("\t\"parent\": \"more_flower_pots:block/pots/").append(color).append("_flower_pot_cross\",\n");
                writer.append("\t\"textures\": {\n");
                writer.append("\t\t\"plant\": \"block/").append(flower).append("\"\n");
                writer.append("\t}\n");
                writer.append("}");
                writer.flush();
                writer.close();
            }
            for (Block f : ModUtil.NEW_PLANTS) {
                flower = Registries.BLOCK.getId(f).getPath();
                writer = new FileWriter(color + "_glazed_potted_" + flower + ".json");
                writer.append("{\n");
                writer.append("\t\"parent\": \"more_flower_pots:block/pots/").append(color).append("_glazed_flower_pot_cross\",\n");
                writer.append("\t\"textures\": {\n");
                writer.append("\t\t\"plant\": \"block/").append(flower).append("\"\n");
                writer.append("\t}\n");
                writer.append("}");
                writer.flush();
                writer.close();
            }
        }
    }
}
