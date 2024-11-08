import java.util.Scanner;

public class Exercise9{
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        System.out.println("What word or phrase would you like to input?");
        String a = input.nextLine();
        System.out.println("That phrase " + method(a) + " a palindrome");
        input.close(); 
    }

    public static String method(String a){
        String b = a.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        for(int i = 0 ; i < b.length(); i++){
            if(b.charAt(i) != b.charAt(b.length()- 1 - i)){
            return "is not";
            }
        }
        return "is";
    }
}