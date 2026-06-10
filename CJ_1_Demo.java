/*
    * This file demonstrates the JVM memory model with a simple Calculator class and a main method that uses it.
    * It illustrates how classes, objects, and method calls(method overloading) are represented in Metaspace, Heap, and Thread Stack.
*/
class Calculator {

    // Stored inside each Calculator object on Heap.
    int instanceVariable;

    // Method metadata/bytecode is in Metaspace; params and return value use stack frame data at runtime.
    public int add(int a, int b) {
        return a + b;
    }
    
    // Overloaded method also has separate metadata in Metaspace; double values use wider stack slots.
    public double add(double a, double b) {
        return a + b;
    }
}

class CJ_1_Demo {
    /*
    * JVM memory map for this file (detailed visual):
     *
     * +------------------------- METASPACE -------------------------+
    * | Class metadata + constant pool + method bytecode             |
    * | - Calculator class                                            |
    * |   - field: instanceVariable:int                               |
    * |   - method: add(II)I                                          |
    * |   - method: add(DD)D                                          |
    * | - Demo class                                                  |
    * |   - method: main([Ljava/lang/String;)V                        |
     * +-------------------------------------------------------------+
     *
     * +--------------------------- HEAP ----------------------------+
    * | Calculator@A (created by new Calculator())                   |
    * | - object header (JVM internal)                               |
    * | - instanceVariable = 0 (default int value)                   |
     * | String literals (interned):                                  |
     * | - "Hello, World!"                                            |
     * | - "The result of addition is: "                              |
     * | - "The result of double addition is: "                       |
    * | args array object (created by JVM launcher)                  |
     * +-------------------------------------------------------------+
     *
     * +---------------------- THREAD STACK -------------------------+
     * | main frame                                                   |
     * | - args   -> String[] object                                  |
     * | - a      = 5                                                 |
     * | - b      = 5                                                 |
     * | - calc   -> Calculator@A                                     |
     * | - result = 10                                                |
     * | - result1= 10.0                                              |
    * | - operand stack used temporarily during calls/println         |
     * |                                                              |
     * | add(int,int) frame (during call)                             |
     * | - this -> Calculator@A, a=5, b=5, return 10                 |
    * | - bytecode idea: iload_1, iload_2, iadd, ireturn             |
     * |                                                              |
     * | add(double,double) frame (during call)                       |
     * | - this -> Calculator@A, a=5.0, b=5.0, return 10.0           |
    * | - bytecode idea: dload_1, dload_3, dadd, dreturn             |
    * +-------------------------------------------------------------+
    *
    * Execution flow summary:
    * 1) Classes load -> metadata in Metaspace.
    * 2) main frame pushed on stack.
    * 3) Calculator object allocated on Heap; calc stores reference.
    * 4) Each add(...) call pushes a new frame, returns value, then pops.
    * 5) main ends; calc reference dies; Calculator@A becomes GC-eligible.
     * +-------------------------------------------------------------+
     */
    // main method metadata is in Metaspace; execution creates a stack frame for local variables.
    public static void main(String[] args) {
        
        System.out.println("Hello, World!");
        // Primitive locals are stored directly in the main stack frame.
        int a, b;
        a = 5;
        b = 5;

        // Reference variable (stack) -> Calculator object (heap).
        Calculator calc = new Calculator();
        // result is primitive in stack; add(...) call creates/pops its own stack frame.
        int result = calc.add(a, b);
        System.out.println("The result of addition is: " + result);
        
        // double primitive local in stack; object reference still points to same heap object.
        double result1 = calc.add(5.0, 5.0);
        System.out.println("The result of double addition is: " + result1);


    }
}