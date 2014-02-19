package src.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import src.components.Rotating;
import src.components.Scaling;
import src.components.ToDelete;
import src.components.Vanish;

/**
 * User: eptwalabha
 * Date: 24/01/14
 * Time: 15:23
 */
public class SetDeltaEntitySystem extends EntityProcessingSystem {

    @Mapper
    ComponentMapper<Scaling> scalingComponentMapper;
    @Mapper
    ComponentMapper<Rotating> rotatingComponentMapper;
    @Mapper
    ComponentMapper<Vanish> vanishingComponentMapper;

    public SetDeltaEntitySystem() {
        super(Aspect.getAspectForOne(Scaling.class, Vanish.class, Rotating.class));
    }

    @Override
    protected void process(Entity e) {

        Scaling s = scalingComponentMapper.getSafe(e);
        Vanish v = vanishingComponentMapper.getSafe(e);
        Rotating r = rotatingComponentMapper.getSafe(e);

        if (s != null)
            s.setDelta(world.getDelta());
        if (v != null)
            v.setDelta(world.getDelta());
        if (r != null)
            r.setDelta(world.getDelta());
    }
}
