package racingcar;

import java.util.Objects;

public class Name {
    private static final int MAXIMUM_RANGE_OF_NAME = 5;
    private final String name;

    public Name(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("이름을 입력해야합니다.");
        }

        if (name.length() > MAXIMUM_RANGE_OF_NAME) {
            throw new IllegalArgumentException("5자 이상을 입력할 수 없습니다.");
        }

        this.name = name;
    }

    public String value() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
