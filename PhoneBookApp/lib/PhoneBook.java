import lib.*;
import java.util.*;

public class PhoneBook {

	public static void main(String[] args) {

		 PhoneBookEntry entry1 = new PhoneBookEntry(5, "John", "Smith", "jsmith@gmail.edu", 20037, 2023334444, "Admin", "username", "password");


	        // Second Object: James, 202344344
	        PhoneBookEntry entry2 = new PhoneBookEntry("James", 202344344);


	        // Third Object: Sarah
	        // For Sarah, we only have a name. We'll use the default constructor and then set her first name.

	        PhoneBookEntry entry3 = new PhoneBookEntry();

	        entry3.setFname("Sarah");



	        // 1. Change the phone number of John Smith to 202555555

	        // Using the setter on entry1 (John Smith)

	        entry1.setNumber(202555555);



	        // 2. Print the attributes of John Smith using the method PrintBookEntry().

	        // This will print all details of entry1

	        entry1.printBookEntry(false);



	        // 3. Assign the Zipcode of John Smith to James’s zip code

	        // Get John Smith's zip code and set it to James

	        int johnZip = entry1.getZipcode();

	        entry2.setZipcode(johnZip);



	        // Print out James's entry

	        entry2.printBookEntry(false);

	}
}