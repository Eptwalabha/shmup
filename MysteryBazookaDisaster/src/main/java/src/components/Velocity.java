package src.components;

import com.artemis.Component;

/**
 * User: eptwalabha
 * Date: 24/01/14
 * Time: 15:35
 */
public class Velocity extends Component {
    public float velocityX;
    public float velocityY;

    public Velocity() {
        this(0f, 0f);
    }

    public Velocity(float velocityX, float velocityY) {
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    public Velocity(float force, int angleInDegree) {

        double pi2 = Math.PI * 2;
        velocityX = (float)(Math.cos(angleInDegree / pi2)) * force;
        velocityY = (float)(Math.sin(angleInDegree / pi2)) * force;
    }

    public Velocity(Position origin, Position destination, float duration) {
        duration = (duration <= 0) ? 1000 : duration;
        velocityX = (destination.getX() - origin.getX()) * 1000f / duration;
        velocityY = (destination.getY() - origin.getY()) * 1000f / duration;
    }

    public void addVelocity(float addX, float addY) {
        velocityX += addX;
        velocityY += addY;
    }

    public void reduceVelocityBy(float ratioForOneSecond, float speed) {
        velocityX *= ratioForOneSecond * speed;
        velocityY *= ratioForOneSecond * speed;
    }

    public void stopVelocity() {
        velocityX = 0f;
        velocityY = 0f;
    }
}
