import java.util.Scanner;

public class Exercise2{
    public static void main(String [] args){
    Scanner input = new Scanner(System.in);
    int [] array = new int [101];
    System.out.println("Please enter intergers and enter 0 when you are done.");

    while(true) {
        int numbers = input.nextInt();
        
        if (numbers == 0){
            break;
        }

        if (numbers >= 1 && numbers <= 100) {
            array[numbers]++;
        } else{
            System.out.println("Please enter numbers between 1 and 100.");
        }
    }

    System.out.println("---------------------------");
    
    for (int i = 1; i <= 100; i++) {
        if (array[i] > 0) {
            System.out.println(i +" appears " + array[i] + method(array[i]));
        }
    }

    input.close();

    }

    public static String method (int a){
        if (a==1) {
            return " time.";
        } else {
            return " times.";
        }
    }
}