package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    private final PitchBalls answer;

    private Game(final PitchBalls answer) {
        this.answer = answer;
    }

    public static Game start() {
        return new Game(generateRandomPitchBalls());
    }

    public Score play(final PitchBalls pitchBalls) {
        return answer.compare(pitchBalls);
    }

    private static PitchBalls generateRandomPitchBalls() {
        final List<Integer> numbers = new ArrayList<>();
        for (int num = 1; num <= 9; num++) {
            numbers.add(num);
        }
        Collections.shuffle(numbers);
        return new PitchBalls(numbers.subList(0, 3));
    }
}
