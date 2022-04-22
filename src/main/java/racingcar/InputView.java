package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String SPLIT_DELIMITER = ",";
    private static final String GET_CARS_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String GET_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    public List<String> getCarNames() {
        System.out.println(GET_CARS_NAME_MESSAGE);
        String input = Console.readLine();

        try {
            validateCarNames(input);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + e.getMessage());
            getCarNames();
        }

        return Arrays.asList(input.split(SPLIT_DELIMITER));
    }

    private void validateCarNames(String input) {
//        System.out.println(input,SPLIT_DELIMITER, input == SPLIT_DELIMITER);
        if (input == null || input.isEmpty() || input.equals(SPLIT_DELIMITER)) {
            throw new IllegalArgumentException("최소한 하나 이상의 이름을 입력해야합니다.");
        }
    }

    public int getTryCount() {
        System.out.println(GET_TRY_COUNT_MESSAGE);
        String input = Console.readLine();
        try {
            return parseIntFromInput(input);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + e.getMessage());
            return getTryCount();
        }
    }

    private int parseIntFromInput(String input) {
        int parsed = getParsed(input);
        if (parsed < 0) {
            throw new IllegalArgumentException("양수만 입력할 수 있습니다.");
        }

        return parsed;
    }

    private int getParsed(String input) {
        int parsed;
        try {
            parsed = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
        return parsed;
    }

}
