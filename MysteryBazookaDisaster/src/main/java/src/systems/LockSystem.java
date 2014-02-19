package src.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import src.components.LockPosition;
import src.components.Position;

/**
 * User: Eptwalabha
 * Date: 07/02/14
 * Time: 18:41
 */
public class LockSystem extends EntityProcessingSystem {

    @Mapper
    ComponentMapper<Position> positionComponentMapper;
    @Mapper
    ComponentMapper<LockPosition> lockPlayerComponentMapper;

    public LockSystem() {
        super(Aspect.getAspectForAll(LockPosition.class, Position.class));
    }

    @Override
    protected void process(Entity e) {
        LockPosition l = lockPlayerComponentMapper.get(e);
        Position p = positionComponentMapper.get(e);

        p.moveY((l.lockedPosition.getY() - p.getY()) * 0.5f * world.getDelta() / 1000f);
    }
}
