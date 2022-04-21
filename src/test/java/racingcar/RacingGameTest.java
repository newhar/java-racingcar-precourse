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

    @Test
    @DisplayName("사용자로부터 입력받도록한다.")
    void 사용자_입력() {
        RacingGame racingGame = new RacingGame();
        InputView inputView = InputView.getInstance();

        inputView.getCarNames();
        inputView.getTryCount();

    }

}