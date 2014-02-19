package src.components;

import com.artemis.Component;
import org.newdawn.slick.Image;

/**
 * User: Eptwalabha
 * Date: 07/02/14
 * Time: 09:59
 */
public class Texture extends Component {
    private Image image;

    public Texture(Image sprite) {
        this.image = sprite;
    }

    public Image getTexture() {
        return image;
    }

    public Image getTexture(float scale) {
        return image.getScaledCopy(scale);
    }
}
