/*
    * How actually non-static variables in static methods are accessed? We know that static methods cannot access non-static variables directly because they do not belong to any instance of the class. However, we can access non-static variables in a static method by creating an instance of the class or by passing an object reference as a parameter to the static method. This way, we can use the object reference to access the non-static variables through the instance of the class.
*/
class Mobile {
    String brand;
    int price;
    static String mobileType = "Smartphone"; // Static variable shared by all instances of Mobile

    //1. Instance method to display mobile details. This method can access both instance variables (brand, price) and the static variable (mobileType). As the mobileType is static, it will be the same for all Mobile objects that's why we can access it in the instance method as well.
    public void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Price: " + price);
        System.out.println("Mobile Type: " + mobileType);
    }

    //2. Static method to display mobile type. This method can only access static variables and cannot access instance variables directly. As the static mathod does not know actually which object's brand and price to display, it can only display the static variable mobileType.
    public static void display1() {
        // System.out.println("Brand: " + brand); //uncomment this line to see the error: non-static variable brand cannot be referenced from a static context
        // System.out.println("Price: " + price); //uncomment this line to see the error: non-static variable price cannot be referenced from a static context
        System.out.println("Mobile Type: " + mobileType);
    }

    //3. Solve above problem "non-static variable brand cannot be referenced from a static context" of static method by passing an object reference as a parameter to the static method. This way, we can access the instance variables through the object reference.
    public static void display2(Mobile m) {
        System.out.println("Brand: " + m.brand);
        System.out.println("Price: " + m.price);
        System.out.println("Mobile Type: " + mobileType);
    }

}

public class CJ_5_Demo {
    public static void main(String[] args) {
        
        //1. Create two Mobile objects and set their instance variables. The static variable mobileType will be the same for both objects since it belongs to the class.
        Mobile m1 = new Mobile();
        m1.brand = "Apple";
        m1.price = 999;
        Mobile.mobileType = "Smartphone"; // Static variable accessed through class name

        Mobile m2 = new Mobile();
        m2.brand = "Samsung";
        m2.price = 899;

        // Display details of both mobiles
        System.out.println("Mobile 1:");
        m1.display();

        System.out.println("\nMobile 2:");
        m2.display();

        //2. nothing to do with display1() as it only displays the static variable mobileType which is same for both objects and can be accessed directly without creating an object reference.

        //3. Accessing instance variables in a static method by passing an object reference.
        System.out.println("\nAccessing instance variables in static method:");
        Mobile.display2(m1);
        Mobile.display2(m2);

    }
}
