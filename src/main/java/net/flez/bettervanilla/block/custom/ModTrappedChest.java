package net.flez.bettervanilla.block.custom;

import net.flez.bettervanilla.block.entity.ModBlockEntities;
import net.flez.bettervanilla.block.entity.ModTrappedChestBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.TrappedChestBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class ModTrappedChest extends TrappedChestBlock {
    public ModTrappedChest(Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ModTrappedChestBlockEntity(pos, state);
    }
}
