package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final InputView inputView = new InputView();

    public static InputView getInstance() {
        return inputView;
    }

    public String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public int getTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");

        try {
            return parseIntFromInput(Console.readLine());
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
