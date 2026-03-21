package domain;

import domain.card.Card;
import domain.card.Hand;
import domain.state.Blackjack;
import domain.state.Hit;
import domain.state.State;

public class Dealer {
    private static final int DEALER_HIT_THRESHOLD = 16;
    private State state;

    private Dealer(State state) {
        this.state = state;
    }

    public static Dealer create(Hand hand) {
        State state = stateFrom(hand);
        return new Dealer(state);
    }

    public boolean isFinished() {
        return state.isFinished();
    }

    public boolean shouldHit() {
        return state.score() <= DEALER_HIT_THRESHOLD;
    }

    public void draw(Card card) {
        state = state.draw(card);
    }

    public void stay() {
        state = state.stay();
    }

    private static State stateFrom(Hand hand) {
        if (hand.isBlackjack()) {
            return new Blackjack(hand);
        }
        return new Hit(hand);
    }
}
