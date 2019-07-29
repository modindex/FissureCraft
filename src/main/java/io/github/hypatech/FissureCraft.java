package io.github.hypatech;

import io.github.hypatech.block.TestGUIBlock;
import io.github.hypatech.gui.TestChestContainer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.container.BlockContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class FissureCraft implements ModInitializer {
    public static final String MODID = "fissurecraft";

    public static final Block TEST_BLOCK = new TestGUIBlock(FabricBlockSettings.of(Material.ANVIL).build());

    public static final Identifier TEST_CHEST_CONTAINER = new Identifier(MODID, "test_chest");

    public void onInitialize() {
        ContainerProviderRegistry.INSTANCE.registerFactory(TEST_CHEST_CONTAINER, (syncId, identifier, playerEntity, packetByteBuf) ->
                new TestChestContainer(syncId, playerEntity.inventory, BlockContext.create(playerEntity.world, packetByteBuf.readBlockPos()))
        );

        Registry.register(Registry.BLOCK, new Identifier(MODID, "test_block"), TEST_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(MODID, "test_block"), new BlockItem(TEST_BLOCK, new Item.Settings().group(ItemGroup.MISC)));
        System.out.println("FissureCraft Initialized!");
    }

}
