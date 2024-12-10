
/*
Its good pratice to keep methods that you can repeatly use in a seperate file which all your code can use.
You can access this here by doing "import PhoneBookApp.Methods;" and then calling the function like normal like here:"Methods.BinarySearch(array, 0, 0, 1)"
*/
package lib;

import java.util.*;
import java.io.*;

public class Methods {
    Scanner input = new Scanner(System.in);
    private static Map<Integer, PhoneBookEntry> Database = new HashMap<>();

    // Got saveData and loadData off the stacked overflow, check README

    public void saveData() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("PhoneBookEntry.txt"))) {
            for (PhoneBookEntry entry : Database.values()) {
                writer.println(entry.getID() + "," + entry.getFname() + "," + entry.getLname() + "," + entry.getEmail() +
                        "," + entry.getZipcode() + "," + entry.getNumber() + "," + entry.getStatus() + "," +
                        entry.getUsername() + "," + entry.getPassword());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] actual_usernames() {
    return Database.values().stream()
            .map(PhoneBookEntry::getUsername)
            .toArray(String[]::new);
}

    public String[] actual_passwords() {
        return Database.values().stream()
                .map(PhoneBookEntry::getPassword)
                .toArray(String[]::new);
    }

    public void loadData() {
        try (BufferedReader reader = new BufferedReader(new FileReader("PhoneBookEntry.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length != 9) {
                    System.out.println("Skipping invalid entry: " + line);
                    continue; 
                }
                PhoneBookEntry entry = new PhoneBookEntry();
                entry.setID(Integer.parseInt(data[0]));
                entry.setFname(data[1]);
                entry.setLname(data[2]);
                entry.setEmail(data[3]);
                entry.setZipcode(Integer.parseInt(data[4]));
                entry.setNumber(Long.parseLong(data[5]));
                entry.setStatus(data[6]);
                entry.setUsername(data[7]);
                entry.setPassword(data[8]);
                Database.put(entry.getID(), entry);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 
    /*
       * Standard linear search, nothing to write home about.
       */

    public static int LinearSearch(int[] array, int input_value) {
        for (int i = 0; i < array.length; i++) {
            if (input_value == array[i]) {
                return i;
            }
        }
        return -1;
    }

    // gets the number of lines from the phonebookentry.txt file
    public int Number_Of_Users() {
        int i = 0;
        try (Scanner fileScanner = new Scanner(new File("PhoneBookEntry.txt"))) {
            while (fileScanner.hasNextLine()) {
                fileScanner.nextLine();
                i++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("PhoneBookEntry.txt not found.");
        }
        return i;
    }

    /*
     * Standard Merge Sort. Basicially it divides the dataset into smaller parts and
     * sorts it and merges it back.
     * When in doubt, Id say use this due to its time efficiency.
     */
    public static void MergeSort(int[] array, int array1, int array2) {
        if (array1 < array2) {
            int mid_value = array1 + (array2 - array1) / 2;
            MergeSort(array, array1, mid_value);
            MergeSort(array, mid_value + 1, array2);

            Merge(array, array1, mid_value, array2);
        }
    }

    public static void Merge(int[] array, int array1, int mid_value, int array2) {
        int array1_size = mid_value - array1 + 1;
        int array2_size = array2 - mid_value;
        int[] temp_array1 = new int[array1_size];
        int[] temp_array2 = new int[array2_size];

        for (int i = 0; i < array1_size; i++) {
            temp_array1[i] = array[array1 + i];
        }
        for (int i = 0; i < array2_size; i++) {
            temp_array2[i] = array[mid_value + 1 + i];
        }

        int a = 0;
        int b = 0;
        int c = array1;

        while (a < array1_size && b < array2_size) {
            if (temp_array1[a] <= temp_array2[b]) {
                array[c] = temp_array1[a];
                a++;
            } else {
                array[c] = temp_array2[b];
                b++;
            }
            c++;
        }
        while (a < array1_size) {
            array[c] = temp_array1[a];
            a++;
            c++;
        }
        while (b < array2_size) {
            array[c] = temp_array2[b];
            b++;
            c++;
        }
    }

    // Removes all non letters and numbers like spaces and symbols and makes
    // everything lowercase.
    public static String Clean_String(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        return input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    // Sets and Changes Username
    public String Set_Username() {
        String username = null;
        while (username == null) {
            System.out.println("What would you like to input as your username?");
            String new_username = input.nextLine();
            System.out.println("Would you like " + new_username + " to be your username?");
            System.out.println("Yes or No?");
            String temp_input1 = input.nextLine();
            if (Clean_String(temp_input1).equals("yes")) {
                username = new_username;
                System.out.println("Your username has been set.");
            } else if (Clean_String(temp_input1).equals("no")) {
                System.out.println("Let's try again.");
            } else {
                System.out.println("Please only input yes or no.");
            }
        }
        return username;
    }

    // Sets and Changes Password
    public String Set_Password() {
        String password = null;
        while (password == null) {
            System.out.println("What would you like to input as your password?");
            String new_password = input.nextLine();
            System.out.println("Would you like " + new_password + " to be your password?");
            System.out.println("Yes or No?");
            String temp_input1 = input.nextLine();
            if (Clean_String(temp_input1).equals("yes")) {
                password = new_password;
                System.out.println("Your password has been set.");
            } else if (Clean_String(temp_input1).equals("no")) {
                System.out.println("Lets try again.");
            } else {
                System.out.println("Please only input yes or no.");
            }
        }
        return password;
    }

    /*
     * sets the login
     * if admins can login into user view but a user cannot login to the admin view
     */

    public boolean login(boolean Admin) {
        for (int i = 0; i < 4; i++) {
            System.out.println("What is your username?");
            String username_input = input.nextLine();
            System.out.println("What is your password?");
            String password_input = input.nextLine();

            boolean credentialsMatch = false;
            for (int j = 0; j < actual_usernames().length; j++) {
                if (actual_usernames()[j].equals(username_input) && actual_passwords()[j].equals(password_input)) {
                    credentialsMatch = true;
                    break;
                }
            }

            if (credentialsMatch) {
                if (Admin) {
                    PhoneBookEntry entry = Database.values().stream()
                        .filter(e - > e.getUsername().equals(username.input))
                        .findFirst()
                        .orElse(null);
                    
                    if (entry == null || !entry.getStatus().equalsIgnoreCase("admin")) {
                        System.out.println("Access denied.");
                        return false;
                    }
                }
                return true;
            } else {
                int remaining_tries = 3 - i;
                if (remaining_tries > 0) {
                    System.out.println("Wrong username or password.");
                    System.out.println("You have " + remaining_tries + " tries left.");
                } else {
                    System.out.println("Wrong username or password.");
                    System.out.println("You have used up all your attempts.");
                }
            }
        }
        return false;
    }

    // generates user id based on system time to create an unique userid.
    // TODO we need to make a number of users variable and array where we store the
    // data.

    public int Generate_UserID(int Number_Of_Users, int[] array) {
        int UserID;
        int Temp_UserID;
        boolean Unique;

        do {
            long currentTimeMillis = System.currentTimeMillis();
            Temp_UserID = (int) (currentTimeMillis % 1000000);
            Unique = true;
            UserID = (Temp_UserID * 13 / 7);

            for (int i = 0; i < Number_Of_Users; i++) {
                if (array[i] == UserID) {
                    Unique = false;
                    break;
                }
            }
        } while (!Unique);

        if (Number_Of_Users < array.length) {
            array[Number_Of_Users++] = UserID;
        } else {
            System.out.println("Storage is full.");
        }
        return UserID;
    }

    public int random_num() {
        long currentTimeMillis = System.currentTimeMillis();
        long num = currentTimeMillis % 1000000;
        long output = (num * 13 / 7);
        return (int) output;
    }

    public String user_status(String input_data) {
        String new_input = Clean_String(input_data);
        while (true) {
            if (new_input.equals("admin")) {
                return "admin";
            } else if (new_input.equals("user")) {
                return "user";
            } else {
                System.out.println("Please input either 'admin' or 'user'.");
                new_input = Clean_String(input.nextLine());
            }
        }
    }

    public int zipcode() {
        int zipcode = -1;
        while (true) {
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
        return zipcode;
    }

    public String status(int UserCount, boolean Admin) {
        String status;
        if (UserCount == 0) {
            status = "admin";
        } else if (Admin) {
            System.out.println("Is this going to be an admin or user account? Please enter 'admin' or 'user'.");
            String statusInput = input.nextLine();
            status = user_status(statusInput);
        } else {
            status = "user";
        }
        return status;
    }

    public long phone_number() {
        // Cause some people put phone number data as 123-123-1234 or 123 123 1234
        // instead of 1231231234. We take the input as a string and parse out all non
        // digits
        long phone_number = -1;
        while (true) {
            System.out.println("What is your phone number?");
            String phone_number_string = input.nextLine();
            phone_number_string = phone_number_string.replaceAll("\\D+", "");
            if (!phone_number_string.matches("\\d{10}")) {
                System.out.println(
                        "Please input a valid US phone number which only contains 10 digits without including the area code.");
            } else {
                phone_number = Long.parseLong(phone_number_string);
                break;
            }
        }
        return phone_number;
    }

    public String email() {
        System.out.println("What is your email?");
        String email = input.nextLine();
        return email;
    }

    public String first_name() {
        System.out.println("What is your first name?");
        String first_name = input.nextLine();
        return first_name;
    }

    public String last_name() {
        System.out.println("What is your last name?");
        String last_name = input.nextLine();
        return last_name;
    }

    public void searchForUserID() {
        int[] array = getAllUserIDs();

        MergeSort(array, 0, array.length - 1);
        System.out.println("Enter the ID you would like to search for:");
        int id = input.nextInt();

        if (binarySearchIDs(array, id)) {
            PhoneBookEntry entry = Database.get(id);
            if (entry != null) {
                entry.printBookEntry(true);
            }
        } else {
            System.out.println("No data found for ID: " + id);
        }
    }

    public boolean binarySearchIDs(int[] sortedArray, int id) {
        int left = 0;
        int right = sortedArray.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (sortedArray[mid] == id) {
                return true;
            } else if (sortedArray[mid] < id) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public int[] getAllUserIDs() {
        int[] userIDs = Database.keySet().stream().mapToInt(Integer::intValue).toArray();
        return userIDs;
    }

    // sets up the hashmap and only Admins can input a status otherwise its
    // automatically User.
    public void add_user_data(int UserCount, boolean Admin, boolean new_user) {
        System.out.println("----------------------------------------------------");
        Map<String, Object> userdata = new HashMap<>();
        int ID = random_num();
        PhoneBookEntry entry = new PhoneBookEntry();

        entry.setID(ID);
        entry.setFname(first_name());
        entry.setLname(last_name());
        entry.setEmail(email());
        entry.setZipcode(zipcode());
        entry.setNumber(phone_number());
        entry.setStatus(status(UserCount, Admin));
        if (new_user) {
            entry.setUsername(Set_Username());
            entry.setPassword(Set_Password());
        } else {
            entry.setUsername(" ");
            entry.setPassword(" ");
        }
        Database.put(ID, entry);

        System.out.println("Your Data has been collected under the unique ID: " + ID);
    }

    public void Print_All_Entries(boolean Admin) {
        // int count = 0;
        for (Map.Entry<Integer, PhoneBookEntry> outerEntry : Database.entrySet()) {
            // System.out.println("ID: " + outerEntry.getKey());
            PhoneBookEntry entry = outerEntry.getValue();
            entry.printBookEntry(Admin);
            System.out.println();

            /*
             * Realistically, we should not print every entry and print like 10 and then
             * have a next page and prev page and exit option.
             * count++;
             * if (count == 10) {
             * break;
             * }
             * 
             */
        }
    }

    public int LinearSearchByPhoneNumber(int phoneNumber, boolean Admin) {
        for (PhoneBookEntry entry : Database.values()) {
            if (entry.getNumber() == phoneNumber) {
                System.out.println("Found Entry: ");
                entry.printBookEntry(Admin);
                return 1;
            }
        }
        return 0;
    }

    // This is broken because of the logic I have up above, you cannot press enter
    // to skip for Zipcode and Phone Number.
    public int Edit(String firstName, String lastName) {

        for (Map.Entry<Integer, PhoneBookEntry> entry : Database.entrySet()) {
            PhoneBookEntry phoneBookEntry = entry.getValue();

            if (phoneBookEntry.getFname().equalsIgnoreCase(firstName)
                    && phoneBookEntry.getLname().equalsIgnoreCase(lastName)) {
                System.out.println("For the following options, press enter to skip.");
                System.out.println("------------------------------------------------------------");

                String new_first_name = first_name();
                if (!new_first_name.equals("")) {
                    phoneBookEntry.setFname(new_first_name);
                }

                String new_last_name = last_name();
                if (!new_last_name.equals("")) {
                    phoneBookEntry.setLname(new_last_name);
                }

                String new_email = email();
                if (!new_email.equals("")) {
                    phoneBookEntry.setEmail(new_email);
                }

                int new_zipcode = zipcode();
                if (new_zipcode != -1) {
                    phoneBookEntry.setZipcode(new_zipcode);
                }

                long new_number = phone_number();
                if (new_number != -1) {
                    phoneBookEntry.setNumber(new_number);
                }

                String new_username = Set_Username();
                    if (!new_username.equals("")) {
                    phoneBookEntry.setUsername(new_username);
                }
                String new_password = Set_Password();
                    if (!new_username.equals("")) {
                    phoneBookEntry.setPassword(new_password);
                }
                return 1;

                
            }
        }
        return 0;
    }

    public void Sort_By_ID(boolean Admin) {
        int[] ids = Database.keySet().stream().mapToInt(Integer::intValue).toArray();
        MergeSort(ids, 0, ids.length - 1);

        Map<Integer, PhoneBookEntry> Sorted_Database = new LinkedHashMap<>();
        for (int id : ids) {
            Sorted_Database.put(id, Database.get(id));
        }

        Database = Sorted_Database;

        System.out.println("Entries sorted by ascending ID:");
        for (PhoneBookEntry entry : Database.values()) {
            entry.printBookEntry(Admin);
        }
    }

    public int Delete_by_ID(int ID) {
        if (Database.containsKey(ID)) {
            Database.remove(ID);
            return 1;
        } else {
            return 0;
        }
    }

    public int Delete(String firstName, String lastName) {
        for (Map.Entry<Integer, PhoneBookEntry> entry : Database.entrySet()) {
            PhoneBookEntry phoneBookEntry = entry.getValue();
            if (phoneBookEntry.getFname().equalsIgnoreCase(firstName)
                    && phoneBookEntry.getLname().equalsIgnoreCase(lastName)) {
                System.out.println("Entry found. Deleting the entry for " 
                                + firstName + " " + lastName + ".");
                Database.remove(entry.getKey());
                return 1; 
            }
        }
        System.out.println("No matching entry found for " + firstName + " " + lastName + ".");
        return 0; 
    }

    public void Register(int UserCount) {
        System.out.println("Registration");
        System.out.println("---------------------------------------------");

        boolean isAdmin = (UserCount == 0); 
        add_user_data(UserCount, isAdmin, true); 

        System.out.println("You are now in the system.");
    }

}
