import java.util.Scanner;

public class Exercise3{
    public static void main (String [] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("What is the radius of your circle?");
        double radius = input.nextDouble();
        System.out.println("The area of your circle is: " + area(radius));
        input.close();
    }

    public static double area(double radius){
        double pi = 22.0/7.0;
        System.out.println(pi);
        System.out.println(radius_squared);
        return area;
    }
}