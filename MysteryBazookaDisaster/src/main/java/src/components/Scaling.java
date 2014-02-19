package src.components;

import com.artemis.Component;
import src.components.TransitionEffect.TranslateEffect;

/**
 * User: Eptwalabha
 * Date: 09/02/14
 * Time: 18:58
 */
public class Scaling extends Component {

    private TranslateEffect scalingEffect;

    public Scaling(TranslateEffect scalingEffect) {
        this.scalingEffect = scalingEffect;
    }

    public float getScale() {
        return scalingEffect.getEasingValue();
    }

    public void setDelta(float delta) {
        scalingEffect.setDelta(delta);
    }
}
