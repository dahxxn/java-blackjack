package domain.state.run;

import domain.card.Card;
import domain.card.Hand;
import domain.state.State;
import domain.state.finish.Bust;
import domain.state.finish.Stay;

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
            return new Bust();
        }
        if (scores == BLACKJACK) {
            return new Stay();
        }
        return this;
    }

    @Override
    public State stay() {
        return new Stay();
    }
}
