package domain.card;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private static final int BUST_THRESHOLD = 21;
    private static final int ACE_DIFFERENCE = 10;
    private List<Card> cards;

    private Hand(List<Card> initialCards) {
        validate(initialCards);
        this.cards = new ArrayList<>(initialCards);
    }

    public static Hand of(List<Card> cards) {
        return new Hand(cards);
    }

    public int calculateScore() {
        int totalScore = cards.stream()
                .mapToInt(Card::rankScore)
                .sum();

        return adjustForAces(totalScore);
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

    private int adjustForAces(int totalScore) {
        int aceCount = countAces();
        while (aceCount > 0 && totalScore > BUST_THRESHOLD) {
            totalScore -= ACE_DIFFERENCE;
            aceCount--;
        }

        return totalScore;
    }

    private int countAces() {
        return (int) cards.stream()
                .filter(Card::isAce)
                .count();
    }

}
