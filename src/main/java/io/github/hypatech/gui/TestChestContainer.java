package io.github.hypatech.gui;

import io.github.hypatech.FissureCraft;
import net.minecraft.container.BlockContext;
import net.minecraft.container.Container;
import net.minecraft.container.ContainerType;
import net.minecraft.container.Slot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.BasicInventory;
import net.minecraft.inventory.Inventory;

public class TestChestContainer extends Container {
    private final Inventory main;
    private final PlayerEntity player;
    private BlockContext context;


    public TestChestContainer(int syncId, PlayerInventory playerInventory){
        this(syncId, playerInventory, BlockContext.EMPTY);
    }

    public TestChestContainer(int syncId, PlayerInventory playerInventory, final BlockContext context) {
        super(null, syncId);
        this.main = new BasicInventory(1){
            public void markDirty(){
                super.markDirty();
                onContentChanged(this);
            }
        };
        this.context = context;
        this.player = playerInventory.player;

        this.addSlot(new Slot(this.main, 0, 27 ,21));
    }

    @Override
    public boolean canUse(PlayerEntity playerEntity) {
        return this.context.run((world, blockPos) -> {
            return world.getBlockState(blockPos).getBlock() == FissureCraft.TEST_BLOCK && playerEntity.squaredDistanceTo(blockPos.getX() + .5D, blockPos.getY() + .5D, blockPos.getZ() + .5D) < 64D;
        }, true);
    }
}
