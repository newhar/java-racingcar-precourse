package racingcar;

import java.util.Objects;

public class Car {
    private static final int MOVING_CRITERION = 4;

    private final Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(0);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void race(RandomNumber randomNumber) {
        if (randomNumber.isOver(MOVING_CRITERION)) {
            move();
        }
    }

    public Position getLargerPosition(Position maxPosition) {
        if(this.position.value() < maxPosition.value() ) {
            return maxPosition;
        }
        return this.position;
    }

    public boolean isSamePosition(Position comparisonPosition) {
        return this.position.equals(comparisonPosition);
    }

    private void move() {
        position = position.next();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

}
