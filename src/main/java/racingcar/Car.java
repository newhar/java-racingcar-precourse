package racingcar;

import java.util.Objects;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        name = name;
        position = 0;
    }

    public Car(String name, int position) {
        name = name;
        this.position = position;
    }

    public Car race(int randomNumber) {
        if (isMovable(randomNumber)) {
            return move();
        }
        return this;
    }

    public boolean isMovable(int randomNumber) {
        return randomNumber >= 4;
    }

    private Car move() {
        return new Car(name, position + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
