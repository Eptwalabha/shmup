package src.components.TransitionEffect;

/**
 * User: Eptwalabha
 * Date: 11/02/14
 * Time: 00:06
 */
public class EaseOutCircEffect extends TranslateEffect {

    public EaseOutCircEffect(float origin, float change, float duration) {
        super(0f, origin, change, duration);
    }

    public EaseOutCircEffect(float delay, float origin, float change, float duration) {
        super(delay, origin, change, duration);
    }

    @Override
    public float getEasingValue() {
        double deltaTime = (double) (accumulateTime / duration);
        deltaTime--;
        return change * (float) Math.sqrt(1 - deltaTime * deltaTime) + origin;
    }

    @Override
    public void setDelta(float delta) {
        accumulateTime += delta;
    }
}
