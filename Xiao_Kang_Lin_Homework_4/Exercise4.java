import java.util.Scanner;

public class Exercise4{
    public static void main(String [] args){
    Scanner input = new Scanner(System.in);
    
    System.out.println("What is the input number?");
    int b = input.nextInt();
    System.out.println(method(b));
    }

    public static int method(int a){
        int b = 0;
        if (a % 2 == 0){
            b++;
        } else if (a % 2 != 0){
            b = 0;
        } else {
            System.out.println("The input is not a number");
            b = -1;
        }
        return b;
    }
}