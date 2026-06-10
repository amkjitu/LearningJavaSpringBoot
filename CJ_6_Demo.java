/*
* static block: A static block is a block of code that is executed when the class is loaded into memory. It is used to initialize static variables or perform any setup that needs to be done before the class can be used. A static block is defined using the static keyword and is executed only once, when the class is first loaded.
* Example of static block in Java:
In this example, the static block initializes the static variable staticVariable to 10 when the class is loaded. The output will be:
Static block executed. Static variable initialized to: 10
Main method executed. Static variable value: 10

*anynumous object: An anonymous object is an object that is created without being assigned to a reference variable. It is typically used when you want to create an object and use it immediately without needing to refer to it later in the code. Anonymous objects are often used in situations where you want to call a method on an object without needing to store a reference to that object.

* Note: If object is not created, static blocks are still executed when the class is loaded. Static blocks are executed in the order they appear in the class, and they are executed before any static methods or instance methods are called. If there are multiple static blocks, they will be executed in the order they are defined in the class.

Java class loading process:
1. When a Java program is run, the Java Virtual Machine (JVM) loads the classes that are needed for the program to run. This process is called class loading.
2. The JVM uses a class loader to load the classes into memory. The class loader reads the bytecode of the class and creates an instance of the class in memory.
3. During the class loading process, the static blocks of the class are executed. This means that any static variables or static initialization code will be executed before any instance of the class is created or any static methods are called.
4. After the class is loaded and the static blocks are executed, the main method of the class is executed, and the program starts running.

*/

class Example {
    int instanceVariable = 5;
    static int staticVariable;

    // Static block to initialize the static variable
    static {
        staticVariable = 10;
        System.out.println("Static block executed. Static variable initialized to: " + staticVariable);
    }
}

public class CJ_6_Demo {
    public static void main(String[] args) throws ClassNotFoundException {
        // Example example = new Example(); // This will trigger the static block to execute
        // System.out.println("Main method executed. Static variable value: " + Example.staticVariable);

        // Commenting the above lines first to show that static block executes even without creating an object of the class. The static block will execute when the class is loaded, and the static variable will be initialized. Accessing the static variable will also trigger the static block to execute if it hasn't already been executed.
        // Class.forName("Example"); // This will also trigger the static block to execute as it loads the class into memory

        //Anonymous object example:
        new Example(); //output: Static block executed. Static variable initialized to: 10
        System.out.println("Accessing instance variable through anonymous object: " + new Example().instanceVariable); //output: Static block executed. Static variable initialized to: 10
    }
}
