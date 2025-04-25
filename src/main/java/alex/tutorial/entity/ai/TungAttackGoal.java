package alex.tutorial.entity.ai;

import alex.tutorial.entity.custom.TungEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;


public class TungAttackGoal extends MeleeAttackGoal {

    public TungAttackGoal(TungEntity tung, double speed, boolean pauseWhenMobIdle) {
        super(tung, speed, pauseWhenMobIdle);
    }

}

