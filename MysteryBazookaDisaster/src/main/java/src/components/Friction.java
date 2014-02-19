package src.components;

import com.artemis.Component;

/**
 * User: Eptwalabha
 * Date: 07/02/14
 * Time: 14:53
 */
public class Friction extends Component {

    private float friction;

    public Friction(float friction) {
        this.friction = friction;
    }

    public float getFriction() {
        return friction;
    }

    public void setFriction(float friction) {
        this.friction = friction;
    }
}
