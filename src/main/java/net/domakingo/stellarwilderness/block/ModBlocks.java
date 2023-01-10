package net.domakingo.stellarwilderness.block;

import net.domakingo.stellarwilderness.block.custom.StarBlock;
import net.domakingo.stellarwilderness.block.custom.TestBlock;
import net.domakingo.stellarwilderness.item.ModCreativeModeTab;
import net.domakingo.stellarwilderness.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static net.domakingo.stellarwilderness.StellarWilderness.MODID;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);



    // codice per aggiungere un blocco

    // test block
    public static final RegistryObject<Block> TEST_BLOCK = registerBlock("test_block",
            () -> new TestBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(7f).requiresCorrectToolForDrops().jumpFactor(2)), ModCreativeModeTab.STELLAR_TAB);

    // star block
    public static final RegistryObject<Block> STAR_BLOCK = registerBlock("star_block",
            () -> new StarBlock(BlockBehaviour.Properties.of(Material.AMETHYST)
                    .strength(8f).requiresCorrectToolForDrops()), ModCreativeModeTab.STELLAR_TAB);



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                           CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
