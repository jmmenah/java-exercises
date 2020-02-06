//package downcasting;
 
public class Demo2 {
    public static void main(String[] args) {
        Bike b = new Bike("10 Litres", "180 km/hr", "Harley-Davidson");
        // First up-cast an object to a super class type.
        Machine m = b;
        // Down-casting is explicit.
        Vehicle v = (Vehicle)m;
        System.out.println("Vehicle's Fuel-capacity : " + v.fuelCapacity);
        System.out.println("Vehicle's Max-Speed \t: " + v.speed);
        System.out.println();
        /*  v can be further down casted to Bike because originally the
            object is of type bike, even though it is referenced by a
            super class reference variable.
         */
        Bike bike = (Bike)v;
        System.out.println("Bike's Fuel-capacity: " + bike.fuelCapacity);
        System.out.println("Bike's Max-speed \t: " + bike.speed);
        System.out.println("Bike's Manufacturer : " + bike.manufacturer);
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
 
class Vehicle extends Machine {
    String speed;
    public Vehicle(String fuelCapacity, String speed) {
        super(fuelCapacity);
        this.speed = speed;
    }
    public String getSpeed() {
        return speed;
    }
}
 
class Bike extends Vehicle {
    String manufacturer;
    public Bike(String fuelCapacity, String speed, String manufacturer) {
        super(fuelCapacity, speed);
        this.manufacturer = manufacturer;
    }
    public String getManufacturer() {
        return manufacturer;
    }
}
