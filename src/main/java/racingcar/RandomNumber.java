package racingcar;

import java.util.HashMap;
import java.util.Map;

public class RandomNumber {
    private static final int MINIMUM_RANGE_OF_RANDOM_NUMBER = 0;
    private static final int MAXIMUM_RANGE_OF_RANDOM_NUMBER = 9;
    private static Map<Integer, RandomNumber> cachedNumber = new HashMap<>();

    static {
        for (int i = MINIMUM_RANGE_OF_RANDOM_NUMBER; i <= MAXIMUM_RANGE_OF_RANDOM_NUMBER; i++) {
            cachedNumber.put(i, new RandomNumber(i));
        }
    }

    private int number;

    private RandomNumber(int number) {
        this.number = number;
    }

    public static RandomNumber of(int number) {
        if (number < MINIMUM_RANGE_OF_RANDOM_NUMBER || number > MAXIMUM_RANGE_OF_RANDOM_NUMBER) {
            throw new IllegalArgumentException();
        }

        return cachedNumber.get(number);
    }

    public boolean isOver(int criterion) {
        return this.number > criterion;
    }
}
