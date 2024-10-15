import java.util.Scanner;

public class exercise1{
	public static void main(String[]args){
		Scanner input = new Scanner(System.in);
		double first_num = 0;
		double second_num = 0;
		System.out.println("What is the first number?");
		first_num = input.nextDouble();
		System.out.println("What is the second Number?");
		second_num = input.nextDouble();
		double sum, subtraction, division, multiplication, remainder;
		sum = first_num+second_num;
		subtraction = first_num-second_num;
		division = first_num/second_num;
		multiplication = first_num*second_num;
		remainder = (first_num%second_num);
		
		System.out.println("The sum of " + (double)first_num + " and " + (double)second_num + " is " + (double)sum + ".");
		System.out.println("The subtraction of " + (double)first_num + " and " + (double)second_num + " is " + (double)subtraction + ".");
		System.out.println("The multiplication of " + (double)first_num + " and " + (double)second_num + " is " + (double)multiplication + ".");
		System.out.println("The division of " + (double)first_num + " and " + (double)second_num + " is " + (double)division + ".");		
		System.out.println("The remainder is " + (double)remainder + ".");
		input.close();
	}
}