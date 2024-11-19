package Car_App;
import java.util.Scanner;
public class CarMngApp {
	
	static Car [] MyInventory = new Car [10]; // make an array of type 'car', 10 of them
	static int carCount = 0; 
	static Scanner input = new Scanner(System.in);


	public static void main(String[] args) {
		// create an array of cars
		
		
		int c;
		
		do {
		c = CarMngApp.Menu(); // call menu method
		
		switch (c) {
			case 1:
				CarMngApp.addCarOption(); 
				break;
			case 2:
				CarMngApp.editCarOption(); 
				break;
			case 3:
				// these methods are already in car class
				CarMngApp.setToFixedOption(); 
				break;
			case 4:
				// print array
				CarMngApp.displayAllCarsOption(); 
				break;
			case 5:
				// bella's method
				CarMngApp.deleteCarOption(); 
				break;
			case 6:
				CarMngApp.displayAllCarsServiceExceedOption(); 
				break;
			case 7:
				CarMngApp.displayProfitOption();
				break;
			case 8: 
				CarMngApp.setToUnfixedOption(); 
				break; 
			case 9: 
				System.out.println("Have a nice day!");
				break;
			default:
				System.out.println("That number isn't a valid option.");
				break;
		
		} 
		
		} while (c!= 9); // while not Exit
		
			// create 2 methods
			// 1st: check if array is full
			
			// 2nd: create a new car
			// ask the user to enter name, id, etc... 
			//MyInventory[0] = new Car("new", 991, false, 100);
		
		input.close(); // close scanner 


		} 
		

	
	
	// create method Menu (to take in user choice) 
	public static int Menu () {
		System.out.println("(1) Add a Car");
		System.out.println("(2) Edit a Car");
		System.out.println("(3) Set a Specific Car to “FIXED” ");
		System.out.println("(4) Display All Cars in Inventory");
		System.out.println("(5) Delete a Car by ID");
		System.out.println("(6) Display All Cars with Service Costs Exceeding a Specified Price");
		System.out.println("(7) Display Expected Profit from Fixing All Cars");
		System.out.println("(8) Set a Specific Car to 'UNFIXED'"); 
		System.out.println("(9) Exit");
		System.out.println();
		
		System.out.println("Choose an option: ");
		int choice = input.nextInt();
		
		System.out.println(); 
		
		return choice; 
		
		
	}
	

	public static void addCarOption() {
		if (carCount >= MyInventory.length) {
            System.out.println("Inventory is full.");
            return; 
            
		} 
		
		// Clear any leftover input
	    if (input.hasNextLine()) {
	        input.nextLine();
	    }
		// else
		System.out.println("Enter Car Name: ");
		String n = input.nextLine();
		
		System.out.println("Enter Car ID: ");
		int id = input.nextInt(); 
		input.nextLine(); // consume the leftover
		
		System.out.println("Is this car FIXED? (yes/no) : ");
		String statusString = input.nextLine();
		boolean statusBool = false;
		if (statusString.contentEquals("yes")) {
			statusBool = true;
		}
			
		System.out.println("Enter Car's Service Fee: ");
		double sfee = input.nextDouble(); 
		input.nextLine(); // consume leftover 
		
		// create, add to the array
		MyInventory[carCount]= new Car(n, id, statusBool, sfee);
		//MyInventory[carCount] = newCar; 
		carCount++;
		
		System.out.print("Car added!");
		System.out.println("\n");
		
		
	}
	
	public static void editCarOption() {
		// catch if there's no cars
		if (carCount == 0) {
			System.out.println("There are no cars to edit, add a car first.");
			System.out.println(); 
			return; 
		}
		
		// ask for the unique ID
		System.out.print("Enter Car's unique ID: ");
		int carID = input.nextInt();
		
		// find car
		Car carToEdit = null; 
		for (int i = 0; i < carCount; i++) {
			if (MyInventory[i].getCar_ID() == carID) {
				carToEdit = MyInventory[i];
			}
		}
		
        // If no car is found
        if (carToEdit == null) {
            System.out.println("Car with ID " + carID + " not found.");
        
        }
				
		// ask user what they want to edit
        System.out.println("What do you want to edit?");
        System.out.println("1. Name");
        System.out.println("2. ID");
        System.out.println("3. Status");
        System.out.println("4. Service Fee");
        System.out.print("Enter your choice: ");
        int choice = input.nextInt();	
        
     // Clear any leftover input
        if (input.hasNextLine()) {
            input.nextLine();
        }
        // switch statement
        switch (choice) {
        

	        case 1: 
	            System.out.print("Enter new name: ");
	            String newName = input.nextLine();
	            carToEdit.setCar_name(newName); // Example: setting "make" as the name
	            System.out.println("Name updated to " + newName);
	            break;
	        case 2:
	            System.out.print("Enter new ID: ");
	            int newID = input.nextInt();
	            carToEdit.setCar_ID(newID);
	            System.out.println("ID updated to "+ newID);
	            break;
	        case 3: 
                System.out.print("Enter new status (FIXED/UNFIXED): ");
                String newStatus = input.next();
                if (newStatus.contentEquals("FIXED")) {
                	carToEdit.setStatus(true);
                } else {
                	carToEdit.setStatus(false);
                }
                
                System.out.println("Status updated to " + newStatus);
                break;
            case 4: 
                System.out.print("Enter new service fee: ");
                double newFee = input.nextDouble();
                carToEdit.setServiceFee(newFee);
                System.out.println("Service fee updated successfully.");
                break;
            default: 
            	System.out.println("That's not an option.");
            	break;
            
        }
        

	}
	
	public static void setToFixedOption() {
		// ask which car (get ID)
		System.out.print("Enter Car's unique ID: ");
		int carID = input.nextInt();
		
		// find car
		Car carToEdit = null; 
		for (int i = 0; i < carCount; i++) {
			if (MyInventory[i].getCar_ID() == carID) {
				carToEdit = MyInventory[i];
			}
		}
		
        // If no car is found
        if (carToEdit == null) {
            System.out.println("Car with ID " + carID + " not found.");
            return;
        }
        
        // change it to FIXED
		carToEdit.setStatus(true); 
    
        System.out.println("Car status has been changed to FIXED. ");
        return; 
		
	}
	
	public static void displayAllCarsOption () {
		// from carCount, figure out how many cars we have
		System.out.println("You currently have " + carCount + " cars in your system.");
		System.out.println(); 
		for (int i = 0; i < carCount; i++) {
			Car printCar = MyInventory[i];
			MyInventory[i].print();
			System.out.println(); 
			
		}
		
		System.out.println("These are all the cars. ");
		System.out.println(); 

		
	} 
	
	public static void deleteCarOption() {
		// ask which car ID they want to delete
		System.out.print("Enter Car's unique ID: ");
		int carID = input.nextInt();
	    input.nextLine(); // Consume leftover newline
	    
		// find car
		int indexToDelete = -1; 
		for (int i = 0; i < carCount; i++) {
			if (MyInventory[i].getCar_ID() == carID) {
				indexToDelete = i;
				break;
			}
		}
		
        // If no car is found
        if (indexToDelete == -1) {
            System.out.println("Car with ID " + carID + " not found.");
            return;
        }
		
		// 'delete' the car
        for (int j = indexToDelete; j < carCount-1; j++) {
        	// shift them
        	MyInventory[j] = MyInventory[j+1]; // shift cars to left
        	
        }
        
        MyInventory[carCount-1] = null; // remove extra
        carCount--; // 'delete' a count
        System.out.println("Car with ID " + carID + " has been deleted.");

		
	} 
	
	public static void displayAllCarsServiceExceedOption() {
		// ask them for x amount serviceFee
		System.out.println("Enter the Service Fee: ");
		double exceedServiceFee = input.nextDouble(); 
		
		for (int i = 0; i < carCount; i++) {
			// get serviceFee, check
			Car checkCar = MyInventory[i];
			if (checkCar.getServiceFee() >= exceedServiceFee) {
				// its greater than or equal
				MyInventory[i].print(); 
				
			}
			
		System.out.println(); 
			
			
			
		}
		
		System.out.println("Here are the cars that have exceeded the service fee of " + exceedServiceFee);
		
		
	} 
	
	public static void displayProfitOption() {
		// we have to calculate the profits of all cars in garage
		
		double totalProfit = 0.0;
		
		for (int i = 0; i < carCount; i++) {
	        Car tempCar = MyInventory[i];
	        totalProfit += tempCar.getServiceFee();
	    }
		
		System.out.println("The total profit calculated profit is $" + totalProfit);
		System.out.println(); 
		
	}
	
	// no. 8
	public static void setToUnfixedOption() {
		// ask which car (get ID)
		System.out.print("Enter Car's unique ID: ");
		int carID = input.nextInt();
				
		// find car
		Car carToEdit = null; 
		for (int i = 0; i < carCount; i++) {
			if (MyInventory[i].getCar_ID() == carID) {
				carToEdit = MyInventory[i];
			}
		}
		
        // If no car is found
        if (carToEdit == null) {
            System.out.println("Car with ID " + carID + " not found.");
            return;
        }
        

		carToEdit.setStatus(false);
		System.out.println("Car status has been changed to UNFIXED."); 
		System.out.println(); 
		return;
        
         
	}
		
}	
	
	
	
	
