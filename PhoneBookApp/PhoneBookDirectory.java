import lib.*;
import java.util.*;


public class PhoneBookDirectory {

    private static Scanner input = new Scanner(System.in);
    private static int UserCount = 0;
    private static Methods methods = new Methods();

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
            entry.setUsername("");
            entry.setPassword("");
        }
        Database.put(ID, entry);

        System.out.println("Your Data has been collected under the unique ID: " + ID);

    }




}
