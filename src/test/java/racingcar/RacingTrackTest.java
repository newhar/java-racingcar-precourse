package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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

        Cars cars = new Cars();
        cars.addCar(new Car("a"));
        cars.addCar(new Car("b"));

        assertThat(racingTrack).isEqualTo(new RacingTrack(cars));
    }

}