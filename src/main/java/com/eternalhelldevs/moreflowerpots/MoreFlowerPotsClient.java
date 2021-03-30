package com.eternalhelldevs.moreflowerpots;

import com.eternalhelldevs.moreflowerpots.registry.RegistryHandler;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class MoreFlowerPotsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// Where else should i put this?
		BlockRenderLayerMap.INSTANCE.putBlock(RegistryHandler.WHITE_FLOWER_POT, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(RegistryHandler.ORANGE_FLOWER_POT, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(RegistryHandler.MAGENTA_FLOWER_POT, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(RegistryHandler.LIGHT_BLUE_FLOWER_POT, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(RegistryHandler.YELLOW_FLOWER_POT, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(RegistryHandler.LIME_FLOWER_POT, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(RegistryHandler.PINK_FLOWER_POT, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(RegistryHandler.GRAY_FLOWER_POT, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(RegistryHandler.LIGHT_GRAY_FLOWER_POT, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(RegistryHandler.CYAN_FLOWER_POT, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(RegistryHandler.PURPLE_FLOWER_POT, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(RegistryHandler.BLUE_FLOWER_POT, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(RegistryHandler.BROWN_FLOWER_POT, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(RegistryHandler.GREEN_FLOWER_POT, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(RegistryHandler.RED_FLOWER_POT, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(RegistryHandler.BLACK_FLOWER_POT, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(RegistryHandler.IRON_FLOWER_POT, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(RegistryHandler.GOLD_FLOWER_POT, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(RegistryHandler.WHITE_GLAZED_FLOWER_POT, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(RegistryHandler.ORANGE_GLAZED_FLOWER_POT, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(RegistryHandler.MAGENTA_GLAZED_FLOWER_POT, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(RegistryHandler.LIGHT_BLUE_GLAZED_FLOWER_POT, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(RegistryHandler.YELLOW_GLAZED_FLOWER_POT, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(RegistryHandler.LIME_GLAZED_FLOWER_POT, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(RegistryHandler.PINK_GLAZED_FLOWER_POT, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(RegistryHandler.GRAY_GLAZED_FLOWER_POT, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(RegistryHandler.LIGHT_GRAY_GLAZED_FLOWER_POT, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(RegistryHandler.CYAN_GLAZED_FLOWER_POT, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(RegistryHandler.PURPLE_GLAZED_FLOWER_POT, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(RegistryHandler.BLUE_GLAZED_FLOWER_POT, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(RegistryHandler.BROWN_GLAZED_FLOWER_POT, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(RegistryHandler.GREEN_GLAZED_FLOWER_POT, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(RegistryHandler.RED_GLAZED_FLOWER_POT, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(RegistryHandler.BLACK_GLAZED_FLOWER_POT, RenderLayer.getCutout());
	}
}
