package src.components;

import com.artemis.Component;

/**
 * User: Eptwalabha
 * Date: 26/01/14
 * Time: 00:27
 */
public class Health extends Component {
    float health;
    float healthMax;

    public Health(float amount) {
        health = healthMax = amount;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public float getHealthMax() {
        return healthMax;
    }

    public void setHealthMax(float healthMax) {
        this.healthMax = healthMax;
    }

    public float getPercentHealth() {
        return (healthMax != 0f) ? health / healthMax : 0f;
    }

    public void addHealth(float gain) {
        health += gain;
        health = (health < 0f) ? 0f : health;
        health = (health > healthMax) ? healthMax : health;
    }

    public void removeHealth(float damage) {
        this.addHealth(-damage);
    }
}
