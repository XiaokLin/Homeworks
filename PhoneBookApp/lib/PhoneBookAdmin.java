package lib;

public class PhoneBookAdmin extends Interface {

    public void menu() {

        boolean exit = true;

        while (exit) {
            System.out.println("Admin Menu:");
            System.out.println("1. Add an entry");
            System.out.println("2. Edit an entry");
            System.out.println("3. Delete an entry");
            System.out.println("4. Sort by ID");
            System.out.println("5. Search by phone number");
            System.out.println("6. Print all entries");
            System.out.println("7. Exit to main menu");

            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    Add_Entry(true);
                    break;
                case "2":
                    System.out.println("Enter the first and last name of the entry to edit:");
                    String fname = input.nextLine();
                    String lname = input.nextLine();
                    int edit_data = methods.Edit(fname, lname);
                    if (edit_data = 1) {
                        System.out.println("Your data has been edited properly.");
                    }   else {
                        System.out.println("No entry was found with the first and last name you entered.")
                    }
                    break;
                case "3":
                    System.out.println("Enter the ID of the entry to delete:");
                    int ID = Integer.parseInt(input.nextLine());
                    if (methods.Delete(ID) == 1){
                        System.out.println("The entry has been deleted.");
                    }   else{
                        System.out.println("The entry was not found.")
                    }
                    break;
                case "4":
                    Sort_By_ID();
                    break;
                case "5":
                    LinearSearchByPhoneNumber();
                    break;
                case "6":
                    Print_All_entries();
                    break;
                case "7":
                    exit = false;
                    break;
                default:
                    System.out.println("Please only input an integer 1-7.");
            }
        }
    }
}
