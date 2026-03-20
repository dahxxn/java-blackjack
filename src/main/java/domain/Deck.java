package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Deck {
    private final List<Card> cards;

    private Deck(List<Card> cards) {
        validate(cards);
        this.cards = new ArrayList<>(cards);
    }

    public static Deck create(ShuffleStrategy shuffleStrategy) {
        List<Card> cards = Arrays.stream(Suits.values())
                .flatMap(suits -> Arrays.stream(Rank.values())
                        .map(rank -> Card.of(suits, rank)))
                .collect(Collectors.toList());

        shuffleStrategy.shuffle(cards);
        return new Deck(cards);
    }

    public Card draw() {
        return cards.removeFirst();
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
