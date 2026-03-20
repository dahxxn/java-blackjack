package domain.card;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards;

    private Hand(List<Card> initialCards) {
        validate(initialCards);
        this.cards = new ArrayList<>(initialCards);
    }

    public static Hand of(List<Card> cards) {
        return new Hand(cards);
    }

    public int calculateScore() {
        return cards.stream()
                .mapToInt(Card::rankScore)
                .sum();
    }

    public void receive(Card card) {
        cards.add(card);
    }

    private void validate(List<Card> cards) {
        validateNotNull(cards);
    }

    private void validateNotNull(List<Card> cards) {
        if (cards == null) {
            throw new IllegalArgumentException("null 이 올 수 없습니다.");
        }
    }

}
