/*
 * Optional Class in Java is a container object which may or may not contain a non-null value. It is a part of the java.util package and was introduced in Java 8 to provide a more functional approach to handling null values and to avoid NullPointerExceptions. Optional provides methods to check if a value is present, to retrieve the value if it is present, and to perform actions based on the presence or absence of a value. It is often used to represent the result of a method that may return a value or may return null, allowing developers to write more robust and readable code by explicitly handling the possibility of null values.
*/

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CJ_18_Demo {
    public static void main(String[] args) {
        List<String> namesString = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");
        // // 1. Create an Optional from the first name that starts with "A"
        // Optional<String> names = namesString.stream()
        //         .filter(name -> name.startsWith("Z"))
        //         .findFirst();

        // // 2. Check if the Optional contains a value and print it
        // System.out.println("Optional contains value: " + names.get());
        // // this will throw NoSuchElementException because there is no name that starts with "Z" in the list, so the Optional is empty and does not contain a value.

        //3. How to use in string type
        String name = namesString.stream().filter(n -> n.startsWith("Z")).findFirst().orElse("No name found");
        System.out.println("Name: " + name);// this will print "No name found" because there is no name that starts with "Z" in the list, so the Optional is empty and the default value "No name found" is returned.

    }
}
