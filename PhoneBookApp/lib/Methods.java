/*
Its good pratice to keep methods that you can repeatly use in a seperate file which all your code can use.
You can access this here by doing "import PhoneBookApp.Methods;" and then calling the function like normal like here:"Methods.BinarySearch(array, 0, 0, 1)"
*/
package lib;
import java.util.*;

public class Methods{
    Scanner input = new Scanner(System.in);
/*
Instead of doing i++, I have this just looping until it finds the output.
Do note that this is bad pratice if the dataset is huge, but overall this should be the default way of making binary search if the dataset isnt big.
If the dataset is huge, you should do the i++ thing and have a limit for i. 
It just gets the min value, max value and splits it and looks for the input value value on loop until it finds it or throws an -1 which means it doesnt exist. 
*/

    public static int BinarySearch(int [] array, int input_value, int min_value, int max_value){
        if (min_value > max_value){
            return -1;
        }

        int mid_value = min_value + (max_value - min_value)/2;

        if(array[mid_value] == input_value) {
            return mid_value;

        }   else if (array[mid_value] < input_value) {
            return BinarySearch(array, input_value, mid_value + 1, max_value);

        }   else {
            return BinarySearch(array, input_value, min_value, mid_value - 1);
        }
    }

/*
Standard linear search, nothing to write home about. 
*/

    public static int LinearSearch(int [] array, int input_value){
        for (int i = 0; i < array.length; i++){
            if (input_value == array[i]){
                return i;
            }
        }
        return -1;
    }

/*
Standard Merge Sort. Basicially it divides the dataset into smaller parts and sorts it and merges it back.
When in doubt, Id say use this due to its time efficiency. 
*/
    public static void MergeSort(int [] array, int array1, int array2){
        if (array1 < array2){
            int mid_value = array1 + (array2 - array1)/2;
            MergeSort(array, array1, mid_value);
            MergeSort(array, mid_value + 1, array2);

            Merge(array, array1, mid_value, array2);
        }
    }

    public static void Merge(int [] array, int array1, int mid_value, int array2){
        int array1_size = mid_value - array1 + 1;
        int array2_size = array2 - mid_value; 
        int[] temp_array1 = new int[array1_size];
        int[] temp_array2 = new int[array2_size];

        for (int i=0; i<array1_size; i++){
            temp_array1[i] = array[array1 + i];
        }
        for (int i=0;i<array2_size; i++){
            temp_array2[i] = array[mid_value + 1 + i];
        }

        int a=0;
        int b=0;
        int c=array1;

        while (a < array1_size && b < array2_size) {
            if (temp_array1[a] <= temp_array2[b]) {
                array[c] = temp_array1[a];
                a++;
            }   else {
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

//Removes all non letters and numbers like spaces and symbols and makes everything lowercase. 
    public static String Clean_String(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        return input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

// Sets and Changes Username 
    public String Set_Username(){
        String username = null;
        while (username == null) {
                System.out.println("What would you like to input as your username?");
                String new_username = input.nextLine();
                System.out.println("Would you like " + new_username + " to be your username?");
                System.out.println("Yes or No?");
                String temp_input1 = input.nextLine();
                if (Clean_String(temp_input1).equals("yes")){
                    username = new_username;
                    System.out.println("Your username has been set.");
                }  else if (Clean_String(temp_input1).equals("no")){
                    System.out.println("Your password has been set.");
                }  else {
                    System.out.println("Please only input yes or no.");
                }
        }
        return username;
    }

//Sets and Changes Password
    public String Set_Password(){
        String password = null;
        while (password == null){
                System.out.println("What would you like to input as your password?");
                String new_password = input.nextLine();
                System.out.println("Would you like " + new_password + " to be your password?");
                System.out.println("Yes or No?");
                String temp_input1 = input.nextLine();
                if (Clean_String(temp_input1).equals("yes")){
                    password = new_password;
                    System.out.println("Your password has been set.");
                }  else if (Clean_String(temp_input1).equals("no")){
                    System.out.println("Lets try again.");
                }  else {
                    System.out.println("Please only input yes or no.");
                }
        }
        return password;
    }

// sets the login
    public void login(String actual_username, String actual_password){
        for (int i=0; i<4; i++){
            System.out.println("What is your username?");
            String username_input = input.nextLine();
            System.out.println("What is your password?");
            String password_input = input.nextLine();
            if (actual_username.equals(username_input) && actual_password.equals(password_input)){
                break;
            }
            else {
                int remaining_tries = 3-i;
                if (remaining_tries > 0){
                    System.out.println("Wrong username or password.");
                    System.out.println("You have " + remaining_tries + " tries left before the database gets deleted.");
                } else {
                    System.out.println("Wrong username or password.");
                    System.out.println("You have used up all your attemps. The database will be deleted.");
                    System.exit(0);
                }
            }
        }
    }
// generates user id based on system time to create an unique userid. 
// TODO we need to make a number of users variable and array where we store the data. 

    public int Generate_UserID(int Number_Of_Users, int [] array) {
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
}