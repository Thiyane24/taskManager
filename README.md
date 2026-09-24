# Mini-Jira: Enterprise-Style Task Manager

A command-line task management application built in Java. This project simulates the **Model-Controller-Service-Repository** layered architecture used in modern backend frameworks like Spring Boot. It serves as a practical demonstration of Dependency Injection, Interface-driven design, and robust exception handling.

## Core Concepts Demonstrated

* **Layered Architecture:** Code is strictly separated by responsibility, preventing the "spaghetti code" common in beginner projects. The UI doesn't talk to the database; it talks to the Service.
* **Dependency Injection:** The `Service` class does not create its own database. Instead, the `Repository` interface is injected into the Service's constructor, making the system modular and easy to test.
* **Interface-Driven Design:** The system relies on a `Repository` contract. The underlying storage (`HashMap`) can be swapped out for a real SQL database later without altering a single line of code in the Service layer.
* **Business Logic & Exceptions:** The `Service` layer protects the database by validating user actions (e.g., throwing an `IllegalArgumentException` if a user attempts to update a task ID that does not exist).
* **Interactive CLI:** Uses `Scanner` to simulate web API calls (POST/GET) via a continuous while-loop menu.

## Project Architecture

* **`Task.java` (Model):** The data entity. Represents a single task with an `id`, `title`, and `status` (TODO, IN_PROGRESS, DONE).
* **`Repository.java` (Interface):** Defines the database contract (`save`, `findById`, `findAll`, `deleteById`).
* **`Db.java` (Repository Impl):** The in-memory database acting as a mock SQL database. Utilizes a `HashMap` to store `Task` objects for instant O(1) lookup.
* **`Service.java` (Business Logic):** The brain of the application. Processes creation and update requests, enforces business rules, and safely passes data to the Repository layer.
* **`Main.java` (Controller):** The entry point. Wires the dependencies together, handles user input via the console, and routes requests to the Service layer.

## How to Run

1. Ensure you have the Java Development Kit (JDK) installed.
2. Save all classes into your project directory.
3. Open your terminal or command prompt and navigate to the folder.
4. Compile the application:
```bash
javac Main.java

```


5. Run the application:
```bash
java Main

```



## Example Usage

```text
=== Welcome to Interactive Mini-Jira ===

Menu: [1] Create Task  [2] Update Status  [3] View All  [4] Exit
Choose an option: 1
Enter a new Task ID (e.g., T1): T1
Enter the Task Title: Setup Azure Deployment
Task created successfully: Setup Azure Deployment

Menu: [1] Create Task  [2] Update Status  [3] View All  [4] Exit
Choose an option: 2
Enter the Task ID to update: T1
Enter new Status (TODO, IN_PROGRESS, DONE): IN_PROGRESS
Task T1 updated to: IN_PROGRESS

Menu: [1] Create Task  [2] Update Status  [3] View All  [4] Exit
Choose an option: 2
Enter the Task ID to update: T99
Enter new Status (TODO, IN_PROGRESS, DONE): DONE
Action Aborted: Error: Task with ID T99 does not exist.

Menu: [1] Create Task  [2] Update Status  [3] View All  [4] Exit
Choose an option: 3

--- CURRENT DATABASE STATE ---
ID: T1 | Title: Setup Azure Deployment | Status: IN_PROGRESS

```
