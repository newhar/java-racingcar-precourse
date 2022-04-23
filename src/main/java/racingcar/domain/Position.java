package racingcar.domain;

import java.util.Objects;

public class Position {
    private static final int NEXT_POSITION_VALUE = 1;
    private static final int ZERO = 0;

    private final int position;

    public Position(int position) {
        if (position < ZERO) {
            throw new IllegalArgumentException();
        }

        this.position = position;
    }

    public int value() {
        return this.position;
    }

    public Position next() {
        return new Position(position + NEXT_POSITION_VALUE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

}
