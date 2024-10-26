# BookVault - Library Management System

BookVault is a Spring Boot-based library management system designed to efficiently manage books, authors, and publishers. It provides CRUD operations for managing library data using REST APIs.

## Features
- Manage Books, Authors, and Publishers.
- REST API for CRUD operations.
- Spring Data JPA for database management.
- Built-in H2 in-memory database for easy setup.


**Technologies Used:**

* **Backend:**
    * Java
    * Spring Boot
    * Spring Data JPA
* **Database:**
    * MySQL - H2 database 
* **Frontend:**
    * Thymeleaf - the project currently uses basic HTML and could benefit from a templating engine
* **Build Tool:**
    * Maven

## Getting Started

### Prerequisites
- **Java JDK 17** or higher
- **Maven 3.x**

### Installation Steps
1. Clone the repository:
    ```bash
    git clone https://github.com/gulshan-pandey/BookVault.git
    cd BookVault
    ```

2. Build the project:
    ```bash
    mvn clean install
    ```

3. Run the application:
    ```bash
    mvn spring-boot:run
    ```

### Database Configuration
By default, the project uses an H2 in-memory database. You can access the H2 database console 

## Project Structure

```plaintext
BookVault/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/application/bookvault/
│       │       ├── controllers/        # Houses the Spring MVC controllers
│       │       ├── models/             # Defines the data models (entities)
│       │       ├── repositories/       # Contains Spring Data JPA repositories
│       │       └── services/           # Holds the business logic
│       └── resources/
│           ├── application.properties  # Spring Boot configuration file
│           └── templates/              # (If using a templating engine) Stores the HTML templates
├── pom.xml                              # Maven project file



