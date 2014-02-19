package src.components.TransitionEffect;

/**
 * User: Eptwalabha
 * Date: 11/02/14
 * Time: 00:06
 */
public class EaseInOutSineEffect extends TranslateEffect {

    public EaseInOutSineEffect(float origin, float change, float duration) {
        super(0f, origin, change, duration);
    }

    public EaseInOutSineEffect(float delay, float origin, float change, float duration) {
        super(delay, origin, change, duration);
    }

    @Override
    public float getEasingValue() {
        return -change / 2f * (float) (Math.cos((accumulateTime / duration) * Math.PI) - 1) + origin;
    }

    @Override
    public void setDelta(float delta) {
        accumulateTime += delta;
    }
}
