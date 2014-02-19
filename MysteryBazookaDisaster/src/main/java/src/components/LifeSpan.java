package src.components;

import com.artemis.Component;

/**
 * User: Eptwalabha
 * Date: 07/02/14
 * Time: 20:16
 */
public class LifeSpan extends Component {
    private float delay;

    public LifeSpan(float delay) {
        this.delay = delay;
    }

    public float getDelay() {
        return delay;
    }

    public void setDelta(float delta) {
        this.delay -= delta;
    }
}
