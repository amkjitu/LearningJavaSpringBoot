/*
    * This file demonstrates the use of arrays, objects, and strings in Java.
    * It includes examples of simple arrays, object arrays, and string manipulation using String, StringBuilder, and StringBuffer classes.
*/
class Demo {
    int arr[] = new int[5];
    int num;

    Demo() {
        num = 100;
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;
        arr[4] = 50;
    }
}

class Student {
    String name;
    int age;
    double marks;
}

class CJ_2_Demo {
    public static void main(String[] args) {
        
        /// 1. Simple Array Example
        // Demo demo = new Demo();
        // for (int i = 0; i < demo.arr.length; i++) {
        //     System.out.println("Element " + i + ": " + demo.arr[i]);
        // }
        
        /// 2. Object Array Example
        // //Student Object-1
        // Student s1 = new Student();
        // s1.name = "Alice";
        // s1.age = 20;
        // s1.marks = 85.5;

        // //Student Object-2
        // Student s2 = new Student();
        // s2.name = "Bob";
        // s2.age = 22;
        // s2.marks = 90.0;

        // // Now we will create an array of Student objects
        // Student[] students = new Student[2];
        // students[0] = s1;
        // students[1] = s2;

        // // Print student details (for loop to iterate through the array)
        // for (int i = 0; i < students.length; i++) {
        //     System.out.println("Student " + (i + 1) + ":");
        //     System.out.println("Name: " + students[i].name);
        //     System.out.println("Age: " + students[i].age);
        //     System.out.println("Marks: " + students[i].marks);
        //     System.out.println();
        // }

        // // Print student details (for-each loop)
        // for (Student stud : students) {
        //     System.out.println("Student:");
        //     System.out.println("Name: " + stud.name);
        //     System.out.println("Age: " + stud.age);
        //     System.out.println("Marks: " + stud.marks);
        //     System.out.println();
        // }

        /// 3. String Example
        // String name = new String(); // String name; is the same and pupular way to declare a String variable
        // System.out.println("Name: " + name); // This will print "Name: null" because the default value of a String reference is null.
        // // name = "Alice";
        
        // String address = new String("Dhaka");
        // System.out.println("Address: " + address);

        // System.out.println("Length of address: " + address.length());
        // System.out.println("Character at index 2: " + address.charAt(2));

        /*
        Types of String creation
        1. String Literal: String s1 = "Hello"; // Stored in String Pool
        2. String Object: String s2 = new String("Hello"); // Stored in Heap, not in String Pool
        
        String Pool (String Interning):
        - A special memory area in the Heap where String literals are stored.
        - When a String literal is created, the JVM checks if it already exists in the String Pool.
        - If it exists, the reference to the existing String is returned.
        - If it does not exist, a new String is created in the String Pool and its reference is returned.
        
        String in Heap:
        - When a String is created using the new keyword, it is stored in the Heap memory
        - Each new String object created with new will have a different reference, even if the content is the same.
        
        String Immutability:
        - Once a String object is created, its content cannot be changed.
        - Any modification to a String results in the creation of a new String object.
        */

        // // For example:
        // String s1 = "Hello"; // String literal in String Pool
        // String s2 = new String("Hello"); // String object in Heap
        // s1 = s1 + " World"; // Creates a new String "Hello World" in Heap, s1 now references it
        // s2 = s2 + " World"; // Creates another new String "Hello World" in Heap, s2 now references it
        
        /*
        String Mutability:
        - If we need a mutable sequence of characters, we can use StringBuilder or StringBuffer classes.
        - StringBuilder is not synchronized and is faster, while StringBuffer is *synchronized and *thread-safe.
        Note: 
        *synchronized means that only one thread can access the StringBuffer object at a time, which can lead to performance overhead in single-threaded scenarios. StringBuilder should be preferred in such cases for better performance.
        *thread-safe means that StringBuffer can be safely used in multi-threaded environments without causing data corruption, while StringBuilder is not thread-safe and should be used with caution in such scenarios.
        */

        // Example of StringBuilder:
        StringBuilder sbld = new StringBuilder("Hello");
        System.out.println("Capacity: " + sbld.capacity());
        System.out.println("Length: " + sbld.length());
        sbld.append(" World"); // Modifies the same StringBuilder object, no new object is created
        System.out.println("Modified String: " + sbld.toString()); // toString() converts StringBuilder to String for concatenation and printing
        
        // Example of StringBuffer:
        StringBuffer sbuf = new StringBuffer("Hello");
        System.out.println("Capacity: " + sbuf.capacity());
        System.out.println("Length: " + sbuf.length());
        sbuf.append(" World"); // Modifies the same StringBuffer object, no new object is created
        System.out.println("Modified String: " + sbuf.toString());

        //Checking String is not same to StringBuilder and StringBuffer
        // String s3 = sbld; // Type mismatch error: cannot convert from StringBuilder to String
        String s3 = sbld.toString(); // Convert StringBuilder to String
        // String s4 = sbuf; // Type mismatch error: cannot convert from StringBuilder to String
        String s4 = sbuf.toString(); // Convert StringBuffer to String
        System.out.println(sbld); // This will print the content of StringBuilder, which is "Hello World"
        System.out.println(sbuf); // This will print the content of StringBuffer, which is "Hello World"
        System.out.println("s3: " + s3);
        System.out.println("s4: " + s4);
    }

}