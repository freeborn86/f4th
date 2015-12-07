package hacker.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Console {
	public static Scanner keyboard = new Scanner(System.in);
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static SimpleHacker getWords() throws IOException {
		System.out.println("Welcome to my simple Fallout4 terminal hack hinting app\n\n"
				+ "Please input the words seen on the ingame terminal\n" + "Press Enter after each word!\n"
				+ "Press Enter twice after the last word to finish the input");
		SimpleHacker sh = new SimpleHacker();
		String curr = Console.readUpperFromKeyboard();
		while (!curr.equals("")) {
			if (!curr.equals("")) {
				sh.addWord(curr);
			}
			curr = Console.readUpperFromKeyboard();
		}
		return sh;
	}

	// reading from the keyboard and returning an Uppercase string
	public static String readUpperFromKeyboard() throws IOException {
		String s = br.readLine().toUpperCase();
		return s;
	}
}
