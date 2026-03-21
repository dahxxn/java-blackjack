package domain;

import java.util.List;

public record GameResult(List<PlayerResult> playerResults) {
    public static GameResult from(Players players, Dealer dealer) {
        return new GameResult(players.calculateResult(dealer));
    }

}
