package racing;

import racing.domain.RacingCars;
import racing.ui.Message;
import racing.ui.Console;
import racing.ui.MessageGenerator;
import racing.validator.InputValidator;

public class RacingGame {
	private final RacingGameConfig config;
	private RacingGameState state;

	public RacingGame() {
		config = new RacingGameConfig();
	}

	public boolean isReady() {
		return state == RacingGameState.READY;
	}

	public void init() {
		// 자동차 이름 콘솔입력
		Console.print(Message.REQUEST_CAR_NAMES_INPUT);
		String carNamesInput = Console.getUserInput();
		if (!InputValidator.isValidCarNamesInput(carNamesInput)) {
			Console.print(Message.INVALID_CAR_NAMES_INPUT);
			state = RacingGameState.ERROR;
			return;
		}
		config.initCarNames(carNamesInput);

		// 경주 횟수 콘솔입력
		Console.print(Message.REQUEST_RACING_CYCLE_INPUT);
		String racingCycleInput = Console.getUserInput();
		if (!InputValidator.isValidRacingCycleInput(racingCycleInput)) {
			Console.print(Message.INVALID_RACING_CYCLE_INPUT);
			state = RacingGameState.ERROR;
			return;
		}
		config.initRacingCycle(racingCycleInput);

		state = RacingGameState.READY;
	}

	public void play() {
		// 레이싱 자동차 준비
		RacingCars racingCars = new RacingCars(config);
		racingCars.init();

		// 레이싱
		Console.print(Message.BLANK);
		Console.print(Message.ANNOUNCE_RACING_RESULT_HEADER);
		while (racingCars.hasNextRacingCycle()) {
			racingCars.race();
			Console.print(MessageGenerator.makeRacingStatusMessage(racingCars));
		}

		// 최종 경주결과 출력
		RacingCars farthestRacingCars = racingCars.filterFarthestCars();
		Console.print(MessageGenerator.makeFinalRacingStatusMessage(farthestRacingCars));
	}

	public static void main(String[] args) {
		RacingGame racingGame = new RacingGame();
		racingGame.init();
		if (racingGame.isReady()) {
			racingGame.play();
		}
	}
}
