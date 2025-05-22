package net.shoguns.tutorialmod.Item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.shoguns.tutorialmod.TutorialMod;
import net.shoguns.tutorialmod.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MITHRIL_ITEMS_TAB = CREATIVE_MODE_TABS.register("mithril_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MITHRIL_INGOT.get()))
                    .title(Component.translatable("creativetab.tutorialmod.mithril_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.MITHRIL_INGOT.get());
                        output.accept(ModItems.RAW_MITHRIL.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> MITHRIL_BLOCKS_TAB = CREATIVE_MODE_TABS.register("mithril_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.MITHRIL_BLOCK.get()))
                    .withTabsBefore(MITHRIL_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.tutorialmod.mithril_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.MITHRIL_BLOCK.get());
                        output.accept(ModBlocks.RAW_MITHRIL_BLOCK.get());
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
