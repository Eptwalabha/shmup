package src.components;

import com.artemis.Component;

/**
 * User: Eptwalabha
 * Date: 13/02/14
 * Time: 23:00
 */
public class DeathCounter extends Component {

    private int deathCounter;

    public DeathCounter() {
        deathCounter = 0;
    }

    public int getDeathCounter() {
        return deathCounter;
    }

    public void addNewDeath() {
        deathCounter++;
    }
}
