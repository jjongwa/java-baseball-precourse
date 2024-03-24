import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PitchBalls {

    private final List<Integer> numbers;

    public PitchBalls(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Score compare(final PitchBalls otherPitchBalls) {
        int strikeCount = 0;
        int ballCount = 0;
        for (int order = 0; order < 3; order++) {
            if (numbers.get(order).equals(otherPitchBalls.numbers.get(order))) {
                strikeCount++;
                continue;
            }
            if (otherPitchBalls.numbers.contains(numbers.get(order))) {
                ballCount++;
            }
        }
        return new Score(strikeCount, ballCount);
    }

    private void validate(final List<Integer> numbers) {
        checkSize(numbers);
        checkNumberRange(numbers);
        checkDuplicate(numbers);
    }

    private void checkSize(final List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("투구는 3개의 숫자를 보유해야 합니다.");
        }
    }

    private void checkNumberRange(final List<Integer> numbers) {
        for (final Integer number : numbers) {
            if (number < 1 || number > 9) {
                throw new IllegalArgumentException("투구가 가질 수 있는 숫자의 범위는 1 이상 9 이하입니다.");
            }
        }
    }

    private void checkDuplicate(final List<Integer> numbers) {
        final Set<Integer> deduplicatedNumbers = new HashSet<>(numbers);
        if (numbers.size() != deduplicatedNumbers.size()) {
            throw new IllegalArgumentException("투구는 중복된 숫자를 가질 수 없습니다.");
        }
    }
}
