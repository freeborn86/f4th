package hacker.simple;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		while (true) {
			SimpleHacker sh = Console.getWords();
			sh.hack();
			String exit = "";
			System.out.println("Type exit + ENTER to exit");
			exit = Console.readUpperFromKeyboard();
			if (exit.equals("EXIT")) {
				break;
			}
		}
		Console.keyboard.close();
		Console.br.close();
	}

}
