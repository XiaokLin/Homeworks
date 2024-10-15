import java.util.Scanner;

public class exercise4{
	public static void main(String[]args){
	Scanner input = new Scanner(System.in);
	double fahrenheit;
	double celcius;
	double a = 5;
	double b = 9;
	System.out.println("What is the degrees in Fahrenheit that you want to convert into Celsius?");
	fahrenheit = input.nextDouble();
	celcius = (a/b)*((double)fahrenheit-32);
	System.out.println(fahrenheit + " degrees in Fahrenheit is " + celcius + " in Celcius.");
	input.close();	
	}
}