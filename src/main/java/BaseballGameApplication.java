import controller.BaseballGameController;
import view.InputView;
import view.OutputView;

public class BaseballGameApplication {

    public static void main(String[] args) {
        final BaseballGameController gameController = new BaseballGameController(new InputView(), new OutputView());
        gameController.execute();
    }
}
