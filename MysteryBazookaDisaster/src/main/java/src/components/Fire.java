package src.components;

import com.artemis.Component;

/**
 * User: Eptwalabha
 * Date: 12/02/14
 * Time: 22:27
 */
public class Fire extends Component {

    private float delay;

    public Fire() {
        this(50f);
    }

    public Fire(float delay) {
        this.delay = delay;
    }

    public void setDelta(float delay) {
        this.delay -= delay;
    }

    public float getDelay() {
        return delay;
    }
}
