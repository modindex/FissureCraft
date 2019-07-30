package io.github.hypatech;

import io.github.hypatech.block.Injector;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class FissureCraft implements ModInitializer {
    public static final String MODID = "fissurecraft";

    public static final Block INJECTOR = new Injector(FabricBlockSettings.of(Material.ANVIL).build());

    public void onInitialize() {
        Registry.register(Registry.BLOCK, new Identifier(MODID, "injector"), INJECTOR);
        Registry.register(Registry.ITEM, new Identifier(MODID, "injector"), new BlockItem(INJECTOR, new Item.Settings().group(ItemGroup.MISC)));

        System.out.println("FissureCraft Initialized!");
    }

}
