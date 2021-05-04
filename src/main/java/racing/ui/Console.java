package racing.ui;

import java.util.Scanner;

public final class Console {
	private static final Scanner scanner = new Scanner(System.in);

	public static String getUserInput() {
		return scanner.nextLine();
	}

	public static void print(Message message) {
		System.out.println(message.toString());
	}

	public static void print(String message) {
		System.out.println(message);
	}
}
