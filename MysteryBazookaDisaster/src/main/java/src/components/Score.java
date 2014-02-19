package src.components;

import com.artemis.Component;

/**
 * User: Eptwalabha
 * Date: 13/02/14
 * Time: 23:03
 */
public class Score extends Component {

    private long score;
    private long maxScore;

    public Score() {
        score = 0;
        maxScore = 0;
    }

    public void addScore(long additionalScore) {
        score += additionalScore;
        if (maxScore < score)
            maxScore = score;
    }

    public long getScore() {
        return score;
    }

    public long getMaxScore() {
        return maxScore;
    }
}
