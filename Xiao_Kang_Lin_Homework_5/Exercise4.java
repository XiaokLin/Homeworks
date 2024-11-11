import java.util.Scanner;

public class Exercise4 {

    public static void main (String [] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the size of your list list:");

        int a = input.nextInt();
        System.out.println("Please enter the values for your list:");
        int [] array = new int[a];

        for (int i = 0; i < a; i++){
            array[i] = input.nextInt();
        } 

        if (isSorted(array)){
            System.out.println("The list is sorted.");
        } else {
            System.out.println("The list is not sorted.");
        }

        input.close();
    }

    public static boolean isSorted(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] > list[i + 1]) {
                return false; 
            }
        }
        return true;
    }

}