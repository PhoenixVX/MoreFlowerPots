package com.eternalhelldevs.moreflowerpots;

import com.eternalhelldevs.moreflowerpots.registry.RegistryHandler;
import net.fabricmc.api.ModInitializer;

public class MoreFlowerPots implements ModInitializer {
    public static String MOD_ID = "more_flower_pots";

    @Override
    public void onInitialize () {
        RegistryHandler.register();
    }
}
