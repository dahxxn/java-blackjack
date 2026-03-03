package domain;

public class CardFactory {
    public static Card from(String cardString) {
        String symbol = cardString.trim().toUpperCase();
        int value = calculateValue(symbol);
        return new Card(symbol, value);
    }

    private static int calculateValue(String cardSymbol) {
        if (cardSymbol.equals("J") || cardSymbol.equals("Q") || cardSymbol.equals("K")) {
            return 10;
        }

        if (cardSymbol.equals("A")) {
            return 11;
        }

        try {
            return Integer.parseInt(cardSymbol);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException("잘못된 카드 값입니다: " + cardSymbol);
        }

    }
}