package racing.ui;

public enum Message {
	BLANK(""),
	LINE_SEPARATOR(System.lineSeparator()),
	REQUEST_CAR_NAMES_INPUT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
	REQUEST_RACING_CYCLE_INPUT("시도할 회수는 몇회인가요?"),
	INVALID_CAR_NAMES_INPUT("유효하지 않은 자동차 이름 입력입니다. (5자이하 이름 하나 이상 입력)"),
	INVALID_RACING_CYCLE_INPUT("유효하지 않은 경주 횟수 입력입니다. (0 이상 정수만 입력)"),
	ANNOUNCE_RACING_RESULT_HEADER("실행 결과"),
	ANNOUNCE_RACING_RESULT_CONTENT_FORMAT("%s 가 최종 우승했습니다.");

	private final String message;

	Message(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}
}
