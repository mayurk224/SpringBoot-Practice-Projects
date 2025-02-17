# To-Do App (Backend)

## Overview

The **To-Do App Backend** is a RESTful API built using **Spring Boot** that provides basic CRUD operations for managing tasks. It includes **role-based authentication**, **JWT-based security**, and **user authentication (login & register)**.

## Tech Stack

- **Spring Boot** - Backend framework
- **Spring Security** - For securing REST APIs
- **JWT (JSON Web Token)** - Authentication & Authorization
- **Spring Data JPA** - Database interaction
- **MySQL** - Relational database
- **Lombok** - To reduce boilerplate code

## Features

- **User Authentication:**
  - Register new users
  - Login with credentials
  - Generate JWT tokens
- **Role-Based Access Control (RBAC):**
  - Assign roles (USER, ADMIN)
  - Restrict access to specific endpoints based on roles
- **Task Management:**
  - Create, Read, Update, and Delete tasks
  - Assign tasks to users
  - Mark tasks as complete or incomplete
- **Security:**
  - Secure API endpoints with JWT tokens
  - Password hashing with BCrypt

## API Endpoints

### Authentication

- **User Registration**
  ```http
  POST /api/auth/register
  ```
- **User Login**
  ```http
  POST /api/auth/login
  ```

### Task Management

- **Create a Task (Admin only)**
  ```http
  POST /api/todos
  ```
- **Get Task by ID (Admin, User)**
  ```http
  GET /api/todos/{todoId}
  ```
- **Get All Tasks (Admin, User)**
  ```http
  GET /api/todos
  ```
- **Update Task (Admin only)**
  ```http
  PUT /api/todos/{todoId}
  ```
- **Delete Task (Admin only)**
  ```http
  DELETE /api/todos/{todoId}
  ```
- **Mark Task as Complete (Admin, User)**
  ```http
  PATCH /api/todos/{todoId}/complete
  ```
- **Mark Task as Incomplete (Admin, User)**
  ```http
  PATCH /api/todos/{todoId}/in-complete
  ```

## Installation and Setup

### Prerequisites

- **Java 17+**
- **MySQL Server**
- **Maven**

### Backend Setup

1. Clone the repository:
   ```sh
   git clone https://github.com/mayurk224/SpringBoot-Practice-Projects
   cd todo-app-backend
   ```
2. Configure MySQL in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/todo_db
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   ```
3. Build and run the application:
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```
   The application will be accessible at `http://localhost:8080`.

## Future Enhancements

- Implement email verification during registration.
- Add task priority and due date.
- Deploy the application to cloud services.

## License

This project is licensed under the MIT License.

## Author

**Mayur Dilip Kamble**

