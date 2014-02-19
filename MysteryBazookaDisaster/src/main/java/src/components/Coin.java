package src.components;

import com.artemis.Component;

/**
 * User: Eptwalabha
 * Date: 08/02/14
 * Time: 15:45
 */
public class Coin extends Component {

    private int coinValue;

    public Coin(int value) {
        coinValue = value;
    }

    public int getCoinValue() {
        return coinValue;
    }

    public void setCoinValue(int coinValue) {
        this.coinValue = coinValue;
    }
}
