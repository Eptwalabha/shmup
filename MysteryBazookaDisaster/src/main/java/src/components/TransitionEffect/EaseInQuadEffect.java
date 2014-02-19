package src.components.TransitionEffect;

/**
 * User: Eptwalabha
 * Date: 11/02/14
 * Time: 00:06
 */
public class EaseInQuadEffect extends TranslateEffect {

    public EaseInQuadEffect(float origin, float change, float duration) {
        super(0f, origin, change, duration);
    }

    public EaseInQuadEffect(float delay, float origin, float change, float duration) {
        super(delay, origin, change, duration);
    }

    @Override
    public float getEasingValue() {
        float deltaTime = accumulateTime / duration;
//        System.out.println("ease in quad =" + change * deltaTime * deltaTime + origin + "; deltaTime = " + deltaTime + "; origin = " + origin + "; change = " + change + "; accumulateTime = " + accumulateTime+ "; duration = " + duration);
        return change * deltaTime * deltaTime + origin;
    }

    @Override
    public void setDelta(float delta) {
        accumulateTime += delta;
    }
}
