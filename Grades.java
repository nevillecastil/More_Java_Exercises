import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
public class Grades {

	public static void main(String[] args){
		ArrayList<Student> a = new ArrayList<Student>();
		Scanner input = new Scanner(System.in);
		int option = 0;
		String name = "";
		double grade = 0;
		int number = 0;

		do {
			System.out.println("Main Menu");
			System.out.println();
			System.out.println("Select one of the following options\n1. Add a Student\n2. Edit student grades \n3. Exit");
			try{
				option = input.nextInt();
				if(option == 1) {
					number++;
					do {
						System.out.println("\nPlease enter the students name:\n");
						name = input.next();
					}while(!isDigit(name));
					boolean badInput = true;
					do {
						try {
							System.out.println("\nPlease enter a grade for " + name + ":\n");
							grade = input.nextDouble();
							badInput = false;
							if(grade <= 100) a.add(new Student(number, name, grade));
							else {
								badInput = true;
								System.out.println("\nPlease enter a valid value (0-100)");					
							}
						}
						catch(InputMismatchException e) {
							System.out.println("Please enter an number. Try again");
							input.nextLine();
						}
					}while(badInput);
				}else if(option ==2 && a.isEmpty()) {
					System.out.println("Database is empty. No records found\nPlease add a Student\n");				
				}else if(option == 2) {
					if(!(a.size() == 0)){
						System.out.println("What student would you like to enter a grade for?\n");
						for(int i = 0; i < a.size(); i++){
							System.out.println(a.get(i));
						}
						boolean numOnly = true;
						
						
						do {
							try {
								int index2 = input.nextInt();
								numOnly = false;								
								for(int i = 1; i <= a.size(); i++){
									if(a.get(a.size()-i).getNumber() == index2) {
										name = a.get(a.size()-i).getName();
										boolean wrongInput = true;
										do {
											try {
												System.out.println("\nPlease enter a grade for " + name + ":\n");
												grade = input.nextDouble();
												wrongInput = false;
												if(grade <= 100) {
													a.remove(a.size()-i);
													a.add(index2-1, new Student(index2, name, grade));
													break;
												}
												else {
													wrongInput = true;
													System.out.println("\nPlease enter a valid value (0-100)");					
												}
											}
											catch(InputMismatchException e) {
												System.out.println("\nPlease enter an number. Try again\n");
												input.nextLine();
											}
										}while(wrongInput);
									}
								}
							}
							catch(InputMismatchException e) {
								System.out.println("\nPlease enter an number. Try again");
								input.nextLine();
							}
						}while(numOnly);
					}else System.out.println();
				}else if(option >= 4) {
					System.out.println("Please enter a valid option number\n");
					continue;
				}
			}
			catch(InputMismatchException ex) {
				System.out.println("Please enter an valid option\n");
				input.nextLine();
			}
		}while(option != 3);
		System.out.println("\nThank you, Goodbye!");
	}

	public static boolean isDigit(String p){
		for (int i=0; i < p.length(); i++) {
			char c = p.charAt(i);
			if(Character.isDigit(c)){
				System.out.print("Your name should not contain a number.");
				return false;
			}
		}
		return true;
	}
}
class Student{
	private int number;
	private String name;
	private double grade;

	public Student(int a, String b, double c) {
		this.number = a;
		this.name = b;
		this.grade = c;
	}
	public int getNumber() {
		return number;
	}
	public String getName() {
		return name;
	}
	public double getGrade() {
		return grade;
	}
	public String toString() {
		return number + ") " + name + " - " + grade;
	}
}