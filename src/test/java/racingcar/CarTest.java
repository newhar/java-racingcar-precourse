package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    void 차_생성() {
        Car car = new Car("newhar");

        assertThat(car).isInstanceOf(Car.class);
        assertThat(car).isEqualTo(new Car("newhar", 0));
    }

    @Test
    void 예외테스트_차이동_음수_전달받을경우() {
        Car car = new Car("newhar");

        assertThatThrownBy(() -> car.race(RandomNumber.of(-1))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외테스트_차이동_범위초과_전달받을경우() {
        Car car = new Car("newhar");

        assertThatThrownBy(() -> car.race(RandomNumber.of(99))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 차이동_전진할_경우() {
        Car car = new Car("newhar");
        car.race(RandomNumber.of(9));

        assertThat(car).isEqualTo(new Car("newhar", 1));
    }

    @Test
    void 차이동_안하는_경우() {
        Car car = new Car("newhar");
        car.race(RandomNumber.of(0));

        assertThat(car).isEqualTo(new Car("newhar", 0));
    }

}
