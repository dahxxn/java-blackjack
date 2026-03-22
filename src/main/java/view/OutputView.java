package view;

import domain.DealResult;
import domain.GameResult;
import domain.PlayerHandResult;
import domain.PlayerResult;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private OutputView() {
    }

    public static void printDealResult(DealResult dealResult) {
        System.out.println("\n딜러와 " + getPlayerNames(dealResult.playerHands()) + "에게 2장을 나누었습니다.");
        System.out.println("딜러: " + dealResult.dealerOpenCard());
        for (PlayerHandResult playerHand : dealResult.playerHands()) {
            System.out.println(playerHand.name() + "카드: " + String.join(", ", playerHand.cards()));
        }
    }

    public static void printPlayerHand(PlayerHandResult playerHand) {
        System.out.println(playerHand.name() + "카드: " + String.join(", ", playerHand.cards()));
    }

    public static void printDealerHit() {
        System.out.println("\n딜러는 16이하라 한장의 카드를 더 받았습니다.");
    }

    public static void printGameResult(GameResult gameResult) {
        System.out.println("\n## 최종 승패");
        for (PlayerResult result : gameResult.playerResults()) {
            System.out.println(result.name() + ": " + result.earningRate());
        }
    }

    private static String getPlayerNames(List<PlayerHandResult> playerHands) {
        return playerHands.stream()
                .map(PlayerHandResult::name)
                .collect(Collectors.joining(", "));
    }
}