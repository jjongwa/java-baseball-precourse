package controller;

import model.Game;
import model.PitchBalls;
import model.Score;
import view.InputView;
import view.OutputView;

public class BaseballGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public BaseballGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void excute() {
        final Game game = Game.start();
        while (true) {
            try {
                final Score score = game.play(new PitchBalls(inputView.readBallNumbers()));
                outputView.printScoreMessage(score.getStrikeCount(), score.getBallCount());
                if (score.checkGameEnd()) {
                    outputView.printGameClearMessage();
                    break;
                }
            } catch (final IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
