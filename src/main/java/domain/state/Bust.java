package domain.state;

import domain.EarningRate;
import domain.card.Hand;

public class Bust extends Finished {
    public Bust(Hand hand) {
        super(hand);
    }

    @Override
    public EarningRate earningRate(Finished dealerState) {
        return EarningRate.LOSE;
    }
}
