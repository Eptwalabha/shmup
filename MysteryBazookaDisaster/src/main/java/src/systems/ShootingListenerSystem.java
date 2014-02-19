package src.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import org.newdawn.slick.Input;
import src.components.*;
import src.utils.SpriteGUI;

/**
 * User: Eptwalabha
 * Date: 07/02/14
 * Time: 13:41
 */
public class ShootingListenerSystem extends EntityProcessingSystem {

    @Mapper
    ComponentMapper<ShootingListener> shootingListenerComponentMapper;
    @Mapper
    ComponentMapper<FiringRate> firingRateComponentMapper;

    private Input input;
    private SpriteGUI spriteGUI;

    public ShootingListenerSystem(Input input, SpriteGUI spriteGUI) {
        super (Aspect.getAspectForAll(ShootingListener.class, FiringRate.class));
        this.input = input;
        this.spriteGUI = spriteGUI;
    }

    @Override
    protected void process(Entity e) {

        if (input.isKeyDown(Input.KEY_SPACE)) {

        }
    }

}
