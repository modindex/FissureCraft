package io.github.hypatech;

import io.github.hypatech.gui.TestChestContainer;
import io.github.hypatech.gui.TestChestScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screen.ScreenProviderRegistry;
import net.minecraft.text.TranslatableText;

public class FissureCraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenProviderRegistry.INSTANCE.registerFactory(
                FissureCraft.TEST_CHEST_CONTAINER,
                (syncId, identifier, playerEntity, packetByteBuf) ->
                        new TestChestScreen(new TestChestContainer(syncId, playerEntity.inventory), playerEntity.inventory, new TranslatableText("container.fissurecraft.test_chest"))
        );
    }
}
