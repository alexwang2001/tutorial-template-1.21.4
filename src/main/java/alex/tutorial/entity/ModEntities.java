package alex.tutorial.entity;

import alex.tutorial.Tutorial;
import alex.tutorial.entity.custom.TralaleroEntity;
import alex.tutorial.entity.custom.TungEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModEntities {

    private static <T extends Entity> EntityType<T> register(RegistryKey<EntityType<?>> key, EntityType.Builder<T> type) {
        return Registry.register(Registries.ENTITY_TYPE, key, type.build(key));
    }

    private static RegistryKey<EntityType<?>> keyOf(String id) {
        return RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(Tutorial.MOD_ID, id));
    }

    private static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> type) {
        return register(keyOf(id), type);
    }
    // APPLY
    public static final EntityType<TungEntity> TUNG = register(
            "tung", EntityType.Builder.create(TungEntity::new, SpawnGroup.CREATURE).dimensions(1F, 2F).eyeHeight(1.5F).maxTrackingRange(5)
    );
    public static final EntityType<TralaleroEntity> TRALALERO = register(
            "tralalero", EntityType.Builder.create(TralaleroEntity::new, SpawnGroup.CREATURE).dimensions(1F, 2F).eyeHeight(1.5F).maxTrackingRange(10)
    );

    public static void registerModEntities() {
        Tutorial.LOGGER.info("Registering Mod Entities for " + Tutorial.MOD_ID);
    }
}