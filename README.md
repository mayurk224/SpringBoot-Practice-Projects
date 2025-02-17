# Spring Boot Practice Repository

## Overview
This repository contains multiple Spring Boot projects that cover various concepts of backend development, including CRUD operations, authentication, security, and database interactions. Each project is designed to help understand and implement different aspects of Spring Boot development.

## Projects Included

### 1. Employee Management System
- **Description:** A full-stack web application with a Spring Boot backend and Vite React.js frontend.
- **Database:** MySQL
- **Features:**
  - Basic CRUD operations for employee records
  - Frontend UI with React.js

### 2. Banking Application (Backend Only)
- **Description:** A backend project for a banking system.
- **Database:** MySQL
- **Features:**
  - Add and close accounts
  - Deposit, withdraw, and transfer funds
  - Transaction history tracking
  - Exception handling (e.g., preventing zero balance transfers)

### 3. Personal Expense Tracker (Backend Only)
- **Description:** A backend project for tracking personal expenses.
- **Database:** MySQL
- **Features:**
  - CRUD operations for expense tracking
  - User authentication and authorization
  - Category-wise expense management

### 4. Lombok Plugin Tutorial
- **Description:** A simple repository to demonstrate the usage of Lombok in Spring Boot projects.
- **Features:**
  - Code simplification using Lombok annotations
  - Examples for @Getter, @Setter, @AllArgsConstructor, @NoArgsConstructor, etc.

### 5. Student Management System
- **Description:** A backend project with Thymeleaf for UI rendering.
- **Database:** MySQL
- **Features:**
  - Basic CRUD operations for student records
  - Thymeleaf-based frontend for displaying student data

### 6. To-Do App (Backend Only)
- **Description:** A backend project with role-based authentication and JWT security.
- **Database:** MySQL
- **Features:**
  - CRUD operations for managing tasks
  - User authentication (Login & Register)
  - Role-based access control (Admin/User)
  - Secure API with JWT authentication

## Installation and Setup
### Prerequisites
- **Java 17+**
- **MySQL Server**
- **Maven**

### Steps to Run a Project
1. Clone the repository:
   ```sh
   git clone https://github.com/mayurk224/SpringBoot-Practice-Projects
   cd spring-boot-practice
   ```
2. Navigate to the desired project folder:
   ```sh
   cd project-folder-name
   ```
3. Configure MySQL in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/db_name
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   ```
4. Build and run the application:
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```

## Future Enhancements
- Add more advanced Spring Boot projects (e.g., Microservices, Kafka, WebSockets)
- Implement frontend for backend-only projects
- Deploy projects to cloud platforms

## License
This repository is licensed under the MIT License.

## Author
**Mayur Dilip Kamble**

