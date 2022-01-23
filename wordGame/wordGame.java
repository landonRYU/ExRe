package wordGame;

import java.util.Scanner;
import java.util.Vector;

public class wordGame {
	private String word;
	private String name;
	private int numP;
	private Scanner sc;
	private int pos = 0;

	public void runWordGame() {
		System.out.println("끝말잇기 게임을 시작합니다.");
		System.out.print("참여 인원수를 입력하세요 >>");
		sc = new Scanner(System.in);
		numP = sc.nextInt();
		Player[] p = new Player[numP];
		Vector<String> wordSum = new Vector<String>();
		sc.nextLine();
		for (int i = 0; i < p.length; i++) {
			System.out.print((i + 1) + "번 참여자 이름 입력 >>");
			name = sc.nextLine();
			p[i] = new Player(name);
		}
		
		Vector<String> wordList = new Vector<String>();
		wordList = wordListMake.wordsToVector();
		int ra = (int) (Math.random()*wordList.size());
		System.out.println(wordList.size());
		String startWord = wordList.get(ra);
		wordSum.add(startWord);

		String playerWord;
		System.out.println(startWord + "로 시작하는 끝말잇기 게임을 시작합니다>>");
		System.out.println("시작단어 : " + startWord);
		
		while (true) {
			for (int i = pos; i < p.length; i++) {
				p[i].getWordFrommUser();
				playerWord = p[i].getWord();
				if (wordList.indexOf(playerWord) == -1) {
					System.out.println("사전에 없는 단어입니다.");
					System.exit(0);
				}
				if (startWord.charAt(startWord.length() - 1) != playerWord.charAt(0)) {
					System.out.println("끝말이 이어지지 않았습니다.");
					System.exit(0);
				}
				if (wordSum.indexOf(playerWord) != -1) {
					System.out.println("다른 플레이어가 이미 언급한 단어입니다.");
					System.exit(0);
				}
				wordSum.add(playerWord);
				startWord = playerWord;
				pos++;
				pos %= numP;
			}
		}
	}
}