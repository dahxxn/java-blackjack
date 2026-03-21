package domain.state.run;

import domain.card.Card;
import domain.card.Hand;
import domain.state.State;

public abstract class Running implements State {
    protected final Hand hand;

    protected Running(Hand hand) {
        this.hand = hand;
    }

    @Override
    public abstract State draw(Card card);

    @Override
    public abstract State stay();

    @Override
    public boolean isFinished() {
        return false;
    }
}
