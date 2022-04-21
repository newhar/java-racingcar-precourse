package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RacingTrack {
    List<Car> cars = new ArrayList<>();

    public RacingTrack() {
    }

    public RacingTrack(List<Car> cars) {
        this.cars = cars;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void race(int[] randomNumbers) {
        for (Car car : cars) {
            car.race(RandomNumber.of(randomNumbers[cars.indexOf(car)]));
        }
    }

    public List<Car> findWinners() {
        Position maxPosition = findMaxPosition();

        return findWinners(maxPosition);
    }

    public int[] generateRandomNumbers(int numberOfRandomNumbers) {
        int[] randomNumbers = new int[cars.size()];

        for (int idx = 0; idx < cars.size(); idx++) {
            randomNumbers[idx] = Randoms.pickNumberInRange(0, 9);
        }

        return randomNumbers;
    }

    private Position findMaxPosition() {
        Position maxPosition = new Position(0);

        for (Car car : cars) {
            maxPosition = car.getLargerPosition(maxPosition);
        }

        return maxPosition;
    }

    private List<Car> findWinners(Position maxPosition) {
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.isMaxPosition(maxPosition)) {
                winners.add(car);
            }
        }

        return winners;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingTrack that = (RacingTrack) o;
        return cars.equals(that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
