package src.components.TransitionEffect;

/**
 * User: Eptwalabha
 * Date: 11/02/14
 * Time: 00:06
 */
public class EaseInCircEffect extends TranslateEffect {

    public EaseInCircEffect(float origin, float change, float duration) {
        super(0f, origin, change, duration);
    }

    public EaseInCircEffect(float delay, float origin, float change, float duration) {
        super(delay, origin, change, duration);
    }

    @Override
    public float getEasingValue() {
        float percent = accumulateTime / duration;
        return -change * (float) (Math.sqrt(1 - percent * percent) - 1) + origin;
    }

    @Override
    public void setDelta(float delta) {
        accumulateTime += delta;
    }
}
