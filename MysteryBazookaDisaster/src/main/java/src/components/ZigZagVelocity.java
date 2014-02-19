package src.components;

import com.artemis.Component;

/**
 * User: Eptwalabha
 * Date: 07/02/14
 * Time: 10:06
 */
public class ZigZagVelocity extends Component {

    private long frequency;
    private long time;
    private float x;
    private float y;

    public ZigZagVelocity(float x, float y, long frequency) {
        this.x = x;
        this.y = y;
        this.frequency = frequency;
        this.time = System.currentTimeMillis();
    }

    public long getFrequency() {
        return frequency;
    }

    public void setFrequency(long frequency) {
        this.frequency = frequency;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
