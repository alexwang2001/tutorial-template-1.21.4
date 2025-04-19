package alex.tutorial.block;

import alex.tutorial.Tutorial;
import alex.tutorial.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {


    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        // Create a registry key for the block
        RegistryKey<Block> blockKey = keyOfBlock(name);
        // Create the block instance
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        // Sometimes, you may not want to register an item for the block.
        // Eg: if it's a technical block like `minecraft:moving_piston` or `minecraft:end_gateway`
        if (shouldRegisterItem) {
            // Items need to be registered with a different type of registry key, but the ID
            // can be the same.
            RegistryKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Tutorial.MOD_ID, name));
    }

    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Tutorial.MOD_ID, name));
    }

    // ------------- ADD BLOCKS HERE -----------------
    public static final Block MINJI_BLOCK = registerBlock(
            "minji_block",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.GRASS),
            true
    );

    public static void registerModBlocks(){
        Tutorial.LOGGER.info("registering mod blocks for" + Tutorial.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ModItems.MY_ITEM_GROUP_KEY).register((itemGroup) -> {
            itemGroup.add(ModBlocks.MINJI_BLOCK.asItem());
        });
    }
}
