/*
    * In Java, a static variable (also known as a class variable) is a variable that belongs to the class rather than to any specific instance of the class. This means that all instances of the class share the same static variable. When you change the value of a static variable, it changes for all instances of the class.

    * In the following code, we will demonstrate how to use a static variable to count the number of objects created from a class. We will create a class called DemoC with a static variable countObjects that increments every time a new object is created. We will also include a method to reset the counter and display the count of objects created.
*/
class DemoC {
    static int countObjects = 0;

    DemoC() {
        countObjects++;
    }
    
    static void ResetCounter() {
        countObjects = 0;
    }
}

public class CJ_4_Demo {

    public static void main(String[] args) {
        DemoC d1 = new DemoC();
        DemoC d2 = new DemoC();
        DemoC d3 = new DemoC();
        System.out.println("Number of DemoC objects created: " + DemoC.countObjects);
        System.out.println("Number of DemoC (d1) objects created: " + d1.countObjects);
        System.out.println("Number of DemoC (d2) objects created: " + d2.countObjects);
        System.out.println("Number of DemoC (d3) objects created: " + d3.countObjects);

        DemoC.ResetCounter();
        System.out.println("Number of DemoC objects after reset: " + DemoC.countObjects);
    }
}
