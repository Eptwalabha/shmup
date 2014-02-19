package src.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import src.components.Position;
import src.components.ZigZagVelocity;

/**
 * User: Eptwalabha
 * Date: 07/02/14
 * Time: 14:55
 */
public class ZigZagSystem extends EntityProcessingSystem {

    @Mapper
    ComponentMapper<Position> positionComponentMapper;
    @Mapper
    ComponentMapper<ZigZagVelocity> zigZagVelocityComponentMapper;
    private float delta;

    public ZigZagSystem() {
        super(Aspect.getAspectForAll(ZigZagVelocity.class, Position.class));
    }

    @Override
    public void begin() {
        delta = world.getDelta() / 1000f;
    }

    @Override
    protected void process(Entity e) {

        ZigZagVelocity z = zigZagVelocityComponentMapper.get(e);
        Position p = positionComponentMapper.get(e);

        double freq = z.getFrequency();
        double delta = ((System.currentTimeMillis() - z.getTime()) % freq * Math.PI * 2) / freq;
        float sin = (float) Math.sin(delta);
        p.movePosition(z.getX() * sin, z.getY() * sin, this.delta);

    }
}
