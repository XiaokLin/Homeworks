import lib.*;
import java.util.*;


public class PhoneBookNew {

    private static Scanner input = new Scanner(System.in);
    private static Map<Integer, Map<String, String>> Database = new HashMap<>();
    private static int Number_Of_Users = 0;
    private static Methods methods = new Methods();


    public static void main(String[] args) {

        String username = null;
        String password = null;
        UserInterface userInterface = new UserInterface();
        AdminInterface adminInterface = new AdminInterface();

        System.out.println("Welcome to the Bari Phone Book Application.");

        if (Number_Of_Users == 0) {
            System.out.println("Please register for an admin view and remember your username and password.");
            username = methods.Set_Username();
            password = methods.Set_Password();
            methods.login(username, password);
            System.out.println("Please input your own data.");
            add_user_data(Number_Of_Users, true); 
            Number_Of_Users++; 
        } else {
            methods.login(username, password);
            System.out.println("Please input your own data.");
            add_user_data(Number_Of_Users, true);
            Number_Of_Users++;
        }

        if (Number_Of_Users == 1) {
            System.out.println("Admin View:");
            adminInterface.user_view();
            adminInterface.admin_view();
        } else {
            System.out.println("User View:");
            userInterface.user_view();
        }

        printFirstTenEntries();
        System.out.println("What is the ID number you would like to search for?");
        int search_id = input.nextInt();
        try {
            boolean found = searchForUserID(search_id);
            if (!found) {
                System.out.println("No data found for that ID.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a numeric user ID.");
        }

        input.close();
    }



    public static void add_user_data(int Number_Of_Users, boolean Admin) {

        Map<String, String> userdata = new HashMap<>();

        System.out.println("What is your last name?");
        String last_name = input.nextLine();
        userdata.put("last_name", last_name);

        System.out.println("What is your first name?");
        String first_name = input.nextLine();
        userdata.put("first_name", first_name);

        System.out.println("What is your email?");
        String email = input.nextLine();
        userdata.put("email", email);

        System.out.println("What is your zipcode?");
        String zipcode = input.nextLine();
        userdata.put("zipcode", zipcode);

        System.out.println("What is your phone number?");
        String phone_number = input.nextLine();
        userdata.put("phone_number", phone_number);

        if (Number_Of_Users == 0) {
            userdata.put("status", "admin");
        } else if (Admin) {
            System.out.println("Is this going to be an admin or user account? Please enter 'admin' or 'user'.");
            String status = input.nextLine();
            userdata.put("status", methods.user_status(status));
        } else {
            userdata.put("status", "user");
        }

        Database.put(methods.random_num(), userdata);
        System.out.println("Your Data has been collected.");
    }

    public static void printFirstTenEntries() {
        int count = 0;
        for (Map.Entry<Integer, Map<String, String>> outerEntry : Database.entrySet()) {
            System.out.println("ID: " + outerEntry.getKey());
            Map<String, String> userData = outerEntry.getValue();
            
            for (Map.Entry<String, String> innerEntry : userData.entrySet()) {
                System.out.println("   " + innerEntry.getKey() + ": " + innerEntry.getValue());
            }

            count++;
            if (count == 10) {
                break; 
            }
        }
    }

    public static int[] getAllUserIDs() {
        int[] userIDs = Database.keySet().stream().mapToInt(Integer::intValue).toArray();
        return userIDs;
    }

    public static boolean searchForUserID(int unique_id) {
        int[] userIDs = getAllUserIDs();
        if (userIDs.length == 0) {
            return false; 
        }

        Methods.MergeSort(userIDs, 0, userIDs.length - 1);

        if (binarySearchIDs(userIDs, unique_id)) {
            Map<String, String> userData = Database.get(unique_id);
            if (userData != null) {
                System.out.println("ID: " + unique_id);
                for (Map.Entry<String, String> entry : userData.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
            } else {
                System.out.println("No data found for ID: " + unique_id);
            }
            return true;
        } else {
            return false;
        }
    }

    public static boolean binarySearchIDs(int[] sortedArray, int unique_id) {
        int left = 0;
        int right = sortedArray.length - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (sortedArray[mid] == unique_id) {
                return true;
            } else if (sortedArray[mid] < unique_id) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
