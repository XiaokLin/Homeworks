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

    public void Print_All_Entries(boolean Admin) {
        // int count = 0;
        for (Map.Entry<Integer, PhoneBookEntry> outerEntry : Database.entrySet()) {
            // System.out.println("ID: " + outerEntry.getKey());
            PhoneBookEntry entry = outerEntry.getValue();
            entry.printBookEntry(Admin);
            System.out.println();
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

                Database.put(entry.getKey(), phoneBookEntry);
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

    public int Delete(int ID) {
        if (Database.containsKey(ID)) {
            Database.remove(ID);
            return 1;
        } else {
            return 0;
        }
    }



}
