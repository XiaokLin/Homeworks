import java.util.Scanner;

public class Exercise5{
    public static void main (String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("What is the first number?");
        int a = input.nextInt();

        System.out.println("What is the second number?");
        int b = input.nextInt();

        System.out.println(method(a,b));

        input.close();    
    }

    public static String method(int a, int b){
        String c = "";
        int d = b%a;
        if (a <= b){
            if (d == 0){
                c = "The first num is a multiple of the second num";
            } else {
            c = "The first num is not a multiple of the second num";
        }
        } else {
            c = "The first num is not a multiple of the second num";
        }
        return c;
    }
}