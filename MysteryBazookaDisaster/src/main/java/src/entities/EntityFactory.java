package src.entities;

import com.artemis.ComponentType;
import com.artemis.Entity;
import com.artemis.World;
import com.artemis.managers.GroupManager;
import org.newdawn.slick.Color;
import src.components.*;
import src.components.TransitionEffect.SinusEffect;
import src.utils.SpriteGUI;

/**
 * Created with IntelliJ IDEA.
 * User: Eptwalabha
 * Date: 25/01/14
 * Time: 23:47
 */
public class EntityFactory {

    public static Entity createNotification(World world, String textNotification, Position position, Color color, float gravity) {

        Entity notification = world.createEntity();
        notification.addComponent(new Position(position));
        notification.addComponent(new Velocity((float) (Math.random() * 2 - 1), (float) (Math.random() * 2) + 1));
        notification.addComponent(new Gravity(gravity));
        notification.addComponent(new TextToDraw(textNotification, color));
        notification.addComponent(new LifeSpan(1500));
        return notification;
    }

    public static Entity createPlayer(World world, Position worldPosition, SpriteGUI spriteGUI) {

        Entity player = world.createEntity();
        player.addComponent(new Player());
        player.addComponent(new Texture(spriteGUI.getSpriteAt(0, 0, 50)));
        player.addComponent(new KeyListener());
//        player.addComponent(new Gravity(98f));
        player.addComponent(new Velocity());
        player.addComponent(new Bound(100, 700));
        player.addComponent(new Friction(0.995f));

        Position position = new Position(worldPosition, 120, 350);
        Health health = new Health(100);
        player.addComponent(position);
        player.addComponent(health);
        player.addComponent(new DeathCounter());
        player.addComponent(new Score());
        player.addComponent(new Heal());
        player.addComponent(new HitBox(20, 30, position, 0f, 10f));
        player.addComponent(new Shadow(50));
        player.addComponent(new Wallet(0));
        player.addComponent(new Fire());

        Entity healthBar = createHealthBar(world, health, position);
        world.addEntity(healthBar);

        world.getManager(GroupManager.class).add(player, "player");
        return player;
    }

    public static Entity createHealthBar(World world, Health health, Position position) {

        Entity healthBar = world.createEntity();
        healthBar.addComponent(health);
        healthBar.addComponent(new Position(position, 0f, 0f));
        healthBar.addComponent(new DrawHealthBar());

        return healthBar;
    }

    public static Entity createWarning(World world, SpriteGUI spriteGUI) {

        Position playerPosition = (Position) world.getManager(GroupManager.class).getEntities("player").get(0).getComponent(ComponentType.getTypeFor(Position.class));

        Entity warning = world.createEntity();
        warning.addComponent(new Texture(spriteGUI.getSpriteAt(1, 0, 100)));

        Position position = new Position(playerPosition.getOrigin(), playerPosition.getLocalX(), playerPosition.getOrigin().getLocalY());
        position.movePosition(850f, (float) (Math.random()) * 550 + 100, 1f);
        warning.addComponent(position);
        warning.addComponent(new TriggerWarning(1500 + (long) (Math.random() * 500)));
        warning.addComponent(new Scaling(new SinusEffect(1f, .3f, 1000)));
        warning.addComponent(new LockPosition(playerPosition));

        return warning;
    }

    public static Entity createMissiles(World world, SpriteGUI spriteGUI, Position position) {

        Position positionPlayer = (Position) world.getManager(GroupManager.class).getEntities("player").get(0).getComponent(ComponentType.getTypeFor(Position.class));
        Entity missile = world.createEntity();
        missile.addComponent(new Texture(spriteGUI.getSpriteAt(2, 0, 50)));
        Position positionMissile = new Position(position);
        positionMissile.moveX(100);
        missile.addComponent(positionMissile);
        missile.addComponent(new Damage((int) (Math.random() * 10) + 10));
//        missile.addComponent(new Velocity((float)(Math.random() * -300) -300f, 0));
        missile.addComponent(new Velocity(positionMissile, positionPlayer, 1000));

        missile.addComponent(new ZigZagVelocity(0, (float) (Math.random() * 50) + 50, (long) (Math.random() * 200 + 300)));
        missile.addComponent(new DestroyWhenOverLeftScreen());
        missile.addComponent(new HitBox(10, 18, positionMissile, -15f, 0f));
        missile.addComponent(new Shadow(50));
        missile.addComponent(new Smoke());
        if ((int) (Math.random() * 10) > 6)
            missile.addComponent(new Explode((float) (Math.random() * 500 + 1000)));

        world.getManager(GroupManager.class).add(missile, "missiles");

//        missile.addComponent(new Heal());

        return missile;
    }

    public static void spawnGroupOfCoins(World world, SpriteGUI spriteGUI, int nbrCoins, int nbrCoinsHeight) {

        int coinX, coinY;
        float height = (float)(Math.random() * 400 + 100);

        for (int i = 0; i < nbrCoins; i++) {

            Entity coin = world.createEntity();

            coinX = i / nbrCoinsHeight * 20 + 1100;
            coinY = (int) ((i % nbrCoinsHeight) * 20 + height);
            Position positionCoin = new Position(coinX , coinY);
            coin.addComponent(new Coin(1));
            coin.addComponent(positionCoin);
            coin.addComponent(new DestroyWhenOverLeftScreen());
            coin.addComponent(new Velocity(-300f, 0f));
            coin.addComponent(new HitBox(15, 15, positionCoin));
            coin.addComponent(new Texture(spriteGUI.getSpriteAt(8, 0, 15)));

            world.getManager(GroupManager.class).add(coin, "coins");
            coin.addToWorld();
        }

    }
}
