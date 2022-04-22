package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {
    List<Car> cars = new ArrayList<>();

    public Cars() {
    }

    public Cars(List<String> carNames) {
        for(String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void race(int tryCount) {
        while(tryCount > 0) {
            tryCount -= 1;
            raceOneRound(generateRandomNumbers());
        }
    }

    public CarsDto toDto() {
        List<CarDto> carsDto = new ArrayList<>();
        for( Car car : this.cars) {
            carsDto.add(car.toDto());
        }
        return new CarsDto(carsDto);
    }


     public void raceOneRound(int[] randomNumbers) {
        for (Car car : cars) {
            car.race(RandomNumber.of(randomNumbers[cars.indexOf(car)]));
        }
    }

    public List<Car> findWinners() {
        Position maxPosition = findMaxPosition();

        return findWinners(maxPosition);
    }

    private int[] generateRandomNumbers() {
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
            addWhenThisCarIsWinner(car, maxPosition, winners);
        }

        return winners;
    }

    private void addWhenThisCarIsWinner(Car car, Position maxPosition, List<Car> winners) {
        if (car.isSamePosition(maxPosition)) {
            winners.add(car);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    public int size() {
        return cars.size();
    }

}
