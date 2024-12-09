package lib;

import java.util.Scanner;

public abstract class Interface {
    protected static Scanner input = new Scanner(System.in);
    protected Methods methods = new Methods();

    public abstract void menu(); 

    protected void Add_Entry(boolean Admin) {
        methods.add_user_data(1, Admin);
    }

    protected void Sort_Entry() {
        methods.Sort_By_ID();
    }

    protected void LinearSearchByPhoneNumber() {
        System.out.println("Enter the phone number to search:");
        int phoneNumber = Integer.parseInt(input.nextLine());
        if(methods.LinearSearchByPhoneNumber(phoneNumber) == 0){
            System.out.println("The Phone Number was not found.");
        }
    }

    protected void Print_All_entries() {
        methods.Print_All_Entries();
    }
}