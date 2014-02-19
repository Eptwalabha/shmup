package src.components;

import com.artemis.Component;

/**
 * User: Eptwalabha
 * Date: 11/02/14
 * Time: 00:55
 */
public class Shadow extends Component {
    private float width;
    private float height;

    public Shadow(float width) {
        this(width, width / 5);
    }

    public Shadow(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}
