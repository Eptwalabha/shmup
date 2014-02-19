package src.components.TransitionEffect;

/**
 * User: Eptwalabha
 * Date: 11/02/14
 * Time: 00:06
 */
public class LinearEffect extends TranslateEffect {

    public LinearEffect(float origin, float change, float duration) {
        super(0f, origin, change, duration);
    }

    public LinearEffect(float delay, float origin, float change, float duration) {
        super(delay, origin, change, duration);
    }

    @Override
    public float getEasingValue() {
        return change * accumulateTime / duration + origin;
    }

    @Override
    public void setDelta(float delta) {
        accumulateTime += delta;
    }
}
