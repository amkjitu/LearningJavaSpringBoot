
/*
Phase of Butterfly's Life Cycle: Egg -> Larva (Caterpillar) -> Pupa (Chrysalis) -> Adult (Butterfly)
* Method Overriding and Polymorphism in Java
Method Overriding: Method overriding occurs when a subclass provides a specific implementation for a method that is already defined in its superclass. The method in the subclass must have the same name, return type, and parameters as the method in the superclass. This allows the subclass to provide its own behavior while still maintaining the same method signature. 

* Polymorphism: Polymorphism is the ability of an object to take on many forms. In Java, polymorphism is achieved through method overriding, where a subclass can provide a specific implementation of a method that is defined in its superclass.

* When a method is called on an object, the JVM determines which version of the method to execute based on the actual type of the object at runtime. This is known as dynamic method dispatch. Polymorphism allows for flexibility and extensibility in code, as it enables objects of different classes to be treated as objects of a common superclass, while still allowing for specific behaviors to be defined in each subclass.
Note: Method Overloading is a compile-time polymorphism, while Method Overriding is a runtime polymorphism.

* Upcasting: Upcasting is the process of converting a subclass reference to a superclass reference. This is done implicitly in Java and allows you to treat an object of a subclass as if it were an object of its superclass. Upcasting is useful when you want to take advantage of polymorphism, as it allows you to call overridden methods on the superclass reference, which will execute the subclass's implementation of the method.
Rule: When a child object is assigned to a parent reference

* Downcasting: Downcasting is the process of converting a superclass reference back to a subclass reference. This is done explicitly in Java and requires a cast. Downcasting can be dangerous if not done carefully, as it can lead to a ClassCastException if the object being downcasted is not actually an instance of the subclass. It is important to ensure that the object being downcasted is indeed an instance of the subclass before performing the downcast.
Rule: When a parent reference is forced to become child type

Simple Rule to Remember:
✅ Java ALWAYS uses: Actual object type, not reference type
✅ Method execution depends on OBJECT TYPE, not reference type

✅ Allowed: Parent ref = new Child();
❌ Not allowed: Child ref = new Parent();
✅ Allowed with cast (only if actual object is child): Child ref = (Child) parentRef;

Think of it like this:
A son is a father’s family member
But a father is not necessarily the son.
*/
class Egg {
    public void config() {
        System.out.println("Configuring Egg...");
    }
    public void show() {
        System.out.println("Hello from Egg!");
    }
}

class Caterpillar extends Egg {
    public void config() {
        System.out.println("Configuring Caterpillar...");
    }
    public void show() {
        System.out.println("Hello from Caterpillar!");
    }
}

public class CJ_9_Demo {
    public static void main(String[] args) {
        // /// 1. Create instances of Egg and Caterpillar classes 
        // Egg eg = new Egg();
        // Caterpillar ca = new Caterpillar();

        // /// 2. Calling methods on class Egg
        // eg.show(); // Output: Hello from class Egg!
        // eg.config(); // Output: Configuring class Egg...

        // /// 3. Calling methods on class Caterpillar
        // // Since class Caterpillar overrides the methods of class Egg, the overridden methods in class Caterpillar will be executed when called on an instance of class Caterpillar.
        // ca.show(); // Output: Hello from class Caterpillar!
        // ca.config(); // Output: Configuring class Caterpillar...

        // /// 4. Polymorphism: When we create a reference of type Egg and assign it an instance of Caterpillar, we can still call the show() and config() methods on that reference. However, since the actual object is of type Caterpillar, the overridden methods in the Caterpillar class will be executed instead of the methods in the Egg class. This demonstrates polymorphism, where the method that gets executed is determined at runtime based on the actual type of the object rather than the type of the reference variable.
        // Upcasting: We are assigning an instance of the subclass (Caterpillar) to a reference variable of the superclass (Egg). This is allowed in Java and is known as upcasting. The reference variable of type Egg can refer to an object of type Caterpillar because Caterpillar is a subclass of Egg.
        // Egg eggpoli = new Caterpillar();
        // eggpoli.show(); // Output: Hello from class Caterpillar! (dynamic method dispatch)
        // eggpoli.config(); // Output: Configuring class Caterpillar! (dynamic method dispatch)

        // Above, we have an example of upcasting where we assign an instance of the subclass (Caterpillar) to a reference variable of the superclass (Egg). This allows us to call the overridden methods on the superclass reference, and the JVM will determine at runtime which version of the method to execute based on the actual type of the object (Caterpillar in this case):
        // Caterpillar extends Egg
        // That means Caterpillar IS-A Egg
        // Every Caterpillar is an Egg (because it extends Egg)
        // A child class inherits from the parent class.
        
        // /// 5. Can child reference ever point to parent? 
        // Caterpillar caterpoli = new Egg(); // This will cause a compile-time error because we cannot assign a superclass reference (Egg) to a subclass reference (Caterpillar). This is not allowed in Java because it violates the principle of type safety. The compiler will not allow this assignment because it cannot guarantee that the object being assigned is actually an instance of the subclass (Caterpillar).
        
        // Caterpillar caterpolii = (Caterpillar) new Egg(); //This will cause Runtime Exception in thread "main" java.lang.ClassCastException: class Egg cannot be cast to class Caterpillar (Egg and Caterpillar are in unnamed module of loader 'app')
        
        // Yes, only with explicit casting, and only if the object is actually a child object.
        Egg egg = new Caterpillar(); // upcasting
        Caterpillar catter = (Caterpillar) egg; // downcasting
        catter.show();
        catter.config();
        // In this example, we first create an instance of the Caterpillar class and assign it to a reference variable of type Egg (upcasting). Then, we explicitly cast the Egg reference back to a Caterpillar reference (downcasting) and call the show() and config() methods. Since the actual object is still a Caterpillar, the overridden methods in the Caterpillar class will be executed successfully without any exceptions.

        ///6. For more better understanding, please refer to the detailed explanation as following;
        /*
        =============================================
        PRIMITIVE CASTING vs OBJECT CASTING IN JAVA
        =============================================
        The key difference is: Primitive casting (double -> int) and Object casting (Egg -> Caterpillar) are fundamentally DIFFERENT mechanisms.
        
        Let's break it down carefully.
        ------------------------------------------
        1. WHY THIS WORKS?
        ------------------------------------------
        
        double a = 10.3;
        int b = (int) a;
        
        
        Here:
        
        10.3 -> 10
        No problem.
        
        Why?
        
        Because `double` and `int` are PRIMITIVE NUMERIC TYPES.
        Java already knows mathematically how to convert them.
        
        This is called PRIMITIVE TYPE CONVERSION
        
        
        You are NOT changing the identity of the value.
        You are only changing the REPRESENTATION.
        
        
        Example:
        
        10.3 (double)
            |
            v
        10 (int)
        
        
        Java simply truncates the decimal part.
        No object relationship is involved.
        
        
        --------------------------------------
        2. WHY THIS COMPILES?
        --------------------------------------
        
        Caterpillar caterpolii = (Caterpillar) new Egg();
        
        
        Surprisingly: [YES] It compiles
        BUT [NO] It crashes at runtime
        
        
        Error: ClassCastException
        
        
        Why?
        
        Because Java says:
        
        "Okay, you are explicitly forcing the cast.
        I'll trust you."
        
        But at runtime Java verifies whether the object is ACTUALLY a Caterpillar. It is NOT.
        
        ----------------------------------
        WHAT IS HAPPENING INTERNALLY?
        ----------------------------------
        
        You create:
        
        new Egg()
        
        
        Actual object:
        
        +--------------+
        |  Egg object  |
        +--------------+
        
        
        Then you say:
        
        (Caterpillar)
        
        
        Java checks: "Is this Egg object actually a Caterpillar?"
        
        Answer: NO
        
        
        Result: ClassCastException
        
        ---------------------------
        MEMORY VISUALIZATION
        ---------------------------
        
        Egg egg = new Egg();
        
        
        Memory:
        
        Egg reference
            |
            v
        +--------------+
        |  Egg object  |
        +--------------+
        
        
        Now:
        
        Caterpillar cat = (Caterpillar) egg;
        
        
        Java asks:
        
        "Is the object really a Caterpillar?"
        
        NO
        
        Result: CRASH
        
        
        
        ----------------------------------------------------------
        3. THEN WHY THIS WORKS?
        ----------------------------------------------------------
        
        Egg egg = new Caterpillar();
        
        Caterpillar cat = (Caterpillar) egg;
        
        
        Because:
        
        The ACTUAL object is:
        
        +----------------------+
        | Caterpillar object   |
        +----------------------+
        
        
        Even though reference type is Egg.
        
        
        Memory:
        
        Egg reference
            |
            v
        +----------------------+
        | Caterpillar object   |
        +----------------------+
        
        
        Java checks: "Is this object actually a Caterpillar?"
        
        YES
        
        Result: Casting succeeds.
        
        
        
        ----------------------------------------------------------
        4. BIGGEST MISUNDERSTANDING
        ----------------------------------------------------------
        
        You may think:
        
        "If explicit cast works for primitive types,
        why not objects?"
        
        
        Because: OBJECT CASTING != VALUE CONVERSION
        Object casting is about changing the REFERENCE TYPE, not converting the actual object.
        
        Primitive cast: double -> int
        means: Convert value representation
        
        
        Object cast: Egg -> Caterpillar
        
        means: Tell Java to treat the SAME object as another type.

        NO new object is created.        
        
        This line: (Caterpillar) new Egg()
        
        
        DOES NOT transform:
        
        Egg object -> Caterpillar object
        
        
        Java is NOT doing conversion.
        
        
        Java only says:
        
        "Treat this object as Caterpillar"
        
        
        But the object is STILL an Egg.
        
        --------------------------
        REAL LIFE ANALOGY
        --------------------------
        
        Person p = new Teacher();
        Teacher t = (Teacher) p;     // VALID
        
        
        Works because the person IS ACTUALLY a Teacher.
        
        
        But:
        
        Person p = new Person();
        Teacher t = (Teacher) p;     // INVALID
        
        You cannot magically turn
        a random person into a Teacher
        just by casting.
        
        
        Casting changes: REFERENCE VIEW
        
        Casting does NOT change: ACTUAL OBJECT
        
        ----------------------------------------------------------
        SAFE WAY (RECOMMENDED)
        ----------------------------------------------------------
        
        Before downcasting:
        
        
        if (egg instanceof Caterpillar) {
            Caterpillar cat = (Caterpillar) egg;
        }
        
        
        This prevents: ClassCastException
        
        ----------------------------------------------------------
        CORE DIFFERENCE SUMMARY
        ----------------------------------------------------------
        
        +-----------------------------+------------------------------+
        | Primitive Cast              | Object Cast                  |
        +-----------------------------+------------------------------+
        | Converts value              | Changes reference view       |
        | 10.3 -> 10                  | Same object, different type  |
        | Mathematical conversion     | Requires inheritance         |
        | No runtime identity check   | Runtime type check required  |
        +-----------------------------+------------------------------+
        
        ==========================================================
        FINAL RULE TO REMEMBER
        ==========================================================
        
        Primitive Casting: Changes VALUE
        
        Object Casting: Changes REFERENCE TYPE
        
        Actual object NEVER changes.
        ==========================================================
        */

    }
}
