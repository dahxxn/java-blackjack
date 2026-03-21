package domain.state;

import domain.EarningRate;
import domain.card.Hand;

public class Stay extends Finished {
    public Stay(Hand hand) {
        super(hand);
    }

    @Override
    public EarningRate earningRate(Finished dealerState) {
        if (dealerState instanceof Blackjack) {
            return EarningRate.LOSE;
        }
        if (dealerState instanceof Bust) {
            return EarningRate.WIN;
        }
        if (this.hand.calculateScore() > dealerState.hand.calculateScore()) {
            return EarningRate.WIN;
        }
        if (this.hand.calculateScore() == dealerState.hand.calculateScore()) {
            return EarningRate.DRAW;
        }
        return EarningRate.LOSE;

    }
}
