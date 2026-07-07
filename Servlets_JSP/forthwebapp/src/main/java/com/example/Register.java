/*
                      MVC Architecture

                   +------------------------+
                   |         MODEL          |
                   |         (JDBC)         |
                   +------------------------+
                      ^                  |
                      |                  |
                      |                  v
+---------+     +------------------------+     +------------------------+
| CLIENT  | --> |      CONTROLLER        | --> |         VIEW           |
+---------+     |       (Servlet)        | <-- |      JSP / HTML        |
      ^         +------------------------+     +------------------------+
      |                   |    ^
      |                   |    |
      +-------------------+----+
                          |
                          v
                   +------------------------+
                   |         MODEL          |
                   |         (JDBC)         |
                   +------------------------+

Flow:
------
1. Client  ------> Controller
2. Controller --> Model
3. Model -------> Controller
4. Controller --> View
5. View --------> Client
*/
package com.example;

public class Register {
}
