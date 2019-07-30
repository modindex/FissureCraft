package io.github.hypatech;

import io.github.hypatech.block.Injector;
import io.github.hypatech.block.entity.InjectorEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class FissureCraft implements ModInitializer {
    public static final String MODID = "fissurecraft";

    public static final Identifier INJECTOR = new Identifier(MODID, "injector");
    public static final Block INJECTOR_BLOCK = new Injector(FabricBlockSettings.of(Material.ANVIL).build());
    public static BlockEntityType<InjectorEntity> INJECTOR_ENTITY;

    public void onInitialize() {
        //Injector
        Registry.register(Registry.BLOCK, INJECTOR, INJECTOR_BLOCK);
        Registry.register(Registry.ITEM, INJECTOR, new BlockItem(INJECTOR_BLOCK, new Item.Settings().group(ItemGroup.MISC)));
        INJECTOR_ENTITY = Registry.register(Registry.BLOCK_ENTITY, INJECTOR, BlockEntityType.Builder.create(InjectorEntity::new).build(null));


        System.out.println("FissureCraft Initialized!");
    }

}
