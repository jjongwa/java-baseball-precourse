package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_BALL_NUMBER_MESSAGE = "숫자를 입력해주세요. : ";
    private static final String INPUT_NUMBER_REGEX = "[1-9]{3}";
    private static final String ERROR_INVALID_INPUT_NUMBER = "[ERROR] 입력값은 1에서 9 사이의 숫자로 이루어진 3자리 숫자입니다.";
    private static final String ERROR_INVALID_RESTART_INPUT = "[ERROR] 1 또는 2를 입력해주세요.";

    public List<Integer> readBallNumbers() {
        printMessage(INPUT_BALL_NUMBER_MESSAGE);
        final String input = SCANNER.nextLine();
        if (!input.matches(INPUT_NUMBER_REGEX)) {
            throw new IllegalArgumentException(ERROR_INVALID_INPUT_NUMBER);
        }
        final List<Integer> numbers = new ArrayList<>();
        for (char numberChar : input.toCharArray()) {
            numbers.add(Character.getNumericValue(numberChar));
        }
        return numbers;
    }

    public boolean readRestart() {
        final Integer input = SCANNER.nextInt();
        if (input == 1) {
            return true;
        }
        if (input == 2) {
            return false;
        }
        throw new IllegalArgumentException(ERROR_INVALID_RESTART_INPUT);
    }

    private void printMessage(final String message) {
        System.out.print(message);
    }
}
