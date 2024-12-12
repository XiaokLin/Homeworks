package lib;
import java.util.*;

public class Methods{
    private Scanner input = new Scanner(System.in);
    private ArrayList<CarAppEntry> entries = new ArrayList<>();


    public int Interface(){
        System.out.println("What would you like to do?");
        System.out.println("1. Add an entry");
        System.out.println("2. Print all entries");
        System.out.println("3. Edit an entry");
        System.out.println("4. Delete an entry");
        System.out.println("5. Exit");
        System.out.println();

        int choice = input.nextInt();
        input.nextLine(); //Code breaks without this...
        return choice;
    }

    public void addEntry() {
        System.out.println("Enter car name: ");
        String name = input.nextLine();
        System.out.println("Enter car make: ");
        String make = input.nextLine();
        System.out.println("Enter car price: ");
        double price = input.nextDouble();
        System.out.println();
        input.nextLine();
        entries.add(new CarAppEntry(name, make, price));

        System.out.println("Car entry added");
    }

    public void printAllEntries() {
        if (entries.isEmpty()) {
            System.out.println("No entries found.");
            return;
        }

        System.out.println("Car Entries:");
        for (int i = 0; i < entries.size(); i++) {
            System.out.println("Entry Number: " + (i + 1));
            entries.get(i).CarAppEntry(); 
        }
    }

    public void editEntry() {
        if (entries.isEmpty()) {
            System.out.println("Please input an entry first.");
            return;
        }
        System.out.println("Enter the car name you want to edit: ");
        String name = input.nextLine();
        System.out.println("Enter the car make you want to edit: ");
        String make = input.nextLine();
        CarAppEntry carToEdit = null;
        for (CarAppEntry car : entries) {
            if (car.getCarName().equalsIgnoreCase(name) && car.getCarMake().equalsIgnoreCase(make)) {
                carToEdit = car;
                break;
            }
        }
        if (carToEdit == null) {
            System.out.println("No matching car entry found.");
            return;
        }

        carToEdit.CarAppEntry();
        System.out.println("Enter new car name: ");
        String newName = input.nextLine();
        carToEdit.setCarName(newName);

        System.out.println("Enter new car make: ");
        String newMake = input.nextLine();
        carToEdit.setCarMake(newMake);

        System.out.println("Enter new car price: ");
        double priceInput = input.nextDouble();
        carToEdit.setCarPrice(priceInput);

        System.out.println("Car entry updated");
    }

    public void deleteEntry() {
        if (entries.isEmpty()) {
            System.out.println("Please input an entry first.");
            return;
        }

        System.out.println("Enter the car name you want to delete: ");
        String nameToDelete = input.nextLine();

        System.out.println("Enter the car make you want to delete: ");
        String makeToDelete = input.nextLine();

        CarAppEntry carToDelete = null;

        for (CarAppEntry car : entries) {
            if (car.getCarName().equalsIgnoreCase(nameToDelete) && car.getCarMake().equalsIgnoreCase(makeToDelete)) {
                carToDelete = car;
                break;
            }
        }

        if (carToDelete == null) {
            System.out.println("No matching car entry found.");
            return;
        }

        entries.remove(carToDelete);
        System.out.println("Car entry deleted");
    }
}