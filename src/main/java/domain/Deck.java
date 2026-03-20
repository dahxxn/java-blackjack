package domain;

import java.util.List;

public class Deck {
    private final List<Card> cards;

    private Deck(List<Card> cards) {
        validate(cards);
        this.cards = cards;
    }

    public static Deck of(List<Card> cards) {
        return new Deck(cards);
    }

    private void validate(List<Card> cards) {
        validateNotNull(cards);
        validateNotDuplicate(cards);
    }

    private void validateNotNull(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("null이 올 수 없습니다");
        }
    }

    private void validateNotDuplicate(List<Card> cards) {
        List<Card> distinctCards = cards.stream()
                .distinct()
                .toList();

        if (distinctCards.size() != cards.size()) {
            throw new IllegalArgumentException("Deck에 들어오는 카드는 중복이 될 수 없습니다.");
        }
    }

}
