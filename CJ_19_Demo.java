/*
Method Reference: Method reference is a shorthand notation of a lambda expression to call a method. It is used to refer to a method without invoking it. It can be used to point to static methods, instance methods, or constructors.
Syntax: ClassName::methodName

Constructor Reference: Constructor reference is a shorthand notation of a lambda expression to call a constructor. It is used to refer to a constructor without invoking it. It can be used to point to a constructor of a class.
Syntax: ClassName::new

Local Variable Type Inference(LVTI): Local variable type inference is a feature introduced in Java 10 that allows the compiler to infer the type of a local variable based on the context in which it is used. This means that you can declare a local variable without explicitly specifying its type, and the compiler will determine the type based on the value assigned to it. This can make code more concise and easier to read, especially when dealing with complex types or generic types.

    Notes to remember:
    1. LVTI can only be used for local variables, not for instance variables, method parameters or return types.
    2. 'var' can be used give a variable name but not as class name, method name or package name.

Sealed Classes: Sealed classes are a feature introduced in Java 15 that allows you to restrict which classes can extend or implement a particular class or interface. A sealed class can only be extended by a specific set of classes, which are defined using the 'permits' keyword. This can help to improve code maintainability and security by preventing unauthorized subclasses from being created.

    Notes to remember:
    1. A sealed class can only be extended by classes that are explicitly listed in the 'permits' clause.
    2. A sealed class can have subclasses that are either final, non-sealed or sealed.
    3. A final class cannot be extended by any other class. Interfaces can also be sealed, which means that they can only be implemented by a specific set of classes. But an Interface cannot be final, because it is meant to be implemented by other classes.

Non-sealed Classes: Non-sealed classes are a feature introduced in Java 15 that allows you to create a class that can be extended by any other class. A non-sealed class is not restricted by the 'permits' clause and can be extended by any class, including classes that are not explicitly listed in the 'permits' clause of the sealed class.

    Notes to remember:
    1. A non-sealed class can be extended by any other class, including classes that are not explicitly listed in the 'permits' clause of the sealed class.
    2. A non-sealed class can have subclasses that are either final, non-sealed or sealed.
    3. A non-sealed class can be extended by any other class.


*/

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

class Terson {
    private String name;

    public Terson(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "'}";
    }
}

// Role class can only be extended by Hero and Mosquito classes
sealed class Role permits Hero, Mosquito {

}

// class Hero can inherit from Role because it is a final class and cannot be extended by any other class.
final class Hero extends Role {

}

//class Mosquito can inherit from Role because it is a final class and cannot be extended by any other class.
final class Mosquito extends Role {

}

// // class Kumir can't inherit from Role.
// final class Kumir extends Role {

// }

public class CJ_19_Demo {
    public static void main(String[] args) {
        List<String> namesString = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

        // // 1. Method reference
        // List<String> upperCaseNames = namesString.stream()
        //         .map(String::toUpperCase) // Using method reference to convert each name to uppercase
        //         .toList(); 

        // System.out.println("Using method reference to print each name:");
        // upperCaseNames.forEach(System.out::println); // Using method reference to print each name in the list

        // 2. Constructor reference
        List<Terson> students = new ArrayList<>();
        // for (String name : namesString) {
        //     students.add(new Terson(name));
        // }

        // // Or, 
        // students = namesString.stream()
        //         .map(name -> new Terson(name))
        //         .toList();

        //Or
        // students = namesString.stream()
        //         .map(Terson::new) // Using constructor reference to create Terson objects
        //         .toList();

        // System.out.println("Using constructor reference to create Terson objects:");
        // // teople.forEach(System.out::println); // Using method reference to print each person in the list
        // System.out.println(students);

        // 3. Local Variable Type Inference (LVTI)
        int a = 0;
        var b = 1; // Using local variable type inference to declare a variable of type int

        int c; // correct
        // var d; // incorrect, cannot use var without initialization

        int nums[] = new int[5];
        // var nums2[] = new int[5]; // incorrect, var is not allowed as an element of an array
        var nums3 = new int[5]; // correct, var can be used to declare an array variable

    }
}
