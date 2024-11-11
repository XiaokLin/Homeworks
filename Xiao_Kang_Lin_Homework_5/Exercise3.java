import java.util.Scanner;

public class Exercise3{
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        double [] array1 = new double[10];
        int [] array2 = new int[10];



        System.out.println("What are the 10 numbers you want to input?");
        for (int i = 0; i < 10; i++){
            array1[i] = input.nextDouble();
        }

        for (int i = 0; i < 10; i++) {
            array2[i] = (int) Math.round(array1[i]);
        }

        System.out.println("The average for the int is " + average(array2));
        System.out.println("The average for the double is " + average(array1));

        input.close();
    }

    public static int average (int [] array){
        int a = 0;
        for (int i = 0; i < 10; i++){
            a += array[i];
        }
        return a/10;
    }

    public static double average(double [] array){
        double a = 0;
        for (int i = 0; i < 10; i++){
            a += array[i];
        }
        return a/10;
 
    }
    
}