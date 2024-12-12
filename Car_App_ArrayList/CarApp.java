package lib;

import java.util.*;

public class CarApp{
    private static Scanner input = new Scanner(System.in);
    private static Methods methods = new Methods();


    public static void main(String [] args){

        ArrayList<String> arrayList = new ArrayList<>();

        int choices = 0;

        do {
            choices = methods.Interface();

            if (choices == 1) {
                methods.addEntry();
            } else if (choices == 2) {
                methods.printAllEntries();
            } else if (choices == 3) {
                methods.editEntry();
            } else if (choices == 4) {
                methods.deleteEntry();
            } else if (choices == 5) {
                System.out.println();
                System.out.println("Take care.");
                System.out.println();
                break;
            } else {
                System.out.println();
                System.out.println("Please only enter a value between 1 to 5.");
                System.out.println();
            }
        } while (choices > 0 && choices < 6);
    }
}