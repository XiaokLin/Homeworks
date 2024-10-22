import java.util.Scanner;

public class do_while{
    public static void main (String[]args){
        Scanner input = new Scanner(System.in);
        int a = 0;
        int b = 2;
        System.out.println("What is an interger you want to input?");
        a = input.nextInt();
        System.out.println("The even numbers from 1 to " + a + " is:");
        do{
            if (b<=a){
                System.out.println(b);
            }
            b += 2;
        }
        while (b<=a);

        input.close();
    }
}