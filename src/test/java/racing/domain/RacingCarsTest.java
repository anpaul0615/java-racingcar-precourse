package racing.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarsTest {
	private RacingCars racingCars;
	private final String[] CAR_NAMES = { "carA", "carB", "carC" };
	private final int RACING_CYCLE = 3;

	@BeforeEach
	void setUp() {
		racingCars = new RacingCars(CAR_NAMES, RACING_CYCLE);
	}

	@AfterEach
	void tearDown() {
		racingCars = null;
	}

	@Test
	@DisplayName("5자 이하 이름 하나 이상 입력가능")
	void hasNextRacingCycle() {
		assertThat(racingCars.hasNextRacingCycle()).isTrue();

		int racingCycleBeforeFinal = RACING_CYCLE - 1;
		for (int i=0; i<racingCycleBeforeFinal; i++) {
			racingCars.race();
		}
		assertThat(racingCars.hasNextRacingCycle()).isTrue();

		racingCars.race();
		assertThat(racingCars.hasNextRacingCycle()).isFalse();
	}


	@Test
	@DisplayName("경주한 모든 자동차의 최고 주행거리는 1등 자동차들의 주행거리 min/max 와 같다")
	void filterFarthestCars() {
		for (int i=0; i<RACING_CYCLE; i++) {
			racingCars.race();
		}

		int maximumDrivenDistance = 0;
		for (Car car : racingCars) {
			int drivenDistance = car.getDrivenDistance();
			maximumDrivenDistance = Math.max(drivenDistance, maximumDrivenDistance);
		}

		RacingCars filterFarthestCars = racingCars.filterFarthestCars();

		Iterator<Car> iterator = filterFarthestCars.iterator();
		Car first = iterator.next();
		int minimumDrivenDistanceFromFarthestCars = first.getDrivenDistance();
		int maximumDrivenDistanceFromFarthestCars = first.getDrivenDistance();
		while (iterator.hasNext()) {
			int drivenDistance = iterator.next().getDrivenDistance();
			minimumDrivenDistanceFromFarthestCars = Math.min(drivenDistance, minimumDrivenDistanceFromFarthestCars);
			maximumDrivenDistanceFromFarthestCars = Math.max(drivenDistance, maximumDrivenDistanceFromFarthestCars);
		}

		assertThat(maximumDrivenDistance)
			.isEqualTo(minimumDrivenDistanceFromFarthestCars)
			.isEqualTo(maximumDrivenDistanceFromFarthestCars);
	}
}
