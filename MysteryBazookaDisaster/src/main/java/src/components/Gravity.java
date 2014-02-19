package src.components;

import com.artemis.Component;

/**
 * User: Eptwalabha
 * Date: 07/02/14
 * Time: 10:28
 */
public class Gravity extends Component {

    public float gravityY;
    public float gravityX;

    public Gravity(float gravityY) {
        this(0f, gravityY);
    }

    public Gravity(float gravityX, float gravityY) {
        this.gravityX = gravityX;
        this.gravityY = gravityY;
    }
}
