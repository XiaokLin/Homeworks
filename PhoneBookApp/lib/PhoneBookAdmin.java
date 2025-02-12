package lib;

public class PhoneBookAdmin extends User {

    public void menu() {

        boolean exit = true;

        while (exit) {
            System.out.println("Admin Menu:");
            System.out.println("1. Add an entry");
            System.out.println("2. Edit an entry");
            System.out.println("3. Delete an entry");
            System.out.println("4. Sort by ID");
            System.out.println("5. Search by ID");
            System.out.println("6. Search by phone number");
            System.out.println("7. Print all entries");
            System.out.println("8. Delete an entry by First and Last Name");
            System.out.println("9. Exit to main menu");

            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    Add_Entry(true);
                    break;
                case "2":
                    System.out.println("Enter the first name of the entry to edit:");
                    String fname = input.nextLine();
                    System.out.println("Enter the last name of the entry to edit:");
                    String lname = input.nextLine();
                    int edit_data = methods.Edit(fname, lname);
                    if (edit_data == 1) {
                        System.out.println("Your data has been edited properly.");
                    }   else {
                        System.out.println("No entry was found with the first and last name you entered.");
                    }   
                    break;
                case "3":
                    System.out.println("Enter the ID of the entry to delete:");
                    int ID = Integer.parseInt(input.nextLine());
                    if (methods.Delete_by_ID(ID) == 1){
                        System.out.println("The entry has been deleted.");
                    }   else{
                        System.out.println("The entry was not found.");
                    }  
                    break;
                case "4":
                    Sort_Entry(true);
                    break;
                case "5":
                    methods.searchForUserID();
                    break;
                case "6":
                    LinearSearchByPhoneNumber(true);
                    break;
                case "7":
                    Print_All_entries(true);
                    break;
                case "8":
                    System.out.println("Enter the first name of the entry to edit:");
                    String firstname = input.nextLine();
                    System.out.println("Enter the last name of the entry to edit:");
                    String lastname = input.nextLine();
                    int delete_data = methods.Delete(firstname, lastname);
                    if (delete_data == 1) {
                        System.out.println("Your data has been edited properly.");
                    }   else {
                        System.out.println("No entry was found with the first and last name you entered.");
                    }   
                    break;
                case "9":
                    exit = false;
                    break;
                default:
                    System.out.println("Please only input an integer 1-9.");
            }
        }
    }
}
