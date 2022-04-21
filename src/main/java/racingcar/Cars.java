package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {
    List<Car> cars = new ArrayList<>();

    public Cars() {
    }

    public void addCar(Car newCar) {
        cars.add(newCar);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return cars.equals(cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
