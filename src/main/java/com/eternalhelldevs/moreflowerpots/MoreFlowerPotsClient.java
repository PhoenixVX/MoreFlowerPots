package com.eternalhelldevs.moreflowerpots;

import com.eternalhelldevs.moreflowerpots.registry.RegistryHandler;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;

import java.lang.reflect.Field;

public class MoreFlowerPotsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		for (Field field : RegistryHandler.class.getDeclaredFields()) {
			try {
				Object object = field.get(null);
				if (object instanceof Block block) {
					BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
}
