package src.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.DelayedEntityProcessingSystem;
import src.components.LifeSpan;
import src.components.ToDelete;

/**
 * User: Eptwalabha
 * Date: 07/02/14
 * Time: 20:14
 */
public class LifeSpanSystem extends DelayedEntityProcessingSystem {

    @Mapper
    ComponentMapper<LifeSpan> lifeSpanComponentMapper;

    public LifeSpanSystem() {
        super(Aspect.getAspectForAll(LifeSpan.class));
    }

    @Override
    protected float getRemainingDelay(Entity e) {
        return lifeSpanComponentMapper.get(e).getDelay();
    }

    @Override
    protected void processDelta(Entity e, float accumulatedDelta) {
        lifeSpanComponentMapper.get(e).setDelta(accumulatedDelta);
    }

    @Override
    protected void processExpired(Entity e) {
        e.addComponent(new ToDelete());
        e.changedInWorld();
    }
}
