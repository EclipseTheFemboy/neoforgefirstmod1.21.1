package net.rizzosciacca.firstmod.item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;

import java.util.Map;

public class ChiselItem extends Item {
    private static final Map<Block, Block> CHISEL_MAP =
            Map.of(
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.STONE_BRICKS, Blocks.STONE_BRICK_STAIRS,
                    Blocks.STONE_BRICK_STAIRS, Blocks.STONE_BRICK_SLAB,
                    Blocks.END_STONE, Blocks.END_STONE_BRICKS,
                    Blocks.END_STONE_BRICKS, Blocks.END_STONE_BRICK_STAIRS,
                    Blocks.END_STONE_BRICK_STAIRS, Blocks.END_STONE_BRICK_SLAB,
                    Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS,
                    Blocks.DEEPSLATE_BRICKS, Blocks.DEEPSLATE_BRICK_STAIRS,
                    Blocks.DEEPSLATE_BRICK_STAIRS, Blocks.DEEPSLATE_BRICK_SLAB
                    );

    public ChiselItem(Properties properties){
        super (properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if(CHISEL_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide()) { //only server side
                level.setBlockAndUpdate(context.getClickedPos(), CHISEL_MAP.get(clickedBlock).defaultBlockState());

                context.getItemInHand().hurtAndBreak(1,((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));
                level.playSound(null, context.getClickedPos(), SoundEvents.GRAVEL_PLACE, SoundSource.BLOCKS);
            }
        }

        return InteractionResult.SUCCESS;

    }
}
