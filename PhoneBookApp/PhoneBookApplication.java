import lib.*;
import java.util.*;

public class PhoneBookApplication {
    private static Scanner input = new Scanner(System.in);
    private static Methods methods = new Methods();

    public static void main(String[] args) {
    NormalUser NormalUser_Interface = new NormalUser();
    PhoneBookAdmin PhoneBookAdmin_Interface = new PhoneBookAdmin();
    System.out.println("Welcome to the Phone Book Application.");

        while (true) {
            System.out.println("Are you logging in as: ");
            System.out.println("---------------------------------------------------------")
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.printlin("3. Exit");
            int status = input.nextInt();

            if (status.equals("0")) {
                System.out.println("Bye Bye");
                methods.save_data_onto_json(); // Gotta make a thing where we save and load the data.
                break;
            }

            switch (status) {
                case "1":
                    PhoneBookAdmin_Interface.admin_view();
                    break;
                case "2":
                    NormalUser_Interface.user_view();
                    break;
                default:
                    System.out.println("Please enter only 1, 2, or 0.");
            }
        }
    }    
}
