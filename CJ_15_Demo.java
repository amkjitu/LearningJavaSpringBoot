/*
Application -> OS -> CPU
Task -> Process -> Thread
* Task: A task is a unit of work that needs to be done. It can be a simple operation or a complex set of operations. Tasks are typically defined by the application and can be executed by the operating system.

* Multi-tasking: The ability of an operating system to execute multiple tasks concurrently. This can be achieved through various scheduling algorithms that allow the CPU to switch between tasks efficiently, giving the illusion of simultaneous execution.

* Process: A process is an instance of a program that is being executed. It is a self-contained unit of execution that has its own memory space, system resources, and execution context. A process can contain multiple threads of execution.
Thread: A thread is a lightweight unit of execution that is part of a process. It shares the same memory space and system resources as other threads in the same process. Threads are used to perform tasks concurrently within a process, allowing for better performance and responsiveness in applications.

* Threading: The technique of using multiple threads to perform tasks concurrently within a process.
For example: A web browser can have multiple threads to handle different tasks such as rendering the user interface, handling user input, and fetching data from the internet. This allows the browser to remain responsive while performing multiple tasks simultaneously.
Thread Priority: The priority of a thread determines the order in which threads are scheduled for execution. Higher priority threads are given preference over lower priority threads when the CPU is allocating time for execution. However, thread scheduling is also influenced by other factors such as the operating system's scheduling algorithm and the availability of system resources.

For example: hiTask.setPriority(Thread.MAX_PRIORITY); // Setting the priority of hiTask to maximum
Here setPriority can take values from 1 to 10, where 1 is the lowest priority and 10 is the highest priority. The default priority is 5.

Now see here class HiTask extends Thread so if we need another class that is also needed to extend but it is not possible to extend two classes in Java. So we can use Runnable interface to achieve this. Runnable is a functional interface that has a single abstract method run() which can be implemented by any class to define the task that needs to be executed in a thread.
For example:
class HiTask implements Runnable {
    public void run() {
        for (int i = 0; i < 40; i++) {
            System.out.println("Hi");
        }
        System.out.println("Hi");
    }
}
    
* Race Condition: A race condition occurs when two or more threads access shared resources concurrently and the outcome of the execution depends on the timing of the threads. This can lead to unpredictable behavior and bugs in the application. To avoid race conditions, synchronization techniques such as locks, semaphores, and monitors can be used to ensure that only one thread can access the shared resource at a time.
For example: If two threads are trying to update the same variable at the same time, it can lead to a race condition where the final value of the variable is unpredictable. To avoid this, we can use synchronization techniques to ensure that only one thread can update the variable at a time. This is called thread safe programming.

* Different states of a thread:
1. New: The thread is created but not yet started.
2. Runnable: The thread is ready to run and is waiting for the CPU to allocate time for execution.
3. Running: The thread is currently executing.
4. Blocked: The thread is waiting for a resource or an event to occur before it can continue execution.
5. Terminated: The thread has completed its execution and is no longer active.

___________________________________________________________________________
|                     _________notify()______________________
|                    |                                       |
|                    |                                       |        
|       start()      v      run()           sleep()/wait()   |
|[New] --------> [Runnable] ----> [Running] -------------> [Waiting]
|                                     |      
|                                     |stop()               
|                                     |
|                                     v 
|                                   [Dead]
|__________________________________________________________________________                                 
                                       

*/
//1. Using Thread class
///Thread 1:
class HiTask extends Thread {
    public void run() {
        for (int i = 0; i < 40; i++) {
            System.out.println("Hi");
        }
        System.out.println("Hi");
    }
}

///Thread 2:
class HelloTask extends Thread {
    public void run() {
        for (int i = 0; i < 40; i++) {
            System.out.println("Hello");
            try {
                Thread.sleep(10); // Sleep for 10 milliseconds to allow other threads to execute
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Hello");
    }
}

//2. Using Runnable interface
///Thread 3:
class HeelloTask implements Runnable {
    public void run() {
        for (int i = 0; i < 40; i++) {
            System.out.println("Hello");
            try {
                Thread.sleep(10); // Sleep for 10 milliseconds to allow other threads to execute
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Hello");
    }
}

///Thread 4:
class HiiTask implements Runnable {
    public void run() {
        for (int i = 0; i < 40; i++) {
            System.out.println("Hi");
        }
        System.out.println("Hi");
    }
}

//3. Thread safety and synchronization
class Counter {
    private int count = 0;

    // public void increment() {
    //     count++;
    // }

    // 3.2: synchronized keyword is used to ensure that only one thread can access a block of code at a time. This is useful when we want to ensure that only one thread can access a shared resource at a time to avoid race conditions.
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class CJ_15_Demo {
    public static void main(String[] args) {
        // // 1. Using Thread class to create threads
        // HiTask hiTask = new HiTask();
        // HelloTask helloTask = new HelloTask();

        // // Setting the priority of hiTask to maximum
        // hiTask.setPriority(Thread.MAX_PRIORITY);

        // // Starting the threads
        // hiTask.start();

        // try {
        //     Thread.sleep(10); // Sleep for 10 milliseconds to allow hiTask to execute before starting helloTask
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        // helloTask.start();

        // //2. Using Runnable interface to create threads
        // HeelloTask heelloTask = new HeelloTask();
        // HiiTask hiiTask = new HiiTask();

        // Thread thread1 = new Thread(heelloTask);
        // Thread thread2 = new Thread(hiiTask);

        // thread1.start();
        // thread2.start();

        ///3. Thread safety and synchronization
        // We are expecting the final count to be 200 but now we are getting a different value every time we run the program because of the race condition. This is because both threads are trying to update the count variable at the same time and the outcome of the execution depends on the timing of the threads. To avoid this, we can use synchronization techniques to ensure that only one thread can access the increment method at a time. This is called thread safe programming.
        Counter counter = new Counter();
        Runnable task1 = () -> {
            for (int i = 0; i < 100; i++) {
                counter.increment();
            }
        };
        Runnable task2 = () -> {
            for (int i = 0; i < 100; i++) {
                counter.increment();
            }
        };

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();

        // Output of the count variable
        System.out.println("Final count: " + counter.getCount());

        // //3.1: join method is used to wait for a thread to die. It is used to ensure that a thread has completed its execution before the main thread continues with its execution. This is useful when we want to wait for a thread to complete before we can access the result of the thread's execution.
        // try {
        //     thread1.join(); // Wait for thread1 to complete its execution
        //     thread2.join(); // Wait for thread2 to complete its execution
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        // System.out.println("Final count: " + counter.getCount());

        //3.2: synchronized keyword is used to ensure that only one thread can access a block of code at a time. This is useful when we want to ensure that only one thread can access a shared resource at a time to avoid race conditions. e.g. in the above code we have used the synchronized keyword in the increment method to ensure that only one thread can access the increment method at a time. This is done to avoid race conditions and ensure that the final count is always 200 when both threads have completed their execution.
        try {
            thread1.join(); // Wait for thread1 to complete its execution
            thread2.join(); // Wait for thread2 to complete its execution
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final count: " + counter.getCount());
    }

}
