package domain.state;

import domain.card.Card;
import domain.card.Hand;
import java.util.List;

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

    @Override
    public int score() {
        return hand.calculateScore();
    }

    @Override
    public List<Card> cards() {
        return hand.cards();
    }
}
