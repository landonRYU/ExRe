package rrn;

public class Rrn {

	private String rrn;
	private String gender;
	private String region;
	private int age;
	
	public Rrn(Checkrrn rrn) {
		age = rrn.checkDate();
		gender = rrn.checkGender();
	}
	
	public String getRrn() {
		return rrn;
	}
	public void setRrn(String rrn) {
		this.rrn = rrn;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void printRRN() {
		System.out.println("나이 : "+age);
		System.out.println("성별 : "+gender);
		
		
	}
	

}
