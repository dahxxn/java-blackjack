package domain;

import java.util.Arrays;
import java.util.List;

public class Cards {
    private final List<Card> cards;

    public Cards(List<Card> cards) {
        this.cards = cards;
    }

    public int calculateSum() {
        return cards.stream()
                .mapToInt(Card::getValue)
                .sum();
    }

    public static Cards from(String input) {
        List<Card> cardList = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(CardFactory::from)
                .toList();
        return new Cards(cardList);
    }
}