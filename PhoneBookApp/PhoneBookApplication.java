import lib.*;
import java.util.*;

public class PhoneBookApplication {

    private static Scanner input = new Scanner(System.in);
    private static Methods methods = new Methods();
    private static int UserCount = methods.Number_Of_Users();

    public static void main(String[] args) {

        String username = null;
        String password = null;
        NormalUser NormalUser_Interface = new NormalUser();
        PhoneBookAdmin PhoneBookAdmin_Interface = new PhoneBookAdmin();

        System.out.println("Welcome to the Bari Phone Book Application.");

        methods.load_and_save();

        if (UserCount == 0) {
            System.out.println("Please register for an admin view and remember your username and password.");
            methods.add_user_data(UserCount, true, true);
            UserCount++;
            methods.load_and_save();
        }

        while (true) {
            System.out.println("Login Page");
            System.out.println("---------------------------------------------------------");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Register");
            System.out.println("4. Exit");
            String status = input.nextLine();

            switch (status) {
                case "1":
                    System.out.println("Enter username:");
                    username = input.nextLine();
                    System.out.println("Enter password:");
                    password = input.nextLine();
                    if (methods.Admin(username, password)) {
                        PhoneBookAdmin_Interface.menu();
                    } else {
                        System.out.println("Invalid credentials. Please try again.");
                    }
                    break;
                case "2":
                    if (UserCount == 1) {
                        System.out.println("No users registered yet. Please register first.");
                        methods.Register(UserCount);
                        UserCount++;
                    } else {
                        System.out.println("Enter username:");
                        username = input.nextLine();
                        System.out.println("Enter password:");
                        password = input.nextLine();
                        if (methods.User(username, password)) {
                            System.out.println("Adding new phonebook entry:");
                            methods.add_user_data(UserCount, false, false);
                        } else {
                            System.out.println("Invalid credentials. Please try again.");
                        }
                    }
                    break;
                case "3":
                    methods.Register(UserCount);
                    UserCount++;
                    break;
                case "4":
                    System.out.println("Bye Bye");
                    methods.saveData();
                    System.exit(0);
                default:
                    System.out.println("Please enter only 1, 2, 3, or 4.");
            }
        }
    }
}
