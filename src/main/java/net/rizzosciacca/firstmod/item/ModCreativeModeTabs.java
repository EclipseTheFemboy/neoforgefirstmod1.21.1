package net.rizzosciacca.firstmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rizzosciacca.firstmod.FirstMod;
import net.rizzosciacca.firstmod.block.ModBlocks;
import org.checkerframework.checker.units.qual.C;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FirstMod.MODID);

    public static final Supplier<CreativeModeTab> MODDED_ITEMS_TAB = CREATIVE_MODE_TAB.register("modded_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BISMUTH.get()))
                    .title(Component.translatable("creativetab.rso.modded_items"))
                    .displayItems((ItemDisplayParameters, output) -> {
                        output.accept(ModItems.BISMUTH);
                        output.accept(ModItems.RAW_BISMUTH);
    }).build());

    public static final Supplier<CreativeModeTab> MODDED_BLOCK_TAB = CREATIVE_MODE_TAB.register("modded_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.BISMUTH_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(FirstMod.MODID, "modded_items_tab"))
                    .title(Component.translatable("creativetab.rso.modded_blocks"))
                    .displayItems((ItemDisplayParameters, output) -> {
                        output.accept(ModBlocks.BISMUTH_BLOCK);
                        output.accept(ModBlocks.TESTBLOCK);
                        output.accept(ModBlocks.BISMUTH_ORE);
                        output.accept(ModBlocks.BISMUTH_DEEPSLATE_ORE);
    }).build());


    public static void register (IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);

    }
}
