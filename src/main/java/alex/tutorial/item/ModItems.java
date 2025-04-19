package alex.tutorial.item;

import alex.tutorial.Tutorial;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;


public class ModItems {
    
    private static Item registerItem(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings){
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Tutorial.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static final Item TUNG_BAT = registerItem("tung_bat", Item::new, new Item.Settings());

    public static void registerModItems(){
        Tutorial.LOGGER.info("registering mod item for" + Tutorial.MOD_ID);

        // add item to group
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((itemGroup) -> itemGroup.add(ModItems.TUNG_BAT));
    }
}
