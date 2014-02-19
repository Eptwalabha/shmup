package src.components.TransitionEffect;

/**
 * User: Eptwalabha
 * Date: 11/02/14
 * Time: 00:06
 */
public class EaseInOutCircEffect extends TranslateEffect {

    public EaseInOutCircEffect(float origin, float change, float duration) {
        super(0f, origin, change, duration);
    }

    public EaseInOutCircEffect(float delay, float origin, float change, float duration) {
        super(delay, origin, change, duration);
    }

    @Override
    public float getEasingValue() {
        float deltaTime = 2 * accumulateTime / duration;
        if (deltaTime < 1)
            return -change / 2f * (float) (Math.sqrt(1 - deltaTime * deltaTime) - 1) + origin;
        deltaTime -= 2;
        return change / 2f * (float) (Math.sqrt(1 - deltaTime * deltaTime) + 1) + origin;
    }

    @Override
    public void setDelta(float delta) {
        accumulateTime += delta;
    }
}
