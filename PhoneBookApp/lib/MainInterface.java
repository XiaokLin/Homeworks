/*
This contains the folder for the print functions used in the interface
*/
package lib;

public class MainInterface {
    
}

class UserInterface {
    public void user_view() {
        System.out.println("1. Add a phone entry.");
        System.out.println("2. Edit a phone entry of a given first name and last name.");
        System.out.println("3. Sort the PhoneBookDirectory.");
        System.out.println("4. Search using Linear Search.");
        System.out.println("5. Print user’s info");
    }
}

class AdminInterface extends UserInterface {
    public void admin_view() {
        System.out.println("6. Delete a phone entry of a given first name and last name.");
        System.out.println("7. Search using Binary Search.");
        System.out.println("8. Change Password.");
        System.out.println("9. Change Username.");
    }
}