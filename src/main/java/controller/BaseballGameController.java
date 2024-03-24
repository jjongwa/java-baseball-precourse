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

    public void execute() {
        while (true) {
            if (isGameEnd()) return;
        }
    }

    private boolean isGameEnd() {
        startNewGame();
        boolean restartTrigger;
        while (true) {
            try {
                restartTrigger = inputView.readRestart();
                break;
            } catch (final IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return gameEndCommand(restartTrigger);
    }

    private boolean gameEndCommand(final boolean restartTrigger) {
        return !restartTrigger;
    }

    private void startNewGame() {
        final Game game = Game.start();
        while (true) {
            try {
                final Score score = game.play(new PitchBalls(inputView.readBallNumbers()));
                outputView.printScoreMessage(score.getStrikeCount(), score.getBallCount());
                if (gameClearCommand(score)) break;
            } catch (final IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private boolean gameClearCommand(final Score score) {
        if (score.checkGameEnd()) {
            outputView.printGameClearMessage();
            return true;
        }
        return false;
    }
}
