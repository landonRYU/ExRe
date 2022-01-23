package wordGame;

import java.util.Scanner;

public class Player {
	private String name;
	private String word;
	private Scanner sc;

	public Player() {
	}

	public Player(String name) {
		sc = new Scanner(System.in);
		this.name = name;
	}

	public Player(String name, String word) {
		sc = new Scanner(System.in);
		this.name = name;
		this.word = word;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getWordFrommUser() {
		System.out.print(name +">>");
		word = sc.nextLine();
		return word;
	}

}
