/*
* Types of Error in Java:
    1. Syntax Errors: These occur when the code violates the syntax rules of the Java language. They are detected by the compiler and must be fixed before the code can be executed.
        For exmaple: ingt a = 10; // Syntax error: 'ingt' is not a valid keyword in Java
    2. Runtime Errors: These occur during the execution of the program and can cause the program to crash. Examples include NullPointerException, ArrayIndexOutOfBoundsException, etc.
        For example: int [] arr = new int[2]; arr[5] = 10; // Runtime error: ArrayIndexOutOfBoundsException because we are trying to access an index that is out of bounds
    3. Logical Errors: These occur when the program compiles and runs without crashing, but produces incorrect results. These errors are often the most difficult to detect and fix because they do not produce any error messages.
        For example: int a = 10; int b = 20; int sum = a - b; // Logical error: The correct operation should be addition (+) instead of subtraction (-)

As systax errors are detected by the compiler, they must be fixed before the code can be executed.
Logical errors are not detected by the compiler and can only be identified through testing and debugging.
Runtime errors can be detected during execution, causing the program to crash.
Here Exception handling comes into play to manage runtime errors and prevent the program from crashing, allowing developers to handle exceptions gracefully and maintain the flow of the program.

* Exception Handling in Java:
    1. Try-Catch Block: This is used to handle exceptions that may occur in a block of code. The code that may throw an exception is placed inside the try block, and the catch block is used to handle the exception if it occurs.
        For example:
        try {
            int result = 10 / 0; // This will throw an ArithmeticException
        } catch (ArithmeticException e) { // Catching the specific exception type
            System.out.println("Cannot divide by zero: " + e.getMessage());
        }
    2. Finally Block: This block is used to execute code that must run regardless of whether an exception was thrown or not. It is often used for cleanup activities, such as closing resources.
        For example:
        try {
            // Code that may throw an exception
        } catch (Exception e) { // Catching a general exception
            // Handle exception
        } finally {
            // Code that will always execute, such as closing resources
        }
    3. Throwing Exceptions: You can throw exceptions manually using the throw keyword. This is useful when you want to signal that an error has occurred in your code.
        For example:
        public void setAge(int age) {
            if (age < 0) {
                throw new IllegalArgumentException("Age cannot be negative");
            }
            this.age = age;
        }
    4. Custom Exceptions: You can create your own custom exception classes by extending the Exception class. This allows you to define specific types of exceptions that are relevant to your application.
        For example:
        public class InvalidAgeException extends Exception {
            public InvalidAgeException(String message) {
                super(message);
            }
        }
    5. Exception Propagation: When an exception is thrown, it can be propagated up the call stack to be handled by a higher-level method. If a method does not handle an exception, it can declare that it throws the exception, allowing the caller to handle it.
        For example:
        public void methodA() throws IOException {
            // Code that may throw an IOException
        }
        public void methodB() {
            try {
                methodA(); // Calling methodA which may throw an IOException
            } catch (IOException e) { // Catching the specific exception type
                // Handle exception
            }
        }

    * Key points to remember:
    - Always catch specific exceptions rather than general exceptions to provide more meaningful error handling.
    - Use the finally block to ensure that important cleanup code is executed regardless of whether an exception occurs or not.
    - When creating custom exceptions, provide meaningful messages to help with debugging and error handling.
    - Exception propagation allows for better separation of concerns, as it allows higher-level methods to handle exceptions that occur in lower-level methods, making the code more modular and easier to maintain.
    
    * The difference between 'throw' and 'throws' in Java is that:
    - 'throw' is used to manually throw an exception, while 'throws' is used in a method signature to declare that the method may throw an exception, allowing the caller to handle it.
    - 'throw' is used to signal that an error has occurred in the code, while throws is used to indicate that a method may throw an exception, allowing the caller to handle it appropriately.
    - 'throw' is used within the body of a method to throw an exception, while throws is used in the method declaration to specify that the method may throw an exception, allowing for better error handling and propagation in Java.

*/

class JituException extends Exception {
    public JituException(String message) {
        super(message);
    }
}

class Ad {
    public void methodA() throws Exception {
        throw new Exception("Error in methodA");
    }
}

public class CJ_13_Demo {
    public static void main(String[] args) {
        // // 1. General Exception Handling using try-catch block
        // try {
        //     int result = 10 / 0; // This will throw an ArithmeticException
        // } catch (Exception e) { // Catching a general exception
        //     System.out.println("An error occurred: " + e.getMessage());
        // }

        // // 2. Specific Exception Handling using try-catch block
        // try {
        //     int[] arr = new int[2]; // This will throw an ArrayIndexOutOfBoundsException
        //     arr[0] = 0; // This is fine, we are assigning a value to the first index of the array
        //     arr[3] = 1; // This will throw an ArrayIndexOutOfBoundsException because we are trying to access an index that is out of bounds
        //     int resutl =  10/arr[0]; // This will throw an ArithmeticException because we are trying to divide by zero
        // } catch (ArithmeticException e) { // Catching the specific exception type
        //     System.out.println("Cannot divide by zero: " + e.getMessage());
        // } catch (ArrayIndexOutOfBoundsException e) { // Catching the specific exception type
        //     System.out.println("Array index is out of bounds: " + e.getMessage());
        // } finally {
        //     System.out.println("This block will always execute.");
        // }

        // // 3. Throwing Exceptions manually
        // try {
        //     int age = -5; // This is an invalid age
        //     if (age < 0) {
        //         throw new IllegalArgumentException("Age cannot be negative");
        //     }
        // } catch (IllegalArgumentException e) { // Catching the specific exception type
        //     System.out.println("Invalid age: " + e.getMessage());
        // }

        // // 4. Custom Exceptions
        // try {
        //     int age = -10; // This is an invalid age
        //     if (age < 0) {
        //         throw new JituException("Age cannot be negative");
        //     }
        // } catch (JituException e) { // Catching the custom exception type
        //     System.out.println("Custom Exception: " + e.getMessage());
        // }

        // 5. Exception Propagation
        try {
            Ad ad = new Ad();
            ad.methodA(); // Calling methodA which may throw an IOException
        } catch (Exception e) { // Catching a general exception
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

}
