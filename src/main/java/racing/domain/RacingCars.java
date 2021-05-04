package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import racing.RacingGameConfig;

public class RacingCars implements Iterable<Car> {
	private final RacingGameConfig config;
	private final List<Car> cars;

	private int racingCycle = 0;

	public RacingCars(RacingGameConfig config) {
		this.config = config;
		this.cars = new ArrayList<>();
	}

	public void init() {
		for (String name : config.getCarNames()) {
			cars.add(new Car(name));
		}
	}

	public boolean hasNextRacingCycle() {
		return racingCycle < config.getRacingCycle();
	}

	public void race() {
		for (Car car : cars) {
			car.drive();
		}
		racingCycle += 1;
	}

	public RacingCars filterFarthestCars() {
		int farthestDrivenDistance = Collections.max(cars).getDrivenDistance();
		cars.removeIf(car -> car.getDrivenDistance() < farthestDrivenDistance);
		return this;
	}

	public List<String> getRacingCarNames() {
		List<String> carNames = new ArrayList<>();
		for (Car car : cars) {
			carNames.add(car.getName());
		}
		return carNames;
	}

	@Override
	public Iterator<Car> iterator() {
		return cars.iterator();
	}
}
