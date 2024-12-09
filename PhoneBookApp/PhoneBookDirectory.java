import lib.*;
import java.util.*;


public class PhoneBookDirectory {

    private static Scanner input = new Scanner(System.in);
    private static int UserCount = 0;
    private static Methods methods = new Methods();


    public static void main(String[] args) {

        String username = null;
        String password = null;
        UserInterface userInterface = new UserInterface();
        AdminInterface adminInterface = new AdminInterface();

        System.out.println("Welcome to the Bari Phone Book Application.");

        if (UserCount == 0) {
            System.out.println("Please register for an admin view and remember your username and password.");
            username = methods.Set_Username();
            password = methods.Set_Password();
            methods.login(username, password);
            System.out.println("Please input your own data.");
            methods.add_user_data(UserCount, true); 
            UserCount++; 
        } else {
            methods.login(username, password);
            System.out.println("Please input your own data.");
            methods.add_user_data(UserCount, true);
            UserCount++;
        }

        if (UserCount == 1) {
            System.out.println("Admin View:");
            adminInterface.user_view();
            adminInterface.admin_view();
        } else {
            System.out.println("User View:");
            userInterface.user_view();
        }

        methods.Print_All_Entries();

        System.out.println("What is the ID number you would like to search for?");
        String search_id_string = input.nextLine();
        int search_id;
        
        try {
            search_id = Integer.parseInt(search_id_string);
            boolean found = methods.searchForUserID(search_id);
            if (!found) {
                System.out.println("No data found for that ID.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a numeric user ID.");
        }

        input.close();
    }







}
