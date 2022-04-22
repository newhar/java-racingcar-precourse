package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final int ZERO = 0;

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private Cars cars;

    public void play() {
        receiveEntryForCars();
        raceStart(inputView.getTryCount());
    }

    private void receiveEntryForCars() {
        try {
            cars = new Cars(inputView.getCarNames());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + e.getMessage());
            cars = new Cars(inputView.getCarNames());
        }
    }

    private List<CarDto> findWinners() {
        List<CarDto> winners = new ArrayList<>();

        for (Car winner : cars.findWinners()) {
            winners.add(winner.toDto());
        }

        return winners;
    }

    private void raceStart(int tryCount) {
        outputView.printStartMessage();

        while (tryCount-- > ZERO) {
            cars.raceOneRound(RandomGenerator.generate(cars.size()));
            outputView.printRoundResult(cars.toDto());
        }

        outputView.printWinners(findWinners());
    }
    

}
