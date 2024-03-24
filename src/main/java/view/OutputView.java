package view;

public class OutputView {

    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 끝";
    private static final String NOTHING = "낫싱";

    public void printScoreMessage(final int strikeCount, final int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println(NOTHING);
            return;
        }
        printStrikeAndBall(strikeCount, ballCount);
    }

    private void printStrikeAndBall(final int strikeCount, final int ballCount) {
        if (strikeCount != 0) {
            System.out.print(strikeCount + STRIKE + " ");
        }
        if (ballCount != 0) {
            System.out.print(ballCount + BALL);
        }
        System.out.println();
    }

    public void printGameClearMessage() {
        System.out.println(END_MESSAGE);
    }
}
