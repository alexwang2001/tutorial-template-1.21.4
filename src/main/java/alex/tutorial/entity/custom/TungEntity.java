package alex.tutorial.entity.custom;

import alex.tutorial.item.ModItems;
import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Dynamic;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.sensor.Sensor;
import net.minecraft.entity.ai.brain.sensor.SensorType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.entity.mob.PiglinEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class TungEntity extends HostileEntity {

    public TungEntity(EntityType<? extends HostileEntity > entityType, World world) {
        super(entityType, world);
        this.setPathfindingPenalty(PathNodeType.DANGER_FIRE, 16.0F);
        this.setPathfindingPenalty(PathNodeType.DAMAGE_FIRE, -1.0F);
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(0, new BreatheAirGoal(this));
        this.goalSelector.add(0, new AttackGoal(this));
        this.goalSelector.add(0, new FlyGoal(this, 0.1D));
        this.goalSelector.add(1, new LookAroundGoal(this));
        this.goalSelector.add(2, new SwimGoal(this));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.3D));
    }

    public static DefaultAttributeContainer.Builder createAttributes(){
        return createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 10)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.35)
                .add(EntityAttributes.ATTACK_DAMAGE, 1)
                .add(EntityAttributes.FOLLOW_RANGE, 20);
    }

    private ItemStack makeInitialWeapon() {
        return new ItemStack(ModItems.TUNG_BAT);
    }

    @Nullable
    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
        this.equipStack(EquipmentSlot.MAINHAND, this.makeInitialWeapon());
        return super.initialize(world, difficulty, spawnReason, entityData);
    }

//    @Nullable
//    @Override
//    public LivingEntity getTarget() {
//        return this.getTargetInBrain();
//    }

//    protected static final ImmutableList<SensorType<? extends Sensor<? super TungEntity>>> SENSOR_TYPES = ImmutableList.of(
//            SensorType.NEAREST_LIVING_ENTITIES, SensorType.NEAREST_PLAYERS, SensorType.NEAREST_ITEMS, SensorType.HURT_BY
//    );
//
//    protected static final ImmutableList<MemoryModuleType<?>> MEMORY_MODULE_TYPES = ImmutableList.of(
//            MemoryModuleType.LOOK_TARGET,
//            MemoryModuleType.MOBS,
//            MemoryModuleType.VISIBLE_MOBS,
//            MemoryModuleType.NEAREST_VISIBLE_PLAYER,
//            MemoryModuleType.NEAREST_VISIBLE_TARGETABLE_PLAYER,
//            MemoryModuleType.NEAREST_VISIBLE_WANTED_ITEM,
//            MemoryModuleType.ITEM_PICKUP_COOLDOWN_TICKS,
//            MemoryModuleType.HURT_BY,
//            MemoryModuleType.HURT_BY_ENTITY,
//            MemoryModuleType.WALK_TARGET,
//            MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE,
//            MemoryModuleType.ATTACK_TARGET,
//            MemoryModuleType.ATTACK_COOLING_DOWN,
//            MemoryModuleType.INTERACTION_TARGET,
//            MemoryModuleType.PATH,
//            MemoryModuleType.ANGRY_AT,
//            MemoryModuleType.UNIVERSAL_ANGER,
//            MemoryModuleType.AVOID_TARGET,
//            MemoryModuleType.ADMIRING_ITEM,
//            MemoryModuleType.TIME_TRYING_TO_REACH_ADMIRE_ITEM,
//            MemoryModuleType.ADMIRING_DISABLED,
//            MemoryModuleType.DISABLE_WALK_TO_ADMIRE_ITEM,
//            MemoryModuleType.CELEBRATE_LOCATION,
//            MemoryModuleType.HUNTED_RECENTLY,
//            MemoryModuleType.NEAREST_PLAYER_HOLDING_WANTED_ITEM,
//            MemoryModuleType.ATE_RECENTLY,
//            MemoryModuleType.NEAREST_REPELLENT
//    );

//    @Override
//    protected Brain.Profile<TungEntity> createBrainProfile() {
//        return Brain.createProfile(MEMORY_MODULE_TYPES, SENSOR_TYPES);
//    }
//
//
//    @Override
//    public Brain<TungEntity> getBrain() {
//        return (Brain<TungEntity>)super.getBrain();
//    }

}
