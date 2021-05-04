package racing;

public class RacingGameConfig {
	private String[] carNames;
	private int racingCycle;

	public void initCarNames(String carNamesInput) {
		this.carNames = carNamesInput.trim().split(",");
	}

	public void initRacingCycle(String racingCycleInput) {
		this.racingCycle = Integer.parseInt(racingCycleInput.trim());
	}

	public String[] getCarNames() {
		return carNames;
	}

	public int getRacingCycle() {
		return racingCycle;
	}
}
