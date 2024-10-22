import java.util.Scanner;

public class prime_number_finder{
	public static void main(String[]args){
		Scanner input = new Scanner(System.in);
		int a = 0;
		int b = 0;
		int big = 0;
		int small = 0;
		System.out.println("What is the first integer?");
		a = input.nextInt();
		System.out.println("What is the second integer?");
		b = input.nextInt();
		System.out.println("The prime numbers between the two integers are:");
		if (a>=b){
			big = a;
			small = b;
		} else { big = b; small = a;}
		for (int i = small; i <= big; i++){
			if (prime_num(i)){
				System.out.println(i);
			}
		}
		input.close();
	}

	public static boolean prime_num(int num){
		if (num <= 1){
			return false;
		}
		for (int i = 2; i <= Math.sqrt(num); i++){
			if (num % i == 0){
				return false;
			}
		}
		return true;
	}
}