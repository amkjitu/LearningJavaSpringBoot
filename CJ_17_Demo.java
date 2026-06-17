/*
Stream API: A powerful feature introduced in Java 8 that allows for functional-style operations on collections of data. It provides a fluent and expressive way to process and manipulate data using a stream of elements.
The Stream API provides various methods for filtering, mapping, and reducing data in a functional programming style. It allows for operations such as map, filter, reduce, and collect, which can be used to perform complex data transformations and aggregations in a concise and readable manner.
Things to remember about Stream API:
    - Stream API is not a data structure, but rather a sequence of elements that can be processed in a functional style.
    - Stream API can be used with various data sources, such as collections, arrays, and I/O channels, to perform operations on the data in a declarative and efficient way.
    - Stream API provides both intermediate and terminal operations. Intermediate operations return a new stream, while terminal operations produce a result or side effect.
    - Stream API supports parallel processing, allowing for efficient execution of operations on large data sets by utilizing multiple threads.
    - Stream API can be used to perform operations such as filtering, mapping, sorting, and reducing data in a concise and readable manner, making it easier to write complex data processing logic.
    - Stream API is designed to work with functional interfaces, such as Predicate, Function, and Consumer, which can be used to define the behavior of stream operations using lambda expressions or method references.
    - One stream can only be consumed once. After a terminal operation is performed on a stream, it cannot be reused or modified.
    - Stream operations are lazy, meaning that they are not executed until a terminal operation is invoked on the stream.
    - Stream operations can be chained together to create complex data processing pipelines.
    

THINGS ARE NOT DIFFICULT THINGS ARE JUST UNFAMILIAR.
*/

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.function.Function;
import java.util.function.BinaryOperator;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class CJ_17_Demo {
    public static void main(String[] args) {
        // // first understand forEach loop
        // List<Integer> tumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // //Traditional for loop
        // for (int i = 0; i < tumbers.size(); i++) {
        //     System.out.println(tumbers.get(i));
        // }

        // // Enhanced for loop
        // for (Integer number : tumbers) {
        //     System.out.println(number);
        // }

        // // Using for each loop with lambda expression
        // tumbers.forEach(number -> System.out.println(number));

        // // Now Let's see how actually forEach is working with the above lambda expression.
        // Consumer<Integer> consumer = new Consumer<Integer>() {
        //     @Override
        //     public void accept(Integer number) {
        //         System.out.println(number);
        //     }
        // };
        // tumbers.forEach(consumer);
        // // The above forEach method takes a Consumer functional interface as an argument, which represents an operation that accepts a single input argument and returns no result. In this case, the lambda expression number -> System.out.println(number) is passed as the Consumer, which prints each number in the list. The forEach method iterates over each element in the list and applies the provided Consumer to it, resulting in the printing of each number.
        
        // // Example double of even numbers and sum them up using traditional for loop
        // List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // int sum = 0;
        // for (Integer number : numbers) {
        //     if (number % 2 == 0) {
        //         int doubled = number * 2;
        //         sum += doubled;
        //     }
        // }
        // System.out.println("Sum of double of even numbers: " + sum);

        // // Example of double of even numbers and sum them up using Stream API to filter and map a list of integers
        // Stream<Integer> numberStream = numbers.stream();

        // // strams can't be reused
        // numberStream.forEach(System.out::println);
        // // numberStream.forEach(System.out::println); //IllegalStateException: stream has already been operated upon or closed

        // // Example of Stream API
        // Stream<Integer> s1 = numbers.stream();
        // Stream<Integer> s2 = s1.filter(n-> n%2==0); //even numbers
        // Stream<Integer> s3 = s2.map(n -> n * 2); //double of even numbers
        // int sumOfDoubleEvenNumbers = s3.reduce(0, (a, b) -> a + b); //sum of double of even numbers
        // System.out.println("Sum of double of even numbers using Stream API: " + sumOfDoubleEvenNumbers);

        // // Example of Stream API with method chaining
        // int sumOfDoubleEvenNumbersChained = numbers.stream()
        //         .filter(n -> n % 2 == 0) // even numbers
        //         .map(n -> n * 2) // double of even numbers
        //         .reduce(0, Integer::sum); // sum of double of even numbers
        // System.out.println("Sum of double of even numbers using Stream API with method chaining: "
        //         + sumOfDoubleEvenNumbersChained);

        // // Now let's see how filter, map and reduce are working with the above lambda expression.
        // // filter method takes a Predicate functional interface as an argument, which represents a boolean-valued function of one argument. In this case, the lambda expression n -> n % 2 == 0 is passed as the Predicate, which checks if a number is even. The filter method returns a new stream that contains only the elements that satisfy the given predicate.
        // // map method takes a Function functional interface as an argument, which represents a function that accepts one argument and produces a result. In this case, the lambda expression n -> n * 2 is passed as the Function, which doubles each number. The map method returns a new stream that contains the results of applying the given function to the elements of the stream.
        // // reduce method takes a BinaryOperator functional interface as an argument, which represents an operation upon two operands of the same type, producing a result of the same type. In this case, the lambda expression (a, b) -> a + b is passed as the BinaryOperator, which sums two numbers. The reduce method performs a reduction on the elements of the stream using the provided binary operator and returns an Optional describing the reduced value, or an empty Optional if the stream is empty. In this example, we also provide an identity value of 0, which is returned if the stream is empty.
        // Predicate <Integer> isEven = new Predicate<Integer>() {
        //     @Override
        //     public boolean test(Integer n) {
        //         return n % 2 == 0;
        //     }
        // };
        // // Predicate<Integer> isEven = n -> n % 2 == 0; // lambda expression for Predicate functional interface
        // Function<Integer, Integer> doubleIt = new Function<Integer, Integer>() {
        //     @Override
        //     public Integer apply(Integer n) {
        //         return n * 2;
        //     }
        // };
        // // Function<Integer, Integer> doubleIt = n -> n * 2; // lambda expression for Function functional interface
        // BinaryOperator<Integer> sumIt = new BinaryOperator<Integer>() {
        //     @Override
        //     public Integer apply(Integer a, Integer b) {
        //         return a + b;
        //     }
        // };
        // // BinaryOperator<Integer> sumIt = (a, b) -> a + b; // lambda expression for BinaryOperator functional interface

        // // Example of Stream API with method chaining by implementing the above functional interfaces
        // int sumOfDoubleEvenNumbersChained1 = numbers.stream()
        //         .filter(isEven) // even numbers
        //         .map(doubleIt) // double of even numbers
        //         .reduce(0, sumIt); // sum of double of even numbers
        // System.out.println("Sum of double of even numbers using Stream API with method chaining: "
        //         + sumOfDoubleEvenNumbersChained1);

        // // Example of Stream API with parallel processing. This use actually uses multiple threads to process the stream in parallel, which can improve performance for large data sets.
        // int sumOfDoubleEvenNumbersParallel = numbers.parallelStream()
        //         .filter(n -> n % 2 == 0) // even numbers
        //         .map(n -> n * 2) // double of even numbers
        //         .reduce(0, Integer::sum); // sum of double of even numbers
        // System.out.println("Sum of double of even numbers using Stream API with parallel processing: "
        //         + sumOfDoubleEvenNumbersParallel);

        // When we should not use Parallel Stream?
        // Such as when we are working with sequential data processing for example Sorting.
        // Stream<Integer> sortedStream = numbers.parallelStream()
        //         .sorted(); // sorting is a sequential operation
        // System.out.println("Sorted numbers using Parallel Stream:");
        // sortedStream.forEach(System.out::println);

        // // When we should use Parallel Stream?
        // // Such as when we are working with large data sets and performing computationally intensive operations that can be easily parallelized, such as filtering, mapping, and reducing operations on large collections of data.
        // List<Integer> largeNumbers = new ArrayList<>(100000);
        // Random random = new Random();
        // for (int i = 1; i <= 100000; i++) {
        //     largeNumbers.add(random.nextInt(1000000));
        // }
        // long startTime = System.currentTimeMillis();
        // long sumOfLargeNumbersParallel = largeNumbers.parallelStream()
        //         .filter(n -> n % 2 == 0) // even numbers
        //         .mapToLong(n -> n * 2L) // double of even numbers
        //         .reduce(0L, Long::sum); // sum of double of even numbers
        // long endTime = System.currentTimeMillis();
        // System.out.println("Sum of double of even numbers using Parallel Stream: " + sumOfLargeNumbersParallel);
        // System.out.println("Time taken: " + (endTime - startTime) + " ms");

        // // Now we will do the same thing using sequential stream to compare the performance.
        // startTime = System.currentTimeMillis();
        // long sumOfLargeNumbersSequential = largeNumbers.stream()
        //         .filter(n -> n % 2 == 0) // even numbers
        //         .mapToLong(n -> n * 2L) // double of even numbers
        //         .reduce(0L, Long::sum); // sum of double of even numbers
        // endTime = System.currentTimeMillis();
        // System.out.println("Sum of double of even numbers using Sequential Stream: " + sumOfLargeNumbersSequential);
        // System.out.println("Time taken: " + (endTime - startTime) + " ms");
        // // We are expecting that the parallel stream will take less time than the sequential stream for processing the large data set, but this will not because parallel steam is responsible for creating and managing multiple threads. that is why for this small amount data set the parallet stream is taking more time than the sequential stream. So, it is important to consider the size of the data set and the nature of the operations being performed when deciding whether to use a parallel stream or a sequential stream.

        // In this example, we will see the actual performance difference between parallel and sequential streams for a large data set by adding some delay. We will measure the time taken for each operation to compare the performance of parallel and sequential streams.

        List<Integer> largeNumbers2 = new ArrayList<>(100000);
        Random random = new Random();
        for (int i = 1; i <= 100000; i++) {
            largeNumbers2.add(random.nextInt(1000000));
        }
        long startTime = System.currentTimeMillis();
        long sumOfLargeNumbersParallel2 = largeNumbers2.parallelStream()
                .filter(n -> n % 2 == 0) // even numbers
                .mapToLong(n -> {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return n * 2L;
                }) // double of even numbers
                .reduce(0L, Long::sum); // sum of double of even numbers
        long endTime = System.currentTimeMillis();
        System.out.println("Sum of double of even numbers using Parallel Stream: " + sumOfLargeNumbersParallel2);
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
        long startTime2 = System.currentTimeMillis();
        long sumOfLargeNumbersSequential2 = largeNumbers2.stream()
                .filter(n -> n % 2 == 0) // even numbers
                .mapToLong(n -> {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return n * 2L;
                }) // double of even numbers
                .reduce(0L, Long::sum); // sum of double of even numbers
        long endTime2 = System.currentTimeMillis();
        System.out.println("Sum of double of even numbers using Sequential Stream: " + sumOfLargeNumbersSequential2);
        System.out.println("Time taken: " + (endTime2 - startTime2) + " ms");

    }
}
