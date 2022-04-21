package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void 차_생성() {
        Car car = new Car("jin");

        assertThat(car).isInstanceOf(Car.class);
        assertThat(car).isEqualTo(new Car("jin", 0));
    }

    @Test
    void 한라운드_레이스_진행_전진할_경우() {
        Car car = new Car("newhar");
        assertThat(car.race(9)).isEqualTo(new Car("newhar", 1));
    }

    @Test
    void 한라운드_레이스_진행_멈추는_경우() {
        Car car = new Car("newhar");
        assertThat(car.race(0)).isEqualTo(new Car("newhar", 0));
    }

}
