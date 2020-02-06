// Upcasting and Downcasting in Java
// https://codeprime.org/java-tutorials/inheritance-in-java/upcasting-and-downcasting-in-java/

/*
 *  Upcasting
 *  Casting a subclass type to a superclass type in the inheritance tree
 * 
 *  Upcasting is implicit i.e it is handled automatically by the compiler. 
 *  You don’t have to explicitly cast a sub class type to a super class type. 
 *
 */

public class Demo1 {
    public static void main(String[] args){
        Bike b = new Bike("10 Litres", "180 km/hr", "Harley-Davidson");
        System.out.println("Bike's Fuel-capacity: " + b.fuelCapacity);
        System.out.println("Bike's Max-speed \t: " + b.speed);
        System.out.println("Bike's Manufacturer : " + b.manufacturer);
        System.out.println();
        // Since Vehicle is a super class of Bike, following assignment is ok.
        /*  You don't need to use casting like v = (Vehicle)b;
            it is handled automatically by the compiler
        */
        Vehicle v  = b;
        System.out.println("Vehicle's Fuel-capacity : " + v.fuelCapacity);
        System.out.println("Vehicle's Max-Speed \t: " + v.speed);
        /*  Vehicle has access to members of its own class and its super
            classes only. So uncommenting the line below would cause
            compilation error.
        */
        // System.out.println("Vehicle's Manufacturer : \t" + v.manufacturer);
        System.out.println();
 
        // Similarly, the following assignments work fine.
        Machine m = b;
        System.out.println("Machine's Fuel-capacity : " + m.fuelCapacity);
        /*  Machine has access to members of its own class and its super
            classes only. So uncommenting the two lines below would cause
            compilation error.
        */
        // System.out.println("Machine's speed : \t" + m.speed);
        // System.out.println("Machine's Manufacturer : \t" + m.manufacturer);
        System.out.println();
 
        Object o = b;
        /*  Object has access to members of its own class and its super
            classes only. So uncommenting the three lines below would cause
            compilation error.
        */
        // System.out.println("Object's fuel-capacity : " + o.fuelCapacity);
        // System.out.println("Object's speed : \t" + o.speed);
        // System.out.println("Object's Manufacturer : \t" + o.manufacturer);
    }
}
 
// No extends keyword. So Machine class extends Object class by default
class Machine{
    String fuelCapacity;
    public Machine(String fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }
    public String getFuelCapacity() {
        return fuelCapacity;
    }
}
 
class Vehicle extends Machine{
    String speed;
    public Vehicle(String fuelCapacity, String speed) {
        super(fuelCapacity);
        this.speed = speed;
    }
    public String getSpeed() {
        return speed;
    }
}
 
class Bike extends Vehicle{
    String manufacturer;
    public Bike(String fuelCapacity, String speed, String manufacturer) {
        super(fuelCapacity, speed);
        this.manufacturer = manufacturer;
    }
    public String getManufacturer() {
        return manufacturer;
    }
}
