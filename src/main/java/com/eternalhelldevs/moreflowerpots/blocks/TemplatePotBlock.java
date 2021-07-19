package com.eternalhelldevs.moreflowerpots.blocks;

import com.eternalhelldevs.moreflowerpots.properties.FlowerProperty;
import com.eternalhelldevs.moreflowerpots.util.Flower;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class TemplatePotBlock extends Block {
    public static final FlowerProperty FLOWER = FlowerProperty.create("flower", Flower.FLOWERS.values());
    protected static final VoxelShape SHAPE = Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 6.0, 11.0);

    public TemplatePotBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FLOWER, Flower.NONE));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FLOWER);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView worldIn, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (state.getBlock() instanceof TemplatePotBlock) {
            Block flower = state.get(TemplatePotBlock.FLOWER).getBlock();
            if (!player.isCreative() && !flower.equals(Blocks.AIR)) {
                BlockPos playerPos = new BlockPos(player.getX(), player.getY(), player.getZ());
                Block.dropStack(world, playerPos, new ItemStack(flower));
            }
        }
    }

    public ActionResult onUse(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockHitResult hit) {
        boolean potIsEmpty;
        ItemStack itemstack = player.getStackInHand(handIn);
        Item item = itemstack.getItem();
        Block flowerIn = Blocks.AIR;
        if (item instanceof BlockItem && Flower.getAllFlowerBlocks().contains(((BlockItem)item).getBlock())) {
            flowerIn = ((BlockItem)item).getBlock();
        }
        boolean doesNotHoldFlower = flowerIn == Blocks.AIR;
        boolean bl = potIsEmpty = (worldIn.getBlockState(pos).get(FLOWER)).getBlock() == Blocks.AIR;
        if (doesNotHoldFlower != potIsEmpty) {
            if (potIsEmpty) {
                Identifier rl = Registry.BLOCK.getId(flowerIn);
                worldIn.setBlockState(pos, this.getDefaultState().with(FLOWER, (rl.getNamespace().equals("biomesoplenty") ? Flower.FLOWERS.get("bop_" + rl.getPath()) : Flower.FLOWERS.get(rl.getPath()))), 3);
                player.incrementStat(Stats.POT_FLOWER);
                if (!player.getAbilities().creativeMode) {
                    itemstack.decrement(1);
                }
            } else {
                ItemStack itemStack1 = new ItemStack((worldIn.getBlockState(pos).get(FLOWER)).getBlock());
                if (itemstack.isEmpty()) {
                    player.setStackInHand(handIn, itemStack1);
                } else if (!player.giveItemStack(itemStack1)) {
                    player.dropItem(itemStack1, false);
                }
                worldIn.setBlockState(pos, this.getDefaultState(), 3);
            }
        }
        return ActionResult.SUCCESS;
    }
}
