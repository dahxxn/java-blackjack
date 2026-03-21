package domain;

import domain.card.Card;
import domain.card.Deck;
import domain.card.Hand;
import java.util.ArrayList;
import java.util.List;

public class Players {
    private static final int INITIAL_CARD_COUNT = 2;
    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = new ArrayList<>(players);
    }

    public static Players create(List<String> names, Deck deck) {
        List<Player> players = names.stream()
                .map(name -> Player.create(Name.of(name), dealInitialHand(deck)))
                .toList();
        return new Players(players);
    }

    private static Hand dealInitialHand(Deck deck) {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < INITIAL_CARD_COUNT; i++) {
            cards.add(deck.draw());
        }
        return Hand.of(cards);
    }

}
