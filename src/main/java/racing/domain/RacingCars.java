package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RacingCars implements Iterable<Car> {
	private final List<Car> cars;
	private final int racingCycle;
	private int currentRacingCycle;

	public RacingCars(String[] carNames, int racingCycle) {
		this.cars = new ArrayList<>();

		for (String name : carNames) {
			cars.add(new Car(name));
		}

		this.racingCycle = racingCycle;
		this.currentRacingCycle = 0;
	}

	public boolean hasNextRacingCycle() {
		return currentRacingCycle < racingCycle;
	}

	public void race() {
		for (Car car : cars) {
			car.drive();
		}
		currentRacingCycle += 1;
	}

	public RacingCars filterFarthestCars() {
		int farthestDrivenDistance = Collections.max(cars).getDrivenDistance();
		cars.removeIf(car -> (car.getDrivenDistance() < farthestDrivenDistance));
		return this;
	}

	@Override
	public Iterator<Car> iterator() {
		return cars.iterator();
	}
}
