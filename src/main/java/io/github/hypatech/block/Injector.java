package io.github.hypatech.block;

import io.github.hypatech.block.entity.InjectorEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.InventoryProvider;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.BasicInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DefaultedList;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class Injector extends Block implements InventoryProvider, BlockEntityProvider {
    public Injector(Settings block$Settings_1) {
        super(block$Settings_1);
    }

    @Override
    public boolean activate(BlockState state, World world, BlockPos blockPos, PlayerEntity playerEntity, Hand hand, BlockHitResult hitResult){
        return true;
    }

    @Override
    public SidedInventory getInventory(BlockState state, IWorld world, BlockPos pos) {
        if(world.getBlockEntity(pos) instanceof InjectorEntity) {
            return (SidedInventory) world.getBlockEntity(pos);
        }

        return null;
    }

    @Override
    public BlockEntity createBlockEntity(BlockView var1) {
        return new InjectorEntity();
    }
}
