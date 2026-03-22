package domain.state;

import domain.EarningRate;
import domain.card.Card;
import domain.card.Hand;
import java.util.List;

public abstract class Finished implements State {
    protected final Hand hand;

    public Finished(Hand hand) {
        this.hand = hand;
    }

    @Override
    public State draw(Card card) {
        throw new IllegalStateException("Finished 상태에서 draw를 호출할 수 없습니다.");
    }

    @Override
    public State stay() {
        throw new IllegalStateException("Finished 상태에서 stay를 호출할 수 없습니다.");
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public int score() {
        return hand.calculateScore();
    }

    public abstract EarningRate earningRate(Finished dealerState);

    @Override
    public List<Card> cards() {
        return hand.cards();
    }
}
