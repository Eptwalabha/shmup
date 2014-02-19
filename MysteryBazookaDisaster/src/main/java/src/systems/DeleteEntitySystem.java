package src.systems;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import src.components.ToDelete;

/**
 * User: eptwalabha
 * Date: 24/01/14
 * Time: 15:23
 */
public class DeleteEntitySystem extends EntityProcessingSystem {

    public DeleteEntitySystem() {
        super(Aspect.getAspectForAll(ToDelete.class));
    }

    @Override
    protected void process(Entity e) {
        world.disable(e);
        e.deleteFromWorld();
    }
}
