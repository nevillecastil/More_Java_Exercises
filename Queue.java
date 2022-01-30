import java.util.ArrayList;
import java.util.Scanner;

public class Queue {

	public static void main(String[] args) {
		ArrayList<Student> a = new ArrayList<Student>();
		Scanner stdin = new Scanner(System.in);
		int index = 0;
		boolean status = true;

		while (status) {
			String name = stdin.next();

			if (name.equals("next")) {
				index--;
				a.remove(0);
			} else if (name.equals("end")) {
				status = false;
			} else {
				int age = stdin.nextInt();
				int grade = stdin.nextInt();

				if (a.size() == 0) {
					a.add(new Student(name, age, grade));
					index++;
				} else if (a.get(a.size() - 1).getCAge() > age || a.get(a.size() - 1).getSGrade() > grade) {
					a.add((index - 1), new Student(name, age, grade));
					index++;
				} else {
					a.add(new Student(name, age, grade));
					index++;
				}
			}
		}
		if (!(a.size() == 0)) {
			for (int i = 0; i < a.size(); i++) {
				System.out.println(a.get(i));
			}
		} else {
			System.out.println("empty");
		}
		stdin.close();
	}
}

class Student {
	protected String firstName;
	protected int cAge;
	protected int sGrade;

	public Student(String name, int age, int grade) {
		firstName = name;
		cAge = age;
		sGrade = grade;
	}

	public String getFirstName() {
		return firstName;
	}

	public int getCAge() {
		return cAge;
	}

	public int getSGrade() {
		return sGrade;
	}

	public String toString() {
		return firstName + " " + cAge + " " + sGrade;
	}
}
