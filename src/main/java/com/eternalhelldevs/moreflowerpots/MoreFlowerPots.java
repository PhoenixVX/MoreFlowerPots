package com.eternalhelldevs.moreflowerpots;

import com.eternalhelldevs.moreflowerpots.blocks.RegisterBlocks;
import com.eternalhelldevs.moreflowerpots.registry.RegistryHandler;
import net.fabricmc.api.ModInitializer;

public class MoreFlowerPots implements ModInitializer {
    public static String ModIdentifier = "more_flower_pots";

    @Override
    public void onInitialize () {
        RegisterBlocks.register(); // This is really pointless
        RegistryHandler.register(); // Don't even ask me why I did this pointless monstrosity
    }
}
