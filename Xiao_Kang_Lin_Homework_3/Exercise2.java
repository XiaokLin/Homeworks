import java.util.Scanner;

public class Exercise2{
	public static void main(String[]args){
	Scanner input = new Scanner(System.in);
	int num = 0;
	int power = 0;
	int result = 1;
	System.out.println("Enter an interger");
	num = input.nextInt();
	System.out.println("What power do you want " + num + " to be raised to?");
	power = input.nextInt();
	if (power < 0) {
        System.out.println("Please enter a non-negative exponent value.");
    } 
    else {
	    for (int i = 0; i < power; i++) {
	        result *= num;
	        System.out.print(num);
	        if (i < power - 1) {
	        	System.out.print(" x ");
	        }
        }
    System.out.println(" = " + result);
    }
    input.close();
	}
}