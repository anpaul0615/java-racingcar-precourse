package racing;

import racing.ui.Message;
import racing.ui.Console;
import racing.validator.InputValidator;

public class RacingGame {
	public void init() {
		// 자동차 이름 콘솔입력
		Console.print(Message.REQUEST_CAR_NAMES_INPUT);
		String carNamesInput = Console.getUserInput();
		if (!InputValidator.isValidCarNamesInput(carNamesInput)) {
			Console.print(Message.INVALID_CAR_NAMES_INPUT);
			return;
		}

		// 경주 횟수 콘솔입력
		Console.print(Message.REQUEST_RACING_CYCLE_INPUT);
		String racingCycleInput = Console.getUserInput();
		if (!InputValidator.isValidRacingCycleInput(racingCycleInput)) {
			Console.print(Message.INVALID_RACING_CYCLE_INPUT);
			return;
		}
	}

	public static void main(String[] args) {
		RacingGame racingGame = new RacingGame();
		racingGame.init();
	}
}
