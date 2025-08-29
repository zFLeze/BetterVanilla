package net.flez.bettervanilla.util;

import net.flez.bettervanilla.BetterVanilla;
import net.flez.bettervanilla.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class GrindFunctions extends Item {
    public GrindFunctions(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (!context.getWorld().isClient() && context.getPlayer() != null) {
            ItemStack stack = context.getPlayer().getMainHandStack();
            Item item = stack.getItem();
            int stackCount = stack.getCount();
            int result = stackCount * 4;
            BlockPos pos = context.getBlockPos();
            BlockState state = context.getWorld().getBlockState(pos);

            if (state.isOf(Blocks.GRINDSTONE)) {
                if (item == Items.AMETHYST_SHARD) {
                    context.getPlayer().setStackInHand(context.getHand(), new ItemStack(ModItems.AMETHYST_DUST, result));
                } else if (item == Items.EMERALD) {
                    context.getPlayer().setStackInHand(context.getHand(), new ItemStack(ModItems.EMERALD_DUST, result));
                }
                return ActionResult.SUCCESS;
            }
        }
        return super.useOnBlock(context);
    }
    public static void registerGrindFunctions() {
        System.out.println("Registering Grind Functions for " + BetterVanilla.MOD_ID);
    }
}
