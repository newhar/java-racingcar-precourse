package racingcar;

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
