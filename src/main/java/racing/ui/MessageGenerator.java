package racing.ui;

import java.util.List;

import racing.domain.Car;
import racing.domain.RacingCars;

public final class MessageGenerator {
	public static String makeRacingStatusMessage(RacingCars racingCars) {
		StringBuilder message = new StringBuilder();
		for (Car car : racingCars) {
			message.append(car.toString()).append(Message.LINE_SEPARATOR);
		}
		return message.toString();
	}

	public static String makeFinalRacingStatusMessage(RacingCars farthestRacingCars) {
		List<String> farthestRacingCarNames = farthestRacingCars.getRacingCarNames();
		return String.format(
			Message.ANNOUNCE_RACING_RESULT_CONTENT_FORMAT.toString(),
			String.join(",", farthestRacingCarNames));
	}
}
