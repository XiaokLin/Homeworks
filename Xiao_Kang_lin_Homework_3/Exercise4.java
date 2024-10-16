import java.util.Scanner;

public class Exercise4{
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        String first = "";
        String second = "";
        String commonality = "";
        System.out.println("Enter First String: ");
        first = input.nextLine();
        System.out.println("Enter Second String: ");
        second = input.nextLine();
        int minLength = Math.min(first.length(), second.length());
        for (int i = 0; i < minLength; i++) {
            if (first.charAt(i) == second.charAt(i)) {
                commonality += first.charAt(i);
            } 
            else {
            break;
            }
        }
        if (!commonality.isEmpty()){
        System.out.println("The common prefix is: " + commonality);
        }
        else 
        {
        System.out.println(first + " and " + second + " have no common prefix.");
        }
        input.close();
    }
}