/*
Interface: An interface in Java is a reference type that defines a contract for classes to implement. It is a collection of abstract methods (methods without a body) and constant variables (static final fields). Interfaces are used to specify a set of behaviors that implementing classes must provide, without dictating how those behaviors should be implemented. A class can implement multiple interfaces, allowing for multiple inheritance of behavior.
Points to remember about interfaces:
    1. An interface cannot be instantiated directly. You cannot create an object of an interface.
    2. An interface can only contain abstract methods (methods without a body) and constant variables (static final fields). It cannot contain concrete methods (methods with a body) or instance variables.
    3. A class that implements an interface must provide implementations for all abstract methods declared in the interface, unless the class is also declared as abstract.
    4. Interfaces can be used to achieve multiple inheritance in Java, as a class can implement multiple interfaces.

Inheritance of interfaces: A class can inherit from an interface by using the "extends" keyword, as shown in example 2

Types of interfaces:
    1. Normal Interface: A normal interface is a standard interface that contains multiple abstract methods and constant variables. It is the most common type of interface used in Java. Classes that implement a normal interface must provide implementations for all abstract methods declared in the interface.
    Example: Vehicle, Computer, at below
    2. Functional Interface/SAM: A functional interface is an interface that contains exactly one abstract method. It can have any number of default or static methods, but it must have only one abstract method. Functional interfaces are used as the basis for lambda expressions and method references in Java. For example, the Runnable interface is a functional interface that contains a single abstract method run(), which can be implemented using a lambda expression or method reference. SAM stands for Single Abstract Method, which is another term used to describe functional interfaces.
    Example: 
        interface A{
            @FunctionalInterface // This annotation is optional but it is good practice to use it to indicate that this interface is intended to be a functional interface
            void method(); // This is the single abstract method of the functional interface A
        }
    3. Marker Interface: A marker interface is an interface that does not contain any methods or fields. It is used to indicate that a class belongs to a particular category or has a specific property. For example, the Serializable interface is a marker interface that indicates that a class can be serialized (converted into a byte stream for storage or transmission). Deserializable is a marker interface that indicates that a class can be deserialized (reconstructed from a byte stream). Marker interfaces are often used in conjunction with reflection to provide metadata about classes at runtime.
    Example: 

Enums: An enum in Java is a special data type that represents a fixed set of constants. It is used to define a collection of related values that can be treated as a single unit. Enums are typically used to represent a group of predefined options or categories, such as days of the week, months of the year, or states of a process. Enums provide type safety and can have methods and fields, making them more powerful than simple constants.
*/

/// 1. Interface

/// Real world example 1 of interface
interface Vehicle {

    // int MAX_SPEED = 120; // only static final variables are allowed in interfaces, so this variable is implicitly public, static and final. It cannot be changed.
    // static final String VEHICLE_TYPE = "Land Vehicle"; // This is a constant variable, it cannot be changed
    String VEHICLE_TYPE = "Fuel Vehicle";
    // final int MAX_SPEED = 120; // This is a constant variable, it cannot be changed
    int MAX_SPEED = 120; // This is a constant variable, it cannot be changed

    void start(); // Abstract method, must be implemented by classes that implement this interface

    void stop(); // Abstract method, must be implemented by classes that implement this interface
}

class Bus implements Vehicle {
    public void start() { // Implementing the start method of the Vehicle interface
        System.out.println("Bus started." + " Vehicle type: " + VEHICLE_TYPE + ", Max speed: " + MAX_SPEED);
    }

    public void stop() { // Implementing the stop method of the Vehicle interface
        System.out.println("Bus stopped.");
    }
}

interface Boat {

    void sail(); // Abstract method, must be implemented by classes that implement this interface
}

class WaterBus implements Vehicle, Boat { // A class can implement multiple interfaces

    public void start() { // Implementing the start method of the Vehicle interface
        System.out.println("WaterBus started." + " Vehicle type: " + VEHICLE_TYPE + ", Max speed: " + MAX_SPEED);
    }

    public void stop() { // Implementing the stop method of the Vehicle interface
        System.out.println("WaterBus stopped.");
    }

    public void sail() { // Implementing the sail method of the Boat interface
        System.out.println("WaterBus is sailing.");
    }
}

interface Troller extends Boat {
    void launch(); // Abstract method, must be implemented by classes that implement this interface
}

class TrollerBoat implements Troller {

    public void sail() { // Implementing the sail method of the Boat interface
        System.out.println("TrollerBoat is sailing.");
    }

    // Implementing the launch method of the Troller interface,
    // if we do not implement compile-time error will say type TrollerBoat must implement the abstract method launch()
    public void launch() {
        System.out.println("TrollerBoat launched.");
    }
}

/// Real world example 2 of interface
interface Computer {
    void compute(); // Abstract method, must be implemented by classes that implement this interface
}

class Laptop implements Computer {
    public void compute() { // Implementing the compute method of the Computer interface
        System.out.println("Laptop is computing[Slow].");
    }
}

class Desktop implements Computer {
    public void compute() { // Implementing the compute method of the Computer interface
        System.out.println("Desktop is computing[Fast].");
    }
}

class ComputerUser {
    void useComputer(Computer computer) { // This method takes a Computer interface as a parameter, allowing it to work with any class that implements the Computer interface
        computer.compute(); // Calling the compute method of the Computer interface
    }
}

/// 2. Enums
/// Real world example 1
enum STATUS {
    PENDING,
    IN_PROGRESS,
    COMPLETED,
    CANCELLED
}

/// Real world example 2
enum RAM {
    Samsang(200),
    Kingston(160),
    // Adata(128),
    Adata,
    Corsair(256);

    private int capacity; // capacity in GB

    private RAM() { // Constructor for the enum, it is called when each enum constant is created
        this.capacity = 0;
    }

    private RAM(int capacity) { // Constructor for the enum, it is called when each enum constant is created
        this.capacity = capacity;
    }

    public int getCapacity() { // Getter method to access the capacity of each RAM type
        return capacity;
    }

    public void setCapacity(int capacity) { // Setter method to change the capacity of each RAM type, although it is not common to have setter methods in enums since they are meant to represent fixed constants
        this.capacity = capacity;
    }
}

///Main class to test the interface and enum examples
public class CJ_12_Demo {
    public static void main(String[] args) {

        // 1. Since Vehicle is an interface, we cannot create an instance of it directly. We can only create instances of classes that implement the Vehicle interface, such as Bus and WaterBus.
        // Bus objBus = new Bus(); // Creating an instance of class Bus
        // Bus.MAX_SPEED = 100; // This will cause a compile-time error because MAX_SPEED is a constant variable (static final) defined in the Vehicle interface, and it cannot be changed
        // objBus.start(); // Calling the start method implemented in class Bus
        // objBus.stop(); // Calling the stop method implemented in class Bus

        //  2. Creating an instance of class WaterBus, which implements both Vehicle and Boat interfaces, so it must provide implementations for all abstract methods declared in both interfaces.
        // WaterBus objWaterBus = new WaterBus(); // Creating an instance of class WaterBus
        // objWaterBus.start(); // Calling the start method implemented in class WaterBus
        // objWaterBus.stop(); // Calling the stop method implemented in class WaterBus
        // objWaterBus.sail(); // Calling the sail method implemented in class WaterBus

        // 3. Interface inheritance example, Troller interface extends Boat interface, so any class that implements Troller must also implement the methods of Boat interface. In this case, TrollerBoat implements Troller, so it must provide implementations for both sail() method from Boat interface and launch() method from Troller interface.
        // TrollerBoat objTrollerBoat = new TrollerBoat();
        // objTrollerBoat.sail();
        // objTrollerBoat.launch();

        // 4. Using the ComputerUser class to demonstrate polymorphism with interfaces. The useComputer method can accept any object that implements the Computer interface, allowing for flexibility and extensibility in the code.

        // Example of using ComputerUser to work with Laptop and Desktop, both of which implement the Computer interface. This demonstrates how we can use interfaces to achieve polymorphism, allowing us to write code that can work with different types of objects that share a common interface.
        // Laptop laptop = new Laptop();
        // Desktop desktop = new Desktop();
        // ComputerUser user1 = new ComputerUser();
        // user1.useComputer(laptop); // This will call the compute method of the Laptop class
        // user1.useComputer(desktop); // This will call the compute method of the Desktop class

        // Alternatively, we can directly pass new instances of Laptop and Desktop to the useComputer method without creating separate variables for them.
        // ComputerUser user2 = new ComputerUser();
        // user2.useComputer(new Laptop());
        // user2.useComputer(new Desktop());

        // 5. Example Enums
        // STATUS status = STATUS.PENDING;
        // System.out.println("Current status: " + status); // This will print "Current status: PENDING"
        // STATUS [] allStatuses = STATUS.values(); // This will return an array of all enum constants defined in the STATUS enum
        // System.out.println("All statuses:");
        // for (STATUS s : allStatuses) {
        //     System.out.println(s.ordinal() + " - " + s);
        // }
        for (RAM ram : RAM.values()) {
            System.out.println(ram.name() + " has capacity: " + ram.getCapacity() + " GB");
        }
    }
}
