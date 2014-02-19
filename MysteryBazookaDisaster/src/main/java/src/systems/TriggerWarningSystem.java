package src.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.DelayedEntityProcessingSystem;
import src.components.Position;
import src.components.ToDelete;
import src.components.TriggerWarning;
import src.entities.EntityFactory;
import src.utils.SpriteGUI;

/**
 * User: Eptwalabha
 * Date: 07/02/14
 * Time: 14:38
 */
public class TriggerWarningSystem extends DelayedEntityProcessingSystem {

    private SpriteGUI spriteGUI;

    @Mapper
    ComponentMapper<TriggerWarning> triggerWarningComponentMapper;
    @Mapper
    ComponentMapper<Position> positionWarningComponentMapper;

    public TriggerWarningSystem(SpriteGUI spriteGUI) {
        super(Aspect.getAspectForAll(TriggerWarning.class, Position.class));
        this.spriteGUI = spriteGUI;
    }

    @Override
    protected float getRemainingDelay(Entity e) {
        return triggerWarningComponentMapper.get(e).getDelay();
    }

    @Override
    protected void processDelta(Entity e, float accumulatedDelta) {
        triggerWarningComponentMapper.get(e).setDelta(accumulatedDelta);
    }

    @Override
    protected void processExpired(Entity e) {

        Position p = positionWarningComponentMapper.get(e);
        world.addEntity(EntityFactory.createMissiles(world, spriteGUI, p));
        e.addComponent(new ToDelete());
        e.changedInWorld();
//        world.deleteEntity(e);
    }
}
