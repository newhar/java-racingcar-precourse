package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.controller.RacingGameController;

import static org.assertj.core.api.Assertions.assertThat;
class RacingGameControllerTest {
    @Test
    void RacingGame_생성() {
        RacingGameController racingGameController = new RacingGameController();

        assertThat(racingGameController).isInstanceOf(RacingGameController.class);
    }

}