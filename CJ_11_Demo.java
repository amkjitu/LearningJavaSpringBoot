/*
* Abstract Class: An abstract class in Java is a class that cannot be instantiated on its own and is meant to be subclassed. It can contain abstract methods (methods without a body) that must be implemented by any concrete subclass. Abstract classes can also contain concrete methods (methods with a body) that can be inherited by subclasses. Abstract classes are used to provide a common base for related classes and to define a common interface for those classes.
Points to remember about abstract classes:
    1. An abstract class cannot be instantiated directly. You cannot create an object of an abstract class
    2. An abstract class can have both abstract and concrete methods. Abstract methods must be implemented by any concrete subclass, while concrete methods can be inherited as they are.
    3. A concrete subclass that extends an abstract class must provide implementations for all abstract methods declared in the abstract class, unless the subclass is also declared as abstract.
    4. Abstract classes can have constructors, but they cannot be used to create instances of the abstract class. Instead, constructors in abstract classes are typically called from the constructors of concrete subclasses to initialize common state or perform setup tasks.
Note: objects can only be created from concrete classes, not from abstract classes. Abstract classes are meant to be subclassed and cannot be instantiated on their own.
* Inner Class: An inner class in Java is a class that is defined within another class. Inner classes can be categorized into four types:
    1. Non-static inner class (also known as an instance inner class): This type of inner class is associated with an instance of the outer class. It can access the members (including private members) of the outer class and is typically used to implement functionality that is closely related to the outer class.
    2. Static inner class (also known as a static nested class): This type of inner class is declared static and does not have access to the instance members of the outer class. It can only access static members of the outer class. Static inner classes are often used for utility or helper classes that do not require access to the instance members of the outer class.
    3. Local inner class: This type of inner class is defined within a method or a block of code. It is only accessible within the scope of that method or block and can access the final or effectively final variables of the enclosing method. Local inner classes are typically used for implementing functionality that is specific to a particular method or block of code.
    4. Anonymous inner class: This type of inner class does not have a name and is defined and instantiated in a single expression. It is often used for implementing interfaces or extending classes in a concise way, especially when the implementation is only needed in one place. Anonymous inner classes are commonly used for event handling and for creating instances of functional interfaces in Java.
*/

/// 1. Abstract class example
abstract class Car {
    abstract void start(); // Abstract method, must be implemented by subclasses
    abstract void fly(); // Abstract method, must be implemented by subclasses

    void stop() { // Concrete method, can be inherited by subclasses
        System.out.println("Car stopped.");
    }
}

abstract class Toyota extends Car {
    void start() { // Implementing the abstract method
        System.out.println("Toyota started.");
    }
}

// this is a concrete class that extends the abstract class Toyota, so it must implement the fly() method as well.
class HeliToyota extends Toyota {
    void fly() { // Implementing the abstract method
        System.out.println("HeliToyota is flying.");
    }
}

/// 2. Inner Classes
class Aouter {

    void display() {
        System.out.println("This is the outer class Aouter.");
    }

    // Non-static inner class
    class Binner {
        void show() {
            System.out.println("This is the non-static inner class Binner.");
        }
    }

    // Static inner class
    static class Cinner {
        void show() {
            System.out.println("This is the static inner class Cinner.");
        }
    }
}

/// 3. Anonymous inner class example
class A2 {

    void display() {
        System.out.println("This is the class A2.");
    }
}

/// 4. Abstract inner Anonymous inner class example
abstract class A3 {

    abstract void display();
}

//this is main class to test the abstract class and its subclasses
public class CJ_11_Demo {
    public static void main(String[] args) {
        /// 1. Abstract classes 
        // Car myCar = new Car(); // This will cause a compile-time error because Car is an abstract class and cannot be instantiated.
        // Car toyota = new Toyota(); // This will cause a also compile-time error because Toyota is an abstract class and cannot be instantiated.
        // toyota.start();
        // toyota.stop();
        
        // Car heliToyota = new HeliToyota(); // This will work because HeliToyota is a concrete class that extends the abstract class Toyota.
        // heliToyota.start();
        // heliToyota.fly();
        // heliToyota.stop();

        /// 2. Inner Classes
        
        // // Object of the outer class
        // Aouter outer = new Aouter();
        // outer.display();

        // // Object of the non-static inner class
        // Aouter.Binner innerB = outer.new Binner(); // Creating an instance of the non-static inner class B
        // innerB.show();

        // // Object of the static inner class
        // Aouter.Cinner innerC = new Aouter.Cinner(); // Creating an instance of the static inner class C
        // innerC.show();

        /// 3. Anonymous inner class example
        // A2 obj = new A2(); // Creating an instance of the class A2, as simple as that
        // obj.display();

        // A2 objAnoInner = new A2() { // Creating an anonymous inner class that extends A2
        //     void display() { // Overriding the display method of A2
        //         System.out.println("This is an anonymous inner class extending A2.");
        //     }
        // };
        // objAnoInner.display(); // This will call the overridden display method of the anonymous inner class

        /// 4. Abstract inner Anonymous inner class example
        A3 objAnoInnerAbstract = new A3() { // Creating an anonymous inner class that extends the abstract class A3
            void display() { // Implementing the abstract method of A3
                System.out.println("This is an anonymous inner class extending the abstract class A3.");
            }
        };
        objAnoInnerAbstract.display(); // This will call the implemented display method of the anonymous inner class
    }
}
