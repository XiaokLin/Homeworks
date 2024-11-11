import java.util.Scanner;

public class Exercise1{
    public static void main(String [] args){
        int [] array = new int [10];
        Scanner input = new Scanner(System.in);
        System.out.println("What are the 10 intergers you want to input?");

        for (int i = 0; i < 10; i++){
            array[i] = input.nextInt();
        }

        System.out.println("The 10 intergers in reserse order are:");
        System.out.println("--------------------------------------");
        for (int i = 0; i < 10; i++){
            System.out.println(array[9-i]);
        }
        input.close();
    }
}