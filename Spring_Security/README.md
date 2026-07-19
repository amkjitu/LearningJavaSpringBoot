## Spring Security
Spring Security is a powerful and highly customizable authentication and access-control framework for Java applications. It is the de-facto standard for securing Spring-based applications. Spring Security provides comprehensive security services for Java EE-based enterprise software applications.

Spring Security Provides features such as authentication, authorization, and protection against common security vulnerabilities. It integrates seamlessly with Spring applications and can be easily configured to meet specific security requirements. See QWASP (https://owasp.org/) for more information about security vulnerabilities and best practices.

We already know that Spring Web comes into two parts:
1. Servlet-based web applications (Spring MVC)
2. Reactive web applications (Spring WebFlux)

We are focusing on Servlet-based web applications (Spring MVC) in this project. Spring Security can be used to secure both types of applications, but the configuration and implementation may differ slightly between the two. Below is a high-level overview of how Spring Security works in a Servlet-based web application (Spring MVC):

╔═════════════════════════════════════════════════════════════════════════════════════════
║                    [Browser / Client HTTP Request]
║                                   │
║                                   ▼
║     ╔═══════════════════════════════════════════════════════════════════════════════╗
║     ║ 1. SERVLET CONTAINER (e.g., Tomcat)                                           ║
║     ║                                                                               ║
║     ║  ┌────────────────────────────────────────────────────────────────────────┐   ║
║     ║  │ STANDARD SPRING WEB FILTERS (1–5)                                      │   ║
║     ║  │  [1] DisableEncodeUrlFilter                                            │   ║
║     ║  │  [2] WebAsyncManagerIntegrationFilter                                  │   ║
║     ║  │  [3] CharacterEncodingFilter                                           │   ║
║     ║  │  [4] FormContentFilter                                                 │   ║
║     ║  │  [5] RequestContextFilter                                              │   ║
║     ║  └──────────────────────────────┬─────────────────────────────────────────┘   ║
║     ║                                 │                                             ║
║     ║                                 ▼                                             ║
║     ║  ┌────────────────────────────────────────────────────────────────────────┐   ║
║     ║  │ SPRING SECURITY FILTER CHAIN (6–16)                                    │   ║
║     ║  │  [6]  ChannelProcessingFilter                                          │   ║
║     ║  │  [7]  CorsFilter                                                       │   ║
║     ║  │  [8]  CsrfFilter                                                       │   ║
║     ║  │  [9]  LogoutFilter                                                     │   ║
║     ║  │  [10] UsernamePasswordAuthenticationFilter / BearerTokenAuthFilter     │   ║
║     ║  │  [11] DefaultLoginPageGeneratingFilter                                 │   ║
║     ║  │  [12] BasicAuthenticationFilter                                        │   ║
║     ║  │  [13] SecurityContextHolderFilter                                      │   ║
║     ║  │  [14] AnonymousAuthenticationFilter                                    │   ║
║     ║  │  [15] ExceptionTranslationFilter                                       │   ║
║     ║  │  [16] AuthorizationFilter  ◄── FINAL GATEKEEPER                        │   ║
║     ║  └──────────────────────────────┬─────────────────────────────────────────┘   ║
║     ║                                 │                                             ║
║     ║                                 ▼                                             ║
║     ║  ┌────────────────────────────────────────────────────────────────────────┐   ║
║     ║  │ 2. FRONT CONTROLLER (DispatcherServlet) – The Central Orchestrator     │   ║
║     ║  │                                                                        │   ║
║     ║  │       ┌──────────────┐     ┌───────────────┐     ┌───────────────┐     │   ║
║     ║  │       │HandlerMapping│ ──► │HandlerAdapter │ ──► │ ViewResolver  │     │   ║
║     ║  │       │(finds route) │     │(executes ctrl)│     │(resolves view)│     │   ║
║     ║  │       └──────────────┘     └───────────────┘     └───────────────┘     │   ║
║     ║  └───────────────────────────────┬────────────────────────────────────────┘   ║
║     ╚══════════════════════════════════╪════════════════════════════════════════════╝
║                                        │
║                                        ▼
║     ╔═══════════════════════════════════════════════════════════════════════════════╗
║     ║ 3. SPRING APPLICATION CONTEXT (IoC Container)                                 ║
║     ║                                                                               ║
║     ║     ┌─────────────────────────────────────────────┐                           ║
║     ║     │ CONTROLLER LAYER (@RestController)          │                           ║
║     ║     │  - Handles mapped endpoints                 │                           ║
║     ║     └──────────────────┬──────────────────────────┘                           ║
║     ║                        │ (Business Call)                                      ║
║     ║                        ▼                                                      ║
║     ║     ┌─────────────────────────────────────────────┐                           ║
║     ║     │ SERVICE LAYER (@Service)                    │                           ║
║     ║     │  - Implements business logic                │                           ║
║     ║     │  - Manages @Transactional boundaries        │                           ║
║     ║     └──────────────────┬──────────────────────────┘                           ║
║     ║                        │ (Data Access)                                        ║
║     ║                        ▼                                                      ║
║     ║     ┌─────────────────────────────────────────────┐                           ║
║     ║     │ REPOSITORY LAYER (@Repository)              │                           ║
║     ║     │  - JPA / JDBC / CRUD operations             │                           ║
║     ║     └────────────────────────┬────────────────────┘                           ║
║     ╚══════════════════════════════╪════════════════════════════════════════════════╝
║                                    │
║                                    ▼
║                            ┌───────────────┐
║                            │   DATABASE    │
║                            │ (SQL / NoSQL) │
║                            └───────┬───────┘
║                                    │ (Return Data)
║                                    ▼
║                      ┌─────────────────────────┐
║                      │  HTTP RESPONSE          │
║                      │ (HTML / JSON / XML)     │
║                      └─────────────────────────┘
╚═══════════════════════════════════════════════════════════════════════════════════════════════

Summary of Spring Security works in a Servlet-based web application (Spring MVC): 
1. Request In → passes through Standard Filters → then through the Security Filter Chain.
2. DispatcherServlet receives the secured request, finds the correct Controller via HandlerMapping, and invokes it via HandlerAdapter.
3. The Controller calls the Service (business logic), which calls the Repository.
4. Repository fetches/stores data from the Database.
5. Data is passed back up: Repository → Service → Controller.
6. The Controller returns a ModelAndView (or a JSON object) to the DispatcherServlet.
7. DispatcherServlet uses ViewResolver to render the view (or directly writes JSON to the response body).
8. HTTP Response is sent back to the client.
