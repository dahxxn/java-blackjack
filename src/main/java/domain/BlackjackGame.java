package domain;


import domain.card.Deck;
import domain.card.Hand;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class BlackjackGame {
    private final Dealer dealer;
    private final Players players;
    private final Deck deck;

    private BlackjackGame(Deck deck, Players players, Dealer dealer) {
        this.deck = deck;
        this.players = players;
        this.dealer = dealer;
    }

    public static BlackjackGame create(List<String> names, ShuffleStrategy strategy) {
        Deck deck = Deck.create(strategy);
        Players players = Players.create(names, deck);
        Dealer dealer = Dealer.create(dealInitialHand(deck));
        return new BlackjackGame(deck, players, dealer);
    }

    public void playDealerTurn() {
        while (dealer.shouldHit()) {
            dealer.draw(deck.draw());
        }
        if (!dealer.isFinished()) {
            dealer.stay();
        }
    }

    public void playPlayerTurn(Function<String, String> inputYesOrNoReader,
                               Consumer<PlayerHandResult> handPrinter) {
        players.play(inputYesOrNoReader, handPrinter, deck);
    }

    public GameResult calculateResult() {
        return GameResult.from(players, dealer);
    }

    public DealResult getDealResult() {
        return DealResult.from(players, dealer);
    }


    private static Hand dealInitialHand(Deck deck) {
        return Hand.of(List.of(deck.draw(), deck.draw()));
    }
}
