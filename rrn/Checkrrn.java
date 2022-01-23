package rrn;

import java.time.DateTimeException;
import java.time.LocalDate;

public class Checkrrn {
	private String rrn;
	private int age;

	public Checkrrn(String rrn) {
		super();
		this.rrn = rrn;
	}

	public boolean checkLength() {
		if (rrn.length() != 14) {
			System.out.println("(자리값오류) 올바른 길이가 아닙니다 다시 입력하세요 >>");
			return false;
		}
		return true;
	}

	public boolean checkDash() {
		if (rrn.charAt(6) != '-') {
			System.out.println("(입력형식오류) -를 포함해서 입력하세요 >>");
			return false;
		}
		return true;
	}

	public boolean checkNumber() {
		int chkn1, chkn2;
		try {
			chkn1 = Integer.parseInt(rrn, 0, 6, 10);
			chkn2 = Integer.parseInt(rrn, 7, 13, 10);
		} catch (NumberFormatException e) {
			System.out.println("(입력형식 오류) 숫자만 입력하세요 >>");
			return false;
		}
		return true;
	}

	public int checkDate() {
		int yy = Integer.parseInt(rrn, 0, 2, 10);
		int mm = Integer.parseInt(rrn, 2, 4, 10);
		int dd = Integer.parseInt(rrn, 4, 6, 10);
		if (Integer.parseInt(rrn, 7, 8, 10) == 1 || Integer.parseInt(rrn, 7, 8, 10) == 2) {
			yy = 1900 + yy;
		} else
			yy = 2000 + yy;
		LocalDate birth;
		try {
			birth = LocalDate.of(yy, mm, dd);
		} catch (DateTimeException e) {
			System.out.println("(생년월일 오류) 앞자리를 확인하고 다시 입력해주세요 ");
			return 0;
		}
		LocalDate now = LocalDate.now();
		if (now.getDayOfYear() > birth.getDayOfYear()) {
			age = now.getYear() - birth.getYear(); // 생일이 지났으면,
		} else if (now.getDayOfYear() <= birth.getDayOfYear()) {
			age = now.getYear() - birth.getYear() - 1;
		}

		return age;
	}

	public String checkGender() {
		int genderNumber;
		String gender;
		genderNumber = Integer.parseInt(rrn, 7, 8, 10);

		if (genderNumber == 1 || genderNumber == 3) {
			gender = "남자";
		} else if (genderNumber == 2 || genderNumber == 4) {
			gender = "여자";
		} else {
			System.out.println("(성별값 입력오류) 다시 입력해주세요 ");
			return "오류";
		}
		return gender;
	}

	public boolean checkCdC() {
		int[] a = new int[13];
		int[] b = { 2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5 };
		int test = 0;

		for (int i = 0; i < a.length + 1; i++) {
			if (i < 6) {
				a[i] = Integer.parseInt(rrn.substring(i, i + 1));
				continue;
			} else if (i == 6) {
				continue;
			} else if (i > 6) {
				a[i - 1] = Integer.parseInt(rrn.substring(i, i + 1));
				continue;
			}

		}

		for (int i = 0; i < b.length; i++) {
			test += a[i] * b[i];
		}

		test = test % 11;
		test = 11 - test;
		if (test >= 10) {
			test -= 10;
		}

		if (a[12] != test) {
			System.out.println("(CDC오류) 올바른 주민등록번호가 아닙니다 다시 입력 >>");
			return false;
		}
		return true;
	}
}
