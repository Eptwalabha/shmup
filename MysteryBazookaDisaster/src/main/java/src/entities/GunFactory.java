package src.entities;

import com.artemis.Entity;
import com.artemis.World;
import src.components.FiringRate;
import src.components.KeyListener;
import src.components.Position;
import src.components.ShootingListener;

/**
 * User: Eptwalabha
 * Date: 18/02/14
 * Time: 01:38
 */
public class GunFactory {

    public static Entity createABasicGun(World world, Position position) {

        Entity basicGun = world.createEntity();

        basicGun.addComponent(new Position(position, 10f, 0f));
        basicGun.addComponent(new FiringRate(100));
        basicGun.addComponent(new ShootingListener());

        return basicGun;
    }
}
