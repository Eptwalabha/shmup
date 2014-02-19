package src.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.DelayedEntityProcessingSystem;
import src.components.Explode;
import src.components.Position;
import src.components.ToDelete;
import src.entities.ParticleFactory;
import src.utils.SpriteGUI;

/**
 * User: Eptwalabha
 * Date: 07/02/14
 * Time: 10:47
 */
public class ExplodeSystem extends DelayedEntityProcessingSystem {

    @Mapper
    ComponentMapper<Explode> explodeComponentMapper;
    @Mapper
    ComponentMapper<Position> positionComponentMapper;

    private SpriteGUI spriteGUI;

    public ExplodeSystem(SpriteGUI spriteGUI) {
        super(Aspect.getAspectForAll(Explode.class));
        this.spriteGUI = spriteGUI;
    }

    @Override
    protected float getRemainingDelay(Entity e) {
        return explodeComponentMapper.get(e).getDelay();
    }

    @Override
    protected void processDelta(Entity e, float accumulatedDelta) {
        explodeComponentMapper.get(e).setDelta(accumulatedDelta);
    }

    @Override
    protected void processExpired(Entity e) {

        e.addComponent(new ToDelete());
        e.changedInWorld();
        Position p = positionComponentMapper.getSafe(e);

        if (p != null)
            ParticleFactory.createExplosion(world, spriteGUI, p);

        offerDelay(explodeComponentMapper.get(e).getDelay());
    }
}
