/*
* super() is a keyword in Java that refers to the immediate parent class of the current class. It is used to call the constructor of the parent class, allowing you to initialize the parent class's properties or perform any necessary setup before executing the child class's constructor. It must be the first statement in that constructor. When you create an instance of a subclass, the constructor of the superclass is automatically called first to ensure that the inherited properties and behaviors are properly initialized. You can use super() in two ways:
1. To call the no-argument constructor of the parent class
2. To call a parameterized constructor of the parent class by passing the appropriate arguments.
In the provided code snippet, we have two classes, A and B. Class B extends class A.
Note: Class having no child takes Object as parent class by default. So, class A is extending Object class implicitly. 
For example, `class A extends Object` thats why we can call super() in class A to invoke the constructor of Object class, and we can call super() in class B to invoke the constructor of class A. This demonstrates how constructors are chained in an inheritance hierarchy, ensuring that each class's constructor is executed in the correct order to properly initialize the objects.

* this() is a keyword in Java that refers to the current instance of the class. It is used to call another constructor within the same class, allowing you to reuse code and avoid duplication when initializing objects. When you use this() in a constructor, it must be the first statement in that constructor, and it can only be used to call another constructor in the same class. This is useful for providing multiple ways to initialize an object while keeping the code organized and maintainable.
Note: 
1. this() cannot be used in a static context because it refers to the current instance of the class, and static methods and blocks do not belong to any instance. Therefore, you cannot use this() in a static method or static block, as there is no instance to refer to in that context.
2. In a constructor, you can use either super() or this(), but not both. This is because both super() and this() must be the first statement in a constructor, and you cannot have two first statements. If you need to call a constructor from the parent class, you should use super(), and if you need to call another constructor within the same class, you should use this(). However, you cannot use both in the same constructor, as it would create ambiguity and violate the requirement that they must be the first statement.
*/

class A {
    public A() {
        super(); // Calls Object's constructor
        System.out.println("In A");
    }

    public A(int x) {
        // super(x); // Object class does not have a constructor that takes an int parameter, so we cannot call super(x) here. 
        super(); // Instead, we can call the no-argument constructor of Object using super() and then handle the integer parameter in class A
        System.out.println("In A with parameter: " + x);
    }
}

class B extends A {
    public B() {
        super(); // Calls A's constructor
        System.out.println("In B");
    }

    public B(int x) {
        this(); // Calls B's no-argument constructor
        // super(x); // Calls A's constructor with an integer parameter
        System.out.println("In B with parameter: " + x);
    }
}

public class CJ_8_Demo {
    public static void main(String[] args) {
        B b = new B();
        // B b2 = new B(5);
    }
}
