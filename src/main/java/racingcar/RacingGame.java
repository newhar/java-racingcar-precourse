package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private Cars cars;

    public void play() {
        cars = new Cars(inputView.getCarNames());
        int tryCount = inputView.getTryCount();

        outputView.printStartMessage();
        while(tryCount > 0) {
            cars.raceOneRound(RandomGenerator.generate(cars.size()));
            tryCount -= 1;
            outputView.printRoundResult(cars.toDto());
        }

        List<CarDto> winners = new ArrayList<>();
        for (Car winner : cars.findWinners()) {
            winners.add(winner.toDto());
        }
        outputView.printWinners(winners);
    }

}
