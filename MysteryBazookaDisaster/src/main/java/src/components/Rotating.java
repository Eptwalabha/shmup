package src.components;

import com.artemis.Component;
import src.components.TransitionEffect.ConstantEffect;
import src.components.TransitionEffect.TranslateEffect;

/**
 * User: Eptwalabha
 * Date: 11/02/14
 * Time: 22:39
 */
public class Rotating extends Component {
    private TranslateEffect rotatingEffect;

    public Rotating(float rotationInDegree) {
        this.rotatingEffect = new ConstantEffect(rotationInDegree / 360f);
    }

    public Rotating(TranslateEffect rotatingEffect) {
        this.rotatingEffect = rotatingEffect;
    }

    public float getRadius() {
        return getPercent() * (float)(Math.PI * 2);
    }

    public float getDegree() {
        return getPercent() * 360f;
    }

    public float getPercent() {
        return rotatingEffect.getEasingValue() % 1;
    }

    public void setDelta(float delta) {
        rotatingEffect.setDelta(delta);
    }
}
