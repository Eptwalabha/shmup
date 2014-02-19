package src.components.TransitionEffect;

/**
 * User: Eptwalabha
 * Date: 09/02/14
 * Time: 18:57
 */
public abstract class TranslateEffect {

    protected float accumulateTime;
    protected float change;
    protected float origin;
    protected float duration;

    public TranslateEffect(float delay, float origin, float change, float duration) {
        accumulateTime = delay;
        this.origin = origin;
        this.change = change;
        this.duration = (duration != 0) ? duration : 100;
    }

    public abstract void setDelta(float delta);
    public abstract float getEasingValue();
}
