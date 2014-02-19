package src.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.DelayedEntityProcessingSystem;
import src.components.Position;
import src.components.Smoke;
import src.entities.ParticleFactory;
import src.utils.SpriteGUI;

/**
 * User: Eptwalabha
 * Date: 11/02/14
 * Time: 21:43
 */
public class SmokeSystem extends DelayedEntityProcessingSystem {

    @Mapper
    ComponentMapper<Smoke> smokeComponentMapper;
    @Mapper
    ComponentMapper<Position> positionComponentMapper;
    private SpriteGUI spriteGUI;

    public SmokeSystem(SpriteGUI spriteGUI) {
        super(Aspect.getAspectForAll(Smoke.class, Position.class));
        this.spriteGUI = spriteGUI;
    }

    @Override
    protected float getRemainingDelay(Entity e) {
        return smokeComponentMapper.get(e).getDelay();
    }

    @Override
    protected void processDelta(Entity e, float accumulatedDelta) {
        smokeComponentMapper.get(e).setDelta(accumulatedDelta);
    }

    @Override
    protected void processExpired(Entity e) {
        float nextSmokeParticle = (float) Math.random() * 30;
        e.addComponent(new Smoke(nextSmokeParticle));
        e.changedInWorld();
        Position p = positionComponentMapper.get(e);
        ParticleFactory.createSmokeParticle(world, spriteGUI, p).addToWorld();
        this.offerDelay(nextSmokeParticle);
    }
}
