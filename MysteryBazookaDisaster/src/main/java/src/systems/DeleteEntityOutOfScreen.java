package src.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import src.components.Coin;
import src.components.LifeSpan;
import src.components.Position;
import src.components.ToDelete;


/**
 * User: Eptwalabha
 * Date: 07/02/14
 * Time: 17:56
 */
public class DeleteEntityOutOfScreen extends EntityProcessingSystem {

    @Mapper
    ComponentMapper<Position> positionComponentMapper;
    @Mapper
    ComponentMapper<Coin> coinComponentMapper;

    private Position camera;
    public DeleteEntityOutOfScreen() {
        super(Aspect.getAspectForAll(Position.class).exclude(LifeSpan.class));
    }

    @Override
    protected void process(Entity e) {
        Position p = positionComponentMapper.get(e);

        if (p.getX() <= camera.getX() - 200) {
            e.addComponent(new ToDelete());
            e.changedInWorld();
//            Entity player = world.getManager(GroupManager.class).getEntities("player").get(0);
//            Health h = (Health) player.getComponent(Health.class);
//            Position pp = (Position) player.getComponent(Position.class);
//
//            int lost = (int) (Math.random() * 9) + 1;
////            System.out.println("lost = " + lost);
//            Entity notif = EntityFactory.createNotification(world, "-" + lost, pp, Color.red, 0.4f);
//            notif.addToWorld();
//            notif.changedInWorld();
//            h.addHealth(-lost);
        }

    }

    public void setCamera(Position camera) {
        this.camera = camera;
    }
}
