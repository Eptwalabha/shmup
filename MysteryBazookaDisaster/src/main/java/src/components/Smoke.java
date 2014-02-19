package src.components;

import com.artemis.Component;

/**
 * User: Eptwalabha
 * Date: 11/02/14
 * Time: 21:47
 */
public class Smoke extends Component {

    private float delay;

    public Smoke() {
        this(50f);
    }

    public Smoke(float delay) {
        this.delay = delay;
    }

    public void setDelta(float delay) {
        this.delay -= delay;
    }

    public float getDelay() {
        return delay;
    }
}
