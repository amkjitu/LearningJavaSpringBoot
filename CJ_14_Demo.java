
/*
In this file we will see how to take console input from the user. Learning purpose is:
Learning InputStreamReader, BufferedReader, Scanner, Console class and their methods to take input from the user.
* InputStreamReader: This class is used to read bytes and decode them into characters using a specified charset. It is a bridge from byte streams to character streams.
* BufferedReader: This class is used to read text from a character-input stream, buffering characters for efficient reading of characters, arrays, and lines. It can read from files, network connections, and other input sources.
Note: BufferedReader is a resource so it should be closed after use to free up system resources. This can be done using a try-with-resources statement or by calling the close() method in a finally block.

* Scanner: This class is used to parse primitive types and strings using regular expressions. It is a simple text scanner which can parse primitive types and strings using regular expressions.
* Console: This class is used to read from and write to the console. It provides methods to read input from the user and write output to the console.
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.Console;

public class CJ_14_Demo {
    public static void main(String[] args) {
        // System.out.println("Enter a number: ");
        // //1. Using System.in to read input from the user
        // System.out.println("Using System.in to read input from the user");
        // try {
        //     int input = System.in.read(); // This will read a single byte from the input stream and return the ascii value as an integer
        //     System.out.println("You entered: " + input);
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        //2. Using InputStreamReader to read input from the user
        // InputStreamReader is used to read bytes and decode them into characters using a specified charset
        // BufferedReader is used to read text from a character-input stream, buffering characters for efficient reading of characters, arrays, and lines
        System.out.println("Using InputStreamReader to read input from the user");
        try {
            InputStreamReader isr = new InputStreamReader(System.in); // Creating an InputStreamReader object to read from the input stream
            BufferedReader br = new BufferedReader(isr); // Creating a BufferedReader object to read from the InputStreamReader
            String input = br.readLine(); // This will read a line of text from the input stream and return it as a string
            System.out.println("You entered: " + input);
            br.close(); // Closing the BufferedReader to free up system resources
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("finally block will always execute.");
            // br.close(); // Closing the BufferedReader to free up system resources
        }

        //2.1 Using try-with-resources to automatically close the BufferedReader
        System.out.println("Using try-with-resources to automatically close the BufferedReader");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) { // Using try-with-resources to automatically close the BufferedReader
            String input = br.readLine(); // This will read a line of text from the input stream and return it as a string
            System.out.println("You entered: " + input);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // //3. Using Scanner to read input from the user
        // // Scanner is used to parse primitive types and strings using regular expressions
        // System.out.println("Using Scanner to read input from the user");
        // Scanner scanner = new Scanner(System.in);
        // System.out.println("Enter a number: ");
        // int number = scanner.nextInt();
        // System.out.println("You entered: " + number);

        //4. Using Console to read input from the user
        // Console is used to read from and write to the console. It provides methods to read input from the user and write output to the console.
        System.out.println("Using Console to read input from the user");
        Console console = System.console();
        if (console != null) {
            System.out.println("Enter a string: ");
            String input = console.readLine();
            System.out.println("You entered: " + input);
        }

    }
}
