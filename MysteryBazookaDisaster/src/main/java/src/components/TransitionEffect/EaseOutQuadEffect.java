package src.components.TransitionEffect;

/**
 * User: Eptwalabha
 * Date: 11/02/14
 * Time: 00:06
 */
public class EaseOutQuadEffect extends TranslateEffect {

    public EaseOutQuadEffect(float origin, float change, float duration) {
        super(0f, origin, change, duration);
    }

    public EaseOutQuadEffect(float delay, float origin, float change, float duration) {
        super(delay, origin, change, duration);
    }

    @Override
    public float getEasingValue() {
        float deltaTime = accumulateTime / duration;
        return -change * deltaTime * (deltaTime - 2f) + origin;
    }

    @Override
    public void setDelta(float delta) {
        accumulateTime += delta;
    }
}
