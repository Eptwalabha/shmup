package src.components;

import com.artemis.Component;

/**
 * User: Eptwalabha
 * Date: 18/02/14
 * Time: 01:30
 */
public class FiringRate extends Component {

    public float firingRate;
    public float timeLeftTillNextShoot;

    public FiringRate() {
        this(200);
    }

    public FiringRate(float firingRate) {
        this.firingRate = firingRate;
        timeLeftTillNextShoot = 0;
    }

    public void setDelta(float delta) {
        timeLeftTillNextShoot = ((timeLeftTillNextShoot - delta) > 0) ? timeLeftTillNextShoot : 0f;
    }
}
