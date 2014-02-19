package src.components;

import com.artemis.Component;

/**
 * User: Eptwalabha
 * Date: 12/02/14
 * Time: 00:22
 */
public class Death extends Component {

    private long timeOfDeath;

    public Death() {
        this.timeOfDeath = System.currentTimeMillis();
    }

    public long getTimeOfDeath() {
        return timeOfDeath;
    }
}
