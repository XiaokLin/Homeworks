import java.util.Scanner;

public class exercise2{
	public static void main(String[]args){

	Scanner input = new Scanner(System.in);
	double kilometers, miles;
	System.out.println("What is the number of kilometers you want me to convert into miles?");
	kilometers = input.nextDouble();
	miles = kilometers * (0.6214);
	System.out.println("There are " + miles + " miles in " + kilometers + " kilometers.");
	input.close();

	}
}