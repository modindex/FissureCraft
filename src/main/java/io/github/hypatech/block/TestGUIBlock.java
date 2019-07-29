package io.github.hypatech.block;

import io.github.hypatech.FissureCraft;
import io.github.hypatech.gui.TestChestContainer;
import net.fabricmc.fabric.api.client.screen.ScreenProviderRegistry;
import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.InventoryProvider;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class TestGUIBlock extends Block {
    public TestGUIBlock(Settings block$Settings_1) {
        super(block$Settings_1);
    }

    @Override
    public boolean activate(BlockState state, World world, BlockPos blockPos, PlayerEntity playerEntity, Hand hand, BlockHitResult hitResult){
        if(!world.isClient){

            ContainerProviderRegistry.INSTANCE.openContainer(FissureCraft.TEST_CHEST_CONTAINER, playerEntity, buf -> buf.writeBlockPos(blockPos));
        } else{
        }

        return true;
    }

}
