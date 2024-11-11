import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double balance = 0.00;
        boolean choices = true;
        String user_input;
        double deposit_amount = 0.00;
        double withdraw_amount = 0.00;
        String user_input2;

        while (choices) {
            System.out.println("1. View Balance");
            System.out.println("2. Deposit Cash");
            System.out.println("3. Withdraw Cash");
            System.out.println("4. Exit");

            user_input = input.nextLine();

            switch (user_input) {
                case "1":
                case "View Balance":
                case "1. View Balance":
                    System.out.println("Your current Balance is: " + balance);
                    break;

                case "2":
                case "2. Deposit Cash":
                case "Deposit Cash":
                    System.out.println("Enter Deposit Amount: ");
                    deposit_amount = input.nextDouble();
                    input.nextLine();
                    if (deposit_amount >= 0) {
                        balance += deposit_amount;
                        System.out.println("You have deposited: " + deposit_amount);
                    } else {
                        System.out.println("Invalid amount, please do not enter a negative amount.");
                    }
                    break;

                case "3": 
                case "3. Withdraw Cash":
                case "Withdraw Cash":
                    System.out.println("Your current balance is: " + balance);
                    System.out.println("Enter Withdrawal Amount: ");
                    withdraw_amount = input.nextDouble();
                    input.nextLine();
                    if (withdraw_amount >=0){
	                    if (withdraw_amount <= balance) {
	                        balance -= withdraw_amount;
	                        System.out.println("You have withdrawn: " + withdraw_amount);
	                    }
	                    else {
	                        System.out.println("You do not have enough money.");
	                    }
	                }
	                else {
	                	System.out.println("Invalid amount, please do not enter a negative amount.");
	                }
                    break;

                case "4":
                case "4. Exit":
                case "Exit":
                    System.out.println("Thank you.");
                    choices = false;
                    break;

                default:
                    System.out.println("Please enter either a number or the text shown below.");
                    break;
            }

            if (choices) {
                System.out.println("Press any key to continue. Type 'no' to exit.");
                user_input2 = input.nextLine();
                if (user_input2.equalsIgnoreCase("no")) {
                    choices = false;
                    System.out.println("Goodbye.");
                }
            }
        }
        input.close();
    }
}
