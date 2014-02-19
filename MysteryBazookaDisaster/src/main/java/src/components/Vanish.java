package src.components;

import com.artemis.Component;
import src.components.TransitionEffect.LinearEffect;
import src.components.TransitionEffect.TranslateEffect;

/**
 * User: Eptwalabha
 * Date: 11/02/14
 * Time: 21:12
 */
public class Vanish extends Component {

    private TranslateEffect translateEffect;

    public Vanish(float duration) {
        translateEffect = new LinearEffect(System.currentTimeMillis(), 1f, 0f, duration);
    }

    public Vanish(long start, float duration) {
        translateEffect = new LinearEffect(start, 1f, 0f, duration);
    }

    public Vanish(TranslateEffect translateEffect) {
        this.translateEffect = translateEffect;
    }

    public float getPercentVanished() {
        return translateEffect.getEasingValue();
    }

    public void setDelta(float delta) {
        translateEffect.setDelta(delta);
    }
}
