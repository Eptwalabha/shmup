package src.components.TransitionEffect;

/**
 * User: Eptwalabha
 * Date: 11/02/14
 * Time: 00:06
 */
public class EaseInSineEffect extends TranslateEffect {

    public EaseInSineEffect(float origin, float change, float duration) {
        super(0f, origin, change, duration);
    }

    public EaseInSineEffect(float delay, float origin, float change, float duration) {
        super(delay, origin, change, duration);
    }

    @Override
    public float getEasingValue() {
        return -change * (float) Math.cos((accumulateTime / duration) * Math.PI / 2) + change + origin;
    }

    @Override
    public void setDelta(float delta) {
        accumulateTime += delta;
    }
}
