package src.components;

import com.artemis.Component;

/**
 * User: Eptwalabha
 * Date: 07/02/14
 * Time: 10:25
 */
public class LockPosition extends Component {

    public Position lockedPosition;

    public LockPosition(Position position) {
        lockedPosition = position;
    }

    public void setLockedPosition(Position lockedPosition) {
        this.lockedPosition = lockedPosition;
    }
}
