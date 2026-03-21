package domain;

import domain.card.Card;
import domain.card.Hand;
import domain.state.Blackjack;
import domain.state.Hit;
import domain.state.State;

public class Player {
    private State state;
    private final Name name;

    private Player(State state, Name name) {
        this.state = state;
        this.name = name;
    }

    public static Player create(Name name, Hand hand) {
        State state = stateFrom(hand);
        return new Player(state, name);
    }

    public boolean isFinished() {
        return state.isFinished();
    }

    public void draw(Card card) {
        state = state.draw(card);
    }

    public void stay() {
        state = state.stay();
    }

    public String name() {
        return name.name();
    }

    public int score() {
        return state.score();
    }

    private static State stateFrom(Hand hand) {
        if (hand.isBlackjack()) {
            return new Blackjack(hand);
        }
        return new Hit(hand);
    }
}
