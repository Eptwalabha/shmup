package src.components.TransitionEffect;

/**
 * User: Eptwalabha
 * Date: 11/02/14
 * Time: 00:06
 */
public class EaseInOutQuadEffect extends TranslateEffect {

    public EaseInOutQuadEffect(float origin, float change, float duration) {
        super(0f, origin, change, duration);
    }

    public EaseInOutQuadEffect(float delay, float origin, float change, float duration) {
        super(delay, origin, change, duration);
    }

    @Override
    public float getEasingValue() {
        float deltaTime = (2 * accumulateTime) / duration;
        if (deltaTime < 1f)
            return change / 2f * deltaTime * deltaTime + origin;
        deltaTime--;
        return -change / 2f * (deltaTime * (deltaTime - 2f) - 1) + origin;
    }

    @Override
    public void setDelta(float delta) {
        accumulateTime += delta;
    }
}
