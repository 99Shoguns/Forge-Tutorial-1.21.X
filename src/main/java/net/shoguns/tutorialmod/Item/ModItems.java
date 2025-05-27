package net.shoguns.tutorialmod.Item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.shoguns.tutorialmod.Item.custom.MidasFingerItem;
import net.shoguns.tutorialmod.TutorialMod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    // Register all items here
    public static final RegistryObject<Item> RAW_MITHRIL = ITEMS.register("raw_mithril",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MITHRIL_INGOT = ITEMS.register("mithril_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MIDAS_FINGER = ITEMS.register("midas_finger",
            () -> new MidasFingerItem(new Item.Properties().durability(32)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
