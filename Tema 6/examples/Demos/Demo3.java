//package instance;
public class Demo3 {
    /*  We can mix instanceof operator with down-casting to realize the
        run-time polymorphism.
    */
    public static void getInfo(Machine m){
        if(m instanceof Bike){
            System.out.println("Bike Manufacturer: " + ((Bike) m).manufacturer);
        }else if(m instanceof Car){
            System.out.println("Car type: " + ((Car) m).type);
        } else if(m instanceof Truck){
            System.out.println("Truck Capacity: " + ((Truck) m).loadCapacity);
        } else{
            System.out.println("Cool machine!");
        }
    }
    public static void main(String[] args){
        Bike b = new Bike("10 Litres", "180 km/hr", "Harley-Davidson");
        Car c = new Car("120 Litres", "220 km/hr", "SUV");
        Truck t = new Truck("200 Litres", "120 km/hr", "20 Metric Tonnes");
        Vehicle v = new Vehicle("20 Litres", "50 km/hr");
        //  See how a single method can take objects of different class types.
        /*  To do this, formal parameter of the method is declared as a
            super class type and within the method body we use down-casting
            to get the full potential of the original object.
        */
        getInfo(b);
        getInfo(c);
        getInfo(t);
        getInfo(v);
    }
}
 
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
class Car extends Vehicle{
    String type;
    public Car(String fuelCapacity, String speed, String type) {
        super(fuelCapacity, speed);
        this.type = type;
    }
    public String getType() {
        return type;
    }
}
 
class Truck extends Vehicle{
    String loadCapacity;
    public Truck(String fuelCapacity, String speed, String loadCapacity) {
        super(fuelCapacity, speed);
        this.loadCapacity = loadCapacity;
    }
    public String getLoadCapacity() {
        return loadCapacity;
    }
}
