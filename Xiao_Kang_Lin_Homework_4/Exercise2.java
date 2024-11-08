import java.util.Scanner;

public class Exercise2{

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        System.out.println("What is your first value?");
        int a = input.nextInt();
        System.out.println("what is your second value?");
        int b = input.nextInt();

        System.out.println("The output is: " + method(a, b).charAt(method(a, b).length() -1));

        input.close();
    }

    public static String method(int a, int b){
        int c = a + b;
        String d = String.valueOf(c);
        return d;
    }

}