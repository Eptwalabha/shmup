package src.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import src.components.Bound;
import src.components.Friction;
import src.components.Position;
import src.components.Velocity;

/**
 * User: eptwalabha
 * Date: 24/01/14
 * Time: 16:51
 */
public class VelocitySystem extends EntityProcessingSystem {

    @Mapper
    ComponentMapper<Bound> boundComponentMapper;
    @Mapper
    ComponentMapper<Velocity> velocityComponentMapper;
    @Mapper
    ComponentMapper<Position> positionComponentMapper;
    @Mapper
    ComponentMapper<Friction> frictionComponentMapper;

    public VelocitySystem() {
        super(Aspect.getAspectForAll(Velocity.class, Position.class));
    }

    @Override
    protected void process(Entity e) {

        Velocity v = velocityComponentMapper.get(e);
        Position p = positionComponentMapper.get(e);
        Friction f = frictionComponentMapper.getSafe(e);
        Bound b = boundComponentMapper.getSafe(e);

        if (p == null || v == null)
            return;

        p.movePosition(v, world.getDelta() / 1000);

        if (b != null){
            if (b.getRoofLevel() < p.getY()) {
                p.setPosition(p.getLocalX(), b.getRoofLevel() - p.getOrigin().getY());
                v.stopVelocity();
            }
            if (b.getFloorLevel() > p.getY()) {
                p.setPosition(p.getLocalX(), b.getFloorLevel() - p.getOrigin().getY());
                v.stopVelocity();
            }
        }

//        if (f != null)
//            v.reduceVelocityBy(f.getFriction(), world.getDelta() / 1000f);
    }
}
