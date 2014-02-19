package src.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.IntervalEntityProcessingSystem;
import src.components.Health;
import src.components.Position;

/**
 * User: eptwalabha
 * Date: 24/01/14
 * Time: 16:56
 */
public class ShowLogInConsole extends IntervalEntityProcessingSystem {

    @Mapper
    ComponentMapper<Health> healthComponentMapper;
    @Mapper
    ComponentMapper<Position> positionComponentMapper;

    public ShowLogInConsole(long time) {
        super(Aspect.getAspectForAll(Health.class, Position.class), time);
    }

    @Override
    protected void process(Entity entity) {

        Health h = healthComponentMapper.get(entity);
        Position p = positionComponentMapper.get(entity);
        System.out.println("health = '" + h.getHealth() + "'; position = (" + p.getX() + "," + p.getY() + ")");
    }
}
