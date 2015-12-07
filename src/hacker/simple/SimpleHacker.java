package hacker.simple;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

public class SimpleHacker {

	SimpleHacker() {
		displayedWords = new HashSet<String>();
	}

	// Fallout4 terminals make you choose from words of the same length

	// this list stores the words displayed on the terminal
	HashSet<String> displayedWords;
	Integer wordCount = new Integer(0);

	void addWord(String word) {
		this.displayedWords.add(word.toUpperCase());
		this.wordCount++;
	}

	void listWords() {
		System.out.print("potential: ");
		for (String s : displayedWords) {
			System.out.print(s + " ");
		}
		System.out.println();
	}

	void markWords(Feedback f) {
		System.out.print("excluded: ");
		for (Iterator<String> iterator = displayedWords.iterator(); iterator.hasNext();) {
			String s = iterator.next();
			if (similarity(f.guess, s) != f.likeliness) {
				System.out.print(s.toLowerCase() + " ");
				iterator.remove();
			}
		}
	}

	int countGoodWords() {
		return this.displayedWords.size();
	}

	// returns a value between [0, length of the string]
	public static int similarity(String s1, String s2) {
		int compareLength = 0;
		if (s1.length() < s2.length()) {
			compareLength = s1.length();
		} else {
			compareLength = s2.length();
		}
		int s = 0;
		for (int i = 0; i < compareLength; i++) {
			if (s1.toUpperCase().charAt(i) == s2.toUpperCase().charAt(i)) {
				s++;
			}
		}
		return s;
	}

	public Feedback getFeedback() {
		String guess = "#DEF#";
		Integer likeliness = -1;
		Feedback f = new Feedback(guess, likeliness);
		System.out.println();
		listWords();
		System.out.println("Requesting WORD:");
		try {
			String tmp = Console.readUpperFromKeyboard();
			while (true) {
				f.guess = tmp;
				if (displayedWords.contains(f.guess)) {
					break;
				} else {
					System.out.println(f.guess + " not found!");
					System.out.println("Requesting WORD:");
				}
				tmp = Console.readUpperFromKeyboard();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.print("Requesting LIKELINESS:");
		while (true) {
			if (Console.keyboard.hasNextInt()) {
				f.likeliness = Console.keyboard.nextInt();
				break;
			} else {
				System.out.println("Input WAS NOT INTEGER!");
				System.out.print("Requesting LIKELINESS:");
				Console.keyboard.next();
			}
		}
		return f;
	}

	void hack() {
		while (countGoodWords() > 1) {
			markWords(getFeedback());

		}
		System.out.println("\nhacking done");
		if (!displayedWords.isEmpty()) {
			listWords();
		}
	}
}
