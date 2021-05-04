package racing.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class InputValidator {
	public static boolean isValidCarNamesInput(String carNamesInput) {
		if (carNamesInput.isEmpty()) {
			return false;
		}
		Pattern pattern = Pattern.compile("\\w{6,}");
		Matcher matcher = pattern.matcher(carNamesInput);
		return !matcher.find();
	}

	public static boolean isValidRacingCycleInput(String racingCycleInput) {
		try {
			return Integer.parseInt(racingCycleInput) > 0;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
