/*
* Final: The final keyword in Java is used to declare constants, prevent method overriding, and prevent inheritance. When a variable is declared as final, its value cannot be changed once it has been assigned. When a method is declared as final, it cannot be overridden by subclasses. When a class is declared as final, it cannot be subclassed.
In short, final - variable, method, class. It is used to restrict the user from changing the value of a variable, overriding a method, or inheriting a class.

* ObjectClass: An object class is a class that is used to create objects. It is the blueprint for creating objects. It contains fields (variables) and methods (functions) that define the behavior of the objects created from the class. In Java, every class is an object class, and it can be instantiated to create objects.

* WrapperClass: A wrapper class in Java is a class that provides a way to use primitive data types (such as int, double, char, etc.) as objects. Each primitive data type has a corresponding wrapper class in Java. 
For example, the wrapper class for 
- int is Integer, 
- double is Double, 
- char is Character and so on.
Wrapper classes provide methods to convert between primitive types and their corresponding wrapper objects, as well as other utility methods for working with the data.
    
*/

class Aa {
    // 1. Final variable
    final int x = 10; // This variable cannot be changed

    // 2. Final method
    final void display() { // This method cannot be overridden
        final int y = 10;
        // y = 100; // This will cause a compile-time error because y is a final variable
        System.out.println("This is a final method class Aa.");
    }
}

// 3. Final class
final class Bb extends Aa {
    // This will cause a compile-time error because we cannot override a final method
    // void display() {
    //     System.out.println("Trying to override a final method.");
    // }
}

// This will cause a compile-time error because we cannot inherit from a final class
// class Cc extends Bb {
// }

public class CJ_10_Demo {
    public static void main(String[] args) {
        // 1. Create an object of class Bb, we will see that Bb.display() will call the display method of class Aa because Bb cannot override it as it is declared final.
        // Bb objB = new Bb();
        // objB.display();

        // 2. Create an object of class Aa
        // Aa objA = new Aa();
        // System.out.println(objA); // This will print the reference of the object objA, which is a memory address in hexadecimal format.
        // System.out.println(objA.toString()); // This will print the reference of the object objA, which is a memory address in hexadecimal format.

        // 3. Wrapper class example
        int primitiveInt = 5;
        Integer wrapperInt = primitiveInt; // Autoboxing: Converting primitive int to Integer object
        int unboxedInt = wrapperInt; // Unboxing: Converting Integer object back to primitive int

        System.out.println("Primitive int: " + primitiveInt);
        System.out.println("Wrapper Integer: " + wrapperInt);
        System.out.println("Unboxed int: " + unboxedInt);

        String str = "123";
        int parsedInt = Integer.parseInt(str); // Converting String to primitive int
        System.out.println("String: " + str);
        System.out.println("Parsed int from String: " + parsedInt);

    }
}
