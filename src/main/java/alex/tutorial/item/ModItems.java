package alex.tutorial.item;

import alex.tutorial.Tutorial;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.text.Text;
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

    // ----------- ADD ITEMS HERE -------------
    public static final Item TUNG_BAT = registerItem("tung_bat", Item::new, new Item.Settings());

    public static void registerModItems(){
        Tutorial.LOGGER.info("registering mod item for" + Tutorial.MOD_ID);

        // add item to group
        //ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((itemGroup) -> itemGroup.add(ModItems.TUNG_BAT));

        Registry.register(Registries.ITEM_GROUP, MY_ITEM_GROUP_KEY, MY_ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(MY_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModItems.TUNG_BAT);
        }
        );
    }

    // Custom group
    public static final RegistryKey<ItemGroup> MY_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(Tutorial.MOD_ID, "item_group"));

    public static final ItemGroup MY_ITEM_GROUP = FabricItemGroup.builder().icon(() -> new ItemStack(TUNG_BAT)).displayName(Text.translatable("itemGroup.tutorial")).build();


}
