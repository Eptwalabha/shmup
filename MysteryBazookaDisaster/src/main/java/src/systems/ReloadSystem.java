package src.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.DelayedEntityProcessingSystem;
import src.components.FiringRate;
import src.components.Position;
import src.components.Smoke;
import src.entities.ParticleFactory;
import src.utils.SpriteGUI;

/**
 * User: Eptwalabha
 * Date: 11/02/14
 * Time: 21:43
 */
public class ReloadSystem extends DelayedEntityProcessingSystem {

    @Mapper
    ComponentMapper<FiringRate> shootComponentMapper;

    public ReloadSystem() {
        super(Aspect.getAspectForAll(FiringRate.class));
    }

    @Override
    protected float getRemainingDelay(Entity e) {
        return shootComponentMapper.get(e).timeLeftTillNextShoot;
    }

    @Override
    protected void processDelta(Entity e, float accumulatedDelta) {
        shootComponentMapper.get(e).setDelta(accumulatedDelta);
    }

    @Override
    protected void processExpired(Entity e) {}
}
