import lib.*;
import java.util.*;

public class PhoneBookNew {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String username = null;
        String password = null;
        int first_use = 0;
        Methods methods = new Methods();
        if (first_use == 0){
            System.out.println("Welcome to the Bari Phone Book Application.");
            System.out.println("Please register for an admin view and be sure to remember your username and password.");
            username = methods.Set_Username();
            password = methods.Set_Password();
            first_use++;
            status = "admin"; //update this here to actually update the statuses. 
        }

        methods.login(username, password);
        
        System.out.println("");
        UserInterface userInterface = new UserInterface();
        System.out.println("User View:");
        userInterface.user_view();

        AdminInterface adminInterface = new AdminInterface();
        System.out.println("\nAdmin View:");
        adminInterface.user_view();
        adminInterface.admin_view();

        input.close();
    }
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