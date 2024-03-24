package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ScoreTest {

    @DisplayName("올바르게 기록을 생성할 수 있다.")
    @ParameterizedTest(name = "{0} 스트라이크 {1} 볼")
    @CsvSource(value = {"0, 0", "0, 1", "0, 2", "0, 3", "1, 0", "1, 1", "1, 2", "2, 0", "2, 1", "3, 0"})
    void validate_SuccessTest(final int strikeCount, final int ballCount) {
        // when & then
        assertDoesNotThrow(() -> new Score(strikeCount, ballCount));
    }

    @DisplayName("스트라이크와 볼의 값이 범위 0 미만 3초과이면 예외 처리한다.")
    @ParameterizedTest(name = "{0} 스트라이크 {1} 볼")
    @CsvSource(value = {"-1, 0", "4, 0", "0, 4", "0, 10", "2, 4", "5, 0"})
    void validate_FailWhenInvalidCountRange(final int strikeCount, final int ballCount) {
        // when & then
        assertThatThrownBy(() -> new Score(strikeCount, ballCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("스트라이크와 볼은 0 이상 3 이하의 값이어야 합니다.");
    }

    @DisplayName("스트라이크와 볼 카운트의 합이 3 초과이면 예외 처리한다.")
    @ParameterizedTest(name = "{0} 스트라이크 {1} 볼")
    @CsvSource(value = {"1, 3", "2, 2", "3, 1", "2, 3"})
    void validate_FailWhenInvalidTotalCount(final int strikeCount, final int ballCount) {
        // when & then
        assertThatThrownBy(() -> new Score(strikeCount, ballCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("스트라이크와 볼의 합은 3 이하여야 합니다.");
    }

    @DisplayName("스트라이크가 3이면 true를 반환한다.")
    @Test
    void checkGameEnd_ReturnTrueWhenStrikeIsThree() {
        // given
        final Score score = new Score(3, 0);

        // when & then
        assertThat(score.checkGameEnd()).isTrue();
    }

    @DisplayName("스트라이크가 3이 아니면 false를 반환한다.")
    @ParameterizedTest(name = "{0} 스트라이크 {1} 볼")
    @CsvSource(value = {"0, 1", "0, 2", "1, 1", "1, 2", "2, 0", "2, 1"})
    void checkGameEnd_ReturnFalseWhenStrikeIsNotThree(final int strikeCount, final int ballCount) {
        // given
        final Score score = new Score(strikeCount, ballCount);

        // when & then
        assertThat(score.checkGameEnd()).isFalse();
    }
}
