package domain;

import domain.card.Card;
import java.util.List;

public record DealResult(String dealerOpenCard, List<PlayerHandResult> playerHands) {
    public static DealResult from(Players players, Dealer dealer) {
        String dealerCard = formatCard(dealer.cards().getFirst());
        List<PlayerHandResult> playerHands = players.calculateHandResult();
        return new DealResult(dealerCard, playerHands);
    }

    private static String formatCard(Card card) {
        return card.rankName() + card.suitName();
    }
}