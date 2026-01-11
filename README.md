# Employee Management System (Java + JDBC)

This project is a simple employee management system developed in Java,
using JDBC for persistence and PostgreSQL as the database.

Although simple in scope, the project was designed with a strong focus on
**software engineering principles**, clean architecture, and clear separation
of responsibilities.

The main goal of this project is to practice and demonstrate:
- Object-Oriented Programming
- DAO (Data Access Object) pattern
- Separation of concerns
- JDBC database access
- Clean and maintainable architecture
- Clear, readable, and well-documented code

---

## Project Structure

-application -> Application entry point (user interaction and flow control)
-entities -> Domain entities (business model)
-dao -> Data Access Objects (persistence abstraction)
-db -> Database connection provider and exception handling

Each package has a **single, well-defined responsibility**, avoiding
tight coupling and improving maintainability.

---

## Technologies Used

- Java
- JDBC
- PostgreSQL
- Git

---

## Architecture

The application is structured following **classic enterprise design principles**,
with a strong emphasis on clarity, maintainability, and future extensibility.

### DAO Pattern

The **DAO (Data Access Object) pattern** is used to completely isolate
database access logic from the application layer.

- The `Program` class depends **only on DAO interfaces**
- JDBC-specific code is encapsulated inside DAO implementations
- SQL statements are isolated from business logic

This approach allows the persistence mechanism to be replaced (e.g., JPA,
Hibernate, or another database) with minimal impact on the rest of the system.

---

###  Connection Management Strategy

Each DAO method obtains its own database connection through a centralized
utility class (`DB`).

- A **new connection is created per operation**
- Connections are properly closed using **try-with-resources**
- There is no shared or static connection, avoiding side effects and
  resource lifecycle issues

This strategy prioritizes **correctness, safety, and clarity**, while
keeping the code aligned with real-world JDBC best practices.

---

### Clear Responsibility Boundaries

- `entities` contain **only domain data and behavior**
- `dao` focuses exclusively on persistence concerns
- `db` centralizes low-level infrastructure details
- `application` coordinates the program flow without knowing
  implementation details of the persistence layer

Each class and method is intentionally small, readable, and focused.

---

### Code Quality and Documentation

- All core classes are documented using **Javadoc**
- Method names and variables favor **readability over brevity**
- Custom unchecked exceptions (`DbException`) are used to avoid
  leaking low-level SQL concerns into higher layers
- Resource management is explicit and consistent

---

## How to Run

1. Configure the database connection in `db/DB.java`
2. Create the database and the `employee` table in PostgreSQL.
3. Run the `Program` class

---

## Future Improvements

- Introduce Dependency Injection
- Add unit tests with mock DAOs
- Introduce a connection pool (`DataSource`)
- Migrate to JPA / Hibernate
- Create a REST API layer

---

## Author

Micael Cruz Batista Martins
















