
package alex.tutorial.entity.ai;

import alex.tutorial.entity.custom.TralaleroEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;


public class TralaleroAttackGoal extends MeleeAttackGoal {

    public TralaleroAttackGoal(TralaleroEntity tralalero, double speed, boolean pauseWhenMobIdle) {
        super(tralalero, speed, pauseWhenMobIdle);
    }

}