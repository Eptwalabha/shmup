package src.components;

import com.artemis.Component;

/**
 * User: Eptwalabha
 * Date: 07/02/14
 * Time: 23:20
 */
public class Bound extends Component {
    private float floorLevel;
    private float roofLevel;

    public Bound(float floorLevel, float roofLevel) {
        this.floorLevel = floorLevel;
        this.roofLevel = roofLevel;
    }

    public float getFloorLevel() {
        return floorLevel;
    }

    public void setFloorLevel(float floorLevel) {
        this.floorLevel = floorLevel;
    }

    public float getRoofLevel() {
        return roofLevel;
    }

    public void setRoofLevel(float roofLevel) {
        this.roofLevel = roofLevel;
    }
}
