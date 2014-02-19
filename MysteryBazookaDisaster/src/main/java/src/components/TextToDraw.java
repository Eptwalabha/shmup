package src.components;

import com.artemis.Component;
import org.newdawn.slick.Color;

/**
 * User: Eptwalabha
 * Date: 07/02/14
 * Time: 20:23
 */
public class TextToDraw extends Component {

    private Color color;
    private String text;

    public TextToDraw(String textNotification, Color color) {
        this.text = textNotification;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
