package lib;
import java.util.*;


public class CarAppEntry {
    private String carName;  
    private String carMake;
    private double carPrice;


    public CarAppEntry() {
        carName = "";
        carMake = "";
        carPrice = 0.0;
    }

    public CarAppEntry(String carName, String carMake, double carPrice) {
        this.carName = carName;
        this.carMake = carMake;
        this.carPrice = carPrice;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(double carPrice) {
        this.carPrice = carPrice;
    }

    public void CarAppEntry(){
        System.out.println();
        System.out.println("The Car Name is: " + this.carName);
        System.out.println("The Car Make is: " + this.carMake);
        System.out.println("The Car Price is: " + this.carPrice);
        System.out.println();
    }
}