import java.util.Scanner;
public class Exercise5b{
    public static void main(String[] args) {
        int n = 0;
        String binary = "";
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an interger: ");
        n = input.nextInt();

        if (n == 0) {
            binary = "0";
        } else {
            while (n > 0) {
                int remainder = n%2;
                binary = remainder + binary;
                n = n/2;
            }
        }

        System.out.println("The binary of your number is: " + binary);
        input.close();
    }
}
