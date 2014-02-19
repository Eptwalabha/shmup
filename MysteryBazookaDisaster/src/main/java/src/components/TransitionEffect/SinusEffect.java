package src.components.TransitionEffect;

/**
 * User: Eptwalabha
 * Date: 11/02/14
 * Time: 22:22
 */
public class SinusEffect extends TranslateEffect {

    public SinusEffect(float origin, float change, int duration) {
        super(0f, origin, change, duration);
    }

    public SinusEffect(float delay, float origin, float change, int duration) {
        super(delay, origin, change, duration);
    }

    @Override
    public float getEasingValue() {
        return (float) Math.sin((accumulateTime % duration * Math.PI * 2) / duration) * change + origin;
    }

    @Override
    public void setDelta(float delta) {
        accumulateTime += delta;
    }
}
