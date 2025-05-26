package net.rizzosciacca.firstmod.item.custom.chisel;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;

public class ChiselItem extends Item {
    private static final Map<Block, Block> CHISEL_MAP =
            Map.of(
            );
    public ChiselItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

            if (CHISEL_MAP.containsKey(clickedBlock)){
                if (!level.isClientSide()) { // only on server side
                    // if (level.isClientSide()) : only on client side
                }
            }

        return super.useOn(context);
    }
}
