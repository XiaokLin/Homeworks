import lib.*;
import java.util.*;


public class PhoneBookDirectory {

    private static Scanner input = new Scanner(System.in);
    private static Map<Integer, PhoneBookEntry> Database = new HashMap<>();
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
            add_user_data(UserCount, true); 
            UserCount++; 
        } else {
            methods.login(username, password);
            System.out.println("Please input your own data.");
            add_user_data(UserCount, true);
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

        printFirstTenEntries();

        System.out.println("What is the ID number you would like to search for?");
        String search_id_string = input.nextLine();
        int search_id;
        
        try {
            search_id = Integer.parseInt(search_id_string);
            boolean found = searchForUserID(search_id);
            if (!found) {
                System.out.println("No data found for that ID.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a numeric user ID.");
        }

        input.close();
    }


// sets up the hashmap and only Admins can input a status otherwise its automatically User. 
    public static void add_user_data(int UserCount, boolean Admin) {
        System.out.println("----------------------------------------------------");
        Map<String, Object> userdata = new HashMap<>();

        System.out.println("What is your last name?");
        String last_name = input.nextLine();

        System.out.println("What is your first name?");
        String first_name = input.nextLine();

        System.out.println("What is your email?");
        String email = input.nextLine();
        
        int zipcode = -1;
        while(true){
            System.out.println("What is your zipcode?");
            String zipcode_string = input.nextLine(); 
// Use Regex make sure its 5 digits :)
            if (!zipcode_string.matches("\\d{5}")) {
                System.out.println("Please enter a valid 5 digit US zipcode.");
            } else {
                zipcode = Integer.parseInt(zipcode_string);
                break;
            }
        }

// Cause some people put phone number data as 123-123-1234 or 123 123 1234 instead of 1231231234. We take the input as a string and parse out all non digits
        int phone_number = -1;
        while(true){
            System.out.println("What is your phone number?");
            String phone_number_string = input.nextLine();
            phone_number_string = phone_number_string.replaceAll("\\D+", "");
            if (!phone_number_string.matches("\\d{10}")) {
                System.out.println("Please input a valid US phone number which only contains 10 digits without including the area code.");
            } else {
                phone_number = Integer.parseInt(phone_number_string);
                break;
            }
        }

        String status;
        if (UserCount == 0) {
            status = "admin";
        } else if (Admin) {
            System.out.println("Is this going to be an admin or user account? Please enter 'admin' or 'user'.");
            String statusInput = input.nextLine();
            status = methods.user_status(statusInput);
        } else {
            status = "user";
        }

        int ID = methods.random_num();
        
        PhoneBookEntry entry = new PhoneBookEntry();
        entry.setID(ID);
        entry.setFname(first_name);
        entry.setLname(last_name);
        entry.setEmail(email);
        entry.setZipcode(zipcode);
        entry.setNumber(phone_number);
        entry.setStatus(status);
        Database.put(ID, entry);

        System.out.println("Your Data has been collected under the unique ID: " + ID);
    }

    public static void printFirstTenEntries() {
        // int count = 0;
        for (Map.Entry<Integer, PhoneBookEntry> outerEntry : Database.entrySet()) {
            System.out.println("ID: " + outerEntry.getKey());
            PhoneBookEntry entry = outerEntry.getValue();
            entry.printBookEntry();
            System.out.println();

        /* 
Realistically, we should not print every entry and print like 10 and then have a next page and prev page and exit option. 
            count++;
            if (count == 10) {
                break; 
            }

        */
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
            PhoneBookEntry entry = Database.get(unique_id);
            if (entry != null) {
                entry.printBookEntry();
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
