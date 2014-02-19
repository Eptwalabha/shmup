package src.components;

import com.artemis.Component;

/**
 * User: Eptwalabha
 * Date: 07/02/14
 * Time: 10:00
 */
public class TriggerWarning extends Component {
    private float delay;

    public TriggerWarning(long delay) {
        this.delay = delay;
    }

    public float getDelay() {
        return delay;
    }

    public void setDelta(float delta) {
        this.delay -= delta;
    }
}
