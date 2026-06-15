
/*
 Collection: In Java, Collection is a framework that provides an architecture to store and manipulate a group of objects. It includes various classes and interfaces that allow developers to work with data structures such as lists, sets, queues, and maps. The Collection framework provides methods for adding, removing, and accessing elements in these data structures, making it easier to manage and manipulate collections of objects in Java.
 
 Collections: The Collections class is a utility class in the java.util package that provides static methods for working with collections, such as sorting and searching. It includes methods for performing various operations on collections, such as sorting, shuffling, reversing, and finding the maximum or minimum element in a collection. The Collections class also provides methods for creating synchronized (thread-safe) collections and unmodifiable collections.

 * Key points to remember:
    - The Collection framework is part of the java.util package and includes interfaces such as List, Set, Queue, and Map, as well as classes that implement these interfaces, such as ArrayList, HashSet, LinkedList, and HashMap.
    - Collections in Java can be used to store and manipulate groups of objects, providing methods for adding, removing, and accessing elements in these data structures.
    - The Collection framework provides a standard way to work with data structures in Java, making it easier for developers to manage and manipulate collections of objects in their applications.
    - Collection is not iterable, but it is a superinterface of List, Set, and Queue, which are all iterable. This means that while you cannot directly iterate over a Collection, you can iterate over its subinterfaces (List, Set, Queue) using an iterator or enhanced for loop.

* The difference between Collection and Collections in Java is that:
    - Collection is an interface in the java.util package that represents a group of objects, while Collections is a utility class that provides static methods for working with collections, such as sorting and searching. e.g., Collection<String> collection = new ArrayList<>(); Collections.sort(list);

______________________________________________________________________________________
|                             Collection                          |
|                                 |                               | 
|        +------------------------+-----------------+             |
|      List,                     Set,             Queue,          |   Map
|        |                        |                 |             |    |
|   ArrayList,                  HashSet,          Deque,          |   HashMap,
|   LinkedList, Vector          LinkedHashSet,    PriorityQueue   |   HashTable,
|                 |             TreeSet                           |   TreeMap
|                 v                                               |   
|               Stack                                             |
|_________________________________________________________________|___________________

* List: A collection that maintains an ordered sequence of elements. It allows duplicate elements and provides methods to access elements based on their index.
* ArrayList: A resizable array implementation of the List interface. It allows for dynamic resizing and provides fast access to elements based on their index.
* LinkedList: A doubly-linked list implementation of the List interface. It allows for efficient insertion and deletion of elements, but it may have slower access times compared to ArrayList due to its linked structure.
* Vector: A synchronized resizable array implementation of the List interface. It is similar to ArrayList but is thread-safe, making it suitable for use in multi-threaded environments.
* Stack: A collection that follows the Last-In-First-Out (LIFO) principle. It is implemented by the Stack class, which uses a vector to store the elements. A Stack does not allow null values.

* Set: A collection that does not allow duplicate elements. It is implemented by the HashSet class, which uses a hash table to store the elements. A Set does not maintain any order of the elements, and it does not allow null values.
* HashSet: A hash table implementation of the Set interface. It does not allow duplicate elements and does not maintain any order of the elements, and it does not allow null values.
* LinkedHashSet: A hash table implementation of the Set interface that maintains the order of elements based on their insertion order. It does not allow duplicate elements.
* TreeSet: A sorted set implementation of the Set interface. It does not allow duplicate elements and maintains the elements in sorted order based on their natural ordering or a specified comparator.

* Queue: A collection that follows the First-In-First-Out (FIFO) principle. It is implemented by the LinkedList class, which can be used as a queue. A Queue does not allow null values.
* Deque: A double-ended queue that allows for insertion and removal of elements from both ends. It is implemented by the LinkedList class, which can be used as a deque. A Deque does not allow null values.
* PriorityQueue: A queue that orders its elements based on their natural ordering or a specified comparator. It does not allow null values and does not maintain any order of the elements.

* Map: A collection that stores key-value pairs. It is implemented by the HashMap class, which uses a hash table to store the elements. A Map does not allow duplicate keys, but it allows duplicate values. It does not maintain any order of the elements.
* HashMap: A hash table implementation of the Map interface. It does not allow duplicate keys, but it allows duplicate values. It does not maintain any order of the elements.
* HashTable: A synchronized hash table implementation of the Map interface. It is similar to HashMap but is thread-safe, making it suitable for use in multi-threaded environments. It does not allow duplicate keys, but it allows duplicate values. It does not maintain any order of the elements.
* TreeMap: A sorted map implementation of the Map interface. It does not allow duplicate keys, but it allows duplicate values. It maintains the keys in sorted order based on their natural ordering or a specified comparator.

Comparator: An interface in Java that defines a method for comparing two objects. It is used to provide a custom ordering for objects when sorting or searching in collections. The Comparator interface has a single method, compare(), which takes two objects as arguments and returns a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.

Comparable: An interface in Java that defines a method for comparing the current object with another object of the same type. It is used to provide a natural ordering for objects when sorting or searching in collections. The Comparable interface has a single method, compareTo(), which takes an object as an argument and returns a negative integer, zero, or a positive integer as the current object is less than, equal to, or greater than the specified object.

      
*/
import java.util.Collection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Stack;
import java.util.Collections;
import java.util.Comparator;

// Person class is a simple class that represents a person with a name and an age. It has a constructor to initialize the name and age, and getter methods to retrieve the name and age of the person.
// class Person implements Comparable<Person>{
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // 1. So we can implement out own comparator to sort the list of Person objects based on their ages in ascending order by implementing the Comparable interface and overriding the compareTo method to compare the ages of the Person objects. 
    // Here only Collections.sort() method of Collections class can be used to sort the list of Person objects based on their ages in ascending order.
    // @Override
    // public int compareTo(Person that) {
    //     if (this.getAge() > that.getAge())
    //         return 1;
    //     else
    //         return -1;
    // }

    // 2. Alternatively, we can also create a custom comparator using the Comparator interface to sort the list of Person objects based on their ages in ascending order. 
    // But here Collections.sort(object, comparator) method is used to sort the list of Person objects based on their ages in ascending order.
    public static Comparator<Person> comparatorSortByAge() {
        return new Comparator<Person>() {
            @Override
            public int compare(Person a, Person b) {
                if (a.getAge() > b.getAge())
                    return 1;
                else
                    return -1;
            }
        };
    }
}

public class CJ_16_Demo {
    public static void main(String[] args) {
        /// A. Collection Framework in Java
        // // 1. Raw Collection: A raw collection is a collection that does not specify a type parameter. It can hold any type of object, but it is not type-safe and can lead to runtime errors if the wrong type of object is added to the collection.
        // Collection list = new ArrayList<>();
        // list.add("Hello");
        // list.add("World");
        // list.add("Java");
        // System.out.println("List: " + list);
        // for (Object element : list) {
        //     System.out.println(element);
        // }

        // // 2. Generic Collection: A generic collection is a collection that specifies a type parameter. It is type-safe and can only hold objects of the specified type, which helps to prevent runtime errors.
        // Collection<String> genericList = new ArrayList<>();
        // genericList.add("Hello");
        // genericList.add("World");
        // genericList.add("Java");
        // System.out.println("Generic List: " + genericList);
        // for (String element : genericList) {
        //     System.out.println(element);
        // }

        // // 2.1 On top of Collection we have iterable, which is an interface that allows us to iterate over a collection of objects. It provides a method called iterator() that returns an iterator object, which can be used to iterate over the elements in the collection. The Iterable interface is implemented by the Collection interface, which means that all collections in Java are iterable.
        // Iterator<String> iterableList = genericList.iterator();
        // while (iterableList.hasNext()) {
        //     System.out.println(iterableList.next());
        // }

        // // 2.2 As Collection is not iterable but List, Set, and Queue are iterable, we can create a List of integers and add some elements to it then iterate over it using for loop
        // List<Integer> listOfNum = new ArrayList<Integer>();
        // listOfNum.add(1);
        // listOfNum.add(3);
        // listOfNum.add(3);
        // listOfNum.add(4);
        // System.out.println("List: " + listOfNum);
        // for (int i = 0; i < listOfNum.size(); i++) {
        //     System.out.println(listOfNum.get(i));  //returns the element at the specified position in this list.
        //     // System.out.println(listOfNum.indexOf(i)); //returns the index of the 1st occurance of the element.
        // }

        // // 2.3 Stack: A Stack is a collection that follows the Last-In-First-Out (LIFO) principle. It is implemented by the Stack class, which uses a vector to store the elements. A Stack does not allow null values.
        // Stack<Character> stack = new Stack<Character>();
        // System.out.println("Enter a string: ");
        // Scanner sc = new Scanner(System.in);
        // String in = sc.nextLine(); // "[(()){()}`{}]"
        // sc.close();
        // for (char c : in.toCharArray()) {
        //     if (c == '(' || c == '{' || c == '[') 
        //         stack.push(c);
        //     else if (c == ')' || c == '}' || c == ']') {
        //         if (stack.isEmpty()) {
        //             System.out.println("Unbalanced parentheses");
        //             break;
        //         }
        //         stack.pop();
        //     }
        // }
        // if (!stack.isEmpty()) {
        //     System.out.println("Unbalanced parentheses");
        // }
        // else {
        //     System.out.println("Balanced parentheses");
        // }

        // // 3. Set: A Set is a collection that does not allow duplicate elements. It is implemented by the HashSet class, which uses a hash table to store the elements. A Set does not maintain any order of the elements, and it does not allow null values.
        // Set<Integer> set = new HashSet<Integer>();
        // set.add(2);
        // set.add(1);
        // set.add(2);
        // set.add(3);
        // System.out.println("Set: " + set);

        // // 3.1 TreeSet: A TreeSet is a collection that does not allow duplicate elements and maintains the elements in sorted order. It is implemented by the TreeSet class, which uses a red-black tree to store the elements. A TreeSet does not allow null values.
        // Set<Integer> treeSet = new TreeSet<Integer>();
        // treeSet.add(3);
        // treeSet.add(1);
        // treeSet.add(2);
        // treeSet.add(2);
        // System.out.println("TreeSet: " + treeSet);

        // // 4. Queue: A Queue is a collection that follows the First-In-First-Out (FIFO) principle. It is implemented by the LinkedList class, which can be used as a queue. A Queue does not allow null values.
        // Collection queue = new LinkedList<>();
        // queue.add("First");
        // queue.add("Second");
        // queue.add("Third");
        // System.out.println("Queue: " + queue);

        // // 5. Map: A Map is a collection that stores key-value pairs. It is implemented by the HashMap class, which uses a hash table to store the elements. A Map does not allow duplicate keys, but it allows duplicate values.

        // Map<Character, Integer> map = new HashMap<>(); // HashTable can also be used
        // System.out.println("Enter a string: ");
        // Scanner scanner = new Scanner(System.in);
        // String input = scanner.nextLine();
        // scanner.close();
        // for (char c : input.toCharArray()) {
        //     map.put(c, 0); // map['a'] = 0, ... map['z'] = 0
        // }

        // for (char c : input.toCharArray()) {
        //     map.put(c, map.get(c) + 1); // map[s[i]]++ 
        // }

        // System.out.println("Character Frequency: " + map);
        // for (Map.Entry<Character, Integer> entry : map.entrySet()) {
        //     System.out.println(entry.getKey() + ": " + entry.getValue());
        // }
        // System.out.println("Keys: " + map.keySet()); // returns a Set view of the keys contained in this map. The set is backed by the map, so changes to the map are reflected in the set, and vice-versa. If the map is modified while an iteration over the set is in progress (except through the iterator's own remove operation), the results of the iteration are undefined. The set supports element removal, which removes the corresponding mapping from the map, via the Iterator.remove(), Set.remove(), removeAll(), retainAll(), and clear() operations. It does not support the add or addAll operations.
        // System.out.println("Values: " + map.values()); // returns a Collection view of the values contained in this map. The collection is backed by the map, so changes to the map are reflected in the collection, and vice-versa. If the map is modified while an iteration over the collection is in progress (except through the iterator's own remove operation), the results of the iteration are undefined. The collection supports element removal, which removes the corresponding mapping from the map, via the Iterator.remove(), Collection.remove(), removeAll(), retainAll(), and clear() operations. It does not support the add or addAll operations.

        /// B. Collections class in Java
        // The Collections class provides static methods for working with collections, such as sorting and searching.

        // // 1. Sorting a List using Collections.sort() by values in ascending order
        // List<Integer> list = new ArrayList<>();
        // list.add(3);
        // list.add(1);
        // list.add(2);
        // System.out.println("List before sorting: " + list);
        // Collections.sort(list); // This will sort the list in ascending order
        // System.out.println("List after sorting: " + list);
        // Collections.reverse(list); // This will reverse the order of the elements in the list
        // System.out.println("List after reversing: " + list);

        // // 2. Sorting a List by last digit in descending order using Collections.sort() with a custom comparator
        // List<Integer> list1 = new ArrayList<>();
        // list1.add(33);
        // list1.add(15);
        // list1.add(22);
        // System.out.println("List before sorting: " + list1);

        // Comparator<Integer> lastDigitDescendingComparator = new Comparator<Integer>() {
        //     @Override
        //     public int compare(Integer a, Integer b) {
        //         int lastDigitA = a % 10;
        //         int lastDigitB = b % 10;

        //         if(lastDigitA>lastDigitB) return -1; // If last digit of a is greater than last digit of b, a should come before b
        //         else
        //             return 1; // If last digit of a is less than last digit of b, a should come after b
                
        //         // return Integer.compare(lastDigitB, lastDigitA); // or directly compare function of Integer class can be used to compare the last digits in descending order, which will return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
        //     }
        // };

        // Collections.sort(list1, lastDigitDescendingComparator); // This will sort the list based on the last digit in descending order
        // System.out.println("List after sorting by last digit in descending order: " + list1);

        // // 3. Sorting a List of strings by their lengths in ascending order using Collections.sort() with a custom comparator
        // List<String> list2 = new ArrayList<String>();
        // list2.add("apple");
        // list2.add("banana");
        // list2.add("kiwi");
        // System.out.println("List before sorting: " + list2);

        // Comparator<String> lenComparator = new Comparator<String>() {
        //     @Override
        //     public int compare(String a, String b) {
        //         if(a.length() > b.length())
        //             return 1;
        //         else
        //             return -1;
        //     }
        // };

        // Collections.sort(list2, lenComparator);
        // System.out.println("List after sorting by length: " + list2);

        // 4. Sorting a list of Ojbects based on a specific property using Collections.sort() with a custom comparator by implementing the Comparable interface in the Person class and using the compareTo method to compare the ages of the Person objects. Alternatively, we can also create a custom comparator using the Comparator interface to sort the list of Person objects based on their ages in ascending order.
        List<Person> people = new ArrayList<Person>();
        people.add(new Person("Jitu", 28));
        people.add(new Person("Ayrin", 26));
        people.add(new Person("Tony", 22));
        people.add(new Person("Joya", 26));

        System.out.println("People before sorting: ");
        for (Person person : people) {
            System.out.println(person.getName() + ": " + person.getAge());
        }
        
        System.out.println("People after sorting by age in ascending order: ");

        // Comparator to sort the list of Person objects based on their ages in ascending order
        Comparator<Person> comparatorSortByAge =  new Comparator<Person>() {
            public int compare(Person a, Person b) {
                if (a.getAge() > b.getAge())
                    return 1;
                else
                    return -1;
            }
        };

        // Comparator to sort the list of Person objects based on their ages in ascending order using lambda expression
        Comparator<Person> comparatorSortByAge1 = (a,b) -> a.getAge() > b.getAge() ? 1 : -1;

        // Directly use the comparator defined in the Person class
        // Collections.sort(people, Person.comparatorSortByAge());

        // Or Use the comparator defined in the main method
        Collections.sort(people, comparatorSortByAge);
        // Or Use the comparator defined in the main method using lambda expression
        // Collections.sort(people, comparatorSortByAge1);
        // Or by directly by the comparable interface implemented in the Person class
        // Collections.sort(people); // This will sort the list of Person objects based on their ages

        for (Person person : people) {
            System.out.println(person.getName() + ": " + person.getAge());
        }
    }
}
