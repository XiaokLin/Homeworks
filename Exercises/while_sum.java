import java.util.Scanner;
public class while_sum{
    public static void main(String[]args){
    int a = 0;
    Scanner input = new Scanner(System.in);
    System.out.println("What is an interger you'd like to find the sum between 1 to?");
    a = input.nextInt();
    int b = 0;
    int i = 1;
    while (i<=a){
        b += i;
        i++;
    }
    System.out.println("The sum of all the values between 1 to " + a + " is " + b);
    input.close();
    }
} 