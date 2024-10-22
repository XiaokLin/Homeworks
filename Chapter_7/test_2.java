import java.util.Scanner;

public class test_2{
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int a = 0;
        int b = 0;
        System.out.println("What is the input of the first value?");
        a = input.nextInt();
        System.out.println("What is the input of the second value?");
        b = input.nextInt();
        System.out.println("The largest interger is: " + max(a,b));
        input.close();
    }
    public static int max(int c, int d){
        if (c>d) {
            return c;
        }
        else return d;
    }
}