/*

Given an array of integers, write a function findLargest(int[] arr) that returns the largest element in the array.
Example:
Input: [4, 7, 1, 9, 3]
Output: 9

*/

import java.util.Scanner;

public class Pratice2{
    public static void main(String [] args){

        Scanner input = new Scanner(System.in);

        System.out.println("What is the length of your array?");
        int length = input.nextInt();

        System.out.println("Please enter the values of your array.");
        int [] array = new int [length];

        for (int i = 0; i < length; i++){
            array[i] = input.nextInt();
        }

        System.out.println("The largest int of the array is: " + method(array));

        input.close();

    }

    public static int method(int [] array){
        for (int i = 0; i < array.length - 1; i++){
            if (array[i] >= array[i+1]){
                array[i+1] = array[i];
            }
        }
        return array[array.length - 1];
    }
    
}   