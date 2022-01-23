package rrn;

import java.util.Scanner;

public class RrnMain {

	public static void main(String[] args) {
		String rrn;
		Checkrrn ckr;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("주민등록번호를 입력하세요 >>");
			rrn = sc.nextLine();
			ckr = new Checkrrn(rrn);
			if(!(ckr.checkLength())) continue;
			if(!ckr.checkDash()) continue;
			if(!ckr.checkNumber()) continue;
			if(ckr.checkDate()==0) continue;
			if(ckr.checkGender().equals("오류")) continue;
			if(!ckr.checkCdC()) continue;
			
			break;
		}
		System.out.println("체크 완료. 정상적인 주민등록 번호입니다.");
		
		Rrn prt = new Rrn(ckr);
		prt.printRRN();
		
	}

}
