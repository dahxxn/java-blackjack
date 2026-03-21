package domain.state;

import domain.card.Card;

public interface State {
    State draw(Card card);

    State stay();

    boolean isFinished();
}
