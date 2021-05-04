package racing;

import racing.ui.Message;
import racing.ui.Console;
import racing.validator.InputValidator;

public class RacingGame {
	private final RacingGameConfig config;

	public RacingGame() {
		config = new RacingGameConfig();
	}

	public void init() {
		// 자동차 이름 콘솔입력
		Console.print(Message.REQUEST_CAR_NAMES_INPUT);
		String carNamesInput = Console.getUserInput();
		if (!InputValidator.isValidCarNamesInput(carNamesInput)) {
			Console.print(Message.INVALID_CAR_NAMES_INPUT);
			return;
		}
		config.initCarNames(carNamesInput);

		// 경주 횟수 콘솔입력
		Console.print(Message.REQUEST_RACING_CYCLE_INPUT);
		String racingCycleInput = Console.getUserInput();
		if (!InputValidator.isValidRacingCycleInput(racingCycleInput)) {
			Console.print(Message.INVALID_RACING_CYCLE_INPUT);
			return;
		}
		config.initRacingCycle(racingCycleInput);
	}

	public static void main(String[] args) {
		RacingGame racingGame = new RacingGame();
		racingGame.init();
	}
}
