package io.github.hypatech.block.entity;

import io.github.hypatech.FissureCraft;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.DefaultedList;

public class InjectorEntity extends BlockEntity implements ImplementedInventory {
    private DefaultedList<ItemStack> inventoryList;


    public InjectorEntity() {
        super(FissureCraft.INJECTOR_ENTITY);
        inventoryList = DefaultedList.ofSize(2, ItemStack.EMPTY);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventoryList;
    }

    public void fromTag(CompoundTag tag){
        Inventories.fromTag(tag, inventoryList);
    }

    public CompoundTag toTag(CompoundTag tag){
        return Inventories.toTag(tag, inventoryList);
    }
}
