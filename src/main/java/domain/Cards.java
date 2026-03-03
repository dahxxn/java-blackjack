package domain;

import java.util.Arrays;
import java.util.List;

public class Cards {
    private final List<Card> cards;

    public Cards(List<Card> cards) {
        this.cards = cards;
    }

    public int calculateSum() {
        int sum = cards.stream()
                .mapToInt(Card::getValue)
                .sum();

        return adjustAceIfBust(sum);
    }

    public static Cards from(String input) {
        List<Card> cardList = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(CardFactory::from)
                .toList();
        return new Cards(cardList);
    }


    private int adjustAceIfBust(int sum) {
        long aceCount = cards.stream()
                .map(Card::getSymbol)
                .filter(symbol -> symbol.equals("A"))
                .count();

        while (sum > 21 && aceCount > 0) {
            sum -= 10;
            aceCount--;
        }

        return sum;
    }
}