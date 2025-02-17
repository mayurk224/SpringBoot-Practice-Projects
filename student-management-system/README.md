# Student Management System (Backend)

## Overview

The **Student Management System** is a backend project built using **Spring Boot** that provides basic CRUD operations for managing student data. It utilizes **Thymeleaf** to render data on a web page.

## Tech Stack

- **Spring Boot** - Backend framework
- **Spring Data JPA** - Database interaction
- **Thymeleaf** - Server-side templating engine
- **MySQL** - Relational database
- **Lombok** - To reduce boilerplate code

## Features

- **Student Management:**
  - Add a new student
  - Update student details
  - Delete a student
  - View all students
- **Web Interface:**
  - Render student data using Thymeleaf
- **Exception Handling:**
  - Prevent invalid operations and handle errors

## API Endpoints

### Student Management

- **Get All Students**
  ```http
  GET /students
  ```
- **Get Student by ID**
  ```http
  GET /students/{studentId}
  ```
- **Add a New Student**
  ```http
  POST /students/new
  ```
  **Request Body:**
  ```json
  {
    "name": "John Doe",
    "email": "johndoe@example.com",
    "course": "Computer Science"
  }
  ```
- **Update Student Details**
  ```http
  PUT /students/{studentId}/edit
  ```
  **Request Body:**
  ```json
  {
    "name": "John Doe",
    "email": "john.doe@example.com",
    "course": "Information Technology"
  }
  ```
- **Delete a Student**
  ```http
  DELETE /students/{studentId}/delete
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
   cd student-management-system
   ```
2. Configure MySQL in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/student_db
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

- Implement student search functionality.
- Add user authentication and authorization.
- Deploy the application to cloud services.

## License

This project is licensed under the MIT License.

## Author

**Mayur Dilip Kamble**

