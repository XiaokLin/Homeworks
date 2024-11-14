/* 
Write a Java method reverseArray(int[] arr) that takes an array as input and reverses it in place (i.e., without using extra arrays).
Example:
Input: [1, 2, 3, 4, 5]
Output: [5, 4, 3, 2, 1]
*/

import java.util.Scanner;

public class Practice3{
    public static void main(String [] args){

        Scanner input = new Scanner(System.in);

        System.out.println("What is the length of the array.");
        int length = input.nextInt();

        int [] array = new int [length];

        System.out.println("Please input the values of the array.");

        for (int i = 0; i < array.length; i++){
            array[i] = input.nextInt();
        }
        System.out.println("The outputs of the array in reverse order is:");
        method(array);
        input.close();
    }
    public static int method(int [] array){
        int [] new_array = new int [array.length];
        for (int i = 0; i < array.length; i++){
            System.out.println(array[array.length - i - 1]);
        }
        return 1; //How do I do this without it returning anything? 
    }   
}