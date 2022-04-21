package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final InputView inputView = new InputView();
    private static final String SPLIT_DELIMITER = ",";

    public static InputView getInstance() {
        return inputView;
    }

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        try {
            validateCarNames(input);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다. 공백을 입력하면 안됩니다.");
            getCarNames();
        }

        return Arrays.asList(input.split(SPLIT_DELIMITER));
    }

    private void validateCarNames(String input) {
        if(input == null || input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public int getTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        try {
            return parseIntFromInput(input);
        } catch (IllegalArgumentException e) {
            System.out.println("양의 숫자만 입력할 수 있습니다.");
            return getTryCount();
        }
    }

    private int parseIntFromInput(String input) {
        int parsed = getParsed(input);
        if (parsed < 0) {
            throw new IllegalArgumentException();
        }

        return parsed;
    }

    private int getParsed(String input) {
        int parsed;
        try {
            parsed = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return parsed;
    }

}
