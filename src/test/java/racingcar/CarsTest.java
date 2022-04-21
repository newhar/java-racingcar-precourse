package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {
    @Test
    void Cars_생성() {
        assertThat(new Cars()).isInstanceOf(Cars.class);
    }

    @Test
    void Cars_차_추가() {
        Cars cars = new Cars();
        cars.addCar(new Car("a"));
        cars.addCar(new Car("b"));

        Cars carsForCompare = new Cars();
        carsForCompare.addCar(new Car("a"));
        carsForCompare.addCar(new Car("b"));
        assertThat(cars).isEqualTo(carsForCompare);
    }

}