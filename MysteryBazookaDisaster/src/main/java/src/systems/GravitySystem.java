package src.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import src.components.Gravity;
import src.components.Velocity;

/**
 * User: eptwalabha
 * Date: 24/01/14
 * Time: 15:23
 */
public class GravitySystem extends EntityProcessingSystem {

    @Mapper
    ComponentMapper<Gravity> gravityMapper;
    @Mapper
    ComponentMapper<Velocity> velocityMapper;

    public GravitySystem() {
        super(Aspect.getAspectForAll(Gravity.class, Velocity.class));
    }

    @Override
    protected void process(Entity e) {

        Gravity g = gravityMapper.get(e);
        Velocity v = velocityMapper.get(e);

        v.velocityX -= g.gravityX * world.getDelta() / 1000f;
        v.velocityY -= g.gravityY * world.getDelta() / 1000f;
    }
}
