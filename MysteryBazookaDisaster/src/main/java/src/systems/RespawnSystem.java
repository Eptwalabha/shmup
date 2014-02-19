package src.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.IntervalEntityProcessingSystem;
import src.components.Death;
import src.components.Health;

/**
 * Created with IntelliJ IDEA.
 * User: Eptwalabha
 * Date: 26/01/14
 * Time: 00:40
 */
public class RespawnSystem extends IntervalEntityProcessingSystem {

    @Mapper
    ComponentMapper<Health> healthComponentMapper;

    public RespawnSystem(long timeToRespawn) {
        super(Aspect.getAspectForAll(Death.class), timeToRespawn);
    }

    @Override
    protected void process(Entity e) {

        Health h = healthComponentMapper.get(e);
        e.removeComponent(Death.class);

        if (h != null)
            h.setHealth(h.getHealthMax());

        e.changedInWorld();
    }
}
