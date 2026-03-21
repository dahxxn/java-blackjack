package domain.state;

import domain.EarningRate;
import domain.card.Hand;

public class Blackjack extends Finished {
    public Blackjack(Hand hand) {
        super(hand);
    }

    @Override
    public EarningRate earningRate(Finished dealerState) {
        if (dealerState instanceof Blackjack) {
            return EarningRate.DRAW;
        }
        return EarningRate.BLACKJACK;
    }

}
