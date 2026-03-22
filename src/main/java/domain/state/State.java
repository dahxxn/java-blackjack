package domain.state;

import domain.card.Card;
import java.util.List;

public interface State {
    State draw(Card card);

    State stay();

    boolean isFinished();

    int score();

    List<Card> cards();

}
