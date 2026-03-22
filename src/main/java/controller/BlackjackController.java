package controller;

import domain.BlackjackGame;
import domain.RandomShuffleStrategy;
import java.util.List;
import view.InputView;
import view.OutputView;

public class BlackjackController {
    public void run() {
        List<String> names = InputView.readPlayerNames();
        BlackjackGame game = BlackjackGame.create(names, new RandomShuffleStrategy());

        OutputView.printDealResult(game.getDealResult());

        game.playPlayerTurn(
                InputView::readYesOrNo,
                OutputView::printPlayerHand
        );

        game.playDealerTurn();
        OutputView.printDealerHit();

        OutputView.printGameResult(game.calculateResult());
    }
}