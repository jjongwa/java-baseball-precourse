import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class PitchBallsTest {

    @DisplayName("올바르게 투구를 생성할 수 있다.")
    @ParameterizedTest(name = "숫자 조합: {0}, {1}, {2}")
    @CsvSource(value = {"1, 2, 3", "3, 1, 2", "2, 3, 1", "9, 8, 7", "5, 6, 4", "8, 3, 7", "5, 2, 9", "8, 9, 4"})
    void validate_SuccessMakePitchBall(final int firstNum, final int secondNum, final int thirdNum) {
        // given
        final List<Integer> numbers = List.of(firstNum, secondNum, thirdNum);

        // when & then
        assertDoesNotThrow(() -> new PitchBalls(numbers));
    }

    @DisplayName("숫자의 개수가 3이 아니면 예외 처리한다.")
    @ParameterizedTest(name = "숫자의 개수가 {0}개인 경우")
    @CsvSource(value = {"0", "1", "2", "4", "5", "6", "10", "100", "1000"})
    void validate_FailWhenIncorrectNumberSize(final int numberSize) {
        // given
        final List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < numberSize; i++) {
            numbers.add(new Random().nextInt());
        }

        // when & then
        assertThatThrownBy(() -> new PitchBalls(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("투구는 3개의 숫자를 보유해야 합니다.");
    }

    @DisplayName("투구가 보유한 숫자가 1 미만 또는 9 초과이면 예외 처리한다.")
    @ParameterizedTest(name = "숫자 조합: {0}, {1}, {2}")
    @CsvSource(value = {"0, 1, 2", "2, 0, 1", "4, 2, 10", "-1, 3, 9", "4, 7 , 11", "100, 200, 300"})
    void validate_FailWhenIncorrectRange(final int firstNum, final int secondNum, final int thirdNum) {
        // given
        final List<Integer> numbers = List.of(firstNum, secondNum, thirdNum);

        // when & then
        assertThatThrownBy(() -> new PitchBalls(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("투구가 가질 수 있는 숫자의 범위는 1 이상 9 이하입니다.");
    }

    @DisplayName("투구에 중복된 숫자가 존재하면 예외 처리한다.")
    @ParameterizedTest(name = "숫자 조합: {0}, {1}, {2}")
    @CsvSource(value = {"1, 1, 2", "1, 2, 1", "9, 8, 8", "7, 7, 7", "4, 5, 5", "3, 2, 3", "6, 7, 7"})
    void validate_FailWhenDuplicateNumber(final int firstNum, final int secondNum, final int thirdNum) {
        // given
        final List<Integer> numbers = List.of(firstNum, secondNum, thirdNum);

        // when & then
        assertThatThrownBy(() -> new PitchBalls(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("투구는 중복된 숫자를 가질 수 없습니다.");
    }
}
