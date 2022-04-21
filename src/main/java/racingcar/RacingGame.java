package racingcar;

public class RacingGame {
    private Cars cars;
    private final InputView inputView = InputView.getInstance();

    public void play() {
//        cars = new Cars();
        inputView.getCarNames();
        inputView.getTryCount();

//        cars.race(inputView.getTryCount());

//        OutPutView.PrintWinners(racingTrack.findWinners());
    }
}
