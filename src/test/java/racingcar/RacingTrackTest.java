package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingTrackTest {

    @Test
    void RacingTrack_생성() {
        RacingTrack racingTrack = new RacingTrack();

        assertThat(racingTrack).isInstanceOf(RacingTrack.class);
    }

    @Test
    void 참가자동차_추가() {
        RacingTrack racingTrack = new RacingTrack();
        racingTrack.addCar(new Car("a"));
        racingTrack.addCar(new Car("b"));

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("a", 0));
        cars.add(new Car("b"));

        assertThat(racingTrack).isEqualTo(new RacingTrack(cars));
    }

    @Test
    @DisplayName("한라운드_시작")
    void race() {
        RacingTrack racingTrack = new RacingTrack();
        racingTrack.addCar(new Car("a"));
        racingTrack.addCar(new Car("b"));
        racingTrack.race(new int[] {1,9});

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("a", 0));
        cars.add(new Car("b", 1));
        assertThat(racingTrack).isEqualTo(new RacingTrack(cars));
    }

    @Test
    @DisplayName("우승자_찾기")
    void findWinners() {
        RacingTrack racingTrack = new RacingTrack();
        racingTrack.addCar(new Car("a"));
        racingTrack.addCar(new Car("b"));
        racingTrack.addCar(new Car("c"));
        racingTrack.race(new int[] {1,9,5});
        racingTrack.race(new int[] {0,9,6});
        racingTrack.race(new int[] {3,8,7});

        assertThat(racingTrack.findWinners()).isEqualTo(Arrays.asList(new Car("b",3), new Car("c", 3)));
    }
}