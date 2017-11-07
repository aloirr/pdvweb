package util;

import java.util.Scanner;

public final class Scan {

	public static Scanner scan() {
		Scanner scanner = new Scanner(System.in);
		return scanner;
	}

	public static String nextLine() {
		return scan().nextLine();
	}
}
