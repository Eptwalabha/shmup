package src.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.IntervalEntityProcessingSystem;
import org.newdawn.slick.Color;
import src.components.Death;
import src.components.Heal;
import src.components.Health;
import src.components.Position;
import src.entities.EntityFactory;

/**
 * User: Eptwalabha
 * Date: 07/02/14
 * Time: 10:47
 */
public class HealSystem extends IntervalEntityProcessingSystem {

    @Mapper
    ComponentMapper<Health> healthComponentMapper;
    @Mapper
    ComponentMapper<Heal> healComponentMapper;
    @Mapper
    ComponentMapper<Position> positionComponentMapper;


    public HealSystem(float interval) {
        super(Aspect.getAspectForAll(Heal.class).exclude(Death.class), interval);
    }

    @Override
    protected void process(Entity e) {

        Health h = healthComponentMapper.getSafe(e);
        Heal heal = healComponentMapper.get(e);
        Position p = positionComponentMapper.getSafe(e);

        if (p == null)
            p = new Position(0f, 0f);

        int gain = (int) (Math.random() * 4) + 1;
        int realGain = 0;
        if (h != null) {
            realGain = (int) h.getHealth();
            h.addHealth(gain);
            realGain = (int) h.getHealth() - realGain;
        }

        if (realGain > 0) {
            Entity notif = EntityFactory.createNotification(world, "+" + realGain, p, Color.green, 0.1f);
            notif.addToWorld();
            notif.changedInWorld();
        }

    }
}
