package racing.domain;

import java.util.Random;

public class Car implements Comparable<Car> {
	private final String name;
	private int drivenDistance;

	public Car(String name) {
		this.name = name;
		this.drivenDistance = 0;
	}

	public String getName() {
		return name;
	}

	public int getDrivenDistance() {
		return drivenDistance;
	}

	public int drive() {
		Random random = new Random();
		int drivingDistance = random.nextInt(10) > 3 ? 1 : 0;
		drivenDistance += drivingDistance;
		return drivingDistance;
	}

	@Override
	public int compareTo(Car target) {
		return Integer.compare(this.getDrivenDistance(), target.getDrivenDistance());
	}
}
