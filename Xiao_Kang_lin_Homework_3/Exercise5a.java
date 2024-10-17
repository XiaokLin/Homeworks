import java.util.Scanner;

public class Exercise5a{
    public static void main (String[]args){
        Scanner input = new Scanner(System.in);
        int num = 0;
        System.out.println("What number do you want to turn into binary?");
        num = input.nextInt();
        System.out.println("The binary of " + num + " is " + Integer.toBinaryString(num));
        input.close();

    }
}