package alex.tutorial;

import alex.tutorial.entity.ModEntities;
import alex.tutorial.entity.custom.TralaleroEntity;
import alex.tutorial.entity.custom.TungEntity;
import alex.tutorial.item.ModItems;
import alex.tutorial.block.ModBlocks;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tutorial implements ModInitializer {
	public static final String MOD_ID = "tutorial";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModEntities.registerModEntities();

		FabricDefaultAttributeRegistry.register(ModEntities.TUNG, TungEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.TRALALERO, TralaleroEntity.createAttributes());

	}
}