import java.util.Scanner;

public class sum_non_prime_digits{
        public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int a = 0;
        int b = 0;
        int c = 0;
        System.out.println("What is the interger you want to input?");
        a = input.nextInt();

        while (a > 0) {
            b = a % 10;
            if (!prime_num(b)){
                c += b;
            }

            a /= 10;
        }

        System.out.println("the sum of the non-prime digits is: " + c);

        input.close();
    }

    public static boolean prime_num(int num){
        if (num <= 1){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i ++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
}
