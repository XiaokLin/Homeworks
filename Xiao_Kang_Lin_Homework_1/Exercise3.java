// Uses Scanner to take keyboard inputs to then use that data in a print statement. 

import java.util.Scanner;

public class Exercise3{
	public static void main(String[]args){
		String FirstName;
		String LastName;
		Scanner names = new Scanner(System.in);
		System.out.println("What is your first name?");
		FirstName = names.nextLine();
		System.out.println("What is your last name?");
		LastName = names.nextLine();
		System.out.println("Hmmmm..... " + FirstName + " " + LastName + ", what a strange name to give to a child.");
		names.close();
	}
}