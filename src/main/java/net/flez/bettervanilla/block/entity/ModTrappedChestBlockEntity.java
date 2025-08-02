package net.flez.bettervanilla.block.entity;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.TrappedChestBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class ModTrappedChestBlockEntity extends TrappedChestBlockEntity {
    public ModTrappedChestBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<?> getType() {
        return ModBlockEntities.TRAPPED_CHEST_BLOCK_ENTITY;
    }
}
