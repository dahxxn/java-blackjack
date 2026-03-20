package domain;

import java.util.List;

public class Hand {
    private List<Card> cards;

    private Hand(List<Card> initialCards) {
        validate(initialCards);
        this.cards = initialCards;
    }

    public static Hand of(List<Card> cards) {
        return new Hand(cards);
    }

    public int calculateScore() {
        return cards.stream()
                .mapToInt(Card::rankScore)
                .sum();
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
