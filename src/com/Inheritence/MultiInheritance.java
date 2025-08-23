package com.Inheritence;

class Car extends Vechile {
    private int noOfDoors;

    public int getNoOfDoors() {
        return noOfDoors;
    }

    public void setNoOfDoors(int noOfDoors) {
        this.noOfDoors = noOfDoors;
    }

    public Car(String brand, int speed, int noOfDoors) {
        super(brand, speed);
        this.noOfDoors = noOfDoors;
    }
    public void start() {
        System.out.println("Starting......");
    }
    public void playMusic(){
        System.out.println("Playing Music.....");
    }
    public void displayInfo(){
        System.out.println("Brand " + getBrand()+" speed "+ getSpeed() +" Number of Doors " + getNoOfDoors() );
    }
}
class Truck extends Vechile {
    private int loadCapacity;

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public Truck(String brand, int speed, int loadCapacity) {
        super(brand, speed);
        this.loadCapacity = loadCapacity;
    }
    public void loadCapacity(int loadCapacity){
        System.out.println("The Load Capacity is "+ loadCapacity);
    }
    public void displayInfo(){
        System.out.println("Brand " + getBrand()+" speed "+ getSpeed() +" Load capacity " + loadCapacity );
    }
}
public class MultiInheritance{
    public static void main(String[] args) {
        Car c1 = new Car("Maruti", 100,4);
        c1.displayInfo();
        Truck t1 = new Truck("supera" , 80 , 10000);
        t1.displayInfo();

    }
}
