package src.components;

import com.artemis.Component;

/**
 * User: Eptwalabha
 * Date: 13/02/14
 * Time: 00:10
 */
public class Wallet extends Component {

    private int walletAmount;

    public Wallet() {
        this(0);
    }

    public Wallet(int walletAmount) {
        this.walletAmount = walletAmount;
    }

    public int getWalletAmount() {
        return walletAmount;
    }

    public void setWalletAmount(int walletAmount) {
        this.walletAmount = walletAmount;
    }

    public void addCoinInWallet(int amount) {
        walletAmount += amount;
    }
}
