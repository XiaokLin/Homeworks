import java.util.Scanner;
import java.text.*;

public class exercise7{
	public static void main(String[]args){
	Scanner input = new Scanner(System.in);
	double a = 0.00;
	double b = 0.00;
	double c = 0.00;
	double d = 0.00;
	System.out.println("What is the first exam grade?");
	a = input.nextDouble();
	System.out.println("What is your second exam grade?");
	b = input.nextDouble();
	System.out.println("What is your third exam grade?");
	c = input.nextDouble();
	d = (a+b+c)/(3.00);
	DecimalFormat e = new DecimalFormat("#.##");
	System.out.println("The arithemetic mean of the grades for the first 3 exam are " + e.format(d));
	input.close();
	}
}