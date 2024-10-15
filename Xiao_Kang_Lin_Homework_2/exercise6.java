import java.lang.Math;
import java.util.Scanner;

public class exercise6{
	public static void main(String[]args){
	Scanner input = new Scanner(System.in);
	double num1;
	double num2;
	double maximum;
	System.out.println("What is the first number?");
	num1 = input.nextDouble();
	System.out.println("What is the second number");
	num2 = input.nextDouble();
	maximum = Math.max(num1,num2);
	System.out.println("The maximum is " + maximum);
	input.close();
	}
}