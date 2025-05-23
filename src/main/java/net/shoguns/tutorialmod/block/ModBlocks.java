package net.shoguns.tutorialmod.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.DropperBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.shoguns.tutorialmod.Item.ModItems;
import net.shoguns.tutorialmod.TutorialMod;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    // Register all blocks here
    public static final RegistryObject<Block> MITHRIL_BLOCK = registerBlock("mithril_block",
        () -> new Block(BlockBehaviour.Properties.of()
            .strength(4f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final RegistryObject<Block> RAW_MITHRIL_BLOCK = registerBlock("raw_mithril_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> MITHRIL_ORE = registerBlock("mithril_ore",
            () -> new DropExperienceBlock(UniformInt.of(1, 1), BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DEEPSLATE_MITHRIL_ORE = registerBlock("deepslate_mithril_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
                    .strength(5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
