/*
    * Encapsulation is one of the fundamental principles of object-oriented programming (OOP) that focuses on bundling data (variables) and methods (functions) that operate on the data into a single unit, called a class. It also restricts direct access to some of the object's components, which is a means of preventing accidental interference and misuse of the data. This is typically achieved through the use of access modifiers (like private, protected, and public) and getter/setter methods.
    * In Java, encapsulation is implemented using classes and access modifiers. The private access modifier is commonly used to restrict access to the class's fields (variables), while public getter and setter methods are provided to allow controlled access to those fields. This way, you can protect the integrity of the data and ensure that it is accessed and modified in a controlled manner.
    * In the following code, we will demonstrate encapsulation by creating a Human class with private fields for name and age, along with public getter and setter methods to access and modify these fields. We will also include a constructor for initializing the fields when creating an object of the Human class.
*/
// // Step-0: Access modifiers: private
// class Human {
//     // String name;
//     // int age;
//     private String name;  
//     private int age;
// }

// public class CJ_3_Demo {
//     public static void main(String[] args) {
//         Human h1 = new Human();
//         h1.name = "Alice";
//         h1.age = 25;
//         System.out.println("Name: " + h1.name);
//         System.out.println("Age: " + h1.age);
//     }   
// }

// // Step-1: Encapsulation with getter and setter methods
// class Human {
//     private String name;  
//     private int age;

//     // getter for name
//     public String getName() {
//         return this.name; //this.name is good practice to avoid confusion with local variables, but since there is no local variable named 'name' in this method, we can also simply return 'name'. ['this' means current object]
//     }

//     // getter for age
//     public int getAge() {
//         return age; //this.age
//     }

//     // setter for name
//     public void setName(String name) {
//         // name = name; // This is a common mistake: it assigns the parameter to itself, not to the instance variable. The instance variable 'name' remains unchanged.
        
//         // To fix this, we should use 'this' to refer to the instance variable:
//         this.name = name; // This correctly assigns the value of the parameter 'name' to the instance variable 'name' of the Human class.
//     }

//     // setter for age
//     public void setAge(int age) {
//         this.age = age;
//     }
// }

// public class CJ_3_Demo {
//     public static void main(String[] args) {
//         Human h1 = new Human();

//         System.out.println("Name: " + h1.getName());
//         System.out.println("Age: " + h1.getAge());

//         h1.setName("Alice");
//         h1.setAge(25);
//         System.out.println("Updated Name: " + h1.getName());
//         System.out.println("Updated Age: " + h1.getAge());
//     }   
// }

// Step-3: Constructor for initialization
class Human {
    private String name;  
    private int age;

    // Constructor
    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Human() {
        this.name = "Default Name";
        this.age = 10;
    }

    // getter for name
    public String getName() {
        return this.name; //this.name is good practice to avoid confusion with local variables, but since there is no local variable named 'name' in this method, we can also simply return 'name'. ['this' means current object]
    }

    // getter for age
    public int getAge() {
        return age; //this.age
    }

    // setter for name
    public void setName(String name) {
        // name = name; // This is a common mistake: it assigns the parameter to itself, not to the instance variable. The instance variable 'name' remains unchanged.
        
        // To fix this, we should use 'this' to refer to the instance variable:
        this.name = name; // This correctly assigns the value of the parameter 'name' to the instance variable 'name' of the Human class.
    }

    // setter for age
    public void setAge(int age) {
        this.age = age;
    }
}

public class CJ_3_Demo {
    public static void main(String[] args) {
        Human h1 = new Human("Alice", 25);

        System.out.println("Object h1");
        System.out.println("Name: " + h1.getName());
        System.out.println("Age: " + h1.getAge());

        h1.setName("Blice");
        h1.setAge(26);
        System.out.println("Updated Name: " + h1.getName());
        System.out.println("Updated Age: " + h1.getAge());

        System.out.println("Object h2");
        Human h2 = new Human();
        System.out.println("Name: " + h2.getName());
        System.out.println("Age: " + h2.getAge());

        //If we understand the constructor concept, 
        //1. we can easily understand the concept of method overloading. Method overloading is a feature in Java that allows a class to have more than one method with the same name, as long as their parameter lists are different. In the above example, we have two constructors for the Human class: one that takes parameters (name and age) and another that is a no-argument constructor that initializes the object with default values. This is an example of constructor overloading, which is a specific type of method overloading.
        //2. We can also understand the concept of constructor chaining, which is the process of calling one constructor from another constructor in the same class. In the above example, we could modify the no-argument constructor to call the parameterized constructor with default values.
        //3. We can also understand the concept of copy constructor, which is called when we want to create a new object then we can count the number of objects created of that class. [Solved in CJ_4_Demo.java]
    }
}