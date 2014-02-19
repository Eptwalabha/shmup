package src.components;

import com.artemis.Component;

/**
 * User: Eptwalabha
 * Date: 12/02/14
 * Time: 19:44
 */
public class Damage extends Component {

    private float dammage;

    public Damage(float dammage) {
        this.dammage = dammage;
    }

    public float getDamage() {
        return dammage;
    }

    public void setDammage(float dammage) {
        this.dammage = dammage;
    }
}
