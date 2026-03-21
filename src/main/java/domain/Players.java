package domain;

import domain.card.Card;
import domain.card.Deck;
import domain.card.Hand;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Players {
    private static final int INITIAL_CARD_COUNT = 2;
    private static final String HIT = "y";
    private static final String STAY = "n";
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

    public void play(Function<String, String> inputYesOrNoReader, Deck deck) {
        for (Player player : players) {
            playerTurn(player, inputYesOrNoReader, deck);
        }
    }

    private void playerTurn(Player player, Function<String, String> inputYesOrNoReader, Deck deck) {
        while (!player.isFinished()) {
            String input = inputYesOrNoReader.apply(player.name());
            if (input.equals(HIT)) {
                player.draw(deck.draw());
                continue;
            } else if (input.equals(STAY)) {
                player.stay();
                continue;
            }

            throw new IllegalArgumentException("y또는 n만 입력 가능합니다.");

        }
    }

    public List<PlayerResult> calculateResult(Dealer dealer) {
        return players.stream()
                .map(player -> new PlayerResult(player.name(), player.earningRate(dealer)))
                .toList();
    }
}
