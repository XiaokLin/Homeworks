// TODO 
// Go to office hours and ask if decimal numbers are integers or doubles. The examples shown on the hw doc uses int. 

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