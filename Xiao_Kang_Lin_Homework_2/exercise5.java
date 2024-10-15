import java.util.Scanner;

public class exercise5{
	public static void main(String[]args){
	Scanner input = new Scanner(System.in);
	String password;
	System.out.println("What is your password?");
	password = input.nextLine();
	if(password.equals("NYU1256")){
			System.out.println("Valid Password");
		}
	else{
			System.out.println("Invalid Password");
	}
	input.close();
	}
}