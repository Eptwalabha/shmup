package src.systems;

import com.artemis.*;
import com.artemis.annotations.Mapper;
import com.artemis.managers.GroupManager;
import com.artemis.systems.VoidEntitySystem;
import com.artemis.utils.Bag;
import com.artemis.utils.ImmutableBag;
import org.newdawn.slick.Color;
import src.components.*;
import src.entities.EntityFactory;
import src.entities.ParticleFactory;
import src.utils.SpriteGUI;

/**
 * User: Eptwalabha
 * Date: 09/02/14
 * Time: 23:02
 */
public class CollisionSystem extends VoidEntitySystem {

    @Mapper
    ComponentMapper<Position> positionComponentMapper;
    @Mapper
    ComponentMapper<HitBox> hitBoxComponentMapper;
    @Mapper
    ComponentMapper<Health> healthComponentMapper;
    @Mapper
    ComponentMapper<Wallet> walletComponentMapper;
    @Mapper
    ComponentMapper<Coin> coinComponentMapper;

    private Bag<CollisionByGroup> collisions;
    private SpriteGUI spriteGUI;

    public CollisionSystem(SpriteGUI spriteGUI) {
//        super(Aspect.getAspectForAll(Position.class, HitBox.class).exclude(Death.class));
        this.spriteGUI = spriteGUI;
    }

    @Override
    public void initialize() {
        collisions = new Bag<CollisionByGroup>();
        collisions.add(new CollisionByGroup("player", "missiles", new CollisionHandler() {
            @Override
            public void collide(Entity player, Entity missile) {
                Health h = healthComponentMapper.getSafe(player);
                Position p = positionComponentMapper.getSafe(player);
                Damage d = (Damage) missile.getComponent(ComponentType.getTypeFor(Damage.class));
                if (h != null && d != null && h.getHealth() > 0) {
                    h.removeHealth(d.getDamage());
                    if (h.getHealth() <= 0f) {
                        player.addComponent(new Death());
                        player.changedInWorld();
                    }
                    Entity notification = EntityFactory.createNotification(world, "-" + (int) d.getDamage(), p, Color.red, 0.4f);
                    notification.addToWorld();
                    notification.changedInWorld();
                }

                missile.addComponent(new ToDelete());
                missile.changedInWorld();
                Position pm = positionComponentMapper.getSafe(missile);

                if (pm != null)
                    ParticleFactory.createExplosion(world, spriteGUI, pm);
            }
        }));

        collisions.add(new CollisionByGroup("player", "coins", new CollisionHandler() {
            @Override
            public void collide(Entity player, Entity coin) {
                coin.addComponent(new ToDelete());
                coin.changedInWorld();
                Coin theCoin = coinComponentMapper.getSafe(coin);
                Wallet wallet = walletComponentMapper.getSafe(player);
                if (wallet != null)
                    wallet.addCoinInWallet((theCoin != null) ? theCoin.getCoinValue() : 1);
            }
        }));
    }

    @Override
    protected void processSystem() {

        for (CollisionByGroup c : collisions)
            c.checkAnyCollision();
    }

    @Override
    protected boolean checkProcessing() {
        return true;
    }

    private class CollisionByGroup {

        private CollisionHandler collisionHandler;
        private ImmutableBag<Entity> groupA;
        private ImmutableBag<Entity> groupB;

        public CollisionByGroup(String groupAName, String groupBName, CollisionHandler collisionHandler) {
            GroupManager groupManager = world.getManager(GroupManager.class);
            groupA = groupManager.getEntities(groupAName);
            groupB = groupManager.getEntities(groupBName);
            this.collisionHandler = collisionHandler;
        }

        public int checkAnyCollision() {
            int collideCounter = 0;

            for (Entity a : groupA) {
                if (a.getComponent(ComponentType.getTypeFor(Death.class)) != null)
                    continue;
                for (Entity b : groupB) {
                    if (collide(a, b)) {
                        collideCounter++;
                        collisionHandler.collide(a, b);
                    }
                }
            }
            return collideCounter;
        }

        private boolean collide(Entity a, Entity b) {
            Position positionA = positionComponentMapper.getSafe(a);
            Position positionB = positionComponentMapper.getSafe(b);
            HitBox hitBoxA = hitBoxComponentMapper.getSafe(a);
            HitBox hitBoxB = hitBoxComponentMapper.getSafe(b);

            if (hitBoxA == null || hitBoxB == null || positionA == null || positionB == null)
                return false;

            return  (hitBoxA.getLeft() <= hitBoxB.getRight()) &&
                    (hitBoxA.getRight() >= hitBoxB.getLeft()) &&
                    (hitBoxA.getBottom() <= hitBoxB.getTop()) &&
                    (hitBoxA.getTop() >= hitBoxB.getBottom());
        }
    }

    public interface CollisionHandler {
        public void collide(Entity a, Entity b);
    }
}
