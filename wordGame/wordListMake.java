package wordGame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class wordListMake {

	public static Vector<String> wordsToVector() {
		String word;
		Vector<String> wordList = new Vector<String>();
		FileReader fr = null;
		try {
			fr = new FileReader("data\\wordlist.dat");
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
			System.exit(0);
		}
		BufferedReader br = new BufferedReader(fr);

		while(true) {
			try {
				word = br.readLine();
				if (word == null) {
					break;
				}
				wordList.add(word.trim());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wordList;
	}

}
