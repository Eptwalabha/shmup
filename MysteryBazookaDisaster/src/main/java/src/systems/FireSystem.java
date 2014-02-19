package src.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.DelayedEntityProcessingSystem;
import src.components.Fire;
import src.components.Position;
import src.entities.ParticleFactory;
import src.utils.SpriteGUI;

/**
 * User: Eptwalabha
 * Date: 12/02/14
 * Time: 22:20
 */
public class FireSystem extends DelayedEntityProcessingSystem{

    @Mapper
    ComponentMapper<Fire> onFireComponentMapper;
    @Mapper
    ComponentMapper<Position> positionComponentMapper;
    private SpriteGUI spriteGUI;

    public FireSystem(SpriteGUI spriteGUI) {
        super(Aspect.getAspectForAll(Fire.class, Position.class));
        this.spriteGUI = spriteGUI;
    }

    @Override
    protected float getRemainingDelay(Entity e) {
        return onFireComponentMapper.get(e).getDelay();
    }

    @Override
    protected void processDelta(Entity e, float accumulatedDelta) {
        onFireComponentMapper.get(e).setDelta(accumulatedDelta);
    }

    @Override
    protected void processExpired(Entity e) {
        float nextFireParticle = (float) Math.random() * 30;
        e.addComponent(new Fire(nextFireParticle));
        e.changedInWorld();
        Position p = new Position(positionComponentMapper.get(e));
        p.moveX(-10);
        ParticleFactory.createFireParticle(world, spriteGUI, p).addToWorld();
        ParticleFactory.createFireParticle(world, spriteGUI, p).addToWorld();
        ParticleFactory.createFireParticle(world, spriteGUI, p).addToWorld();
        this.offerDelay(nextFireParticle);
    }
}
