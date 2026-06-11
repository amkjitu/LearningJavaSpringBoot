package CJ_7_Demo;

// import CJ_7_Demo.Phone.Smartphone;
// import CJ_7_Demo.Phone.Camera;
// import CJ_7_Demo.Phone.Phone;
// import CJ_7_Demo.Calc.Calc;
// import CJ_7_Demo.Calc.AdvCalc;
// import CJ_7_Demo.Calc.SciCalc;
// import CJ_7_Demo.Calc.GraphingCalc;

// or we can import all classes from the Calc and Phone packages using wildcard imports
import CJ_7_Demo.Calc.*; // this means all the files inside the Calc Folder
import CJ_7_Demo.Phone.*;

/*
 * Inheritance: In OOP, inheritance is a fundamental concept that allows a new class (called a subclass or child class) to inherit properties and behaviors (fields and methods) from an existing class (called a superclass or parent class). This promotes code reusability and establishes a natural hierarchical relationship between classes.
 * Inheritance allows the subclass to:
 * 1. Inherit fields and methods from the superclass, which means the subclass can use the existing code without having to rewrite it.
 * 2. Override methods from the superclass to provide specific implementations in the subclass.
 * 3. Add new fields and methods to enhance or extend the functionality of the superclass.
 * In Java, inheritance is achieved using the "extends" keyword. For example, if we have a superclass called "Calc" and a subclass called "AdvCalc", we can define the Dog class as ``public class AdvCalc extends Calc``
 * In this example, the AdvCalc class inherits all the methods from the Calc class and can also have its own additional methods (like factorial and power) that are specific to advanced calculations. This allows us to create a more specialized calculator while still retaining the basic functionalities provided by the Calc class.
 * Types of Inheritance:
 * 1. Single Inheritance: A subclass inherits from a single superclass.
 *
 *      SuperClass
 *         |
 *      SubClass
 * 
 * 2. Multilevel Inheritance: A subclass inherits from a superclass, and then another subclass inherits from that subclass.
 *
 *      GrandParent
 *         |
 *      Parent
 *         |
 *      Child
 * 
 * 3. Hierarchical Inheritance: Multiple subclasses inherit from a single superclass.
 *
 *           SuperClass
 *           /   |    \
 *      SubA  SubB  SubC
 * 
 * 4. Multiple Inheritance (not supported in Java): A subclass inherits from multiple superclasses. In Java, this can be achieved using interfaces instead of classes.
 *
 *          InterfaceA   InterfaceB
 *               \         /
 *               ImplementingClass
 * 
 * Examples:
 * - Single Inheritance: A class "Dog" inherits from a class "Animal".
 * - Multilevel Inheritance: A class "Car" inherits from a class "Vehicle", and then a class "ElectricCar" inherits from "Car".
 * - Hierarchical Inheritance: A class "Shape" is a superclass, and classes "Circle", "Square", and "Triangle" inherit from it.
 * - Multiple Inheritance (using interfaces): A class "Smartphone" implements interfaces "Camera" and "Phone".
 * 
 * Package: A package in Java is a namespace that organizes a set of related classes and interfaces. It helps to avoid name conflicts and to control access to classes. In the provided code snippet, we have two packages: "Calc" and "Phone". The "Calc" package contains classes related to different types of calculators (Calc, AdvCalc, SciCalc, GraphingCalc), while the "Phone" package contains interfaces and classes related to phone functionalities (Phone, Camera, Smartphone). By organizing our classes into packages, we can maintain a cleaner and more modular codebase, making it easier to manage and understand the relationships between different components of our application.
 * 
 * Package Structure:
 * - CJ_7_Demo
 *  - Calc
 *    - Calc.java
 *    - AdvCalc.java
 *    - SciCalc.java
 *    - GraphingCalc.java
 * - Phone
 *   - Phone.java
 *   - Camera.java
 *   - Smartphone.java
 * If i want to use for example, the AdvCalc class in the CJ_7_Demo class, I need to import it using `import CJ_7_Demo.Calc.AdvCalc;` and then I can create an instance of AdvCalc and call its methods. this is actually the folder by dot notation in Java, where the folder structure corresponds to the package structure. So, the AdvCalc class is located in the "Calc" package, which is a subpackage of "CJ_7_Demo". By importing it, we can use its functionalities in our main class.
 * 
 * Access Modifiers: In Java, access modifiers are keywords that set the accessibility of classes, methods, and other members. The main access modifiers are:
 * 1. public: The member is accessible from any other class.
 * 2. protected: The member is accessible within the same package and subclasses in other packages.
 * 3. default (package-private): The member is accessible only within the same package.
 * 4. private: The member is accessible only within the same class.
 * 
 */

public class CJ_7_Demo {
    public static void main(String[] args) {
        System.out.println("This is CJ_7_Demo class.");

        // /// 1. Here we have a single inheritance example where AdvCalc is a subclass of Calc, inheriting its methods and adding new functionalities specific to advanced calculations.
        // Calc calc = new Calc();
        // System.out.println("Calc Addition: " + calc.add(5, 3));
        // System.out.println("Calc Subtraction: " + calc.subtract(5, 3));
        // System.out.println("Calc Multiplication: " + calc.multiply(5, 3));
        // System.out.println("Calc Division: " + calc.divide(5, 3));

        // AdvCalc advCalc = new AdvCalc();
        // System.out.println("AdvCalc Addition: " + advCalc.add(5, 3));
        // System.out.println("AdvCalc Subtraction: " + advCalc.subtract(5, 3));
        // System.out.println("AdvCalc Multiplication: " + advCalc.multiply(5, 3));
        // System.out.println("AdvCalc Division: " + advCalc.divide(5, 3));
        // System.out.println("AdvCalc Factorial: " + advCalc.factorial(5));
        // System.out.println("AdvCalc Power: " + advCalc.power(2, 3));

        // /// 2. In this example, we have a multilevel inheritance scenario where we can create a new class "SciCalc" that inherits from "AdvCalc", which in turn inherits from "Calc". This allows us to further extend the functionality of the calculator while still retaining all the methods from both Calc and AdvCalc.
        // SciCalc sciCalc = new SciCalc();
        // System.out.println("SciCalc Addition: " + sciCalc.add(5, 3));
        // System.out.println("SciCalc Subtraction: " + sciCalc.subtract(5, 3));
        // System.out.println("SciCalc Multiplication: " + sciCalc.multiply(5, 3));
        // System.out.println("SciCalc Division: " + sciCalc.divide(5, 3));
        // System.out.println("SciCalc Factorial: " + sciCalc.factorial(5));
        // System.out.println("SciCalc Power: " + sciCalc.power(2, 3));
        // System.out.println("SciCalc Square Root: " + sciCalc.squareRoot(16));

        // /// 3. Here we have a hierarchical inheritance example where we can create a new class "GraphingCalc" that also inherits from "AdvCalc". This allows us to have multiple subclasses (SciCalc and GraphingCalc) that share the same superclass (AdvCalc) while providing their own specific functionalities.
        // GraphingCalc graphingCalc = new GraphingCalc();
        // System.out.println("GraphingCalc Addition: " + graphingCalc.add(5, 3));
        // System.out.println("GraphingCalc Subtraction: " + graphingCalc.subtract(5, 3));
        // System.out.println("GraphingCalc Multiplication: " + graphingCalc.multiply(5, 3));
        // System.out.println("GraphingCalc Division: " + graphingCalc.divide(5, 3));
        // System.out.println("GraphingCalc Factorial: " + graphingCalc.factorial(5));
        // System.out.println("GraphingCalc Power: " + graphingCalc.power(2, 3));
        // System.out.println("GraphingCalc Graphing Function: " + graphingCalc.graphFunction("y = x^2"));

        // 4. Multiple Inheritance is not supported in Java, but we can achieve similar functionality using interfaces. For example, we can create two interfaces "Camera" and "Phone", and then a class "Smartphone" that implements both interfaces to provide functionalities of both a camera and a phone.
        Smartphone smartphone = new Smartphone();
        smartphone.makeCall();
        smartphone.takePicture();

    }
}
