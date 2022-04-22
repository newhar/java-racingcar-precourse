package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
class RacingGameTest {
    @Test
    void RacingGame_생성() {
        RacingGame racingGame = new RacingGame();

        assertThat(racingGame).isInstanceOf(RacingGame.class);
    }

}