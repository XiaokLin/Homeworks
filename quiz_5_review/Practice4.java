/*

Write a Java method findDuplicates(int[] arr) that finds and returns an array of duplicate values in the given array.
Example:
Input: [1, 2, 3, 2, 4, 1]
Output: [1, 2]

*/


import java.util.Scanner;

public class Practice4 {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("What is the length of your array?");
        int length = input.nextInt();
        int[] array = new int[length];

        System.out.println("What are the values for your array?");
        
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }

        int[] duplicates = findDuplicates(array);

        if (duplicates.length > 0) {
            System.out.print("Duplicates: ");
            for (int num : duplicates) {
                System.out.print(num + " ");
            }
        } else {
            System.out.println("No duplicates found.");
        }

        input.close();
    }

    public static int[] findDuplicates(int[] array) {
        int[] temp = new int[array.length];
        int count = 0; 

        for (int i = 0; i < array.length; i++) {
            for (int n = i + 1; n < array.length; n++) {
                if (array[i] == array[n]) {
                    boolean alreadyAdded = false;
                    for (int a = 0; a < count; a++) {
                        if (temp[a] == array[i]) {
                            alreadyAdded = true;
                            break;
                        }
                    }
                    if (!alreadyAdded) {
                        temp[count++] = array[i];
                    }
                }
            }
        }

        int[] result = new int[count];
        
        for (int i = 0; i < count; i++) {
            result[i] = temp[i];
        }

        return result; 

    }

}