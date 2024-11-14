/*
Array Basics
Write a Java program that initializes an integer array with 10 elements. Populate the array with numbers from 1 to 10. Then, print the sum of all elements in the array.
*/

import java.util.Scanner;

public class Practice1{
    public static void main (String [] args){

        Scanner input = new Scanner(System.in);

        double [] array = new double [10];

        System.out.println("Please input 10 values:");

        for (int i = 0; i < array.length; i++){
            array[i] = input.nextDouble();
        }

        System.out.println("The values of the array are:");

        for (int i = 0; i <array.length ; i++){
            System.out.println(array[i]);
        }
        System.out.println("The sum of all the elements in the array is " + method(array));

        input.close();
    }
    public static double method(double [] array){
        double n = 0;
        for (int i = 0; i < array.length; i++){
            n += array[i];
        }
        return n;
    }
}