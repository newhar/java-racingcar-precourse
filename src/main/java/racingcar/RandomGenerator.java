package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomGenerator {

    public static int[] generate(int numberOfGenerated) {
//        List<Integer> randomNumbers = new ArrayList<>();

        int[] randomNumbers = new int[numberOfGenerated];

        for (int idx = 0; idx < numberOfGenerated; idx++) {
//            randomNumbers.add(Randoms.pickNumberInRange(0, 9));
            randomNumbers[idx] = Randoms.pickNumberInRange(0, 9);
        }

        return randomNumbers;
    }
}
