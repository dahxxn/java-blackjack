package domain.state;

import domain.card.Card;
import domain.card.Hand;

public class Hit extends Running {
    private final static int BLACKJACK = 21;

    public Hit(Hand hand) {
        super(hand);
    }

    @Override
    public State draw(Card card) {
        hand.receive(card);
        int scores = hand.calculateScore();

        if (scores > BLACKJACK) {
            return new Bust(hand);
        }
        if (scores == BLACKJACK) {
            return new Stay(hand);
        }
        return this;
    }

    @Override
    public State stay() {
        return new Stay(hand);
    }
}
