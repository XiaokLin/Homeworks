import lib.*;
import java.util.*;


public class PhoneBookDirectory {

    private static Scanner input = new Scanner(System.in);
    private static int UserCount = 0;
    private static Methods methods = new Methods();


    public static void main(String[] args) {

        String username = null;
        String password = null;
        NormalUser NormalUser_Interface = new NormalUser();
        PhoneBookAdmin PhoneBookAdmin_Interface = new PhoneBookAdmin();

        System.out.println("Welcome to the Bari Phone Book Application.");

        methods.loadData();

        if (UserCount == 0) {
            System.out.println("Please register for an admin view and remember your username and password.");
            username = methods.Set_Username();
            password = methods.Set_Password();
            methods.add_user_data(UserCount, true, true);
            UserCount++;
        }

        while (true) {
                System.out.println("Are you logging in as: ");
                System.out.println("---------------------------------------------------------")
                System.out.println("1. Admin");
                System.out.println("2. User");
                System.out.println("3. Register");
                System.out.printlin("4. Exit");
                int status = input.nextInt();

                if (status.equals("4")) {
                    System.out.println("Bye Bye");
                    methods.saveData();
                    break;
                }

                switch (status) {
                    case "1":
                        PhoneBookAdmin_Interface.admin_view();
                        break;
                    case "2":
                        if (UserCount == 1) {
                            System.out.println("No users registered yet. Please register first.");
                            methods.register();
                            UserCount++;
                        } else {
                            System.out.println("Adding new phonebook entry:");
                            methods.add_user_data(UserCount, false, false);
                        }
                    case "3":
                        methods.register();
                        break;
                    default:
                        System.out.println("Please enter only 1, 2, or 0.");
                }
            }
        input.close();
    }







}
