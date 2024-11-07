import java.util.Scanner;

public class Exercise1{
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int i = 0;
        double balance = 0;
        System.out.println("Thank You For Choosing Our ATM.");

        do {
            System.out.println("Please Choose An Option Below.");
            System.out.println("1. View Your Account Balance.");
            System.out.println("2. Deposit Cash.");
            System.out.println("3. Withdraw Cash.");
            System.out.println("4. Exit.");
            String response = input.nextLine().toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

            if (response.equals("1") || response.equals("1viewyouraccountbalance") || response.equals("viewyouraccountbalance")){
                System.out.println("Your Current Balance Is" + balance);
            } else if (response.equals("2") || response.equals("2depositcash") || response.equals("despositcash")){
                balance = deposit(balance);
            } else if (response.equals("3") || response.equals("3withdrawcash") || response.equals("withdrawcash")){
                balance = withdraw(balance);
            } else if (response.equals("4") || response.equals("4exit") || response.equals("exit")){
                i = 1;
            } else {
                System.out.println("Please Only Input Things Listed Above.");
            }

        } while (i != 1);

        System.out.println("Thank You! Have A Great Day!");
        input.close();
    }
    public static double withdraw(double balance){
        System.out.println("Your Current Balance Is: " + balance);
        System.out.println("How Much Would You Like To Deposit?");
        Scanner input = new Scanner(System.in);
        double a = input.nextDouble();

        if (a < 0) {
            System.out.println("Please Do Not Enter A Negative Value.");
        } else {
            balance -= a;
            System.out.println("Your New Balance Is: " + balance);
        }

        return balance;
    }

    public static double deposit(double balance){
        System.out.println("Your Current Balance Is: " + balance);
        System.out.println("How Much Would You Like To Withdraw?");
        Scanner input = new Scanner(System.in);
        double a = input.nextDouble();

        if (a < 0 || a > balance){
            System.out.println("Please Do Not Enter A Negative Value Or A Value Larger Than: " + balance);
        } else {
            balance += a;
            System.out.println("Your New Balance Is: " + balance);
        }

        return balance;
    }
}