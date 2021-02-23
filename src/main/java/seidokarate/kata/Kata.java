package seidokarate.kata;

public class Kata {
	
	enum Grade{
		ALL,
		WHITE,
		BLUE,
		YELLOW,
		GREEN,
		BROWN
	}
	
	private final String name;
	private final Grade grade;
	
	public Kata(String name, Grade grade) {
		this.name = name;
		this.grade = grade;
	}
	
	public String getName() {
		return name;
	}
	
	public Grade getGrade() {
		return grade;
	}
	
	public String toString() {
		return "Name: " + this.name + ", Grade: " + this.grade;
	}
}