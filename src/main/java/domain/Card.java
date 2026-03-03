package domain;

public class Card {
    private final String symbol;
    private final int value;

    public Card(String symbol, int value) {
        this.symbol = symbol;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getSymbol() {
        return symbol;
    }
}