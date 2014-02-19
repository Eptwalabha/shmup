package src.entities;

import com.artemis.Entity;
import com.artemis.World;
import src.components.*;
import src.components.TransitionEffect.EaseInQuadEffect;
import src.components.TransitionEffect.EaseOutQuadEffect;
import src.components.TransitionEffect.LinearEffect;
import src.utils.SpriteGUI;

/**
 * User: Eptwalabha
 * Date: 09/02/14
 * Time: 18:11
 */
public class ParticleFactory {

    public static void createExplosion(World world, SpriteGUI spriteGUI, Position position) {

        Entity shockWave = world.createEntity();
        float timeToLive = 200;
        shockWave.addComponent(new Position(position));
        shockWave.addComponent(new Texture(spriteGUI.getSpriteAt(3, 0, 10)));
        shockWave.addComponent(new LifeSpan(timeToLive));
        shockWave.addComponent(new Scaling(new LinearEffect(1f, 20f, timeToLive)));
        shockWave.addComponent(new Vanish(new EaseInQuadEffect(1f, -1f, timeToLive)));
        shockWave.addToWorld();

        for (int i = 0; i < 50; i++) {
            Entity debris = world.createEntity();
            int noTexture = (int) (Math.random() * 3) + 3;
            debris.addComponent(new Texture(spriteGUI.getSpriteAt(noTexture, 0, 40)));
            debris.addComponent(new Position(position));
            Velocity v = new Velocity((float) (Math.random() * 100) + 200, (int) (Math.random() * 360));
            debris.addComponent(v);
            debris.addComponent(new Gravity(100f));
            debris.addComponent(new LifeSpan(500));
            debris.addComponent(new Vanish(new EaseInQuadEffect(1f, -1f, 500)));
            debris.addComponent(new Rotating((float) (Math.random() * 10) - 5f));
            debris.addToWorld();
            if (Math.random() > 0.8) {
                Entity smoke = createSmokeParticle(world, spriteGUI, new Position(position));
                smoke.addComponent(v);
            }
        }
    }

    public static Entity createSmokeParticle(World world, SpriteGUI spriteGUI, Position position) {

        Entity smokeParticle = world.createEntity();
        float timeToLive = 500;
        smokeParticle.addComponent(new Position(position));
        smokeParticle.addComponent(new Gravity(-20f));
        smokeParticle.addComponent(new Velocity());
        smokeParticle.addComponent(new LifeSpan(timeToLive));
        smokeParticle.addComponent(new Vanish(new EaseInQuadEffect(1f, -.7f, timeToLive)));
//        smokeParticle.addComponent(new Vanish(new LinearEffect(1f, -1f, timeToLive)));
        smokeParticle.addComponent(new Texture(spriteGUI.getSpriteAt(6, 0, 20)));
        smokeParticle.addComponent(new Scaling(new LinearEffect(1f, 1.5f, timeToLive)));
        smokeParticle.addComponent(new Rotating(new LinearEffect(1f, (float) (Math.random() * 1) - 0.5f, timeToLive)));

        return smokeParticle;
    }

    public static Entity createFireParticle(World world, SpriteGUI spriteGUI, Position position) {

        Entity fireParticle = world.createEntity();
        float timeToLive = 500;
        fireParticle.addComponent(new Position(position));
        fireParticle.addComponent(new Gravity(-40f));
        fireParticle.addComponent(new Velocity((float) (Math.random() * 60 + 50), (int) (Math.random() * 180 - 45)));

        fireParticle.addComponent(new Vanish(new EaseOutQuadEffect(1f, -.7f, timeToLive)));
        fireParticle.addComponent(new Scaling(new EaseInQuadEffect(1f, -.7f, timeToLive)));
        fireParticle.addComponent(new Rotating(new EaseInQuadEffect(0f, (float) (Math.random() * 1) - 0.5f, timeToLive)));

        fireParticle.addComponent(new LifeSpan(timeToLive));
        fireParticle.addComponent(new Texture(spriteGUI.getSpriteAt(7, 0, 10)));

        return fireParticle;
    }
}
