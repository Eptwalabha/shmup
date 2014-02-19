package src.systems;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.systems.IntervalEntitySystem;
import com.artemis.utils.ImmutableBag;
import src.entities.EntityFactory;
import src.utils.SpriteGUI;

/**
 * User: Eptwalabha
 * Date: 07/02/14
 * Time: 10:47
 */
public class SpawnMissilesSystem extends IntervalEntitySystem {

    private SpriteGUI spriteGUI;

    public SpawnMissilesSystem(float interval, SpriteGUI spriteGUI) {
        super(Aspect.getEmpty(), interval);
        this.spriteGUI = spriteGUI;
    }

    @Override
    protected void processEntities(ImmutableBag<Entity> entities) {

        Entity warning = EntityFactory.createWarning(world, spriteGUI);
        warning.addToWorld();
        warning.changedInWorld();
    }

    public SpawnMissilesSystem changeInterval(float interval) {
        return new SpawnMissilesSystem(interval, spriteGUI);
    }
}
