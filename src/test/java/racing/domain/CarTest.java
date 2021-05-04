package racing.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
	private Car car;
	private final String CAR_NAME = "carA";

	@BeforeEach
	void setUp() {
		car = new Car(CAR_NAME);
	}

	@AfterEach
	void tearDown() {
		car = null;
	}

	@Test
	@DisplayName("초기 주행거리는 0 이다")
	void getDrivenDistance() {
		assertThat(car.getDrivenDistance()).isEqualTo(0);
	}

	@Test
	@DisplayName("주행한만큼 주행거리가 늘어난다")
	void drive() {
		int prevDrivenDistance = car.getDrivenDistance();
		assertThat(prevDrivenDistance).isEqualTo(0);

		int drivingDistance = car.drive();
		int nextDrivenDistance = prevDrivenDistance + drivingDistance;
		assertThat(nextDrivenDistance).isEqualTo(car.getDrivenDistance());
	}
}
