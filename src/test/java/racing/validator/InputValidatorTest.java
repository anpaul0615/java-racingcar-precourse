package racing.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
	@Test
	@DisplayName("5자 이하 이름 하나 이상 입력가능")
	void isValidCarNamesInput() {
		assertThat(InputValidator.isValidCarNamesInput("car1")).isTrue();
		assertThat(InputValidator.isValidCarNamesInput("car1,car2,car3")).isTrue();

		assertThat(InputValidator.isValidCarNamesInput("")).isFalse();
		assertThat(InputValidator.isValidCarNamesInput("car111")).isFalse();
		assertThat(InputValidator.isValidCarNamesInput("car1,car222,car3")).isFalse();
	}

	@Test
	@DisplayName("0 이상 정수만 입력가능")
	void isValidRacingCycleInput() {
		assertThat(InputValidator.isValidRacingCycleInput("1")).isTrue();
		assertThat(InputValidator.isValidRacingCycleInput("123")).isTrue();

		assertThat(InputValidator.isValidRacingCycleInput("0")).isFalse();
		assertThat(InputValidator.isValidRacingCycleInput("0.1")).isFalse();
		assertThat(InputValidator.isValidRacingCycleInput("-1")).isFalse();
	}
}
