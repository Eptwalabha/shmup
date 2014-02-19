package src.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import org.newdawn.slick.Input;
import src.components.Death;
import src.components.KeyListener;
import src.components.Velocity;

/**
 * User: Eptwalabha
 * Date: 07/02/14
 * Time: 13:41
 */
public class InputListenerSystem extends EntityProcessingSystem {
    private Input input;

    @Mapper
    ComponentMapper<Velocity> velocityComponentMapper;

    public InputListenerSystem(Input input) {
        super (Aspect.getAspectForAll(KeyListener.class).exclude(Death.class));
        this.input = input;
    }

    @Override
    protected void process(Entity e) {

        Velocity v = velocityComponentMapper.getSafe(e);

        if (v == null)
            return;

        if (input.isKeyDown(Input.KEY_UP))
            v.addVelocity(0, 5f);

        if (input.isKeyDown(Input.KEY_DOWN))
            v.addVelocity(0, -5f);

//        System.out.println("velocity = " + v.getVelocityY());
    }

}
