## Spring REST API Using Spring Boot
### Components of Spring REST API
1. **Controller**: The controller is responsible for handling incoming HTTP requests and returning appropriate responses. It defines the endpoints of the REST API and maps them to specific methods that perform the desired actions. In Spring Boot, controllers are typically annotated with `@RestController` and use `@RequestMapping` or other HTTP method annotations (e.g., `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`) to define the routes.
2. **Service**: The service layer contains the business logic of the application. It processes the data received from the controller, interacts with the repository layer, and performs any necessary computations or transformations. The service layer is typically annotated with `@Service` and is responsible for coordinating the flow of data between the controller and the repository.
3. **Repository**: The repository layer is responsible for interacting with the database. It provides methods for performing CRUD operations on the underlying data model. In Spring Boot, repositories are typically interfaces that extend `JpaRepository` or `CrudRepository`, and they are annotated with `@Repository`. The repository layer abstracts the data access logic, allowing the service layer to focus on business logic without worrying about the underlying database implementation.

### How Spring Framework knows for which Request we have to go to which Controller
Spring Framework/MVC basically uses `Front Controller` design pattern. In this pattern, a single controller (the DispatcherServlet) handles all incoming requests and delegates them to the appropriate controller based on the request URL and HTTP method. The DispatcherServlet is configured in the web.xml file or through Java-based configuration in Spring Boot.

When a request is received, the DispatcherServlet consults the HandlerMapping to determine which controller method should handle the request. The HandlerMapping uses annotations (e.g., `@RequestMapping`, `@GetMapping`, `@PostMapping`) to map specific URLs and HTTP methods to controller methods. Once the appropriate controller method is identified, the DispatcherServlet invokes that method, passing any necessary parameters extracted from the request.

### How this 'simplewebbackend' application works:
- It uses lombok.Data for automatic generation of getters, setters, and other utility methods
- It provides a simple REST API with endpoints for managing products(CRUD operations)
    
#### Later we will add database to this project when learning Spring Data JPA(See Spring_Data_JPA Folder)