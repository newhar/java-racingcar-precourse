package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RacingTrack {
    Cars cars;

    public RacingTrack(Cars cars) {
        this.cars = cars;
    }

    public RacingTrack() {
        this.cars = new Cars();
    }


    public void addCar(Car car) {
        cars.addCar(car);
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
