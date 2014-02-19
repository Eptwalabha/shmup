package src.components;

import com.artemis.Component;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

/**
 * User: Eptwalabha
 * Date: 09/02/14
 * Time: 23:37
 */
public class HitBox extends Component {

    private float width;
    private float height;
    private float offsetX;
    private float offsetY;
    private float widthBy2;
    private float heightBy2;
    private Position origin;

    public HitBox(float width, float height) {
        this(width, height, null, 0f, 0f);
    }

    public HitBox(float width, float height, Position origin) {
        this(width, height, origin, 0f, 0f);
    }

    public HitBox(float width, float height, Position origin, float offsetX, float offsetY) {
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.origin = origin;
        widthBy2 = width / 2f;
        heightBy2 = height / 2f;
        this.width = width;
        this.height = height;
    }

    public float getLeft() {
        return (origin != null) ? origin.getX() + offsetX - widthBy2 : offsetX - widthBy2;
    }

    public float getRight() {
        return (origin != null) ? origin.getX() + offsetX + widthBy2 : offsetX + widthBy2;
    }

    public float getTop() {
        return (origin != null) ? origin.getY() + offsetY + heightBy2 : offsetY + heightBy2;
    }

    public float getBottom() {
        return (origin != null) ? origin.getY() + offsetY - heightBy2 : offsetY - heightBy2;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

}
