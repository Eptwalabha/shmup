package src.components.TransitionEffect;

/**
 * User: Eptwalabha
 * Date: 12/02/14
 * Time: 00:03
 */
public class ConstantEffect extends TranslateEffect {

    private float constant;

    public ConstantEffect(float constant) {
        super(0, 0f, 0f, 1f);
        this.constant = constant;
    }

    @Override
    public float getEasingValue() {
        return constant;
    }

    @Override
    public void setDelta(float delta) {
    }
}
