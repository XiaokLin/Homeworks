package lib;

public class NormalUser {

    public void menu() {
        boolean exit = true;

        while (exit) {
            System.out.println("User Menu:");
            System.out.println("1. Add an entry");
            System.out.println("2. Sort by ID");
            System.out.println("3. Search by phone number");
            System.out.println("4. Print all entries");
            System.out.println("5. Exit to main menu");

            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    Add_Entry(false);
                    break;
                case "2":
                    Sort_By_ID();
                    break;
                case "3":
                    LinearSearchByPhoneNumber();
                    break;
                case "4":
                    Print_All_entries();
                    break;
                case "5":
                    exit = false;
                    break;
                default:
                    System.out.println("Please only input an integer 1-5.");
            }
        }
    }
}