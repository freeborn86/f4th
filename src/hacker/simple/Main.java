package hacker.simple;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		SimpleHacker sh = Console.getWords();
		sh.hack();
		Console.keyboard.close();
		Console.br.close();
	}

}
