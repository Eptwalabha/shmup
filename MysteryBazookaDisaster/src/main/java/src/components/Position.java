package src.components;

import com.artemis.Component;

/**
 * User: eptwalabha
 * Date: 24/01/14
 * Time: 15:31
 */
public class Position extends Component {

    private float x;
    private float y;
    private Position origin;

    /**
     * Crée une copie de cette position: même origine et même coordonnée locale.
     * @param position
     */
    public Position(Position position) {
        this(position.origin, position.x, position.y);
    }

    /**
     * Nouvelle Instance de Position avec une position d'origine et des coordonnées locales à celle-ci.
     * @param origin
     * @param x
     * @param y
     */
    public Position(Position origin, float x, float y) {
        this.origin = origin;
        this.x = x;
        this.y = y;
    }

    public Position(float x, float y) {
        this.origin = null;
        this.x = x;
        this.y = y;
    }

    public void setOrigin(Position origin) {
        this.origin = origin;
    }

    public Position getOrigin() {
        return origin;
    }

    public boolean samePosition(Position position) {
        return (getX() == position.getX()) && (getY() == position.getY());
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void setPosition(Position position) {
        x = position.x;
        y = position.y;
    }

    public void movePosition(float x, float y, float speed) {
        this.x += x * speed;
        this.y += y * speed;
    }

    public void movePosition(Velocity v, float speed) {
        this.x += v.velocityX * speed;
        this.y += v.velocityY * speed;
    }

    public float getX() {
        return (origin != null) ? origin.getX() + x : x;
    }

    public void moveX(float x) {
        this.x += x;
    }

    public float getY() {
        return (origin != null) ? origin.getY() + y : y;
    }

    public void moveY(float y) {
        this.y += y;
    }

    public float getLocalX() {
        return x;
    }

    public float getLocalY() {
        return y;
    }
}
